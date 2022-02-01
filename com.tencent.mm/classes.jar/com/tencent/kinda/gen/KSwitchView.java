package com.tencent.kinda.gen;

public abstract interface KSwitchView
  extends KView
{
  public abstract boolean getEnabled();
  
  public abstract KImage getOffImage();
  
  public abstract boolean getOn();
  
  public abstract KImage getOnImage();
  
  public abstract DynamicColor getOnTintColor();
  
  public abstract DynamicColor getThumbTintColor();
  
  public abstract DynamicColor getTintColor();
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setOffImage(KImage paramKImage);
  
  public abstract void setOn(boolean paramBoolean);
  
  public abstract void setOnChangeSwitchCallback(KSwitchViewOnChangeSwitchCallback paramKSwitchViewOnChangeSwitchCallback);
  
  public abstract void setOnImage(KImage paramKImage);
  
  public abstract void setOnTintColor(DynamicColor paramDynamicColor);
  
  public abstract void setThumbTintColor(DynamicColor paramDynamicColor);
  
  public abstract void setTintColor(DynamicColor paramDynamicColor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KSwitchView
 * JD-Core Version:    0.7.0.1
 */