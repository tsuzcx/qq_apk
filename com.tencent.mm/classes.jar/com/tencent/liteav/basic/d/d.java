package com.tencent.liteav.basic.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

public class d
  implements f.a
{
  private volatile HandlerThread a = null;
  private volatile f b = null;
  private g c = null;
  private int d = 0;
  private boolean e = false;
  private float f = 1.0F;
  private float g = 1.0F;
  private int h = 0;
  private int i = 0;
  private boolean j = false;
  private n k = null;
  private boolean l = false;
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(146492);
    try
    {
      if (this.b != null) {
        this.b.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(146492);
    }
  }
  
  private void b(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2)
  {
    AppMethodBeat.i(146493);
    if ((paramInt5 == 0) || (paramInt6 == 0) || (this.c == null))
    {
      AppMethodBeat.o(146493);
      return;
    }
    if (this.l)
    {
      this.l = false;
      AppMethodBeat.o(146493);
      return;
    }
    if (paramBoolean2)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      GLES20.glBindFramebuffer(36160, 0);
      if (this.b != null) {
        this.b.c();
      }
      this.l = true;
    }
    label99:
    float f1;
    label134:
    float f2;
    label148:
    label237:
    int m;
    if (paramInt3 != 0)
    {
      if (paramInt4 == 0) {
        break label382;
      }
      this.h = paramInt3;
      this.i = paramInt4;
      GLES20.glViewport(0, 0, paramInt3, paramInt4);
      if (paramInt4 == 0) {
        break label389;
      }
      f1 = paramInt3 / paramInt4;
      if (paramInt6 == 0) {
        break label395;
      }
      f2 = paramInt5 / paramInt6;
      if ((this.e != paramBoolean1) || (this.d != paramInt2) || (this.f != f1) || (this.g != f2))
      {
        this.e = paramBoolean1;
        this.d = paramInt2;
        this.f = f1;
        this.g = f2;
        int n = (720 - this.d) % 360;
        if ((n != 90) && (n != 270)) {
          break label401;
        }
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label406;
        }
        m = paramInt4;
        label245:
        if (paramInt2 != 0) {
          paramInt4 = paramInt3;
        }
        g localg = this.c;
        float[] arrayOfFloat = k.a(j.a, false, true);
        f1 = m / paramInt4;
        if (paramInt2 == 0) {
          break label413;
        }
        paramBoolean1 = false;
        label284:
        if (paramInt2 == 0) {
          break label421;
        }
        paramBoolean2 = this.e;
        label294:
        localg.a(paramInt5, paramInt6, n, arrayOfFloat, f1, paramBoolean1, paramBoolean2);
        if (paramInt2 == 0) {
          break label427;
        }
        this.c.g();
      }
    }
    for (;;)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      GLES20.glBindFramebuffer(36160, 0);
      this.c.a(paramInt1);
      g();
      if (this.b != null) {
        this.b.c();
      }
      AppMethodBeat.o(146493);
      return;
      paramInt3 = paramInt5;
      break;
      label382:
      paramInt4 = paramInt6;
      break label99;
      label389:
      f1 = 1.0F;
      break label134;
      label395:
      f2 = 1.0F;
      break label148;
      label401:
      paramInt2 = 0;
      break label237;
      label406:
      m = paramInt3;
      break label245;
      label413:
      paramBoolean1 = this.e;
      break label284;
      label421:
      paramBoolean2 = false;
      break label294;
      label427:
      this.c.h();
    }
  }
  
  private void b(EGLContext paramEGLContext, Surface paramSurface)
  {
    AppMethodBeat.i(146490);
    f();
    try
    {
      this.a = new HandlerThread("TXGLSurfaceRenderThread");
      this.a.start();
      this.b = new f(this.a.getLooper());
      this.b.a(this);
      this.b.g = paramEGLContext;
      this.b.c = paramSurface;
      TXCLog.w("TXGLSurfaceRenderThread", "surface-render: create gl thread " + this.a.getName());
      a(100);
      AppMethodBeat.o(146490);
      return;
    }
    finally
    {
      AppMethodBeat.o(146490);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(146491);
    try
    {
      if (this.b != null)
      {
        f.a(this.b, this.a);
        TXCLog.w("TXGLSurfaceRenderThread", "surface-render: destroy gl thread");
      }
      this.b = null;
      this.a = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(146491);
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(146494);
    int i1;
    int m;
    label55:
    int n;
    if (this.j) {
      if ((this.h != 0) && (this.i != 0))
      {
        if (this.h > this.i) {
          break label174;
        }
        i1 = 1;
        if (this.i < this.h) {
          break label179;
        }
        m = this.i;
        if (this.i < this.h) {
          break label187;
        }
        n = this.h;
        label71:
        if (i1 == 0) {
          break label195;
        }
        i1 = m;
        m = n;
      }
    }
    for (;;)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(m * i1 * 4);
      Bitmap localBitmap = Bitmap.createBitmap(m, i1, Bitmap.Config.ARGB_8888);
      localByteBuffer.position(0);
      GLES20.glReadPixels(0, 0, m, i1, 6408, 5121, localByteBuffer);
      n localn = this.k;
      if (localn != null) {
        new Thread(new d.2(this, localByteBuffer, localBitmap, m, i1, localn)).start();
      }
      this.k = null;
      this.j = false;
      AppMethodBeat.o(146494);
      return;
      label174:
      i1 = 0;
      break;
      label179:
      m = this.h;
      break label55;
      label187:
      n = this.i;
      break label71;
      label195:
      i1 = n;
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(146484);
    TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render stop ");
    f();
    AppMethodBeat.o(146484);
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2)
  {
    AppMethodBeat.i(146487);
    GLES20.glFinish();
    try
    {
      if (this.b != null) {
        this.b.post(new d.1(this, paramInt1, paramBoolean1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean2));
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(146487);
    }
  }
  
  public void a(n paramn)
  {
    this.k = paramn;
    this.j = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(146486);
    try
    {
      if (this.b != null) {
        this.b.post(paramRunnable);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(146486);
    }
  }
  
  public void a(EGLContext paramEGLContext, Surface paramSurface)
  {
    AppMethodBeat.i(146483);
    TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render start ".concat(String.valueOf(paramSurface)));
    b(paramEGLContext, paramSurface);
    AppMethodBeat.o(146483);
  }
  
  /* Error */
  public Surface b()
  {
    // Byte code:
    //   0: ldc 252
    //   2: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 33	com/tencent/liteav/basic/d/d:b	Lcom/tencent/liteav/basic/d/f;
    //   11: ifnull +20 -> 31
    //   14: aload_0
    //   15: getfield 33	com/tencent/liteav/basic/d/d:b	Lcom/tencent/liteav/basic/d/f;
    //   18: invokevirtual 254	com/tencent/liteav/basic/d/f:b	()Landroid/view/Surface;
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: ldc 252
    //   26: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_1
    //   30: areturn
    //   31: aconst_null
    //   32: astore_1
    //   33: goto -11 -> 22
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: ldc 252
    //   41: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	d
    //   21	12	1	localSurface	Surface
    //   36	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	22	36	finally
    //   22	24	36	finally
    //   37	39	36	finally
  }
  
  public void c()
  {
    AppMethodBeat.i(146488);
    this.c = new g();
    if (!this.c.a())
    {
      AppMethodBeat.o(146488);
      return;
    }
    this.c.a(k.e, k.a(j.a, false, false));
    AppMethodBeat.o(146488);
  }
  
  public void d() {}
  
  public void e()
  {
    AppMethodBeat.i(146489);
    if (this.c != null)
    {
      this.c.d();
      this.c = null;
    }
    AppMethodBeat.o(146489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.basic.d.d
 * JD-Core Version:    0.7.0.1
 */