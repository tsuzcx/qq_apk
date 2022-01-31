package com.tencent.kinda.gen;

import java.util.ArrayList;

public abstract interface KCountryCallingCodeView
  extends KView
{
  public abstract String getCountryCode();
  
  public abstract boolean getFocus();
  
  public abstract boolean getHideCode();
  
  public abstract String getNationality();
  
  public abstract String getPlaceHolder();
  
  public abstract void setCountryCode(String paramString);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setHideCode(boolean paramBoolean);
  
  public abstract void setNationality(String paramString);
  
  public abstract void setNationalityExcludeArray(ArrayList<String> paramArrayList);
  
  public abstract void setOnSelectCallback(KCountryCallingCodeViewOnSelectCallback paramKCountryCallingCodeViewOnSelectCallback);
  
  public abstract void setPlaceHolder(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KCountryCallingCodeView
 * JD-Core Version:    0.7.0.1
 */