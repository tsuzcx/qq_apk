package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
  implements g
{
  private String jDl;
  private g.a jDm;
  
  public final void KW(String paramString)
  {
    AppMethodBeat.i(187972);
    this.jDl = ai.ee(paramString + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(187972);
  }
  
  public final void a(g.a parama)
  {
    this.jDm = parama;
  }
  
  public final String aYA()
  {
    return this.jDl;
  }
  
  public final g.a aYB()
  {
    return this.jDm;
  }
  
  public final String cc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187971);
    paramString1 = j.Ej().get(paramString1, paramString2);
    AppMethodBeat.o(187971);
    return paramString1;
  }
  
  public final void clear()
  {
    this.jDl = null;
    this.jDm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b
 * JD-Core Version:    0.7.0.1
 */