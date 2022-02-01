package com.tencent.mm.live.core.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/LiveRenderManager;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "()V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eglThread", "Landroid/os/HandlerThread;", "initializeCallback", "Lkotlin/Function0;", "", "getInitializeCallback", "()Lkotlin/jvm/functions/Function0;", "setInitializeCallback", "(Lkotlin/jvm/functions/Function0;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "outputEglSurface", "Landroid/opengl/EGLSurface;", "outputSurface", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderer", "Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "clearFrame", "endScaleAnimation", "time", "", "exchangeSurface", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getRendererTextureSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "makeEGLEnvironment", "makeOutputSurface", "mirrorMode", "queueEvent", "r", "release", "requestRender", "reset", "setFpsCallbackListener", "listener", "Lkotlin/Function1;", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setOutputSurface", "surface", "setPerFrameRendererCostCallbackListener", "setPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "setup", "startScaleAnimation", "scale", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateBeautyConfig", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "updateDrawSize", "width", "height", "updateFilterConfig", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "updateMirror", "isMirror", "updateMirrorMode", "updateScene", "scene", "Companion", "plugin-core_release"})
public final class d
  implements com.tencent.mm.media.widget.camerarecordview.preview.e
{
  public static final d.a hDy;
  public com.tencent.mm.live.core.core.b.f hAy;
  private final HandlerThread hDq;
  private MMHandler hDr;
  private c.b hDs;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
  private EGLSurface hDu;
  private Object hDv;
  public g hDw;
  kotlin.g.a.a<x> hDx;
  
  static
  {
    AppMethodBeat.i(196648);
    hDy = new d.a((byte)0);
    AppMethodBeat.o(196648);
  }
  
  public d()
  {
    AppMethodBeat.i(196647);
    HandlerThread localHandlerThread = com.tencent.f.c.d.hA("MicroMsg.LiveCoreRender", 10);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…TAG, Thread.MAX_PRIORITY)");
    this.hDq = localHandlerThread;
    this.hDq.start();
    this.hDr = new MMHandler(this.hDq.getLooper());
    this.hDr.post((Runnable)new c(this));
    AppMethodBeat.o(196647);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(196631);
    j((kotlin.g.a.a)new d.g(this, parama));
    AppMethodBeat.o(196631);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(196632);
    j((kotlin.g.a.a)new d.h(this, paramb));
    AppMethodBeat.o(196632);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(196630);
    p.h(parama, "renderer");
    Log.printInfoStack("MicroMsg.LiveCoreRender", "setPreviewRenderer cpuCrop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((com.tencent.mm.media.widget.camerarecordview.preview.e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((com.tencent.mm.media.widget.camerarecordview.preview.f)this))
    {
      this.hDt = locala;
      locala = this.hDt;
      if (locala == null) {
        break;
      }
      locala.b(parama);
      AppMethodBeat.o(196630);
      return;
    }
    AppMethodBeat.o(196630);
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(196634);
    p.h(paramb, "cameraConfig");
    Log.printInfoStack("MicroMsg.LiveCoreRender", "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(196634);
      return;
    }
    AppMethodBeat.o(196634);
  }
  
  public final ac aEA()
  {
    int k = 0;
    AppMethodBeat.i(196646);
    Object localObject = this.hDt;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).aQu();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.g.d)localObject).width;; i = 0)
    {
      localObject = this.hDt;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).aQu();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.g.d)localObject).height;
        }
      }
      localObject = new ac(i, j);
      AppMethodBeat.o(196646);
      return localObject;
    }
  }
  
  public final void aEx() {}
  
  public final void aEy()
  {
    AppMethodBeat.i(196639);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.aEy();
      AppMethodBeat.o(196639);
      return;
    }
    AppMethodBeat.o(196639);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(196641);
    j((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(196641);
  }
  
  public final void bO(Object paramObject)
  {
    if (paramObject != null)
    {
      this.hDu = null;
      this.hDv = paramObject;
    }
  }
  
  public final void cX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196633);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramInt1 = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
      paramInt2 = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
      localObject = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.GA("updateDrawSize:" + paramInt1 + " x " + paramInt2);
      localObject = this.hDt;
      if (localObject != null)
      {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
        AppMethodBeat.o(196633);
        return;
      }
      AppMethodBeat.o(196633);
      return;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.GA("updateDrawSize:" + paramInt1 + " x " + paramInt2);
    localObject = this.hDt;
    if (localObject != null)
    {
      ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
      AppMethodBeat.o(196633);
      return;
    }
    AppMethodBeat.o(196633);
  }
  
  public final void d(final kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(196635);
    Object localObject1 = this.hDt;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture(); localObject1 == null; localObject1 = null)
    {
      this.hDx = ((kotlin.g.a.a)new f(this, paramb));
      AppMethodBeat.o(196635);
      return;
    }
    if (paramb != null)
    {
      localObject1 = this.hDt;
      if (localObject1 == null) {
        break label134;
      }
    }
    label134:
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();; localObject1 = null)
    {
      paramb.invoke(localObject1);
      localObject1 = new StringBuilder("tryCameraPreview  ");
      com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
      paramb = localObject2;
      if (locala != null) {
        paramb = locala.getSurfaceTexture();
      }
      Log.printInfoStack("MicroMsg.LiveCoreRender", paramb, new Object[0]);
      AppMethodBeat.o(196635);
      return;
    }
  }
  
  public final void e(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(196644);
    g localg = this.hDw;
    if (localg != null)
    {
      localg.g(paramb);
      AppMethodBeat.o(196644);
      return;
    }
    AppMethodBeat.o(196644);
  }
  
  public final void f(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(196645);
    p.h(paramb, "listener");
    g localg = this.hDw;
    if (localg != null)
    {
      localg.hDZ = paramb;
      AppMethodBeat.o(196645);
      return;
    }
    AppMethodBeat.o(196645);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.hDs;
    if (localb != null) {
      return localb.ilv;
    }
    return null;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    AppMethodBeat.i(196638);
    Object localObject = this.hDt;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(196638);
      return localObject;
    }
    AppMethodBeat.o(196638);
    return null;
  }
  
  public final com.tencent.mm.media.g.d getPreviewTexture()
  {
    AppMethodBeat.i(196637);
    Object localObject = this.hDt;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).aQu();
      AppMethodBeat.o(196637);
      return localObject;
    }
    AppMethodBeat.o(196637);
    return null;
  }
  
  public final void j(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(196643);
    p.h(parama, "r");
    this.hDr.post((Runnable)new e(parama));
    AppMethodBeat.o(196643);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196640);
    Log.i("MicroMsg.LiveCoreRender", "release live render manager");
    j((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(196640);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(196642);
    j((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(196642);
  }
  
  public final void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, x> paramb)
  {
    AppMethodBeat.i(196636);
    Log.printInfoStack("MicroMsg.LiveCoreRender", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.iqL = paramb;
      AppMethodBeat.o(196636);
      return;
    }
    AppMethodBeat.o(196636);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(196621);
      final int i = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
      final int j = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
      d.a(this.hDz, c.a.a(com.tencent.mm.media.k.c.ilt, null, 1, 1, null, 16));
      Object localObject = d.b(this.hDz);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
        if (localObject == null) {}
      }
      for (boolean bool = ((com.tencent.mm.live.core.core.b.d)localObject).hzi;; bool = false)
      {
        d.a(this.hDz, new g(bool));
        localObject = this.hDz;
        g localg = d.c(this.hDz);
        if (localg == null) {
          p.hyc();
        }
        ((d)localObject).a((com.tencent.mm.media.j.a)localg, bool);
        localObject = d.d(this.hDz);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceCreated(null, null);
        }
        localObject = d.d(this.hDz);
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).a(0, (kotlin.g.a.a)new q(i) {});
        AppMethodBeat.o(196621);
        return;
      }
      AppMethodBeat.o(196621);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(d paramd, kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.d
 * JD-Core Version:    0.7.0.1
 */