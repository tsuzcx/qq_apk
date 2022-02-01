package com.tencent.mm.plugin.cast.e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.c;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.cast.PluginCast;
import com.tencent.mm.plugin.cast.PluginCast.a;
import com.tencent.mm.plugin.cast.h.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/render/ScreenCastRenderer;", "", "width", "", "height", "fps", "(III)V", "<set-?>", "Landroid/view/Surface;", "decodeSurface", "getDecodeSurface", "()Landroid/view/Surface;", "eEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "firstFrameCost", "", "getFirstFrameCost", "()J", "setFirstFrameCost", "(J)V", "getFps", "()I", "setFps", "(I)V", "getHeight", "setHeight", "isUseOpenGLRenderer", "", "mEGLRenderer", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "mFrameAvailable", "mImageReader", "Lcom/tencent/mm/plugin/cast/render/ScreenCastImageReader;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mTimerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onScreenCallBack", "Lcom/tencent/mm/plugin/cast/render/ScreenCastRenderer$OnScreenCallBack;", "renderCostAvg", "getRenderCostAvg", "setRenderCostAvg", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderHandlerThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "surface", "getWidth", "setWidth", "eglSetup", "", "initGLContext", "makeEGLCurrent", "queue", "callback", "Lkotlin/Function0;", "release", "renderImage", "saveScreenShot", "setInputSurface", "setOnScreenCallBack", "setup", "swapBuffers", "updateTexImage", "Companion", "OnScreenCallBack", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a wNl;
  public MTimerHandler eln;
  private int fps;
  public int height;
  private volatile boolean mFrameAvailable;
  public SurfaceTexture mSurfaceTexture;
  public HandlerThread mVE;
  public Surface mVI;
  public c.b mVJ;
  public MMHandler nBk;
  public Surface surface;
  public b wNm;
  public a wNn;
  public c wNo;
  public boolean wNp;
  public long wNq;
  long wNr;
  public int width;
  
  static
  {
    AppMethodBeat.i(274105);
    wNl = new b.a((byte)0);
    AppMethodBeat.o(274105);
  }
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(274081);
    this.width = paramInt1;
    this.height = paramInt2;
    this.fps = paramInt3;
    this.mVE = com.tencent.threadpool.c.d.jy(s.X("MicroMsg.ScreenCastRenderMgr", Integer.valueOf(hashCode())), 10);
    e locale = e.wOn;
    this.wNp = e.dpJ();
    this.mVE.start();
    this.nBk = new MMHandler(this.mVE.getLooper());
    this.wNq = -1L;
    this.wNr = -1L;
    this.eln = new MTimerHandler("ScreenCastRenderTimer", new b..ExternalSyntheticLambda1(this), true);
    AppMethodBeat.o(274081);
  }
  
  private static final void J(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(274091);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(274091);
  }
  
  private static final void a(b paramb, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(274085);
    s.u(paramb, "this$0");
    paramb.mFrameAvailable = true;
    AppMethodBeat.o(274085);
  }
  
  private static final boolean a(b paramb)
  {
    AppMethodBeat.i(274098);
    s.u(paramb, "this$0");
    paramb.K((kotlin.g.a.a)new c(paramb));
    AppMethodBeat.o(274098);
    return true;
  }
  
  public final void K(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(274138);
    s.u(parama, "callback");
    if (this.mVE.isAlive())
    {
      this.nBk.post(new b..ExternalSyntheticLambda2(parama));
      AppMethodBeat.o(274138);
      return;
    }
    Log.e("MicroMsg.ScreenCastRenderMgr", "queue in error");
    AppMethodBeat.o(274138);
  }
  
  public final void bgC()
  {
    int j = 0;
    for (;;)
    {
      long l1;
      try
      {
        AppMethodBeat.i(274154);
        boolean bool = this.wNp;
        if (!bool) {
          break label340;
        }
        try
        {
          l1 = Util.currentTicks();
          if (this.mFrameAvailable) {
            this.mFrameAvailable = false;
          }
        }
        catch (Exception localException2)
        {
          Object localObject1;
          int i;
          Log.e("MicroMsg.ScreenCastRenderMgr", s.X("render error in ", localException2));
          AppMethodBeat.o(274154);
          continue;
        }
        try
        {
          localObject1 = this.mSurfaceTexture;
          if (localObject1 != null) {
            ((SurfaceTexture)localObject1).updateTexImage();
          }
        }
        catch (Exception localException1)
        {
          Log.i("MicroMsg.ScreenCastRenderMgr", "render Image update");
          continue;
        }
        localObject1 = this.mVJ;
        if ((localObject1 != null) && (!EGL14.eglMakeCurrent(((c.b)localObject1).nFB, ((c.b)localObject1).eglSurface, ((c.b)localObject1).eglSurface, ((c.b)localObject1).eXL))) {
          Log.e("MicroMsg.ScreenCastRenderMgr", "makeEGLCurrent faild ");
        }
        localObject1 = this.wNo;
        if (localObject1 != null) {
          ((c)localObject1).bgE();
        }
        localObject1 = this.mVJ;
        if (localObject1 != null) {
          EGL14.eglSwapBuffers(((c.b)localObject1).nFB, ((c.b)localObject1).eglSurface);
        }
        if (this.wNq == -1L)
        {
          this.wNq = Util.ticksToNow(l1);
          localObject1 = PluginCast.wLM;
          localObject1 = PluginCast.a.dpb();
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.cast.c.a)localObject1).wMX = this.wNq;
          }
          localObject1 = PluginCast.wLM;
          localObject1 = PluginCast.a.dpb();
          i = j;
          if (localObject1 != null)
          {
            i = j;
            if (((com.tencent.mm.plugin.cast.c.a)localObject1).wMV == -1L) {
              i = 1;
            }
          }
          if (i == 0) {
            break label499;
          }
          this.wNr = Util.ticksToNow(this.wNr);
          localObject1 = PluginCast.wLM;
          localObject1 = PluginCast.a.dpb();
          if (localObject1 == null) {
            break label499;
          }
          ((com.tencent.mm.plugin.cast.c.a)localObject1).wMV = this.wNr;
          AppMethodBeat.o(274154);
          return;
        }
      }
      finally {}
      long l2 = this.wNq;
      this.wNq = (Util.ticksToNow(l1) + l2);
      this.wNq /= 2L;
      continue;
      label340:
      Object localObject4 = this.wNn;
      if (localObject4 != null) {
        synchronized (((a)localObject4).lock)
        {
          Surface localSurface = ((a)localObject4).wNj;
          Bitmap localBitmap;
          if (localSurface != null)
          {
            localBitmap = ((a)localObject4).wNk;
            if (localBitmap == null) {}
          }
          try
          {
            if ((localSurface.isValid()) && (((a)localObject4).imageReader != null))
            {
              Canvas localCanvas = localSurface.lockCanvas(null);
              s.s(localCanvas, "surface.lockCanvas(null)");
              localCanvas.drawColor(-16777216);
              localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, ((a)localObject4).paint);
              localSurface.unlockCanvasAndPost(localCanvas);
            }
            localObject4 = ah.aiuX;
            AppMethodBeat.o(274154);
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              Log.e("MicroMsg.ScreenCastImageReader", s.X("error happened ", localException3.fillInStackTrace()));
            }
          }
        }
      } else {
        label499:
        AppMethodBeat.o(274154);
      }
    }
  }
  
  public final void setup()
  {
    AppMethodBeat.i(274129);
    Object localObject1;
    Object localObject2;
    if (this.wNp)
    {
      this.wNo = new c(this.width, this.height, 0, 0, 0, 0, 60);
      localObject1 = new com.tencent.mm.media.g.d(false, 20L);
      localObject2 = this.wNo;
      if (localObject2 != null) {
        ((c)localObject2).nEx = ((com.tencent.mm.media.g.d)localObject1).nAF;
      }
      this.mSurfaceTexture = new SurfaceTexture(((com.tencent.mm.media.g.d)localObject1).nAF);
      localObject1 = this.mSurfaceTexture;
      if (localObject1 != null) {
        ((SurfaceTexture)localObject1).setDefaultBufferSize(this.width, this.height);
      }
      localObject1 = this.mSurfaceTexture;
      if (localObject1 != null) {
        ((SurfaceTexture)localObject1).setOnFrameAvailableListener(new b..ExternalSyntheticLambda0(this));
      }
      localObject1 = new Surface(this.mSurfaceTexture);
    }
    for (;;)
    {
      this.mVI = ((Surface)localObject1);
      localObject1 = this.mVI;
      if (localObject1 != null)
      {
        localObject2 = this.wNm;
        if (localObject2 != null) {
          ((b)localObject2).o((Surface)localObject1);
        }
        this.eln.startTimer(1000L / this.fps);
      }
      AppMethodBeat.o(274129);
      return;
      this.wNn = new a(this.width, this.height);
      localObject1 = this.wNn;
      if (localObject1 != null)
      {
        localObject2 = this.nBk.getLooper();
        s.s(localObject2, "renderHandler.looper");
        ((a)localObject1).i((Looper)localObject2);
      }
      localObject1 = this.wNn;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((a)localObject1).inputSurface;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/render/ScreenCastRenderer$OnScreenCallBack;", "", "onCutScreen", "", "bitmap", "Landroid/graphics/Bitmap;", "onScreenFrameUpdate", "onScreenInfo", "bytes", "", "onSurfaceReady", "surface", "Landroid/view/Surface;", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void dpi();
    
    public abstract void o(Surface paramSurface);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.e.b
 * JD-Core Version:    0.7.0.1
 */