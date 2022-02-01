package com.tencent.mapsdk.raster.model;

import java.net.URL;

public abstract class UrlTileProvider
  implements TileProvider
{
  private static final boolean PRINT_URL = false;
  public final int mHeight;
  public final int mWidth;
  
  public UrlTileProvider(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.UrlTileProvider
 * JD-Core Version:    0.7.0.1
 */