package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.sdk.f.a;

@SuppressLint({"ViewConstructor"})
public final class h
  extends u
{
  public h(j paramj)
  {
    super(a.iV(paramj.mContext), paramj);
    AppMethodBeat.i(47512);
    AppMethodBeat.o(47512);
  }
  
  public final void Kx(String paramString)
  {
    AppMethodBeat.i(47513);
    super.Kx("__wx__/open-api-redirecting-page");
    AppMethodBeat.o(47513);
  }
  
  public final f bhv()
  {
    AppMethodBeat.i(47514);
    h.1 local1 = new h.1(this);
    AppMethodBeat.o(47514);
    return local1;
  }
  
  public final ae bhw()
  {
    AppMethodBeat.i(175007);
    i locali = new i();
    AppMethodBeat.o(175007);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.h
 * JD-Core Version:    0.7.0.1
 */