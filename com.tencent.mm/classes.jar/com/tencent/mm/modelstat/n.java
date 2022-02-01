package com.tencent.mm.modelstat;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bt;

public final class n
{
  static
  {
    AppMethodBeat.i(151110);
    if (Build.VERSION.SDK_INT >= 28)
    {
      bt.reset(ak.getContext());
      AppMethodBeat.o(151110);
      return;
    }
    bt.reset();
    AppMethodBeat.o(151110);
  }
  
  private static void a(k paramk, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 522: 
      paramk.ith = (paramk.ito + paramk.itp);
      paramk.dEu |= 0x8000;
      return;
    case 138: 
    case 139: 
      paramk.isV = (paramk.itc + paramk.itd);
      paramk.dEu |= 0x8;
      return;
    case 110: 
      paramk.itj = (paramk.ito + paramk.itp);
      paramk.dEu |= 0x20000;
      return;
    case 109: 
    case 123: 
      paramk.isX = (paramk.itc + paramk.itd);
      paramk.dEu |= 0x20;
      return;
    case 127: 
      paramk.itl = (paramk.ito + paramk.itp);
      paramk.dEu |= 0x80000;
      return;
    case 128: 
      paramk.isZ = (paramk.itc + paramk.itd);
      paramk.dEu |= 0x80;
      return;
    case 149: 
      paramk.itn = (paramk.ito + paramk.itp);
      paramk.dEu |= 0x200000;
      return;
    }
    paramk.itb = (paramk.itc + paramk.itd);
    paramk.dEu |= 0x200;
  }
  
  public static void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177295);
    k localk = new k();
    localk.itd = paramLong1;
    localk.itp = paramLong2;
    localk.dEu = 12585984;
    c(localk);
    a(localk, paramInt);
    q.aMn().a(localk);
    AppMethodBeat.o(177295);
  }
  
  public static void c(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177296);
    k localk = new k();
    localk.itc = paramLong1;
    localk.ito = paramLong2;
    localk.dEu = 12585984;
    c(localk);
    a(localk, paramInt);
    q.aMn().a(localk);
    AppMethodBeat.o(177296);
  }
  
  private static void c(k paramk)
  {
    AppMethodBeat.i(151109);
    if (Build.VERSION.SDK_INT >= 28) {
      bt.ji(ak.getContext());
    }
    for (;;)
    {
      paramk.ite = bt.fpC();
      paramk.itq = bt.fpB();
      paramk.itf = bt.fpA();
      paramk.itr = bt.fpz();
      paramk.its = bt.Dy(0L);
      paramk.itu = bt.Dx(0L);
      paramk.itt = bt.fpD();
      paramk.itv = bt.Dw(0L);
      paramk.dEu = (paramk.dEu | 0x2000 | 0x2000000 | 0x1000 | 0x1000000 | 0x8000000 | 0x20000000 | 0x4000000 | 0x10000000);
      AppMethodBeat.o(151109);
      return;
      bt.update();
    }
  }
  
  public static void y(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177294);
    if (com.tencent.mm.network.ae.cR(ak.getContext()))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(0) });
      b(paramLong1, paramLong2, 0);
      AppMethodBeat.o(177294);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(0) });
    c(paramLong1, paramLong2, 0);
    AppMethodBeat.o(177294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.n
 * JD-Core Version:    0.7.0.1
 */