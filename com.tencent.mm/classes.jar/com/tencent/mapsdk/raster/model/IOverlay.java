package com.tencent.mapsdk.raster.model;

public abstract interface IOverlay
{
  public abstract String getId();
  
  public abstract boolean isVisible();
  
  public abstract void remove();
  
  public abstract void setVisible(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.IOverlay
 * JD-Core Version:    0.7.0.1
 */