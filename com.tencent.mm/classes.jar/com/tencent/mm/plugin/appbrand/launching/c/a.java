package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.plugin.appbrand.launching.ap;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a
{
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
    paramAppBrandStatObject.dCw = com.tencent.mm.compatible.util.q.encode(paramString);
    paramAppBrandStatObject.ecU = m.k(paramInt, paramBundle1);
    paramAppBrandStatObject.ecV = m.l(paramInt, paramBundle1);
    if (paramBundle2 != null) {
      paramAppBrandStatObject.nHw = paramBundle2.getBundle("stat_get_a8_key_cgi_speed");
    }
    if ((paramInt != 1037) && (paramInt != 1018))
    {
      paramAppBrandStatObject.ecS = paramInt;
      return;
    }
    paramAppBrandStatObject.ecS = 0;
  }
  
  public final a a(Context paramContext, String paramString, int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    Log.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", new Object[] { paramString });
    String str2 = null;
    String str1;
    if (Util.isNullOrNil(paramString))
    {
      paramContext = a.mYk;
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
            Log.i("MicroMsg.AppBrand.AbsLinkOpener", "replace url for parsing %s", new Object[] { str1 });
          }
        }
      }
      paramString = Uri.parse(str1);
      if (Util.getInt(paramString.getQueryParameter("debug"), 0) > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label574;
        }
        i = Util.getInt(paramString.getQueryParameter("ret"), 0);
        if (i != 1) {
          break label196;
        }
        paramContext = a.mYl;
        break;
      }
      if (i == 2)
      {
        paramContext = a.mYm;
      }
      else
      {
        localObject1 = paramString.getQueryParameter("appid");
        str2 = paramString.getQueryParameter("username");
        str3 = Util.nullAsNil(paramString.getQueryParameter("path"));
        localObject2 = paramString.getQueryParameter("codeurl");
        str4 = paramString.getQueryParameter("md5");
        str5 = paramString.getQueryParameter("pageurl");
        str6 = paramString.getQueryParameter("pagemd5");
        l = Util.getLong(paramString.getQueryParameter("test_lifespan"), 7200L);
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str2)) && (!Util.isNullOrNil((String)localObject2))) {
          break;
        }
        Log.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { localObject1, str2, localObject2 });
        paramContext = a.mYk;
      }
    }
    boolean bool = n.buL().a((String)localObject1, 1, (String)localObject2, str4, 0L, Util.nowSecond() + l);
    if ((!Util.isNullOrNil(str5)) && (!Util.isNullOrNil(str6)))
    {
      n.buL().a((String)localObject1, 10000, str5, str6, 0L, Util.nowSecond() + l);
      i = com.tencent.mm.plugin.appbrand.dynamic.k.b.dV(0, 1);
      if (i == 10000)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("appId", (String)localObject1);
        ((Bundle)localObject2).putInt("debugType", i);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject2, a.d.class, null);
      }
    }
    if (bool)
    {
      d.cd((String)localObject1, 1);
      com.tencent.mm.plugin.appbrand.task.h.bWb().cl((String)localObject1, 1);
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).ct((String)localObject1, 1);
    }
    String str4 = paramString.getQueryParameter("json_extinfo");
    Object localObject2 = new LaunchParamsOptional();
    ((LaunchParamsOptional)localObject2).iIt = str4;
    ((t)n.W(t.class)).A((String)localObject1, 1, str4);
    Object localObject1 = new AppBrandStatObject();
    a(str1, paramInt, (AppBrandStatObject)localObject1, paramBundle1, paramBundle2);
    AppBrandLaunchProxyUI.a(paramContext, str2, str3, 1, -1, (AppBrandStatObject)localObject1, (LaunchParamsOptional)localObject2);
    for (;;)
    {
      paramContext = a.mYj;
      break;
      label574:
      str3 = paramString.getQueryParameter("username");
      if (Util.isNullOrNil(str3))
      {
        Log.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", new Object[] { str3 });
        paramContext = a.mYk;
        break;
      }
      if (paramBundle1 != null) {}
      for (str2 = paramBundle1.getString("stat_app_id");; str2 = null)
      {
        if (!Util.isNullOrNil(str2)) {
          break label660;
        }
        a(paramContext, str1, paramString, paramInt, paramBundle1, str3, paramBundle2);
        break;
      }
      label660:
      paramContext = new a.1(this, str2, str3, paramContext, str1, paramString, paramInt, paramBundle1, paramBundle2);
      paramBundle1 = new ap();
      paramBundle1.field_appId = str2;
      paramBundle2 = n.buD();
      if (paramBundle2 == null)
      {
        Log.w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
        h.a(paramContext);
      }
      else
      {
        if (paramBundle2.a(paramBundle1, new String[] { "appId" }))
        {
          if ((paramBundle1.acg("banJumpApp")) || (paramBundle1.acg("banJumpGame"))) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label805;
            }
            ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(str3, new h.1(paramContext, paramBundle1));
            break;
          }
        }
        label805:
        Log.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no ban info for appid:%s", new Object[] { str2 });
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
      mYj = new a("OK", 0);
      mYk = new a("ERR_URL_INVALID", 1);
      mYl = new a("ERR_UIN_INVALID", 2);
      mYm = new a("ERR_DEV_CODE_EXPIRED", 3);
      mYn = new a[] { mYj, mYk, mYl, mYm };
      AppMethodBeat.o(47406);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.a
 * JD-Core Version:    0.7.0.1
 */