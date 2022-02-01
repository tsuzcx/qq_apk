package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class h
{
  public static int a = 1;
  public static int b = 2;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private boolean i;
  private float[] j;
  private float[] k;
  private float l;
  private float m;
  private boolean n;
  private boolean o;
  private final float[] p;
  private FloatBuffer q;
  private float[] r;
  private float[] s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public h(Boolean paramBoolean)
  {
    AppMethodBeat.i(16909);
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = b;
    this.h = 0;
    this.i = false;
    this.j = new float[16];
    this.k = new float[16];
    this.l = 1.0F;
    this.m = 1.0F;
    this.n = false;
    this.o = true;
    this.p = new float[] { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.r = new float[16];
    this.s = new float[16];
    this.u = -12345;
    this.v = -12345;
    this.o = paramBoolean.booleanValue();
    this.q = ByteBuffer.allocateDirect(this.p.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.q.put(this.p).position(0);
    Matrix.setIdentityM(this.s, 0);
    AppMethodBeat.o(16909);
  }
  
  private int a(int paramInt, String paramString)
  {
    int i1 = 0;
    AppMethodBeat.i(16916);
    int i2 = GLES20.glCreateShader(paramInt);
    a("glCreateShader type=".concat(String.valueOf(paramInt)));
    GLES20.glShaderSource(i2, paramString);
    GLES20.glCompileShader(i2);
    paramString = new int[1];
    GLES20.glGetShaderiv(i2, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      TXCLog.e("TXTweenFilter", "Could not compile shader " + paramInt + ":");
      TXCLog.e("TXTweenFilter", " " + GLES20.glGetShaderInfoLog(i2));
      GLES20.glDeleteShader(i2);
    }
    for (paramInt = i1;; paramInt = i2)
    {
      AppMethodBeat.o(16916);
      return paramInt;
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    int i1 = 0;
    AppMethodBeat.i(16917);
    int i3 = a(35633, paramString1);
    if (i3 == 0)
    {
      AppMethodBeat.o(16917);
      return 0;
    }
    int i4 = a(35632, paramString2);
    if (i4 == 0)
    {
      AppMethodBeat.o(16917);
      return 0;
    }
    int i2 = GLES20.glCreateProgram();
    a("glCreateProgram");
    if (i2 == 0) {
      TXCLog.e("TXTweenFilter", "Could not create program");
    }
    GLES20.glAttachShader(i2, i3);
    a("glAttachShader");
    GLES20.glAttachShader(i2, i4);
    a("glAttachShader");
    GLES20.glLinkProgram(i2);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(i2, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      TXCLog.e("TXTweenFilter", "Could not link program: ");
      TXCLog.e("TXTweenFilter", GLES20.glGetProgramInfoLog(i2));
      GLES20.glDeleteProgram(i2);
    }
    for (;;)
    {
      AppMethodBeat.o(16917);
      return i1;
      i1 = i2;
    }
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(16918);
    for (;;)
    {
      int i1 = GLES20.glGetError();
      if (i1 == 0) {
        break;
      }
      TXCLog.e("TXTweenFilter", paramString + ": glError " + i1);
    }
    AppMethodBeat.o(16918);
  }
  
  private void b(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(16908);
    if ((this.d == 0) || (this.c == 0))
    {
      AppMethodBeat.o(16908);
      return;
    }
    int i2 = this.e;
    int i1 = this.f;
    if ((this.h == 270) || (this.h == 90))
    {
      i2 = this.f;
      i1 = this.e;
    }
    float f2 = this.c * 1.0F / i2;
    float f1 = this.d * 1.0F / i1;
    if (this.g == a)
    {
      if (i1 * f2 > this.d) {
        break label244;
      }
      Matrix.setIdentityM(this.k, 0);
      if (this.i)
      {
        if (this.h % 180 != 0) {
          break label249;
        }
        Matrix.scaleM(this.k, 0, -1.0F, 1.0F, 1.0F);
      }
    }
    for (;;)
    {
      Matrix.scaleM(this.k, 0, i2 * f1 / this.c * 1.0F, i1 * f1 / this.d * 1.0F, 1.0F);
      Matrix.rotateM(this.k, 0, this.h, 0.0F, 0.0F, -1.0F);
      Matrix.multiplyMM(paramArrayOfFloat, 0, this.j, 0, this.k, 0);
      AppMethodBeat.o(16908);
      return;
      if (i1 * f2 > this.d) {
        break;
      }
      label244:
      f1 = f2;
      break;
      label249:
      Matrix.scaleM(this.k, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  private void d()
  {
    AppMethodBeat.i(16913);
    if (!this.n)
    {
      AppMethodBeat.o(16913);
      return;
    }
    TXCLog.i("TXTweenFilter", "reloadFrameBuffer. size = " + this.c + "*" + this.d);
    e();
    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = new int[1];
    GLES20.glGenTextures(1, arrayOfInt1, 0);
    GLES20.glGenFramebuffers(1, arrayOfInt2, 0);
    this.u = arrayOfInt1[0];
    this.v = arrayOfInt2[0];
    TXCLog.d("TXTweenFilter", "frameBuffer id = " + this.v + ", texture id = " + this.u);
    GLES20.glBindTexture(3553, this.u);
    a("glBindTexture mFrameBufferTextureID");
    GLES20.glTexImage2D(3553, 0, 6408, this.c, this.d, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    a("glTexParameter");
    GLES20.glBindFramebuffer(36160, this.v);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u, 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    this.n = false;
    AppMethodBeat.o(16913);
  }
  
  private void e()
  {
    AppMethodBeat.i(16915);
    if (this.v != -12345)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.v }, 0);
      this.v = -12345;
    }
    if (this.u != -12345)
    {
      GLES20.glDeleteTextures(1, new int[] { this.u }, 0);
      this.u = -12345;
    }
    AppMethodBeat.o(16915);
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16906);
    if ((paramInt1 == this.c) && (paramInt2 == this.d))
    {
      AppMethodBeat.o(16906);
      return;
    }
    TXCLog.i("TXTweenFilter", "Output resolution change: " + this.c + "*" + this.d + " -> " + paramInt1 + "*" + paramInt2);
    this.c = paramInt1;
    this.d = paramInt2;
    Matrix.orthoM(this.j, 0, -1.0F, 1.0F, -1.0F, 1.0F, -1.0F, 1.0F);
    this.l = 1.0F;
    this.m = 1.0F;
    this.n = true;
    AppMethodBeat.o(16906);
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.s = paramArrayOfFloat;
  }
  
  public boolean a()
  {
    return this.o;
  }
  
  public void b()
  {
    AppMethodBeat.i(16912);
    if (this.o) {}
    for (this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n"); this.t == 0; this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}"))
    {
      TXCLog.e("TXTweenFilter", "failed creating program");
      AppMethodBeat.o(16912);
      return;
    }
    this.y = GLES20.glGetAttribLocation(this.t, "aPosition");
    a("glGetAttribLocation aPosition");
    if (this.y == -1)
    {
      TXCLog.e("TXTweenFilter", "Could not get attrib location for aPosition");
      AppMethodBeat.o(16912);
      return;
    }
    this.z = GLES20.glGetAttribLocation(this.t, "aTextureCoord");
    a("glGetAttribLocation aTextureCoord");
    if (this.z == -1)
    {
      TXCLog.e("TXTweenFilter", "Could not get attrib location for aTextureCoord");
      AppMethodBeat.o(16912);
      return;
    }
    this.w = GLES20.glGetUniformLocation(this.t, "uMVPMatrix");
    a("glGetUniformLocation uMVPMatrix");
    if (this.w == -1)
    {
      TXCLog.e("TXTweenFilter", "Could not get attrib location for uMVPMatrix");
      AppMethodBeat.o(16912);
      return;
    }
    this.x = GLES20.glGetUniformLocation(this.t, "uSTMatrix");
    a("glGetUniformLocation uSTMatrix");
    if (this.x == -1)
    {
      TXCLog.e("TXTweenFilter", "Could not get attrib location for uSTMatrix");
      AppMethodBeat.o(16912);
      return;
    }
    AppMethodBeat.o(16912);
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16907);
    if ((paramInt1 == this.e) && (paramInt2 == this.f))
    {
      AppMethodBeat.o(16907);
      return;
    }
    TXCLog.i("TXTweenFilter", "Input resolution change: " + this.e + "*" + this.f + " -> " + paramInt1 + "*" + paramInt2);
    this.e = paramInt1;
    this.f = paramInt2;
    AppMethodBeat.o(16907);
  }
  
  public void c()
  {
    AppMethodBeat.i(16914);
    GLES20.glDeleteProgram(this.t);
    e();
    AppMethodBeat.o(16914);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(16910);
    GLES20.glViewport(0, 0, this.c, this.d);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.t);
    a("glUseProgram");
    if (this.o)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramInt);
    }
    for (;;)
    {
      this.q.position(0);
      GLES20.glVertexAttribPointer(this.y, 3, 5126, false, 20, this.q);
      a("glVertexAttribPointer maPosition");
      GLES20.glEnableVertexAttribArray(this.y);
      a("glEnableVertexAttribArray maPositionHandle");
      this.q.position(3);
      GLES20.glVertexAttribPointer(this.z, 2, 5126, false, 20, this.q);
      a("glVertexAttribPointer maTextureHandle");
      GLES20.glEnableVertexAttribArray(this.z);
      a("glEnableVertexAttribArray maTextureHandle");
      Matrix.setIdentityM(this.r, 0);
      b(this.r);
      GLES20.glUniformMatrix4fv(this.w, 1, false, this.r, 0);
      GLES20.glUniformMatrix4fv(this.x, 1, false, this.s, 0);
      a("glDrawArrays");
      GLES20.glDrawArrays(5, 0, 4);
      a("glDrawArrays");
      if (!this.o) {
        break;
      }
      GLES20.glBindTexture(36197, 0);
      AppMethodBeat.o(16910);
      return;
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
    }
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(16910);
  }
  
  public int d(int paramInt)
  {
    AppMethodBeat.i(16911);
    d();
    if (this.v == -12345)
    {
      TXCLog.d("TXTweenFilter", "invalid frame buffer id");
      AppMethodBeat.o(16911);
      return paramInt;
    }
    GLES20.glBindFramebuffer(36160, this.v);
    c(paramInt);
    GLES20.glBindFramebuffer(36160, 0);
    paramInt = this.u;
    AppMethodBeat.o(16911);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.renderer.h
 * JD-Core Version:    0.7.0.1
 */