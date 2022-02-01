package com.tencent.mm.plugin.appbrand.launching.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.g.b.a.it.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private int aDD;
  private String appId;
  private int dkg;
  private String lEv;
  private int lNH;
  public boolean lNI;
  private List<Integer> lNJ;
  private String provider;
  private int scene;
  
  public c(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaPluginCodeInfo> paramList)
  {
    AppMethodBeat.i(47465);
    this.lNJ = new ArrayList();
    this.appId = paramString1;
    this.aDD = paramInt1;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.provider = ((WxaAttributes.WxaPluginCodeInfo)paramList.get(0)).provider;
        this.lNH = ((WxaAttributes.WxaPluginCodeInfo)paramList.get(0)).version;
      }
      this.lEv = paramString2;
      this.scene = paramInt3;
      ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "appid:%s,appVersion:%s,appState:%s,instanceId:%s,scene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(this.dkg), paramString2, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(47465);
      return;
      this.dkg = 1;
      continue;
      this.dkg = 2;
      continue;
      this.dkg = 3;
    }
  }
  
  public static void up(int paramInt)
  {
    AppMethodBeat.i(47466);
    ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "idkeyReport id:%d,key:%d", new Object[] { Integer.valueOf(1027), Integer.valueOf(paramInt) });
    g.yhR.idkeyStat(1027L, paramInt, 1L, false);
    AppMethodBeat.o(47466);
  }
  
  public final void report()
  {
    AppMethodBeat.i(47468);
    if (this.lNI)
    {
      if ((this.lNJ != null) && (this.lNJ.size() > 0))
      {
        Iterator localIterator = this.lNJ.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          it localit = new it();
          localit.rp(this.appId);
          localit.eru = this.aDD;
          localit.exN = it.a.jy(this.dkg);
          localit.esT = 1004L;
          localit.rq(this.provider);
          localit.exP = this.lNH;
          localit.exQ = i;
          localit.rr(q.dK(aj.getContext()));
          localit.rs(this.lEv);
          localit.dVd = this.scene;
          localit.aLk();
          ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "kvReportStatis report:%s", new Object[] { localit.RE() });
        }
        AppMethodBeat.o(47468);
      }
    }
    else {
      ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "hot startUp!");
    }
    AppMethodBeat.o(47468);
  }
  
  public final void uq(int paramInt)
  {
    AppMethodBeat.i(47467);
    if ((bt.isNullOrNil(this.appId)) || (bt.isNullOrNil(this.provider)))
    {
      ad.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "kvReportStatis appId or provider null!");
      AppMethodBeat.o(47467);
      return;
    }
    this.lNJ.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(47467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.c
 * JD-Core Version:    0.7.0.1
 */