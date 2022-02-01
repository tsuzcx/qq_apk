package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Locale;

final class s$2
  extends HashMap<String, o>
{
  s$2(s params) {}
  
  public final String toString()
  {
    AppMethodBeat.i(45421);
    String str = String.format(Locale.ENGLISH, "PageAPIs[%d]", new Object[] { Integer.valueOf(size()) });
    AppMethodBeat.o(45421);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.2
 * JD-Core Version:    0.7.0.1
 */