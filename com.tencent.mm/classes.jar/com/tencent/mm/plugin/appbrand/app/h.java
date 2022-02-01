package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.List;

class h
  implements com.tencent.mm.plugin.appbrand.service.i
{
  public com.tencent.mm.vending.g.e<Integer> DF(final String paramString)
  {
    AppMethodBeat.i(44171);
    paramString = com.tencent.mm.co.g.fkM().b(new com.tencent.mm.vending.c.a()
    {
      private Integer aOv()
      {
        AppMethodBeat.i(44166);
        if (!com.tencent.mm.kernel.g.afz().aeI())
        {
          com.tencent.mm.vending.g.g.fhl().ea(new com.tencent.mm.model.b());
          AppMethodBeat.o(44166);
          return null;
        }
        AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.IR(paramString);
        final com.tencent.mm.vending.g.b localb = com.tencent.mm.vending.g.g.fhr();
        com.tencent.mm.kernel.g.afA().gcy.a(1345, new com.tencent.mm.al.g()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(44165);
            if (c.b(paramAnonymous2n, h.1.this.val$appId))
            {
              com.tencent.mm.kernel.g.afA().gcy.b(1345, this);
              try
              {
                localb.D(new Object[] { Integer.valueOf(c.f(paramAnonymous2n)) });
                AppMethodBeat.o(44165);
                return;
              }
              catch (Exception paramAnonymous2String)
              {
                localb.ea(paramAnonymous2String);
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
  
  public void DG(String paramString)
  {
    AppMethodBeat.i(44172);
    com.tencent.mm.plugin.appbrand.task.f.e(com.tencent.mm.plugin.appbrand.task.e.lwx);
    AppMethodBeat.o(44172);
  }
  
  public void a(int paramInt, String paramString, Object paramObject) {}
  
  public final int aOu()
  {
    AppMethodBeat.i(44175);
    ICommLibReader localICommLibReader2 = ar.aPR();
    ICommLibReader localICommLibReader1 = localICommLibReader2;
    if (localICommLibReader2 == null) {}
    try
    {
      aq.aPQ();
      localICommLibReader1 = ar.aPR();
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
    int i = localb.aPc();
    AppMethodBeat.o(44175);
    return i;
  }
  
  public void aT(List<String> paramList)
  {
    AppMethodBeat.i(44174);
    w.c(paramList, n.a.jel).a(new h.2(this));
    AppMethodBeat.o(44174);
  }
  
  public void bS(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(44176);
    if (TextUtils.isEmpty(paramString1))
    {
      ad.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage invalid uuid");
      AppMethodBeat.o(44176);
      return;
    }
    com.tencent.mm.co.g.fkM().h(new com.tencent.mm.vending.c.a()
    {
      private Void aOw()
      {
        AppMethodBeat.i(195604);
        com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.Kw(paramString1).auK();
        try
        {
          Object localObject3 = new com.tencent.mm.ac.i(paramString2);
          Object localObject2 = new com.tencent.mm.ac.i(((com.tencent.mm.ac.i)localObject3).optString("invokeData"));
          localObject1 = ((com.tencent.mm.ac.i)localObject2).optString("miniprogramAppID");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            ad.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, invalid miniprogramAppId");
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.Kv(paramString1).auK();
            localObject1 = HPQ;
            AppMethodBeat.o(195604);
            return localObject1;
          }
          Object localObject4 = ((com.tencent.mm.ac.i)localObject2).optString("name");
          String str = ((com.tencent.mm.ac.i)localObject3).optString("runtimeAppid");
          localObject3 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject3).scene = 1111;
          ((AppBrandStatObject)localObject3).dbt = (str + ":" + (String)localObject4);
          localObject4 = new AppBrandLaunchReferrer();
          ((AppBrandLaunchReferrer)localObject4).jdC = 7;
          ((AppBrandLaunchReferrer)localObject4).appId = null;
          ((AppBrandLaunchReferrer)localObject4).jdF = ((com.tencent.mm.ac.i)localObject2).toString();
          localObject2 = new LaunchParcel();
          ((LaunchParcel)localObject2).appId = ((String)localObject1);
          ((LaunchParcel)localObject2).iJb = "__wx__/open-api-redirecting-page";
          ((LaunchParcel)localObject2).kOh = ((AppBrandStatObject)localObject3);
          ((LaunchParcel)localObject2).cfi = ((AppBrandLaunchReferrer)localObject4);
          ((LaunchParcel)localObject2).kOk = new com.tencent.luggage.sdk.launching.a() {};
          com.tencent.mm.plugin.appbrand.launching.e.f.kOI.a(aj.getContext(), (LaunchParcel)localObject2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1;
            ad.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, parse failed e = %s, uuid = %s, json = %s", new Object[] { localException, paramString1, paramString2 });
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.Kv(paramString1).auK();
          }
        }
        localObject1 = HPQ;
        AppMethodBeat.o(195604);
        return localObject1;
      }
    }).fhm();
    AppMethodBeat.o(44176);
  }
  
  public void o(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44173);
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.jRv = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.jRw = paramInt;
    com.tencent.mm.plugin.appbrand.ipc.e.b(paramString1, localSendDataToMiniProgramFromH5Event);
    AppMethodBeat.o(44173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h
 * JD-Core Version:    0.7.0.1
 */