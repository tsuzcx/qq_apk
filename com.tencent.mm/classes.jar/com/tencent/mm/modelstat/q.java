package com.tencent.mm.modelstat;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.ck.c;
import com.tencent.mm.ck.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n;
import com.tencent.mm.network.x;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class q
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private l eEN = new l();
  private h<m> eEO = new h(new c() {});
  private x eEP = new x();
  private h<g> eEQ = new h(new q.2(this));
  private n eiF = new q.3(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new q.4());
  }
  
  public static g RA()
  {
    com.tencent.mm.kernel.g.DN().CX();
    return (g)RB().eEQ.get();
  }
  
  private static q RB()
  {
    return (q)p.B(q.class);
  }
  
  public static m RC()
  {
    com.tencent.mm.kernel.g.DN().CX();
    return (m)RB().eEO.get();
  }
  
  public static void e(e parame)
  {
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.SubCoreStat", "dknetstat setNetworkMoniter  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bk.csb() });
      if (parame != null) {
        parame.a(RB().eEN);
      }
      return;
    }
  }
  
  public static void f(e parame)
  {
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.SubCoreStat", "setKVReportMonitor  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bk.csb() });
      if (parame != null) {
        parame.a(RB().eEP);
      }
      return;
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(9998), this.eEN);
    com.tencent.mm.kernel.g.DO().a(this.eiF);
    com.tencent.mm.model.am.a.dVz = new q.5(this);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.kernel.g.DO().b(this.eiF);
    e.d.b(Integer.valueOf(9998), this.eEN);
    this.eEN = new l();
    com.tencent.mm.model.am.a.dVz = null;
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.q
 * JD-Core Version:    0.7.0.1
 */