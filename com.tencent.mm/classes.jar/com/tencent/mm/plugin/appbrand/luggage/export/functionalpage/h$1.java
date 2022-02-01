package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.by;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.plugin.appbrand.report.model.q;

final class h$1
  implements f
{
  private final com.tencent.mm.plugin.appbrand.report.model.h kPx;
  
  h$1(h paramh)
  {
    AppMethodBeat.i(47506);
    this.kPx = new c(d.d(this.kPy.getRuntime().aNc().cfi));
    AppMethodBeat.o(47506);
  }
  
  public final void H(Intent paramIntent) {}
  
  public final void a(long paramLong, by paramby) {}
  
  public final void a(ae paramae1, ae paramae2, by paramby)
  {
    AppMethodBeat.i(47509);
    this.kPx.a(paramae1, paramae2, paramby);
    AppMethodBeat.o(47509);
  }
  
  public final p bhA()
  {
    AppMethodBeat.i(47508);
    p localp = p.bmK();
    AppMethodBeat.o(47508);
    return localp;
  }
  
  public final q bhB()
  {
    AppMethodBeat.i(180319);
    q localq = q.bmL();
    AppMethodBeat.o(180319);
    return localq;
  }
  
  public final void bhC() {}
  
  public final void bhx() {}
  
  public final com.tencent.mm.plugin.appbrand.report.model.h bhy()
  {
    return this.kPx;
  }
  
  public final Intent bhz()
  {
    return null;
  }
  
  public final void c(ae paramae)
  {
    AppMethodBeat.i(47507);
    d(paramae);
    AppMethodBeat.o(47507);
  }
  
  public final void d(ae paramae)
  {
    AppMethodBeat.i(47510);
    this.kPx.d(paramae);
    AppMethodBeat.o(47510);
  }
  
  public final void e(ae paramae)
  {
    AppMethodBeat.i(47511);
    this.kPx.e(paramae);
    AppMethodBeat.o(47511);
  }
  
  public final void resetSession() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.h.1
 * JD-Core Version:    0.7.0.1
 */