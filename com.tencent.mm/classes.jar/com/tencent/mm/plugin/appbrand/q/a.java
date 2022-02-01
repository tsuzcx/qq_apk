package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.q.b.a
{
  private static Set<String> lXz;
  
  static
  {
    AppMethodBeat.i(47768);
    com.tencent.mm.plugin.appbrand.q.c.e.lXR = new a.1();
    com.tencent.mm.plugin.appbrand.q.c.d.lXQ = new a.2();
    com.tencent.mm.plugin.appbrand.q.b.b.a(new com.tencent.mm.plugin.appbrand.q.b.b.a()
    {
      public final void a(AppBrandRuntime paramAnonymousAppBrandRuntime, JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(47766);
        try
        {
          paramAnonymousJSONObject.put("notSupport", a.lXz.contains(ai.ee(paramAnonymousAppBrandRuntime.mAppId)));
          paramAnonymousJSONObject.put("switchWebsocket", ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxL, 0));
          paramAnonymousJSONObject.put("switchFs", ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxM, 0));
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
    lXz = localHashSet;
    localHashSet.add(ai.ee("wxa51f55ab3b2655b9"));
    lXz.add(ai.ee("wx5b5555f4b7c7824b"));
    lXz.add(ai.ee("wx8c67c6eee918d4ea"));
    lXz.add(ai.ee("wx577c74fb940daaea"));
    lXz.add(ai.ee("wx7d9e9cbea92ce71f"));
    lXz.add(ai.ee("wx850d691fd02de8a1"));
    AppMethodBeat.o(47768);
  }
  
  public final void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(188679);
    super.a(paramStringBuffer);
    StringBuffer localStringBuffer = paramStringBuffer.append(";const _switchTimer = ");
    if (((Boolean)m.kkR.ate()).booleanValue()) {}
    for (paramStringBuffer = "true";; paramStringBuffer = "false")
    {
      localStringBuffer.append(paramStringBuffer).append(";");
      AppMethodBeat.o(188679);
      return;
    }
  }
  
  public final String btz()
  {
    AppMethodBeat.i(47767);
    if (((Boolean)com.tencent.mm.plugin.appbrand.game.a.i.OP("debugNode").ate()).booleanValue()) {
      try
      {
        ad.i("MicroMsg.AppBrandNodeJSInstallHelperWC", "hy: inject local node script!");
        String str1 = com.tencent.mm.vfs.i.aYq(com.tencent.mm.loader.j.b.arU() + "nodjs_debug/node_jsapi.js");
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
    String str2 = super.btz();
    AppMethodBeat.o(47767);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a
 * JD-Core Version:    0.7.0.1
 */