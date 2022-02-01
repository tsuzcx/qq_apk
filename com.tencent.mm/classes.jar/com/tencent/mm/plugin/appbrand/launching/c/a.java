package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.widget.Toast;
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
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class a
{
  static void a(Context paramContext, String paramString1, Uri paramUri, int paramInt, Bundle paramBundle, String paramString2)
  {
    String str = bs.nullAsNil(paramUri.getQueryParameter("path"));
    int i = bs.getInt(paramUri.getQueryParameter("version"), 0);
    int j = bs.getInt(paramUri.getQueryParameter("type"), 0);
    paramUri = new AppBrandStatObject();
    a(paramString1, paramInt, paramUri, paramBundle);
    AppBrandLaunchProxyUI.a(paramContext, paramString2, str, j, i, paramUri, null, null);
  }
  
  private static void a(String paramString, int paramInt, AppBrandStatObject paramAppBrandStatObject, Bundle paramBundle)
  {
    paramAppBrandStatObject.scene = paramInt;
    paramAppBrandStatObject.cYP = p.encode(paramString);
    paramAppBrandStatObject.dxE = k.l(paramInt, paramBundle);
    paramAppBrandStatObject.dxF = k.m(paramInt, paramBundle);
    if ((paramInt != 1037) && (paramInt != 1018))
    {
      paramAppBrandStatObject.dxC = paramInt;
      return;
    }
    paramAppBrandStatObject.dxC = 0;
  }
  
  public final a a(final Context paramContext, final String paramString, final int paramInt, final Bundle paramBundle)
  {
    ac.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", new Object[] { paramString });
    final String str2 = null;
    final String str1;
    if (bs.isNullOrNil(paramString))
    {
      paramContext = a.lpi;
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
            ac.i("MicroMsg.AppBrand.AbsLinkOpener", "replace url for parsing %s", new Object[] { str1 });
          }
        }
      }
      paramString = Uri.parse(str1);
      if (bs.getInt(paramString.getQueryParameter("debug"), 0) > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label567;
        }
        i = bs.getInt(paramString.getQueryParameter("ret"), 0);
        if (i != 1) {
          break label196;
        }
        paramContext = a.lpj;
        break;
      }
      if (i == 2)
      {
        paramContext = a.lpk;
      }
      else
      {
        localObject1 = paramString.getQueryParameter("appid");
        str2 = paramString.getQueryParameter("username");
        str3 = bs.nullAsNil(paramString.getQueryParameter("path"));
        localObject2 = paramString.getQueryParameter("codeurl");
        str4 = paramString.getQueryParameter("md5");
        str5 = paramString.getQueryParameter("pageurl");
        str6 = paramString.getQueryParameter("pagemd5");
        l = bs.getLong(paramString.getQueryParameter("test_lifespan"), 7200L);
        if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(str2)) && (!bs.isNullOrNil((String)localObject2))) {
          break;
        }
        ac.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { localObject1, str2, localObject2 });
        paramContext = a.lpi;
      }
    }
    boolean bool = j.aVC().a((String)localObject1, 1, (String)localObject2, str4, 0L, bs.aNx() + l);
    if ((!bs.isNullOrNil(str5)) && (!bs.isNullOrNil(str6)))
    {
      j.aVC().a((String)localObject1, 10000, str5, str6, 0L, bs.aNx() + l);
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
      d.bO((String)localObject1, 1);
      f.bV((String)localObject1, 1);
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).cc((String)localObject1, 1);
    }
    String str4 = paramString.getQueryParameter("json_extinfo");
    Object localObject2 = new LaunchParamsOptional();
    ((LaunchParamsOptional)localObject2).hsc = str4;
    ((t)j.T(t.class)).s((String)localObject1, 1, str4);
    Object localObject1 = new AppBrandStatObject();
    a(str1, paramInt, (AppBrandStatObject)localObject1, paramBundle);
    AppBrandLaunchProxyUI.a(paramContext, str2, str3, 1, -1, (AppBrandStatObject)localObject1, null, (LaunchParamsOptional)localObject2);
    for (;;)
    {
      paramContext = a.lph;
      break;
      label567:
      str3 = paramString.getQueryParameter("username");
      if (bs.isNullOrNil(str3))
      {
        ac.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", new Object[] { str3 });
        paramContext = a.lpi;
        break;
      }
      if (paramBundle != null) {}
      for (str2 = paramBundle.getString("stat_app_id");; str2 = null)
      {
        if (!bs.isNullOrNil(str2)) {
          break label649;
        }
        a(paramContext, str1, paramString, paramInt, paramBundle, str3);
        break;
      }
      label649:
      paramContext = new h.a()
      {
        public final void bnY()
        {
          AppMethodBeat.i(47402);
          ac.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] should ban, from appid:%s, to username:%s", new Object[] { str2, str3 });
          new ao(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47401);
              Toast.makeText(ai.getContext(), 2131755352, 1).show();
              AppMethodBeat.o(47401);
            }
          });
          AppMethodBeat.o(47402);
        }
        
        public final void bnZ()
        {
          AppMethodBeat.i(47403);
          ac.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] not ban, from appid:%s, to username:%s", new Object[] { str2, str3 });
          a.a(paramContext, str1, paramString, paramInt, paramBundle, str3);
          AppMethodBeat.o(47403);
        }
      };
      paramBundle = new au();
      paramBundle.field_appId = str2;
      localObject1 = j.aVv();
      if (localObject1 == null)
      {
        ac.w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
        h.a(paramContext);
      }
      else
      {
        if (((at)localObject1).a(paramBundle, new String[] { "appId" }))
        {
          if ((paramBundle.Ot("banJumpApp")) || (paramBundle.Ot("banJumpGame"))) {}
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
        ac.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no ban info for appid:%s", new Object[] { str2 });
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
      lph = new a("OK", 0);
      lpi = new a("ERR_URL_INVALID", 1);
      lpj = new a("ERR_UIN_INVALID", 2);
      lpk = new a("ERR_DEV_CODE_EXPIRED", 3);
      lpl = new a[] { lph, lpi, lpj, lpk };
      AppMethodBeat.o(47406);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.a
 * JD-Core Version:    0.7.0.1
 */