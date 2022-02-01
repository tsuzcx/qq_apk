package com.tencent.mm.live.core.core.d.b;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class b
{
  private static final float[] positoins = { -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
  private static final float[] texcoords = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  public int[] mFrameBuffer;
  public int mHeight;
  public float[] mMVPMatrix;
  public FloatBuffer mPositoins;
  public int mProgramHandle;
  public float[] mSTMatrix;
  public FloatBuffer mTexcoords;
  public int[] mTextureid;
  public int mWidth;
  public int minputImageTextureid;
  public int mpositionid;
  public int mtexcoordid;
  public int muMVPMatrixHandle;
  public int muSTMatrixHandle;
  
  public b()
  {
    AppMethodBeat.i(248047);
    this.mMVPMatrix = new float[16];
    this.mSTMatrix = new float[16];
    this.mProgramHandle = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mpositionid = 0;
    this.mtexcoordid = 0;
    this.minputImageTextureid = 0;
    this.mFrameBuffer = new int[1];
    this.mFrameBuffer[0] = 0;
    this.mTextureid = new int[1];
    this.mTextureid[0] = 0;
    this.mPositoins = ByteBuffer.allocateDirect(positoins.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mPositoins.put(positoins).position(0);
    this.mTexcoords = ByteBuffer.allocateDirect(texcoords.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTexcoords.put(texcoords).position(0);
    Matrix.setIdentityM(this.mSTMatrix, 0);
    int k = compileShader("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 position;\nattribute vec4 texCoord;\nvarying vec2 coordinate;\nvoid main()\n{\n   gl_Position = uMVPMatrix * position;\n   coordinate = (uSTMatrix * texCoord).xy;\n}\n", 35633);
    int i;
    if (k == 0) {
      i = j;
    }
    while ((i != 1) || (checkGlError("OES2TextureFilter") != 0))
    {
      Object localObject = new RuntimeException("sifeng: OES2TextureFilter create failed");
      AppMethodBeat.o(248047);
      throw ((Throwable)localObject);
      int m = compileShader("precision mediump float;\nvarying highp vec2 coordinate;\nuniform sampler2D inputImageTexture;\nvec3 RGB2YUV(vec3 rgb)\n{\nvec3 yuv = vec3(0.0);\nyuv.x = rgb.r * 0.257 + rgb.g * 0.504 + rgb.b * 0.098 + 0.00627;\nyuv.y = rgb.r * -0.148 + rgb.g * -0.291 + rgb.b * 0.439 + 0.50196;\nyuv.z = rgb.r * 0.439 + rgb.g * -0.368 + rgb.b * -0.071 + 0.50196;\nreturn yuv;\n}\nvoid main()\n{\nvec3 orgColor = texture2D(inputImageTexture, coordinate).rgb;\nvec3 yuvColor = RGB2YUV(orgColor);\ngl_FragColor = vec4(yuvColor, 1.0);\n}\n", 35632);
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
                        if (this.muSTMatrixHandle != -1) {
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
    AppMethodBeat.o(248047);
  }
  
  public static int checkGlError(String paramString)
  {
    AppMethodBeat.i(248068);
    int i = GLES20.glGetError();
    if (i != 0)
    {
      new StringBuilder().append(paramString).append(": EGL error: 0x").append(Integer.toHexString(i));
      AppMethodBeat.o(248068);
      return i;
    }
    AppMethodBeat.o(248068);
    return 0;
  }
  
  private static int compileShader(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(248060);
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
      AppMethodBeat.o(248060);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.b.b
 * JD-Core Version:    0.7.0.1
 */