package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.cn.c;
import com.tencent.mm.cn.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class q
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.network.n hBi;
  private l hXO;
  private h<m> hXP;
  private aa hXQ;
  private h<g> hXR;
  
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
    this.hXO = new l();
    this.hXP = new h(new c() {});
    this.hXQ = new aa();
    this.hXR = new h(new c() {});
    this.hBi = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(151134);
        if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
        {
          AppMethodBeat.o(151134);
          return;
        }
        com.tencent.mm.kernel.g.agU().m(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151132);
            if (!com.tencent.mm.kernel.g.agP().afY())
            {
              AppMethodBeat.o(151132);
              return;
            }
            q.aIE().aIx();
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
        ac.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        o.run(2);
        AppMethodBeat.o(151134);
      }
    };
    AppMethodBeat.o(151136);
  }
  
  public static g aIE()
  {
    AppMethodBeat.i(151137);
    com.tencent.mm.kernel.g.agP().afT();
    g localg = (g)aIF().hXR.get();
    AppMethodBeat.o(151137);
    return localg;
  }
  
  private static q aIF()
  {
    AppMethodBeat.i(151138);
    q localq = (q)t.ap(q.class);
    AppMethodBeat.o(151138);
    return localq;
  }
  
  public static m aIG()
  {
    AppMethodBeat.i(151139);
    com.tencent.mm.kernel.g.agP().afT();
    m localm = (m)aIF().hXP.get();
    AppMethodBeat.o(151139);
    return localm;
  }
  
  public static void d(e parame)
  {
    AppMethodBeat.i(151140);
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.SubCoreStat", "dknetstat setNetworkMoniter  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bs.eWi() });
      if (parame != null) {
        parame.a(aIF().hXO);
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
      ac.d("MicroMsg.SubCoreStat", "setKVReportMonitor  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bs.eWi() });
      if (parame != null) {
        parame.a(aIF().hXQ);
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
    f.d.a(Integer.valueOf(9998), this.hXO);
    com.tencent.mm.kernel.g.agQ().a(this.hBi);
    com.tencent.mm.model.ar.a.hnx = new ar.e()
    {
      public final void cZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151135);
        ac.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), bs.eWi() });
        n.y(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151135);
      }
    };
    AppMethodBeat.o(151143);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151142);
    com.tencent.mm.kernel.g.agQ().b(this.hBi);
    f.d.b(Integer.valueOf(9998), this.hXO);
    this.hXO = new l();
    com.tencent.mm.model.ar.a.hnx = null;
    AppMethodBeat.o(151142);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.q
 * JD-Core Version:    0.7.0.1
 */