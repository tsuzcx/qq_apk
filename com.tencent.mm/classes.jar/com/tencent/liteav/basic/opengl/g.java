package com.tencent.liteav.basic.opengl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class g
  implements i.a
{
  private volatile HandlerThread a = null;
  private volatile i b = null;
  private j c = null;
  private int d = 0;
  private boolean e = false;
  private float f = 1.0F;
  private float g = 1.0F;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private boolean l = false;
  private p m = null;
  private boolean n = false;
  
  private void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230246);
    final int i3;
    final int i1;
    label56:
    int i2;
    if (this.l) {
      if ((this.j != 0) && (this.k != 0))
      {
        if (this.j > this.k) {
          break label183;
        }
        i3 = 1;
        if (this.k < this.j) {
          break label189;
        }
        i1 = this.k;
        if (this.k < this.j) {
          break label197;
        }
        i2 = this.j;
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
      final p localp = this.m;
      if (localp != null) {
        new Thread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230282);
            localByteBuffer.position(0);
            localBitmap.copyPixelsFromBuffer(localByteBuffer);
            Object localObject = new Matrix();
            ((Matrix)localObject).setScale(1.0F, -1.0F);
            localObject = Bitmap.createBitmap(localBitmap, 0, 0, i1, i3, (Matrix)localObject, false);
            localp.onTakePhotoComplete((Bitmap)localObject);
            localBitmap.recycle();
            AppMethodBeat.o(230282);
          }
        }).start();
      }
      this.m = null;
      this.l = false;
      AppMethodBeat.o(230246);
      return;
      label183:
      i3 = 0;
      break;
      label189:
      i1 = this.j;
      break label56;
      label197:
      i2 = this.k;
      break label73;
      label206:
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
    AppMethodBeat.i(230233);
    if ((paramInt5 == 0) || (paramInt6 == 0) || (this.c == null))
    {
      AppMethodBeat.o(230233);
      return;
    }
    if (this.n)
    {
      this.n = false;
      AppMethodBeat.o(230233);
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
    label99:
    int i1;
    int i2;
    if (paramInt3 != 0)
    {
      if (paramInt4 == 0) {
        break label424;
      }
      if (this.h != 0) {
        break label431;
      }
      i1 = 0;
      i2 = 0;
    }
    for (;;)
    {
      this.j = paramInt3;
      this.k = paramInt4;
      GLES20.glViewport(i2, i1, paramInt3, paramInt4);
      label157:
      label160:
      float f1;
      label174:
      float f2;
      label188:
      int i3;
      label279:
      label287:
      label291:
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
            break label588;
          }
          f1 = paramInt3 / paramInt4;
          if (paramInt6 == 0) {
            break label594;
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
              break label600;
            }
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label605;
            }
            i3 = paramInt4;
            if (paramInt2 == 0) {
              break label612;
            }
            localObject = this.c;
            float[] arrayOfFloat = m.a(l.a, false, true);
            f1 = i3 / paramInt3;
            if (paramInt2 == 0) {
              break label619;
            }
            paramBoolean1 = false;
            label322:
            if (paramInt2 == 0) {
              break label627;
            }
            paramBoolean2 = this.e;
            label332:
            ((j)localObject).a(paramInt5, paramInt6, i4, arrayOfFloat, f1, paramBoolean1, paramBoolean2);
            if (paramInt2 == 0) {
              break label633;
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
        AppMethodBeat.o(230233);
        return;
        paramInt3 = paramInt5;
        break;
        label424:
        paramInt4 = paramInt6;
        break label99;
        label431:
        if (this.h != 1) {
          break label643;
        }
        i1 = (720 - paramInt2) % 360;
        if ((i1 == 90) || (i1 == 270))
        {
          i2 = 1;
          label468:
          if (i2 == 0) {
            break label533;
          }
          i1 = paramInt6;
          label477:
          if (i2 == 0) {
            break label540;
          }
        }
        label533:
        label540:
        for (i2 = paramInt5;; i2 = paramInt6)
        {
          localObject = a(paramInt3, paramInt4, i1, i2);
          paramInt3 = localObject[0];
          paramInt4 = localObject[1];
          i2 = localObject[2];
          i1 = localObject[3];
          break;
          i2 = 0;
          break label468;
          i1 = paramInt5;
          break label477;
        }
        paramBoolean1 = false;
        break label157;
        paramBoolean2 = paramBoolean1;
        if (this.i != 2) {
          break label160;
        }
        paramBoolean2 = paramBoolean1;
        if (!paramBoolean3) {
          break label160;
        }
        if (!paramBoolean1) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          paramBoolean2 = paramBoolean1;
          break;
        }
        label588:
        f1 = 1.0F;
        break label174;
        label594:
        f2 = 1.0F;
        break label188;
        label600:
        paramInt2 = 0;
        break label279;
        label605:
        i3 = paramInt3;
        break label287;
        label612:
        paramInt3 = paramInt4;
        break label291;
        label619:
        paramBoolean1 = this.e;
        break label322;
        label627:
        paramBoolean2 = false;
        break label332;
        label633:
        this.c.h();
      }
      label643:
      i1 = 0;
      i2 = 0;
    }
  }
  
  /* Error */
  private void b(Object paramObject, Surface paramSurface)
  {
    // Byte code:
    //   0: ldc 172
    //   2: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 174	com/tencent/liteav/basic/opengl/g:f	()V
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: new 176	android/os/HandlerThread
    //   15: dup
    //   16: ldc 178
    //   18: invokespecial 181	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   21: putfield 41	com/tencent/liteav/basic/opengl/g:a	Landroid/os/HandlerThread;
    //   24: aload_0
    //   25: getfield 41	com/tencent/liteav/basic/opengl/g:a	Landroid/os/HandlerThread;
    //   28: invokevirtual 182	android/os/HandlerThread:start	()V
    //   31: aload_0
    //   32: new 138	com/tencent/liteav/basic/opengl/i
    //   35: dup
    //   36: aload_0
    //   37: getfield 41	com/tencent/liteav/basic/opengl/g:a	Landroid/os/HandlerThread;
    //   40: invokevirtual 186	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   43: invokespecial 189	com/tencent/liteav/basic/opengl/i:<init>	(Landroid/os/Looper;)V
    //   46: putfield 43	com/tencent/liteav/basic/opengl/g:b	Lcom/tencent/liteav/basic/opengl/i;
    //   49: aload_0
    //   50: getfield 43	com/tencent/liteav/basic/opengl/g:b	Lcom/tencent/liteav/basic/opengl/i;
    //   53: aload_0
    //   54: invokevirtual 192	com/tencent/liteav/basic/opengl/i:a	(Lcom/tencent/liteav/basic/opengl/i$a;)V
    //   57: aload_1
    //   58: ifnull +10 -> 68
    //   61: aload_1
    //   62: instanceof 194
    //   65: ifeq +71 -> 136
    //   68: aload_0
    //   69: getfield 43	com/tencent/liteav/basic/opengl/g:b	Lcom/tencent/liteav/basic/opengl/i;
    //   72: iconst_0
    //   73: putfield 196	com/tencent/liteav/basic/opengl/i:d	Z
    //   76: aload_0
    //   77: getfield 43	com/tencent/liteav/basic/opengl/g:b	Lcom/tencent/liteav/basic/opengl/i;
    //   80: aload_1
    //   81: checkcast 194	javax/microedition/khronos/egl/EGLContext
    //   84: putfield 199	com/tencent/liteav/basic/opengl/i:h	Ljavax/microedition/khronos/egl/EGLContext;
    //   87: aload_0
    //   88: getfield 43	com/tencent/liteav/basic/opengl/g:b	Lcom/tencent/liteav/basic/opengl/i;
    //   91: aload_2
    //   92: putfield 202	com/tencent/liteav/basic/opengl/i:c	Landroid/view/Surface;
    //   95: ldc 178
    //   97: new 204	java/lang/StringBuilder
    //   100: dup
    //   101: ldc 206
    //   103: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 41	com/tencent/liteav/basic/opengl/g:a	Landroid/os/HandlerThread;
    //   110: invokevirtual 211	android/os/HandlerThread:getName	()Ljava/lang/String;
    //   113: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 224	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_0
    //   125: bipush 100
    //   127: invokespecial 226	com/tencent/liteav/basic/opengl/g:c	(I)V
    //   130: ldc 172
    //   132: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: aload_0
    //   137: getfield 43	com/tencent/liteav/basic/opengl/g:b	Lcom/tencent/liteav/basic/opengl/i;
    //   140: iconst_1
    //   141: putfield 196	com/tencent/liteav/basic/opengl/i:d	Z
    //   144: aload_0
    //   145: getfield 43	com/tencent/liteav/basic/opengl/g:b	Lcom/tencent/liteav/basic/opengl/i;
    //   148: aload_1
    //   149: checkcast 228	android/opengl/EGLContext
    //   152: putfield 231	com/tencent/liteav/basic/opengl/i:f	Landroid/opengl/EGLContext;
    //   155: goto -68 -> 87
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: ldc 172
    //   163: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	g
    //   0	168	1	paramObject	Object
    //   0	168	2	paramSurface	Surface
    // Exception table:
    //   from	to	target	type
    //   11	57	158	finally
    //   61	68	158	finally
    //   68	87	158	finally
    //   87	124	158	finally
    //   136	155	158	finally
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(230218);
    try
    {
      if (this.b != null) {
        this.b.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(230218);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(230212);
    try
    {
      if (this.b != null)
      {
        i.a(this.b, this.a);
        TXCLog.w("TXGLSurfaceRenderThread", "surface-render: destroy gl thread");
      }
      this.b = null;
      this.a = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(230212);
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(230284);
    TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render stop ".concat(String.valueOf(this)));
    f();
    AppMethodBeat.o(230284);
  }
  
  public void a(final int paramInt)
  {
    AppMethodBeat.i(230298);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230291);
        g.a(g.this, paramInt);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        AppMethodBeat.o(230291);
      }
    });
    AppMethodBeat.o(230298);
  }
  
  public void a(final int paramInt1, final boolean paramBoolean1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final int paramInt6, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(230319);
    GLES20.glFinish();
    try
    {
      if (this.b != null) {
        this.b.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230287);
            try
            {
              g.a(g.this, paramInt1, paramBoolean1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean2, paramBoolean3);
              AppMethodBeat.o(230287);
              return;
            }
            catch (Exception localException)
            {
              TXCLog.e("TXGLSurfaceRenderThread", "surface-render: render texture error occurred!" + localException.getMessage());
              AppMethodBeat.o(230287);
            }
          }
        });
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(230319);
    }
  }
  
  public void a(p paramp)
  {
    this.m = paramp;
    this.l = true;
  }
  
  public void a(Object paramObject, Surface paramSurface)
  {
    AppMethodBeat.i(230276);
    TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render start " + paramSurface + ", " + this);
    b(paramObject, paramSurface);
    AppMethodBeat.o(230276);
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(230310);
    try
    {
      if (this.b != null) {
        this.b.post(paramRunnable);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(230310);
    }
  }
  
  /* Error */
  public Surface b()
  {
    // Byte code:
    //   0: ldc_w 287
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 43	com/tencent/liteav/basic/opengl/g:b	Lcom/tencent/liteav/basic/opengl/i;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 43	com/tencent/liteav/basic/opengl/g:b	Lcom/tencent/liteav/basic/opengl/i;
    //   19: invokevirtual 289	com/tencent/liteav/basic/opengl/i:b	()Landroid/view/Surface;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: ldc_w 287
    //   28: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_1
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -12 -> 23
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: ldc_w 287
    //   44: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	g
    //   22	13	1	localSurface	Surface
    //   38	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	23	38	finally
    //   23	25	38	finally
  }
  
  public void b(final int paramInt)
  {
    AppMethodBeat.i(230303);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230265);
        g.b(g.this, paramInt);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        AppMethodBeat.o(230265);
      }
    });
    AppMethodBeat.o(230303);
  }
  
  public void c()
  {
    AppMethodBeat.i(230329);
    this.c = new j();
    if (!this.c.a())
    {
      AppMethodBeat.o(230329);
      return;
    }
    this.c.a(m.e, m.a(l.a, false, false));
    AppMethodBeat.o(230329);
  }
  
  public void d() {}
  
  public void e()
  {
    AppMethodBeat.i(230341);
    if (this.c != null)
    {
      this.c.d();
      this.c = null;
    }
    AppMethodBeat.o(230341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.g
 * JD-Core Version:    0.7.0.1
 */