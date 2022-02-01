package com.tencent.kinda.gen;

public abstract interface KCardNumberEditView
  extends KView
{
  public abstract boolean getFocus();
  
  public abstract String getHint();
  
  public abstract DynamicColor getHintColor();
  
  public abstract int getInputTextLength();
  
  public abstract DynamicColor getTextColor();
  
  public abstract String getValue();
  
  public abstract boolean isBankCardNumber();
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setHint(String paramString);
  
  public abstract void setHintColor(DynamicColor paramDynamicColor);
  
  public abstract void setOnTextChangedCallback(KCardNumberEditViewOnTextChangedCallback paramKCardNumberEditViewOnTextChangedCallback);
  
  public abstract void setText(String paramString);
  
  public abstract void setTextColor(DynamicColor paramDynamicColor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KCardNumberEditView
 * JD-Core Version:    0.7.0.1
 */