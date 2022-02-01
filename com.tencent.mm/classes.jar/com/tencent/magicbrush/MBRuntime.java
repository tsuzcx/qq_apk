package com.tencent.magicbrush;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import android.view.Surface;
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
import com.tencent.magicbrush.ui.a.b;
import com.tencent.magicbrush.utils.e;
import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import java.util.Arrays;
import java.util.concurrent.FutureTask;

public abstract class MBRuntime
{
  public c clA = new c(this);
  protected MBParams cwp;
  private MBRuntime.a cwq = null;
  protected IMBFileSystem cwr = null;
  protected BaseImageDecodeService cws = null;
  protected IMBFontHandler cwt = null;
  public com.tencent.magicbrush.handler.b cwu = null;
  public volatile com.tencent.magicbrush.handler.c cwv;
  protected com.tencent.magicbrush.ui.a cww;
  private int cwx = 0;
  protected volatile long mNativeInst;
  
  static {}
  
  private static void gR(int paramInt)
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
      localc = this.cwv;
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
  
  private native void nativeRequestV8GarbageCollectionForTest(long paramLong);
  
  private native void nativeRunOnJsThread(long paramLong, int paramInt);
  
  private native void nativeSetIsCpuProfiling(long paramLong, boolean paramBoolean);
  
  private boolean o(Runnable paramRunnable)
  {
    paramRunnable = new e(paramRunnable);
    if (!n(paramRunnable)) {
      return false;
    }
    paramRunnable.aN(3000L);
    return paramRunnable.cAN.isDone();
  }
  
