package com.tencent.kinda.gen;

public abstract interface KMoneyInputText
  extends KView
{
  public abstract boolean getFocus();
  
  public abstract String getInputText();
  
  public abstract String getTitle();
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setInputText(String paramString);
  
  public abstract void setOnTextChangedCallback(KMoneyInputTextOnTextChangedCallback paramKMoneyInputTextOnTextChangedCallback);
  
  public abstract void setOnkeyBoardVisibleAnchorCallback(KMoneyInputTextOnkeyBoardVisibleAnchorCallback paramKMoneyInputTextOnkeyBoardVisibleAnchorCallback);
  
  public abstract void setTitle(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KMoneyInputText
 * JD-Core Version:    0.7.0.1
 */