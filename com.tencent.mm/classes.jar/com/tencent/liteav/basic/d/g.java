package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class g
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
  protected g.a l;
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
  
  public g()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
  }
  
  public g(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, false);
  }
  
  public g(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146570);
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
    this.h = ByteBuffer.allocateDirect(k.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.j = k.e;
    this.h.put(this.j).position(0);
    this.i = ByteBuffer.allocateDirect(k.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.k = k.a(j.a, false, true);
    this.i.put(this.k).position(0);
    AppMethodBeat.o(146570);
  }
  
  private static float[] a(FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(146576);
    if (paramFloatBuffer.limit() <= 0)
    {
      AppMethodBeat.o(146576);
      return null;
    }
    float[] arrayOfFloat = new float[paramFloatBuffer.limit()];
    int i1 = 0;
    while (i1 < paramFloatBuffer.limit())
    {
      arrayOfFloat[i1] = paramFloatBuffer.get(i1);
      i1 += 1;
    }
    AppMethodBeat.o(146576);
    return arrayOfFloat;
  }
  
  public int a(int paramInt)
  {
    AppMethodBeat.i(146583);
    paramInt = b(paramInt, this.h, this.i);
    AppMethodBeat.o(146583);
    return paramInt;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146585);
    if (!this.g)
    {
      AppMethodBeat.o(146585);
      return -1;
    }
    GLES20.glBindFramebuffer(36160, paramInt2);
    a(paramInt1, this.h, this.i);
    if ((this.l instanceof g.a)) {
      this.l.a(paramInt3);
    }
    GLES20.glBindFramebuffer(36160, 0);
    AppMethodBeat.o(146585);
    return paramInt3;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(146592);
    a(new g.2(this, paramInt, paramFloat));
    AppMethodBeat.o(146592);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146578);
    if ((this.f == paramInt2) && (this.e == paramInt1))
    {
      AppMethodBeat.o(146578);
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
      this.n = i.a(paramInt1, paramInt2, 6408, 6408);
      GLES20.glBindFramebuffer(36160, this.m);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.n, 0);
      GLES20.glBindFramebuffer(36160, 0);
    }
    AppMethodBeat.o(146578);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(146589);
    float[] arrayOfFloat = paramArrayOfFloat;
    if (paramArrayOfFloat == null) {
      arrayOfFloat = k.a(j.a, false, true);
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
        a((float[])k.e.clone(), arrayOfFloat);
        AppMethodBeat.o(146589);
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
    AppMethodBeat.i(146590);
    if (paramFloatBuffer == null) {}
    for (paramFloatBuffer = k.a(j.a, false, true);; paramFloatBuffer = a(paramFloatBuffer))
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
    a((float[])k.e.clone(), paramFloatBuffer);
    AppMethodBeat.o(146590);
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(146579);
    GLES20.glUseProgram(this.a);
    k();
    if (!this.g)
    {
      AppMethodBeat.o(146579);
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
        break label191;
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
      AppMethodBeat.o(146579);
      return;
      label191:
      GLES20.glBindTexture(3553, paramInt);
    }
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(146579);
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(146593);
    a(new g.3(this, paramInt, paramArrayOfFloat));
    AppMethodBeat.o(146593);
  }
  
  public void a(g.a parama)
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
    AppMethodBeat.i(146596);
    synchronized (this.r)
    {
      this.r.addLast(paramRunnable);
      AppMethodBeat.o(146596);
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
    AppMethodBeat.i(146587);
    this.j = paramArrayOfFloat1;
    this.h = ByteBuffer.allocateDirect(k.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.h.put(paramArrayOfFloat1).position(0);
    this.k = paramArrayOfFloat2;
    this.i = ByteBuffer.allocateDirect(k.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.i.put(paramArrayOfFloat2).position(0);
    AppMethodBeat.o(146587);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(146571);
    this.a = i.a(this.s, this.t);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(146571);
      return bool;
    }
  }
  
  public float[] a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, a parama, int paramInt3)
  {
    int i1 = 0;
    AppMethodBeat.i(146588);
    float f2;
    float f4;
    if (paramFloatBuffer == null) {
      if (4 == paramInt3)
      {
        paramFloatBuffer = k.a(j.a, false, false);
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
      paramFloatBuffer = k.a(j.a, false, true);
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
    AppMethodBeat.o(146588);
    return paramFloatBuffer;
  }
  
  public int b(int paramInt)
  {
    AppMethodBeat.i(146586);
    paramInt = a(paramInt, this.m, this.n);
    AppMethodBeat.o(146586);
    return paramInt;
  }
  
  public int b(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(146582);
    if (!this.g)
    {
      AppMethodBeat.o(146582);
      return -1;
    }
    a(paramInt, paramFloatBuffer1, paramFloatBuffer2);
    if ((this.l instanceof g.a)) {
      this.l.a(paramInt);
    }
    AppMethodBeat.o(146582);
    return 1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146591);
    a(new g.1(this, paramInt1, paramInt2));
    AppMethodBeat.o(146591);
  }
  
  public void b(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(146594);
    a(new g.4(this, paramInt, paramArrayOfFloat));
    AppMethodBeat.o(146594);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(146572);
    this.p = paramBoolean;
    TXCLog.i(this.x, "set Nearest model ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(146572);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(146573);
    this.b = GLES20.glGetAttribLocation(this.a, "position");
    this.c = GLES20.glGetUniformLocation(this.a, "inputImageTexture");
    this.v = GLES20.glGetUniformLocation(this.a, "textureTransform");
    this.d = GLES20.glGetAttribLocation(this.a, "inputTextureCoordinate");
    AppMethodBeat.o(146573);
    return true;
  }
  
  public void c() {}
  
  public void c(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(146595);
    a(new g.5(this, paramInt, paramArrayOfFloat));
    AppMethodBeat.o(146595);
  }
  
  public void d()
  {
    AppMethodBeat.i(146574);
    GLES20.glDeleteProgram(this.a);
    e();
    this.g = false;
    AppMethodBeat.o(146574);
  }
  
  public void e()
  {
    AppMethodBeat.i(146575);
    f();
    this.f = -1;
    this.e = -1;
    AppMethodBeat.o(146575);
  }
  
  public void f()
  {
    AppMethodBeat.i(146577);
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
    AppMethodBeat.o(146577);
  }
  
  public void g()
  {
    AppMethodBeat.i(146580);
    if (this.k != null)
    {
      int i1 = 0;
      while (i1 < 8)
      {
        this.k[i1] = (1.0F - this.k[i1]);
        i1 += 2;
      }
    }
    AppMethodBeat.o(146580);
    return;
    a(this.j, this.k);
    AppMethodBeat.o(146580);
  }
  
  public void h()
  {
    AppMethodBeat.i(146581);
    if (this.k != null)
    {
      int i1 = 1;
      while (i1 < 8)
      {
        this.k[i1] = (1.0F - this.k[i1]);
        i1 += 2;
      }
    }
    AppMethodBeat.o(146581);
    return;
    a(this.j, this.k);
    AppMethodBeat.o(146581);
  }
  
  protected void i() {}
  
  protected void j() {}
  
  protected void k()
  {
    AppMethodBeat.i(146584);
    while (!this.r.isEmpty()) {
      ((Runnable)this.r.removeFirst()).run();
    }
    AppMethodBeat.o(146584);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.basic.d.g
 * JD-Core Version:    0.7.0.1
 */