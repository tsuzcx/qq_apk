package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.ag;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.d;
import com.tencent.mm.plugin.appbrand.debugger.e;
import com.tencent.mm.plugin.appbrand.debugger.k;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.gkb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.threadpool.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class bj
  implements cl.a
{
  public static final Map<String, bj.c> qHi;
  
  static
  {
    AppMethodBeat.i(44366);
    HashMap localHashMap = new HashMap();
    localHashMap.put("AppBrandNotify", new b((byte)0));
    localHashMap.put("AppPublicLibraryNotify", new d((byte)0));
    localHashMap.put("mmbizwxaconfig", new bj.a((byte)0));
    localHashMap.put("ForceOpenAppNotify", new e());
    localHashMap.put("AppBrandForceKill", new d());
    if (DebuggerShell.cls()) {
      localHashMap.put("AppBrandTestUpdateWxaUsageListNotify", new k());
    }
    qHi = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(44366);
  }
  
  public final void a(final g.a parama)
  {
    AppMethodBeat.i(44364);
    parama = com.tencent.mm.platformtools.w.a(parama.mpN.YFG);
    if (Util.isNullOrNil(parama))
    {
      Log.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
      AppMethodBeat.o(44364);
      return;
    }
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44357);
        bj.ig(parama);
        AppMethodBeat.o(44357);
      }
    }, "MicroMsg.AppBrand.WxaPkgPushingXmlHandler");
    AppMethodBeat.o(44364);
  }
  
  public final void a(g.c paramc) {}
  
  static final class b
    implements bj.c
  {
    private static final String qHm;
    
    static
    {
      AppMethodBeat.i(320244);
      qHm = "<sysmsg type=\"AppBrandNotify\">\n\t<AppBrandNotify> \t\n\t\t<DebugInfoList> \t\t\n\t\t\t<DebugInfo> \t\t\t\n\t\t\t\t<AppID>wx221a6c79f8176f0a</AppID>\n\t\t\t\t<UserName>gh_495fc098f3aa</UserName>\n\t\t\t\t<Type>1</Type>\n\t\t\t\t<URL>https://" + WeChatHosts.domainString(ba.i.host_open_weixin_qq_com) + "/weapp-test/debug/E_MGI-1c7F4DvKwqnDNT7VCFLgeSJ6w6GfrdgXutHfo</URL>\n\t\t\t\t<StartTime>1470322794</StartTime>\n\t\t\t\t<EndTime>1470329994</EndTime>\n\t\t\t</DebugInfo>\n\t\t</DebugInfoList>\n\t</AppBrandNotify>\n</sysmsg>";
      AppMethodBeat.o(320244);
    }
    
    private boolean l(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(44362);
      Log.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", new Object[] { paramString });
      if (paramMap.get(paramString) == null)
      {
        AppMethodBeat.o(44362);
        return false;
      }
      final String str1 = (String)paramMap.get(paramString + ".AppID");
      String str2 = (String)paramMap.get(paramString + ".UserName");
      final int i = Util.getInt((String)paramMap.get(paramString + ".Type"), 1);
      String str3 = (String)paramMap.get(paramString + ".URL");
      long l1 = Util.getLong((String)paramMap.get(paramString + ".StartTime"), Util.nowSecond());
      long l2 = Util.getLong((String)paramMap.get(paramString + ".EndTime"), 7200L + l1);
      paramString = (String)paramMap.get(paramString + ".MD5");
      boolean bool = n.cfm().a(str1, i, str3, paramString, l1, l2);
      Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[] { str1, str2, Integer.valueOf(i), str3, Long.valueOf(l1), Long.valueOf(l2), paramString, Boolean.valueOf(bool) });
      if (bool)
      {
        if (999 == i) {
          break label398;
        }
        ag.XP(str2);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(44360);
            com.tencent.mm.plugin.appbrand.task.i.cJV().F(str1, i);
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(ba.i.app_brand_pkg_updated_should_reboot, new Object[] { Util.nullAs(this.qHo, str1) }), 1).show();
            AppMethodBeat.o(44360);
          }
        });
      }
      for (;;)
      {
        n.cfk().bZ(str2, i);
        AppMethodBeat.o(44362);
        return true;
        label398:
        ab.qFk.id(false);
      }
    }
    
    public final void k(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(320250);
      l(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", paramMap);
      int i = 0;
      int j;
      do
      {
        j = i + 1;
        i = j;
      } while (l(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo".concat(String.valueOf(j)), paramMap));
      AppMethodBeat.o(320250);
    }
  }
  
  static final class d
    implements bj.c
  {
    public final void k(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(320237);
      if (paramMap.get(".sysmsg.AppPublicLibraryNotify") == null)
      {
        AppMethodBeat.o(320237);
        return;
      }
      int i = Util.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
      paramString = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.MD5");
      String str = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.URL");
      int j = Util.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
      if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramString)) || (i <= 0))
      {
        Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[] { str, paramString, Integer.valueOf(i) });
        AppMethodBeat.o(320237);
        return;
      }
      Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[] { Integer.valueOf(i), paramString, str, Integer.valueOf(j) });
      paramMap = new gkb();
      paramMap.version = i;
      paramMap.md5 = paramString;
      paramMap.url = str;
      paramMap.abns = j;
      ax.a(paramMap);
      AppMethodBeat.o(320237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bj
 * JD-Core Version:    0.7.0.1
 */