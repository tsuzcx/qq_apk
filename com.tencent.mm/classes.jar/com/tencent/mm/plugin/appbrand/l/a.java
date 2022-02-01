package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/handoff/HandOffUtils;", "", "()V", "obtainHandOffModel", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "handOffType", "", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a jtT;
  
  static
  {
    AppMethodBeat.i(175133);
    jtT = new a();
    AppMethodBeat.o(175133);
  }
  
  public static final HandOffMP C(o paramo)
  {
    AppMethodBeat.i(175132);
    k.h(paramo, "$this$obtainHandOffModel");
    paramo = paramo.aNc();
    String str1 = bt.nullAsNil(paramo.iconUrl);
    String str2 = bt.nullAsNil(paramo.dfM);
    String str3 = bt.nullAsNil(paramo.appId);
    String str4 = bt.nullAsNil(paramo.username);
    String str5 = bt.nullAsNil(paramo.iJb);
    k.g(paramo, "config");
    if (paramo.CZ())
    {
      k.g(str1, "icon");
      k.g(str2, "title");
      k.g(str3, "appId");
      k.g(str5, "entryPage");
      k.g(str4, "appUserName");
      paramo = (HandOffMP)new HandOffMG(str1, str2, str3, str5, str4);
      AppMethodBeat.o(175132);
      return paramo;
    }
    k.g(str1, "icon");
    k.g(str2, "title");
    k.g(str3, "appId");
    k.g(str5, "entryPage");
    k.g(str4, "appUserName");
    paramo = new HandOffMP(str1, str2, str3, str5, str4, 1);
    AppMethodBeat.o(175132);
    return paramo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.a
 * JD-Core Version:    0.7.0.1
 */