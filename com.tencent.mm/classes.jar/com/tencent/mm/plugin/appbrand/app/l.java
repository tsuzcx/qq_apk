package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o.a;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.g.d.b;
import java.util.List;

class l
  implements j
{
  public com.tencent.mm.vending.g.e<Integer> UK(final String paramString)
  {
    AppMethodBeat.i(44171);
    paramString = com.tencent.mm.co.g.hio().b(new com.tencent.mm.vending.c.a()
    {
      private Integer buv()
      {
        AppMethodBeat.i(44166);
        if (!com.tencent.mm.kernel.g.aAf().azp())
        {
          com.tencent.mm.vending.g.g.hdx().ej(new com.tencent.mm.model.b());
          AppMethodBeat.o(44166);
          return null;
        }
        AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.aaA(paramString);
        final com.tencent.mm.vending.g.b localb = com.tencent.mm.vending.g.g.hdH();
        com.tencent.mm.kernel.g.aAg().hqi.a(1345, new com.tencent.mm.ak.i()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
          {
            AppMethodBeat.i(44165);
            if (c.b(paramAnonymous2q, l.1.this.val$appId))
            {
              com.tencent.mm.kernel.g.aAg().hqi.b(1345, this);
              try
              {
                localb.G(new Object[] { Integer.valueOf(c.e(paramAnonymous2q)) });
                AppMethodBeat.o(44165);
                return;
              }
              catch (Exception paramAnonymous2String)
              {
                localb.ej(paramAnonymous2String);
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
  
  public void UL(String paramString)
  {
    AppMethodBeat.i(44172);
    h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPD, z.nMF);
    AppMethodBeat.o(44172);
  }
  
  public void a(int paramInt, String paramString, Object paramObject) {}
  
  public void bc(List<String> paramList)
  {
    AppMethodBeat.i(44174);
    aa.a(paramList, o.a.leX, null).a(new d.b() {});
    AppMethodBeat.o(44174);
  }
  
  public final int buu()
  {
    AppMethodBeat.i(44175);
    ICommLibReader localICommLibReader2 = at.bvT();
    ICommLibReader localICommLibReader1 = localICommLibReader2;
    if (localICommLibReader2 == null) {}
    try
    {
      as.bvS();
      localICommLibReader1 = at.bvT();
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
    int i = localb.bvd();
    AppMethodBeat.o(44175);
    return i;
  }
  
  public void cr(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(44176);
    if (TextUtils.isEmpty(paramString1))
    {
      Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage invalid uuid");
      AppMethodBeat.o(44176);
      return;
    }
    com.tencent.mm.co.g.hio().h(new com.tencent.mm.vending.c.a()
    {
      private Void buw()
      {
        AppMethodBeat.i(226330);
        com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.act(paramString1).aYI();
        try
        {
          Object localObject3 = new com.tencent.mm.ab.i(paramString2);
          Object localObject2 = new com.tencent.mm.ab.i(((com.tencent.mm.ab.i)localObject3).optString("invokeData"));
          localObject1 = ((com.tencent.mm.ab.i)localObject2).optString("miniprogramAppID");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, invalid miniprogramAppId");
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.acs(paramString1).aYI();
            localObject1 = QZL;
            AppMethodBeat.o(226330);
            return localObject1;
          }
          String str1 = ((com.tencent.mm.ab.i)localObject2).optString("path", "__wx__/open-api-redirecting-page");
          Object localObject4 = ((com.tencent.mm.ab.i)localObject2).optString("name");
          String str2 = ((com.tencent.mm.ab.i)localObject3).optString("runtimeAppid");
          localObject3 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject3).scene = 1111;
          ((AppBrandStatObject)localObject3).dCw = (str2 + ":" + (String)localObject4);
          localObject4 = new AppBrandLaunchReferrer();
          ((AppBrandLaunchReferrer)localObject4).leo = 7;
          ((AppBrandLaunchReferrer)localObject4).appId = null;
          ((AppBrandLaunchReferrer)localObject4).ler = ((com.tencent.mm.ab.i)localObject2).toString();
          localObject2 = new LaunchParcel();
          ((LaunchParcel)localObject2).appId = ((String)localObject1);
          ((LaunchParcel)localObject2).kHw = str1;
          ((LaunchParcel)localObject2).mYK = ((AppBrandStatObject)localObject3);
          ((LaunchParcel)localObject2).cys = ((AppBrandLaunchReferrer)localObject4);
          ((LaunchParcel)localObject2).mYN = new com.tencent.luggage.sdk.launching.a() {};
          com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(MMApplicationContext.getContext(), (LaunchParcel)localObject2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1;
            Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, parse failed e = %s, uuid = %s, json = %s", new Object[] { localException, paramString1, paramString2 });
            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.acs(paramString1).aYI();
          }
        }
        localObject1 = QZL;
        AppMethodBeat.o(226330);
        return localObject1;
      }
    }).hdy();
    AppMethodBeat.o(44176);
  }
  
  public void p(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44173);
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.lWe = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.lWf = paramInt;
    com.tencent.mm.plugin.appbrand.ipc.e.b(paramString1, localSendDataToMiniProgramFromH5Event);
    AppMethodBeat.o(44173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.l
 * JD-Core Version:    0.7.0.1
 */