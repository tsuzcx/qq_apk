package com.tencent.mm.live.core.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/render/LiveRenderManager;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "()V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eglThread", "Landroid/os/HandlerThread;", "initializeCallback", "Lkotlin/Function0;", "", "getInitializeCallback", "()Lkotlin/jvm/functions/Function0;", "setInitializeCallback", "(Lkotlin/jvm/functions/Function0;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "outputEglSurface", "Landroid/opengl/EGLSurface;", "outputSurface", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderer", "Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "clearFrame", "endScaleAnimation", "time", "", "exchangeSurface", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getRendererTextureSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "makeEGLEnvironment", "makeOutputSurface", "queueEvent", "r", "release", "requestRender", "reset", "setFpsCallbackListener", "listener", "Lkotlin/Function1;", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setOutputSurface", "surface", "setPerFrameRendererCostCallbackListener", "setPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "setup", "startScaleAnimation", "scale", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class b
  implements com.tencent.mm.media.widget.camerarecordview.preview.e
{
  public static final b.a grk;
  public com.tencent.mm.live.core.core.b.d goK;
  private final HandlerThread grc;
  private ao grd;
  private c.b gre;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a grf;
  private EGLSurface grg;
  private Object grh;
  public e gri;
  d.g.a.a<y> grj;
  
  static
  {
    AppMethodBeat.i(209293);
    grk = new b.a((byte)0);
    AppMethodBeat.o(209293);
  }
  
  public b()
  {
    AppMethodBeat.i(209292);
    HandlerThread localHandlerThread = com.tencent.e.c.d.gz("MicroMsg.LiveCoreRender", 10);
    k.g(localHandlerThread, "SpecialThreadFactory.cre…TAG, Thread.MAX_PRIORITY)");
    this.grc = localHandlerThread;
    this.grc.start();
    this.grd = new ao(this.grc.getLooper());
    this.grd.post((Runnable)new c(this));
    AppMethodBeat.o(209292);
  }
  
  public final void a(com.tencent.mm.media.i.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(209277);
    k.h(parama, "renderer");
    com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.LiveCoreRender", "setPreviewRenderer cpuCrop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.grf;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((com.tencent.mm.media.widget.camerarecordview.preview.e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((f)this))
    {
      this.grf = locala;
      locala = this.grf;
      if (locala == null) {
        break;
      }
      locala.b(parama);
      AppMethodBeat.o(209277);
      return;
    }
    AppMethodBeat.o(209277);
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(209279);
    k.h(paramb, "cameraConfig");
    com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.LiveCoreRender", "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.grf;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(209279);
      return;
    }
    AppMethodBeat.o(209279);
  }
  
  public final void ajA() {}
  
  public final void ajB()
  {
    AppMethodBeat.i(209284);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.grf;
    if (locala != null)
    {
      locala.ajB();
      AppMethodBeat.o(209284);
      return;
    }
    AppMethodBeat.o(209284);
  }
  
  public final void ajC()
  {
    AppMethodBeat.i(209286);
    h((d.g.a.a)new b(this));
    AppMethodBeat.o(209286);
  }
  
  public final com.tencent.mm.compatible.deviceinfo.ac ajD()
  {
    int k = 0;
    AppMethodBeat.i(209291);
    Object localObject = this.grf;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).auU();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.f.d)localObject).width;; i = 0)
    {
      localObject = this.grf;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).auU();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.f.d)localObject).height;
        }
      }
      localObject = new com.tencent.mm.compatible.deviceinfo.ac(i, j);
      AppMethodBeat.o(209291);
      return localObject;
    }
  }
  
  public final void bE(Object paramObject)
  {
    if (paramObject != null)
    {
      this.grg = null;
      this.grh = paramObject;
    }
  }
  
  public final void c(final d.g.a.b<? super SurfaceTexture, y> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(209280);
    Object localObject1 = this.grf;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture(); localObject1 == null; localObject1 = null)
    {
      this.grj = ((d.g.a.a)new f(this, paramb));
      AppMethodBeat.o(209280);
      return;
    }
    if (paramb != null)
    {
      localObject1 = this.grf;
      if (localObject1 == null) {
        break label134;
      }
    }
    label134:
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();; localObject1 = null)
    {
      paramb.ay(localObject1);
      localObject1 = new StringBuilder("tryCameraPreview  ");
      com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.grf;
      paramb = localObject2;
      if (locala != null) {
        paramb = locala.getSurfaceTexture();
      }
      com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.LiveCoreRender", paramb, new Object[0]);
      AppMethodBeat.o(209280);
      return;
    }
  }
  
  public final void cQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209278);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramInt1 = com.tencent.mm.cc.a.ig(ai.getContext());
      paramInt2 = com.tencent.mm.cc.a.ih(ai.getContext());
      localObject = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.uG("updateDrawSize:" + paramInt1 + " x " + paramInt2);
      localObject = this.grf;
      if (localObject != null)
      {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
        AppMethodBeat.o(209278);
        return;
      }
      AppMethodBeat.o(209278);
      return;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("updateDrawSize:" + paramInt1 + " x " + paramInt2);
    localObject = this.grf;
    if (localObject != null)
    {
      ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
      AppMethodBeat.o(209278);
      return;
    }
    AppMethodBeat.o(209278);
  }
  
  public final void d(d.g.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(209289);
    e locale = this.gri;
    if (locale != null)
    {
      locale.f(paramb);
      AppMethodBeat.o(209289);
      return;
    }
    AppMethodBeat.o(209289);
  }
  
  public final void e(d.g.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(209290);
    k.h(paramb, "listener");
    e locale = this.gri;
    if (locale != null)
    {
      locale.grI = paramb;
      AppMethodBeat.o(209290);
      return;
    }
    AppMethodBeat.o(209290);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.gre;
    if (localb != null) {
      return localb.gWL;
    }
    return null;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(209283);
    Object localObject = this.grf;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(209283);
      return localObject;
    }
    AppMethodBeat.o(209283);
    return null;
  }
  
  public final com.tencent.mm.media.f.d getPreviewTexture()
  {
    AppMethodBeat.i(209282);
    Object localObject = this.grf;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).auU();
      AppMethodBeat.o(209282);
      return localObject;
    }
    AppMethodBeat.o(209282);
    return null;
  }
  
  public final void h(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(209288);
    k.h(parama, "r");
    this.grd.post((Runnable)new c(parama));
    AppMethodBeat.o(209288);
  }
  
  public final void release()
  {
    AppMethodBeat.i(209285);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LiveCoreRender", "release live render manager");
    h((d.g.a.a)new d(this));
    AppMethodBeat.o(209285);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(209287);
    h((d.g.a.a)new e(this));
    AppMethodBeat.o(209287);
  }
  
  public final void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.f.d, y> paramb)
  {
    AppMethodBeat.i(209281);
    com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.LiveCoreRender", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.grf;
    if (locala != null)
    {
      locala.hco = paramb;
      AppMethodBeat.o(209281);
      return;
    }
    AppMethodBeat.o(209281);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(209272);
      final int i = com.tencent.mm.cc.a.ig(ai.getContext());
      final int j = com.tencent.mm.cc.a.ih(ai.getContext());
      Object localObject1 = this.grl;
      Object localObject2 = com.tencent.mm.media.j.c.gWJ;
      b.a((b)localObject1, c.a.a(null, 1, 1, null, 16));
      localObject1 = b.b(this.grl);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gnS;
        if (localObject1 == null) {}
      }
      for (boolean bool = ((com.tencent.mm.live.core.core.b.b)localObject1).gnM;; bool = false)
      {
        b.a(this.grl, new e(bool));
        localObject1 = this.grl;
        localObject2 = b.c(this.grl);
        if (localObject2 == null) {
          k.fOy();
        }
        ((b)localObject1).a((com.tencent.mm.media.i.a)localObject2, bool);
        localObject1 = b.d(this.grl);
        if (localObject1 != null) {
          ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).onSurfaceCreated(null, null);
        }
        localObject1 = b.d(this.grl);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).a(0, (d.g.a.a)new d.g.b.l(i) {});
        AppMethodBeat.o(209272);
        return;
      }
      AppMethodBeat.o(209272);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(b paramb)
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
    f(b paramb, d.g.a.b paramb1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.b.b
 * JD-Core Version:    0.7.0.1
 */