package com.tencent.mm.plugin.expt.d;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.l;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public class a
  implements com.tencent.mm.plugin.expt.d.b.c, com.tencent.mm.plugin.expt.d.d.b
{
  private static volatile a sxr;
  public com.tencent.mm.plugin.expt.d.b.b.a sxA;
  public MMHandler sxB;
  private IListener sxC;
  public com.tencent.mm.plugin.expt.d.d.a sxs;
  private com.tencent.mm.plugin.expt.d.a.c sxt;
  private com.tencent.mm.plugin.expt.d.a.c sxu;
  public com.tencent.mm.plugin.expt.d.i.b sxv;
  private com.tencent.mm.plugin.expt.d.g.a sxw;
  public com.tencent.mm.plugin.expt.d.c.a sxx;
  private ThreadPoolExecutor sxy;
  public com.tencent.mm.plugin.expt.d.b.a.a sxz;
  
  private a()
  {
    AppMethodBeat.i(220270);
    this.sxB = new MMHandler("EdgeComputingMgr#mExecuteScriptHandler")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(220264);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(220264);
          return;
          a.a(a.this, true);
          AppMethodBeat.o(220264);
          return;
          a.a(a.this, false);
          AppMethodBeat.o(220264);
          return;
          a.a(a.this);
        }
      }
    };
    this.sxC = new IListener() {};
    this.sxs = new com.tencent.mm.plugin.expt.d.d.a(this);
    this.sxt = com.tencent.mm.plugin.expt.d.a.b.GM(1);
    this.sxu = com.tencent.mm.plugin.expt.d.a.b.GM(2);
    this.sxw = new com.tencent.mm.plugin.expt.d.g.a();
    this.sxx = new com.tencent.mm.plugin.expt.d.c.a();
    this.sxz = new com.tencent.mm.plugin.expt.d.b.a.a();
    this.sxA = new com.tencent.mm.plugin.expt.d.b.b.a();
    this.sxv = new com.tencent.mm.plugin.expt.d.i.b();
    this.sxy = b.cMK();
    com.tencent.mm.plugin.expt.d.b.b.cMS().sxQ = this;
    EventCenter.instance.add(this.sxC);
    AppMethodBeat.o(220270);
  }
  
  private Map<Long, List<List<com.tencent.mm.plugin.expt.d.e.b>>> a(com.tencent.mm.plugin.expt.d.h.a parama, com.tencent.mm.plugin.expt.d.e.a.b paramb, Map<Long, List<String>> paramMap, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220273);
    if ((parama != null) && (paramb != null) && (paramMap.size() > 0))
    {
      localObject = this.sxz;
      str = paramb.syg;
      if (!org.apache.commons.b.g.eP(str)) {
        break label57;
      }
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(220273);
      return null;
      label57:
      if ((!b.KB()) && (((com.tencent.mm.plugin.expt.d.b.a.a)localObject).sxY.containsKey(str)))
      {
        Log.i("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] isErrorScriptConfig configID : ".concat(String.valueOf(str)));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    Log.d("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing configID : " + paramb.syg);
    long l = SystemClock.uptimeMillis();
    Object localObject = this.sxz;
    String str = paramb.syg;
    if (!org.apache.commons.b.g.eP(str))
    {
      ((com.tencent.mm.plugin.expt.d.b.a.a)localObject).sya.put(str, Long.valueOf(System.currentTimeMillis()));
      ((com.tencent.mm.plugin.expt.d.b.a.a)localObject).cMX();
    }
    parama = parama.a(paramb, paramMap, paramLong1, paramLong2);
    paramMap = this.sxz;
    localObject = paramb.syg;
    if (!org.apache.commons.b.g.eP((String)localObject))
    {
      paramMap.sya.remove(localObject);
      paramMap.cMX();
    }
    if ((parama == null) || (parama.size() <= 0))
    {
      AppMethodBeat.o(220273);
      return null;
    }
    paramMap = parama.values().iterator();
    for (int i = 0; paramMap.hasNext(); i = ((List)paramMap.next()).size() + i) {}
    paramb = paramb.syg;
    paramLong1 = SystemClock.uptimeMillis() - l;
    if (paramLong1 <= 10L) {
      h.CyF.idkeyStat(1409L, 0L, 1L, false);
    }
    for (;;)
    {
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramb, Long.valueOf(paramLong1), Integer.valueOf(i) });
      AppMethodBeat.o(220273);
      return parama;
      if (paramLong1 <= 100L)
      {
        h.CyF.idkeyStat(1409L, 1L, 1L, false);
      }
      else if (paramLong1 <= 1000L)
      {
        h.CyF.idkeyStat(1409L, 2L, 1L, false);
      }
      else
      {
        h.CyF.idkeyStat(1409L, 3L, 1L, false);
        if (com.tencent.mm.plugin.expt.d.f.a.syv == null)
        {
          com.tencent.mm.plugin.expt.d.f.a.syv = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smE, false));
          Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.syv);
        }
        if (com.tencent.mm.plugin.expt.d.f.a.syv.booleanValue()) {
          h.CyF.a(20176, new Object[] { paramb, Integer.valueOf(0), Long.valueOf(paramLong1), Integer.valueOf(i) });
        }
      }
    }
  }
  
  public static a cMI()
  {
    AppMethodBeat.i(220271);
    if (sxr == null) {}
    try
    {
      if (sxr == null) {
        sxr = new a();
      }
      a locala = sxr;
      AppMethodBeat.o(220271);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(220271);
    }
  }
  
  private void cMJ()
  {
    AppMethodBeat.i(220274);
    Object localObject1 = com.tencent.mm.plugin.expt.d.b.b.cMS().cMV();
    if (((List)localObject1).size() <= 0)
    {
      AppMethodBeat.o(220274);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] runSqlOnRegularTime!");
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (com.tencent.mm.plugin.expt.d.e.a.c)((Iterator)localObject1).next();
      if (org.apache.commons.b.g.equals(MD5Util.getMD5String(((com.tencent.mm.plugin.expt.d.e.a.c)???).sql), ((com.tencent.mm.plugin.expt.d.e.a.c)???).syt))
      {
        Object localObject4 = this.sxz;
        Object localObject5 = ((com.tencent.mm.plugin.expt.d.e.a.c)???).syg;
        if (!org.apache.commons.b.g.eP((String)localObject5))
        {
          ((com.tencent.mm.plugin.expt.d.b.a.a)localObject4).syb.put(localObject5, Long.valueOf(System.currentTimeMillis()));
          ((com.tencent.mm.plugin.expt.d.b.a.a)localObject4).cMX();
        }
        long l = SystemClock.uptimeMillis();
        localObject4 = aok(((com.tencent.mm.plugin.expt.d.e.a.c)???).sql);
        localObject5 = ((com.tencent.mm.plugin.expt.d.e.a.c)???).syg;
        l = SystemClock.uptimeMillis() - l;
        int i;
        if (localObject4 != null)
        {
          i = ((List)localObject4).size();
          label175:
          if (l > 10L) {
            break label336;
          }
          h.CyF.idkeyStat(1409L, 12L, 1L, false);
        }
        for (;;)
        {
          Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statSQLQueryCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { localObject5, Long.valueOf(l), Integer.valueOf(i) });
          localObject5 = this.sxz;
          String str = ((com.tencent.mm.plugin.expt.d.e.a.c)???).syg;
          if (!org.apache.commons.b.g.eP(str))
          {
            ((com.tencent.mm.plugin.expt.d.b.a.a)localObject5).syb.remove(str);
            ((com.tencent.mm.plugin.expt.d.b.a.a)localObject5).cMX();
          }
          if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
            break;
          }
          if (((com.tencent.mm.plugin.expt.d.e.a.c)???).syl <= 0) {
            break label506;
          }
          localObject4 = ((List)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            com.tencent.mm.plugin.expt.d.g.a.q((List)((Iterator)localObject4).next(), ((com.tencent.mm.plugin.expt.d.e.a.c)???).syl);
          }
          i = 0;
          break label175;
          label336:
          if (l <= 100L)
          {
            h.CyF.idkeyStat(1409L, 13L, 1L, false);
          }
          else if (l <= 1000L)
          {
            h.CyF.idkeyStat(1409L, 14L, 1L, false);
          }
          else
          {
            h.CyF.idkeyStat(1409L, 15L, 1L, false);
            if (com.tencent.mm.plugin.expt.d.f.a.syv == null)
            {
              com.tencent.mm.plugin.expt.d.f.a.syv = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smE, false));
              Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statRegularWorkTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.syv);
            }
            if (com.tencent.mm.plugin.expt.d.f.a.syv.booleanValue()) {
              h.CyF.a(20176, new Object[] { localObject5, Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(i) });
            }
          }
        }
        label506:
        localObject4 = com.tencent.mm.plugin.expt.d.b.b.cMS();
        localObject5 = ((com.tencent.mm.plugin.expt.d.e.a.c)???).syg;
        if (!org.apache.commons.b.g.eP((String)localObject5))
        {
          Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] removeSqlConfigModel, configID : ".concat(String.valueOf(localObject5)));
          synchronized (((com.tencent.mm.plugin.expt.d.b.b)localObject4).sxN)
          {
            ((com.tencent.mm.plugin.expt.d.b.b)localObject4).sxN.remove(localObject5);
            ((com.tencent.mm.plugin.expt.d.b.b)localObject4).cMW();
          }
        }
      }
    }
    AppMethodBeat.o(220274);
  }
  
  public final void a(long paramLong, final com.tencent.mm.plugin.expt.d.e.a.b paramb, String paramString)
  {
    AppMethodBeat.i(220272);
    if ((paramb == null) || (org.apache.commons.b.g.eP(paramString)))
    {
      AppMethodBeat.o(220272);
      return;
    }
    Log.d("EdgeComputingMgr", "[EdgeComputingMgr] onDataReceive configID : " + paramb.syg + ", data : " + paramString);
    if (this.sxv == null)
    {
      Log.e("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing please resetDB!");
      AppMethodBeat.o(220272);
      return;
    }
    com.tencent.mm.plugin.expt.d.f.a.k(paramb.syg, 3, paramLong);
    final com.tencent.mm.plugin.expt.d.e.a locala = new com.tencent.mm.plugin.expt.d.e.a();
    locala.data = paramString;
    locala.syg = paramb.syg;
    locala.syh = paramLong;
    this.sxB.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220267);
        long l = SystemClock.uptimeMillis();
        String str;
        if (paramb.syn == 1)
        {
          a.c(a.this).a(locala);
          a.b(a.this).removeMessages(1003);
          a.b(a.this).sendEmptyMessageDelayed(1003, 30000L);
          str = paramb.syg;
          l = SystemClock.uptimeMillis() - l;
          if (l > 10L) {
            break label174;
          }
          h.CyF.idkeyStat(1409L, 4L, 1L, false);
        }
        for (;;)
        {
          Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { str, Long.valueOf(l), Integer.valueOf(1) });
          com.tencent.mm.plugin.expt.d.f.a.k(paramb.syg, 5, locala.syh);
          AppMethodBeat.o(220267);
          return;
          a.d(a.this).a(locala);
          break;
          label174:
          if (l <= 100L)
          {
            h.CyF.idkeyStat(1409L, 5L, 1L, false);
          }
          else if (l <= 1000L)
          {
            h.CyF.idkeyStat(1409L, 6L, 1L, false);
          }
          else
          {
            h.CyF.idkeyStat(1409L, 7L, 1L, false);
            if (com.tencent.mm.plugin.expt.d.f.a.syv == null)
            {
              com.tencent.mm.plugin.expt.d.f.a.syv = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smE, false));
              Log.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.syv);
            }
            if (com.tencent.mm.plugin.expt.d.f.a.syv.booleanValue()) {
              h.CyF.a(20176, new Object[] { str, Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(1) });
            }
          }
        }
      }
    });
    this.sxB.removeMessages(1002);
    this.sxB.sendEmptyMessageDelayed(1002, 3000L);
    AppMethodBeat.o(220272);
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(220276);
    if (paramb == null)
    {
      AppMethodBeat.o(220276);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigUpdate newConfig : " + paramb.syg);
    AppMethodBeat.o(220276);
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.e.a.c paramc)
  {
    AppMethodBeat.i(220279);
    if (paramc == null)
    {
      AppMethodBeat.o(220279);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigUpdate newConfig : " + paramc.syg);
    AppMethodBeat.o(220279);
  }
  
  public final List<List<String>> aok(String paramString)
  {
    AppMethodBeat.i(220275);
    if (org.apache.commons.b.g.eP(paramString))
    {
      AppMethodBeat.o(220275);
      return null;
    }
    paramString = this.sxx.gn("Edge.db", paramString);
    AppMethodBeat.o(220275);
    return paramString;
  }
  
  public final void b(final com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(220277);
    if (paramb == null)
    {
      AppMethodBeat.o(220277);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigOffline offlineConfig : " + paramb.syg);
    this.sxB.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220268);
        a.d(a.this).clear(paramb.syg);
        a.c(a.this).clear(paramb.syg);
        com.tencent.mm.plugin.expt.d.i.b localb = a.e(a.this);
        com.tencent.mm.plugin.expt.d.e.a.b localb1 = paramb;
        if ((localb.syB == null) || (localb1 == null))
        {
          AppMethodBeat.o(220268);
          return;
        }
        new com.tencent.mm.plugin.expt.d.i.a(localb.syB, localb1.syg, localb1.sym).cNg();
        Log.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] clearAllData configID : " + localb1.syg);
        AppMethodBeat.o(220268);
      }
    });
    AppMethodBeat.o(220277);
  }
  
  public final void b(com.tencent.mm.plugin.expt.d.e.a.c paramc)
  {
    AppMethodBeat.i(220280);
    if (paramc == null)
    {
      AppMethodBeat.o(220280);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigOffline offlineConfig : " + paramc.syg);
    AppMethodBeat.o(220280);
  }
  
  public final void c(final com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(220278);
    if (paramb == null)
    {
      AppMethodBeat.o(220278);
      return;
    }
    if (b.KB()) {
      this.sxB.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220269);
          if (paramb.syo == 0)
          {
            com.tencent.mm.plugin.expt.d.b.b.a locala = a.f(a.this);
            String str = paramb.syg;
            if (!org.apache.commons.b.g.eP(str)) {
              synchronized (locala.syc)
              {
                locala.syc.remove(str);
                locala.cMZ();
                AppMethodBeat.o(220269);
                return;
              }
            }
          }
          AppMethodBeat.o(220269);
        }
      });
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigSame sameConfig : " + paramb.syg);
    AppMethodBeat.o(220278);
  }
  
  public final void c(com.tencent.mm.plugin.expt.d.e.a.c paramc)
  {
    AppMethodBeat.i(220281);
    if (paramc == null)
    {
      AppMethodBeat.o(220281);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigSame sameConfig : " + paramc.syg);
    AppMethodBeat.o(220281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a
 * JD-Core Version:    0.7.0.1
 */