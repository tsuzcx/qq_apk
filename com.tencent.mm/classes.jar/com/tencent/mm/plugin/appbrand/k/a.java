package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/handoff/HandOffUtils;", "", "()V", "obtainHandOffModel", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "handOffType", "", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a koC;
  
  static
  {
    AppMethodBeat.i(175133);
    koC = new a();
    AppMethodBeat.o(175133);
  }
  
  public static final HandOffMP t(o paramo)
  {
    AppMethodBeat.i(175132);
    p.h(paramo, "$this$obtainHandOffModel");
    paramo = paramo.aXc();
    String str1 = bt.nullAsNil(paramo.iconUrl);
    String str2 = bt.nullAsNil(paramo.doD);
    String str3 = bt.nullAsNil(paramo.appId);
    String str4 = bt.nullAsNil(paramo.username);
    String str5 = bt.nullAsNil(paramo.jCN);
    p.g(paramo, "config");
    if (paramo.Eb())
    {
      p.g(str1, "icon");
      p.g(str2, "title");
      p.g(str3, "appId");
      p.g(str5, "entryPage");
      p.g(str4, "appUserName");
      paramo = (HandOffMP)new HandOffMG(str1, str2, str3, str5, str4);
      AppMethodBeat.o(175132);
      return paramo;
    }
    p.g(str1, "icon");
    p.g(str2, "title");
    p.g(str3, "appId");
    p.g(str5, "entryPage");
    p.g(str4, "appUserName");
    paramo = new HandOffMP(str1, str2, str3, str5, str4, 1);
    AppMethodBeat.o(175132);
    return paramo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.a
 * JD-Core Version:    0.7.0.1
 */