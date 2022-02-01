package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.sdk.platformtools.MD5Util;

public final class d
  implements g
{
  private String kIg;
  private g.a kIh;
  
  public final void UF(String paramString)
  {
    AppMethodBeat.i(226293);
    this.kIg = MD5Util.getMD5String(paramString + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(226293);
  }
  
  public final void a(g.a parama)
  {
    this.kIh = parama;
  }
  
  public final String bul()
  {
    return this.kIg;
  }
  
  public final g.a bum()
  {
    return this.kIh;
  }
  
  public final void clear()
  {
    this.kIg = null;
    this.kIh = null;
  }
  
  public final String cp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226292);
    paramString1 = n.NL().get(paramString1, paramString2);
    AppMethodBeat.o(226292);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.d
 * JD-Core Version:    0.7.0.1
 */