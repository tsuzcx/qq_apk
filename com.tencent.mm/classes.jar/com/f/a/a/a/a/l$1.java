package com.f.a.a.a.a;

import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;

final class l$1
  extends com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
{
  l$1(int paramInt1, int paramInt2, TileProvider paramTileProvider)
  {
    super(paramInt1, paramInt2);
  }
  
  public final URL getTileUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(212877);
    URL localURL = ((com.tencent.mapsdk.raster.model.UrlTileProvider)this.MXl).getTileUrl(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(212877);
    return localURL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.f.a.a.a.a.l.1
 * JD-Core Version:    0.7.0.1
 */