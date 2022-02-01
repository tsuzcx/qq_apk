package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class c
{
  public HashMap<String, a> jYe;
  
  public c()
  {
    AppMethodBeat.i(44824);
    this.jYe = new HashMap();
    AppMethodBeat.o(44824);
  }
  
  public final a Nz(String paramString)
  {
    AppMethodBeat.i(44826);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(44826);
      return null;
    }
    paramString = (a)this.jYe.get(paramString);
    AppMethodBeat.o(44826);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(44825);
    if ((parama == null) || (bu.isNullOrNil(parama.dsN)))
    {
      ae.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(44825);
      return;
    }
    ae.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", new Object[] { parama.dsN, parama.jXT });
    this.jYe.put(parama.dsN, parama);
    AppMethodBeat.o(44825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.c
 * JD-Core Version:    0.7.0.1
 */