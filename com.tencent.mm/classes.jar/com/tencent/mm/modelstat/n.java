package com.tencent.mm.modelstat;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.TrafficStats;

public final class n
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
  
  public static void D(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177294);
    if (ag.dm(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(0) });
      b(paramLong1, paramLong2, 0);
      AppMethodBeat.o(177294);
      return;
    }
    Log.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(0) });
    c(paramLong1, paramLong2, 0);
    AppMethodBeat.o(177294);
  }
  
  private static void a(k paramk, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 522: 
      paramk.jou = (paramk.joB + paramk.joC);
      paramk.cSx |= 0x8000;
      return;
    case 138: 
    case 139: 
      paramk.joi = (paramk.jop + paramk.joq);
      paramk.cSx |= 0x8;
      return;
    case 110: 
      paramk.jow = (paramk.joB + paramk.joC);
      paramk.cSx |= 0x20000;
      return;
    case 109: 
    case 123: 
      paramk.jok = (paramk.jop + paramk.joq);
      paramk.cSx |= 0x20;
      return;
    case 127: 
      paramk.joy = (paramk.joB + paramk.joC);
      paramk.cSx |= 0x80000;
      return;
    case 128: 
      paramk.jom = (paramk.jop + paramk.joq);
      paramk.cSx |= 0x80;
      return;
    case 149: 
      paramk.joA = (paramk.joB + paramk.joC);
      paramk.cSx |= 0x200000;
      return;
    }
    paramk.joo = (paramk.jop + paramk.joq);
    paramk.cSx |= 0x200;
  }
  
  public static void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177295);
    k localk = new k();
    localk.joq = paramLong1;
    localk.joC = paramLong2;
    localk.cSx = 12585984;
    c(localk);
    a(localk, paramInt);
    q.bgo().a(localk);
    AppMethodBeat.o(177295);
  }
  
  public static void c(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177296);
    k localk = new k();
    localk.jop = paramLong1;
    localk.joB = paramLong2;
    localk.cSx = 12585984;
    c(localk);
    a(localk, paramInt);
    q.bgo().a(localk);
    AppMethodBeat.o(177296);
  }
  
  private static void c(k paramk)
  {
    AppMethodBeat.i(151109);
    if (Build.VERSION.SDK_INT >= 28) {
      TrafficStats.updateNsm(MMApplicationContext.getContext());
    }
    for (;;)
    {
      paramk.jor = TrafficStats.getMobileRx(0L);
      paramk.joD = TrafficStats.getMobileTx(0L);
      paramk.jos = TrafficStats.getWifiRx(0L);
      paramk.joE = TrafficStats.getWifiTx(0L);
      paramk.joF = TrafficStats.getWxMobileRx(0L);
      paramk.joH = TrafficStats.getWxMobileTx(0L);
      paramk.joG = TrafficStats.getWxWifiRx(0L);
      paramk.joI = TrafficStats.getWxWifiTx(0L);
      paramk.cSx = (paramk.cSx | 0x2000 | 0x2000000 | 0x1000 | 0x1000000 | 0x8000000 | 0x20000000 | 0x4000000 | 0x10000000);
      AppMethodBeat.o(151109);
      return;
      TrafficStats.update();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.n
 * JD-Core Version:    0.7.0.1
 */