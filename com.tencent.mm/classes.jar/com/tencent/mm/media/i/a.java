package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "blurBgBitmapProvider", "blurBgdBitmap", "continueZeroPtsFrameCount", "", "currentRenderPtsNs", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "drawInOnFrameAvailableLock", "Ljava/lang/Object;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "isFirstFrameAvailable", "isInitFinished", "isReleased", "lastFrameTimestamp", "lastPts", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "ptsStepUs", "releaseLock", "remuxStartTime", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getCurrentRenderPtsNs", "getEGLEnvironment", "getOutputSurface", "initForRemuxer", "canUseDrawInFrameAvailable", "width", "height", "startTime", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "initWithSurface", "waitNewFrame", "isDrawInOnFrameAvailable", "queue", "queueFirst", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "bitmap", "waitFistFrameAvailable", "blurBg", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setDrawBlurBgBitmapProvider", "setDrawInOnFrameAvailable", "draw", "setMirror", "mirror", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "setVideoFps", "fps", "updateDrawSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "mediaFormat", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a kWh;
  public final String TAG;
  private volatile boolean isReleased;
  private long kSy;
  private final HandlerThread kVN;
  private MMHandler kVO;
  public kotlin.g.a.b<? super Boolean, x> kVP;
  private boolean kVQ;
  private volatile boolean kVR;
  private final Object kVS;
  private kotlin.g.a.b<? super Long, Bitmap> kVT;
  Bitmap kVU;
  private kotlin.g.a.b<? super Long, Bitmap> kVV;
  private Bitmap kVW;
  private volatile boolean kVX;
  private final Object kVY;
  kotlin.g.a.a<x> kVZ;
  int kWa;
  private int kWb;
  private long kWc;
  volatile long kWd;
  private volatile boolean kWe;
  private long kWf;
  public com.tencent.mm.media.j.a kWg;
  c.b krl;
  Surface surface;
  private SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(93759);
    kWh = new a.a((byte)0);
    AppMethodBeat.o(93759);
  }
  
  public a(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(93758);
    this.kWg = parama;
    this.TAG = "MicroMsg.CodecInputSurface";
    this.kVN = d.im("CodecInputSurface_renderThread", 5);
    this.kVS = new Object();
    this.kVY = new Object();
    this.kWa = 33000000;
    this.kVN.start();
    parama = this.kVN;
    p.j(parama, "renderThread");
    this.kVO = new MMHandler(parama.getLooper());
    AppMethodBeat.o(93758);
  }
  
  private final void aUV()
  {
    AppMethodBeat.i(93754);
    this.surfaceTexture = this.kWg.getTexture();
    AppMethodBeat.o(93754);
  }
  
  private final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(93755);
    synchronized (this.kVY)
    {
      this.kVX = paramBoolean;
      Log.i(this.TAG, "setDrawInOnFrameAvailable:".concat(String.valueOf(paramBoolean)));
      x localx = x.aazN;
      AppMethodBeat.o(93755);
      return;
    }
  }
  
  public final void a(final long paramLong, Bitmap paramBitmap1, final Bitmap paramBitmap2)
  {
    AppMethodBeat.i(93744);
    j((kotlin.g.a.a)new f(this, true, paramLong, paramBitmap1, paramBitmap2));
    AppMethodBeat.o(93744);
  }
  
  public final void a(final Surface paramSurface, final EGLContext paramEGLContext, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(258932);
    p.k(paramSurface, "surface");
    this.surface = paramSurface;
    Log.i(this.TAG, hashCode() + " initWithSurface, eglContext:" + paramEGLContext + ", surface:" + paramSurface + ", waitNewFrame:false, callback:false");
    j((kotlin.g.a.a)new d(this, paramEGLContext, paramSurface, paramb));
    AppMethodBeat.o(258932);
  }
  
  public final void a(final Surface paramSurface, boolean paramBoolean, final int paramInt1, final int paramInt2, long paramLong, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(258933);
    this.surface = paramSurface;
    Log.i(this.TAG, hashCode() + " initForRemuxer, surface:" + paramSurface + ", callback:false, drawInOnFrameAvailable:" + this.kVX);
    if (!paramBoolean)
    {
      Log.i(this.TAG, "cannot use drawInFrameAvailable!");
      fD(false);
    }
    for (;;)
    {
      this.kWb = 0;
      this.kWc = paramLong;
      j((kotlin.g.a.a)new b(this, paramSurface, paramInt1, paramInt2, paramb));
      AppMethodBeat.o(258933);
      return;
      Log.i(this.TAG, "default use drawInFrameAvailable");
      fD(true);
    }
  }
  
  public final void a(final byte[] paramArrayOfByte, final long paramLong, kotlin.g.a.b<? super byte[], x> paramb)
  {
    AppMethodBeat.i(93746);
    p.k(paramArrayOfByte, "data");
    p.k(paramb, "inputCallback");
    Log.d(this.TAG, "ByteArray length : " + paramArrayOfByte.length);
    j((kotlin.g.a.a)new g(this, paramArrayOfByte, paramLong, paramb));
    AppMethodBeat.o(93746);
  }
  
  public final Surface aUU()
  {
    AppMethodBeat.i(93748);
    if (this.surfaceTexture == null) {
      aUV();
    }
    Surface localSurface = new Surface(this.surfaceTexture);
    AppMethodBeat.o(93748);
    return localSurface;
  }
  
  public final void dt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93749);
    this.kWg.du(paramInt1, paramInt2);
    AppMethodBeat.o(93749);
  }
  
  public final void dv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93750);
    this.kWg.dv(paramInt1, paramInt2);
    AppMethodBeat.o(93750);
  }
  
  public final void e(MediaFormat paramMediaFormat)
  {
    int j = 0;
    AppMethodBeat.i(93751);
    p.k(paramMediaFormat, "mediaFormat");
    Object localObject1 = this.kWg;
    p.k(paramMediaFormat, "format");
    Object localObject2;
    int m;
    int k;
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGa, true))
    {
      if ((paramMediaFormat.containsKey("width")) && (paramMediaFormat.containsKey("height")))
      {
        ((com.tencent.mm.media.j.a)localObject1).krg = paramMediaFormat.getInteger("width");
        ((com.tencent.mm.media.j.a)localObject1).krh = paramMediaFormat.getInteger("height");
        localObject2 = ((com.tencent.mm.media.j.a)localObject1).kYb;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.a)localObject2).dv(((com.tencent.mm.media.j.a)localObject1).krg, ((com.tencent.mm.media.j.a)localObject1).krh);
        }
      }
      m = ((com.tencent.mm.media.j.a)localObject1).krh;
      k = ((com.tencent.mm.media.j.a)localObject1).krg;
      if (!paramMediaFormat.containsKey("crop-left")) {
        break label375;
      }
    }
    label375:
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
      Log.i("MicroMsg.Media.AbsSurfaceRenderer", "updateTextureSizeByMediaFormat:textureWidth->" + ((com.tencent.mm.media.j.a)localObject1).krg + " textureHeight->" + ((com.tencent.mm.media.j.a)localObject1).krh + " validLeft->" + i + " validTop->" + m + " validRight->" + k + "  validBottom -> " + j);
      paramMediaFormat = ((com.tencent.mm.media.j.a)localObject1).kYb;
      if (paramMediaFormat != null)
      {
        localObject1 = new Point(i, m + 1);
        localObject2 = new Point(k + 1, j);
        p.k(localObject1, "leftTop");
        p.k(localObject2, "rightBottom");
        paramMediaFormat.kYN = ((Point)localObject1);
        paramMediaFormat.kYO = ((Point)localObject2);
        AppMethodBeat.o(93751);
        return;
      }
      AppMethodBeat.o(93751);
      return;
    }
  }
  
  public final void i(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93742);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      Log.i(str, i);
      this.kVT = paramb;
      AppMethodBeat.o(93742);
      return;
    }
  }
  
  public final void j(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(93753);
    synchronized (this.kVS)
    {
      HandlerThread localHandlerThread = this.kVN;
      p.j(localHandlerThread, "renderThread");
      if ((localHandlerThread.isAlive()) && (!this.isReleased))
      {
        this.kVO.post((Runnable)new b(parama));
        AppMethodBeat.o(93753);
        return;
      }
      Log.e(this.TAG, hashCode() + " queue already release");
      parama = x.aazN;
    }
  }
  
  public final void j(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93743);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlurBgBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      Log.i(str, i);
      this.kVV = paramb;
      AppMethodBeat.o(93743);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(93756);
    Log.i(this.TAG, hashCode() + " release resources");
    Object localObject2 = (kotlin.g.a.a)new e(this);
    for (;;)
    {
      synchronized (this.kVS)
      {
        HandlerThread localHandlerThread = this.kVN;
        p.j(localHandlerThread, "renderThread");
        if ((localHandlerThread.isAlive()) && (!this.isReleased))
        {
          this.kVO.removeCallbacksAndMessages(null);
          this.kVO.post((Runnable)new b((kotlin.g.a.a)localObject2));
        }
      }
      synchronized (this.kVS)
      {
        this.isReleased = true;
        this.kWe = false;
        localObject2 = x.aazN;
        AppMethodBeat.o(93756);
        return;
        Log.e(this.TAG, hashCode() + " queueFirst already release");
        localObject2 = x.aazN;
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
    Object localObject = this.krl;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).las, ((c.b)localObject).eglSurface, paramLong);
    }
    this.kWd = paramLong;
    localObject = c.lar;
    c.a.OB("eglPresentationTimeANDROID");
    AppMethodBeat.o(93757);
  }
  
  public final void tm(int paramInt)
  {
    AppMethodBeat.i(93752);
    this.kWg.tm(paramInt);
    AppMethodBeat.o(93752);
  }
  
  public final void x(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(93747);
    j((kotlin.g.a.a)new h(this, paramInt, paramLong));
    AppMethodBeat.o(93747);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(a parama, Surface paramSurface, int paramInt1, int paramInt2, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public c(a parama, EGLContext paramEGLContext, int paramInt1, int paramInt2, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(a parama, EGLContext paramEGLContext, Surface paramSurface, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(a parama, boolean paramBoolean, long paramLong, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(a parama, byte[] paramArrayOfByte, long paramLong, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(a parama, int paramInt, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    public i(a parama, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class k
    implements SurfaceTexture.OnFrameAvailableListener
  {
    k(a parama) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(93740);
      Object localObject1 = a.d(this.kWi);
      Object localObject2 = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
      paramSurfaceTexture = a.h(this.kWi);
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp());
        Log.i((String)localObject1, paramSurfaceTexture + ", drawInOnFrameAvailable:" + a.i(this.kWi));
        localObject1 = a.h(this.kWi);
        if (localObject1 == null) {
          break label428;
        }
        if (((SurfaceTexture)localObject1).getTimestamp() > 0L) {
          break label216;
        }
        paramSurfaceTexture = this.kWi;
        a.a(paramSurfaceTexture, a.k(paramSurfaceTexture) + 1);
      }
      for (;;)
      {
        if ((a.f(this.kWi)) && (((SurfaceTexture)localObject1).getTimestamp() <= 0L))
        {
          Log.i(a.d(this.kWi), "first frame available and new timestamp still zero!!");
          if (a.k(this.kWi) < 3) {
            break label245;
          }
          Log.i(a.d(this.kWi), "continue 3 frames pts is zero!!!");
          a.j(this.kWi);
          paramSurfaceTexture = a.l(this.kWi);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture.invoke();
            AppMethodBeat.o(93740);
            return;
            paramSurfaceTexture = null;
            break;
            label216:
            a.a(this.kWi, 0);
            continue;
          }
          AppMethodBeat.o(93740);
          return;
        }
      }
      a.a(this.kWi, ((SurfaceTexture)localObject1).getTimestamp());
      label245:
      if (!a.f(this.kWi)) {
        a.g(this.kWi);
      }
      long l;
      if (a.i(this.kWi))
      {
        if (a.n(this.kWi) == null) {
          break label328;
        }
        localObject2 = this.kWi;
        l = a.m(this.kWi);
        paramSurfaceTexture = a.n(this.kWi);
        localObject1 = a.o(this.kWi);
      }
      for (;;)
      {
        a.a((a)localObject2, l, paramSurfaceTexture, (Bitmap)localObject1);
        AppMethodBeat.o(93740);
        return;
        label328:
        localObject2 = this.kWi;
        l = a.m(this.kWi);
        paramSurfaceTexture = a.p(this.kWi);
        if (paramSurfaceTexture != null) {}
        for (paramSurfaceTexture = (Bitmap)paramSurfaceTexture.invoke(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));; paramSurfaceTexture = null)
        {
          kotlin.g.a.b localb = a.q(this.kWi);
          if (localb == null) {
            break label422;
          }
          localObject1 = (Bitmap)localb.invoke(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));
          break;
        }
        label422:
        localObject1 = null;
      }
      label428:
      AppMethodBeat.o(93740);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.i.a
 * JD-Core Version:    0.7.0.1
 */