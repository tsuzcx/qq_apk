package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class c
{
  public HashMap<String, a> hgu;
  
  public c()
  {
    AppMethodBeat.i(129824);
    this.hgu = new HashMap();
    AppMethodBeat.o(129824);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(129825);
    if ((parama == null) || (bo.isNullOrNil(parama.ctV)))
    {
      ab.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
      AppMethodBeat.o(129825);
      return;
    }
    ab.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", new Object[] { parama.ctV, parama.hgj });
    this.hgu.put(parama.ctV, parama);
    AppMethodBeat.o(129825);
  }
  
  public final a zG(String paramString)
  {
    AppMethodBeat.i(129826);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
      AppMethodBeat.o(129826);
      return null;
    }
    paramString = (a)this.hgu.get(paramString);
    AppMethodBeat.o(129826);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.c
 * JD-Core Version:    0.7.0.1
 */