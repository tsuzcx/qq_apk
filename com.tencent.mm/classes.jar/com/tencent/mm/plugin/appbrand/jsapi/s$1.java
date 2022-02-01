package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Locale;

final class s$1
  extends HashMap<String, o>
{
  s$1(s params) {}
  
  public final String toString()
  {
    AppMethodBeat.i(45420);
    String str = String.format(Locale.ENGLISH, "ServiceAPIs[%d]", new Object[] { Integer.valueOf(size()) });
    AppMethodBeat.o(45420);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.1
 * JD-Core Version:    0.7.0.1
 */