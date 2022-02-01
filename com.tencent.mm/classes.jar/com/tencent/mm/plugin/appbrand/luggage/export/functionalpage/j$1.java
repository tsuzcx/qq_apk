package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bs;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.plugin.appbrand.report.model.q;

final class j$1
  implements f
{
  private final h lOw;
  
  j$1(j paramj)
  {
    AppMethodBeat.i(47506);
    this.lOw = new c(d.d(this.lOx.getRuntime().aXc().cmv), this.lOx.getRuntime().aVW());
    AppMethodBeat.o(47506);
  }
  
  public final void I(Intent paramIntent) {}
  
  public final void a(long paramLong, bs parambs) {}
  
  public final void a(ae paramae1, ae paramae2, bs parambs)
  {
    AppMethodBeat.i(47509);
    this.lOw.a(paramae1, paramae2, parambs);
    AppMethodBeat.o(47509);
  }
  
  public final void bsj() {}
  
  public final h bsk()
  {
    return this.lOw;
  }
  
  public final Intent bsl()
  {
    return null;
  }
  
  public final p bsm()
  {
    AppMethodBeat.i(47508);
    p localp = p.bxL();
    AppMethodBeat.o(47508);
    return localp;
  }
  
  public final q bsn()
  {
    AppMethodBeat.i(180319);
    q localq = q.bxM();
    AppMethodBeat.o(180319);
    return localq;
  }
  
  public final void bso() {}
  
  public final void c(ae paramae)
  {
    AppMethodBeat.i(47507);
    d(paramae);
    AppMethodBeat.o(47507);
  }
  
  public final void d(ae paramae)
  {
    AppMethodBeat.i(47510);
    this.lOw.d(paramae);
    AppMethodBeat.o(47510);
  }
  
  public final void e(ae paramae)
  {
    AppMethodBeat.i(47511);
    this.lOw.e(paramae);
    AppMethodBeat.o(47511);
  }
  
  public final void resetSession() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j.1
 * JD-Core Version:    0.7.0.1
 */