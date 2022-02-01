package com.tencent.liteav.basic.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
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
  private int j = 0;
  private int k = 0;
  private boolean l = false;
  private n m = null;
  private boolean n = false;
  
  private void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14551);
    final int i3;
    final int i1;
    label57:
    int i2;
    if (this.l) {
      if ((this.j != 0) && (this.k != 0))
      {
        if (this.j > this.k) {
          break label185;
        }
        i3 = 1;
        if (this.k < this.j) {
          break label191;
        }
        i1 = this.k;
        if (this.k < this.j) {
          break label199;
        }
        i2 = this.j;
        label74:
        if (i3 == 0) {
          break label208;
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
      final n localn = this.m;
      if (localn != null) {
        new Thread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14496);
            localByteBuffer.position(0);
            localBitmap.copyPixelsFromBuffer(localByteBuffer);
            Object localObject = new Matrix();
            ((Matrix)localObject).setScale(1.0F, -1.0F);
            localObject = Bitmap.createBitmap(localBitmap, 0, 0, i1, i3, (Matrix)localObject, false);
            localn.onTakePhotoComplete((Bitmap)localObject);
            localBitmap.recycle();
            AppMethodBeat.o(14496);
          }
        }).start();
      }
      this.m = null;
      this.l = false;
      AppMethodBeat.o(14551);
      return;
      label185:
      i3 = 0;
      break;
      label191:
      i1 = this.j;
      break label57;
      label199:
      i2 = this.k;
      break label74;
      label208:
      i3 = i2;
    }
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
  
  private void b(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(14550);
    if ((paramInt5 == 0) || (paramInt6 == 0) || (this.c == null))
    {
      AppMethodBeat.o(14550);
      return;
    }
    if (this.n)
    {
      this.n = false;
      AppMethodBeat.o(14550);
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
      this.n = true;
    }
    label102:
    int i1;
    int i2;
    if (paramInt3 != 0)
    {
      if (paramInt4 == 0) {
        break label428;
      }
      if (this.h != 0) {
        break label435;
      }
      i1 = 0;
      i2 = 0;
    }
    for (;;)
    {
      this.j = paramInt3;
      this.k = paramInt4;
      GLES20.glViewport(i2, i1, paramInt3, paramInt4);
      label160:
      label163:
      float f1;
      label177:
      float f2;
      label191:
      int i3;
      label282:
      label290:
      label294:
      Object localObject;
      if (this.i == 1)
      {
        paramBoolean2 = paramBoolean1;
        if (!paramBoolean3)
        {
          if (!paramBoolean1)
          {
            paramBoolean1 = true;
            paramBoolean2 = paramBoolean1;
          }
        }
        else
        {
          if (paramInt4 == 0) {
            break label595;
          }
          f1 = paramInt3 / paramInt4;
          if (paramInt6 == 0) {
            break label601;
          }
          f2 = paramInt5 / paramInt6;
          if ((this.e != paramBoolean2) || (this.d != paramInt2) || (this.f != f1) || (this.g != f2))
          {
            this.e = paramBoolean2;
            this.d = paramInt2;
            this.f = f1;
            this.g = f2;
            int i4 = (720 - this.d) % 360;
            if ((i4 != 90) && (i4 != 270)) {
              break label607;
            }
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label612;
            }
            i3 = paramInt4;
            if (paramInt2 == 0) {
              break label619;
            }
            localObject = this.c;
            float[] arrayOfFloat = k.a(j.a, false, true);
            f1 = i3 / paramInt3;
            if (paramInt2 == 0) {
              break label626;
            }
            paramBoolean1 = false;
            label325:
            if (paramInt2 == 0) {
              break label634;
            }
            paramBoolean2 = this.e;
            label335:
            ((g)localObject).a(paramInt5, paramInt6, i4, arrayOfFloat, f1, paramBoolean1, paramBoolean2);
            if (paramInt2 == 0) {
              break label640;
            }
            this.c.g();
          }
        }
      }
      for (;;)
      {
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        GLES20.glBindFramebuffer(36160, 0);
        this.c.a(paramInt1);
        a(i2, i1);
        if (this.b != null) {
          this.b.c();
        }
        AppMethodBeat.o(14550);
        return;
        paramInt3 = paramInt5;
        break;
        label428:
        paramInt4 = paramInt6;
        break label102;
        label435:
        if (this.h != 1) {
          break label650;
        }
        i1 = (720 - this.d) % 360;
        if ((i1 == 90) || (i1 == 270))
        {
          i2 = 1;
          label475:
          if (i2 == 0) {
            break label540;
          }
          i1 = paramInt6;
          label484:
          if (i2 == 0) {
            break label547;
          }
        }
        label540:
        label547:
        for (i2 = paramInt5;; i2 = paramInt6)
        {
          localObject = a(paramInt3, paramInt4, i1, i2);
          paramInt3 = localObject[0];
          paramInt4 = localObject[1];
          i2 = localObject[2];
          i1 = localObject[3];
          break;
          i2 = 0;
          break label475;
          i1 = paramInt5;
          break label484;
        }
        paramBoolean1 = false;
        break label160;
        paramBoolean2 = paramBoolean1;
        if (this.i != 2) {
          break label163;
        }
        paramBoolean2 = paramBoolean1;
        if (!paramBoolean3) {
          break label163;
        }
        if (!paramBoolean1) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          paramBoolean2 = paramBoolean1;
          break;
        }
        label595:
        f1 = 1.0F;
        break label177;
        label601:
        f2 = 1.0F;
        break label191;
        label607:
        paramInt2 = 0;
        break label282;
        label612:
        i3 = paramInt3;
        break label290;
        label619:
        paramInt3 = paramInt4;
        break label294;
        label626:
        paramBoolean1 = this.e;
        break label325;
        label634:
        paramBoolean2 = false;
        break label335;
        label640:
        this.c.h();
      }
      label650:
      i1 = 0;
      i2 = 0;
    }
  }
  
  private void b(EGLContext paramEGLContext, Surface paramSurface)
  {
    AppMethodBeat.i(14547);
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
      c(100);
      AppMethodBeat.o(14547);
      return;
    }
    finally
    {
      AppMethodBeat.o(14547);
    }
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(14549);
    try
    {
      if (this.b != null) {
        this.b.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14549);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(14548);
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
      AppMethodBeat.o(14548);
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(14539);
    TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render stop ".concat(String.valueOf(this)));
    f();
    AppMethodBeat.o(14539);
  }
  
  public void a(final int paramInt)
  {
    AppMethodBeat.i(14541);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14553);
        d.a(d.this, paramInt);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        AppMethodBeat.o(14553);
      }
    });
    AppMethodBeat.o(14541);
  }
  
  public void a(final int paramInt1, final boolean paramBoolean1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final int paramInt6, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(14544);
    GLES20.glFinish();
    try
    {
      if (this.b != null) {
        this.b.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14506);
            try
            {
              d.a(d.this, paramInt1, paramBoolean1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean2, paramBoolean3);
              AppMethodBeat.o(14506);
              return;
            }
            catch (Exception localException)
            {
              TXCLog.e("TXGLSurfaceRenderThread", "surface-render: render texture error occurred!");
              AppMethodBeat.o(14506);
            }
          }
        });
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14544);
    }
  }
  
  public void a(n paramn)
  {
    this.m = paramn;
    this.l = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(14543);
    try
    {
      if (this.b != null) {
        this.b.post(paramRunnable);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(14543);
    }
  }
  
  public void a(EGLContext paramEGLContext, Surface paramSurface)
  {
    AppMethodBeat.i(14538);
    TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render start " + paramSurface + ", " + this);
    b(paramEGLContext, paramSurface);
    AppMethodBeat.o(14538);
  }
  
  /* Error */
  public Surface b()
  {
    // Byte code:
    //   0: sipush 14540
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 43	com/tencent/liteav/basic/d/d:b	Lcom/tencent/liteav/basic/d/f;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 43	com/tencent/liteav/basic/d/d:b	Lcom/tencent/liteav/basic/d/f;
    //   19: invokevirtual 268	com/tencent/liteav/basic/d/f:b	()Landroid/view/Surface;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: sipush 14540
    //   28: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_1
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -12 -> 23
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: sipush 14540
    //   44: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	d
    //   22	13	1	localSurface	Surface
    //   38	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	23	38	finally
    //   23	25	38	finally
    //   39	41	38	finally
  }
  
  public void b(final int paramInt)
  {
    AppMethodBeat.i(14542);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14501);
        d.b(d.this, paramInt);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        AppMethodBeat.o(14501);
      }
    });
    AppMethodBeat.o(14542);
  }
  
  public void c()
  {
    AppMethodBeat.i(14545);
    this.c = new g();
    if (!this.c.a())
    {
      AppMethodBeat.o(14545);
      return;
    }
    this.c.a(k.e, k.a(j.a, false, false));
    AppMethodBeat.o(14545);
  }
  
  public void d() {}
  
  public void e()
  {
    AppMethodBeat.i(14546);
    if (this.c != null)
    {
      this.c.d();
      this.c = null;
    }
    AppMethodBeat.o(14546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.d
 * JD-Core Version:    0.7.0.1
 */