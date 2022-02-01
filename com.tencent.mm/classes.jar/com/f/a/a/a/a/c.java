package com.f.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements com.tencent.mapsdk.raster.model.CustomLayer
{
  private com.tencent.tencentmap.mapsdk.maps.model.CustomLayer Mzv;
  
  public c(com.tencent.tencentmap.mapsdk.maps.model.CustomLayer paramCustomLayer)
  {
    this.Mzv = paramCustomLayer;
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(199946);
    if (this.Mzv == null)
    {
      AppMethodBeat.o(199946);
      return;
    }
    this.Mzv.clearDiskCache();
    AppMethodBeat.o(199946);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(199947);
    if (this.Mzv == null)
    {
      AppMethodBeat.o(199947);
      return null;
    }
    String str = this.Mzv.getId();
    AppMethodBeat.o(199947);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(199944);
    if (this.Mzv == null)
    {
      AppMethodBeat.o(199944);
      return;
    }
    this.Mzv.reload();
    AppMethodBeat.o(199944);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(199945);
    if (this.Mzv == null)
    {
      AppMethodBeat.o(199945);
      return;
    }
    this.Mzv.remove();
    AppMethodBeat.o(199945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */