package com.tencent.mm.plugin.aa;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.bq;
import com.tencent.mm.h.a.br;
import com.tencent.mm.h.a.ms;
import com.tencent.mm.h.a.mt;
import com.tencent.mm.h.a.ts;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.aa.a.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class b
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private c<mt> eUT = new b.1(this);
  private c<ms> eUU = new b.2(this);
  private c<bq> eUV = new c() {};
  private c<br> eUW = new b.4(this);
  private o eUX = new b.5(this);
  c<ts> eUY = new b.6(this);
  private d eUZ;
  private com.tencent.mm.plugin.aa.a.b.b eVa;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("AARecord".hashCode()), new b.7());
    dgp.put(Integer.valueOf("AAPayRecord".hashCode()), new b.8());
  }
  
  private static b Vi()
  {
    return (b)com.tencent.mm.model.p.B(b.class);
  }
  
  public static d Vj()
  {
    if (Vi().eUZ == null)
    {
      b localb = Vi();
      g.DQ();
      localb.eUZ = new d(g.DP().dKu);
    }
    return Vi().eUZ;
  }
  
  public static com.tencent.mm.plugin.aa.a.b.b Vk()
  {
    if (Vi().eVa == null)
    {
      b localb = Vi();
      g.DQ();
      localb.eVa = new com.tencent.mm.plugin.aa.a.b.b(g.DP().dKu);
    }
    return Vi().eVa;
  }
  
  public final void bh(boolean paramBoolean)
  {
    a.udP.c(this.eUT);
    a.udP.c(this.eUU);
    a.udP.c(this.eUV);
    a.udP.c(this.eUW);
    a.udP.c(this.eUY);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.eUX);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    a.udP.d(this.eUT);
    a.udP.d(this.eUU);
    a.udP.d(this.eUV);
    a.udP.d(this.eUW);
    a.udP.d(this.eUY);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.eUX);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b
 * JD-Core Version:    0.7.0.1
 */