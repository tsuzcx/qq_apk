package com.tencent.mm.plugin.appbrand.launching.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.s;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
{
  static void a(Context paramContext, String paramString1, Uri paramUri, int paramInt, Bundle paramBundle, String paramString2)
  {
    String str = bk.pm(paramUri.getQueryParameter("path"));
    int i = bk.getInt(paramUri.getQueryParameter("version"), 0);
    int j = bk.getInt(paramUri.getQueryParameter("type"), 0);
    paramUri = new AppBrandStatObject();
    a(paramString1, paramInt, paramUri, paramBundle);
    AppBrandLaunchProxyUI.a(paramContext, paramString2, str, j, i, paramUri, null, null);
  }
  
  private static void a(String paramString, int paramInt, AppBrandStatObject paramAppBrandStatObject, Bundle paramBundle)
  {
    paramAppBrandStatObject.scene = paramInt;
    paramAppBrandStatObject.bFv = q.encode(paramString);
    paramAppBrandStatObject.caB = com.tencent.mm.plugin.appbrand.report.f.g(paramInt, paramBundle);
    paramAppBrandStatObject.caC = com.tencent.mm.plugin.appbrand.report.f.h(paramInt, paramBundle);
    if ((paramInt != 1037) && (paramInt != 1018))
    {
      paramAppBrandStatObject.caA = paramInt;
      return;
    }
    paramAppBrandStatObject.caA = 0;
  }
  
  public final a.a a(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", new Object[] { paramString });
    String str2 = null;
    String str1;
    if (bk.bl(paramString))
    {
      paramContext = a.a.gLX;
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
            y.i("MicroMsg.AppBrand.AbsLinkOpener", "replace url for parsing %s", new Object[] { str1 });
          }
        }
      }
      paramString = Uri.parse(str1);
      if (bk.getInt(paramString.getQueryParameter("debug"), 0) > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label546;
        }
        i = bk.getInt(paramString.getQueryParameter("ret"), 0);
        if (i != 1) {
          break label196;
        }
        paramContext = a.a.gLY;
        break;
      }
      if (i == 2)
      {
        paramContext = a.a.gLZ;
      }
      else
      {
        localObject1 = paramString.getQueryParameter("appid");
        str2 = paramString.getQueryParameter("username");
        str3 = bk.pm(paramString.getQueryParameter("path"));
        localObject2 = paramString.getQueryParameter("codeurl");
        str4 = paramString.getQueryParameter("md5");
        str5 = paramString.getQueryParameter("pageurl");
        str6 = paramString.getQueryParameter("pagemd5");
        l = bk.getLong(paramString.getQueryParameter("test_lifespan"), 7200L);
        if ((!bk.bl((String)localObject1)) && (!bk.bl(str2)) && (!bk.bl((String)localObject2))) {
          break;
        }
        y.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { localObject1, str2, localObject2 });
        paramContext = a.a.gLX;
      }
    }
    boolean bool = e.abb().a((String)localObject1, 1, (String)localObject2, str4, 0L, bk.UX() + l);
    if ((!bk.bl(str5)) && (!bk.bl(str6)))
    {
      e.abb().a((String)localObject1, 10000, str5, str6, 0L, bk.UX() + l);
      i = b.bR(0, 1);
      if (i == 10000)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("appId", (String)localObject1);
        ((Bundle)localObject2).putInt("debugType", i);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", (Parcelable)localObject2, a.d.class, null);
      }
    }
    if (bool) {
      com.tencent.mm.plugin.appbrand.task.g.aZ((String)localObject1, 1);
    }
    String str4 = paramString.getQueryParameter("json_extinfo");
    Object localObject2 = new LaunchParamsOptional();
    ((LaunchParamsOptional)localObject2).dZO = str4;
    ((com.tencent.mm.plugin.appbrand.launching.h)e.G(com.tencent.mm.plugin.appbrand.launching.h.class)).l((String)localObject1, 1, str4);
    Object localObject1 = new AppBrandStatObject();
    a(str1, paramInt, (AppBrandStatObject)localObject1, paramBundle);
    AppBrandLaunchProxyUI.a(paramContext, str2, str3, 1, -1, (AppBrandStatObject)localObject1, null, (LaunchParamsOptional)localObject2);
    for (;;)
    {
      paramContext = a.a.gLW;
      break;
      label546:
      str3 = paramString.getQueryParameter("username");
      if (bk.bl(str3))
      {
        y.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", new Object[] { str3 });
        paramContext = a.a.gLX;
        break;
      }
      if (paramBundle != null) {}
      for (str2 = paramBundle.getString("stat_app_id");; str2 = null)
      {
        if (!bk.bl(str2)) {
          break label628;
        }
        a(paramContext, str1, paramString, paramInt, paramBundle, str3);
        break;
      }
      label628:
      paramContext = new a.1(this, str2, str3, paramContext, str1, paramString, paramInt, paramBundle);
      paramBundle = new t();
      paramBundle.field_appId = str2;
      localObject1 = e.aaU();
      if (localObject1 == null)
      {
        y.w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
        h.a(paramContext);
      }
      else
      {
        if (((s)localObject1).a(paramBundle, new String[] { "appId" }))
        {
          if ((paramBundle.uU("banJumpApp")) || (paramBundle.uU("banJumpGame"))) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label771;
            }
            ((c)com.tencent.mm.kernel.g.r(c.class)).a(str3, new h.1(paramContext, paramBundle));
            break;
          }
        }
        label771:
        y.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no ban info for appid:%s", new Object[] { str2 });
        h.a(paramContext);
      }
    }
  }
  
  abstract void a(String paramString, Uri paramUri, a.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a
 * JD-Core Version:    0.7.0.1
 */