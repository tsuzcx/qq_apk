package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.plugin.appbrand.u.b.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.u.b.a
{
  private static Set<String> qlp;
  
  static
  {
    AppMethodBeat.i(47768);
    com.tencent.mm.plugin.appbrand.u.c.h.qlH = new a.1();
    com.tencent.mm.plugin.appbrand.u.c.g.qlG = new a.2();
    com.tencent.mm.plugin.appbrand.u.b.b.a(new a.a()
    {
      public final void a(AppBrandRuntime paramAnonymousAppBrandRuntime, JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(47766);
        super.a(paramAnonymousAppBrandRuntime, paramAnonymousJSONObject);
        try
        {
          paramAnonymousJSONObject.put("notSupport", a.qlp.contains(MD5Util.getMD5String(paramAnonymousAppBrandRuntime.mAppId)));
          paramAnonymousJSONObject.put("switchWebsocket", ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vER, 0));
          paramAnonymousJSONObject.put("jsApiPermissionDebugOn", ac.mFH.equals("1"));
          if (paramAnonymousAppBrandRuntime.getFileSystem().bIH() != null) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousJSONObject.put("enableSpaceStatics", bool);
            AppMethodBeat.o(47766);
            return;
          }
          return;
        }
        catch (JSONException paramAnonymousAppBrandRuntime)
        {
          AppMethodBeat.o(47766);
        }
      }
    });
    HashSet localHashSet = new HashSet();
    qlp = localHashSet;
    localHashSet.add(MD5Util.getMD5String("wxa51f55ab3b2655b9"));
    qlp.add(MD5Util.getMD5String("wx5b5555f4b7c7824b"));
    qlp.add(MD5Util.getMD5String("wx8c67c6eee918d4ea"));
    qlp.add(MD5Util.getMD5String("wx577c74fb940daaea"));
    qlp.add(MD5Util.getMD5String("wx7d9e9cbea92ce71f"));
    qlp.add(MD5Util.getMD5String("wx850d691fd02de8a1"));
    AppMethodBeat.o(47768);
  }
  
  public final void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(278778);
    super.a(paramStringBuffer);
    AppMethodBeat.o(278778);
  }
  
  public final String ccz()
  {
    AppMethodBeat.i(47767);
    if (((Boolean)j.agw("debugNode").aUb()).booleanValue()) {
      try
      {
        Log.i("MicroMsg.AppBrandNodeJSInstallHelperWC", "hy: inject local node script!");
        String str1 = u.bBS(com.tencent.mm.loader.j.b.aSL() + "nodjs_debug/node_jsapi.js");
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
    String str2 = super.ccz();
    AppMethodBeat.o(47767);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a
 * JD-Core Version:    0.7.0.1
 */