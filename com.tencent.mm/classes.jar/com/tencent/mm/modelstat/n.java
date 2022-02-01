package com.tencent.mm.modelstat;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bs;

public final class n
{
  static
  {
    AppMethodBeat.i(151110);
    if ((Build.VERSION.SDK_INT > 28) || (Build.VERSION.CODENAME.equals("Q")))
    {
      bs.l(com.tencent.mm.compatible.deviceinfo.q.WU(), aj.getContext());
      AppMethodBeat.o(151110);
      return;
    }
    bs.reset();
    AppMethodBeat.o(151110);
  }
  
  public static void B(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177294);
    if (ae.cJ(aj.getContext()))
    {
      ad.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(0) });
      b(paramLong1, paramLong2, 0);
      AppMethodBeat.o(177294);
      return;
    }
    ad.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(0) });
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
      paramk.hwq = (paramk.hwx + paramk.hwy);
      paramk.dtM |= 0x8000;
      return;
    case 138: 
    case 139: 
      paramk.hwe = (paramk.hwl + paramk.hwm);
      paramk.dtM |= 0x8;
      return;
    case 110: 
      paramk.hws = (paramk.hwx + paramk.hwy);
      paramk.dtM |= 0x20000;
      return;
    case 109: 
    case 123: 
      paramk.hwg = (paramk.hwl + paramk.hwm);
      paramk.dtM |= 0x20;
      return;
    case 127: 
      paramk.hwu = (paramk.hwx + paramk.hwy);
      paramk.dtM |= 0x80000;
      return;
    case 128: 
      paramk.hwi = (paramk.hwl + paramk.hwm);
      paramk.dtM |= 0x80;
      return;
    case 149: 
      paramk.hww = (paramk.hwx + paramk.hwy);
      paramk.dtM |= 0x200000;
      return;
    }
    paramk.hwk = (paramk.hwl + paramk.hwm);
    paramk.dtM |= 0x200;
  }
  
  public static void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177295);
    k localk = new k();
    localk.hwm = paramLong1;
    localk.hwy = paramLong2;
    localk.dtM = 12585984;
    c(localk);
    a(localk, paramInt);
    q.aBQ().a(localk);
    AppMethodBeat.o(177295);
  }
  
  public static void c(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177296);
    k localk = new k();
    localk.hwl = paramLong1;
    localk.hwx = paramLong2;
    localk.dtM = 12585984;
    c(localk);
    a(localk, paramInt);
    q.aBQ().a(localk);
    AppMethodBeat.o(177296);
  }
  
  private static void c(k paramk)
  {
    AppMethodBeat.i(151109);
    if ((Build.VERSION.SDK_INT > 28) || (Build.VERSION.CODENAME.equals("Q"))) {
      bs.m(com.tencent.mm.compatible.deviceinfo.q.WU(), aj.getContext());
    }
    for (;;)
    {
      paramk.hwn = bs.eGC();
      paramk.hwz = bs.eGB();
      paramk.hwo = bs.eGA();
      paramk.hwA = bs.eGz();
      paramk.hwB = bs.vH(0L);
      paramk.hwD = bs.vG(0L);
      paramk.hwC = bs.eGD();
      paramk.hwE = bs.vF(0L);
      paramk.dtM = (paramk.dtM | 0x2000 | 0x2000000 | 0x1000 | 0x1000000 | 0x8000000 | 0x20000000 | 0x4000000 | 0x10000000);
      AppMethodBeat.o(151109);
      return;
      bs.update();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.n
 * JD-Core Version:    0.7.0.1
 */