package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.q.c.d.a;
import com.tencent.mm.plugin.appbrand.q.c.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.q.b.a
{
  private static Set<String> lyb;
  
  static
  {
    AppMethodBeat.i(47768);
    com.tencent.mm.plugin.appbrand.q.c.e.lyt = new e.a()
    {
      public final void kvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47764);
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(47764);
      }
    };
    com.tencent.mm.plugin.appbrand.q.c.d.lys = new d.a()
    {
      public final void N(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(47765);
        com.tencent.mm.plugin.report.service.h.wUl.n(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
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
          paramAnonymousJSONObject.put("notSupport", a.lyb.contains(ah.dg(paramAnonymousAppBrandRuntime.mAppId)));
          paramAnonymousJSONObject.put("switchWebsocket", ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pTg, 0));
          paramAnonymousJSONObject.put("switchFs", ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pTh, 0));
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
    lyb = localHashSet;
    localHashSet.add(ah.dg("wxa51f55ab3b2655b9"));
    lyb.add(ah.dg("wx5b5555f4b7c7824b"));
    lyb.add(ah.dg("wx8c67c6eee918d4ea"));
    lyb.add(ah.dg("wx577c74fb940daaea"));
    lyb.add(ah.dg("wx7d9e9cbea92ce71f"));
    lyb.add(ah.dg("wx850d691fd02de8a1"));
    AppMethodBeat.o(47768);
  }
  
  public final void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(186884);
    super.a(paramStringBuffer);
    StringBuffer localStringBuffer = paramStringBuffer.append(";const _switchTimer = ");
    if (((Boolean)l.jQE.aqp()).booleanValue()) {}
    for (paramStringBuffer = "true";; paramStringBuffer = "false")
    {
      localStringBuffer.append(paramStringBuffer).append(";");
      AppMethodBeat.o(186884);
      return;
    }
  }
  
  public final String bpy()
  {
    AppMethodBeat.i(47767);
    if (((Boolean)com.tencent.mm.plugin.appbrand.game.a.h.Lv("debugNode").aqp()).booleanValue()) {
      try
      {
        ac.i("MicroMsg.AppBrandNodeJSInstallHelperWC", "hy: inject local node script!");
        String str1 = i.aSr(com.tencent.mm.loader.j.b.aph() + "nodjs_debug/node_jsapi.js");
        AppMethodBeat.o(47767);
        return str1;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandNodeJSInstallHelperWC", localIOException, "hy: can not find node script in sdcard!!", new Object[0]);
        AppMethodBeat.o(47767);
        return "";
      }
    }
    String str2 = super.bpy();
    AppMethodBeat.o(47767);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a
 * JD-Core Version:    0.7.0.1
 */