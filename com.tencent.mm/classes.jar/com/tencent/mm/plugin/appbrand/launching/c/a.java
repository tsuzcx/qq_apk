package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.launching.au;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class a
{
  static void a(Context paramContext, String paramString1, Uri paramUri, int paramInt, Bundle paramBundle, String paramString2)
  {
    String str = bt.nullAsNil(paramUri.getQueryParameter("path"));
    int i = bt.getInt(paramUri.getQueryParameter("version"), 0);
    int j = bt.getInt(paramUri.getQueryParameter("type"), 0);
    paramUri = new AppBrandStatObject();
    a(paramString1, paramInt, paramUri, paramBundle);
    AppBrandLaunchProxyUI.a(paramContext, paramString2, str, j, i, paramUri, null, null);
  }
  
  private static void a(String paramString, int paramInt, AppBrandStatObject paramAppBrandStatObject, Bundle paramBundle)
  {
    paramAppBrandStatObject.scene = paramInt;
    paramAppBrandStatObject.dbt = p.encode(paramString);
    paramAppBrandStatObject.dzS = l.k(paramInt, paramBundle);
    paramAppBrandStatObject.dzT = l.l(paramInt, paramBundle);
    if ((paramInt != 1037) && (paramInt != 1018))
    {
      paramAppBrandStatObject.dzQ = paramInt;
      return;
    }
    paramAppBrandStatObject.dzQ = 0;
  }
  
  public final a a(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    ad.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", new Object[] { paramString });
    String str2 = null;
    String str1;
    if (bt.isNullOrNil(paramString))
    {
      paramContext = a.kNJ;
      str1 = paramString;
      paramString = str2;
    }
    int i;
    label196:
    String str3;
    String str5;
    String str6;
    long l;
    for (;;)
    {
      a(str1, paramString, paramContext);
      return paramContext;
      i = paramString.indexOf('#');
      int j = paramString.indexOf('?');
      str1 = paramString;
      if (i > 0)
      {
        str1 = paramString;
        if (j > 0)
        {
          str1 = paramString;
          if (i < j)
          {
            str1 = paramString.substring(0, i) + paramString.substring(j, paramString.length());
            ad.i("MicroMsg.AppBrand.AbsLinkOpener", "replace url for parsing %s", new Object[] { str1 });
          }
        }
      }
      paramString = Uri.parse(str1);
      if (bt.getInt(paramString.getQueryParameter("debug"), 0) > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label567;
        }
        i = bt.getInt(paramString.getQueryParameter("ret"), 0);
        if (i != 1) {
          break label196;
        }
        paramContext = a.kNK;
        break;
      }
      if (i == 2)
      {
        paramContext = a.kNL;
      }
      else
      {
        localObject1 = paramString.getQueryParameter("appid");
        str2 = paramString.getQueryParameter("username");
        str3 = bt.nullAsNil(paramString.getQueryParameter("path"));
        localObject2 = paramString.getQueryParameter("codeurl");
        str4 = paramString.getQueryParameter("md5");
        str5 = paramString.getQueryParameter("pageurl");
        str6 = paramString.getQueryParameter("pagemd5");
        l = bt.getLong(paramString.getQueryParameter("test_lifespan"), 7200L);
        if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(str2)) && (!bt.isNullOrNil((String)localObject2))) {
          break;
        }
        ad.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { localObject1, str2, localObject2 });
        paramContext = a.kNJ;
      }
    }
    boolean bool = j.aOK().a((String)localObject1, 1, (String)localObject2, str4, 0L, bt.aGK() + l);
    if ((!bt.isNullOrNil(str5)) && (!bt.isNullOrNil(str6)))
    {
      j.aOK().a((String)localObject1, 10000, str5, str6, 0L, bt.aGK() + l);
      i = com.tencent.mm.plugin.appbrand.dynamic.k.b.dI(0, 1);
      if (i == 10000)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("appId", (String)localObject1);
        ((Bundle)localObject2).putInt("debugType", i);
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject2, a.d.class, null);
      }
    }
    if (bool)
    {
      d.bK((String)localObject1, 1);
      f.bQ((String)localObject1, 1);
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).bX((String)localObject1, 1);
    }
    String str4 = paramString.getQueryParameter("json_extinfo");
    Object localObject2 = new LaunchParamsOptional();
    ((LaunchParamsOptional)localObject2).gRC = str4;
    ((t)j.T(t.class)).s((String)localObject1, 1, str4);
    Object localObject1 = new AppBrandStatObject();
    a(str1, paramInt, (AppBrandStatObject)localObject1, paramBundle);
    AppBrandLaunchProxyUI.a(paramContext, str2, str3, 1, -1, (AppBrandStatObject)localObject1, null, (LaunchParamsOptional)localObject2);
    for (;;)
    {
      paramContext = a.kNI;
      break;
      label567:
      str3 = paramString.getQueryParameter("username");
      if (bt.isNullOrNil(str3))
      {
        ad.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", new Object[] { str3 });
        paramContext = a.kNJ;
        break;
      }
      if (paramBundle != null) {}
      for (str2 = paramBundle.getString("stat_app_id");; str2 = null)
      {
        if (!bt.isNullOrNil(str2)) {
          break label649;
        }
        a(paramContext, str1, paramString, paramInt, paramBundle, str3);
        break;
      }
      label649:
      paramContext = new a.1(this, str2, str3, paramContext, str1, paramString, paramInt, paramBundle);
      paramBundle = new au();
      paramBundle.field_appId = str2;
      localObject1 = j.aOD();
      if (localObject1 == null)
      {
        ad.w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
        h.a(paramContext);
      }
      else
      {
        if (((at)localObject1).a(paramBundle, new String[] { "appId" }))
        {
          if ((paramBundle.Km("banJumpApp")) || (paramBundle.Km("banJumpGame"))) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label792;
            }
            ((m)g.ab(m.class)).a(str3, new h.1(paramContext, paramBundle));
            break;
          }
        }
        label792:
        ad.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no ban info for appid:%s", new Object[] { str2 });
        h.a(paramContext);
      }
    }
  }
  
  abstract void a(String paramString, Uri paramUri, a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(47406);
      kNI = new a("OK", 0);
      kNJ = new a("ERR_URL_INVALID", 1);
      kNK = new a("ERR_UIN_INVALID", 2);
      kNL = new a("ERR_DEV_CODE_EXPIRED", 3);
      kNM = new a[] { kNI, kNJ, kNK, kNL };
      AppMethodBeat.o(47406);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.a
 * JD-Core Version:    0.7.0.1
 */