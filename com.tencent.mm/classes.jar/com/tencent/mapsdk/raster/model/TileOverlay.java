package com.tencent.mapsdk.raster.model;

public abstract interface TileOverlay
{
  public abstract void clearTileCache();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract String getId();
  
  public abstract int hashCode();
  
  public abstract void reload();
  
  public abstract void remove();
  
  public abstract void setDiskCacheDir(String paramString);
  
  public abstract void setZindex(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.TileOverlay
 * JD-Core Version:    0.7.0.1
 */