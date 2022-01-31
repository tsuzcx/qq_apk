package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class f
{
  private final float[] a = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private final float[] b = { 1.0F, -1.0F, 0.0F, 1.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  private FloatBuffer c;
  private float[] d = new float[16];
  private float[] e = new float[16];
  private int f;
  private int g = -12345;
  private int h;
  private int i;
  private int j;
  private int k;
  private boolean l = false;
  private boolean m = true;
  private boolean n = false;
  private int o = -1;
  private int p = 0;
  private int q = 0;
  
  public f(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (this.m)
    {
      this.c = ByteBuffer.allocateDirect(this.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.c.put(this.a).position(0);
    }
    for (;;)
    {
      Matrix.setIdentityM(this.e, 0);
      return;
      this.c = ByteBuffer.allocateDirect(this.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.c.put(this.b).position(0);
    }
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
      TXCLog.e("TXCOesTextureRender", "Could not compile shader " + paramInt + ":");
      TXCLog.e("TXCOesTextureRender", " " + GLES20.glGetShaderInfoLog(i1));
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
      TXCLog.e("TXCOesTextureRender", "Could not create program");
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
      TXCLog.e("TXCOesTextureRender", "Could not link program: ");
      TXCLog.e("TXCOesTextureRender", GLES20.glGetProgramInfoLog(i3));
      GLES20.glDeleteProgram(i3);
      return 0;
    }
    return i3;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    if (this.l)
    {
      this.l = false;
      return;
    }
    GLES20.glUseProgram(this.f);
    a("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramInt1, paramInt2);
    this.c.position(0);
    GLES20.glVertexAttribPointer(this.j, 3, 5126, false, 20, this.c);
    a("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.j);
    a("glEnableVertexAttribArray maPositionHandle");
    this.c.position(3);
    GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 20, this.c);
    a("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.k);
    a("glEnableVertexAttribArray maTextureHandle");
    Matrix.setIdentityM(this.d, 0);
    GLES20.glUniformMatrix4fv(this.h, 1, false, this.d, 0);
    if (this.p % 8 != 0)
    {
      paramInt1 = (this.p + 7) / 8;
      Matrix.scaleM(this.e, 0, (this.p - 1) * 1.0F / (paramInt1 * 8), 1.0F, 1.0F);
    }
    if (this.q % 8 != 0)
    {
      paramInt1 = (this.q + 7) / 8;
      Matrix.scaleM(this.e, 0, 1.0F, (this.q - 1) * 1.0F / (paramInt1 * 8), 1.0F);
    }
    GLES20.glUniformMatrix4fv(this.i, 1, false, this.e, 0);
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glFinish();
  }
  
  private void c()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.g = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.g);
    a("glBindTexture mTextureID");
  }
  
  public int a()
  {
    return this.g;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.p = paramInt1;
    this.q = paramInt2;
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((this.n != paramBoolean) || (this.o != paramInt2))
    {
      this.n = paramBoolean;
      this.o = paramInt2;
      float[] arrayOfFloat = new float[20];
      int i1 = 0;
      while (i1 < 20)
      {
        arrayOfFloat[i1] = this.b[i1];
        i1 += 1;
      }
      if (this.n)
      {
        arrayOfFloat[0] = (-arrayOfFloat[0]);
        arrayOfFloat[5] = (-arrayOfFloat[5]);
        arrayOfFloat[10] = (-arrayOfFloat[10]);
        arrayOfFloat[15] = (-arrayOfFloat[15]);
      }
      i1 = paramInt2 / 90;
      paramInt2 = 0;
      while (paramInt2 < i1)
      {
        float f1 = arrayOfFloat[3];
        float f2 = arrayOfFloat[4];
        arrayOfFloat[3] = arrayOfFloat[8];
        arrayOfFloat[4] = arrayOfFloat[9];
        arrayOfFloat[8] = arrayOfFloat[18];
        arrayOfFloat[9] = arrayOfFloat[19];
        arrayOfFloat[18] = arrayOfFloat[13];
        arrayOfFloat[19] = arrayOfFloat[14];
        arrayOfFloat[13] = f1;
        arrayOfFloat[14] = f2;
        paramInt2 += 1;
      }
      this.c.clear();
      this.c.put(arrayOfFloat).position(0);
    }
    b(3553, paramInt1);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    if (paramSurfaceTexture == null) {
      return;
    }
    a("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.e);
    b(36197, this.g);
  }
  
  public void a(String paramString)
  {
    int i1 = GLES20.glGetError();
    if (i1 != 0) {
      TXCLog.e("TXCOesTextureRender", paramString + ": glError " + i1);
    }
  }
  
  public void b()
  {
    if (this.m) {}
    for (this.f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n"); this.f == 0; this.f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}")) {
      throw new RuntimeException("failed creating program");
    }
    this.j = GLES20.glGetAttribLocation(this.f, "aPosition");
    a("glGetAttribLocation aPosition");
    if (this.j == -1) {
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    this.k = GLES20.glGetAttribLocation(this.f, "aTextureCoord");
    a("glGetAttribLocation aTextureCoord");
    if (this.k == -1) {
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    }
    this.h = GLES20.glGetUniformLocation(this.f, "uMVPMatrix");
    a("glGetUniformLocation uMVPMatrix");
    if (this.h == -1) {
      throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    }
    this.i = GLES20.glGetUniformLocation(this.f, "uSTMatrix");
    a("glGetUniformLocation uSTMatrix");
    if (this.i == -1) {
      throw new RuntimeException("Could not get attrib location for uSTMatrix");
    }
    if (this.m) {
      c();
    }
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    a("glTexParameter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.renderer.f
 * JD-Core Version:    0.7.0.1
 */