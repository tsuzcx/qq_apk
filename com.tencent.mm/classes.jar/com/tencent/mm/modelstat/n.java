package com.tencent.mm.modelstat;

import com.tencent.mm.network.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.y;

public final class n
{
  static {}
  
  private static void a(k paramk, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 522: 
      paramk.eDQ = (paramk.eDX + paramk.eDY);
      paramk.bcw |= 0x8000;
      return;
    case 138: 
    case 139: 
      paramk.eDE = (paramk.eDL + paramk.eDM);
      paramk.bcw |= 0x8;
      return;
    case 110: 
      paramk.eDS = (paramk.eDX + paramk.eDY);
      paramk.bcw |= 0x20000;
      return;
    case 109: 
    case 123: 
      paramk.eDG = (paramk.eDL + paramk.eDM);
      paramk.bcw |= 0x20;
      return;
    case 127: 
      paramk.eDU = (paramk.eDX + paramk.eDY);
      paramk.bcw |= 0x80000;
      return;
    case 128: 
      paramk.eDI = (paramk.eDL + paramk.eDM);
      paramk.bcw |= 0x80;
      return;
    case 149: 
      paramk.eDW = (paramk.eDX + paramk.eDY);
      paramk.bcw |= 0x200000;
      return;
    }
    paramk.eDK = (paramk.eDL + paramk.eDM);
    paramk.bcw |= 0x200;
  }
  
  public static void bg(int paramInt1, int paramInt2)
  {
    if (ab.bG(ae.getContext()))
    {
      y.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
      w(paramInt1, paramInt2, 0);
      return;
    }
    y.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    x(paramInt1, paramInt2, 0);
  }
  
  private static void c(k paramk)
  {
    bj.update();
    paramk.eDN = ((int)bj.crO());
    paramk.eDZ = ((int)bj.crN());
    paramk.eDO = ((int)bj.crM());
    paramk.eEa = ((int)bj.crL());
    paramk.eEb = ((int)bj.crS());
    paramk.eEd = ((int)bj.crR());
    paramk.eEc = ((int)bj.crQ());
    paramk.eEe = ((int)bj.crP());
    paramk.bcw = (paramk.bcw | 0x2000 | 0x2000000 | 0x1000 | 0x1000000 | 0x8000000 | 0x20000000 | 0x4000000 | 0x10000000);
  }
  
  public static void w(int paramInt1, int paramInt2, int paramInt3)
  {
    k localk = new k();
    localk.eDM = paramInt1;
    localk.eDY = paramInt2;
    localk.bcw = 8390656;
    c(localk);
    a(localk, paramInt3);
    q.RC().a(localk);
  }
  
  public static void x(int paramInt1, int paramInt2, int paramInt3)
  {
    k localk = new k();
    localk.eDL = paramInt1;
    localk.eDX = paramInt2;
    localk.bcw = 4195328;
    c(localk);
    a(localk, paramInt3);
    q.RC().a(localk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.n
 * JD-Core Version:    0.7.0.1
 */