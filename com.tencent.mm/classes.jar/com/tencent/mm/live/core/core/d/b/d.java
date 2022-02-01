package com.tencent.mm.live.core.core.d.b;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class d
{
  public static final float[] mRd = { 8.0F, 0.25F, 0.4F, 0.35F, 0.25F, 20.0F, 4.0F, 0.25F, 0.35F, 0.35F, 0.3F, 20.0F };
  private static final float[] positoins = { -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
  private static final float[] texcoords = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  public int[] mFrameBuffer;
  public int mHeight;
  public float[] mMVPMatrix;
  public FloatBuffer mPositoins;
  public int mProgramHandle;
  public int mRe;
  public float[] mSTMatrix;
  public FloatBuffer mTexcoords;
  public int[] mTextureid;
  public int mWidth;
  public int mblurredImageTexture1id;
  public int mblurredImageTexture2id;
  public int mblurredImageTexture3id;
  public int minputImageTextureid;
  public int mpositionid;
  public int mtexcoordid;
  public int muMVPMatrixHandle;
  public int muSTMatrixHandle;
  
  public d()
  {
    AppMethodBeat.i(248061);
    this.mMVPMatrix = new float[16];
    this.mSTMatrix = new float[16];
    this.mProgramHandle = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mpositionid = 0;
    this.mtexcoordid = 0;
    this.minputImageTextureid = 0;
    this.mblurredImageTexture1id = 0;
    this.mblurredImageTexture2id = 0;
    this.mblurredImageTexture3id = 0;
    this.mRe = 0;
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
    while ((i != 1) || (checkGlError("USM3FusionFilter") != 0))
    {
      Object localObject = new RuntimeException("USM3FusionFilter create failed");
      AppMethodBeat.o(248061);
      throw ((Throwable)localObject);
      int m = compileShader("precision mediump float;\nvarying highp vec2 coordinate;\nuniform float paras[6];\nuniform sampler2D inputImageTexture;\nuniform sampler2D blurredImageTexture1;\nuniform sampler2D blurredImageTexture2;\nuniform sampler2D blurredImageTexture3;\nvec3 YUV2RGB(vec3 yuv)\n{\n  yuv.x = yuv.x - 0.00627;\n  yuv.y = yuv.y - 0.50196;\n  yuv.z = yuv.z - 0.50196;\n  vec3 rgb = vec3(0.0);\n  rgb.r = yuv.x * 1.164 +                 yuv.z * 1.596;\n  rgb.g = yuv.x * 1.164 + yuv.y * -0.392 + yuv.z * -0.813;\n  rgb.b = yuv.x * 1.164 + yuv.y * 2.017;\n  return rgb;\n}\nvoid main()\n{\n    vec3 orgColor = texture2D(inputImageTexture, coordinate).rgb;\n\n    float y0 = orgColor.r;\n\n    float y_lowpass1 = texture2D(blurredImageTexture1, coordinate).r;\n\n    float y_lowpass2 = texture2D(blurredImageTexture2, coordinate).r;\n\n    float y_lowpass3 = texture2D(blurredImageTexture3, coordinate).r;\n\n    float para1 = paras[0];\n    float para3 = paras[5];\n    float y_residue = abs(y0-y_lowpass1);\n    y_residue = y_residue>0.09412?(y_residue<0.18823?0.18823-y_residue:0.0):y_residue;  //24\n    float ay_residue = y_residue*255.0;\n    float resw1 = para3/((1.0+exp(-(ay_residue-para1)))*(ay_residue+2.0))*y_residue;\n\n    y_residue = abs(y0-y_lowpass2);\n    y_residue = y_residue>0.09412?(y_residue<0.18823?0.18823-y_residue:0.0):y_residue; //24\n    ay_residue = y_residue*255.0;\n    float resw2 = para3/((1.0+exp(-(ay_residue-para1)))*(ay_residue+2.0))*y_residue;\n\n    y_residue = abs(y0-y_lowpass3);\n    y_residue = y_residue>0.09412?(y_residue<0.18823?0.18823-y_residue:0.0):y_residue; //24\n    ay_residue = y_residue*255.0;\n    float resw3 = para3/((1.0+exp(-(ay_residue-para1)))*(ay_residue+2.0))*y_residue;\n\n    float resw;\n   // if ((y0-y_lowpass1)*(y0-y_lowpass2)<0.0 || (y0-y_lowpass1)*(y0-y_lowpass3)<0.0) resw = 0.0; \n    resw = y0-y_lowpass1>=0.0?pow(resw1, paras[2])*pow(resw2, paras[3])*pow(resw3, paras[4]):-pow(resw1, paras[2])*pow(resw2, paras[3])*pow(resw3, paras[4]);\n\n    float cvalue = clamp(y0+resw, 0.0, 1.0);\n\n    float para2 = paras[1];\n    float val_weight = cvalue <= (1.0 - para2)? 1.0 : (resw<0.0?1.0:pow((1.0-cvalue)/para2,3.0));\n    float yres = val_weight*cvalue + (1.0-val_weight)*y0;\n\n    vec3 rgbColor = YUV2RGB(vec3(yres, orgColor.gb));\n    gl_FragColor = vec4(rgbColor, 1.0);\n    // if (coordinate.x<0.2 && coordinate.y<0.2) gl_FragColor = vec4(vec3(paras[4]*2.0), 1.0);\n}\n", 35632);
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
                this.mblurredImageTexture1id = GLES20.glGetUniformLocation(this.mProgramHandle, "blurredImageTexture1");
                this.mblurredImageTexture2id = GLES20.glGetUniformLocation(this.mProgramHandle, "blurredImageTexture2");
                this.mblurredImageTexture3id = GLES20.glGetUniformLocation(this.mProgramHandle, "blurredImageTexture3");
                this.mRe = GLES20.glGetUniformLocation(this.mProgramHandle, "paras");
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
                          if (this.mblurredImageTexture1id != -1)
                          {
                            i = j;
                            if (this.mblurredImageTexture2id != -1)
                            {
                              i = j;
                              if (this.mblurredImageTexture3id != -1)
                              {
                                i = j;
                                if (this.mRe != -1) {
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
      }
    }
    AppMethodBeat.o(248061);
  }
  
  public static int checkGlError(String paramString)
  {
    AppMethodBeat.i(248077);
    int i = GLES20.glGetError();
    if (i != 0)
    {
      new StringBuilder().append(paramString).append(": EGL error: 0x").append(Integer.toHexString(i));
      AppMethodBeat.o(248077);
      return i;
    }
    AppMethodBeat.o(248077);
    return 0;
  }
  
  private static int compileShader(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(248069);
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
      AppMethodBeat.o(248069);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.b.d
 * JD-Core Version:    0.7.0.1
 */