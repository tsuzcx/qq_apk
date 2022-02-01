package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  private static k HHy;
  public static final h HHz;
  
  static
  {
    AppMethodBeat.i(289588);
    HHy = null;
    HHz = new h();
    AppMethodBeat.o(289588);
  }
  
  public static String ID(String paramString)
  {
    AppMethodBeat.i(289587);
    if (HHy == null)
    {
      AppMethodBeat.o(289587);
      return null;
    }
    paramString = HHy.ID(paramString);
    AppMethodBeat.o(289587);
    return paramString;
  }
  
  public static void a(k paramk)
  {
    AppMethodBeat.i(289585);
    HHy = paramk;
    Log.i("MicroMsg.GalleryHelper", "setMediaItemProvider: ".concat(String.valueOf(paramk)));
    AppMethodBeat.o(289585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.h
 * JD-Core Version:    0.7.0.1
 */