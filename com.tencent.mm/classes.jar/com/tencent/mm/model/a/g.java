package com.tencent.mm.model.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public class g
  implements ar
{
  private c dYl = null;
  
  private static g Ix()
  {
    return (g)p.B(g.class);
  }
  
  public static c Iy()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Ix().dYl == null) {
      Ix().dYl = new c();
    }
    return Ix().dYl;
  }
  
  public final void bh(boolean paramBoolean)
  {
    c localc = Iy();
    long l = System.currentTimeMillis();
    try
    {
      localc.iY((String)com.tencent.mm.kernel.g.DP().Dz().get(328193, null));
      if (localc.Iw()) {
        f.ja(localc.dYf.dYb);
      }
      y.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { localException.toString() });
      }
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    c localc = Iy();
    localc.dYg = null;
    localc.dYf = null;
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.g
 * JD-Core Version:    0.7.0.1
 */