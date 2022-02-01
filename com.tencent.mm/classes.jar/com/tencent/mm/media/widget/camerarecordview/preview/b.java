package com.tencent.mm.media.widget.camerarecordview.preview;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "()V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public final class b
  implements TextureView.SurfaceTextureListener, e
{
  public static final b.a hci;
  private HandlerThread gSR;
  private ao gSS;
  com.tencent.mm.media.i.a gTi;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a grf;
  private d.g.a.b<? super SurfaceTexture, y> hbY;
  private SurfaceTexture hbv;
  private boolean hca;
  private c.b hcg;
  private ArrayList<d.g.a.a<y>> hch;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(94332);
    hci = new b.a((byte)0);
    AppMethodBeat.o(94332);
  }
  
  public b()
  {
    AppMethodBeat.i(94331);
    this.hch = new ArrayList();
    auT();
    AppMethodBeat.o(94331);
  }
  
  private final void auT()
  {
    AppMethodBeat.i(94330);
    HandlerThread localHandlerThread = com.tencent.e.c.d.gB("CameraPreviewTextureView_renderThread", -2);
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
    AppMethodBeat.o(94330);
  }
  
  public final void a(com.tencent.mm.media.i.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94325);
    k.h(parama, "renderer");
    ac.i("MicroMsg.CameraPreviewGLTextureRender", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.grf;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((f)this))
    {
      this.grf = locala;
      locala = this.grf;
      if (locala != null) {
        locala.b(parama);
      }
      this.gTi = parama;
      AppMethodBeat.o(94325);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94317);
    k.h(paramb, "cameraConfig");
    ac.i("MicroMsg.CameraPreviewGLTextureRender", "updateCameraConfig: ".concat(String.valueOf(paramb)));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.grf;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94317);
      return;
    }
    AppMethodBeat.o(94317);
  }
  
  public final void ajA()
  {
    AppMethodBeat.i(94323);
    ac.m("MicroMsg.CameraPreviewGLTextureRender", "tryStopCameraPreview", new Object[0]);
    this.hbY = null;
    AppMethodBeat.o(94323);
  }
  
  public final void ajB()
  {
    AppMethodBeat.i(94329);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.grf;
    if (locala != null)
    {
      locala.ajB();
      AppMethodBeat.o(94329);
      return;
    }
    AppMethodBeat.o(94329);
  }
  
  public final void c(d.g.a.b<? super SurfaceTexture, y> paramb)
  {
    AppMethodBeat.i(94322);
    ac.m("MicroMsg.CameraPreviewGLTextureRender", "tryCameraPreview canPreview:" + this.hca, new Object[0]);
    if (this.hca)
    {
      if (paramb != null)
      {
        Object localObject = this.grf;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getSurfaceTexture();; localObject = null)
        {
          paramb.ay(localObject);
          AppMethodBeat.o(94322);
          return;
        }
      }
      AppMethodBeat.o(94322);
      return;
    }
    this.hbY = paramb;
    AppMethodBeat.o(94322);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.hcg;
    if (localb != null) {
      return localb.gWL;
    }
    return null;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(94328);
    Object localObject = this.grf;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(94328);
      return localObject;
    }
    AppMethodBeat.o(94328);
    return null;
  }
  
  public final com.tencent.mm.media.f.d getPreviewTexture()
  {
    com.tencent.mm.media.i.a locala = this.gTi;
    if (locala != null) {
      return locala.gVe;
    }
    return null;
  }
  
  public final void h(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(94327);
    k.h(parama, "r");
    if (this.gSS != null)
    {
      ao localao = this.gSS;
      if (localao != null)
      {
        localao.post((Runnable)new c(parama));
        AppMethodBeat.o(94327);
        return;
      }
      AppMethodBeat.o(94327);
      return;
    }
    this.hch.add(parama);
    AppMethodBeat.o(94327);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94321);
    ac.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.gSS);
    if (this.gSS == null) {
      auT();
    }
    if (paramSurfaceTexture != null)
    {
      h((d.g.a.a)new b(paramSurfaceTexture, this, paramInt1, paramInt2));
      AppMethodBeat.o(94321);
      return;
    }
    AppMethodBeat.o(94321);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(94319);
    ac.m("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureDestroyed", new Object[0]);
    this.hca = false;
    h((d.g.a.a)new c(this));
    AppMethodBeat.o(94319);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94318);
    ac.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    h((d.g.a.a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(94318);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void release()
  {
    AppMethodBeat.i(94320);
    h((d.g.a.a)new e(this));
    AppMethodBeat.o(94320);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(94326);
    h((d.g.a.a)new f(this));
    AppMethodBeat.o(94326);
  }
  
  public final void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.f.d, y> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.grf;
    if (locala != null) {
      locala.hco = paramb;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender$onSurfaceTextureAvailable$1$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(SurfaceTexture paramSurfaceTexture, b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.b
 * JD-Core Version:    0.7.0.1
 */