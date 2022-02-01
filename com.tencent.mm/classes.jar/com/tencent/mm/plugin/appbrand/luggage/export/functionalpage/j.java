package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.system.AndroidContextUtil;

@SuppressLint({"ViewConstructor"})
public final class j
  extends y
{
  public j(l paraml)
  {
    super(AndroidContextUtil.castActivityOrNull(paraml.mContext), paraml);
    AppMethodBeat.i(47512);
    AppMethodBeat.o(47512);
  }
  
  public final f caN()
  {
    AppMethodBeat.i(47514);
    f local1 = new f()
    {
      private final h qaN;
      
      public final void J(Intent paramAnonymousIntent) {}
      
      public final void a(long paramAnonymousLong, ca paramAnonymousca) {}
      
      public final void a(ah paramAnonymousah1, ah paramAnonymousah2, ca paramAnonymousca)
      {
        AppMethodBeat.i(47509);
        this.qaN.a(paramAnonymousah1, paramAnonymousah2, paramAnonymousca);
        AppMethodBeat.o(47509);
      }
      
      public final void caP() {}
      
      public final h caQ()
      {
        return this.qaN;
      }
      
      public final Intent caR()
      {
        return null;
      }
      
      public final p caS()
      {
        AppMethodBeat.i(47508);
        p localp = p.cih();
        AppMethodBeat.o(47508);
        return localp;
      }
      
      public final q caT()
      {
        AppMethodBeat.i(180319);
        q localq = q.cii();
        AppMethodBeat.o(180319);
        return localq;
      }
      
      public final void caU() {}
      
      public final void d(ah paramAnonymousah)
      {
        AppMethodBeat.i(47507);
        e(paramAnonymousah);
        AppMethodBeat.o(47507);
      }
      
      public final void e(ah paramAnonymousah)
      {
        AppMethodBeat.i(47510);
        this.qaN.e(paramAnonymousah);
        AppMethodBeat.o(47510);
      }
      
      public final void f(ah paramAnonymousah)
      {
        AppMethodBeat.i(47511);
        this.qaN.f(paramAnonymousah);
        AppMethodBeat.o(47511);
      }
      
      public final void resetSession() {}
    };
    AppMethodBeat.o(47514);
    return local1;
  }
  
  public final ah caO()
  {
    AppMethodBeat.i(175007);
    k localk = new k();
    AppMethodBeat.o(175007);
    return localk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j
 * JD-Core Version:    0.7.0.1
 */