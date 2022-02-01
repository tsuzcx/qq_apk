package com.tencent.mm.plugin.appbrand.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.game.a.k;
import com.tencent.mm.plugin.appbrand.v.b.a.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.v.b.a
{
  private static Set<String> tqn;
  
  static
  {
    AppMethodBeat.i(47768);
    com.tencent.mm.plugin.appbrand.v.c.h.tqF = new a.1();
    com.tencent.mm.plugin.appbrand.v.c.g.tqE = new a.2();
    com.tencent.mm.plugin.appbrand.v.b.b.a(new a.a()
    {
      public final void a(AppBrandRuntime paramAnonymousAppBrandRuntime, JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(47766);
        super.a(paramAnonymousAppBrandRuntime, paramAnonymousJSONObject);
        try
        {
          paramAnonymousJSONObject.put("notSupport", a.tqn.contains(MD5Util.getMD5String(paramAnonymousAppBrandRuntime.mAppId)));
          paramAnonymousJSONObject.put("switchWebsocket", ((c)h.ax(c.class)).a(c.a.yUo, 0));
          String str2 = z.pCh;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          paramAnonymousJSONObject.put("jsApiPermissionDebugOn", str1.equals("1"));
          if (paramAnonymousAppBrandRuntime.getFileSystem().cim() != null) {}
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
    tqn = localHashSet;
    localHashSet.add(MD5Util.getMD5String("wxa51f55ab3b2655b9"));
    tqn.add(MD5Util.getMD5String("wx5b5555f4b7c7824b"));
    tqn.add(MD5Util.getMD5String("wx8c67c6eee918d4ea"));
    tqn.add(MD5Util.getMD5String("wx577c74fb940daaea"));
    tqn.add(MD5Util.getMD5String("wx7d9e9cbea92ce71f"));
    tqn.add(MD5Util.getMD5String("wx850d691fd02de8a1"));
    AppMethodBeat.o(47768);
  }
  
  public final void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(321224);
    super.a(paramStringBuffer);
    paramStringBuffer = paramStringBuffer.append(";const _clicfg_android_appbrand_permission_bytes_jsapi_nodejs_impl = ");
    c localc = (c)h.ax(c.class);
    c.a locala = c.a.yPh;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      paramStringBuffer.append(localc.a(locala, bool)).append(";");
      AppMethodBeat.o(321224);
      return;
    }
  }
  
  public final String cCV()
  {
    AppMethodBeat.i(47767);
    if (((Boolean)k.Zr("debugNode").boF()).booleanValue()) {
      try
      {
        Log.i("MicroMsg.AppBrandNodeJSInstallHelperWC", "hy: inject local node script!");
        String str1 = y.bEn(com.tencent.mm.loader.i.b.bmz() + "nodjs_debug/node_jsapi.js");
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
    String str2 = super.cCV();
    AppMethodBeat.o(47767);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a
 * JD-Core Version:    0.7.0.1
 */