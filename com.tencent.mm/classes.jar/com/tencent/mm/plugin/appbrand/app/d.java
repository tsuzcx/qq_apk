package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.sdk.platformtools.MD5Util;

public final class d
  implements g
{
  private String nBW;
  private g.a nBX;
  
  public final void a(g.a parama)
  {
    this.nBX = parama;
  }
  
  public final void acp(String paramString)
  {
    AppMethodBeat.i(257831);
    this.nBW = MD5Util.getMD5String(paramString + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(257831);
  }
  
  public final String bFl()
  {
    return this.nBW;
  }
  
  public final g.a bFm()
  {
    return this.nBX;
  }
  
  public final void clear()
  {
    this.nBW = null;
    this.nBX = null;
  }
  
  public final String cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(257830);
    paramString1 = m.QG().L(paramString1, paramString2);
    AppMethodBeat.o(257830);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.d
 * JD-Core Version:    0.7.0.1
 */