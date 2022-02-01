package com.tencent.mm.live.core.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.live.core.core.e.l;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveRenderManager;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "()V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eglThread", "Landroid/os/HandlerThread;", "initializeCallback", "Lkotlin/Function0;", "", "getInitializeCallback", "()Lkotlin/jvm/functions/Function0;", "setInitializeCallback", "(Lkotlin/jvm/functions/Function0;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "outputEglSurface", "Landroid/opengl/EGLSurface;", "outputSurface", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderer", "Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "clearFrame", "endScaleAnimation", "time", "", "exchangeSurface", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getRendererTextureSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "makeEGLEnvironment", "makeOutputSurface", "mirrorMode", "queueEvent", "r", "release", "requestRender", "reset", "setFpsCallbackListener", "listener", "Lkotlin/Function1;", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setOutputSurface", "surface", "setPerFrameRendererCostCallbackListener", "setPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "setup", "liveScene", "startScaleAnimation", "scale", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateBeautyConfig", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "updateDrawSize", "width", "height", "updateFilterConfig", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "updateMirror", "isMirror", "updateMirrorMode", "updateScene", "scene", "Companion", "plugin-core_release"})
public final class d
  implements com.tencent.mm.media.widget.camerarecordview.preview.e
{
  public static final a krr;
  public com.tencent.mm.live.core.core.model.g knz;
  private final HandlerThread krj;
  private MMHandler krk;
  private c.b krl;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a krm;
  private EGLSurface krn;
  private Object kro;
  public i krp;
  kotlin.g.a.a<x> krq;
  
  static
  {
    AppMethodBeat.i(198121);
    krr = new a((byte)0);
    AppMethodBeat.o(198121);
  }
  
  public d()
  {
    AppMethodBeat.i(198116);
    HandlerThread localHandlerThread = com.tencent.e.c.d.ik("MicroMsg.LiveCoreRender", 10);
    p.j(localHandlerThread, "SpecialThreadFactory.cre…TAG, Thread.MAX_PRIORITY)");
    this.krj = localHandlerThread;
    this.krj.start();
    this.krk = new MMHandler(this.krj.getLooper());
    this.krk.post((Runnable)new c(this));
    AppMethodBeat.o(198116);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(198064);
    i((kotlin.g.a.a)new g(this, parama));
    AppMethodBeat.o(198064);
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(198066);
    i((kotlin.g.a.a)new h(this, paramb));
    AppMethodBeat.o(198066);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(198062);
    p.k(parama, "renderer");
    Log.printInfoStack("MicroMsg.LiveCoreRender", "setPreviewRenderer cpuCrop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.krm;
    if (locala != null) {
      locala.release(true);
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((com.tencent.mm.media.widget.camerarecordview.preview.e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((f)this))
    {
      this.krm = locala;
      locala = this.krm;
      if (locala == null) {
        break;
      }
      locala.b(parama);
      AppMethodBeat.o(198062);
      return;
    }
    AppMethodBeat.o(198062);
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(198072);
    p.k(paramb, "cameraConfig");
    Log.printInfoStack("MicroMsg.LiveCoreRender", "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.krm;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(198072);
      return;
    }
    AppMethodBeat.o(198072);
  }
  
  public final void aMM() {}
  
  public final void aMN()
  {
    AppMethodBeat.i(198095);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.krm;
    if (locala != null)
    {
      locala.aMN();
      AppMethodBeat.o(198095);
      return;
    }
    AppMethodBeat.o(198095);
  }
  
  public final void aMO()
  {
    AppMethodBeat.i(198098);
    i((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(198098);
  }
  
  public final ad aMP()
  {
    int k = 0;
    AppMethodBeat.i(198110);
    Object localObject = this.krm;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).aZm();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.g.d)localObject).width;; i = 0)
    {
      localObject = this.krm;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).aZm();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.g.d)localObject).height;
        }
      }
      localObject = new ad(i, j);
      AppMethodBeat.o(198110);
      return localObject;
    }
  }
  
  public final int aMQ()
  {
    AppMethodBeat.i(198113);
    Object localObject = this.krp;
    if (localObject != null)
    {
      i = ((i)localObject).ksg;
      AppMethodBeat.o(198113);
      return i;
    }
    localObject = e.l.kkD;
    int i = e.l.aKE();
    AppMethodBeat.o(198113);
    return i;
  }
  
  public final void bO(Object paramObject)
  {
    if (paramObject != null)
    {
      this.krn = null;
      this.kro = paramObject;
    }
  }
  
  public final void d(final kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(198078);
    Object localObject1 = this.krm;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture(); localObject1 == null; localObject1 = null)
    {
      this.krq = ((kotlin.g.a.a)new f(this, paramb));
      AppMethodBeat.o(198078);
      return;
    }
    if (paramb != null)
    {
      localObject1 = this.krm;
      if (localObject1 == null) {
        break label134;
      }
    }
    label134:
    for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();; localObject1 = null)
    {
      paramb.invoke(localObject1);
      localObject1 = new StringBuilder("tryCameraPreview  ");
      com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.krm;
      paramb = localObject2;
      if (locala != null) {
        paramb = locala.getSurfaceTexture();
      }
      Log.printInfoStack("MicroMsg.LiveCoreRender", paramb, new Object[0]);
      AppMethodBeat.o(198078);
      return;
    }
  }
  
  public final void dt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198069);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramInt1 = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext());
      paramInt2 = com.tencent.mm.ci.a.ks(MMApplicationContext.getContext());
      localObject = com.tencent.mm.live.core.debug.a.kqB;
      com.tencent.mm.live.core.debug.a.NN("updateDrawSize:" + paramInt1 + " x " + paramInt2);
      localObject = this.krm;
      if (localObject != null)
      {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
        AppMethodBeat.o(198069);
        return;
      }
      AppMethodBeat.o(198069);
      return;
    }
    Object localObject = com.tencent.mm.live.core.debug.a.kqB;
    com.tencent.mm.live.core.debug.a.NN("updateDrawSize:" + paramInt1 + " x " + paramInt2);
    localObject = this.krm;
    if (localObject != null)
    {
      ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceChanged(null, paramInt1, paramInt2);
      AppMethodBeat.o(198069);
      return;
    }
    AppMethodBeat.o(198069);
  }
  
  public final void e(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(198104);
    i locali = this.krp;
    if (locali != null)
    {
      locali.g(paramb);
      AppMethodBeat.o(198104);
      return;
    }
    AppMethodBeat.o(198104);
  }
  
  public final void f(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(198107);
    p.k(paramb, "listener");
    i locali = this.krp;
    if (locali != null)
    {
      locali.kse = paramb;
      AppMethodBeat.o(198107);
      return;
    }
    AppMethodBeat.o(198107);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.krl;
    if (localb != null) {
      return localb.lau;
    }
    return null;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    AppMethodBeat.i(198091);
    Object localObject = this.krm;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(198091);
      return localObject;
    }
    AppMethodBeat.o(198091);
    return null;
  }
  
  public final com.tencent.mm.media.g.d getPreviewTexture()
  {
    AppMethodBeat.i(198088);
    Object localObject = this.krp;
    if (localObject != null)
    {
      localObject = ((i)localObject).aMV();
      AppMethodBeat.o(198088);
      return localObject;
    }
    AppMethodBeat.o(198088);
    return null;
  }
  
  public final void i(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(198101);
    p.k(parama, "r");
    this.krk.post((Runnable)new e(parama));
    AppMethodBeat.o(198101);
  }
  
  public final void release()
  {
    AppMethodBeat.i(198096);
    Log.i("MicroMsg.LiveCoreRender", "release live render manager");
    i((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(198096);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(198100);
    i((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(198100);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(198102);
    i locali = this.krp;
    if (locali != null)
    {
      locali.reset();
      AppMethodBeat.o(198102);
      return;
    }
    AppMethodBeat.o(198102);
  }
  
  public final void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, x> paramb)
  {
    AppMethodBeat.i(198087);
    Log.printInfoStack("MicroMsg.LiveCoreRender", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.krm;
    if (locala != null)
    {
      locala.lfQ = paramb;
      AppMethodBeat.o(198087);
      return;
    }
    AppMethodBeat.o(198087);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveRenderManager$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(199914);
      final int i = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext());
      final int j = com.tencent.mm.ci.a.ks(MMApplicationContext.getContext());
      d.a(this.krs, c.a.a(com.tencent.mm.media.k.c.lar, null, 1, 1, null, 16));
      Object localObject = d.b(this.krs);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.model.g)localObject).kmp;
        if (localObject == null) {}
      }
      for (boolean bool = ((com.tencent.mm.live.core.core.model.e)localObject).kmf;; bool = false)
      {
        d.a(this.krs, new i(bool));
        localObject = this.krs;
        i locali = d.c(this.krs);
        if (locali == null) {
          p.iCn();
        }
        ((d)localObject).a((com.tencent.mm.media.j.a)locali, bool);
        localObject = d.d(this.krs);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceCreated(null, null);
        }
        localObject = d.d(this.krs);
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).a(0, (kotlin.g.a.a)new q(i) {});
        AppMethodBeat.o(199914);
        return;
      }
      AppMethodBeat.o(199914);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(d paramd, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(d paramd, a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(d paramd, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    public i(d paramd, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    public j(d paramd, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.d
 * JD-Core Version:    0.7.0.1
 */