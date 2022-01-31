package com.tencent.magicbrush;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.support.annotation.Keep;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.c.a.b;
import com.tencent.magicbrush.c.g;
import com.tencent.magicbrush.d.c;
import com.tencent.magicbrush.handler.JsTouchEventHandler.a;
import com.tencent.magicbrush.handler.MBCanvasHandler;
import com.tencent.magicbrush.handler.MBJsThreadHandler;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.handler.glfont.h;
import com.tencent.magicbrush.handler.image.IMBImageHandler;
import com.tencent.magicbrush.handler.image.IMBImageHandler.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;

@Keep
public class MBRuntime
{
  private static final String TAG = "MicroMsg.MagicBrush.MBRuntime";
  private int __filed_touchJava;
  protected com.tencent.magicbrush.c.a mAnimationFrameHandler;
  private final MBCanvasHandler mCanvasHandler;
  private MBRuntime.IMBEventListener mClientEventListener;
  private IMBFontHandler mFontHandler;
  private IMBImageHandler mImageHandler;
  private volatile MBJsThreadHandler mJsThreadHandler;
  private ConcurrentLinkedQueue<MBRuntime.IMBEventListener> mListenerQueue;
  public volatile long mNativeInst;
  private MBParams mParams;
  private volatile int mScreenCanvasId;
  private volatile int mSystemDisplayHeight;
  private volatile int mSystemDisplayWidth;
  private boolean mainThreadWaitingFlag;
  private a mbInspector;
  private g mbView;
  
  static
  {
    AppMethodBeat.i(115838);
    com.tencent.magicbrush.a.b.loadLibraries();
    AppMethodBeat.o(115838);
  }
  
  public MBRuntime(MBParams paramMBParams)
  {
    AppMethodBeat.i(115804);
    this.mainThreadWaitingFlag = false;
    this.mImageHandler = null;
    this.mFontHandler = null;
    this.mListenerQueue = null;
    this.mClientEventListener = null;
    this.mSystemDisplayWidth = 0;
    this.mSystemDisplayHeight = 0;
    this.mScreenCanvasId = -1;
    this.mbInspector = new a(this);
    this.__filed_touchJava = 0;
    this.mParams = paramMBParams;
    if ((this.mParams.device_pixel_ratio_ <= 0.0D) || (this.mParams.screen_width_ <= 0) || (this.mParams.screen_height_ <= 0))
    {
      paramMBParams = new IllegalArgumentException("MBRuntime can only accept positive screen.");
      AppMethodBeat.o(115804);
      throw paramMBParams;
    }
    if ((this.mParams.gc_factor < 0.0F) || (this.mParams.gc_factor > 1.0F))
    {
      paramMBParams = new IllegalArgumentException("MBRuntime gc_factor can only accept [0, 1].");
      AppMethodBeat.o(115804);
      throw paramMBParams;
    }
    this.mNativeInst = nativeCreate(this.mParams);
    this.mClientEventListener = new MBRuntime.b(this, (byte)0);
    nativeSetEventListener(this.mNativeInst, this.mClientEventListener);
    this.mCanvasHandler = new MBCanvasHandler(this, this.mNativeInst);
    AppMethodBeat.o(115804);
  }
  
  @Keep
  private Bitmap captureScreen(Bitmap paramBitmap)
  {
    AppMethodBeat.i(115828);
    paramBitmap = getCanvasHandler().a(paramBitmap, true);
    AppMethodBeat.o(115828);
    return paramBitmap;
  }
  
