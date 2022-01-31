package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class k
{
  public static int a = 1;
  public static int b = 2;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = b;
  private int h = 0;
  private boolean i = false;
  private float[] j = new float[16];
  private float[] k = new float[16];
  private float l = 1.0F;
  private float m = 1.0F;
  private boolean n = false;
  private boolean o = true;
  private final float[] p = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private FloatBuffer q;
  private float[] r = new float[16];
  private float[] s = new float[16];
  private int t;
  private int u = -12345;
  private int v = -12345;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public k(Boolean paramBoolean)
  {
    this.o = paramBoolean.booleanValue();
    this.q = ByteBuffer.allocateDirect(this.p.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.q.put(this.p).position(0);
    Matrix.setIdentityM(this.s, 0);
  }
  
  private int a(int paramInt, String paramString)
  {
    int i1 = GLES20.glCreateShader(paramInt);
    a("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i1, paramString);
    GLES20.glCompileShader(i1);
    paramString = new int[1];
    GLES20.glGetShaderiv(i1, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      TXCLog.e("TXTweenFilter", "Could not compile shader " + paramInt + ":");
      TXCLog.e("TXTweenFilter", " " + GLES20.glGetShaderInfoLog(i1));
      GLES20.glDeleteShader(i1);
      return 0;
    }
    return i1;
  }
  
  private int a(String paramString1, String paramString2)
  {
    int i1 = a(35633, paramString1);
    if (i1 == 0) {}
    int i2;
    do
    {
      return 0;
      i2 = a(35632, paramString2);
    } while (i2 == 0);
    int i3 = GLES20.glCreateProgram();
    a("glCreateProgram");
    if (i3 == 0) {
      TXCLog.e("TXTweenFilter", "Could not create program");
    }
    GLES20.glAttachShader(i3, i1);
    a("glAttachShader");
    GLES20.glAttachShader(i3, i2);
    a("glAttachShader");
    GLES20.glLinkProgram(i3);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(i3, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      TXCLog.e("TXTweenFilter", "Could not link program: ");
      TXCLog.e("TXTweenFilter", GLES20.glGetProgramInfoLog(i3));
      GLES20.glDeleteProgram(i3);
      return 0;
    }
    return i3;
  }
  
  private void a(String paramString)
  {
    int i1 = GLES20.glGetError();
    if (i1 != 0)
    {
      TXCLog.e("TXTweenFilter", paramString + ": glError " + i1);
      throw new RuntimeException(paramString + ": glError " + i1);
    }
  }
  
  private void b(float[] paramArrayOfFloat)
  {
    if ((this.d == 0) || (this.c == 0)) {
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
        break label226;
      }
      Matrix.setIdentityM(this.k, 0);
      if (this.i)
      {
        if (this.h % 180 != 0) {
          break label231;
        }
        Matrix.scaleM(this.k, 0, -1.0F, 1.0F, 1.0F);
      }
    }
    for (;;)
    {
      Matrix.scaleM(this.k, 0, i2 * f1 / this.c * 1.0F, i1 * f1 / this.d * 1.0F, 1.0F);
      Matrix.rotateM(this.k, 0, this.h, 0.0F, 0.0F, -1.0F);
      Matrix.multiplyMM(paramArrayOfFloat, 0, this.j, 0, this.k, 0);
      return;
      if (i1 * f2 > this.d) {
        break;
      }
      label226:
      f1 = f2;
      break;
      label231:
      Matrix.scaleM(this.k, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  private void c()
  {
    if (!this.n) {
      return;
    }
    TXCLog.d("TXTweenFilter", "reloadFrameBuffer. size = " + this.c + "*" + this.d);
    d();
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
  }
  
  private void d()
  {
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
  }
  
  public void a()
  {
    if (this.o) {}
    for (this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n"); this.t == 0; this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}")) {
      throw new RuntimeException("failed creating program");
    }
    this.y = GLES20.glGetAttribLocation(this.t, "aPosition");
    a("glGetAttribLocation aPosition");
    if (this.y == -1) {
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    this.z = GLES20.glGetAttribLocation(this.t, "aTextureCoord");
    a("glGetAttribLocation aTextureCoord");
    if (this.z == -1) {
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    }
    this.w = GLES20.glGetUniformLocation(this.t, "uMVPMatrix");
    a("glGetUniformLocation uMVPMatrix");
    if (this.w == -1) {
      throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    }
    this.x = GLES20.glGetUniformLocation(this.t, "uSTMatrix");
    a("glGetUniformLocation uSTMatrix");
    if (this.x == -1) {
      throw new RuntimeException("Could not get attrib location for uSTMatrix");
    }
  }
  
  public void a(int paramInt)
  {
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
      return;
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
    }
    GLES20.glBindTexture(3553, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.c) && (paramInt2 == this.d)) {
      return;
    }
    TXCLog.d("TXTweenFilter", "Output resolution change: " + this.c + "*" + this.d + " -> " + paramInt1 + "*" + paramInt2);
    this.c = paramInt1;
    this.d = paramInt2;
    Matrix.orthoM(this.j, 0, -1.0F, 1.0F, -1.0F, 1.0F, -1.0F, 1.0F);
    this.l = 1.0F;
    this.m = 1.0F;
    this.n = true;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.s = paramArrayOfFloat;
  }
  
  public int b(int paramInt)
  {
    c();
    if (this.v == -12345)
    {
      TXCLog.d("TXTweenFilter", "invalid frame buffer id");
      return paramInt;
    }
    GLES20.glBindFramebuffer(36160, this.v);
    a(paramInt);
    GLES20.glBindFramebuffer(36160, 0);
    return this.u;
  }
  
  public void b()
  {
    GLES20.glDeleteProgram(this.t);
    d();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.e) && (paramInt2 == this.f)) {
      return;
    }
    TXCLog.d("TXTweenFilter", "Input resolution change: " + this.e + "*" + this.f + " -> " + paramInt1 + "*" + paramInt2);
    this.e = paramInt1;
    this.f = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.k
 * JD-Core Version:    0.7.0.1
 */