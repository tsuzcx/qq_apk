package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.f;

final class h$1
  implements f
{
  private final com.tencent.mm.plugin.appbrand.report.model.h ioE;
  
  h$1(h paramh)
  {
    AppMethodBeat.i(132124);
    this.ioE = new c(d.d(this.ioF.getRuntime().atS().hiz));
    AppMethodBeat.o(132124);
  }
  
  public final void G(Intent paramIntent) {}
  
  public final void a(long paramLong, bf parambf) {}
  
  public final void a(z paramz)
  {
    AppMethodBeat.i(132125);
    b(paramz);
    AppMethodBeat.o(132125);
  }
  
  public final void a(z paramz1, z paramz2, bf parambf)
  {
    AppMethodBeat.i(132127);
    this.ioE.a(paramz1, paramz2, parambf);
    AppMethodBeat.o(132127);
  }
  
  public final void aHD() {}
  
  public final com.tencent.mm.plugin.appbrand.report.model.h aHE()
  {
    return this.ioE;
  }
  
  public final Intent aHF()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.model.o aHG()
  {
    AppMethodBeat.i(132126);
    com.tencent.mm.plugin.appbrand.report.model.o localo = com.tencent.mm.plugin.appbrand.report.model.o.aLs();
    AppMethodBeat.o(132126);
    return localo;
  }
  
  public final void aHH() {}
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(132128);
    this.ioE.b(paramz);
    AppMethodBeat.o(132128);
  }
  
  public final void c(z paramz)
  {
    AppMethodBeat.i(132129);
    this.ioE.c(paramz);
    AppMethodBeat.o(132129);
  }
  
  public final void resetSession() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.h.1
 * JD-Core Version:    0.7.0.1
 */