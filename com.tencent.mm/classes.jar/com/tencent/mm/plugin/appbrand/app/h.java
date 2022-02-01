package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vending.g.d.b;
import java.util.List;

class h
  implements com.tencent.mm.plugin.appbrand.service.i
{
  public com.tencent.mm.vending.g.e<Integer> Lb(final String paramString)
  {
    AppMethodBeat.i(44171);
    paramString = com.tencent.mm.cn.g.fSm().b(new com.tencent.mm.vending.c.a()
    {
      private Integer aYI()
      {
        AppMethodBeat.i(44166);
        if (!com.tencent.mm.kernel.g.ajA().aiK())
        {
          com.tencent.mm.vending.g.g.fOa().ee(new com.tencent.mm.model.b());
          AppMethodBeat.o(44166);
          return null;
        }
        AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.Qp(paramString);
        final com.tencent.mm.vending.g.b localb = com.tencent.mm.vending.g.g.fOg();
        com.tencent.mm.kernel.g.ajB().gAO.a(1345, new com.tencent.mm.al.f()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(44165);
            if (c.b(paramAnonymous2n, h.1.this.val$appId))
            {
              com.tencent.mm.kernel.g.ajB().gAO.b(1345, this);
              try
              {
                localb.G(new Object[] { Integer.valueOf(c.e(paramAnonymous2n)) });
                AppMethodBeat.o(44165);
                return;
              }
              catch (Exception paramAnonymous2String)
              {
                localb.ee(paramAnonymous2String);
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
  
  public void Lc(String paramString)
  {
    AppMethodBeat.i(44172);
    com.tencent.mm.plugin.appbrand.task.f.f(com.tencent.mm.plugin.appbrand.task.e.myg);
    AppMethodBeat.o(44172);
  }
  
  public void a(int paramInt, String paramString, Object paramObject) {}
  
  public void aS(List<String> paramList)
  {
    AppMethodBeat.i(44174);
    x.a(paramList, n.a.jYB, null).a(new d.b() {});
    AppMethodBeat.o(44174);
  }
  
  public final int aYH()
  {
    AppMethodBeat.i(44175);
    ICommLibReader localICommLibReader2 = as.bag();
    ICommLibReader localICommLibReader1 = localICommLibReader2;
    if (localICommLibReader2 == null) {}
    try
    {
      ar.baf();
      localICommLibReader1 = as.bag();
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
    int i = localb.aZp();
    AppMethodBeat.o(44175);
    return i;
  }
  
  public void cd(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(44176);
    if (TextUtils.isEmpty(paramString1))
    {
      ad.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage invalid uuid");
      AppMethodBeat.o(44176);
      return;
    }
    com.tencent.mm.cn.g.fSm().h(new com.tencent.mm.vending.c.a()
    {
      private Void aYJ()
      {
        AppMethodBeat.i(187992);
        com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.Sc(paramString1).aED();
        try
        {
          Object localObject3 = new com.tencent.mm.ac.i(paramString2);
          Object localObject2 = new com.tencent.mm.ac.i(((com.tencent.mm.ac.i)localObject3).optString("invokeData"));
          localObject1 = ((com.tencent.mm.ac.i)localObject2).optString("miniprogramAppID");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            ad.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, invalid miniprogramAppId");
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.Sb(paramString1).aED();
            localObject1 = LhQ;
            AppMethodBeat.o(187992);
            return localObject1;
          }
          Object localObject4 = ((com.tencent.mm.ac.i)localObject2).optString("name");
          String str = ((com.tencent.mm.ac.i)localObject3).optString("runtimeAppid");
          localObject3 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject3).scene = 1111;
          ((AppBrandStatObject)localObject3).dkh = (str + ":" + (String)localObject4);
          localObject4 = new AppBrandLaunchReferrer();
          ((AppBrandLaunchReferrer)localObject4).jXR = 7;
          ((AppBrandLaunchReferrer)localObject4).appId = null;
          ((AppBrandLaunchReferrer)localObject4).jXU = ((com.tencent.mm.ac.i)localObject2).toString();
          localObject2 = new LaunchParcel();
          ((LaunchParcel)localObject2).appId = ((String)localObject1);
          ((LaunchParcel)localObject2).jCN = "__wx__/open-api-redirecting-page";
          ((LaunchParcel)localObject2).lMZ = ((AppBrandStatObject)localObject3);
          ((LaunchParcel)localObject2).cmv = ((AppBrandLaunchReferrer)localObject4);
          ((LaunchParcel)localObject2).lNc = new com.tencent.luggage.sdk.launching.a() {};
          com.tencent.mm.plugin.appbrand.launching.e.f.lNC.a(aj.getContext(), (LaunchParcel)localObject2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1;
            ad.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, parse failed e = %s, uuid = %s, json = %s", new Object[] { localException, paramString1, paramString2 });
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.Sb(paramString1).aED();
          }
        }
        localObject1 = LhQ;
        AppMethodBeat.o(187992);
        return localObject1;
      }
    }).fOb();
    AppMethodBeat.o(44176);
  }
  
  public void q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44173);
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.kND = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.kNE = paramInt;
    com.tencent.mm.plugin.appbrand.ipc.e.b(paramString1, localSendDataToMiniProgramFromH5Event);
    AppMethodBeat.o(44173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h
 * JD-Core Version:    0.7.0.1
 */