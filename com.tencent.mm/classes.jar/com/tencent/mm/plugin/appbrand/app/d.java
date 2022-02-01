package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.service.h;
import com.tencent.mm.plugin.appbrand.service.h.a;
import com.tencent.mm.sdk.platformtools.MD5Util;

public final class d
  implements h
{
  private String qBl;
  private h.a qBm;
  
  public final void UQ(String paramString)
  {
    AppMethodBeat.i(317803);
    this.qBl = MD5Util.getMD5String(paramString + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(317803);
  }
  
  public final void a(h.a parama)
  {
    this.qBm = parama;
  }
  
  public final String cL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317798);
    paramString1 = n.aqS().O(paramString1, paramString2);
    AppMethodBeat.o(317798);
    return paramString1;
  }
  
  public final h.a ceA()
  {
    return this.qBm;
  }
  
  public final String cez()
  {
    return this.qBl;
  }
  
  public final void clear()
  {
    this.qBl = null;
    this.qBm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.d
 * JD-Core Version:    0.7.0.1
 */