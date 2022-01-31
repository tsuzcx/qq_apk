package com.tencent.kinda.gen;

public abstract interface KRegionEditView
  extends KView
{
  public abstract String getCity();
  
  public abstract String getCountry();
  
  public abstract boolean getFocus();
  
  public abstract String getProvince();
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setOnRegionSelectedCallback(KRegionEditViewOnRegionSelectedCallback paramKRegionEditViewOnRegionSelectedCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.KRegionEditView
 * JD-Core Version:    0.7.0.1
 */