package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.sdk.f.a;

@SuppressLint({"ViewConstructor"})
public final class j
  extends v
{
  public j(l paraml)
  {
    super(a.jq(paraml.mContext), paraml);
    AppMethodBeat.i(47512);
    AppMethodBeat.o(47512);
  }
  
  public final void Sd(String paramString)
  {
    AppMethodBeat.i(47513);
    super.Sd("__wx__/open-api-redirecting-page");
    AppMethodBeat.o(47513);
  }
  
  public final f bsh()
  {
    AppMethodBeat.i(47514);
    j.1 local1 = new j.1(this);
    AppMethodBeat.o(47514);
    return local1;
  }
  
  public final ae bsi()
  {
    AppMethodBeat.i(175007);
    k localk = new k();
    AppMethodBeat.o(175007);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j
 * JD-Core Version:    0.7.0.1
 */