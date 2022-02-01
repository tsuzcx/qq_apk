package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.c.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "blurBgBitmapProvider", "blurBgdBitmap", "continueZeroPtsFrameCount", "", "currentRenderPtsNs", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "drawInOnFrameAvailableLock", "Ljava/lang/Object;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "isFirstFrameAvailable", "isInitFinished", "isReleased", "lastFrameTimestamp", "lastPts", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "ptsStepUs", "releaseLock", "remuxStartTime", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getCurrentRenderPtsNs", "getEGLEnvironment", "getOutputSurface", "initForRemuxer", "canUseDrawInFrameAvailable", "width", "height", "startTime", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "initWithSurface", "waitNewFrame", "isDrawInOnFrameAvailable", "queue", "queueFirst", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "waitTextureFinished", "bitmap", "waitFistFrameAvailable", "blurBg", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setDrawBlurBgBitmapProvider", "setDrawInOnFrameAvailable", "draw", "setMirror", "mirror", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "setVideoFps", "fps", "updateDrawSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "mediaFormat", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a nBi;
  final String TAG;
  private volatile boolean isInitFinished;
  private volatile boolean isReleased;
  c.b mVi;
  private long nBA;
  public com.tencent.mm.media.j.a nBj;
  private MMHandler nBk;
  public kotlin.g.a.b<? super Boolean, ah> nBl;
  private boolean nBm;
  private volatile boolean nBn;
  private final Object nBo;
  private kotlin.g.a.b<? super Long, Bitmap> nBp;
  Bitmap nBq;
  private kotlin.g.a.b<? super Long, Bitmap> nBr;
  private Bitmap nBs;
  private volatile boolean nBt;
  private final Object nBu;
  kotlin.g.a.a<ah> nBv;
  int nBw;
  private int nBx;
  private long nBy;
  volatile long nBz;
  private final HandlerThread nty;
  private long nyj;
  Surface surface;
  private SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(93759);
    nBi = new a.a((byte)0);
    AppMethodBeat.o(93759);
  }
  
  public a(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(93758);
    this.nBj = parama;
    this.TAG = "MicroMsg.CodecInputSurface";
    this.nty = d.jy("CodecInputSurface_renderThread", 5);
    this.nBo = new Object();
    this.nBu = new Object();
    this.nBw = 33000000;
    this.nty.start();
    this.nBk = new MMHandler(this.nty.getLooper());
    AppMethodBeat.o(93758);
  }
  
  private void K(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(93753);
    synchronized (this.nBo)
    {
      if ((this.nty.isAlive()) && (!this.isReleased))
      {
        this.nBk.post(new a..ExternalSyntheticLambda2(parama));
        AppMethodBeat.o(93753);
        return;
      }
      Log.e(this.TAG, hashCode() + " queue already release");
      parama = ah.aiuX;
    }
  }
  
  private static final void Y(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(237821);
    parama.invoke();
    AppMethodBeat.o(237821);
  }
  
  private static final void Z(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(237824);
    parama.invoke();
    AppMethodBeat.o(237824);
  }
  
  private static final void a(a parama, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(237835);
    s.u(parama, "this$0");
    Object localObject1 = parama.TAG;
    Object localObject2 = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
    paramSurfaceTexture = parama.surfaceTexture;
    if (paramSurfaceTexture == null)
    {
      paramSurfaceTexture = null;
      Log.i((String)localObject1, paramSurfaceTexture + ", drawInOnFrameAvailable:" + parama.nBt);
      localObject1 = parama.surfaceTexture;
      if (localObject1 == null) {
        break label317;
      }
      if (((SurfaceTexture)localObject1).getTimestamp() > 0L) {
        break label196;
      }
    }
    label196:
    for (parama.nBx += 1;; parama.nBx = 0)
    {
      if ((!parama.nBn) || (((SurfaceTexture)localObject1).getTimestamp() > 0L)) {
        break label204;
      }
      Log.i(parama.TAG, "first frame available and new timestamp still zero!!");
      if (parama.nBx < 3) {
        break label213;
      }
      Log.i(parama.TAG, "continue 3 frames pts is zero!!!");
      parama.nBt = false;
      parama = parama.nBv;
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(237835);
      return;
      paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp());
      break;
    }
    label204:
    parama.nyj = ((SurfaceTexture)localObject1).getTimestamp();
    label213:
    if (!parama.nBn) {
      parama.nBn = true;
    }
    long l1;
    if (parama.nBt)
    {
      if (parama.nBq == null) {
        break label324;
      }
      l1 = parama.nyj;
      localObject1 = parama.nBq;
      paramSurfaceTexture = parama.nBs;
    }
    for (;;)
    {
      try
      {
        if (parama.isInitFinished) {
          break;
        }
        Log.e(parama.TAG, "requestDraw not init now");
        AppMethodBeat.o(237835);
        return;
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.printErrStackTrace(parama.TAG, (Throwable)paramSurfaceTexture, "", new Object[0]);
        parama = parama.nBl;
        if (parama != null) {
          parama.invoke(Boolean.FALSE);
        }
      }
      label317:
      AppMethodBeat.o(237835);
      return;
      label324:
      l1 = parama.nyj;
      paramSurfaceTexture = parama.nBp;
      if (paramSurfaceTexture == null) {}
      for (paramSurfaceTexture = null;; paramSurfaceTexture = (Bitmap)paramSurfaceTexture.invoke(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L)))
      {
        localObject2 = parama.nBr;
        if (localObject2 != null) {
          break label388;
        }
        localObject2 = null;
        localObject1 = paramSurfaceTexture;
        paramSurfaceTexture = (SurfaceTexture)localObject2;
        break;
      }
      label388:
      localObject2 = (Bitmap)((kotlin.g.a.b)localObject2).invoke(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));
      localObject1 = paramSurfaceTexture;
      paramSurfaceTexture = (SurfaceTexture)localObject2;
    }
    Log.i(parama.TAG, s.X("render pts:", Long.valueOf(l1)));
    long l2 = Util.currentTicks();
    if ((parama.nBj instanceof com.tencent.mm.media.j.b)) {
      ((com.tencent.mm.media.j.b)parama.nBj).b((Bitmap)localObject1, paramSurfaceTexture);
    }
    localObject1 = parama.TAG;
    localObject2 = new StringBuilder("render cost ").append(Util.ticksToNow(l2)).append(", surface timestamp:");
    paramSurfaceTexture = parama.surfaceTexture;
    if (paramSurfaceTexture == null)
    {
      paramSurfaceTexture = null;
      Log.d((String)localObject1, paramSurfaceTexture + ", lastFrameTimestamp:" + parama.nBA);
      if ((parama.surfaceTexture == null) || (!parama.nBn)) {
        break label641;
      }
      l2 = parama.nBA;
      paramSurfaceTexture = parama.surfaceTexture;
      if (paramSurfaceTexture != null) {
        break label630;
      }
    }
    label630:
    for (paramSurfaceTexture = null;; paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp()))
    {
      s.checkNotNull(paramSurfaceTexture);
      if (l2 <= paramSurfaceTexture.longValue()) {
        break label641;
      }
      Log.e(parama.TAG, "not stickily monotonic increase timestamp");
      parama.nBt = false;
      paramSurfaceTexture = parama.nBv;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.invoke();
      }
      AppMethodBeat.o(237835);
      return;
      paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp());
      break;
    }
    label641:
    paramSurfaceTexture = parama.surfaceTexture;
    long l3;
    if (paramSurfaceTexture == null)
    {
      l2 = 0L;
      parama.nBz = l2;
      l3 = Util.currentTicks();
      if (parama.surfaceTexture == null) {
        break label878;
      }
      paramSurfaceTexture = parama.surfaceTexture;
      if (paramSurfaceTexture != null) {
        break label867;
      }
      paramSurfaceTexture = null;
      label682:
      s.checkNotNull(paramSurfaceTexture);
      l2 = paramSurfaceTexture.longValue();
      long l4 = parama.nBA;
      paramSurfaceTexture = parama.surfaceTexture;
      if ((paramSurfaceTexture == null) || (l4 != paramSurfaceTexture.getTimestamp())) {
        break label918;
      }
    }
    label918:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i(parama.TAG, "same frame timestamp!!");
        l2 = l1;
      }
      parama.nBA = l2;
      if (parama.surface != null)
      {
        l1 = l2;
        if (parama.nBy > 0L) {
          l1 = l2 - parama.nBy * 1000000L;
        }
        parama.setPresentationTime(l1);
      }
      for (;;)
      {
        if (parama.surface != null)
        {
          paramSurfaceTexture = parama.mVi;
          if (paramSurfaceTexture != null)
          {
            localObject1 = com.tencent.mm.media.util.c.nFs;
            com.tencent.mm.media.util.c.a.a(paramSurfaceTexture.nFB, paramSurfaceTexture.eglSurface);
          }
        }
        Log.d(parama.TAG, s.X("swap buffer cost ", Long.valueOf(Util.ticksToNow(l3))));
        paramSurfaceTexture = parama.nBl;
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.invoke(Boolean.TRUE);
        }
        AppMethodBeat.o(237835);
        return;
        l2 = paramSurfaceTexture.getTimestamp();
        break;
        label867:
        paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp());
        break label682;
        label878:
        if (parama.surface != null)
        {
          l2 = l1;
          if (parama.nBy > 0L) {
            l2 = l1 - parama.nBy * 1000000L;
          }
          parama.setPresentationTime(l2);
        }
      }
    }
  }
  
  private final void bpD()
  {
    AppMethodBeat.i(93754);
    this.surfaceTexture = this.nBj.bpL();
    AppMethodBeat.o(93754);
  }
  
  private final void gn(boolean paramBoolean)
  {
    AppMethodBeat.i(93755);
    synchronized (this.nBu)
    {
      this.nBt = paramBoolean;
      Log.i(this.TAG, s.X("setDrawInOnFrameAvailable:", Boolean.valueOf(paramBoolean)));
      ah localah = ah.aiuX;
      AppMethodBeat.o(93755);
      return;
    }
  }
  
  public final void C(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93742);
    String str = this.TAG;
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      Log.i(str, s.X("setDrawBlendBitmapProvider:", Integer.valueOf(i)));
      this.nBp = paramb;
      AppMethodBeat.o(93742);
      return;
    }
  }
  
  public final void D(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93743);
    String str = this.TAG;
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      Log.i(str, s.X("setDrawBlurBgBitmapProvider:", Integer.valueOf(i)));
      this.nBr = paramb;
      AppMethodBeat.o(93743);
      return;
    }
  }
  
  public final void X(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(237962);
    s.u(parama, "callback");
    K((kotlin.g.a.a)new a.j(parama));
    AppMethodBeat.o(237962);
  }
  
  public final void a(final int paramInt, final long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(237907);
    K((kotlin.g.a.a)new h(this, paramInt, paramBoolean, paramLong));
    AppMethodBeat.o(237907);
  }
  
  public final void a(final long paramLong, Bitmap paramBitmap1, final Bitmap paramBitmap2)
  {
    AppMethodBeat.i(93744);
    K((kotlin.g.a.a)new f(this, true, paramLong, paramBitmap1, paramBitmap2));
    AppMethodBeat.o(93744);
  }
  
  public final void a(EGLContext paramEGLContext, final int paramInt1, final int paramInt2, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(237886);
    Log.i(this.TAG, hashCode() + " initWithSize, eglContext: " + paramEGLContext + ", callback: false, width:" + paramInt1 + ", height:" + paramInt2);
    K((kotlin.g.a.a)new c(paramEGLContext, this, paramInt1, paramInt2, paramb));
    AppMethodBeat.o(237886);
  }
  
  public final void a(final Surface paramSurface, EGLContext paramEGLContext, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(237876);
    s.u(paramSurface, "surface");
    this.surface = paramSurface;
    Log.i(this.TAG, hashCode() + " initWithSurface, eglContext:" + paramEGLContext + ", surface:" + paramSurface + ", waitNewFrame:false, callback:false");
    K((kotlin.g.a.a)new d(paramEGLContext, this, paramSurface, paramb));
    AppMethodBeat.o(237876);
  }
  
  public final void a(final Surface paramSurface, boolean paramBoolean, final int paramInt1, final int paramInt2, long paramLong, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(237882);
    this.surface = paramSurface;
    Log.i(this.TAG, hashCode() + " initForRemuxer, surface:" + paramSurface + ", callback:false, drawInOnFrameAvailable:" + this.nBt);
    if (!paramBoolean)
    {
      Log.i(this.TAG, "cannot use drawInFrameAvailable!");
      gn(false);
    }
    for (;;)
    {
      this.nBx = 0;
      this.nBy = paramLong;
      K((kotlin.g.a.a)new b(this, paramSurface, paramInt1, paramInt2, paramb));
      AppMethodBeat.o(237882);
      return;
      Log.i(this.TAG, "default use drawInFrameAvailable");
      gn(true);
    }
  }
  
  public final void a(final byte[] paramArrayOfByte, final long paramLong, kotlin.g.a.b<? super byte[], ah> paramb)
  {
    AppMethodBeat.i(93746);
    s.u(paramArrayOfByte, "data");
    s.u(paramb, "inputCallback");
    Log.d(this.TAG, s.X("ByteArray length : ", Integer.valueOf(paramArrayOfByte.length)));
    K((kotlin.g.a.a)new g(this, paramArrayOfByte, paramLong, paramb));
    AppMethodBeat.o(93746);
  }
  
  public final void e(MediaFormat paramMediaFormat)
  {
    int j = 0;
    AppMethodBeat.i(93751);
    s.u(paramMediaFormat, "mediaFormat");
    Object localObject1 = this.nBj;
    s.u(paramMediaFormat, "format");
    Object localObject2;
    int m;
    int k;
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVF, true))
    {
      if ((paramMediaFormat.containsKey("width")) && (paramMediaFormat.containsKey("height")))
      {
        ((com.tencent.mm.media.j.a)localObject1).mVd = paramMediaFormat.getInteger("width");
        ((com.tencent.mm.media.j.a)localObject1).mVe = paramMediaFormat.getInteger("height");
        localObject2 = ((com.tencent.mm.media.j.a)localObject1).nDm;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.a)localObject2).el(((com.tencent.mm.media.j.a)localObject1).mVd, ((com.tencent.mm.media.j.a)localObject1).mVe);
        }
      }
      m = ((com.tencent.mm.media.j.a)localObject1).mVe;
      k = ((com.tencent.mm.media.j.a)localObject1).mVd;
      if (!paramMediaFormat.containsKey("crop-left")) {
        break label368;
      }
    }
    label368:
    for (int i = paramMediaFormat.getInteger("crop-left");; i = 0)
    {
      if (paramMediaFormat.containsKey("crop-top")) {
        j = paramMediaFormat.getInteger("crop-top");
      }
      if (paramMediaFormat.containsKey("crop-right")) {
        k = paramMediaFormat.getInteger("crop-right") + 1;
      }
      if (paramMediaFormat.containsKey("crop-bottom")) {
        m = paramMediaFormat.getInteger("crop-bottom") + 1;
      }
      Log.i("MicroMsg.Media.AbsSurfaceRenderer", "updateTextureSizeByMediaFormat:textureWidth->" + ((com.tencent.mm.media.j.a)localObject1).mVd + " textureHeight->" + ((com.tencent.mm.media.j.a)localObject1).mVe + " validLeft->" + i + " validTop->" + m + " validRight->" + k + "  validBottom -> " + j);
      paramMediaFormat = ((com.tencent.mm.media.j.a)localObject1).nDm;
      if (paramMediaFormat != null)
      {
        localObject1 = new Point(i, m + 1);
        localObject2 = new Point(k + 1, j);
        s.u(localObject1, "leftTop");
        s.u(localObject2, "rightBottom");
        paramMediaFormat.nDV = ((Point)localObject1);
        paramMediaFormat.nDW = ((Point)localObject2);
      }
      AppMethodBeat.o(93751);
      return;
    }
  }
  
  public final void ej(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93749);
    this.nBj.ek(paramInt1, paramInt2);
    AppMethodBeat.o(93749);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93750);
    this.nBj.el(paramInt1, paramInt2);
    AppMethodBeat.o(93750);
  }
  
  public final void g(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(237909);
    s.u(paramSurfaceTexture, "surfaceTexture");
    K((kotlin.g.a.a)new i(this, paramSurfaceTexture));
    AppMethodBeat.o(237909);
  }
  
  public final Surface getOutputSurface()
  {
    AppMethodBeat.i(93748);
    if (this.surfaceTexture == null) {
      bpD();
    }
    Surface localSurface = new Surface(this.surfaceTexture);
    AppMethodBeat.o(93748);
    return localSurface;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93756);
    Log.i(this.TAG, hashCode() + " release resources");
    Object localObject2 = (kotlin.g.a.a)new e(this);
    for (;;)
    {
      synchronized (this.nBo)
      {
        if ((this.nty.isAlive()) && (!this.isReleased))
        {
          this.nBk.removeCallbacksAndMessages(null);
          this.nBk.post(new a..ExternalSyntheticLambda1((kotlin.g.a.a)localObject2));
        }
      }
      synchronized (this.nBo)
      {
        this.isReleased = true;
        this.isInitFinished = false;
        localObject2 = ah.aiuX;
        AppMethodBeat.o(93756);
        return;
        Log.e(this.TAG, hashCode() + " queueFirst already release");
        localObject2 = ah.aiuX;
        continue;
        localObject3 = finally;
        AppMethodBeat.o(93756);
        throw localObject3;
      }
    }
  }
  
  protected final void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(93757);
    Object localObject = this.mVi;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).nFB, ((c.b)localObject).eglSurface, paramLong);
    }
    this.nBz = paramLong;
    localObject = com.tencent.mm.media.util.c.nFs;
    com.tencent.mm.media.util.c.a.GR("eglPresentationTimeANDROID");
    AppMethodBeat.o(93757);
  }
  
  public final void th(int paramInt)
  {
    AppMethodBeat.i(93752);
    this.nBj.th(paramInt);
    AppMethodBeat.o(93752);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama, Surface paramSurface, int paramInt1, int paramInt2, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(EGLContext paramEGLContext, a parama, int paramInt1, int paramInt2, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(EGLContext paramEGLContext, a parama, Surface paramSurface, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(a parama, boolean paramBoolean, long paramLong, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(a parama, byte[] paramArrayOfByte, long paramLong, kotlin.g.a.b<? super byte[], ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(a parama, int paramInt, boolean paramBoolean, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(a parama, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.i.a
 * JD-Core Version:    0.7.0.1
 */