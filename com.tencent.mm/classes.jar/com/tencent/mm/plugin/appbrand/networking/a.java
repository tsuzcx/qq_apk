package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiArgsCheckUtil;", "", "()V", "TAG", "", "isValidCgiArgs", "", "appId", "userName", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a njw;
  
  static
  {
    AppMethodBeat.i(229061);
    njw = new a();
    AppMethodBeat.o(229061);
  }
  
  public static final boolean eA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229060);
    if (((b)g.af(b.class)).a(b.a.sgZ, 1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(229060);
      return true;
    }
    String str1 = Util.nullAs(paramString1, "");
    if (str1 == null) {
      p.hyc();
    }
    String str2 = Util.nullAs(paramString2, "");
    if (str2 == null) {
      p.hyc();
    }
    if (((paramString1 == null) && (paramString2 == null)) || ((n.aL((CharSequence)str1)) && ((n.aL((CharSequence)str2)) || (!n.K(str2, "@app", false)) || (str2.length() < 5)))) {}
    for (boolean bool = false;; bool = true)
    {
      if (!bool)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandCgiArgsCheckUtil", "isValidCgiArgs: invalid cgi args appId [" + paramString1 + "] userName [" + paramString2 + "] stack [" + android.util.Log.getStackTraceString(new Throwable()) + ']');
        h.CyF.dN(369, 34);
      }
      AppMethodBeat.o(229060);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.a
 * JD-Core Version:    0.7.0.1
 */