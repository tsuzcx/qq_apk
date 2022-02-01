package com.tencent.mm.live.core.b;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.live.core.core.e.n;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/LiveRenderManager;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "()V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eglThread", "Landroid/os/HandlerThread;", "initializeCallback", "Lkotlin/Function0;", "", "getInitializeCallback", "()Lkotlin/jvm/functions/Function0;", "setInitializeCallback", "(Lkotlin/jvm/functions/Function0;)V", "model", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "outputEglSurface", "Landroid/opengl/EGLSurface;", "outputSurface", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderer", "Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "clearFrame", "endScaleAnimation", "time", "", "exchangeSurface", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getRendererTextureSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "makeEGLEnvironment", "makeOutputSurface", "mirrorMode", "queueEvent", "r", "release", "requestRender", "reset", "setFpsCallbackListener", "listener", "Lkotlin/Function1;", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setOutputSurface", "surface", "setPerFrameRendererCostCallbackListener", "setPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "setup", "liveScene", "startScaleAnimation", "scale", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateBeautyConfig", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "updateDrawSize", "width", "height", "updateFilterConfig", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "updateMirror", "isMirror", "updateMirrorMode", "updateScene", "scene", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.media.widget.camerarecordview.preview.b
{
  public static final d.a mVf;
  public h mRA;
  private final HandlerThread mVg;
  private MMHandler mVh;
  private c.b mVi;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a mVj;
  private EGLSurface mVk;
  private Object mVl;
  public g mVm;
  kotlin.g.a.a<ah> mVn;
  
  static
  {
    AppMethodBeat.i(247824);
    mVf = new d.a((byte)0);
    AppMethodBeat.o(247824);
  }
  
  public d()
  {
    AppMethodBeat.i(247731);
    HandlerThread localHandlerThread = com.tencent.threadpool.c.d.jw("MicroMsg.LiveCoreRender", 10);
    s.s(localHandlerThread, "createAboutMeidaThread(TAG, Thread.MAX_PRIORITY)");
    this.mVg = localHandlerThread;
    this.mVg.start();
    this.mVh = new MMHandler(this.mVg.getLooper());
    this.mVh.post(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(247731);
  }
  
  private static final void I(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(247751);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(247751);
  }
  
  private static final void a(final d paramd)
  {
    AppMethodBeat.i(247742);
    s.u(paramd, "this$0");
    int i = com.tencent.mm.cd.a.ms(MMApplicationContext.getContext());
    final int j = com.tencent.mm.cd.a.mt(MMApplicationContext.getContext());
    paramd.mVi = c.a.a(com.tencent.mm.media.util.c.nFs, null, 1, 1, null, 16);
    Object localObject = paramd.mRA;
    boolean bool;
    if (localObject == null) {
      bool = false;
    }
    for (;;)
    {
      paramd.mVm = new g(bool);
      localObject = paramd.mVm;
      s.checkNotNull(localObject);
      paramd.a((com.tencent.mm.media.j.a)localObject, bool);
      localObject = paramd.mVj;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).onSurfaceCreated(null, null);
      }
      localObject = paramd.mVj;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).a(0, (kotlin.g.a.a)new c(i, j, paramd));
      }
      AppMethodBeat.o(247742);
      return;
      localObject = ((h)localObject).mNB;
      if (localObject == null) {
        bool = false;
      } else {
        bool = ((f)localObject).mNk;
      }
    }
  }
  
  public final void H(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(247938);
    s.u(parama, "r");
    this.mVh.post(new d..ExternalSyntheticLambda1(parama));
    AppMethodBeat.o(247938);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(247853);
    H((kotlin.g.a.a)new h(this, parama));
    AppMethodBeat.o(247853);
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(247859);
    H((kotlin.g.a.a)new j(this, paramb));
    AppMethodBeat.o(247859);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(247847);
    s.u(parama, "renderer");
    Log.printInfoStack("MicroMsg.LiveCoreRender", s.X("setPreviewRenderer cpuCrop:", Boolean.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      com.tencent.mm.media.widget.camerarecordview.preview.a.a.a(locala, false, false, 3);
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((com.tencent.mm.media.widget.camerarecordview.preview.b)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((com.tencent.mm.media.widget.camerarecordview.preview.c)this))
    {
      this.mVj = locala;
      locala = this.mVj;
      if (locala != null) {
        locala.b(parama);
      }
      AppMethodBeat.o(247847);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(247871);
    s.u(paramb, "cameraConfig");
    Log.printInfoStack("MicroMsg.LiveCoreRender", s.X("updateCameraConfig:", paramb), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.a(paramb);
    }
    AppMethodBeat.o(247871);
  }
  
  public final int bgA()
  {
    AppMethodBeat.i(247975);
    Object localObject = this.mVm;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((g)localObject).mWa))
    {
      localObject = e.n.mLw;
      i = e.n.bdA();
      AppMethodBeat.o(247975);
      return i;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(247975);
    return i;
  }
  
  public final void bgw() {}
  
  public final void bgx()
  {
    AppMethodBeat.i(247911);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.bgx();
    }
    AppMethodBeat.o(247911);
  }
  
  public final void bgy()
  {
    AppMethodBeat.i(247927);
    H((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(247927);
  }
  
  public final ad bgz()
  {
    int j = 0;
    AppMethodBeat.i(247966);
    Object localObject = this.mVj;
    int i;
    if (localObject == null)
    {
      i = 0;
      localObject = this.mVj;
      if (localObject != null) {
        break label68;
      }
    }
    for (;;)
    {
      localObject = new ad(i, j);
      AppMethodBeat.o(247966);
      return localObject;
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).bul();
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((com.tencent.mm.media.g.d)localObject).width;
      break;
      label68:
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).bul();
      if (localObject != null) {
        j = ((com.tencent.mm.media.g.d)localObject).height;
      }
    }
  }
  
  public final void di(Object paramObject)
  {
    AppMethodBeat.i(247941);
    H((kotlin.g.a.a)new f(paramObject, this));
    AppMethodBeat.o(247941);
  }
  
  public final void ej(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(247864);
    H((kotlin.g.a.a)new i(paramInt1, paramInt2, this));
    AppMethodBeat.o(247864);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.mVi;
    if (localb == null) {
      return null;
    }
    return localb.eXL;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    AppMethodBeat.i(247905);
    Object localObject = this.mVj;
    if (localObject == null)
    {
      AppMethodBeat.o(247905);
      return null;
    }
    localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
    AppMethodBeat.o(247905);
    return localObject;
  }
  
  public final com.tencent.mm.media.g.d getPreviewTexture()
  {
    AppMethodBeat.i(247900);
    Object localObject = this.mVm;
    if (localObject == null)
    {
      AppMethodBeat.o(247900);
      return null;
    }
    localObject = ((g)localObject).bgF();
    AppMethodBeat.o(247900);
    return localObject;
  }
  
  public final void release()
  {
    AppMethodBeat.i(247919);
    Log.i("MicroMsg.LiveCoreRender", "release live render manager");
    H((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(247919);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(247933);
    H((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(247933);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(247946);
    g localg = this.mVm;
    if (localg != null) {
      localg.reset();
    }
    AppMethodBeat.o(247946);
  }
  
  public final void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, ah> paramb)
  {
    AppMethodBeat.i(247892);
    Log.printInfoStack("MicroMsg.LiveCoreRender", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.nKB = paramb;
    }
    AppMethodBeat.o(247892);
  }
  
  public final void t(kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(247877);
    Object localObject1 = this.mVj;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture())
    {
      this.mVn = ((kotlin.g.a.a)new g(paramb, this));
      AppMethodBeat.o(247877);
      return;
    }
    if (paramb != null)
    {
      localObject1 = this.mVj;
      if (localObject1 == null)
      {
        localObject1 = null;
        paramb.invoke(localObject1);
      }
    }
    else
    {
      paramb = this.mVj;
      if (paramb != null) {
        break label119;
      }
    }
    label119:
    for (paramb = localObject2;; paramb = paramb.getSurfaceTexture())
    {
      Log.printInfoStack("MicroMsg.LiveCoreRender", s.X("tryCameraPreview  ", paramb), new Object[0]);
      AppMethodBeat.o(247877);
      return;
      localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();
      break;
    }
  }
  
  public final void u(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(247954);
    g localg = this.mVm;
    if (localg != null) {
      localg.w(paramb);
    }
    AppMethodBeat.o(247954);
  }
  
  public final void v(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(247961);
    s.u(paramb, "listener");
    g localg = this.mVm;
    if (localg != null) {
      localg.mVY = paramb;
    }
    AppMethodBeat.o(247961);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(int paramInt1, int paramInt2, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(Object paramObject, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(kotlin.g.a.b<? super SurfaceTexture, ah> paramb, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(d paramd, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(int paramInt1, int paramInt2, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(d paramd, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    public k(d paramd, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class l
    extends u
    implements kotlin.g.a.a<ah>
  {
    public l(d paramd, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.b.d
 * JD-Core Version:    0.7.0.1
 */