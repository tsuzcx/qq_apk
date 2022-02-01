package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.co.c;
import com.tencent.mm.co.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ay.e;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class q
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private p iRt;
  private l jpq;
  private h<m> jpr;
  private ac jps;
  private h<g> jpt;
  
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
    this.jpq = new l();
    this.jpr = new h(new c() {});
    this.jps = new ac();
    this.jpt = new h(new c() {});
    this.iRt = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(151134);
        if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
        {
          AppMethodBeat.o(151134);
          return;
        }
        com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151132);
            if (!com.tencent.mm.kernel.g.aAf().azp())
            {
              AppMethodBeat.o(151132);
              return;
            }
            q.bgm().bgh();
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
        Log.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        o.run(2);
        AppMethodBeat.o(151134);
      }
    };
    AppMethodBeat.o(151136);
  }
  
  public static g bgm()
  {
    AppMethodBeat.i(151137);
    com.tencent.mm.kernel.g.aAf().azk();
    g localg = (g)bgn().jpt.get();
    AppMethodBeat.o(151137);
    return localg;
  }
  
  private static q bgn()
  {
    AppMethodBeat.i(151138);
    q localq = (q)y.at(q.class);
    AppMethodBeat.o(151138);
    return localq;
  }
  
  public static m bgo()
  {
    AppMethodBeat.i(151139);
    com.tencent.mm.kernel.g.aAf().azk();
    m localm = (m)bgn().jpr.get();
    AppMethodBeat.o(151139);
    return localm;
  }
  
  public static void d(com.tencent.mm.network.g paramg)
  {
    AppMethodBeat.i(151140);
    if (paramg == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SubCoreStat", "dknetstat setNetworkMoniter  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), Util.getStack() });
      if (paramg != null) {
        paramg.a(bgn().jpq);
      }
      AppMethodBeat.o(151140);
      return;
    }
  }
  
  public static void e(com.tencent.mm.network.g paramg)
  {
    AppMethodBeat.i(151141);
    if (paramg == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SubCoreStat", "setKVReportMonitor  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), Util.getStack() });
      if (paramg != null) {
        paramg.a(bgn().jps);
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
    h.d.a(Integer.valueOf(9998), this.jpq);
    com.tencent.mm.kernel.g.aAg().a(this.iRt);
    com.tencent.mm.model.ay.a.iDr = new ay.e()
    {
      public final void dl(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151135);
        Log.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), Util.getStack() });
        n.D(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151135);
      }
    };
    AppMethodBeat.o(151143);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151142);
    com.tencent.mm.kernel.g.aAg().b(this.iRt);
    h.d.b(Integer.valueOf(9998), this.jpq);
    this.jpq = new l();
    com.tencent.mm.model.ay.a.iDr = null;
    AppMethodBeat.o(151142);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.q
 * JD-Core Version:    0.7.0.1
 */