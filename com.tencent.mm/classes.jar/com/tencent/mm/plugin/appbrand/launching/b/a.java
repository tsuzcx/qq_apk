package com.tencent.mm.plugin.appbrand.launching.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.aa;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class a
{
  static void a(Context paramContext, String paramString1, Uri paramUri, int paramInt, Bundle paramBundle, String paramString2)
  {
    String str = bo.nullAsNil(paramUri.getQueryParameter("path"));
    int i = bo.getInt(paramUri.getQueryParameter("version"), 0);
    int j = bo.getInt(paramUri.getQueryParameter("type"), 0);
    paramUri = new AppBrandStatObject();
    a(paramString1, paramInt, paramUri, paramBundle);
    AppBrandLaunchProxyUI.a(paramContext, paramString2, str, j, i, paramUri, null, null);
  }
  
  private static void a(String paramString, int paramInt, AppBrandStatObject paramAppBrandStatObject, Bundle paramBundle)
  {
    paramAppBrandStatObject.scene = paramInt;
    paramAppBrandStatObject.cmF = q.encode(paramString);
    paramAppBrandStatObject.cJb = com.tencent.mm.plugin.appbrand.report.i.j(paramInt, paramBundle);
    paramAppBrandStatObject.cJc = com.tencent.mm.plugin.appbrand.report.i.k(paramInt, paramBundle);
    if ((paramInt != 1037) && (paramInt != 1018))
    {
      paramAppBrandStatObject.cIZ = paramInt;
      return;
    }
    paramAppBrandStatObject.cIZ = 0;
  }
  
  public final a.a a(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", new Object[] { paramString });
    String str2 = null;
    String str1;
    if (bo.isNullOrNil(paramString))
    {
      paramContext = a.a.inn;
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
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AbsLinkOpener", "replace url for parsing %s", new Object[] { str1 });
          }
        }
      }
      paramString = Uri.parse(str1);
      if (bo.getInt(paramString.getQueryParameter("debug"), 0) > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label546;
        }
        i = bo.getInt(paramString.getQueryParameter("ret"), 0);
        if (i != 1) {
          break label196;
        }
        paramContext = a.a.ino;
        break;
      }
      if (i == 2)
      {
        paramContext = a.a.inp;
      }
      else
      {
        localObject1 = paramString.getQueryParameter("appid");
        str2 = paramString.getQueryParameter("username");
        str3 = bo.nullAsNil(paramString.getQueryParameter("path"));
        localObject2 = paramString.getQueryParameter("codeurl");
        str4 = paramString.getQueryParameter("md5");
        str5 = paramString.getQueryParameter("pageurl");
        str6 = paramString.getQueryParameter("pagemd5");
        l = bo.getLong(paramString.getQueryParameter("test_lifespan"), 7200L);
        if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil(str2)) && (!bo.isNullOrNil((String)localObject2))) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { localObject1, str2, localObject2 });
        paramContext = a.a.inn;
      }
    }
    boolean bool = com.tencent.mm.plugin.appbrand.app.g.auM().a((String)localObject1, 1, (String)localObject2, str4, 0L, bo.aox() + l);
    if ((!bo.isNullOrNil(str5)) && (!bo.isNullOrNil(str6)))
    {
      com.tencent.mm.plugin.appbrand.app.g.auM().a((String)localObject1, 10000, str5, str6, 0L, bo.aox() + l);
      i = b.dc(0, 1);
      if (i == 10000)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("appId", (String)localObject1);
        ((Bundle)localObject2).putInt("debugType", i);
        f.a("com.tencent.mm", (Parcelable)localObject2, a.d.class, null);
      }
    }
    if (bool) {
      com.tencent.mm.plugin.appbrand.task.h.bt((String)localObject1, 1);
    }
    String str4 = paramString.getQueryParameter("json_extinfo");
    Object localObject2 = new LaunchParamsOptional();
    ((LaunchParamsOptional)localObject2).fpV = str4;
    ((m)com.tencent.mm.plugin.appbrand.app.g.w(m.class)).n((String)localObject1, 1, str4);
    Object localObject1 = new AppBrandStatObject();
    a(str1, paramInt, (AppBrandStatObject)localObject1, paramBundle);
    AppBrandLaunchProxyUI.a(paramContext, str2, str3, 1, -1, (AppBrandStatObject)localObject1, null, (LaunchParamsOptional)localObject2);
    for (;;)
    {
      paramContext = a.a.inm;
      break;
      label546:
      str3 = paramString.getQueryParameter("username");
      if (bo.isNullOrNil(str3))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", new Object[] { str3 });
        paramContext = a.a.inn;
        break;
      }
      if (paramBundle != null) {}
      for (str2 = paramBundle.getString("stat_app_id");; str2 = null)
      {
        if (!bo.isNullOrNil(str2)) {
          break label628;
        }
        a(paramContext, str1, paramString, paramInt, paramBundle, str3);
        break;
      }
      label628:
      paramContext = new a.1(this, str2, str3, paramContext, str1, paramString, paramInt, paramBundle);
      paramBundle = new com.tencent.mm.plugin.appbrand.launching.ab();
      paramBundle.field_appId = str2;
      localObject1 = com.tencent.mm.plugin.appbrand.app.g.auG();
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
        h.a(paramContext);
      }
      else
      {
        if (((aa)localObject1).a(paramBundle, new String[] { "appId" }))
        {
          if ((paramBundle.Dn("banJumpApp")) || (paramBundle.Dn("banJumpGame"))) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label771;
            }
            ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).a(str3, new h.1(paramContext, paramBundle));
            break;
          }
        }
        label771:
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no ban info for appid:%s", new Object[] { str2 });
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