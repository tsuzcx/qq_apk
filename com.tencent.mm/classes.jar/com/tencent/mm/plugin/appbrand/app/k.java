package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cw.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o.a;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d.b;
import java.util.List;

class k
  implements j
{
  public void a(int paramInt, String paramString, Object paramObject) {}
  
  public com.tencent.mm.vending.g.e<Integer> acu(final String paramString)
  {
    AppMethodBeat.i(44171);
    paramString = com.tencent.mm.cw.g.ijP().b(new a()
    {
      private Integer bFy()
      {
        AppMethodBeat.i(44166);
        if (!h.aHE().aGM())
        {
          com.tencent.mm.vending.g.g.ieE().eo(new com.tencent.mm.model.b());
          AppMethodBeat.o(44166);
          return null;
        }
        AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.air(paramString);
        final com.tencent.mm.vending.g.b localb = com.tencent.mm.vending.g.g.ieO();
        h.aHF().kcd.a(1345, new com.tencent.mm.an.i()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
          {
            AppMethodBeat.i(44165);
            if (com.tencent.mm.plugin.appbrand.jsapi.op_report.c.b(paramAnonymous2q, k.1.this.val$appId))
            {
              h.aHF().kcd.b(1345, this);
              try
              {
                localb.G(new Object[] { Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.op_report.c.e(paramAnonymous2q)) });
                AppMethodBeat.o(44165);
                return;
              }
              catch (Exception paramAnonymous2String)
              {
                localb.eo(paramAnonymous2String);
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
  
  public void acv(String paramString)
  {
    AppMethodBeat.i(44172);
    com.tencent.mm.plugin.appbrand.task.i.cjb().a(LuggageServiceType.cBP, z.qOX);
    AppMethodBeat.o(44172);
  }
  
  public final int bFx()
  {
    AppMethodBeat.i(44175);
    if ((!h.aHE().kbT) || (h.ae(com.tencent.mm.plugin.appbrand.api.e.class) == null))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.ServiceForWebView", "getWxaCommLibVersion, invalid account status, stack:%s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(44175);
      return -1;
    }
    ICommLibReader localICommLibReader2 = au.bHb();
    ICommLibReader localICommLibReader1 = localICommLibReader2;
    if (localICommLibReader2 == null) {}
    try
    {
      at.bHa();
      localICommLibReader1 = au.bHb();
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
    int i = localb.bGi();
    AppMethodBeat.o(44175);
    return i;
  }
  
  public void ba(List<String> paramList)
  {
    AppMethodBeat.i(44174);
    aa.a(paramList, o.a.nZk, null).a(new d.b() {});
    AppMethodBeat.o(44174);
  }
  
  public void cw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44176);
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage invalid uuid");
      AppMethodBeat.o(44176);
      return;
    }
    com.tencent.mm.cw.g.ijP().h(new k.3(this, paramString1, paramString2)).ieF();
    AppMethodBeat.o(44176);
  }
  
  public void r(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44173);
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.oTP = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.oTQ = paramInt;
    com.tencent.mm.plugin.appbrand.ipc.e.b(paramString1, localSendDataToMiniProgramFromH5Event);
    AppMethodBeat.o(44173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.k
 * JD-Core Version:    0.7.0.1
 */