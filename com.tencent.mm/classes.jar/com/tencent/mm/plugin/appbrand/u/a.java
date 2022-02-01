package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.plugin.appbrand.u.b.a.a;
import com.tencent.mm.plugin.appbrand.u.c.e.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.u.b.a
{
  private static Set<String> njR;
  
  static
  {
    AppMethodBeat.i(47768);
    com.tencent.mm.plugin.appbrand.u.c.e.nkj = new e.a()
    {
      public final void kvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(47764);
        h.CyF.kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(47764);
      }
    };
    com.tencent.mm.plugin.appbrand.u.c.d.nki = new a.2();
    com.tencent.mm.plugin.appbrand.u.b.b.a(new a.a()
    {
      public final void a(AppBrandRuntime paramAnonymousAppBrandRuntime, JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(47766);
        super.a(paramAnonymousAppBrandRuntime, paramAnonymousJSONObject);
        try
        {
          paramAnonymousJSONObject.put("notSupport", a.njR.contains(MD5Util.getMD5String(paramAnonymousAppBrandRuntime.mAppId)));
          paramAnonymousJSONObject.put("switchWebsocket", ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYb, 0));
          paramAnonymousJSONObject.put("jsApiPermissionDebugOn", ac.jOx.equals("1"));
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
    njR = localHashSet;
    localHashSet.add(MD5Util.getMD5String("wxa51f55ab3b2655b9"));
    njR.add(MD5Util.getMD5String("wx5b5555f4b7c7824b"));
    njR.add(MD5Util.getMD5String("wx8c67c6eee918d4ea"));
    njR.add(MD5Util.getMD5String("wx577c74fb940daaea"));
    njR.add(MD5Util.getMD5String("wx7d9e9cbea92ce71f"));
    njR.add(MD5Util.getMD5String("wx850d691fd02de8a1"));
    AppMethodBeat.o(47768);
  }
  
  public final void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(227223);
    super.a(paramStringBuffer);
    AppMethodBeat.o(227223);
  }
  
  public final String bPR()
  {
    AppMethodBeat.i(47767);
    if (((Boolean)j.YI("debugNode").aLT()).booleanValue()) {
      try
      {
        Log.i("MicroMsg.AppBrandNodeJSInstallHelperWC", "hy: inject local node script!");
        String str1 = s.boY(com.tencent.mm.loader.j.b.aKJ() + "nodjs_debug/node_jsapi.js");
        AppMethodBeat.o(47767);
        return str1;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNodeJSInstallHelperWC", localIOException, "hy: can not find node script in sdcard!!", new Object[0]);
        AppMethodBeat.o(47767);
        return "";
      }
    }
    String str2 = super.bPR();
    AppMethodBeat.o(47767);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a
 * JD-Core Version:    0.7.0.1
 */