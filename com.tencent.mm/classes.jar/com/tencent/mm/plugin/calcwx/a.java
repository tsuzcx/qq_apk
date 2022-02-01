package com.tencent.mm.plugin.calcwx;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cn;
import com.tencent.mm.autogen.a.dj;
import com.tencent.mm.autogen.a.oh;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.o;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.calcwx.a.e;
import com.tencent.mm.plugin.calcwx.c.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.b> qkO;
  private static a wbc;
  private boolean eRu;
  private i.a lzk;
  private HashMap<Integer, com.tencent.mm.plugin.calcwx.a.a> otn;
  private o.a qkP;
  private com.tencent.mm.plugin.calcwx.b.b wbb;
  private MMHandler wbd;
  private com.tencent.mm.plugin.calcwx.c.d wbe;
  public HashSet<Long> wbf;
  public boolean wbg;
  private boolean wbh;
  public com.tencent.mm.plugin.calcwx.c.d wbi;
  com.tencent.mm.plugin.calcwx.c.c wbj;
  private d.a wbk;
  private d.a wbl;
  private IListener<dj> wbm;
  private boolean wbn;
  private BroadcastReceiver wbo;
  private Runnable wbp;
  private boolean wbq;
  private IListener<cn> wbr;
  
  static
  {
    AppMethodBeat.i(22725);
    HashMap localHashMap = new HashMap();
    qkO = localHashMap;
    localHashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.calcwx.b.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(22725);
  }
  
  public a()
  {
    AppMethodBeat.i(22704);
    this.wbe = null;
    this.wbf = new HashSet();
    this.wbg = false;
    this.wbh = false;
    this.wbi = null;
    this.wbj = null;
    this.otn = new HashMap();
    this.wbk = new d.a()
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
            a.this.mZ(false);
            AppMethodBeat.o(22696);
          }
        });
        AppMethodBeat.o(22697);
      }
    };
    this.wbl = new d.a()
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
    this.lzk = new i.a()
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
        if ((paramAnonymousc == null) || (paramAnonymousc.mZo == null))
        {
          AppMethodBeat.o(22686);
          return;
        }
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22685);
            Log.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[] { paramAnonymousc.KRm, Integer.valueOf(paramAnonymousc.mZo.size()) });
            if ("delete".equals(paramAnonymousc.KRm))
            {
              AppMethodBeat.o(22685);
              return;
            }
            int i;
            Iterator localIterator;
            if ("delete".equals(paramAnonymousc.KRm))
            {
              i = 2;
              localIterator = paramAnonymousc.mZo.iterator();
            }
            for (;;)
            {
              label94:
              if (!localIterator.hasNext()) {
                break label230;
              }
              Object localObject = (cc)localIterator.next();
              if (localObject != null)
              {
                a locala = a.this;
                long l = ((fi)localObject).field_msgId;
                if (locala.wbg) {}
                for (boolean bool = locala.wbf.contains(Long.valueOf(l));; bool = false)
                {
                  if (!bool) {
                    break label199;
                  }
                  Log.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[] { Long.valueOf(((fi)localObject).field_msgId) });
                  break label94;
                  i = 1;
                  break;
                }
                label199:
                localObject = new com.tencent.mm.plugin.calcwx.c.b((cc)localObject, i);
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
    this.wbm = new CalcWxService.11(this, com.tencent.mm.app.f.hfK);
    this.eRu = false;
    this.wbn = true;
    this.wbq = false;
    this.wbr = new CalcWxService.13(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(22704);
  }
  
  public static void Q(int paramInt, long paramLong)
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
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTn, Integer.valueOf(i));
      paramInt = ((Integer)com.tencent.mm.plugin.report.service.h.a(i, new int[] { 5, 10, 20, 25, 30 }, 10, 15)).intValue();
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(664L, paramInt, 1L, false);
      AppMethodBeat.o(22717);
      return;
      paramInt -= 5;
      break;
    }
  }
  
  private void daL()
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(664L, 2L, 1L, false);
        }
        if (a.h(a.this) != null) {
          a.h(a.this).isStop = true;
        }
        AppMethodBeat.o(22701);
      }
    });
    AppMethodBeat.o(22710);
  }
  
  public static void diC()
  {
    AppMethodBeat.i(277811);
    int i;
    if (Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_delete_oversize_sns_db", "0", false, true), 0) > 0) {
      i = 1;
    }
    while (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baF();
      long l1 = new u(com.tencent.mm.kernel.h.baE().cachePath + "SnsMicroMsg.db").length();
      long l3 = Util.getLong(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_db_count", Long.toString(50000L), false, true), 50000L);
      long l2 = al.hgB().hlb();
      if (l2 > l3)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 101);
        al.hgW();
        com.tencent.mm.plugin.sns.f.a.hek();
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.baF();
        l3 = new u(com.tencent.mm.kernel.h.baE().cachePath + "SnsMicroMsg.db").length();
        long l4 = al.hgB().hlb();
        com.tencent.mm.plugin.report.service.h.OAn.p(150L, 102L, l2 - l4);
        com.tencent.mm.plugin.report.service.h.OAn.b(22134, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) });
        Log.i("MicroMsg.CalcWxService", "cleanSnsDb:%b, snsCount:%s, newSnsCount:%s, snsDbSize:%s, newSnsDbSize:%s", new Object[] { Boolean.TRUE, Long.valueOf(l2), Long.valueOf(l4), Util.getSizeKB(l1), Util.getSizeKB(l3) });
        AppMethodBeat.o(277811);
        return;
        i = 0;
      }
      else
      {
        Log.i("MicroMsg.CalcWxService", "cleanSnsDb:%b, snsCount:%s, snsDbSize:%s", new Object[] { Boolean.FALSE, Long.valueOf(l2), Util.getSizeKB(l1) });
        com.tencent.mm.plugin.report.service.h.OAn.b(22134, new Object[] { Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(0), Integer.valueOf(0) });
      }
    }
    AppMethodBeat.o(277811);
  }
  
  public static long diD()
  {
    AppMethodBeat.i(22713);
    long l2 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTp, Long.valueOf(-1L))).longValue();
    long l1 = l2;
    if (l2 <= -1L)
    {
      l1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aMe("message");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTp, Long.valueOf(l1));
    }
    AppMethodBeat.o(22713);
    return l1;
  }
  
  public static long diG()
  {
    AppMethodBeat.i(22719);
    long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTo, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(22719);
    return l;
  }
  
  public static int diH()
  {
    AppMethodBeat.i(22720);
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTn, Integer.valueOf(5))).intValue();
    AppMethodBeat.o(22720);
    return i;
  }
  
  public static a diz()
  {
    try
    {
      AppMethodBeat.i(22705);
      if (wbc == null) {
        wbc = new a();
      }
      a locala = wbc;
      AppMethodBeat.o(22705);
      return locala;
    }
    finally {}
  }
  
  public final void aE(cc paramcc)
  {
    AppMethodBeat.i(22716);
    if (paramcc == null)
    {
      AppMethodBeat.o(22716);
      return;
    }
    try
    {
      com.tencent.mm.plugin.calcwx.a.a locala2 = (com.tencent.mm.plugin.calcwx.a.a)this.otn.get(Integer.valueOf(paramcc.getType()));
      com.tencent.mm.plugin.calcwx.a.a locala1 = locala2;
      if (locala2 == null) {
        locala1 = (com.tencent.mm.plugin.calcwx.a.a)this.otn.get(Integer.valueOf(com.tencent.mm.pluginsdk.model.app.n.va(paramcc.getType())));
      }
      if (locala1 != null) {
        locala1.aF(paramcc);
      }
      AppMethodBeat.o(22716);
      return;
    }
    catch (Exception paramcc)
    {
      Log.printErrStackTrace("MicroMsg.CalcWxService", paramcc, "", new Object[0]);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(664L, 5L, 1L, false);
      AppMethodBeat.o(22716);
    }
  }
  
  public final String bNL()
  {
    AppMethodBeat.i(22721);
    String str = hashCode();
    AppMethodBeat.o(22721);
    return str;
  }
  
  public final com.tencent.mm.plugin.calcwx.b.b diA()
  {
    AppMethodBeat.i(22706);
    if (this.wbb == null) {
      this.wbb = new com.tencent.mm.plugin.calcwx.b.b(this.qkP);
    }
    com.tencent.mm.plugin.calcwx.b.b localb = this.wbb;
    AppMethodBeat.o(22706);
    return localb;
  }
  
  public final void diB()
  {
    boolean bool = false;
    AppMethodBeat.i(22709);
    u[] arrayOfu = new u(com.tencent.mm.loader.i.b.bmz()).a(new com.tencent.mm.vfs.w()
    {
      public final boolean accept(u paramAnonymousu)
      {
        AppMethodBeat.i(22698);
        if (paramAnonymousu.isDirectory())
        {
          AppMethodBeat.o(22698);
          return false;
        }
        if ((paramAnonymousu.getName().endsWith(".apk")) || (paramAnonymousu.getName().endsWith(".temp")))
        {
          AppMethodBeat.o(22698);
          return true;
        }
        AppMethodBeat.o(22698);
        return false;
      }
    });
    if ((arrayOfu != null) && (arrayOfu.length > 0))
    {
      String str = bNL();
      if (this.wbi != null) {
        bool = true;
      }
      Log.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      post(new a.8(this, arrayOfu));
    }
    AppMethodBeat.o(22709);
  }
  
  public final boolean diE()
  {
    AppMethodBeat.i(22714);
    long l1 = diD();
    long l2 = diG();
    if (l2 >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
      if ((bool) && (((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTs, Long.valueOf(0L))).longValue() <= 0L)) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acTs, Long.valueOf(Util.nowSecond()));
      }
      AppMethodBeat.o(22714);
      return bool;
    }
  }
  
  public final void diF()
  {
    AppMethodBeat.i(22715);
    this.wbg = false;
    this.wbf.clear();
    Log.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    AppMethodBeat.o(22715);
  }
  
  public final void kv(long paramLong)
  {
    AppMethodBeat.i(22718);
    Log.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong) });
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acTo, Long.valueOf(paramLong));
    AppMethodBeat.o(22718);
  }
  
  public final void mZ(final boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(22708);
    String str = bNL();
    if (this.wbi != null) {
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
          oh localoh = new oh();
          if (a.this.diE())
          {
            a.a(a.this, false);
            localoh.hQN.hcg = true;
            localoh.publish();
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(664L, 9L, 1L, false);
            AppMethodBeat.o(22694);
            return;
          }
          if (paramBoolean) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(664L, 7L, 1L, false);
          }
          localoh.hQN.hQO = a.diG();
          localoh.hQN.total = a.diD();
          localoh.hQN.hcg = false;
          localoh.publish();
          a.a(a.this, new com.tencent.mm.plugin.calcwx.c.d("message", a.diG(), a.diH(), a.c(a.this)));
          a.d(a.this).postToWorker(a.b(a.this));
          if (((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTr, Long.valueOf(0L))).longValue() <= 0L) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acTr, Long.valueOf(Util.nowSecond()));
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
    Log.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[] { bNL() });
    if (this.wbd == null)
    {
      Log.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[] { bNL() });
      this.wbd = new MMHandler("calc-wx");
      this.wbd.setLogging(false);
    }
    paramc = com.tencent.mm.kernel.h.baE().cachePath + "WxFileIndex.db";
    if (!y.ZC(paramc)) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTo, Long.valueOf(0L));
    }
    this.qkP = o.a(hashCode(), paramc, qkO, true);
    this.otn.put(Integer.valueOf(43), new e());
    this.otn.put(Integer.valueOf(62), new e());
    this.otn.put(Integer.valueOf(44), new e());
    this.otn.put(Integer.valueOf(486539313), new e());
    this.otn.put(Integer.valueOf(34), new com.tencent.mm.plugin.calcwx.a.f());
    this.otn.put(Integer.valueOf(3), new com.tencent.mm.plugin.calcwx.a.d());
    this.otn.put(Integer.valueOf(49), new com.tencent.mm.plugin.calcwx.a.c());
    this.otn.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.calcwx.a.b());
    diD();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.lzk, null);
    this.wbm.alive();
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
    for (this.eRu = bool;; this.eRu = false)
    {
      this.wbn = ((PowerManager)paramc.getSystemService("power")).isScreenOn();
      this.wbo = new BroadcastReceiver()
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
                a.this.diB();
                a.diC();
                Log.i("MicroMsg.CalcWxService", "start to calc");
                if (a.this.diE())
                {
                  a locala = a.this;
                  long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTq, Long.valueOf(0L))).longValue();
                  MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
                  Log.i("MicroMsg.CalcWxService", "checkAndReport, midImgSize:%s, hevcSize:%s", new Object[] { Long.valueOf(localMultiProcessMMKV.getLong("CleanCalcMidImg", 0L)), Long.valueOf(localMultiProcessMMKV.getLong("CleanCalcHevcImg", 0L)) });
                  if (Util.milliSecondsToNow(l) >= 259200000L)
                  {
                    if (locala.wbj != null) {
                      locala.wbj.isStop = true;
                    }
                    locala.wbj = new com.tencent.mm.plugin.calcwx.c.c();
                    locala.post(locala.wbj);
                    com.tencent.mm.kernel.h.baE().ban().set(at.a.acTq, Long.valueOf(Util.nowMilliSecond()));
                  }
                  AppMethodBeat.o(22689);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(664L, 1L, 1L, false);
                a.i(a.this);
                AppMethodBeat.o(22689);
              }
            });
            bh.baH().postToWorkerDelayed(a.l(a.this), 300000L);
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
            bh.baH();
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
      paramc.registerReceiver(this.wbo, (IntentFilter)localObject);
      this.wbr.alive();
      if (this.wbq) {
        new cn().publish();
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
    this.wbf.clear();
    this.wbg = false;
    if (this.qkP != null)
    {
      this.qkP.yb(hashCode());
      this.qkP = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.lzk);
    this.wbm.dead();
    this.otn.clear();
    if (this.wbo != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(this.wbo);
      this.wbo = null;
    }
    if (this.wbp != null)
    {
      bh.baH();
      MMHandlerThread.removeRunnable(this.wbp);
      this.wbp = null;
    }
    daL();
    if (this.wbd != null)
    {
      Log.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[] { bNL() });
      this.wbd.quit();
    }
    this.wbd = null;
    this.wbr.dead();
    AppMethodBeat.o(22712);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(22707);
    try
    {
      if (this.wbd != null)
      {
        this.wbd.postToWorker(paramRunnable);
        AppMethodBeat.o(22707);
        return;
      }
      Log.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[] { bNL() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.a
 * JD-Core Version:    0.7.0.1
 */