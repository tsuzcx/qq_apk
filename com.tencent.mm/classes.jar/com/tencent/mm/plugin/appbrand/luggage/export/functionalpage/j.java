package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.sdk.system.AndroidContextUtil;

@SuppressLint({"ViewConstructor"})
public final class j
  extends x
{
  public j(l paraml)
  {
    super(AndroidContextUtil.castActivityOrNull(paraml.mContext), paraml);
    AppMethodBeat.i(47512);
    AppMethodBeat.o(47512);
  }
  
  public final f bOw()
  {
    AppMethodBeat.i(47514);
    f local1 = new f()
    {
      private final h nay;
      
      public final void I(Intent paramAnonymousIntent) {}
      
      public final void a(long paramAnonymousLong, bx paramAnonymousbx) {}
      
      public final void a(ag paramAnonymousag1, ag paramAnonymousag2, bx paramAnonymousbx)
      {
        AppMethodBeat.i(47509);
        this.nay.a(paramAnonymousag1, paramAnonymousag2, paramAnonymousbx);
        AppMethodBeat.o(47509);
      }
      
      public final Intent bOA()
      {
        return null;
      }
      
      public final p bOB()
      {
        AppMethodBeat.i(47508);
        p localp = p.bUW();
        AppMethodBeat.o(47508);
        return localp;
      }
      
      public final com.tencent.mm.plugin.appbrand.report.model.q bOC()
      {
        AppMethodBeat.i(180319);
        com.tencent.mm.plugin.appbrand.report.model.q localq = com.tencent.mm.plugin.appbrand.report.model.q.bUX();
        AppMethodBeat.o(180319);
        return localq;
      }
      
      public final void bOD() {}
      
      public final void bOy() {}
      
      public final h bOz()
      {
        return this.nay;
      }
      
      public final void c(ag paramAnonymousag)
      {
        AppMethodBeat.i(47507);
        d(paramAnonymousag);
        AppMethodBeat.o(47507);
      }
      
      public final void d(ag paramAnonymousag)
      {
        AppMethodBeat.i(47510);
        this.nay.d(paramAnonymousag);
        AppMethodBeat.o(47510);
      }
      
      public final void e(ag paramAnonymousag)
      {
        AppMethodBeat.i(47511);
        this.nay.e(paramAnonymousag);
        AppMethodBeat.o(47511);
      }
      
      public final void resetSession() {}
    };
    AppMethodBeat.o(47514);
    return local1;
  }
  
  public final ag bOx()
  {
    AppMethodBeat.i(175007);
    k localk = new k();
    AppMethodBeat.o(175007);
    return localk;
  }
  
  public final boolean e(t paramt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j
 * JD-Core Version:    0.7.0.1
 */