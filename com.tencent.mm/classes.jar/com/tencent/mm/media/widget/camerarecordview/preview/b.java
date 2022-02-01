package com.tencent.mm.media.widget.camerarecordview.preview;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "()V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public final class b
  implements TextureView.SurfaceTextureListener, e
{
  public static final b.a huq;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gKP;
  private HandlerThread hkS;
  private ap hkT;
  com.tencent.mm.media.j.a hlj;
  private SurfaceTexture htD;
  private d.g.a.b<? super SurfaceTexture, z> hug;
  private boolean hui;
  private c.b huo;
  private ArrayList<d.g.a.a<z>> hup;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(94332);
    huq = new b.a((byte)0);
    AppMethodBeat.o(94332);
  }
  
  public b()
  {
    AppMethodBeat.i(94331);
    this.hup = new ArrayList();
    axG();
    AppMethodBeat.o(94331);
  }
  
  private final void axG()
  {
    AppMethodBeat.i(94330);
    HandlerThread localHandlerThread = com.tencent.e.c.d.gZ("CameraPreviewTextureView_renderThread", -2);
    localHandlerThread.start();
    this.hkT = new ap(localHandlerThread.getLooper());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.hup);
    this.hup.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      h((d.g.a.a)((Iterator)localObject).next());
    }
    this.hkS = localHandlerThread;
    AppMethodBeat.o(94330);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94325);
    p.h(parama, "renderer");
    ad.i("MicroMsg.CameraPreviewGLTextureRender", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((f)this))
    {
      this.gKP = locala;
      locala = this.gKP;
      if (locala != null) {
        locala.b(parama);
      }
      this.hlj = parama;
      AppMethodBeat.o(94325);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94317);
    p.h(paramb, "cameraConfig");
    ad.i("MicroMsg.CameraPreviewGLTextureRender", "updateCameraConfig: ".concat(String.valueOf(paramb)));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94317);
      return;
    }
    AppMethodBeat.o(94317);
  }
  
  public final void amm()
  {
    AppMethodBeat.i(94323);
    ad.m("MicroMsg.CameraPreviewGLTextureRender", "tryStopCameraPreview", new Object[0]);
    this.hug = null;
    AppMethodBeat.o(94323);
  }
  
  public final void amn()
  {
    AppMethodBeat.i(94329);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null)
    {
      locala.amn();
      AppMethodBeat.o(94329);
      return;
    }
    AppMethodBeat.o(94329);
  }
  
  public final void d(d.g.a.b<? super SurfaceTexture, z> paramb)
  {
    AppMethodBeat.i(94322);
    ad.m("MicroMsg.CameraPreviewGLTextureRender", "tryCameraPreview canPreview:" + this.hui, new Object[0]);
    if (this.hui)
    {
      if (paramb != null)
      {
        Object localObject = this.gKP;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getSurfaceTexture();; localObject = null)
        {
          paramb.invoke(localObject);
          AppMethodBeat.o(94322);
          return;
        }
      }
      AppMethodBeat.o(94322);
      return;
    }
    this.hug = paramb;
    AppMethodBeat.o(94322);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.huo;
    if (localb != null) {
      return localb.hoR;
    }
    return null;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(94328);
    Object localObject = this.gKP;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(94328);
      return localObject;
    }
    AppMethodBeat.o(94328);
    return null;
  }
  
  public final com.tencent.mm.media.g.d getPreviewTexture()
  {
    com.tencent.mm.media.j.a locala = this.hlj;
    if (locala != null) {
      return locala.hnh;
    }
    return null;
  }
  
  public final void h(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(94327);
    p.h(parama, "r");
    if (this.hkT != null)
    {
      ap localap = this.hkT;
      if (localap != null)
      {
        localap.post((Runnable)new c(parama));
        AppMethodBeat.o(94327);
        return;
      }
      AppMethodBeat.o(94327);
      return;
    }
    this.hup.add(parama);
    AppMethodBeat.o(94327);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94321);
    ad.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.hkT);
    if (this.hkT == null) {
      axG();
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
    ad.m("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureDestroyed", new Object[0]);
    this.hui = false;
    h((d.g.a.a)new c(this));
    AppMethodBeat.o(94319);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94318);
    ad.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
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
  
  public final void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.g.d, z> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null) {
      locala.huw = paramb;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender$onSurfaceTextureAvailable$1$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(SurfaceTexture paramSurfaceTexture, b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.b
 * JD-Core Version:    0.7.0.1
 */