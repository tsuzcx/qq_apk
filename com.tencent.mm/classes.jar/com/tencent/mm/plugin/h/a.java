package com.tencent.mm.plugin.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ce;
import com.tencent.mm.f.a.cz;
import com.tencent.mm.f.a.cz.a;
import com.tencent.mm.f.a.na;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.h.a.e;
import com.tencent.mm.plugin.h.c.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.b> nnH;
  private static a sWL;
  private boolean cVD;
  private i.a iXh;
  private HashMap<Integer, com.tencent.mm.plugin.h.a.a> lBC;
  private r.a nnI;
  private com.tencent.mm.plugin.h.b.b sWK;
  private MMHandler sWM;
  private com.tencent.mm.plugin.h.c.d sWN;
  public HashSet<Long> sWO;
  public boolean sWP;
  private boolean sWQ;
  public com.tencent.mm.plugin.h.c.d sWR;
  com.tencent.mm.plugin.h.c.c sWS;
  private d.a sWT;
  private d.a sWU;
  private IListener<cz> sWV;
  private boolean sWW;
  private BroadcastReceiver sWX;
  private Runnable sWY;
  private boolean sWZ;
  private IListener<ce> sXa;
  
  static
  {
    AppMethodBeat.i(22725);
    HashMap localHashMap = new HashMap();
    nnH = localHashMap;
    localHashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.h.b.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(22725);
  }
  
  public a()
  {
    AppMethodBeat.i(22704);
    this.sWN = null;
    this.sWO = new HashSet();
    this.sWP = false;
    this.sWQ = false;
    this.sWR = null;
    this.sWS = null;
    this.lBC = new HashMap();
    this.sWT = new d.a()
    {
      public final void finish()
      {
        AppMethodBeat.i(22697);
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22696);
            a.a(a.this, null);
            a.this.lF(false);
            AppMethodBeat.o(22696);
          }
        });
        AppMethodBeat.o(22697);
      }
    };
    this.sWU = new d.a()
    {
      public final void finish()
      {
        AppMethodBeat.i(22703);
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22702);
            a.b(a.this, null);
            a.i(a.this);
            AppMethodBeat.o(22702);
          }
        });
        AppMethodBeat.o(22703);
      }
    };
    this.iXh = new i.a()
    {
      public final void onNotifyChange(i paramAnonymousi, final i.c paramAnonymousc)
      {
        AppMethodBeat.i(22686);
        if (CrashReportFactory.isBackupMerge())
        {
          AppMethodBeat.o(22686);
          return;
        }
        if (paramAnonymousi == null)
        {
          AppMethodBeat.o(22686);
          return;
        }
        if ((paramAnonymousc == null) || (paramAnonymousc.kvM == null))
        {
          AppMethodBeat.o(22686);
          return;
        }
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22685);
            Log.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[] { paramAnonymousc.EVM, Integer.valueOf(paramAnonymousc.kvM.size()) });
            if ("delete".equals(paramAnonymousc.EVM))
            {
              AppMethodBeat.o(22685);
              return;
            }
            int i;
            Iterator localIterator;
            if ("delete".equals(paramAnonymousc.EVM))
            {
              i = 2;
              localIterator = paramAnonymousc.kvM.iterator();
            }
            for (;;)
            {
              label94:
              if (!localIterator.hasNext()) {
                break label230;
              }
              Object localObject = (ca)localIterator.next();
              if (localObject != null)
              {
                a locala = a.this;
                long l = ((et)localObject).field_msgId;
                if (locala.sWP) {}
                for (boolean bool = locala.sWO.contains(Long.valueOf(l));; bool = false)
                {
                  if (!bool) {
                    break label199;
                  }
                  Log.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[] { Long.valueOf(((et)localObject).field_msgId) });
                  break label94;
                  i = 1;
                  break;
                }
                label199:
                localObject = new com.tencent.mm.plugin.h.c.b((ca)localObject, i);
                a.d(a.this).postToWorker((Runnable)localObject);
              }
            }
            label230:
            AppMethodBeat.o(22685);
          }
        });
        AppMethodBeat.o(22686);
      }
    };
    this.sWV = new IListener() {};
    this.cVD = false;
    this.sWW = true;
    this.sWZ = false;
    this.sXa = new IListener()
    {
      private boolean cFp()
      {
        AppMethodBeat.i(22692);
        Log.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[] { a.this.bqf() });
        a.d(a.this, true);
        try
        {
          com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22691);
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrL, Long.valueOf(-1L));
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrK, Long.valueOf(0L));
              com.tencent.mm.kernel.h.aHG().aHp().hxT();
              a.cFg().cFh().cFq();
              a.d(a.this, false);
              AppMethodBeat.o(22691);
            }
          });
          AppMethodBeat.o(22692);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.CalcWxService", localException, "%s clean wx file error", new Object[] { a.this.bqf() });
          }
        }
      }
    };
    AppMethodBeat.o(22704);
  }
  
  public static void M(int paramInt, long paramLong)
  {
    int i = 30;
    AppMethodBeat.i(22717);
    if (paramLong <= 1000L)
    {
      paramInt += 5;
      if (paramInt <= 30) {
        break label123;
      }
      paramInt = i;
    }
    label123:
    for (;;)
    {
      i = paramInt;
      if (paramInt < 5) {
        i = 5;
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrJ, Integer.valueOf(i));
      paramInt = ((Integer)com.tencent.mm.plugin.report.service.h.a(i, new int[] { 5, 10, 20, 25, 30 }, 10, 15)).intValue();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(664L, paramInt, 1L, false);
      AppMethodBeat.o(22717);
      return;
      paramInt -= 5;
      break;
    }
  }
  
  public static a cFg()
  {
    try
    {
      AppMethodBeat.i(22705);
      if (sWL == null) {
        sWL = new a();
      }
      a locala = sWL;
      AppMethodBeat.o(22705);
      return locala;
    }
    finally {}
  }
  
  public static void cFj()
  {
    AppMethodBeat.i(267546);
    int i;
    if (Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_delete_oversize_sns_db", "0", false, true), 0) > 0) {
      i = 1;
    }
    while (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHH();
      long l1 = new q(com.tencent.mm.kernel.h.aHG().cachePath + "SnsMicroMsg.db").length();
      long l3 = Util.getLong(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_db_count", Long.toString(50000L), false, true), 50000L);
      long l2 = aj.fOI().fSP();
      if (l2 > l3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(150, 101);
        aj.fPc();
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.aHH();
        l3 = new q(com.tencent.mm.kernel.h.aHG().cachePath + "SnsMicroMsg.db").length();
        long l4 = aj.fOI().fSP();
        com.tencent.mm.plugin.report.service.h.IzE.p(150L, 102L, l2 - l4);
        com.tencent.mm.plugin.report.service.h.IzE.a(22134, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) });
        Log.i("MicroMsg.CalcWxService", "cleanSnsDb:%b, snsCount:%s, newSnsCount:%s, snsDbSize:%s, newSnsDbSize:%s", new Object[] { Boolean.TRUE, Long.valueOf(l2), Long.valueOf(l4), Util.getSizeKB(l1), Util.getSizeKB(l3) });
        AppMethodBeat.o(267546);
        return;
        i = 0;
      }
      else
      {
        Log.i("MicroMsg.CalcWxService", "cleanSnsDb:%b, snsCount:%s, snsDbSize:%s", new Object[] { Boolean.FALSE, Long.valueOf(l2), Util.getSizeKB(l1) });
        com.tencent.mm.plugin.report.service.h.IzE.a(22134, new Object[] { Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(0), Integer.valueOf(0) });
      }
    }
    AppMethodBeat.o(267546);
  }
  
  public static long cFk()
  {
    AppMethodBeat.i(22713);
    long l2 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrL, Long.valueOf(-1L))).longValue();
    long l1 = l2;
    if (l2 <= -1L)
    {
      l1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aPf("message");
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrL, Long.valueOf(l1));
    }
    AppMethodBeat.o(22713);
    return l1;
  }
  
  public static long cFn()
  {
    AppMethodBeat.i(22719);
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrK, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(22719);
    return l;
  }
  
  public static int cFo()
  {
    AppMethodBeat.i(22720);
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrJ, Integer.valueOf(5))).intValue();
    AppMethodBeat.o(22720);
    return i;
  }
  
  private void cxT()
  {
    AppMethodBeat.i(22710);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22701);
        if (a.f(a.this) != null)
        {
          a.f(a.this).cancel();
          a.f(a.this).isStop = true;
          a.b(a.this, null);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(664L, 2L, 1L, false);
        }
        if (a.h(a.this) != null) {
          a.h(a.this).isStop = true;
        }
        AppMethodBeat.o(22701);
      }
    });
    AppMethodBeat.o(22710);
  }
  
  public final void Id(long paramLong)
  {
    AppMethodBeat.i(22718);
    Log.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong) });
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrK, Long.valueOf(paramLong));
    AppMethodBeat.o(22718);
  }
  
  public final void av(ca paramca)
  {
    AppMethodBeat.i(22716);
    if (paramca == null)
    {
      AppMethodBeat.o(22716);
      return;
    }
    try
    {
      com.tencent.mm.plugin.h.a.a locala2 = (com.tencent.mm.plugin.h.a.a)this.lBC.get(Integer.valueOf(paramca.getType()));
      com.tencent.mm.plugin.h.a.a locala1 = locala2;
      if (locala2 == null) {
        locala1 = (com.tencent.mm.plugin.h.a.a)this.lBC.get(Integer.valueOf(m.apL(paramca.getType())));
      }
      if (locala1 != null) {
        locala1.aw(paramca);
      }
      AppMethodBeat.o(22716);
      return;
    }
    catch (Exception paramca)
    {
      Log.printErrStackTrace("MicroMsg.CalcWxService", paramca, "", new Object[0]);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(664L, 5L, 1L, false);
      AppMethodBeat.o(22716);
    }
  }
  
  public final String bqf()
  {
    AppMethodBeat.i(22721);
    String str = hashCode();
    AppMethodBeat.o(22721);
    return str;
  }
  
  public final com.tencent.mm.plugin.h.b.b cFh()
  {
    AppMethodBeat.i(22706);
    if (this.sWK == null) {
      this.sWK = new com.tencent.mm.plugin.h.b.b(this.nnI);
    }
    com.tencent.mm.plugin.h.b.b localb = this.sWK;
    AppMethodBeat.o(22706);
    return localb;
  }
  
  public final void cFi()
  {
    boolean bool = false;
    AppMethodBeat.i(22709);
    q[] arrayOfq = new q(com.tencent.mm.loader.j.b.aSL()).a(new s()
    {
      public final boolean accept(q paramAnonymousq)
      {
        AppMethodBeat.i(22698);
        if (paramAnonymousq.isDirectory())
        {
          AppMethodBeat.o(22698);
          return false;
        }
        if ((paramAnonymousq.getName().endsWith(".apk")) || (paramAnonymousq.getName().endsWith(".temp")))
        {
          AppMethodBeat.o(22698);
          return true;
        }
        AppMethodBeat.o(22698);
        return false;
      }
    });
    if ((arrayOfq != null) && (arrayOfq.length > 0))
    {
      String str = bqf();
      if (this.sWR != null) {
        bool = true;
      }
      Log.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      post(new a.10(this, arrayOfq));
    }
    AppMethodBeat.o(22709);
  }
  
  public final boolean cFl()
  {
    AppMethodBeat.i(22714);
    long l1 = cFk();
    long l2 = cFn();
    if (l2 >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
      if ((bool) && (((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrO, Long.valueOf(0L))).longValue() <= 0L)) {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrO, Long.valueOf(Util.nowSecond()));
      }
      AppMethodBeat.o(22714);
      return bool;
    }
  }
  
  public final void cFm()
  {
    AppMethodBeat.i(22715);
    this.sWP = false;
    this.sWO.clear();
    Log.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    AppMethodBeat.o(22715);
  }
  
  public final void lF(final boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(22708);
    String str = bqf();
    if (this.sWR != null) {
      bool = true;
    }
    Log.d("MicroMsg.CalcWxService", "%s manual scan now manualScanTask[%b] uiClick[%b]", new Object[] { str, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22694);
        if (paramBoolean) {
          a.a(a.this, true);
        }
        if (!a.a(a.this))
        {
          AppMethodBeat.o(22694);
          return;
        }
        if (a.b(a.this) == null)
        {
          na localna = new na();
          if (a.this.cFl())
          {
            a.a(a.this, false);
            localna.fLg.eYG = true;
            EventCenter.instance.publish(localna);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(664L, 9L, 1L, false);
            AppMethodBeat.o(22694);
            return;
          }
          if (paramBoolean) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(664L, 7L, 1L, false);
          }
          localna.fLg.progress = a.cFn();
          localna.fLg.total = a.cFk();
          localna.fLg.eYG = false;
          EventCenter.instance.publish(localna);
          a.a(a.this, new com.tencent.mm.plugin.h.c.d("message", a.cFn(), a.cFo(), a.c(a.this)));
          a.d(a.this).postToWorker(a.b(a.this));
          if (((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrN, Long.valueOf(0L))).longValue() <= 0L) {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrN, Long.valueOf(Util.nowSecond()));
          }
        }
        AppMethodBeat.o(22694);
      }
    });
    AppMethodBeat.o(22708);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(22711);
    Log.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[] { bqf() });
    if (this.sWM == null)
    {
      Log.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[] { bqf() });
      this.sWM = new MMHandler("calc-wx");
      this.sWM.setLogging(false);
    }
    paramc = com.tencent.mm.kernel.h.aHG().cachePath + "WxFileIndex.db";
    this.nnI = r.a(hashCode(), paramc, nnH, true);
    this.lBC.put(Integer.valueOf(43), new e());
    this.lBC.put(Integer.valueOf(62), new e());
    this.lBC.put(Integer.valueOf(44), new e());
    this.lBC.put(Integer.valueOf(486539313), new e());
    this.lBC.put(Integer.valueOf(34), new com.tencent.mm.plugin.h.a.f());
    this.lBC.put(Integer.valueOf(3), new com.tencent.mm.plugin.h.a.d());
    this.lBC.put(Integer.valueOf(49), new com.tencent.mm.plugin.h.a.c());
    this.lBC.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.h.a.b());
    cFk();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this.iXh, null);
    EventCenter.instance.add(this.sWV);
    paramc = MMApplicationContext.getContext();
    Object localObject = paramc.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    boolean bool;
    if (localObject != null)
    {
      int i = ((Intent)localObject).getIntExtra("status", -1);
      if ((i == 2) || (i == 5)) {
        bool = true;
      }
    }
    for (this.cVD = bool;; this.cVD = false)
    {
      this.sWW = ((PowerManager)paramc.getSystemService("power")).isScreenOn();
      this.sWX = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(22690);
          paramAnonymousContext = paramAnonymousIntent.getAction();
          int i = -1;
          switch (paramAnonymousContext.hashCode())
          {
          default: 
            switch (i)
            {
            }
            break;
          }
          for (;;)
          {
            if ((!a.j(a.this)) || (a.k(a.this))) {
              break label273;
            }
            Log.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
            if (a.l(a.this) != null) {
              break label313;
            }
            a.b(a.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(22689);
                a.this.cFi();
                a.cFj();
                Log.i("MicroMsg.CalcWxService", "start to calc");
                if (a.this.cFl())
                {
                  a locala = a.this;
                  long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VrM, Long.valueOf(0L))).longValue();
                  MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
                  Log.i("MicroMsg.CalcWxService", "checkAndReport, midImgSize:%s, hevcSize:%s", new Object[] { Long.valueOf(localMultiProcessMMKV.getLong("CleanCalcMidImg", 0L)), Long.valueOf(localMultiProcessMMKV.getLong("CleanCalcHevcImg", 0L)) });
                  if (Util.milliSecondsToNow(l) >= 259200000L)
                  {
                    if (locala.sWS != null) {
                      locala.sWS.isStop = true;
                    }
                    locala.sWS = new com.tencent.mm.plugin.h.c.c();
                    locala.post(locala.sWS);
                    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrM, Long.valueOf(Util.nowMilliSecond()));
                  }
                  AppMethodBeat.o(22689);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(664L, 1L, 1L, false);
                a.i(a.this);
                AppMethodBeat.o(22689);
              }
            });
            bh.aHJ().postToWorkerDelayed(a.l(a.this), 300000L);
            AppMethodBeat.o(22690);
            return;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_ON")) {
              break;
            }
            i = 0;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_OFF")) {
              break;
            }
            i = 1;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
              break;
            }
            i = 2;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
              break;
            }
            i = 3;
            break;
            a.b(a.this, true);
            continue;
            a.b(a.this, false);
            continue;
            a.c(a.this, true);
            continue;
            a.c(a.this, false);
          }
          label273:
          if (a.l(a.this) != null)
          {
            bh.aHJ();
            MMHandlerThread.removeRunnable(a.l(a.this));
            a.b(a.this, null);
          }
          a.m(a.this);
          label313:
          AppMethodBeat.o(22690);
        }
      };
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      paramc.registerReceiver(this.sWX, (IntentFilter)localObject);
      EventCenter.instance.add(this.sXa);
      if (this.sWZ) {
        EventCenter.instance.publish(new ce());
      }
      AppMethodBeat.o(22711);
      return;
      bool = false;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22712);
    Log.i("MicroMsg.CalcWxService", "CalcWxService Release");
    this.sWO.clear();
    this.sWP = false;
    if (this.nnI != null)
    {
      this.nnI.xW(hashCode());
      this.nnI = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this.iXh);
    EventCenter.instance.removeListener(this.sWV);
    this.lBC.clear();
    if (this.sWX != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(this.sWX);
      this.sWX = null;
    }
    if (this.sWY != null)
    {
      bh.aHJ();
      MMHandlerThread.removeRunnable(this.sWY);
      this.sWY = null;
    }
    cxT();
    if (this.sWM != null)
    {
      Log.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[] { bqf() });
      this.sWM.quit();
    }
    this.sWM = null;
    EventCenter.instance.removeListener(this.sXa);
    AppMethodBeat.o(22712);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(22707);
    try
    {
      if (this.sWM != null)
      {
        this.sWM.postToWorker(paramRunnable);
        AppMethodBeat.o(22707);
        return;
      }
      Log.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[] { bqf() });
      AppMethodBeat.o(22707);
      return;
    }
    catch (Exception paramRunnable)
    {
      Log.printErrStackTrace("MicroMsg.CalcWxService", paramRunnable, "post error: [%s]", new Object[] { paramRunnable.toString() });
      AppMethodBeat.o(22707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a
 * JD-Core Version:    0.7.0.1
 */