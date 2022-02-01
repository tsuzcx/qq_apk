package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lr;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.m.ae;
import com.tencent.mm.plugin.appbrand.page.bj;
import com.tencent.mm.plugin.appbrand.page.bj.a;
import com.tencent.mm.plugin.appbrand.task.a.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public enum an
{
  public static void t(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(44652);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44649);
        if (!com.tencent.mm.kernel.g.aAf().azp())
        {
          AppMethodBeat.o(44649);
          return;
        }
        an.w(this.gtu, paramString2, paramInt);
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
    Log.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    n.buJ().bp(paramString1, paramInt);
    ((k)n.W(k.class)).Wu(paramString1);
    n.buU().gC(paramString1);
    String str1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str1 = y.Xw(paramString1);
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    bi.bwz();
    com.tencent.mm.plugin.appbrand.task.h.bWb().cl(str1, paramInt);
    int i = n.buL().aZ(str1, paramInt);
    paramString2 = new lr();
    paramString2.eZr = 1L;
    paramString2 = paramString2.yZ(str1);
    paramString2.eZs = paramInt;
    paramString2.eZt = i;
    paramString2.eZp = 1L;
    paramString2.bfK();
    n.buR().clear(str1);
    n.buS();
    bm.clear(str1);
    if (paramInt == 0) {
      ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class)).gC(str1);
    }
    boolean bool1 = n.buL().aW(str1, 0);
    boolean bool2 = n.buL().aW(str1, 2);
    boolean bool3 = n.buL().aW(str1, 1);
    boolean bool4 = ((u)n.W(u.class)).bj(paramString1, paramInt);
    Log.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", new Object[] { paramString1, str1, Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    if ((!bool1) && (!bool2) && (!bool3))
    {
      Object localObject = n.buC().d(paramString1, new String[] { "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL" });
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
          com.tencent.mm.modelappbrand.a.b.aXY().LJ(str4);
          com.tencent.mm.modelappbrand.a.b.aXY().LK(str4);
          i += 1;
        }
      }
      if (bool4) {
        y.Xz(paramString1);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).afy(str1);
      ((v)n.W(v.class)).Xq(paramString1);
      label488:
      n.NK().VJ(str1);
      ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.M(com.tencent.luggage.sdk.customize.a.class)).dD(str1).VJ(str1);
      AppBrandStickyBannerLogic.b.cr(str1, paramInt);
      n.NL().WY(str1);
      n.buD().gC(str1);
      m.WY(str1);
      n.buG().gC(str1);
      JsApiOperateWXData.clear(str1);
      paramString1 = com.tencent.mm.b.p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Wp(str1));
      try
      {
        at.dt(paramString1, str1).bxq();
      }
      catch (Exception paramString2)
      {
        try
        {
          at.du(paramString1, str1).bxq();
        }
        catch (Exception paramString2)
        {
          try
          {
            at.dv(paramString1, str1).bxq();
          }
          catch (Exception paramString2)
          {
            try
            {
              for (;;)
              {
                at.dw(paramString1, str1).bxq();
                AppBrandLocalMediaObjectManager.clear(str1);
                if (j.a.sE(paramInt))
                {
                  ((t)n.W(t.class)).A(str1, paramInt, "{}");
                  ((com.tencent.mm.plugin.appbrand.appcache.d)n.W(com.tencent.mm.plugin.appbrand.appcache.d.class)).aN(str1, paramInt);
                }
                paramString1 = bj.ntu;
                paramString1 = new o(bj.a.Mo());
                if ((!paramString1.exists()) || (!paramString1.isDirectory())) {
                  break label905;
                }
                paramString1 = paramString1.het();
                int j = paramString1.length;
                i = 0;
                for (;;)
                {
                  if (i >= j) {
                    break label905;
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
                n.buC().Xq(paramString1);
                break;
                ((com.tencent.mm.plugin.appbrand.ui.c.a.b)n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).ct(str1, paramInt);
                if (bool1) {
                  break label488;
                }
                ((v)n.W(v.class)).Xq(paramString1);
                break label488;
                paramString2 = paramString2;
                Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean NonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                paramString2 = paramString2;
                Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean OpenDataNonFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                paramString2 = paramString2;
                Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean ClientDataFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
              }
            }
            catch (Exception paramString1)
            {
              for (;;)
              {
                Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean SinglePageNotFlatten appId=%s e=%s", new Object[] { str1, paramString1 });
                continue;
                s.dy(aa.z(paramString2.her()), true);
              }
              label905:
              com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.cd(str1, paramInt);
              ae.WY(str1);
              ((com.tencent.mm.plugin.appbrand.appcache.b)n.W(com.tencent.mm.plugin.appbrand.appcache.b.class)).UO(str1);
              ((bp)com.tencent.mm.kernel.g.af(bp.class)).UZ(str1);
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