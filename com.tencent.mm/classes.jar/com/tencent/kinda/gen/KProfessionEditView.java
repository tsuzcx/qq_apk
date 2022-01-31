package com.tencent.kinda.gen;

public abstract interface KProfessionEditView
  extends KView
{
  public abstract boolean getFocus();
  
  public abstract String getProfessionName();
  
  public abstract int getProfessionType();
  
  public abstract void setData(ITransmitKvData paramITransmitKvData);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setOnSelectProfessionCallback(KProfessionEditViewOnSelectProfessionCallback paramKProfessionEditViewOnSelectProfessionCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.gen.KProfessionEditView
 * JD-Core Version:    0.7.0.1
 */