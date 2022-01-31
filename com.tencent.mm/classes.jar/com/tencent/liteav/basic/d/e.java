package com.tencent.liteav.basic.d;

import android.graphics.SurfaceTexture;
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
    AppMethodBeat.i(146529);
    this.b = null;
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = false;
    this.a = 25;
    this.h = 0L;
    this.i = 0L;
    this.j = new float[16];
    AppMethodBeat.o(146529);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(146541);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(146541);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(146540);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessageDelayed(paramInt, paramLong);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(146540);
    }
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(146542);
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
      AppMethodBeat.o(146542);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(146538);
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
      AppMethodBeat.o(146538);
      return;
    }
    finally
    {
      AppMethodBeat.o(146538);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(146539);
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
      AppMethodBeat.o(146539);
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(146543);
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
    AppMethodBeat.o(146543);
  }
  
  private void h()
  {
    AppMethodBeat.i(146544);
    TXCLog.w("TXGLSurfaceTextureThread", "init surface texture ");
    this.e = new int[1];
    this.e[0] = i.b();
    if (this.e[0] <= 0)
    {
      this.e = null;
      AppMethodBeat.o(146544);
      return;
    }
    this.f = new SurfaceTexture(this.e[0]);
    this.f.setDefaultBufferSize(1280, 720);
    this.f.setOnFrameAvailableListener(new e.2(this));
    m localm = this.d;
    if (localm != null) {
      localm.a(this.f);
    }
    AppMethodBeat.o(146544);
  }
  
  private boolean i()
  {
    AppMethodBeat.i(146545);
    if (!this.g)
    {
      this.h = 0L;
      this.i = System.nanoTime();
      AppMethodBeat.o(146545);
      return false;
    }
    long l = System.nanoTime();
    if (l < this.i + this.h * 1000L * 1000L * 1000L / this.a)
    {
      AppMethodBeat.o(146545);
      return false;
    }
    if (this.i == 0L) {
      this.i = l;
    }
    for (;;)
    {
      this.h += 1L;
      AppMethodBeat.o(146545);
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
    AppMethodBeat.i(146531);
    f();
    AppMethodBeat.o(146531);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146530);
    this.a = paramInt;
    b();
    AppMethodBeat.o(146530);
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(146533);
    try
    {
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(146533);
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 225
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 41	com/tencent/liteav/basic/d/e:c	Lcom/tencent/liteav/basic/d/f;
    //   11: ifnull +11 -> 22
    //   14: aload_0
    //   15: getfield 41	com/tencent/liteav/basic/d/e:c	Lcom/tencent/liteav/basic/d/f;
    //   18: aconst_null
    //   19: invokevirtual 229	com/tencent/liteav/basic/d/f:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 47	com/tencent/liteav/basic/d/e:g	Z
    //   27: aload_0
    //   28: getfield 45	com/tencent/liteav/basic/d/e:f	Landroid/graphics/SurfaceTexture;
    //   31: ifnull +12 -> 43
    //   34: aload_0
    //   35: getfield 43	com/tencent/liteav/basic/d/e:e	[I
    //   38: astore_2
    //   39: aload_2
    //   40: ifnonnull +11 -> 51
    //   43: aload_0
    //   44: monitorexit
    //   45: ldc 225
    //   47: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: aload_0
    //   52: getfield 45	com/tencent/liteav/basic/d/e:f	Landroid/graphics/SurfaceTexture;
    //   55: invokevirtual 232	android/graphics/SurfaceTexture:updateTexImage	()V
    //   58: aload_0
    //   59: getfield 45	com/tencent/liteav/basic/d/e:f	Landroid/graphics/SurfaceTexture;
    //   62: new 234	com/tencent/liteav/basic/d/e$1
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 235	com/tencent/liteav/basic/d/e$1:<init>	(Lcom/tencent/liteav/basic/d/e;)V
    //   70: invokevirtual 167	android/graphics/SurfaceTexture:setOnFrameAvailableListener	(Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: ldc 225
    //   77: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: ldc 225
    //   86: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_2
    //   90: athrow
    //   91: astore_2
    //   92: goto -34 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	e
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
    AppMethodBeat.i(146535);
    h();
    AppMethodBeat.o(146535);
  }
  
  public void d()
  {
    AppMethodBeat.i(146536);
    a(102, 5L);
    if (!i())
    {
      AppMethodBeat.o(146536);
      return;
    }
    if ((this.f == null) || (this.e == null))
    {
      AppMethodBeat.o(146536);
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
      AppMethodBeat.o(146536);
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
    AppMethodBeat.i(146537);
    g();
    AppMethodBeat.o(146537);
  }
  
  /* Error */
  public javax.microedition.khronos.egl.EGLContext getGLContext()
  {
    // Byte code:
    //   0: ldc_w 266
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 41	com/tencent/liteav/basic/d/e:c	Lcom/tencent/liteav/basic/d/f;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 41	com/tencent/liteav/basic/d/e:c	Lcom/tencent/liteav/basic/d/f;
    //   19: invokevirtual 268	com/tencent/liteav/basic/d/f:a	()Ljavax/microedition/khronos/egl/EGLContext;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: ldc_w 266
    //   28: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_1
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -12 -> 23
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: ldc_w 266
    //   44: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.basic.d.e
 * JD-Core Version:    0.7.0.1
 */