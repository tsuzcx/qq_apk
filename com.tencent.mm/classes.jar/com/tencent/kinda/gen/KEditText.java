package com.tencent.kinda.gen;

public abstract interface KEditText
  extends KView
{
  public abstract String encryptWith3Des();
  
  public abstract ClearButtonMode getClearButtonMode();
  
  public abstract boolean getEnabled();
  
  public abstract boolean getFocus();
  
  public abstract String getHint();
  
  public abstract long getHintColor();
  
  public abstract KeyboardType getKeyboardType();
  
  public abstract int getMaxLength();
  
  public abstract int getSelection();
  
  public abstract String getText();
  
  public abstract TextAlign getTextAlign();
  
  public abstract long getTextColor();
  
  public abstract String getTextFont();
  
  public abstract float getTextSize();
  
  public abstract long getTintColor();
  
  public abstract void setClearButtonMode(ClearButtonMode paramClearButtonMode);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setHint(String paramString);
  
  public abstract void setHintColor(long paramLong);
  
  public abstract void setKeyboardType(KeyboardType paramKeyboardType);
  
  public abstract void setMaxLength(int paramInt);
  
  public abstract void setOnTextBeginChangeCallback(KEditTextOnTextBeginChangeCallback paramKEditTextOnTextBeginChangeCallback);
  
  public abstract void setOnTextChangedCallback(KEditTextOnTextChangedCallback paramKEditTextOnTextChangedCallback);
  
  public abstract void setSelection(int paramInt);
  
  public abstract void setText(String paramString);
  
  public abstract void setTextAlign(TextAlign paramTextAlign);
  
  public abstract void setTextColor(long paramLong);
  
  public abstract void setTextFont(String paramString);
  
  public abstract void setTextSize(float paramFloat);
  
  public abstract void setTintColor(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KEditText
 * JD-Core Version:    0.7.0.1
 */