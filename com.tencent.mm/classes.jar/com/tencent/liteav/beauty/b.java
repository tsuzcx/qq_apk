package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.d.i.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.j;
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
  private boolean D;
  private float[] E;
  private boolean F;
  private int G;
  private int H;
  private com.tencent.liteav.basic.d.a I;
  private Bitmap J;
  private k K;
  private o L;
  private com.tencent.liteav.beauty.b.b M;
  private com.tencent.liteav.beauty.b.a.a N;
  private com.tencent.liteav.beauty.b.b.a O;
  private com.tencent.liteav.beauty.b.c P;
  private Bitmap Q;
  private Bitmap R;
  private float S;
  private float T;
  private float U;
  private m V;
  private n W;
  private x X;
  private j Y;
  private com.tencent.liteav.beauty.b.i Z;
  boolean a;
  private int[] aA;
  private boolean aB;
  private byte[] aC;
  private int aD;
  private int aE;
  private int aF;
  private int aG;
  private d aH;
  private WeakReference<com.tencent.liteav.basic.c.a> aI;
  private i.a aJ;
  private g aa;
  private l ab;
  private h ac;
  private g ad;
  private final Queue<Runnable> ae;
  private boolean af;
  private Object ag;
  private Object ah;
  private Handler ai;
  private b.a aj;
  private float ak;
  private int al;
  private int am;
  private int an;
  private int ao;
  private int ap;
  private boolean aq;
  private com.tencent.liteav.beauty.a.a.c ar;
  private com.tencent.liteav.beauty.a.a.a as;
  private Bitmap at;
  private List<c.e> au;
  private long av;
  private int aw;
  private final int ax;
  private final float ay;
  private byte[] az;
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
  private Context m;
  private boolean n;
  private c.d o;
  private c.e p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private float y;
  private int z;
  
  b(Context paramContext, boolean paramBoolean)
  {
    super("TXCFilterDrawer");
    AppMethodBeat.i(66847);
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = null;
    this.n = true;
    this.o = new c.d();
    this.p = null;
    this.q = -1;
    this.r = -1;
    this.s = -1;
    this.t = -1;
    this.u = -1;
    this.v = -1;
    this.w = -1;
    this.x = -1;
    this.y = 1.0F;
    this.z = -1;
    this.A = -1;
    this.B = 0;
    this.C = 0;
    this.D = false;
    this.E = null;
    this.F = false;
    this.G = 0;
    this.H = 0;
    this.I = null;
    this.J = null;
    this.K = null;
    this.L = null;
    this.M = null;
    this.N = null;
    this.O = null;
    this.P = null;
    this.W = null;
    this.X = null;
    this.Y = null;
    this.Z = null;
    this.aa = null;
    this.ab = null;
    this.ac = null;
    this.ad = null;
    this.ae = new LinkedList();
    this.a = false;
    this.ag = new Object();
    this.ah = new Object();
    this.ak = 0.5F;
    this.al = 0;
    this.am = 0;
    this.an = 0;
    this.ao = 0;
    this.ap = 0;
    this.aq = false;
    this.ar = null;
    this.as = null;
    this.at = null;
    this.au = null;
    this.av = 0L;
    this.aw = 0;
    this.ax = 100;
    this.ay = 1000.0F;
    this.az = null;
    this.aA = null;
    this.aB = false;
    this.aC = null;
    this.b = null;
    this.c = null;
    this.aD = -1;
    this.aE = 0;
    this.aF = 1;
    this.aG = this.aD;
    this.aH = null;
    this.aI = new WeakReference(null);
    this.d = new com.tencent.liteav.beauty.b.a();
    this.e = new com.tencent.liteav.beauty.b.a();
    this.f = new com.tencent.liteav.beauty.b.a();
    this.aJ = new b.11(this);
    this.m = paramContext;
    this.ai = new Handler(this.m.getMainLooper());
    this.af = paramBoolean;
    AppMethodBeat.o(66847);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66849);
    if (true == this.af) {
      if (this.aH != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.az);
        this.aH.a(this.az, this.z, this.A, this.H, TXCTimeUtil.getTimeTick());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66849);
      return 0;
      if (this.aC != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aC);
        continue;
        if (3 == com.tencent.liteav.basic.d.i.a())
        {
          if (0L == this.av) {
            this.av = TXCTimeUtil.getTimeTick();
          }
          int i1 = this.aw + 1;
          this.aw = i1;
          if (i1 >= 100)
          {
            TXCLog.i("TXCFilterDrawer", "Real fps ".concat(String.valueOf(100.0F / ((float)(TXCTimeUtil.getTimeTick() - this.av) / 1000.0F))));
            this.aw = 0;
            this.av = TXCTimeUtil.getTimeTick();
          }
          GLES30.glPixelStorei(3333, 1);
          if (Build.VERSION.SDK_INT >= 18) {
            GLES30.glReadBuffer(1029);
          }
          GLES30.glBindBuffer(35051, this.aA[0]);
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
              AppMethodBeat.o(66849);
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
    AppMethodBeat.i(146399);
    if (this.H == 0) {
      if (this.aH != null)
      {
        if (paramLong != 0L) {
          break label211;
        }
        paramLong = TXCTimeUtil.getTimeTick();
      }
    }
    label211:
    for (;;)
    {
      this.aH.a(paramInt, this.z, this.A, paramLong);
      AppMethodBeat.o(146399);
      return paramInt;
      if ((1 == this.H) || (3 == this.H) || (2 == this.H))
      {
        GLES20.glViewport(0, 0, this.z, this.A);
        if (this.L == null)
        {
          TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
          AppMethodBeat.o(146399);
          return paramInt;
        }
        GLES20.glBindFramebuffer(36160, this.b[0]);
        this.L.a(paramInt);
        if (2 == this.H) {
          a(this.z, this.A);
        }
        for (;;)
        {
          GLES20.glBindFramebuffer(36160, 0);
          AppMethodBeat.o(146399);
          return paramInt;
          a(this.z, this.A * 3 / 8);
        }
      }
      TXCLog.e("TXCFilterDrawer", "Don't support format!");
      AppMethodBeat.o(146399);
      return -1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    AppMethodBeat.i(66879);
    if (this.V == null)
    {
      TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
      this.V = new m(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
      if (true == this.V.a())
      {
        this.V.a(true);
        this.V.a(paramInt1, paramInt2);
        AppMethodBeat.o(66879);
        return;
      }
      TXCLog.e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
    }
    AppMethodBeat.o(66879);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66877);
    TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
    if (paramInt3 == 0)
    {
      if (this.N == null) {
        this.N = new com.tencent.liteav.beauty.b.a.a();
      }
      this.M = this.N;
    }
    while (this.M == null)
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
      AppMethodBeat.o(66877);
      return;
      if (1 == paramInt3)
      {
        if (this.O == null) {
          this.O = new com.tencent.liteav.beauty.b.b.a();
        }
        this.M = this.O;
      }
      else if (2 == paramInt3)
      {
        if (this.P == null) {
          this.P = new com.tencent.liteav.beauty.b.c();
        }
        this.M = this.P;
      }
    }
    this.M.a(true);
    if (true == this.M.c(paramInt1, paramInt2))
    {
      if (this.am > 0) {
        this.M.c(this.am);
      }
      if (this.an > 0) {
        this.M.d(this.an);
      }
      if (this.ap > 0) {
        this.M.e(this.ap);
      }
      if (this.ao > 0)
      {
        this.M.f(this.ao);
        AppMethodBeat.o(66877);
      }
    }
    else
    {
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
    }
    AppMethodBeat.o(66877);
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    // Byte code:
    //   0: ldc_w 521
    //   3: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 254	com/tencent/liteav/beauty/b:ah	Ljava/lang/Object;
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
    //   28: ldc 138
    //   30: ldc_w 523
    //   33: iload_3
    //   34: invokestatic 526	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   37: invokevirtual 391	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 396	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 234	com/tencent/liteav/beauty/b:aa	Lcom/tencent/liteav/basic/d/g;
    //   47: ifnonnull +67 -> 114
    //   50: iload_1
    //   51: iload 4
    //   53: if_icmpne +31 -> 84
    //   56: iload_2
    //   57: iload 5
    //   59: if_icmpne +25 -> 84
    //   62: iload_3
    //   63: ifne +21 -> 84
    //   66: ldc 138
    //   68: ldc_w 528
    //   71: invokestatic 396	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 7
    //   76: monitorexit
    //   77: ldc_w 521
    //   80: invokestatic 348	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: aload_0
    //   85: new 530	com/tencent/liteav/basic/d/g
    //   88: dup
    //   89: invokespecial 531	com/tencent/liteav/basic/d/g:<init>	()V
    //   92: putfield 234	com/tencent/liteav/beauty/b:aa	Lcom/tencent/liteav/basic/d/g;
    //   95: iconst_1
    //   96: aload_0
    //   97: getfield 234	com/tencent/liteav/beauty/b:aa	Lcom/tencent/liteav/basic/d/g;
    //   100: invokevirtual 532	com/tencent/liteav/basic/d/g:a	()Z
    //   103: if_icmpne +49 -> 152
    //   106: aload_0
    //   107: getfield 234	com/tencent/liteav/beauty/b:aa	Lcom/tencent/liteav/basic/d/g;
    //   110: iconst_1
    //   111: invokevirtual 533	com/tencent/liteav/basic/d/g:a	(Z)V
    //   114: aload_0
    //   115: getfield 234	com/tencent/liteav/beauty/b:aa	Lcom/tencent/liteav/basic/d/g;
    //   118: iload 4
    //   120: iload 5
    //   122: invokevirtual 534	com/tencent/liteav/basic/d/g:a	(II)V
    //   125: aload_0
    //   126: getfield 234	com/tencent/liteav/beauty/b:aa	Lcom/tencent/liteav/basic/d/g;
    //   129: sipush 720
    //   132: iload_3
    //   133: isub
    //   134: sipush 360
    //   137: irem
    //   138: aconst_null
    //   139: invokevirtual 537	com/tencent/liteav/basic/d/g:a	(ILjava/nio/FloatBuffer;)V
    //   142: aload 7
    //   144: monitorexit
    //   145: ldc_w 521
    //   148: invokestatic 348	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: ldc 138
    //   154: ldc_w 539
    //   157: invokestatic 424	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -46 -> 114
    //   163: astore 8
    //   165: aload 7
    //   167: monitorexit
    //   168: ldc_w 521
    //   171: invokestatic 348	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(146397);
    if (this.ab == null)
    {
      TXCLog.i("TXCFilterDrawer", "Create CropFilter");
      if (4 == paramInt6)
      {
        this.ab = new l("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
        if (true != this.ab.a()) {
          break label188;
        }
        this.ab.a(true);
      }
    }
    else
    {
      label64:
      this.ab.a(paramInt3, paramInt4);
      parama = this.ab.a(this.q, this.r, null, parama, paramInt6);
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
      this.ab.a(paramInt1, paramInt2, paramInt6, parama, paramInt5 / paramInt4, paramBoolean, false);
      AppMethodBeat.o(146397);
      return;
      this.ab = new l();
      break;
      TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
      break label64;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(66881);
    synchronized (this.ae)
    {
      this.ae.add(paramRunnable);
      AppMethodBeat.o(66881);
      return;
    }
  }
  
  private void a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(66882);
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
        AppMethodBeat.o(66882);
      }
    }
    AppMethodBeat.o(66882);
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(66861);
    if (!paramBoolean)
    {
      if (this.aH != null)
      {
        this.aH.a(paramArrayOfByte, this.z, this.A, this.H, TXCTimeUtil.getTimeTick());
        AppMethodBeat.o(66861);
        return;
      }
      TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
      AppMethodBeat.o(66861);
      return;
    }
    int i1 = this.A * 3 / 8;
    if (2 == this.H) {
      i1 = this.A;
    }
    if (this.aH != null)
    {
      NativeLoad.getInstance();
      if (true == NativeLoad.nativeGlReadPixsFromQueue(this.z, i1, this.az))
      {
        this.aH.a(this.az, this.z, this.A, this.H, TXCTimeUtil.getTimeTick());
        AppMethodBeat.o(66861);
        return;
      }
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
      this.aH.a(paramArrayOfByte, this.z, this.A, this.H, TXCTimeUtil.getTimeTick());
      AppMethodBeat.o(66861);
      return;
    }
    NativeLoad.getInstance();
    if (!NativeLoad.nativeGlReadPixsFromQueue(this.z, i1, this.aC)) {
      TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
    }
    AppMethodBeat.o(66861);
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66868);
    GLES20.glGenFramebuffers(1, paramArrayOfInt1, 0);
    paramArrayOfInt2[0] = com.tencent.liteav.basic.d.i.a(paramInt1, paramInt2, 6408, 6408, paramArrayOfInt2);
    GLES20.glBindFramebuffer(36160, paramArrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramArrayOfInt2[0], 0);
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(66868);
  }
  
  private void b()
  {
    AppMethodBeat.i(66865);
    TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
    this.aB = false;
    if (this.K != null)
    {
      this.K.d();
      this.K = null;
    }
    if (this.L != null)
    {
      this.L.d();
      this.L = null;
    }
    c();
    if (this.V != null)
    {
      this.V.d();
      this.V = null;
    }
    if (this.W != null)
    {
      this.W.a();
      this.W = null;
    }
    if (this.ac != null)
    {
      this.ac.d();
      this.ac = null;
    }
    if (this.ab != null)
    {
      this.ab.d();
      this.ab = null;
    }
    if (this.aa != null)
    {
      this.aa.d();
      this.aa = null;
    }
    if (this.X != null)
    {
      this.X.d();
      this.X = null;
    }
    if (this.Y != null)
    {
      this.Y.a();
      this.Y = null;
    }
    if (this.Z != null)
    {
      this.Z.d();
      this.Z = null;
    }
    if (this.ad != null)
    {
      this.ad.d();
      this.ad = null;
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
    this.p = null;
    TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
    AppMethodBeat.o(66865);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146400);
    if (this.ad == null)
    {
      TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
      this.ad = new g();
      if (true != this.ad.a()) {
        break label74;
      }
      this.ad.a(true);
    }
    for (;;)
    {
      if (this.ad != null) {
        this.ad.a(paramInt1, paramInt2);
      }
      AppMethodBeat.o(146400);
      return;
      label74:
      TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66863);
    if (this.K == null)
    {
      TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
      AppMethodBeat.o(66863);
      return;
    }
    this.K.a(paramArrayOfByte);
    AppMethodBeat.o(66863);
  }
  
  private void c()
  {
    AppMethodBeat.i(66878);
    if (this.N != null)
    {
      this.N.d();
      this.N = null;
    }
    if (this.O != null)
    {
      this.O.d();
      this.O = null;
    }
    if (this.P != null)
    {
      this.P.d();
      this.P = null;
    }
    this.M = null;
    AppMethodBeat.o(66878);
  }
  
  private boolean c(c.b paramb)
  {
    AppMethodBeat.i(66866);
    TXCLog.i("TXCFilterDrawer", "come into initInternal");
    b();
    this.af = paramb.j;
    this.q = paramb.d;
    this.r = paramb.e;
    this.I = paramb.m;
    this.s = paramb.g;
    this.t = paramb.f;
    this.B = paramb.h;
    this.D = paramb.i;
    this.z = paramb.b;
    this.A = paramb.c;
    this.C = paramb.a;
    this.u = paramb.g;
    this.v = paramb.f;
    if ((this.B == 90) || (this.B == 270))
    {
      this.u = paramb.f;
      this.v = paramb.g;
    }
    this.H = paramb.l;
    this.G = paramb.k;
    this.az = new byte[this.z * this.A * 4];
    TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is " + this.y);
    int i1;
    if (this.y != 1.0F)
    {
      if (this.u >= this.v) {
        break label607;
      }
      i1 = this.u;
      if (i1 > 368) {
        this.y = (432.0F / i1);
      }
      if (this.y > 1.0F) {
        this.y = 1.0F;
      }
    }
    this.w = ((int)(this.u * this.y));
    this.x = ((int)(this.v * this.y));
    a(this.w, this.x, this.al);
    if ((this.p != null) && (this.p.a != null) && (this.X == null))
    {
      TXCLog.i("TXCFilterDrawer", "reset water mark!");
      a(this.p.a, this.p.b, this.p.c, this.p.d);
    }
    if (((this.Q != null) || (this.R != null)) && (this.V == null)) {
      a(this.w, this.x, this.S, this.Q, this.T, this.R, this.U);
    }
    a(this.I, this.s, this.t, this.w, this.x, this.D, this.B, this.G);
    a(this.u, this.v, this.B, this.z, this.A, this.C);
    if (this.b == null)
    {
      this.b = new int[1];
      label512:
      if (this.c != null) {
        break label627;
      }
      this.c = new int[1];
      label526:
      a(this.b, this.c, this.z, this.A);
      if (3 == com.tencent.liteav.basic.d.i.a())
      {
        if (this.aA != null) {
          break label639;
        }
        this.aA = new int[1];
      }
    }
    for (;;)
    {
      TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
      com.tencent.liteav.basic.d.i.a(this.s, this.t, this.aA);
      TXCLog.i("TXCFilterDrawer", "come out initInternal");
      AppMethodBeat.o(66866);
      return true;
      label607:
      i1 = this.v;
      break;
      GLES20.glDeleteFramebuffers(1, this.b, 0);
      break label512;
      label627:
      GLES20.glDeleteTextures(1, this.c, 0);
      break label526;
      label639:
      TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
      GLES30.glDeleteBuffers(1, this.aA, 0);
    }
  }
  
  private boolean d(c.b paramb)
  {
    AppMethodBeat.i(66869);
    if (((1 == paramb.k) || (3 == paramb.k) || (2 == paramb.k)) && (this.K == null))
    {
      this.K = new k(paramb.k);
      this.K.a(true);
      if (!this.K.a())
      {
        TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
        AppMethodBeat.o(66869);
        return false;
      }
      this.K.a(paramb.d, paramb.e);
    }
    if (((1 == paramb.l) || (3 == paramb.l) || (2 == paramb.l)) && (this.L == null))
    {
      this.L = new o(paramb.l);
      if (!this.L.a())
      {
        TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
        AppMethodBeat.o(66869);
        return false;
      }
      this.L.a(paramb.b, paramb.c);
    }
    AppMethodBeat.o(66869);
    return true;
  }
  
  private int m(int paramInt)
  {
    AppMethodBeat.i(66858);
    GLES20.glViewport(0, 0, this.q, this.r);
    paramInt = a(this.K.q(), paramInt, 0L);
    AppMethodBeat.o(66858);
    return paramInt;
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(146395);
    a(this.ae);
    int i1;
    if (this.y != 1.0F)
    {
      i1 = 1;
      GLES20.glViewport(0, 0, this.w, this.x);
      int i2 = paramInt1;
      if (this.ab != null)
      {
        if ((4 == paramInt2) || (true == this.F))
        {
          this.ab.a(this.E);
          this.ab.c(this.F);
        }
        i2 = this.ab.b(paramInt1);
      }
      paramInt2 = i2;
      if (this.M != null) {
        if ((this.am <= 0) && (this.an <= 0))
        {
          paramInt2 = i2;
          if (this.ap <= 0) {}
        }
        else
        {
          paramInt2 = this.M.b(i2);
        }
      }
      paramInt1 = paramInt2;
      if (this.V != null) {
        paramInt1 = this.V.b(paramInt2);
      }
      GLES20.glViewport(0, 0, this.u, this.v);
      paramInt2 = paramInt1;
      if (this.Y != null)
      {
        paramInt2 = this.Y.a(paramInt1);
        i1 = 0;
      }
      if (this.Z == null) {
        break label382;
      }
      paramInt1 = this.Z.b(paramInt2);
      i1 = 0;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        b(this.u, this.v);
        if (this.ad != null) {
          GLES20.glViewport(0, 0, this.u, this.v);
        }
      }
      for (paramInt2 = this.ad.b(paramInt1);; paramInt2 = paramInt1)
      {
        paramInt1 = paramInt2;
        if (this.aH != null)
        {
          i1 = this.aH.a(paramInt2, this.u, this.v);
          paramInt1 = paramInt2;
          if (i1 > 0) {
            paramInt1 = i1;
          }
        }
        GLES20.glViewport(0, 0, this.u, this.v);
        paramInt2 = paramInt1;
        if (this.X != null) {
          paramInt2 = this.X.b(paramInt1);
        }
        paramInt1 = paramInt2;
        if (this.aa != null)
        {
          GLES20.glViewport(0, 0, this.z, this.A);
          paramInt1 = this.aa.b(paramInt2);
        }
        a(paramInt1, paramLong);
        AppMethodBeat.o(146395);
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
    AppMethodBeat.i(66850);
    a(paramArrayOfByte);
    if (!this.af)
    {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
      this.aj.obtainMessage(2, paramArrayOfByte).sendToTarget();
      if (!this.aB)
      {
        TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
        NativeLoad.getInstance();
        NativeLoad.nativeClearQueue();
      }
      this.aj.obtainMessage(3, paramInt, 0).sendToTarget();
      a(paramArrayOfByte, this.aB);
      this.aB = true;
    }
    for (paramInt = -1;; paramInt = m(paramInt))
    {
      AppMethodBeat.o(66850);
      return paramInt;
      b(paramArrayOfByte);
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(66864);
    if (!this.af)
    {
      if (this.aj == null) {
        break label57;
      }
      this.aj.obtainMessage(1).sendToTarget();
      try
      {
        this.d.b();
        AppMethodBeat.o(66864);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        AppMethodBeat.o(66864);
        return;
      }
    }
    b();
    label57:
    AppMethodBeat.o(66864);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(66851);
    this.ak = paramFloat;
    a(new b.1(this, paramFloat));
    AppMethodBeat.o(66851);
  }
  
  public void a(float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    AppMethodBeat.i(66876);
    if ((this.Q != paramBitmap1) || (this.R != paramBitmap2))
    {
      this.Q = paramBitmap1;
      this.R = paramBitmap2;
      this.S = paramFloat1;
      this.T = paramFloat2;
      this.U = paramFloat3;
      a(new b.5(this, paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3));
      AppMethodBeat.o(66876);
      return;
    }
    if ((this.V != null) && ((this.S != paramFloat1) || (this.T != paramFloat2) || (this.U != paramFloat3)))
    {
      this.S = paramFloat1;
      this.T = paramFloat2;
      this.U = paramFloat3;
      a(new b.6(this, paramFloat1, paramFloat2, paramFloat3));
    }
    AppMethodBeat.o(66876);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(66860);
    a(new b.10(this, paramInt));
    AppMethodBeat.o(66860);
  }
  
  public void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(66875);
    a(1.0F, paramBitmap, this.ak, null, 0.0F);
    AppMethodBeat.o(66875);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(66855);
    if (this.p == null) {
      this.p = new c.e();
    }
    if ((this.p.a != null) && (paramBitmap != null) && (true == this.p.a.equals(paramBitmap)) && (paramFloat1 == this.p.b) && (paramFloat2 == this.p.c) && (paramFloat3 == this.p.d))
    {
      AppMethodBeat.o(66855);
      return;
    }
    this.p.a = paramBitmap;
    this.p.b = paramFloat1;
    this.p.c = paramFloat2;
    this.p.d = paramFloat3;
    a(new b.9(this, paramBitmap, paramFloat1, paramFloat2, paramFloat3));
    AppMethodBeat.o(66855);
  }
  
  void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(146398);
    TXCLog.i("TXCFilterDrawer", "set notify");
    this.aI = new WeakReference(parama);
    if (this.Y != null) {
      this.Y.a((com.tencent.liteav.basic.c.a)this.aI.get());
    }
    AppMethodBeat.o(146398);
  }
  
  void a(d paramd)
  {
    AppMethodBeat.i(66856);
    TXCLog.i("TXCFilterDrawer", "set listener");
    this.aH = paramd;
    AppMethodBeat.o(66856);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(146396);
    a(new b.8(this, paramBoolean));
    AppMethodBeat.o(146396);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aC = paramArrayOfByte;
  }
  
  public void a(final float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(66852);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(66827);
        b.a(b.this, paramArrayOfFloat);
        AppMethodBeat.o(66827);
      }
    });
    AppMethodBeat.o(66852);
  }
  
  /* Error */
  public boolean a(c.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 933
    //   5: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iconst_1
    //   9: istore_2
    //   10: aload_1
    //   11: getfield 707	com/tencent/liteav/beauty/c$b:j	Z
    //   14: ifne +63 -> 77
    //   17: aload_0
    //   18: getfield 840	com/tencent/liteav/beauty/b:aj	Lcom/tencent/liteav/beauty/b$a;
    //   21: ifnonnull +27 -> 48
    //   24: aload_0
    //   25: invokevirtual 936	com/tencent/liteav/beauty/b:start	()V
    //   28: aload_0
    //   29: new 10	com/tencent/liteav/beauty/b$a
    //   32: dup
    //   33: aload_0
    //   34: aload_0
    //   35: invokevirtual 939	com/tencent/liteav/beauty/b:getLooper	()Landroid/os/Looper;
    //   38: aload_0
    //   39: getfield 161	com/tencent/liteav/beauty/b:m	Landroid/content/Context;
    //   42: invokespecial 942	com/tencent/liteav/beauty/b$a:<init>	(Lcom/tencent/liteav/beauty/b;Landroid/os/Looper;Landroid/content/Context;)V
    //   45: putfield 840	com/tencent/liteav/beauty/b:aj	Lcom/tencent/liteav/beauty/b$a;
    //   48: aload_0
    //   49: getfield 840	com/tencent/liteav/beauty/b:aj	Lcom/tencent/liteav/beauty/b$a;
    //   52: iconst_0
    //   53: aload_1
    //   54: invokevirtual 844	com/tencent/liteav/beauty/b$a:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   57: invokevirtual 849	android/os/Message:sendToTarget	()V
    //   60: aload_0
    //   61: getfield 840	com/tencent/liteav/beauty/b:aj	Lcom/tencent/liteav/beauty/b$a;
    //   64: invokevirtual 943	com/tencent/liteav/beauty/b$a:b	()V
    //   67: ldc_w 933
    //   70: invokestatic 348	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_2
    //   76: ireturn
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial 636	com/tencent/liteav/beauty/b:c	(Lcom/tencent/liteav/beauty/c$b;)Z
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
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(66870);
    this.am = paramInt;
    a(new b.12(this, paramInt));
    AppMethodBeat.o(66870);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b(c.b paramb)
  {
    AppMethodBeat.i(66867);
    if (!this.af)
    {
      if (this.aj == null)
      {
        TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
        AppMethodBeat.o(66867);
        return false;
      }
      this.aj.obtainMessage(5, 0, 0, paramb).sendToTarget();
    }
    for (;;)
    {
      AppMethodBeat.o(66867);
      return true;
      d(paramb);
    }
  }
  
  public void c(final int paramInt)
  {
    AppMethodBeat.i(66871);
    if ((this.al == paramInt) || (paramInt > 2) || (paramInt < 0))
    {
      AppMethodBeat.o(66871);
      return;
    }
    this.al = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(146331);
        b.a(b.this, b.f(b.this), b.g(b.this), paramInt);
        AppMethodBeat.o(146331);
      }
    });
    AppMethodBeat.o(66871);
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(66872);
    this.an = paramInt;
    a(new b.2(this, paramInt));
    AppMethodBeat.o(66872);
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(66873);
    this.ao = paramInt;
    a(new b.3(this, paramInt));
    AppMethodBeat.o(66873);
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(66874);
    this.ap = paramInt;
    a(new b.4(this, paramInt));
    AppMethodBeat.o(66874);
  }
  
  public void g(int paramInt) {}
  
  public void h(int paramInt) {}
  
  public void i(int paramInt) {}
  
  public void j(int paramInt) {}
  
  public void k(int paramInt) {}
  
  public void l(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.beauty.b
 * JD-Core Version:    0.7.0.1
 */