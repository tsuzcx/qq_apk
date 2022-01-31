package com.tencent.mm.plugin.label;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ai;
import java.util.HashMap;

public class e
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private ai lAJ;
  private d lAK = new d();
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new e.1());
    dgp.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new e.2());
  }
  
  private static e bdy()
  {
    au.Hq();
    e locale2 = (e)bu.iR("plugin.label");
    if (locale2 == null)
    {
      e locale1 = locale2;
      if (locale2 == null) {}
      try
      {
        locale1 = new e();
        au.Hq().a("plugin.label", locale1);
        return locale1;
      }
      finally {}
    }
    return locale2;
  }
  
  public static ai bdz()
  {
    g.DN().CX();
    if (bdy().lAJ == null)
    {
      e locale = bdy();
      au.Hx();
      locale.lAJ = new ai(c.Dv());
    }
    return bdy().lAJ;
  }
  
  public final void bh(boolean paramBoolean)
  {
    b localb = new b();
    com.tencent.mm.plugin.label.a.a.lAL = localb;
    com.tencent.mm.au.b.esj = localb;
    com.tencent.mm.sdk.b.a.udP.c(this.lAK);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.plugin.label.a.a.lAL = null;
    com.tencent.mm.sdk.b.a.udP.d(this.lAK);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.e
 * JD-Core Version:    0.7.0.1
 */