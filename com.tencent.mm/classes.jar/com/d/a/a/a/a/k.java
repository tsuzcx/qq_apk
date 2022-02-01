package com.d.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  implements com.tencent.mapsdk.raster.model.TileOverlay
{
  private com.tencent.tencentmap.mapsdk.maps.model.TileOverlay SKs;
  
  public k(com.tencent.tencentmap.mapsdk.maps.model.TileOverlay paramTileOverlay)
  {
    this.SKs = paramTileOverlay;
  }
  
  public final void clearTileCache()
  {
    AppMethodBeat.i(217535);
    if (this.SKs == null)
    {
      AppMethodBeat.o(217535);
      return;
    }
    this.SKs.clearTileCache();
    AppMethodBeat.o(217535);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(217536);
    if (this.SKs == null)
    {
      AppMethodBeat.o(217536);
      return null;
    }
    String str = this.SKs.getId();
    AppMethodBeat.o(217536);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(217531);
    if (this.SKs == null)
    {
      AppMethodBeat.o(217531);
      return;
    }
    this.SKs.reload();
    AppMethodBeat.o(217531);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(217532);
    if (this.SKs == null)
    {
      AppMethodBeat.o(217532);
      return;
    }
    this.SKs.remove();
    AppMethodBeat.o(217532);
  }
  
  public final void setDiskCacheDir(String paramString)
  {
    AppMethodBeat.i(217533);
    if (this.SKs == null)
    {
      AppMethodBeat.o(217533);
      return;
    }
    this.SKs.setDiskCacheDir(paramString);
    AppMethodBeat.o(217533);
  }
  
  public final void setZindex(int paramInt)
  {
    AppMethodBeat.i(217534);
    if (this.SKs == null)
    {
      AppMethodBeat.o(217534);
      return;
    }
    this.SKs.setZindex(paramInt);
    AppMethodBeat.o(217534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */