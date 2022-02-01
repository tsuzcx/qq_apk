package com.tencent.mm.plugin.flutter.voip.manager;

import android.graphics.SurfaceTexture;
import android.util.Size;
import androidx.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterTextureMgr;", "", "registry", "Lio/flutter/view/TextureRegistry;", "(Lio/flutter/view/TextureRegistry;)V", "TAG", "", "texturePool", "Landroidx/collection/LongSparseArray;", "Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterTextureMgr$SurfaceHolder;", "textureTrash", "", "clearTextureTrash", "", "create", "get", "renderType", "", "id", "", "(Ljava/lang/Long;)Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterTextureMgr$SurfaceHolder;", "release", "(Ljava/lang/Long;)V", "releaseAll", "warmUp", "flutterVoipMgr", "Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterVoipMgr;", "SurfaceHolder", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final TextureRegistry Hnm;
  public final d<a> Hnn;
  public final List<a> Hno;
  public final String TAG;
  
  public a(TextureRegistry paramTextureRegistry)
  {
    AppMethodBeat.i(263482);
    this.Hnm = paramTextureRegistry;
    this.TAG = "MicroMsg.FlutterTextureMgr";
    this.Hnn = new d();
    this.Hno = ((List)new ArrayList());
    AppMethodBeat.o(263482);
  }
  
  private final a fvT()
  {
    AppMethodBeat.i(263493);
    Object localObject1 = this.Hnm.createSurfaceTexture();
    Object localObject2 = ((TextureRegistry.SurfaceTextureEntry)localObject1).surfaceTexture();
    s.s(localObject2, "flutterTexture.surfaceTexture()");
    localObject2 = new com.tencent.mm.plugin.flutter.voip.d.a((SurfaceTexture)localObject2);
    long l = ((TextureRegistry.SurfaceTextureEntry)localObject1).id();
    s.s(localObject1, "flutterTexture");
    localObject1 = new a(l, (TextureRegistry.SurfaceTextureEntry)localObject1, (com.tencent.mm.plugin.flutter.voip.d.a)localObject2, (byte)0);
    this.Hnn.a(((a)localObject1).id, localObject1);
    Log.i(this.TAG, "create flutter texture: " + ((a)localObject1).id + ", surfaceTexture:" + ((a)localObject1).Hnq.HnK);
    AppMethodBeat.o(263493);
    return localObject1;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(263502);
    s.u(paramb, "flutterVoipMgr");
    Log.i(this.TAG, "warm up");
    if (this.Hnm == null)
    {
      Log.w(this.TAG, "registry is null!");
      AppMethodBeat.o(263502);
      return;
    }
    if (this.Hnn.size() >= 2)
    {
      Log.i(this.TAG, "texturePool size >= 2, skip warm up");
      AppMethodBeat.o(263502);
      return;
    }
    a locala = fvT();
    paramb.a(locala.Hnq);
    locala.Hnq.HnM = ((kotlin.g.a.b)new b(this));
    Log.i(this.TAG, "warm up local camera texture");
    locala = fvT();
    paramb.b(locala.Hnq);
    locala.Hnq.HnM = ((kotlin.g.a.b)new c(this));
    Log.i(this.TAG, "warm up remote camera texture");
    AppMethodBeat.o(263502);
  }
  
  public final void releaseAll()
  {
    AppMethodBeat.i(263511);
    Log.i(this.TAG, "release all textures");
    int i = 0;
    int k = this.Hnn.size();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      a locala = (a)this.Hnn.bl(i);
      locala.Hnq.HnM = null;
      locala.Hnq.fwh();
      List localList = this.Hno;
      s.s(locala, "surfaceHolder");
      localList.add(locala);
      if (j >= k)
      {
        this.Hnn.clear();
        AppMethodBeat.o(263511);
        return;
      }
      i = j;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterTextureMgr$SurfaceHolder;", "", "id", "", "flutterTexture", "Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;", "voipSurfaceTexture", "Lcom/tencent/mm/plugin/flutter/voip/ui/FlutterVoipSurfaceTexture;", "width", "", "height", "(JLio/flutter/view/TextureRegistry$SurfaceTextureEntry;Lcom/tencent/mm/plugin/flutter/voip/ui/FlutterVoipSurfaceTexture;II)V", "getFlutterTexture", "()Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;", "getHeight", "()I", "setHeight", "(I)V", "getId", "()J", "getVoipSurfaceTexture", "()Lcom/tencent/mm/plugin/flutter/voip/ui/FlutterVoipSurfaceTexture;", "getWidth", "setWidth", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public final TextureRegistry.SurfaceTextureEntry Hnp;
    public final com.tencent.mm.plugin.flutter.voip.d.a Hnq;
    public int height;
    public final long id;
    public int width;
    
    private a(long paramLong, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, com.tencent.mm.plugin.flutter.voip.d.a parama)
    {
      AppMethodBeat.i(263498);
      this.id = paramLong;
      this.Hnp = paramSurfaceTextureEntry;
      this.Hnq = parama;
      this.width = 0;
      this.height = 0;
      AppMethodBeat.o(263498);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "size", "Landroid/util/Size;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Size, ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "size", "Landroid/util/Size;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Size, ah>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.manager.a
 * JD-Core Version:    0.7.0.1
 */