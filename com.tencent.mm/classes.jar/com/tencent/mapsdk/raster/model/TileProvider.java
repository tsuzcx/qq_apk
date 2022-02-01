package com.tencent.mapsdk.raster.model;

public abstract interface TileProvider
{
  public static final Tile NO_TILE = new Tile(-1, -1, null);
  
  public abstract Tile getTile(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.TileProvider
 * JD-Core Version:    0.7.0.1
 */