package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.p.c;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.c;
import com.tencent.mm.plugin.appbrand.debugger.d;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class bc
  implements cc.a
{
  public static final Map<String, c> iOq;
  
  static
  {
    AppMethodBeat.i(44366);
    HashMap localHashMap = new HashMap();
    localHashMap.put("AppBrandNotify", new b((byte)0));
    localHashMap.put("AppPublicLibraryNotify", new bc.d((byte)0));
    localHashMap.put("mmbizwxaconfig", new a((byte)0));
    localHashMap.put("ForceOpenAppNotify", new d());
    localHashMap.put("AppBrandForceKill", new c());
    if (DebuggerShell.aTY()) {
      localHashMap.put("AppBrandTestUpdateWxaUsageListNotify", new com.tencent.mm.plugin.appbrand.debugger.h());
    }
    iOq = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(44366);
  }
  
  public final void a(final f.a parama)
  {
    AppMethodBeat.i(44364);
    parama = z.a(parama.fTo.Cxz);
    if (bt.isNullOrNil(parama))
    {
      ad.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
      AppMethodBeat.o(44364);
      return;
    }
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44357);
        bc.et(parama);
        AppMethodBeat.o(44357);
      }
    }, "MicroMsg.AppBrand.WxaPkgPushingXmlHandler");
    AppMethodBeat.o(44364);
  }
  
  public final void a(f.c paramc) {}
  
  static final class a
    implements bc.c
  {
    public final void i(final String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(195620);
      if (paramMap.get(".sysmsg.mmbizwxaconfig") == null)
      {
        AppMethodBeat.o(195620);
        return;
      }
      int i = bt.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.command"), -1);
      final int j = bt.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.type"), 0);
      paramString = (String)paramMap.get(".sysmsg.mmbizwxaconfig.appid");
      int k = bt.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.configversion"), 0);
      ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, Integer.valueOf(k) });
      paramMap = new LinkedList();
      dke localdke = new dke();
      localdke.version = k;
      localdke.type = j;
      paramMap.add(localdke);
      p.a(paramString, paramMap, false);
      p.a(paramString, j, i, new p.c()
      {
        public final void Eh(String paramAnonymousString)
        {
          AppMethodBeat.i(44358);
          ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[] { paramAnonymousString });
          e.o(paramString, j, paramAnonymousString);
          AppMethodBeat.o(44358);
        }
      }, true);
      AppMethodBeat.o(195620);
    }
  }
  
  static final class b
    implements bc.c
  {
    private boolean j(String paramString, Map<String, String> paramMap)
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
      long l1 = bt.getLong((String)paramMap.get(paramString + ".StartTime"), bt.aGK());
      long l2 = bt.getLong((String)paramMap.get(paramString + ".EndTime"), 7200L + l1);
      paramString = (String)paramMap.get(paramString + ".MD5");
      boolean bool = j.aOK().a(str1, i, str3, paramString, l1, l2);
      ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[] { str1, str2, Integer.valueOf(i), str3, Long.valueOf(l1), Long.valueOf(l2), paramString, Boolean.valueOf(bool) });
      if (bool)
      {
        if (999 == i) {
          break label398;
        }
        com.tencent.mm.plugin.appbrand.config.w.Go(str2);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(44360);
            f.bQ(str1, i);
            Toast.makeText(aj.getContext(), aj.getContext().getString(2131755575, new Object[] { bt.by(this.iOv, str1) }), 1).show();
            AppMethodBeat.o(44360);
          }
        });
      }
      for (;;)
      {
        j.aOI().ba(str2, i);
        AppMethodBeat.o(44362);
        return true;
        label398:
        w.iMv.fh(false);
      }
    }
    
    public final void i(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(195621);
      j(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", paramMap);
      int i = 0;
      int j;
      do
      {
        j = i + 1;
        i = j;
      } while (j(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo".concat(String.valueOf(j)), paramMap));
      AppMethodBeat.o(195621);
    }
  }
  
  public static abstract interface c
  {
    public abstract void i(String paramString, Map<String, String> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bc
 * JD-Core Version:    0.7.0.1
 */