package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bt;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.sdk.f.a;

@SuppressLint({"ViewConstructor"})
public final class h
  extends v
{
  public h(j paramj)
  {
    super(a.jg(paramj.mContext), paramj);
    AppMethodBeat.i(47512);
    AppMethodBeat.o(47512);
  }
  
  public final void OE(String paramString)
  {
    AppMethodBeat.i(47513);
    super.OE("__wx__/open-api-redirecting-page");
    AppMethodBeat.o(47513);
  }
  
  public final f bop()
  {
    AppMethodBeat.i(47514);
    f local1 = new f()
    {
      private final com.tencent.mm.plugin.appbrand.report.model.h lqW;
      
      public final void H(Intent paramAnonymousIntent) {}
      
      public final void a(long paramAnonymousLong, bt paramAnonymousbt) {}
      
      public final void a(ae paramAnonymousae1, ae paramAnonymousae2, bt paramAnonymousbt)
      {
        AppMethodBeat.i(47509);
        this.lqW.a(paramAnonymousae1, paramAnonymousae2, paramAnonymousbt);
        AppMethodBeat.o(47509);
      }
      
      public final void bor() {}
      
      public final com.tencent.mm.plugin.appbrand.report.model.h bos()
      {
        return this.lqW;
      }
      
      public final Intent bot()
      {
        return null;
      }
      
      public final p bou()
      {
        AppMethodBeat.i(47508);
        p localp = p.btG();
        AppMethodBeat.o(47508);
        return localp;
      }
      
      public final q bov()
      {
        AppMethodBeat.i(180319);
        q localq = q.btH();
        AppMethodBeat.o(180319);
        return localq;
      }
      
      public final void bow() {}
      
      public final void c(ae paramAnonymousae)
      {
        AppMethodBeat.i(47507);
        d(paramAnonymousae);
        AppMethodBeat.o(47507);
      }
      
      public final void d(ae paramAnonymousae)
      {
        AppMethodBeat.i(47510);
        this.lqW.d(paramAnonymousae);
        AppMethodBeat.o(47510);
      }
      
      public final void e(ae paramAnonymousae)
      {
        AppMethodBeat.i(47511);
        this.lqW.e(paramAnonymousae);
        AppMethodBeat.o(47511);
      }
      
      public final void resetSession() {}
    };
    AppMethodBeat.o(47514);
    return local1;
  }
  
  public final ae boq()
  {
    AppMethodBeat.i(175007);
    i locali = new i();
    AppMethodBeat.o(175007);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.h
 * JD-Core Version:    0.7.0.1
 */