package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.a.h;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.r.b.a
{
  private static Set<String> kWr;
  
  static
  {
    AppMethodBeat.i(47768);
    com.tencent.mm.plugin.appbrand.r.c.e.kWJ = new a.1();
    com.tencent.mm.plugin.appbrand.r.c.d.kWI = new a.2();
    com.tencent.mm.plugin.appbrand.r.b.b.a(new com.tencent.mm.plugin.appbrand.r.b.b.a()
    {
      public final void a(AppBrandRuntime paramAnonymousAppBrandRuntime, JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(47766);
        try
        {
          paramAnonymousJSONObject.put("notSupport", a.biF().contains(ai.du(paramAnonymousAppBrandRuntime.mAppId)));
          paramAnonymousJSONObject.put("switchWebsocket", ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.ppv, 0));
          paramAnonymousJSONObject.put("switchFs", ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.ppw, 0));
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
    kWr = localHashSet;
    localHashSet.add(ai.du("wxa51f55ab3b2655b9"));
    kWr.add(ai.du("wx5b5555f4b7c7824b"));
    kWr.add(ai.du("wx8c67c6eee918d4ea"));
    kWr.add(ai.du("wx577c74fb940daaea"));
    kWr.add(ai.du("wx7d9e9cbea92ce71f"));
    kWr.add(ai.du("wx850d691fd02de8a1"));
    AppMethodBeat.o(47768);
  }
  
  public final void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(196052);
    super.a(paramStringBuffer);
    StringBuffer localStringBuffer = paramStringBuffer.append(";const _switchTimer = ");
    if (((Boolean)j.jqn.ajp()).booleanValue()) {}
    for (paramStringBuffer = "true";; paramStringBuffer = "false")
    {
      localStringBuffer.append(paramStringBuffer).append(";");
      AppMethodBeat.o(196052);
      return;
    }
  }
  
  public final String biE()
  {
    AppMethodBeat.i(47767);
    if (((Boolean)h.Hr("debugNode").ajp()).booleanValue()) {
      try
      {
        ad.i("MicroMsg.AppBrandNodeJSInstallHelperWC", "hy: inject local node script!");
        String str1 = i.aMP(com.tencent.mm.loader.j.b.aih() + "nodjs_debug/node_jsapi.js");
        AppMethodBeat.o(47767);
        return str1;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandNodeJSInstallHelperWC", localIOException, "hy: can not find node script in sdcard!!", new Object[0]);
        AppMethodBeat.o(47767);
        return "";
      }
    }
    String str2 = super.biE();
    AppMethodBeat.o(47767);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a
 * JD-Core Version:    0.7.0.1
 */