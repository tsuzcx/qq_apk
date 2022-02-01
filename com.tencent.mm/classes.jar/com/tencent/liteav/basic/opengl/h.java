package com.tencent.liteav.basic.opengl;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  implements i.a, n
{
  public int a;
  private volatile HandlerThread b;
  private volatile i c;
  private o d;
  private int[] e;
  private SurfaceTexture f;
  private boolean g;
  private long h;
  private long i;
  private float[] j;
  
  public h()
  {
    AppMethodBeat.i(230180);
    this.b = null;
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = false;
    this.a = 25;
    this.h = 0L;
    this.i = 0L;
    this.j = new float[16];
    AppMethodBeat.o(230180);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(230209);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(230209);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(230200);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessageDelayed(paramInt, paramLong);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(230200);
    }
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(230216);
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
      AppMethodBeat.o(230216);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(230187);
    f();
    try
    {
      this.b = new HandlerThread("TXGLSurfaceTextureThread");
      this.b.start();
      this.c = new i(this.b.getLooper());
      this.c.a(this);
      this.c.a = 1280;
      this.c.b = 720;
      TXCLog.w("TXGLSurfaceTextureThread", "create gl thread " + this.b.getName());
      a(100);
      AppMethodBeat.o(230187);
      return;
    }
    finally
    {
      AppMethodBeat.o(230187);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(230194);
    try
    {
      if (this.c != null)
      {
        i.a(this.c, this.b);
        TXCLog.w("TXGLSurfaceTextureThread", "destroy gl thread");
      }
      this.c = null;
      this.b = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(230194);
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(230223);
    TXCLog.w("TXGLSurfaceTextureThread", "destroy surface texture ");
    o localo = this.d;
    if (localo != null) {
      localo.b(this.f);
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
    AppMethodBeat.o(230223);
  }
  
  private void h()
  {
    AppMethodBeat.i(230228);
    TXCLog.w("TXGLSurfaceTextureThread", "init surface texture ");
    this.e = new int[1];
    this.e[0] = TXCOpenGlUtils.b();
    if (this.e[0] <= 0)
    {
      this.e = null;
      AppMethodBeat.o(230228);
      return;
    }
    this.f = new SurfaceTexture(this.e[0]);
    this.f.setDefaultBufferSize(1280, 720);
    this.f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(230318);
        h.a(h.this, 103, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230211);
            h.a(h.this, true);
            h.a(h.this, 102);
            AppMethodBeat.o(230211);
          }
        });
        paramAnonymousSurfaceTexture.setOnFrameAvailableListener(null);
        AppMethodBeat.o(230318);
      }
    });
    o localo = this.d;
    if (localo != null) {
      localo.a(this.f);
    }
    AppMethodBeat.o(230228);
  }
  
  private boolean i()
  {
    AppMethodBeat.i(230236);
    if (!this.g)
    {
      this.h = 0L;
      this.i = System.nanoTime();
      AppMethodBeat.o(230236);
      return false;
    }
    long l = System.nanoTime();
    if (l < this.i + this.h * 1000L * 1000L * 1000L / this.a)
    {
      AppMethodBeat.o(230236);
      return false;
    }
    if (this.i == 0L) {
      this.i = l;
    }
    for (;;)
    {
      this.h += 1L;
      AppMethodBeat.o(230236);
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
    AppMethodBeat.i(230269);
    f();
    AppMethodBeat.o(230269);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(230260);
    this.a = paramInt;
    b();
    AppMethodBeat.o(230260);
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(230297);
    try
    {
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(230297);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(230304);
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
      AppMethodBeat.o(230304);
    }
    this.f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(230335);
        h.a(h.this, 103, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230290);
            h.a(h.this, true);
            h.a(h.this, 102);
            AppMethodBeat.o(230290);
          }
        });
        paramAnonymousSurfaceTexture.setOnFrameAvailableListener(null);
        AppMethodBeat.o(230335);
      }
    });
    AppMethodBeat.o(230304);
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void c()
  {
    AppMethodBeat.i(230333);
    h();
    AppMethodBeat.o(230333);
  }
  
  public void d()
  {
    AppMethodBeat.i(230343);
    a(102, 5L);
    if (!i())
    {
      AppMethodBeat.o(230343);
      return;
    }
    if ((this.f == null) || (this.e == null))
    {
      AppMethodBeat.o(230343);
      return;
    }
    try
    {
      this.f.updateTexImage();
      this.f.getTransformMatrix(this.j);
      o localo = this.d;
      if (localo != null) {
        localo.a(this.e[0], this.j);
      }
      AppMethodBeat.o(230343);
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
    AppMethodBeat.i(230348);
    g();
    AppMethodBeat.o(230348);
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
    //   9: getfield 49	com/tencent/liteav/basic/opengl/h:c	Lcom/tencent/liteav/basic/opengl/i;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 49	com/tencent/liteav/basic/opengl/h:c	Lcom/tencent/liteav/basic/opengl/i;
    //   19: invokevirtual 274	com/tencent/liteav/basic/opengl/i:a	()Ljavax/microedition/khronos/egl/EGLContext;
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
    //   0	49	0	this	h
    //   22	13	1	localEGLContext	javax.microedition.khronos.egl.EGLContext
    //   38	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	23	38	finally
    //   23	25	38	finally
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.f;
  }
  
  public void setRendMirror(int paramInt) {}
  
  public void setRendMode(int paramInt) {}
  
  public void setSurfaceTextureListener(o paramo)
  {
    this.d = paramo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.h
 * JD-Core Version:    0.7.0.1
 */