package com.f.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements com.tencent.mapsdk.raster.model.CustomLayer
{
  private com.tencent.tencentmap.mapsdk.maps.model.CustomLayer MWC;
  
  public c(com.tencent.tencentmap.mapsdk.maps.model.CustomLayer paramCustomLayer)
  {
    this.MWC = paramCustomLayer;
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(212638);
    if (this.MWC == null)
    {
      AppMethodBeat.o(212638);
      return;
    }
    this.MWC.clearDiskCache();
    AppMethodBeat.o(212638);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(212639);
    if (this.MWC == null)
    {
      AppMethodBeat.o(212639);
      return null;
    }
    String str = this.MWC.getId();
    AppMethodBeat.o(212639);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(212636);
    if (this.MWC == null)
    {
      AppMethodBeat.o(212636);
      return;
    }
    this.MWC.reload();
    AppMethodBeat.o(212636);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(212637);
    if (this.MWC == null)
    {
      AppMethodBeat.o(212637);
      return;
    }
    this.MWC.remove();
    AppMethodBeat.o(212637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */