package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class c
{
  public HashMap<String, a> lbc;
  
  public c()
  {
    AppMethodBeat.i(44824);
    this.lbc = new HashMap();
    AppMethodBeat.o(44824);
  }
  
  public final a WH(String paramString)
  {
    AppMethodBeat.i(44826);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(44826);
      return null;
    }
    paramString = (a)this.lbc.get(paramString);
    AppMethodBeat.o(44826);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(44825);
    if ((parama == null) || (Util.isNullOrNil(parama.dJX)))
    {
      Log.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(44825);
      return;
    }
    Log.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", new Object[] { parama.dJX, parama.laR });
    this.lbc.put(parama.dJX, parama);
    AppMethodBeat.o(44825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.c
 * JD-Core Version:    0.7.0.1
 */