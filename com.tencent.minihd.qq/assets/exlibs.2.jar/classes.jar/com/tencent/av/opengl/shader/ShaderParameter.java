package com.tencent.av.opengl.shader;

public abstract class ShaderParameter
{
  public int handle = -1;
  protected final String mName;
  
  public ShaderParameter(String paramString)
  {
    this.mName = paramString;
  }
  
  public abstract void loadHandle(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.shader.ShaderParameter
 * JD-Core Version:    0.7.0.1
 */