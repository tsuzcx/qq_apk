package com.tencent.kinda.gen;

public abstract interface KCountPickerView
  extends KView
{
  public abstract boolean getFocus();
  
  public abstract String getValue();
  
  public abstract void setDefaultCount(int paramInt);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setOnSelectCallback(KCountPickerViewOnSelectCallback paramKCountPickerViewOnSelectCallback);
  
  public abstract void setValue(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.KCountPickerView
 * JD-Core Version:    0.7.0.1
 */