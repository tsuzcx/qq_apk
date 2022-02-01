package com.tencent.kinda.gen;

public abstract interface KImageView
  extends KView
{
  public abstract String getDarkModeUrl();
  
  public abstract String getDefaultUrl();
  
  public abstract KImage getImage();
  
  public abstract byte[] getImageData();
  
  public abstract ScaleType getScaleType();
  
  public abstract DynamicColor getTintColor();
  
  public abstract String getUrl();
  
  public abstract void setDarkModeUrl(String paramString);
  
  public abstract void setDefaultUrl(String paramString);
  
  public abstract void setImage(KImage paramKImage);
  
  public abstract void setImageData(byte[] paramArrayOfByte);
  
  public abstract void setScaleType(ScaleType paramScaleType);
  
  public abstract void setTintColor(DynamicColor paramDynamicColor);
  
  public abstract void setUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KImageView
 * JD-Core Version:    0.7.0.1
 */