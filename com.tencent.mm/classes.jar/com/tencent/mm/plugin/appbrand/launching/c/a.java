package com.tencent.mm.plugin.appbrand.launching.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.g.b.a.cp.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaCodeLibInfo;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private String appId;
  private int bDc;
  private String bsd;
  private int cmE;
  private int ioh;
  public boolean ioi;
  private List<Integer> ioj;
  
  public a(String paramString, int paramInt1, int paramInt2, List<WxaAttributes.WxaCodeLibInfo> paramList)
  {
    AppMethodBeat.i(132084);
    this.ioj = new ArrayList();
    this.appId = paramString;
    this.bDc = paramInt1;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.bsd = ((WxaAttributes.WxaCodeLibInfo)paramList.get(0)).bsd;
        this.ioh = ((WxaAttributes.WxaCodeLibInfo)paramList.get(0)).version;
      }
      ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "appid:%s,appVersion:%s,appState:%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(this.cmE) });
      AppMethodBeat.o(132084);
      return;
      this.cmE = 1;
      continue;
      this.cmE = 2;
      continue;
      this.cmE = 3;
    }
  }
  
  public static void oK(int paramInt)
  {
    AppMethodBeat.i(132085);
    ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "idkeyReport id:%d,key:%d", new Object[] { Integer.valueOf(1027), Integer.valueOf(paramInt) });
    h.qsU.idkeyStat(1027L, paramInt, 1L, false);
    AppMethodBeat.o(132085);
  }
  
  public final void IE()
  {
    AppMethodBeat.i(132087);
    if (this.ioi)
    {
      if ((this.ioj != null) && (this.ioj.size() > 0))
      {
        Iterator localIterator = this.ioj.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          cp localcp = new cp();
          localcp.hL(this.appId);
          localcp.cZB = this.bDc;
          localcp.dcj = cp.a.hc(this.cmE);
          localcp.cZD = 1004L;
          localcp.hM(this.bsd);
          localcp.dcl = this.ioh;
          localcp.dcm = i;
          localcp.hN(m.da(ah.getContext()));
          localcp.ake();
          ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "kvReportStatis report:%s", new Object[] { localcp.Fg() });
        }
        AppMethodBeat.o(132087);
      }
    }
    else {
      ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "hot startUp!");
    }
    AppMethodBeat.o(132087);
  }
  
  public final void oL(int paramInt)
  {
    AppMethodBeat.i(132086);
    if ((bo.isNullOrNil(this.appId)) || (bo.isNullOrNil(this.bsd)))
    {
      ab.i("MicroMsg.LaunchPrepareSplitCodeLibReporter", "kvReportStatis appId or provider null!");
      AppMethodBeat.o(132086);
      return;
    }
    this.ioj.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(132086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.a
 * JD-Core Version:    0.7.0.1
 */