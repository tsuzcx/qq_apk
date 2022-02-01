package com.j.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  implements com.tencent.mapsdk.raster.model.TileOverlay
{
  private com.tencent.tencentmap.mapsdk.maps.model.TileOverlay airZ;
  
  public k(com.tencent.tencentmap.mapsdk.maps.model.TileOverlay paramTileOverlay)
  {
    this.airZ = paramTileOverlay;
  }
  
  public final void clearTileCache()
  {
    AppMethodBeat.i(207219);
    if (this.airZ == null)
    {
      AppMethodBeat.o(207219);
      return;
    }
    this.airZ.clearTileCache();
    AppMethodBeat.o(207219);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(207228);
    if (this.airZ == null)
    {
      AppMethodBeat.o(207228);
      return null;
    }
    String str = this.airZ.getId();
    AppMethodBeat.o(207228);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(207166);
    if (this.airZ == null)
    {
      AppMethodBeat.o(207166);
      return;
    }
    this.airZ.reload();
    AppMethodBeat.o(207166);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(207179);
    if (this.airZ == null)
    {
      AppMethodBeat.o(207179);
      return;
    }
    this.airZ.remove();
    AppMethodBeat.o(207179);
  }
  
  public final void setDiskCacheDir(String paramString)
  {
    AppMethodBeat.i(207190);
    if (this.airZ == null)
    {
      AppMethodBeat.o(207190);
      return;
    }
    this.airZ.setDiskCacheDir(paramString);
    AppMethodBeat.o(207190);
  }
  
  public final void setZindex(int paramInt)
  {
    AppMethodBeat.i(207205);
    if (this.airZ == null)
    {
      AppMethodBeat.o(207205);
      return;
    }
    this.airZ.setZindex(paramInt);
    AppMethodBeat.o(207205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */