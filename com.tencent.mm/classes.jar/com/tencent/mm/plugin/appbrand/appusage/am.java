package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.si;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bo;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appcache.bv;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.l;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager;
import com.tencent.mm.plugin.appbrand.backgroundfetch.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.AppBrandMonitoredBluetoothDeviceService;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.plugin.appbrand.launching.ai;
import com.tencent.mm.plugin.appbrand.launching.aj;
import com.tencent.mm.plugin.appbrand.n.ae;
import com.tencent.mm.plugin.appbrand.page.bl;
import com.tencent.mm.plugin.appbrand.page.bl.a;
import com.tencent.mm.plugin.appbrand.task.a.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Objects;

public enum am
{
  public static void C(String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(44652);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44649);
        if (!com.tencent.mm.kernel.h.baC().aZN())
        {
          AppMethodBeat.o(44649);
          return;
        }
        try
        {
          am.F(am.this, paramString2, paramInt);
          AppMethodBeat.o(44649);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrand.RemoveUsageTask", "doRemove username(%s), appId(%s), get exception:%s", new Object[] { am.this, paramString2, localException });
          AppMethodBeat.o(44649);
        }
      }
    }, "MicroMsg.AppBrand.RemoveUsageTask");
    AppMethodBeat.o(44652);
  }
  
  public static void D(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44653);
    E(paramString1, paramString2, paramInt);
    AppMethodBeat.o(44653);
  }
  
  private static void E(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44654);
    Log.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    n.cfk().ca(paramString1, paramInt);
    ((j)n.ag(j.class)).WJ(paramString1);
    n.cfw().iP(paramString1);
    String str1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str1 = ad.XJ(paramString1);
    }
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(44654);
      return;
    }
    Objects.requireNonNull(str1);
    bo.chc();
    com.tencent.mm.plugin.appbrand.task.i.cJV().d(str1, paramInt, true);
    int i = n.cfm().bI(str1, paramInt);
    paramString2 = new si();
    paramString2.jxW = 1L;
    paramString2 = paramString2.yW(str1);
    paramString2.jxX = paramInt;
    paramString2.jxY = i;
    paramString2.jxU = 1L;
    paramString2.bMH();
    n.cft().clear(str1);
    n.cfu();
    bt.clear(str1);
    if (paramInt == 0)
    {
      ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)n.ag(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class)).iP(str1);
      ((aa)n.ag(aa.class)).cq(str1, 2147483647);
    }
    boolean bool1 = n.cfm().bE(str1, 0);
    boolean bool2 = n.cfm().bE(str1, 2);
    boolean bool3 = n.cfm().bE(str1, 1);
    boolean bool4 = ((t)n.ag(t.class)).bU(paramString1, paramInt);
    Log.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", new Object[] { paramString1, str1, Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    Object localObject1;
    String str2;
    if ((!bool1) && (!bool2) && (!bool3))
    {
      Object localObject2 = n.cfc().d(paramString1, new String[] { "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL" });
      if (localObject2 != null)
      {
        paramString2 = ((WxaAttributes)localObject2).field_smallHeadURL;
        localObject1 = ((WxaAttributes)localObject2).field_bigHeadURL;
        str2 = ((WxaAttributes)localObject2).field_brandIconURL;
        localObject2 = ((WxaAttributes)localObject2).field_roundedSquareIconURL;
        i = 0;
        while (i < 4)
        {
          String str3 = new String[] { paramString2, localObject1, str2, localObject2 }[i];
          com.tencent.mm.modelappbrand.a.b.bEY().Ld(str3);
          com.tencent.mm.modelappbrand.a.b.bEY().Le(str3);
          i += 1;
        }
      }
      if (bool4) {
        ad.XM(paramString1);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ui.b.a.b)n.ag(com.tencent.mm.plugin.appbrand.ui.b.a.b.class)).agq(str1);
      ((aa)n.ag(aa.class)).XD(paramString1);
      label509:
      ((com.tencent.luggage.sdk.customize.a)com.tencent.luggage.a.e.T(com.tencent.luggage.sdk.customize.a.class)).fn(str1);
      AppBrandStickyBannerLogic.b.dl(str1, paramInt);
      n.aqS().fe(str1);
      n.cfd().iP(str1);
      o.fe(str1);
      n.cfh().iP(str1);
      JsApiOperateWXData.clear(str1);
      str2 = p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(str1));
      try
      {
        ax.dU(str2, str1).cij();
      }
      catch (Exception paramString2)
      {
        try
        {
          ax.dV(str2, str1).cij();
        }
        catch (Exception paramString2)
        {
          try
          {
            ax.dW(str2, str1).cij();
          }
          catch (Exception paramString2)
          {
            try
            {
              for (;;)
              {
                ax.dX(str2, str1).cij();
                AppBrandLocalMediaObjectManager.clear(str1);
                paramString2 = AppBrandStorageQuotaManager.qMt;
                AppBrandStorageQuotaManager.Wh(str1);
                if (k.a.vK(paramInt))
                {
                  ((com.tencent.mm.plugin.appbrand.launching.t)n.ag(com.tencent.mm.plugin.appbrand.launching.t.class)).D(str1, paramInt, "{}");
                  ((com.tencent.mm.plugin.appbrand.appcache.d)n.ag(com.tencent.mm.plugin.appbrand.appcache.d.class)).bw(str1, paramInt);
                }
                paramString2 = bl.tAb;
                paramString2 = new u(bl.a.apo());
                if ((!paramString2.jKS()) || (!paramString2.isDirectory())) {
                  break label946;
                }
                localObject1 = paramString2.jKX();
                paramString2 = (String)localObject1;
                if (localObject1 == null) {
                  paramString2 = new u[0];
                }
                int j = paramString2.length;
                i = 0;
                for (;;)
                {
                  if (i >= j) {
                    break label946;
                  }
                  localObject1 = paramString2[i];
                  if (((u)localObject1).getName().startsWith(str1))
                  {
                    if (!((u)localObject1).jKV()) {
                      break;
                    }
                    ((u)localObject1).diJ();
                  }
                  i += 1;
                }
                n.cfc().XD(paramString1);
                break;
                ((com.tencent.mm.plugin.appbrand.ui.b.a.b)n.ag(com.tencent.mm.plugin.appbrand.ui.b.a.b.class)).dp(str1, paramInt);
                if (bool1) {
                  break label509;
                }
                ((aa)n.ag(aa.class)).XD(paramString1);
                break label509;
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
            catch (Exception paramString2)
            {
              for (;;)
              {
                Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean SinglePageNotFlatten appId=%s e=%s", new Object[] { str1, paramString2 });
                continue;
                y.ew(ah.v(((u)localObject1).jKT()), true);
              }
              label946:
              com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.cZ(str1, paramInt);
              ae.fe(str1);
              ((com.tencent.mm.plugin.appbrand.appcache.b)n.ag(com.tencent.mm.plugin.appbrand.appcache.b.class)).UY(str1);
              ((bv)com.tencent.mm.kernel.h.ax(bv.class)).Vi(str1);
              ai.eH(paramString1, str1);
              ai.eK(paramString1, str1);
              ((l)n.ag(l.class)).VQ(str1);
              ((l)n.ag(l.class)).VR(paramString1);
              com.tencent.mm.plugin.appbrand.a.a.a.cK(str2, str1);
              paramString1 = AppBrandMonitoredBluetoothDeviceService.rgb;
              AppBrandMonitoredBluetoothDeviceService.cs(str1, paramInt);
              AppMethodBeat.o(44654);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.am
 * JD-Core Version:    0.7.0.1
 */