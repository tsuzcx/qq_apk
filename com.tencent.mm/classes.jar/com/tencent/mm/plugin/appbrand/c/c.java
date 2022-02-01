package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class c
{
  public HashMap<String, a> jaF;
  
  public c()
  {
    AppMethodBeat.i(44824);
    this.jaF = new HashMap();
    AppMethodBeat.o(44824);
  }
  
  public final a Fv(String paramString)
  {
    AppMethodBeat.i(44826);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(44826);
      return null;
    }
    paramString = (a)this.jaF.get(paramString);
    AppMethodBeat.o(44826);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(44825);
    if ((parama == null) || (bt.isNullOrNil(parama.diQ)))
    {
      ad.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(44825);
      return;
    }
    ad.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", new Object[] { parama.diQ, parama.jau });
    this.jaF.put(parama.diQ, parama);
    AppMethodBeat.o(44825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.c
 * JD-Core Version:    0.7.0.1
 */