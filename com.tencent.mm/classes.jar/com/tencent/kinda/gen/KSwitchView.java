package com.tencent.kinda.gen;

public abstract interface KSwitchView
  extends KView
{
  public abstract boolean getEnabled();
  
  public abstract KImage getOffImage();
  
  public abstract boolean getOn();
  
  public abstract KImage getOnImage();
  
  public abstract long getOnTintColor();
  
  public abstract long getThumbTintColor();
  
  public abstract long getTintColor();
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setOffImage(KImage paramKImage);
  
  public abstract void setOn(boolean paramBoolean);
  
  public abstract void setOnChangeSwitchCallback(KSwitchViewOnChangeSwitchCallback paramKSwitchViewOnChangeSwitchCallback);
  
  public abstract void setOnImage(KImage paramKImage);
  
  public abstract void setOnTintColor(long paramLong);
  
  public abstract void setThumbTintColor(long paramLong);
  
  public abstract void setTintColor(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KSwitchView
 * JD-Core Version:    0.7.0.1
 */