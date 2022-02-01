package com.f.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  implements com.tencent.mapsdk.raster.model.TileOverlay
{
  private com.tencent.tencentmap.mapsdk.maps.model.TileOverlay MAd;
  
  public k(com.tencent.tencentmap.mapsdk.maps.model.TileOverlay paramTileOverlay)
  {
    this.MAd = paramTileOverlay;
  }
  
  public final void clearTileCache()
  {
    AppMethodBeat.i(200181);
    if (this.MAd == null)
    {
      AppMethodBeat.o(200181);
      return;
    }
    this.MAd.clearTileCache();
    AppMethodBeat.o(200181);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(200182);
    if (this.MAd == null)
    {
      AppMethodBeat.o(200182);
      return null;
    }
    String str = this.MAd.getId();
    AppMethodBeat.o(200182);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(200177);
    if (this.MAd == null)
    {
      AppMethodBeat.o(200177);
      return;
    }
    this.MAd.reload();
    AppMethodBeat.o(200177);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(200178);
    if (this.MAd == null)
    {
      AppMethodBeat.o(200178);
      return;
    }
    this.MAd.remove();
    AppMethodBeat.o(200178);
  }
  
  public final void setDiskCacheDir(String paramString)
  {
    AppMethodBeat.i(200179);
    if (this.MAd == null)
    {
      AppMethodBeat.o(200179);
      return;
    }
    this.MAd.setDiskCacheDir(paramString);
    AppMethodBeat.o(200179);
  }
  
  public final void setZindex(int paramInt)
  {
    AppMethodBeat.i(200180);
    if (this.MAd == null)
    {
      AppMethodBeat.o(200180);
      return;
    }
    this.MAd.setZindex(paramInt);
    AppMethodBeat.o(200180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */