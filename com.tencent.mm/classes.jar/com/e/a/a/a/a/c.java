package com.e.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements com.tencent.mapsdk.raster.model.CustomLayer
{
  private com.tencent.tencentmap.mapsdk.maps.model.CustomLayer KIQ;
  
  public c(com.tencent.tencentmap.mapsdk.maps.model.CustomLayer paramCustomLayer)
  {
    this.KIQ = paramCustomLayer;
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(205840);
    if (this.KIQ == null)
    {
      AppMethodBeat.o(205840);
      return;
    }
    this.KIQ.clearDiskCache();
    AppMethodBeat.o(205840);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(205841);
    if (this.KIQ == null)
    {
      AppMethodBeat.o(205841);
      return null;
    }
    String str = this.KIQ.getId();
    AppMethodBeat.o(205841);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(205838);
    if (this.KIQ == null)
    {
      AppMethodBeat.o(205838);
      return;
    }
    this.KIQ.reload();
    AppMethodBeat.o(205838);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(205839);
    if (this.KIQ == null)
    {
      AppMethodBeat.o(205839);
      return;
    }
    this.KIQ.remove();
    AppMethodBeat.o(205839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */