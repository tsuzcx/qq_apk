package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class e
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final e.j a = new e.j(null);
  private i b;
  private GLSurfaceView.Renderer c;
  protected boolean d = false;
  protected boolean e = false;
  protected final WeakReference<e> f = new WeakReference(this);
  protected boolean g;
  protected boolean h;
  private boolean i;
  private e.e j;
  private f k;
  private e.g l;
  private e.k m;
  private int n;
  private int o;
  private boolean p;
  
  public e(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void b()
  {
    getHolder().addCallback(this);
  }
  
  private void f()
  {
    if (this.b != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new e.b(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  protected int c()
  {
    return 0;
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if ((!this.d) && (this.e) && (this.b != null))
    {
      TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
      this.b.a(new Runnable()
      {
        public void run()
        {
          e.this.a();
        }
      });
      this.b.f();
    }
  }
  
  public int d()
  {
    return this.b.a();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.b != null) {
        this.b.g();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.n;
  }
  
  public e.h getEGLHelper()
  {
    return this.b.b();
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.p;
  }
  
  public int getRenderMode()
  {
    return this.b.d();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.i) && (this.c != null)) {
      if (this.b == null) {
        break label74;
      }
    }
    label74:
    for (int i1 = this.b.d();; i1 = 1)
    {
      this.b = new i(this.f);
      if (i1 != 1) {
        this.b.a(i1);
      }
      this.b.start();
      this.i = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.b != null) {
      this.b.g();
    }
    this.i = true;
    super.onDetachedFromWindow();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setEGLConfigChooser(e.e parame)
  {
    f();
    this.j = parame;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new e.m(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    f();
    this.o = paramInt;
  }
  
  public void setEGLContextFactory(f paramf)
  {
    f();
    this.k = paramf;
  }
  
  public void setEGLWindowSurfaceFactory(e.g paramg)
  {
    f();
    this.l = paramg;
  }
  
  public void setGLWrapper(e.k paramk)
  {
    this.m = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    f();
    if (this.j == null) {
      this.j = new e.m(this, true);
    }
    if (this.k == null) {
      this.k = new e.c(this, null);
    }
    if (this.l == null) {
      this.l = new e.d(null);
    }
    this.c = paramRenderer;
    this.b = new i(this.f);
    this.b.start();
  }
  
  protected void setRunInBackground(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.b.e();
    setRunInBackground(false);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    setRunInBackground(true);
    if (!this.d)
    {
      this.b.a(new e.1(this));
      this.b.f();
    }
  }
  
  public static abstract interface f
  {
    public abstract EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  static class i
    extends Thread
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l = 0;
    private int m = 0;
    private int n = 1;
    private boolean o = true;
    private boolean p;
    private ArrayList<Runnable> q = new ArrayList();
    private boolean r = true;
    private e.h s;
    private WeakReference<e> t;
    
    i(WeakReference<e> paramWeakReference)
    {
      this.t = paramWeakReference;
    }
    
    /* Error */
    private void i()
    {
      // Byte code:
      //   0: aload_0
      //   1: new 65	com/tencent/liteav/renderer/e$h
      //   4: dup
      //   5: aload_0
      //   6: getfield 55	com/tencent/liteav/renderer/e$i:t	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 67	com/tencent/liteav/renderer/e$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 69	com/tencent/liteav/renderer/e$i:s	Lcom/tencent/liteav/renderer/e$h;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 71	com/tencent/liteav/renderer/e$i:h	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 73	com/tencent/liteav/renderer/e$i:i	Z
      //   25: iconst_0
      //   26: istore_3
      //   27: iconst_0
      //   28: istore 4
      //   30: iconst_0
      //   31: istore 6
      //   33: iconst_0
      //   34: istore_2
      //   35: iconst_0
      //   36: istore 5
      //   38: iconst_0
      //   39: istore 8
      //   41: iconst_0
      //   42: istore_1
      //   43: iconst_0
      //   44: istore 12
      //   46: iconst_0
      //   47: istore 9
      //   49: iconst_0
      //   50: istore 10
      //   52: aconst_null
      //   53: astore 22
      //   55: aconst_null
      //   56: astore 21
      //   58: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   61: astore 23
      //   63: aload 23
      //   65: monitorenter
      //   66: iload 12
      //   68: istore 7
      //   70: aload_0
      //   71: getfield 78	com/tencent/liteav/renderer/e$i:a	Z
      //   74: ifeq +34 -> 108
      //   77: aload 23
      //   79: monitorexit
      //   80: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   83: astore 21
      //   85: aload 21
      //   87: monitorenter
      //   88: aload_0
      //   89: invokespecial 80	com/tencent/liteav/renderer/e$i:j	()V
      //   92: aload_0
      //   93: invokespecial 82	com/tencent/liteav/renderer/e$i:k	()V
      //   96: aload 21
      //   98: monitorexit
      //   99: return
      //   100: astore 22
      //   102: aload 21
      //   104: monitorexit
      //   105: aload 22
      //   107: athrow
      //   108: aload_0
      //   109: getfield 43	com/tencent/liteav/renderer/e$i:q	Ljava/util/ArrayList;
      //   112: invokevirtual 86	java/util/ArrayList:isEmpty	()Z
      //   115: ifne +63 -> 178
      //   118: aload_0
      //   119: getfield 43	com/tencent/liteav/renderer/e$i:q	Ljava/util/ArrayList;
      //   122: iconst_0
      //   123: invokevirtual 90	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   126: checkcast 92	java/lang/Runnable
      //   129: astore 22
      //   131: iload 7
      //   133: istore 12
      //   135: iload 9
      //   137: istore 13
      //   139: iload 4
      //   141: istore 7
      //   143: iload_1
      //   144: istore 4
      //   146: aload 23
      //   148: monitorexit
      //   149: aload 22
      //   151: ifnull +611 -> 762
      //   154: aload 22
      //   156: invokeinterface 95 1 0
      //   161: aconst_null
      //   162: astore 22
      //   164: iload 4
      //   166: istore_1
      //   167: iload 7
      //   169: istore 4
      //   171: iload 13
      //   173: istore 9
      //   175: goto -117 -> 58
      //   178: aload_0
      //   179: getfield 97	com/tencent/liteav/renderer/e$i:d	Z
      //   182: aload_0
      //   183: getfield 99	com/tencent/liteav/renderer/e$i:c	Z
      //   186: if_icmpeq +937 -> 1123
      //   189: aload_0
      //   190: getfield 99	com/tencent/liteav/renderer/e$i:c	Z
      //   193: istore 19
      //   195: aload_0
      //   196: aload_0
      //   197: getfield 99	com/tencent/liteav/renderer/e$i:c	Z
      //   200: putfield 97	com/tencent/liteav/renderer/e$i:d	Z
      //   203: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   206: invokevirtual 104	java/lang/Object:notifyAll	()V
      //   209: aload_0
      //   210: getfield 106	com/tencent/liteav/renderer/e$i:k	Z
      //   213: ifeq +19 -> 232
      //   216: aload_0
      //   217: invokespecial 80	com/tencent/liteav/renderer/e$i:j	()V
      //   220: aload_0
      //   221: invokespecial 82	com/tencent/liteav/renderer/e$i:k	()V
      //   224: aload_0
      //   225: iconst_0
      //   226: putfield 106	com/tencent/liteav/renderer/e$i:k	Z
      //   229: iconst_1
      //   230: istore 7
      //   232: iload_2
      //   233: istore 11
      //   235: iload_2
      //   236: ifeq +14 -> 250
      //   239: aload_0
      //   240: invokespecial 80	com/tencent/liteav/renderer/e$i:j	()V
      //   243: aload_0
      //   244: invokespecial 82	com/tencent/liteav/renderer/e$i:k	()V
      //   247: iconst_0
      //   248: istore 11
      //   250: iload 19
      //   252: ifeq +14 -> 266
      //   255: aload_0
      //   256: getfield 73	com/tencent/liteav/renderer/e$i:i	Z
      //   259: ifeq +7 -> 266
      //   262: aload_0
      //   263: invokespecial 80	com/tencent/liteav/renderer/e$i:j	()V
      //   266: iload 19
      //   268: ifeq +48 -> 316
      //   271: aload_0
      //   272: getfield 71	com/tencent/liteav/renderer/e$i:h	Z
      //   275: ifeq +41 -> 316
      //   278: aload_0
      //   279: getfield 55	com/tencent/liteav/renderer/e$i:t	Ljava/lang/ref/WeakReference;
      //   282: invokevirtual 112	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   285: checkcast 6	com/tencent/liteav/renderer/e
      //   288: astore 24
      //   290: aload 24
      //   292: ifnonnull +333 -> 625
      //   295: iconst_0
      //   296: istore 20
      //   298: iload 20
      //   300: ifeq +12 -> 312
      //   303: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   306: invokevirtual 116	com/tencent/liteav/renderer/e$j:a	()Z
      //   309: ifeq +7 -> 316
      //   312: aload_0
      //   313: invokespecial 82	com/tencent/liteav/renderer/e$i:k	()V
      //   316: iload 19
      //   318: ifeq +19 -> 337
      //   321: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   324: invokevirtual 118	com/tencent/liteav/renderer/e$j:b	()Z
      //   327: ifeq +10 -> 337
      //   330: aload_0
      //   331: getfield 69	com/tencent/liteav/renderer/e$i:s	Lcom/tencent/liteav/renderer/e$h;
      //   334: invokevirtual 120	com/tencent/liteav/renderer/e$h:g	()V
      //   337: aload_0
      //   338: getfield 122	com/tencent/liteav/renderer/e$i:e	Z
      //   341: ifne +37 -> 378
      //   344: aload_0
      //   345: getfield 124	com/tencent/liteav/renderer/e$i:g	Z
      //   348: ifne +30 -> 378
      //   351: aload_0
      //   352: getfield 73	com/tencent/liteav/renderer/e$i:i	Z
      //   355: ifeq +7 -> 362
      //   358: aload_0
      //   359: invokespecial 80	com/tencent/liteav/renderer/e$i:j	()V
      //   362: aload_0
      //   363: iconst_1
      //   364: putfield 124	com/tencent/liteav/renderer/e$i:g	Z
      //   367: aload_0
      //   368: iconst_0
      //   369: putfield 126	com/tencent/liteav/renderer/e$i:f	Z
      //   372: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   375: invokevirtual 104	java/lang/Object:notifyAll	()V
      //   378: aload_0
      //   379: getfield 122	com/tencent/liteav/renderer/e$i:e	Z
      //   382: ifeq +21 -> 403
      //   385: aload_0
      //   386: getfield 124	com/tencent/liteav/renderer/e$i:g	Z
      //   389: ifeq +14 -> 403
      //   392: aload_0
      //   393: iconst_0
      //   394: putfield 124	com/tencent/liteav/renderer/e$i:g	Z
      //   397: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   400: invokevirtual 104	java/lang/Object:notifyAll	()V
      //   403: iload_1
      //   404: istore 12
      //   406: iload 8
      //   408: istore 13
      //   410: iload_1
      //   411: ifeq +20 -> 431
      //   414: iconst_0
      //   415: istore 13
      //   417: iconst_0
      //   418: istore 12
      //   420: aload_0
      //   421: iconst_1
      //   422: putfield 128	com/tencent/liteav/renderer/e$i:p	Z
      //   425: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   428: invokevirtual 104	java/lang/Object:notifyAll	()V
      //   431: iload 4
      //   433: istore 18
      //   435: iload 7
      //   437: istore 14
      //   439: iload 5
      //   441: istore 17
      //   443: iload 6
      //   445: istore 15
      //   447: iload_3
      //   448: istore 16
      //   450: aload_0
      //   451: invokespecial 130	com/tencent/liteav/renderer/e$i:l	()Z
      //   454: ifeq +270 -> 724
      //   457: iload 7
      //   459: istore_2
      //   460: iload_3
      //   461: istore_1
      //   462: aload_0
      //   463: getfield 71	com/tencent/liteav/renderer/e$i:h	Z
      //   466: ifne +12 -> 478
      //   469: iload 7
      //   471: ifeq +164 -> 635
      //   474: iconst_0
      //   475: istore_2
      //   476: iload_3
      //   477: istore_1
      //   478: iload 4
      //   480: istore 8
      //   482: iload 5
      //   484: istore 7
      //   486: iload 6
      //   488: istore_3
      //   489: aload_0
      //   490: getfield 71	com/tencent/liteav/renderer/e$i:h	Z
      //   493: ifeq +34 -> 527
      //   496: iload 4
      //   498: istore 8
      //   500: iload 5
      //   502: istore 7
      //   504: iload 6
      //   506: istore_3
      //   507: aload_0
      //   508: getfield 73	com/tencent/liteav/renderer/e$i:i	Z
      //   511: ifne +16 -> 527
      //   514: aload_0
      //   515: iconst_1
      //   516: putfield 73	com/tencent/liteav/renderer/e$i:i	Z
      //   519: iconst_1
      //   520: istore 8
      //   522: iconst_1
      //   523: istore_3
      //   524: iconst_1
      //   525: istore 7
      //   527: iload 8
      //   529: istore 18
      //   531: iload_2
      //   532: istore 14
      //   534: iload 7
      //   536: istore 17
      //   538: iload_3
      //   539: istore 15
      //   541: iload_1
      //   542: istore 16
      //   544: aload_0
      //   545: getfield 73	com/tencent/liteav/renderer/e$i:i	Z
      //   548: ifeq +176 -> 724
      //   551: aload_0
      //   552: getfield 45	com/tencent/liteav/renderer/e$i:r	Z
      //   555: ifeq +549 -> 1104
      //   558: iconst_1
      //   559: istore 5
      //   561: aload_0
      //   562: getfield 47	com/tencent/liteav/renderer/e$i:l	I
      //   565: istore 9
      //   567: aload_0
      //   568: getfield 49	com/tencent/liteav/renderer/e$i:m	I
      //   571: istore 4
      //   573: iconst_1
      //   574: istore 8
      //   576: iconst_1
      //   577: istore 6
      //   579: aload_0
      //   580: iconst_0
      //   581: putfield 45	com/tencent/liteav/renderer/e$i:r	Z
      //   584: aload_0
      //   585: iconst_0
      //   586: putfield 51	com/tencent/liteav/renderer/e$i:o	Z
      //   589: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   592: invokevirtual 104	java/lang/Object:notifyAll	()V
      //   595: iload 4
      //   597: istore 10
      //   599: iload 12
      //   601: istore 4
      //   603: iload 6
      //   605: istore 7
      //   607: iload 9
      //   609: istore 13
      //   611: iload_2
      //   612: istore 12
      //   614: iload 11
      //   616: istore_2
      //   617: iload_3
      //   618: istore 6
      //   620: iload_1
      //   621: istore_3
      //   622: goto -476 -> 146
      //   625: aload 24
      //   627: invokestatic 133	com/tencent/liteav/renderer/e:a	(Lcom/tencent/liteav/renderer/e;)Z
      //   630: istore 20
      //   632: goto -334 -> 298
      //   635: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   638: aload_0
      //   639: invokevirtual 136	com/tencent/liteav/renderer/e$j:b	(Lcom/tencent/liteav/renderer/e$i;)Z
      //   642: istore 19
      //   644: iload 7
      //   646: istore_2
      //   647: iload_3
      //   648: istore_1
      //   649: iload 19
      //   651: ifeq -173 -> 478
      //   654: aload_0
      //   655: getfield 69	com/tencent/liteav/renderer/e$i:s	Lcom/tencent/liteav/renderer/e$h;
      //   658: invokevirtual 138	com/tencent/liteav/renderer/e$h:a	()V
      //   661: aload_0
      //   662: iconst_1
      //   663: putfield 71	com/tencent/liteav/renderer/e$i:h	Z
      //   666: iconst_1
      //   667: istore_1
      //   668: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   671: invokevirtual 104	java/lang/Object:notifyAll	()V
      //   674: iload 7
      //   676: istore_2
      //   677: goto -199 -> 478
      //   680: astore 21
      //   682: aload 23
      //   684: monitorexit
      //   685: aload 21
      //   687: athrow
      //   688: astore 22
      //   690: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   693: astore 21
      //   695: aload 21
      //   697: monitorenter
      //   698: aload_0
      //   699: invokespecial 80	com/tencent/liteav/renderer/e$i:j	()V
      //   702: aload_0
      //   703: invokespecial 82	com/tencent/liteav/renderer/e$i:k	()V
      //   706: aload 21
      //   708: monitorexit
      //   709: aload 22
      //   711: athrow
      //   712: astore 21
      //   714: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   717: aload_0
      //   718: invokevirtual 141	com/tencent/liteav/renderer/e$j:c	(Lcom/tencent/liteav/renderer/e$i;)V
      //   721: aload 21
      //   723: athrow
      //   724: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   727: invokevirtual 144	java/lang/Object:wait	()V
      //   730: iload 12
      //   732: istore_1
      //   733: iload 18
      //   735: istore 4
      //   737: iload 14
      //   739: istore 7
      //   741: iload 13
      //   743: istore 8
      //   745: iload 17
      //   747: istore 5
      //   749: iload 11
      //   751: istore_2
      //   752: iload 15
      //   754: istore 6
      //   756: iload 16
      //   758: istore_3
      //   759: goto -689 -> 70
      //   762: iload 7
      //   764: istore 9
      //   766: iload 7
      //   768: ifeq +38 -> 806
      //   771: aload_0
      //   772: getfield 69	com/tencent/liteav/renderer/e$i:s	Lcom/tencent/liteav/renderer/e$h;
      //   775: invokevirtual 145	com/tencent/liteav/renderer/e$h:b	()Z
      //   778: ifeq +252 -> 1030
      //   781: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   784: astore 23
      //   786: aload 23
      //   788: monitorenter
      //   789: aload_0
      //   790: iconst_1
      //   791: putfield 147	com/tencent/liteav/renderer/e$i:j	Z
      //   794: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   797: invokevirtual 104	java/lang/Object:notifyAll	()V
      //   800: aload 23
      //   802: monitorexit
      //   803: iconst_0
      //   804: istore 9
      //   806: iload 6
      //   808: ifeq +293 -> 1101
      //   811: aload_0
      //   812: getfield 69	com/tencent/liteav/renderer/e$i:s	Lcom/tencent/liteav/renderer/e$h;
      //   815: invokevirtual 150	com/tencent/liteav/renderer/e$h:d	()Ljavax/microedition/khronos/opengles/GL;
      //   818: checkcast 152	javax/microedition/khronos/opengles/GL10
      //   821: astore 21
      //   823: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   826: aload 21
      //   828: invokevirtual 155	com/tencent/liteav/renderer/e$j:a	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   831: iconst_0
      //   832: istore 6
      //   834: iload_3
      //   835: istore 7
      //   837: iload_3
      //   838: ifeq +42 -> 880
      //   841: aload_0
      //   842: getfield 55	com/tencent/liteav/renderer/e$i:t	Ljava/lang/ref/WeakReference;
      //   845: invokevirtual 112	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   848: checkcast 6	com/tencent/liteav/renderer/e
      //   851: astore 23
      //   853: aload 23
      //   855: ifnull +287 -> 1142
      //   858: aload 23
      //   860: invokestatic 158	com/tencent/liteav/renderer/e:b	(Lcom/tencent/liteav/renderer/e;)Landroid/opengl/GLSurfaceView$Renderer;
      //   863: aload 21
      //   865: aload_0
      //   866: getfield 69	com/tencent/liteav/renderer/e$i:s	Lcom/tencent/liteav/renderer/e$h;
      //   869: getfield 161	com/tencent/liteav/renderer/e$h:d	Ljavax/microedition/khronos/egl/EGLConfig;
      //   872: invokeinterface 167 3 0
      //   877: goto +265 -> 1142
      //   880: iload 5
      //   882: istore_3
      //   883: iload 5
      //   885: ifeq +39 -> 924
      //   888: aload_0
      //   889: getfield 55	com/tencent/liteav/renderer/e$i:t	Ljava/lang/ref/WeakReference;
      //   892: invokevirtual 112	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   895: checkcast 6	com/tencent/liteav/renderer/e
      //   898: astore 23
      //   900: aload 23
      //   902: ifnull +246 -> 1148
      //   905: aload 23
      //   907: invokestatic 158	com/tencent/liteav/renderer/e:b	(Lcom/tencent/liteav/renderer/e;)Landroid/opengl/GLSurfaceView$Renderer;
      //   910: aload 21
      //   912: iload 13
      //   914: iload 10
      //   916: invokeinterface 171 4 0
      //   921: goto +227 -> 1148
      //   924: aload_0
      //   925: getfield 55	com/tencent/liteav/renderer/e$i:t	Ljava/lang/ref/WeakReference;
      //   928: invokevirtual 112	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   931: checkcast 6	com/tencent/liteav/renderer/e
      //   934: astore 23
      //   936: aload 23
      //   938: ifnull +197 -> 1135
      //   941: aload 23
      //   943: invokestatic 158	com/tencent/liteav/renderer/e:b	(Lcom/tencent/liteav/renderer/e;)Landroid/opengl/GLSurfaceView$Renderer;
      //   946: aload 21
      //   948: invokeinterface 174 2 0
      //   953: aload 23
      //   955: invokevirtual 177	com/tencent/liteav/renderer/e:c	()I
      //   958: istore_1
      //   959: goto +194 -> 1153
      //   962: ldc 179
      //   964: ldc 181
      //   966: iload_1
      //   967: invokestatic 184	com/tencent/liteav/renderer/e$h:a	(Ljava/lang/String;Ljava/lang/String;I)V
      //   970: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   973: astore 23
      //   975: aload 23
      //   977: monitorenter
      //   978: aload_0
      //   979: iconst_1
      //   980: putfield 126	com/tencent/liteav/renderer/e$i:f	Z
      //   983: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   986: invokevirtual 104	java/lang/Object:notifyAll	()V
      //   989: aload 23
      //   991: monitorexit
      //   992: iload_2
      //   993: istore 11
      //   995: iload 8
      //   997: ifeq +132 -> 1129
      //   1000: iconst_1
      //   1001: istore_1
      //   1002: iload 9
      //   1004: istore 4
      //   1006: iload 13
      //   1008: istore 9
      //   1010: iload_3
      //   1011: istore 5
      //   1013: iload 11
      //   1015: istore_2
      //   1016: iload 7
      //   1018: istore_3
      //   1019: goto -961 -> 58
      //   1022: astore 21
      //   1024: aload 23
      //   1026: monitorexit
      //   1027: aload 21
      //   1029: athrow
      //   1030: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   1033: astore 23
      //   1035: aload 23
      //   1037: monitorenter
      //   1038: aload_0
      //   1039: iconst_1
      //   1040: putfield 147	com/tencent/liteav/renderer/e$i:j	Z
      //   1043: aload_0
      //   1044: iconst_1
      //   1045: putfield 126	com/tencent/liteav/renderer/e$i:f	Z
      //   1048: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   1051: invokevirtual 104	java/lang/Object:notifyAll	()V
      //   1054: aload 23
      //   1056: monitorexit
      //   1057: iload 4
      //   1059: istore_1
      //   1060: iload 7
      //   1062: istore 4
      //   1064: iload 13
      //   1066: istore 9
      //   1068: goto -1010 -> 58
      //   1071: astore 21
      //   1073: aload 23
      //   1075: monitorexit
      //   1076: aload 21
      //   1078: athrow
      //   1079: iconst_1
      //   1080: istore 11
      //   1082: goto -87 -> 995
      //   1085: astore 21
      //   1087: aload 23
      //   1089: monitorexit
      //   1090: aload 21
      //   1092: athrow
      //   1093: astore 22
      //   1095: aload 21
      //   1097: monitorexit
      //   1098: aload 22
      //   1100: athrow
      //   1101: goto -267 -> 834
      //   1104: iload 10
      //   1106: istore 4
      //   1108: iload 8
      //   1110: istore 6
      //   1112: iload 13
      //   1114: istore 8
      //   1116: iload 7
      //   1118: istore 5
      //   1120: goto -536 -> 584
      //   1123: iconst_0
      //   1124: istore 19
      //   1126: goto -917 -> 209
      //   1129: iload 4
      //   1131: istore_1
      //   1132: goto -130 -> 1002
      //   1135: sipush 12288
      //   1138: istore_1
      //   1139: goto +14 -> 1153
      //   1142: iconst_0
      //   1143: istore 7
      //   1145: goto -265 -> 880
      //   1148: iconst_0
      //   1149: istore_3
      //   1150: goto -226 -> 924
      //   1153: iload_2
      //   1154: istore 11
      //   1156: iload_1
      //   1157: lookupswitch	default:+27->1184, 12288:+-162->995, 12302:+-78->1079
      //   1185: impdep2
      //   1186: fload_0
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1187	0	this	i
      //   42	1115	1	i1	int
      //   34	1120	2	i2	int
      //   26	1124	3	i3	int
      //   28	1102	4	i4	int
      //   36	1083	5	i5	int
      //   31	1080	6	i6	int
      //   68	1076	7	i7	int
      //   39	1076	8	i8	int
      //   47	1020	9	i9	int
      //   50	1055	10	i10	int
      //   233	922	11	i11	int
      //   44	687	12	i12	int
      //   137	976	13	i13	int
      //   437	301	14	i14	int
      //   445	308	15	i15	int
      //   448	309	16	i16	int
      //   441	305	17	i17	int
      //   433	301	18	i18	int
      //   193	932	19	bool1	boolean
      //   296	335	20	bool2	boolean
      //   56	47	21	localj1	e.j
      //   680	6	21	localObject1	Object
      //   693	14	21	localj2	e.j
      //   712	10	21	localRuntimeException	java.lang.RuntimeException
      //   821	126	21	localGL10	javax.microedition.khronos.opengles.GL10
      //   1022	6	21	localObject2	Object
      //   1071	6	21	localObject3	Object
      //   1085	11	21	localObject4	Object
      //   53	1	22	localObject5	Object
      //   100	6	22	localObject6	Object
      //   129	34	22	localRunnable	Runnable
      //   688	22	22	localObject7	Object
      //   1093	6	22	localObject8	Object
      //   288	338	24	locale	e
      // Exception table:
      //   from	to	target	type
      //   88	99	100	finally
      //   102	105	100	finally
      //   70	80	680	finally
      //   108	131	680	finally
      //   146	149	680	finally
      //   178	209	680	finally
      //   209	229	680	finally
      //   239	247	680	finally
      //   255	266	680	finally
      //   271	290	680	finally
      //   303	312	680	finally
      //   312	316	680	finally
      //   321	337	680	finally
      //   337	362	680	finally
      //   362	378	680	finally
      //   378	403	680	finally
      //   420	431	680	finally
      //   450	457	680	finally
      //   462	469	680	finally
      //   489	496	680	finally
      //   507	519	680	finally
      //   544	558	680	finally
      //   561	573	680	finally
      //   579	584	680	finally
      //   584	595	680	finally
      //   625	632	680	finally
      //   635	644	680	finally
      //   654	661	680	finally
      //   661	666	680	finally
      //   668	674	680	finally
      //   682	685	680	finally
      //   714	724	680	finally
      //   724	730	680	finally
      //   58	66	688	finally
      //   154	161	688	finally
      //   685	688	688	finally
      //   771	789	688	finally
      //   811	831	688	finally
      //   841	853	688	finally
      //   858	877	688	finally
      //   888	900	688	finally
      //   905	921	688	finally
      //   924	936	688	finally
      //   941	959	688	finally
      //   962	978	688	finally
      //   1027	1030	688	finally
      //   1030	1038	688	finally
      //   1076	1079	688	finally
      //   1090	1093	688	finally
      //   654	661	712	java/lang/RuntimeException
      //   789	803	1022	finally
      //   1024	1027	1022	finally
      //   1038	1057	1071	finally
      //   1073	1076	1071	finally
      //   978	992	1085	finally
      //   1087	1090	1085	finally
      //   698	709	1093	finally
      //   1095	1098	1093	finally
    }
    
    private void j()
    {
      if (this.i)
      {
        this.i = false;
        this.s.f();
      }
    }
    
    private void k()
    {
      if (this.h)
      {
        this.s.g();
        this.h = false;
        e locale = (e)this.t.get();
        if (locale != null) {
          locale.h = false;
        }
        e.e().c(this);
      }
    }
    
    private boolean l()
    {
      return (!this.d) && (this.e) && (!this.f) && (this.l > 0) && (this.m > 0) && ((this.o) || (this.n == 1));
    }
    
    public int a()
    {
      return this.s.c();
    }
    
    public void a(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 1)) {
        throw new IllegalArgumentException("renderMode");
      }
      synchronized (e.e())
      {
        this.n = paramInt;
        e.e().notifyAll();
        return;
      }
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      synchronized ()
      {
        this.l = paramInt1;
        this.m = paramInt2;
        this.r = true;
        this.o = true;
        this.p = false;
        e.e().notifyAll();
        for (;;)
        {
          if ((!this.b) && (!this.d) && (!this.p))
          {
            boolean bool = c();
            if (bool) {
              try
              {
                e.e().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void a(Runnable paramRunnable)
    {
      if (paramRunnable == null) {
        throw new IllegalArgumentException("r must not be null");
      }
      synchronized (e.e())
      {
        this.q.add(paramRunnable);
        e.e().notifyAll();
        return;
      }
    }
    
    public e.h b()
    {
      return this.s;
    }
    
    public boolean c()
    {
      return (this.h) && (this.i) && (l());
    }
    
    public int d()
    {
      synchronized ()
      {
        int i1 = this.n;
        return i1;
      }
    }
    
    public void e()
    {
      synchronized ()
      {
        this.e = true;
        this.j = false;
        e.e().notifyAll();
        for (;;)
        {
          if ((this.g) && (!this.j))
          {
            boolean bool = this.b;
            if (!bool) {
              try
              {
                e.e().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void f()
    {
      synchronized ()
      {
        this.e = false;
        e.e().notifyAll();
        for (;;)
        {
          if (!this.g)
          {
            boolean bool = this.b;
            if (!bool) {
              try
              {
                e.e().wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void g()
    {
      synchronized ()
      {
        this.a = true;
        e.e().notifyAll();
        for (;;)
        {
          boolean bool = this.b;
          if (!bool) {
            try
            {
              e.e().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    
    public void h()
    {
      this.k = true;
      e.e().notifyAll();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: new 218	java/lang/StringBuilder
      //   4: dup
      //   5: ldc 220
      //   7: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   10: aload_0
      //   11: invokevirtual 225	com/tencent/liteav/renderer/e$i:getId	()J
      //   14: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   17: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   20: invokevirtual 236	com/tencent/liteav/renderer/e$i:setName	(Ljava/lang/String;)V
      //   23: aload_0
      //   24: invokespecial 238	com/tencent/liteav/renderer/e$i:i	()V
      //   27: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   30: aload_0
      //   31: invokevirtual 240	com/tencent/liteav/renderer/e$j:a	(Lcom/tencent/liteav/renderer/e$i;)V
      //   34: return
      //   35: astore_1
      //   36: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   39: aload_0
      //   40: invokevirtual 240	com/tencent/liteav/renderer/e$j:a	(Lcom/tencent/liteav/renderer/e$i;)V
      //   43: return
      //   44: astore_1
      //   45: invokestatic 76	com/tencent/liteav/renderer/e:e	()Lcom/tencent/liteav/renderer/e$j;
      //   48: aload_0
      //   49: invokevirtual 240	com/tencent/liteav/renderer/e$j:a	(Lcom/tencent/liteav/renderer/e$i;)V
      //   52: aload_1
      //   53: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	54	0	this	i
      //   35	1	1	localInterruptedException	InterruptedException
      //   44	9	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   23	27	35	java/lang/InterruptedException
      //   23	27	44	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.renderer.e
 * JD-Core Version:    0.7.0.1
 */