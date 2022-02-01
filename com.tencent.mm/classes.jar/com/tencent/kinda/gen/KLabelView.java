package com.tencent.kinda.gen;

public abstract interface KLabelView
  extends KView
{
  public abstract boolean getAdjustsFontSizeToFitWidth();
  
  public abstract BaselineAdjustmentAlign getBaselineAdjustment();
  
  public abstract Ellipsize getEllipsize();
  
  public abstract FontStyle getFontStyle();
  
  public abstract int getLines();
  
  public abstract int getMaxLength();
  
  public abstract String getText();
  
  public abstract TextAlign getTextAlign();
  
  public abstract DynamicColor getTextColor();
  
  public abstract String getTextFont();
  
  public abstract float getTextSize();
  
  public abstract void setAdjustsFontSizeToFitWidth(boolean paramBoolean);
  
  public abstract void setBaselineAdjustment(BaselineAdjustmentAlign paramBaselineAdjustmentAlign);
  
  public abstract void setEllipsize(Ellipsize paramEllipsize);
  
  public abstract void setFontStyle(FontStyle paramFontStyle);
  
  public abstract void setLines(int paramInt);
  
  public abstract void setMaxLength(int paramInt);
  
  public abstract void setText(String paramString);
  
  public abstract void setTextAlign(TextAlign paramTextAlign);
  
  public abstract void setTextColor(DynamicColor paramDynamicColor);
  
  public abstract void setTextFont(String paramString);
  
  public abstract void setTextSize(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KLabelView
 * JD-Core Version:    0.7.0.1
 */