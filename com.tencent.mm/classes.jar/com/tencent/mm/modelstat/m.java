package com.tencent.mm.modelstat;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ag;
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
      paramj.mdJ = (paramj.mdQ + paramj.mdR);
      paramj.cUP |= 0x8000;
      return;
    case 138: 
    case 139: 
      paramj.mdx = (paramj.mdE + paramj.mdF);
      paramj.cUP |= 0x8;
      return;
    case 110: 
      paramj.mdL = (paramj.mdQ + paramj.mdR);
      paramj.cUP |= 0x20000;
      return;
    case 109: 
    case 123: 
      paramj.mdz = (paramj.mdE + paramj.mdF);
      paramj.cUP |= 0x20;
      return;
    case 127: 
      paramj.mdN = (paramj.mdQ + paramj.mdR);
      paramj.cUP |= 0x80000;
      return;
    case 128: 
      paramj.mdB = (paramj.mdE + paramj.mdF);
      paramj.cUP |= 0x80;
      return;
    case 149: 
      paramj.mdP = (paramj.mdQ + paramj.mdR);
      paramj.cUP |= 0x200000;
      return;
    }
    paramj.mdD = (paramj.mdE + paramj.mdF);
    paramj.cUP |= 0x200;
  }
  
  public static void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(200994);
    if (ag.dj(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
      c(paramLong1, paramLong2, paramInt);
      AppMethodBeat.o(200994);
      return;
    }
    Log.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    d(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(200994);
  }
  
  public static void c(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177295);
    j localj = new j();
    localj.mdF = paramLong1;
    localj.mdR = paramLong2;
    localj.cUP = 12585984;
    c(localj);
    a(localj, paramInt);
    p.bpD().a(localj);
    AppMethodBeat.o(177295);
  }
  
  private static void c(j paramj)
  {
    AppMethodBeat.i(151109);
    if (Build.VERSION.SDK_INT >= 28) {
      TrafficStats.updateNsm(MMApplicationContext.getContext());
    }
    for (;;)
    {
      paramj.mdG = TrafficStats.getMobileRx(0L);
      paramj.mdS = TrafficStats.getMobileTx(0L);
      paramj.mdH = TrafficStats.getWifiRx(0L);
      paramj.mdT = TrafficStats.getWifiTx(0L);
      paramj.mdU = TrafficStats.getWxMobileRx(0L);
      paramj.mdW = TrafficStats.getWxMobileTx(0L);
      paramj.mdV = TrafficStats.getWxWifiRx(0L);
      paramj.mdX = TrafficStats.getWxWifiTx(0L);
      paramj.cUP = (paramj.cUP | 0x2000 | 0x2000000 | 0x1000 | 0x1000000 | 0x8000000 | 0x20000000 | 0x4000000 | 0x10000000);
      AppMethodBeat.o(151109);
      return;
      TrafficStats.update();
    }
  }
  
  public static void d(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177296);
    j localj = new j();
    localj.mdE = paramLong1;
    localj.mdQ = paramLong2;
    localj.cUP = 12585984;
    c(localj);
    a(localj, paramInt);
    p.bpD().a(localj);
    AppMethodBeat.o(177296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.m
 * JD-Core Version:    0.7.0.1
 */