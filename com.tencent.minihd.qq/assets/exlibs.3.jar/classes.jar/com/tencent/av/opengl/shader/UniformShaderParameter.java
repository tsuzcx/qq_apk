package com.tencent.av.opengl.shader;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.Utils;

public class UniformShaderParameter
  extends ShaderParameter
{
  public UniformShaderParameter(String paramString)
  {
    super(paramString);
  }
  
  public void loadHandle(int paramInt)
  {
    this.handle = GLES20.glGetUniformLocation(paramInt, this.mName);
    Utils.checkError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.shader.UniformShaderParameter
 * JD-Core Version:    0.7.0.1
 */