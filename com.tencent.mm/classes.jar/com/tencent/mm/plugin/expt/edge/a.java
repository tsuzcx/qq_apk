package com.tencent.mm.plugin.expt.edge;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.edge.config.c.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.c.i;

public class a
  implements com.tencent.mm.plugin.expt.b.a, com.tencent.mm.plugin.expt.edge.config.c, com.tencent.mm.plugin.expt.edge.d.b
{
  private static volatile a zxX;
  public q.a xhE;
  public com.tencent.mm.plugin.expt.edge.d.a zxY;
  public com.tencent.mm.plugin.expt.edge.a.c zxZ;
  public com.tencent.mm.plugin.expt.edge.a.c zya;
  public com.tencent.mm.plugin.expt.edge.i.b zyb;
  public com.tencent.mm.plugin.expt.edge.g.a zyc;
  public com.tencent.mm.plugin.expt.edge.config.a.a zyd;
  public com.tencent.mm.plugin.expt.edge.config.b.a zye;
  public com.tencent.mm.plugin.expt.edge.config.c.a zyf;
  public MMHandler zyg;
  
  private a()
  {
    AppMethodBeat.i(299769);
    this.zyg = new MMHandler("EdgeComputingMgr#mExecuteScriptHandler")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(299687);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(299687);
          return;
          a.a(a.this, true);
          AppMethodBeat.o(299687);
          return;
          a.a(a.this, false);
          AppMethodBeat.o(299687);
          return;
          a.a(a.this);
          AppMethodBeat.o(299687);
          return;
          a.b(a.this);
        }
      }
    };
    this.xhE = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(299693);
        if (!b.dHV())
        {
          AppMethodBeat.o(299693);
          return;
        }
        Log.e("EdgeComputingMgr", "[onAppBackground]");
        a.c(a.this).removeMessages(1004);
        a.c(a.this).sendEmptyMessageDelayed(1004, 1000L);
        a.c(a.this).removeMessages(1001);
        a.c(a.this).sendEmptyMessageDelayed(1001, 1000L);
        AppMethodBeat.o(299693);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(299686);
        if (!b.dHV())
        {
          AppMethodBeat.o(299686);
          return;
        }
        Log.e("EdgeComputingMgr", "[onAppForeground]");
        a.c(a.this).removeMessages(1004);
        a.c(a.this).removeMessages(1001);
        AppMethodBeat.o(299686);
      }
    };
    this.zxY = new com.tencent.mm.plugin.expt.edge.d.a(this);
    this.zxZ = com.tencent.mm.plugin.expt.edge.a.b.Lt(1);
    this.zya = com.tencent.mm.plugin.expt.edge.a.b.Lt(2);
    this.zyc = new com.tencent.mm.plugin.expt.edge.g.a();
    this.zyd = new com.tencent.mm.plugin.expt.edge.config.a.a();
    this.zye = new com.tencent.mm.plugin.expt.edge.config.b.a();
    this.zyf = new com.tencent.mm.plugin.expt.edge.config.c.a();
    this.zyb = new com.tencent.mm.plugin.expt.edge.i.b();
    com.tencent.mm.plugin.expt.edge.config.b.dIg().zyF = this;
    AppMethodBeat.o(299769);
  }
  
  private Map<Long, List<List<com.tencent.mm.plugin.expt.edge.e.b>>> a(com.tencent.mm.plugin.expt.edge.h.a parama, com.tencent.mm.plugin.expt.edge.e.a.b paramb, Map<Long, List<String>> paramMap, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(299783);
    if ((parama != null) && (paramb != null) && (paramMap.size() > 0))
    {
      localObject = this.zyd;
      str = paramb.zzS;
      if (!i.hm(str)) {
        break label57;
      }
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(299783);
      return null;
      label57:
      if ((!b.isDebugMode()) && (((com.tencent.mm.plugin.expt.edge.config.a.a)localObject).zyZ.containsKey(str)))
      {
        Log.i("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] isErrorScriptConfig configID : ".concat(String.valueOf(str)));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    Object localObject = paramMap.values().iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = ((List)((Iterator)localObject).next()).size() + i) {}
    long l = SystemClock.uptimeMillis();
    com.tencent.mm.plugin.expt.edge.f.a.aqs(paramb.zzS);
    localObject = this.zyd;
    String str = paramb.zzS;
    if (!i.hm(str))
    {
      ((com.tencent.mm.plugin.expt.edge.config.a.a)localObject).zzB.put(str, Long.valueOf(System.currentTimeMillis()));
      ((com.tencent.mm.plugin.expt.edge.config.a.a)localObject).dIm();
    }
    parama = parama.a(paramb, paramMap, paramLong1, paramLong2);
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] edgeComputing configID : " + paramb.zzS + ", dataSize : " + i);
    paramMap = this.zyd;
    localObject = paramb.zzS;
    if (!i.hm((String)localObject))
    {
      paramMap.zzB.remove(localObject);
      paramMap.dIm();
    }
    com.tencent.mm.plugin.expt.edge.f.a.e(paramb.zzS, SystemClock.uptimeMillis() - l, i);
    AppMethodBeat.o(299783);
    return parama;
  }
  
  public static a dHT()
  {
    AppMethodBeat.i(299777);
    if (zxX == null) {}
    try
    {
      if (zxX == null) {
        zxX = new a();
      }
      a locala = zxX;
      AppMethodBeat.o(299777);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(299777);
    }
  }
  
  private void dHU()
  {
    AppMethodBeat.i(299797);
    Object localObject1 = com.tencent.mm.plugin.expt.edge.config.b.dIg().dIi();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0))
    {
      AppMethodBeat.o(299797);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] executeSqlTask!");
    Iterator localIterator1 = ((List)localObject1).iterator();
    label56:
    Object localObject5;
    Object localObject3;
    long l1;
    for (localObject1 = null; localIterator1.hasNext(); localObject1 = new com.tencent.mm.plugin.expt.edge.c.a())
    {
      localObject5 = (com.tencent.mm.plugin.expt.edge.e.a.c)localIterator1.next();
      if ((i.hm(((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).sql)) || (!i.qA(MD5Util.getMD5String(((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).sql), ((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zAi))) {
        break label56;
      }
      localObject3 = this.zyd;
      ??? = ((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zzS;
      if (!i.hm((String)???))
      {
        ((com.tencent.mm.plugin.expt.edge.config.a.a)localObject3).zzC.put(???, Long.valueOf(System.currentTimeMillis()));
        ((com.tencent.mm.plugin.expt.edge.config.a.a)localObject3).dIm();
      }
      l1 = SystemClock.uptimeMillis();
      if (localObject1 != null) {
        break label614;
      }
    }
    label611:
    label614:
    for (;;)
    {
      for (;;)
      {
        localObject3 = ((com.tencent.mm.plugin.expt.edge.c.a)localObject1).hi("Edge.db", ((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).sql);
        ??? = ((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zzS;
        long l2 = SystemClock.uptimeMillis();
        int i;
        Object localObject6;
        if (localObject3 != null)
        {
          i = ((List)localObject3).size();
          com.tencent.mm.plugin.expt.edge.f.a.g((String)???, l2 - l1, i);
          ??? = this.zyd;
          localObject6 = ((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zzS;
          if (!i.hm((String)localObject6))
          {
            ((com.tencent.mm.plugin.expt.edge.config.a.a)???).zzC.remove(localObject6);
            ((com.tencent.mm.plugin.expt.edge.config.a.a)???).dIm();
          }
          if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
            break label611;
          }
          if (((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zzX > 0) {
            localObject6 = ((List)localObject3).iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject6).hasNext()) {
              break label499;
            }
            List localList = (List)((Iterator)localObject6).next();
            if (((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zAd == 1)
            {
              String str = ((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zzS;
              i = ((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zzX;
              if ((!i.hm(str)) && (i > 0) && (localList != null) && (localList.size() > 0))
              {
                ArrayList localArrayList = new ArrayList();
                Iterator localIterator2 = localList.iterator();
                for (;;)
                {
                  if (localIterator2.hasNext())
                  {
                    ??? = (String)localIterator2.next();
                    localObject3 = ???;
                    if (((String)???).contains(",")) {
                      localObject3 = ((String)???).replace(",", "\\$");
                    }
                    localArrayList.add(localObject3);
                    continue;
                    i = 0;
                    break;
                  }
                }
                com.tencent.mm.plugin.expt.edge.g.b.L(str, i, com.tencent.mm.plugin.expt.edge.g.a.eZ(localList));
              }
            }
            else if (((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zAd == 2)
            {
              com.tencent.mm.plugin.expt.edge.g.a.x(((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zzX, localList);
            }
            else
            {
              com.tencent.mm.plugin.expt.edge.g.a.v(((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zzX, localList);
            }
          }
        }
        label499:
        localObject3 = com.tencent.mm.plugin.expt.edge.config.b.dIg();
        localObject5 = ((com.tencent.mm.plugin.expt.edge.e.a.c)localObject5).zzS;
        if (!i.hm((String)localObject5))
        {
          Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] removeSqlConfigModel, configID : ".concat(String.valueOf(localObject5)));
          synchronized (((com.tencent.mm.plugin.expt.edge.config.b)localObject3).zyB)
          {
            ((com.tencent.mm.plugin.expt.edge.config.b)localObject3).zyB.remove(localObject5);
            ((com.tencent.mm.plugin.expt.edge.config.b)localObject3).dIk();
          }
        }
      }
      break;
      if (localObject2 != null) {
        localObject2.release();
      }
      this.zyc.dIu();
      AppMethodBeat.o(299797);
      return;
      break;
    }
  }
  
  public final void a(long paramLong, final com.tencent.mm.plugin.expt.edge.e.a.b paramb, String paramString)
  {
    AppMethodBeat.i(299882);
    if ((paramb == null) || (i.hm(paramString)))
    {
      AppMethodBeat.o(299882);
      return;
    }
    com.tencent.mm.plugin.expt.edge.config.c.a locala1 = this.zyf;
    String str = paramb.zzS;
    int i;
    if (i.hm(str)) {
      i = 0;
    }
    while (i == 0)
    {
      Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onDataReceive reject handle for frequency configID : " + paramb.zzS);
      AppMethodBeat.o(299882);
      return;
      long l = System.currentTimeMillis();
      a.a locala = (a.a)locala1.zzJ.get(str);
      localObject = locala;
      if (locala == null)
      {
        localObject = new a.a(locala1, l);
        locala1.zzJ.put(str, localObject);
      }
      if (l - ((a.a)localObject).zzK > 60000L)
      {
        ((a.a)localObject).zzK = l;
        ((a.a)localObject).zzL = 1;
      }
      do
      {
        i = 1;
        break;
        ((a.a)localObject).zzL += 1;
      } while (((a.a)localObject).zzL <= com.tencent.mm.plugin.expt.edge.config.c.a.zzE);
      i = 0;
    }
    b.hf("EdgeComputingMgr", "[EdgeComputingMgr] onDataReceive configID : " + paramb.zzS);
    com.tencent.mm.plugin.expt.edge.f.a.l(paramb.zzS, 3, paramLong);
    Object localObject = new com.tencent.mm.plugin.expt.edge.e.a();
    ((com.tencent.mm.plugin.expt.edge.e.a)localObject).data = paramString;
    ((com.tencent.mm.plugin.expt.edge.e.a)localObject).zzS = paramb.zzS;
    ((com.tencent.mm.plugin.expt.edge.e.a)localObject).zzT = paramLong;
    this.zyg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(299684);
        long l = SystemClock.uptimeMillis();
        if (paramb.zzZ == 1)
        {
          a.d(a.this).a(this.zyj);
          a.c(a.this).removeMessages(1003);
          MMHandler localMMHandler = a.c(a.this);
          a.e(a.this);
          localMMHandler.sendEmptyMessageDelayed(1003, com.tencent.mm.plugin.expt.edge.config.c.a.dIs());
        }
        for (;;)
        {
          com.tencent.mm.plugin.expt.edge.f.a.ak(paramb.zzS, SystemClock.uptimeMillis() - l);
          com.tencent.mm.plugin.expt.edge.f.a.l(paramb.zzS, 5, this.zyj.zzT);
          AppMethodBeat.o(299684);
          return;
          a.f(a.this).a(this.zyj);
        }
      }
    });
    this.zyg.removeMessages(1004);
    this.zyg.sendEmptyMessageDelayed(1004, 3000L);
    this.zyg.removeMessages(1002);
    this.zyg.sendEmptyMessageDelayed(1002, 3000L);
    AppMethodBeat.o(299882);
  }
  
  public final void a(com.tencent.mm.plugin.expt.edge.e.a.b paramb)
  {
    AppMethodBeat.i(299901);
    if (paramb == null)
    {
      AppMethodBeat.o(299901);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigUpdate newConfig : " + paramb.zzS);
    AppMethodBeat.o(299901);
  }
  
  public final void a(com.tencent.mm.plugin.expt.edge.e.a.c paramc)
  {
    AppMethodBeat.i(299919);
    if (paramc == null)
    {
      AppMethodBeat.o(299919);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigUpdate newConfig : " + paramc.zzS);
    AppMethodBeat.o(299919);
  }
  
  public final void b(final com.tencent.mm.plugin.expt.edge.e.a.b paramb)
  {
    AppMethodBeat.i(299907);
    if (paramb == null)
    {
      AppMethodBeat.o(299907);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigOffline offlineConfig : " + paramb.zzS);
    this.zyg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(299749);
        a.f(a.this).clear(paramb.zzS);
        a.d(a.this).clear(paramb.zzS);
        com.tencent.mm.plugin.expt.edge.i.b localb = a.g(a.this);
        com.tencent.mm.plugin.expt.edge.e.a.b localb1 = paramb;
        if ((localb.zys == null) || (localb1 == null))
        {
          AppMethodBeat.o(299749);
          return;
        }
        new com.tencent.mm.plugin.expt.edge.i.a(localb.zys, localb1.zzS, localb1.zzY).dIC();
        Log.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] clearAllData configID : " + localb1.zzS);
        AppMethodBeat.o(299749);
      }
    });
    AppMethodBeat.o(299907);
  }
  
  public final void b(com.tencent.mm.plugin.expt.edge.e.a.c paramc)
  {
    AppMethodBeat.i(299923);
    if (paramc == null)
    {
      AppMethodBeat.o(299923);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigOffline offlineConfig : " + paramc.zzS);
    AppMethodBeat.o(299923);
  }
  
  public final void c(final com.tencent.mm.plugin.expt.edge.e.a.b paramb)
  {
    AppMethodBeat.i(299913);
    if (paramb == null)
    {
      AppMethodBeat.o(299913);
      return;
    }
    if (b.isDebugMode()) {
      this.zyg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(299745);
          if (paramb.zAa == 0)
          {
            com.tencent.mm.plugin.expt.edge.config.b.a locala = a.h(a.this);
            String str = paramb.zzS;
            if (!i.hm(str)) {
              synchronized (locala.zzD)
              {
                locala.zzD.remove(str);
                locala.dIo();
                AppMethodBeat.o(299745);
                return;
              }
            }
          }
          AppMethodBeat.o(299745);
        }
      });
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onScriptConfigSame sameConfig : " + paramb.zzS);
    AppMethodBeat.o(299913);
  }
  
  public final void c(com.tencent.mm.plugin.expt.edge.e.a.c paramc)
  {
    AppMethodBeat.i(299927);
    if (paramc == null)
    {
      AppMethodBeat.o(299927);
      return;
    }
    Log.i("EdgeComputingMgr", "[EdgeComputingMgr] onSqlConfigSame sameConfig : " + paramc.zzS);
    AppMethodBeat.o(299927);
  }
  
  public final List<String> hd(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(299892);
    if ((i.hm(paramString1)) || (i.hm(paramString2)))
    {
      AppMethodBeat.o(299892);
      return null;
    }
    com.tencent.mm.plugin.expt.edge.h.a locala = new com.tencent.mm.plugin.expt.edge.h.a();
    Object localObject1 = localObject2;
    if (!i.hm(paramString2))
    {
      if (!i.hm(paramString1)) {
        break label73;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      locala.release();
      AppMethodBeat.o(299892);
      return localObject1;
      label73:
      Log.i("EdgeComputingScriptService", "[EdgeComputingScriptService] executePureScript");
      if (!locala.zAn.aqt(paramString1))
      {
        Log.e("EdgeComputingScriptService", "[EdgeComputingScriptService] executePureScript loadScript fail!");
        localObject1 = localObject2;
      }
      else
      {
        paramString1 = locala.zAn;
        h.baC();
        localObject1 = paramString1.ab("__main__", paramString2, com.tencent.mm.plugin.expt.edge.h.a.b(p.getString(com.tencent.mm.kernel.b.getUin()), d.Yxh, 0L, 0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.a
 * JD-Core Version:    0.7.0.1
 */