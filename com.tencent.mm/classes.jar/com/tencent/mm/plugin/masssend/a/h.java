package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import java.util.HashMap;

public final class h
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private bx.a lYt = new h.2(this);
  private b maO;
  private c maP;
  private i maQ = new i();
  private g maR = new g();
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new h.1());
  }
  
  private static h bhc()
  {
    au.Hq();
    h localh2 = (h)bu.iR("plugin.masssend");
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h();
      au.Hq().a("plugin.favorite", localh1);
    }
    return localh1;
  }
  
  public static b bhd()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bhc().maO == null)
    {
      h localh = bhc();
      au.Hx();
      localh.maO = new b(com.tencent.mm.model.c.Dv());
    }
    return bhc().maO;
  }
  
  public static c bhe()
  {
    if (bhc().maP == null) {
      bhc().maP = new c();
    }
    return bhc().maP;
  }
  
  public final void bh(boolean paramBoolean)
  {
    au.getSysCmdMsgExtension().a("masssendapp", this.lYt, false);
    com.tencent.mm.sdk.b.a.udP.c(this.maQ);
    com.tencent.mm.sdk.b.a.udP.c(this.maR);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    au.getSysCmdMsgExtension().b("masssendapp", this.lYt, false);
    com.tencent.mm.sdk.b.a.udP.d(this.maQ);
    com.tencent.mm.sdk.b.a.udP.d(this.maR);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h
 * JD-Core Version:    0.7.0.1
 */