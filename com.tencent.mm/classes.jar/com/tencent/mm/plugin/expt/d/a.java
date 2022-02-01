package com.tencent.mm.plugin.expt.d;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

public class a
  implements com.tencent.mm.plugin.expt.d.b.c, com.tencent.mm.plugin.expt.d.d.b
{
  private static volatile a qPm;
  public com.tencent.mm.plugin.expt.d.d.a qPn;
  private com.tencent.mm.plugin.expt.d.a.a qPo;
  public com.tencent.mm.plugin.expt.d.i.b qPp;
  private com.tencent.mm.plugin.expt.d.g.a qPq;
  private com.tencent.mm.plugin.expt.d.c.a qPr;
  private ThreadPoolExecutor qPs;
  private com.tencent.mm.plugin.expt.d.b.a.a qPt;
  private ap qPu;
  private com.tencent.mm.sdk.b.c qPv;
  
  private a()
  {
    AppMethodBeat.i(210211);
    this.qPu = new ap("EdgeComputingMgr#mExecuteScriptHandler")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(210203);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(210203);
          return;
          a.a(a.this, true);
          AppMethodBeat.o(210203);
          return;
          a.a(a.this, false);
        }
      }
    };
    this.qPv = new com.tencent.mm.sdk.b.c() {};
    this.qPn = new com.tencent.mm.plugin.expt.d.d.a(this);
    this.qPo = new com.tencent.mm.plugin.expt.d.a.a();
    this.qPq = new com.tencent.mm.plugin.expt.d.g.a();
    this.qPr = new com.tencent.mm.plugin.expt.d.c.a();
    this.qPs = b.cnh();
    this.qPt = new com.tencent.mm.plugin.expt.d.b.a.a();
    com.tencent.mm.plugin.expt.d.b.b.cnj().qPN = this;
    com.tencent.mm.sdk.b.a.IbL.b(this.qPv);
    AppMethodBeat.o(210211);
  }
  
  private Map<Long, List<List<com.tencent.mm.plugin.expt.d.e.b>>> a(com.tencent.mm.plugin.expt.d.e.a.b paramb, Map<Long, List<String>> paramMap)
  {
    AppMethodBeat.i(210214);
    if ((paramb != null) && (paramMap != null) && (paramMap.size() > 0))
    {
      localObject = this.qPt;
      str = paramb.qQf;
      if (!org.apache.commons.b.g.ea(str)) {
        break label55;
      }
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(210214);
      return null;
      label55:
      if (((com.tencent.mm.plugin.expt.d.b.a.a)localObject).qPV.containsKey(str))
      {
        ad.i("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] isErrorScriptConfig configID : ".concat(String.valueOf(str)));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    ad.d("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing configID : " + paramb.qQf);
    long l = SystemClock.uptimeMillis();
    Object localObject = this.qPt;
    String str = paramb.qQf;
    if (!org.apache.commons.b.g.ea(str))
    {
      ((com.tencent.mm.plugin.expt.d.b.a.a)localObject).qPX.put(str, Long.valueOf(System.currentTimeMillis()));
      ((com.tencent.mm.plugin.expt.d.b.a.a)localObject).cnn();
    }
    localObject = new com.tencent.mm.plugin.expt.d.h.a();
    paramMap = ((com.tencent.mm.plugin.expt.d.h.a)localObject).b(paramb, paramMap);
    if (((com.tencent.mm.plugin.expt.d.h.a)localObject).qQp != null) {
      ((com.tencent.mm.plugin.expt.d.h.a)localObject).qQp.release();
    }
    localObject = this.qPt;
    str = paramb.qQf;
    if (!org.apache.commons.b.g.ea(str))
    {
      ((com.tencent.mm.plugin.expt.d.b.a.a)localObject).qPX.remove(str);
      ((com.tencent.mm.plugin.expt.d.b.a.a)localObject).cnn();
    }
    localObject = paramMap.values().iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = ((List)((Iterator)localObject).next()).size() + i) {}
    paramb = paramb.qQf;
    l = SystemClock.uptimeMillis() - l;
    if (l <= 10L) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 0L, 1L, false);
    }
    for (;;)
    {
      ad.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { paramb, Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(210214);
      return paramMap;
      if (l <= 100L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 1L, 1L, false);
      }
      else if (l <= 1000L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 2L, 1L, false);
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 3L, 1L, false);
        if (com.tencent.mm.plugin.expt.d.f.a.qQo == null)
        {
          com.tencent.mm.plugin.expt.d.f.a.qQo = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHP, false));
          ad.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statComputingCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.qQo);
        }
        if (com.tencent.mm.plugin.expt.d.f.a.qQo.booleanValue()) {
          com.tencent.mm.plugin.report.service.g.yhR.f(20176, new Object[] { paramb, Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(i) });
        }
      }
    }
  }
  
  public static a cng()
  {
    AppMethodBeat.i(210212);
    if (qPm == null) {}
    try
    {
      if (qPm == null) {
        qPm = new a();
      }
      a locala = qPm;
      AppMethodBeat.o(210212);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(210212);
    }
  }
  
  public final void a(final long paramLong, final com.tencent.mm.plugin.expt.d.e.a.b paramb, final String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(210213);
    if ((paramb == null) || (org.apache.commons.b.g.ea(paramString)))
    {
      AppMethodBeat.o(210213);
      return;
    }
    ad.d("EdgeComputingMgr", "[EdgeComputingMgr] onDataReceive configID : " + paramb.qQf + ", data : " + paramString);
    if (this.qPp == null)
    {
      ad.e("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing please resetDB!");
      AppMethodBeat.o(210213);
      return;
    }
    com.tencent.mm.plugin.expt.d.f.a.l(paramb.qQf, 3, paramLong);
    if (paramb.qQk == 1)
    {
      Object localObject1 = localObject2;
      if (paramb != null)
      {
        localObject1 = localObject2;
        if (!org.apache.commons.b.g.ea(paramString))
        {
          if (paramLong > 0L) {
            break label155;
          }
          localObject1 = localObject2;
        }
      }
      while ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        AppMethodBeat.o(210213);
        return;
        label155:
        localObject1 = new HashMap();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        ((Map)localObject1).put(Long.valueOf(paramLong), localArrayList);
        paramString = a(paramb, (Map)localObject1);
        localObject1 = localObject2;
        if (paramString != null)
        {
          localObject1 = localObject2;
          if (paramString.size() > 0) {
            localObject1 = (List)paramString.get(Long.valueOf(paramLong));
          }
        }
      }
      com.tencent.mm.plugin.expt.d.f.a.l(paramb.qQf, 4, paramLong);
      if (paramb.qQl > 0) {
        this.qPu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210206);
            long l = SystemClock.uptimeMillis();
            Iterator localIterator = this.qPx.iterator();
            while (localIterator.hasNext())
            {
              List localList = (List)localIterator.next();
              ad.d("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing saveResult ret : ".concat(String.valueOf(a.b(a.this).a(localList, paramb))));
            }
            com.tencent.mm.plugin.expt.d.f.a.e(paramb.qQf, SystemClock.uptimeMillis() - l, this.qPx.size());
            com.tencent.mm.plugin.expt.d.f.a.l(paramb.qQf, 6, paramLong);
            AppMethodBeat.o(210206);
          }
        });
      }
      if (paramb.qQi > 0)
      {
        paramString = ((List)localObject1).iterator();
        while (paramString.hasNext()) {
          com.tencent.mm.plugin.expt.d.g.a.o((List)paramString.next(), paramb.qQi);
        }
        com.tencent.mm.plugin.expt.d.f.a.l(paramb.qQf, 7, paramLong);
      }
    }
    for (;;)
    {
      this.qPu.removeMessages(1002);
      this.qPu.sendEmptyMessageDelayed(1002, 300L);
      AppMethodBeat.o(210213);
      return;
      this.qPu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210207);
          long l = SystemClock.uptimeMillis();
          com.tencent.mm.plugin.expt.d.e.a locala = new com.tencent.mm.plugin.expt.d.e.a();
          locala.qQb = paramb.qQb;
          locala.qQc = paramb.qQc;
          locala.data = paramString;
          locala.qQd = paramLong;
          a.c(a.this);
          ax localax = com.tencent.mm.plugin.expt.d.a.a.Lv();
          String str;
          Object localObject2;
          byte[] arrayOfByte;
          Object localObject1;
          if (localax != null)
          {
            str = com.tencent.mm.plugin.expt.d.a.a.fx(locala.qQb, locala.qQc);
            if (!org.apache.commons.b.g.ea(str))
            {
              ad.d("EdgeComputingDataCache", "[EdgeComputingDataCache] saveDataCache dataCacheKey : ".concat(String.valueOf(str)));
              localObject2 = null;
              arrayOfByte = localax.decodeBytes(str);
              localObject1 = localObject2;
              if (arrayOfByte != null)
              {
                localObject1 = localObject2;
                if (arrayOfByte.length > 0) {
                  localObject1 = new afr();
                }
              }
            }
          }
          try
          {
            ((afr)localObject1).parseFrom(arrayOfByte);
            localObject1 = com.tencent.mm.plugin.expt.d.e.c.a((afr)localObject1);
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((List)localObject2).add(locala);
            localObject1 = com.tencent.mm.plugin.expt.d.e.c.cX((List)localObject2);
            if (localObject1 == null) {}
          }
          catch (IOException localIOException2)
          {
            try
            {
              boolean bool = localax.encode(str, ((afr)localObject1).toByteArray());
              ad.d("EdgeComputingDataCache", "[EdgeComputingDataCache] saveDataCache encode : " + str + ", mmkvEncode : " + bool);
              localObject1 = paramb.qQf;
              l = SystemClock.uptimeMillis() - l;
              if (l <= 10L)
              {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 4L, 1L, false);
                ad.d("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime configID : %s, costTime : %d, dataSzie : %d", new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(1) });
                com.tencent.mm.plugin.expt.d.f.a.l(paramb.qQf, 5, paramLong);
                AppMethodBeat.o(210207);
                return;
                localIOException2 = localIOException2;
                ad.e("EdgeComputingDataCache", "[EdgeComputingDataCache] saveDataCache parseFrom : " + str + ", throw IOException : " + localIOException2.getMessage());
              }
            }
            catch (IOException localIOException1)
            {
              for (;;)
              {
                ad.e("EdgeComputingDataCache", "[EdgeComputingDataCache] saveDataCache encode throw IOException : " + localIOException1.getMessage());
                continue;
                if (l <= 100L)
                {
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 5L, 1L, false);
                }
                else if (l <= 1000L)
                {
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 6L, 1L, false);
                }
                else
                {
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1409L, 7L, 1L, false);
                  if (com.tencent.mm.plugin.expt.d.f.a.qQo == null)
                  {
                    com.tencent.mm.plugin.expt.d.f.a.qQo = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHP, false));
                    ad.i("EdgeComputingMonitor", "[EdgeComputingMonitor] statCacheCostTime sIsMonitorPerformance : " + com.tencent.mm.plugin.expt.d.f.a.qQo);
                  }
                  if (com.tencent.mm.plugin.expt.d.f.a.qQo.booleanValue()) {
                    com.tencent.mm.plugin.report.service.g.yhR.f(20176, new Object[] { localIOException1, Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(1) });
                  }
                }
              }
            }
          }
        }
      });
    }
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(210215);
    if (paramb == null)
    {
      AppMethodBeat.o(210215);
      return;
    }
    ad.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigUpdate newConfig : " + paramb.qQf);
    AppMethodBeat.o(210215);
  }
  
  public final void a(com.tencent.mm.plugin.expt.d.e.a.c paramc)
  {
    AppMethodBeat.i(210217);
    if (paramc == null)
    {
      AppMethodBeat.o(210217);
      return;
    }
    ad.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigUpdate newConfig : " + paramc.qQf);
    AppMethodBeat.o(210217);
  }
  
  public final void b(final com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(210216);
    if (paramb == null)
    {
      AppMethodBeat.o(210216);
      return;
    }
    ad.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigOffline offlineConfig : " + paramb.qQf);
    this.qPu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210210);
        a.c(a.this);
        com.tencent.mm.plugin.expt.d.a.a.fw(paramb.qQb, paramb.qQc);
        com.tencent.mm.plugin.expt.d.i.b localb = a.b(a.this);
        com.tencent.mm.plugin.expt.d.e.a.b localb1 = paramb;
        if ((localb.qQu == null) || (localb1 == null))
        {
          AppMethodBeat.o(210210);
          return;
        }
        new com.tencent.mm.plugin.expt.d.i.a(localb.qQu, localb1.qQf, localb1.qQj).cnr();
        ad.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] clearAllData configID : " + localb1.qQf);
        AppMethodBeat.o(210210);
      }
    });
    AppMethodBeat.o(210216);
  }
  
  public final void b(com.tencent.mm.plugin.expt.d.e.a.c paramc)
  {
    AppMethodBeat.i(210218);
    if (paramc == null)
    {
      AppMethodBeat.o(210218);
      return;
    }
    ad.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigOffline offlineConfig : " + paramc.qQf);
    AppMethodBeat.o(210218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a
 * JD-Core Version:    0.7.0.1
 */