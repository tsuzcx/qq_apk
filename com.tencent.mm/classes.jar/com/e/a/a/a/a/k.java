package com.e.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  implements com.tencent.mapsdk.raster.model.TileOverlay
{
  private com.tencent.tencentmap.mapsdk.maps.model.TileOverlay aamm;
  
  public k(com.tencent.tencentmap.mapsdk.maps.model.TileOverlay paramTileOverlay)
  {
    this.aamm = paramTileOverlay;
  }
  
  public final void clearTileCache()
  {
    AppMethodBeat.i(187603);
    if (this.aamm == null)
    {
      AppMethodBeat.o(187603);
      return;
    }
    this.aamm.clearTileCache();
    AppMethodBeat.o(187603);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(187605);
    if (this.aamm == null)
    {
      AppMethodBeat.o(187605);
      return null;
    }
    String str = this.aamm.getId();
    AppMethodBeat.o(187605);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(187596);
    if (this.aamm == null)
    {
      AppMethodBeat.o(187596);
      return;
    }
    this.aamm.reload();
    AppMethodBeat.o(187596);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(187597);
    if (this.aamm == null)
    {
      AppMethodBeat.o(187597);
      return;
    }
    this.aamm.remove();
    AppMethodBeat.o(187597);
  }
  
  public final void setDiskCacheDir(String paramString)
  {
    AppMethodBeat.i(187598);
    if (this.aamm == null)
    {
      AppMethodBeat.o(187598);
      return;
    }
    this.aamm.setDiskCacheDir(paramString);
    AppMethodBeat.o(187598);
  }
  
  public final void setZindex(int paramInt)
  {
    AppMethodBeat.i(187599);
    if (this.aamm == null)
    {
      AppMethodBeat.o(187599);
      return;
    }
    this.aamm.setZindex(paramInt);
    AppMethodBeat.o(187599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */