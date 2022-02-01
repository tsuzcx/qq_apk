package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bk;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.page.bg.a;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;

public enum an
{
  public static void t(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(44652);
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44649);
        an.w(this.fur, paramString2, paramInt);
        AppMethodBeat.o(44649);
      }
    }, "MicroMsg.AppBrand.RemoveUsageTask");
    AppMethodBeat.o(44652);
  }
  
  public static void u(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44653);
    v(paramString1, paramString2, paramInt);
    AppMethodBeat.o(44653);
  }
  
  private static void v(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44654);
    ac.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    j.aVA().bf(paramString1, paramInt);
    j.aVL().zB(paramString1);
    String str1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str1 = com.tencent.mm.plugin.appbrand.config.u.Kl(paramString1);
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    com.tencent.mm.plugin.appbrand.appcache.bg.aXp();
    f.bV(str1, paramInt);
    int i = j.aVC().aR(str1, paramInt);
    paramString2 = new gr();
    paramString2.ecJ = 1L;
    paramString2 = paramString2.oc(str1);
    paramString2.ecK = paramInt;
    paramString2.ecL = i;
    paramString2.ecH = 1L;
    paramString2.aHZ();
    j.aVI().clear(str1);
    j.aVJ();
    bk.clear(str1);
    if (paramInt == 0) {
      ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).zB(str1);
    }
    boolean bool1 = j.aVC().aM(str1, 0);
    boolean bool2 = j.aVC().aM(str1, 2);
    boolean bool3 = j.aVC().aM(str1, 1);
    boolean bool4 = ((u)j.T(u.class)).aZ(paramString1, paramInt);
    ac.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", new Object[] { paramString1, str1, Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    if ((!bool1) && (!bool2) && (!bool3))
    {
      Object localObject = j.aVu().d(paramString1, new String[] { "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL" });
      if (localObject != null)
      {
        paramString2 = ((WxaAttributes)localObject).field_smallHeadURL;
        String str2 = ((WxaAttributes)localObject).field_bigHeadURL;
        String str3 = ((WxaAttributes)localObject).field_brandIconURL;
        localObject = ((WxaAttributes)localObject).field_roundedSquareIconURL;
        i = 0;
        while (i < 4)
        {
          String str4 = new String[] { paramString2, str2, str3, localObject }[i];
          com.tencent.mm.modelappbrand.a.b.aAS().zx(str4);
          com.tencent.mm.modelappbrand.a.b.aAS().zy(str4);
          i += 1;
        }
      }
      if (bool4) {
        com.tencent.mm.plugin.appbrand.config.u.Ko(paramString1);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).Rl(str1);
      label456:
      j.CJ().IF(str1);
      ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).ch(str1).IF(str1);
      AppBrandStickyBannerLogic.b.bvY();
      j.CK().JQ(str1);
      j.aVv().zB(str1);
      l.JQ(str1);
      JsApiOperateWXData.clear(str1);
      paramString1 = p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ji(str1));
      try
      {
        ar.cZ(paramString1, str1).aYb();
      }
      catch (Exception paramString2)
      {
        try
        {
          ar.da(paramString1, str1).aYb();
        }
        catch (Exception paramString2)
        {
          try
          {
            ar.db(paramString1, str1).aYb();
          }
          catch (Exception paramString2)
          {
            try
            {
              for (;;)
              {
                ar.dc(paramString1, str1).aYb();
                AppBrandLocalMediaObjectManager.clear(str1);
                if (j.a.on(paramInt))
                {
                  ((t)j.T(t.class)).s(str1, paramInt, "{}");
                  ((com.tencent.mm.plugin.appbrand.appcache.d)j.T(com.tencent.mm.plugin.appbrand.appcache.d.class)).aF(str1, paramInt);
                }
                paramString1 = com.tencent.mm.plugin.appbrand.page.bg.lFc;
                paramString1 = new com.tencent.mm.vfs.e(bg.a.Bq());
                if ((!paramString1.exists()) || (!paramString1.isDirectory())) {
                  break label842;
                }
                paramString1 = paramString1.fxX();
                int j = paramString1.length;
                i = 0;
                for (;;)
                {
                  if (i >= j) {
                    break label842;
                  }
                  paramString2 = paramString1[i];
                  if (paramString2.getName().startsWith(str1))
                  {
                    if (!paramString2.isFile()) {
                      break;
                    }
                    paramString2.delete();
                  }
                  i += 1;
                }
                j.aVu().Ke(paramString1);
                break;
                ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).cc(str1, paramInt);
                break label456;
                paramString2 = paramString2;
                ac.e("MicroMsg.AppBrand.RemoveUsageTask", "clean NonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                paramString2 = paramString2;
                ac.e("MicroMsg.AppBrand.RemoveUsageTask", "clean OpenDataNonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                paramString2 = paramString2;
                ac.e("MicroMsg.AppBrand.RemoveUsageTask", "clean ClientDataFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
              }
            }
            catch (Exception paramString1)
            {
              for (;;)
              {
                ac.e("MicroMsg.AppBrand.RemoveUsageTask", "clean SinglePageNotFlatten appId=%s e=%s", new Object[] { str1, paramString1 });
                continue;
                com.tencent.mm.vfs.i.cU(q.B(paramString2.fxV()), true);
              }
              label842:
              com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.bO(str1, paramInt);
              ((com.tencent.mm.plugin.appbrand.appcache.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.class)).HN(str1);
              AppMethodBeat.o(44654);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.an
 * JD-Core Version:    0.7.0.1
 */