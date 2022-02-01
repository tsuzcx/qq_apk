package com.tencent.magicbrush;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.magicbrush.utils.f;
import com.tencent.magicbrush.utils.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.FutureTask;
import kotlin.g.b.s;

public abstract class MBRuntime
{
  protected MBParams eHg;
  private a eHh = null;
  protected IMBFileSystem eHi = null;
  protected IMBFontHandler eHj = null;
  private com.tencent.magicbrush.handler.b eHk = null;
  protected c eHl = null;
  public volatile com.tencent.magicbrush.handler.c eHm;
  protected com.tencent.magicbrush.ui.a eHn;
  private int eHo = 0;
  protected BaseImageDecodeService ekv = null;
  public d eod = new d(this);
  protected volatile long mNativeInst;
  
  static
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "enter static block", new Object[0]);
    com.tencent.magicbrush.a.b.loadLibraries();
  }
  
  private void avx()
  {
    if (this.eHg.device_pixel_ratio_ <= 0.0F) {
      throw new IllegalStateException("device pixel ratio is null");
    }
  }
  
  private static void mP(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("windowId < 0");
    }
  }
  
  private native int[] nativeGetCanvasSize(long paramLong, int paramInt);
  
  private native int nativeGetGLThreadTid(long paramLong);
  
  private native int nativeGetJsThreadTid(long paramLong);
  
  private native void nativeMarkNeedCallbackBeforeSwapThisFrame(long paramLong);
  
  private native void nativeNotifyScreenSizeChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeRequestV8GarbageCollectionForTest(long paramLong);
  
  private native void nativeRunOnJsThread(long paramLong, int paramInt);
  
  private native void nativeSetIsCpuProfiling(long paramLong, boolean paramBoolean);
  
  private boolean r(final Runnable paramRunnable)
  {
    if (this.mNativeInst == 0L) {}
    com.tencent.magicbrush.handler.c localc;
    do
    {
      return false;
      localc = this.eHm;
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
  
  private boolean s(Runnable paramRunnable)
  {
    paramRunnable = new f(paramRunnable);
    if (!r(paramRunnable)) {
      return false;
    }
    paramRunnable.dA(3000L);
    return paramRunnable.eLr.isDone();
  }
  
  public final void N(final int paramInt, boolean paramBoolean)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowDestroyed: %d", new Object[] { Integer.valueOf(paramInt) });
    mP(paramInt);
    nativeNotifyBeforeWindowDestroyed(this.mNativeInst, paramInt);
    if ((this.eHg.sync_surface_destroy) || (paramBoolean)) {}
    Runnable local4;
    for (paramBoolean = true;; paramBoolean = false)
    {
      local4 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(228752);
          MBRuntime.this.nativeNotifyWindowDestroyed(MBRuntime.this.mNativeInst, paramInt);
          AppMethodBeat.o(228752);
        }
      };
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surface) windowId:%d sync?%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      if (!paramBoolean) {
        break;
      }
      if (!s(local4)) {
        c.c.e("MicroMsg.MagicBrush.MBRuntime", "notifyWindowDestroyed, but await fail. [deadlock]:    %s", new Object[] { this.eHm.aoO() });
      }
      return;
    }
    r(local4);
  }
  
  public final void a(int paramInt, final long paramLong, final JsTouchEventHandler.a parama)
  {
    if (this.mNativeInst == 0L)
    {
      parama.dz(paramLong);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.eHm;
    if (localc == null)
    {
      parama.dz(paramLong);
      return;
    }
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139944);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          parama.dz(paramLong);
          AppMethodBeat.o(139944);
          return;
        }
        MBRuntime.this.nativeNotifyTouchEvent(MBRuntime.this.mNativeInst, this.eHq, paramLong);
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
    mP(paramInt);
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
    boolean bool = this.eHg.sync_surface_destroy;
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) param:true windowId:%d sync?%b %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), paramSurfaceTexture });
    if (bool) {
      s(local3);
    }
    for (;;)
    {
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) done. windowId:%d", new Object[] { Integer.valueOf(paramInt) });
      return;
      r(local3);
    }
  }
  
  public final void a(final int paramInt1, final SurfaceTexture paramSurfaceTexture, final int paramInt2, final int paramInt3)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged ", new Object[0]);
    mP(paramInt1);
    r(new Runnable()
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
    r(new Runnable()
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
    r(new Runnable()
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
    this.ekv = paramBaseImageDecodeService;
    nativeSetImageHandler(this.mNativeInst, paramBaseImageDecodeService);
  }
  
  final void a(a parama)
  {
    this.eHh = parama;
    nativeMarkNeedCallbackBeforeSwapThisFrame(this.mNativeInst);
  }
  
  public final void a(com.tencent.magicbrush.handler.a parama)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.set_jsthread_handler ", new Object[0]);
    if (this.eHm != null)
    {
      c.c.e("MicroMsg.MagicBrush.MBRuntime", "Why you set_jsthread_handler twice, unexpected behaviour.", new Object[0]);
      return;
    }
    long l = this.mNativeInst;
    this.eHm = new com.tencent.magicbrush.handler.c(parama);
  }
  
  public final void a(IMBFontHandler paramIMBFontHandler)
  {
    this.eHj = paramIMBFontHandler;
    nativeSetFontHandler(this.mNativeInst, paramIMBFontHandler);
  }
  
  protected void applyWindowAttributes(final int paramInt, final boolean paramBoolean)
  {
    g.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175885);
        MagicBrushView localMagicBrushView = MBRuntime.this.avt().findOrNull(paramInt);
        if (localMagicBrushView != null) {
          if (paramBoolean) {
            break label44;
          }
        }
        label44:
        for (boolean bool = true;; bool = false)
        {
          localMagicBrushView.setOpaque(bool);
          AppMethodBeat.o(175885);
          return;
        }
      }
    });
  }
  
  protected final void avk()
  {
    if (this.eHg.enable_request_animation_frame) {
      this.eHn = com.tencent.magicbrush.ui.a.a(this, this.eHm, this.eHg.animationFrameHandlerStrategy);
    }
    if (this.eHj == null)
    {
      this.eHj = new i();
      nativeSetFontHandler(this.mNativeInst, this.eHj);
    }
    if (this.eHm == null) {
      throw new IllegalStateException("[MBRuntime] JsThreadHandler not registered.");
    }
    if (this.ekv == null) {
      throw new IllegalStateException("[MBRuntime] ImageHandler not registered.");
    }
    if (this.eHj == null) {
      throw new IllegalStateException("[MBRuntime] FontHandler not registered.");
    }
    if (this.mNativeInst == 0L)
    {
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "init. mNativeInst == 0", new Object[0]);
      return;
    }
    q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139940);
        MBRuntime.this.nativeInit(MBRuntime.this.mNativeInst);
        AppMethodBeat.o(139940);
      }
    });
  }
  
  public final void avl()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.resume ", new Object[0]);
    d locald = this.eod;
    if (locald.handler == null)
    {
      locald.handler = new Handler(Looper.getMainLooper());
      locald.handler.post(locald.eGQ);
    }
    r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139947);
        MBRuntime.this.nativeResume(MBRuntime.this.mNativeInst);
        if (MBRuntime.this.eHg.enable_request_animation_frame) {
          MBRuntime.this.eHn.resume();
        }
        AppMethodBeat.o(139947);
      }
    });
  }
  
  public final void avm()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.pause ", new Object[0]);
    this.eod.auY();
    r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139948);
        if (MBRuntime.this.eHg.enable_request_animation_frame) {
          MBRuntime.this.eHn.pause();
        }
        MBRuntime.this.nativePause(MBRuntime.this.mNativeInst);
        AppMethodBeat.o(139948);
      }
    });
  }
  
  public final void avn()
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeNotifyAnimationFrameLooper(this.mNativeInst);
  }
  
  public final void avo()
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeStopAnimationFrameLooper(this.mNativeInst);
  }
  
  public final boolean avp()
  {
    if (this.mNativeInst == 0L) {
      return false;
    }
    return nativeGetIsMali(this.mNativeInst);
  }
  
  public final BaseImageDecodeService avq()
  {
    return this.ekv;
  }
  
  public final IMBFontHandler avr()
  {
    return this.eHj;
  }
  
  abstract b avs();
  
  abstract MBViewManager avt();
  
  abstract e.e avu();
  
  public final MBParams avv()
  {
    return this.eHg;
  }
  
  public final com.tencent.magicbrush.handler.c avw()
  {
    return this.eHm;
  }
  
  public final void b(final int paramInt1, final Surface paramSurface, final int paramInt2, final int paramInt3)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged Surface[%s] %d, %d", new Object[] { paramSurface, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    mP(paramInt1);
    r(new Runnable()
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
      paramc.bd(paramObject);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.eHm;
    if (localc == null)
    {
      paramc.bd(paramObject);
      return;
    }
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139945);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          paramc.bd(paramObject);
          AppMethodBeat.o(139945);
          return;
        }
        MBRuntime.this.nativeNotifyImageDecoded(MBRuntime.this.mNativeInst, paramString, paramObject, paramImageDecodeConfig);
        AppMethodBeat.o(139945);
      }
    }, false);
  }
  
  protected void beforeSwap(boolean paramBoolean)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "hy: beforeSwap! %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.eHh != null) {
      this.eHh.beforeSwap(paramBoolean);
    }
  }
  
  protected Bitmap captureScreen(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    Object localObject = avs();
    if ((paramInt2 > 0) && (paramInt3 > 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramBitmap = String.format("captureScreenCanvas of [%d] [%d, %d]", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }, 3));
      s.r(paramBitmap, "java.lang.String.format(this, *args)");
      throw ((Throwable)new IllegalStateException(paramBitmap.toString()));
    }
    localObject = ((b)localObject).mN(paramInt1);
    if (localObject == null) {
      return null;
    }
    g localg = g.eLt;
    return (Bitmap)g.x((kotlin.g.a.a)new b.d((MagicBrushView)localObject, paramInt2, paramInt3, paramBitmap));
  }
  
  public void destroy()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy", new Object[0]);
    this.eod.auY();
    if (this.mNativeInst == 0L)
    {
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip outside", new Object[0]);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.eHl != null) {
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
    if (this.eHg.enable_request_animation_frame) {
      this.eHn.destroy();
    }
    nativeDestroy(this.mNativeInst);
    this.eHm = null;
    this.ekv = null;
    this.eHj = null;
    this.mNativeInst = 0L;
  }
  
  public final void dg(boolean paramBoolean)
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeSetIsCpuProfiling(this.mNativeInst, paramBoolean);
  }
  
  protected boolean doInnerLoopTask()
  {
    if (this.eHm != null) {
      return this.eHm.doInnerLoopTask();
    }
    return true;
  }
  
  protected int insertElement(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    label154:
    for (;;)
    {
      try
      {
        MagicBrushView localMagicBrushView = ((e.e)Objects.requireNonNull(avu())).avy();
        avx();
        float f = this.eHg.device_pixel_ratio_;
        ((e.e)Objects.requireNonNull(avu())).a(localMagicBrushView, (int)(paramFloat1 * f), (int)(paramFloat2 * f), (int)(paramFloat3 * f), (int)(paramFloat4 * f), paramInt);
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
    //   3: getfield 148	com/tencent/magicbrush/MBRuntime:mNativeInst	J
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
  
  protected native long nativeCreate(MBParams paramMBParams);
  
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
  
  protected native void nativeNotifyBeforeWindowDestroyed(long paramLong, int paramInt);
  
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
  
  protected final boolean q(final Runnable paramRunnable)
  {
    if (this.mNativeInst == 0L) {}
    com.tencent.magicbrush.handler.c localc;
    do
    {
      return false;
      localc = this.eHm;
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
  
  protected void removeElement(int paramInt)
  {
    try
    {
      MagicBrushView localMagicBrushView = avt().findOrNull(paramInt);
      if (localMagicBrushView == null)
      {
        c.c.e("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: removeElement window_id = [%d] not found!", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      ((e.e)Objects.requireNonNull(avu())).c(localMagicBrushView);
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: removeElement a ScreenCanvas window_id = [%d]...done", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", localException, "dl: ScreenCanvas: removeElement failed", new Object[0]);
    }
  }
  
  protected void resumeLoopTasks()
  {
    if (this.eHm != null) {
      this.eHm.resumeLoopTasks();
    }
  }
  
  protected void switchToJsThread(final int paramInt)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread taskId: ".concat(String.valueOf(paramInt)), new Object[0]);
    if (this.eHm != null) {
      try
      {
        this.eHm.t(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(228756);
            c.c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread Runnable taskId: " + paramInt, new Object[0]);
            MBRuntime.a(MBRuntime.this, MBRuntime.this.mNativeInst, paramInt);
            AppMethodBeat.o(228756);
          }
        });
        return;
      }
      finally
      {
        c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", localThrowable, "hy: switchToJsThread crash!", new Object[0]);
      }
    }
    c.c.e("MicroMsg.MagicBrush.MBRuntime", "hy: switchToJsThread no js thread handler", new Object[0]);
  }
  
  protected void touchJava()
  {
    this.eHo += 1;
  }
  
  protected void updateElement(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    try
    {
      MagicBrushView localMagicBrushView = avt().findOrNull(paramInt1);
      if (localMagicBrushView == null)
      {
        c.c.e("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: updateElement window_id = [%d] not found!", new Object[] { Integer.valueOf(paramInt1) });
        return;
      }
      avx();
      float f = this.eHg.device_pixel_ratio_;
      ((e.e)Objects.requireNonNull(avu())).b(localMagicBrushView, (int)(paramFloat1 * f), (int)(paramFloat2 * f), (int)(paramFloat3 * f), (int)(paramFloat4 * f), paramInt2);
      return;
    }
    catch (Exception localException)
    {
      c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", localException, "dl: ScreenCanvas: updateElement failed", new Object[0]);
    }
  }
  
  public final void x(double paramDouble)
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeNotifyAnimationFrame(this.mNativeInst, paramDouble);
  }
  
  public static class MBParams
  {
    public boolean adjust_thread_priority = true;
    public boolean allow_antialias_ = false;
    public boolean allow_opengl3 = true;
    public a.b animationFrameHandlerStrategy = a.b.eKs;
    public long app_brand_runtime = 0L;
    AssetManager asset_manager;
    public int cmd_pool_type = 1;
    public float device_pixel_ratio_ = -1.0F;
    public boolean disable_webgl2 = true;
    public boolean enable_2d = true;
    public boolean enable_font_batch = false;
    public boolean enable_gfx = true;
    public boolean enable_request_animation_frame = true;
    public boolean enable_window_attributes_alpha = false;
    public boolean enable_window_check = true;
    public boolean enable_wxbindcanvastexture = false;
    public IMBFileSystem file_system_ = null;
    public boolean force_run_v8_microtasks = false;
    public float gc_factor = 0.0F;
    public boolean is_game = false;
    public boolean perf_crazy_mode = false;
    public String render_thread_name;
    public boolean render_thread_profiler = false;
    public boolean revert_cpu_optimizer_test = false;
    public int screen_height_ = -1;
    public int screen_width_ = -1;
    public String sdcard_path;
    public boolean support_client_vertex_buffer = false;
    public boolean support_etc2_astc = false;
    public int support_gfximage_share_texture = 1;
    public boolean support_hardware_decode = true;
    public boolean support_hardware_encode = true;
    public boolean sync_surface_destroy = true;
    public boolean use_command_buffer = true;
  }
  
  static abstract interface a
  {
    public abstract void beforeSwap(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime
 * JD-Core Version:    0.7.0.1
 */