package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.ConcurrentHashMap;

public final class s
  implements z.b
{
  private static final ConcurrentHashMap<String, Boolean> gUC;
  
  static
  {
    AppMethodBeat.i(129390);
    gUC = new ConcurrentHashMap();
    AppMethodBeat.o(129390);
  }
  
  public static void yp(String paramString)
  {
    AppMethodBeat.i(129388);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129388);
      return;
    }
    gUC.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(129388);
  }
  
  public final z.a a(a parama)
  {
    AppMethodBeat.i(129387);
    if ((aq.class == parama.getClass()) || (ak.class == parama.getClass()) || (al.class == parama.getClass()) || (bd.class == parama.getClass()))
    {
      parama = new s.a(parama, (byte)0);
      AppMethodBeat.o(129387);
      return parama;
    }
    AppMethodBeat.o(129387);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s
 * JD-Core Version:    0.7.0.1
 */