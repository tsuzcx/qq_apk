package com.tencent.kinda.gen;

public abstract interface KImage
{
  public abstract float getHeight();
  
  public abstract String getUrl();
  
  public abstract float getWidth();
  
  public abstract void setDarkModeUrl(String paramString);
  
  public abstract void setSvgUrl(String paramString, DynamicColor paramDynamicColor);
  
  public abstract void setSvgUrl(String paramString, DynamicColor paramDynamicColor, KSize paramKSize);
  
  public abstract void setUrl(String paramString);
  
  public abstract void stretchImage(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KImage
 * JD-Core Version:    0.7.0.1
 */