  protected final void Hc()
  {
    if (this.cwp.enable_request_animation_frame) {
      this.cww = com.tencent.magicbrush.ui.a.a(this, this.cwv, this.cwp.animationFrameHandlerStrategy);
    }
    if (this.cwt == null)
    {
      this.cwt = new i();
      nativeSetFontHandler(this.mNativeInst, this.cwt);
    }
    if (this.cwv == null) {
      throw new IllegalStateException("[MBRuntime] JsThreadHandler not registered.");
    }
    if (this.cws == null) {
      throw new IllegalStateException("[MBRuntime] ImageHandler not registered.");
    }
    if (this.cwt == null) {
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
  
  public final void Hd()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.resume ", new Object[0]);
    c localc = this.clA;
    if (localc.handler == null)
    {
      localc.handler = new Handler(Looper.getMainLooper());
      localc.handler.post(localc.cwb);
    }
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139946);
        MBRuntime.this.nativeResume(MBRuntime.this.mNativeInst);
        if (MBRuntime.this.cwp.enable_request_animation_frame) {
          MBRuntime.this.cww.resume();
        }
        AppMethodBeat.o(139946);
      }
    });
  }
  
  public final void He()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.pause ", new Object[0]);
    this.clA.GQ();
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139947);
        if (MBRuntime.this.cwp.enable_request_animation_frame) {
          MBRuntime.this.cww.pause();
        }
        MBRuntime.this.nativePause(MBRuntime.this.mNativeInst);
        AppMethodBeat.o(139947);
      }
    });
  }
  
  public final void Hf()
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeNotifyAnimationFrameLooper(this.mNativeInst);
  }
  
  public final void Hg()
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeStopAnimationFrameLooper(this.mNativeInst);
  }
  
  public final void Hh()
  {
    if (this.mNativeInst == 0L) {}
    com.tencent.magicbrush.handler.c localc;
    do
    {
      return;
      localc = this.cwv;
    } while (localc == null);
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215078);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          AppMethodBeat.o(215078);
          return;
        }
        MBRuntime.a(MBRuntime.this, MBRuntime.this.mNativeInst);
        AppMethodBeat.o(215078);
      }
    }, false);
  }
  
  public final BaseImageDecodeService Hi()
  {
    return this.cws;
  }
  
  public final IMBFontHandler Hj()
  {
    return this.cwt;
  }
  
  abstract b Hk();
  
  abstract MBViewManager Hl();
  
  public final MBParams Hm()
  {
    return this.cwp;
  }
  
  public final com.tencent.magicbrush.handler.c Hn()
  {
    return this.cwv;
  }
  
  public final void a(int paramInt, final long paramLong, final JsTouchEventHandler.a parama)
  {
    if (this.mNativeInst == 0L)
    {
      parama.aM(paramLong);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.cwv;
    if (localc == null)
    {
      parama.aM(paramLong);
      return;
    }
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139944);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          parama.aM(paramLong);
          AppMethodBeat.o(139944);
          return;
        }
        MBRuntime.this.nativeNotifyTouchEvent(MBRuntime.this.mNativeInst, this.cwz, paramLong);
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
    gR(paramInt);
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139941);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          AppMethodBeat.o(139941);
          return;
        }
        MBRuntime.this.nativeNotifyWindowDestroyed(MBRuntime.this.mNativeInst, paramInt);
        if (paramSurfaceTexture == null)
        {
          c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not release. maybe released by other module", new Object[0]);
          AppMethodBeat.o(139941);
          return;
        }
        paramSurfaceTexture.release();
        AppMethodBeat.o(139941);
      }
    };
    boolean bool = this.cwp.sync_surface_destroy;
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) param:true windowId:%d sync?%b %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), paramSurfaceTexture });
    if (bool) {
      o(local2);
    }
    for (;;)
    {
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) done. windowId:%d", new Object[] { Integer.valueOf(paramInt) });
      return;
      n(local2);
    }
  }
  
  public final void a(final int paramInt1, final SurfaceTexture paramSurfaceTexture, final int paramInt2, final int paramInt3)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged ", new Object[0]);
    gR(paramInt1);
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139952);
        if (paramSurfaceTexture == null)
        {
          c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
          AppMethodBeat.o(139952);
          return;
        }
        MBRuntime.this.nativeNotifyWindowChanged(MBRuntime.this.mNativeInst, paramInt1, paramSurfaceTexture, paramInt2, paramInt3);
        AppMethodBeat.o(139952);
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
        AppMethodBeat.i(139948);
        if (paramSurfaceTexture == null)
        {
          c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowAvailable. maybe released by other module", new Object[0]);
          AppMethodBeat.o(139948);
          return;
        }
        MBRuntime.this.nativeNotifyWindowAvailable(MBRuntime.this.mNativeInst, paramInt1, paramSurfaceTexture, paramInt2, paramInt3, paramBoolean);
        AppMethodBeat.o(139948);
      }
    });
  }
  
  public final void a(final int paramInt1, final Surface paramSurface, final int paramInt2, final int paramInt3)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowAvailable: %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramSurface == null) {
      throw new RuntimeException("surface == null");
    }
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139951);
        MBRuntime.this.nativeNotifyWindowAvailableForSurface(MBRuntime.this.mNativeInst, paramInt1, paramSurface, paramInt2, paramInt3);
        AppMethodBeat.o(139951);
      }
    });
  }
  
  public final void a(BaseImageDecodeService paramBaseImageDecodeService)
  {
    this.cws = paramBaseImageDecodeService;
    nativeSetImageHandler(this.mNativeInst, paramBaseImageDecodeService);
  }
  
  final void a(MBRuntime.a parama)
  {
    this.cwq = parama;
    nativeMarkNeedCallbackBeforeSwapThisFrame(this.mNativeInst);
  }
  
  public final void a(com.tencent.magicbrush.handler.a parama)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.set_jsthread_handler ", new Object[0]);
    if (this.cwv != null)
    {
      c.c.e("MicroMsg.MagicBrush.MBRuntime", "Why you set_jsthread_handler twice, unexpected behaviour.", new Object[0]);
      return;
    }
    long l = this.mNativeInst;
    this.cwv = new com.tencent.magicbrush.handler.c(parama);
  }
  
  public final void a(IMBFontHandler paramIMBFontHandler)
  {
    this.cwt = paramIMBFontHandler;
    nativeSetFontHandler(this.mNativeInst, paramIMBFontHandler);
  }
  
  @Keep
  protected void applyWindowAttributes(int paramInt, boolean paramBoolean)
  {
    f.runOnUiThread(new MBRuntime.7(this, paramInt, paramBoolean));
  }
  
  public final void b(final int paramInt1, final Surface paramSurface, final int paramInt2, final int paramInt3)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged Surface[%s] %d, %d", new Object[] { paramSurface, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    gR(paramInt1);
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139953);
        if (paramSurface == null)
        {
          c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
          AppMethodBeat.o(139953);
          return;
        }
        MBRuntime.this.nativeNotifyWindowChangedForSurface(MBRuntime.this.mNativeInst, paramInt1, paramSurface, paramInt2, paramInt3);
        AppMethodBeat.o(139953);
      }
    });
  }
  
  public final void b(final String paramString, final Object paramObject, final IImageDecodeService.c paramc, final ImageDecodeConfig paramImageDecodeConfig)
  {
    if (this.mNativeInst == 0L)
    {
      paramc.ad(paramObject);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.cwv;
    if (localc == null)
    {
      paramc.ad(paramObject);
      return;
    }
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139945);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          paramc.ad(paramObject);
          AppMethodBeat.o(139945);
          return;
        }
        MBRuntime.this.nativeNotifyImageDecoded(MBRuntime.this.mNativeInst, paramString, paramObject, paramImageDecodeConfig);
        AppMethodBeat.o(139945);
      }
    }, false);
  }
  
  public final void bN(boolean paramBoolean)
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeSetIsCpuProfiling(this.mNativeInst, paramBoolean);
  }
  
  @Keep
  protected void beforeSwap(boolean paramBoolean)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: beforeSwap! %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.cwq != null) {
      this.cwq.beforeSwap(paramBoolean);
    }
  }
  
  @Keep
  protected Bitmap captureScreen(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    Object localObject = Hk();
    if ((paramInt2 > 0) && (paramInt3 > 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramBitmap = String.format("captureScreenCanvas of [%d] [%d, %d]", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }, 3));
      p.g(paramBitmap, "java.lang.String.format(this, *args)");
      throw ((Throwable)new IllegalStateException(paramBitmap.toString()));
    }
    localObject = ((b)localObject).gP(paramInt1);
    if (localObject == null) {
      return null;
    }
    f localf = f.cAP;
    return (Bitmap)f.e((d.g.a.a)new b.d((MagicBrushView)localObject, paramInt2, paramInt3, paramBitmap));
  }
  
  @Keep
  protected void delayLoadLibrary(String paramString)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: delayLoadLibrary ".concat(String.valueOf(paramString)), new Object[0]);
    com.tencent.magicbrush.a.b.loadLibrary(paramString);
  }
  
  public void destroy()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy", new Object[0]);
    this.clA.GQ();
    if (this.mNativeInst == 0L)
    {
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip outside", new Object[0]);
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      if (this.mNativeInst == 0L)
      {
        c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip inside, lock [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        return;
      }
    }
    finally {}
    if (this.cwp.enable_request_animation_frame) {
      this.cww.destroy();
    }
    nativeDestroy(this.mNativeInst);
    this.cwv = null;
    this.cws = null;
    this.cwt = null;
    this.mNativeInst = 0L;
  }
  
  public final void g(double paramDouble)
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeNotifyAnimationFrame(this.mNativeInst, paramDouble);
  }
  
  @Keep
  protected String[] getAsyncableJsApis()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: trigger get asyncable jsapis", new Object[0]);
    try
    {
      if (this.cwu != null) {
        return this.cwu.getAsyncableJsApis();
      }
      c.c.e("MicroMsg.MagicBrush.MBRuntime", "hy: invoke handler not set!", new Object[0]);
      return null;
    }
    catch (Throwable localThrowable)
    {
      c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", localThrowable, "hy: get acyncable jsapis failed!", new Object[0]);
    }
    return null;
  }
  
  final Bitmap h(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mNativeInst == 0L) {
      return null;
    }
    if (paramBoolean) {
      return nativeCaptureScreen(this.mNativeInst, paramInt1);
    }
    return nativeCaptureCanvas(this.mNativeInst, paramInt2);
  }
  
  /* Error */
  public final boolean isDestroyed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 115	com/tencent/magicbrush/MBRuntime:mNativeInst	J
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
      localc = this.cwv;
    } while (localc == null);
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139949);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          AppMethodBeat.o(139949);
          return;
        }
        paramRunnable.run();
        AppMethodBeat.o(139949);
      }
    }, false);
    return true;
  }
  
  protected native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  protected native Bitmap nativeCaptureCanvas(long paramLong, int paramInt);
  
  protected native Bitmap nativeCaptureScreen(long paramLong, int paramInt);
  
  protected native long nativeCreate(MBParams paramMBParams);
  
  protected native void nativeDebug(long paramLong, int paramInt);
  
  protected native void nativeDestroy(long paramLong);
  
  native float[] nativeGetCurrentFps(long paramLong);
  
  native float nativeGetCurrentFpsVariance(long paramLong);
  
  native int nativeGetDrawCalls(long paramLong);
  
  native int nativeGetFrameCounter(long paramLong);
  
  native int nativeGetTriangles(long paramLong);
  
  native int nativeGetVertexes(long paramLong);
  
  protected native void nativeInit(long paramLong);
  
  @Keep
  protected String nativeInvokeHandler(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (this.cwu != null) {
      try
      {
        paramString1 = this.cwu.a(paramString1, paramString2, paramInt, paramBoolean);
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", paramString1, "hy: crash when invoke jsapi!", new Object[0]);
        throw paramString1;
      }
    }
    c.c.e("MicroMsg.MagicBrush.MBRuntime", "hy: no native invoke handler", new Object[0]);
    return "";
  }
  
  protected native void nativeNotifyAnimationFrame(long paramLong, double paramDouble);
  
  protected native void nativeNotifyAnimationFrameLooper(long paramLong);
  
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
  
  public final void s(final int paramInt, boolean paramBoolean)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowDestroyed: %d", new Object[] { Integer.valueOf(paramInt) });
    gR(paramInt);
    if ((this.cwp.sync_surface_destroy) || (paramBoolean)) {}
    Runnable local3;
    for (paramBoolean = true;; paramBoolean = false)
    {
      local3 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139942);
          MBRuntime.this.nativeNotifyWindowDestroyed(MBRuntime.this.mNativeInst, paramInt);
          AppMethodBeat.o(139942);
        }
      };
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surface) windowId:%d sync?%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break;
      }
      if (!o(local3)) {
        c.c.e("MicroMsg.MagicBrush.MBRuntime", "notifyWindowDestroyed, but await fail. [deadlock]:    %s", new Object[] { this.cwv.Cu() });
      }
      return;
    }
    n(local3);
  }
  
  @Keep
  protected void switchToJsThread(final int paramInt)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread taskId: ".concat(String.valueOf(paramInt)), new Object[0]);
    if (this.cwv != null) {
      try
      {
        this.cwv.p(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215079);
            c.c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread Runnable taskId: " + paramInt, new Object[0]);
            MBRuntime.a(MBRuntime.this, MBRuntime.this.mNativeInst, paramInt);
            AppMethodBeat.o(215079);
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
    this.cwx += 1;
  }
  
  @Keep
  public static class MBParams
  {
    public boolean adjust_thread_priority = true;
    public boolean allow_antialias_ = false;
    public boolean allow_opengl3 = true;
    public a.b animationFrameHandlerStrategy = a.b.czL;
    AssetManager asset_manager;
    public int cmd_pool_type = 1;
    public float device_pixel_ratio_ = -1.0F;
    public boolean enable_2d = true;
    public boolean enable_font_batch = false;
    public boolean enable_gfx = true;
    public boolean enable_request_animation_frame = true;
    public boolean enable_switch_thread_native_for_jsapis = true;
    public boolean enable_window_attributes_alpha = false;
    public boolean enable_wxbindcanvastexture = false;
    public IMBFileSystem file_system_ = null;
    public float gc_factor = 0.0F;
    public boolean is_game = false;
    public boolean perf_crazy_mode = false;
    public boolean render_thread_profiler = false;
    public boolean revert_cpu_optimizer_test = false;
    public int screen_height_ = -1;
    public int screen_width_ = -1;
    public String sdcard_path;
    public boolean support_client_vertex_buffer = false;
    public boolean support_gfximage_share_texture = true;
    public boolean support_hardware_decode = true;
    public boolean support_hardware_encode = true;
    public boolean sync_surface_destroy = true;
    public boolean use_command_buffer = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime
 * JD-Core Version:    0.7.0.1
 */