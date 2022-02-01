package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.ai;
import com.tencent.mm.plugin.appbrand.launching.aj;
import com.tencent.mm.plugin.appbrand.launching.ar;
import com.tencent.mm.plugin.appbrand.launching.s;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public abstract class a
{
  private a a(final Context paramContext, final String paramString, final Uri paramUri, final int paramInt, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    int i;
    if (Util.getInt(paramUri.getQueryParameter("debug"), 0) > 0) {
      i = 1;
    }
    while (i != 0)
    {
      i = Util.getInt(paramUri.getQueryParameter("ret"), 0);
      if (i == 1)
      {
        return a.pYK;
        i = 0;
      }
      else
      {
        if (i == 2) {
          return a.pYL;
        }
        Object localObject1 = paramUri.getQueryParameter("appid");
        str1 = paramUri.getQueryParameter("username");
        str2 = Util.nullAsNil(paramUri.getQueryParameter("path"));
        Object localObject2 = paramUri.getQueryParameter("codeurl");
        Object localObject3 = paramUri.getQueryParameter("md5");
        Object localObject4 = paramUri.getQueryParameter("pageurl");
        String str3 = paramUri.getQueryParameter("pagemd5");
        long l = Util.getLong(paramUri.getQueryParameter("test_lifespan"), 7200L);
        if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil(str1)) || (Util.isNullOrNil((String)localObject2)))
        {
          Log.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { localObject1, str1, localObject2 });
          return a.pYJ;
        }
        boolean bool = m.bFP().a((String)localObject1, 1, (String)localObject2, (String)localObject3, 0L, Util.nowSecond() + l);
        if ((!Util.isNullOrNil((String)localObject4)) && (!Util.isNullOrNil(str3)))
        {
          m.bFP().a((String)localObject1, 10000, (String)localObject4, str3, 0L, Util.nowSecond() + l);
          i = com.tencent.mm.plugin.appbrand.dynamic.k.b.eu(0, 1);
          if (i == 10000)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("appId", (String)localObject1);
            ((Bundle)localObject2).putInt("debugType", i);
            j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject2, a.d.class, null);
          }
        }
        if (bool)
        {
          d.cB((String)localObject1, 1);
          i.cjb().u((String)localObject1, 1);
          ((com.tencent.mm.plugin.appbrand.ui.c.a.b)m.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).cN((String)localObject1, 1);
        }
        localObject2 = paramUri.getQueryParameter("json_extinfo");
        paramUri = new LaunchParamsOptional();
        paramUri.lyv = ((String)localObject2);
        ((s)m.W(s.class)).B((String)localObject1, 1, (String)localObject2);
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject2 = ac.afy((String)localObject2);
          localObject1 = ((WxaAttributes.WxaVersionInfo)localObject2).obB;
          localObject2 = ((WxaAttributes.WxaVersionInfo)localObject2).moduleList;
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            localObject1 = ((List)localObject2).iterator();
          }
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject1).next();
            if ((((WxaAttributes.WxaVersionModuleInfo)localObject2).obO != null) && (((WxaAttributes.WxaVersionModuleInfo)localObject2).obO.size() > 0))
            {
              localObject3 = ((WxaAttributes.WxaVersionModuleInfo)localObject2).obO.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject3).next();
                if (!Util.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)localObject4).nGm))
                {
                  bool = ((ar)m.W(ar.class)).j(((WxaAttributes.WxaPluginCodeInfo)localObject4).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject4).nGm, ((WxaAttributes.WxaPluginCodeInfo)localObject4).obv);
                  Log.i("MicroMsg.AppBrand.AbsLinkOpener", "handleLinkImpl: module :%s dev plugin provider:%s,versionDesc:%s,devUin:%d saveRet:%b", new Object[] { ((WxaAttributes.WxaVersionModuleInfo)localObject2).name, ((WxaAttributes.WxaPluginCodeInfo)localObject4).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject4).nGm, Integer.valueOf(new p(((WxaAttributes.WxaPluginCodeInfo)localObject4).obv).intValue()), Boolean.valueOf(bool) });
                }
              }
              continue;
              if ((localObject1 != null) && (((List)localObject1).size() > 0))
              {
                localObject1 = ((List)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject1).next();
                  if (!Util.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)localObject2).nGm))
                  {
                    bool = ((ar)m.W(ar.class)).j(((WxaAttributes.WxaPluginCodeInfo)localObject2).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject2).nGm, ((WxaAttributes.WxaPluginCodeInfo)localObject2).obv);
                    Log.i("MicroMsg.AppBrand.AbsLinkOpener", "handleLinkImpl: dev plugin provider:%s,versionDesc:%s,devUin:%d saveRet:%b", new Object[] { ((WxaAttributes.WxaPluginCodeInfo)localObject2).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject2).nGm, Integer.valueOf(new p(((WxaAttributes.WxaPluginCodeInfo)localObject2).obv).intValue()), Boolean.valueOf(bool) });
                  }
                }
              }
            }
          }
        }
        localObject1 = new AppBrandStatObject();
        a(paramString, paramInt, (AppBrandStatObject)localObject1, paramBundle1, paramBundle2);
        AppBrandLaunchProxyUI.a(paramContext, str1, str2, 1, -1, (AppBrandStatObject)localObject1, paramUri);
        return a.pYI;
      }
    }
    final String str2 = paramUri.getQueryParameter("username");
    if (Util.isNullOrNil(str2))
    {
      Log.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", new Object[] { str2 });
      return a.pYJ;
    }
    if (paramBundle1 != null) {}
    for (final String str1 = paramBundle1.getString("stat_app_id"); Util.isNullOrNil(str1); str1 = null)
    {
      a(paramContext, paramString, paramUri, paramInt, paramBundle1, str2, paramBundle2);
      return a.pYI;
    }
    paramContext = new h.a()
    {
      public final void cas()
      {
        AppMethodBeat.i(47402);
        Log.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] should ban, from appid:%s, to username:%s", new Object[] { str1, str2 });
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47401);
            Toast.makeText(MMApplicationContext.getContext(), au.i.app_brand_ban_jumping_from_long_press_wx_code, 1).show();
            AppMethodBeat.o(47401);
          }
        });
        AppMethodBeat.o(47402);
      }
      
      public final void cat()
      {
        AppMethodBeat.i(47403);
        Log.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] not ban, from appid:%s, to username:%s", new Object[] { str1, str2 });
        a.a(paramContext, paramString, paramUri, paramInt, paramBundle1, str2, paramBundle2);
        AppMethodBeat.o(47403);
      }
    };
    paramString = new aj();
    paramString.field_appId = str1;
    paramUri = m.bFG();
    if (paramUri == null)
    {
      Log.w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
      h.a(paramContext);
    }
    for (;;)
    {
      return a.pYI;
      if (paramUri.a(paramString, new String[] { "appId" }))
      {
        if ((paramString.aka("banJumpApp")) || (paramString.aka("banJumpGame"))) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label1017;
          }
          ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).a(str2, new h.1(paramContext, paramString));
          break;
        }
      }
      label1017:
      Log.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no ban info for appid:%s", new Object[] { str1 });
      h.a(paramContext);
    }
  }
  
  static void a(Context paramContext, String paramString1, Uri paramUri, int paramInt, Bundle paramBundle1, String paramString2, Bundle paramBundle2)
  {
    String str = Util.nullAsNil(paramUri.getQueryParameter("path"));
    int i = Util.getInt(paramUri.getQueryParameter("version"), 0);
    int j = Util.getInt(paramUri.getQueryParameter("type"), 0);
    paramUri = new AppBrandStatObject();
    a(paramString1, paramInt, paramUri, paramBundle1, paramBundle2);
    AppBrandLaunchProxyUI.a(paramContext, paramString2, str, j, i, paramUri, null);
  }
  
  private static void a(String paramString, int paramInt, AppBrandStatObject paramAppBrandStatObject, Bundle paramBundle1, Bundle paramBundle2)
  {
    paramAppBrandStatObject.scene = paramInt;
    paramAppBrandStatObject.fvd = com.tencent.mm.compatible.util.q.aT(paramString);
    paramAppBrandStatObject.fXa = n.m(paramInt, paramBundle1);
    paramAppBrandStatObject.fXb = n.n(paramInt, paramBundle1);
    if (paramBundle2 != null) {
      paramAppBrandStatObject.qJI = paramBundle2.getBundle("stat_get_a8_key_cgi_speed");
    }
    if ((paramInt != 1037) && (paramInt != 1018))
    {
      paramAppBrandStatObject.fWX = paramInt;
      return;
    }
    paramAppBrandStatObject.fWX = 0;
  }
  
  public final a a(Context paramContext, String paramString, int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    Log.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", new Object[] { paramString });
    String str = null;
    if (Util.isNullOrNil(paramString))
    {
      paramContext = a.pYJ;
      paramBundle1 = paramString;
      paramString = str;
    }
    for (;;)
    {
      a(paramBundle1, paramString, paramContext);
      return paramContext;
      int i = paramString.indexOf('#');
      int j = paramString.indexOf('?');
      str = paramString;
      if (i > 0)
      {
        str = paramString;
        if (j > 0)
        {
          str = paramString;
          if (i < j)
          {
            str = paramString.substring(0, i) + paramString.substring(j, paramString.length());
            Log.i("MicroMsg.AppBrand.AbsLinkOpener", "replace url for parsing %s", new Object[] { str });
          }
        }
      }
      paramString = Uri.parse(str);
      paramContext = a(paramContext, str, paramString, paramInt, paramBundle1, paramBundle2);
      paramBundle1 = str;
    }
  }
  
  abstract void a(String paramString, Uri paramUri, a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(47406);
      pYI = new a("OK", 0);
      pYJ = new a("ERR_URL_INVALID", 1);
      pYK = new a("ERR_UIN_INVALID", 2);
      pYL = new a("ERR_DEV_CODE_EXPIRED", 3);
      pYM = new a[] { pYI, pYJ, pYK, pYL };
      AppMethodBeat.o(47406);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.a
 * JD-Core Version:    0.7.0.1
 */