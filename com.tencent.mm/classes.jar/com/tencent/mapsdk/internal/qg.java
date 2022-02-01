package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;

public final class qg
{
  private qe a;
  
  public qg(qe paramqe)
  {
    this.a = paramqe;
  }
  
  public final pz a(TileOverlayOptions paramTileOverlayOptions)
  {
    AppMethodBeat.i(226010);
    Object localObject = null;
    TileProvider localTileProvider = paramTileOverlayOptions.getTileProvider();
    if (localTileProvider != null)
    {
      if (!(localTileProvider instanceof qk)) {
        break label51;
      }
      localObject = new qf(this.a, paramTileOverlayOptions);
    }
    for (;;)
    {
      this.a.a((pz)localObject);
      AppMethodBeat.o(226010);
      return localObject;
      label51:
      if ((localTileProvider instanceof rk)) {
        localObject = new qh(this.a, paramTileOverlayOptions);
      } else {
        localObject = new pz(this.a, paramTileOverlayOptions);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qg
 * JD-Core Version:    0.7.0.1
 */