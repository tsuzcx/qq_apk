package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/handoff/HandOffUtils;", "", "()V", "obtainHandOffModel", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "handOffType", "", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a lvB;
  
  static
  {
    AppMethodBeat.i(175133);
    lvB = new a();
    AppMethodBeat.o(175133);
  }
  
  public static final HandOffMP y(q paramq)
  {
    AppMethodBeat.i(175132);
    p.h(paramq, "$this$obtainHandOffModel");
    paramq = paramq.bsC();
    String str1 = Util.nullAsNil(paramq.iconUrl);
    String str2 = Util.nullAsNil(paramq.brandName);
    String str3 = Util.nullAsNil(paramq.appId);
    String str4 = Util.nullAsNil(paramq.username);
    String str5 = Util.nullAsNil(paramq.kHw);
    p.g(paramq, "config");
    if (paramq.NA())
    {
      p.g(str1, "icon");
      p.g(str2, "title");
      p.g(str3, "appId");
      p.g(str5, "entryPage");
      p.g(str4, "appUserName");
      paramq = (HandOffMP)new HandOffMG(str1, str2, str3, str5, str4, 1, null, null, null, 448, null);
      AppMethodBeat.o(175132);
      return paramq;
    }
    p.g(str1, "icon");
    p.g(str2, "title");
    p.g(str3, "appId");
    p.g(str5, "entryPage");
    p.g(str4, "appUserName");
    paramq = new HandOffMP(str1, str2, str3, str5, str4, 1, null, null, null, 448, null);
    AppMethodBeat.o(175132);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.a
 * JD-Core Version:    0.7.0.1
 */