package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class h
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
  private String x;
  
  public h()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
    AppMethodBeat.i(14502);
    AppMethodBeat.o(14502);
  }
  
  public h(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, false);
  }
  
  public h(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(187329);
    this.u = false;
    this.v = -1;
    this.w = null;
    this.m = -1;
    this.n = -1;
    this.o = false;
    this.p = false;
    this.q = false;
    this.x = "TXCGPUFilter";
    this.r = new LinkedList();
    this.s = paramString1;
    this.t = paramString2;
    this.q = paramBoolean;
    if (true == paramBoolean) {
      TXCLog.i(this.x, "set Oes fileter");
    }
    this.h = ByteBuffer.allocateDirect(l.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.j = l.e;
    this.h.put(this.j).position(0);
    this.i = ByteBuffer.allocateDirect(l.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.k = l.a(k.a, false, true);
    this.i.put(this.k).position(0);
    AppMethodBeat.o(187329);
  }
  
  private static float[] a(FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(187334);
    if (paramFloatBuffer.limit() <= 0)
    {
      AppMethodBeat.o(187334);
      return null;
    }
    float[] arrayOfFloat = new float[paramFloatBuffer.limit()];
    int i1 = 0;
    while (i1 < paramFloatBuffer.limit())
    {
      arrayOfFloat[i1] = paramFloatBuffer.get(i1);
      i1 += 1;
    }
    AppMethodBeat.o(187334);
    return arrayOfFloat;
  }
  
  public int a(int paramInt)
  {
    AppMethodBeat.i(187340);
    paramInt = b(paramInt, this.h, this.i);
    AppMethodBeat.o(187340);
    return paramInt;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187342);
    if (!this.g)
    {
      AppMethodBeat.o(187342);
      return -1;
    }
    GLES20.glBindFramebuffer(36160, paramInt2);
    a(paramInt1, this.h, this.i);
    if ((this.l instanceof a)) {
      this.l.a(paramInt3);
    }
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(187342);
    return paramInt3;
  }
  
  public void a(final int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(187349);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187292);
        GLES20.glUniform1f(paramInt, paramFloat);
        AppMethodBeat.o(187292);
      }
    });
    AppMethodBeat.o(187349);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187336);
    if ((this.f == paramInt2) && (this.e == paramInt1))
    {
      AppMethodBeat.o(187336);
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
      this.n = j.a(paramInt1, paramInt2, 6408, 6408);
      GLES20.glBindFramebuffer(36160, this.m);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.n, 0);
      GLES20.glBindFramebuffer(36160, 0);
    }
    AppMethodBeat.o(187336);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(187346);
    float[] arrayOfFloat = paramArrayOfFloat;
    if (paramArrayOfFloat == null) {
      arrayOfFloat = l.a(k.a, false, true);
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
        a((float[])l.e.clone(), arrayOfFloat);
        AppMethodBeat.o(187346);
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
    AppMethodBeat.i(187347);
    if (paramFloatBuffer == null) {}
    for (paramFloatBuffer = l.a(k.a, false, true);; paramFloatBuffer = a(paramFloatBuffer))
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
    a((float[])l.e.clone(), paramFloatBuffer);
    AppMethodBeat.o(187347);
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(14504);
    GLES20.glUseProgram(this.a);
    k();
    if (!this.g)
    {
      AppMethodBeat.o(14504);
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
        break label197;
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
      AppMethodBeat.o(14504);
      return;
      label197:
      GLES20.glBindTexture(3553, paramInt);
    }
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(14504);
  }
  
  public void a(final int paramInt, final float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(187350);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187273);
        GLES20.glUniform2fv(paramInt, 1, FloatBuffer.wrap(paramArrayOfFloat));
        AppMethodBeat.o(187273);
      }
    });
    AppMethodBeat.o(187350);
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
    AppMethodBeat.i(187353);
    synchronized (this.r)
    {
      this.r.addLast(paramRunnable);
      AppMethodBeat.o(187353);
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
    AppMethodBeat.i(187344);
    this.j = paramArrayOfFloat1;
    this.h = ByteBuffer.allocateDirect(l.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.h.put(paramArrayOfFloat1).position(0);
    this.k = paramArrayOfFloat2;
    this.i = ByteBuffer.allocateDirect(l.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.i.put(paramArrayOfFloat2).position(0);
    AppMethodBeat.o(187344);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(187330);
    this.a = j.a(this.s, this.t);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(187330);
      return bool;
    }
  }
  
  public float[] a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, a parama, int paramInt3)
  {
    int i1 = 0;
    AppMethodBeat.i(187345);
    float f2;
    float f4;
    if (paramFloatBuffer == null) {
      if (4 == paramInt3)
      {
        paramFloatBuffer = l.a(k.a, false, false);
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
      paramFloatBuffer = l.a(k.a, false, true);
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
    AppMethodBeat.o(187345);
    return paramFloatBuffer;
  }
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(187343);
    paramInt = a(paramInt, this.m, this.n);
    AppMethodBeat.o(187343);
    return paramInt;
  }
  
  public int b(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(187339);
    if (!this.g)
    {
      AppMethodBeat.o(187339);
      return -1;
    }
    a(paramInt, paramFloatBuffer1, paramFloatBuffer2);
    if ((this.l instanceof a)) {
      this.l.a(paramInt);
    }
    AppMethodBeat.o(187339);
    return 1;
  }
  
  public void b(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(187348);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187277);
        GLES20.glUniform1i(paramInt1, paramInt2);
        AppMethodBeat.o(187277);
      }
    });
    AppMethodBeat.o(187348);
  }
  
  public void b(final int paramInt, final float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(187351);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187327);
        GLES20.glUniform3fv(paramInt, 1, FloatBuffer.wrap(paramArrayOfFloat));
        AppMethodBeat.o(187327);
      }
    });
    AppMethodBeat.o(187351);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(187331);
    this.p = paramBoolean;
    TXCLog.i(this.x, "set Nearest model ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(187331);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(14503);
    this.b = GLES20.glGetAttribLocation(this.a, "position");
    this.c = GLES20.glGetUniformLocation(this.a, "inputImageTexture");
    this.v = GLES20.glGetUniformLocation(this.a, "textureTransform");
    this.d = GLES20.glGetAttribLocation(this.a, "inputTextureCoordinate");
    AppMethodBeat.o(14503);
    return true;
  }
  
  public void c() {}
  
  public void c(final int paramInt, final float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(187352);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187275);
        GLES20.glUniform4fv(paramInt, 1, FloatBuffer.wrap(paramArrayOfFloat));
        AppMethodBeat.o(187275);
      }
    });
    AppMethodBeat.o(187352);
  }
  
  public void d()
  {
    AppMethodBeat.i(187332);
    GLES20.glDeleteProgram(this.a);
    e();
    this.g = false;
    AppMethodBeat.o(187332);
  }
  
  public void e()
  {
    AppMethodBeat.i(187333);
    f();
    this.f = -1;
    this.e = -1;
    AppMethodBeat.o(187333);
  }
  
  public void f()
  {
    AppMethodBeat.i(187335);
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
    AppMethodBeat.o(187335);
  }
  
  public void g()
  {
    AppMethodBeat.i(187337);
    if (this.k != null)
    {
      int i1 = 0;
      while (i1 < 8)
      {
        this.k[i1] = (1.0F - this.k[i1]);
        i1 += 2;
      }
    }
    AppMethodBeat.o(187337);
    return;
    a(this.j, this.k);
    AppMethodBeat.o(187337);
  }
  
  public void h()
  {
    AppMethodBeat.i(187338);
    if (this.k != null)
    {
      int i1 = 1;
      while (i1 < 8)
      {
        this.k[i1] = (1.0F - this.k[i1]);
        i1 += 2;
      }
    }
    AppMethodBeat.o(187338);
    return;
    a(this.j, this.k);
    AppMethodBeat.o(187338);
  }
  
  protected void i() {}
  
  protected void j() {}
  
  protected void k()
  {
    AppMethodBeat.i(187341);
    while (!this.r.isEmpty()) {
      ((Runnable)this.r.removeFirst()).run();
    }
    AppMethodBeat.o(187341);
  }
  
  public int l()
  {
    return this.n;
  }
  
  public boolean m()
  {
    return this.g;
  }
  
  public int n()
  {
    return this.e;
  }
  
  public int o()
  {
    return this.f;
  }
  
  public int p()
  {
    return this.a;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.h
 * JD-Core Version:    0.7.0.1
 */