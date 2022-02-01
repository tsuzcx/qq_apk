package com.tencent.kinda.gen;

public abstract interface KButton
  extends KView
{
  public abstract KImage getDisabledImage();
  
  public abstract boolean getEnable();
  
  public abstract long getExpandHitHeight();
  
  public abstract long getExpandHitWidth();
  
  public abstract FontStyle getFontStyle();
  
  public abstract DynamicColor getNormalColor();
  
  public abstract KImage getNormalImage();
  
  public abstract KImage getPressedImage();
  
  public abstract KImage getSelectedImage();
  
  public abstract String getText();
  
  public abstract DynamicColor getTextNormalColor();
  
  public abstract float getTextSize();
  
  public abstract void setDisabledImage(KImage paramKImage);
  
  public abstract void setEnable(boolean paramBoolean);
  
  public abstract void setExpandHitHeight(long paramLong);
  
  public abstract void setExpandHitWidth(long paramLong);
  
  public abstract void setFontStyle(FontStyle paramFontStyle);
  
  public abstract void setNormalColor(DynamicColor paramDynamicColor);
  
  public abstract void setNormalImage(KImage paramKImage);
  
  public abstract void setPressedImage(KImage paramKImage);
  
  public abstract void setSelectedImage(KImage paramKImage);
  
  public abstract void setText(String paramString);
  
  public abstract void setTextNormalColor(DynamicColor paramDynamicColor);
  
  public abstract void setTextSize(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KButton
 * JD-Core Version:    0.7.0.1
 */