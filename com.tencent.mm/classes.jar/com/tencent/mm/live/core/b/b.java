package com.tencent.mm.live.core.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveRenderManager;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "()V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eglThread", "Landroid/os/HandlerThread;", "initializeCallback", "Lkotlin/Function0;", "", "getInitializeCallback", "()Lkotlin/jvm/functions/Function0;", "setInitializeCallback", "(Lkotlin/jvm/functions/Function0;)V", "outputEglSurface", "Landroid/opengl/EGLSurface;", "outputSurface", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderer", "Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "clearFrame", "endScaleAnimation", "time", "", "exchangeSurface", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getRendererTextureSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "makeEGLEnvironment", "makeOutputSurface", "queueEvent", "r", "release", "requestRender", "reset", "setFpsCallbackListener", "listener", "Lkotlin/Function1;", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setOutputSurface", "surface", "setPerFrameRendererCostCallbackListener", "setPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "startScaleAnimation", "scale", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class b
  implements com.tencent.mm.media.widget.camerarecordview.preview.e
{
  public static final a qQd;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gBC;
  private c.b gsl;
  private final HandlerThread qPJ;
  private ap qPQ;
  private EGLSurface qPS;
  private Object qPU;
  public e qQa;
  d.g.a.a<y> qQc;
  
  static
  {
    AppMethodBeat.i(205757);
    qQd = new a((byte)0);
    AppMethodBeat.o(205757);
  }
  
  public b()
  {
    AppMethodBeat.i(205756);
    HandlerThread localHandlerThread = com.tencent.e.c.d.gv("MicroMsg.LiveCoreRender", 10);
    k.g(localHandlerThread, "SpecialThreadFactory.cre…TAG, Thread.MAX_PRIORITY)");
    this.qPJ = localHandlerThread;
    this.qPJ.start();
    this.qPQ = new ap(this.qPJ.getLooper());
    this.qPQ.post((Runnable)new c(this));
    AppMethodBeat.o(205756);
  }
  
  public final void D(d.g.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(205754);
    k.h(paramb, "listener");
    e locale = this.qQa;
    if (locale != null)
    {
      locale.qSV = paramb;
      AppMethodBeat.o(205754);
      return;
    }
    AppMethodBeat.o(205754);
  }
  
  public final void a(com.tencent.mm.media.i.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(205741);
    k.h(parama, "renderer");
    ad.m("MicroMsg.LiveCoreRender", "setPreviewRenderer cpuCrop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((com.tencent.mm.media.widget.camerarecordview.preview.e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((f)this))
    {
      this.gBC = locala;
      locala = this.gBC;
      if (locala == null) {
        break;
      }
      locala.b(parama);
      AppMethodBeat.o(205741);
      return;
    }
    AppMethodBeat.o(205741);
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(205743);
    k.h(paramb, "cameraConfig");
    ad.m("MicroMsg.LiveCoreRender", "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(205743);
      return;
    }
    AppMethodBeat.o(205743);
  }
  
  public final void anS() {}
  
  public final void anT()
  {
    AppMethodBeat.i(205748);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.anT();
      AppMethodBeat.o(205748);
      return;
    }
    AppMethodBeat.o(205748);
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205742);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramInt1 = com.tencent.mm.cd.a.hV(aj.getContext());
      paramInt2 = com.tencent.mm.cd.a.hW(aj.getContext());
      localObject = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.aUc("updateDrawSize:" + paramInt1 + " x " + paramInt2);
      localObject = this.gBC;
      if (localObject != null)
      {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
        AppMethodBeat.o(205742);
        return;
      }
      AppMethodBeat.o(205742);
      return;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("updateDrawSize:" + paramInt1 + " x " + paramInt2);
    localObject = this.gBC;
    if (localObject != null)
    {
      ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
      AppMethodBeat.o(205742);
      return;
    }
    AppMethodBeat.o(205742);
  }
  
  public final void czD()
  {
    AppMethodBeat.i(205750);
    j((d.g.a.a)new b(this));
    AppMethodBeat.o(205750);
  }
  
  public final ac czH()
  {
    int k = 0;
    AppMethodBeat.i(205755);
    Object localObject = this.gBC;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).fQI();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.f.d)localObject).width;; i = 0)
    {
      localObject = this.gBC;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).fQI();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.f.d)localObject).height;
        }
      }
      localObject = new ac(i, j);
      AppMethodBeat.o(205755);
      return localObject;
    }
  }
  
  public final void gc(Object paramObject)
  {
    if (paramObject != null)
    {
      this.qPS = null;
      this.qPU = paramObject;
    }
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.gsl;
    if (localb != null) {
      return localb.gwo;
    }
    return null;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(205747);
    Object localObject = this.gBC;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(205747);
      return localObject;
    }
    AppMethodBeat.o(205747);
    return null;
  }
  
  public final com.tencent.mm.media.f.d getPreviewTexture()
  {
    AppMethodBeat.i(205746);
    Object localObject = this.gBC;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).fQI();
      AppMethodBeat.o(205746);
      return localObject;
    }
    AppMethodBeat.o(205746);
    return null;
  }
  
  public final void j(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(205752);
    k.h(parama, "r");
    this.qPQ.post((Runnable)new c(parama));
    AppMethodBeat.o(205752);
  }
  
  public final void m(final d.g.a.b<? super SurfaceTexture, y> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(205744);
    Object localObject1 = this.gBC;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture(); localObject1 == null; localObject1 = null)
    {
      this.qQc = ((d.g.a.a)new f(this, paramb));
      AppMethodBeat.o(205744);
      return;
    }
    if (paramb != null)
    {
      localObject1 = this.gBC;
      if (localObject1 == null) {
        break label134;
      }
    }
    label134:
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();; localObject1 = null)
    {
      paramb.aA(localObject1);
      localObject1 = new StringBuilder("tryCameraPreview  ");
      com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
      paramb = localObject2;
      if (locala != null) {
        paramb = locala.getSurfaceTexture();
      }
      ad.m("MicroMsg.LiveCoreRender", paramb, new Object[0]);
      AppMethodBeat.o(205744);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(205749);
    ad.i("MicroMsg.LiveCoreRender", "release live render manager");
    j((d.g.a.a)new d(this));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null) {
      locala.release();
    }
    this.qPQ.removeCallbacks(null);
    this.qPJ.quitSafely();
    AppMethodBeat.o(205749);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(205751);
    j((d.g.a.a)new e(this));
    AppMethodBeat.o(205751);
  }
  
  public final void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.f.d, y> paramb)
  {
    AppMethodBeat.i(205745);
    ad.m("MicroMsg.LiveCoreRender", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.gBQ = paramb;
      AppMethodBeat.o(205745);
      return;
    }
    AppMethodBeat.o(205745);
  }
  
  public final void v(d.g.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(205753);
    k.h(paramb, "listener");
    e locale = this.qQa;
    if (locale != null)
    {
      locale.qSU = paramb;
      AppMethodBeat.o(205753);
      return;
    }
    AppMethodBeat.o(205753);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveRenderManager$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(205736);
      final int i = com.tencent.mm.cd.a.hV(aj.getContext());
      final int j = com.tencent.mm.cd.a.hW(aj.getContext());
      Object localObject1 = this.qQe;
      Object localObject2 = com.tencent.mm.media.j.c.gwl;
      b.a((b)localObject1, c.a.a(null, 0, 0, null, 28));
      localObject1 = com.tencent.mm.live.core.core.b.d.qzw;
      boolean bool = com.tencent.mm.live.core.core.b.d.cnu().qyW;
      b.a(this.qQe, new e(bool));
      localObject1 = this.qQe;
      localObject2 = b.b(this.qQe);
      if (localObject2 == null) {
        k.fvU();
      }
      ((b)localObject1).a((com.tencent.mm.media.i.a)localObject2, bool);
      localObject1 = b.c(this.qQe);
      if (localObject1 != null) {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).onSurfaceCreated(null, null);
      }
      localObject1 = b.c(this.qQe);
      if (localObject1 != null)
      {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).b(0, (d.g.a.a)new d.g.b.l(i) {});
        AppMethodBeat.o(205736);
        return;
      }
      AppMethodBeat.o(205736);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(b paramb, d.g.a.b paramb1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.b
 * JD-Core Version:    0.7.0.1
 */