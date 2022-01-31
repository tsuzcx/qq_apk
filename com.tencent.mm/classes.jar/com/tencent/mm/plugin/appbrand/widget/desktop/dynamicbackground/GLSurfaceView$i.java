package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.opengles.GL10;

final class GLSurfaceView$i
  extends Thread
{
  private boolean jhd;
  private GLSurfaceView.h jhe;
  private ArrayList<Runnable> mEventQueue;
  boolean mExited;
  Runnable mFinishDrawingRunnable;
  boolean mFinishedCreatingEglSurface;
  private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
  boolean mHasSurface;
  boolean mHaveEglContext;
  boolean mHaveEglSurface;
  int mHeight;
  boolean mPaused;
  boolean mRenderComplete;
  private int mRenderMode;
  private boolean mRequestPaused;
  boolean mRequestRender;
  private boolean mShouldExit;
  private boolean mShouldReleaseEglContext;
  boolean mSizeChanged;
  private boolean mSurfaceIsBad;
  boolean mWaitingForSurface;
  boolean mWantRenderNotification;
  int mWidth;
  
  GLSurfaceView$i(WeakReference<GLSurfaceView> paramWeakReference)
  {
    AppMethodBeat.i(133985);
    this.jhd = true;
    this.mEventQueue = new ArrayList();
    this.mSizeChanged = true;
    this.mFinishDrawingRunnable = null;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mRequestRender = true;
    this.mRenderMode = 1;
    this.mWantRenderNotification = false;
    this.mGLSurfaceViewWeakRef = paramWeakReference;
    AppMethodBeat.o(133985);
  }
  
  private void d(GL10 paramGL10)
  {
    AppMethodBeat.i(133987);
    if (this.mHaveEglSurface)
    {
      if ((this.jhd) && (paramGL10 != null))
      {
        ab.b("CustomGLSurfaceView", "alvinluo stopEglsurface", new Object[0]);
        this.jhd = false;
        ab.i("CustomGLSurfaceView", "alvinluo saveBitmap");
        ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(8192000);
        localByteBuffer.position(0);
        paramGL10.glReadPixels(0, 0, 1024, 2000, 6408, 5121, localByteBuffer);
        paramGL10 = DynamicBackgroundGLSurfaceView.b.jgL;
        DynamicBackgroundGLSurfaceView.b.a.a(localByteBuffer, "/sdcard/test.png");
      }
      this.mHaveEglSurface = false;
      paramGL10 = this.jhe;
      ab.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
      paramGL10.destroySurfaceImp();
    }
    AppMethodBeat.o(133987);
  }
  
  /* Error */
  private void guardedRun()
  {
    // Byte code:
    //   0: ldc 173
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: new 166	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h
    //   9: dup
    //   10: aload_0
    //   11: getfield 72	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   14: invokespecial 175	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:<init>	(Ljava/lang/ref/WeakReference;)V
    //   17: putfield 136	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:jhe	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 177	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglContext	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 87	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglSurface	Z
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 70	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWantRenderNotification	Z
    //   35: iconst_0
    //   36: istore_1
    //   37: iconst_0
    //   38: istore_3
    //   39: iconst_0
    //   40: istore 6
    //   42: iconst_0
    //   43: istore_2
    //   44: iconst_0
    //   45: istore 5
    //   47: iconst_0
    //   48: istore 9
    //   50: iconst_0
    //   51: istore 4
    //   53: iconst_0
    //   54: istore 8
    //   56: iconst_0
    //   57: istore 10
    //   59: iconst_0
    //   60: istore 11
    //   62: aconst_null
    //   63: astore 21
    //   65: aconst_null
    //   66: astore 20
    //   68: aconst_null
    //   69: astore 23
    //   71: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   74: astore 24
    //   76: aload 24
    //   78: monitorenter
    //   79: iload_1
    //   80: istore 7
    //   82: iload 8
    //   84: istore_1
    //   85: iload 4
    //   87: istore 14
    //   89: aload_0
    //   90: getfield 183	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mShouldExit	Z
    //   93: ifeq +45 -> 138
    //   96: aload 24
    //   98: monitorexit
    //   99: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   102: astore 20
    //   104: aload 20
    //   106: monitorenter
    //   107: aload_0
    //   108: aconst_null
    //   109: invokespecial 185	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:d	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   112: aload_0
    //   113: invokespecial 188	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:stopEglContextLocked	()V
    //   116: aload 20
    //   118: monitorexit
    //   119: ldc 173
    //   121: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: return
    //   125: astore 21
    //   127: aload 20
    //   129: monitorexit
    //   130: ldc 173
    //   132: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload 21
    //   137: athrow
    //   138: aload_0
    //   139: getfield 56	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mEventQueue	Ljava/util/ArrayList;
    //   142: invokevirtual 192	java/util/ArrayList:isEmpty	()Z
    //   145: ifne +71 -> 216
    //   148: aload_0
    //   149: getfield 56	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mEventQueue	Ljava/util/ArrayList;
    //   152: iconst_0
    //   153: invokevirtual 196	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   156: checkcast 198	java/lang/Runnable
    //   159: astore 22
    //   161: aload 21
    //   163: astore 20
    //   165: aload 22
    //   167: astore 21
    //   169: iload_1
    //   170: istore 8
    //   172: iload 7
    //   174: istore_1
    //   175: iload_3
    //   176: istore 7
    //   178: iload 14
    //   180: istore_3
    //   181: aload 24
    //   183: monitorexit
    //   184: aload 21
    //   186: ifnull +1365 -> 1551
    //   189: aload 21
    //   191: invokeinterface 201 1 0
    //   196: aconst_null
    //   197: astore 22
    //   199: iload_3
    //   200: istore 4
    //   202: iload 7
    //   204: istore_3
    //   205: aload 20
    //   207: astore 21
    //   209: aload 22
    //   211: astore 20
    //   213: goto -142 -> 71
    //   216: iconst_0
    //   217: istore 19
    //   219: aload_0
    //   220: getfield 203	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mPaused	Z
    //   223: aload_0
    //   224: getfield 205	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mRequestPaused	Z
    //   227: if_icmpeq +59 -> 286
    //   230: aload_0
    //   231: getfield 205	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mRequestPaused	Z
    //   234: istore 19
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 205	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mRequestPaused	Z
    //   241: putfield 203	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mPaused	Z
    //   244: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   247: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   250: ldc 210
    //   252: new 140	java/lang/StringBuilder
    //   255: dup
    //   256: ldc 212
    //   258: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: aload_0
    //   262: getfield 203	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mPaused	Z
    //   265: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   268: ldc 217
    //   270: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_0
    //   274: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   277: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   280: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_0
    //   287: getfield 223	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mShouldReleaseEglContext	Z
    //   290: ifeq +2248 -> 2538
    //   293: ldc 210
    //   295: new 140	java/lang/StringBuilder
    //   298: dup
    //   299: ldc 225
    //   301: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   304: aload_0
    //   305: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   308: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   311: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_0
    //   318: aload 23
    //   320: invokespecial 185	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:d	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   323: aload_0
    //   324: invokespecial 188	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:stopEglContextLocked	()V
    //   327: aload_0
    //   328: iconst_0
    //   329: putfield 223	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mShouldReleaseEglContext	Z
    //   332: iconst_1
    //   333: istore 4
    //   335: iload_2
    //   336: istore 12
    //   338: iload_2
    //   339: ifeq +16 -> 355
    //   342: aload_0
    //   343: aload 23
    //   345: invokespecial 185	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:d	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   348: aload_0
    //   349: invokespecial 188	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:stopEglContextLocked	()V
    //   352: iconst_0
    //   353: istore 12
    //   355: iload 19
    //   357: ifeq +40 -> 397
    //   360: aload_0
    //   361: getfield 87	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglSurface	Z
    //   364: ifeq +33 -> 397
    //   367: ldc 210
    //   369: new 140	java/lang/StringBuilder
    //   372: dup
    //   373: ldc 227
    //   375: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: aload_0
    //   379: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   382: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   385: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_0
    //   392: aload 23
    //   394: invokespecial 185	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:d	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   397: iload 19
    //   399: ifeq +63 -> 462
    //   402: aload_0
    //   403: getfield 177	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglContext	Z
    //   406: ifeq +56 -> 462
    //   409: aload_0
    //   410: getfield 72	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   413: invokevirtual 233	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   416: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView
    //   419: astore 22
    //   421: aload 22
    //   423: ifnonnull +456 -> 879
    //   426: iconst_0
    //   427: istore 19
    //   429: iload 19
    //   431: ifne +31 -> 462
    //   434: aload_0
    //   435: invokespecial 188	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:stopEglContextLocked	()V
    //   438: ldc 210
    //   440: new 140	java/lang/StringBuilder
    //   443: dup
    //   444: ldc 235
    //   446: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: aload_0
    //   450: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   453: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: aload_0
    //   463: getfield 237	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHasSurface	Z
    //   466: ifne +63 -> 529
    //   469: aload_0
    //   470: getfield 239	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWaitingForSurface	Z
    //   473: ifne +56 -> 529
    //   476: ldc 210
    //   478: new 140	java/lang/StringBuilder
    //   481: dup
    //   482: ldc 241
    //   484: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   487: aload_0
    //   488: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   491: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   494: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: aload_0
    //   501: getfield 87	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglSurface	Z
    //   504: ifeq +9 -> 513
    //   507: aload_0
    //   508: aload 23
    //   510: invokespecial 185	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:d	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   513: aload_0
    //   514: iconst_1
    //   515: putfield 239	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWaitingForSurface	Z
    //   518: aload_0
    //   519: iconst_0
    //   520: putfield 243	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mSurfaceIsBad	Z
    //   523: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   526: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   529: aload_0
    //   530: getfield 237	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHasSurface	Z
    //   533: ifeq +45 -> 578
    //   536: aload_0
    //   537: getfield 239	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWaitingForSurface	Z
    //   540: ifeq +38 -> 578
    //   543: ldc 210
    //   545: new 140	java/lang/StringBuilder
    //   548: dup
    //   549: ldc 245
    //   551: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   554: aload_0
    //   555: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   558: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   561: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: aload_0
    //   568: iconst_0
    //   569: putfield 239	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWaitingForSurface	Z
    //   572: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   575: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   578: iload 14
    //   580: istore 13
    //   582: iload 14
    //   584: ifeq +46 -> 630
    //   587: ldc 210
    //   589: new 140	java/lang/StringBuilder
    //   592: dup
    //   593: ldc 247
    //   595: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   598: aload_0
    //   599: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   602: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   605: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   611: aload_0
    //   612: iconst_0
    //   613: putfield 70	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWantRenderNotification	Z
    //   616: iconst_0
    //   617: istore 13
    //   619: aload_0
    //   620: iconst_1
    //   621: putfield 249	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mRenderComplete	Z
    //   624: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   627: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   630: aload_0
    //   631: getfield 60	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mFinishDrawingRunnable	Ljava/lang/Runnable;
    //   634: ifnull +14 -> 648
    //   637: aload_0
    //   638: getfield 60	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mFinishDrawingRunnable	Ljava/lang/Runnable;
    //   641: astore 21
    //   643: aload_0
    //   644: aconst_null
    //   645: putfield 60	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mFinishDrawingRunnable	Ljava/lang/Runnable;
    //   648: aload_0
    //   649: invokevirtual 252	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:readyToDraw	()Z
    //   652: ifeq +628 -> 1280
    //   655: iload 4
    //   657: istore_2
    //   658: iload 7
    //   660: istore_1
    //   661: aload_0
    //   662: getfield 177	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglContext	Z
    //   665: ifne +13 -> 678
    //   668: iload 4
    //   670: ifeq +219 -> 889
    //   673: iconst_0
    //   674: istore_2
    //   675: iload 7
    //   677: istore_1
    //   678: iload_3
    //   679: istore 8
    //   681: iload 5
    //   683: istore 7
    //   685: iload 6
    //   687: istore 4
    //   689: aload_0
    //   690: getfield 177	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglContext	Z
    //   693: ifeq +35 -> 728
    //   696: iload_3
    //   697: istore 8
    //   699: iload 5
    //   701: istore 7
    //   703: iload 6
    //   705: istore 4
    //   707: aload_0
    //   708: getfield 87	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglSurface	Z
    //   711: ifne +17 -> 728
    //   714: aload_0
    //   715: iconst_1
    //   716: putfield 87	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglSurface	Z
    //   719: iconst_1
    //   720: istore 8
    //   722: iconst_1
    //   723: istore 4
    //   725: iconst_1
    //   726: istore 7
    //   728: iload 8
    //   730: istore 18
    //   732: aload 21
    //   734: astore 22
    //   736: iload_2
    //   737: istore 14
    //   739: iload 7
    //   741: istore 17
    //   743: iload 4
    //   745: istore 15
    //   747: iload_1
    //   748: istore 16
    //   750: aload_0
    //   751: getfield 87	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglSurface	Z
    //   754: ifeq +591 -> 1345
    //   757: aload_0
    //   758: getfield 58	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mSizeChanged	Z
    //   761: ifeq +1763 -> 2524
    //   764: iconst_1
    //   765: istore 6
    //   767: aload_0
    //   768: getfield 62	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWidth	I
    //   771: istore_3
    //   772: aload_0
    //   773: getfield 64	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHeight	I
    //   776: istore 5
    //   778: aload_0
    //   779: iconst_1
    //   780: putfield 70	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWantRenderNotification	Z
    //   783: ldc 210
    //   785: new 140	java/lang/StringBuilder
    //   788: dup
    //   789: ldc 254
    //   791: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   794: aload_0
    //   795: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   798: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   801: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: iconst_1
    //   808: istore 8
    //   810: aload_0
    //   811: iconst_0
    //   812: putfield 58	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mSizeChanged	Z
    //   815: aload_0
    //   816: iconst_0
    //   817: putfield 66	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mRequestRender	Z
    //   820: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   823: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   826: aload_0
    //   827: getfield 70	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWantRenderNotification	Z
    //   830: ifeq +1651 -> 2481
    //   833: iconst_1
    //   834: istore 9
    //   836: aload 20
    //   838: astore 22
    //   840: iload_3
    //   841: istore 10
    //   843: iload 13
    //   845: istore_3
    //   846: iload 8
    //   848: istore 7
    //   850: aload 21
    //   852: astore 20
    //   854: aload 22
    //   856: astore 21
    //   858: iload 5
    //   860: istore 11
    //   862: iload_2
    //   863: istore 8
    //   865: iload 6
    //   867: istore 5
    //   869: iload 12
    //   871: istore_2
    //   872: iload 4
    //   874: istore 6
    //   876: goto -695 -> 181
    //   879: aload 22
    //   881: invokestatic 258	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)Z
    //   884: istore 19
    //   886: goto -457 -> 429
    //   889: aload_0
    //   890: getfield 136	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:jhe	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h;
    //   893: astore 22
    //   895: ldc 138
    //   897: new 140	java/lang/StringBuilder
    //   900: dup
    //   901: ldc_w 260
    //   904: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   907: invokestatic 149	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   910: invokevirtual 153	java/lang/Thread:getId	()J
    //   913: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   916: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   919: invokestatic 164	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   922: aload 22
    //   924: invokestatic 266	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
    //   927: checkcast 268	javax/microedition/khronos/egl/EGL10
    //   930: putfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   933: aload 22
    //   935: aload 22
    //   937: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   940: getstatic 276	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
    //   943: invokeinterface 280 2 0
    //   948: putfield 284	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   951: aload 22
    //   953: getfield 284	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   956: getstatic 287	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   959: if_acmpne +82 -> 1041
    //   962: new 172	java/lang/RuntimeException
    //   965: dup
    //   966: ldc_w 289
    //   969: invokespecial 290	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   972: astore 20
    //   974: ldc 173
    //   976: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   979: aload 20
    //   981: athrow
    //   982: astore 20
    //   984: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   987: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   990: ldc 173
    //   992: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   995: aload 20
    //   997: athrow
    //   998: astore 20
    //   1000: aload 24
    //   1002: monitorexit
    //   1003: ldc 173
    //   1005: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1008: aload 20
    //   1010: athrow
    //   1011: astore 21
    //   1013: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   1016: astore 20
    //   1018: aload 20
    //   1020: monitorenter
    //   1021: aload_0
    //   1022: aconst_null
    //   1023: invokespecial 185	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:d	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1026: aload_0
    //   1027: invokespecial 188	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:stopEglContextLocked	()V
    //   1030: aload 20
    //   1032: monitorexit
    //   1033: ldc 173
    //   1035: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1038: aload 21
    //   1040: athrow
    //   1041: iconst_2
    //   1042: newarray int
    //   1044: astore 25
    //   1046: aload 22
    //   1048: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1051: aload 22
    //   1053: getfield 284	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1056: aload 25
    //   1058: invokeinterface 294 3 0
    //   1063: ifne +23 -> 1086
    //   1066: new 172	java/lang/RuntimeException
    //   1069: dup
    //   1070: ldc_w 296
    //   1073: invokespecial 290	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1076: astore 20
    //   1078: ldc 173
    //   1080: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1083: aload 20
    //   1085: athrow
    //   1086: aload 22
    //   1088: getfield 297	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1091: invokevirtual 233	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1094: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView
    //   1097: astore 25
    //   1099: aload 25
    //   1101: ifnonnull +121 -> 1222
    //   1104: aload 22
    //   1106: aconst_null
    //   1107: putfield 301	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1110: aload 22
    //   1112: aconst_null
    //   1113: putfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   1116: aload 22
    //   1118: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   1121: ifnull +14 -> 1135
    //   1124: aload 22
    //   1126: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   1129: getstatic 308	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   1132: if_acmpne +25 -> 1157
    //   1135: aload 22
    //   1137: aconst_null
    //   1138: putfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   1141: ldc_w 310
    //   1144: aload 22
    //   1146: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1149: invokeinterface 314 1 0
    //   1154: invokestatic 318	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:throwEglException	(Ljava/lang/String;I)V
    //   1157: ldc 138
    //   1159: new 140	java/lang/StringBuilder
    //   1162: dup
    //   1163: ldc_w 320
    //   1166: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1169: aload 22
    //   1171: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   1174: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1177: ldc 217
    //   1179: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: invokestatic 149	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1185: invokevirtual 153	java/lang/Thread:getId	()J
    //   1188: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1191: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1194: invokestatic 164	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1197: aload 22
    //   1199: aconst_null
    //   1200: putfield 327	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1203: aload_0
    //   1204: iconst_1
    //   1205: putfield 177	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglContext	Z
    //   1208: iconst_1
    //   1209: istore_1
    //   1210: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   1213: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   1216: iload 4
    //   1218: istore_2
    //   1219: goto -541 -> 678
    //   1222: aload 22
    //   1224: aload 25
    //   1226: invokestatic 330	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:b	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$e;
    //   1229: aload 22
    //   1231: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1234: aload 22
    //   1236: getfield 284	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1239: invokeinterface 336 3 0
    //   1244: putfield 301	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1247: aload 22
    //   1249: aload 25
    //   1251: invokestatic 340	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:c	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$f;
    //   1254: aload 22
    //   1256: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1259: aload 22
    //   1261: getfield 284	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1264: aload 22
    //   1266: getfield 301	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1269: invokeinterface 345 4 0
    //   1274: putfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   1277: goto -161 -> 1116
    //   1280: iload_3
    //   1281: istore 18
    //   1283: aload 21
    //   1285: astore 22
    //   1287: iload 4
    //   1289: istore 14
    //   1291: iload 5
    //   1293: istore 17
    //   1295: iload 6
    //   1297: istore 15
    //   1299: iload 7
    //   1301: istore 16
    //   1303: aload 21
    //   1305: ifnull +40 -> 1345
    //   1308: ldc 89
    //   1310: ldc_w 347
    //   1313: invokestatic 164	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1316: aload 21
    //   1318: invokeinterface 201 1 0
    //   1323: aconst_null
    //   1324: astore 22
    //   1326: iload 7
    //   1328: istore 16
    //   1330: iload 6
    //   1332: istore 15
    //   1334: iload 5
    //   1336: istore 17
    //   1338: iload 4
    //   1340: istore 14
    //   1342: iload_3
    //   1343: istore 18
    //   1345: ldc 210
    //   1347: new 140	java/lang/StringBuilder
    //   1350: dup
    //   1351: ldc_w 349
    //   1354: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1357: aload_0
    //   1358: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   1361: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1364: ldc_w 351
    //   1367: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: aload_0
    //   1371: getfield 177	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglContext	Z
    //   1374: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1377: ldc_w 353
    //   1380: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: aload_0
    //   1384: getfield 87	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHaveEglSurface	Z
    //   1387: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1390: ldc_w 355
    //   1393: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: aload_0
    //   1397: getfield 357	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mFinishedCreatingEglSurface	Z
    //   1400: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1403: ldc_w 359
    //   1406: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: aload_0
    //   1410: getfield 203	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mPaused	Z
    //   1413: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1416: ldc_w 361
    //   1419: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: aload_0
    //   1423: getfield 237	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHasSurface	Z
    //   1426: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1429: ldc_w 363
    //   1432: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: aload_0
    //   1436: getfield 243	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mSurfaceIsBad	Z
    //   1439: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1442: ldc_w 365
    //   1445: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: aload_0
    //   1449: getfield 239	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWaitingForSurface	Z
    //   1452: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1455: ldc_w 367
    //   1458: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: aload_0
    //   1462: getfield 62	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mWidth	I
    //   1465: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1468: ldc_w 372
    //   1471: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: aload_0
    //   1475: getfield 64	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mHeight	I
    //   1478: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1481: ldc_w 374
    //   1484: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: aload_0
    //   1488: getfield 66	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mRequestRender	Z
    //   1491: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1494: ldc_w 376
    //   1497: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: aload_0
    //   1501: getfield 68	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mRenderMode	I
    //   1504: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1507: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1510: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1513: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   1516: invokevirtual 379	java/lang/Object:wait	()V
    //   1519: iload 14
    //   1521: istore_1
    //   1522: iload 13
    //   1524: istore 14
    //   1526: iload 18
    //   1528: istore_3
    //   1529: aload 22
    //   1531: astore 21
    //   1533: iload 17
    //   1535: istore 5
    //   1537: iload 12
    //   1539: istore_2
    //   1540: iload 15
    //   1542: istore 6
    //   1544: iload 16
    //   1546: istore 7
    //   1548: goto -1459 -> 89
    //   1551: iload 7
    //   1553: ifeq +921 -> 2474
    //   1556: ldc 210
    //   1558: ldc_w 381
    //   1561: invokestatic 164	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1564: aload_0
    //   1565: getfield 136	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:jhe	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h;
    //   1568: astore 22
    //   1570: ldc 138
    //   1572: new 140	java/lang/StringBuilder
    //   1575: dup
    //   1576: ldc_w 383
    //   1579: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1582: invokestatic 149	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1585: invokevirtual 153	java/lang/Thread:getId	()J
    //   1588: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1591: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1594: invokestatic 164	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1597: aload 22
    //   1599: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1602: ifnonnull +23 -> 1625
    //   1605: new 172	java/lang/RuntimeException
    //   1608: dup
    //   1609: ldc_w 385
    //   1612: invokespecial 290	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1615: astore 20
    //   1617: ldc 173
    //   1619: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1622: aload 20
    //   1624: athrow
    //   1625: aload 22
    //   1627: getfield 284	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1630: ifnonnull +23 -> 1653
    //   1633: new 172	java/lang/RuntimeException
    //   1636: dup
    //   1637: ldc_w 387
    //   1640: invokespecial 290	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1643: astore 20
    //   1645: ldc 173
    //   1647: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1650: aload 20
    //   1652: athrow
    //   1653: aload 22
    //   1655: getfield 301	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1658: ifnonnull +23 -> 1681
    //   1661: new 172	java/lang/RuntimeException
    //   1664: dup
    //   1665: ldc_w 389
    //   1668: invokespecial 290	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1671: astore 20
    //   1673: ldc 173
    //   1675: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1678: aload 20
    //   1680: athrow
    //   1681: aload 22
    //   1683: invokevirtual 169	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:destroySurfaceImp	()V
    //   1686: aload 22
    //   1688: getfield 297	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1691: invokevirtual 233	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1694: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView
    //   1697: astore 24
    //   1699: aload 24
    //   1701: ifnull +556 -> 2257
    //   1704: aload 22
    //   1706: aload 24
    //   1708: invokestatic 392	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:d	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$g;
    //   1711: aload 22
    //   1713: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1716: aload 22
    //   1718: getfield 284	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1721: aload 22
    //   1723: getfield 301	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1726: aload 24
    //   1728: invokevirtual 396	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   1731: invokeinterface 402 5 0
    //   1736: putfield 327	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1739: aload 22
    //   1741: getfield 327	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1744: ifnull +14 -> 1758
    //   1747: aload 22
    //   1749: getfield 327	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1752: getstatic 405	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1755: if_acmpne +511 -> 2266
    //   1758: aload 22
    //   1760: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   1763: invokeinterface 314 1 0
    //   1768: sipush 12299
    //   1771: if_icmpne +778 -> 2549
    //   1774: ldc 138
    //   1776: ldc_w 407
    //   1779: invokestatic 410	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1782: goto +767 -> 2549
    //   1785: iload 4
    //   1787: ifeq +556 -> 2343
    //   1790: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   1793: astore 22
    //   1795: aload 22
    //   1797: monitorenter
    //   1798: aload_0
    //   1799: iconst_1
    //   1800: putfield 357	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mFinishedCreatingEglSurface	Z
    //   1803: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   1806: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   1809: aload 22
    //   1811: monitorexit
    //   1812: iconst_0
    //   1813: istore 4
    //   1815: iload 6
    //   1817: istore 7
    //   1819: iload 6
    //   1821: ifeq +131 -> 1952
    //   1824: aload_0
    //   1825: getfield 136	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:jhe	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h;
    //   1828: astore 23
    //   1830: aload 23
    //   1832: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   1835: invokevirtual 414	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
    //   1838: astore 22
    //   1840: aload 23
    //   1842: getfield 297	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1845: invokevirtual 233	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1848: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView
    //   1851: astore 24
    //   1853: aload 22
    //   1855: astore 23
    //   1857: aload 24
    //   1859: ifnull +608 -> 2467
    //   1862: aload 24
    //   1864: invokestatic 417	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:e	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$k;
    //   1867: ifnull +15 -> 1882
    //   1870: aload 24
    //   1872: invokestatic 417	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:e	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$k;
    //   1875: invokeinterface 422 1 0
    //   1880: astore 22
    //   1882: aload 22
    //   1884: astore 23
    //   1886: aload 24
    //   1888: invokestatic 426	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:f	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)I
    //   1891: iconst_3
    //   1892: iand
    //   1893: ifeq +574 -> 2467
    //   1896: iconst_0
    //   1897: istore 6
    //   1899: aload 24
    //   1901: invokestatic 426	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:f	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)I
    //   1904: iconst_1
    //   1905: iand
    //   1906: ifeq +6 -> 1912
    //   1909: iconst_1
    //   1910: istore 6
    //   1912: aload 24
    //   1914: invokestatic 426	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:f	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)I
    //   1917: iconst_2
    //   1918: iand
    //   1919: ifeq +542 -> 2461
    //   1922: new 428	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$l
    //   1925: dup
    //   1926: invokespecial 429	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$l:<init>	()V
    //   1929: astore 23
    //   1931: aload 22
    //   1933: iload 6
    //   1935: aload 23
    //   1937: invokestatic 435	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
    //   1940: astore 22
    //   1942: aload 22
    //   1944: checkcast 117	javax/microedition/khronos/opengles/GL10
    //   1947: astore 23
    //   1949: iconst_0
    //   1950: istore 7
    //   1952: iload_1
    //   1953: istore 12
    //   1955: iload_1
    //   1956: ifeq +37 -> 1993
    //   1959: ldc 210
    //   1961: ldc_w 437
    //   1964: invokestatic 164	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1967: aload_0
    //   1968: getfield 72	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1971: invokevirtual 233	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1974: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView
    //   1977: astore 22
    //   1979: aload 22
    //   1981: ifnull +574 -> 2555
    //   1984: aload 22
    //   1986: invokestatic 441	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:h	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$m;
    //   1989: pop
    //   1990: goto +565 -> 2555
    //   1993: iload 5
    //   1995: istore_1
    //   1996: iload 5
    //   1998: ifeq +69 -> 2067
    //   2001: ldc 210
    //   2003: new 140	java/lang/StringBuilder
    //   2006: dup
    //   2007: ldc_w 443
    //   2010: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2013: iload 10
    //   2015: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2018: ldc_w 445
    //   2021: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2024: iload 11
    //   2026: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2029: ldc_w 447
    //   2032: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2035: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2038: invokestatic 164	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2041: aload_0
    //   2042: getfield 72	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   2045: invokevirtual 233	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2048: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView
    //   2051: astore 22
    //   2053: aload 22
    //   2055: ifnull +506 -> 2561
    //   2058: aload 22
    //   2060: invokestatic 441	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:h	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$m;
    //   2063: pop
    //   2064: goto +497 -> 2561
    //   2067: ldc 210
    //   2069: new 140	java/lang/StringBuilder
    //   2072: dup
    //   2073: ldc_w 449
    //   2076: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2079: aload_0
    //   2080: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   2083: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2086: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2089: invokestatic 164	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2092: aload_0
    //   2093: getfield 72	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   2096: invokevirtual 233	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2099: checkcast 6	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView
    //   2102: astore 24
    //   2104: aload 20
    //   2106: astore 22
    //   2108: aload 24
    //   2110: ifnull +28 -> 2138
    //   2113: aload 24
    //   2115: invokestatic 441	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:h	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$m;
    //   2118: pop
    //   2119: aload 20
    //   2121: astore 22
    //   2123: aload 20
    //   2125: ifnull +13 -> 2138
    //   2128: aload 20
    //   2130: invokeinterface 201 1 0
    //   2135: aconst_null
    //   2136: astore 22
    //   2138: aload_0
    //   2139: getfield 136	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:jhe	Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h;
    //   2142: astore 20
    //   2144: aload 20
    //   2146: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   2149: aload 20
    //   2151: getfield 284	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2154: aload 20
    //   2156: getfield 327	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2159: invokeinterface 453 3 0
    //   2164: ifne +435 -> 2599
    //   2167: aload 20
    //   2169: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   2172: invokeinterface 314 1 0
    //   2177: istore 5
    //   2179: goto +387 -> 2566
    //   2182: ldc 210
    //   2184: ldc_w 454
    //   2187: iload 5
    //   2189: invokestatic 458	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2192: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   2195: astore 20
    //   2197: aload 20
    //   2199: monitorenter
    //   2200: aload_0
    //   2201: iconst_1
    //   2202: putfield 243	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mSurfaceIsBad	Z
    //   2205: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   2208: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   2211: aload 20
    //   2213: monitorexit
    //   2214: iload_2
    //   2215: istore 6
    //   2217: iload 9
    //   2219: ifeq +325 -> 2544
    //   2222: iconst_1
    //   2223: istore_2
    //   2224: iconst_0
    //   2225: istore 9
    //   2227: aload 21
    //   2229: astore 20
    //   2231: iload 4
    //   2233: istore_3
    //   2234: iload_2
    //   2235: istore 4
    //   2237: aload 22
    //   2239: astore 21
    //   2241: iload_1
    //   2242: istore 5
    //   2244: iload 6
    //   2246: istore_2
    //   2247: iload 7
    //   2249: istore 6
    //   2251: iload 12
    //   2253: istore_1
    //   2254: goto -2183 -> 71
    //   2257: aload 22
    //   2259: aconst_null
    //   2260: putfield 327	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2263: goto -524 -> 1739
    //   2266: aload 22
    //   2268: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   2271: aload 22
    //   2273: getfield 284	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   2276: aload 22
    //   2278: getfield 327	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2281: aload 22
    //   2283: getfield 327	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   2286: aload 22
    //   2288: getfield 305	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEglContext	Ljavax/microedition/khronos/egl/EGLContext;
    //   2291: invokeinterface 462 5 0
    //   2296: ifne +28 -> 2324
    //   2299: ldc_w 464
    //   2302: ldc_w 465
    //   2305: aload 22
    //   2307: getfield 272	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:mEgl	Ljavax/microedition/khronos/egl/EGL10;
    //   2310: invokeinterface 314 1 0
    //   2315: invokestatic 458	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$h:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2318: iconst_0
    //   2319: istore 4
    //   2321: goto -536 -> 1785
    //   2324: iconst_1
    //   2325: istore 4
    //   2327: goto -542 -> 1785
    //   2330: astore 20
    //   2332: aload 22
    //   2334: monitorexit
    //   2335: ldc 173
    //   2337: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2340: aload 20
    //   2342: athrow
    //   2343: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   2346: astore 22
    //   2348: aload 22
    //   2350: monitorenter
    //   2351: aload_0
    //   2352: iconst_1
    //   2353: putfield 357	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mFinishedCreatingEglSurface	Z
    //   2356: aload_0
    //   2357: iconst_1
    //   2358: putfield 243	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:mSurfaceIsBad	Z
    //   2361: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   2364: invokevirtual 208	java/lang/Object:notifyAll	()V
    //   2367: aload 22
    //   2369: monitorexit
    //   2370: aload 21
    //   2372: astore 22
    //   2374: iload_3
    //   2375: istore 4
    //   2377: iload 7
    //   2379: istore_3
    //   2380: aload 20
    //   2382: astore 21
    //   2384: aload 22
    //   2386: astore 20
    //   2388: goto -2317 -> 71
    //   2391: astore 20
    //   2393: aload 22
    //   2395: monitorexit
    //   2396: ldc 173
    //   2398: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2401: aload 20
    //   2403: athrow
    //   2404: ldc 210
    //   2406: new 140	java/lang/StringBuilder
    //   2409: dup
    //   2410: ldc_w 467
    //   2413: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2416: aload_0
    //   2417: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   2420: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2423: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2426: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2429: iconst_1
    //   2430: istore 6
    //   2432: goto -215 -> 2217
    //   2435: astore 21
    //   2437: aload 20
    //   2439: monitorexit
    //   2440: ldc 173
    //   2442: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2445: aload 21
    //   2447: athrow
    //   2448: astore 21
    //   2450: aload 20
    //   2452: monitorexit
    //   2453: ldc 173
    //   2455: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2458: aload 21
    //   2460: athrow
    //   2461: aconst_null
    //   2462: astore 23
    //   2464: goto -533 -> 1931
    //   2467: aload 23
    //   2469: astore 22
    //   2471: goto -529 -> 1942
    //   2474: iload 7
    //   2476: istore 4
    //   2478: goto -663 -> 1815
    //   2481: aload 20
    //   2483: astore 22
    //   2485: iload_3
    //   2486: istore 10
    //   2488: iload 13
    //   2490: istore_3
    //   2491: iload 8
    //   2493: istore 7
    //   2495: aload 21
    //   2497: astore 20
    //   2499: aload 22
    //   2501: astore 21
    //   2503: iload 5
    //   2505: istore 11
    //   2507: iload_2
    //   2508: istore 8
    //   2510: iload 6
    //   2512: istore 5
    //   2514: iload 12
    //   2516: istore_2
    //   2517: iload 4
    //   2519: istore 6
    //   2521: goto -2340 -> 181
    //   2524: iload 11
    //   2526: istore 5
    //   2528: iload 10
    //   2530: istore_3
    //   2531: iload 7
    //   2533: istore 6
    //   2535: goto -1720 -> 815
    //   2538: iload_1
    //   2539: istore 4
    //   2541: goto -2206 -> 335
    //   2544: iload_3
    //   2545: istore_2
    //   2546: goto -319 -> 2227
    //   2549: iconst_0
    //   2550: istore 4
    //   2552: goto -767 -> 1785
    //   2555: iconst_0
    //   2556: istore 12
    //   2558: goto -565 -> 1993
    //   2561: iconst_0
    //   2562: istore_1
    //   2563: goto -496 -> 2067
    //   2566: iload_2
    //   2567: istore 6
    //   2569: iload 5
    //   2571: lookupswitch	default:+25->2596, 12288:+-354->2217, 12302:+-167->2404
    //   2597: impdep1
    //   2598: fadd
    //   2599: sipush 12288
    //   2602: istore 5
    //   2604: goto -38 -> 2566
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2607	0	this	i
    //   36	2527	1	i	int
    //   43	2524	2	j	int
    //   38	2507	3	k	int
    //   51	2500	4	m	int
    //   45	2558	5	n	int
    //   40	2528	6	i1	int
    //   80	2452	7	i2	int
    //   54	2455	8	i3	int
    //   48	2178	9	i4	int
    //   57	2472	10	i5	int
    //   60	2465	11	i6	int
    //   336	2221	12	i7	int
    //   580	1909	13	i8	int
    //   87	1438	14	i9	int
    //   745	796	15	i10	int
    //   748	797	16	i11	int
    //   741	793	17	i12	int
    //   730	797	18	i13	int
    //   217	668	19	bool	boolean
    //   982	14	20	localRuntimeException	java.lang.RuntimeException
    //   998	11	20	localObject2	Object
    //   2330	51	20	localObject4	Object
    //   2386	1	20	localObject5	Object
    //   2391	91	20	localObject6	Object
    //   2497	1	20	localObject7	Object
    //   63	1	21	localObject8	Object
    //   125	37	21	localObject9	Object
    //   167	690	21	localObject10	Object
    //   1011	306	21	localObject11	Object
    //   1531	852	21	localObject12	Object
    //   2435	11	21	localObject13	Object
    //   2448	48	21	localObject14	Object
    //   2501	1	21	localObject15	Object
    //   69	2399	23	localObject17	Object
    //   74	2040	24	localObject18	Object
    //   1044	206	25	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   107	119	125	finally
    //   127	130	125	finally
    //   889	982	982	java/lang/RuntimeException
    //   1041	1086	982	java/lang/RuntimeException
    //   1086	1099	982	java/lang/RuntimeException
    //   1104	1116	982	java/lang/RuntimeException
    //   1116	1135	982	java/lang/RuntimeException
    //   1135	1157	982	java/lang/RuntimeException
    //   1157	1203	982	java/lang/RuntimeException
    //   1222	1277	982	java/lang/RuntimeException
    //   89	99	998	finally
    //   138	161	998	finally
    //   181	184	998	finally
    //   219	286	998	finally
    //   286	332	998	finally
    //   342	352	998	finally
    //   360	397	998	finally
    //   402	421	998	finally
    //   434	462	998	finally
    //   462	513	998	finally
    //   513	529	998	finally
    //   529	578	998	finally
    //   587	616	998	finally
    //   619	630	998	finally
    //   630	648	998	finally
    //   648	655	998	finally
    //   661	668	998	finally
    //   689	696	998	finally
    //   707	719	998	finally
    //   750	764	998	finally
    //   767	807	998	finally
    //   810	815	998	finally
    //   815	833	998	finally
    //   879	886	998	finally
    //   889	982	998	finally
    //   984	998	998	finally
    //   1000	1003	998	finally
    //   1041	1086	998	finally
    //   1086	1099	998	finally
    //   1104	1116	998	finally
    //   1116	1135	998	finally
    //   1135	1157	998	finally
    //   1157	1203	998	finally
    //   1203	1208	998	finally
    //   1210	1216	998	finally
    //   1222	1277	998	finally
    //   1308	1323	998	finally
    //   1345	1519	998	finally
    //   71	79	1011	finally
    //   189	196	1011	finally
    //   1003	1011	1011	finally
    //   1556	1625	1011	finally
    //   1625	1653	1011	finally
    //   1653	1681	1011	finally
    //   1681	1699	1011	finally
    //   1704	1739	1011	finally
    //   1739	1758	1011	finally
    //   1758	1782	1011	finally
    //   1790	1798	1011	finally
    //   1824	1853	1011	finally
    //   1862	1882	1011	finally
    //   1886	1896	1011	finally
    //   1899	1909	1011	finally
    //   1912	1931	1011	finally
    //   1931	1942	1011	finally
    //   1942	1949	1011	finally
    //   1959	1979	1011	finally
    //   1984	1990	1011	finally
    //   2001	2053	1011	finally
    //   2058	2064	1011	finally
    //   2067	2104	1011	finally
    //   2113	2119	1011	finally
    //   2128	2135	1011	finally
    //   2138	2179	1011	finally
    //   2182	2200	1011	finally
    //   2257	2263	1011	finally
    //   2266	2318	1011	finally
    //   2335	2343	1011	finally
    //   2343	2351	1011	finally
    //   2396	2404	1011	finally
    //   2404	2429	1011	finally
    //   2440	2448	1011	finally
    //   1798	1812	2330	finally
    //   2332	2335	2330	finally
    //   2351	2370	2391	finally
    //   2393	2396	2391	finally
    //   2200	2214	2435	finally
    //   2437	2440	2435	finally
    //   1021	1033	2448	finally
    //   2450	2453	2448	finally
  }
  
  private void stopEglContextLocked()
  {
    AppMethodBeat.i(133988);
    if (this.mHaveEglContext)
    {
      GLSurfaceView.h localh = this.jhe;
      ab.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
      if (localh.mEglContext != null)
      {
        GLSurfaceView localGLSurfaceView = (GLSurfaceView)localh.mGLSurfaceViewWeakRef.get();
        if (localGLSurfaceView != null) {
          GLSurfaceView.c(localGLSurfaceView).destroyContext(localh.mEgl, localh.mEglDisplay, localh.mEglContext);
        }
        localh.mEglContext = null;
      }
      if (localh.mEglDisplay != null)
      {
        localh.mEgl.eglTerminate(localh.mEglDisplay);
        localh.mEglDisplay = null;
      }
      this.mHaveEglContext = false;
      GLSurfaceView.aQa().notifyAll();
    }
    AppMethodBeat.o(133988);
  }
  
  public final int getRenderMode()
  {
    AppMethodBeat.i(133991);
    synchronized (GLSurfaceView.aQa())
    {
      int i = this.mRenderMode;
      AppMethodBeat.o(133991);
      return i;
    }
  }
  
  final boolean readyToDraw()
  {
    return (!this.mPaused) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.mRequestRender) || (this.mRenderMode == 1));
  }
  
  public final void requestExitAndWait()
  {
    AppMethodBeat.i(133992);
    synchronized (GLSurfaceView.aQa())
    {
      this.mShouldExit = true;
      GLSurfaceView.aQa().notifyAll();
      for (;;)
      {
        boolean bool = this.mExited;
        if (!bool) {
          try
          {
            GLSurfaceView.aQa().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    AppMethodBeat.o(133992);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 488
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: new 140	java/lang/StringBuilder
    //   10: dup
    //   11: ldc_w 490
    //   14: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   21: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokevirtual 493	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:setName	(Ljava/lang/String;)V
    //   30: ldc 210
    //   32: new 140	java/lang/StringBuilder
    //   35: dup
    //   36: ldc_w 495
    //   39: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: invokevirtual 221	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:getId	()J
    //   46: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: invokespecial 497	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i:guardedRun	()V
    //   59: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   62: aload_0
    //   63: invokevirtual 502	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j:b	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i;)V
    //   66: ldc_w 488
    //   69: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: astore_1
    //   74: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   77: aload_0
    //   78: invokevirtual 502	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j:b	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i;)V
    //   81: ldc_w 488
    //   84: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: return
    //   88: astore_1
    //   89: invokestatic 181	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView:aQa	()Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j;
    //   92: aload_0
    //   93: invokevirtual 502	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$j:b	(Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GLSurfaceView$i;)V
    //   96: ldc_w 488
    //   99: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	i
    //   73	1	1	localInterruptedException	InterruptedException
    //   88	15	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	59	73	java/lang/InterruptedException
    //   55	59	88	finally
  }
  
  public final void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(133990);
    if ((paramInt < 0) || (paramInt > 1))
    {
      ??? = new IllegalArgumentException("renderMode");
      AppMethodBeat.o(133990);
      throw ((Throwable)???);
    }
    synchronized (GLSurfaceView.aQa())
    {
      this.mRenderMode = paramInt;
      GLSurfaceView.aQa().notifyAll();
      AppMethodBeat.o(133990);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.i
 * JD-Core Version:    0.7.0.1
 */