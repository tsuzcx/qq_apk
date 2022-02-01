package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.aw;
import com.tencent.mm.plugin.appbrand.launching.ax;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class a
{
  static void a(Context paramContext, String paramString1, Uri paramUri, int paramInt, Bundle paramBundle1, String paramString2, Bundle paramBundle2)
  {
    String str = bt.nullAsNil(paramUri.getQueryParameter("path"));
    int i = bt.getInt(paramUri.getQueryParameter("version"), 0);
    int j = bt.getInt(paramUri.getQueryParameter("type"), 0);
    paramUri = new AppBrandStatObject();
    a(paramString1, paramInt, paramUri, paramBundle1, paramBundle2);
    AppBrandLaunchProxyUI.a(paramContext, paramString2, str, j, i, paramUri, null);
  }
  
  private static void a(String paramString, int paramInt, AppBrandStatObject paramAppBrandStatObject, Bundle paramBundle1, Bundle paramBundle2)
  {
    paramAppBrandStatObject.scene = paramInt;
    paramAppBrandStatObject.dkh = q.encode(paramString);
    paramAppBrandStatObject.dJQ = l.l(paramInt, paramBundle1);
    paramAppBrandStatObject.dJR = l.m(paramInt, paramBundle1);
    if (paramBundle2 != null) {
      paramAppBrandStatObject.mrA = paramBundle2.getBundle("stat_get_a8_key_cgi_speed");
    }
    if ((paramInt != 1037) && (paramInt != 1018))
    {
      paramAppBrandStatObject.dJO = paramInt;
      return;
    }
    paramAppBrandStatObject.dJO = 0;
  }
  
  public final a a(final Context paramContext, final String paramString, final int paramInt, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    ad.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", new Object[] { paramString });
    final String str2 = null;
    final String str1;
    if (bt.isNullOrNil(paramString))
    {
      paramContext = a.lMB;
      str1 = paramString;
      paramString = str2;
    }
    int i;
    label196:
    final String str3;
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
          break label568;
        }
        i = bt.getInt(paramString.getQueryParameter("ret"), 0);
        if (i != 1) {
          break label196;
        }
        paramContext = a.lMC;
        break;
      }
      if (i == 2)
      {
        paramContext = a.lMD;
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
        paramContext = a.lMB;
      }
    }
    boolean bool = j.aYX().a((String)localObject1, 1, (String)localObject2, str4, 0L, bt.aQJ() + l);
    if ((!bt.isNullOrNil(str5)) && (!bt.isNullOrNil(str6)))
    {
      j.aYX().a((String)localObject1, 10000, str5, str6, 0L, bt.aQJ() + l);
      i = com.tencent.mm.plugin.appbrand.dynamic.k.b.dK(0, 1);
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
      d.bR((String)localObject1, 1);
      f.bY((String)localObject1, 1);
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).cf((String)localObject1, 1);
    }
    String str4 = paramString.getQueryParameter("json_extinfo");
    Object localObject2 = new LaunchParamsOptional();
    ((LaunchParamsOptional)localObject2).hKu = str4;
    ((t)j.T(t.class)).t((String)localObject1, 1, str4);
    Object localObject1 = new AppBrandStatObject();
    a(str1, paramInt, (AppBrandStatObject)localObject1, paramBundle1, paramBundle2);
    AppBrandLaunchProxyUI.a(paramContext, str2, str3, 1, -1, (AppBrandStatObject)localObject1, (LaunchParamsOptional)localObject2);
    for (;;)
    {
      paramContext = a.lMA;
      break;
      label568:
      str3 = paramString.getQueryParameter("username");
      if (bt.isNullOrNil(str3))
      {
        ad.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", new Object[] { str3 });
        paramContext = a.lMB;
        break;
      }
      if (paramBundle1 != null) {}
      for (str2 = paramBundle1.getString("stat_app_id");; str2 = null)
      {
        if (!bt.isNullOrNil(str2)) {
          break label654;
        }
        a(paramContext, str1, paramString, paramInt, paramBundle1, str3, paramBundle2);
        break;
      }
      label654:
      paramContext = new h.a()
      {
        public final void brR()
        {
          AppMethodBeat.i(47402);
          ad.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] should ban, from appid:%s, to username:%s", new Object[] { str2, str3 });
          new ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47401);
              Toast.makeText(aj.getContext(), 2131755352, 1).show();
              AppMethodBeat.o(47401);
            }
          });
          AppMethodBeat.o(47402);
        }
        
        public final void brS()
        {
          AppMethodBeat.i(47403);
          ad.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] not ban, from appid:%s, to username:%s", new Object[] { str2, str3 });
          a.a(paramContext, str1, paramString, paramInt, paramBundle1, str3, paramBundle2);
          AppMethodBeat.o(47403);
        }
      };
      paramBundle1 = new ax();
      paramBundle1.field_appId = str2;
      paramBundle2 = j.aYQ();
      if (paramBundle2 == null)
      {
        ad.w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
        h.a(paramContext);
      }
      else
      {
        if (paramBundle2.a(paramBundle1, new String[] { "appId" }))
        {
          if ((paramBundle1.RT("banJumpApp")) || (paramBundle1.RT("banJumpGame"))) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label799;
            }
            ((n)g.ab(n.class)).a(str3, new h.1(paramContext, paramBundle1));
            break;
          }
        }
        label799:
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
      lMA = new a("OK", 0);
      lMB = new a("ERR_URL_INVALID", 1);
      lMC = new a("ERR_UIN_INVALID", 2);
      lMD = new a("ERR_DEV_CODE_EXPIRED", 3);
      lME = new a[] { lMA, lMB, lMC, lMD };
      AppMethodBeat.o(47406);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.a
 * JD-Core Version:    0.7.0.1
 */