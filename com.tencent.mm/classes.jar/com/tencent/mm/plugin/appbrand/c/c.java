package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public final class c
{
  public HashMap<String, a> jAS;
  
  public c()
  {
    AppMethodBeat.i(44824);
    this.jAS = new HashMap();
    AppMethodBeat.o(44824);
  }
  
  public final a Jz(String paramString)
  {
    AppMethodBeat.i(44826);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(44826);
      return null;
    }
    paramString = (a)this.jAS.get(paramString);
    AppMethodBeat.o(44826);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(44825);
    if ((parama == null) || (bs.isNullOrNil(parama.dgl)))
    {
      ac.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(44825);
      return;
    }
    ac.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", new Object[] { parama.dgl, parama.jAH });
    this.jAS.put(parama.dgl, parama);
    AppMethodBeat.o(44825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.c
 * JD-Core Version:    0.7.0.1
 */