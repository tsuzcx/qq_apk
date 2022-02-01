package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.cm.c;
import com.tencent.mm.cm.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.au.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class q
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.network.n hWv;
  private l iue;
  private h<m> iuf;
  private aa iug;
  private h<g> iuh;
  
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
    this.iue = new l();
    this.iuf = new h(new c() {});
    this.iug = new aa();
    this.iuh = new h(new c() {});
    this.hWv = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(151134);
        if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
        {
          AppMethodBeat.o(151134);
          return;
        }
        com.tencent.mm.kernel.g.ajU().n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151132);
            if (!com.tencent.mm.kernel.g.ajP().aiZ())
            {
              AppMethodBeat.o(151132);
              return;
            }
            q.aMl().aMe();
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
        ae.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        o.run(2);
        AppMethodBeat.o(151134);
      }
    };
    AppMethodBeat.o(151136);
  }
  
  public static g aMl()
  {
    AppMethodBeat.i(151137);
    com.tencent.mm.kernel.g.ajP().aiU();
    g localg = (g)aMm().iuh.get();
    AppMethodBeat.o(151137);
    return localg;
  }
  
  private static q aMm()
  {
    AppMethodBeat.i(151138);
    q localq = (q)u.ap(q.class);
    AppMethodBeat.o(151138);
    return localq;
  }
  
  public static m aMn()
  {
    AppMethodBeat.i(151139);
    com.tencent.mm.kernel.g.ajP().aiU();
    m localm = (m)aMm().iuf.get();
    AppMethodBeat.o(151139);
    return localm;
  }
  
  public static void d(e parame)
  {
    AppMethodBeat.i(151140);
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.SubCoreStat", "dknetstat setNetworkMoniter  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bu.fpN() });
      if (parame != null) {
        parame.a(aMm().iue);
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
      ae.d("MicroMsg.SubCoreStat", "setKVReportMonitor  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), bu.fpN() });
      if (parame != null) {
        parame.a(aMm().iug);
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
    e.d.a(Integer.valueOf(9998), this.iue);
    com.tencent.mm.kernel.g.ajQ().a(this.hWv);
    com.tencent.mm.model.au.a.hIH = new au.e()
    {
      public final void db(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151135);
        ae.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), bu.fpN() });
        n.y(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151135);
      }
    };
    AppMethodBeat.o(151143);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151142);
    com.tencent.mm.kernel.g.ajQ().b(this.hWv);
    e.d.b(Integer.valueOf(9998), this.iue);
    this.iue = new l();
    com.tencent.mm.model.au.a.hIH = null;
    AppMethodBeat.o(151142);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.q
 * JD-Core Version:    0.7.0.1
 */