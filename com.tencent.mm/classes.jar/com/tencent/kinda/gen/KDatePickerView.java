package com.tencent.kinda.gen;

public abstract interface KDatePickerView
  extends KView
{
  public abstract boolean getFocus();
  
  public abstract DatePickerType getType();
  
  public abstract String getValue();
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setOnSelectCallback(KDatePickerViewOnSelectCallback paramKDatePickerViewOnSelectCallback);
  
  public abstract void setType(DatePickerType paramDatePickerType);
  
  public abstract void setValue(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KDatePickerView
 * JD-Core Version:    0.7.0.1
 */