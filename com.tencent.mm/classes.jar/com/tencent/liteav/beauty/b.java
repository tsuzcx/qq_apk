package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.f.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.i;
import com.tencent.liteav.beauty.b.j;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.b.n;
import com.tencent.liteav.beauty.b.v;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class b
  extends HandlerThread
{
  private int A = 0;
  private int B = 0;
  private boolean C = false;
  private float[] D;
  private int E = 0;
  private int F = 0;
  private com.tencent.liteav.basic.d.a G = null;
  private Bitmap H = null;
  private k I = null;
  private n J = null;
  private com.tencent.liteav.beauty.b.b K = null;
  private com.tencent.liteav.beauty.b.a.a L = null;
  private com.tencent.liteav.beauty.b.b.a M = null;
  private com.tencent.liteav.beauty.b.c N = null;
  private Bitmap O;
  private Bitmap P;
  private float Q;
  private float R;
  private float S;
  private l T;
  private m U = null;
  private v V = null;
  private j W = null;
  private i X = null;
  private com.tencent.liteav.basic.d.d Y = null;
  private com.tencent.liteav.basic.d.d Z = null;
  boolean a = false;
  private byte[] aA = null;
  private int aB = -1;
  private int aC = 0;
  private int aD = 1;
  private int aE = this.aB;
  private d aF = null;
  private WeakReference<com.tencent.liteav.basic.c.a> aG = new WeakReference(null);
  private f.a aH = new b.9(this);
  private e aa = null;
  private com.tencent.liteav.basic.d.d ab = null;
  private final Queue<Runnable> ac = new LinkedList();
  private boolean ad;
  private Object ae = new Object();
  private Object af = new Object();
  private Handler ag;
  private b.a ah;
  private float ai = 0.5F;
  private int aj = 0;
  private int ak = 0;
  private int al = 0;
  private int am = 0;
  private int an = 0;
  private boolean ao = false;
  private com.tencent.liteav.beauty.a.a.c ap = null;
  private com.tencent.liteav.beauty.a.a.a aq = null;
  private Bitmap ar = null;
  private List<c.d> as = null;
  private long at = 0L;
  private int au = 0;
  private final int av = 100;
  private final float aw = 1000.0F;
  private byte[] ax = null;
  private int[] ay = null;
  private boolean az = false;
  protected int[] b = null;
  protected int[] c = null;
  com.tencent.liteav.beauty.b.a d = new com.tencent.liteav.beauty.b.a();
  com.tencent.liteav.beauty.b.a e = new com.tencent.liteav.beauty.b.a();
  com.tencent.liteav.beauty.b.a f = new com.tencent.liteav.beauty.b.a();
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private Context m = null;
  private boolean n = true;
  private c.d o = null;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private float x = 1.0F;
  private int y = -1;
  private int z = -1;
  
  b(Context paramContext, boolean paramBoolean)
  {
    super("TXCFilterDrawer");
    this.m = paramContext;
    this.ag = new Handler(this.m.getMainLooper());
    this.ad = paramBoolean;
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    if (this.T == null)
    {
      TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
      this.T = new l(paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3);
      if (true == this.T.a())
      {
        this.T.a(true);
        this.T.a(paramInt1, paramInt2);
      }
    }
    else
    {
      return;
    }
    TXCLog.e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
    if (paramInt3 == 0)
    {
      if (this.L == null) {
        this.L = new com.tencent.liteav.beauty.b.a.a();
      }
      this.K = this.L;
      if (this.K != null) {
        break label122;
      }
      TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
    }
    label122:
    do
    {
      return;
      if (1 == paramInt3)
      {
        if (this.M == null) {
          this.M = new com.tencent.liteav.beauty.b.b.a();
        }
        this.K = this.M;
        break;
      }
      if (2 != paramInt3) {
        break;
      }
      if (this.N == null) {
        this.N = new com.tencent.liteav.beauty.b.c();
      }
      this.K = this.N;
      break;
      this.K.a(true);
      if (true != this.K.b(paramInt1, paramInt2)) {
        break label216;
      }
      if (this.ak > 0) {
        this.K.c(this.ak);
      }
      if (this.al > 0) {
        this.K.d(this.al);
      }
      if (this.an > 0) {
        this.K.e(this.an);
      }
    } while (this.am <= 0);
    this.K.f(this.am);
    return;
    label216:
    TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Object localObject1 = this.af;
    paramInt3 = (paramInt6 - paramInt3 + 360) % 360;
    for (;;)
    {
      try
      {
        TXCLog.i("TXCFilterDrawer", "real outputAngle " + paramInt3);
        if (this.Y == null)
        {
          if ((paramInt1 == paramInt4) && (paramInt2 == paramInt5) && (paramInt3 == 0))
          {
            TXCLog.i("TXCFilterDrawer", "Don't need change output Image, don't create out filter!");
            return;
          }
          this.Y = new com.tencent.liteav.basic.d.d();
          if (true == this.Y.a()) {
            this.Y.a(true);
          }
        }
        else
        {
          this.Y.a(paramInt4, paramInt5);
          this.Y.a((720 - paramInt3) % 360, null);
          return;
        }
      }
      finally {}
      TXCLog.e("TXCFilterDrawer", "mOutputZoomFilter init failed!");
    }
  }
  
  private void a(com.tencent.liteav.basic.d.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    if (this.Z == null)
    {
      TXCLog.i("TXCFilterDrawer", "Create CropFilter");
      if (4 == paramInt6)
      {
        this.Z = new com.tencent.liteav.basic.d.d("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
        if (true != this.Z.a()) {
          break label176;
        }
        this.Z.a(true);
      }
    }
    else
    {
      label58:
      this.Z.a(paramInt3, paramInt4);
      parama = this.Z.a(this.p, this.q, null, parama, paramInt6);
      paramInt6 = (720 - paramInt5) % 360;
      if ((paramInt6 != 90) && (paramInt6 != 270)) {
        break label187;
      }
    }
    label176:
    label187:
    for (paramInt5 = paramInt4;; paramInt5 = paramInt3)
    {
      if ((paramInt6 == 90) || (paramInt6 == 270)) {
        paramInt4 = paramInt3;
      }
      this.Z.a(paramInt1, paramInt2, paramInt6, parama, paramInt5 / paramInt4, paramBoolean, false);
      return;
      this.Z = new com.tencent.liteav.basic.d.d();
      break;
      TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
      break label58;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.ac)
    {
      this.ac.add(paramRunnable);
      return;
    }
  }
  
  private void a(Queue<Runnable> paramQueue)
  {
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
      finally {}
    }
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.aF != null) {
        this.aF.a(paramArrayOfByte, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
      }
    }
    int i1;
    do
    {
      return;
      TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
      return;
      i1 = this.z * 3 / 8;
      if (2 == this.F) {
        i1 = this.z;
      }
      if (this.aF != null)
      {
        NativeLoad.getInstance();
        if (true == NativeLoad.nativeGlReadPixsFromQueue(this.y, i1, this.ax))
        {
          this.aF.a(this.ax, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
          return;
        }
        TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
        this.aF.a(paramArrayOfByte, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
        return;
      }
      NativeLoad.getInstance();
    } while (NativeLoad.nativeGlReadPixsFromQueue(this.y, i1, this.aA));
    TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    GLES20.glGenFramebuffers(1, paramArrayOfInt1, 0);
    paramArrayOfInt2[0] = f.a(paramInt1, paramInt2, 6408, 6408, paramArrayOfInt2);
    GLES20.glBindFramebuffer(36160, paramArrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramArrayOfInt2[0], 0);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    if (true == this.ad) {
      if (this.aF != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.ax);
        this.aF.a(this.ax, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
      }
    }
    for (;;)
    {
      return 0;
      if (this.aA != null)
      {
        NativeLoad.getInstance();
        NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, this.aA);
        continue;
        if (3 == f.a())
        {
          if (0L == this.at) {
            this.at = TXCTimeUtil.getTimeTick();
          }
          int i1 = this.au + 1;
          this.au = i1;
          if (i1 >= 100)
          {
            float f1 = 100.0F / ((float)(TXCTimeUtil.getTimeTick() - this.at) / 1000.0F);
            TXCLog.i("TXCFilterDrawer", "Real fps " + f1);
            this.au = 0;
            this.at = TXCTimeUtil.getTimeTick();
          }
          GLES30.glPixelStorei(3333, 1);
          if (Build.VERSION.SDK_INT >= 18) {
            GLES30.glReadBuffer(1029);
          }
          GLES30.glBindBuffer(35051, this.ay[0]);
          NativeLoad.getInstance();
          NativeLoad.nativeGlReadPixs(paramInt1, paramInt2, null);
          if (Build.VERSION.SDK_INT >= 18)
          {
            ByteBuffer localByteBuffer = (ByteBuffer)GLES30.glMapBufferRange(35051, 0, paramInt1 * paramInt2 * 4, 1);
            localObject = localByteBuffer;
            if (localByteBuffer == null)
            {
              TXCLog.e("TXCFilterDrawer", "glMapBufferRange is null");
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
  
  private void b()
  {
    TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
    this.az = false;
    if (this.I != null)
    {
      this.I.d();
      this.I = null;
    }
    if (this.J != null)
    {
      this.J.d();
      this.J = null;
    }
    c();
    if (this.T != null)
    {
      this.T.d();
      this.T = null;
    }
    if (this.U != null)
    {
      this.U.a();
      this.U = null;
    }
    if (this.aa != null)
    {
      this.aa.d();
      this.aa = null;
    }
    if (this.Z != null)
    {
      this.Z.d();
      this.Z = null;
    }
    if (this.Y != null)
    {
      this.Y.d();
      this.Y = null;
    }
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
    if (this.X != null)
    {
      this.X.d();
      this.X = null;
    }
    if (this.ab != null)
    {
      this.ab.d();
      this.ab = null;
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
    this.o = null;
    TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    if (this.I == null)
    {
      TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
      return;
    }
    this.I.a(paramArrayOfByte);
  }
  
  private void c()
  {
    if (this.L != null)
    {
      this.L.d();
      this.L = null;
    }
    if (this.M != null)
    {
      this.M.d();
      this.M = null;
    }
    if (this.N != null)
    {
      this.N.d();
      this.N = null;
    }
    this.K = null;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.ab == null)
    {
      TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
      this.ab = new com.tencent.liteav.basic.d.d();
      if (true != this.ab.a()) {
        break label62;
      }
      this.ab.a(true);
    }
    for (;;)
    {
      if (this.ab != null) {
        this.ab.a(paramInt1, paramInt2);
      }
      return;
      label62:
      TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
    }
  }
  
  private boolean c(c.b paramb)
  {
    TXCLog.i("TXCFilterDrawer", "come into initInternal");
    b();
    this.ad = paramb.j;
    this.p = paramb.d;
    this.q = paramb.e;
    this.G = paramb.m;
    this.r = paramb.g;
    this.s = paramb.f;
    this.A = paramb.h;
    this.C = paramb.i;
    this.y = paramb.b;
    this.z = paramb.c;
    this.B = paramb.a;
    this.t = paramb.g;
    this.u = paramb.f;
    if ((this.A == 90) || (this.A == 270))
    {
      this.t = paramb.f;
      this.u = paramb.g;
    }
    this.F = paramb.l;
    this.E = paramb.k;
    this.ax = new byte[this.y * this.z * 4];
    TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is " + this.x);
    int i1;
    if (this.x != 1.0F)
    {
      if (this.t >= this.u) {
        break label595;
      }
      i1 = this.t;
      if (i1 > 368) {
        this.x = (432.0F / i1);
      }
      if (this.x > 1.0F) {
        this.x = 1.0F;
      }
    }
    this.v = ((int)(this.t * this.x));
    this.w = ((int)(this.u * this.x));
    a(this.v, this.w, this.aj);
    if ((this.o != null) && (this.o.a != null) && (this.V == null))
    {
      TXCLog.i("TXCFilterDrawer", "reset water mark!");
      a(this.o.a, this.o.b, this.o.c, this.o.d);
    }
    if (((this.O != null) || (this.P != null)) && (this.T == null)) {
      a(this.v, this.w, this.Q, this.O, this.R, this.P, this.S);
    }
    a(this.G, this.r, this.s, this.v, this.w, this.C, this.A, this.E);
    a(this.t, this.u, this.A, this.y, this.z, this.B);
    if (this.b == null)
    {
      this.b = new int[1];
      label506:
      if (this.c != null) {
        break label615;
      }
      this.c = new int[1];
      label520:
      a(this.b, this.c, this.y, this.z);
      if (3 == f.a())
      {
        if (this.ay != null) {
          break label627;
        }
        this.ay = new int[1];
      }
    }
    for (;;)
    {
      TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
      f.a(this.r, this.s, this.ay);
      TXCLog.i("TXCFilterDrawer", "come out initInternal");
      return true;
      label595:
      i1 = this.u;
      break;
      GLES20.glDeleteFramebuffers(1, this.b, 0);
      break label506;
      label615:
      GLES20.glDeleteTextures(1, this.c, 0);
      break label520;
      label627:
      TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
      GLES30.glDeleteBuffers(1, this.ay, 0);
    }
  }
  
  private boolean d(c.b paramb)
  {
    if (((1 == paramb.k) || (3 == paramb.k) || (2 == paramb.k)) && (this.I == null))
    {
      this.I = new k(paramb.k);
      this.I.a(true);
      if (!this.I.a())
      {
        TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
        return false;
      }
      this.I.a(paramb.d, paramb.e);
    }
    if (((1 == paramb.l) || (3 == paramb.l) || (2 == paramb.l)) && (this.J == null))
    {
      this.J = new n(paramb.l);
      if (!this.J.a())
      {
        TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
        return false;
      }
      this.J.a(paramb.b, paramb.c);
    }
    return true;
  }
  
  private int m(int paramInt)
  {
    if (this.F == 0)
    {
      if (this.aF != null) {
        this.aF.a(paramInt, this.y, this.z, TXCTimeUtil.getTimeTick());
      }
      return paramInt;
    }
    if ((1 == this.F) || (3 == this.F) || (2 == this.F))
    {
      GLES20.glViewport(0, 0, this.y, this.z);
      if (this.J == null)
      {
        TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
        return paramInt;
      }
      GLES20.glBindFramebuffer(36160, this.b[0]);
      this.J.a(paramInt);
      if (2 == this.F) {
        b(this.y, this.z);
      }
      for (;;)
      {
        GLES20.glBindFramebuffer(36160, 0);
        return paramInt;
        b(this.y, this.z * 3 / 8);
      }
    }
    TXCLog.e("TXCFilterDrawer", "Don't support format!");
    return -1;
  }
  
  private int n(int paramInt)
  {
    GLES20.glViewport(0, 0, this.p, this.q);
    return a(this.I.q(), paramInt);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    a(this.ac);
    int i1;
    if (this.x != 1.0F)
    {
      i1 = 1;
      GLES20.glViewport(0, 0, this.v, this.w);
      int i2 = paramInt1;
      if (this.Z != null)
      {
        if (4 == paramInt2) {
          this.Z.a(this.D);
        }
        i2 = this.Z.b(paramInt1);
      }
      paramInt2 = i2;
      if (this.K != null) {
        if ((this.ak <= 0) && (this.al <= 0))
        {
          paramInt2 = i2;
          if (this.an <= 0) {}
        }
        else
        {
          paramInt2 = this.K.b(i2);
        }
      }
      paramInt1 = paramInt2;
      if (this.T != null) {
        paramInt1 = this.T.b(paramInt2);
      }
      GLES20.glViewport(0, 0, this.t, this.u);
      paramInt2 = paramInt1;
      if (this.W != null)
      {
        paramInt2 = this.W.a(paramInt1);
        i1 = 0;
      }
      if (this.X == null) {
        break label342;
      }
      paramInt1 = this.X.b(paramInt2);
      i1 = 0;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        c(this.t, this.u);
        if (this.ab != null) {
          GLES20.glViewport(0, 0, this.t, this.u);
        }
      }
      for (paramInt2 = this.ab.b(paramInt1);; paramInt2 = paramInt1)
      {
        paramInt1 = paramInt2;
        if (this.aF != null)
        {
          i1 = this.aF.a(paramInt2, this.t, this.u);
          paramInt1 = paramInt2;
          if (i1 > 0) {
            paramInt1 = i1;
          }
        }
        GLES20.glViewport(0, 0, this.t, this.u);
        paramInt2 = paramInt1;
        if (this.V != null) {
          paramInt2 = this.V.b(paramInt1);
        }
        paramInt1 = paramInt2;
        if (this.Y != null)
        {
          GLES20.glViewport(0, 0, this.y, this.z);
          paramInt1 = this.Y.b(paramInt2);
        }
        m(paramInt1);
        return paramInt1;
        i1 = 0;
        break;
      }
      label342:
      paramInt1 = paramInt2;
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte);
    if (!this.ad)
    {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
      this.ah.obtainMessage(2, paramArrayOfByte).sendToTarget();
      if (!this.az)
      {
        TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
        NativeLoad.getInstance();
        NativeLoad.nativeClearQueue();
      }
      this.ah.obtainMessage(3, paramInt, 0).sendToTarget();
      a(paramArrayOfByte, this.az);
      this.az = true;
      return -1;
    }
    b(paramArrayOfByte);
    return n(paramInt);
  }
  
  public void a()
  {
    if (!this.ad) {
      if (this.ah != null) {
        this.ah.obtainMessage(1).sendToTarget();
      }
    }
    try
    {
      this.d.b();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
    b();
    return;
  }
  
  public void a(float paramFloat)
  {
    this.ai = paramFloat;
    a(new b.1(this, paramFloat));
  }
  
  public void a(float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    if ((this.O != paramBitmap1) || (this.P != paramBitmap2))
    {
      this.O = paramBitmap1;
      this.P = paramBitmap2;
      this.Q = paramFloat1;
      this.R = paramFloat2;
      this.S = paramFloat3;
      a(new b.4(this, paramFloat1, paramBitmap1, paramFloat2, paramBitmap2, paramFloat3));
    }
    while ((this.T == null) || ((this.Q == paramFloat1) && (this.R == paramFloat2) && (this.S == paramFloat3))) {
      return;
    }
    this.Q = paramFloat1;
    this.R = paramFloat2;
    this.S = paramFloat3;
    a(new b.5(this, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public void a(int paramInt)
  {
    a(new b.8(this, paramInt));
  }
  
  public void a(Bitmap paramBitmap)
  {
    a(1.0F, paramBitmap, this.ai, null, 0.0F);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.o == null) {
      this.o = new c.d();
    }
    if ((this.o.a != null) && (paramBitmap != null) && (true == this.o.a.equals(paramBitmap)) && (paramFloat1 == this.o.b) && (paramFloat2 == this.o.c) && (paramFloat3 == this.o.d)) {
      return;
    }
    this.o.a = paramBitmap;
    this.o.b = paramFloat1;
    this.o.c = paramFloat2;
    this.o.d = paramFloat3;
    a(new b.7(this, paramBitmap, paramFloat1, paramFloat2, paramFloat3));
  }
  
  void a(com.tencent.liteav.basic.c.a parama)
  {
    TXCLog.i("TXCFilterDrawer", "set notify");
    this.aG = new WeakReference(parama);
  }
  
  void a(d paramd)
  {
    TXCLog.i("TXCFilterDrawer", "set listener");
    this.aF = paramd;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aA = paramArrayOfByte;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    a(new b.6(this, paramArrayOfFloat));
  }
  
  /* Error */
  public boolean a(c.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: istore_2
    //   4: aload_1
    //   5: getfield 641	com/tencent/liteav/beauty/c$b:j	Z
    //   8: ifne +57 -> 65
    //   11: aload_0
    //   12: getfield 769	com/tencent/liteav/beauty/b:ah	Lcom/tencent/liteav/beauty/b$a;
    //   15: ifnonnull +27 -> 42
    //   18: aload_0
    //   19: invokevirtual 844	com/tencent/liteav/beauty/b:start	()V
    //   22: aload_0
    //   23: new 6	com/tencent/liteav/beauty/b$a
    //   26: dup
    //   27: aload_0
    //   28: aload_0
    //   29: invokevirtual 847	com/tencent/liteav/beauty/b:getLooper	()Landroid/os/Looper;
    //   32: aload_0
    //   33: getfield 147	com/tencent/liteav/beauty/b:m	Landroid/content/Context;
    //   36: invokespecial 850	com/tencent/liteav/beauty/b$a:<init>	(Lcom/tencent/liteav/beauty/b;Landroid/os/Looper;Landroid/content/Context;)V
    //   39: putfield 769	com/tencent/liteav/beauty/b:ah	Lcom/tencent/liteav/beauty/b$a;
    //   42: aload_0
    //   43: getfield 769	com/tencent/liteav/beauty/b:ah	Lcom/tencent/liteav/beauty/b$a;
    //   46: iconst_0
    //   47: aload_1
    //   48: invokevirtual 773	com/tencent/liteav/beauty/b$a:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   51: invokevirtual 778	android/os/Message:sendToTarget	()V
    //   54: aload_0
    //   55: getfield 769	com/tencent/liteav/beauty/b:ah	Lcom/tencent/liteav/beauty/b$a;
    //   58: invokevirtual 851	com/tencent/liteav/beauty/b$a:b	()V
    //   61: aload_0
    //   62: monitorexit
    //   63: iload_2
    //   64: ireturn
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 523	com/tencent/liteav/beauty/b:c	(Lcom/tencent/liteav/beauty/c$b;)Z
    //   70: istore_2
    //   71: goto -10 -> 61
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	b
    //   0	79	1	paramb	c.b
    //   3	68	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	42	74	finally
    //   42	61	74	finally
    //   65	71	74	finally
  }
  
  public void b(int paramInt)
  {
    this.ak = paramInt;
    a(new b.10(this, paramInt));
  }
  
  public boolean b(c.b paramb)
  {
    if (!this.ad)
    {
      if (this.ah == null)
      {
        TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
        return false;
      }
      this.ah.obtainMessage(5, 0, 0, paramb).sendToTarget();
    }
    for (;;)
    {
      return true;
      d(paramb);
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.aj == paramInt) || (paramInt > 2) || (paramInt < 0)) {
      return;
    }
    this.aj = paramInt;
    a(new b.11(this, paramInt));
  }
  
  public void d(int paramInt)
  {
    this.al = paramInt;
    a(new b.12(this, paramInt));
  }
  
  public void e(int paramInt)
  {
    this.am = paramInt;
    a(new b.2(this, paramInt));
  }
  
  public void f(int paramInt)
  {
    this.an = paramInt;
    a(new b.3(this, paramInt));
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