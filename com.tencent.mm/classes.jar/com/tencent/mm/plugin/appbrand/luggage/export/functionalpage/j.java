package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.e;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.model.s;
import com.tencent.mm.plugin.appbrand.report.model.t;
import com.tencent.mm.plugin.appbrand.w;

public final class j
  extends y
{
  public j(l paraml)
  {
    super(paraml.mContext, paraml);
    AppMethodBeat.i(47512);
    AppMethodBeat.o(47512);
  }
  
  public final ah adu(String paramString)
  {
    AppMethodBeat.i(320038);
    paramString = new k();
    AppMethodBeat.o(320038);
    return paramString;
  }
  
  public final h cBi()
  {
    AppMethodBeat.i(47514);
    h local1 = new h()
    {
      private final com.tencent.mm.plugin.appbrand.report.model.j tfT;
      
      public final void M(Intent paramAnonymousIntent) {}
      
      public final void a(long paramAnonymousLong, cb paramAnonymouscb) {}
      
      public final void a(ah paramAnonymousah1, ah paramAnonymousah2, cb paramAnonymouscb)
      {
        AppMethodBeat.i(47509);
        this.tfT.a(paramAnonymousah1, paramAnonymousah2, paramAnonymouscb);
        AppMethodBeat.o(47509);
      }
      
      public final void aqI() {}
      
      public final void cBj() {}
      
      public final com.tencent.mm.plugin.appbrand.report.model.j cBk()
      {
        return this.tfT;
      }
      
      public final Intent cBl()
      {
        return null;
      }
      
      public final s cBm()
      {
        AppMethodBeat.i(47508);
        s locals = s.cIY();
        AppMethodBeat.o(47508);
        return locals;
      }
      
      public final t cBn()
      {
        AppMethodBeat.i(180319);
        t localt = t.cIZ();
        AppMethodBeat.o(180319);
        return localt;
      }
      
      public final void cBo() {}
      
      public final void d(ah paramAnonymousah)
      {
        AppMethodBeat.i(47507);
        e(paramAnonymousah);
        AppMethodBeat.o(47507);
      }
      
      public final void e(ah paramAnonymousah)
      {
        AppMethodBeat.i(47510);
        this.tfT.e(paramAnonymousah);
        AppMethodBeat.o(47510);
      }
      
      public final void f(ah paramAnonymousah)
      {
        AppMethodBeat.i(47511);
        this.tfT.f(paramAnonymousah);
        AppMethodBeat.o(47511);
      }
    };
    AppMethodBeat.o(47514);
    return local1;
  }
  
  public final boolean e(u paramu)
  {
    return false;
  }
  
  public final void init(String paramString)
  {
    AppMethodBeat.i(47513);
    super.init(paramString);
    AppMethodBeat.o(47513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j
 * JD-Core Version:    0.7.0.1
 */