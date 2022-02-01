package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/handoff/HandOffUtils;", "", "()V", "obtainHandOffModel", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "handOffType", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a rui;
  
  static
  {
    AppMethodBeat.i(175133);
    rui = new a();
    AppMethodBeat.o(175133);
  }
  
  public static final HandOffMP J(w paramw)
  {
    AppMethodBeat.i(175132);
    s.u(paramw, "<this>");
    s.u(paramw, "<this>");
    paramw = paramw.getInitConfig();
    String str1 = Util.nullAsNil(paramw.iconUrl);
    String str2 = Util.nullAsNil(paramw.hEy);
    String str3 = Util.nullAsNil(paramw.appId);
    String str4 = Util.nullAsNil(paramw.username);
    String str5 = Util.nullAsNil(paramw.qAF);
    if (paramw.aqJ())
    {
      s.s(str1, "icon");
      s.s(str2, "title");
      s.s(str3, "appId");
      s.s(str5, "entryPage");
      s.s(str4, "appUserName");
      paramw = (HandOffMP)new HandOffMG(str1, str2, str3, str5, str4, 1, null, null, null, 448, null);
      AppMethodBeat.o(175132);
      return paramw;
    }
    s.s(str1, "icon");
    s.s(str2, "title");
    s.s(str3, "appId");
    s.s(str5, "entryPage");
    s.s(str4, "appUserName");
    paramw = new HandOffMP(str1, str2, str3, str5, str4, 1, null, null, null, 448, null);
    AppMethodBeat.o(175132);
    return paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.a
 * JD-Core Version:    0.7.0.1
 */