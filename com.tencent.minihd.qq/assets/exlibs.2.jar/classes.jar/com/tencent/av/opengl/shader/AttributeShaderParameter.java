package com.tencent.av.opengl.shader;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.Utils;

public class AttributeShaderParameter
  extends ShaderParameter
{
  public AttributeShaderParameter(String paramString)
  {
    super(paramString);
  }
  
  public void loadHandle(int paramInt)
  {
    this.handle = GLES20.glGetAttribLocation(paramInt, this.mName);
    Utils.checkError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.shader.AttributeShaderParameter
 * JD-Core Version:    0.7.0.1
 */