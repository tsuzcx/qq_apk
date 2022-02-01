package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.p.c;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.d;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class bd
  implements cd.a
{
  public static final Map<String, c> jIv;
  
  static
  {
    AppMethodBeat.i(44366);
    HashMap localHashMap = new HashMap();
    localHashMap.put("AppBrandNotify", new b((byte)0));
    localHashMap.put("AppPublicLibraryNotify", new d((byte)0));
    localHashMap.put("mmbizwxaconfig", new a((byte)0));
    localHashMap.put("ForceOpenAppNotify", new com.tencent.mm.plugin.appbrand.debugger.e());
    localHashMap.put("AppBrandForceKill", new d());
    if (DebuggerShell.bew()) {
      localHashMap.put("AppBrandTestUpdateWxaUsageListNotify", new com.tencent.mm.plugin.appbrand.debugger.i());
    }
    jIv = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(44366);
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(44364);
    parama = z.a(parama.gqE.Fvk);
    if (bt.isNullOrNil(parama))
    {
      ad.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
      AppMethodBeat.o(44364);
      return;
    }
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44357);
        bd.fd(parama);
        AppMethodBeat.o(44357);
      }
    }, "MicroMsg.AppBrand.WxaPkgPushingXmlHandler");
    AppMethodBeat.o(44364);
  }
  
  public final void a(e.c paramc) {}
  
  static final class a
    implements bd.c
  {
    public final void k(final String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(188013);
      if (paramMap.get(".sysmsg.mmbizwxaconfig") == null)
      {
        AppMethodBeat.o(188013);
        return;
      }
      int i = bt.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.command"), -1);
      final int j = bt.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.type"), 0);
      paramString = (String)paramMap.get(".sysmsg.mmbizwxaconfig.appid");
      int k = bt.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.configversion"), 0);
      ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, Integer.valueOf(k) });
      paramMap = new LinkedList();
      dvk localdvk = new dvk();
      localdvk.version = k;
      localdvk.type = j;
      paramMap.add(localdvk);
      p.a(paramString, paramMap, false);
      p.a(paramString, j, i, new p.c()
      {
        public final void LC(String paramAnonymousString)
        {
          AppMethodBeat.i(44358);
          ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.ipc.e.p(paramString, j, paramAnonymousString);
          AppMethodBeat.o(44358);
        }
      }, true);
      AppMethodBeat.o(188013);
    }
  }
  
  static final class b
    implements bd.c
  {
    private boolean l(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(44362);
      ad.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", new Object[] { paramString });
      if (paramMap.get(paramString) == null)
      {
        AppMethodBeat.o(44362);
        return false;
      }
      final String str1 = (String)paramMap.get(paramString + ".AppID");
      String str2 = (String)paramMap.get(paramString + ".UserName");
      final int i = bt.getInt((String)paramMap.get(paramString + ".Type"), 1);
      String str3 = (String)paramMap.get(paramString + ".URL");
      long l1 = bt.getLong((String)paramMap.get(paramString + ".StartTime"), bt.aQJ());
      long l2 = bt.getLong((String)paramMap.get(paramString + ".EndTime"), 7200L + l1);
      paramString = (String)paramMap.get(paramString + ".MD5");
      boolean bool = j.aYX().a(str1, i, str3, paramString, l1, l2);
      ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[] { str1, str2, Integer.valueOf(i), str3, Long.valueOf(l1), Long.valueOf(l2), paramString, Boolean.valueOf(bool) });
      if (bool)
      {
        if (999 == i) {
          break label398;
        }
        com.tencent.mm.plugin.appbrand.config.x.NL(str2);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(44360);
            f.bY(str1, i);
            Toast.makeText(aj.getContext(), aj.getContext().getString(2131755575, new Object[] { bt.bI(this.jIA, str1) }), 1).show();
            AppMethodBeat.o(44360);
          }
        });
      }
      for (;;)
      {
        j.aYV().bg(str2, i);
        AppMethodBeat.o(44362);
        return true;
        label398:
        x.jGy.fH(false);
      }
    }
    
    public final void k(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(188014);
      l(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", paramMap);
      int i = 0;
      int j;
      do
      {
        j = i + 1;
        i = j;
      } while (l(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo".concat(String.valueOf(j)), paramMap));
      AppMethodBeat.o(188014);
    }
  }
  
  public static abstract interface c
  {
    public abstract void k(String paramString, Map<String, String> paramMap);
  }
  
  static final class d
    implements bd.c
  {
    public final void k(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(188015);
      if (paramMap.get(".sysmsg.AppPublicLibraryNotify") == null)
      {
        AppMethodBeat.o(188015);
        return;
      }
      int i = bt.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
      paramString = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.MD5");
      String str = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.URL");
      int j = bt.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
      if ((bt.isNullOrNil(str)) || (bt.isNullOrNil(paramString)) || (i <= 0))
      {
        ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[] { str, paramString, Integer.valueOf(i) });
        AppMethodBeat.o(188015);
        return;
      }
      ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[] { Integer.valueOf(i), paramString, str, Integer.valueOf(j) });
      paramMap = new efy();
      paramMap.version = i;
      paramMap.md5 = paramString;
      paramMap.url = str;
      paramMap.HgA = j;
      at.a(paramMap);
      AppMethodBeat.o(188015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bd
 * JD-Core Version:    0.7.0.1
 */