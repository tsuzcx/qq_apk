package com.tencent.kinda.gen;

public abstract interface KSecureEditText
  extends KView
{
  public abstract ClearButtonMode getClearButtonMode();
  
  public abstract String getDefaultValue();
  
  public abstract boolean getEnabled();
  
  public abstract boolean getFocus();
  
  public abstract String getHint();
  
  public abstract KeyboardType getKeyboardType();
  
  public abstract int getMaxLength();
  
  public abstract String getText();
  
  public abstract DynamicColor getTextColor();
  
  public abstract DynamicColor getTintColor();
  
  public abstract boolean isCardFromatValid(int paramInt);
  
  public abstract void setClearButtonMode(ClearButtonMode paramClearButtonMode);
  
  public abstract void setDefaultValue(String paramString);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setHint(String paramString);
  
  public abstract void setKeyboardType(KeyboardType paramKeyboardType);
  
  public abstract void setMaxLength(int paramInt);
  
  public abstract void setOnTextChangedCallback(KSecureEditTextOnTextChangedCallback paramKSecureEditTextOnTextChangedCallback);
  
  public abstract void setText(String paramString);
  
  public abstract void setTextColor(DynamicColor paramDynamicColor);
  
  public abstract void setTintColor(DynamicColor paramDynamicColor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KSecureEditText
 * JD-Core Version:    0.7.0.1
 */