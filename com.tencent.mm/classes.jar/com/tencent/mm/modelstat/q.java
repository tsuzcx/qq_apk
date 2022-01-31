package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.cm.c;
import com.tencent.mm.cm.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.at;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n;
import com.tencent.mm.network.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class q
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private l fUE;
  private h<m> fUF;
  private y fUG;
  private h<g> fUH;
  private n fyJ;
  
  static
  {
    AppMethodBeat.i(78801);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new q.4());
    AppMethodBeat.o(78801);
  }
  
  public q()
  {
    AppMethodBeat.i(78793);
    this.fUE = new l();
    this.fUF = new h(new c() {});
    this.fUG = new y();
    this.fUH = new h(new q.2(this));
    this.fyJ = new q.3(this);
    AppMethodBeat.o(78793);
  }
  
  public static g akJ()
  {
    AppMethodBeat.i(78794);
    com.tencent.mm.kernel.g.RJ().QQ();
    g localg = (g)akK().fUH.get();
    AppMethodBeat.o(78794);
    return localg;
  }
  
  private static q akK()
  {
    AppMethodBeat.i(78795);
    q localq = (q)com.tencent.mm.model.q.S(q.class);
    AppMethodBeat.o(78795);
    return localq;
  }
  
  public static m akL()
  {
    AppMethodBeat.i(78796);
    com.tencent.mm.kernel.g.RJ().QQ();
    m localm = (m)akK().fUF.get();
    AppMethodBeat.o(78796);
    return localm;
  }
  
  public static void d(e parame)
  {
    AppMethodBeat.i(78797);
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.SubCoreStat", "dknetstat setNetworkMoniter  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bo.dtY() });
      if (parame != null) {
        parame.a(akK().fUE);
      }
      AppMethodBeat.o(78797);
      return;
    }
  }
  
  public static void e(e parame)
  {
    AppMethodBeat.i(78798);
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.SubCoreStat", "setKVReportMonitor  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bo.dtY() });
      if (parame != null) {
        parame.a(akK().fUG);
      }
      AppMethodBeat.o(78798);
      return;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(78800);
    e.d.a(Integer.valueOf(9998), this.fUE);
    com.tencent.mm.kernel.g.RK().a(this.fyJ);
    com.tencent.mm.model.ao.a.flJ = new q.5(this);
    AppMethodBeat.o(78800);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(78799);
    com.tencent.mm.kernel.g.RK().b(this.fyJ);
    e.d.b(Integer.valueOf(9998), this.fUE);
    this.fUE = new l();
    com.tencent.mm.model.ao.a.flJ = null;
    AppMethodBeat.o(78799);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.q
 * JD-Core Version:    0.7.0.1
 */