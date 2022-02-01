package com.tencent.mm.plugin.emojicapture.ui;

import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.plugin.emojicapture.ui.b.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureRenderSurface;", "Landroid/view/TextureView$SurfaceTextureListener;", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;", "(Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRender;)V", "TAG", "", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "onDrawCallback", "Lkotlin/Function0;", "", "getOnDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "getPreviewCallback", "()Lkotlin/jvm/functions/Function1;", "setPreviewCallback", "(Lkotlin/jvm/functions/Function1;)V", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceWidth", "texture", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queueEvent", "r", "quitHandlerThread", "requestRender", "pts", "", "updateTextureSize", "plugin-emojicapture_release"})
public final class a
  implements TextureView.SurfaceTextureListener
{
  private final String TAG;
  private HandlerThread gSR;
  private ao gSS;
  d.g.a.b<? super SurfaceTexture, y> hbY;
  private SurfaceTexture hbv;
  private boolean hca;
  private c.b hcg;
  private ArrayList<d.g.a.a<y>> hch;
  d.g.a.a<y> pqG;
  final h pqH;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public a(h paramh)
  {
    AppMethodBeat.i(447);
    this.pqH = paramh;
    this.TAG = "MicroMsg.EmojiCaptureRenderSurface";
    this.hch = new ArrayList();
    auT();
    this.pqH.gVj = ((d.g.a.b)new a.1(this));
    AppMethodBeat.o(447);
  }
  
  private final void auT()
  {
    AppMethodBeat.i(446);
    HandlerThread localHandlerThread = d.gy("EmojiCaptureRenderSurface_renderThread", -2);
    localHandlerThread.start();
    this.gSS = new ao(localHandlerThread.getLooper());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.hch);
    this.hch.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      h((d.g.a.a)((Iterator)localObject).next());
    }
    this.gSR = localHandlerThread;
    AppMethodBeat.o(446);
  }
  
  public final void h(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(445);
    k.h(parama, "r");
    if (this.gSS != null)
    {
      ao localao = this.gSS;
      if (localao != null)
      {
        localao.post((Runnable)new b(parama));
        AppMethodBeat.o(445);
        return;
      }
      AppMethodBeat.o(445);
      return;
    }
    this.hch.add(parama);
    AppMethodBeat.o(445);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(444);
    ac.i(this.TAG, "onSurfaceTextureAvailable: ");
    if (this.gSS == null) {
      auT();
    }
    if (paramSurfaceTexture != null)
    {
      h((d.g.a.a)new a(paramSurfaceTexture, this, paramInt1, paramInt2));
      AppMethodBeat.o(444);
      return;
    }
    AppMethodBeat.o(444);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(443);
    ac.i(this.TAG, "onSurfaceTextureDestroyed: ");
    h((d.g.a.a)new b(this));
    AppMethodBeat.o(443);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(442);
    ac.i(this.TAG, "onSurfaceTextureSizeChanged: ");
    h((d.g.a.a)new c(this, paramInt1, paramInt2));
    AppMethodBeat.o(442);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureRenderSurface$onSurfaceTextureAvailable$1$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(SurfaceTexture paramSurfaceTexture, a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(a parama, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a
 * JD-Core Version:    0.7.0.1
 */