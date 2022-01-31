package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class g
  implements ar
{
  private static HashMap<Integer, h.d> fjU;
  private e fjT;
  private c fjV = new g.2(this);
  private c fjW = new g.3(this);
  private c fjX = new g.4(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    fjU = localHashMap;
    localHashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new g.1());
  }
  
  private static g XA()
  {
    try
    {
      g localg = (g)p.B(g.class);
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static e XB()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (XA().fjT == null) {
      XA().fjT = new e(com.tencent.mm.kernel.g.DP().dKu);
    }
    return XA().fjT;
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.sdk.b.a.udP.c(this.fjV);
    com.tencent.mm.sdk.b.a.udP.c(this.fjW);
    com.tencent.mm.sdk.b.a.udP.c(this.fjX);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.fjV);
    com.tencent.mm.sdk.b.a.udP.d(this.fjW);
    com.tencent.mm.sdk.b.a.udP.d(this.fjX);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return fjU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.g
 * JD-Core Version:    0.7.0.1
 */