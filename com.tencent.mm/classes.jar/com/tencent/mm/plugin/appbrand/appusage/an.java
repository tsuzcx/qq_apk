package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bg;
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
import com.tencent.mm.plugin.appbrand.page.bl;
import com.tencent.mm.plugin.appbrand.page.bl.a;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;

public enum an
{
  public static void s(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(44652);
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44649);
        an.v(this.fqK, paramString2, paramInt);
        AppMethodBeat.o(44649);
      }
    }, "MicroMsg.AppBrand.RemoveUsageTask");
    AppMethodBeat.o(44652);
  }
  
  public static void t(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44653);
    u(paramString1, paramString2, paramInt);
    AppMethodBeat.o(44653);
  }
  
  private static void u(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44654);
    ad.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    j.aOI().bb(paramString1, paramInt);
    j.aOT().vv(paramString1);
    String str1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str1 = com.tencent.mm.plugin.appbrand.config.u.Gh(paramString1);
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    bg.aQx();
    f.bQ(str1, paramInt);
    int i = j.aOK().aN(str1, paramInt);
    paramString2 = new ez();
    paramString2.eaD = 1L;
    paramString2 = paramString2.kX(str1);
    paramString2.eaE = paramInt;
    paramString2.eaF = i;
    paramString2.eaB = 1L;
    paramString2.aBj();
    j.aOQ().clear(str1);
    j.aOR();
    bk.clear(str1);
    if (paramInt == 0) {
      ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).vv(str1);
    }
    boolean bool1 = j.aOK().aI(str1, 0);
    boolean bool2 = j.aOK().aI(str1, 2);
    boolean bool3 = j.aOK().aI(str1, 1);
    boolean bool4 = ((u)j.T(u.class)).aV(paramString1, paramInt);
    ad.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", new Object[] { paramString1, str1, Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    if ((!bool1) && (!bool2) && (!bool3))
    {
      Object localObject = j.aOC().d(paramString1, new String[] { "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL" });
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
          com.tencent.mm.modelappbrand.a.b.aub().vr(str4);
          com.tencent.mm.modelappbrand.a.b.aub().vs(str4);
          i += 1;
        }
      }
      if (bool4) {
        com.tencent.mm.plugin.appbrand.config.u.Gk(paramString1);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).Nc(str1);
      label456:
      j.Dg().EC(str1);
      ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).cs(str1).EC(str1);
      AppBrandStickyBannerLogic.b.bpd();
      j.Dh().FM(str1);
      j.aOD().vv(str1);
      l.FM(str1);
      JsApiOperateWXData.clear(str1);
      paramString1 = p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ff(str1));
      try
      {
        ar.cO(paramString1, str1).aRg();
      }
      catch (Exception paramString2)
      {
        try
        {
          ar.cP(paramString1, str1).aRg();
        }
        catch (Exception paramString2)
        {
          try
          {
            ar.cQ(paramString1, str1).aRg();
          }
          catch (Exception paramString2)
          {
            try
            {
              for (;;)
              {
                ar.cR(paramString1, str1).aRg();
                AppBrandLocalMediaObjectManager.clear(str1);
                if (j.a.nz(paramInt))
                {
                  ((t)j.T(t.class)).s(str1, paramInt, "{}");
                  ((com.tencent.mm.plugin.appbrand.appcache.d)j.T(com.tencent.mm.plugin.appbrand.appcache.d.class)).aB(str1, paramInt);
                }
                paramString1 = bl.lfm;
                paramString1 = new com.tencent.mm.vfs.e(bl.a.BM());
                if ((!paramString1.exists()) || (!paramString1.isDirectory())) {
                  break label842;
                }
                paramString1 = paramString1.fhW();
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
                j.aOC().Ga(paramString1);
                break;
                ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).bX(str1, paramInt);
                break label456;
                paramString2 = paramString2;
                ad.e("MicroMsg.AppBrand.RemoveUsageTask", "clean NonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                paramString2 = paramString2;
                ad.e("MicroMsg.AppBrand.RemoveUsageTask", "clean OpenDataNonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                paramString2 = paramString2;
                ad.e("MicroMsg.AppBrand.RemoveUsageTask", "clean ClientDataFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
              }
            }
            catch (Exception paramString1)
            {
              for (;;)
              {
                ad.e("MicroMsg.AppBrand.RemoveUsageTask", "clean SinglePageNotFlatten appId=%s e=%s", new Object[] { str1, paramString1 });
                continue;
                com.tencent.mm.vfs.i.cO(q.B(paramString2.fhU()), true);
              }
              label842:
              com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.bK(str1, paramInt);
              ((com.tencent.mm.plugin.appbrand.appcache.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.class)).DJ(str1);
              AppMethodBeat.o(44654);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.an
 * JD-Core Version:    0.7.0.1
 */