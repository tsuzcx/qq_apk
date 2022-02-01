package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;

public final class y
  implements af.b
{
  private static final ConcurrentHashMap<String, Boolean> nEY;
  
  static
  {
    AppMethodBeat.i(44296);
    nEY = new ConcurrentHashMap();
    AppMethodBeat.o(44296);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(284601);
    if (parama == null)
    {
      AppMethodBeat.o(284601);
      return false;
    }
    if ((bd.class == parama.getClass()) || (ay.class == parama.getClass()) || (az.class == parama.getClass()) || (ca.class == parama.getClass()))
    {
      AppMethodBeat.o(284601);
      return true;
    }
    AppMethodBeat.o(284601);
    return false;
  }
  
  public static void acK(String paramString)
  {
    AppMethodBeat.i(44294);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44294);
      return;
    }
    nEY.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(44294);
  }
  
  public final af.a b(a parama)
  {
    AppMethodBeat.i(44293);
    if (a(parama))
    {
      parama = new y.a(parama, (byte)0);
      AppMethodBeat.o(44293);
      return parama;
    }
    AppMethodBeat.o(44293);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.y
 * JD-Core Version:    0.7.0.1
 */