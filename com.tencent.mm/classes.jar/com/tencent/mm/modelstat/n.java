package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bn;

public final class n
{
  static
  {
    AppMethodBeat.i(78767);
    bn.reset();
    AppMethodBeat.o(78767);
  }
  
  public static void I(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(78764);
    k localk = new k();
    localk.fTD = paramInt1;
    localk.fTP = paramInt2;
    localk.bsY = 8390656;
    c(localk);
    a(localk, paramInt3);
    q.akL().a(localk);
    AppMethodBeat.o(78764);
  }
  
  public static void J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(78765);
    k localk = new k();
    localk.fTC = paramInt1;
    localk.fTO = paramInt2;
    localk.bsY = 4195328;
    c(localk);
    a(localk, paramInt3);
    q.akL().a(localk);
    AppMethodBeat.o(78765);
  }
  
  private static void a(k paramk, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 522: 
      paramk.fTH = (paramk.fTO + paramk.fTP);
      paramk.bsY |= 0x8000;
      return;
    case 138: 
    case 139: 
      paramk.fTv = (paramk.fTC + paramk.fTD);
      paramk.bsY |= 0x8;
      return;
    case 110: 
      paramk.fTJ = (paramk.fTO + paramk.fTP);
      paramk.bsY |= 0x20000;
      return;
    case 109: 
    case 123: 
      paramk.fTx = (paramk.fTC + paramk.fTD);
      paramk.bsY |= 0x20;
      return;
    case 127: 
      paramk.fTL = (paramk.fTO + paramk.fTP);
      paramk.bsY |= 0x80000;
      return;
    case 128: 
      paramk.fTz = (paramk.fTC + paramk.fTD);
      paramk.bsY |= 0x80;
      return;
    case 149: 
      paramk.fTN = (paramk.fTO + paramk.fTP);
      paramk.bsY |= 0x200000;
      return;
    }
    paramk.fTB = (paramk.fTC + paramk.fTD);
    paramk.bsY |= 0x200;
  }
  
  private static void c(k paramk)
  {
    AppMethodBeat.i(78766);
    bn.update();
    paramk.fTE = ((int)bn.dtO());
    paramk.fTQ = ((int)bn.dtN());
    paramk.fTF = ((int)bn.dtM());
    paramk.fTR = ((int)bn.dtL());
    paramk.fTS = ((int)bn.nS(0L));
    paramk.fTU = ((int)bn.nR(0L));
    paramk.fTT = ((int)bn.dtP());
    paramk.fTV = ((int)bn.nQ(0L));
    paramk.bsY = (paramk.bsY | 0x2000 | 0x2000000 | 0x1000 | 0x1000000 | 0x8000000 | 0x20000000 | 0x4000000 | 0x10000000);
    AppMethodBeat.o(78766);
  }
  
  public static void cq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78763);
    if (ac.cm(ah.getContext()))
    {
      ab.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
      I(paramInt1, paramInt2, 0);
      AppMethodBeat.o(78763);
      return;
    }
    ab.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    J(paramInt1, paramInt2, 0);
    AppMethodBeat.o(78763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.n
 * JD-Core Version:    0.7.0.1
 */