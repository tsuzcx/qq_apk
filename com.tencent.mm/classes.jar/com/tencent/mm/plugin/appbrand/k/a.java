package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/handoff/HandOffUtils;", "", "()V", "obtainHandOffModel", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "handOffType", "", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a oqx;
  
  static
  {
    AppMethodBeat.i(175133);
    oqx = new a();
    AppMethodBeat.o(175133);
  }
  
  public static final HandOffMP z(t paramt)
  {
    AppMethodBeat.i(175132);
    p.k(paramt, "$this$obtainHandOffModel");
    paramt = paramt.bDy();
    String str1 = Util.nullAsNil(paramt.iconUrl);
    String str2 = Util.nullAsNil(paramt.fzM);
    String str3 = Util.nullAsNil(paramt.appId);
    String str4 = Util.nullAsNil(paramt.username);
    String str5 = Util.nullAsNil(paramt.nBq);
    p.j(paramt, "config");
    if (paramt.Qv())
    {
      p.j(str1, "icon");
      p.j(str2, "title");
      p.j(str3, "appId");
      p.j(str5, "entryPage");
      p.j(str4, "appUserName");
      paramt = (HandOffMP)new HandOffMG(str1, str2, str3, str5, str4, 1, null, null, null, 448, null);
      AppMethodBeat.o(175132);
      return paramt;
    }
    p.j(str1, "icon");
    p.j(str2, "title");
    p.j(str3, "appId");
    p.j(str5, "entryPage");
    p.j(str4, "appUserName");
    paramt = new HandOffMP(str1, str2, str3, str5, str4, 1, null, null, null, 448, null);
    AppMethodBeat.o(175132);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.a
 * JD-Core Version:    0.7.0.1
 */