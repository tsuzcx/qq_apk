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

class b
  extends HandlerThread
{
  private int A;
  private int B;
  private int C;
  private int D;
  private Context E;
  private boolean F;
  private c.d G;
  private c.e H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private float Q;
  private int R;
  private int S;
  private int T;
  private int U;
  private int V;
  private boolean W;
  private float[] X;
  private boolean Y;
  private int Z;
  boolean a;
  private Object aA;
  private Handler aB;
  private a aC;
  private float aD;
  private int aE;
  private int aF;
  private int aG;
  private int aH;
  private int aI;
  private boolean aJ;
  private com.tencent.liteav.beauty.a.a.c aK;
  private com.tencent.liteav.beauty.a.a.a aL;
  private Bitmap aM;
  private List<c.e> aN;
  private long aO;
  private int aP;
  private final int aQ;
  private final float aR;
  private byte[] aS;
  private int[] aT;
  private boolean aU;
  private byte[] aV;
  private int aW;
  private int aX;
  private int aY;
  private int aZ;
  private int aa;
  private com.tencent.liteav.basic.d.a ab;
  private Bitmap ac;
  private k ad;
  private o ae;
  private com.tencent.liteav.beauty.b.b af;
  private com.tencent.liteav.beauty.b.a.a ag;
  private com.tencent.liteav.beauty.b.b.a ah;
  private com.tencent.liteav.beauty.b.c ai;
  private Bitmap aj;
  private Bitmap ak;
  private float al;
  private float am;
  private float an;
  private m ao;
  private n ap;
  private x aq;
  private com.tencent.liteav.beauty.b.j ar;
  private com.tencent.liteav.beauty.b.i as;
  private h at;
  private l au;
  private com.tencent.liteav.basic.d.i av;
  private h aw;
  private final Queue<Runnable> ax;
  private boolean ay;
  private Object az;
  protected int[] b;
  private d ba;
  private WeakReference<com.tencent.liteav.basic.c.a> bb;
  private j.a bc;
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
  
  b(Context paramContext, boolean paramBoolean)
  {
    super("TXCFilterDrawer");
    AppMethodBeat.i(15162);
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
    this.G = new c.d();
    this.H = null;
    this.I = -1;
    this.J = -1;
    this.K = -1;
    this.L = -1;
    this.M = -1;
    this.N = -1;
    this.O = -1;
    this.P = -1;
    this.Q = 1.0F;
    this.R = -1;
    this.S = -1;
    this.T = 0;
    this.U = 0;
    this.V = 1;
    this.W = false;
    this.X = null;
    this.Y = false;
    this.Z = 0;
    this.aa = 0;
    this.ab = null;
    this.ac = null;
    this.ad = null;
    this.ae = null;
    this.af = null;
    this.ag = null;
    this.ah = null;
    this.ai = null;
    this.ap = null;
    this.aq = null;
    this.ar = null;
    this.as = null;
    this.at = null;
    this.au = null;
    this.av = null;
    this.aw = null;
    this.ax = new LinkedList();
    this.a = false;
    this.az = new Object();
    this.aA = new Object();
    this.aD = 0.5F;
    this.aE = 0;
    this.aF = 0;
    this.aG = 0;
    this.aH = 0;
    this.aI = 0;
    this.aJ = false;
    this.aK = null;
    this.aL = null;
    this.aM = null;
    this.aN = null;
    this.aO = 0L;
    this.aP = 0;
    this.aQ = 100;
    this.aR = 1000.0F;
    this.aS = null;
    this.aT = null;
    this.aU = false;
    this.aV = null;
    this.b = null;
    this.c = null;
    this.aW = -1;
    this.aX = 0;
    this.aY = 1;
    this.aZ = this.aW;
    this.ba = null;
    this.bb = new WeakReference(null);
    this.d = new com.tencent.liteav.beauty.b.a();
    this.e = new com.tencent.liteav.beauty.b.a();
    this.f = new com.tencent.liteav.beauty.b.a();
    this.bc = new j.a() {};
    this.E = paramContext;
    this.aB = new Handler(this.E.getMainLooper());
    this.ay = paramBoolean;
    AppMethodBeat.o(15162);
  }
  
  private int A(int paramInt)
  {
    AppMethodBeat.i(15178);
    GLES20.glViewport(0, 0, this.I, this.J);
    paramInt = a(this.ad.q(), paramInt, 0L);
    AppMethodBeat.o(15178);
    return paramInt;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15175);
    if (true == this.ay) {
      if (this.ba != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aS);
        this.ba.a(this.aS, this.R, this.S, this.aa, TXCTimeUtil.generatePtsMS());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(15175);
      return 0;
      if (this.aV != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aV);
        continue;
        if (3 == com.tencent.liteav.basic.d.j.a())
        {
          if (0L == this.aO) {
            this.aO = TXCTimeUtil.getTimeTick();
          }
          int i1 = this.aP + 1;
          this.aP = i1;
          if (i1 >= 100)
          {
            TXCLog.i("TXCFilterDrawer", "Real fps ".concat(String.valueOf(100.0F / ((float)(TXCTimeUtil.getTimeTick() - this.aO) / 1000.0F))));
            this.aP = 0;
            this.aO = TXCTimeUtil.getTimeTick();
          }
          GLES30.glPixelStorei(3333, 1);
          if (Build.VERSION.SDK_INT >= 18) {
            GLES30.glReadBuffer(1029);
          }
          GLES30.glBindBuffer(35051, this.aT[0]);
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
              AppMethodBeat.o(15175);
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
    AppMethodBeat.i(15174);
    if (this.aa == 0) {
      if (this.ba != null)
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
      this.ba.a(paramInt, this.R, this.S, paramLong);
      AppMethodBeat.o(15174);
      return paramInt;
      if ((1 == this.aa) || (3 == this.aa) || (2 == this.aa))
      {
        GLES20.glViewport(0, 0, this.R, this.S);
        if (this.ae == null)
        {
          TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
          AppMethodBeat.o(15174);
          return paramInt;
        }
        GLES20.glBindFramebuffer(36160, this.b[0]);
        this.ae.a(paramInt);
        if (2 == this.aa) {
          a(this.R, this.S);
        }
        for (;;)
        {
          GLES20.glBindFramebuffer(36160, 0);
          AppMethodBeat.o(15174);
          return paramInt;
          a(this.R, this.S * 3 / 8);
        }
      }
      TXCLog.e("TXCFilterDrawer", "Don't support format!");
      AppMethodBeat.o(15174);
      return -1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    AppMethodBeat.i(15195);
    if (this.ao == null)
    {
      TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
      this.ao = new m(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
      if (true == this.ao.a())
      {
        this.ao.a(true);
        this.ao.a(paramInt1, paramInt2);
        AppMethodBeat.o(15195);
        return;
      }
      TXCLog.e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
    }
    AppMethodBeat.o(15195);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(15193);
    TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
    if (paramInt3 == 0)
    {
      if (this.ag == null) {
        this.ag = new com.tencent.liteav.beauty.b.a.a();
      }
      this.af = this.ag;
    }
    while (this.af == null)
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
      AppMethodBeat.o(15193);
      return;
      if (1 == paramInt3)
      {
        if (this.ah == null) {
          this.ah = new com.tencent.liteav.beauty.b.b.a();
        }
        this.af = this.ah;
      }
      else if (2 == paramInt3)
      {
        if (this.ai == null) {
          this.ai = new com.tencent.liteav.beauty.b.c();
        }
        this.af = this.ai;
      }
    }
    this.af.a(true);
    if (true == this.af.c(paramInt1, paramInt2))
    {
      if (this.aF > 0) {
        this.af.c(this.aF);
      }
      if (this.aG > 0) {
        this.af.d(this.aG);
      }
      if (this.aI > 0) {
        this.af.e(this.aI);
      }
      if (this.aH > 0)
      {
        this.af.f(this.aH);
        AppMethodBeat.o(15193);
      }
    }
    else
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
    }
    AppMethodBeat.o(15193);
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    // Byte code:
    //   0: sipush 15170
    //   3: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 332	com/tencent/liteav/beauty/b:aA	Ljava/lang/Object;
    //   10: astore 7
    //   12: aload 7
    //   14: monitorenter
    //   15: iload 6
    //   17: iload_3
    //   18: isub
    //   19: sipush 360
    //   22: iadd
    //   23: sipush 360
    //   26: irem
    //   27: istore_3
    //   28: ldc 179
    //   30: ldc_w 604
    //   33: iload_3
    //   34: invokestatic 607	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   37: invokevirtual 483	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 488	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 312	com/tencent/liteav/beauty/b:at	Lcom/tencent/liteav/basic/d/h;
    //   47: ifnonnull +67 -> 114
    //   50: iload_1
    //   51: iload 4
    //   53: if_icmpne +31 -> 84
    //   56: iload_2
    //   57: iload 5
    //   59: if_icmpne +25 -> 84
    //   62: iload_3
    //   63: ifne +21 -> 84
    //   66: ldc 179
    //   68: ldc_w 609
    //   71: invokestatic 488	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 7
    //   76: monitorexit
    //   77: sipush 15170
    //   80: invokestatic 424	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: aload_0
    //   85: new 611	com/tencent/liteav/basic/d/h
    //   88: dup
    //   89: invokespecial 612	com/tencent/liteav/basic/d/h:<init>	()V
    //   92: putfield 312	com/tencent/liteav/beauty/b:at	Lcom/tencent/liteav/basic/d/h;
    //   95: iconst_1
    //   96: aload_0
    //   97: getfield 312	com/tencent/liteav/beauty/b:at	Lcom/tencent/liteav/basic/d/h;
    //   100: invokevirtual 613	com/tencent/liteav/basic/d/h:a	()Z
    //   103: if_icmpne +49 -> 152
    //   106: aload_0
    //   107: getfield 312	com/tencent/liteav/beauty/b:at	Lcom/tencent/liteav/basic/d/h;
    //   110: iconst_1
    //   111: invokevirtual 614	com/tencent/liteav/basic/d/h:a	(Z)V
    //   114: aload_0
    //   115: getfield 312	com/tencent/liteav/beauty/b:at	Lcom/tencent/liteav/basic/d/h;
    //   118: iload 4
    //   120: iload 5
    //   122: invokevirtual 615	com/tencent/liteav/basic/d/h:a	(II)V
    //   125: aload_0
    //   126: getfield 312	com/tencent/liteav/beauty/b:at	Lcom/tencent/liteav/basic/d/h;
    //   129: sipush 720
    //   132: iload_3
    //   133: isub
    //   134: sipush 360
    //   137: irem
    //   138: aconst_null
    //   139: invokevirtual 618	com/tencent/liteav/basic/d/h:a	(ILjava/nio/FloatBuffer;)V
    //   142: aload 7
    //   144: monitorexit
    //   145: sipush 15170
    //   148: invokestatic 424	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: ldc 179
    //   154: ldc_w 620
    //   157: invokestatic 516	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -46 -> 114
    //   163: astore 8
    //   165: aload 7
    //   167: monitorexit
    //   168: sipush 15170
    //   171: invokestatic 424	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload 8
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	b
    //   0	177	1	paramInt1	int
    //   0	177	2	paramInt2	int
    //   0	177	3	paramInt3	int
    //   0	177	4	paramInt4	int
    //   0	177	5	paramInt5	int
    //   0	177	6	paramInt6	int
    //   10	156	7	localObject1	Object
    //   163	12	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	50	163	finally
    //   66	77	163	finally
    //   84	114	163	finally
    //   114	145	163	finally
    //   152	160	163	finally
    //   165	168	163	finally
  }
  
  private void a(com.tencent.liteav.basic.d.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(15169);
    if (this.au == null)
    {
      TXCLog.i("TXCFilterDrawer", "Create CropFilter");
      if (4 == paramInt6)
      {
        this.au = new l("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
        if (true != this.au.a()) {
          break label188;
        }
        this.au.a(true);
      }
    }
    else
    {
      label64:
      this.au.a(paramInt3, paramInt4);
      parama = this.au.a(this.I, this.J, null, parama, paramInt6);
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
      this.au.a(paramInt1, paramInt2, paramInt6, parama, paramInt5 / paramInt4, paramBoolean, false);
      AppMethodBeat.o(15169);
      return;
      this.au = new l();
      break;
      TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
      break label64;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(15197);
    synchronized (this.ax)
    {
      this.ax.add(paramRunnable);
      AppMethodBeat.o(15197);
      return;
    }
  }
  
  private void a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(15198);
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
        AppMethodBeat.o(15198);
      }
    }
    AppMethodBeat.o(15198);
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(15177);
    if (!paramBoolean)
    {
      if (this.ba != null)
      {
        this.ba.a(paramArrayOfByte, this.R, this.S, this.aa, TXCTimeUtil.generatePtsMS());
        AppMethodBeat.o(15177);
        return;
      }
      TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
      AppMethodBeat.o(15177);
      return;
    }
    int i1 = this.S * 3 / 8;
    if (2 == this.aa) {
      i1 = this.S;
    }
    if (this.ba != null)
    {
      NativeLoad.getInstance();
      if (true == NativeLoad.nativeGlReadPixsFromQueue(this.R, i1, this.aS))
      {
        this.ba.a(this.aS, this.R, this.S, this.aa, TXCTimeUtil.generatePtsMS());
        AppMethodBeat.o(15177);
        return;
      }
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
      this.ba.a(paramArrayOfByte, this.R, this.S, this.aa, TXCTimeUtil.generatePtsMS());
      AppMethodBeat.o(15177);
      return;
    }
    NativeLoad.getInstance();
    if (!NativeLoad.nativeGlReadPixsFromQueue(this.R, i1, this.aV)) {
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
    }
    AppMethodBeat.o(15177);
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15184);
    GLES20.glGenFramebuffers(1, paramArrayOfInt1, 0);
    paramArrayOfInt2[0] = com.tencent.liteav.basic.d.j.a(paramInt1, paramInt2, 6408, 6408, paramArrayOfInt2);
    GLES20.glBindFramebuffer(36160, paramArrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramArrayOfInt2[0], 0);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(15184);
  }
  
  private void b()
  {
    AppMethodBeat.i(15181);
    TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
    this.aU = false;
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
    c();
    if (this.ao != null)
    {
      this.ao.d();
      this.ao = null;
    }
    if (this.ap != null)
    {
      this.ap.a();
      this.ap = null;
    }
    if (this.av != null)
    {
      this.av.d();
      this.av = null;
    }
    if (this.au != null)
    {
      this.au.d();
      this.au = null;
    }
    if (this.at != null)
    {
      this.at.d();
      this.at = null;
    }
    if (this.aq != null)
    {
      this.aq.d();
      this.aq = null;
    }
    if (this.ar != null)
    {
      this.ar.a();
      this.ar = null;
    }
    if (this.as != null)
    {
      this.as.d();
      this.as = null;
    }
    if (this.aw != null)
    {
      this.aw.d();
      this.aw = null;
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
    AppMethodBeat.o(15181);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15196);
    if (this.aw == null)
    {
      TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
      this.aw = new h();
      if (true != this.aw.a()) {
        break label74;
      }
      this.aw.a(true);
    }
    for (;;)
    {
      if (this.aw != null) {
        this.aw.a(paramInt1, paramInt2);
      }
      AppMethodBeat.o(15196);
      return;
      label74:
      TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(15179);
    if (this.ad == null)
    {
      TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
      AppMethodBeat.o(15179);
      return;
    }
    this.ad.a(paramArrayOfByte);
    AppMethodBeat.o(15179);
  }
  
  private void c()
  {
    AppMethodBeat.i(15194);
    if (this.ag != null)
    {
      this.ag.d();
      this.ag = null;
    }
    if (this.ah != null)
    {
      this.ah.d();
      this.ah = null;
    }
    if (this.ai != null)
    {
      this.ai.d();
      this.ai = null;
    }
    this.af = null;
    AppMethodBeat.o(15194);
  }
  
  private boolean c(c.b paramb)
  {
    AppMethodBeat.i(15182);
    TXCLog.i("TXCFilterDrawer", "come into initInternal");
    b();
    this.ay = paramb.j;
    this.I = paramb.d;
    this.J = paramb.e;
    this.ab = paramb.m;
    this.K = paramb.g;
    this.L = paramb.f;
    this.T = paramb.h;
    this.W = paramb.i;
    this.R = paramb.b;
    this.S = paramb.c;
    this.U = paramb.a;
    this.M = paramb.g;
    this.N = paramb.f;
    if ((this.T == 90) || (this.T == 270))
    {
      this.M = paramb.f;
      this.N = paramb.g;
    }
    this.aa = paramb.l;
    this.Z = paramb.k;
    this.aS = new byte[this.R * this.S * 4];
    TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is " + this.Q);
    int i1;
    if (this.Q != 1.0F)
    {
      if (this.M >= this.N) {
        break label607;
      }
      i1 = this.M;
      if (i1 > 368) {
        this.Q = (432.0F / i1);
      }
      if (this.Q > 1.0F) {
        this.Q = 1.0F;
      }
    }
    this.O = ((int)(this.M * this.Q));
    this.P = ((int)(this.N * this.Q));
    a(this.O, this.P, this.aE);
    if ((this.H != null) && (this.H.a != null) && (this.aq == null))
    {
      TXCLog.i("TXCFilterDrawer", "reset water mark!");
      a(this.H.a, this.H.b, this.H.c, this.H.d);
    }
    if (((this.aj != null) || (this.ak != null)) && (this.ao == null)) {
      a(this.O, this.P, this.al, this.aj, this.am, this.ak, this.an);
    }
    a(this.ab, this.K, this.L, this.O, this.P, this.W, this.T, this.Z);
    a(this.M, this.N, this.T, this.R, this.S, this.U);
    if (this.b == null)
    {
      this.b = new int[1];
      label512:
      if (this.c != null) {
        break label627;
      }
      this.c = new int[1];
      label526:
      a(this.b, this.c, this.R, this.S);
      if (3 == com.tencent.liteav.basic.d.j.a())
      {
        if (this.aT != null) {
          break label639;
        }
        this.aT = new int[1];
      }
    }
    for (;;)
    {
      TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
      com.tencent.liteav.basic.d.j.a(this.K, this.L, this.aT);
      TXCLog.i("TXCFilterDrawer", "come out initInternal");
      AppMethodBeat.o(15182);
      return true;
      label607:
      i1 = this.N;
      break;
      GLES20.glDeleteFramebuffers(1, this.b, 0);
      break label512;
      label627:
      GLES20.glDeleteTextures(1, this.c, 0);
      break label526;
      label639:
      TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
      GLES30.glDeleteBuffers(1, this.aT, 0);
    }
  }
  
  private boolean d(c.b paramb)
  {
    AppMethodBeat.i(15185);
    if (((1 == paramb.k) || (3 == paramb.k) || (2 == paramb.k)) && (this.ad == null))
    {
      this.ad = new k(paramb.k);
      this.ad.a(true);
      if (!this.ad.a())
      {
        TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
        AppMethodBeat.o(15185);
        return false;
      }
      this.ad.a(paramb.d, paramb.e);
    }
    if (((1 == paramb.l) || (3 == paramb.l) || (2 == paramb.l)) && (this.ae == null))
    {
      this.ae = new o(paramb.l);
      if (!this.ae.a())
      {
        TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
        AppMethodBeat.o(15185);
        return false;
      }
      this.ae.a(paramb.b, paramb.c);
    }
    AppMethodBeat.o(15185);
    return true;
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(15164);
    a(this.ax);
    int i1;
    if (this.Q != 1.0F)
    {
      i1 = 1;
      GLES20.glViewport(0, 0, this.O, this.P);
      int i2 = paramInt1;
      if (this.au != null)
      {
        if ((4 == paramInt2) || (true == this.Y))
        {
          this.au.a(this.X);
          this.au.c(this.Y);
        }
        i2 = this.au.b(paramInt1);
      }
      paramInt2 = i2;
      if (this.af != null) {
        if ((this.aF <= 0) && (this.aG <= 0))
        {
          paramInt2 = i2;
          if (this.aI <= 0) {}
        }
        else
        {
          paramInt2 = this.af.b(i2);
        }
      }
      paramInt1 = paramInt2;
      if (this.ao != null) {
        paramInt1 = this.ao.b(paramInt2);
      }
      GLES20.glViewport(0, 0, this.M, this.N);
      paramInt2 = paramInt1;
      if (this.ar != null)
      {
        paramInt2 = this.ar.a(paramInt1);
        i1 = 0;
      }
      if (this.as == null) {
        break label382;
      }
      paramInt1 = this.as.b(paramInt2);
      i1 = 0;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        b(this.M, this.N);
        if (this.aw != null) {
          GLES20.glViewport(0, 0, this.M, this.N);
        }
      }
      for (paramInt2 = this.aw.b(paramInt1);; paramInt2 = paramInt1)
      {
        paramInt1 = paramInt2;
        if (this.ba != null)
        {
          i1 = this.ba.a(paramInt2, this.M, this.N);
          paramInt1 = paramInt2;
          if (i1 > 0) {
            paramInt1 = i1;
          }
        }
        GLES20.glViewport(0, 0, this.M, this.N);
        paramInt2 = paramInt1;
        if (this.aq != null) {
          paramInt2 = this.aq.b(paramInt1);
        }
        paramInt1 = paramInt2;
        if (this.at != null)
        {
          GLES20.glViewport(0, 0, this.R, this.S);
          paramInt1 = this.at.b(paramInt2);
        }
        a(paramInt1, paramLong);
        AppMethodBeat.o(15164);
        return paramInt1;
        i1 = 0;
        break;
      }
      label382:
      paramInt1 = paramInt2;
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(15165);
    a(paramArrayOfByte);
    if (!this.ay)
    {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
      this.aC.obtainMessage(2, paramArrayOfByte).sendToTarget();
      if (!this.aU)
      {
        TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
        NativeLoad.getInstance();
        NativeLoad.nativeClearQueue();
      }
      this.aC.obtainMessage(3, paramInt, 0).sendToTarget();
      a(paramArrayOfByte, this.aU);
      this.aU = true;
    }
    for (paramInt = -1;; paramInt = A(paramInt))
    {
      AppMethodBeat.o(15165);
      return paramInt;
      b(paramArrayOfByte);
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(15180);
    if (!this.ay)
    {
      if (this.aC == null) {
        break label57;
      }
      this.aC.obtainMessage(1).sendToTarget();
      try
      {
        this.d.b();
        AppMethodBeat.o(15180);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        AppMethodBeat.o(15180);
        return;
      }
    }
    b();
    label57:
    AppMethodBeat.o(15180);
  }
  
  public void a(final float paramFloat)
  {
    AppMethodBeat.i(15166);
    this.aD = paramFloat;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15266);
        if (b.a(b.this) != null) {
          b.a(b.this).a(paramFloat);
        }
        AppMethodBeat.o(15266);
      }
    });
    AppMethodBeat.o(15166);
  }
  
  public void a(final float paramFloat1, final Bitmap paramBitmap1, final float paramFloat2, final Bitmap paramBitmap2, final float paramFloat3)
  {
    AppMethodBeat.i(15192);
    if ((this.aj != paramBitmap1) || (this.ak != paramBitmap2))
    {
      this.aj = paramBitmap1;
      this.ak = paramBitmap2;
      this.al = paramFloat1;
      this.am = paramFloat2;
      this.an = paramFloat3;
      a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15123);
          if (b.a(b.this) != null) {
            a.a().e();
          }
          if ((b.h(b.this) == null) && (b.i(b.this) == null))
          {
            if (b.a(b.this) != null)
            {
              b.a(b.this).d();
              b.a(b.this, null);
              AppMethodBeat.o(15123);
            }
          }
          else
          {
            if (b.a(b.this) == null)
            {
              b.a(b.this, b.f(b.this), b.g(b.this), b.j(b.this), b.h(b.this), b.k(b.this), b.i(b.this), b.l(b.this));
              AppMethodBeat.o(15123);
              return;
            }
            b.a(b.this).a(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
          }
          AppMethodBeat.o(15123);
        }
      });
      AppMethodBeat.o(15192);
      return;
    }
    if ((this.ao != null) && ((this.al != paramFloat1) || (this.am != paramFloat2) || (this.an != paramFloat3)))
    {
      this.al = paramFloat1;
      this.am = paramFloat2;
      this.an = paramFloat3;
      a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15268);
          b.a(b.this).a(paramFloat1, paramFloat2, paramFloat3);
          AppMethodBeat.o(15268);
        }
      });
    }
    AppMethodBeat.o(15192);
  }
  
  public void a(int paramInt) {}
  
  public void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(15191);
    a(1.0F, paramBitmap, this.aD, null, 0.0F);
    AppMethodBeat.o(15191);
  }
  
  public void a(final Bitmap paramBitmap, final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    AppMethodBeat.i(15171);
    if (this.H == null) {
      this.H = new c.e();
    }
    if ((this.H.a != null) && (paramBitmap != null) && (true == this.H.a.equals(paramBitmap)) && (paramFloat1 == this.H.b) && (paramFloat2 == this.H.c) && (paramFloat3 == this.H.d) && (this.aq != null))
    {
      AppMethodBeat.o(15171);
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
        AppMethodBeat.i(15210);
        if (paramBitmap != null) {
          a.a().g();
        }
        if (paramBitmap == null)
        {
          if (b.b(b.this) != null)
          {
            b.b(b.this).d();
            b.a(b.this, null);
          }
          AppMethodBeat.o(15210);
          return;
        }
        if (b.b(b.this) == null)
        {
          if ((b.c(b.this) <= 0) || (b.d(b.this) <= 0))
          {
            TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
            AppMethodBeat.o(15210);
            return;
          }
          b.a(b.this, new x());
          b.b(b.this).a(true);
          if (!b.b(b.this).a())
          {
            TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
            b.b(b.this).d();
            b.a(b.this, null);
            AppMethodBeat.o(15210);
            return;
          }
          b.b(b.this).a(b.c(b.this), b.d(b.this));
        }
        b.b(b.this).c(true);
        b.b(b.this).a(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
        AppMethodBeat.o(15210);
      }
    });
    AppMethodBeat.o(15171);
  }
  
  void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(15173);
    TXCLog.i("TXCFilterDrawer", "set notify");
    this.bb = new WeakReference(parama);
    if (this.ar != null) {
      this.ar.a((com.tencent.liteav.basic.c.a)this.bb.get());
    }
    AppMethodBeat.o(15173);
  }
  
  void a(d paramd)
  {
    AppMethodBeat.i(15172);
    TXCLog.i("TXCFilterDrawer", "set listener");
    this.ba = paramd;
    AppMethodBeat.o(15172);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(final boolean paramBoolean)
  {
    AppMethodBeat.i(15168);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15267);
        b.a(b.this, paramBoolean);
        AppMethodBeat.o(15267);
      }
    });
    AppMethodBeat.o(15168);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aV = paramArrayOfByte;
  }
  
  public void a(final float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(15167);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15161);
        b.a(b.this, paramArrayOfFloat);
        AppMethodBeat.o(15161);
      }
    });
    AppMethodBeat.o(15167);
  }
  
  /* Error */
  public boolean a(c.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 15163
    //   5: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iconst_1
    //   9: istore_2
    //   10: aload_1
    //   11: getfield 769	com/tencent/liteav/beauty/c$b:j	Z
    //   14: ifne +63 -> 77
    //   17: aload_0
    //   18: getfield 892	com/tencent/liteav/beauty/b:aC	Lcom/tencent/liteav/beauty/b$a;
    //   21: ifnonnull +27 -> 48
    //   24: aload_0
    //   25: invokevirtual 962	com/tencent/liteav/beauty/b:start	()V
    //   28: aload_0
    //   29: new 32	com/tencent/liteav/beauty/b$a
    //   32: dup
    //   33: aload_0
    //   34: aload_0
    //   35: invokevirtual 965	com/tencent/liteav/beauty/b:getLooper	()Landroid/os/Looper;
    //   38: aload_0
    //   39: getfield 237	com/tencent/liteav/beauty/b:E	Landroid/content/Context;
    //   42: invokespecial 968	com/tencent/liteav/beauty/b$a:<init>	(Lcom/tencent/liteav/beauty/b;Landroid/os/Looper;Landroid/content/Context;)V
    //   45: putfield 892	com/tencent/liteav/beauty/b:aC	Lcom/tencent/liteav/beauty/b$a;
    //   48: aload_0
    //   49: getfield 892	com/tencent/liteav/beauty/b:aC	Lcom/tencent/liteav/beauty/b$a;
    //   52: iconst_0
    //   53: aload_1
    //   54: invokevirtual 896	com/tencent/liteav/beauty/b$a:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   57: invokevirtual 901	android/os/Message:sendToTarget	()V
    //   60: aload_0
    //   61: getfield 892	com/tencent/liteav/beauty/b:aC	Lcom/tencent/liteav/beauty/b$a;
    //   64: invokevirtual 969	com/tencent/liteav/beauty/b$a:b	()V
    //   67: sipush 15163
    //   70: invokestatic 424	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_2
    //   76: ireturn
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial 707	com/tencent/liteav/beauty/b:c	(Lcom/tencent/liteav/beauty/c$b;)Z
    //   82: istore_2
    //   83: goto -16 -> 67
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	b
    //   0	91	1	paramb	c.b
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
    AppMethodBeat.i(15176);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15209);
        b.a(b.this, paramInt);
        AppMethodBeat.o(15209);
      }
    });
    AppMethodBeat.o(15176);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b(c.b paramb)
  {
    AppMethodBeat.i(15183);
    if (!this.ay)
    {
      if (this.aC == null)
      {
        TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
        AppMethodBeat.o(15183);
        return false;
      }
      this.aC.obtainMessage(5, 0, 0, paramb).sendToTarget();
    }
    for (;;)
    {
      AppMethodBeat.o(15183);
      return true;
      d(paramb);
    }
  }
  
  public void c(final int paramInt)
  {
    AppMethodBeat.i(15186);
    this.aF = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15285);
        if (paramInt > 0) {
          a.a().b();
        }
        if ((b.e(b.this) != null) && (paramInt >= 0)) {
          b.e(b.this).c(paramInt);
        }
        AppMethodBeat.o(15285);
      }
    });
    AppMethodBeat.o(15186);
  }
  
  public void d(final int paramInt)
  {
    AppMethodBeat.i(15187);
    if ((this.aE == paramInt) || (paramInt > 2) || (paramInt < 0))
    {
      AppMethodBeat.o(15187);
      return;
    }
    this.aE = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15272);
        b.a(b.this, b.f(b.this), b.g(b.this), paramInt);
        AppMethodBeat.o(15272);
      }
    });
    AppMethodBeat.o(15187);
  }
  
  public void e(final int paramInt)
  {
    AppMethodBeat.i(15188);
    this.aG = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15261);
        if (paramInt > 0) {
          a.a().c();
        }
        if ((b.e(b.this) != null) && (paramInt >= 0)) {
          b.e(b.this).d(paramInt);
        }
        AppMethodBeat.o(15261);
      }
    });
    AppMethodBeat.o(15188);
  }
  
  public void f(final int paramInt)
  {
    AppMethodBeat.i(15189);
    this.aH = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15124);
        if (paramInt > 0) {
          a.a().f();
        }
        if ((b.e(b.this) != null) && (paramInt >= 0)) {
          b.e(b.this).f(paramInt);
        }
        AppMethodBeat.o(15124);
      }
    });
    AppMethodBeat.o(15189);
  }
  
  public void g(final int paramInt)
  {
    AppMethodBeat.i(15190);
    this.aI = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15208);
        if (paramInt > 0) {
          a.a().d();
        }
        if ((b.e(b.this) != null) && (paramInt >= 0)) {
          b.e(b.this).e(paramInt);
        }
        AppMethodBeat.o(15208);
      }
    });
    AppMethodBeat.o(15190);
  }
  
  public void h(int paramInt) {}
  
  public void i(int paramInt) {}
  
  public void j(int paramInt) {}
  
  public void k(int paramInt) {}
  
  public void l(int paramInt) {}
  
  public void m(int paramInt) {}
  
  public void n(int paramInt) {}
  
  public void o(int paramInt) {}
  
  public void p(int paramInt) {}
  
  public void q(int paramInt) {}
  
  public void r(int paramInt) {}
  
  public void s(int paramInt) {}
  
  public void t(int paramInt) {}
  
  public void u(int paramInt) {}
  
  public void v(int paramInt) {}
  
  public void w(int paramInt) {}
  
  public void x(int paramInt) {}
  
  public void y(int paramInt) {}
  
  public void z(int paramInt) {}
  
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
      AppMethodBeat.i(15262);
      TXCLog.i(this.b, "come into InitEGL");
      paramObject = (c.b)paramObject;
      a();
      b.a(b.this, new com.tencent.liteav.beauty.a.a.a());
      b.a(b.this, new com.tencent.liteav.beauty.a.a.c(b.m(b.this), paramObject.g, paramObject.f, false));
      b.n(b.this).b();
      if (!b.a(b.this, paramObject))
      {
        TXCLog.e(this.b, "initInternal failed!");
        AppMethodBeat.o(15262);
        return;
      }
      TXCLog.i(this.b, "come out InitEGL");
      AppMethodBeat.o(15262);
    }
    
    public void a()
    {
      AppMethodBeat.i(15263);
      TXCLog.i(this.b, "come into releaseEGL");
      if ((b.o(b.this) != null) && (b.o(b.this)[0] > 0))
      {
        GLES20.glDeleteBuffers(1, b.o(b.this), 0);
        b.a(b.this, null);
      }
      b.p(b.this);
      if (b.n(b.this) != null)
      {
        b.n(b.this).c();
        b.a(b.this, null);
      }
      if (b.m(b.this) != null)
      {
        b.m(b.this).a();
        b.a(b.this, null);
      }
      b.b(b.this, false);
      NativeLoad.getInstance();
      NativeLoad.nativeDeleteYuv2Yuv();
      TXCLog.i(this.b, "come out releaseEGL");
      AppMethodBeat.o(15263);
    }
    
    /* Error */
    void b()
    {
      // Byte code:
      //   0: sipush 15265
      //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: monitorenter
      //   8: aload_0
      //   9: invokevirtual 129	java/lang/Object:wait	()V
      //   12: aload_0
      //   13: monitorexit
      //   14: sipush 15265
      //   17: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   20: return
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: sipush 15265
      //   27: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   30: aload_1
      //   31: athrow
      //   32: astore_1
      //   33: goto -21 -> 12
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	36	0	this	a
      //   21	10	1	localObject	Object
      //   32	1	1	localInterruptedException	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   8	12	21	finally
      //   12	14	21	finally
      //   22	24	21	finally
      //   8	12	32	java/lang/InterruptedException
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(15264);
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
            AppMethodBeat.o(15264);
          }
          a(paramMessage.obj);
          b.b(b.this, true);
          i = 1;
          continue;
          a();
          b.this.d.a();
          i = 0;
          continue;
          b.a(b.this, (byte[])paramMessage.obj);
          i = 0;
          continue;
          b.b(b.this, paramMessage.arg1);
          i = 1;
          continue;
          b.a(b.this, (float)(paramMessage.arg1 / 100.0D));
          if (b.a(b.this) == null) {
            break;
          }
          b.a(b.this).a(b.q(b.this));
          i = 0;
          continue;
          paramMessage = (c.b)paramMessage.obj;
          b.b(b.this, paramMessage);
          i = 0;
        }
        b.a(b.this, b.c(b.this), b.d(b.this), b.r(b.this), paramMessage.arg1, paramMessage.arg2, ((Integer)paramMessage.obj).intValue());
        b.this.f.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b
 * JD-Core Version:    0.7.0.1
 */