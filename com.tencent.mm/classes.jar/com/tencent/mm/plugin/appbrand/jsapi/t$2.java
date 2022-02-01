package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Locale;

final class t$2
  extends HashMap<String, p>
{
  t$2(t paramt) {}
  
  public final String toString()
  {
    AppMethodBeat.i(45421);
    String str = String.format(Locale.ENGLISH, "PageAPIs[%d]", new Object[] { Integer.valueOf(size()) });
    AppMethodBeat.o(45421);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.2
 * JD-Core Version:    0.7.0.1
 */