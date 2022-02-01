package com.tencent.liteav.basic.d;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
  implements f.a, l
{
  public int a;
  private volatile HandlerThread b;
  private volatile f c;
  private m d;
  private int[] e;
  private SurfaceTexture f;
  private boolean g;
  private long h;
  private long i;
  private float[] j;
  
  public e()
  {
    AppMethodBeat.i(14594);
    this.b = null;
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = false;
    this.a = 25;
    this.h = 0L;
    this.i = 0L;
    this.j = new float[16];
    AppMethodBeat.o(14594);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(14606);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14606);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(14605);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessageDelayed(paramInt, paramLong);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14605);
    }
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(14607);
    try
    {
      if (this.c != null)
      {
        Message localMessage = new Message();
        localMessage.what = paramInt;
        localMessage.obj = paramRunnable;
        this.c.sendMessage(localMessage);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14607);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(14603);
    f();
    try
    {
      this.b = new HandlerThread("TXGLSurfaceTextureThread");
      this.b.start();
      this.c = new f(this.b.getLooper());
      this.c.a(this);
      this.c.a = 1280;
      this.c.b = 720;
      TXCLog.w("TXGLSurfaceTextureThread", "create gl thread " + this.b.getName());
      a(100);
      AppMethodBeat.o(14603);
      return;
    }
    finally
    {
      AppMethodBeat.o(14603);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(14604);
    try
    {
      if (this.c != null)
      {
        f.a(this.c, this.b);
        TXCLog.w("TXGLSurfaceTextureThread", "destroy gl thread");
      }
      this.c = null;
      this.b = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(14604);
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(14608);
    TXCLog.w("TXGLSurfaceTextureThread", "destroy surface texture ");
    m localm = this.d;
    if (localm != null) {
      localm.b(this.f);
    }
    if (this.f != null)
    {
      this.f.setOnFrameAvailableListener(null);
      this.f.release();
      this.g = false;
      this.f = null;
    }
    if (this.e != null)
    {
      GLES20.glDeleteTextures(1, this.e, 0);
      this.e = null;
    }
    AppMethodBeat.o(14608);
  }
  
  private void h()
  {
    AppMethodBeat.i(14609);
    TXCLog.w("TXGLSurfaceTextureThread", "init surface texture ");
    this.e = new int[1];
    this.e[0] = i.b();
    if (this.e[0] <= 0)
    {
      this.e = null;
      AppMethodBeat.o(14609);
      return;
    }
    this.f = new SurfaceTexture(this.e[0]);
    this.f.setDefaultBufferSize(1280, 720);
    this.f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(14537);
        e.a(e.this, 103, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14499);
            e.a(e.this, true);
            e.a(e.this, 102);
            AppMethodBeat.o(14499);
          }
        });
        paramAnonymousSurfaceTexture.setOnFrameAvailableListener(null);
        AppMethodBeat.o(14537);
      }
    });
    m localm = this.d;
    if (localm != null) {
      localm.a(this.f);
    }
    AppMethodBeat.o(14609);
  }
  
  private boolean i()
  {
    AppMethodBeat.i(14610);
    if (!this.g)
    {
      this.h = 0L;
      this.i = System.nanoTime();
      AppMethodBeat.o(14610);
      return false;
    }
    long l = System.nanoTime();
    if (l < this.i + this.h * 1000L * 1000L * 1000L / this.a)
    {
      AppMethodBeat.o(14610);
      return false;
    }
    if (this.i == 0L) {
      this.i = l;
    }
    for (;;)
    {
      this.h += 1L;
      AppMethodBeat.o(14610);
      return true;
      if (l > this.i + 1000000000L)
      {
        this.h = 0L;
        this.i = l;
      }
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(14596);
    f();
    AppMethodBeat.o(14596);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(14595);
    this.a = paramInt;
    b();
    AppMethodBeat.o(14595);
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(14598);
    try
    {
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14598);
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 14599
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 48	com/tencent/liteav/basic/d/e:c	Lcom/tencent/liteav/basic/d/f;
    //   12: ifnull +11 -> 23
    //   15: aload_0
    //   16: getfield 48	com/tencent/liteav/basic/d/e:c	Lcom/tencent/liteav/basic/d/f;
    //   19: aconst_null
    //   20: invokevirtual 220	com/tencent/liteav/basic/d/f:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 54	com/tencent/liteav/basic/d/e:g	Z
    //   28: aload_0
    //   29: getfield 52	com/tencent/liteav/basic/d/e:f	Landroid/graphics/SurfaceTexture;
    //   32: ifnull +12 -> 44
    //   35: aload_0
    //   36: getfield 50	com/tencent/liteav/basic/d/e:e	[I
    //   39: astore_2
    //   40: aload_2
    //   41: ifnonnull +12 -> 53
    //   44: aload_0
    //   45: monitorexit
    //   46: sipush 14599
    //   49: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: aload_0
    //   54: getfield 52	com/tencent/liteav/basic/d/e:f	Landroid/graphics/SurfaceTexture;
    //   57: invokevirtual 223	android/graphics/SurfaceTexture:updateTexImage	()V
    //   60: aload_0
    //   61: getfield 52	com/tencent/liteav/basic/d/e:f	Landroid/graphics/SurfaceTexture;
    //   64: new 10	com/tencent/liteav/basic/d/e$1
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 224	com/tencent/liteav/basic/d/e$1:<init>	(Lcom/tencent/liteav/basic/d/e;)V
    //   72: invokevirtual 166	android/graphics/SurfaceTexture:setOnFrameAvailableListener	(Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: sipush 14599
    //   80: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: sipush 14599
    //   90: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_2
    //   96: goto -36 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	e
    //   0	99	1	paramBoolean	boolean
    //   39	2	2	arrayOfInt	int[]
    //   84	10	2	localObject	Object
    //   95	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   8	23	84	finally
    //   23	40	84	finally
    //   44	46	84	finally
    //   53	60	84	finally
    //   60	77	84	finally
    //   85	87	84	finally
    //   8	23	95	java/lang/Exception
    //   23	40	95	java/lang/Exception
    //   53	60	95	java/lang/Exception
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void c()
  {
    AppMethodBeat.i(14600);
    h();
    AppMethodBeat.o(14600);
  }
  
  public void d()
  {
    AppMethodBeat.i(14601);
    a(102, 5L);
    if (!i())
    {
      AppMethodBeat.o(14601);
      return;
    }
    if ((this.f == null) || (this.e == null))
    {
      AppMethodBeat.o(14601);
      return;
    }
    try
    {
      this.f.updateTexImage();
      this.f.getTransformMatrix(this.j);
      m localm = this.d;
      if (localm != null) {
        localm.a(this.e[0], this.j);
      }
      AppMethodBeat.o(14601);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e("TXGLSurfaceTextureThread", "onMsgRend Exception " + localException.getMessage());
      }
    }
  }
  
  public void e()
  {
    AppMethodBeat.i(14602);
    g();
    AppMethodBeat.o(14602);
  }
  
  /* Error */
  public javax.microedition.khronos.egl.EGLContext getGLContext()
  {
    // Byte code:
    //   0: sipush 14597
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 48	com/tencent/liteav/basic/d/e:c	Lcom/tencent/liteav/basic/d/f;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 48	com/tencent/liteav/basic/d/e:c	Lcom/tencent/liteav/basic/d/f;
    //   19: invokevirtual 253	com/tencent/liteav/basic/d/f:a	()Ljavax/microedition/khronos/egl/EGLContext;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: sipush 14597
    //   28: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_1
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -12 -> 23
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: sipush 14597
    //   44: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	e
    //   22	13	1	localEGLContext	javax.microedition.khronos.egl.EGLContext
    //   38	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	23	38	finally
    //   23	25	38	finally
    //   39	41	38	finally
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.f;
  }
  
  public void setRendMirror(int paramInt) {}
  
  public void setRendMode(int paramInt) {}
  
  public void setSurfaceTextureListener(m paramm)
  {
    this.d = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.e
 * JD-Core Version:    0.7.0.1
 */