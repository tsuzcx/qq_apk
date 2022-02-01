package com.tencent.mapsdk.raster.model;

public abstract interface CustomLayer
{
  public abstract void clearDiskCache();
  
  public abstract String getId();
  
  public abstract void reload();
  
  public abstract void remove();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.CustomLayer
 * JD-Core Version:    0.7.0.1
 */