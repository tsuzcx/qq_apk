package com.tencent.kinda.gen;

public abstract interface KBankEditView
  extends KView
{
  public abstract boolean getFocus();
  
  public abstract FontStyle getFontStyle();
  
  public abstract String getSelectedBankType();
  
  public abstract DynamicColor getTextColor();
  
  public abstract float getTextSize();
  
  public abstract void setData(ITransmitKvData paramITransmitKvData);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setFontStyle(FontStyle paramFontStyle);
  
  public abstract void setOnSeletBankCallback(KBankEditViewOnSeletBankCallback paramKBankEditViewOnSeletBankCallback);
  
  public abstract void setSelected(String paramString);
  
  public abstract void setTextColor(DynamicColor paramDynamicColor);
  
  public abstract void setTextSize(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KBankEditView
 * JD-Core Version:    0.7.0.1
 */