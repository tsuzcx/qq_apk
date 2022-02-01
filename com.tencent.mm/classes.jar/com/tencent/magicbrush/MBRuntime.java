package com.tencent.magicbrush;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Keep;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.JsTouchEventHandler.a;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.utils.f;
import com.tencent.magicbrush.utils.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.FutureTask;
import kotlin.g.b.p;

public abstract class MBRuntime
{
  protected MBRuntime.MBParams cLM;
  private MBRuntime.a cLN = null;
  protected IMBFileSystem cLO = null;
  protected IMBFontHandler cLP = null;
  private com.tencent.magicbrush.handler.b cLQ = null;
  protected c cLR = null;
  public volatile com.tencent.magicbrush.handler.c cLS;
  protected com.tencent.magicbrush.ui.a cLT;
  private int cLU = 0;
  protected BaseImageDecodeService csB = null;
  public d cwf = new d(this);
  protected volatile long mNativeInst;
  
  static
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "enter static block", new Object[0]);
    com.tencent.magicbrush.a.b.loadLibraries();
  }
  
  private void UU()
  {
    if (this.cLM.device_pixel_ratio_ <= 0.0F) {
      throw new IllegalStateException("device pixel ratio is null");
    }
  }
  
  private static void jm(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("windowId < 0");
    }
  }
  
  private boolean n(final Runnable paramRunnable)
  {
    if (this.mNativeInst == 0L) {}
    com.tencent.magicbrush.handler.c localc;
    do
    {
      return false;
      localc = this.cLS;
    } while (localc == null);
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139943);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          AppMethodBeat.o(139943);
          return;
        }
        paramRunnable.run();
        AppMethodBeat.o(139943);
      }
    }, true);
    return true;
  }
  
  private native int[] nativeGetCanvasSize(long paramLong, int paramInt);
  
  private native int nativeGetGLThreadTid(long paramLong);
  
  private native int nativeGetJsThreadTid(long paramLong);
  
  private native void nativeMarkNeedCallbackBeforeSwapThisFrame(long paramLong);
  
  private native void nativeNotifyScreenSizeChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeRequestV8GarbageCollectionForTest(long paramLong);
  
  private native void nativeRunOnJsThread(long paramLong, int paramInt);
  
  private native void nativeSetIsCpuProfiling(long paramLong, boolean paramBoolean);
  
  private boolean o(Runnable paramRunnable)
  {
    paramRunnable = new f(paramRunnable);
    if (!n(paramRunnable)) {
      return false;
    }
    paramRunnable.bi(3000L);
    return paramRunnable.cQn.isDone();
  }
  
  protected final void UH()
  {
    if (this.cLM.enable_request_animation_frame) {
      this.cLT = com.tencent.magicbrush.ui.a.a(this, this.cLS, this.cLM.animationFrameHandlerStrategy);
    }
    if (this.cLP == null)
    {
      this.cLP = new i();
      nativeSetFontHandler(this.mNativeInst, this.cLP);
    }
    if (this.cLS == null) {
      throw new IllegalStateException("[MBRuntime] JsThreadHandler not registered.");
    }
    if (this.csB == null) {
      throw new IllegalStateException("[MBRuntime] ImageHandler not registered.");
    }
    if (this.cLP == null) {
      throw new IllegalStateException("[MBRuntime] FontHandler not registered.");
    }
    if (this.mNativeInst == 0L)
    {
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "init. mNativeInst == 0", new Object[0]);
      return;
    }
    m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139940);
        MBRuntime.this.nativeInit(MBRuntime.this.mNativeInst);
        AppMethodBeat.o(139940);
      }
    });
  }
  
  public final void UI()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.resume ", new Object[0]);
    d locald = this.cwf;
    if (locald.handler == null)
    {
      locald.handler = new Handler(Looper.getMainLooper());
      locald.handler.post(locald.cLw);
    }
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139947);
        MBRuntime.this.nativeResume(MBRuntime.this.mNativeInst);
        if (MBRuntime.this.cLM.enable_request_animation_frame) {
          MBRuntime.this.cLT.resume();
        }
        AppMethodBeat.o(139947);
      }
    });
  }
  
  public final void UJ()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.pause ", new Object[0]);
    this.cwf.Uv();
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139948);
        if (MBRuntime.this.cLM.enable_request_animation_frame) {
          MBRuntime.this.cLT.pause();
        }
        MBRuntime.this.nativePause(MBRuntime.this.mNativeInst);
        AppMethodBeat.o(139948);
      }
    });
  }
  
  public final void UK()
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeNotifyAnimationFrameLooper(this.mNativeInst);
  }
  
  public final void UL()
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeStopAnimationFrameLooper(this.mNativeInst);
  }
  
  public final boolean UM()
  {
    if (this.mNativeInst == 0L) {
      return false;
    }
    return nativeGetIsMali(this.mNativeInst);
  }
  
  public final BaseImageDecodeService UN()
  {
    return this.csB;
  }
  
  public final IMBFontHandler UO()
  {
    return this.cLP;
  }
  
  abstract b UP();
  
  abstract MBViewManager UQ();
  
  abstract e.e UR();
  
  public final MBRuntime.MBParams US()
  {
    return this.cLM;
  }
  
  public final com.tencent.magicbrush.handler.c UT()
  {
    return this.cLS;
  }
  
  public final a Uw()
  {
    return this.cwf.Uw();
  }
  
  public final void a(int paramInt, final long paramLong, final JsTouchEventHandler.a parama)
  {
    if (this.mNativeInst == 0L)
    {
      parama.bh(paramLong);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.cLS;
    if (localc == null)
    {
      parama.bh(paramLong);
      return;
    }
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139944);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          parama.bh(paramLong);
          AppMethodBeat.o(139944);
          return;
        }
        MBRuntime.this.nativeNotifyTouchEvent(MBRuntime.this.mNativeInst, this.cLW, paramLong);
        AppMethodBeat.o(139944);
      }
    }, false);
  }
  
  public final void a(final int paramInt, final SurfaceTexture paramSurfaceTexture)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowDestroyed shouldDestroySync: %b", new Object[] { Boolean.TRUE });
    if (this.mNativeInst == 0L) {
      return;
    }
    jm(paramInt);
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139942);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          AppMethodBeat.o(139942);
          return;
        }
        MBRuntime.this.nativeNotifyWindowDestroyed(MBRuntime.this.mNativeInst, paramInt);
        if (paramSurfaceTexture == null)
        {
          c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not release. maybe released by other module", new Object[0]);
          AppMethodBeat.o(139942);
          return;
        }
        paramSurfaceTexture.release();
        AppMethodBeat.o(139942);
      }
    };
    boolean bool = this.cLM.sync_surface_destroy;
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) param:true windowId:%d sync?%b %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), paramSurfaceTexture });
    if (bool) {
      o(local3);
    }
    for (;;)
    {
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) done. windowId:%d", new Object[] { Integer.valueOf(paramInt) });
      return;
      n(local3);
    }
  }
  
  public final void a(final int paramInt1, final SurfaceTexture paramSurfaceTexture, final int paramInt2, final int paramInt3)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged ", new Object[0]);
    jm(paramInt1);
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139953);
        if (paramSurfaceTexture == null)
        {
          c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
          AppMethodBeat.o(139953);
          return;
        }
        MBRuntime.this.nativeNotifyWindowChanged(MBRuntime.this.mNativeInst, paramInt1, paramSurfaceTexture, paramInt2, paramInt3);
        AppMethodBeat.o(139953);
      }
    });
  }
  
  public final void a(final int paramInt1, final SurfaceTexture paramSurfaceTexture, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowAvailable windowId:%d %s", new Object[] { Integer.valueOf(paramInt1), paramSurfaceTexture });
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("windowId < 0");
    }
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139949);
        if (paramSurfaceTexture == null)
        {
          c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowAvailable. maybe released by other module", new Object[0]);
          AppMethodBeat.o(139949);
          return;
        }
        MBRuntime.this.nativeNotifyWindowAvailable(MBRuntime.this.mNativeInst, paramInt1, paramSurfaceTexture, paramInt2, paramInt3, paramBoolean);
        AppMethodBeat.o(139949);
      }
    });
  }
  
  public final void a(final int paramInt1, final Surface paramSurface, final int paramInt2, final int paramInt3)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowAvailable: %d, %d, %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramSurface });
    if (paramSurface == null) {
      throw new RuntimeException("surface == null");
    }
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139952);
        MBRuntime.this.nativeNotifyWindowAvailableForSurface(MBRuntime.this.mNativeInst, paramInt1, paramSurface, paramInt2, paramInt3);
        AppMethodBeat.o(139952);
      }
    });
  }
  
  public final void a(BaseImageDecodeService paramBaseImageDecodeService)
  {
    this.csB = paramBaseImageDecodeService;
    nativeSetImageHandler(this.mNativeInst, paramBaseImageDecodeService);
  }
  
  final void a(MBRuntime.a parama)
  {
    this.cLN = parama;
    nativeMarkNeedCallbackBeforeSwapThisFrame(this.mNativeInst);
  }
  
  public final void a(com.tencent.magicbrush.handler.a parama)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.set_jsthread_handler ", new Object[0]);
    if (this.cLS != null)
    {
      c.c.e("MicroMsg.MagicBrush.MBRuntime", "Why you set_jsthread_handler twice, unexpected behaviour.", new Object[0]);
      return;
    }
    long l = this.mNativeInst;
    this.cLS = new com.tencent.magicbrush.handler.c(parama);
  }
  
  public final void a(IMBFontHandler paramIMBFontHandler)
  {
    this.cLP = paramIMBFontHandler;
    nativeSetFontHandler(this.mNativeInst, paramIMBFontHandler);
  }
  
  @Keep
  protected void applyWindowAttributes(int paramInt, boolean paramBoolean)
  {
    g.runOnUiThread(new MBRuntime.7(this, paramInt, paramBoolean));
  }
  
  public final void b(final int paramInt1, final Surface paramSurface, final int paramInt2, final int paramInt3)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged Surface[%s] %d, %d", new Object[] { paramSurface, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    jm(paramInt1);
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139946);
        if (paramSurface == null)
        {
          c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
          AppMethodBeat.o(139946);
          return;
        }
        MBRuntime.this.nativeNotifyWindowChangedForSurface(MBRuntime.this.mNativeInst, paramInt1, paramSurface, paramInt2, paramInt3);
        AppMethodBeat.o(139946);
      }
    });
  }
  
  public final void b(final String paramString, final Object paramObject, final IImageDecodeService.c paramc, final ImageDecodeConfig paramImageDecodeConfig)
  {
    if (this.mNativeInst == 0L)
    {
      paramc.U(paramObject);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.cLS;
    if (localc == null)
    {
      paramc.U(paramObject);
      return;
    }
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139945);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          paramc.U(paramObject);
          AppMethodBeat.o(139945);
          return;
        }
        MBRuntime.this.nativeNotifyImageDecoded(MBRuntime.this.mNativeInst, paramString, paramObject, paramImageDecodeConfig);
        AppMethodBeat.o(139945);
      }
    }, false);
  }
  
  @Keep
  protected void beforeSwap(boolean paramBoolean)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: beforeSwap! %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.cLN != null) {
      this.cLN.beforeSwap(paramBoolean);
    }
  }
  
  public final void cA(boolean paramBoolean)
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeSetIsCpuProfiling(this.mNativeInst, paramBoolean);
  }
  
  @Keep
  protected Bitmap captureScreen(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    Object localObject = UP();
    if ((paramInt2 > 0) && (paramInt3 > 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramBitmap = String.format("captureScreenCanvas of [%d] [%d, %d]", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }, 3));
      p.j(paramBitmap, "java.lang.String.format(this, *args)");
      throw ((Throwable)new IllegalStateException(paramBitmap.toString()));
    }
    localObject = ((b)localObject).jk(paramInt1);
    if (localObject == null) {
      return null;
    }
    g localg = g.cQp;
    return (Bitmap)g.f((kotlin.g.a.a)new b.d((MagicBrushView)localObject, paramInt2, paramInt3, paramBitmap));
  }
  
  public void destroy()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy", new Object[0]);
    this.cwf.Uv();
    if (this.mNativeInst == 0L)
    {
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip outside", new Object[0]);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.cLR != null) {
      throw null;
    }
    try
    {
      if (this.mNativeInst == 0L)
      {
        c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip inside, lock [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        return;
      }
    }
    finally {}
    if (this.cLM.enable_request_animation_frame) {
      this.cLT.destroy();
    }
    nativeDestroy(this.mNativeInst);
    this.cLS = null;
    this.csB = null;
    this.cLP = null;
    this.mNativeInst = 0L;
  }
  
  @Keep
  protected boolean doInnerLoopTask()
  {
    if (this.cLS != null) {
      return this.cLS.doInnerLoopTask();
    }
    return true;
  }
  
  public final void h(double paramDouble)
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeNotifyAnimationFrame(this.mNativeInst, paramDouble);
  }
  
  @Keep
  protected int insertElement(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    label154:
    for (;;)
    {
      try
      {
        MagicBrushView localMagicBrushView = ((e.e)Objects.requireNonNull(UR())).UV();
        UU();
        float f = this.cLM.device_pixel_ratio_;
        ((e.e)Objects.requireNonNull(UR())).a(localMagicBrushView, (int)(paramFloat1 * f), (int)(paramFloat2 * f), (int)(paramFloat3 * f), (int)(paramFloat4 * f), paramInt);
        int i = localMagicBrushView.getVirtualElementId();
        c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", localException1, "dl: ScreenCanvas: insertElement failed", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          c.c.i("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: insertElement a ScreenCanvas [%f, %f, %f, %f, %d]...done", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4), Integer.valueOf(paramInt) });
          c.c.i("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: insertElement a ScreenCanvas, result = [%d]", new Object[] { Integer.valueOf(i) });
          return i;
        }
        catch (Exception localException2)
        {
          break label154;
        }
        localException1 = localException1;
        i = -1;
      }
    }
  }
  
  /* Error */
  public final boolean isDestroyed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 133	com/tencent/magicbrush/MBRuntime:mNativeInst	J
    //   6: lstore_1
    //   7: lload_1
    //   8: lconst_0
    //   9: lcmp
    //   10: ifne +9 -> 19
    //   13: iconst_1
    //   14: istore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: iconst_0
    //   20: istore_3
    //   21: goto -6 -> 15
    //   24: astore 4
    //   26: aload_0
    //   27: monitorexit
    //   28: aload 4
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	MBRuntime
    //   6	2	1	l	long
    //   14	7	3	bool	boolean
    //   24	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
  }
  
  protected final boolean m(final Runnable paramRunnable)
  {
    if (this.mNativeInst == 0L) {}
    com.tencent.magicbrush.handler.c localc;
    do
    {
      return false;
      localc = this.cLS;
    } while (localc == null);
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139950);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          AppMethodBeat.o(139950);
          return;
        }
        paramRunnable.run();
        AppMethodBeat.o(139950);
      }
    }, false);
    return true;
  }
  
  final Bitmap n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mNativeInst == 0L) {
      return null;
    }
    if (paramBoolean) {
      return nativeCaptureScreen(this.mNativeInst, paramInt1);
    }
    return nativeCaptureCanvas(this.mNativeInst, paramInt2);
  }
  
  protected native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  protected native Bitmap nativeCaptureCanvas(long paramLong, int paramInt);
  
  protected native Bitmap nativeCaptureScreen(long paramLong, int paramInt);
  
  protected native long nativeCreate(MBRuntime.MBParams paramMBParams);
  
  native int nativeCreateExternalTexture(long paramLong, int paramInt);
  
  protected native void nativeDebug(long paramLong, int paramInt);
  
  protected native void nativeDestroy(long paramLong);
  
  native void nativeDestroyExternalTexture(long paramLong, int paramInt);
  
  native float[] nativeGetCurrentFps(long paramLong);
  
  native float nativeGetCurrentFpsVariance(long paramLong);
  
  native int nativeGetDrawCalls(long paramLong);
  
  native int nativeGetFrameCounter(long paramLong);
  
  protected native boolean nativeGetIsMali(long paramLong);
  
  native int nativeGetTriangles(long paramLong);
  
  native int nativeGetVertexes(long paramLong);
  
  protected native void nativeInit(long paramLong);
  
  protected native void nativeLazyLoadBox2D(long paramLong, String paramString);
  
  protected native void nativeLazyLoadPhysx(long paramLong, String paramString);
  
  protected native void nativeNotifyAnimationFrame(long paramLong, double paramDouble);
  
  protected native void nativeNotifyAnimationFrameLooper(long paramLong);
  
  protected native void nativeNotifyExternalSurfaceAvailable(long paramLong, SurfaceTexture paramSurfaceTexture, int paramInt);
  
  protected native void nativeNotifyImageDecoded(long paramLong, String paramString, Object paramObject, ImageDecodeConfig paramImageDecodeConfig);
  
  protected native void nativeNotifyTouchEvent(long paramLong1, int paramInt, long paramLong2);
  
  protected native void nativeNotifyWindowAvailable(long paramLong, int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, boolean paramBoolean);
  
  protected native void nativeNotifyWindowAvailableForSurface(long paramLong, int paramInt1, Surface paramSurface, int paramInt2, int paramInt3);
  
  protected native void nativeNotifyWindowChanged(long paramLong, int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3);
  
  protected native void nativeNotifyWindowChangedForSurface(long paramLong, int paramInt1, Surface paramSurface, int paramInt2, int paramInt3);
  
  protected native void nativeNotifyWindowDestroyed(long paramLong, int paramInt);
  
  protected native void nativePause(long paramLong);
  
  protected native void nativeResume(long paramLong);
  
  native void nativeSetEnableInspectFpsVariance(long paramLong, boolean paramBoolean);
  
  protected native void nativeSetEventListener(long paramLong, EventDispatcher paramEventDispatcher);
  
  protected native void nativeSetFontHandler(long paramLong, IMBFontHandler paramIMBFontHandler);
  
  protected native void nativeSetImageHandler(long paramLong, IImageDecodeService paramIImageDecodeService);
  
  protected native void nativeSetJsThreadHandler(long paramLong1, long paramLong2);
  
  protected native void nativeSetUserPreferredFps(long paramLong, double paramDouble);
  
  protected native void nativeStopAnimationFrameLooper(long paramLong);
  
  protected native void nativeUpdateParams(long paramLong, boolean paramBoolean);
  
  @Keep
  protected void removeElement(int paramInt)
  {
    try
    {
      MagicBrushView localMagicBrushView = UQ().findOrNull(paramInt);
      if (localMagicBrushView == null)
      {
        c.c.e("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: removeElement window_id = [%d] not found!", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      ((e.e)Objects.requireNonNull(UR())).c(localMagicBrushView);
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: removeElement a ScreenCanvas window_id = [%d]...done", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", localException, "dl: ScreenCanvas: removeElement failed", new Object[0]);
    }
  }
  
  @Keep
  protected void resumeLoopTasks()
  {
    if (this.cLS != null) {
      this.cLS.resumeLoopTasks();
    }
  }
  
  @Keep
  protected void switchToJsThread(final int paramInt)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread taskId: ".concat(String.valueOf(paramInt)), new Object[0]);
    if (this.cLS != null) {
      try
      {
        this.cLS.p(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203560);
            c.c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread Runnable taskId: " + paramInt, new Object[0]);
            MBRuntime.a(MBRuntime.this, MBRuntime.this.mNativeInst, paramInt);
            AppMethodBeat.o(203560);
          }
        });
        return;
      }
      catch (Throwable localThrowable)
      {
        c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", localThrowable, "hy: switchToJsThread crash!", new Object[0]);
        throw localThrowable;
      }
    }
    c.c.e("MicroMsg.MagicBrush.MBRuntime", "hy: switchToJsThread no js thread handler", new Object[0]);
  }
  
  @Keep
  protected void touchJava()
  {
    this.cLU += 1;
  }
  
  @Keep
  protected void updateElement(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    try
    {
      MagicBrushView localMagicBrushView = UQ().findOrNull(paramInt1);
      if (localMagicBrushView == null)
      {
        c.c.e("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: updateElement window_id = [%d] not found!", new Object[] { Integer.valueOf(paramInt1) });
        return;
      }
      UU();
      float f = this.cLM.device_pixel_ratio_;
      ((e.e)Objects.requireNonNull(UR())).b(localMagicBrushView, (int)(paramFloat1 * f), (int)(paramFloat2 * f), (int)(paramFloat3 * f), (int)(paramFloat4 * f), paramInt2);
      return;
    }
    catch (Exception localException)
    {
      c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", localException, "dl: ScreenCanvas: updateElement failed", new Object[0]);
    }
  }
  
  public final void y(final int paramInt, boolean paramBoolean)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowDestroyed: %d", new Object[] { Integer.valueOf(paramInt) });
    jm(paramInt);
    if ((this.cLM.sync_surface_destroy) || (paramBoolean)) {}
    Runnable local4;
    for (paramBoolean = true;; paramBoolean = false)
    {
      local4 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203541);
          MBRuntime.this.nativeNotifyWindowDestroyed(MBRuntime.this.mNativeInst, paramInt);
          AppMethodBeat.o(203541);
        }
      };
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surface) windowId:%d sync?%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break;
      }
      if (!o(local4)) {
        c.c.e("MicroMsg.MagicBrush.MBRuntime", "notifyWindowDestroyed, but await fail. [deadlock]:    %s", new Object[] { this.cLS.OG() });
      }
      return;
    }
    n(local4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime
 * JD-Core Version:    0.7.0.1
 */