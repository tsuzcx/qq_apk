package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiArgsCheckUtil;", "", "()V", "TAG", "", "isValidCgiArgs", "", "appId", "userName", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a tpR;
  
  static
  {
    AppMethodBeat.i(317274);
    tpR = new a();
    AppMethodBeat.o(317274);
  }
  
  public static final boolean ff(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317273);
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zjG, 1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(317273);
      return true;
    }
    String str1 = Util.nullAs(paramString1, "");
    s.checkNotNull(str1);
    String str2 = Util.nullAs(paramString2, "");
    s.checkNotNull(str2);
    if (((paramString1 == null) && (paramString2 == null)) || ((n.bp((CharSequence)str1)) && ((n.bp((CharSequence)str2)) || (!n.rs(str2, "@app")) || (str2.length() < 5)))) {}
    for (boolean bool = false;; bool = true)
    {
      if (!bool)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandCgiArgsCheckUtil", "isValidCgiArgs: invalid cgi args appId [" + paramString1 + "] userName [" + paramString2 + "] stack [" + android.util.Log.getStackTraceString(new Throwable()) + ']');
        com.tencent.mm.plugin.report.service.h.OAn.kJ(369, 34);
      }
      AppMethodBeat.o(317273);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.a
 * JD-Core Version:    0.7.0.1
 */