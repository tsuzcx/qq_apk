package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fx;
import com.tencent.mm.g.b.a.fx.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private int aAS;
  private String appId;
  private int dbs;
  private String kGa;
  private int kOK;
  public boolean kOL;
  private List<Integer> kOM;
  private String provider;
  private int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaPluginCodeInfo> paramList)
  {
    AppMethodBeat.i(47465);
    this.kOM = new ArrayList();
    this.appId = paramString1;
    this.aAS = paramInt1;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.provider = ((WxaAttributes.WxaPluginCodeInfo)paramList.get(0)).provider;
        this.kOK = ((WxaAttributes.WxaPluginCodeInfo)paramList.get(0)).version;
      }
      this.kGa = paramString2;
      this.scene = paramInt3;
      ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "appid:%s,appVersion:%s,appState:%s,instanceId:%s,scene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(this.dbs), paramString2, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(47465);
      return;
      this.dbs = 1;
      continue;
      this.dbs = 2;
      continue;
      this.dbs = 3;
    }
  }
  
  public static void sU(int paramInt)
  {
    AppMethodBeat.i(47466);
    ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "idkeyReport id:%d,key:%d", new Object[] { Integer.valueOf(1027), Integer.valueOf(paramInt) });
    h.vKh.idkeyStat(1027L, paramInt, 1L, false);
    AppMethodBeat.o(47466);
  }
  
  public final void report()
  {
    AppMethodBeat.i(47468);
    if (this.kOL)
    {
      if ((this.kOM != null) && (this.kOM.size() > 0))
      {
        Iterator localIterator = this.kOM.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          fx localfx = new fx();
          localfx.lD(this.appId);
          localfx.dYT = this.aAS;
          localfx.eeH = fx.a.jd(this.dbs);
          localfx.eai = 1004L;
          localfx.lE(this.provider);
          localfx.eeJ = this.kOK;
          localfx.eeK = i;
          localfx.lF(q.dC(aj.getContext()));
          localfx.lG(this.kGa);
          localfx.dKe = this.scene;
          localfx.aBj();
          ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "kvReportStatis report:%s", new Object[] { localfx.PW() });
        }
        AppMethodBeat.o(47468);
      }
    }
    else {
      ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "hot startUp!");
    }
    AppMethodBeat.o(47468);
  }
  
  public final void sV(int paramInt)
  {
    AppMethodBeat.i(47467);
    if ((bt.isNullOrNil(this.appId)) || (bt.isNullOrNil(this.provider)))
    {
      ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "kvReportStatis appId or provider null!");
      AppMethodBeat.o(47467);
      return;
    }
    this.kOM.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(47467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.a
 * JD-Core Version:    0.7.0.1
 */