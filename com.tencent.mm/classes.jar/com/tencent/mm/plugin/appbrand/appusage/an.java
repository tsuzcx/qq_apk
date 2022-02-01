package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.f.b.a.op;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bo;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appcache.bw;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.launching.ah;
import com.tencent.mm.plugin.appbrand.launching.ai;
import com.tencent.mm.plugin.appbrand.launching.s;
import com.tencent.mm.plugin.appbrand.m.ae;
import com.tencent.mm.plugin.appbrand.page.bl;
import com.tencent.mm.plugin.appbrand.page.bl.a;
import com.tencent.mm.plugin.appbrand.task.a.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;

public enum an
{
  public static void w(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(44652);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44649);
        if (!com.tencent.mm.kernel.h.aHE().aGM())
        {
          AppMethodBeat.o(44649);
          return;
        }
        an.z(this.iXG, paramString2, paramInt);
        AppMethodBeat.o(44649);
      }
    }, "MicroMsg.AppBrand.RemoveUsageTask");
    AppMethodBeat.o(44652);
  }
  
  public static void x(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44653);
    y(paramString1, paramString2, paramInt);
    AppMethodBeat.o(44653);
  }
  
  private static void y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44654);
    Log.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    com.tencent.mm.plugin.appbrand.app.m.bFN().bI(paramString1, paramInt);
    ((k)com.tencent.mm.plugin.appbrand.app.m.W(k.class)).aeg(paramString1);
    com.tencent.mm.plugin.appbrand.app.m.bFZ().ho(paramString1);
    String str1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str1 = y.afi(paramString1);
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    bo.bHG();
    com.tencent.mm.plugin.appbrand.task.i.cjb().u(str1, paramInt);
    int i = com.tencent.mm.plugin.appbrand.app.m.bFP().br(str1, paramInt);
    paramString2 = new op();
    paramString2.hci = 1L;
    paramString2 = paramString2.FF(str1);
    paramString2.hcj = paramInt;
    paramString2.hck = i;
    paramString2.hcg = 1L;
    paramString2.bpa();
    com.tencent.mm.plugin.appbrand.app.m.bFW().clear(str1);
    com.tencent.mm.plugin.appbrand.app.m.bFX();
    bt.clear(str1);
    if (paramInt == 0) {
      ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)com.tencent.mm.plugin.appbrand.app.m.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class)).ho(str1);
    }
    boolean bool1 = com.tencent.mm.plugin.appbrand.app.m.bFP().bn(str1, 0);
    boolean bool2 = com.tencent.mm.plugin.appbrand.app.m.bFP().bn(str1, 2);
    boolean bool3 = com.tencent.mm.plugin.appbrand.app.m.bFP().bn(str1, 1);
    boolean bool4 = ((u)com.tencent.mm.plugin.appbrand.app.m.W(u.class)).bC(paramString1, paramInt);
    Log.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", new Object[] { paramString1, str1, Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    String str2;
    if ((!bool1) && (!bool2) && (!bool3))
    {
      Object localObject = com.tencent.mm.plugin.appbrand.app.m.bFF().c(paramString1, new String[] { "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL" });
      if (localObject != null)
      {
        paramString2 = ((WxaAttributes)localObject).field_smallHeadURL;
        str2 = ((WxaAttributes)localObject).field_bigHeadURL;
        String str3 = ((WxaAttributes)localObject).field_brandIconURL;
        localObject = ((WxaAttributes)localObject).field_roundedSquareIconURL;
        i = 0;
        while (i < 4)
        {
          String str4 = new String[] { paramString2, str2, str3, localObject }[i];
          com.tencent.mm.modelappbrand.a.b.bhh().Tb(str4);
          com.tencent.mm.modelappbrand.a.b.bhh().Tc(str4);
          i += 1;
        }
      }
      if (bool4) {
        y.afl(paramString1);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ui.c.a.b)com.tencent.mm.plugin.appbrand.app.m.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).ana(str1);
      ((v)com.tencent.mm.plugin.appbrand.app.m.W(v.class)).afc(paramString1);
      label487:
      com.tencent.mm.plugin.appbrand.app.m.QF().adu(str1);
      ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.K(com.tencent.luggage.sdk.customize.a.class)).dX(str1).adu(str1);
      AppBrandStickyBannerLogic.b.cL(str1, paramInt);
      com.tencent.mm.plugin.appbrand.app.m.QG().dU(str1);
      com.tencent.mm.plugin.appbrand.app.m.bFG().ho(str1);
      com.tencent.mm.plugin.appbrand.config.m.dU(str1);
      com.tencent.mm.plugin.appbrand.app.m.bFK().ho(str1);
      JsApiOperateWXData.clear(str1);
      paramString2 = p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).aee(str1));
      try
      {
        av.dB(paramString2, str1).bIE();
      }
      catch (Exception localException3)
      {
        try
        {
          av.dC(paramString2, str1).bIE();
        }
        catch (Exception localException3)
        {
          try
          {
            av.dD(paramString2, str1).bIE();
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                av.dE(paramString2, str1).bIE();
                AppBrandLocalMediaObjectManager.clear(str1);
                paramString2 = AppBrandStorageQuotaManager.nMv;
                AppBrandStorageQuotaManager.adG(str1);
                if (j.a.vB(paramInt))
                {
                  ((s)com.tencent.mm.plugin.appbrand.app.m.W(s.class)).B(str1, paramInt, "{}");
                  ((com.tencent.mm.plugin.appbrand.appcache.d)com.tencent.mm.plugin.appbrand.app.m.W(com.tencent.mm.plugin.appbrand.appcache.d.class)).bf(str1, paramInt);
                }
                paramString2 = bl.qvp;
                paramString2 = new q(bl.a.Pg());
                if ((!paramString2.ifE()) || (!paramString2.isDirectory())) {
                  break label922;
                }
                paramString2 = paramString2.ifJ();
                int j = paramString2.length;
                i = 0;
                for (;;)
                {
                  if (i >= j) {
                    break label922;
                  }
                  str2 = paramString2[i];
                  if (str2.getName().startsWith(str1))
                  {
                    if (!str2.ifH()) {
                      break;
                    }
                    str2.cFq();
                  }
                  i += 1;
                }
                com.tencent.mm.plugin.appbrand.app.m.bFF().afc(paramString1);
                break;
                ((com.tencent.mm.plugin.appbrand.ui.c.a.b)com.tencent.mm.plugin.appbrand.app.m.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).cN(str1, paramInt);
                if (bool1) {
                  break label487;
                }
                ((v)com.tencent.mm.plugin.appbrand.app.m.W(v.class)).afc(paramString1);
                break label487;
                localException1 = localException1;
                Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean NonFlatten appId=%s e=%s", new Object[] { str1, localException1 });
                continue;
                localException2 = localException2;
                Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean OpenDataNonFlatten appId=%s e=%s", new Object[] { str1, localException2 });
                continue;
                localException3 = localException3;
                Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean ClientDataFlatten appId=%s e=%s", new Object[] { str1, localException3 });
              }
            }
            catch (Exception paramString2)
            {
              for (;;)
              {
                Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean SinglePageNotFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                com.tencent.mm.vfs.u.dK(localException3.bOF(), true);
              }
              label922:
              com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.cB(str1, paramInt);
              ae.dU(str1);
              ((com.tencent.mm.plugin.appbrand.appcache.b)com.tencent.mm.plugin.appbrand.app.m.W(com.tencent.mm.plugin.appbrand.appcache.b.class)).acy(str1);
              ((bw)com.tencent.mm.kernel.h.ae(bw.class)).acJ(str1);
              ah.ep(paramString1, str1);
              ah.es(paramString1, str1);
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