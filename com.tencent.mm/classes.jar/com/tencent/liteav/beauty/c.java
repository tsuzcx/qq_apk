package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.d.j.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.b.n;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.beauty.b.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class c
  extends HandlerThread
{
  private int A;
  private int B;
  private int C;
  private int D;
  private Context E;
  private boolean F;
  private d.e G;
  private d.f H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private float O;
  private int P;
  private int Q;
  private int R;
  private boolean S;
  private float[] T;
  private boolean U;
  private int V;
  private int W;
  private com.tencent.liteav.basic.d.a X;
  private Bitmap Y;
  private k Z;
  boolean a;
  private int aA;
  private int aB;
  private int aC;
  private int aD;
  private int aE;
  private boolean aF;
  private com.tencent.liteav.beauty.a.a.c aG;
  private com.tencent.liteav.beauty.a.a.a aH;
  private Bitmap aI;
  private List<d.f> aJ;
  private long aK;
  private int aL;
  private final int aM;
  private final float aN;
  private byte[] aO;
  private int[] aP;
  private boolean aQ;
  private byte[] aR;
  private int aS;
  private int aT;
  private int aU;
  private int aV;
  private e aW;
  private WeakReference<com.tencent.liteav.basic.c.a> aX;
  private j.a aY;
  private o aa;
  private b ab;
  private com.tencent.liteav.beauty.b.a.a ac;
  private com.tencent.liteav.beauty.b.b.a ad;
  private com.tencent.liteav.beauty.b.c ae;
  private Bitmap af;
  private Bitmap ag;
  private float ah;
  private float ai;
  private float aj;
  private m ak;
  private n al;
  private x am;
  private com.tencent.liteav.beauty.b.j an;
  private com.tencent.liteav.beauty.b.i ao;
  private h ap;
  private l aq;
  private com.tencent.liteav.basic.d.i ar;
  private h as;
  private final Queue<Runnable> at;
  private boolean au;
  private Object av;
  private Object aw;
  private Handler ax;
  private a ay;
  private float az;
  protected int[] b;
  protected int[] c;
  com.tencent.liteav.beauty.b.a d;
  com.tencent.liteav.beauty.b.a e;
  com.tencent.liteav.beauty.b.a f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  c(Context paramContext, boolean paramBoolean)
  {
    super("TXCFilterDrawer");
    AppMethodBeat.i(15215);
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.o = 0;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.u = 0;
    this.v = 0;
    this.w = 0;
    this.x = 0;
    this.y = 0;
    this.z = 0;
    this.A = 0;
    this.B = 0;
    this.C = 0;
    this.D = 0;
    this.E = null;
    this.F = true;
    this.G = new d.e();
    this.H = null;
    this.I = -1;
    this.J = -1;
    this.K = -1;
    this.L = -1;
    this.M = -1;
    this.N = -1;
    this.O = 1.0F;
    this.P = -1;
    this.Q = -1;
    this.R = 1;
    this.S = false;
    this.T = null;
    this.U = false;
    this.V = 0;
    this.W = 0;
    this.X = null;
    this.Y = null;
    this.Z = null;
    this.aa = null;
    this.ab = null;
    this.ac = null;
    this.ad = null;
    this.ae = null;
    this.al = null;
    this.am = null;
    this.an = null;
    this.ao = null;
    this.ap = null;
    this.aq = null;
    this.ar = null;
    this.as = null;
    this.at = new LinkedList();
    this.a = false;
    this.av = new Object();
    this.aw = new Object();
    this.az = 0.5F;
    this.aA = 0;
    this.aB = 0;
    this.aC = 0;
    this.aD = 0;
    this.aE = 0;
    this.aF = false;
    this.aG = null;
    this.aH = null;
    this.aI = null;
    this.aJ = null;
    this.aK = 0L;
    this.aL = 0;
    this.aM = 100;
    this.aN = 1000.0F;
    this.aO = null;
    this.aP = null;
    this.aQ = false;
    this.aR = null;
    this.b = null;
    this.c = null;
    this.aS = -1;
    this.aT = 0;
    this.aU = 1;
    this.aV = this.aS;
    this.aW = null;
    this.aX = new WeakReference(null);
    this.d = new com.tencent.liteav.beauty.b.a();
    this.e = new com.tencent.liteav.beauty.b.a();
    this.f = new com.tencent.liteav.beauty.b.a();
    this.aY = new j.a() {};
    this.E = paramContext;
    this.ax = new Handler(this.E.getMainLooper());
    this.au = paramBoolean;
    AppMethodBeat.o(15215);
  }
  
  private int A(int paramInt)
  {
    AppMethodBeat.i(187172);
    GLES20.glViewport(0, 0, this.I, this.J);
    paramInt = a(this.Z.q(), paramInt, 0L);
    AppMethodBeat.o(187172);
    return paramInt;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187170);
    if (true == this.au) {
      if (this.aW != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aO);
        this.aW.a(this.aO, this.P, this.Q, this.W, TXCTimeUtil.generatePtsMS());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(187170);
      return 0;
      if (this.aR != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aR);
        continue;
        if (3 == com.tencent.liteav.basic.d.j.a())
        {
          if (0L == this.aK) {
            this.aK = TXCTimeUtil.getTimeTick();
          }
          int i1 = this.aL + 1;
          this.aL = i1;
          if (i1 >= 100)
          {
            TXCLog.i("TXCFilterDrawer", "Real fps ".concat(String.valueOf(100.0F / ((float)(TXCTimeUtil.getTimeTick() - this.aK) / 1000.0F))));
            this.aL = 0;
            this.aK = TXCTimeUtil.getTimeTick();
          }
          GLES30.glPixelStorei(3333, 1);
          if (Build.VERSION.SDK_INT >= 18) {
            GLES30.glReadBuffer(1029);
          }
          GLES30.glBindBuffer(35051, this.aP[0]);
          NativeLoad.getInstance();
          NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, null);
          Object localObject = null;
          if (Build.VERSION.SDK_INT >= 18)
          {
            ByteBuffer localByteBuffer = (ByteBuffer)GLES30.glMapBufferRange(35051, 0, paramInt1 * paramInt2 * 4, 1);
            localObject = localByteBuffer;
            if (localByteBuffer == null)
            {
              TXCLog.e("TXCFilterDrawer", "glMapBufferRange is null");
              AppMethodBeat.o(187170);
              return -1;
            }
          }
          NativeLoad.getInstance();
          NativeLoad.nativeGlMapBufferToQueue(paramInt1, paramInt2, localObject);
          if (Build.VERSION.SDK_INT >= 18) {
            GLES30.glUnmapBuffer(35051);
          }
          GLES30.glBindBuffer(35051, 0);
        }
        else
        {
          NativeLoad.getInstance();
          NativeLoad.nativeGlReadPixsToQueue(paramInt1, paramInt2);
        }
      }
    }
  }
  
  private int a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187169);
    if (this.W == 0) {
      if (this.aW != null)
      {
        if (paramLong != 0L) {
          break label211;
        }
        paramLong = TXCTimeUtil.generatePtsMS();
      }
    }
    label211:
    for (;;)
    {
      this.aW.a(paramInt, this.P, this.Q, paramLong);
      AppMethodBeat.o(187169);
      return paramInt;
      if ((1 == this.W) || (3 == this.W) || (2 == this.W))
      {
        GLES20.glViewport(0, 0, this.P, this.Q);
        if (this.aa == null)
        {
          TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
          AppMethodBeat.o(187169);
          return paramInt;
        }
        GLES20.glBindFramebuffer(36160, this.b[0]);
        this.aa.a(paramInt);
        if (2 == this.W) {
          a(this.P, this.Q);
        }
        for (;;)
        {
          GLES20.glBindFramebuffer(36160, 0);
          AppMethodBeat.o(187169);
          return paramInt;
          a(this.P, this.Q * 3 / 8);
        }
      }
      TXCLog.e("TXCFilterDrawer", "Don't support format!");
      AppMethodBeat.o(187169);
      return -1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    AppMethodBeat.i(187181);
    if (this.ak == null)
    {
      TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
      this.ak = new m(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
      if (true == this.ak.a())
      {
        this.ak.a(true);
        this.ak.a(paramInt1, paramInt2);
        AppMethodBeat.o(187181);
        return;
      }
      TXCLog.e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
    }
    AppMethodBeat.o(187181);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187180);
    TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
    if (paramInt3 == 0)
    {
      if (this.ac == null) {
        this.ac = new com.tencent.liteav.beauty.b.a.a();
      }
      this.ab = this.ac;
    }
    while (this.ab == null)
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
      AppMethodBeat.o(187180);
      return;
      if (1 == paramInt3)
      {
        if (this.ad == null) {
          this.ad = new com.tencent.liteav.beauty.b.b.a();
        }
        this.ab = this.ad;
      }
      else if (2 == paramInt3)
      {
        if (this.ae == null) {
          this.ae = new com.tencent.liteav.beauty.b.c();
        }
        this.ab = this.ae;
      }
    }
    this.ab.a(true);
    if (true == this.ab.c(paramInt1, paramInt2))
    {
      if (this.aB > 0) {
        this.ab.c(this.aB);
      }
      if (this.aC > 0) {
        this.ab.d(this.aC);
      }
      if (this.aE > 0) {
        this.ab.e(this.aE);
      }
      if (this.aD > 0)
      {
        this.ab.f(this.aD);
        AppMethodBeat.o(187180);
      }
    }
    else
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
    }
    AppMethodBeat.o(187180);
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc_w 596
    //   3: invokestatic 183	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 320	com/tencent/liteav/beauty/c:aw	Ljava/lang/Object;
    //   10: astore 6
    //   12: aload 6
    //   14: monitorenter
    //   15: iload 5
    //   17: sipush 360
    //   20: iadd
    //   21: sipush 360
    //   24: irem
    //   25: istore 5
    //   27: ldc 175
    //   29: ldc_w 598
    //   32: iload 5
    //   34: invokestatic 601	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   37: invokevirtual 473	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 478	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 300	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/d/h;
    //   47: ifnonnull +67 -> 114
    //   50: iload_1
    //   51: iload_3
    //   52: if_icmpne +32 -> 84
    //   55: iload_2
    //   56: iload 4
    //   58: if_icmpne +26 -> 84
    //   61: iload 5
    //   63: ifne +21 -> 84
    //   66: ldc 175
    //   68: ldc_w 603
    //   71: invokestatic 478	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 6
    //   76: monitorexit
    //   77: ldc_w 596
    //   80: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: aload_0
    //   85: new 605	com/tencent/liteav/basic/d/h
    //   88: dup
    //   89: invokespecial 606	com/tencent/liteav/basic/d/h:<init>	()V
    //   92: putfield 300	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/d/h;
    //   95: iconst_1
    //   96: aload_0
    //   97: getfield 300	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/d/h;
    //   100: invokevirtual 607	com/tencent/liteav/basic/d/h:a	()Z
    //   103: if_icmpne +49 -> 152
    //   106: aload_0
    //   107: getfield 300	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/d/h;
    //   110: iconst_1
    //   111: invokevirtual 608	com/tencent/liteav/basic/d/h:a	(Z)V
    //   114: aload_0
    //   115: getfield 300	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/d/h;
    //   118: iload_3
    //   119: iload 4
    //   121: invokevirtual 609	com/tencent/liteav/basic/d/h:a	(II)V
    //   124: aload_0
    //   125: getfield 300	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/d/h;
    //   128: sipush 720
    //   131: iload 5
    //   133: isub
    //   134: sipush 360
    //   137: irem
    //   138: aconst_null
    //   139: invokevirtual 612	com/tencent/liteav/basic/d/h:a	(ILjava/nio/FloatBuffer;)V
    //   142: aload 6
    //   144: monitorexit
    //   145: ldc_w 596
    //   148: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: ldc 175
    //   154: ldc_w 614
    //   157: invokestatic 506	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -46 -> 114
    //   163: astore 7
    //   165: aload 6
    //   167: monitorexit
    //   168: ldc_w 596
    //   171: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload 7
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	c
    //   0	177	1	paramInt1	int
    //   0	177	2	paramInt2	int
    //   0	177	3	paramInt3	int
    //   0	177	4	paramInt4	int
    //   0	177	5	paramInt5	int
    //   10	156	6	localObject1	Object
    //   163	12	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	50	163	finally
    //   66	77	163	finally
    //   84	114	163	finally
    //   114	145	163	finally
    //   152	160	163	finally
    //   165	168	163	finally
  }
  
  private void a(com.tencent.liteav.basic.d.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(187167);
    if (this.aq == null)
    {
      TXCLog.i("TXCFilterDrawer", "Create CropFilter");
      if (4 == paramInt6)
      {
        this.aq = new l("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
        if (true != this.aq.a()) {
          break label188;
        }
        this.aq.a(true);
      }
    }
    else
    {
      label64:
      this.aq.a(paramInt3, paramInt4);
      parama = this.aq.a(this.I, this.J, null, parama, paramInt6);
      paramInt6 = (720 - paramInt5) % 360;
      if ((paramInt6 != 90) && (paramInt6 != 270)) {
        break label199;
      }
    }
    label188:
    label199:
    for (paramInt5 = paramInt4;; paramInt5 = paramInt3)
    {
      if ((paramInt6 == 90) || (paramInt6 == 270)) {
        paramInt4 = paramInt3;
      }
      this.aq.a(paramInt1, paramInt2, paramInt6, parama, paramInt5 / paramInt4, paramBoolean, false);
      AppMethodBeat.o(187167);
      return;
      this.aq = new l();
      break;
      TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
      break label64;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(187183);
    synchronized (this.at)
    {
      this.at.add(paramRunnable);
      AppMethodBeat.o(187183);
      return;
    }
  }
  
  private void a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(187184);
    for (;;)
    {
      Runnable localRunnable = null;
      try
      {
        if (!paramQueue.isEmpty()) {
          localRunnable = (Runnable)paramQueue.poll();
        }
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      finally
      {
        AppMethodBeat.o(187184);
      }
    }
    AppMethodBeat.o(187184);
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(187171);
    if (!paramBoolean)
    {
      if (this.aW != null)
      {
        this.aW.a(paramArrayOfByte, this.P, this.Q, this.W, TXCTimeUtil.generatePtsMS());
        AppMethodBeat.o(187171);
        return;
      }
      TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
      AppMethodBeat.o(187171);
      return;
    }
    int i1 = this.Q * 3 / 8;
    if (2 == this.W) {
      i1 = this.Q;
    }
    if (this.aW != null)
    {
      NativeLoad.getInstance();
      if (true == NativeLoad.nativeGlReadPixsFromQueue(this.P, i1, this.aO))
      {
        this.aW.a(this.aO, this.P, this.Q, this.W, TXCTimeUtil.generatePtsMS());
        AppMethodBeat.o(187171);
        return;
      }
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
      this.aW.a(paramArrayOfByte, this.P, this.Q, this.W, TXCTimeUtil.generatePtsMS());
      AppMethodBeat.o(187171);
      return;
    }
    NativeLoad.getInstance();
    if (!NativeLoad.nativeGlReadPixsFromQueue(this.P, i1, this.aR)) {
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
    }
    AppMethodBeat.o(187171);
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187177);
    GLES20.glGenFramebuffers(1, paramArrayOfInt1, 0);
    paramArrayOfInt2[0] = com.tencent.liteav.basic.d.j.a(paramInt1, paramInt2, 6408, 6408, paramArrayOfInt2);
    GLES20.glBindFramebuffer(36160, paramArrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramArrayOfInt2[0], 0);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(187177);
  }
  
  private void b()
  {
    AppMethodBeat.i(15227);
    TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
    this.aQ = false;
    if (this.Z != null)
    {
      this.Z.d();
      this.Z = null;
    }
    if (this.aa != null)
    {
      this.aa.d();
      this.aa = null;
    }
    c();
    if (this.ak != null)
    {
      this.ak.d();
      this.ak = null;
    }
    if (this.al != null)
    {
      this.al.a();
      this.al = null;
    }
    if (this.ar != null)
    {
      this.ar.d();
      this.ar = null;
    }
    if (this.aq != null)
    {
      this.aq.d();
      this.aq = null;
    }
    if (this.ap != null)
    {
      this.ap.d();
      this.ap = null;
    }
    if (this.am != null)
    {
      this.am.d();
      this.am = null;
    }
    if (this.an != null)
    {
      this.an.a();
      this.an = null;
    }
    if (this.ao != null)
    {
      this.ao.d();
      this.ao = null;
    }
    if (this.as != null)
    {
      this.as.d();
      this.as = null;
    }
    if (this.b != null)
    {
      GLES20.glDeleteFramebuffers(1, this.b, 0);
      this.b = null;
    }
    if (this.c != null)
    {
      GLES20.glDeleteTextures(1, this.c, 0);
      this.c = null;
    }
    TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
    AppMethodBeat.o(15227);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187182);
    if (this.as == null)
    {
      TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
      this.as = new h();
      if (true != this.as.a()) {
        break label74;
      }
      this.as.a(true);
    }
    for (;;)
    {
      if (this.as != null) {
        this.as.a(paramInt1, paramInt2);
      }
      AppMethodBeat.o(187182);
      return;
      label74:
      TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187173);
    if (this.Z == null)
    {
      TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
      AppMethodBeat.o(187173);
      return;
    }
    this.Z.a(paramArrayOfByte);
    AppMethodBeat.o(187173);
  }
  
  private void c()
  {
    AppMethodBeat.i(15214);
    if (this.ac != null)
    {
      this.ac.d();
      this.ac = null;
    }
    if (this.ad != null)
    {
      this.ad.d();
      this.ad = null;
    }
    if (this.ae != null)
    {
      this.ae.d();
      this.ae = null;
    }
    this.ab = null;
    AppMethodBeat.o(15214);
  }
  
  private boolean c(d.b paramb)
  {
    AppMethodBeat.i(187175);
    TXCLog.i("TXCFilterDrawer", "come into initInternal");
    b();
    this.au = paramb.j;
    this.I = paramb.d;
    this.J = paramb.e;
    this.X = paramb.m;
    int i2 = paramb.g;
    int i3 = paramb.f;
    int i4 = paramb.h;
    this.S = paramb.i;
    this.P = paramb.b;
    this.Q = paramb.c;
    int i5 = paramb.a;
    this.K = paramb.g;
    this.L = paramb.f;
    if ((i4 == 90) || (i4 == 270))
    {
      this.K = paramb.f;
      this.L = paramb.g;
    }
    this.W = paramb.l;
    this.V = paramb.k;
    this.aO = new byte[this.P * this.Q * 4];
    TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is %f, process size: %d x %d", new Object[] { Float.valueOf(this.O), Integer.valueOf(this.K), Integer.valueOf(this.L) });
    int i1;
    if (this.O != 1.0F)
    {
      if (this.K >= this.L) {
        break label593;
      }
      i1 = this.K;
      if (i1 > 368) {
        this.O = (432.0F / i1);
      }
      if (this.O > 1.0F) {
        this.O = 1.0F;
      }
    }
    this.M = ((int)(this.K * this.O));
    this.N = ((int)(this.L * this.O));
    a(this.M, this.N, this.aA);
    if ((this.H != null) && (this.H.a != null) && (this.am == null))
    {
      TXCLog.i("TXCFilterDrawer", "reset water mark!");
      a(this.H.a, this.H.b, this.H.c, this.H.d);
    }
    if (((this.af != null) || (this.ag != null)) && (this.ak == null)) {
      a(this.M, this.N, this.ah, this.af, this.ai, this.ag, this.aj);
    }
    a(this.X, i2, i3, this.M, this.N, this.S, i4, this.V);
    a(this.K, this.L, this.P, this.Q, i5);
    if (this.b == null)
    {
      this.b = new int[1];
      label503:
      if (this.c != null) {
        break label613;
      }
      this.c = new int[1];
      label517:
      a(this.b, this.c, this.P, this.Q);
      if (3 == com.tencent.liteav.basic.d.j.a())
      {
        if (this.aP != null) {
          break label625;
        }
        this.aP = new int[1];
      }
    }
    for (;;)
    {
      TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
      com.tencent.liteav.basic.d.j.a(i2, i3, this.aP);
      TXCLog.i("TXCFilterDrawer", "come out initInternal");
      AppMethodBeat.o(187175);
      return true;
      label593:
      i1 = this.L;
      break;
      GLES20.glDeleteFramebuffers(1, this.b, 0);
      break label503;
      label613:
      GLES20.glDeleteTextures(1, this.c, 0);
      break label517;
      label625:
      TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
      GLES30.glDeleteBuffers(1, this.aP, 0);
    }
  }
  
  private boolean d(d.b paramb)
  {
    AppMethodBeat.i(187178);
    if (((1 == paramb.k) || (3 == paramb.k) || (2 == paramb.k)) && (this.Z == null))
    {
      this.Z = new k(paramb.k);
      this.Z.a(true);
      if (!this.Z.a())
      {
        TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
        AppMethodBeat.o(187178);
        return false;
      }
      this.Z.a(paramb.d, paramb.e);
    }
    if (((1 == paramb.l) || (3 == paramb.l) || (2 == paramb.l)) && (this.aa == null))
    {
      this.aa = new o(paramb.l);
      if (!this.aa.a())
      {
        TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
        AppMethodBeat.o(187178);
        return false;
      }
      this.aa.a(paramb.b, paramb.c);
    }
    AppMethodBeat.o(187178);
    return true;
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(187165);
    a(this.at);
    int i1;
    if (this.O != 1.0F)
    {
      i1 = 1;
      GLES20.glViewport(0, 0, this.M, this.N);
      int i2 = paramInt1;
      if (this.aq != null)
      {
        if ((4 == paramInt2) || (true == this.U))
        {
          this.aq.a(this.T);
          this.aq.c(this.U);
        }
        i2 = this.aq.b(paramInt1);
      }
      paramInt1 = i2;
      if (this.ab != null)
      {
        if (Math.min(this.P, this.Q) >= 540) {
          break label408;
        }
        paramInt2 = 0;
        label123:
        this.ab.f(paramInt2);
        if ((this.aB <= 0) && (this.aC <= 0) && (this.aE <= 0))
        {
          paramInt1 = i2;
          if (paramInt2 <= 0) {}
        }
        else
        {
          paramInt1 = this.ab.b(i2);
        }
      }
      paramInt2 = paramInt1;
      if (this.ak != null) {
        paramInt2 = this.ak.b(paramInt1);
      }
      GLES20.glViewport(0, 0, this.K, this.L);
      paramInt1 = paramInt2;
      if (this.an != null)
      {
        paramInt1 = this.an.a(paramInt2);
        i1 = 0;
      }
      if (this.ao == null) {
        break label421;
      }
      paramInt1 = this.ao.b(paramInt1);
      i1 = 0;
    }
    label408:
    label421:
    for (;;)
    {
      if (i1 != 0)
      {
        b(this.K, this.L);
        if (this.as != null) {
          GLES20.glViewport(0, 0, this.K, this.L);
        }
      }
      for (paramInt2 = this.as.b(paramInt1);; paramInt2 = paramInt1)
      {
        paramInt1 = paramInt2;
        if (this.aW != null)
        {
          i1 = this.aW.a(paramInt2, this.K, this.L);
          paramInt1 = paramInt2;
          if (i1 > 0) {
            paramInt1 = i1;
          }
        }
        GLES20.glViewport(0, 0, this.K, this.L);
        paramInt2 = paramInt1;
        if (this.am != null) {
          paramInt2 = this.am.b(paramInt1);
        }
        paramInt1 = paramInt2;
        if (this.ap != null)
        {
          GLES20.glViewport(0, 0, this.P, this.Q);
          paramInt1 = this.ap.b(paramInt2);
        }
        a(paramInt1, paramLong);
        AppMethodBeat.o(187165);
        return paramInt1;
        i1 = 0;
        break;
        paramInt2 = this.aD;
        break label123;
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(187166);
    a(paramArrayOfByte);
    if (!this.au)
    {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
      this.ay.obtainMessage(2, paramArrayOfByte).sendToTarget();
      if (!this.aQ)
      {
        TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
        NativeLoad.getInstance();
        NativeLoad.nativeClearQueue();
      }
      this.ay.obtainMessage(3, paramInt, 0).sendToTarget();
      a(paramArrayOfByte, this.aQ);
      this.aQ = true;
    }
    for (paramInt = -1;; paramInt = A(paramInt))
    {
      AppMethodBeat.o(187166);
      return paramInt;
      b(paramArrayOfByte);
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(187174);
    if (!this.au)
    {
      if (this.ay == null) {
        break label57;
      }
      this.ay.obtainMessage(1).sendToTarget();
      try
      {
        this.d.b();
        AppMethodBeat.o(187174);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        AppMethodBeat.o(187174);
        return;
      }
    }
    b();
    label57:
    AppMethodBeat.o(187174);
  }
  
  public void a(final float paramFloat)
  {
    AppMethodBeat.i(15255);
    this.az = paramFloat;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187066);
        if (c.a(c.this) != null) {
          c.a(c.this).a(paramFloat);
        }
        AppMethodBeat.o(187066);
      }
    });
    AppMethodBeat.o(15255);
  }
  
  public void a(final float paramFloat1, final Bitmap paramBitmap1, final float paramFloat2, final Bitmap paramBitmap2, final float paramFloat3)
  {
    AppMethodBeat.i(187179);
    if ((this.af != paramBitmap1) || (this.ag != paramBitmap2))
    {
      this.af = paramBitmap1;
      this.ag = paramBitmap2;
      this.ah = paramFloat1;
      this.ai = paramFloat2;
      this.aj = paramFloat3;
      a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(187193);
          if (c.a(c.this) != null) {
            a.a().e();
          }
          if ((c.h(c.this) == null) && (c.i(c.this) == null))
          {
            if (c.a(c.this) != null)
            {
              c.a(c.this).d();
              c.a(c.this, null);
              AppMethodBeat.o(187193);
            }
          }
          else
          {
            if (c.a(c.this) == null)
            {
              c.a(c.this, c.f(c.this), c.g(c.this), c.j(c.this), c.h(c.this), c.k(c.this), c.i(c.this), c.l(c.this));
              AppMethodBeat.o(187193);
              return;
            }
            c.a(c.this).a(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
          }
          AppMethodBeat.o(187193);
        }
      });
      AppMethodBeat.o(187179);
      return;
    }
    if ((this.ak != null) && ((this.ah != paramFloat1) || (this.ai != paramFloat2) || (this.aj != paramFloat3)))
    {
      this.ah = paramFloat1;
      this.ai = paramFloat2;
      this.aj = paramFloat3;
      a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(187067);
          c.a(c.this).a(paramFloat1, paramFloat2, paramFloat3);
          AppMethodBeat.o(187067);
        }
      });
    }
    AppMethodBeat.o(187179);
  }
  
  public void a(int paramInt) {}
  
  public void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(15256);
    a(1.0F, paramBitmap, this.az, null, 0.0F);
    AppMethodBeat.o(15256);
  }
  
  public void a(final Bitmap paramBitmap, final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    AppMethodBeat.i(15221);
    if (this.H == null) {
      this.H = new d.f();
    }
    if ((this.H.a != null) && (paramBitmap != null) && (true == this.H.a.equals(paramBitmap)) && (paramFloat1 == this.H.b) && (paramFloat2 == this.H.c) && (paramFloat3 == this.H.d) && (this.am != null))
    {
      AppMethodBeat.o(15221);
      return;
    }
    this.H.a = paramBitmap;
    this.H.b = paramFloat1;
    this.H.c = paramFloat2;
    this.H.d = paramFloat3;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187192);
        if (paramBitmap != null) {
          a.a().g();
        }
        if (paramBitmap == null)
        {
          if (c.b(c.this) != null)
          {
            c.b(c.this).d();
            c.a(c.this, null);
          }
          AppMethodBeat.o(187192);
          return;
        }
        if (c.b(c.this) == null)
        {
          if ((c.c(c.this) <= 0) || (c.d(c.this) <= 0))
          {
            TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
            AppMethodBeat.o(187192);
            return;
          }
          c.a(c.this, new x());
          c.b(c.this).a(true);
          if (!c.b(c.this).a())
          {
            TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
            c.b(c.this).d();
            c.a(c.this, null);
            AppMethodBeat.o(187192);
            return;
          }
          c.b(c.this).a(c.c(c.this), c.d(c.this));
        }
        c.b(c.this).c(true);
        c.b(c.this).a(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
        AppMethodBeat.o(187192);
      }
    });
    AppMethodBeat.o(15221);
  }
  
  void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(15223);
    TXCLog.i("TXCFilterDrawer", "set notify");
    this.aX = new WeakReference(parama);
    if (this.an != null) {
      this.an.a((com.tencent.liteav.basic.c.a)this.aX.get());
    }
    AppMethodBeat.o(15223);
  }
  
  void a(e parame)
  {
    AppMethodBeat.i(15222);
    TXCLog.i("TXCFilterDrawer", "set listener");
    this.aW = parame;
    AppMethodBeat.o(15222);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(15233);
    AppMethodBeat.o(15233);
  }
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(final boolean paramBoolean)
  {
    AppMethodBeat.i(15217);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187071);
        c.a(c.this, paramBoolean);
        AppMethodBeat.o(187071);
      }
    });
    AppMethodBeat.o(15217);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aR = paramArrayOfByte;
  }
  
  public void a(final float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(15216);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187194);
        c.a(c.this, paramArrayOfFloat);
        AppMethodBeat.o(187194);
      }
    });
    AppMethodBeat.o(15216);
  }
  
  /* Error */
  public boolean a(d.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 979
    //   5: invokestatic 183	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iconst_1
    //   9: istore_2
    //   10: aload_1
    //   11: getfield 773	com/tencent/liteav/beauty/d$b:j	Z
    //   14: ifne +63 -> 77
    //   17: aload_0
    //   18: getfield 909	com/tencent/liteav/beauty/c:ay	Lcom/tencent/liteav/beauty/c$a;
    //   21: ifnonnull +27 -> 48
    //   24: aload_0
    //   25: invokevirtual 982	com/tencent/liteav/beauty/c:start	()V
    //   28: aload_0
    //   29: new 32	com/tencent/liteav/beauty/c$a
    //   32: dup
    //   33: aload_0
    //   34: aload_0
    //   35: invokevirtual 985	com/tencent/liteav/beauty/c:getLooper	()Landroid/os/Looper;
    //   38: aload_0
    //   39: getfield 233	com/tencent/liteav/beauty/c:E	Landroid/content/Context;
    //   42: invokespecial 988	com/tencent/liteav/beauty/c$a:<init>	(Lcom/tencent/liteav/beauty/c;Landroid/os/Looper;Landroid/content/Context;)V
    //   45: putfield 909	com/tencent/liteav/beauty/c:ay	Lcom/tencent/liteav/beauty/c$a;
    //   48: aload_0
    //   49: getfield 909	com/tencent/liteav/beauty/c:ay	Lcom/tencent/liteav/beauty/c$a;
    //   52: iconst_0
    //   53: aload_1
    //   54: invokevirtual 913	com/tencent/liteav/beauty/c$a:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   57: invokevirtual 918	android/os/Message:sendToTarget	()V
    //   60: aload_0
    //   61: getfield 909	com/tencent/liteav/beauty/c:ay	Lcom/tencent/liteav/beauty/c$a;
    //   64: invokevirtual 989	com/tencent/liteav/beauty/c$a:b	()V
    //   67: ldc_w 979
    //   70: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_2
    //   76: ireturn
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial 706	com/tencent/liteav/beauty/c:c	(Lcom/tencent/liteav/beauty/d$b;)Z
    //   82: istore_2
    //   83: goto -16 -> 67
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	c
    //   0	91	1	paramb	d.b
    //   9	74	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	86	finally
    //   10	48	86	finally
    //   48	67	86	finally
    //   67	73	86	finally
    //   77	83	86	finally
  }
  
  public void b(final int paramInt)
  {
    AppMethodBeat.i(15226);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187163);
        c.a(c.this, paramInt);
        AppMethodBeat.o(187163);
      }
    });
    AppMethodBeat.o(15226);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b(d.b paramb)
  {
    AppMethodBeat.i(187176);
    if (!this.au)
    {
      if (this.ay == null)
      {
        TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
        AppMethodBeat.o(187176);
        return false;
      }
      this.ay.obtainMessage(5, 0, 0, paramb).sendToTarget();
    }
    for (;;)
    {
      AppMethodBeat.o(187176);
      return true;
      d(paramb);
    }
  }
  
  public void c(final int paramInt)
  {
    AppMethodBeat.i(15228);
    this.aB = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187112);
        if (paramInt > 0) {
          a.a().b();
        }
        if ((c.e(c.this) != null) && (paramInt >= 0)) {
          c.e(c.this).c(paramInt);
        }
        AppMethodBeat.o(187112);
      }
    });
    AppMethodBeat.o(15228);
  }
  
  public void d(final int paramInt)
  {
    AppMethodBeat.i(15229);
    if ((this.aA == paramInt) || (paramInt > 2) || (paramInt < 0))
    {
      AppMethodBeat.o(15229);
      return;
    }
    this.aA = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187111);
        c.a(c.this, c.f(c.this), c.g(c.this), paramInt);
        AppMethodBeat.o(187111);
      }
    });
    AppMethodBeat.o(15229);
  }
  
  public void e(final int paramInt)
  {
    AppMethodBeat.i(15230);
    this.aC = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187113);
        if (paramInt > 0) {
          a.a().c();
        }
        if ((c.e(c.this) != null) && (paramInt >= 0)) {
          c.e(c.this).d(paramInt);
        }
        AppMethodBeat.o(187113);
      }
    });
    AppMethodBeat.o(15230);
  }
  
  public void f(final int paramInt)
  {
    AppMethodBeat.i(15231);
    this.aD = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187195);
        if (paramInt > 0) {
          a.a().f();
        }
        if ((c.e(c.this) != null) && (paramInt >= 0)) {
          c.e(c.this).f(paramInt);
        }
        AppMethodBeat.o(187195);
      }
    });
    AppMethodBeat.o(15231);
  }
  
  public void g(final int paramInt)
  {
    AppMethodBeat.i(15232);
    this.aE = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187107);
        if (paramInt > 0) {
          a.a().d();
        }
        if ((c.e(c.this) != null) && (paramInt >= 0)) {
          c.e(c.this).e(paramInt);
        }
        AppMethodBeat.o(187107);
      }
    });
    AppMethodBeat.o(15232);
  }
  
  public void h(int paramInt)
  {
    AppMethodBeat.i(15236);
    AppMethodBeat.o(15236);
  }
  
  public void i(int paramInt)
  {
    AppMethodBeat.i(15237);
    AppMethodBeat.o(15237);
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(15238);
    AppMethodBeat.o(15238);
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(15239);
    AppMethodBeat.o(15239);
  }
  
  public void l(int paramInt)
  {
    AppMethodBeat.i(15240);
    AppMethodBeat.o(15240);
  }
  
  public void m(int paramInt)
  {
    AppMethodBeat.i(15241);
    AppMethodBeat.o(15241);
  }
  
  public void n(int paramInt)
  {
    AppMethodBeat.i(15242);
    AppMethodBeat.o(15242);
  }
  
  public void o(int paramInt)
  {
    AppMethodBeat.i(15243);
    AppMethodBeat.o(15243);
  }
  
  public void p(int paramInt)
  {
    AppMethodBeat.i(15244);
    AppMethodBeat.o(15244);
  }
  
  public void q(int paramInt)
  {
    AppMethodBeat.i(15245);
    AppMethodBeat.o(15245);
  }
  
  public void r(int paramInt)
  {
    AppMethodBeat.i(15246);
    AppMethodBeat.o(15246);
  }
  
  public void s(int paramInt)
  {
    AppMethodBeat.i(15247);
    AppMethodBeat.o(15247);
  }
  
  public void t(int paramInt)
  {
    AppMethodBeat.i(15248);
    AppMethodBeat.o(15248);
  }
  
  public void u(int paramInt)
  {
    AppMethodBeat.i(15249);
    AppMethodBeat.o(15249);
  }
  
  public void v(int paramInt)
  {
    AppMethodBeat.i(15250);
    AppMethodBeat.o(15250);
  }
  
  public void w(int paramInt)
  {
    AppMethodBeat.i(15251);
    AppMethodBeat.o(15251);
  }
  
  public void x(int paramInt)
  {
    AppMethodBeat.i(15252);
    AppMethodBeat.o(15252);
  }
  
  public void y(int paramInt)
  {
    AppMethodBeat.i(15253);
    AppMethodBeat.o(15253);
  }
  
  public void z(int paramInt)
  {
    AppMethodBeat.i(15254);
    AppMethodBeat.o(15254);
  }
  
  class a
    extends Handler
  {
    private String b = "EGLDrawThreadHandler";
    
    a(Looper paramLooper, Context paramContext)
    {
      super();
    }
    
    private void a(Object paramObject)
    {
      AppMethodBeat.i(187062);
      TXCLog.i(this.b, "come into InitEGL");
      paramObject = (d.b)paramObject;
      a();
      c.a(c.this, new com.tencent.liteav.beauty.a.a.a());
      c.a(c.this, new com.tencent.liteav.beauty.a.a.c(c.m(c.this), paramObject.g, paramObject.f, false));
      c.n(c.this).b();
      if (!c.a(c.this, paramObject))
      {
        TXCLog.e(this.b, "initInternal failed!");
        AppMethodBeat.o(187062);
        return;
      }
      TXCLog.i(this.b, "come out InitEGL");
      AppMethodBeat.o(187062);
    }
    
    public void a()
    {
      AppMethodBeat.i(187063);
      TXCLog.i(this.b, "come into releaseEGL");
      if ((c.o(c.this) != null) && (c.o(c.this)[0] > 0))
      {
        GLES20.glDeleteBuffers(1, c.o(c.this), 0);
        c.a(c.this, null);
      }
      c.p(c.this);
      if (c.n(c.this) != null)
      {
        c.n(c.this).c();
        c.a(c.this, null);
      }
      if (c.m(c.this) != null)
      {
        c.m(c.this).a();
        c.a(c.this, null);
      }
      c.b(c.this, false);
      NativeLoad.getInstance();
      NativeLoad.nativeDeleteYuv2Yuv();
      TXCLog.i(this.b, "come out releaseEGL");
      AppMethodBeat.o(187063);
    }
    
    /* Error */
    void b()
    {
      // Byte code:
      //   0: ldc 127
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_0
      //   8: invokevirtual 132	java/lang/Object:wait	()V
      //   11: aload_0
      //   12: monitorexit
      //   13: ldc 127
      //   15: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   18: return
      //   19: astore_1
      //   20: aload_0
      //   21: monitorexit
      //   22: ldc 127
      //   24: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   27: aload_1
      //   28: athrow
      //   29: astore_1
      //   30: goto -19 -> 11
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	33	0	this	a
      //   19	9	1	localObject	Object
      //   29	1	1	localInterruptedException	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   7	11	19	finally
      //   11	13	19	finally
      //   20	22	19	finally
      //   7	11	29	java/lang/InterruptedException
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(187064);
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        int i = 0;
        for (;;)
        {
          if (1 == i) {}
          try
          {
            notify();
            return;
          }
          finally
          {
            AppMethodBeat.o(187064);
          }
          a(paramMessage.obj);
          c.b(c.this, true);
          i = 1;
          continue;
          a();
          c.this.d.a();
          i = 0;
          continue;
          c.a(c.this, (byte[])paramMessage.obj);
          i = 0;
          continue;
          c.b(c.this, paramMessage.arg1);
          i = 1;
          continue;
          c.a(c.this, (float)(paramMessage.arg1 / 100.0D));
          if (c.a(c.this) == null) {
            break;
          }
          c.a(c.this).a(c.q(c.this));
          i = 0;
        }
        paramMessage = (d.b)paramMessage.obj;
        c.b(c.this, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.c
 * JD-Core Version:    0.7.0.1
 */