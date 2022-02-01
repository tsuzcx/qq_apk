package com.tencent.mm.plugin.finder.video.thumb;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.plugin.xlabeffect.k.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.xeffect.VLogDirector;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbRenderer;", "", "width", "", "height", "(II)V", "TAG", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eGLHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eGLThread", "Landroid/os/HandlerThread;", "getHeight", "()I", "setHeight", "(I)V", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "outputSizeChanged", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "renderFrameCallback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "", "renderSurface", "Landroid/view/Surface;", "renderSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "renderTexture", "surfaceCallback", "Lkotlin/Function1;", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "waitNextVideoFrameTimeMs", "getWidth", "setWidth", "createEGLEnvironment", "createEGLThread", "createVideoTexture", "initVLogDirector", "queue", "call", "Lkotlin/Function0;", "release", "renderFrame", "timestampNs", "setMediaInfo", "setRenderFrameCallback", "callback", "setup", "afterSurfaceCreated", "updateSize", "waitNextVideoFrame", "timeMs", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a GvS;
  private SurfaceTexture ELg;
  com.tencent.mm.plugin.thumbplayer.a.b GvR;
  HandlerThread GvT;
  MMHandler GvU;
  kotlin.g.a.b<? super Surface, ah> GvV;
  private com.tencent.mm.media.g.d GvW;
  private VLogDirector GvX;
  boolean GvY;
  m<? super Bitmap, ? super Long, ah> GvZ;
  volatile long Gwa;
  final String TAG;
  int height;
  private com.tencent.mm.media.g.d mVc;
  private c.b nFD;
  private Surface renderSurface;
  int width;
  
  static
  {
    AppMethodBeat.i(335903);
    GvS = new a((byte)0);
    k.a locala = k.XKT;
    k.a.tryLoadLibrary();
    AppMethodBeat.o(335903);
  }
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335790);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = s.X("MicroMsg.TPTrackThumbRenderer@", Integer.valueOf(hashCode()));
    this.GvX = new VLogDirector();
    AppMethodBeat.o(335790);
  }
  
  private static final void bw(a parama)
  {
    AppMethodBeat.i(335795);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(335795);
  }
  
  public final void K(a<ah> parama)
  {
    int i = 1;
    AppMethodBeat.i(335929);
    s.u(parama, "call");
    Object localObject = this.GvT;
    if ((localObject != null) && (((HandlerThread)localObject).isAlive() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localObject = this.GvU;
        if (localObject != null) {
          ((MMHandler)localObject).post(new d..ExternalSyntheticLambda0(parama));
        }
      }
      AppMethodBeat.o(335929);
      return;
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbRenderer$Companion;", "", "()V", "FrameTimeErrorThreshold", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(d paramd)
    {
      super();
    }
    
    private static final void b(final d paramd, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(335774);
      s.u(paramd, "this$0");
      Looper localLooper = Looper.myLooper();
      Object localObject = d.c(paramd);
      if (localObject == null) {}
      for (localObject = null; s.p(localLooper, localObject); localObject = ((HandlerThread)localObject).getLooper())
      {
        paramSurfaceTexture.updateTexImage();
        d.a(paramd, paramSurfaceTexture.getTimestamp());
        AppMethodBeat.o(335774);
        return;
      }
      paramd.K((a)new a(paramSurfaceTexture, paramd));
      AppMethodBeat.o(335774);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(SurfaceTexture paramSurfaceTexture, d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<ah>
  {
    f(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.thumb.d
 * JD-Core Version:    0.7.0.1
 */