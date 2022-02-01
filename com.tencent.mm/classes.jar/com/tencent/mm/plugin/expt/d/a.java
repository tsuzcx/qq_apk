package com.tencent.mm.plugin.expt.d;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.g;

public class a
  implements com.tencent.mm.plugin.expt.d.c.c, com.tencent.mm.plugin.expt.d.e.b
{
  private static volatile a wcX;
  public com.tencent.mm.plugin.expt.d.e.a wcY;
  private com.tencent.mm.plugin.expt.d.a.c wcZ;
  private com.tencent.mm.plugin.expt.d.a.c wda;
  public com.tencent.mm.plugin.expt.d.j.b wdb;
  private com.tencent.mm.plugin.expt.d.h.a wdc;
  public com.tencent.mm.plugin.expt.d.d.a wdd;
  public com.tencent.mm.plugin.expt.d.c.a.a wde;
  public com.tencent.mm.plugin.expt.d.c.b.a wdf;
  public MMHandler wdg;
  private IListener wdh;
  
  private a()
  {
    AppMethodBeat.i(254597);
    this.wdg = new MMHandler("EdgeComputingMgr#mExecuteScriptHandler")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(255124);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(255124);
          return;
          a.a(a.this, true);
          AppMethodBeat.o(255124);
          return;
          a.a(a.this, false);
          AppMethodBeat.o(255124);
          return;
          a.a(a.this);
        }
      }
    };
    this.wdh = new a.2(this);
    this.wcY = new com.tencent.mm.plugin.expt.d.e.a(this);
    this.wcZ = com.tencent.mm.plugin.expt.d.a.b.Ku(1);
    this.wda = com.tencent.mm.plugin.expt.d.a.b.Ku(2);
    this.wdc = new com.tencent.mm.plugin.expt.d.h.a();
    this.wdd = new com.tencent.mm.plugin.expt.d.d.a();
    this.wde = new com.tencent.mm.plugin.expt.d.c.a.a();
    this.wdf = new com.tencent.mm.plugin.expt.d.c.b.a();
    this.wdb = new com.tencent.mm.plugin.expt.d.j.b();
    com.tencent.mm.plugin.expt.d.c.b.dbG().wdw = this;
    EventCenter.instance.add(this.wdh);
    AppMethodBeat.o(254597);
  }
  
  private Map<Long, List<List<com.tencent.mm.plugin.expt.d.f.b>>> a(com.tencent.mm.plugin.expt.d.i.a parama, com.tencent.mm.plugin.expt.d.f.a.b paramb, Map<Long, List<String>> paramMap, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(254610);
    if ((parama != null) && (paramb != null) && (paramMap.size() > 0))
    {
      locala = this.wde;
      str = paramb.wdY;
      if (!g.fK(str)) {
        break label57;
      }
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(254610);
      return null;
      label57:
      if ((!b.No()) && (locala.wdQ.containsKey(str)))
      {
        Log.i("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] isErrorScriptConfig configID : ".concat(String.valueOf(str)));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    long l = SystemClock.uptimeMillis();
    com.tencent.mm.plugin.expt.d.c.a.a locala = this.wde;
    String str = paramb.wdY;
    if (!g.fK(str))
    {
      locala.wdS.put(str, Long.valueOf(System.currentTimeMillis()));
      locala.dbM();
    }
    parama = parama.a(paramb, paramMap, paramLong1, paramLong2);
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing configID : " + paramb.wdY);
    Log.d("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing configID : " + paramb.wdY + ", ecResult : " + parama);
    locala = this.wde;
    str = paramb.wdY;
    if (!g.fK(str))
    {
      locala.wdS.remove(str);
      locala.dbM();
    }
    paramMap = paramMap.values().iterator();
    for (int i = 0; paramMap.hasNext(); i = ((List)paramMap.next()).size() + i) {}
    paramb = paramb.wdY;
    paramLong1 = SystemClock.uptimeMillis() - l;
    if (paramLong1 <= 10L) {
      h.IzE.idkeyStat(1409L, 0L, 1L, false);
    }
    for (;;)
    {
      if (paramLong1 <= 1000L)
      {
        h.IzE.idkeyStat(1409L, 34L, paramLong1, false);
        h.IzE.idkeyStat(1409L, 35L, 1L, false);
      }
      h.IzE.idkeyStat(1409L, 89L, 1L, false);
      if (com.tencent.mm.plugin.expt.d.g.a.dbP()) {
        h.IzE.a(20176, new Object[] { paramb, Integer.valueOf(0), Long.valueOf(paramLong1), Integer.valueOf(i) });
      }
      Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramb, Long.valueOf(paramLong1), Integer.valueOf(i) });
      AppMethodBeat.o(254610);
      return parama;
      if (paramLong1 <= 100L) {
        h.IzE.idkeyStat(1409L, 1L, 1L, false);
      } else if (paramLong1 <= 1000L) {
        h.IzE.idkeyStat(1409L, 2L, 1L, false);
      } else {
        h.IzE.idkeyStat(1409L, 3L, 1L, false);
      }
    }
  }
  
  public static a dbw()
  {
    AppMethodBeat.i(254599);
    if (wcX == null) {}
    try
    {
      if (wcX == null) {
        wcX = new a();
      }
      a locala = wcX;
      AppMethodBeat.o(254599);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(254599);
    }
  }
  
  private void dbx()
  {
    AppMethodBeat.i(254617);
    Object localObject1 = com.tencent.mm.plugin.expt.d.c.b.dbG().dbJ();
    if (((List)localObject1).size() <= 0)
    {
      AppMethodBeat.o(254617);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] runSqlOnRegularTime!");
    Iterator localIterator1 = ((List)localObject1).iterator();
    while (localIterator1.hasNext())
    {
      Object localObject4 = (com.tencent.mm.plugin.expt.d.f.a.c)localIterator1.next();
      if ((!g.fK(((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).sql)) && (g.oC(MD5Util.getMD5String(((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).sql), ((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).weo)))
      {
        localObject1 = this.wde;
        ??? = ((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).wdY;
        if (!g.fK((String)???))
        {
          ((com.tencent.mm.plugin.expt.d.c.a.a)localObject1).wdT.put(???, Long.valueOf(System.currentTimeMillis()));
          ((com.tencent.mm.plugin.expt.d.c.a.a)localObject1).dbM();
        }
        long l = SystemClock.uptimeMillis();
        localObject1 = awi(((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).sql);
        ??? = ((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).wdY;
        l = SystemClock.uptimeMillis() - l;
        int i;
        label208:
        Object localObject5;
        if (localObject1 != null)
        {
          i = ((List)localObject1).size();
          if (l > 10L) {
            break label563;
          }
          h.IzE.idkeyStat(1409L, 12L, 1L, false);
          if (l <= 1000L)
          {
            h.IzE.idkeyStat(1409L, 47L, l, false);
            h.IzE.idkeyStat(1409L, 48L, 1L, false);
          }
          h.IzE.idkeyStat(1409L, 92L, 1L, false);
          if (com.tencent.mm.plugin.expt.d.g.a.dbP()) {
            h.IzE.a(20176, new Object[] { ???, Integer.valueOf(3), Long.valueOf(l), Integer.valueOf(i) });
          }
          Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statSQLQueryCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { ???, Long.valueOf(l), Integer.valueOf(i) });
          ??? = this.wde;
          localObject5 = ((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).wdY;
          if (!g.fK((String)localObject5))
          {
            ((com.tencent.mm.plugin.expt.d.c.a.a)???).wdT.remove(localObject5);
            ((com.tencent.mm.plugin.expt.d.c.a.a)???).dbM();
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            continue;
          }
          if (((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).wed <= 0) {
            break label658;
          }
          localObject5 = ((List)localObject1).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject5).hasNext()) {
            break label658;
          }
          List localList = (List)((Iterator)localObject5).next();
          if (((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).wej == 1)
          {
            String str = ((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).wdY;
            i = ((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).wed;
            if ((!g.fK(str)) && (i > 0) && (localList != null) && (localList.size() > 0))
            {
              ArrayList localArrayList = new ArrayList();
              Iterator localIterator2 = localList.iterator();
              for (;;)
              {
                if (localIterator2.hasNext())
                {
                  ??? = (String)localIterator2.next();
                  localObject1 = ???;
                  if (((String)???).contains(",")) {
                    localObject1 = ((String)???).replace(",", "\\$");
                  }
                  localArrayList.add(localObject1);
                  continue;
                  i = 0;
                  break;
                  label563:
                  if (l <= 100L)
                  {
                    h.IzE.idkeyStat(1409L, 13L, 1L, false);
                    break label208;
                  }
                  if (l <= 1000L)
                  {
                    h.IzE.idkeyStat(1409L, 14L, 1L, false);
                    break label208;
                  }
                  h.IzE.idkeyStat(1409L, 15L, 1L, false);
                  break label208;
                }
              }
              com.tencent.mm.plugin.expt.d.h.b.J(str, i, com.tencent.mm.plugin.expt.d.h.a.dt(localList));
            }
          }
          else
          {
            com.tencent.mm.plugin.expt.d.h.a.g(((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).wed, localList);
          }
        }
        label658:
        localObject1 = com.tencent.mm.plugin.expt.d.c.b.dbG();
        localObject4 = ((com.tencent.mm.plugin.expt.d.f.a.c)localObject4).wdY;
        if (!g.fK((String)localObject4))
        {
          Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] removeSqlConfigModel, configID : ".concat(String.valueOf(localObject4)));
          synchronized (((com.tencent.mm.plugin.expt.d.c.b)localObject1).wdt)
          {
            ((com.tencent.mm.plugin.expt.d.c.b)localObject1).wdt.remove(localObject4);
            ((com.tencent.mm.plugin.expt.d.c.b)localObject1).dbK();
          }
        }
      }
    }
    this.wdc.dbQ();
    AppMethodBeat.o(254617);
  }
  
  public final void a(long paramLong, final com.tencent.mm.plugin.expt.d.f.a.b paramb, String paramString)
  {
    AppMethodBeat.i(254605);
    if ((paramb == null) || (g.fK(paramString)))
    {
      AppMethodBeat.o(254605);
      return;
    }
    Log.d("EdgeComputingMgr", "[EdgeComputingMgr] onDataReceive configID : " + paramb.wdY + ", data : " + paramString);
    com.tencent.mm.plugin.expt.d.g.a.l(paramb.wdY, 3, paramLong);
    final com.tencent.mm.plugin.expt.d.f.a locala = new com.tencent.mm.plugin.expt.d.f.a();
    locala.data = paramString;
    locala.wdY = paramb.wdY;
    locala.wdZ = paramLong;
    this.wdg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(251972);
        long l = SystemClock.uptimeMillis();
        String str;
        if (paramb.wef == 1)
        {
          a.c(a.this).a(locala);
          a.b(a.this).removeMessages(1003);
          a.b(a.this).sendEmptyMessageDelayed(1003, 30000L);
          str = paramb.wdY;
          l = SystemClock.uptimeMillis() - l;
          if (l > 10L) {
            break label268;
          }
          h.IzE.idkeyStat(1409L, 4L, 1L, false);
        }
        for (;;)
        {
          if (l <= 1000L)
          {
            h.IzE.idkeyStat(1409L, 43L, l, false);
            h.IzE.idkeyStat(1409L, 44L, 1L, false);
          }
          h.IzE.idkeyStat(1409L, 90L, 1L, false);
          if (com.tencent.mm.plugin.expt.d.g.a.dbP()) {
            h.IzE.a(20176, new Object[] { str, Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(1) });
          }
          Log.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { str, Long.valueOf(l), Integer.valueOf(1) });
          com.tencent.mm.plugin.expt.d.g.a.l(paramb.wdY, 5, locala.wdZ);
          AppMethodBeat.o(251972);
          return;
          a.d(a.this).a(locala);
          break;
          label268:
          if (l <= 100L) {
            h.IzE.idkeyStat(1409L, 5L, 1L, false);
          } else if (l <= 1000L) {
            h.IzE.idkeyStat(1409L, 6L, 1L, false);
          } else {
            h.IzE.idkeyStat(1409L, 7L, 1L, false);
          }
        }
      }
    });
    this.wdg.removeMessages(1002);
    this.wdg.sendEmptyMessageDelayed(1002, 3000L);
    AppMethodBeat.o(254605);
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.f.a.b paramb)
  {
    AppMethodBeat.i(254621);
    if (paramb == null)
    {
      AppMethodBeat.o(254621);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigUpdate newConfig : " + paramb.wdY);
    AppMethodBeat.o(254621);
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.f.a.c paramc)
  {
    AppMethodBeat.i(254627);
    if (paramc == null)
    {
      AppMethodBeat.o(254627);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigUpdate newConfig : " + paramc.wdY);
    AppMethodBeat.o(254627);
  }
  
  public final List<List<String>> awi(String paramString)
  {
    AppMethodBeat.i(254619);
    if (g.fK(paramString))
    {
      AppMethodBeat.o(254619);
      return null;
    }
    paramString = this.wdd.gB("Edge.db", paramString);
    AppMethodBeat.o(254619);
    return paramString;
  }
  
  public final void b(final com.tencent.mm.plugin.expt.d.f.a.b paramb)
  {
    AppMethodBeat.i(254623);
    if (paramb == null)
    {
      AppMethodBeat.o(254623);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigOffline offlineConfig : " + paramb.wdY);
    this.wdg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(255475);
        a.d(a.this).clear(paramb.wdY);
        a.c(a.this).clear(paramb.wdY);
        com.tencent.mm.plugin.expt.d.j.b localb = a.e(a.this);
        com.tencent.mm.plugin.expt.d.f.a.b localb1 = paramb;
        if ((localb.wex == null) || (localb1 == null))
        {
          AppMethodBeat.o(255475);
          return;
        }
        new com.tencent.mm.plugin.expt.d.j.a(localb.wex, localb1.wdY, localb1.wee).dbY();
        Log.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] clearAllData configID : " + localb1.wdY);
        AppMethodBeat.o(255475);
      }
    });
    AppMethodBeat.o(254623);
  }
  
  public final void b(com.tencent.mm.plugin.expt.d.f.a.c paramc)
  {
    AppMethodBeat.i(254630);
    if (paramc == null)
    {
      AppMethodBeat.o(254630);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigOffline offlineConfig : " + paramc.wdY);
    AppMethodBeat.o(254630);
  }
  
  public final void c(final com.tencent.mm.plugin.expt.d.f.a.b paramb)
  {
    AppMethodBeat.i(254626);
    if (paramb == null)
    {
      AppMethodBeat.o(254626);
      return;
    }
    if (b.No()) {
      this.wdg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250960);
          if (paramb.weg == 0)
          {
            com.tencent.mm.plugin.expt.d.c.b.a locala = a.f(a.this);
            String str = paramb.wdY;
            if (!g.fK(str)) {
              synchronized (locala.wdU)
              {
                locala.wdU.remove(str);
                locala.dbO();
                AppMethodBeat.o(250960);
                return;
              }
            }
          }
          AppMethodBeat.o(250960);
        }
      });
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigSame sameConfig : " + paramb.wdY);
    AppMethodBeat.o(254626);
  }
  
  public final void c(com.tencent.mm.plugin.expt.d.f.a.c paramc)
  {
    AppMethodBeat.i(254633);
    if (paramc == null)
    {
      AppMethodBeat.o(254633);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigSame sameConfig : " + paramc.wdY);
    AppMethodBeat.o(254633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a
 * JD-Core Version:    0.7.0.1
 */