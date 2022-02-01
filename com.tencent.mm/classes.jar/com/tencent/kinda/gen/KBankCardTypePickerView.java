package com.tencent.kinda.gen;

import java.util.ArrayList;

public abstract interface KBankCardTypePickerView
  extends KView
{
  public abstract boolean getFocus();
  
  public abstract String getValue();
  
  public abstract void setBankCardType(ArrayList<BankCardType> paramArrayList);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setOnSelectCallback(KBankCardTypePickerViewOnSelectCallback paramKBankCardTypePickerViewOnSelectCallback);
  
  public abstract void setSelectedBankCardType(BankCardType paramBankCardType);
  
  public abstract void setValue(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KBankCardTypePickerView
 * JD-Core Version:    0.7.0.1
 */