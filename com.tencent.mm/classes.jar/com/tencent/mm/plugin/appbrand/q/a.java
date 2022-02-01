package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.a.i;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.plugin.appbrand.q.c.d.a;
import com.tencent.mm.plugin.appbrand.q.c.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.q.b.a
{
  private static Set<String> mcg;
  
  static
  {
    AppMethodBeat.i(47768);
    com.tencent.mm.plugin.appbrand.q.c.e.mcy = new e.a()
    {
      public final void kvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47764);
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(47764);
      }
    };
    com.tencent.mm.plugin.appbrand.q.c.d.mcx = new d.a()
    {
      public final void P(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(47765);
        com.tencent.mm.plugin.report.service.g.yxI.n(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(47765);
      }
    };
    com.tencent.mm.plugin.appbrand.q.b.b.a(new com.tencent.mm.plugin.appbrand.q.b.b.a()
    {
      public final void a(AppBrandRuntime paramAnonymousAppBrandRuntime, JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(47766);
        try
        {
          paramAnonymousJSONObject.put("notSupport", a.mcg.contains(aj.ej(paramAnonymousAppBrandRuntime.mAppId)));
          paramAnonymousJSONObject.put("switchWebsocket", ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qER, 0));
          paramAnonymousJSONObject.put("switchFs", ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qES, 0));
          AppMethodBeat.o(47766);
          return;
        }
        catch (JSONException paramAnonymousAppBrandRuntime)
        {
          AppMethodBeat.o(47766);
        }
      }
    });
    HashSet localHashSet = new HashSet();
    mcg = localHashSet;
    localHashSet.add(aj.ej("wxa51f55ab3b2655b9"));
    mcg.add(aj.ej("wx5b5555f4b7c7824b"));
    mcg.add(aj.ej("wx8c67c6eee918d4ea"));
    mcg.add(aj.ej("wx577c74fb940daaea"));
    mcg.add(aj.ej("wx7d9e9cbea92ce71f"));
    mcg.add(aj.ej("wx850d691fd02de8a1"));
    AppMethodBeat.o(47768);
  }
  
  public final void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(222849);
    super.a(paramStringBuffer);
    StringBuffer localStringBuffer = paramStringBuffer.append(";const _switchTimer = ");
    if (((Boolean)m.koh.att()).booleanValue()) {}
    for (paramStringBuffer = "true";; paramStringBuffer = "false")
    {
      localStringBuffer.append(paramStringBuffer).append(";");
      AppMethodBeat.o(222849);
      return;
    }
  }
  
  public final String buk()
  {
    AppMethodBeat.i(47767);
    if (((Boolean)i.Px("debugNode").att()).booleanValue()) {
      try
      {
        ae.i("MicroMsg.AppBrandNodeJSInstallHelperWC", "hy: inject local node script!");
        String str1 = o.aZT(com.tencent.mm.loader.j.b.asj() + "nodjs_debug/node_jsapi.js");
        AppMethodBeat.o(47767);
        return str1;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandNodeJSInstallHelperWC", localIOException, "hy: can not find node script in sdcard!!", new Object[0]);
        AppMethodBeat.o(47767);
        return "";
      }
    }
    String str2 = super.buk();
    AppMethodBeat.o(47767);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a
 * JD-Core Version:    0.7.0.1
 */