package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.hw;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.launching.aw;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.bf.a;
import com.tencent.mm.plugin.appbrand.task.a.c;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public enum an
{
  public static void u(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(44652);
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44649);
        if (!com.tencent.mm.kernel.g.ajP().aiZ())
        {
          AppMethodBeat.o(44649);
          return;
        }
        an.x(this.fOj, paramString2, paramInt);
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
    ae.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    j.aZs().bk(paramString1, paramInt);
    ((k)j.T(k.class)).Nm(paramString1);
    j.aZD().Dc(paramString1);
    String str1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str1 = v.Om(paramString1);
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    bi.bbm();
    f.cc(str1, paramInt);
    int i = j.aZu().aW(str1, paramInt);
    paramString2 = new hw();
    paramString2.euV = 1L;
    paramString2 = paramString2.qW(str1);
    paramString2.euW = paramInt;
    paramString2.euX = i;
    paramString2.euT = 1L;
    paramString2.aLH();
    j.aZA().clear(str1);
    j.aZB();
    bm.clear(str1);
    if (paramInt == 0) {
      ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).Dc(str1);
    }
    boolean bool1 = j.aZu().aR(str1, 0);
    boolean bool2 = j.aZu().aR(str1, 2);
    boolean bool3 = j.aZu().aR(str1, 1);
    boolean bool4 = ((u)j.T(u.class)).be(paramString1, paramInt);
    ae.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", new Object[] { paramString1, str1, Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    if ((!bool1) && (!bool2) && (!bool3))
    {
      Object localObject = j.aZl().d(paramString1, new String[] { "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL" });
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
          com.tencent.mm.modelappbrand.a.b.aEl().CY(str4);
          com.tencent.mm.modelappbrand.a.b.aEl().CZ(str4);
          i += 1;
        }
      }
      if (bool4) {
        v.Op(paramString1);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).VC(str1);
      ((s)j.T(s.class)).Of(paramString1);
      label484:
      j.El().MA(str1);
      ((com.tencent.luggage.sdk.customize.a)e.K(com.tencent.luggage.sdk.customize.a.class)).dl(str1).MA(str1);
      AppBrandStickyBannerLogic.b.bAZ();
      j.Em().NQ(str1);
      j.aZm().Dc(str1);
      l.NQ(str1);
      j.aZp().Dc(str1);
      JsApiOperateWXData.clear(str1);
      paramString1 = p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ng(str1));
      try
      {
        at.dd(paramString1, str1).bcb();
      }
      catch (Exception paramString2)
      {
        try
        {
          at.de(paramString1, str1).bcb();
        }
        catch (Exception paramString2)
        {
          try
          {
            at.dg(paramString1, str1).bcb();
          }
          catch (Exception paramString2)
          {
            try
            {
              for (;;)
              {
                at.dh(paramString1, str1).bcb();
                AppBrandLocalMediaObjectManager.clear(str1);
                if (j.a.oQ(paramInt))
                {
                  ((t)j.T(t.class)).v(str1, paramInt, "{}");
                  ((com.tencent.mm.plugin.appbrand.appcache.d)j.T(com.tencent.mm.plugin.appbrand.appcache.d.class)).aI(str1, paramInt);
                }
                paramString1 = bf.mja;
                paramString1 = new com.tencent.mm.vfs.k(bf.a.CS());
                if ((!paramString1.exists()) || (!paramString1.isDirectory())) {
                  break label899;
                }
                paramString1 = paramString1.fTj();
                int j = paramString1.length;
                i = 0;
                for (;;)
                {
                  if (i >= j) {
                    break label899;
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
                j.aZl().Of(paramString1);
                break;
                ((com.tencent.mm.plugin.appbrand.ui.c.a.b)j.T(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).cj(str1, paramInt);
                if (bool1) {
                  break label484;
                }
                ((s)j.T(s.class)).Of(paramString1);
                break label484;
                paramString2 = paramString2;
                ae.e("MicroMsg.AppBrand.RemoveUsageTask", "clean NonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                paramString2 = paramString2;
                ae.e("MicroMsg.AppBrand.RemoveUsageTask", "clean OpenDataNonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                paramString2 = paramString2;
                ae.e("MicroMsg.AppBrand.RemoveUsageTask", "clean ClientDataFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
              }
            }
            catch (Exception paramString1)
            {
              for (;;)
              {
                ae.e("MicroMsg.AppBrand.RemoveUsageTask", "clean SinglePageNotFlatten appId=%s e=%s", new Object[] { str1, paramString1 });
                continue;
                o.dd(com.tencent.mm.vfs.w.B(paramString2.fTh()), true);
              }
              label899:
              com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.bV(str1, paramInt);
              ((com.tencent.mm.plugin.appbrand.appcache.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.class)).LF(str1);
              ((bp)com.tencent.mm.kernel.g.ab(bp.class)).LQ(str1);
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