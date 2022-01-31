package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class c
{
  public HashMap<String, a> fNk = new HashMap();
  
  public final void a(a parama)
  {
    if ((parama == null) || (bk.bl(parama.bMB)))
    {
      y.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
      return;
    }
    y.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", new Object[] { parama.bMB, parama.fMZ });
    this.fNk.put(parama.bMB, parama);
  }
  
  public final a rQ(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
      return null;
    }
    return (a)this.fNk.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.c
 * JD-Core Version:    0.7.0.1
 */