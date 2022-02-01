package com.tencent.mm.plugin.expt.d;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public class a
  implements com.tencent.mm.plugin.expt.d.b.c, com.tencent.mm.plugin.expt.d.d.b
{
  private static volatile a qXh;
  public com.tencent.mm.plugin.expt.d.d.a qXi;
  private com.tencent.mm.plugin.expt.d.a.c qXj;
  private com.tencent.mm.plugin.expt.d.a.c qXk;
  public com.tencent.mm.plugin.expt.d.i.b qXl;
  private com.tencent.mm.plugin.expt.d.g.a qXm;
  public com.tencent.mm.plugin.expt.d.c.a qXn;
  private ThreadPoolExecutor qXo;
  public com.tencent.mm.plugin.expt.d.b.a.a qXp;
  public com.tencent.mm.plugin.expt.d.b.b.a qXq;
  public aq qXr;
  private com.tencent.mm.sdk.b.c qXs;
  
  private a()
  {
    AppMethodBeat.i(195850);
    this.qXr = new aq("EdgeComputingMgr#mExecuteScriptHandler")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(195844);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(195844);
          return;
          a.a(a.this, true);
          AppMethodBeat.o(195844);
          return;
          a.a(a.this, false);
          AppMethodBeat.o(195844);
          return;
          a.a(a.this);
        }
      }
    };
    this.qXs = new com.tencent.mm.sdk.b.c() {};
    this.qXi = new com.tencent.mm.plugin.expt.d.d.a(this);
    this.qXj = com.tencent.mm.plugin.expt.d.a.b.Db(1);
    this.qXk = com.tencent.mm.plugin.expt.d.a.b.Db(2);
    this.qXm = new com.tencent.mm.plugin.expt.d.g.a();
    this.qXn = new com.tencent.mm.plugin.expt.d.c.a();
    this.qXp = new com.tencent.mm.plugin.expt.d.b.a.a();
    this.qXq = new com.tencent.mm.plugin.expt.d.b.b.a();
    this.qXl = new com.tencent.mm.plugin.expt.d.i.b();
    this.qXo = b.coy();
    com.tencent.mm.plugin.expt.d.b.b.coG().qXG = this;
    com.tencent.mm.sdk.b.a.IvT.b(this.qXs);
    AppMethodBeat.o(195850);
  }
  
  private Map<Long, List<List<com.tencent.mm.plugin.expt.d.e.b>>> a(com.tencent.mm.plugin.expt.d.h.a parama, com.tencent.mm.plugin.expt.d.e.a.b paramb, Map<Long, List<String>> paramMap, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195853);
    if ((paramb != null) && (paramMap.size() > 0))
    {
      localObject = this.qXp;
      str = paramb.qXW;
      if (!org.apache.commons.b.g.ef(str)) {
        break label53;
      }
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(195853);
      return null;
      label53:
      if (((com.tencent.mm.plugin.expt.d.b.a.a)localObject).qXO.containsKey(str))
      {
        ae.i("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] isErrorScriptConfig configID : ".concat(String.valueOf(str)));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    ae.d("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing configID : " + paramb.qXW);
    long l = SystemClock.uptimeMillis();
    Object localObject = this.qXp;
    String str = paramb.qXW;
    if (!org.apache.commons.b.g.ef(str))
    {
      ((com.tencent.mm.plugin.expt.d.b.a.a)localObject).qXQ.put(str, Long.valueOf(System.currentTimeMillis()));
      ((com.tencent.mm.plugin.expt.d.b.a.a)localObject).coL();
    }
    parama = parama.a(paramb, paramMap, paramLong1, paramLong2);
    paramMap = this.qXp;
    localObject = paramb.qXW;
    if (!org.apache.commons.b.g.ef((String)localObject))
    {
      paramMap.qXQ.remove(localObject);
      paramMap.coL();
    }
    if ((parama == null) || (parama.size() <= 0))
    {
      AppMethodBeat.o(195853);
      return null;
    }
    paramMap = parama.values().iterator();
    for (int i = 0; paramMap.hasNext(); i = ((List)paramMap.next()).size() + i) {}
    paramb = paramb.qXW;
    paramLong1 = SystemClock.uptimeMillis() - l;
    if (paramLong1 <= 10L) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 0L, 1L, false);
    }
    for (;;)
    {
      ae.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramb, Long.valueOf(paramLong1), Integer.valueOf(i) });
      AppMethodBeat.o(195853);
      return parama;
      if (paramLong1 <= 100L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 1L, 1L, false);
      }
      else if (paramLong1 <= 1000L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 2L, 1L, false);
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 3L, 1L, false);
        if (com.tencent.mm.plugin.expt.d.f.a.qYj == null)
        {
          com.tencent.mm.plugin.expt.d.f.a.qYj = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPv, false));
          ae.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.qYj);
        }
        if (com.tencent.mm.plugin.expt.d.f.a.qYj.booleanValue()) {
          com.tencent.mm.plugin.report.service.g.yxI.f(20176, new Object[] { paramb, Integer.valueOf(0), Long.valueOf(paramLong1), Integer.valueOf(i) });
        }
      }
    }
  }
  
  public static a cow()
  {
    AppMethodBeat.i(195851);
    if (qXh == null) {}
    try
    {
      if (qXh == null) {
        qXh = new a();
      }
      a locala = qXh;
      AppMethodBeat.o(195851);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(195851);
    }
  }
  
  private void cox()
  {
    AppMethodBeat.i(195854);
    Object localObject1 = com.tencent.mm.plugin.expt.d.b.b.coG().coJ();
    if (((List)localObject1).size() <= 0)
    {
      AppMethodBeat.o(195854);
      return;
    }
    ae.i("EdgeComputingMgr", "[EdgeComputingMgr] runSqlOnRegularTime!");
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (com.tencent.mm.plugin.expt.d.e.a.c)((Iterator)localObject1).next();
      Object localObject4 = this.qXp;
      Object localObject5 = ((com.tencent.mm.plugin.expt.d.e.a.c)???).qXW;
      if (!org.apache.commons.b.g.ef((String)localObject5))
      {
        ((com.tencent.mm.plugin.expt.d.b.a.a)localObject4).qXR.put(localObject5, Long.valueOf(System.currentTimeMillis()));
        ((com.tencent.mm.plugin.expt.d.b.a.a)localObject4).coL();
      }
      long l = SystemClock.uptimeMillis();
      localObject4 = this.qXn.fU(((com.tencent.mm.plugin.expt.d.e.a.c)???).dbPath, ((com.tencent.mm.plugin.expt.d.e.a.c)???).sql);
      localObject5 = ((com.tencent.mm.plugin.expt.d.e.a.c)???).qXW;
      l = SystemClock.uptimeMillis() - l;
      int i;
      if (localObject4 != null)
      {
        i = ((List)localObject4).size();
        label164:
        if (l > 10L) {
          break label325;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 12L, 1L, false);
      }
      for (;;)
      {
        ae.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statSQLQueryCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { localObject5, Long.valueOf(l), Integer.valueOf(i) });
        localObject5 = this.qXp;
        String str = ((com.tencent.mm.plugin.expt.d.e.a.c)???).qXW;
        if (!org.apache.commons.b.g.ef(str))
        {
          ((com.tencent.mm.plugin.expt.d.b.a.a)localObject5).qXR.remove(str);
          ((com.tencent.mm.plugin.expt.d.b.a.a)localObject5).coL();
        }
        if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
          break;
        }
        if (((com.tencent.mm.plugin.expt.d.e.a.c)???).qYb <= 0) {
          break label495;
        }
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          com.tencent.mm.plugin.expt.d.g.a.p((List)((Iterator)localObject4).next(), ((com.tencent.mm.plugin.expt.d.e.a.c)???).qYb);
        }
        i = 0;
        break label164;
        label325:
        if (l <= 100L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 13L, 1L, false);
        }
        else if (l <= 1000L)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 14L, 1L, false);
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 15L, 1L, false);
          if (com.tencent.mm.plugin.expt.d.f.a.qYj == null)
          {
            com.tencent.mm.plugin.expt.d.f.a.qYj = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPv, false));
            ae.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statRegularWorkTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.qYj);
          }
          if (com.tencent.mm.plugin.expt.d.f.a.qYj.booleanValue()) {
            com.tencent.mm.plugin.report.service.g.yxI.f(20176, new Object[] { localObject5, Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(i) });
          }
        }
      }
      label495:
      localObject4 = com.tencent.mm.plugin.expt.d.b.b.coG();
      localObject5 = ((com.tencent.mm.plugin.expt.d.e.a.c)???).qXW;
      if (!org.apache.commons.b.g.ef((String)localObject5))
      {
        ae.i("EdgeComputingConfigService", "[EdgeComputingConfigService] removeSqlConfigModel, configID : ".concat(String.valueOf(localObject5)));
        synchronized (((com.tencent.mm.plugin.expt.d.b.b)localObject4).qXD)
        {
          ((com.tencent.mm.plugin.expt.d.b.b)localObject4).qXD.remove(localObject5);
          ((com.tencent.mm.plugin.expt.d.b.b)localObject4).coK();
        }
      }
    }
    AppMethodBeat.o(195854);
  }
  
  public final void a(long paramLong, final com.tencent.mm.plugin.expt.d.e.a.b paramb, String paramString)
  {
    AppMethodBeat.i(195852);
    if ((paramb == null) || (org.apache.commons.b.g.ef(paramString)))
    {
      AppMethodBeat.o(195852);
      return;
    }
    ae.d("EdgeComputingMgr", "[EdgeComputingMgr] onDataReceive configID : " + paramb.qXW + ", data : " + paramString);
    if (this.qXl == null)
    {
      ae.e("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing please resetDB!");
      AppMethodBeat.o(195852);
      return;
    }
    com.tencent.mm.plugin.expt.d.f.a.l(paramb.qXW, 3, paramLong);
    final com.tencent.mm.plugin.expt.d.e.a locala = new com.tencent.mm.plugin.expt.d.e.a();
    locala.data = paramString;
    locala.qXW = paramb.qXW;
    locala.qXX = paramLong;
    this.qXr.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195847);
        long l = SystemClock.uptimeMillis();
        String str;
        if (paramb.qYd == 1)
        {
          a.c(a.this).a(locala);
          str = paramb.qXW;
          l = SystemClock.uptimeMillis() - l;
          if (l > 10L) {
            break label144;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 4L, 1L, false);
        }
        for (;;)
        {
          ae.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { str, Long.valueOf(l), Integer.valueOf(1) });
          com.tencent.mm.plugin.expt.d.f.a.l(paramb.qXW, 5, locala.qXX);
          AppMethodBeat.o(195847);
          return;
          a.d(a.this).a(locala);
          break;
          label144:
          if (l <= 100L)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 5L, 1L, false);
          }
          else if (l <= 1000L)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 6L, 1L, false);
          }
          else
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1409L, 7L, 1L, false);
            if (com.tencent.mm.plugin.expt.d.f.a.qYj == null)
            {
              com.tencent.mm.plugin.expt.d.f.a.qYj = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPv, false));
              ae.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.qYj);
            }
            if (com.tencent.mm.plugin.expt.d.f.a.qYj.booleanValue()) {
              com.tencent.mm.plugin.report.service.g.yxI.f(20176, new Object[] { str, Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(1) });
            }
          }
        }
      }
    });
    if (paramb.qYd == 1)
    {
      this.qXr.removeMessages(1003);
      this.qXr.sendEmptyMessageDelayed(1003, 30000L);
    }
    this.qXr.removeMessages(1002);
    this.qXr.sendEmptyMessageDelayed(1002, 3000L);
    AppMethodBeat.o(195852);
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(195855);
    if (paramb == null)
    {
      AppMethodBeat.o(195855);
      return;
    }
    ae.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigUpdate newConfig : " + paramb.qXW);
    AppMethodBeat.o(195855);
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.e.a.c paramc)
  {
    AppMethodBeat.i(195858);
    if (paramc == null)
    {
      AppMethodBeat.o(195858);
      return;
    }
    ae.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigUpdate newConfig : " + paramc.qXW);
    AppMethodBeat.o(195858);
  }
  
  public final void b(final com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(195856);
    if (paramb == null)
    {
      AppMethodBeat.o(195856);
      return;
    }
    ae.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigOffline offlineConfig : " + paramb.qXW);
    this.qXr.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195848);
        a.d(a.this).clear(paramb.qXW);
        a.c(a.this).clear(paramb.qXW);
        com.tencent.mm.plugin.expt.d.i.b localb = a.e(a.this);
        com.tencent.mm.plugin.expt.d.e.a.b localb1 = paramb;
        if ((localb.qYs == null) || (localb1 == null))
        {
          AppMethodBeat.o(195848);
          return;
        }
        new com.tencent.mm.plugin.expt.d.i.a(localb.qYs, localb1.qXW, localb1.qYc).coT();
        ae.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] clearAllData configID : " + localb1.qXW);
        AppMethodBeat.o(195848);
      }
    });
    AppMethodBeat.o(195856);
  }
  
  public final void b(com.tencent.mm.plugin.expt.d.e.a.c paramc)
  {
    AppMethodBeat.i(195859);
    if (paramc == null)
    {
      AppMethodBeat.o(195859);
      return;
    }
    ae.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigOffline offlineConfig : " + paramc.qXW);
    AppMethodBeat.o(195859);
  }
  
  public final void c(final com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(195857);
    if (paramb == null)
    {
      AppMethodBeat.o(195857);
      return;
    }
    if ((j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.fnF())) {
      this.qXr.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195849);
          if (paramb.qYe == 0)
          {
            com.tencent.mm.plugin.expt.d.b.b.a locala = a.f(a.this);
            String str = paramb.qXW;
            if (!org.apache.commons.b.g.ef(str)) {
              synchronized (locala.qXS)
              {
                locala.qXS.remove(str);
                locala.coN();
                AppMethodBeat.o(195849);
                return;
              }
            }
          }
          AppMethodBeat.o(195849);
        }
      });
    }
    ae.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigSame sameConfig : " + paramb.qXW);
    AppMethodBeat.o(195857);
  }
  
  public final void c(com.tencent.mm.plugin.expt.d.e.a.c paramc)
  {
    AppMethodBeat.i(195860);
    if (paramc == null)
    {
      AppMethodBeat.o(195860);
      return;
    }
    ae.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigSame sameConfig : " + paramc.qXW);
    AppMethodBeat.o(195860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a
 * JD-Core Version:    0.7.0.1
 */