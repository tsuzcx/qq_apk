package com.tencent.kinda.gen;

public abstract interface KBankEditView
  extends KView
{
  public abstract boolean getFocus();
  
  public abstract void setData(ITransmitKvData paramITransmitKvData);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setOnSeletBankCallback(KBankEditViewOnSeletBankCallback paramKBankEditViewOnSeletBankCallback);
  
  public abstract void setSelected(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.gen.KBankEditView
 * JD-Core Version:    0.7.0.1
 */