package com.tencent.mm.plugin.appbrand;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.k.c;

public final class ah
{
  private static k.c gSi;
  private static k.c gSj;
  
  static
  {
    AppMethodBeat.i(129165);
    gSi = new ah.1();
    gSj = new ah.2();
    AppMethodBeat.o(129165);
  }
  
  public static k.c aun()
  {
    return gSi;
  }
  
  public static k.c auo()
  {
    return gSj;
  }
  
  private static Boolean aup()
  {
    AppMethodBeat.i(129162);
    Object localObject = com.tencent.mm.sdk.platformtools.ah.dsR().getString("appbrandgame_open_wcwss", "");
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("wcwss")))
    {
      localObject = Boolean.TRUE;
      AppMethodBeat.o(129162);
      return localObject;
    }
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("websocket")))
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(129162);
      return localObject;
    }
    AppMethodBeat.o(129162);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah
 * JD-Core Version:    0.7.0.1
 */