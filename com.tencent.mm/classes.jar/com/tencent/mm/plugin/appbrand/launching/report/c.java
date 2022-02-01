package com.tencent.mm.plugin.appbrand.launching.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.iv;
import com.tencent.mm.g.b.a.iv.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private int aDD;
  private String appId;
  private int dli;
  private String lIU;
  private int lSi;
  public boolean lSj;
  private List<Integer> lSk;
  private String provider;
  private int scene;
  
  public c(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaPluginCodeInfo> paramList)
  {
    AppMethodBeat.i(47465);
    this.lSk = new ArrayList();
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
        this.lSi = ((WxaAttributes.WxaPluginCodeInfo)paramList.get(0)).version;
      }
      this.lIU = paramString2;
      this.scene = paramInt3;
      ae.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "appid:%s,appVersion:%s,appState:%s,instanceId:%s,scene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(this.dli), paramString2, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(47465);
      return;
      this.dli = 1;
      continue;
      this.dli = 2;
      continue;
      this.dli = 3;
    }
  }
  
  public static void uv(int paramInt)
  {
    AppMethodBeat.i(47466);
    ae.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "idkeyReport id:%d,key:%d", new Object[] { Integer.valueOf(1027), Integer.valueOf(paramInt) });
    g.yxI.idkeyStat(1027L, paramInt, 1L, false);
    AppMethodBeat.o(47466);
  }
  
  public final void report()
  {
    AppMethodBeat.i(47468);
    if (this.lSj)
    {
      if ((this.lSk != null) && (this.lSk.size() > 0))
      {
        Iterator localIterator = this.lSk.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          iv localiv = new iv();
          localiv.rK(this.appId);
          localiv.etb = this.aDD;
          localiv.ezx = iv.a.jA(this.dli);
          localiv.euA = 1004L;
          localiv.rL(this.provider);
          localiv.ezz = this.lSi;
          localiv.ezA = i;
          localiv.rM(q.dO(ak.getContext()));
          localiv.rN(this.lIU);
          localiv.dWt = this.scene;
          localiv.aLH();
          ae.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "kvReportStatis report:%s", new Object[] { localiv.RD() });
        }
        AppMethodBeat.o(47468);
      }
    }
    else {
      ae.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "hot startUp!");
    }
    AppMethodBeat.o(47468);
  }
  
  public final void uw(int paramInt)
  {
    AppMethodBeat.i(47467);
    if ((bu.isNullOrNil(this.appId)) || (bu.isNullOrNil(this.provider)))
    {
      ae.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "kvReportStatis appId or provider null!");
      AppMethodBeat.o(47467);
      return;
    }
    this.lSk.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(47467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.c
 * JD-Core Version:    0.7.0.1
 */