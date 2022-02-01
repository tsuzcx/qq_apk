package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.liteav.basic.c.m;
import com.tencent.liteav.basic.c.n;
import com.tencent.liteav.basic.c.o;
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
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, m
{
  private o A;
  private int B;
  private int C;
  private boolean D;
  private boolean E;
  private n F;
  private long G;
  private byte[] H;
  private long I;
  private int J;
  private int K;
  private final Queue<Runnable> L;
  WeakReference<b> a;
  private SurfaceTexture g;
  private EGLContext h;
  private h i;
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
    AppMethodBeat.i(16757);
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
    this.D = true;
    this.E = true;
    this.H = null;
    this.I = 0L;
    this.J = 0;
    this.K = 0;
    this.L = new LinkedList();
    setEGLContextClientVersion(2);
    a(8, 8, 8, 8, 16, 0);
    setRenderer(this);
    AppMethodBeat.o(16757);
  }
  
  public TXCGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(16758);
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
    this.D = true;
    this.E = true;
    this.H = null;
    this.I = 0L;
    this.J = 0;
    this.K = 0;
    this.L = new LinkedList();
    setEGLContextClientVersion(2);
    a(8, 8, 8, 8, 16, 0);
    setRenderer(this);
    AppMethodBeat.o(16758);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182254);
    final int i3;
    final int i1;
    label56:
    int i2;
    if (this.z) {
      if ((this.x != 0) && (this.y != 0))
      {
        if (this.x > this.y) {
          break label183;
        }
        i3 = 1;
        if (this.y < this.x) {
          break label189;
        }
        i1 = this.y;
        if (this.y < this.x) {
          break label197;
        }
        i2 = this.x;
        label73:
        if (i3 == 0) {
          break label206;
        }
        i3 = i1;
        i1 = i2;
      }
    }
    for (;;)
    {
      final ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 * i3 * 4);
      final Bitmap localBitmap = Bitmap.createBitmap(i1, i3, Bitmap.Config.ARGB_8888);
      localByteBuffer.position(0);
      GLES20.glReadPixels(paramInt1, paramInt2, i1, i3, 6408, 5121, localByteBuffer);
      final o localo = this.A;
      if (localo != null) {
        new Thread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(16823);
            try
            {
              localByteBuffer.position(0);
              localBitmap.copyPixelsFromBuffer(localByteBuffer);
              Object localObject1 = new Matrix();
              ((Matrix)localObject1).setScale(1.0F, -1.0F);
              localObject1 = Bitmap.createBitmap(localBitmap, 0, 0, i1, i3, (Matrix)localObject1, false);
              localo.onTakePhotoComplete((Bitmap)localObject1);
              localBitmap.recycle();
              AppMethodBeat.o(16823);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                TXCLog.w("TXCGLSurfaceView", "takePhoto error ".concat(String.valueOf(localException)));
                Object localObject2 = null;
              }
            }
            catch (Error localError)
            {
              for (;;)
              {
                TXCLog.w("TXCGLSurfaceView", "takePhoto error ".concat(String.valueOf(localError)));
                Object localObject3 = null;
              }
            }
          }
        }).start();
      }
      this.A = null;
      this.z = false;
      AppMethodBeat.o(182254);
      return;
      label183:
      i3 = 0;
      break;
      label189:
      i1 = this.x;
      break label56;
      label197:
      i2 = this.y;
      break label73;
      label206:
      i3 = i2;
    }
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(16777);
    try
    {
      Thread.sleep(paramLong);
      AppMethodBeat.o(16777);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16777);
    }
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(16772);
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null)
      {
        AppMethodBeat.o(16772);
        return false;
      }
    }
    finally
    {
      AppMethodBeat.o(16772);
    }
    localObject.run();
    AppMethodBeat.o(16772);
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
  
  private void g()
  {
    AppMethodBeat.i(16778);
    if (this.E)
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
          AppMethodBeat.o(16778);
          return;
        }
        this.g.setOnFrameAvailableListener(this);
        AppMethodBeat.o(16778);
      }
    }
    else if (this.g != null) {
      this.g.setOnFrameAvailableListener(null);
    }
    AppMethodBeat.o(16778);
  }
  
  public void a()
  {
    AppMethodBeat.i(16767);
    b(false);
    AppMethodBeat.o(16767);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(16766);
    this.p = paramInt;
    if (this.p <= 0) {
      this.p = 1;
    }
    for (;;)
    {
      this.A = null;
      this.z = false;
      this.J = 0;
      this.I = 0L;
      this.K = 0;
      b(true);
      this.E = paramBoolean;
      this.G = 0L;
      g();
      AppMethodBeat.o(16766);
      return;
      if (this.p > 60) {
        this.p = 60;
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(16765);
    if (this.i == null)
    {
      AppMethodBeat.o(16765);
      return;
    }
    for (;;)
    {
      int i5;
      int i1;
      int i3;
      int i4;
      int i2;
      boolean bool;
      float f1;
      float f2;
      try
      {
        if (this.c) {
          return;
        }
        GLES20.glClear(16640);
        i5 = getWidth();
        i1 = getHeight();
        if (this.B == 0)
        {
          i3 = 0;
          i4 = 0;
          i2 = i5;
          this.x = i2;
          this.y = i1;
          GLES20.glViewport(i4, i3, i2, i1);
          if (this.C != 1) {
            break label517;
          }
          bool = paramBoolean1;
          if (!paramBoolean2)
          {
            if (paramBoolean1) {
              break label512;
            }
            paramBoolean1 = true;
            bool = paramBoolean1;
          }
          if (i1 == 0) {
            break label553;
          }
          f1 = i2 / i1;
          if (paramInt4 == 0) {
            break label559;
          }
          f2 = paramInt3 / paramInt4;
          if ((this.m != bool) || (this.l != paramInt2) || (this.n != f1) || (this.o != f2) || (this.D != paramBoolean2))
          {
            this.m = bool;
            this.l = paramInt2;
            this.n = f1;
            this.o = f2;
            this.D = paramBoolean2;
            int i6 = (720 - this.l) % 360;
            if ((i6 != 90) && (i6 != 270)) {
              break label565;
            }
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label570;
            }
            i5 = i1;
            if (paramInt2 == 0) {
              break label577;
            }
            h localh = this.i;
            float[] arrayOfFloat = l.a(k.a, false, true);
            f1 = i5 / i2;
            if (paramInt2 == 0) {
              break label584;
            }
            paramBoolean1 = false;
            if (paramInt2 == 0) {
              break label592;
            }
            paramBoolean2 = this.m;
            localh.a(paramInt3, paramInt4, i6, arrayOfFloat, f1, paramBoolean1, paramBoolean2);
            if (paramInt2 == 0) {
              break label598;
            }
            this.i.g();
          }
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
          GLES20.glClear(16640);
          this.i.a(paramInt1);
          a(i4, i3);
          AppMethodBeat.o(16765);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(16765);
      }
      if (this.B == 1)
      {
        i2 = (720 - paramInt2) % 360;
        if ((i2 == 90) || (i2 == 270))
        {
          i3 = 1;
          label433:
          if (i3 == 0) {
            break label498;
          }
          i2 = paramInt4;
          label442:
          if (i3 == 0) {
            break label505;
          }
        }
        label498:
        label505:
        for (i3 = paramInt3;; i3 = paramInt4)
        {
          int[] arrayOfInt = a(i5, i1, i2, i3);
          i2 = arrayOfInt[0];
          i1 = arrayOfInt[1];
          i4 = arrayOfInt[2];
          i3 = arrayOfInt[3];
          break;
          i3 = 0;
          break label433;
          i2 = paramInt3;
          break label442;
        }
        label512:
        paramBoolean1 = false;
        continue;
        label517:
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
            label553:
            f1 = 1.0F;
            continue;
            label559:
            f2 = 1.0F;
            continue;
            label565:
            paramInt2 = 0;
            continue;
            label570:
            i5 = i2;
            continue;
            label577:
            i2 = i1;
            continue;
            label584:
            paramBoolean1 = this.m;
            continue;
            label592:
            paramBoolean2 = false;
            continue;
            label598:
            this.i.h();
          }
        }
      }
      else
      {
        i3 = 0;
        i4 = 0;
        i2 = i5;
      }
    }
  }
  
  public void a(o paramo)
  {
    this.A = paramo;
    this.z = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(16768);
    synchronized (this.L)
    {
      this.L.add(paramRunnable);
      AppMethodBeat.o(16768);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16776);
    this.t = true;
    if (paramBoolean)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      this.s = e();
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
      AppMethodBeat.o(16776);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      this.H = paramArrayOfByte;
      this.t = false;
      this.u = true;
      return;
    }
    finally {}
  }
  
  protected void b()
  {
    AppMethodBeat.i(16762);
    TXCLog.i("TXCGLSurfaceView", "surfaceDestroyed-->enter with mSurfaceTextureListener:" + this.F);
    if (this.F != null) {
      this.F.b(this.g);
    }
    if (this.g != null)
    {
      this.g.release();
      this.g = null;
    }
    AppMethodBeat.o(16762);
  }
  
  public void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(16771);
    synchronized (this.L)
    {
      this.L.add(paramRunnable);
      AppMethodBeat.o(16771);
      return;
    }
  }
  
  protected int c()
  {
    AppMethodBeat.i(16769);
    if (this.s != 12288) {
      TXCLog.e("TXCGLSurfaceView", "background capture swapbuffer error : " + this.s);
    }
    int i1 = this.s;
    AppMethodBeat.o(16769);
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
    AppMethodBeat.i(16770);
    super.onDetachedFromWindow();
    if ((Build.VERSION.SDK_INT >= 21) && (this.w != null))
    {
      this.w.getLooper().quitSafely();
      this.w = null;
    }
    AppMethodBeat.o(16770);
  }
  
  /* Error */
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: sipush 16774
    //   3: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 135	com/tencent/liteav/renderer/TXCGLSurfaceView:L	Ljava/util/Queue;
    //   11: invokespecial 385	com/tencent/liteav/renderer/TXCGLSurfaceView:a	(Ljava/util/Queue;)Z
    //   14: pop
    //   15: iconst_0
    //   16: istore_3
    //   17: iconst_1
    //   18: istore_2
    //   19: invokestatic 391	java/lang/System:currentTimeMillis	()J
    //   22: lstore 5
    //   24: aload_0
    //   25: getfield 93	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   28: lconst_0
    //   29: lcmp
    //   30: ifeq +13 -> 43
    //   33: lload 5
    //   35: aload_0
    //   36: getfield 93	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   39: lcmp
    //   40: ifge +9 -> 49
    //   43: aload_0
    //   44: lload 5
    //   46: putfield 93	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   49: lload 5
    //   51: aload_0
    //   52: getfield 93	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   55: lsub
    //   56: aload_0
    //   57: getfield 91	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   60: ldc2_w 392
    //   63: lmul
    //   64: aload_0
    //   65: getfield 89	com/tencent/liteav/renderer/TXCGLSurfaceView:p	I
    //   68: i2l
    //   69: ldiv
    //   70: lcmp
    //   71: ifge +15 -> 86
    //   74: aload_0
    //   75: ldc2_w 394
    //   78: invokespecial 397	com/tencent/liteav/renderer/TXCGLSurfaceView:a	(J)V
    //   81: iconst_0
    //   82: istore_2
    //   83: goto -64 -> 19
    //   86: lload 5
    //   88: aload_0
    //   89: getfield 93	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   92: lsub
    //   93: ldc2_w 392
    //   96: lcmp
    //   97: ifle +17 -> 114
    //   100: aload_0
    //   101: lconst_1
    //   102: putfield 91	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   105: iconst_1
    //   106: istore_3
    //   107: aload_0
    //   108: invokestatic 391	java/lang/System:currentTimeMillis	()J
    //   111: putfield 93	com/tencent/liteav/renderer/TXCGLSurfaceView:r	J
    //   114: aload_0
    //   115: getfield 97	com/tencent/liteav/renderer/TXCGLSurfaceView:t	Z
    //   118: ifeq +10 -> 128
    //   121: sipush 16774
    //   124: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_0
    //   131: monitorenter
    //   132: aload_0
    //   133: getfield 99	com/tencent/liteav/renderer/TXCGLSurfaceView:u	Z
    //   136: ifne +37 -> 173
    //   139: iconst_1
    //   140: istore 4
    //   142: iload_2
    //   143: istore_3
    //   144: iload 4
    //   146: istore_2
    //   147: aload_0
    //   148: monitorexit
    //   149: iconst_1
    //   150: iload_2
    //   151: if_icmpne +159 -> 310
    //   154: iconst_1
    //   155: iload_3
    //   156: if_icmpne +10 -> 166
    //   159: aload_0
    //   160: ldc2_w 398
    //   163: invokespecial 397	com/tencent/liteav/renderer/TXCGLSurfaceView:a	(J)V
    //   166: sipush 16774
    //   169: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: return
    //   173: iconst_0
    //   174: istore 4
    //   176: aload_0
    //   177: getfield 124	com/tencent/liteav/renderer/TXCGLSurfaceView:H	[B
    //   180: ifnull +65 -> 245
    //   183: aload_0
    //   184: getfield 124	com/tencent/liteav/renderer/TXCGLSurfaceView:H	[B
    //   187: astore_1
    //   188: aload_0
    //   189: aconst_null
    //   190: putfield 124	com/tencent/liteav/renderer/TXCGLSurfaceView:H	[B
    //   193: aload_0
    //   194: getfield 224	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   197: ifnull +375 -> 572
    //   200: aload_0
    //   201: getfield 224	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   204: invokevirtual 328	android/graphics/SurfaceTexture:updateTexImage	()V
    //   207: aload_0
    //   208: getfield 224	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   211: aload_0
    //   212: getfield 79	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   215: invokevirtual 403	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   218: iload_3
    //   219: ifne +54 -> 273
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 91	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   227: lconst_1
    //   228: ladd
    //   229: putfield 91	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   232: aload_0
    //   233: iconst_0
    //   234: putfield 99	com/tencent/liteav/renderer/TXCGLSurfaceView:u	Z
    //   237: iconst_0
    //   238: istore_2
    //   239: iload 4
    //   241: istore_3
    //   242: goto -95 -> 147
    //   245: aload_0
    //   246: getfield 224	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   249: ifnull +326 -> 575
    //   252: aload_0
    //   253: getfield 224	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   256: invokevirtual 328	android/graphics/SurfaceTexture:updateTexImage	()V
    //   259: aload_0
    //   260: getfield 224	com/tencent/liteav/renderer/TXCGLSurfaceView:g	Landroid/graphics/SurfaceTexture;
    //   263: aload_0
    //   264: getfield 79	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   267: invokevirtual 403	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   270: goto +305 -> 575
    //   273: aload_0
    //   274: lconst_1
    //   275: putfield 91	com/tencent/liteav/renderer/TXCGLSurfaceView:q	J
    //   278: goto -46 -> 232
    //   281: astore_1
    //   282: aload_0
    //   283: monitorexit
    //   284: sipush 16774
    //   287: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload_1
    //   291: athrow
    //   292: astore_1
    //   293: ldc_w 331
    //   296: ldc_w 405
    //   299: aload_1
    //   300: invokestatic 408	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   303: sipush 16774
    //   306: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: return
    //   310: invokestatic 391	java/lang/System:currentTimeMillis	()J
    //   313: lstore 5
    //   315: lload 5
    //   317: l2d
    //   318: aload_0
    //   319: getfield 126	com/tencent/liteav/renderer/TXCGLSurfaceView:I	J
    //   322: l2d
    //   323: ldc2_w 409
    //   326: dadd
    //   327: dcmpl
    //   328: ifle +39 -> 367
    //   331: aload_0
    //   332: aload_0
    //   333: getfield 130	com/tencent/liteav/renderer/TXCGLSurfaceView:K	I
    //   336: i2d
    //   337: ldc2_w 409
    //   340: dmul
    //   341: lload 5
    //   343: aload_0
    //   344: getfield 126	com/tencent/liteav/renderer/TXCGLSurfaceView:I	J
    //   347: lsub
    //   348: l2d
    //   349: ddiv
    //   350: d2i
    //   351: iconst_1
    //   352: iadd
    //   353: putfield 128	com/tencent/liteav/renderer/TXCGLSurfaceView:J	I
    //   356: aload_0
    //   357: lload 5
    //   359: putfield 126	com/tencent/liteav/renderer/TXCGLSurfaceView:I	J
    //   362: aload_0
    //   363: iconst_0
    //   364: putfield 130	com/tencent/liteav/renderer/TXCGLSurfaceView:K	I
    //   367: aload_0
    //   368: aload_0
    //   369: getfield 130	com/tencent/liteav/renderer/TXCGLSurfaceView:K	I
    //   372: iconst_1
    //   373: iadd
    //   374: putfield 130	com/tencent/liteav/renderer/TXCGLSurfaceView:K	I
    //   377: aload_0
    //   378: getfield 338	com/tencent/liteav/renderer/TXCGLSurfaceView:F	Lcom/tencent/liteav/basic/c/n;
    //   381: ifnull +21 -> 402
    //   384: aload_1
    //   385: ifnull +148 -> 533
    //   388: aload_0
    //   389: getfield 338	com/tencent/liteav/renderer/TXCGLSurfaceView:F	Lcom/tencent/liteav/basic/c/n;
    //   392: aload_1
    //   393: aload_0
    //   394: getfield 79	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   397: invokeinterface 413 3 0
    //   402: aload_0
    //   403: monitorenter
    //   404: aload_0
    //   405: getfield 270	com/tencent/liteav/renderer/TXCGLSurfaceView:c	Z
    //   408: ifne +148 -> 556
    //   411: iconst_1
    //   412: istore_2
    //   413: aload_0
    //   414: monitorexit
    //   415: iload_2
    //   416: ifeq +110 -> 526
    //   419: aload_0
    //   420: invokevirtual 325	com/tencent/liteav/renderer/TXCGLSurfaceView:e	()I
    //   423: istore_2
    //   424: iload_2
    //   425: sipush 12288
    //   428: if_icmpeq +98 -> 526
    //   431: invokestatic 391	java/lang/System:currentTimeMillis	()J
    //   434: aload_0
    //   435: getfield 263	com/tencent/liteav/renderer/TXCGLSurfaceView:G	J
    //   438: lsub
    //   439: ldc2_w 414
    //   442: lcmp
    //   443: ifle +83 -> 526
    //   446: ldc_w 331
    //   449: ldc_w 417
    //   452: iload_2
    //   453: invokestatic 423	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   456: invokevirtual 427	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   459: invokestatic 429	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: aload_0
    //   463: invokestatic 391	java/lang/System:currentTimeMillis	()J
    //   466: putfield 263	com/tencent/liteav/renderer/TXCGLSurfaceView:G	J
    //   469: new 431	android/os/Bundle
    //   472: dup
    //   473: invokespecial 432	android/os/Bundle:<init>	()V
    //   476: astore_1
    //   477: aload_1
    //   478: ldc_w 434
    //   481: iload_2
    //   482: invokevirtual 438	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   485: aload_1
    //   486: ldc_w 440
    //   489: sipush 2110
    //   492: invokevirtual 438	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   495: aload_1
    //   496: ldc_w 442
    //   499: invokestatic 447	com/tencent/liteav/basic/util/TXCTimeUtil:getTimeTick	()J
    //   502: invokevirtual 451	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   505: aload_1
    //   506: ldc_w 453
    //   509: ldc_w 455
    //   512: invokevirtual 459	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   515: aload_0
    //   516: getfield 461	com/tencent/liteav/renderer/TXCGLSurfaceView:a	Ljava/lang/ref/WeakReference;
    //   519: sipush 2110
    //   522: aload_1
    //   523: invokestatic 466	com/tencent/liteav/basic/util/f:a	(Ljava/lang/ref/WeakReference;ILandroid/os/Bundle;)V
    //   526: sipush 16774
    //   529: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: return
    //   533: aload_0
    //   534: getfield 338	com/tencent/liteav/renderer/TXCGLSurfaceView:F	Lcom/tencent/liteav/basic/c/n;
    //   537: aload_0
    //   538: getfield 468	com/tencent/liteav/renderer/TXCGLSurfaceView:j	[I
    //   541: iconst_0
    //   542: iaload
    //   543: aload_0
    //   544: getfield 79	com/tencent/liteav/renderer/TXCGLSurfaceView:k	[F
    //   547: invokeinterface 471 3 0
    //   552: pop
    //   553: goto -151 -> 402
    //   556: iconst_0
    //   557: istore_2
    //   558: goto -145 -> 413
    //   561: astore_1
    //   562: aload_0
    //   563: monitorexit
    //   564: sipush 16774
    //   567: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   570: aload_1
    //   571: athrow
    //   572: goto -354 -> 218
    //   575: aconst_null
    //   576: astore_1
    //   577: goto -359 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	this	TXCGLSurfaceView
    //   0	580	1	paramGL10	GL10
    //   18	540	2	i1	int
    //   16	226	3	i2	int
    //   140	100	4	i3	int
    //   22	336	5	l1	long
    // Exception table:
    //   from	to	target	type
    //   132	139	281	finally
    //   147	149	281	finally
    //   176	218	281	finally
    //   222	232	281	finally
    //   232	237	281	finally
    //   245	270	281	finally
    //   273	278	281	finally
    //   282	284	281	finally
    //   130	132	292	java/lang/Exception
    //   159	166	292	java/lang/Exception
    //   284	292	292	java/lang/Exception
    //   310	367	292	java/lang/Exception
    //   367	384	292	java/lang/Exception
    //   388	402	292	java/lang/Exception
    //   402	404	292	java/lang/Exception
    //   419	424	292	java/lang/Exception
    //   431	526	292	java/lang/Exception
    //   533	553	292	java/lang/Exception
    //   564	572	292	java/lang/Exception
    //   404	411	561	finally
    //   413	415	561	finally
    //   562	564	561	finally
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.t = false;
    try
    {
      this.u = true;
      return;
    }
    finally {}
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(16773);
    this.h = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    this.j = new int[1];
    this.j[0] = j.b();
    if (this.j[0] <= 0)
    {
      this.j = null;
      TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
      AppMethodBeat.o(16773);
      return;
    }
    this.g = new SurfaceTexture(this.j[0]);
    g();
    this.i = new h();
    if (!this.i.a())
    {
      AppMethodBeat.o(16773);
      return;
    }
    this.i.a(l.e, l.a(k.a, false, false));
    if (this.F != null) {
      this.F.a(this.g);
    }
    AppMethodBeat.o(16773);
  }
  
  public void setFPS(final int paramInt)
  {
    AppMethodBeat.i(16759);
    b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16782);
        TXCGLSurfaceView.a(TXCGLSurfaceView.this, paramInt);
        if (TXCGLSurfaceView.a(TXCGLSurfaceView.this) <= 0) {
          TXCGLSurfaceView.a(TXCGLSurfaceView.this, 1);
        }
        for (;;)
        {
          TXCGLSurfaceView.a(TXCGLSurfaceView.this, 0L);
          TXCGLSurfaceView.b(TXCGLSurfaceView.this, 0L);
          AppMethodBeat.o(16782);
          return;
          if (TXCGLSurfaceView.a(TXCGLSurfaceView.this) > 60) {
            TXCGLSurfaceView.a(TXCGLSurfaceView.this, 60);
          }
        }
      }
    });
    AppMethodBeat.o(16759);
  }
  
  public void setNotifyListener(b paramb)
  {
    AppMethodBeat.i(222339);
    this.a = new WeakReference(paramb);
    AppMethodBeat.o(222339);
  }
  
  public void setRendMirror(final int paramInt)
  {
    AppMethodBeat.i(16761);
    b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16841);
        TXCGLSurfaceView.c(TXCGLSurfaceView.this, paramInt);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        AppMethodBeat.o(16841);
      }
    });
    AppMethodBeat.o(16761);
  }
  
  public void setRendMode(final int paramInt)
  {
    AppMethodBeat.i(16760);
    b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16822);
        TXCGLSurfaceView.b(TXCGLSurfaceView.this, paramInt);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        AppMethodBeat.o(16822);
      }
    });
    AppMethodBeat.o(16760);
  }
  
  protected void setRunInBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(16763);
    if (paramBoolean) {
      try
      {
        TXCLog.i("TXCGLSurfaceView", "background capture enter background");
        this.c = true;
        return;
      }
      finally
      {
        AppMethodBeat.o(16763);
      }
    }
    b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16839);
        try
        {
          TXCLog.i("TXCGLSurfaceView", "background capture exit background");
          TXCGLSurfaceView.this.c = false;
          return;
        }
        finally
        {
          AppMethodBeat.o(16839);
        }
      }
    });
    AppMethodBeat.o(16763);
  }
  
  public void setSurfaceTextureListener(n paramn)
  {
    this.F = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */