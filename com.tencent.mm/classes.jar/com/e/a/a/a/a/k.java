package com.e.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  implements com.tencent.mapsdk.raster.model.TileOverlay
{
  private com.tencent.tencentmap.mapsdk.maps.model.TileOverlay KJq;
  
  public k(com.tencent.tencentmap.mapsdk.maps.model.TileOverlay paramTileOverlay)
  {
    this.KJq = paramTileOverlay;
  }
  
  public final void clearTileCache()
  {
    AppMethodBeat.i(206058);
    if (this.KJq == null)
    {
      AppMethodBeat.o(206058);
      return;
    }
    this.KJq.clearTileCache();
    AppMethodBeat.o(206058);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(206059);
    if (this.KJq == null)
    {
      AppMethodBeat.o(206059);
      return null;
    }
    String str = this.KJq.getId();
    AppMethodBeat.o(206059);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(206054);
    if (this.KJq == null)
    {
      AppMethodBeat.o(206054);
      return;
    }
    this.KJq.reload();
    AppMethodBeat.o(206054);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(206055);
    if (this.KJq == null)
    {
      AppMethodBeat.o(206055);
      return;
    }
    this.KJq.remove();
    AppMethodBeat.o(206055);
  }
  
  public final void setDiskCacheDir(String paramString)
  {
    AppMethodBeat.i(206056);
    if (this.KJq == null)
    {
      AppMethodBeat.o(206056);
      return;
    }
    this.KJq.setDiskCacheDir(paramString);
    AppMethodBeat.o(206056);
  }
  
  public final void setZindex(int paramInt)
  {
    AppMethodBeat.i(206057);
    if (this.KJq == null)
    {
      AppMethodBeat.o(206057);
      return;
    }
    this.KJq.setZindex(paramInt);
    AppMethodBeat.o(206057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */