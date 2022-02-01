package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.ag;
import com.tencent.mm.plugin.appbrand.config.q.a;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.c.a;
import java.util.List;

class l
  implements k
{
  public com.tencent.mm.vending.g.e<Integer> UU(final String paramString)
  {
    AppMethodBeat.i(44171);
    paramString = com.tencent.mm.cp.g.jPX().b(new a()
    {
      private Integer ceV()
      {
        AppMethodBeat.i(44166);
        if (!com.tencent.mm.kernel.h.baC().aZN())
        {
          com.tencent.mm.vending.g.g.jJL().gM(new com.tencent.mm.model.b());
          AppMethodBeat.o(44166);
          return null;
        }
        AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.abp(paramString);
        final com.tencent.mm.vending.g.b localb = com.tencent.mm.vending.g.g.jJV();
        com.tencent.mm.kernel.h.baD().mCm.a(1345, new com.tencent.mm.am.h()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
          {
            AppMethodBeat.i(44165);
            if (com.tencent.mm.plugin.appbrand.jsapi.op_report.c.b(paramAnonymous2p, l.1.this.etl))
            {
              com.tencent.mm.kernel.h.baD().mCm.b(1345, this);
              try
              {
                localb.K(new Object[] { Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.op_report.c.e(paramAnonymous2p)) });
                AppMethodBeat.o(44165);
                return;
              }
              catch (Exception paramAnonymous2String)
              {
                localb.gM(paramAnonymous2String);
              }
            }
            AppMethodBeat.o(44165);
          }
        });
        AppMethodBeat.o(44166);
        return null;
      }
    });
    AppMethodBeat.o(44171);
    return paramString;
  }
  
  public void UV(String paramString)
  {
    AppMethodBeat.i(44172);
    com.tencent.mm.plugin.appbrand.task.i.cJV().a(LuggageServiceType.euv, ab.tTO);
    AppMethodBeat.o(44172);
  }
  
  public void a(int paramInt, String paramString, Object paramObject) {}
  
  public void cG(List<String> paramList)
  {
    AppMethodBeat.i(44174);
    ag.a(paramList, q.a.qZs, null).a(new l.2(this));
    AppMethodBeat.o(44174);
  }
  
  public void cN(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(44176);
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage invalid uuid");
      AppMethodBeat.o(44176);
      return;
    }
    com.tencent.mm.cp.g.jPX().h(new a()
    {
      private Void ceW()
      {
        AppMethodBeat.i(317736);
        com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.adt(paramString1).bFJ();
        try
        {
          Object localObject3 = new com.tencent.mm.ad.i(paramString2);
          Object localObject2 = new com.tencent.mm.ad.i(((com.tencent.mm.ad.i)localObject3).optString("invokeData"));
          localObject1 = ((com.tencent.mm.ad.i)localObject2).optString("miniprogramAppID");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, invalid miniprogramAppId");
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.ads(paramString1).bFJ();
            localObject1 = aguz;
            AppMethodBeat.o(317736);
            return localObject1;
          }
          String str1 = ((com.tencent.mm.ad.i)localObject2).optString("path", "__wx__/open-api-redirecting-page");
          Object localObject4 = ((com.tencent.mm.ad.i)localObject2).optString("name");
          String str2 = ((com.tencent.mm.ad.i)localObject3).optString("runtimeAppid");
          localObject3 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject3).scene = 1111;
          ((AppBrandStatObject)localObject3).hzx = (str2 + ":" + (String)localObject4);
          localObject4 = new AppBrandLaunchReferrer();
          ((AppBrandLaunchReferrer)localObject4).qYE = 7;
          ((AppBrandLaunchReferrer)localObject4).appId = null;
          ((AppBrandLaunchReferrer)localObject4).qYH = ((com.tencent.mm.ad.i)localObject2).toString();
          localObject2 = new LaunchParcel();
          ((LaunchParcel)localObject2).appId = ((String)localObject1);
          ((LaunchParcel)localObject2).qAF = str1;
          ((LaunchParcel)localObject2).siB = ((AppBrandStatObject)localObject3);
          ((LaunchParcel)localObject2).eoV = ((AppBrandLaunchReferrer)localObject4);
          ((LaunchParcel)localObject2).tdY = new com.tencent.luggage.sdk.launching.b() {};
          com.tencent.mm.plugin.appbrand.launching.precondition.f.teH.a(MMApplicationContext.getContext(), (LaunchParcel)localObject2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1;
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, parse failed e = %s, uuid = %s, json = %s", new Object[] { localException, paramString1, paramString2 });
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.ads(paramString1).bFJ();
          }
        }
        localObject1 = aguz;
        AppMethodBeat.o(317736);
        return localObject1;
      }
    }).jJM();
    AppMethodBeat.o(44176);
  }
  
  public final int ceU()
  {
    AppMethodBeat.i(44175);
    if ((!com.tencent.mm.kernel.h.baC().mBZ) || (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.api.e.class) == null))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.ServiceForWebView", "getWxaCommLibVersion, invalid account status, stack:%s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(44175);
      return -1;
    }
    ICommLibReader localICommLibReader2 = av.cgx();
    ICommLibReader localICommLibReader1 = localICommLibReader2;
    if (localICommLibReader2 == null) {}
    try
    {
      au.cgw();
      localICommLibReader1 = av.cgx();
      if (localICommLibReader1 == null)
      {
        AppMethodBeat.o(44175);
        return -1;
      }
    }
    catch (com.tencent.mm.model.b localb)
    {
      AppMethodBeat.o(44175);
      return -1;
    }
    int i = localb.cfG();
    AppMethodBeat.o(44175);
    return i;
  }
  
  public void w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44173);
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.rZd = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.rZe = paramInt;
    com.tencent.mm.plugin.appbrand.ipc.f.b(paramString1, localSendDataToMiniProgramFromH5Event);
    AppMethodBeat.o(44173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.l
 * JD-Core Version:    0.7.0.1
 */