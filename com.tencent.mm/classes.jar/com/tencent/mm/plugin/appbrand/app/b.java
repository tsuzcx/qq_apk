package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
  implements g
{
  private String jGj;
  private g.a jGk;
  
  public final void Lw(String paramString)
  {
    AppMethodBeat.i(222086);
    this.jGj = aj.ej(paramString + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(222086);
  }
  
  public final void a(g.a parama)
  {
    this.jGk = parama;
  }
  
  public final String aYW()
  {
    return this.jGj;
  }
  
  public final g.a aYX()
  {
    return this.jGk;
  }
  
  public final String cc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222085);
    paramString1 = j.Em().get(paramString1, paramString2);
    AppMethodBeat.o(222085);
    return paramString1;
  }
  
  public final void clear()
  {
    this.jGj = null;
    this.jGk = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b
 * JD-Core Version:    0.7.0.1
 */