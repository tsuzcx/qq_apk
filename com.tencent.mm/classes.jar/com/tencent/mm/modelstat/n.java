package com.tencent.mm.modelstat;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.br;

public final class n
{
  static
  {
    AppMethodBeat.i(151110);
    if ((Build.VERSION.SDK_INT > 28) || (Build.VERSION.CODENAME.equals("Q")))
    {
      br.l(com.tencent.mm.compatible.deviceinfo.q.XR(), ai.getContext());
      AppMethodBeat.o(151110);
      return;
    }
    br.reset();
    AppMethodBeat.o(151110);
  }
  
  private static void a(k paramk, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 522: 
      paramk.hWR = (paramk.hWY + paramk.hWZ);
      paramk.drx |= 0x8000;
      return;
    case 138: 
    case 139: 
      paramk.hWF = (paramk.hWM + paramk.hWN);
      paramk.drx |= 0x8;
      return;
    case 110: 
      paramk.hWT = (paramk.hWY + paramk.hWZ);
      paramk.drx |= 0x20000;
      return;
    case 109: 
    case 123: 
      paramk.hWH = (paramk.hWM + paramk.hWN);
      paramk.drx |= 0x20;
      return;
    case 127: 
      paramk.hWV = (paramk.hWY + paramk.hWZ);
      paramk.drx |= 0x80000;
      return;
    case 128: 
      paramk.hWJ = (paramk.hWM + paramk.hWN);
      paramk.drx |= 0x80;
      return;
    case 149: 
      paramk.hWX = (paramk.hWY + paramk.hWZ);
      paramk.drx |= 0x200000;
      return;
    }
    paramk.hWL = (paramk.hWM + paramk.hWN);
    paramk.drx |= 0x200;
  }
  
  public static void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177295);
    k localk = new k();
    localk.hWN = paramLong1;
    localk.hWZ = paramLong2;
    localk.drx = 12585984;
    c(localk);
    a(localk, paramInt);
    q.aIG().a(localk);
    AppMethodBeat.o(177295);
  }
  
  public static void c(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(177296);
    k localk = new k();
    localk.hWM = paramLong1;
    localk.hWY = paramLong2;
    localk.drx = 12585984;
    c(localk);
    a(localk, paramInt);
    q.aIG().a(localk);
    AppMethodBeat.o(177296);
  }
  
  private static void c(k paramk)
  {
    AppMethodBeat.i(151109);
    if ((Build.VERSION.SDK_INT > 28) || (Build.VERSION.CODENAME.equals("Q"))) {
      br.m(com.tencent.mm.compatible.deviceinfo.q.XR(), ai.getContext());
    }
    for (;;)
    {
      paramk.hWO = br.eVX();
      paramk.hXa = br.eVW();
      paramk.hWP = br.eVV();
      paramk.hXb = br.eVU();
      paramk.hXc = br.Ak(0L);
      paramk.hXe = br.Aj(0L);
      paramk.hXd = br.eVY();
      paramk.hXf = br.Ai(0L);
      paramk.drx = (paramk.drx | 0x2000 | 0x2000000 | 0x1000 | 0x1000000 | 0x8000000 | 0x20000000 | 0x4000000 | 0x10000000);
      AppMethodBeat.o(151109);
      return;
      br.update();
    }
  }
  
  public static void y(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177294);
    if (ae.cS(ai.getContext()))
    {
      ac.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(0) });
      b(paramLong1, paramLong2, 0);
      AppMethodBeat.o(177294);
      return;
    }
    ac.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(0) });
    c(paramLong1, paramLong2, 0);
    AppMethodBeat.o(177294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.n
 * JD-Core Version:    0.7.0.1
 */