package com.tencent.mm.live.core.core.d.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.d.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public final class a
{
  private static final float[] positoins = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] texcoords = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  int mPj;
  int mPk;
  int mPl;
  int mPm;
  int mPn;
  int mPo;
  FloatBuffer mPositoins;
  private int mPp;
  private int mPq;
  private int mPr;
  int mProgramHandle;
  int mPs;
  boolean mPt;
  EGL10 mPu;
  EGLDisplay mPv;
  EGLContext mPw;
  EGLSurface mPx;
  b mPy;
  public com.tencent.mm.live.core.core.d.a.a.a mPz;
  FloatBuffer mTexcoords;
  
  a()
  {
    AppMethodBeat.i(248085);
    this.mProgramHandle = 0;
    this.mPn = 0;
    this.mPo = 0;
    this.mPp = 0;
    this.mPq = 0;
    this.mPr = -1;
    this.mPs = -1;
    this.mPv = null;
    this.mPw = null;
    this.mPx = null;
    this.mPositoins = ByteBuffer.allocateDirect(positoins.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mPositoins.put(positoins).position(0);
    this.mTexcoords = ByteBuffer.allocateDirect(texcoords.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTexcoords.put(texcoords).position(0);
    AppMethodBeat.o(248085);
  }
  
  static int checkGlError(String paramString)
  {
    AppMethodBeat.i(248099);
    int i = GLES20.glGetError();
    if (i != 0)
    {
      Log.e("CustomRender.CustomGLRenderImp", paramString + ": EGL error: 0x" + Integer.toHexString(i));
      AppMethodBeat.o(248099);
      return i;
    }
    AppMethodBeat.o(248099);
    return 0;
  }
  
  static int compileShader(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(248092);
    int j = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("CustomRender.CustomGLRenderImp", "Could not compile shader " + paramInt + ":");
      Log.e("CustomRender.CustomGLRenderImp", " " + GLES20.glGetShaderInfoLog(j));
      GLES20.glDeleteShader(j);
    }
    for (paramInt = i;; paramInt = j)
    {
      AppMethodBeat.o(248092);
      return paramInt;
    }
  }
  
  public final void beE()
  {
    AppMethodBeat.i(248125);
    if (this.mPv != null)
    {
      EGL10 localEGL10 = this.mPu;
      EGLDisplay localEGLDisplay = this.mPv;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
      if (this.mPx != null) {
        this.mPu.eglDestroySurface(this.mPv, this.mPx);
      }
      if (this.mPw != null) {
        this.mPu.eglDestroyContext(this.mPv, this.mPw);
      }
      this.mPu.eglTerminate(this.mPv);
      checkEglError("egl Release");
      this.mPv = null;
      this.mPx = null;
      this.mPv = null;
    }
    AppMethodBeat.o(248125);
  }
  
  public final void beF()
  {
    AppMethodBeat.i(248135);
    if (this.mPu != null)
    {
      makeCurrent();
      if (this.mProgramHandle != 0)
      {
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = 0;
      }
      beE();
      this.mPu = null;
    }
    this.mPt = false;
    AppMethodBeat.o(248135);
  }
  
  public final Size beG()
  {
    AppMethodBeat.i(248161);
    Object localObject = new int[1];
    int[] arrayOfInt = new int[1];
    boolean bool1 = this.mPu.eglQuerySurface(this.mPv, this.mPx, 12375, (int[])localObject);
    boolean bool2 = this.mPu.eglQuerySurface(this.mPv, this.mPx, 12374, arrayOfInt);
    if ((bool1) && (bool2))
    {
      localObject = new Size(localObject[0], arrayOfInt[0]);
      AppMethodBeat.o(248161);
      return localObject;
    }
    localObject = new Size(0, 0);
    AppMethodBeat.o(248161);
    return localObject;
  }
  
  final void checkEglError(String paramString)
  {
    AppMethodBeat.i(248166);
    for (int i = 0;; i = 1)
    {
      int j = this.mPu.eglGetError();
      if (j == 12288) {
        break;
      }
      Log.e("CustomRender.CustomGLRenderImp", paramString + ": EGL error: 0x" + Integer.toHexString(j));
    }
    if (i != 0)
    {
      paramString = new RuntimeException("EGL error encountered (see log)");
      AppMethodBeat.o(248166);
      throw paramString;
    }
    AppMethodBeat.o(248166);
  }
  
  final boolean compileShaders()
  {
    AppMethodBeat.i(248153);
    int i = compileShader("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", 35633);
    if (i == 0)
    {
      AppMethodBeat.o(248153);
      return false;
    }
    int j = compileShader("varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", 35632);
    if (j == 0)
    {
      AppMethodBeat.o(248153);
      return false;
    }
    this.mProgramHandle = GLES20.glCreateProgram();
    if (checkGlError("glCreateProgram") != 0)
    {
      AppMethodBeat.o(248153);
      return false;
    }
    GLES20.glAttachShader(this.mProgramHandle, i);
    if (checkGlError("glAttachShader") != 0)
    {
      AppMethodBeat.o(248153);
      return false;
    }
    GLES20.glAttachShader(this.mProgramHandle, j);
    if (checkGlError("glAttachShader") != 0)
    {
      AppMethodBeat.o(248153);
      return false;
    }
    GLES20.glLinkProgram(this.mProgramHandle);
    Object localObject = new int[1];
    GLES20.glGetProgramiv(this.mProgramHandle, 35714, (int[])localObject, 0);
    if (localObject[0] != 1)
    {
      Log.e("CustomRender.CustomGLRenderImp", "Could not link program: ");
      Log.e("CustomRender.CustomGLRenderImp", GLES20.glGetProgramInfoLog(this.mProgramHandle));
      GLES20.glDeleteProgram(this.mProgramHandle);
      this.mProgramHandle = 0;
      AppMethodBeat.o(248153);
      return false;
    }
    GLES20.glUseProgram(this.mProgramHandle);
    this.mPj = GLES20.glGetAttribLocation(this.mProgramHandle, "position");
    this.mPk = GLES20.glGetUniformLocation(this.mProgramHandle, "inputImageTexture");
    this.mPm = GLES20.glGetAttribLocation(this.mProgramHandle, "inputTextureCoordinate");
    GLES20.glEnableVertexAttribArray(this.mPj);
    GLES20.glEnableVertexAttribArray(this.mPm);
    if ((this.mPj == -1) || (this.mPk == -1) || (this.mPm == -1) || (checkGlError("AdjustResidueFilter") != 0))
    {
      localObject = new RuntimeException("Shaders create failed");
      AppMethodBeat.o(248153);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(248153);
    return true;
  }
  
  public final void dA(Context paramContext)
  {
    AppMethodBeat.i(248114);
    if (this.mPz != null)
    {
      com.tencent.mm.live.core.core.d.a.a.a locala = this.mPz;
      if (locala.mQr)
      {
        paramContext = (SensorManager)paramContext.getSystemService("sensor");
        if (locala.mQu != null) {
          paramContext.unregisterListener(locala.mQu);
        }
        locala.mQr = false;
      }
    }
    AppMethodBeat.o(248114);
  }
  
  public final void makeCurrent()
  {
    AppMethodBeat.i(248144);
    if ((this.mPu != null) && (!this.mPu.eglMakeCurrent(this.mPv, this.mPx, this.mPx, this.mPw))) {
      checkEglError("makeCurrent");
    }
    AppMethodBeat.o(248144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.a.a
 * JD-Core Version:    0.7.0.1
 */