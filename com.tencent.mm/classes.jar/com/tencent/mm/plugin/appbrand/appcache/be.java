package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.p.c;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.d;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class be
  implements cf.a
{
  public static final Map<String, c> jLw;
  
  static
  {
    AppMethodBeat.i(44366);
    HashMap localHashMap = new HashMap();
    localHashMap.put("AppBrandNotify", new b((byte)0));
    localHashMap.put("AppPublicLibraryNotify", new d((byte)0));
    localHashMap.put("mmbizwxaconfig", new a((byte)0));
    localHashMap.put("ForceOpenAppNotify", new com.tencent.mm.plugin.appbrand.debugger.e());
    localHashMap.put("AppBrandForceKill", new d());
    if (DebuggerShell.bfe()) {
      localHashMap.put("AppBrandTestUpdateWxaUsageListNotify", new com.tencent.mm.plugin.appbrand.debugger.i());
    }
    jLw = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(44366);
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(44364);
    parama = z.a(parama.gte.FNI);
    if (bu.isNullOrNil(parama))
    {
      ae.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
      AppMethodBeat.o(44364);
      return;
    }
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44357);
        be.fi(parama);
        AppMethodBeat.o(44357);
      }
    }, "MicroMsg.AppBrand.WxaPkgPushingXmlHandler");
    AppMethodBeat.o(44364);
  }
  
  public final void a(e.c paramc) {}
  
  static final class a
    implements be.c
  {
    public final void l(final String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(222131);
      if (paramMap.get(".sysmsg.mmbizwxaconfig") == null)
      {
        AppMethodBeat.o(222131);
        return;
      }
      int i = bu.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.command"), -1);
      final int j = bu.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.type"), 0);
      paramString = (String)paramMap.get(".sysmsg.mmbizwxaconfig.appid");
      int k = bu.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.configversion"), 0);
      ae.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, Integer.valueOf(k) });
      paramMap = new LinkedList();
      dwh localdwh = new dwh();
      localdwh.version = k;
      localdwh.type = j;
      paramMap.add(localdwh);
      p.a(paramString, paramMap, false);
      p.a(paramString, j, i, new p.c()
      {
        public final void Mf(String paramAnonymousString)
        {
          AppMethodBeat.i(44358);
          ae.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.ipc.e.r(paramString, j, paramAnonymousString);
          AppMethodBeat.o(44358);
        }
      }, true);
      AppMethodBeat.o(222131);
    }
  }
  
  static final class b
    implements be.c
  {
    private boolean m(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(44362);
      ae.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", new Object[] { paramString });
      if (paramMap.get(paramString) == null)
      {
        AppMethodBeat.o(44362);
        return false;
      }
      final String str1 = (String)paramMap.get(paramString + ".AppID");
      String str2 = (String)paramMap.get(paramString + ".UserName");
      final int i = bu.getInt((String)paramMap.get(paramString + ".Type"), 1);
      String str3 = (String)paramMap.get(paramString + ".URL");
      long l1 = bu.getLong((String)paramMap.get(paramString + ".StartTime"), bu.aRi());
      long l2 = bu.getLong((String)paramMap.get(paramString + ".EndTime"), 7200L + l1);
      paramString = (String)paramMap.get(paramString + ".MD5");
      boolean bool = j.aZu().a(str1, i, str3, paramString, l1, l2);
      ae.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[] { str1, str2, Integer.valueOf(i), str3, Long.valueOf(l1), Long.valueOf(l2), paramString, Boolean.valueOf(bool) });
      if (bool)
      {
        if (999 == i) {
          break label398;
        }
        x.Ot(str2);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(44360);
            f.cc(str1, i);
            Toast.makeText(ak.getContext(), ak.getContext().getString(2131755575, new Object[] { bu.bI(this.jLB, str1) }), 1).show();
            AppMethodBeat.o(44360);
          }
        });
      }
      for (;;)
      {
        j.aZs().bj(str2, i);
        AppMethodBeat.o(44362);
        return true;
        label398:
        y.jJy.fG(false);
      }
    }
    
    public final void l(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(222132);
      m(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", paramMap);
      int i = 0;
      int j;
      do
      {
        j = i + 1;
        i = j;
      } while (m(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo".concat(String.valueOf(j)), paramMap));
      AppMethodBeat.o(222132);
    }
  }
  
  public static abstract interface c
  {
    public abstract void l(String paramString, Map<String, String> paramMap);
  }
  
  static final class d
    implements be.c
  {
    public final void l(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(222133);
      if (paramMap.get(".sysmsg.AppPublicLibraryNotify") == null)
      {
        AppMethodBeat.o(222133);
        return;
      }
      int i = bu.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
      paramString = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.MD5");
      String str = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.URL");
      int j = bu.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
      if ((bu.isNullOrNil(str)) || (bu.isNullOrNil(paramString)) || (i <= 0))
      {
        ae.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[] { str, paramString, Integer.valueOf(i) });
        AppMethodBeat.o(222133);
        return;
      }
      ae.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[] { Integer.valueOf(i), paramString, str, Integer.valueOf(j) });
      paramMap = new ehp();
      paramMap.version = i;
      paramMap.md5 = paramString;
      paramMap.url = str;
      paramMap.HAa = j;
      au.a(paramMap);
      AppMethodBeat.o(222133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.be
 * JD-Core Version:    0.7.0.1
 */