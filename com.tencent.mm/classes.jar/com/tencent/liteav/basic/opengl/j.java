package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class j
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected boolean g;
  protected FloatBuffer h;
  protected FloatBuffer i;
  protected float[] j;
  protected float[] k;
  protected a l;
  protected int m;
  protected int n;
  protected boolean o;
  protected boolean p;
  protected boolean q;
  private final LinkedList<Runnable> r;
  private final String s;
  private final String t;
  private boolean u;
  private int v;
  private float[] w;
  
  public j()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
  }
  
  public j(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, false);
  }
  
  public j(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(237397);
    this.u = false;
    this.v = -1;
    this.w = null;
    this.m = -1;
    this.n = -1;
    this.o = false;
    this.p = false;
    this.q = false;
    this.r = new LinkedList();
    this.s = paramString1;
    this.t = paramString2;
    this.q = paramBoolean;
    if (true == paramBoolean) {
      TXCLog.i("TXCGPUFilter", "set Oes fileter");
    }
    this.h = ByteBuffer.allocateDirect(m.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.j = m.e;
    this.h.put(this.j).position(0);
    this.i = ByteBuffer.allocateDirect(m.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.k = m.a(l.a, false, true);
    this.i.put(this.k).position(0);
    AppMethodBeat.o(237397);
  }
  
  private static float[] a(FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(237407);
    if (paramFloatBuffer.limit() <= 0)
    {
      AppMethodBeat.o(237407);
      return null;
    }
    float[] arrayOfFloat = new float[paramFloatBuffer.limit()];
    int i1 = 0;
    while (i1 < paramFloatBuffer.limit())
    {
      arrayOfFloat[i1] = paramFloatBuffer.get(i1);
      i1 += 1;
    }
    AppMethodBeat.o(237407);
    return arrayOfFloat;
  }
  
  public int a(int paramInt)
  {
    AppMethodBeat.i(237414);
    paramInt = b(paramInt, this.h, this.i);
    AppMethodBeat.o(237414);
    return paramInt;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(237416);
    if (!this.g)
    {
      AppMethodBeat.o(237416);
      return -1;
    }
    GLES20.glBindFramebuffer(36160, paramInt2);
    a(paramInt1, this.h, this.i);
    if ((this.l instanceof a)) {
      this.l.a(paramInt3);
    }
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(237416);
    return paramInt3;
  }
  
  public void a(final int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(237423);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(235841);
        GLES20.glUniform1f(paramInt, paramFloat);
        AppMethodBeat.o(235841);
      }
    });
    AppMethodBeat.o(237423);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237409);
    if ((this.f == paramInt2) && (this.e == paramInt1))
    {
      AppMethodBeat.o(237409);
      return;
    }
    this.e = paramInt1;
    this.f = paramInt2;
    if (this.o)
    {
      if (this.m != -1) {
        f();
      }
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      this.m = arrayOfInt[0];
      this.n = TXCOpenGlUtils.a(paramInt1, paramInt2, 6408, 6408);
      GLES20.glBindFramebuffer(36160, this.m);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.n, 0);
      GLES20.glBindFramebuffer(36160, 0);
    }
    AppMethodBeat.o(237409);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(237420);
    float[] arrayOfFloat = paramArrayOfFloat;
    if (paramArrayOfFloat == null) {
      arrayOfFloat = m.a(l.a, false, true);
    }
    int i2;
    int i1;
    if (paramInt1 / paramInt2 > paramFloat)
    {
      i2 = (int)(paramInt2 * paramFloat);
      i1 = paramInt2;
    }
    for (;;)
    {
      float f1 = i2 / paramInt1;
      paramFloat = i1 / paramInt2;
      f1 = (1.0F - f1) / 2.0F;
      paramFloat = (1.0F - paramFloat) / 2.0F;
      paramInt1 = 0;
      label80:
      if (paramInt1 < arrayOfFloat.length / 2)
      {
        if (arrayOfFloat[(paramInt1 * 2)] < 0.5F)
        {
          paramInt2 = paramInt1 * 2;
          arrayOfFloat[paramInt2] += f1;
          label116:
          if (arrayOfFloat[(paramInt1 * 2 + 1)] >= 0.5F) {
            break label197;
          }
          paramInt2 = paramInt1 * 2 + 1;
          arrayOfFloat[paramInt2] += paramFloat;
        }
        for (;;)
        {
          paramInt1 += 1;
          break label80;
          if (paramInt1 / paramInt2 >= paramFloat) {
            break label533;
          }
          i1 = (int)(paramInt1 / paramFloat);
          i2 = paramInt1;
          break;
          paramInt2 = paramInt1 * 2;
          arrayOfFloat[paramInt2] -= f1;
          break label116;
          paramInt2 = paramInt1 * 2 + 1;
          arrayOfFloat[paramInt2] -= paramFloat;
        }
      }
      label197:
      paramInt2 = paramInt3 / 90;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramFloat = arrayOfFloat[0];
        f1 = arrayOfFloat[1];
        arrayOfFloat[0] = arrayOfFloat[2];
        arrayOfFloat[1] = arrayOfFloat[3];
        arrayOfFloat[2] = arrayOfFloat[6];
        arrayOfFloat[3] = arrayOfFloat[7];
        arrayOfFloat[6] = arrayOfFloat[4];
        arrayOfFloat[7] = arrayOfFloat[5];
        arrayOfFloat[4] = paramFloat;
        arrayOfFloat[5] = f1;
        paramInt1 += 1;
      }
      if ((paramInt2 == 0) || (paramInt2 == 2))
      {
        if (paramBoolean1)
        {
          arrayOfFloat[0] = (1.0F - arrayOfFloat[0]);
          arrayOfFloat[2] = (1.0F - arrayOfFloat[2]);
          arrayOfFloat[4] = (1.0F - arrayOfFloat[4]);
          arrayOfFloat[6] = (1.0F - arrayOfFloat[6]);
        }
        if (paramBoolean2)
        {
          arrayOfFloat[1] = (1.0F - arrayOfFloat[1]);
          arrayOfFloat[3] = (1.0F - arrayOfFloat[3]);
          arrayOfFloat[5] = (1.0F - arrayOfFloat[5]);
          arrayOfFloat[7] = (1.0F - arrayOfFloat[7]);
        }
      }
      for (;;)
      {
        a((float[])m.e.clone(), arrayOfFloat);
        AppMethodBeat.o(237420);
        return;
        if (paramBoolean2)
        {
          arrayOfFloat[0] = (1.0F - arrayOfFloat[0]);
          arrayOfFloat[2] = (1.0F - arrayOfFloat[2]);
          arrayOfFloat[4] = (1.0F - arrayOfFloat[4]);
          arrayOfFloat[6] = (1.0F - arrayOfFloat[6]);
        }
        if (paramBoolean1)
        {
          arrayOfFloat[1] = (1.0F - arrayOfFloat[1]);
          arrayOfFloat[3] = (1.0F - arrayOfFloat[3]);
          arrayOfFloat[5] = (1.0F - arrayOfFloat[5]);
          arrayOfFloat[7] = (1.0F - arrayOfFloat[7]);
        }
      }
      label533:
      i1 = paramInt2;
      i2 = paramInt1;
    }
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(237421);
    if (paramFloatBuffer == null) {}
    for (paramFloatBuffer = m.a(l.a, false, true);; paramFloatBuffer = a(paramFloatBuffer))
    {
      int i1 = paramInt / 90;
      paramInt = 0;
      while (paramInt < i1)
      {
        float f1 = paramFloatBuffer[0];
        float f2 = paramFloatBuffer[1];
        paramFloatBuffer[0] = paramFloatBuffer[2];
        paramFloatBuffer[1] = paramFloatBuffer[3];
        paramFloatBuffer[2] = paramFloatBuffer[6];
        paramFloatBuffer[3] = paramFloatBuffer[7];
        paramFloatBuffer[6] = paramFloatBuffer[4];
        paramFloatBuffer[7] = paramFloatBuffer[5];
        paramFloatBuffer[4] = f1;
        paramFloatBuffer[5] = f2;
        paramInt += 1;
      }
    }
    a((float[])m.e.clone(), paramFloatBuffer);
    AppMethodBeat.o(237421);
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(237410);
    GLES20.glUseProgram(this.a);
    k();
    if (!this.g)
    {
      AppMethodBeat.o(237410);
      return;
    }
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.b);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.d);
    if ((this.v >= 0) && (this.w != null)) {
      GLES20.glUniformMatrix4fv(this.v, 1, false, this.w, 0);
    }
    if (paramInt != -1)
    {
      GLES20.glActiveTexture(33984);
      if (true != this.q) {
        break label193;
      }
      GLES20.glBindTexture(36197, paramInt);
    }
    for (;;)
    {
      GLES20.glUniform1i(this.c, 0);
      i();
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.b);
      GLES20.glDisableVertexAttribArray(this.d);
      j();
      if (true != this.q) {
        break;
      }
      GLES20.glBindTexture(36197, 0);
      AppMethodBeat.o(237410);
      return;
      label193:
      GLES20.glBindTexture(3553, paramInt);
    }
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(237410);
  }
  
  public void a(final int paramInt, final float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(237424);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(237440);
        GLES20.glUniform2fv(paramInt, 1, FloatBuffer.wrap(paramArrayOfFloat));
        AppMethodBeat.o(237440);
      }
    });
    AppMethodBeat.o(237424);
  }
  
  public void a(a parama)
  {
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.u = bool;
      this.l = parama;
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(237427);
    synchronized (this.r)
    {
      this.r.addLast(paramRunnable);
      AppMethodBeat.o(237427);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.w = paramArrayOfFloat;
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(237418);
    this.j = paramArrayOfFloat1;
    this.h = ByteBuffer.allocateDirect(m.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.h.put(paramArrayOfFloat1).position(0);
    this.k = paramArrayOfFloat2;
    this.i = ByteBuffer.allocateDirect(m.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.i.put(paramArrayOfFloat2).position(0);
    AppMethodBeat.o(237418);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(237399);
    this.a = TXCOpenGlUtils.a(this.s, this.t);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(237399);
      return bool;
    }
  }
  
  public float[] a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, a parama, int paramInt3)
  {
    int i1 = 0;
    AppMethodBeat.i(237419);
    float f2;
    float f4;
    if (paramFloatBuffer == null) {
      if (4 == paramInt3)
      {
        paramFloatBuffer = m.a(l.a, false, false);
        if (parama == null) {
          break label225;
        }
        float f1 = parama.a / (paramInt1 * 1.0F);
        f2 = (paramInt1 - parama.a - parama.c) / (paramInt1 * 1.0F);
        float f3 = parama.b / (paramInt2 * 1.0F);
        f4 = (paramInt2 - parama.b - parama.d) / (paramInt2 * 1.0F);
        paramInt1 = i1;
        label104:
        if (paramInt1 >= paramFloatBuffer.length / 2) {
          break label225;
        }
        if (paramFloatBuffer[(paramInt1 * 2)] >= 0.5F) {
          break label191;
        }
        paramInt2 = paramInt1 * 2;
        paramFloatBuffer[paramInt2] += f1;
        label136:
        if (paramFloatBuffer[(paramInt1 * 2 + 1)] >= 0.5F) {
          break label207;
        }
        paramInt2 = paramInt1 * 2 + 1;
        paramFloatBuffer[paramInt2] += f3;
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label104;
      paramFloatBuffer = m.a(l.a, false, true);
      break;
      paramFloatBuffer = a(paramFloatBuffer);
      break;
      label191:
      paramInt2 = paramInt1 * 2;
      paramFloatBuffer[paramInt2] -= f2;
      break label136;
      label207:
      paramInt2 = paramInt1 * 2 + 1;
      paramFloatBuffer[paramInt2] -= f4;
    }
    label225:
    AppMethodBeat.o(237419);
    return paramFloatBuffer;
  }
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(237417);
    paramInt = a(paramInt, this.m, this.n);
    AppMethodBeat.o(237417);
    return paramInt;
  }
  
  public int b(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(237413);
    if (!this.g)
    {
      AppMethodBeat.o(237413);
      return -1;
    }
    a(paramInt, paramFloatBuffer1, paramFloatBuffer2);
    if ((this.l instanceof a)) {
      this.l.a(paramInt);
    }
    AppMethodBeat.o(237413);
    return 1;
  }
  
  public void b(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(237422);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(237186);
        GLES20.glUniform1i(paramInt1, paramInt2);
        AppMethodBeat.o(237186);
      }
    });
    AppMethodBeat.o(237422);
  }
  
  public void b(final int paramInt, final float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(237425);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(237308);
        GLES20.glUniform3fv(paramInt, 1, FloatBuffer.wrap(paramArrayOfFloat));
        AppMethodBeat.o(237308);
      }
    });
    AppMethodBeat.o(237425);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(237402);
    this.p = paramBoolean;
    TXCLog.i("TXCGPUFilter", "set Nearest model ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(237402);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(237403);
    this.b = GLES20.glGetAttribLocation(this.a, "position");
    this.c = GLES20.glGetUniformLocation(this.a, "inputImageTexture");
    this.v = GLES20.glGetUniformLocation(this.a, "textureTransform");
    this.d = GLES20.glGetAttribLocation(this.a, "inputTextureCoordinate");
    AppMethodBeat.o(237403);
    return true;
  }
  
  public void c() {}
  
  public void c(final int paramInt, final float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(237426);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(237260);
        GLES20.glUniform4fv(paramInt, 1, FloatBuffer.wrap(paramArrayOfFloat));
        AppMethodBeat.o(237260);
      }
    });
    AppMethodBeat.o(237426);
  }
  
  public void d()
  {
    AppMethodBeat.i(237404);
    GLES20.glDeleteProgram(this.a);
    e();
    this.g = false;
    AppMethodBeat.o(237404);
  }
  
  public void e()
  {
    AppMethodBeat.i(237406);
    f();
    this.f = -1;
    this.e = -1;
    AppMethodBeat.o(237406);
  }
  
  public void f()
  {
    AppMethodBeat.i(237408);
    if (this.m != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.m }, 0);
      this.m = -1;
    }
    if (this.n != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.n }, 0);
      this.n = -1;
    }
    AppMethodBeat.o(237408);
  }
  
  public void g()
  {
    AppMethodBeat.i(237411);
    if (this.k != null)
    {
      int i1 = 0;
      while (i1 < 8)
      {
        this.k[i1] = (1.0F - this.k[i1]);
        i1 += 2;
      }
    }
    AppMethodBeat.o(237411);
    return;
    a(this.j, this.k);
    AppMethodBeat.o(237411);
  }
  
  public void h()
  {
    AppMethodBeat.i(237412);
    if (this.k != null)
    {
      int i1 = 1;
      while (i1 < 8)
      {
        this.k[i1] = (1.0F - this.k[i1]);
        i1 += 2;
      }
    }
    AppMethodBeat.o(237412);
    return;
    a(this.j, this.k);
    AppMethodBeat.o(237412);
  }
  
  protected void i() {}
  
  protected void j() {}
  
  protected void k()
  {
    AppMethodBeat.i(237415);
    while (!this.r.isEmpty()) {
      ((Runnable)this.r.removeFirst()).run();
    }
    AppMethodBeat.o(237415);
  }
  
  public int l()
  {
    return this.n;
  }
  
  public int m()
  {
    return this.m;
  }
  
  public boolean n()
  {
    return this.g;
  }
  
  public int o()
  {
    return this.e;
  }
  
  public int p()
  {
    return this.f;
  }
  
  public int q()
  {
    return this.a;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.j
 * JD-Core Version:    0.7.0.1
 */