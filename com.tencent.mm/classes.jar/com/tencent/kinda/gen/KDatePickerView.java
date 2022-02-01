package com.tencent.kinda.gen;

public abstract interface KDatePickerView
  extends KView
{
  public abstract KDate currentDate();
  
  public abstract boolean getCanBeLongTerm();
  
  public abstract KDate getEndDate();
  
  public abstract boolean getFocus();
  
  public abstract KDate getSelectedDate();
  
  public abstract KDate getStartDate();
  
  public abstract DatePickerType getType();
  
  public abstract String getValue();
  
  public abstract void setCanBeLongTerm(boolean paramBoolean);
  
  public abstract void setEndDate(KDate paramKDate);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setHint(String paramString);
  
  public abstract void setOnSelectCallback(KDatePickerViewOnSelectCallback paramKDatePickerViewOnSelectCallback);
  
  public abstract void setOriginDate(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setStartDate(KDate paramKDate);
  
  public abstract void setType(DatePickerType paramDatePickerType);
  
  public abstract void setValue(String paramString);
  
  public abstract long timeForDate(KDate paramKDate);
  
  public abstract int yearOfNow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KDatePickerView
 * JD-Core Version:    0.7.0.1
 */