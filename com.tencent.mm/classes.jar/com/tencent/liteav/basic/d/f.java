package com.tencent.liteav.basic.d;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f
  implements g.a, m
{
  public int a;
  private volatile HandlerThread b;
  private volatile g c;
  private n d;
  private int[] e;
  private SurfaceTexture f;
  private boolean g;
  private long h;
  private long i;
  private float[] j;
  
  public f()
  {
    AppMethodBeat.i(221424);
    this.b = null;
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = false;
    this.a = 25;
    this.h = 0L;
    this.i = 0L;
    this.j = new float[16];
    AppMethodBeat.o(221424);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(221432);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(221432);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(221431);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessageDelayed(paramInt, paramLong);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(221431);
    }
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(221433);
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
      AppMethodBeat.o(221433);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(221430);
    f();
    try
    {
      this.b = new HandlerThread("TXGLSurfaceTextureThread");
      this.b.start();
      this.c = new g(this.b.getLooper());
      this.c.a(this);
      this.c.a = 1280;
      this.c.b = 720;
      TXCLog.w("TXGLSurfaceTextureThread", "create gl thread " + this.b.getName());
      a(100);
      AppMethodBeat.o(221430);
      return;
    }
    finally
    {
      AppMethodBeat.o(221430);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(182425);
    try
    {
      if (this.c != null)
      {
        g.a(this.c, this.b);
        TXCLog.w("TXGLSurfaceTextureThread", "destroy gl thread");
      }
      this.c = null;
      this.b = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(182425);
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(221434);
    TXCLog.w("TXGLSurfaceTextureThread", "destroy surface texture ");
    n localn = this.d;
    if (localn != null) {
      localn.b(this.f);
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
    AppMethodBeat.o(221434);
  }
  
  private void h()
  {
    AppMethodBeat.i(221435);
    TXCLog.w("TXGLSurfaceTextureThread", "init surface texture ");
    this.e = new int[1];
    this.e[0] = j.b();
    if (this.e[0] <= 0)
    {
      this.e = null;
      AppMethodBeat.o(221435);
      return;
    }
    this.f = new SurfaceTexture(this.e[0]);
    this.f.setDefaultBufferSize(1280, 720);
    this.f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(221422);
        f.a(f.this, 103, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(221491);
            f.a(f.this, true);
            f.a(f.this, 102);
            AppMethodBeat.o(221491);
          }
        });
        paramAnonymousSurfaceTexture.setOnFrameAvailableListener(null);
        AppMethodBeat.o(221422);
      }
    });
    n localn = this.d;
    if (localn != null) {
      localn.a(this.f);
    }
    AppMethodBeat.o(221435);
  }
  
  private boolean i()
  {
    AppMethodBeat.i(221436);
    if (!this.g)
    {
      this.h = 0L;
      this.i = System.nanoTime();
      AppMethodBeat.o(221436);
      return false;
    }
    long l = System.nanoTime();
    if (l < this.i + this.h * 1000L * 1000L * 1000L / this.a)
    {
      AppMethodBeat.o(221436);
      return false;
    }
    if (this.i == 0L) {
      this.i = l;
    }
    for (;;)
    {
      this.h += 1L;
      AppMethodBeat.o(221436);
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
    AppMethodBeat.i(221426);
    f();
    AppMethodBeat.o(221426);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221425);
    this.a = paramInt;
    b();
    AppMethodBeat.o(221425);
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(221428);
    try
    {
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(221428);
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 231
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 49	com/tencent/liteav/basic/d/f:c	Lcom/tencent/liteav/basic/d/g;
    //   11: ifnull +11 -> 22
    //   14: aload_0
    //   15: getfield 49	com/tencent/liteav/basic/d/f:c	Lcom/tencent/liteav/basic/d/g;
    //   18: aconst_null
    //   19: invokevirtual 235	com/tencent/liteav/basic/d/g:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 55	com/tencent/liteav/basic/d/f:g	Z
    //   27: aload_0
    //   28: getfield 53	com/tencent/liteav/basic/d/f:f	Landroid/graphics/SurfaceTexture;
    //   31: ifnull +12 -> 43
    //   34: aload_0
    //   35: getfield 51	com/tencent/liteav/basic/d/f:e	[I
    //   38: astore_2
    //   39: aload_2
    //   40: ifnonnull +11 -> 51
    //   43: aload_0
    //   44: monitorexit
    //   45: ldc 231
    //   47: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: aload_0
    //   52: getfield 53	com/tencent/liteav/basic/d/f:f	Landroid/graphics/SurfaceTexture;
    //   55: invokevirtual 238	android/graphics/SurfaceTexture:updateTexImage	()V
    //   58: aload_0
    //   59: getfield 53	com/tencent/liteav/basic/d/f:f	Landroid/graphics/SurfaceTexture;
    //   62: new 10	com/tencent/liteav/basic/d/f$1
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 239	com/tencent/liteav/basic/d/f$1:<init>	(Lcom/tencent/liteav/basic/d/f;)V
    //   70: invokevirtual 175	android/graphics/SurfaceTexture:setOnFrameAvailableListener	(Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: ldc 231
    //   77: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: ldc 231
    //   86: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_2
    //   90: athrow
    //   91: astore_2
    //   92: goto -34 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	f
    //   0	95	1	paramBoolean	boolean
    //   38	2	2	arrayOfInt	int[]
    //   81	9	2	localObject	Object
    //   91	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   7	22	81	finally
    //   22	39	81	finally
    //   43	45	81	finally
    //   51	58	81	finally
    //   58	75	81	finally
    //   82	84	81	finally
    //   7	22	91	java/lang/Exception
    //   22	39	91	java/lang/Exception
    //   51	58	91	java/lang/Exception
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void c()
  {
    AppMethodBeat.i(14565);
    h();
    AppMethodBeat.o(14565);
  }
  
  public void d()
  {
    AppMethodBeat.i(182423);
    a(102, 5L);
    if (!i())
    {
      AppMethodBeat.o(182423);
      return;
    }
    if ((this.f == null) || (this.e == null))
    {
      AppMethodBeat.o(182423);
      return;
    }
    try
    {
      this.f.updateTexImage();
      this.f.getTransformMatrix(this.j);
      n localn = this.d;
      if (localn != null) {
        localn.a(this.e[0], this.j);
      }
      AppMethodBeat.o(182423);
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
    AppMethodBeat.i(14571);
    g();
    AppMethodBeat.o(14571);
  }
  
  /* Error */
  public javax.microedition.khronos.egl.EGLContext getGLContext()
  {
    // Byte code:
    //   0: ldc_w 268
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 49	com/tencent/liteav/basic/d/f:c	Lcom/tencent/liteav/basic/d/g;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 49	com/tencent/liteav/basic/d/f:c	Lcom/tencent/liteav/basic/d/g;
    //   19: invokevirtual 270	com/tencent/liteav/basic/d/g:a	()Ljavax/microedition/khronos/egl/EGLContext;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: ldc_w 268
    //   28: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_1
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -12 -> 23
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: ldc_w 268
    //   44: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	f
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
  
  public void setSurfaceTextureListener(n paramn)
  {
    this.d = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.f
 * JD-Core Version:    0.7.0.1
 */