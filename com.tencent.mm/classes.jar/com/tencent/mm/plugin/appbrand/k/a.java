package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/handoff/HandOffUtils;", "", "()V", "obtainHandOffModel", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "handOffType", "", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a krS;
  
  static
  {
    AppMethodBeat.i(175133);
    krS = new a();
    AppMethodBeat.o(175133);
  }
  
  public static final HandOffMP u(com.tencent.mm.plugin.appbrand.p paramp)
  {
    AppMethodBeat.i(175132);
    d.g.b.p.h(paramp, "$this$obtainHandOffModel");
    paramp = paramp.aXx();
    String str1 = bu.nullAsNil(paramp.iconUrl);
    String str2 = bu.nullAsNil(paramp.dpI);
    String str3 = bu.nullAsNil(paramp.appId);
    String str4 = bu.nullAsNil(paramp.username);
    String str5 = bu.nullAsNil(paramp.jFL);
    d.g.b.p.g(paramp, "config");
    if (paramp.Ee())
    {
      d.g.b.p.g(str1, "icon");
      d.g.b.p.g(str2, "title");
      d.g.b.p.g(str3, "appId");
      d.g.b.p.g(str5, "entryPage");
      d.g.b.p.g(str4, "appUserName");
      paramp = (HandOffMP)new HandOffMG(str1, str2, str3, str5, str4);
      AppMethodBeat.o(175132);
      return paramp;
    }
    d.g.b.p.g(str1, "icon");
    d.g.b.p.g(str2, "title");
    d.g.b.p.g(str3, "appId");
    d.g.b.p.g(str5, "entryPage");
    d.g.b.p.g(str4, "appUserName");
    paramp = new HandOffMP(str1, str2, str3, str5, str4, 1);
    AppMethodBeat.o(175132);
    return paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.a
 * JD-Core Version:    0.7.0.1
 */