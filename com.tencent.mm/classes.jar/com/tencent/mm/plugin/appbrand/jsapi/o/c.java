package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;

public final class c
{
  public static b.a a(i parami)
  {
    AppMethodBeat.i(176554);
    parami = parami.optString("pictureInPictureMode", null);
    if (parami == null)
    {
      AppMethodBeat.o(176554);
      return null;
    }
    parami = b.a.IT(parami);
    AppMethodBeat.o(176554);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c
 * JD-Core Version:    0.7.0.1
 */