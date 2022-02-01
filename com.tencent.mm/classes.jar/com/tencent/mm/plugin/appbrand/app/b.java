package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
  implements g
{
  private String jjx;
  private g.a jjy;
  
  public final void HF(String paramString)
  {
    AppMethodBeat.i(186289);
    this.jjx = ah.dg(paramString + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(186289);
  }
  
  public final void a(g.a parama)
  {
    this.jjy = parama;
  }
  
  public final String aVg()
  {
    return this.jjx;
  }
  
  public final g.a aVh()
  {
    return this.jjy;
  }
  
  public final String ca(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186288);
    paramString1 = j.CK().get(paramString1, paramString2);
    AppMethodBeat.o(186288);
    return paramString1;
  }
  
  public final void clear()
  {
    this.jjx = null;
    this.jjy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b
 * JD-Core Version:    0.7.0.1
 */