package com.tencent.kinda.gen;

import java.util.ArrayList;

public abstract interface KCardTypePickerView
  extends KView
{
  public abstract boolean getEnabled();
  
  public abstract boolean getFocus();
  
  public abstract void select(int paramInt);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setHint(String paramString);
  
  public abstract void setOnSelectCallback(KCardTypePickerViewOnSelectCallback paramKCardTypePickerViewOnSelectCallback);
  
  public abstract void setOptions(ArrayList<Option> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KCardTypePickerView
 * JD-Core Version:    0.7.0.1
 */