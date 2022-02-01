package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hp;
import com.tencent.mm.g.b.a.hp.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private int aBM;
  private String appId;
  private int cYO;
  private String lht;
  private int lqj;
  public boolean lqk;
  private List<Integer> lql;
  private String provider;
  private int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaPluginCodeInfo> paramList)
  {
    AppMethodBeat.i(47465);
    this.lql = new ArrayList();
    this.appId = paramString1;
    this.aBM = paramInt1;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.provider = ((WxaAttributes.WxaPluginCodeInfo)paramList.get(0)).provider;
        this.lqj = ((WxaAttributes.WxaPluginCodeInfo)paramList.get(0)).version;
      }
      this.lht = paramString2;
      this.scene = paramInt3;
      ac.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "appid:%s,appVersion:%s,appState:%s,instanceId:%s,scene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(this.cYO), paramString2, Integer.valueOf(paramInt3) });
      AppMethodBeat.o(47465);
      return;
      this.cYO = 1;
      continue;
      this.cYO = 2;
      continue;
      this.cYO = 3;
    }
  }
  
  public static void tL(int paramInt)
  {
    AppMethodBeat.i(47466);
    ac.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "idkeyReport id:%d,key:%d", new Object[] { Integer.valueOf(1027), Integer.valueOf(paramInt) });
    h.wUl.idkeyStat(1027L, paramInt, 1L, false);
    AppMethodBeat.o(47466);
  }
  
  public final void report()
  {
    AppMethodBeat.i(47468);
    if (this.lqk)
    {
      if ((this.lql != null) && (this.lql.size() > 0))
      {
        Iterator localIterator = this.lql.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          hp localhp = new hp();
          localhp.oI(this.appId);
          localhp.eaM = this.aBM;
          localhp.egO = hp.a.jb(this.cYO);
          localhp.eco = 1004L;
          localhp.oJ(this.provider);
          localhp.egQ = this.lqj;
          localhp.egR = i;
          localhp.oK(p.dL(ai.getContext()));
          localhp.oL(this.lht);
          localhp.dHY = this.scene;
          localhp.aHZ();
          ac.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "kvReportStatis report:%s", new Object[] { localhp.PS() });
        }
        AppMethodBeat.o(47468);
      }
    }
    else {
      ac.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "hot startUp!");
    }
    AppMethodBeat.o(47468);
  }
  
  public final void tM(int paramInt)
  {
    AppMethodBeat.i(47467);
    if ((bs.isNullOrNil(this.appId)) || (bs.isNullOrNil(this.provider)))
    {
      ac.i("MicroMsg.LaunchPrepareSplitPluginCodeReporter", "kvReportStatis appId or provider null!");
      AppMethodBeat.o(47467);
      return;
    }
    this.lql.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(47467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.a
 * JD-Core Version:    0.7.0.1
 */