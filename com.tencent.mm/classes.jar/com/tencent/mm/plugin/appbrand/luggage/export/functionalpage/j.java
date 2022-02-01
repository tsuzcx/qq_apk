package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.sdk.f.a;

@SuppressLint({"ViewConstructor"})
public final class j
  extends u
{
  public j(l paraml)
  {
    super(a.jw(paraml.mContext), paraml);
    AppMethodBeat.i(47512);
    AppMethodBeat.o(47512);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(47513);
    super.SM("__wx__/open-api-redirecting-page");
    AppMethodBeat.o(47513);
  }
  
  public final f bsS()
  {
    AppMethodBeat.i(47514);
    f local1 = new f()
    {
      private final h lSX;
      
      public final void I(Intent paramAnonymousIntent) {}
      
      public final void a(long paramAnonymousLong, br paramAnonymousbr) {}
      
      public final void a(ad paramAnonymousad1, ad paramAnonymousad2, br paramAnonymousbr)
      {
        AppMethodBeat.i(47509);
        this.lSX.a(paramAnonymousad1, paramAnonymousad2, paramAnonymousbr);
        AppMethodBeat.o(47509);
      }
      
      public final void bsU() {}
      
      public final h bsV()
      {
        return this.lSX;
      }
      
      public final Intent bsW()
      {
        return null;
      }
      
      public final com.tencent.mm.plugin.appbrand.report.model.p bsX()
      {
        AppMethodBeat.i(47508);
        com.tencent.mm.plugin.appbrand.report.model.p localp = com.tencent.mm.plugin.appbrand.report.model.p.byE();
        AppMethodBeat.o(47508);
        return localp;
      }
      
      public final q bsY()
      {
        AppMethodBeat.i(180319);
        q localq = q.byF();
        AppMethodBeat.o(180319);
        return localq;
      }
      
      public final void bsZ() {}
      
      public final void c(ad paramAnonymousad)
      {
        AppMethodBeat.i(47507);
        d(paramAnonymousad);
        AppMethodBeat.o(47507);
      }
      
      public final void d(ad paramAnonymousad)
      {
        AppMethodBeat.i(47510);
        this.lSX.d(paramAnonymousad);
        AppMethodBeat.o(47510);
      }
      
      public final void e(ad paramAnonymousad)
      {
        AppMethodBeat.i(47511);
        this.lSX.e(paramAnonymousad);
        AppMethodBeat.o(47511);
      }
      
      public final void resetSession() {}
    };
    AppMethodBeat.o(47514);
    return local1;
  }
  
  public final ad bsT()
  {
    AppMethodBeat.i(175007);
    k localk = new k();
    AppMethodBeat.o(175007);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j
 * JD-Core Version:    0.7.0.1
 */