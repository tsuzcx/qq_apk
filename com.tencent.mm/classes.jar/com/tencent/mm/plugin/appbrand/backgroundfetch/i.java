package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends p
{
  private static final int CTRL_INDEX = 523;
  private static final String NAME = "onBackgroundFetchData";
  
  public static void o(o paramo)
  {
    AppMethodBeat.i(129808);
    String str = paramo.mAppId;
    i.1 local1 = new i.1(str);
    MMToClientEvent.a(str, local1);
    ab.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app start listening background fetched data event, appId:%s", new Object[] { str });
    paramo.gPL.a(new i.2(local1));
    AppMethodBeat.o(129808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.i
 * JD-Core Version:    0.7.0.1
 */