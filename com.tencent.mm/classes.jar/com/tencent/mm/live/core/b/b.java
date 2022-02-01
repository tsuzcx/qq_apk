package com.tencent.mm.live.core.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/render/LiveRenderManager;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "()V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eglThread", "Landroid/os/HandlerThread;", "initializeCallback", "Lkotlin/Function0;", "", "getInitializeCallback", "()Lkotlin/jvm/functions/Function0;", "setInitializeCallback", "(Lkotlin/jvm/functions/Function0;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "outputEglSurface", "Landroid/opengl/EGLSurface;", "outputSurface", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderer", "Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "clearFrame", "endScaleAnimation", "time", "", "exchangeSurface", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getRendererTextureSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "makeEGLEnvironment", "makeOutputSurface", "queueEvent", "r", "release", "requestRender", "reset", "setFpsCallbackListener", "listener", "Lkotlin/Function1;", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setOutputSurface", "surface", "setPerFrameRendererCostCallbackListener", "setPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "setup", "startScaleAnimation", "scale", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class b
  implements com.tencent.mm.media.widget.camerarecordview.preview.e
{
  public static final b.a gND;
  public com.tencent.mm.live.core.core.b.d gLb;
  private Object gNA;
  public e gNB;
  d.g.a.a<z> gNC;
  private final HandlerThread gNv;
  private aq gNw;
  private c.b gNx;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gNy;
  private EGLSurface gNz;
  
  static
  {
    AppMethodBeat.i(196963);
    gND = new b.a((byte)0);
    AppMethodBeat.o(196963);
  }
  
  public b()
  {
    AppMethodBeat.i(196962);
    HandlerThread localHandlerThread = com.tencent.e.c.d.hg("MicroMsg.LiveCoreRender", 10);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…TAG, Thread.MAX_PRIORITY)");
    this.gNv = localHandlerThread;
    this.gNv.start();
    this.gNw = new aq(this.gNv.getLooper());
    this.gNw.post((Runnable)new c(this));
    AppMethodBeat.o(196962);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(196947);
    p.h(parama, "renderer");
    ae.m("MicroMsg.LiveCoreRender", "setPreviewRenderer cpuCrop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gNy;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((com.tencent.mm.media.widget.camerarecordview.preview.e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((f)this))
    {
      this.gNy = locala;
      locala = this.gNy;
      if (locala == null) {
        break;
      }
      locala.b(parama);
      AppMethodBeat.o(196947);
      return;
    }
    AppMethodBeat.o(196947);
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(196949);
    p.h(paramb, "cameraConfig");
    ae.m("MicroMsg.LiveCoreRender", "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gNy;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(196949);
      return;
    }
    AppMethodBeat.o(196949);
  }
  
  public final void amB() {}
  
  public final void amC()
  {
    AppMethodBeat.i(196954);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gNy;
    if (locala != null)
    {
      locala.amC();
      AppMethodBeat.o(196954);
      return;
    }
    AppMethodBeat.o(196954);
  }
  
  public final void amD()
  {
    AppMethodBeat.i(196956);
    i((d.g.a.a)new b(this));
    AppMethodBeat.o(196956);
  }
  
  public final ac amE()
  {
    int k = 0;
    AppMethodBeat.i(196961);
    Object localObject = this.gNy;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).axW();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.g.d)localObject).width;; i = 0)
    {
      localObject = this.gNy;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).axW();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.g.d)localObject).height;
        }
      }
      localObject = new ac(i, j);
      AppMethodBeat.o(196961);
      return localObject;
    }
  }
  
  public final void bG(Object paramObject)
  {
    if (paramObject != null)
    {
      this.gNz = null;
      this.gNA = paramObject;
    }
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196948);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramInt1 = com.tencent.mm.cb.a.iu(ak.getContext());
      paramInt2 = com.tencent.mm.cb.a.iv(ak.getContext());
      localObject = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.yg("updateDrawSize:" + paramInt1 + " x " + paramInt2);
      localObject = this.gNy;
      if (localObject != null)
      {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
        AppMethodBeat.o(196948);
        return;
      }
      AppMethodBeat.o(196948);
      return;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("updateDrawSize:" + paramInt1 + " x " + paramInt2);
    localObject = this.gNy;
    if (localObject != null)
    {
      ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
      AppMethodBeat.o(196948);
      return;
    }
    AppMethodBeat.o(196948);
  }
  
  public final void d(final d.g.a.b<? super SurfaceTexture, z> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(196950);
    Object localObject1 = this.gNy;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture(); localObject1 == null; localObject1 = null)
    {
      this.gNC = ((d.g.a.a)new f(this, paramb));
      AppMethodBeat.o(196950);
      return;
    }
    if (paramb != null)
    {
      localObject1 = this.gNy;
      if (localObject1 == null) {
        break label134;
      }
    }
    label134:
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();; localObject1 = null)
    {
      paramb.invoke(localObject1);
      localObject1 = new StringBuilder("tryCameraPreview  ");
      com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gNy;
      paramb = localObject2;
      if (locala != null) {
        paramb = locala.getSurfaceTexture();
      }
      ae.m("MicroMsg.LiveCoreRender", paramb, new Object[0]);
      AppMethodBeat.o(196950);
      return;
    }
  }
  
  public final void e(d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(196959);
    e locale = this.gNB;
    if (locale != null)
    {
      locale.g(paramb);
      AppMethodBeat.o(196959);
      return;
    }
    AppMethodBeat.o(196959);
  }
  
  public final void f(d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(196960);
    p.h(paramb, "listener");
    e locale = this.gNB;
    if (locale != null)
    {
      locale.gNZ = paramb;
      AppMethodBeat.o(196960);
      return;
    }
    AppMethodBeat.o(196960);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.gNx;
    if (localb != null) {
      return localb.hrF;
    }
    return null;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(196953);
    Object localObject = this.gNy;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(196953);
      return localObject;
    }
    AppMethodBeat.o(196953);
    return null;
  }
  
  public final com.tencent.mm.media.g.d getPreviewTexture()
  {
    AppMethodBeat.i(196952);
    Object localObject = this.gNy;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).axW();
      AppMethodBeat.o(196952);
      return localObject;
    }
    AppMethodBeat.o(196952);
    return null;
  }
  
  public final void i(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(196958);
    p.h(parama, "r");
    this.gNw.post((Runnable)new c(parama));
    AppMethodBeat.o(196958);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196955);
    ae.i("MicroMsg.LiveCoreRender", "release live render manager");
    i((d.g.a.a)new d(this));
    AppMethodBeat.o(196955);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(196957);
    i((d.g.a.a)new e(this));
    AppMethodBeat.o(196957);
  }
  
  public final void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.g.d, z> paramb)
  {
    AppMethodBeat.i(196951);
    ae.m("MicroMsg.LiveCoreRender", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gNy;
    if (locala != null)
    {
      locala.hxk = paramb;
      AppMethodBeat.o(196951);
      return;
    }
    AppMethodBeat.o(196951);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(196942);
      final int i = com.tencent.mm.cb.a.iu(ak.getContext());
      final int j = com.tencent.mm.cb.a.iv(ak.getContext());
      Object localObject1 = this.gNE;
      Object localObject2 = com.tencent.mm.media.k.c.hrD;
      b.a((b)localObject1, c.a.a(null, 1, 1, null, 16));
      localObject1 = b.b(this.gNE);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gKk;
        if (localObject1 == null) {}
      }
      for (boolean bool = ((com.tencent.mm.live.core.core.b.b)localObject1).gKe;; bool = false)
      {
        b.a(this.gNE, new e(bool));
        localObject1 = this.gNE;
        localObject2 = b.c(this.gNE);
        if (localObject2 == null) {
          p.gkB();
        }
        ((b)localObject1).a((com.tencent.mm.media.j.a)localObject2, bool);
        localObject1 = b.d(this.gNE);
        if (localObject1 != null) {
          ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).onSurfaceCreated(null, null);
        }
        localObject1 = b.d(this.gNE);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).a(0, (d.g.a.a)new q(i) {});
        AppMethodBeat.o(196942);
        return;
      }
      AppMethodBeat.o(196942);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(b paramb, d.g.a.b paramb1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.b
 * JD-Core Version:    0.7.0.1
 */