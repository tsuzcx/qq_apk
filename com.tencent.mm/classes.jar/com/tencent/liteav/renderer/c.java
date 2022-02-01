package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class c
{
  private final float[] a;
  private final float[] b;
  private FloatBuffer c;
  private float[] d;
  private float[] e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int o;
  private int p;
  private int q;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(16731);
    this.a = new float[] { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.b = new float[] { 1.0F, -1.0F, 0.0F, 1.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
    this.d = new float[16];
    this.e = new float[16];
    this.g = -12345;
    this.l = false;
    this.m = true;
    this.n = false;
    this.o = -1;
    this.p = 0;
    this.q = 0;
    this.m = paramBoolean;
    if (this.m)
    {
      this.c = ByteBuffer.allocateDirect(this.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.c.put(this.a).position(0);
    }
    for (;;)
    {
      Matrix.setIdentityM(this.e, 0);
      AppMethodBeat.o(16731);
      return;
      this.c = ByteBuffer.allocateDirect(this.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.c.put(this.b).position(0);
    }
  }
  
  private int a(int paramInt, String paramString)
  {
    int i1 = 0;
    AppMethodBeat.i(16738);
    int i2 = GLES20.glCreateShader(paramInt);
    a("glCreateShader type=".concat(String.valueOf(paramInt)));
    GLES20.glShaderSource(i2, paramString);
    GLES20.glCompileShader(i2);
    paramString = new int[1];
    GLES20.glGetShaderiv(i2, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      TXCLog.e("TXCOesTextureRender", "Could not compile shader " + paramInt + ":");
      TXCLog.e("TXCOesTextureRender", " " + GLES20.glGetShaderInfoLog(i2));
      GLES20.glDeleteShader(i2);
    }
    for (paramInt = i1;; paramInt = i2)
    {
      AppMethodBeat.o(16738);
      return paramInt;
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    int i1 = 0;
    AppMethodBeat.i(16739);
    int i3 = a(35633, paramString1);
    if (i3 == 0)
    {
      AppMethodBeat.o(16739);
      return 0;
    }
    int i4 = a(35632, paramString2);
    if (i4 == 0)
    {
      AppMethodBeat.o(16739);
      return 0;
    }
    int i2 = GLES20.glCreateProgram();
    a("glCreateProgram");
    if (i2 == 0) {
      TXCLog.e("TXCOesTextureRender", "Could not create program");
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
      TXCLog.e("TXCOesTextureRender", "Could not link program: ");
      TXCLog.e("TXCOesTextureRender", GLES20.glGetProgramInfoLog(i2));
      GLES20.glDeleteProgram(i2);
    }
    for (;;)
    {
      AppMethodBeat.o(16739);
      return i1;
      i1 = i2;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16734);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    if (this.l)
    {
      this.l = false;
      AppMethodBeat.o(16734);
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
    AppMethodBeat.o(16734);
  }
  
  private void d()
  {
    AppMethodBeat.i(16737);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.g = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.g);
    a("glBindTexture mTextureID");
    AppMethodBeat.o(16737);
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
    AppMethodBeat.i(16733);
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
    AppMethodBeat.o(16733);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16732);
    if (paramSurfaceTexture == null)
    {
      AppMethodBeat.o(16732);
      return;
    }
    a("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.e);
    b(36197, this.g);
    AppMethodBeat.o(16732);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(16740);
    int i1 = GLES20.glGetError();
    if (i1 != 0)
    {
      TXCLog.e("TXCOesTextureRender", paramString + ": glError " + i1);
      AppMethodBeat.o(16740);
      return;
    }
    AppMethodBeat.o(16740);
  }
  
  public void b()
  {
    AppMethodBeat.i(16735);
    if (this.m) {}
    RuntimeException localRuntimeException;
    for (this.f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n"); this.f == 0; this.f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}"))
    {
      localRuntimeException = new RuntimeException("failed creating program");
      AppMethodBeat.o(16735);
      throw localRuntimeException;
    }
    this.j = GLES20.glGetAttribLocation(this.f, "aPosition");
    a("glGetAttribLocation aPosition");
    if (this.j == -1)
    {
      localRuntimeException = new RuntimeException("Could not get attrib location for aPosition");
      AppMethodBeat.o(16735);
      throw localRuntimeException;
    }
    this.k = GLES20.glGetAttribLocation(this.f, "aTextureCoord");
    a("glGetAttribLocation aTextureCoord");
    if (this.k == -1)
    {
      localRuntimeException = new RuntimeException("Could not get attrib location for aTextureCoord");
      AppMethodBeat.o(16735);
      throw localRuntimeException;
    }
    this.h = GLES20.glGetUniformLocation(this.f, "uMVPMatrix");
    a("glGetUniformLocation uMVPMatrix");
    if (this.h == -1)
    {
      localRuntimeException = new RuntimeException("Could not get attrib location for uMVPMatrix");
      AppMethodBeat.o(16735);
      throw localRuntimeException;
    }
    this.i = GLES20.glGetUniformLocation(this.f, "uSTMatrix");
    a("glGetUniformLocation uSTMatrix");
    if (this.i == -1)
    {
      localRuntimeException = new RuntimeException("Could not get attrib location for uSTMatrix");
      AppMethodBeat.o(16735);
      throw localRuntimeException;
    }
    if (this.m) {
      d();
    }
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    a("glTexParameter");
    AppMethodBeat.o(16735);
  }
  
  public void c()
  {
    AppMethodBeat.i(16736);
    if (this.f != 0) {
      GLES20.glDeleteProgram(this.f);
    }
    GLES20.glDeleteTextures(1, new int[] { this.g }, 0);
    this.g = -1;
    AppMethodBeat.o(16736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.c
 * JD-Core Version:    0.7.0.1
 */