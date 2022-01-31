package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.util.Log;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class GameGLSurfaceView$j
  extends Thread
{
  private boolean jhu;
  boolean jhv;
  boolean jhw;
  private LinkedList<Runnable> jhx;
  private GameGLSurfaceView.i jhy;
  boolean mExited;
  boolean mFinishedCreatingEglSurface;
  private WeakReference<GameGLSurfaceView> mGLSurfaceViewWeakRef;
  boolean mHasSurface;
  boolean mHaveEglContext;
  boolean mHaveEglSurface;
  int mHeight;
  boolean mPaused;
  boolean mRenderComplete;
  private int mRenderMode;
  boolean mRequestPaused;
  boolean mRequestRender;
  private boolean mShouldExit;
  private boolean mShouldReleaseEglContext;
  boolean mSizeChanged;
  private boolean mSurfaceIsBad;
  boolean mWaitingForSurface;
  private boolean mWantRenderNotification;
  int mWidth;
  
  GameGLSurfaceView$j(WeakReference<GameGLSurfaceView> paramWeakReference)
  {
    AppMethodBeat.i(134077);
    this.jhx = new LinkedList();
    this.mSizeChanged = true;
    try
    {
      setPriority(10);
      label31:
      this.mWidth = 0;
      this.mHeight = 0;
      this.mRequestRender = true;
      this.mRenderMode = 1;
      this.mWantRenderNotification = false;
      this.mGLSurfaceViewWeakRef = paramWeakReference;
      AppMethodBeat.o(134077);
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  private void aQe()
  {
    AppMethodBeat.i(134081);
    Runnable localRunnable = null;
    label199:
    for (;;)
    {
      synchronized (GameGLSurfaceView.aQd())
      {
        if (!aQf())
        {
          AppMethodBeat.o(134081);
          return;
        }
        if (this.jhv)
        {
          this.jhv = false;
          c.c.i("MicroMsg.GLThread", "Request leave PAUSE_ALSO_DO_DRAW", new Object[0]);
          AppMethodBeat.o(134081);
          return;
        }
        if (this.jhx.isEmpty()) {
          break label199;
        }
        localRunnable = (Runnable)this.jhx.remove(0);
        if (localRunnable != null)
        {
          localRunnable.run();
          localRunnable = null;
        }
      }
      ??? = (GameGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
      if (??? != null) {
        try
        {
          GameGLSurfaceView.g((GameGLSurfaceView)???).aPL();
        }
        catch (Exception localException)
        {
          c.c.e("MicroMsg.GLThread", Log.getStackTraceString(localException) + " readyToPauseAlsoDoDraw while() ", new Object[0]);
        }
      } else {
        synchronized (GameGLSurfaceView.aQd())
        {
          this.mShouldExit = true;
          AppMethodBeat.o(134081);
          return;
        }
      }
    }
  }
  
  private boolean aQf()
  {
    return (this.mPaused) && (this.jhw) && (this.mWidth > 0) && (this.mHeight > 0) && ((!this.mRequestRender) || (this.mRenderMode == 1));
  }
  
  /* Error */
  private void guardedRun()
  {
    // Byte code:
    //   0: ldc 184
    //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: new 186	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i
    //   9: dup
    //   10: aload_0
    //   11: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   14: invokespecial 188	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:<init>	(Ljava/lang/ref/WeakReference;)V
    //   17: putfield 164	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:jhy	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 190	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglContext	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 192	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglSurface	Z
    //   30: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   33: astore 15
    //   35: aload 15
    //   37: monitorenter
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 72	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mWantRenderNotification	Z
    //   43: aload 15
    //   45: monitorexit
    //   46: iconst_0
    //   47: istore_3
    //   48: iconst_0
    //   49: istore 4
    //   51: iconst_0
    //   52: istore 5
    //   54: iconst_0
    //   55: istore 7
    //   57: iconst_0
    //   58: istore 9
    //   60: iconst_0
    //   61: istore 6
    //   63: iconst_0
    //   64: istore_2
    //   65: iconst_0
    //   66: istore 10
    //   68: iconst_0
    //   69: istore 11
    //   71: aconst_null
    //   72: astore 15
    //   74: iconst_0
    //   75: istore_1
    //   76: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   79: astore 16
    //   81: aload 16
    //   83: monitorenter
    //   84: iload_2
    //   85: istore 8
    //   87: iload_1
    //   88: istore_2
    //   89: iload 8
    //   91: istore_1
    //   92: aload_0
    //   93: getfield 156	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mShouldExit	Z
    //   96: ifeq +25 -> 121
    //   99: aload 16
    //   101: monitorexit
    //   102: ldc 184
    //   104: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore 16
    //   110: aload 15
    //   112: monitorexit
    //   113: ldc 184
    //   115: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload 16
    //   120: athrow
    //   121: aload_0
    //   122: getfield 158	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mPaused	Z
    //   125: ifne +62 -> 187
    //   128: aload_0
    //   129: getfield 194	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mFinishedCreatingEglSurface	Z
    //   132: ifeq +55 -> 187
    //   135: aload_0
    //   136: getfield 57	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:jhx	Ljava/util/LinkedList;
    //   139: invokevirtual 108	java/util/LinkedList:isEmpty	()Z
    //   142: ifne +45 -> 187
    //   145: aload_0
    //   146: getfield 57	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:jhx	Ljava/util/LinkedList;
    //   149: iconst_0
    //   150: invokevirtual 112	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   153: checkcast 114	java/lang/Runnable
    //   156: astore 15
    //   158: aload 16
    //   160: monitorexit
    //   161: aload 15
    //   163: ifnull +1014 -> 1177
    //   166: aload 15
    //   168: invokeinterface 117 1 0
    //   173: aconst_null
    //   174: astore 15
    //   176: iload_2
    //   177: istore 8
    //   179: iload_1
    //   180: istore_2
    //   181: iload 8
    //   183: istore_1
    //   184: goto -108 -> 76
    //   187: iconst_0
    //   188: istore 14
    //   190: aload_0
    //   191: getfield 158	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mPaused	Z
    //   194: aload_0
    //   195: getfield 196	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mRequestPaused	Z
    //   198: if_icmpeq +95 -> 293
    //   201: aload_0
    //   202: getfield 196	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mRequestPaused	Z
    //   205: istore 14
    //   207: aload_0
    //   208: aload_0
    //   209: getfield 196	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mRequestPaused	Z
    //   212: putfield 158	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mPaused	Z
    //   215: iload 14
    //   217: ifeq +472 -> 689
    //   220: aload_0
    //   221: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   224: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   227: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   230: astore 17
    //   232: aload 17
    //   234: ifnull +13 -> 247
    //   237: aload 17
    //   239: invokestatic 127	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$n;
    //   242: invokeinterface 199 1 0
    //   247: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   250: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   253: ldc 96
    //   255: new 134	java/lang/StringBuilder
    //   258: dup
    //   259: ldc 204
    //   261: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: aload_0
    //   265: getfield 158	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mPaused	Z
    //   268: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   271: ldc 212
    //   273: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: invokevirtual 216	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:getId	()J
    //   280: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   283: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: iconst_0
    //   287: anewarray 100	java/lang/Object
    //   290: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload_0
    //   294: getfield 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mShouldReleaseEglContext	Z
    //   297: ifeq +46 -> 343
    //   300: ldc 96
    //   302: new 134	java/lang/StringBuilder
    //   305: dup
    //   306: ldc 223
    //   308: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: aload_0
    //   312: invokevirtual 216	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:getId	()J
    //   315: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   318: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: iconst_0
    //   322: anewarray 100	java/lang/Object
    //   325: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: aload_0
    //   329: invokespecial 170	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:stopEglSurfaceLocked	()V
    //   332: aload_0
    //   333: invokespecial 175	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:stopEglContextLocked	()V
    //   336: aload_0
    //   337: iconst_0
    //   338: putfield 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mShouldReleaseEglContext	Z
    //   341: iconst_1
    //   342: istore_1
    //   343: iload 7
    //   345: istore 12
    //   347: iload 7
    //   349: ifeq +14 -> 363
    //   352: aload_0
    //   353: invokespecial 170	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:stopEglSurfaceLocked	()V
    //   356: aload_0
    //   357: invokespecial 175	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:stopEglContextLocked	()V
    //   360: iconst_0
    //   361: istore 12
    //   363: iload 14
    //   365: ifeq +42 -> 407
    //   368: aload_0
    //   369: getfield 192	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglSurface	Z
    //   372: ifeq +35 -> 407
    //   375: ldc 96
    //   377: new 134	java/lang/StringBuilder
    //   380: dup
    //   381: ldc 225
    //   383: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   386: aload_0
    //   387: invokevirtual 216	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:getId	()J
    //   390: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   393: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: iconst_0
    //   397: anewarray 100	java/lang/Object
    //   400: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: aload_0
    //   404: invokespecial 170	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:stopEglSurfaceLocked	()V
    //   407: iload 14
    //   409: ifeq +67 -> 476
    //   412: aload_0
    //   413: getfield 190	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglContext	Z
    //   416: ifeq +60 -> 476
    //   419: aload_0
    //   420: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   423: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   426: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   429: astore 17
    //   431: aload 17
    //   433: ifnonnull +347 -> 780
    //   436: iconst_0
    //   437: istore 14
    //   439: iload 14
    //   441: ifne +35 -> 476
    //   444: aload_0
    //   445: invokespecial 175	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:stopEglContextLocked	()V
    //   448: ldc 96
    //   450: new 134	java/lang/StringBuilder
    //   453: dup
    //   454: ldc 227
    //   456: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   459: aload_0
    //   460: invokevirtual 216	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:getId	()J
    //   463: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   466: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: iconst_0
    //   470: anewarray 100	java/lang/Object
    //   473: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   476: aload_0
    //   477: getfield 229	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHasSurface	Z
    //   480: ifne +65 -> 545
    //   483: aload_0
    //   484: getfield 231	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mWaitingForSurface	Z
    //   487: ifne +58 -> 545
    //   490: ldc 96
    //   492: new 134	java/lang/StringBuilder
    //   495: dup
    //   496: ldc 233
    //   498: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   501: aload_0
    //   502: invokevirtual 216	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:getId	()J
    //   505: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   508: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: iconst_0
    //   512: anewarray 100	java/lang/Object
    //   515: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   518: aload_0
    //   519: getfield 192	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglSurface	Z
    //   522: ifeq +7 -> 529
    //   525: aload_0
    //   526: invokespecial 170	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:stopEglSurfaceLocked	()V
    //   529: aload_0
    //   530: iconst_1
    //   531: putfield 231	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mWaitingForSurface	Z
    //   534: aload_0
    //   535: iconst_0
    //   536: putfield 235	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mSurfaceIsBad	Z
    //   539: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   542: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   545: aload_0
    //   546: getfield 229	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHasSurface	Z
    //   549: ifeq +49 -> 598
    //   552: aload_0
    //   553: getfield 231	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mWaitingForSurface	Z
    //   556: ifeq +42 -> 598
    //   559: ldc 96
    //   561: new 134	java/lang/StringBuilder
    //   564: dup
    //   565: ldc 237
    //   567: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   570: aload_0
    //   571: invokevirtual 216	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:getId	()J
    //   574: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   577: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: iconst_0
    //   581: anewarray 100	java/lang/Object
    //   584: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   587: aload_0
    //   588: iconst_0
    //   589: putfield 231	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mWaitingForSurface	Z
    //   592: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   595: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   598: iload 6
    //   600: istore 13
    //   602: iload 6
    //   604: ifeq +50 -> 654
    //   607: ldc 96
    //   609: new 134	java/lang/StringBuilder
    //   612: dup
    //   613: ldc 239
    //   615: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   618: aload_0
    //   619: invokevirtual 216	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:getId	()J
    //   622: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   625: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: iconst_0
    //   629: anewarray 100	java/lang/Object
    //   632: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: aload_0
    //   636: iconst_0
    //   637: putfield 72	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mWantRenderNotification	Z
    //   640: iconst_0
    //   641: istore 13
    //   643: aload_0
    //   644: iconst_1
    //   645: putfield 241	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mRenderComplete	Z
    //   648: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   651: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   654: aload_0
    //   655: getfield 190	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglContext	Z
    //   658: ifne +179 -> 837
    //   661: ldc 96
    //   663: ldc 243
    //   665: iconst_0
    //   666: anewarray 100	java/lang/Object
    //   669: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: iload_1
    //   673: ifeq +117 -> 790
    //   676: iconst_0
    //   677: istore_1
    //   678: iload 13
    //   680: istore 6
    //   682: iload 12
    //   684: istore 7
    //   686: goto -528 -> 158
    //   689: aload_0
    //   690: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   693: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   696: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   699: astore 17
    //   701: aload 17
    //   703: ifnull -456 -> 247
    //   706: aload 17
    //   708: invokestatic 127	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$n;
    //   711: invokeinterface 246 1 0
    //   716: goto -469 -> 247
    //   719: astore 15
    //   721: aload 16
    //   723: monitorexit
    //   724: ldc 184
    //   726: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   729: aload 15
    //   731: athrow
    //   732: astore 15
    //   734: ldc 96
    //   736: aload 15
    //   738: ldc 248
    //   740: iconst_0
    //   741: anewarray 100	java/lang/Object
    //   744: invokestatic 252	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   747: aload_0
    //   748: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   751: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   754: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   757: astore 15
    //   759: aload 15
    //   761: ifnull +13 -> 774
    //   764: aload 15
    //   766: invokestatic 127	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$n;
    //   769: invokeinterface 255 1 0
    //   774: ldc 184
    //   776: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   779: return
    //   780: aload 17
    //   782: invokestatic 259	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:h	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Z
    //   785: istore 14
    //   787: goto -348 -> 439
    //   790: aload_0
    //   791: getfield 164	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:jhy	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i;
    //   794: invokevirtual 262	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:start	()V
    //   797: aload_0
    //   798: iconst_1
    //   799: putfield 190	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglContext	Z
    //   802: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   805: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   808: iconst_1
    //   809: istore_3
    //   810: iload 13
    //   812: istore 6
    //   814: iload 12
    //   816: istore 7
    //   818: goto -660 -> 158
    //   821: astore 15
    //   823: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   826: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   829: ldc 184
    //   831: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   834: aload 15
    //   836: athrow
    //   837: aload_0
    //   838: invokevirtual 265	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:readyToDraw	()Z
    //   841: ifeq +1548 -> 2389
    //   844: iload_3
    //   845: istore 6
    //   847: aload_0
    //   848: getfield 190	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglContext	Z
    //   851: ifne +1547 -> 2398
    //   854: ldc 96
    //   856: ldc 243
    //   858: iconst_0
    //   859: anewarray 100	java/lang/Object
    //   862: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   865: iload_1
    //   866: ifeq +191 -> 1057
    //   869: iconst_0
    //   870: istore_1
    //   871: iload_2
    //   872: istore 7
    //   874: iload 4
    //   876: istore 6
    //   878: iload 5
    //   880: istore 8
    //   882: aload_0
    //   883: getfield 190	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglContext	Z
    //   886: ifeq +47 -> 933
    //   889: iload_2
    //   890: istore 7
    //   892: iload 4
    //   894: istore 6
    //   896: iload 5
    //   898: istore 8
    //   900: aload_0
    //   901: getfield 192	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglSurface	Z
    //   904: ifne +29 -> 933
    //   907: ldc 96
    //   909: ldc_w 267
    //   912: iconst_0
    //   913: anewarray 100	java/lang/Object
    //   916: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   919: aload_0
    //   920: iconst_1
    //   921: putfield 192	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglSurface	Z
    //   924: iconst_1
    //   925: istore 6
    //   927: iconst_1
    //   928: istore 8
    //   930: iconst_1
    //   931: istore 7
    //   933: aload_0
    //   934: getfield 192	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglSurface	Z
    //   937: ifeq +160 -> 1097
    //   940: aload_0
    //   941: getfield 59	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mSizeChanged	Z
    //   944: ifeq +1431 -> 2375
    //   947: iconst_1
    //   948: istore 7
    //   950: aload_0
    //   951: getfield 64	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mWidth	I
    //   954: istore_2
    //   955: aload_0
    //   956: getfield 66	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHeight	I
    //   959: istore 4
    //   961: aload_0
    //   962: iconst_1
    //   963: putfield 72	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mWantRenderNotification	Z
    //   966: ldc 96
    //   968: new 134	java/lang/StringBuilder
    //   971: dup
    //   972: ldc_w 269
    //   975: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   978: aload_0
    //   979: invokevirtual 216	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:getId	()J
    //   982: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   985: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: iconst_0
    //   989: anewarray 100	java/lang/Object
    //   992: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   995: iconst_1
    //   996: istore 5
    //   998: aload_0
    //   999: iconst_0
    //   1000: putfield 59	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mSizeChanged	Z
    //   1003: aload_0
    //   1004: iconst_0
    //   1005: putfield 68	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mRequestRender	Z
    //   1008: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   1011: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   1014: aload_0
    //   1015: getfield 72	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mWantRenderNotification	Z
    //   1018: istore 14
    //   1020: iload 14
    //   1022: ifeq +1324 -> 2346
    //   1025: iconst_1
    //   1026: istore 9
    //   1028: iload 4
    //   1030: istore 11
    //   1032: iload_2
    //   1033: istore 10
    //   1035: iload 7
    //   1037: istore_2
    //   1038: iload 13
    //   1040: istore 6
    //   1042: iload 12
    //   1044: istore 7
    //   1046: iload 5
    //   1048: istore 4
    //   1050: iload 8
    //   1052: istore 5
    //   1054: goto -896 -> 158
    //   1057: aload_0
    //   1058: getfield 164	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:jhy	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i;
    //   1061: invokevirtual 262	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:start	()V
    //   1064: aload_0
    //   1065: iconst_1
    //   1066: putfield 190	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mHaveEglContext	Z
    //   1069: iconst_1
    //   1070: istore 6
    //   1072: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   1075: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   1078: goto +1320 -> 2398
    //   1081: astore 15
    //   1083: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   1086: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   1089: ldc 184
    //   1091: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1094: aload 15
    //   1096: athrow
    //   1097: ldc 96
    //   1099: ldc_w 271
    //   1102: iconst_0
    //   1103: anewarray 100	java/lang/Object
    //   1106: invokestatic 154	com/tencent/magicbrush/a/c$c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1109: iload 8
    //   1111: istore 5
    //   1113: iload 6
    //   1115: istore 4
    //   1117: iload 7
    //   1119: istore_2
    //   1120: aload_0
    //   1121: invokespecial 92	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:aQf	()Z
    //   1124: ifeq +36 -> 1160
    //   1127: ldc 96
    //   1129: ldc_w 273
    //   1132: iconst_1
    //   1133: anewarray 100	java/lang/Object
    //   1136: dup
    //   1137: iconst_0
    //   1138: aload_0
    //   1139: getfield 158	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mPaused	Z
    //   1142: invokestatic 279	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1145: aastore
    //   1146: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1149: iload 13
    //   1151: istore 6
    //   1153: iload 12
    //   1155: istore 7
    //   1157: goto -999 -> 158
    //   1160: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   1163: invokevirtual 282	java/lang/Object:wait	()V
    //   1166: iload 13
    //   1168: istore 6
    //   1170: iload 12
    //   1172: istore 7
    //   1174: goto -1082 -> 92
    //   1177: iload 4
    //   1179: ifeq +1164 -> 2343
    //   1182: ldc 96
    //   1184: ldc_w 284
    //   1187: iconst_0
    //   1188: anewarray 100	java/lang/Object
    //   1191: invokestatic 287	com/tencent/magicbrush/a/c$c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1194: aload_0
    //   1195: getfield 164	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:jhy	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i;
    //   1198: astore 16
    //   1200: ldc 96
    //   1202: new 134	java/lang/StringBuilder
    //   1205: dup
    //   1206: ldc_w 289
    //   1209: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1212: invokestatic 293	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1215: invokevirtual 294	java/lang/Thread:getId	()J
    //   1218: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: iconst_0
    //   1225: anewarray 100	java/lang/Object
    //   1228: invokestatic 287	com/tencent/magicbrush/a/c$c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1231: aload 16
    //   1233: getfield 298	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1236: ifnonnull +33 -> 1269
    //   1239: new 183	java/lang/RuntimeException
    //   1242: dup
    //   1243: ldc_w 300
    //   1246: invokespecial 301	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1249: astore 15
    //   1251: ldc 184
    //   1253: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1256: aload 15
    //   1258: athrow
    //   1259: astore 15
    //   1261: ldc 184
    //   1263: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1266: aload 15
    //   1268: athrow
    //   1269: aload 16
    //   1271: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1274: ifnonnull +23 -> 1297
    //   1277: new 183	java/lang/RuntimeException
    //   1280: dup
    //   1281: ldc_w 307
    //   1284: invokespecial 301	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1287: astore 15
    //   1289: ldc 184
    //   1291: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1294: aload 15
    //   1296: athrow
    //   1297: aload 16
    //   1299: getfield 311	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1302: ifnonnull +23 -> 1325
    //   1305: new 183	java/lang/RuntimeException
    //   1308: dup
    //   1309: ldc_w 313
    //   1312: invokespecial 301	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1315: astore 15
    //   1317: ldc 184
    //   1319: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1322: aload 15
    //   1324: athrow
    //   1325: aload 16
    //   1327: invokevirtual 316	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:destroySurfaceImp	()V
    //   1330: aload 16
    //   1332: getfield 317	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1335: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1338: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   1341: astore 17
    //   1343: aload 17
    //   1345: ifnull +352 -> 1697
    //   1348: aload 16
    //   1350: aload 17
    //   1352: invokestatic 320	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:d	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$h;
    //   1355: aload 16
    //   1357: getfield 298	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1360: aload 16
    //   1362: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1365: aload 16
    //   1367: getfield 311	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1370: aload 17
    //   1372: invokevirtual 324	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   1375: invokeinterface 330 5 0
    //   1380: putfield 334	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1383: aload 16
    //   1385: getfield 334	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1388: ifnull +14 -> 1402
    //   1391: aload 16
    //   1393: getfield 334	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1396: getstatic 339	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1399: if_acmpne +307 -> 1706
    //   1402: aload 16
    //   1404: getfield 298	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1407: invokeinterface 343 1 0
    //   1412: sipush 12299
    //   1415: if_icmpne +989 -> 2404
    //   1418: ldc 96
    //   1420: ldc_w 345
    //   1423: iconst_0
    //   1424: anewarray 100	java/lang/Object
    //   1427: invokestatic 154	com/tencent/magicbrush/a/c$c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1430: goto +974 -> 2404
    //   1433: iload 8
    //   1435: ifeq +383 -> 1818
    //   1438: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   1441: astore 16
    //   1443: aload 16
    //   1445: monitorenter
    //   1446: aload_0
    //   1447: iconst_1
    //   1448: putfield 194	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mFinishedCreatingEglSurface	Z
    //   1451: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   1454: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   1457: aload 16
    //   1459: monitorexit
    //   1460: iload_3
    //   1461: ifne +949 -> 2410
    //   1464: ldc 96
    //   1466: ldc_w 347
    //   1469: iconst_0
    //   1470: anewarray 100	java/lang/Object
    //   1473: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1476: aload_0
    //   1477: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1480: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1483: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   1486: astore 16
    //   1488: aload 16
    //   1490: ifnull +920 -> 2410
    //   1493: aload 16
    //   1495: invokestatic 127	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$n;
    //   1498: invokeinterface 350 1 0
    //   1503: goto +907 -> 2410
    //   1506: iload 5
    //   1508: istore 8
    //   1510: iload 5
    //   1512: ifeq +127 -> 1639
    //   1515: ldc 96
    //   1517: ldc_w 352
    //   1520: iconst_0
    //   1521: anewarray 100	java/lang/Object
    //   1524: invokestatic 287	com/tencent/magicbrush/a/c$c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1527: aload_0
    //   1528: getfield 164	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:jhy	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i;
    //   1531: astore 17
    //   1533: aload 17
    //   1535: getfield 356	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   1538: invokevirtual 362	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
    //   1541: astore 16
    //   1543: aload 17
    //   1545: getfield 317	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1548: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1551: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   1554: astore 17
    //   1556: aload 17
    //   1558: ifnull +858 -> 2416
    //   1561: aload 17
    //   1563: invokestatic 365	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:e	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$l;
    //   1566: ifnull +15 -> 1581
    //   1569: aload 17
    //   1571: invokestatic 365	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:e	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$l;
    //   1574: invokeinterface 370 1 0
    //   1579: astore 16
    //   1581: aload 17
    //   1583: invokestatic 374	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:f	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)I
    //   1586: iconst_3
    //   1587: iand
    //   1588: ifeq +828 -> 2416
    //   1591: iconst_0
    //   1592: istore 5
    //   1594: aload 17
    //   1596: invokestatic 374	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:f	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)I
    //   1599: iconst_1
    //   1600: iand
    //   1601: ifeq +6 -> 1607
    //   1604: iconst_1
    //   1605: istore 5
    //   1607: aload 17
    //   1609: invokestatic 374	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:f	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)I
    //   1612: iconst_2
    //   1613: iand
    //   1614: ifeq +778 -> 2392
    //   1617: new 376	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$m
    //   1620: dup
    //   1621: invokespecial 377	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$m:<init>	()V
    //   1624: astore 17
    //   1626: aload 16
    //   1628: iload 5
    //   1630: aload 17
    //   1632: invokestatic 383	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
    //   1635: pop
    //   1636: goto +780 -> 2416
    //   1639: iload_3
    //   1640: ifeq +11 -> 1651
    //   1643: aload_0
    //   1644: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1647: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1650: pop
    //   1651: iload_3
    //   1652: ifeq +244 -> 1896
    //   1655: ldc 96
    //   1657: ldc_w 385
    //   1660: iconst_0
    //   1661: anewarray 100	java/lang/Object
    //   1664: invokestatic 287	com/tencent/magicbrush/a/c$c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1667: aload_0
    //   1668: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1671: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1674: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   1677: astore 16
    //   1679: aload 16
    //   1681: ifnull +200 -> 1881
    //   1684: aload 16
    //   1686: invokestatic 127	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$n;
    //   1689: invokeinterface 388 1 0
    //   1694: goto +728 -> 2422
    //   1697: aload 16
    //   1699: aconst_null
    //   1700: putfield 334	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1703: goto -320 -> 1383
    //   1706: aload 16
    //   1708: getfield 298	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1711: aload 16
    //   1713: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1716: aload 16
    //   1718: getfield 334	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1721: aload 16
    //   1723: getfield 334	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1726: aload 16
    //   1728: getfield 356	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   1731: invokeinterface 392 5 0
    //   1736: ifne +28 -> 1764
    //   1739: ldc_w 394
    //   1742: ldc_w 395
    //   1745: aload 16
    //   1747: getfield 298	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1750: invokeinterface 343 1 0
    //   1755: invokestatic 399	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1758: iconst_0
    //   1759: istore 8
    //   1761: goto -328 -> 1433
    //   1764: aload 16
    //   1766: getfield 402	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:jht	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1769: ifnull +30 -> 1799
    //   1772: aload 16
    //   1774: getfield 298	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1777: aload 16
    //   1779: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1782: aload 16
    //   1784: getfield 402	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:jht	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1787: invokeinterface 406 3 0
    //   1792: pop
    //   1793: aload 16
    //   1795: aconst_null
    //   1796: putfield 402	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:jht	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1799: iconst_1
    //   1800: istore 8
    //   1802: goto -369 -> 1433
    //   1805: astore 15
    //   1807: aload 16
    //   1809: monitorexit
    //   1810: ldc 184
    //   1812: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1815: aload 15
    //   1817: athrow
    //   1818: ldc 96
    //   1820: ldc_w 408
    //   1823: iconst_0
    //   1824: anewarray 100	java/lang/Object
    //   1827: invokestatic 154	com/tencent/magicbrush/a/c$c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1830: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   1833: astore 16
    //   1835: aload 16
    //   1837: monitorenter
    //   1838: aload_0
    //   1839: iconst_1
    //   1840: putfield 194	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mFinishedCreatingEglSurface	Z
    //   1843: aload_0
    //   1844: iconst_1
    //   1845: putfield 235	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mSurfaceIsBad	Z
    //   1848: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   1851: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   1854: aload 16
    //   1856: monitorexit
    //   1857: iload_2
    //   1858: istore 8
    //   1860: iload_1
    //   1861: istore_2
    //   1862: iload 8
    //   1864: istore_1
    //   1865: goto -1789 -> 76
    //   1868: astore 15
    //   1870: aload 16
    //   1872: monitorexit
    //   1873: ldc 184
    //   1875: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1878: aload 15
    //   1880: athrow
    //   1881: ldc 96
    //   1883: ldc_w 410
    //   1886: iconst_0
    //   1887: anewarray 100	java/lang/Object
    //   1890: invokestatic 154	com/tencent/magicbrush/a/c$c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1893: goto +529 -> 2422
    //   1896: iload_2
    //   1897: ifeq +443 -> 2340
    //   1900: ldc 96
    //   1902: new 134	java/lang/StringBuilder
    //   1905: dup
    //   1906: ldc_w 412
    //   1909: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1912: iload 10
    //   1914: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1917: ldc_w 417
    //   1920: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: iload 11
    //   1925: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1928: ldc_w 419
    //   1931: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1937: iconst_0
    //   1938: anewarray 100	java/lang/Object
    //   1941: invokestatic 287	com/tencent/magicbrush/a/c$c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1944: aload_0
    //   1945: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1948: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1951: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   1954: astore 16
    //   1956: aload 16
    //   1958: ifnull +481 -> 2439
    //   1961: aload 16
    //   1963: invokestatic 127	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$n;
    //   1966: iload 10
    //   1968: iload 11
    //   1970: invokeinterface 423 3 0
    //   1975: ldc 96
    //   1977: ldc_w 425
    //   1980: iconst_0
    //   1981: anewarray 100	java/lang/Object
    //   1984: invokestatic 154	com/tencent/magicbrush/a/c$c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1987: goto +452 -> 2439
    //   1990: aload_0
    //   1991: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1994: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1997: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   2000: astore 16
    //   2002: aload 16
    //   2004: ifnull +13 -> 2017
    //   2007: aload 16
    //   2009: invokestatic 127	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$n;
    //   2012: invokeinterface 132 1 0
    //   2017: aload_0
    //   2018: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   2021: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2024: pop
    //   2025: sipush 12288
    //   2028: istore 12
    //   2030: iconst_1
    //   2031: istore 14
    //   2033: aload_0
    //   2034: getfield 74	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   2037: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2040: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView
    //   2043: astore 16
    //   2045: aload 16
    //   2047: ifnull +10 -> 2057
    //   2050: aload 16
    //   2052: invokevirtual 428	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:getIsSwapNow	()Z
    //   2055: istore 14
    //   2057: iload 14
    //   2059: ifeq +107 -> 2166
    //   2062: aload_0
    //   2063: getfield 164	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:jhy	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i;
    //   2066: astore 17
    //   2068: sipush 12288
    //   2071: istore 5
    //   2073: iload 5
    //   2075: istore 12
    //   2077: aload 17
    //   2079: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2082: ifnull +84 -> 2166
    //   2085: iload 5
    //   2087: istore 12
    //   2089: aload 17
    //   2091: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2094: getstatic 431	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2097: if_acmpeq +69 -> 2166
    //   2100: iload 5
    //   2102: istore 12
    //   2104: aload 17
    //   2106: getfield 334	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2109: ifnull +57 -> 2166
    //   2112: iload 5
    //   2114: istore 12
    //   2116: aload 17
    //   2118: getfield 334	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2121: getstatic 339	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2124: if_acmpeq +42 -> 2166
    //   2127: iload 5
    //   2129: istore 12
    //   2131: aload 17
    //   2133: getfield 298	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   2136: aload 17
    //   2138: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2141: aload 17
    //   2143: getfield 334	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2146: invokeinterface 434 3 0
    //   2151: ifne +15 -> 2166
    //   2154: aload 17
    //   2156: getfield 298	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   2159: invokeinterface 343 1 0
    //   2164: istore 12
    //   2166: aload 16
    //   2168: ifnull +276 -> 2444
    //   2171: aload 16
    //   2173: iconst_1
    //   2174: invokevirtual 438	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:setSwapNow	(Z)V
    //   2177: goto +267 -> 2444
    //   2180: ldc_w 440
    //   2183: ldc_w 441
    //   2186: iload 12
    //   2188: invokestatic 399	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$i:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2191: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   2194: astore 16
    //   2196: aload 16
    //   2198: monitorenter
    //   2199: aload_0
    //   2200: iconst_1
    //   2201: putfield 235	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:mSurfaceIsBad	Z
    //   2204: invokestatic 88	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView:aQd	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$k;
    //   2207: invokevirtual 202	java/lang/Object:notifyAll	()V
    //   2210: aload 16
    //   2212: monitorexit
    //   2213: iload 7
    //   2215: istore 5
    //   2217: iload 9
    //   2219: ifeq +110 -> 2329
    //   2222: iconst_1
    //   2223: istore 7
    //   2225: iconst_0
    //   2226: istore 6
    //   2228: aload_0
    //   2229: invokespecial 443	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:aQe	()V
    //   2232: iload 6
    //   2234: istore 9
    //   2236: iload_2
    //   2237: istore 12
    //   2239: iload 7
    //   2241: istore 6
    //   2243: iload 5
    //   2245: istore 7
    //   2247: iload_1
    //   2248: istore_2
    //   2249: iload 8
    //   2251: istore 5
    //   2253: iload 12
    //   2255: istore_1
    //   2256: goto -2180 -> 76
    //   2259: astore 15
    //   2261: ldc 96
    //   2263: ldc_w 425
    //   2266: iconst_0
    //   2267: anewarray 100	java/lang/Object
    //   2270: invokestatic 154	com/tencent/magicbrush/a/c$c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2273: ldc 184
    //   2275: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2278: aload 15
    //   2280: athrow
    //   2281: ldc 96
    //   2283: new 134	java/lang/StringBuilder
    //   2286: dup
    //   2287: ldc_w 445
    //   2290: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2293: aload_0
    //   2294: invokevirtual 216	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$j:getId	()J
    //   2297: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2300: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2303: iconst_0
    //   2304: anewarray 100	java/lang/Object
    //   2307: invokestatic 105	com/tencent/magicbrush/a/c$c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2310: iconst_1
    //   2311: istore 5
    //   2313: goto -96 -> 2217
    //   2316: astore 15
    //   2318: aload 16
    //   2320: monitorexit
    //   2321: ldc 184
    //   2323: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2326: aload 15
    //   2328: athrow
    //   2329: iload 6
    //   2331: istore 7
    //   2333: iload 9
    //   2335: istore 6
    //   2337: goto -109 -> 2228
    //   2340: goto -350 -> 1990
    //   2343: goto -837 -> 1506
    //   2346: iload 4
    //   2348: istore 11
    //   2350: iload_2
    //   2351: istore 10
    //   2353: iload 7
    //   2355: istore_2
    //   2356: iload 13
    //   2358: istore 6
    //   2360: iload 12
    //   2362: istore 7
    //   2364: iload 5
    //   2366: istore 4
    //   2368: iload 8
    //   2370: istore 5
    //   2372: goto -2214 -> 158
    //   2375: iload 11
    //   2377: istore 4
    //   2379: iload 10
    //   2381: istore_2
    //   2382: iload 6
    //   2384: istore 5
    //   2386: goto -1383 -> 1003
    //   2389: goto -1269 -> 1120
    //   2392: aconst_null
    //   2393: astore 17
    //   2395: goto -769 -> 1626
    //   2398: iload 6
    //   2400: istore_3
    //   2401: goto -1530 -> 871
    //   2404: iconst_0
    //   2405: istore 8
    //   2407: goto -974 -> 1433
    //   2410: iconst_0
    //   2411: istore 4
    //   2413: goto -907 -> 1506
    //   2416: iconst_0
    //   2417: istore 8
    //   2419: goto -780 -> 1639
    //   2422: iconst_0
    //   2423: istore_3
    //   2424: iload_2
    //   2425: istore 12
    //   2427: iload_1
    //   2428: istore_2
    //   2429: iload 8
    //   2431: istore 5
    //   2433: iload 12
    //   2435: istore_1
    //   2436: goto -2360 -> 76
    //   2439: iconst_0
    //   2440: istore_2
    //   2441: goto -451 -> 1990
    //   2444: iload 7
    //   2446: istore 5
    //   2448: iload 12
    //   2450: lookupswitch	default:+26->2476, 12288:+-233->2217, 12302:+-169->2281
    //   2477: impdep1
    //   2478: <illegal opcode>
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2479	0	this	j
    //   75	2361	1	i	int
    //   64	2377	2	j	int
    //   47	2377	3	k	int
    //   49	2363	4	m	int
    //   52	2395	5	n	int
    //   61	2338	6	i1	int
    //   55	2390	7	i2	int
    //   85	2345	8	i3	int
    //   58	2276	9	i4	int
    //   66	2314	10	i5	int
    //   69	2307	11	i6	int
    //   345	2104	12	i7	int
    //   600	1757	13	i8	int
    //   188	1870	14	bool	boolean
    //   33	142	15	localObject1	Object
    //   719	11	15	localObject2	Object
    //   732	5	15	localThrowable	Throwable
    //   757	8	15	localGameGLSurfaceView	GameGLSurfaceView
    //   821	14	15	localRuntimeException1	java.lang.RuntimeException
    //   1081	14	15	localRuntimeException2	java.lang.RuntimeException
    //   1249	8	15	localRuntimeException3	java.lang.RuntimeException
    //   1259	8	15	localObject3	Object
    //   1287	36	15	localRuntimeException4	java.lang.RuntimeException
    //   1805	11	15	localObject4	Object
    //   1868	11	15	localObject5	Object
    //   2259	20	15	localObject6	Object
    //   2316	11	15	localObject7	Object
    //   79	21	16	localk	GameGLSurfaceView.k
    //   108	614	16	localObject8	Object
    //   230	2164	17	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	108	finally
    //   110	113	108	finally
    //   92	102	719	finally
    //   121	158	719	finally
    //   158	161	719	finally
    //   190	215	719	finally
    //   220	232	719	finally
    //   237	247	719	finally
    //   247	293	719	finally
    //   293	341	719	finally
    //   352	360	719	finally
    //   368	407	719	finally
    //   412	431	719	finally
    //   444	476	719	finally
    //   476	529	719	finally
    //   529	545	719	finally
    //   545	598	719	finally
    //   607	640	719	finally
    //   643	654	719	finally
    //   654	672	719	finally
    //   689	701	719	finally
    //   706	716	719	finally
    //   721	724	719	finally
    //   780	787	719	finally
    //   790	797	719	finally
    //   797	808	719	finally
    //   823	837	719	finally
    //   837	844	719	finally
    //   847	865	719	finally
    //   882	889	719	finally
    //   900	924	719	finally
    //   933	947	719	finally
    //   950	995	719	finally
    //   998	1003	719	finally
    //   1003	1020	719	finally
    //   1057	1064	719	finally
    //   1064	1069	719	finally
    //   1072	1078	719	finally
    //   1083	1097	719	finally
    //   1097	1109	719	finally
    //   1120	1149	719	finally
    //   1160	1166	719	finally
    //   76	84	732	java/lang/Throwable
    //   166	173	732	java/lang/Throwable
    //   724	732	732	java/lang/Throwable
    //   1182	1259	732	java/lang/Throwable
    //   1269	1297	732	java/lang/Throwable
    //   1297	1325	732	java/lang/Throwable
    //   1325	1343	732	java/lang/Throwable
    //   1348	1383	732	java/lang/Throwable
    //   1383	1402	732	java/lang/Throwable
    //   1402	1430	732	java/lang/Throwable
    //   1438	1446	732	java/lang/Throwable
    //   1464	1488	732	java/lang/Throwable
    //   1493	1503	732	java/lang/Throwable
    //   1515	1556	732	java/lang/Throwable
    //   1561	1581	732	java/lang/Throwable
    //   1581	1591	732	java/lang/Throwable
    //   1594	1604	732	java/lang/Throwable
    //   1607	1626	732	java/lang/Throwable
    //   1626	1636	732	java/lang/Throwable
    //   1643	1651	732	java/lang/Throwable
    //   1655	1679	732	java/lang/Throwable
    //   1684	1694	732	java/lang/Throwable
    //   1697	1703	732	java/lang/Throwable
    //   1706	1758	732	java/lang/Throwable
    //   1764	1799	732	java/lang/Throwable
    //   1810	1818	732	java/lang/Throwable
    //   1818	1838	732	java/lang/Throwable
    //   1873	1881	732	java/lang/Throwable
    //   1881	1893	732	java/lang/Throwable
    //   1900	1956	732	java/lang/Throwable
    //   1975	1987	732	java/lang/Throwable
    //   1990	2002	732	java/lang/Throwable
    //   2007	2017	732	java/lang/Throwable
    //   2017	2025	732	java/lang/Throwable
    //   2033	2045	732	java/lang/Throwable
    //   2050	2057	732	java/lang/Throwable
    //   2062	2068	732	java/lang/Throwable
    //   2077	2085	732	java/lang/Throwable
    //   2089	2100	732	java/lang/Throwable
    //   2104	2112	732	java/lang/Throwable
    //   2116	2127	732	java/lang/Throwable
    //   2131	2166	732	java/lang/Throwable
    //   2171	2177	732	java/lang/Throwable
    //   2180	2199	732	java/lang/Throwable
    //   2228	2232	732	java/lang/Throwable
    //   2261	2281	732	java/lang/Throwable
    //   2281	2310	732	java/lang/Throwable
    //   2321	2329	732	java/lang/Throwable
    //   790	797	821	java/lang/RuntimeException
    //   1057	1064	1081	java/lang/RuntimeException
    //   76	84	1259	finally
    //   166	173	1259	finally
    //   724	732	1259	finally
    //   734	759	1259	finally
    //   764	774	1259	finally
    //   1182	1259	1259	finally
    //   1269	1297	1259	finally
    //   1297	1325	1259	finally
    //   1325	1343	1259	finally
    //   1348	1383	1259	finally
    //   1383	1402	1259	finally
    //   1402	1430	1259	finally
    //   1438	1446	1259	finally
    //   1464	1488	1259	finally
    //   1493	1503	1259	finally
    //   1515	1556	1259	finally
    //   1561	1581	1259	finally
    //   1581	1591	1259	finally
    //   1594	1604	1259	finally
    //   1607	1626	1259	finally
    //   1626	1636	1259	finally
    //   1643	1651	1259	finally
    //   1655	1679	1259	finally
    //   1684	1694	1259	finally
    //   1697	1703	1259	finally
    //   1706	1758	1259	finally
    //   1764	1799	1259	finally
    //   1810	1818	1259	finally
    //   1818	1838	1259	finally
    //   1873	1881	1259	finally
    //   1881	1893	1259	finally
    //   1900	1956	1259	finally
    //   1975	1987	1259	finally
    //   1990	2002	1259	finally
    //   2007	2017	1259	finally
    //   2017	2025	1259	finally
    //   2033	2045	1259	finally
    //   2050	2057	1259	finally
    //   2062	2068	1259	finally
    //   2077	2085	1259	finally
    //   2089	2100	1259	finally
    //   2104	2112	1259	finally
    //   2116	2127	1259	finally
    //   2131	2166	1259	finally
    //   2171	2177	1259	finally
    //   2180	2199	1259	finally
    //   2228	2232	1259	finally
    //   2261	2281	1259	finally
    //   2281	2310	1259	finally
    //   2321	2329	1259	finally
    //   1446	1460	1805	finally
    //   1807	1810	1805	finally
    //   1838	1857	1868	finally
    //   1870	1873	1868	finally
    //   1961	1975	2259	finally
    //   2199	2213	2316	finally
    //   2318	2321	2316	finally
  }
  
  private void stopEglContextLocked()
  {
    AppMethodBeat.i(134079);
    if (this.mHaveEglContext)
    {
      this.mHaveEglContext = false;
      GameGLSurfaceView.aQd().notifyAll();
    }
    AppMethodBeat.o(134079);
  }
  
  private void stopEglSurfaceLocked()
  {
    if (this.mHaveEglSurface)
    {
      this.mHaveEglSurface = false;
      this.mFinishedCreatingEglSurface = false;
    }
  }
  
  public final void aQg()
  {
    AppMethodBeat.i(134085);
    synchronized (GameGLSurfaceView.aQd())
    {
      c.c.i("MicroMsg.GLThread", "requestExitAndWaitForDestory tid=" + getId(), new Object[0]);
      this.mShouldExit = true;
      this.jhu = true;
      this.jhv = true;
      GameGLSurfaceView.aQd().notifyAll();
      for (;;)
      {
        boolean bool = this.mExited;
        if (!bool) {
          try
          {
            GameGLSurfaceView.aQd().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    AppMethodBeat.o(134085);
  }
  
  public final int getRenderMode()
  {
    AppMethodBeat.i(134083);
    synchronized (GameGLSurfaceView.aQd())
    {
      int i = this.mRenderMode;
      AppMethodBeat.o(134083);
      return i;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(134084);
    synchronized (GameGLSurfaceView.aQd())
    {
      c.c.i("MicroMsg.GLThread", "onPause tid=" + getId(), new Object[0]);
      this.mRequestPaused = true;
      GameGLSurfaceView.aQd().notifyAll();
      for (;;)
      {
        if ((!this.mExited) && (!this.mPaused))
        {
          c.c.i("MicroMsg.GLThread", "onPause waiting for mPaused.", new Object[0]);
          try
          {
            GameGLSurfaceView.aQd().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    AppMethodBeat.o(134084);
  }
  
  final boolean readyToDraw()
  {
    return (!this.mPaused) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.mRequestRender) || (this.mRenderMode == 1));
  }
  
  public final void run()
  {
    AppMethodBeat.i(134078);
    setName("MicroMsg.GLThread" + getId());
    c.c.i("MicroMsg.GLThread", "starting tid=" + getId(), new Object[0]);
    try
    {
      guardedRun();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      c.c.e("MicroMsg.GLThread", Log.getStackTraceString(localInterruptedException) + " hy: InterruptedException", new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.c.e("MicroMsg.GLThread", "alvinluo GLThread#run() stack = [%s]", new Object[] { Log.getStackTraceString(localThrowable) });
      GameGLSurfaceView localGameGLSurfaceView = (GameGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
      if (localGameGLSurfaceView != null) {
        GameGLSurfaceView.g(localGameGLSurfaceView).aPM();
      }
      return;
    }
    finally
    {
      GameGLSurfaceView.aQd().f(this);
      AppMethodBeat.o(134078);
    }
  }
  
  public final void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(134082);
    if ((paramInt < 0) || (paramInt > 1))
    {
      ??? = new IllegalArgumentException("renderMode");
      AppMethodBeat.o(134082);
      throw ((Throwable)???);
    }
    synchronized (GameGLSurfaceView.aQd())
    {
      this.mRenderMode = paramInt;
      GameGLSurfaceView.aQd().notifyAll();
      AppMethodBeat.o(134082);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.j
 * JD-Core Version:    0.7.0.1
 */