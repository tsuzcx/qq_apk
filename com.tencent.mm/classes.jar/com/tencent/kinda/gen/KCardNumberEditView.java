package com.tencent.kinda.gen;

public abstract interface KCardNumberEditView
  extends KView
{
  public abstract boolean getFocus();
  
  public abstract String getHint();
  
  public abstract long getHintColor();
  
  public abstract String getValue();
  
  public abstract boolean isBankCardNumber();
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setHint(String paramString);
  
  public abstract void setHintColor(long paramLong);
  
  public abstract void setOnTextChangedCallback(KCardNumberEditViewOnTextChangedCallback paramKCardNumberEditViewOnTextChangedCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.KCardNumberEditView
 * JD-Core Version:    0.7.0.1
 */