package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.av.opengl.shader.AttributeShaderParameter;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.shader.UniformShaderParameter;
import com.tencent.av.opengl.utils.Utils;

public class TextureProgram
{
  public static final String ALPHA_UNIFORM = "uAlpha";
  public static final String COLOR_MATRIX = "colorMat";
  public static final String COLOR_UNIFORM = "uColor";
  public static final int EDGETEXTURE = 9;
  public static final int INDEX_ALPHA = 2;
  public static final int INDEX_COLOR_MATRIX = 9;
  public static final int INDEX_HEIGHT = 8;
  public static final int INDEX_LEAVEL = 11;
  public static final int INDEX_MATRIX = 1;
  public static final int INDEX_POSITION = 0;
  public static final int INDEX_TEXTURE_CURVE = 8;
  public static final int INDEX_TEXTURE_MATRIX = 3;
  public static final int INDEX_TEXTURE_SAMPLER0 = 4;
  public static final int INDEX_TEXTURE_SAMPLER1 = 5;
  public static final int INDEX_TEXTURE_SAMPLER2 = 6;
  public static final int INDEX_WIDTH = 7;
  public static final int INDEX_YUV_FORMAT = 10;
  public static final String MATRIX_UNIFORM = "uMatrix";
  public static final String POSITION_ATTRIBUTE = "aPosition";
  public static final String TEXTURE_COORD_ATTRIBUTE = "aTextureCoordinate";
  public static final String TEXTURE_MATRIX_UNIFORM = "uTextureMatrix";
  public static final String TEXTURE_SAMPLER_UNIFORM0 = "uTextureSampler0";
  public static final String TEXTURE_SAMPLER_UNIFORM1 = "uTextureSampler1";
  public static final String TEXTURE_SAMPLER_UNIFORM2 = "uTextureSampler2";
  public static final String TEXTURE_SAMPLER_UNIFORM3 = "uTextureSampler3";
  public static final String TONE_CURVE_TEXTURE = "toneCurveTexture";
  public static final String YUV_FORMAT = "yuvFormat";
  public static final String YUV_HEIGHT = "fHeight";
  public static final String YUV_LEAVEL = "leavel";
  public static final String YUV_WIDTH = "fWidth";
  private static final String textureFragmentShader = "precision mediump float;varying vec2 vTextureCoord;uniform float uAlpha;uniform sampler2D  uTextureSampler0;void main() {gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);gl_FragColor *= uAlpha;}";
  private static final String textureVertexShader = "uniform mat4 uMatrix;uniform mat4  uTextureMatrix;attribute vec2 aPosition;varying vec2 vTextureCoord;void main() {vec4 pos = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;}";
  private int mFragmentShader = -1;
  private ShaderParameter[] mParameters;
  private int mProgram = -1;
  private int mVertexShader = -1;
  
  public TextureProgram()
  {
    this("uniform mat4 uMatrix;uniform mat4  uTextureMatrix;attribute vec2 aPosition;varying vec2 vTextureCoord;void main() {vec4 pos = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;}", "precision mediump float;varying vec2 vTextureCoord;uniform float uAlpha;uniform sampler2D  uTextureSampler0;void main() {gl_FragColor = texture2D(uTextureSampler0, vTextureCoord);gl_FragColor *= uAlpha;}", new ShaderParameter[] { new AttributeShaderParameter("aPosition"), new UniformShaderParameter("uMatrix"), new UniformShaderParameter("uAlpha"), new UniformShaderParameter("uTextureMatrix"), new UniformShaderParameter("uTextureSampler0") }, false);
  }
  
  protected TextureProgram(String paramString1, String paramString2, ShaderParameter[] paramArrayOfShaderParameter, boolean paramBoolean)
  {
    this.mVertexShader = loadShader(35633, paramString1);
    this.mFragmentShader = loadShader(35632, paramString2);
    this.mParameters = paramArrayOfShaderParameter;
    this.mProgram = assembleProgram(this.mVertexShader, this.mFragmentShader, this.mParameters);
  }
  
  public static int assembleProgram(int paramInt1, int paramInt2, ShaderParameter[] paramArrayOfShaderParameter)
  {
    int i = GLES20.glCreateProgram();
    Utils.checkError();
    if (i == 0) {
      return 0;
    }
    GLES20.glAttachShader(i, paramInt1);
    Utils.checkError();
    GLES20.glAttachShader(i, paramInt2);
    Utils.checkError();
    GLES20.glLinkProgram(i);
    Utils.checkError();
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(i, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] != 1)
    {
      GLES20.glDeleteProgram(i);
      return 0;
    }
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfShaderParameter.length)
    {
      paramArrayOfShaderParameter[paramInt1].loadHandle(i);
      paramInt1 += 1;
    }
    return i;
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    Utils.checkError();
    GLES20.glCompileShader(paramInt);
    Utils.checkError();
    return paramInt;
  }
  
  public int getId()
  {
    return this.mProgram;
  }
  
  public ShaderParameter[] getParameters()
  {
    return this.mParameters;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.program.TextureProgram
 * JD-Core Version:    0.7.0.1
 */