package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class ar
  extends Exception
{
  public ar(String paramString)
  {
    super(String.format(Locale.US, "%s not found", new Object[] { paramString }));
    AppMethodBeat.i(146931);
    AppMethodBeat.o(146931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ar
 * JD-Core Version:    0.7.0.1
 */