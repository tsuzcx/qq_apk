package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiArgsCheckUtil;", "", "()V", "TAG", "", "isValidCgiArgs", "", "appId", "userName", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a qkU;
  
  static
  {
    AppMethodBeat.i(272468);
    qkU = new a();
    AppMethodBeat.o(272468);
  }
  
  public static final boolean eO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(272465);
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vQX, 1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(272465);
      return true;
    }
    String str1 = Util.nullAs(paramString1, "");
    if (str1 == null) {
      p.iCn();
    }
    String str2 = Util.nullAs(paramString2, "");
    if (str2 == null) {
      p.iCn();
    }
    if (((paramString1 == null) && (paramString2 == null)) || ((n.ba((CharSequence)str1)) && ((n.ba((CharSequence)str2)) || (!n.pu(str2, "@app")) || (str2.length() < 5)))) {}
    for (boolean bool = false;; bool = true)
    {
      if (!bool)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandCgiArgsCheckUtil", "isValidCgiArgs: invalid cgi args appId [" + paramString1 + "] userName [" + paramString2 + "] stack [" + android.util.Log.getStackTraceString(new Throwable()) + ']');
        com.tencent.mm.plugin.report.service.h.IzE.el(369, 34);
      }
      AppMethodBeat.o(272465);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.a
 * JD-Core Version:    0.7.0.1
 */