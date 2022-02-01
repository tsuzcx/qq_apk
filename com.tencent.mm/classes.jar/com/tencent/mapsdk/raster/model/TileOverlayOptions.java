package com.tencent.mapsdk.raster.model;

public final class TileOverlayOptions
{
  private boolean mBetterQuality = true;
  private volatile String mDiskCacheDir;
  private TileProvider mTileProvider;
  private volatile String mVersionInfo;
  private int mZIndex = 1;
  
  public final TileOverlayOptions betterQuality(boolean paramBoolean)
  {
    this.mBetterQuality = paramBoolean;
    return this;
  }
  
  public final TileOverlayOptions diskCacheDir(String paramString)
  {
    this.mDiskCacheDir = paramString;
    return this;
  }
  
  public final String getDiskCacheDir()
  {
    return this.mDiskCacheDir;
  }
  
  public final TileProvider getTileProvider()
  {
    return this.mTileProvider;
  }
  
  public final String getVersionInfo()
  {
    return this.mVersionInfo;
  }
  
  public final int getZIndex()
  {
    return this.mZIndex;
  }
  
  public final boolean isBetterQuality()
  {
    return this.mBetterQuality;
  }
  
  public final TileOverlayOptions tileProvider(TileProvider paramTileProvider)
  {
    this.mTileProvider = paramTileProvider;
    return this;
  }
  
  public final TileOverlayOptions versionInfo(String paramString)
  {
    this.mVersionInfo = paramString;
    return this;
  }
  
  public final TileOverlayOptions zIndex(int paramInt)
  {
    this.mZIndex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.TileOverlayOptions
 * JD-Core Version:    0.7.0.1
 */