  private native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3);
  
  private native long nativeCreate(MBParams paramMBParams);
  
  private native void nativeDebug(long paramLong, int paramInt);
  
  private native void nativeDestroy(long paramLong);
  
  private native int[] nativeGetCanvasSize(long paramLong, int paramInt);
  
  private native int nativeGetGLThreadTid(long paramLong);
  
  private native int nativeGetJsThreadTid(long paramLong);
  
  private native void nativeInit(long paramLong);
  
  private native void nativeNotifyAnimationFrame(long paramLong, double paramDouble);
  
  private native void nativeNotifyImageDecoded(long paramLong, String paramString, Object paramObject);
  
  private native void nativeNotifyTouchEvent(long paramLong1, long paramLong2);
  
  private native void nativeNotifyWindowAvailable(long paramLong, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);
  
  private native void nativeNotifyWindowChanged(long paramLong, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);
  
  private native void nativeNotifyWindowDestroyed(long paramLong);
  
  private native void nativePause(long paramLong);
  
  private native void nativeResetScreenCanvasFlag(long paramLong);
  
  private native void nativeResume(long paramLong);
  
  private native void nativeSetEventListener(long paramLong, MBRuntime.IMBEventListener paramIMBEventListener);
  
  private native void nativeSetFontHandler(long paramLong, IMBFontHandler paramIMBFontHandler);
  
  private native void nativeSetImageHandler(long paramLong, IMBImageHandler paramIMBImageHandler);
  
  private native void nativeSetJsThreadHandler(long paramLong1, long paramLong2);
  
  private native void nativeSetUserPreferredFps(long paramLong, double paramDouble);
  
  private void resetJavaClientRes()
  {
    AppMethodBeat.i(115817);
    if (this.mListenerQueue != null)
    {
      this.mListenerQueue.clear();
      this.mListenerQueue = null;
    }
    this.mClientEventListener = null;
    this.mImageHandler = null;
    this.mFontHandler = null;
    AppMethodBeat.o(115817);
  }
  
  @Keep
  private void touchJava()
  {
    this.__filed_touchJava += 1;
  }
  
  public void bindTo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(115806);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.BindTo", new Object[0]);
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115806);
      return;
    }
    MBJsThreadHandler localMBJsThreadHandler = this.mJsThreadHandler;
    if (localMBJsThreadHandler == null)
    {
      AppMethodBeat.o(115806);
      return;
    }
    localMBJsThreadHandler.i(new MBRuntime.1(this, paramLong1, paramLong2));
    AppMethodBeat.o(115806);
  }
  
  public void debug(int paramInt)
  {
    AppMethodBeat.i(115809);
    nativeDebug(this.mNativeInst, paramInt);
    AppMethodBeat.o(115809);
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: ldc_w 273
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 20
    //   8: ldc_w 275
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 256	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: getfield 129	com/tencent/magicbrush/MBRuntime:mNativeInst	J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifne +22 -> 46
    //   27: ldc 20
    //   29: ldc_w 277
    //   32: iconst_0
    //   33: anewarray 4	java/lang/Object
    //   36: invokestatic 256	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: ldc_w 273
    //   42: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   49: lstore_1
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 129	com/tencent/magicbrush/MBRuntime:mNativeInst	J
    //   56: lconst_0
    //   57: lcmp
    //   58: ifne +35 -> 93
    //   61: ldc 20
    //   63: ldc_w 285
    //   66: iconst_1
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   75: lload_1
    //   76: lsub
    //   77: invokestatic 291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   80: aastore
    //   81: invokestatic 256	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: monitorexit
    //   86: ldc_w 273
    //   89: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: return
    //   93: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   96: lstore_3
    //   97: aload_0
    //   98: getfield 100	com/tencent/magicbrush/MBRuntime:mParams	Lcom/tencent/magicbrush/MBRuntime$MBParams;
    //   101: getfield 294	com/tencent/magicbrush/MBRuntime$MBParams:enable_request_animation_frame	Z
    //   104: ifeq +88 -> 192
    //   107: aload_0
    //   108: getfield 296	com/tencent/magicbrush/MBRuntime:mAnimationFrameHandler	Lcom/tencent/magicbrush/c/a;
    //   111: astore 6
    //   113: ldc_w 298
    //   116: ldc_w 300
    //   119: iconst_1
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload 6
    //   127: invokevirtual 306	com/tencent/magicbrush/c/a:yx	()Lcom/tencent/magicbrush/c/a$b;
    //   130: invokevirtual 312	com/tencent/magicbrush/c/a$b:name	()Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 256	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 6
    //   139: getfield 316	com/tencent/magicbrush/c/a:bLl	Ljava/lang/Object;
    //   142: astore 5
    //   144: aload 5
    //   146: monitorenter
    //   147: aload 6
    //   149: getfield 319	com/tencent/magicbrush/c/a:isRunning	Z
    //   152: ifeq +32 -> 184
    //   155: ldc_w 298
    //   158: ldc_w 321
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload 6
    //   169: invokevirtual 306	com/tencent/magicbrush/c/a:yx	()Lcom/tencent/magicbrush/c/a$b;
    //   172: invokevirtual 312	com/tencent/magicbrush/c/a$b:name	()Ljava/lang/String;
    //   175: aastore
    //   176: invokestatic 256	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload 6
    //   181: invokevirtual 324	com/tencent/magicbrush/c/a:pause	()V
    //   184: getstatic 330	a/y:BMg	La/y;
    //   187: astore 6
    //   189: aload 5
    //   191: monitorexit
    //   192: aload_0
    //   193: aload_0
    //   194: getfield 129	com/tencent/magicbrush/MBRuntime:mNativeInst	J
    //   197: invokespecial 332	com/tencent/magicbrush/MBRuntime:nativeDestroy	(J)V
    //   200: aload_0
    //   201: aconst_null
    //   202: putfield 258	com/tencent/magicbrush/MBRuntime:mJsThreadHandler	Lcom/tencent/magicbrush/handler/MBJsThreadHandler;
    //   205: aload_0
    //   206: invokespecial 334	com/tencent/magicbrush/MBRuntime:resetJavaClientRes	()V
    //   209: aload_0
    //   210: lconst_0
    //   211: putfield 129	com/tencent/magicbrush/MBRuntime:mNativeInst	J
    //   214: aload_0
    //   215: aconst_null
    //   216: putfield 336	com/tencent/magicbrush/MBRuntime:mbView	Lcom/tencent/magicbrush/c/g;
    //   219: aload_0
    //   220: monitorexit
    //   221: ldc 20
    //   223: ldc_w 338
    //   226: iconst_2
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   235: lload_1
    //   236: lsub
    //   237: invokestatic 291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: lload_3
    //   244: lload_1
    //   245: lsub
    //   246: invokestatic 291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   249: aastore
    //   250: invokestatic 256	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: ldc_w 273
    //   256: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: return
    //   260: astore 6
    //   262: aload 5
    //   264: monitorexit
    //   265: ldc_w 273
    //   268: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload 6
    //   273: athrow
    //   274: astore 5
    //   276: aload_0
    //   277: monitorexit
    //   278: ldc_w 273
    //   281: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: aload 5
    //   286: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	MBRuntime
    //   49	196	1	l1	long
    //   96	148	3	l2	long
    //   274	11	5	localObject2	Object
    //   111	77	6	localObject3	Object
    //   260	12	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   147	184	260	finally
    //   184	189	260	finally
    //   52	86	274	finally
    //   93	147	274	finally
    //   189	192	274	finally
    //   192	221	274	finally
    //   262	274	274	finally
    //   276	278	274	finally
  }
  
  public MBCanvasHandler getCanvasHandler()
  {
    return this.mCanvasHandler;
  }
  
  public int[] getCanvasSize(int paramInt)
  {
    AppMethodBeat.i(115824);
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115824);
      return null;
    }
    int[] arrayOfInt = nativeGetCanvasSize(this.mNativeInst, paramInt);
    if ((arrayOfInt != null) && (arrayOfInt.length != 2))
    {
      AppMethodBeat.o(115824);
      return null;
    }
    AppMethodBeat.o(115824);
    return arrayOfInt;
  }
  
  public a.a getCurrentFps()
  {
    AppMethodBeat.i(115820);
    a.a locala = getInspector().getCurrentFps();
    AppMethodBeat.o(115820);
    return locala;
  }
  
  public IMBFontHandler getFontHandler()
  {
    return this.mFontHandler;
  }
  
  public int getGLThreadTid()
  {
    AppMethodBeat.i(115816);
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115816);
      return 0;
    }
    try
    {
      if (this.mNativeInst == 0L) {
        return 0;
      }
      int i = nativeGetGLThreadTid(this.mNativeInst);
      return i;
    }
    finally
    {
      AppMethodBeat.o(115816);
    }
  }
  
  public IMBImageHandler getImageHandler()
  {
    return this.mImageHandler;
  }
  
  public a getInspector()
  {
    return this.mbInspector;
  }
  
  public MBJsThreadHandler getJsThreadHandler()
  {
    return this.mJsThreadHandler;
  }
  
  public int getJsThreadTid()
  {
    AppMethodBeat.i(115815);
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115815);
      return 0;
    }
    try
    {
      if (this.mNativeInst == 0L) {
        return 0;
      }
      int i = nativeGetJsThreadTid(this.mNativeInst);
      return i;
    }
    finally
    {
      AppMethodBeat.o(115815);
    }
  }
  
  public g getMBRuntimeView()
  {
    return this.mbView;
  }
  
  public MBParams getParams()
  {
    return this.mParams;
  }
  
  public int getScreenCanvasId()
  {
    return this.mScreenCanvasId;
  }
  
  public int getSystemDisplayHeight()
  {
    return this.mSystemDisplayHeight;
  }
  
  public int getSystemDisplayWidth()
  {
    return this.mSystemDisplayWidth;
  }
  
  public void init()
  {
    AppMethodBeat.i(115805);
    if (this.mParams.enable_request_animation_frame) {
      this.mAnimationFrameHandler = com.tencent.magicbrush.c.a.a(this, this.mJsThreadHandler, getParams().animationFrameHandlerStrategy);
    }
    if (this.mFontHandler == null)
    {
      this.mFontHandler = new h();
      nativeSetFontHandler(this.mNativeInst, this.mFontHandler);
    }
    if (this.mImageHandler == null)
    {
      this.mImageHandler = new com.tencent.magicbrush.handler.image.a(this, this.mJsThreadHandler);
      nativeSetImageHandler(this.mNativeInst, this.mImageHandler);
    }
    IllegalStateException localIllegalStateException;
    if (this.mJsThreadHandler == null)
    {
      localIllegalStateException = new IllegalStateException("[MBRuntime] JsThreadHandler not registered.");
      AppMethodBeat.o(115805);
      throw localIllegalStateException;
    }
    if (this.mImageHandler == null)
    {
      localIllegalStateException = new IllegalStateException("[MBRuntime] ImageHandler not registered.");
      AppMethodBeat.o(115805);
      throw localIllegalStateException;
    }
    if (this.mFontHandler == null)
    {
      localIllegalStateException = new IllegalStateException("[MBRuntime] FontHandler not registered.");
      AppMethodBeat.o(115805);
      throw localIllegalStateException;
    }
    if (this.mNativeInst == 0L)
    {
      c.c.i("MicroMsg.MagicBrush.MBRuntime", "init. mNativeInst == 0", new Object[0]);
      AppMethodBeat.o(115805);
      return;
    }
    nativeInit(this.mNativeInst);
    AppMethodBeat.o(115805);
  }
  
  /* Error */
  public boolean isDestroyed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 129	com/tencent/magicbrush/MBRuntime:mNativeInst	J
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
  
  public boolean isDestroyedUnlock()
  {
    return this.mNativeInst == 0L;
  }
  
  public boolean isMainThreadWaiting()
  {
    return this.mainThreadWaitingFlag;
  }
  
  native float[] nativeGetCurrentFps(long paramLong);
  
  native float nativeGetCurrentFpsVariance(long paramLong);
  
  native int nativeGetDrawCalls(long paramLong);
  
  native int nativeGetFrameCounter(long paramLong);
  
  native int nativeGetTriangles(long paramLong);
  
  native int nativeGetVertexes(long paramLong);
  
  public native void nativeSetEnableInspectFpsVariance(long paramLong, boolean paramBoolean);
  
  public void notifyAnimationFrame(double paramDouble)
  {
    AppMethodBeat.i(115810);
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115810);
      return;
    }
    nativeNotifyAnimationFrame(this.mNativeInst, paramDouble);
    AppMethodBeat.o(115810);
  }
  
  public void notifyImageDecoded(final String paramString, final Object paramObject, final IMBImageHandler.a parama)
  {
    AppMethodBeat.i(115823);
    if (this.mNativeInst == 0L)
    {
      parama.U(paramObject);
      AppMethodBeat.o(115823);
      return;
    }
    MBJsThreadHandler localMBJsThreadHandler = this.mJsThreadHandler;
    if (localMBJsThreadHandler == null)
    {
      parama.U(paramObject);
      AppMethodBeat.o(115823);
      return;
    }
    localMBJsThreadHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151470);
        if (MBRuntime.this.mNativeInst == 0L)
        {
          parama.U(paramObject);
          AppMethodBeat.o(151470);
          return;
        }
        MBRuntime.access$1100(MBRuntime.this, MBRuntime.this.mNativeInst, paramString, paramObject);
        AppMethodBeat.o(151470);
      }
    });
    AppMethodBeat.o(115823);
  }
  
  public void notifyTouchEvent(long paramLong, JsTouchEventHandler.a parama)
  {
    AppMethodBeat.i(115822);
    if (this.mNativeInst == 0L)
    {
      parama.au(paramLong);
      AppMethodBeat.o(115822);
      return;
    }
    MBJsThreadHandler localMBJsThreadHandler = this.mJsThreadHandler;
    if (localMBJsThreadHandler == null)
    {
      parama.au(paramLong);
      AppMethodBeat.o(115822);
      return;
    }
    localMBJsThreadHandler.post(new MBRuntime.10(this, parama, paramLong));
    AppMethodBeat.o(115822);
  }
  
  public void notifyWindowAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115811);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowAvailable ", new Object[0]);
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115811);
      return;
    }
    MBJsThreadHandler localMBJsThreadHandler = this.mJsThreadHandler;
    if (localMBJsThreadHandler == null)
    {
      AppMethodBeat.o(115811);
      return;
    }
    localMBJsThreadHandler.post(new MBRuntime.5(this, paramSurfaceTexture, paramInt1, paramInt2));
    AppMethodBeat.o(115811);
  }
  
  public void notifyWindowChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115812);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged ", new Object[0]);
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115812);
      return;
    }
    MBJsThreadHandler localMBJsThreadHandler = this.mJsThreadHandler;
    if (localMBJsThreadHandler == null)
    {
      AppMethodBeat.o(115812);
      return;
    }
    localMBJsThreadHandler.post(new MBRuntime.6(this, paramSurfaceTexture, paramInt1, paramInt2));
    AppMethodBeat.o(115812);
  }
  
  public void notifyWindowDestroyed(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(155608);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowDestroyed shouldDestroySync: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(155608);
      return;
    }
    MBJsThreadHandler localMBJsThreadHandler = this.mJsThreadHandler;
    if (localMBJsThreadHandler == null)
    {
      AppMethodBeat.o(155608);
      return;
    }
    paramSurfaceTexture = new MBRuntime.7(this, paramSurfaceTexture);
    if (paramBoolean)
    {
      paramSurfaceTexture = new com.tencent.magicbrush.d.b(paramSurfaceTexture);
      localMBJsThreadHandler.i(paramSurfaceTexture);
      paramSurfaceTexture.await();
      AppMethodBeat.o(155608);
      return;
    }
    localMBJsThreadHandler.post(paramSurfaceTexture);
    AppMethodBeat.o(155608);
  }
  
  public void pause()
  {
    AppMethodBeat.i(115808);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.pause ", new Object[0]);
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115808);
      return;
    }
    MBJsThreadHandler localMBJsThreadHandler = this.mJsThreadHandler;
    if (localMBJsThreadHandler == null)
    {
      AppMethodBeat.o(115808);
      return;
    }
    localMBJsThreadHandler.post(new MBRuntime.4(this));
    AppMethodBeat.o(115808);
  }
  
  public void registerEventListener(MBRuntime.IMBEventListener paramIMBEventListener)
  {
    AppMethodBeat.i(115825);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.registerEventListener ", new Object[0]);
    if (this.mListenerQueue == null) {
      this.mListenerQueue = new ConcurrentLinkedQueue();
    }
    this.mListenerQueue.add(paramIMBEventListener);
    AppMethodBeat.o(115825);
  }
  
  @Deprecated
  public void resetScreenCanvasFlag()
  {
    AppMethodBeat.i(151471);
    c.a(this, new MBRuntime.8(this));
    AppMethodBeat.o(151471);
  }
  
  public void resume()
  {
    AppMethodBeat.i(115807);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.resume ", new Object[0]);
    if (this.mbView == null)
    {
      localObject = new IllegalStateException("MBRuntime can not resume, before a MBRuntimeView attached.");
      AppMethodBeat.o(115807);
      throw ((Throwable)localObject);
    }
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115807);
      return;
    }
    Object localObject = this.mJsThreadHandler;
    if (localObject == null)
    {
      AppMethodBeat.o(115807);
      return;
    }
    ((com.tencent.magicbrush.handler.a)localObject).post(new MBRuntime.3(this));
    AppMethodBeat.o(115807);
  }
  
  public void setFontHandler(IMBFontHandler paramIMBFontHandler)
  {
    AppMethodBeat.i(115819);
    this.mFontHandler = paramIMBFontHandler;
    nativeSetFontHandler(this.mNativeInst, paramIMBFontHandler);
    AppMethodBeat.o(115819);
  }
  
  public void setImageHandler(IMBImageHandler paramIMBImageHandler)
  {
    AppMethodBeat.i(115818);
    this.mImageHandler = paramIMBImageHandler;
    nativeSetImageHandler(this.mNativeInst, paramIMBImageHandler);
    AppMethodBeat.o(115818);
  }
  
  public void setJsThreadHandler(com.tencent.magicbrush.handler.a parama)
  {
    AppMethodBeat.i(115827);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.set_jsthread_handler ", new Object[0]);
    if (this.mJsThreadHandler != null)
    {
      c.c.e("MicroMsg.MagicBrush.MBRuntime", "Why you set_jsthread_handler twice, unexpected behaviour.", new Object[0]);
      AppMethodBeat.o(115827);
      return;
    }
    long l = this.mNativeInst;
    this.mJsThreadHandler = new MBJsThreadHandler(parama);
    AppMethodBeat.o(115827);
  }
  
  public void setMBRuntimeView(g paramg)
  {
    this.mbView = paramg;
  }
  
  public void setUserPreferredFps(double paramDouble)
  {
    AppMethodBeat.i(115821);
    if (this.mNativeInst == 0L)
    {
      AppMethodBeat.o(115821);
      return;
    }
    MBJsThreadHandler localMBJsThreadHandler = this.mJsThreadHandler;
    if (localMBJsThreadHandler == null)
    {
      AppMethodBeat.o(115821);
      return;
    }
    localMBJsThreadHandler.post(new MBRuntime.9(this, paramDouble));
    AppMethodBeat.o(115821);
  }
  
  public void unregisterEventListener(MBRuntime.IMBEventListener paramIMBEventListener)
  {
    AppMethodBeat.i(115826);
    c.c.i("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.unregisterEventListener ", new Object[0]);
    if (this.mListenerQueue == null)
    {
      paramIMBEventListener = new IllegalStateException("[MBRuntime:unregisterEventListener] You may make a mistake.");
      AppMethodBeat.o(115826);
      throw paramIMBEventListener;
    }
    this.mListenerQueue.remove(paramIMBEventListener);
    AppMethodBeat.o(115826);
  }
  
  @Keep
  public static class MBParams
  {
    public boolean adjust_thread_priority;
    public boolean allow_antialias_;
    public boolean allow_opengl3;
    public a.b animationFrameHandlerStrategy = a.b.bLp;
    public double device_pixel_ratio_;
    public boolean enable_2d = true;
    public boolean enable_request_animation_frame;
    public boolean enable_wxbindcanvastexture;
    public float gc_factor;
    public boolean perf_crazy_mode;
    public boolean render_thread_profiler;
    public int screen_height_;
    public int screen_width_;
    public boolean use_command_buffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime
 * JD-Core Version:    0.7.0.1
 */