package com.d.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements com.tencent.mapsdk.raster.model.CustomLayer
{
  private com.tencent.tencentmap.mapsdk.maps.model.CustomLayer SJK;
  
  public c(com.tencent.tencentmap.mapsdk.maps.model.CustomLayer paramCustomLayer)
  {
    this.SJK = paramCustomLayer;
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(217297);
    if (this.SJK == null)
    {
      AppMethodBeat.o(217297);
      return;
    }
    this.SJK.clearDiskCache();
    AppMethodBeat.o(217297);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(217298);
    if (this.SJK == null)
    {
      AppMethodBeat.o(217298);
      return null;
    }
    String str = this.SJK.getId();
    AppMethodBeat.o(217298);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(217295);
    if (this.SJK == null)
    {
      AppMethodBeat.o(217295);
      return;
    }
    this.SJK.reload();
    AppMethodBeat.o(217295);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(217296);
    if (this.SJK == null)
    {
      AppMethodBeat.o(217296);
      return;
    }
    this.SJK.remove();
    AppMethodBeat.o(217296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */