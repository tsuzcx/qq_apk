package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils.a;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.i;
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
import java.util.concurrent.TimeUnit;

class c
  extends HandlerThread
{
  private int A;
  private int B;
  private Context C;
  private boolean D;
  private boolean E;
  private d.e F;
  private d.f G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private float N;
  private int O;
  private int P;
  private int Q;
  private boolean R;
  private float[] S;
  private boolean T;
  private int U;
  private int V;
  private com.tencent.liteav.basic.opengl.a W;
  private Bitmap X;
  private com.tencent.liteav.beauty.b.k Y;
  private o Z;
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
  private WeakReference<com.tencent.liteav.basic.c.b> aX;
  private com.tencent.liteav.beauty.b.a aY;
  private final com.tencent.liteav.basic.util.c aZ;
  private com.tencent.liteav.beauty.b.b aa;
  private com.tencent.liteav.beauty.b.a.a ab;
  private com.tencent.liteav.beauty.b.b.a ac;
  private com.tencent.liteav.beauty.b.c ad;
  private com.tencent.liteav.beauty.b.c.a ae;
  private Bitmap af;
  private Bitmap ag;
  private float ah;
  private float ai;
  private float aj;
  private m ak;
  private n al;
  private x am;
  private com.tencent.liteav.beauty.b.j an;
  private i ao;
  private com.tencent.liteav.basic.opengl.j ap;
  private l aq;
  private com.tencent.liteav.basic.opengl.k ar;
  private com.tencent.liteav.basic.opengl.j as;
  private final Queue<Runnable> at;
  private boolean au;
  private Object av;
  private Object aw;
  private Handler ax;
  private a ay;
  private float az;
  protected int[] b;
  private TXCOpenGlUtils.a ba;
  protected int[] c;
  private int d;
  private int e;
  private int f;
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
    this.d = 0;
    this.e = 0;
    this.f = 0;
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
    this.C = null;
    this.D = true;
    this.E = false;
    this.F = new d.e();
    this.G = null;
    this.H = -1;
    this.I = -1;
    this.J = -1;
    this.K = -1;
    this.L = -1;
    this.M = -1;
    this.N = 1.0F;
    this.O = -1;
    this.P = -1;
    this.Q = 1;
    this.R = false;
    this.S = null;
    this.T = false;
    this.U = 0;
    this.V = 0;
    this.W = null;
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
    this.aY = new com.tencent.liteav.beauty.b.a();
    this.ba = new TXCOpenGlUtils.a() {};
    this.C = paramContext;
    this.ax = new Handler(this.C.getMainLooper());
    this.au = paramBoolean;
    this.aZ = new com.tencent.liteav.basic.util.c("filter-drawer", (int)TimeUnit.SECONDS.toMillis(5L));
    AppMethodBeat.o(15215);
  }
  
  private int B(int paramInt)
  {
    AppMethodBeat.i(229813);
    GLES20.glViewport(0, 0, this.H, this.I);
    paramInt = a(this.Y.r(), paramInt, 0L);
    AppMethodBeat.o(229813);
    return paramInt;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229799);
    if (true == this.au) {
      if (this.aW != null)
      {
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aO);
        this.aW.a(this.aO, this.O, this.P, this.V, TXCTimeUtil.generatePtsMS());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(229799);
      return 0;
      if (this.aR != null)
      {
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aR);
        continue;
        if (3 == TXCOpenGlUtils.a())
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
          if (TXCBuild.VersionInt() >= 18) {
            GLES30.glReadBuffer(1029);
          }
          GLES30.glBindBuffer(35051, this.aP[0]);
          NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, null);
          Object localObject = null;
          if (TXCBuild.VersionInt() >= 18)
          {
            ByteBuffer localByteBuffer = (ByteBuffer)GLES30.glMapBufferRange(35051, 0, paramInt1 * paramInt2 * 4, 1);
            localObject = localByteBuffer;
            if (localByteBuffer == null)
            {
              TXCLog.e("TXCFilterDrawer", "glMapBufferRange is null");
              AppMethodBeat.o(229799);
              return -1;
            }
          }
          NativeLoad.nativeGlMapBufferToQueue(paramInt1, paramInt2, localObject);
          if (TXCBuild.VersionInt() >= 18) {
            GLES30.glUnmapBuffer(35051);
          }
          GLES30.glBindBuffer(35051, 0);
        }
        else
        {
          NativeLoad.nativeGlReadPixsToQueue(paramInt1, paramInt2);
        }
      }
    }
  }
  
  private int a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(229789);
    if (this.V == 0) {
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
      this.aW.a(paramInt, this.O, this.P, paramLong);
      AppMethodBeat.o(229789);
      return paramInt;
      if ((1 == this.V) || (3 == this.V) || (2 == this.V))
      {
        GLES20.glViewport(0, 0, this.O, this.P);
        if (this.Z == null)
        {
          TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
          AppMethodBeat.o(229789);
          return paramInt;
        }
        GLES20.glBindFramebuffer(36160, this.b[0]);
        this.Z.a(paramInt);
        if (2 == this.V) {
          a(this.O, this.P);
        }
        for (;;)
        {
          GLES20.glBindFramebuffer(36160, 0);
          AppMethodBeat.o(229789);
          return paramInt;
          a(this.O, this.P * 3 / 8);
        }
      }
      TXCLog.e("TXCFilterDrawer", "Don't support format!");
      AppMethodBeat.o(229789);
      return -1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    AppMethodBeat.i(229843);
    if (this.ak == null)
    {
      TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
      this.ak = new m(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
      if (true == this.ak.a())
      {
        this.ak.a(true);
        this.ak.a(paramInt1, paramInt2);
        AppMethodBeat.o(229843);
        return;
      }
      TXCLog.e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
    }
    AppMethodBeat.o(229843);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229838);
    TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
    if (paramInt3 == 0)
    {
      if (this.ab == null) {
        this.ab = new com.tencent.liteav.beauty.b.a.a();
      }
      this.aa = this.ab;
    }
    while (this.aa == null)
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
      AppMethodBeat.o(229838);
      return;
      if (1 == paramInt3)
      {
        if (this.ac == null) {
          this.ac = new com.tencent.liteav.beauty.b.b.a();
        }
        this.aa = this.ac;
      }
      else if (2 == paramInt3)
      {
        if (this.ae == null) {
          this.ae = new com.tencent.liteav.beauty.b.c.a();
        }
        this.aa = this.ae;
      }
      else if (3 == paramInt3)
      {
        if (this.ad == null) {
          this.ad = new com.tencent.liteav.beauty.b.c();
        }
        this.aa = this.ad;
      }
    }
    this.aa.a(true);
    if (true == this.aa.c(paramInt1, paramInt2))
    {
      if (this.aB > 0) {
        this.aa.c(this.aB);
      }
      if (this.aC > 0) {
        this.aa.d(this.aC);
      }
      if (this.aE > 0) {
        this.aa.e(this.aE);
      }
      if (this.aD > 0)
      {
        this.aa.f(this.aD);
        AppMethodBeat.o(229838);
      }
    }
    else
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
    }
    AppMethodBeat.o(229838);
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc_w 622
    //   3: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 330	com/tencent/liteav/beauty/c:aw	Ljava/lang/Object;
    //   10: astore 6
    //   12: aload 6
    //   14: monitorenter
    //   15: iload 5
    //   17: sipush 360
    //   20: iadd
    //   21: sipush 360
    //   24: irem
    //   25: istore 5
    //   27: ldc 179
    //   29: ldc_w 624
    //   32: iload 5
    //   34: invokestatic 627	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   37: invokevirtual 496	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 501	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 310	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/opengl/j;
    //   47: ifnonnull +67 -> 114
    //   50: iload_1
    //   51: iload_3
    //   52: if_icmpne +32 -> 84
    //   55: iload_2
    //   56: iload 4
    //   58: if_icmpne +26 -> 84
    //   61: iload 5
    //   63: ifne +21 -> 84
    //   66: ldc 179
    //   68: ldc_w 629
    //   71: invokestatic 501	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 6
    //   76: monitorexit
    //   77: ldc_w 622
    //   80: invokestatic 439	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: aload_0
    //   85: new 631	com/tencent/liteav/basic/opengl/j
    //   88: dup
    //   89: invokespecial 632	com/tencent/liteav/basic/opengl/j:<init>	()V
    //   92: putfield 310	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/opengl/j;
    //   95: iconst_1
    //   96: aload_0
    //   97: getfield 310	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/opengl/j;
    //   100: invokevirtual 633	com/tencent/liteav/basic/opengl/j:a	()Z
    //   103: if_icmpne +49 -> 152
    //   106: aload_0
    //   107: getfield 310	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/opengl/j;
    //   110: iconst_1
    //   111: invokevirtual 634	com/tencent/liteav/basic/opengl/j:a	(Z)V
    //   114: aload_0
    //   115: getfield 310	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/opengl/j;
    //   118: iload_3
    //   119: iload 4
    //   121: invokevirtual 635	com/tencent/liteav/basic/opengl/j:a	(II)V
    //   124: aload_0
    //   125: getfield 310	com/tencent/liteav/beauty/c:ap	Lcom/tencent/liteav/basic/opengl/j;
    //   128: sipush 720
    //   131: iload 5
    //   133: isub
    //   134: sipush 360
    //   137: irem
    //   138: aconst_null
    //   139: invokevirtual 638	com/tencent/liteav/basic/opengl/j:a	(ILjava/nio/FloatBuffer;)V
    //   142: aload 6
    //   144: monitorexit
    //   145: ldc_w 622
    //   148: invokestatic 439	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: ldc 179
    //   154: ldc_w 640
    //   157: invokestatic 529	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -46 -> 114
    //   163: astore 7
    //   165: aload 6
    //   167: monitorexit
    //   168: ldc_w 622
    //   171: invokestatic 439	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  }
  
  private void a(com.tencent.liteav.basic.opengl.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(229774);
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
      parama = this.aq.a(this.H, this.I, null, parama, paramInt6);
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
      AppMethodBeat.o(229774);
      return;
      this.aq = new l();
      break;
      TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
      break label64;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(229851);
    synchronized (this.at)
    {
      this.at.add(paramRunnable);
      AppMethodBeat.o(229851);
      return;
    }
  }
  
  private void a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(229854);
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
        AppMethodBeat.o(229854);
      }
    }
    AppMethodBeat.o(229854);
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(229807);
    if (!paramBoolean)
    {
      if (this.aW != null)
      {
        this.aW.a(paramArrayOfByte, this.O, this.P, this.V, TXCTimeUtil.generatePtsMS());
        AppMethodBeat.o(229807);
        return;
      }
      TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
      AppMethodBeat.o(229807);
      return;
    }
    int i1 = this.P * 3 / 8;
    if (2 == this.V) {
      i1 = this.P;
    }
    if (this.aW != null)
    {
      if (true == NativeLoad.nativeGlReadPixsFromQueue(this.O, i1, this.aO))
      {
        this.aW.a(this.aO, this.O, this.P, this.V, TXCTimeUtil.generatePtsMS());
        AppMethodBeat.o(229807);
        return;
      }
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
      this.aW.a(paramArrayOfByte, this.O, this.P, this.V, TXCTimeUtil.generatePtsMS());
      AppMethodBeat.o(229807);
      return;
    }
    if (!NativeLoad.nativeGlReadPixsFromQueue(this.O, i1, this.aR)) {
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
    }
    AppMethodBeat.o(229807);
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229831);
    GLES20.glGenFramebuffers(1, paramArrayOfInt1, 0);
    paramArrayOfInt2[0] = TXCOpenGlUtils.a(paramInt1, paramInt2, 6408, 6408, paramArrayOfInt2);
    GLES20.glBindFramebuffer(36160, paramArrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramArrayOfInt2[0], 0);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(229831);
  }
  
  private void b()
  {
    AppMethodBeat.i(15227);
    TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
    this.aQ = false;
    if (this.Y != null)
    {
      this.Y.d();
      this.Y = null;
    }
    if (this.Z != null)
    {
      this.Z.d();
      this.Z = null;
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
    if ((this.aP != null) && (this.aP[0] > 0))
    {
      GLES30.glDeleteBuffers(1, this.aP, 0);
      this.aP = null;
    }
    TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
    AppMethodBeat.o(15227);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229846);
    if (this.as == null)
    {
      TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
      this.as = new com.tencent.liteav.basic.opengl.j();
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
      AppMethodBeat.o(229846);
      return;
      label74:
      TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(229818);
    if (this.Y == null)
    {
      TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
      AppMethodBeat.o(229818);
      return;
    }
    this.Y.a(paramArrayOfByte);
    AppMethodBeat.o(229818);
  }
  
  private void c()
  {
    AppMethodBeat.i(15214);
    if (this.ab != null)
    {
      this.ab.d();
      this.ab = null;
    }
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
    this.aa = null;
    AppMethodBeat.o(15214);
  }
  
  private boolean c(d.b paramb)
  {
    AppMethodBeat.i(229828);
    TXCLog.i("TXCFilterDrawer", "come into initInternal");
    b();
    this.au = paramb.j;
    this.H = paramb.d;
    this.I = paramb.e;
    this.W = paramb.m;
    int i2 = paramb.g;
    int i3 = paramb.f;
    int i4 = paramb.h;
    this.R = paramb.i;
    this.O = paramb.b;
    this.P = paramb.c;
    int i5 = paramb.a;
    this.J = paramb.g;
    this.K = paramb.f;
    if ((i4 == 90) || (i4 == 270))
    {
      this.J = paramb.f;
      this.K = paramb.g;
    }
    this.V = paramb.l;
    this.U = paramb.k;
    this.aO = new byte[this.O * this.P * 4];
    TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is %f, process size: %d x %d", new Object[] { Float.valueOf(this.N), Integer.valueOf(this.J), Integer.valueOf(this.K) });
    int i1;
    if (this.N != 1.0F)
    {
      if (this.J >= this.K) {
        break label593;
      }
      i1 = this.J;
      if (i1 > 368) {
        this.N = (432.0F / i1);
      }
      if (this.N > 1.0F) {
        this.N = 1.0F;
      }
    }
    this.L = ((int)(this.J * this.N));
    this.M = ((int)(this.K * this.N));
    a(this.L, this.M, this.aA);
    if ((this.G != null) && (this.G.a != null) && (this.am == null))
    {
      TXCLog.i("TXCFilterDrawer", "reset water mark!");
      a(this.G.a, this.G.b, this.G.c, this.G.d);
    }
    if (((this.af != null) || (this.ag != null)) && (this.ak == null)) {
      a(this.L, this.M, this.ah, this.af, this.ai, this.ag, this.aj);
    }
    a(this.W, i2, i3, this.L, this.M, this.R, i4, this.U);
    a(this.J, this.K, this.O, this.P, i5);
    if (this.b == null)
    {
      this.b = new int[1];
      label503:
      if (this.c != null) {
        break label613;
      }
      this.c = new int[1];
      label517:
      a(this.b, this.c, this.O, this.P);
      if (3 == TXCOpenGlUtils.a())
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
      TXCOpenGlUtils.a(i2, i3, this.aP);
      TXCLog.i("TXCFilterDrawer", "come out initInternal");
      AppMethodBeat.o(229828);
      return true;
      label593:
      i1 = this.K;
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
    AppMethodBeat.i(229834);
    if (((1 == paramb.k) || (3 == paramb.k) || (2 == paramb.k)) && (this.Y == null))
    {
      this.Y = new com.tencent.liteav.beauty.b.k(paramb.k);
      this.Y.a(true);
      if (!this.Y.a())
      {
        TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
        AppMethodBeat.o(229834);
        return false;
      }
      this.Y.a(paramb.d, paramb.e);
    }
    if (((1 == paramb.l) || (3 == paramb.l) || (2 == paramb.l)) && (this.Z == null))
    {
      this.Z = new o(paramb.l);
      if (!this.Z.a())
      {
        TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
        AppMethodBeat.o(229834);
        return false;
      }
      this.Z.a(paramb.b, paramb.c);
    }
    AppMethodBeat.o(229834);
    return true;
  }
  
  public void A(int paramInt) {}
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(230000);
    this.aZ.a();
    a(this.at);
    int i1;
    if (this.N != 1.0F)
    {
      i1 = 1;
      GLES20.glViewport(0, 0, this.L, this.M);
      int i2 = paramInt1;
      if (this.aq != null)
      {
        if ((4 == paramInt2) || (true == this.T))
        {
          this.aq.a(this.S);
          this.aq.c(this.T);
        }
        i2 = this.aq.b(paramInt1);
      }
      paramInt2 = i2;
      if (this.aa != null)
      {
        if (Math.min(this.O, this.P) >= 540) {
          break label411;
        }
        paramInt1 = 0;
        label130:
        this.aa.f(paramInt1);
        if ((this.aB <= 0) && (this.aC <= 0))
        {
          paramInt2 = i2;
          if (this.aE <= 0) {}
        }
        else
        {
          paramInt2 = this.aa.b(i2);
        }
      }
      paramInt1 = paramInt2;
      if (this.ak != null) {
        paramInt1 = this.ak.b(paramInt2);
      }
      GLES20.glViewport(0, 0, this.J, this.K);
      paramInt2 = paramInt1;
      if (this.an != null)
      {
        paramInt2 = this.an.a(paramInt1);
        i1 = 0;
      }
      if (this.ao == null) {
        break label424;
      }
      paramInt1 = this.ao.b(paramInt2);
      i1 = 0;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        b(this.J, this.K);
        if (this.as != null) {
          GLES20.glViewport(0, 0, this.J, this.K);
        }
      }
      for (paramInt2 = this.as.b(paramInt1);; paramInt2 = paramInt1)
      {
        paramInt1 = paramInt2;
        if (this.aW != null)
        {
          i1 = this.aW.a(paramInt2, this.J, this.K);
          paramInt1 = paramInt2;
          if (i1 > 0) {
            paramInt1 = i1;
          }
        }
        GLES20.glViewport(0, 0, this.J, this.K);
        paramInt2 = paramInt1;
        if (this.am != null) {
          paramInt2 = this.am.b(paramInt1);
        }
        paramInt1 = paramInt2;
        if (this.ap != null)
        {
          GLES20.glViewport(0, 0, this.O, this.P);
          paramInt1 = this.ap.b(paramInt2);
        }
        a(paramInt1, paramLong);
        AppMethodBeat.o(230000);
        return paramInt1;
        i1 = 0;
        break;
        label411:
        paramInt1 = this.aD;
        break label130;
      }
      label424:
      paramInt1 = paramInt2;
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(230007);
    a(paramArrayOfByte);
    if (!this.au)
    {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
      this.ay.obtainMessage(2, paramArrayOfByte).sendToTarget();
      if (!this.aQ)
      {
        TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
        NativeLoad.nativeClearQueue();
      }
      this.ay.obtainMessage(3, paramInt, 0).sendToTarget();
      a(paramArrayOfByte, this.aQ);
      this.aQ = true;
    }
    for (paramInt = -1;; paramInt = B(paramInt))
    {
      AppMethodBeat.o(230007);
      return paramInt;
      b(paramArrayOfByte);
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(230053);
    if (!this.au)
    {
      if (this.ay == null) {
        break label57;
      }
      this.ay.obtainMessage(1).sendToTarget();
      try
      {
        this.aY.b();
        AppMethodBeat.o(230053);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        AppMethodBeat.o(230053);
        return;
      }
    }
    b();
    label57:
    AppMethodBeat.o(230053);
  }
  
  public void a(final float paramFloat)
  {
    AppMethodBeat.i(15255);
    this.az = paramFloat;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229736);
        if (c.a(c.this) != null) {
          c.a(c.this).a(paramFloat);
        }
        AppMethodBeat.o(229736);
      }
    });
    AppMethodBeat.o(15255);
  }
  
  public void a(final float paramFloat1, final Bitmap paramBitmap1, final float paramFloat2, final Bitmap paramBitmap2, final float paramFloat3)
  {
    AppMethodBeat.i(230095);
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
          AppMethodBeat.i(229732);
          if (c.a(c.this) != null) {
            a.a().e();
          }
          if ((c.h(c.this) == null) && (c.i(c.this) == null))
          {
            if (c.a(c.this) != null)
            {
              c.a(c.this).d();
              c.a(c.this, null);
              AppMethodBeat.o(229732);
            }
          }
          else
          {
            if (c.a(c.this) == null)
            {
              c.a(c.this, c.f(c.this), c.g(c.this), c.j(c.this), c.h(c.this), c.k(c.this), c.i(c.this), c.l(c.this));
              AppMethodBeat.o(229732);
              return;
            }
            c.a(c.this).a(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
          }
          AppMethodBeat.o(229732);
        }
      });
      AppMethodBeat.o(230095);
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
          AppMethodBeat.i(229744);
          c.a(c.this).a(paramFloat1, paramFloat2, paramFloat3);
          AppMethodBeat.o(229744);
        }
      });
    }
    AppMethodBeat.o(230095);
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
    if (this.G == null) {
      this.G = new d.f();
    }
    if ((TXCCommonUtil.equals(this.G.a, paramBitmap)) && (paramFloat1 == this.G.b) && (paramFloat2 == this.G.c) && (paramFloat3 == this.G.d) && (this.am != null))
    {
      AppMethodBeat.o(15221);
      return;
    }
    this.G.a = paramBitmap;
    this.G.b = paramFloat1;
    this.G.c = paramFloat2;
    this.G.d = paramFloat3;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229747);
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
          AppMethodBeat.o(229747);
          return;
        }
        if (c.b(c.this) == null)
        {
          if ((c.c(c.this) <= 0) || (c.d(c.this) <= 0))
          {
            TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
            AppMethodBeat.o(229747);
            return;
          }
          c.a(c.this, new x());
          c.b(c.this).a(true);
          if (!c.b(c.this).a())
          {
            TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
            c.b(c.this).d();
            c.a(c.this, null);
            AppMethodBeat.o(229747);
            return;
          }
          c.b(c.this).a(c.c(c.this), c.d(c.this));
        }
        c.b(c.this).c(true);
        c.b(c.this).a(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
        AppMethodBeat.o(229747);
      }
    });
    AppMethodBeat.o(15221);
  }
  
  void a(com.tencent.liteav.basic.c.b paramb)
  {
    AppMethodBeat.i(230042);
    TXCLog.i("TXCFilterDrawer", "set notify");
    this.aX = new WeakReference(paramb);
    if (this.an != null) {
      this.an.a((com.tencent.liteav.basic.c.b)this.aX.get());
    }
    AppMethodBeat.o(230042);
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
        AppMethodBeat.i(229740);
        c.a(c.this, paramBoolean);
        AppMethodBeat.o(229740);
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
        AppMethodBeat.i(229741);
        c.a(c.this, paramArrayOfFloat);
        AppMethodBeat.o(229741);
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
    //   2: ldc_w 1007
    //   5: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iconst_1
    //   9: istore_2
    //   10: aload_1
    //   11: getfield 802	com/tencent/liteav/beauty/d$b:j	Z
    //   14: ifne +63 -> 77
    //   17: aload_0
    //   18: getfield 933	com/tencent/liteav/beauty/c:ay	Lcom/tencent/liteav/beauty/c$a;
    //   21: ifnonnull +27 -> 48
    //   24: aload_0
    //   25: invokevirtual 1010	com/tencent/liteav/beauty/c:start	()V
    //   28: aload_0
    //   29: new 32	com/tencent/liteav/beauty/c$a
    //   32: dup
    //   33: aload_0
    //   34: aload_0
    //   35: invokevirtual 1013	com/tencent/liteav/beauty/c:getLooper	()Landroid/os/Looper;
    //   38: aload_0
    //   39: getfield 239	com/tencent/liteav/beauty/c:C	Landroid/content/Context;
    //   42: invokespecial 1016	com/tencent/liteav/beauty/c$a:<init>	(Lcom/tencent/liteav/beauty/c;Landroid/os/Looper;Landroid/content/Context;)V
    //   45: putfield 933	com/tencent/liteav/beauty/c:ay	Lcom/tencent/liteav/beauty/c$a;
    //   48: aload_0
    //   49: getfield 933	com/tencent/liteav/beauty/c:ay	Lcom/tencent/liteav/beauty/c$a;
    //   52: iconst_0
    //   53: aload_1
    //   54: invokevirtual 937	com/tencent/liteav/beauty/c$a:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   57: invokevirtual 942	android/os/Message:sendToTarget	()V
    //   60: aload_0
    //   61: getfield 933	com/tencent/liteav/beauty/c:ay	Lcom/tencent/liteav/beauty/c$a;
    //   64: invokevirtual 1017	com/tencent/liteav/beauty/c$a:b	()V
    //   67: ldc_w 1007
    //   70: invokestatic 439	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_2
    //   76: ireturn
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial 732	com/tencent/liteav/beauty/c:c	(Lcom/tencent/liteav/beauty/d$b;)Z
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
        AppMethodBeat.i(229742);
        c.a(c.this, paramInt);
        AppMethodBeat.o(229742);
      }
    });
    AppMethodBeat.o(15226);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b(d.b paramb)
  {
    AppMethodBeat.i(230060);
    if (!this.au)
    {
      if (this.ay == null)
      {
        TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
        AppMethodBeat.o(230060);
        return false;
      }
      this.ay.obtainMessage(5, 0, 0, paramb).sendToTarget();
    }
    for (;;)
    {
      AppMethodBeat.o(230060);
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
        AppMethodBeat.i(229743);
        if (paramInt > 0) {
          a.a().b();
        }
        if ((c.e(c.this) != null) && (paramInt >= 0)) {
          c.e(c.this).c(paramInt);
        }
        AppMethodBeat.o(229743);
      }
    });
    AppMethodBeat.o(15228);
  }
  
  public void d(final int paramInt)
  {
    AppMethodBeat.i(15229);
    if ((this.aA == paramInt) || (paramInt > 3) || (paramInt < 0))
    {
      AppMethodBeat.o(15229);
      return;
    }
    this.aA = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229739);
        c.a(c.this, c.f(c.this), c.g(c.this), paramInt);
        AppMethodBeat.o(229739);
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
        AppMethodBeat.i(229733);
        if (paramInt > 0) {
          a.a().c();
        }
        if ((c.e(c.this) != null) && (paramInt >= 0)) {
          c.e(c.this).d(paramInt);
        }
        AppMethodBeat.o(229733);
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
        AppMethodBeat.i(229731);
        if (paramInt > 0) {
          a.a().f();
        }
        if ((c.e(c.this) != null) && (paramInt >= 0)) {
          c.e(c.this).f(paramInt);
        }
        AppMethodBeat.o(229731);
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
        AppMethodBeat.i(229729);
        if (paramInt > 0) {
          a.a().d();
        }
        if ((c.e(c.this) != null) && (paramInt >= 0)) {
          c.e(c.this).e(paramInt);
        }
        AppMethodBeat.o(229729);
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
      AppMethodBeat.i(229728);
      TXCLog.i(this.b, "come into InitEGL");
      paramObject = (d.b)paramObject;
      a();
      c.a(c.this, new com.tencent.liteav.beauty.a.a.a());
      c.a(c.this, new com.tencent.liteav.beauty.a.a.c(c.m(c.this), paramObject.g, paramObject.f, false));
      c.n(c.this).b();
      if (!c.a(c.this, paramObject))
      {
        TXCLog.e(this.b, "initInternal failed!");
        AppMethodBeat.o(229728);
        return;
      }
      TXCLog.i(this.b, "come out InitEGL");
      AppMethodBeat.o(229728);
    }
    
    public void a()
    {
      AppMethodBeat.i(229730);
      TXCLog.i(this.b, "come into releaseEGL");
      c.o(c.this);
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
      NativeLoad.nativeDeleteYuv2Yuv();
      TXCLog.i(this.b, "come out releaseEGL");
      AppMethodBeat.o(229730);
    }
    
    /* Error */
    void b()
    {
      // Byte code:
      //   0: ldc 110
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_0
      //   8: invokevirtual 115	java/lang/Object:wait	()V
      //   11: aload_0
      //   12: monitorexit
      //   13: ldc 110
      //   15: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   18: return
      //   19: astore_1
      //   20: aload_0
      //   21: monitorexit
      //   22: ldc 110
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
      //   7	11	29	java/lang/InterruptedException
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(229735);
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
            AppMethodBeat.o(229735);
          }
          a(paramMessage.obj);
          c.b(c.this, true);
          i = 1;
          continue;
          a();
          c.p(c.this).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.c
 * JD-Core Version:    0.7.0.1
 */