package com.tencent.mm.modelmulti;

import com.tencent.mm.ap.c;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.be;
import java.util.HashMap;

public class n
  implements ar
{
  public static HashMap<Integer, h.d> dgp = new HashMap();
  private c etG;
  
  public static m Pl()
  {
    g.DQ();
    g.DN().CX();
    return ((j)g.r(j.class)).Pl();
  }
  
  public static o Pm()
  {
    return ((com.tencent.mm.plugin.zero.b.b)g.r(com.tencent.mm.plugin.zero.b.b.class)).Pm();
  }
  
  public static n Pn()
  {
    au.Hq();
    n localn2 = (n)bu.iR(n.class.getName());
    n localn1 = localn2;
    if (localn2 == null)
    {
      localn1 = new n();
      au.Hq().a(n.class.getName(), localn1);
    }
    return localn1;
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.udP;
    c localc = new c();
    this.etG = localc;
    locala.c(localc);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (this.etG != null)
    {
      c localc = this.etG;
      com.tencent.mm.sdk.b.a.udP.d(localc.emh);
      com.tencent.mm.ap.b.Oi().emb = null;
      ((j)g.r(j.class)).FB().b(localc);
      Pn();
      Pl().d(localc);
      com.tencent.mm.sdk.b.a.udP.d(this.etG);
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.n
 * JD-Core Version:    0.7.0.1
 */