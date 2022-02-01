package com.e.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements com.tencent.mapsdk.raster.model.CustomLayer
{
  private com.tencent.tencentmap.mapsdk.maps.model.CustomLayer aalE;
  
  public c(com.tencent.tencentmap.mapsdk.maps.model.CustomLayer paramCustomLayer)
  {
    this.aalE = paramCustomLayer;
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(188482);
    if (this.aalE == null)
    {
      AppMethodBeat.o(188482);
      return;
    }
    this.aalE.clearDiskCache();
    AppMethodBeat.o(188482);
  }
  
  public final String getId()
  {
    AppMethodBeat.i(188483);
    if (this.aalE == null)
    {
      AppMethodBeat.o(188483);
      return null;
    }
    String str = this.aalE.getId();
    AppMethodBeat.o(188483);
    return str;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(188478);
    if (this.aalE == null)
    {
      AppMethodBeat.o(188478);
      return;
    }
    this.aalE.reload();
    AppMethodBeat.o(188478);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(188480);
    if (this.aalE == null)
    {
      AppMethodBeat.o(188480);
      return;
    }
    this.aalE.remove();
    AppMethodBeat.o(188480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */