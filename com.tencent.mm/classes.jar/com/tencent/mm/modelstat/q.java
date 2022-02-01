package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.cn.c;
import com.tencent.mm.cn.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.as.e;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class q
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.network.n hTD;
  private l irj;
  private h<m> irk;
  private aa irl;
  private h<g> irm;
  
  static
  {
    AppMethodBeat.i(151144);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return m.SQL_CREATE;
      }
    });
    AppMethodBeat.o(151144);
  }
  
  public q()
  {
    AppMethodBeat.i(151136);
    this.irj = new l();
    this.irk = new h(new c() {});
    this.irl = new aa();
    this.irm = new h(new c() {});
    this.hTD = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(151134);
        if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
        {
          AppMethodBeat.o(151134);
          return;
        }
        com.tencent.mm.kernel.g.ajF().n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151132);
            if (!com.tencent.mm.kernel.g.ajA().aiK())
            {
              AppMethodBeat.o(151132);
              return;
            }
            q.aLO().aLH();
            AppMethodBeat.o(151132);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(151133);
            String str = super.toString() + "|onNetworkChange";
            AppMethodBeat.o(151133);
            return str;
          }
        }, 3000L);
        ad.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        o.run(2);
        AppMethodBeat.o(151134);
      }
    };
    AppMethodBeat.o(151136);
  }
  
  public static g aLO()
  {
    AppMethodBeat.i(151137);
    com.tencent.mm.kernel.g.ajA().aiF();
    g localg = (g)aLP().irm.get();
    AppMethodBeat.o(151137);
    return localg;
  }
  
  private static q aLP()
  {
    AppMethodBeat.i(151138);
    q localq = (q)t.ap(q.class);
    AppMethodBeat.o(151138);
    return localq;
  }
  
  public static m aLQ()
  {
    AppMethodBeat.i(151139);
    com.tencent.mm.kernel.g.ajA().aiF();
    m localm = (m)aLP().irk.get();
    AppMethodBeat.o(151139);
    return localm;
  }
  
  public static void d(e parame)
  {
    AppMethodBeat.i(151140);
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.SubCoreStat", "dknetstat setNetworkMoniter  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bt.flS() });
      if (parame != null) {
        parame.a(aLP().irj);
      }
      AppMethodBeat.o(151140);
      return;
    }
  }
  
  public static void e(e parame)
  {
    AppMethodBeat.i(151141);
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.SubCoreStat", "setKVReportMonitor  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bt.flS() });
      if (parame != null) {
        parame.a(aLP().irl);
      }
      AppMethodBeat.o(151141);
      return;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(151143);
    e.d.a(Integer.valueOf(9998), this.irj);
    com.tencent.mm.kernel.g.ajB().a(this.hTD);
    com.tencent.mm.model.as.a.hFP = new as.e()
    {
      public final void db(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151135);
        ad.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), bt.flS() });
        n.y(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151135);
      }
    };
    AppMethodBeat.o(151143);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151142);
    com.tencent.mm.kernel.g.ajB().b(this.hTD);
    e.d.b(Integer.valueOf(9998), this.irj);
    this.irj = new l();
    com.tencent.mm.model.as.a.hFP = null;
    AppMethodBeat.o(151142);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.q
 * JD-Core Version:    0.7.0.1
 */