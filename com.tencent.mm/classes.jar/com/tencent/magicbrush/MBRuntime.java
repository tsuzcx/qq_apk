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
import com.tencent.magicbrush.handler.glfont.h;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.magicbrush.utils.e;
import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.util.Arrays;
import java.util.concurrent.FutureTask;

public abstract class MBRuntime
{
  public c cbj = new c(this);
  protected MBParams clN;
  private a clO = null;
  protected IMBFileSystem clP = null;
  protected BaseImageDecodeService clQ = null;
  protected IMBFontHandler clR = null;
  public com.tencent.magicbrush.handler.b clS = null;
  public volatile com.tencent.magicbrush.handler.c clT;
  protected com.tencent.magicbrush.ui.a clU;
  private int clV = 0;
  protected volatile long mNativeInst;
  
  static {}
  
  private static void gM(int paramInt)
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
      localc = this.clT;
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
    return paramRunnable.cdt.isDone();
  }
  
  protected final void FI()
  {
    if (this.clN.enable_request_animation_frame) {
      this.clU = com.tencent.magicbrush.ui.a.a(this, this.clT, this.clN.animationFrameHandlerStrategy);
    }
    if (this.clR == null)
    {
      this.clR = new h();
      nativeSetFontHandler(this.mNativeInst, this.clR);
    }
    if (this.clT == null) {
      throw new IllegalStateException("[MBRuntime] JsThreadHandler not registered.");
    }
    if (this.clQ == null) {
      throw new IllegalStateException("[MBRuntime] ImageHandler not registered.");
    }
    if (this.clR == null) {
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
  
  public final void FJ()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.resume ", new Object[0]);
    c localc = this.cbj;
    if (localc.handler == null)
    {
      localc.handler = new Handler(Looper.getMainLooper());
      localc.handler.post(localc.clz);
    }
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139946);
        MBRuntime.this.nativeResume(MBRuntime.this.mNativeInst);
        if (MBRuntime.this.clN.enable_request_animation_frame) {
          MBRuntime.this.clU.resume();
        }
        AppMethodBeat.o(139946);
      }
    });
  }
  
  public final void FK()
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.pause ", new Object[0]);
    this.cbj.Fw();
    n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139947);
        if (MBRuntime.this.clN.enable_request_animation_frame) {
          MBRuntime.this.clU.pause();
        }
        MBRuntime.this.nativePause(MBRuntime.this.mNativeInst);
        AppMethodBeat.o(139947);
      }
    });
  }
  
  public final void FL()
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeNotifyAnimationFrameLooper(this.mNativeInst);
  }
  
  public final void FM()
  {
    if (this.mNativeInst == 0L) {
      return;
    }
    nativeStopAnimationFrameLooper(this.mNativeInst);
  }
  
  public final void FN()
  {
    if (this.mNativeInst == 0L) {}
    com.tencent.magicbrush.handler.c localc;
    do
    {
      return;
      localc = this.clT;
    } while (localc == null);
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190910);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          AppMethodBeat.o(190910);
          return;
        }
        MBRuntime.a(MBRuntime.this, MBRuntime.this.mNativeInst);
        AppMethodBeat.o(190910);
      }
    }, false);
  }
  
  public final BaseImageDecodeService FO()
  {
    return this.clQ;
  }
  
  public final IMBFontHandler FP()
  {
    return this.clR;
  }
  
  abstract b FQ();
  
  abstract MBViewManager FR();
  
  public final MBParams FS()
  {
    return this.clN;
  }
  
  public final com.tencent.magicbrush.handler.c FT()
  {
    return this.clT;
  }
  
  public final void a(int paramInt, final long paramLong, final JsTouchEventHandler.a parama)
  {
    if (this.mNativeInst == 0L)
    {
      parama.aM(paramLong);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.clT;
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
        MBRuntime.this.nativeNotifyTouchEvent(MBRuntime.this.mNativeInst, this.clX, paramLong);
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
    gM(paramInt);
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
    boolean bool = this.clN.sync_surface_destroy;
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
    gM(paramInt1);
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
    this.clQ = paramBaseImageDecodeService;
    nativeSetImageHandler(this.mNativeInst, paramBaseImageDecodeService);
  }
  
  final void a(a parama)
  {
    this.clO = parama;
    nativeMarkNeedCallbackBeforeSwapThisFrame(this.mNativeInst);
  }
  
  public final void a(com.tencent.magicbrush.handler.a parama)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.set_jsthread_handler ", new Object[0]);
    if (this.clT != null)
    {
      c.c.e("MicroMsg.MagicBrush.MBRuntime", "Why you set_jsthread_handler twice, unexpected behaviour.", new Object[0]);
      return;
    }
    long l = this.mNativeInst;
    this.clT = new com.tencent.magicbrush.handler.c(parama);
  }
  
  public final void a(IMBFontHandler paramIMBFontHandler)
  {
    this.clR = paramIMBFontHandler;
    nativeSetFontHandler(this.mNativeInst, paramIMBFontHandler);
  }
  
  @Keep
  protected void applyWindowAttributes(final int paramInt, final boolean paramBoolean)
  {
    f.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175885);
        MagicBrushView localMagicBrushView = MBRuntime.this.FR().findOrNull(paramInt);
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
  
  public final void b(final int paramInt1, final Surface paramSurface, final int paramInt2, final int paramInt3)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged Surface[%s] %d, %d", new Object[] { paramSurface, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    gM(paramInt1);
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
      paramc.ab(paramObject);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.clT;
    if (localc == null)
    {
      paramc.ab(paramObject);
      return;
    }
    localc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139945);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          paramc.ab(paramObject);
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
    if (this.clO != null) {
      this.clO.beforeSwap(paramBoolean);
    }
  }
  
  @Keep
  protected Bitmap captureScreen(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    Object localObject = FQ();
    if ((paramInt2 > 0) && (paramInt3 > 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramBitmap = String.format("captureScreenCanvas of [%d] [%d, %d]", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }, 3));
      k.g(paramBitmap, "java.lang.String.format(this, *args)");
      throw ((Throwable)new IllegalStateException(paramBitmap.toString()));
    }
    localObject = ((b)localObject).gK(paramInt1);
    if (localObject == null) {
      return null;
    }
    f localf = f.cpX;
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
    this.cbj.Fw();
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
    if (this.clN.enable_request_animation_frame) {
      this.clU.destroy();
    }
    nativeDestroy(this.mNativeInst);
    this.clT = null;
    this.clQ = null;
    this.clR = null;
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
      if (this.clS != null) {
        return this.clS.getAsyncableJsApis();
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
    //   3: getfield 117	com/tencent/magicbrush/MBRuntime:mNativeInst	J
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
      localc = this.clT;
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
    if (this.clS != null) {
      try
      {
        paramString1 = this.clS.a(paramString1, paramString2, paramInt, paramBoolean);
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
    gM(paramInt);
    if ((this.clN.sync_surface_destroy) || (paramBoolean)) {}
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
        c.c.e("MicroMsg.MagicBrush.MBRuntime", "notifyWindowDestroyed, but await fail. [deadlock]:    %s", new Object[] { this.clT.AV() });
      }
      return;
    }
    n(local3);
  }
  
  @Keep
  protected void switchToJsThread(final int paramInt)
  {
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread taskId: ".concat(String.valueOf(paramInt)), new Object[0]);
    if (this.clT != null) {
      try
      {
        this.clT.p(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(190911);
            c.c.i("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread Runnable taskId: " + paramInt, new Object[0]);
            MBRuntime.a(MBRuntime.this, MBRuntime.this.mNativeInst, paramInt);
            AppMethodBeat.o(190911);
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
    this.clV += 1;
  }
  
  @Keep
  public static class MBParams
  {
    public boolean adjust_thread_priority = true;
    public boolean allow_antialias_ = false;
    public boolean allow_opengl3 = true;
    public a.b animationFrameHandlerStrategy = a.b.coU;
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
    public boolean sync_surface_destroy = true;
    public boolean use_command_buffer = true;
  }
  
  static abstract interface a
  {
    public abstract void beforeSwap(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime
 * JD-Core Version:    0.7.0.1
 */