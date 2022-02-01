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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/render/LiveRenderManager;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "()V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eglThread", "Landroid/os/HandlerThread;", "initializeCallback", "Lkotlin/Function0;", "", "getInitializeCallback", "()Lkotlin/jvm/functions/Function0;", "setInitializeCallback", "(Lkotlin/jvm/functions/Function0;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "outputEglSurface", "Landroid/opengl/EGLSurface;", "outputSurface", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderer", "Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "clearFrame", "endScaleAnimation", "time", "", "exchangeSurface", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getRendererTextureSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "makeEGLEnvironment", "makeOutputSurface", "queueEvent", "r", "release", "requestRender", "reset", "setFpsCallbackListener", "listener", "Lkotlin/Function1;", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setOutputSurface", "surface", "setPerFrameRendererCostCallbackListener", "setPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "setup", "startScaleAnimation", "scale", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class b
  implements com.tencent.mm.media.widget.camerarecordview.preview.e
{
  public static final b.a gKU;
  public com.tencent.mm.live.core.core.b.d gIs;
  private final HandlerThread gKM;
  private ap gKN;
  private c.b gKO;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gKP;
  private EGLSurface gKQ;
  private Object gKR;
  public e gKS;
  d.g.a.a<z> gKT;
  
  static
  {
    AppMethodBeat.i(216951);
    gKU = new b.a((byte)0);
    AppMethodBeat.o(216951);
  }
  
  public b()
  {
    AppMethodBeat.i(216950);
    HandlerThread localHandlerThread = com.tencent.e.c.d.gX("MicroMsg.LiveCoreRender", 10);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…TAG, Thread.MAX_PRIORITY)");
    this.gKM = localHandlerThread;
    this.gKM.start();
    this.gKN = new ap(this.gKM.getLooper());
    this.gKN.post((Runnable)new c(this));
    AppMethodBeat.o(216950);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(216935);
    p.h(parama, "renderer");
    ad.m("MicroMsg.LiveCoreRender", "setPreviewRenderer cpuCrop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((com.tencent.mm.media.widget.camerarecordview.preview.e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((f)this))
    {
      this.gKP = locala;
      locala = this.gKP;
      if (locala == null) {
        break;
      }
      locala.b(parama);
      AppMethodBeat.o(216935);
      return;
    }
    AppMethodBeat.o(216935);
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(216937);
    p.h(paramb, "cameraConfig");
    ad.m("MicroMsg.LiveCoreRender", "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(216937);
      return;
    }
    AppMethodBeat.o(216937);
  }
  
  public final void amm() {}
  
  public final void amn()
  {
    AppMethodBeat.i(216942);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null)
    {
      locala.amn();
      AppMethodBeat.o(216942);
      return;
    }
    AppMethodBeat.o(216942);
  }
  
  public final void amo()
  {
    AppMethodBeat.i(216944);
    h((d.g.a.a)new b(this));
    AppMethodBeat.o(216944);
  }
  
  public final ac amp()
  {
    int k = 0;
    AppMethodBeat.i(216949);
    Object localObject = this.gKP;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).axH();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.g.d)localObject).width;; i = 0)
    {
      localObject = this.gKP;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).axH();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.g.d)localObject).height;
        }
      }
      localObject = new ac(i, j);
      AppMethodBeat.o(216949);
      return localObject;
    }
  }
  
  public final void bG(Object paramObject)
  {
    if (paramObject != null)
    {
      this.gKQ = null;
      this.gKR = paramObject;
    }
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216936);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramInt1 = com.tencent.mm.cc.a.ip(aj.getContext());
      paramInt2 = com.tencent.mm.cc.a.iq(aj.getContext());
      localObject = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.xx("updateDrawSize:" + paramInt1 + " x " + paramInt2);
      localObject = this.gKP;
      if (localObject != null)
      {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
        AppMethodBeat.o(216936);
        return;
      }
      AppMethodBeat.o(216936);
      return;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("updateDrawSize:" + paramInt1 + " x " + paramInt2);
    localObject = this.gKP;
    if (localObject != null)
    {
      ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
      AppMethodBeat.o(216936);
      return;
    }
    AppMethodBeat.o(216936);
  }
  
  public final void d(final d.g.a.b<? super SurfaceTexture, z> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(216938);
    Object localObject1 = this.gKP;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture(); localObject1 == null; localObject1 = null)
    {
      this.gKT = ((d.g.a.a)new f(this, paramb));
      AppMethodBeat.o(216938);
      return;
    }
    if (paramb != null)
    {
      localObject1 = this.gKP;
      if (localObject1 == null) {
        break label134;
      }
    }
    label134:
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();; localObject1 = null)
    {
      paramb.invoke(localObject1);
      localObject1 = new StringBuilder("tryCameraPreview  ");
      com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
      paramb = localObject2;
      if (locala != null) {
        paramb = locala.getSurfaceTexture();
      }
      ad.m("MicroMsg.LiveCoreRender", paramb, new Object[0]);
      AppMethodBeat.o(216938);
      return;
    }
  }
  
  public final void e(d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(216947);
    e locale = this.gKS;
    if (locale != null)
    {
      locale.g(paramb);
      AppMethodBeat.o(216947);
      return;
    }
    AppMethodBeat.o(216947);
  }
  
  public final void f(d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(216948);
    p.h(paramb, "listener");
    e locale = this.gKS;
    if (locale != null)
    {
      locale.gLq = paramb;
      AppMethodBeat.o(216948);
      return;
    }
    AppMethodBeat.o(216948);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.gKO;
    if (localb != null) {
      return localb.hoR;
    }
    return null;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(216941);
    Object localObject = this.gKP;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(216941);
      return localObject;
    }
    AppMethodBeat.o(216941);
    return null;
  }
  
  public final com.tencent.mm.media.g.d getPreviewTexture()
  {
    AppMethodBeat.i(216940);
    Object localObject = this.gKP;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).axH();
      AppMethodBeat.o(216940);
      return localObject;
    }
    AppMethodBeat.o(216940);
    return null;
  }
  
  public final void h(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(216946);
    p.h(parama, "r");
    this.gKN.post((Runnable)new c(parama));
    AppMethodBeat.o(216946);
  }
  
  public final void release()
  {
    AppMethodBeat.i(216943);
    ad.i("MicroMsg.LiveCoreRender", "release live render manager");
    h((d.g.a.a)new d(this));
    AppMethodBeat.o(216943);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(216945);
    h((d.g.a.a)new e(this));
    AppMethodBeat.o(216945);
  }
  
  public final void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.g.d, z> paramb)
  {
    AppMethodBeat.i(216939);
    ad.m("MicroMsg.LiveCoreRender", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null)
    {
      locala.huw = paramb;
      AppMethodBeat.o(216939);
      return;
    }
    AppMethodBeat.o(216939);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(216930);
      final int i = com.tencent.mm.cc.a.ip(aj.getContext());
      final int j = com.tencent.mm.cc.a.iq(aj.getContext());
      Object localObject1 = this.gKV;
      Object localObject2 = com.tencent.mm.media.k.c.hoP;
      b.a((b)localObject1, c.a.a(null, 1, 1, null, 16));
      localObject1 = b.b(this.gKV);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gHB;
        if (localObject1 == null) {}
      }
      for (boolean bool = ((com.tencent.mm.live.core.core.b.b)localObject1).gHv;; bool = false)
      {
        b.a(this.gKV, new e(bool));
        localObject1 = this.gKV;
        localObject2 = b.c(this.gKV);
        if (localObject2 == null) {
          p.gfZ();
        }
        ((b)localObject1).a((com.tencent.mm.media.j.a)localObject2, bool);
        localObject1 = b.d(this.gKV);
        if (localObject1 != null) {
          ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).onSurfaceCreated(null, null);
        }
        localObject1 = b.d(this.gKV);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).a(0, (d.g.a.a)new q(i) {});
        AppMethodBeat.o(216930);
        return;
      }
      AppMethodBeat.o(216930);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(b paramb)
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