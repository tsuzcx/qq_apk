package com.tencent.liteav.basic.c;

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
    AppMethodBeat.i(222211);
    this.b = null;
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = false;
    this.a = 25;
    this.h = 0L;
    this.i = 0L;
    this.j = new float[16];
    AppMethodBeat.o(222211);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(222223);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(222223);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(222222);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessageDelayed(paramInt, paramLong);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(222222);
    }
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(222224);
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
      AppMethodBeat.o(222224);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(222220);
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
      AppMethodBeat.o(222220);
      return;
    }
    finally
    {
      AppMethodBeat.o(222220);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(222221);
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
      AppMethodBeat.o(222221);
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(222225);
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
    AppMethodBeat.o(222225);
  }
  
  private void h()
  {
    AppMethodBeat.i(222226);
    TXCLog.w("TXGLSurfaceTextureThread", "init surface texture ");
    this.e = new int[1];
    this.e[0] = j.b();
    if (this.e[0] <= 0)
    {
      this.e = null;
      AppMethodBeat.o(222226);
      return;
    }
    this.f = new SurfaceTexture(this.e[0]);
    this.f.setDefaultBufferSize(1280, 720);
    this.f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(222209);
        f.a(f.this, 103, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222309);
            f.a(f.this, true);
            f.a(f.this, 102);
            AppMethodBeat.o(222309);
          }
        });
        paramAnonymousSurfaceTexture.setOnFrameAvailableListener(null);
        AppMethodBeat.o(222209);
      }
    });
    n localn = this.d;
    if (localn != null) {
      localn.a(this.f);
    }
    AppMethodBeat.o(222226);
  }
  
  private boolean i()
  {
    AppMethodBeat.i(222227);
    if (!this.g)
    {
      this.h = 0L;
      this.i = System.nanoTime();
      AppMethodBeat.o(222227);
      return false;
    }
    long l = System.nanoTime();
    if (l < this.i + this.h * 1000L * 1000L * 1000L / this.a)
    {
      AppMethodBeat.o(222227);
      return false;
    }
    if (this.i == 0L) {
      this.i = l;
    }
    for (;;)
    {
      this.h += 1L;
      AppMethodBeat.o(222227);
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
    AppMethodBeat.i(222213);
    f();
    AppMethodBeat.o(222213);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(222212);
    this.a = paramInt;
    b();
    AppMethodBeat.o(222212);
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(222215);
    try
    {
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(222215);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(222216);
    try
    {
      if (this.c != null) {
        this.c.removeCallbacksAndMessages(null);
      }
      this.g = false;
      if (this.f != null)
      {
        int[] arrayOfInt = this.e;
        if (arrayOfInt != null) {}
      }
      else
      {
        return;
      }
      this.f.updateTexImage();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e("TXGLSurfaceTextureThread", "updateTexImage failed." + localException.getMessage());
      }
    }
    finally
    {
      AppMethodBeat.o(222216);
    }
    this.f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(222191);
        f.a(f.this, 103, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222189);
            f.a(f.this, true);
            f.a(f.this, 102);
            AppMethodBeat.o(222189);
          }
        });
        paramAnonymousSurfaceTexture.setOnFrameAvailableListener(null);
        AppMethodBeat.o(222191);
      }
    });
    AppMethodBeat.o(222216);
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void c()
  {
    AppMethodBeat.i(222217);
    h();
    AppMethodBeat.o(222217);
  }
  
  public void d()
  {
    AppMethodBeat.i(222218);
    a(102, 5L);
    if (!i())
    {
      AppMethodBeat.o(222218);
      return;
    }
    if ((this.f == null) || (this.e == null))
    {
      AppMethodBeat.o(222218);
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
      AppMethodBeat.o(222218);
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
    AppMethodBeat.i(222219);
    g();
    AppMethodBeat.o(222219);
  }
  
  /* Error */
  public javax.microedition.khronos.egl.EGLContext getGLContext()
  {
    // Byte code:
    //   0: ldc_w 272
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 49	com/tencent/liteav/basic/c/f:c	Lcom/tencent/liteav/basic/c/g;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 49	com/tencent/liteav/basic/c/f:c	Lcom/tencent/liteav/basic/c/g;
    //   19: invokevirtual 274	com/tencent/liteav/basic/c/g:a	()Ljavax/microedition/khronos/egl/EGLContext;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: ldc_w 272
    //   28: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_1
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -12 -> 23
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: ldc_w 272
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.c.f
 * JD-Core Version:    0.7.0.1
 */