package com.e.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$2
  implements com.tencent.tencentmap.mapsdk.maps.model.TileProvider
{
  l$2(com.tencent.mapsdk.raster.model.TileProvider paramTileProvider) {}
  
  public final com.tencent.tencentmap.mapsdk.maps.model.Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(206061);
    Object localObject = this.KJr.getTile(paramInt1, paramInt2, paramInt3);
    if (localObject == null)
    {
      AppMethodBeat.o(206061);
      return null;
    }
    localObject = new com.tencent.tencentmap.mapsdk.maps.model.Tile(((com.tencent.mapsdk.raster.model.Tile)localObject).mWidth, ((com.tencent.mapsdk.raster.model.Tile)localObject).mHeight, ((com.tencent.mapsdk.raster.model.Tile)localObject).mData);
    AppMethodBeat.o(206061);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.a.a.a.l.2
 * JD-Core Version:    0.7.0.1
 */