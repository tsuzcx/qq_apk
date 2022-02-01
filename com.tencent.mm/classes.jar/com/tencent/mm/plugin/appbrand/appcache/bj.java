package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.q.c;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.d;
import com.tencent.mm.plugin.appbrand.debugger.k;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.fay;
import com.tencent.mm.protocal.protobuf.fni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class bj
  implements ck.a
{
  public static final Map<String, bj.c> nHv;
  
  static
  {
    AppMethodBeat.i(44366);
    HashMap localHashMap = new HashMap();
    localHashMap.put("AppBrandNotify", new b((byte)0));
    localHashMap.put("AppPublicLibraryNotify", new d((byte)0));
    localHashMap.put("mmbizwxaconfig", new a((byte)0));
    localHashMap.put("ForceOpenAppNotify", new com.tencent.mm.plugin.appbrand.debugger.e());
    localHashMap.put("AppBrandForceKill", new d());
    if (DebuggerShell.bLS()) {
      localHashMap.put("AppBrandTestUpdateWxaUsageListNotify", new k());
    }
    nHv = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(44366);
  }
  
  public final void a(final h.a parama)
  {
    AppMethodBeat.i(44364);
    parama = com.tencent.mm.platformtools.z.a(parama.jQG.RIF);
    if (Util.isNullOrNil(parama))
    {
      Log.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
      AppMethodBeat.o(44364);
      return;
    }
    h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44357);
        bj.gF(parama);
        AppMethodBeat.o(44357);
      }
    }, "MicroMsg.AppBrand.WxaPkgPushingXmlHandler");
    AppMethodBeat.o(44364);
  }
  
  public final void a(h.c paramc) {}
  
  static final class a
    implements bj.c
  {
    public final void k(final String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(270491);
      if (paramMap.get(".sysmsg.mmbizwxaconfig") == null)
      {
        AppMethodBeat.o(270491);
        return;
      }
      int i = Util.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.command"), -1);
      final int j = Util.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.type"), 0);
      paramString = (String)paramMap.get(".sysmsg.mmbizwxaconfig.appid");
      int k = Util.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.configversion"), 0);
      Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, Integer.valueOf(k) });
      paramMap = new LinkedList();
      fay localfay = new fay();
      localfay.version = k;
      localfay.type = j;
      paramMap.add(localfay);
      q.a(paramString, paramMap, false);
      q.a(paramString, j, i, new q.c()
      {
        public final void acY(String paramAnonymousString)
        {
          AppMethodBeat.i(44358);
          Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.ipc.e.x(paramString, j, paramAnonymousString);
          AppMethodBeat.o(44358);
        }
      }, true);
      AppMethodBeat.o(270491);
    }
  }
  
  static final class b
    implements bj.c
  {
    private static final String nHz;
    
    static
    {
      AppMethodBeat.i(274593);
      nHz = "<sysmsg type=\"AppBrandNotify\">\n\t<AppBrandNotify> \t\n\t\t<DebugInfoList> \t\t\n\t\t\t<DebugInfo> \t\t\t\n\t\t\t\t<AppID>wx221a6c79f8176f0a</AppID>\n\t\t\t\t<UserName>gh_495fc098f3aa</UserName>\n\t\t\t\t<Type>1</Type>\n\t\t\t\t<URL>https://" + WeChatHosts.domainString(au.i.host_open_weixin_qq_com) + "/weapp-test/debug/E_MGI-1c7F4DvKwqnDNT7VCFLgeSJ6w6GfrdgXutHfo</URL>\n\t\t\t\t<StartTime>1470322794</StartTime>\n\t\t\t\t<EndTime>1470329994</EndTime>\n\t\t\t</DebugInfo>\n\t\t</DebugInfoList>\n\t</AppBrandNotify>\n</sysmsg>";
      AppMethodBeat.o(274593);
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
      boolean bool = m.bFP().a(str1, i, str3, paramString, l1, l2);
      Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[] { str1, str2, Integer.valueOf(i), str3, Long.valueOf(l1), Long.valueOf(l2), paramString, Boolean.valueOf(bool) });
      if (bool)
      {
        if (999 == i) {
          break label398;
        }
        aa.afp(str2);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(44360);
            com.tencent.mm.plugin.appbrand.task.i.cjb().u(str1, i);
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(au.i.app_brand_pkg_updated_should_reboot, new Object[] { Util.nullAs(this.nHB, str1) }), 1).show();
            AppMethodBeat.o(44360);
          }
        });
      }
      for (;;)
      {
        m.bFN().bH(str2, i);
        AppMethodBeat.o(44362);
        return true;
        label398:
        z.nFo.hm(false);
      }
    }
    
    public final void k(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(274591);
      l(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", paramMap);
      int i = 0;
      int j;
      do
      {
        j = i + 1;
        i = j;
      } while (l(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo".concat(String.valueOf(j)), paramMap));
      AppMethodBeat.o(274591);
    }
  }
  
  static final class d
    implements bj.c
  {
    public final void k(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(264404);
      if (paramMap.get(".sysmsg.AppPublicLibraryNotify") == null)
      {
        AppMethodBeat.o(264404);
        return;
      }
      int i = Util.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
      paramString = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.MD5");
      String str = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.URL");
      int j = Util.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
      if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramString)) || (i <= 0))
      {
        Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[] { str, paramString, Integer.valueOf(i) });
        AppMethodBeat.o(264404);
        return;
      }
      Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[] { Integer.valueOf(i), paramString, str, Integer.valueOf(j) });
      paramMap = new fni();
      paramMap.version = i;
      paramMap.md5 = paramString;
      paramMap.url = str;
      paramMap.TWD = j;
      aw.a(paramMap);
      AppMethodBeat.o(264404);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bj
 * JD-Core Version:    0.7.0.1
 */