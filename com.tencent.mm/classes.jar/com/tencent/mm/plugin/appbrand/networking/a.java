package com.tencent.mm.plugin.appbrand.networking;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiArgsCheckUtil;", "", "()V", "TAG", "", "isValidCgiArgs", "", "appId", "userName", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a mbL;
  
  static
  {
    AppMethodBeat.i(223811);
    mbL = new a();
    AppMethodBeat.o(223811);
  }
  
  public static final boolean ej(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223810);
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qLa, 1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(223810);
      return true;
    }
    String str1 = bu.bI(paramString1, "");
    if (str1 == null) {
      p.gkB();
    }
    String str2 = bu.bI(paramString2, "");
    if (str2 == null) {
      p.gkB();
    }
    if (((paramString1 == null) && (paramString2 == null)) || ((n.aD((CharSequence)str1)) && ((n.aD((CharSequence)str2)) || (!n.nG(str2, "@app")) || (str2.length() < 5)))) {}
    for (boolean bool = false;; bool = true)
    {
      if (!bool)
      {
        ae.e("MicroMsg.AppBrandCgiArgsCheckUtil", "isValidCgiArgs: invalid cgi args appId [" + paramString1 + "] userName [" + paramString2 + "] stack [" + Log.getStackTraceString(new Throwable()) + ']');
        com.tencent.mm.plugin.report.service.g.yxI.dD(369, 34);
      }
      AppMethodBeat.o(223810);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.a
 * JD-Core Version:    0.7.0.1
 */