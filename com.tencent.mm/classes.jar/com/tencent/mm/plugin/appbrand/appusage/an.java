package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.page.bg.a;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;

public enum an
{
  public static void u(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(44652);
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44649);
        if (!com.tencent.mm.kernel.g.ajA().aiK())
        {
          AppMethodBeat.o(44649);
          return;
        }
        an.x(this.fNr, paramString2, paramInt);
        AppMethodBeat.o(44649);
      }
    }, "MicroMsg.AppBrand.RemoveUsageTask");
    AppMethodBeat.o(44652);
  }
  
  public static void v(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44653);
    w(paramString1, paramString2, paramInt);
    AppMethodBeat.o(44653);
  }
  
  private static void w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44654);
    ad.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    j.aYV().bh(paramString1, paramInt);
    ((k)j.T(k.class)).MF(paramString1);
    j.aZg().CA(paramString1);
    String str1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str1 = v.NE(paramString1);
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    bh.baN();
    f.bY(str1, paramInt);
    int i = j.aYX().aT(str1, paramInt);
    paramString2 = new hu();
    paramString2.eto = 1L;
    paramString2 = paramString2.qB(str1);
    paramString2.etp = paramInt;
    paramString2.etq = i;
    paramString2.etm = 1L;
    paramString2.aLk();
    j.aZd().clear(str1);
    j.aZe();
    bl.clear(str1);
    if (paramInt == 0) {
      ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).CA(str1);
    }
    boolean bool1 = j.aYX().aO(str1, 0);
    boolean bool2 = j.aYX().aO(str1, 2);
    boolean bool3 = j.aYX().aO(str1, 1);
    boolean bool4 = ((u)j.T(u.class)).bb(paramString1, paramInt);
    ad.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", new Object[] { paramString1, str1, Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    if ((!bool1) && (!bool2) && (!bool3))
    {
      Object localObject = j.aYP().d(paramString1, new String[] { "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL" });
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
          com.tencent.mm.modelappbrand.a.b.aDV().Cw(str4);
          com.tencent.mm.modelappbrand.a.b.aDV().Cx(str4);
          i += 1;
        }
      }
      if (bool4) {
        v.NH(paramString1);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).UR(str1);
      ((s)j.T(s.class)).Nx(paramString1);
      label484:
      j.Ei().LW(str1);
      ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).dg(str1).LW(str1);
      AppBrandStickyBannerLogic.b.bAe();
      j.Ej().Nj(str1);
      j.aYQ().CA(str1);
      l.Nj(str1);
      JsApiOperateWXData.clear(str1);
      paramString1 = p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Mz(str1));
      try
      {
        ar.db(paramString1, str1).bbz();
      }
      catch (Exception paramString2)
      {
        try
        {
          ar.dc(paramString1, str1).bbz();
        }
        catch (Exception paramString2)
        {
          try
          {
            ar.dd(paramString1, str1).bbz();
          }
          catch (Exception paramString2)
          {
            try
            {
              for (;;)
              {
                ar.de(paramString1, str1).bbz();
                AppBrandLocalMediaObjectManager.clear(str1);
                if (j.a.oN(paramInt))
                {
                  ((t)j.T(t.class)).t(str1, paramInt, "{}");
                  ((com.tencent.mm.plugin.appbrand.appcache.d)j.T(com.tencent.mm.plugin.appbrand.appcache.d.class)).aH(str1, paramInt);
                }
                paramString1 = com.tencent.mm.plugin.appbrand.page.bg.meG;
                paramString1 = new com.tencent.mm.vfs.e(bg.a.CP());
                if ((!paramString1.exists()) || (!paramString1.isDirectory())) {
                  break label890;
                }
                paramString1 = paramString1.fOM();
                int j = paramString1.length;
                i = 0;
                for (;;)
                {
                  if (i >= j) {
                    break label890;
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
                j.aYP().Nx(paramString1);
                break;
                ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).cf(str1, paramInt);
                if (bool1) {
                  break label484;
                }
                ((s)j.T(s.class)).Nx(paramString1);
                break label484;
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
                com.tencent.mm.vfs.i.cZ(q.B(paramString2.fOK()), true);
              }
              label890:
              com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.bR(str1, paramInt);
              ((com.tencent.mm.plugin.appbrand.appcache.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.class)).Lf(str1);
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