package com.google.android.exoplayer2.video;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

final class DummySurface$a
  extends HandlerThread
  implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback
{
  private final int[] aTg = new int[1];
  private EGLDisplay aTh;
  private EGLContext aTi;
  private EGLSurface aTj;
  private SurfaceTexture aTk;
  private Error aTl;
  private RuntimeException aTm;
  private DummySurface aTn;
  Handler handler;
  
  public DummySurface$a()
  {
    super("dummySurface");
  }
  
  public final DummySurface aD(boolean paramBoolean)
  {
    int j = 0;
    start();
    this.handler = new Handler(getLooper(), this);
    try
    {
      Object localObject1 = this.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject1).obtainMessage(1, i, 0).sendToTarget();
        i = j;
        while ((this.aTn == null) && (this.aTm == null))
        {
          localObject1 = this.aTl;
          if (localObject1 != null) {
            break;
          }
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            i = 1;
          }
        }
      }
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      if (this.aTm != null) {
        throw this.aTm;
      }
    }
    finally {}
    if (this.aTl != null) {
      throw this.aTl;
    }
    return this.aTn;
  }
  
  /* Error */
  public final boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 98	android/os/Message:what	I
    //   4: tableswitch	default:+28 -> 32, 1:+30->34, 2:+618->622, 3:+627->631
    //   33: ireturn
    //   34: aload_1
    //   35: getfield 101	android/os/Message:arg1	I
    //   38: ifeq +446 -> 484
    //   41: iconst_1
    //   42: istore_2
    //   43: aload_0
    //   44: iconst_0
    //   45: invokestatic 107	android/opengl/EGL14:eglGetDisplay	(I)Landroid/opengl/EGLDisplay;
    //   48: putfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   51: aload_0
    //   52: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   55: ifnull +434 -> 489
    //   58: iconst_1
    //   59: istore_3
    //   60: iload_3
    //   61: ldc 111
    //   63: invokestatic 117	com/google/android/exoplayer2/i/a:c	(ZLjava/lang/Object;)V
    //   66: iconst_2
    //   67: newarray int
    //   69: astore_1
    //   70: aload_0
    //   71: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   74: aload_1
    //   75: iconst_0
    //   76: aload_1
    //   77: iconst_1
    //   78: invokestatic 121	android/opengl/EGL14:eglInitialize	(Landroid/opengl/EGLDisplay;[II[II)Z
    //   81: ldc 123
    //   83: invokestatic 117	com/google/android/exoplayer2/i/a:c	(ZLjava/lang/Object;)V
    //   86: iconst_1
    //   87: anewarray 125	android/opengl/EGLConfig
    //   90: astore_1
    //   91: iconst_1
    //   92: newarray int
    //   94: astore 4
    //   96: aload_0
    //   97: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   100: bipush 17
    //   102: newarray int
    //   104: dup
    //   105: iconst_0
    //   106: sipush 12352
    //   109: iastore
    //   110: dup
    //   111: iconst_1
    //   112: iconst_4
    //   113: iastore
    //   114: dup
    //   115: iconst_2
    //   116: sipush 12324
    //   119: iastore
    //   120: dup
    //   121: iconst_3
    //   122: bipush 8
    //   124: iastore
    //   125: dup
    //   126: iconst_4
    //   127: sipush 12323
    //   130: iastore
    //   131: dup
    //   132: iconst_5
    //   133: bipush 8
    //   135: iastore
    //   136: dup
    //   137: bipush 6
    //   139: sipush 12322
    //   142: iastore
    //   143: dup
    //   144: bipush 7
    //   146: bipush 8
    //   148: iastore
    //   149: dup
    //   150: bipush 8
    //   152: sipush 12321
    //   155: iastore
    //   156: dup
    //   157: bipush 9
    //   159: bipush 8
    //   161: iastore
    //   162: dup
    //   163: bipush 10
    //   165: sipush 12325
    //   168: iastore
    //   169: dup
    //   170: bipush 11
    //   172: iconst_0
    //   173: iastore
    //   174: dup
    //   175: bipush 12
    //   177: sipush 12327
    //   180: iastore
    //   181: dup
    //   182: bipush 13
    //   184: sipush 12344
    //   187: iastore
    //   188: dup
    //   189: bipush 14
    //   191: sipush 12339
    //   194: iastore
    //   195: dup
    //   196: bipush 15
    //   198: iconst_4
    //   199: iastore
    //   200: dup
    //   201: bipush 16
    //   203: sipush 12344
    //   206: iastore
    //   207: iconst_0
    //   208: aload_1
    //   209: iconst_0
    //   210: iconst_1
    //   211: aload 4
    //   213: iconst_0
    //   214: invokestatic 129	android/opengl/EGL14:eglChooseConfig	(Landroid/opengl/EGLDisplay;[II[Landroid/opengl/EGLConfig;II[II)Z
    //   217: ifeq +277 -> 494
    //   220: aload 4
    //   222: iconst_0
    //   223: iaload
    //   224: ifle +270 -> 494
    //   227: aload_1
    //   228: iconst_0
    //   229: aaload
    //   230: ifnull +264 -> 494
    //   233: iconst_1
    //   234: istore_3
    //   235: iload_3
    //   236: ldc 131
    //   238: invokestatic 117	com/google/android/exoplayer2/i/a:c	(ZLjava/lang/Object;)V
    //   241: aload_1
    //   242: iconst_0
    //   243: aaload
    //   244: astore 4
    //   246: iload_2
    //   247: ifeq +252 -> 499
    //   250: iconst_5
    //   251: newarray int
    //   253: astore_1
    //   254: aload_1
    //   255: dup
    //   256: iconst_0
    //   257: sipush 12440
    //   260: iastore
    //   261: dup
    //   262: iconst_1
    //   263: iconst_2
    //   264: iastore
    //   265: dup
    //   266: iconst_2
    //   267: sipush 12992
    //   270: iastore
    //   271: dup
    //   272: iconst_3
    //   273: iconst_1
    //   274: iastore
    //   275: dup
    //   276: iconst_4
    //   277: sipush 12344
    //   280: iastore
    //   281: pop
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   287: aload 4
    //   289: getstatic 134	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   292: aload_1
    //   293: iconst_0
    //   294: invokestatic 138	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   297: putfield 140	com/google/android/exoplayer2/video/DummySurface$a:aTi	Landroid/opengl/EGLContext;
    //   300: aload_0
    //   301: getfield 140	com/google/android/exoplayer2/video/DummySurface$a:aTi	Landroid/opengl/EGLContext;
    //   304: ifnull +502 -> 806
    //   307: iconst_1
    //   308: istore_3
    //   309: iload_3
    //   310: ldc 142
    //   312: invokestatic 117	com/google/android/exoplayer2/i/a:c	(ZLjava/lang/Object;)V
    //   315: iload_2
    //   316: ifeq +208 -> 524
    //   319: bipush 7
    //   321: newarray int
    //   323: astore_1
    //   324: aload_1
    //   325: dup
    //   326: iconst_0
    //   327: sipush 12375
    //   330: iastore
    //   331: dup
    //   332: iconst_1
    //   333: iconst_1
    //   334: iastore
    //   335: dup
    //   336: iconst_2
    //   337: sipush 12374
    //   340: iastore
    //   341: dup
    //   342: iconst_3
    //   343: iconst_1
    //   344: iastore
    //   345: dup
    //   346: iconst_4
    //   347: sipush 12992
    //   350: iastore
    //   351: dup
    //   352: iconst_5
    //   353: iconst_1
    //   354: iastore
    //   355: dup
    //   356: bipush 6
    //   358: sipush 12344
    //   361: iastore
    //   362: pop
    //   363: aload_0
    //   364: aload_0
    //   365: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   368: aload 4
    //   370: aload_1
    //   371: iconst_0
    //   372: invokestatic 146	android/opengl/EGL14:eglCreatePbufferSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;[II)Landroid/opengl/EGLSurface;
    //   375: putfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   378: aload_0
    //   379: getfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   382: ifnull +177 -> 559
    //   385: iconst_1
    //   386: istore_3
    //   387: iload_3
    //   388: ldc 150
    //   390: invokestatic 117	com/google/android/exoplayer2/i/a:c	(ZLjava/lang/Object;)V
    //   393: aload_0
    //   394: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   397: aload_0
    //   398: getfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   401: aload_0
    //   402: getfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   405: aload_0
    //   406: getfield 140	com/google/android/exoplayer2/video/DummySurface$a:aTi	Landroid/opengl/EGLContext;
    //   409: invokestatic 154	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   412: ldc 156
    //   414: invokestatic 117	com/google/android/exoplayer2/i/a:c	(ZLjava/lang/Object;)V
    //   417: iconst_1
    //   418: aload_0
    //   419: getfield 38	com/google/android/exoplayer2/video/DummySurface$a:aTg	[I
    //   422: iconst_0
    //   423: invokestatic 162	android/opengl/GLES20:glGenTextures	(I[II)V
    //   426: aload_0
    //   427: new 164	android/graphics/SurfaceTexture
    //   430: dup
    //   431: aload_0
    //   432: getfield 38	com/google/android/exoplayer2/video/DummySurface$a:aTg	[I
    //   435: iconst_0
    //   436: iaload
    //   437: invokespecial 167	android/graphics/SurfaceTexture:<init>	(I)V
    //   440: putfield 169	com/google/android/exoplayer2/video/DummySurface$a:aTk	Landroid/graphics/SurfaceTexture;
    //   443: aload_0
    //   444: getfield 169	com/google/android/exoplayer2/video/DummySurface$a:aTk	Landroid/graphics/SurfaceTexture;
    //   447: aload_0
    //   448: invokevirtual 173	android/graphics/SurfaceTexture:setOnFrameAvailableListener	(Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;)V
    //   451: aload_0
    //   452: new 10	com/google/android/exoplayer2/video/DummySurface
    //   455: dup
    //   456: aload_0
    //   457: aload_0
    //   458: getfield 169	com/google/android/exoplayer2/video/DummySurface$a:aTk	Landroid/graphics/SurfaceTexture;
    //   461: iload_2
    //   462: iconst_0
    //   463: invokespecial 176	com/google/android/exoplayer2/video/DummySurface:<init>	(Lcom/google/android/exoplayer2/video/DummySurface$a;Landroid/graphics/SurfaceTexture;ZB)V
    //   466: putfield 68	com/google/android/exoplayer2/video/DummySurface$a:aTn	Lcom/google/android/exoplayer2/video/DummySurface;
    //   469: aload_0
    //   470: monitorenter
    //   471: aload_0
    //   472: invokevirtual 179	java/lang/Object:notify	()V
    //   475: aload_0
    //   476: monitorexit
    //   477: iconst_1
    //   478: ireturn
    //   479: astore_1
    //   480: aload_0
    //   481: monitorexit
    //   482: aload_1
    //   483: athrow
    //   484: iconst_0
    //   485: istore_2
    //   486: goto -443 -> 43
    //   489: iconst_0
    //   490: istore_3
    //   491: goto -431 -> 60
    //   494: iconst_0
    //   495: istore_3
    //   496: goto -261 -> 235
    //   499: iconst_3
    //   500: newarray int
    //   502: astore_1
    //   503: aload_1
    //   504: dup
    //   505: iconst_0
    //   506: sipush 12440
    //   509: iastore
    //   510: dup
    //   511: iconst_1
    //   512: iconst_2
    //   513: iastore
    //   514: dup
    //   515: iconst_2
    //   516: sipush 12344
    //   519: iastore
    //   520: pop
    //   521: goto -239 -> 282
    //   524: iconst_5
    //   525: newarray int
    //   527: astore_1
    //   528: aload_1
    //   529: dup
    //   530: iconst_0
    //   531: sipush 12375
    //   534: iastore
    //   535: dup
    //   536: iconst_1
    //   537: iconst_1
    //   538: iastore
    //   539: dup
    //   540: iconst_2
    //   541: sipush 12374
    //   544: iastore
    //   545: dup
    //   546: iconst_3
    //   547: iconst_1
    //   548: iastore
    //   549: dup
    //   550: iconst_4
    //   551: sipush 12344
    //   554: iastore
    //   555: pop
    //   556: goto -193 -> 363
    //   559: iconst_0
    //   560: istore_3
    //   561: goto -174 -> 387
    //   564: astore_1
    //   565: aload_0
    //   566: aload_1
    //   567: putfield 70	com/google/android/exoplayer2/video/DummySurface$a:aTm	Ljava/lang/RuntimeException;
    //   570: aload_0
    //   571: monitorenter
    //   572: aload_0
    //   573: invokevirtual 179	java/lang/Object:notify	()V
    //   576: aload_0
    //   577: monitorexit
    //   578: iconst_1
    //   579: ireturn
    //   580: astore_1
    //   581: aload_0
    //   582: monitorexit
    //   583: aload_1
    //   584: athrow
    //   585: astore_1
    //   586: aload_0
    //   587: aload_1
    //   588: putfield 72	com/google/android/exoplayer2/video/DummySurface$a:aTl	Ljava/lang/Error;
    //   591: aload_0
    //   592: monitorenter
    //   593: aload_0
    //   594: invokevirtual 179	java/lang/Object:notify	()V
    //   597: aload_0
    //   598: monitorexit
    //   599: iconst_1
    //   600: ireturn
    //   601: astore_1
    //   602: aload_0
    //   603: monitorexit
    //   604: aload_1
    //   605: athrow
    //   606: astore_1
    //   607: aload_0
    //   608: monitorenter
    //   609: aload_0
    //   610: invokevirtual 179	java/lang/Object:notify	()V
    //   613: aload_0
    //   614: monitorexit
    //   615: aload_1
    //   616: athrow
    //   617: astore_1
    //   618: aload_0
    //   619: monitorexit
    //   620: aload_1
    //   621: athrow
    //   622: aload_0
    //   623: getfield 169	com/google/android/exoplayer2/video/DummySurface$a:aTk	Landroid/graphics/SurfaceTexture;
    //   626: invokevirtual 182	android/graphics/SurfaceTexture:updateTexImage	()V
    //   629: iconst_1
    //   630: ireturn
    //   631: aload_0
    //   632: getfield 169	com/google/android/exoplayer2/video/DummySurface$a:aTk	Landroid/graphics/SurfaceTexture;
    //   635: ifnull +19 -> 654
    //   638: aload_0
    //   639: getfield 169	com/google/android/exoplayer2/video/DummySurface$a:aTk	Landroid/graphics/SurfaceTexture;
    //   642: invokevirtual 185	android/graphics/SurfaceTexture:release	()V
    //   645: iconst_1
    //   646: aload_0
    //   647: getfield 38	com/google/android/exoplayer2/video/DummySurface$a:aTg	[I
    //   650: iconst_0
    //   651: invokestatic 188	android/opengl/GLES20:glDeleteTextures	(I[II)V
    //   654: aload_0
    //   655: getfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   658: ifnull +15 -> 673
    //   661: aload_0
    //   662: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   665: aload_0
    //   666: getfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   669: invokestatic 192	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   672: pop
    //   673: aload_0
    //   674: getfield 140	com/google/android/exoplayer2/video/DummySurface$a:aTi	Landroid/opengl/EGLContext;
    //   677: ifnull +15 -> 692
    //   680: aload_0
    //   681: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   684: aload_0
    //   685: getfield 140	com/google/android/exoplayer2/video/DummySurface$a:aTi	Landroid/opengl/EGLContext;
    //   688: invokestatic 196	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
    //   691: pop
    //   692: aload_0
    //   693: aconst_null
    //   694: putfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   697: aload_0
    //   698: aconst_null
    //   699: putfield 140	com/google/android/exoplayer2/video/DummySurface$a:aTi	Landroid/opengl/EGLContext;
    //   702: aload_0
    //   703: aconst_null
    //   704: putfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   707: aload_0
    //   708: aconst_null
    //   709: putfield 68	com/google/android/exoplayer2/video/DummySurface$a:aTn	Lcom/google/android/exoplayer2/video/DummySurface;
    //   712: aload_0
    //   713: aconst_null
    //   714: putfield 169	com/google/android/exoplayer2/video/DummySurface$a:aTk	Landroid/graphics/SurfaceTexture;
    //   717: aload_0
    //   718: invokevirtual 200	com/google/android/exoplayer2/video/DummySurface$a:quit	()Z
    //   721: pop
    //   722: iconst_1
    //   723: ireturn
    //   724: astore_1
    //   725: aload_0
    //   726: getfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   729: ifnull +15 -> 744
    //   732: aload_0
    //   733: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   736: aload_0
    //   737: getfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   740: invokestatic 192	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   743: pop
    //   744: aload_0
    //   745: getfield 140	com/google/android/exoplayer2/video/DummySurface$a:aTi	Landroid/opengl/EGLContext;
    //   748: ifnull +15 -> 763
    //   751: aload_0
    //   752: getfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   755: aload_0
    //   756: getfield 140	com/google/android/exoplayer2/video/DummySurface$a:aTi	Landroid/opengl/EGLContext;
    //   759: invokestatic 196	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
    //   762: pop
    //   763: aload_0
    //   764: aconst_null
    //   765: putfield 148	com/google/android/exoplayer2/video/DummySurface$a:aTj	Landroid/opengl/EGLSurface;
    //   768: aload_0
    //   769: aconst_null
    //   770: putfield 140	com/google/android/exoplayer2/video/DummySurface$a:aTi	Landroid/opengl/EGLContext;
    //   773: aload_0
    //   774: aconst_null
    //   775: putfield 109	com/google/android/exoplayer2/video/DummySurface$a:aTh	Landroid/opengl/EGLDisplay;
    //   778: aload_0
    //   779: aconst_null
    //   780: putfield 68	com/google/android/exoplayer2/video/DummySurface$a:aTn	Lcom/google/android/exoplayer2/video/DummySurface;
    //   783: aload_0
    //   784: aconst_null
    //   785: putfield 169	com/google/android/exoplayer2/video/DummySurface$a:aTk	Landroid/graphics/SurfaceTexture;
    //   788: aload_1
    //   789: athrow
    //   790: astore_1
    //   791: aload_0
    //   792: invokevirtual 200	com/google/android/exoplayer2/video/DummySurface$a:quit	()Z
    //   795: pop
    //   796: iconst_1
    //   797: ireturn
    //   798: astore_1
    //   799: aload_0
    //   800: invokevirtual 200	com/google/android/exoplayer2/video/DummySurface$a:quit	()Z
    //   803: pop
    //   804: aload_1
    //   805: athrow
    //   806: iconst_0
    //   807: istore_3
    //   808: goto -499 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	811	0	this	a
    //   0	811	1	paramMessage	Message
    //   42	444	2	bool1	boolean
    //   59	749	3	bool2	boolean
    //   94	275	4	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   471	477	479	finally
    //   480	482	479	finally
    //   34	41	564	java/lang/RuntimeException
    //   43	58	564	java/lang/RuntimeException
    //   60	220	564	java/lang/RuntimeException
    //   235	241	564	java/lang/RuntimeException
    //   250	282	564	java/lang/RuntimeException
    //   282	307	564	java/lang/RuntimeException
    //   309	315	564	java/lang/RuntimeException
    //   319	363	564	java/lang/RuntimeException
    //   363	385	564	java/lang/RuntimeException
    //   387	469	564	java/lang/RuntimeException
    //   499	521	564	java/lang/RuntimeException
    //   524	528	564	java/lang/RuntimeException
    //   572	578	580	finally
    //   581	583	580	finally
    //   34	41	585	java/lang/Error
    //   43	58	585	java/lang/Error
    //   60	220	585	java/lang/Error
    //   235	241	585	java/lang/Error
    //   250	282	585	java/lang/Error
    //   282	307	585	java/lang/Error
    //   309	315	585	java/lang/Error
    //   319	363	585	java/lang/Error
    //   363	385	585	java/lang/Error
    //   387	469	585	java/lang/Error
    //   499	521	585	java/lang/Error
    //   524	528	585	java/lang/Error
    //   593	599	601	finally
    //   602	604	601	finally
    //   34	41	606	finally
    //   43	58	606	finally
    //   60	220	606	finally
    //   235	241	606	finally
    //   250	282	606	finally
    //   282	307	606	finally
    //   309	315	606	finally
    //   319	363	606	finally
    //   363	385	606	finally
    //   387	469	606	finally
    //   499	521	606	finally
    //   524	528	606	finally
    //   565	570	606	finally
    //   586	591	606	finally
    //   609	615	617	finally
    //   618	620	617	finally
    //   631	654	724	finally
    //   654	673	790	java/lang/Throwable
    //   673	692	790	java/lang/Throwable
    //   692	717	790	java/lang/Throwable
    //   725	744	790	java/lang/Throwable
    //   744	763	790	java/lang/Throwable
    //   763	790	790	java/lang/Throwable
    //   654	673	798	finally
    //   673	692	798	finally
    //   692	717	798	finally
    //   725	744	798	finally
    //   744	763	798	finally
    //   763	790	798	finally
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.handler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface.a
 * JD-Core Version:    0.7.0.1
 */