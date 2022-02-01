package com.j.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements com.tencent.mapsdk.raster.model.CustomLayer
{
  private com.tencent.tencentmap.mapsdk.maps.model.CustomLayer airr;
  
  public c(com.tencent.tencentmap.mapsdk.maps.model.CustomLayer paramCustomLayer)
  {
    this.airr = paramCustomLayer;
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(207020);
    if (this.airr == null)
    {
      AppMethodBeat.o(207020);
      return;
    }
    this.airr.clearDiskCache();
    AppMethodBeat.o(207020);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(207029);
    if (this.airr == null)
    {
      AppMethodBeat.o(207029);
      return null;
    }
    String str = this.airr.getId();
    AppMethodBeat.o(207029);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(207007);
    if (this.airr == null)
    {
      AppMethodBeat.o(207007);
      return;
    }
    this.airr.reload();
    AppMethodBeat.o(207007);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(207016);
    if (this.airr == null)
    {
      AppMethodBeat.o(207016);
      return;
    }
    this.airr.remove();
    AppMethodBeat.o(207016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */