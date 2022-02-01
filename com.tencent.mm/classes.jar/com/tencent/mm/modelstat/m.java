package com.tencent.mm.modelstat;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.TrafficStats;

public final class m
{
  static
  {
    AppMethodBeat.i(151110);
    if (Build.VERSION.SDK_INT >= 28)
    {
      TrafficStats.reset(MMApplicationContext.getContext());
      AppMethodBeat.o(151110);
      return;
    }
    TrafficStats.reset();
    AppMethodBeat.o(151110);
  }
  
  private static void a(j paramj, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 522: 
      paramj.oWC = (paramj.oWJ + paramj.oWK);
      paramj.eQp |= 0x8000;
      return;
    case 138: 
    case 139: 
      paramj.oWq = (paramj.oWx + paramj.oWy);
      paramj.eQp |= 0x8;
      return;
    case 110: 
      paramj.oWE = (paramj.oWJ + paramj.oWK);
      paramj.eQp |= 0x20000;
      return;
    case 109: 
    case 123: 
      paramj.oWs = (paramj.oWx + paramj.oWy);
      paramj.eQp |= 0x20;
      return;
    case 127: 
      paramj.oWG = (paramj.oWJ + paramj.oWK);
      paramj.eQp |= 0x80000;
      return;
    case 128: 
      paramj.oWu = (paramj.oWx + paramj.oWy);
      paramj.eQp |= 0x80;
      return;
    case 149: 
      paramj.oWI = (paramj.oWJ + paramj.oWK);
      paramj.eQp |= 0x200000;
      return;
    }
    paramj.oWw = (paramj.oWx + paramj.oWy);
    paramj.eQp |= 0x200;
  }
  
  private static void c(j paramj)
  {
    AppMethodBeat.i(151109);
    if (Build.VERSION.SDK_INT >= 28) {
      TrafficStats.updateNsm(MMApplicationContext.getContext());
    }
    for (;;)
    {
      paramj.oWz = TrafficStats.getMobileRx(0L);
      paramj.oWL = TrafficStats.getMobileTx(0L);
      paramj.oWA = TrafficStats.getWifiRx(0L);
      paramj.oWM = TrafficStats.getWifiTx(0L);
      paramj.oWN = TrafficStats.getWxMobileRx(0L);
      paramj.oWP = TrafficStats.getWxMobileTx(0L);
      paramj.oWO = TrafficStats.getWxWifiRx(0L);
      paramj.oWQ = TrafficStats.getWxWifiTx(0L);
      paramj.eQp = (paramj.eQp | 0x2000 | 0x2000000 | 0x1000 | 0x1000000 | 0x8000000 | 0x20000000 | 0x4000000 | 0x10000000);
      AppMethodBeat.o(151109);
      return;
      TrafficStats.update();
    }
  }
  
  public static void d(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(242901);
    if (ah.eb(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
      e(paramLong1, paramLong2, paramInt);
      AppMethodBeat.o(242901);
      return;
    }
    Log.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    f(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(242901);
  }
  
  public static void e(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177295);
    j localj = new j();
    localj.oWy = paramLong1;
    localj.oWK = paramLong2;
    localj.eQp = 12585984;
    c(localj);
    a(localj, paramInt);
    p.bNk().a(localj);
    AppMethodBeat.o(177295);
  }
  
  public static void f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177296);
    j localj = new j();
    localj.oWx = paramLong1;
    localj.oWJ = paramLong2;
    localj.eQp = 12585984;
    c(localj);
    a(localj, paramInt);
    p.bNk().a(localj);
    AppMethodBeat.o(177296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.m
 * JD-Core Version:    0.7.0.1
 */