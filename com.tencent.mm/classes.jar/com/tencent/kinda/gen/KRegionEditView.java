package com.tencent.kinda.gen;

import java.util.ArrayList;

public abstract interface KRegionEditView
  extends KView
{
  public abstract boolean getAutoLocation();
  
  public abstract String getCity();
  
  public abstract String getCountry();
  
  public abstract boolean getFocus();
  
  public abstract String getProvince();
  
  public abstract boolean getShowDomesticCity();
  
  public abstract boolean getShowSelectedLocation();
  
  public abstract boolean isUSOrCA();
  
  public abstract void setAreaExcludeArray(ArrayList<String> paramArrayList);
  
  public abstract void setAutoLocation(boolean paramBoolean);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setOnRegionSelectedCallback(KRegionEditViewOnRegionSelectedCallback paramKRegionEditViewOnRegionSelectedCallback);
  
  public abstract void setOriginRegion(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void setShowDomesticCity(boolean paramBoolean);
  
  public abstract void setShowSelectedLocation(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.KRegionEditView
 * JD-Core Version:    0.7.0.1
 */