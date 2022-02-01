package com.tencent.mm.modelstat;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.az.e;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.g;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.network.p lHL;
  private k meI;
  private com.tencent.mm.cw.h<l> meJ;
  private ac meK;
  private com.tencent.mm.cw.h<f> meL;
  
  static
  {
    AppMethodBeat.i(151144);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    AppMethodBeat.o(151144);
  }
  
  public p()
  {
    AppMethodBeat.i(151136);
    this.meI = new k();
    this.meJ = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.meK = new ac();
    this.meL = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.lHL = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(151134);
        if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
        {
          AppMethodBeat.o(151134);
          return;
        }
        com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151132);
            if (!com.tencent.mm.kernel.h.aHE().aGM())
            {
              AppMethodBeat.o(151132);
              return;
            }
            p.bpB().bpv();
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
        AppMethodBeat.o(151134);
      }
    };
    AppMethodBeat.o(151136);
  }
  
  public static f bpB()
  {
    AppMethodBeat.i(151137);
    com.tencent.mm.kernel.h.aHE().aGH();
    f localf = (f)bpC().meL.get();
    AppMethodBeat.o(151137);
    return localf;
  }
  
  private static p bpC()
  {
    AppMethodBeat.i(151138);
    p localp = (p)y.as(p.class);
    AppMethodBeat.o(151138);
    return localp;
  }
  
  public static l bpD()
  {
    AppMethodBeat.i(151139);
    com.tencent.mm.kernel.h.aHE().aGH();
    l locall = (l)bpC().meJ.get();
    AppMethodBeat.o(151139);
    return locall;
  }
  
  public static void d(g paramg)
  {
    AppMethodBeat.i(151140);
    if (paramg == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SubCoreStat", "dknetstat setNetworkMoniter  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), Util.getStack() });
      if (paramg != null) {
        paramg.a(bpC().meI);
      }
      AppMethodBeat.o(151140);
      return;
    }
  }
  
  public static void e(g paramg)
  {
    AppMethodBeat.i(151141);
    if (paramg == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SubCoreStat", "setKVReportMonitor  isnull:%b  ,  %s ", new Object[] { Boolean.valueOf(bool), Util.getStack() });
      if (paramg != null) {
        paramg.a(bpC().meK);
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
    h.d.a(Integer.valueOf(9998), this.meI);
    com.tencent.mm.kernel.h.aHF().a(this.lHL);
    com.tencent.mm.model.az.a.lts = new az.e()
    {
      public final void dH(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(151135);
        Log.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), Util.getStack() });
        com.tencent.e.h.ZvG.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194066);
            m.b(paramAnonymousInt1, paramAnonymousInt2, this.val$type);
            AppMethodBeat.o(194066);
          }
        }, "SubCoreStat-NetStatStorageLogic");
        AppMethodBeat.o(151135);
      }
    };
    AppMethodBeat.o(151143);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151142);
    com.tencent.mm.kernel.h.aHF().b(this.lHL);
    h.d.b(Integer.valueOf(9998), this.meI);
    this.meI = new k();
    com.tencent.mm.model.az.a.lts = null;
    AppMethodBeat.o(151142);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.p
 * JD-Core Version:    0.7.0.1
 */