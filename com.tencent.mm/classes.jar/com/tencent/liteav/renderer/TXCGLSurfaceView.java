package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.i;
import com.tencent.liteav.basic.d.j;
import com.tencent.liteav.basic.d.k;
import com.tencent.liteav.basic.d.l;
import com.tencent.liteav.basic.d.m;
import com.tencent.liteav.basic.d.n;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceView
  extends TXCGLSurfaceViewBase
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, l
{
  private n A;
  private int B;
  private int C;
  private int D;
  private int E;
  private boolean F;
  private boolean G;
  private m H;
  private byte[] I;
  private long J;
  private int K;
  private int L;
  private final Queue<Runnable> M;
  WeakReference<a> a;
  private SurfaceTexture g;
  private EGLContext h;
  private g i;
  private int[] j;
  private float[] k;
  private int l;
  private boolean m;
  private float n;
  private float o;
  private int p;
  private long q;
  private long r;
  private int s;
  private boolean t;
  private boolean u;
  private Object v;
  private Handler w;
  private int x;
  private int y;
  private boolean z;
  
  public TXCGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(67183);
    this.k = new float[16];
    this.l = 0;
    this.m = false;
    this.n = 1.0F;
    this.o = 1.0F;
    this.p = 20;
    this.q = 0L;
    this.r = 0L;
    this.s = 12288;
    this.t = true;
    this.u = false;
    this.v = new Object();
    this.x = 0;
    this.y = 0;
    this.z = true;
    this.A = null;
    this.B = 0;
    this.C = 0;
    this.F = true;
    this.G = true;
    this.I = null;
    this.J = 0L;
    this.K = 0;
    this.L = 0;
    this.M = new LinkedList();
    setEGLContextClientVersion(2);
    a(8, 8, 8, 8, 16, 0);
    setRenderer(this);
    AppMethodBeat.o(67183);
  }
  
  public TXCGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67184);
    this.k = new float[16];
    this.l = 0;
    this.m = false;
    this.n = 1.0F;
    this.o = 1.0F;
    this.p = 20;
    this.q = 0L;
    this.r = 0L;
    this.s = 12288;
    this.t = true;
    this.u = false;
    this.v = new Object();
    this.x = 0;
    this.y = 0;
    this.z = true;
    this.A = null;
    this.B = 0;
    this.C = 0;
    this.F = true;
    this.G = true;
    this.I = null;
    this.J = 0L;
    this.K = 0;
    this.L = 0;
    this.M = new LinkedList();
    setEGLContextClientVersion(2);
    a(8, 8, 8, 8, 16, 0);
    setRenderer(this);
    AppMethodBeat.o(67184);
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(146750);
    try
    {
      Thread.sleep(paramLong);
      AppMethodBeat.o(146750);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(146750);
    }
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(67197);
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null)
      {
        AppMethodBeat.o(67197);
        return false;
      }
    }
    finally
    {
      AppMethodBeat.o(67197);
    }
    localObject.run();
    AppMethodBeat.o(67197);
    return true;
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt2 / paramInt1;
    float f2 = paramInt4 / paramInt3;
    int i1;
    if (f1 > f2)
    {
      paramInt4 = (int)(paramInt1 * f2);
      i1 = (paramInt2 - paramInt4) / 2;
      paramInt3 = 0;
      paramInt2 = paramInt4;
      paramInt4 = paramInt1;
    }
    for (paramInt1 = i1;; paramInt1 = 0)
    {
      return new int[] { paramInt4, paramInt2, paramInt3, paramInt1 };
      paramInt4 = (int)(paramInt2 / f2);
      paramInt3 = (paramInt1 - paramInt4) / 2;
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(67200);
    int i3;
    int i1;
    label55:
    int i2;
    if (this.z) {
      if ((this.x != 0) && (this.y != 0))
      {
        if (getWidth() > getHeight()) {
          break label162;
        }
        i3 = 1;
        if (this.y < this.x) {
          break label167;
        }
        i1 = this.y;
        if (this.y < this.x) {
          break label175;
        }
        i2 = this.x;
        label71:
        if (i3 == 0) {
          break label183;
        }
        i3 = i1;
        i1 = i2;
      }
    }
    for (;;)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 * i3 * 4);
      Bitmap localBitmap = Bitmap.createBitmap(i1, i3, Bitmap.Config.ARGB_8888);
      localByteBuffer.position(0);
      GLES20.glReadPixels(this.D, this.E, i1, i3, 6408, 5121, localByteBuffer);
      new Thread(new TXCGLSurfaceView.5(this, localByteBuffer, localBitmap, i1, i3)).start();
      this.z = false;
      AppMethodBeat.o(67200);
      return;
      label162:
      i3 = 0;
      break;
      label167:
      i1 = this.x;
      break label55;
      label175:
      i2 = this.y;
      break label71;
      label183:
      i3 = i2;
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(67203);
    if (this.G)
    {
      if (this.g != null)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (this.w == null)
          {
            HandlerThread localHandlerThread = new HandlerThread("VideoCaptureThread");
            localHandlerThread.start();
            this.w = new Handler(localHandlerThread.getLooper());
          }
          this.g.setOnFrameAvailableListener(this, this.w);
          AppMethodBeat.o(67203);
          return;
        }
        this.g.setOnFrameAvailableListener(this);
        AppMethodBeat.o(67203);
      }
    }
    else if (this.g != null) {
      this.g.setOnFrameAvailableListener(null);
    }
    AppMethodBeat.o(67203);
  }
  
  public void a()
  {
    AppMethodBeat.i(67192);
    b(false);
    AppMethodBeat.o(67192);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146749);
    this.p = paramInt;
    this.A = null;
    this.z = false;
    this.K = 0;
    this.J = 0L;
    this.L = 0;
    b(true);
    this.G = paramBoolean;
    g();
    AppMethodBeat.o(146749);
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(146748);
    if (this.i == null)
    {
      AppMethodBeat.o(146748);
      return;
    }
    for (;;)
    {
      int i4;
      int i1;
      int i2;
      boolean bool;
      float f1;
      float f2;
      int i3;
      try
      {
        if (this.c) {
          return;
        }
        GLES20.glClear(16640);
        i4 = getWidth();
        i1 = getHeight();
        if (this.B == 0)
        {
          this.D = 0;
          this.E = 0;
          i2 = i4;
          this.x = i2;
          this.y = i1;
          GLES20.glViewport(this.D, this.E, i2, i1);
          if (this.C != 1) {
            break label511;
          }
          bool = paramBoolean1;
          if (!paramBoolean2)
          {
            if (paramBoolean1) {
              break label506;
            }
            paramBoolean1 = true;
            bool = paramBoolean1;
          }
          if (i1 == 0) {
            break label547;
          }
          f1 = i2 / i1;
          if (paramInt4 == 0) {
            break label553;
          }
          f2 = paramInt3 / paramInt4;
          if ((this.m != bool) || (this.l != paramInt2) || (this.n != f1) || (this.o != f2) || (this.F != paramBoolean2))
          {
            this.m = bool;
            this.l = paramInt2;
            this.n = f1;
            this.o = f2;
            this.F = paramBoolean2;
            i4 = (720 - this.l) % 360;
            if ((i4 != 90) && (i4 != 270)) {
              break label559;
            }
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label564;
            }
            i3 = i1;
            if (paramInt2 == 0) {
              break label571;
            }
            g localg = this.i;
            float[] arrayOfFloat = k.a(j.a, false, true);
            f1 = i3 / i2;
            if (paramInt2 == 0) {
              break label578;
            }
            paramBoolean1 = false;
            if (paramInt2 == 0) {
              break label586;
            }
            paramBoolean2 = this.m;
            localg.a(paramInt3, paramInt4, i4, arrayOfFloat, f1, paramBoolean1, paramBoolean2);
            if (paramInt2 == 0) {
              break label592;
            }
            this.i.g();
          }
          GLES20.glBindFramebuffer(36160, 0);
          this.i.a(paramInt1);
          AppMethodBeat.o(146748);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(146748);
      }
      if (this.B == 1)
      {
        i2 = (720 - this.l) % 360;
        if ((i2 == 90) || (i2 == 270))
        {
          i3 = 1;
          label423:
          if (i3 == 0) {
            break label492;
          }
          i2 = paramInt4;
          label432:
          if (i3 == 0) {
            break label499;
          }
        }
        label492:
        label499:
        for (i3 = paramInt3;; i3 = paramInt4)
        {
          int[] arrayOfInt = a(i4, i1, i2, i3);
          i2 = arrayOfInt[0];
          i1 = arrayOfInt[1];
          this.D = arrayOfInt[2];
          this.E = arrayOfInt[3];
          break;
          i3 = 0;
          break label423;
          i2 = paramInt3;
          break label432;
        }
        label506:
        paramBoolean1 = false;
        continue;
        label511:
        bool = paramBoolean1;
        if (this.C == 2)
        {
          bool = paramBoolean1;
          if (paramBoolean2)
          {
            if (!paramBoolean1) {}
            for (paramBoolean1 = true;; paramBoolean1 = false)
            {
              bool = paramBoolean1;
              break;
            }
            label547:
            f1 = 1.0F;
            continue;
            label553:
            f2 = 1.0F;
            continue;
            label559:
            paramInt2 = 0;
            continue;
            label564:
            i3 = i2;
            continue;
            label571:
            i2 = i1;
            continue;
            label578:
            paramBoolean1 = this.m;
            continue;
            label586:
            paramBoolean2 = false;
            continue;
            label592:
            this.i.h();
          }
        }
      }
      else
      {
        i2 = i4;
      }
    }
  }
  
  public void a(n paramn)
  {
    this.A = paramn;
    this.z = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(67193);
    synchronized (this.M)
    {
      this.M.add(paramRunnable);
      AppMethodBeat.o(67193);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(67202);
    this.t = true;
    if (paramBoolean)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      this.s = d();
    }
    try
    {
      if (this.u)
      {
        this.u = false;
        if (this.g != null) {
          this.g.updateTexImage();
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(67202);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      this.I = paramArrayOfByte;
      this.t = false;
      this.u = true;
      return;
    }
    finally {}
  }
  
  protected void b()
  {
    AppMethodBeat.i(67187);
    TXCLog.i("TXCGLSurfaceView", "surfaceDestroyed-->enter with mSurfaceTextureListener:" + this.H);
    if (this.H != null) {
      this.H.b(this.g);
    }
    if (this.g != null)
    {
      this.g.release();
      this.g = null;
    }
    AppMethodBeat.o(67187);
  }
  
  public void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(67196);
    synchronized (this.M)
    {
      this.M.add(paramRunnable);
      AppMethodBeat.o(67196);
      return;
    }
  }
  
  protected int c()
  {
    AppMethodBeat.i(67194);
    if (this.s != 12288) {
      TXCLog.e("TXCGLSurfaceView", "background capture swapbuffer error : " + this.s);
    }
    int i1 = this.s;
    AppMethodBeat.o(67194);
    return i1;
  }
  
  public EGLContext getGLContext()
  {
    return this.h;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.g;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(67195);
    super.onDetachedFromWindow();
    if ((Build.VERSION.SDK_INT >= 21) && (this.w != null))
    {
      this.w.getLooper().quitSafely();
      this.w = null;
    }
    AppMethodBeat.o(67195);
  }
  
  /* Error */
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: ldc_w 395
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 127	com/tencent/liteav/renderer/TXCGLSurfaceView:M	Ljava/util/Queue;
    //   11: invokespecial 397	com/tencent/liteav/renderer/TXCGLSurfaceView:a	(Ljava/util/Queue;)Z
    //   14: pop
    //   15: iconst_0
    //   16: istore_3
    //   17: iconst_1
    //   18: istore_2
    //   19: invokestatic 403	java/lang/System:currentTimeMillis	()J
    //   22: lstore 5
    //   24: aload_0
    //   25: getfield 85	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +9 -> 39
    //   33: aload_0
    //   34: lload 5
    //   36: putfield 85	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   39: lload 5
    //   41: aload_0
    //   42: getfield 85	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   45: lsub
    //   46: aload_0
    //   47: getfield 83	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   50: ldc2_w 404
    //   53: lmul
    //   54: aload_0
    //   55: getfield 81	com/tencent/liteav/renderer/TXCGLSurfaceView:p	I
    //   58: i2l
    //   59: ldiv
    //   60: lcmp
    //   61: ifge +15 -> 76
    //   64: aload_0
    //   65: ldc2_w 406
    //   68: invokespecial 409	com/tencent/liteav/renderer/TXCGLSurfaceView:a	(J)V
    //   71: iconst_0
    //   72: istore_2
    //   73: goto -54 -> 19
    //   76: lload 5
    //   78: aload_0
    //   79: getfield 85	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   82: lsub
    //   83: ldc2_w 404
    //   86: lcmp
    //   87: ifle +17 -> 104
    //   90: aload_0
    //   91: lconst_1
    //   92: putfield 83	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   95: iconst_1
    //   96: istore_3
    //   97: aload_0
    //   98: invokestatic 403	java/lang/System:currentTimeMillis	()J
    //   101: putfield 85	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   104: aload_0
    //   105: getfield 89	com/tencent/liteav/renderer/TXCGLSurfaceView:t	Z
    //   108: ifeq +10 -> 118
    //   111: ldc_w 395
    //   114: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: aconst_null
    //   119: astore_1
    //   120: aload_0
    //   121: monitorenter
    //   122: aload_0
    //   123: getfield 91	com/tencent/liteav/renderer/TXCGLSurfaceView:u	Z
    //   126: ifne +37 -> 163
    //   129: iconst_1
    //   130: istore 4
    //   132: iload_2
    //   133: istore_3
    //   134: iload 4
    //   136: istore_2
    //   137: aload_0
    //   138: monitorexit
    //   139: iconst_1
    //   140: iload_2
    //   141: if_icmpne +149 -> 290
    //   144: iconst_1
    //   145: iload_3
    //   146: if_icmpne +10 -> 156
    //   149: aload_0
    //   150: ldc2_w 410
    //   153: invokespecial 409	com/tencent/liteav/renderer/TXCGLSurfaceView:a	(J)V
    //   156: ldc_w 395
    //   159: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: return
    //   163: iconst_0
    //   164: istore 4
    //   166: aload_0
    //   167: getfield 116	com/tencent/liteav/renderer/TXCGLSurfaceView:I	[B
    //   170: ifnull +65 -> 235
    //   173: aload_0
    //   174: getfield 116	com/tencent/liteav/renderer/TXCGLSurfaceView:I	[B
    //   177: astore_1
    //   178: aload_0
    //   179: aconst_null
    //   180: putfield 116	com/tencent/liteav/renderer/TXCGLSurfaceView:I	[B
    //   183: aload_0
    //   184: getfield 235	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   187: ifnull +270 -> 457
    //   190: aload_0
    //   191: getfield 235	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   194: invokevirtual 334	android/graphics/SurfaceTexture:updateTexImage	()V
    //   197: aload_0
    //   198: getfield 235	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   201: aload_0
    //   202: getfield 71	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   205: invokevirtual 415	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   208: iload_3
    //   209: ifne +54 -> 263
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 83	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   217: lconst_1
    //   218: ladd
    //   219: putfield 83	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   222: aload_0
    //   223: iconst_0
    //   224: putfield 91	com/tencent/liteav/renderer/TXCGLSurfaceView:u	Z
    //   227: iconst_0
    //   228: istore_2
    //   229: iload 4
    //   231: istore_3
    //   232: goto -95 -> 137
    //   235: aload_0
    //   236: getfield 235	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   239: ifnull +221 -> 460
    //   242: aload_0
    //   243: getfield 235	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   246: invokevirtual 334	android/graphics/SurfaceTexture:updateTexImage	()V
    //   249: aload_0
    //   250: getfield 235	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   253: aload_0
    //   254: getfield 71	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   257: invokevirtual 415	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   260: goto +200 -> 460
    //   263: aload_0
    //   264: lconst_1
    //   265: putfield 83	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   268: goto -46 -> 222
    //   271: astore_1
    //   272: aload_0
    //   273: monitorexit
    //   274: ldc_w 395
    //   277: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: ldc_w 395
    //   286: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: return
    //   290: invokestatic 403	java/lang/System:currentTimeMillis	()J
    //   293: lstore 5
    //   295: lload 5
    //   297: l2d
    //   298: aload_0
    //   299: getfield 118	com/tencent/liteav/renderer/TXCGLSurfaceView:J	J
    //   302: l2d
    //   303: ldc2_w 416
    //   306: dadd
    //   307: dcmpl
    //   308: ifle +39 -> 347
    //   311: aload_0
    //   312: aload_0
    //   313: getfield 122	com/tencent/liteav/renderer/TXCGLSurfaceView:L	I
    //   316: i2d
    //   317: ldc2_w 416
    //   320: dmul
    //   321: lload 5
    //   323: aload_0
    //   324: getfield 118	com/tencent/liteav/renderer/TXCGLSurfaceView:J	J
    //   327: lsub
    //   328: l2d
    //   329: ddiv
    //   330: d2i
    //   331: iconst_1
    //   332: iadd
    //   333: putfield 120	com/tencent/liteav/renderer/TXCGLSurfaceView:K	I
    //   336: aload_0
    //   337: lload 5
    //   339: putfield 118	com/tencent/liteav/renderer/TXCGLSurfaceView:J	J
    //   342: aload_0
    //   343: iconst_0
    //   344: putfield 122	com/tencent/liteav/renderer/TXCGLSurfaceView:L	I
    //   347: aload_0
    //   348: aload_0
    //   349: getfield 122	com/tencent/liteav/renderer/TXCGLSurfaceView:L	I
    //   352: iconst_1
    //   353: iadd
    //   354: putfield 122	com/tencent/liteav/renderer/TXCGLSurfaceView:L	I
    //   357: aload_0
    //   358: getfield 345	com/tencent/liteav/renderer/TXCGLSurfaceView:H	Lcom/tencent/liteav/basic/d/m;
    //   361: ifnull +21 -> 382
    //   364: aload_1
    //   365: ifnull +53 -> 418
    //   368: aload_0
    //   369: getfield 345	com/tencent/liteav/renderer/TXCGLSurfaceView:H	Lcom/tencent/liteav/basic/d/m;
    //   372: aload_1
    //   373: aload_0
    //   374: getfield 71	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   377: invokeinterface 420 3 0
    //   382: aload_0
    //   383: invokespecial 422	com/tencent/liteav/renderer/TXCGLSurfaceView:f	()V
    //   386: aload_0
    //   387: monitorenter
    //   388: aload_0
    //   389: getfield 282	com/tencent/liteav/renderer/TXCGLSurfaceView:c	Z
    //   392: ifne +49 -> 441
    //   395: iconst_1
    //   396: istore_2
    //   397: aload_0
    //   398: monitorexit
    //   399: iload_2
    //   400: ifeq +11 -> 411
    //   403: aload_0
    //   404: aload_0
    //   405: invokevirtual 331	com/tencent/liteav/renderer/TXCGLSurfaceView:d	()I
    //   408: putfield 87	com/tencent/liteav/renderer/TXCGLSurfaceView:s	I
    //   411: ldc_w 395
    //   414: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: return
    //   418: aload_0
    //   419: getfield 345	com/tencent/liteav/renderer/TXCGLSurfaceView:H	Lcom/tencent/liteav/basic/d/m;
    //   422: aload_0
    //   423: getfield 424	com/tencent/liteav/renderer/TXCGLSurfaceView:j	[I
    //   426: iconst_0
    //   427: iaload
    //   428: aload_0
    //   429: getfield 71	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   432: invokeinterface 427 3 0
    //   437: pop
    //   438: goto -56 -> 382
    //   441: iconst_0
    //   442: istore_2
    //   443: goto -46 -> 397
    //   446: astore_1
    //   447: aload_0
    //   448: monitorexit
    //   449: ldc_w 395
    //   452: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   455: aload_1
    //   456: athrow
    //   457: goto -249 -> 208
    //   460: aconst_null
    //   461: astore_1
    //   462: goto -254 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	TXCGLSurfaceView
    //   0	465	1	paramGL10	GL10
    //   18	425	2	i1	int
    //   16	216	3	i2	int
    //   130	100	4	i3	int
    //   22	316	5	l1	long
    // Exception table:
    //   from	to	target	type
    //   122	129	271	finally
    //   137	139	271	finally
    //   166	208	271	finally
    //   212	222	271	finally
    //   222	227	271	finally
    //   235	260	271	finally
    //   263	268	271	finally
    //   272	274	271	finally
    //   120	122	282	java/lang/Exception
    //   149	156	282	java/lang/Exception
    //   274	282	282	java/lang/Exception
    //   290	347	282	java/lang/Exception
    //   347	364	282	java/lang/Exception
    //   368	382	282	java/lang/Exception
    //   382	388	282	java/lang/Exception
    //   403	411	282	java/lang/Exception
    //   418	438	282	java/lang/Exception
    //   449	457	282	java/lang/Exception
    //   388	395	446	finally
    //   397	399	446	finally
    //   447	449	446	finally
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(67201);
    this.t = false;
    try
    {
      this.u = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(67201);
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(67198);
    this.h = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    this.j = new int[1];
    this.j[0] = i.b();
    if (this.j[0] <= 0)
    {
      this.j = null;
      TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
      AppMethodBeat.o(67198);
      return;
    }
    this.g = new SurfaceTexture(this.j[0]);
    g();
    this.i = new g();
    if (!this.i.a())
    {
      AppMethodBeat.o(67198);
      return;
    }
    this.i.a(k.e, k.a(j.a, false, false));
    if (this.H != null) {
      this.H.a(this.g);
    }
    AppMethodBeat.o(67198);
  }
  
  public void setFPS(int paramInt)
  {
    AppMethodBeat.i(67185);
    b(new TXCGLSurfaceView.1(this, paramInt));
    AppMethodBeat.o(67185);
  }
  
  public void setNotifyListener(a parama)
  {
    AppMethodBeat.i(146747);
    this.a = new WeakReference(parama);
    AppMethodBeat.o(146747);
  }
  
  public void setRendMirror(int paramInt)
  {
    AppMethodBeat.i(146746);
    b(new TXCGLSurfaceView.3(this, paramInt));
    AppMethodBeat.o(146746);
  }
  
  public void setRendMode(int paramInt)
  {
    AppMethodBeat.i(67186);
    b(new TXCGLSurfaceView.2(this, paramInt));
    AppMethodBeat.o(67186);
  }
  
  protected void setRunInBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(67188);
    if (paramBoolean) {
      try
      {
        TXCLog.d("TXCGLSurfaceView", "background capture enter background");
        this.c = true;
        return;
      }
      finally
      {
        AppMethodBeat.o(67188);
      }
    }
    b(new TXCGLSurfaceView.4(this));
    AppMethodBeat.o(67188);
  }
  
  public void setSurfaceTextureListener(m paramm)
  {
    this.H = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */