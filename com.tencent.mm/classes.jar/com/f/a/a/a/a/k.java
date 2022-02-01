package com.f.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  implements com.tencent.mapsdk.raster.model.TileOverlay
{
  private com.tencent.tencentmap.mapsdk.maps.model.TileOverlay MXk;
  
  public k(com.tencent.tencentmap.mapsdk.maps.model.TileOverlay paramTileOverlay)
  {
    this.MXk = paramTileOverlay;
  }
  
  public final void clearTileCache()
  {
    AppMethodBeat.i(212875);
    if (this.MXk == null)
    {
      AppMethodBeat.o(212875);
      return;
    }
    this.MXk.clearTileCache();
    AppMethodBeat.o(212875);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(212876);
    if (this.MXk == null)
    {
      AppMethodBeat.o(212876);
      return null;
    }
    String str = this.MXk.getId();
    AppMethodBeat.o(212876);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(212871);
    if (this.MXk == null)
    {
      AppMethodBeat.o(212871);
      return;
    }
    this.MXk.reload();
    AppMethodBeat.o(212871);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(212872);
    if (this.MXk == null)
    {
      AppMethodBeat.o(212872);
      return;
    }
    this.MXk.remove();
    AppMethodBeat.o(212872);
  }
  
  public final void setDiskCacheDir(String paramString)
  {
    AppMethodBeat.i(212873);
    if (this.MXk == null)
    {
      AppMethodBeat.o(212873);
      return;
    }
    this.MXk.setDiskCacheDir(paramString);
    AppMethodBeat.o(212873);
  }
  
  public final void setZindex(int paramInt)
  {
    AppMethodBeat.i(212874);
    if (this.MXk == null)
    {
      AppMethodBeat.o(212874);
      return;
    }
    this.MXk.setZindex(paramInt);
    AppMethodBeat.o(212874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */