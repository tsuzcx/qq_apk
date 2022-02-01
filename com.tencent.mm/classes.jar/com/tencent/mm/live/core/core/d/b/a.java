package com.tencent.mm.live.core.core.d.b;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class a
{
  private static final float[] positoins = { -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
  private static final float[] texcoords = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private int[] mFrameBuffer;
  private int mHeight;
  private float[] mMVPMatrix;
  private int mOffsetid;
  private FloatBuffer mPositoins;
  private int mProgramHandle;
  private float[] mSTMatrix;
  private FloatBuffer mTexcoords;
  public int[] mTextureid;
  private int mWidth;
  private int minputImageTextureid;
  private int mpositionid;
  private int mtexSizeid;
  private int mtexcoordid;
  private int muMVPMatrixHandle;
  private int muSTMatrixHandle;
  
  public a()
  {
    AppMethodBeat.i(248054);
    this.mMVPMatrix = new float[16];
    this.mSTMatrix = new float[16];
    this.mProgramHandle = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mpositionid = 0;
    this.mtexcoordid = 0;
    this.mtexSizeid = 0;
    this.mOffsetid = 0;
    this.minputImageTextureid = 0;
    this.mFrameBuffer = new int[3];
    this.mTextureid = new int[3];
    int i = 0;
    while (i < 3)
    {
      this.mFrameBuffer[i] = 0;
      this.mTextureid[i] = 0;
      i += 1;
    }
    this.mPositoins = ByteBuffer.allocateDirect(positoins.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mPositoins.put(positoins).position(0);
    this.mTexcoords = ByteBuffer.allocateDirect(texcoords.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTexcoords.put(texcoords).position(0);
    Matrix.setIdentityM(this.mSTMatrix, 0);
    int k = compileShader("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 position;\nattribute vec4 texCoord;\nuniform highp vec2 texSize;\nuniform highp float Offset;\nvarying vec2 TexCoord;\nvarying vec2 TexCoord_shift1;\nvarying vec2 TexCoord_shift2;\nvarying vec2 TexCoord_shift3;\nvarying vec2 TexCoord_shift4;\nvarying vec2 TexCoord_shift5;\nvarying vec2 TexCoord_shift6;\nvarying vec2 TexCoord_shift7;\nvarying vec2 TexCoord_shift8;\nvoid main()\n{\n   gl_Position = uMVPMatrix * position;\n   TexCoord = (uSTMatrix * texCoord).xy;\n   TexCoord_shift1 = vec2(float(int(TexCoord.x * texSize.x - Offset ))/texSize.x, float(int(TexCoord.y * texSize.y))/texSize.y);\n   TexCoord_shift2 = vec2(float(int(TexCoord.x * texSize.x + Offset ))/texSize.x, float(int(TexCoord.y * texSize.y))/texSize.y);\n   TexCoord_shift3 = vec2(float(int(TexCoord.x * texSize.x))/texSize.x, float(int(TexCoord.y * texSize.y - Offset))/texSize.y);\n   TexCoord_shift4 = vec2(float(int(TexCoord.x * texSize.x))/texSize.x, float(int(TexCoord.y * texSize.y + Offset))/texSize.y);\n\n   TexCoord_shift5 = vec2(float(int(TexCoord.x * texSize.x - Offset))/texSize.x, float(int(TexCoord.y * texSize.y - Offset ))/texSize.y);\n   TexCoord_shift6 = vec2(float(int(TexCoord.x * texSize.x + Offset))/texSize.x, float(int(TexCoord.y * texSize.y + Offset ))/texSize.y);\n   TexCoord_shift7 = vec2(float(int(TexCoord.x * texSize.x - Offset))/texSize.x, float(int(TexCoord.y * texSize.y + Offset ))/texSize.y);\n   TexCoord_shift8 = vec2(float(int(TexCoord.x * texSize.x + Offset))/texSize.x, float(int(TexCoord.y * texSize.y - Offset ))/texSize.y);\n}\n", 35633);
    if (k == 0) {
      i = j;
    }
    while ((i != 1) || (checkGlError("BlurFilter") != 0))
    {
      Object localObject = new RuntimeException("sifeng: BlurFilter create failed");
      AppMethodBeat.o(248054);
      throw ((Throwable)localObject);
      int m = compileShader("precision mediump float;\nvarying vec2 TexCoord;\nuniform sampler2D inputImageTexture;\nvarying vec2 TexCoord_shift1;\nvarying vec2 TexCoord_shift2;\nvarying vec2 TexCoord_shift3;\nvarying vec2 TexCoord_shift4;\nvarying vec2 TexCoord_shift5;\nvarying vec2 TexCoord_shift6;\nvarying vec2 TexCoord_shift7;\nvarying vec2 TexCoord_shift8;\nvoid main()\n{\ngl_FragColor = vec4((texture2D(inputImageTexture,TexCoord_shift1).r + texture2D(inputImageTexture,TexCoord_shift2).r + texture2D(inputImageTexture,TexCoord_shift3).r + \ntexture2D(inputImageTexture,TexCoord_shift4).r + texture2D(inputImageTexture,TexCoord_shift5).r + texture2D(inputImageTexture,TexCoord_shift6).r + \ntexture2D(inputImageTexture,TexCoord_shift7).r + texture2D(inputImageTexture,TexCoord_shift8).r + texture2D(inputImageTexture, TexCoord).r ) * 0.11111, texture2D(inputImageTexture, TexCoord).gb, 1.0);\n}\n", 35632);
      i = j;
      if (m != 0)
      {
        this.mProgramHandle = GLES20.glCreateProgram();
        i = j;
        if (checkGlError("glCreateProgram") == 0)
        {
          GLES20.glAttachShader(this.mProgramHandle, k);
          i = j;
          if (checkGlError("glAttachShader") == 0)
          {
            GLES20.glAttachShader(this.mProgramHandle, m);
            i = j;
            if (checkGlError("glAttachShader") == 0)
            {
              GLES20.glLinkProgram(this.mProgramHandle);
              localObject = new int[1];
              GLES20.glGetProgramiv(this.mProgramHandle, 35714, (int[])localObject, 0);
              if (localObject[0] != 1)
              {
                GLES20.glGetProgramInfoLog(this.mProgramHandle);
                GLES20.glDeleteProgram(this.mProgramHandle);
                this.mProgramHandle = 0;
                i = j;
              }
              else
              {
                GLES20.glUseProgram(this.mProgramHandle);
                this.mpositionid = GLES20.glGetAttribLocation(this.mProgramHandle, "position");
                GLES20.glEnableVertexAttribArray(this.mpositionid);
                this.mtexcoordid = GLES20.glGetAttribLocation(this.mProgramHandle, "texCoord");
                GLES20.glEnableVertexAttribArray(this.mtexcoordid);
                this.mtexSizeid = GLES20.glGetUniformLocation(this.mProgramHandle, "texSize");
                this.mOffsetid = GLES20.glGetUniformLocation(this.mProgramHandle, "Offset");
                this.minputImageTextureid = GLES20.glGetUniformLocation(this.mProgramHandle, "inputImageTexture");
                this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
                this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgramHandle, "uSTMatrix");
                i = j;
                if (this.mpositionid != -1)
                {
                  i = j;
                  if (this.mtexcoordid != -1)
                  {
                    i = j;
                    if (this.minputImageTextureid != -1)
                    {
                      i = j;
                      if (this.muMVPMatrixHandle != -1)
                      {
                        i = j;
                        if (this.muSTMatrixHandle != -1)
                        {
                          i = j;
                          if (this.mtexSizeid != -1)
                          {
                            i = j;
                            if (this.mOffsetid != -1) {
                              i = 1;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(248054);
  }
  
  private static int checkGlError(String paramString)
  {
    AppMethodBeat.i(248072);
    int i = GLES20.glGetError();
    if (i != 0)
    {
      new StringBuilder().append(paramString).append(": EGL error: 0x").append(Integer.toHexString(i));
      AppMethodBeat.o(248072);
      return i;
    }
    AppMethodBeat.o(248072);
    return 0;
  }
  
  private static int compileShader(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(248066);
    int j = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      new StringBuilder("Could not compile shader ").append(paramInt).append(":");
      new StringBuilder(" ").append(GLES20.glGetShaderInfoLog(j));
      GLES20.glDeleteShader(j);
    }
    for (paramInt = i;; paramInt = j)
    {
      AppMethodBeat.o(248066);
      return paramInt;
    }
  }
  
  public final void destroyBuffers()
  {
    AppMethodBeat.i(248089);
    int i = 0;
    while (i < 3)
    {
      if (this.mFrameBuffer[i] != 0)
      {
        GLES20.glDeleteFramebuffers(1, this.mFrameBuffer, i);
        this.mFrameBuffer[i] = 0;
      }
      if (this.mTextureid[i] != 0)
      {
        GLES20.glDeleteTextures(1, this.mTextureid, i);
        this.mTextureid[i] = 0;
      }
      i += 1;
    }
    if (this.mProgramHandle != 0)
    {
      GLES20.glDeleteProgram(this.mProgramHandle);
      this.mProgramHandle = 0;
    }
    AppMethodBeat.o(248089);
  }
  
  public final void process(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(248105);
    int i;
    int j;
    if ((this.mWidth != paramInt2) || (this.mHeight != paramInt3))
    {
      i = 1;
      j = 0;
      if (j < 3)
      {
        if (this.mFrameBuffer[j] != 0)
        {
          GLES20.glDeleteFramebuffers(1, this.mFrameBuffer, j);
          this.mFrameBuffer[j] = 0;
        }
        if (this.mTextureid[j] != 0)
        {
          GLES20.glDeleteTextures(1, this.mTextureid, j);
          this.mTextureid[j] = 0;
        }
        if (j == 0) {
          break label568;
        }
        i *= 2;
      }
    }
    label565:
    label568:
    for (;;)
    {
      GLES20.glGenFramebuffers(1, this.mFrameBuffer, j);
      GLES20.glBindFramebuffer(36160, this.mFrameBuffer[j]);
      GLES20.glGenTextures(1, this.mTextureid, j);
      GLES20.glBindTexture(3553, this.mTextureid[j]);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt2 / i, paramInt3 / i, 0, 6408, 5121, null);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10240, 9729);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mTextureid[j], 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      j += 1;
      break;
      this.mWidth = paramInt2;
      this.mHeight = paramInt3;
      int k = 1;
      i = 0;
      j = paramInt1;
      paramInt1 = k;
      if (i < 3)
      {
        if (i == 0) {
          break label565;
        }
        paramInt1 *= 2;
      }
      for (;;)
      {
        GLES20.glBindFramebuffer(36160, this.mFrameBuffer[i]);
        GLES20.glUseProgram(this.mProgramHandle);
        GLES20.glViewport(0, 0, paramInt2 / paramInt1, paramInt3 / paramInt1);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, j);
        GLES20.glUniform1i(this.minputImageTextureid, 0);
        if (i != 0) {
          GLES20.glUniform2f(this.mtexSizeid, paramInt2 / paramInt1 * 2, paramInt3 / paramInt1 * 2);
        }
        for (;;)
        {
          GLES20.glUniform1f(this.mOffsetid, 1.0F);
          Matrix.setIdentityM(this.mMVPMatrix, 0);
          GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
          GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
          this.mPositoins.position(0);
          this.mTexcoords.position(0);
          GLES20.glVertexAttribPointer(this.mpositionid, 3, 5126, false, 0, this.mPositoins);
          GLES20.glVertexAttribPointer(this.mtexcoordid, 2, 5126, false, 0, this.mTexcoords);
          GLES20.glDrawArrays(5, 0, 4);
          j = this.mTextureid[i];
          if (checkGlError("BlurFilter") == 0) {
            break;
          }
          RuntimeException localRuntimeException = new RuntimeException("sifeng: BlurFilter process failed");
          AppMethodBeat.o(248105);
          throw localRuntimeException;
          GLES20.glUniform2f(this.mtexSizeid, paramInt2, paramInt3);
        }
        GLES20.glBindFramebuffer(36160, 0);
        i += 1;
        break;
        AppMethodBeat.o(248105);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.b.a
 * JD-Core Version:    0.7.0.1
 */