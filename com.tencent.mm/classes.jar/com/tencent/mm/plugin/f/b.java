package com.tencent.mm.plugin.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.f.a.a;
import com.tencent.mm.plugin.f.a.f;
import com.tencent.mm.plugin.f.c.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
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
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.b> kvw;
  private static b pPK;
  private boolean cSX;
  private i.a gsV;
  private HashMap<Integer, a> iLv;
  private r.a kvx;
  private com.tencent.mm.plugin.f.b.b pPJ;
  private MMHandler pPL;
  private com.tencent.mm.plugin.f.c.d pPM;
  public HashSet<Long> pPN;
  public boolean pPO;
  private boolean pPP;
  public com.tencent.mm.plugin.f.c.d pPQ;
  com.tencent.mm.plugin.f.c.c pPR;
  private d.a pPS;
  private d.a pPT;
  private IListener<cv> pPU;
  private boolean pPV;
  private BroadcastReceiver pPW;
  private Runnable pPX;
  private boolean pPY;
  private IListener<com.tencent.mm.g.a.ca> pPZ;
  
  static
  {
    AppMethodBeat.i(22725);
    HashMap localHashMap = new HashMap();
    kvw = localHashMap;
    localHashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.f.b.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(22725);
  }
  
  public b()
  {
    AppMethodBeat.i(22704);
    this.pPM = null;
    this.pPN = new HashSet();
    this.pPO = false;
    this.pPP = false;
    this.pPQ = null;
    this.pPR = null;
    this.iLv = new HashMap();
    this.pPS = new d.a()
    {
      public final void finish()
      {
        AppMethodBeat.i(22697);
        b.a(b.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22696);
            b.a(b.this, null);
            b.this.kt(false);
            AppMethodBeat.o(22696);
          }
        });
        AppMethodBeat.o(22697);
      }
    };
    this.pPT = new d.a()
    {
      public final void finish()
      {
        AppMethodBeat.i(22703);
        b.a(b.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22702);
            b.b(b.this, null);
            b.i(b.this);
            AppMethodBeat.o(22702);
          }
        });
        AppMethodBeat.o(22703);
      }
    };
    this.gsV = new i.a()
    {
      public final void a(i paramAnonymousi, final i.c paramAnonymousc)
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
        if ((paramAnonymousc == null) || (paramAnonymousc.hIs == null))
        {
          AppMethodBeat.o(22686);
          return;
        }
        b.a(b.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22685);
            Log.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[] { paramAnonymousc.zqn, Integer.valueOf(paramAnonymousc.hIs.size()) });
            if ("delete".equals(paramAnonymousc.zqn))
            {
              AppMethodBeat.o(22685);
              return;
            }
            int i;
            Iterator localIterator;
            if ("delete".equals(paramAnonymousc.zqn))
            {
              i = 2;
              localIterator = paramAnonymousc.hIs.iterator();
            }
            for (;;)
            {
              label94:
              if (!localIterator.hasNext()) {
                break label230;
              }
              Object localObject = (com.tencent.mm.storage.ca)localIterator.next();
              if (localObject != null)
              {
                b localb = b.this;
                long l = ((eo)localObject).field_msgId;
                if (localb.pPO) {}
                for (boolean bool = localb.pPN.contains(Long.valueOf(l));; bool = false)
                {
                  if (!bool) {
                    break label199;
                  }
                  Log.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[] { Long.valueOf(((eo)localObject).field_msgId) });
                  break label94;
                  i = 1;
                  break;
                }
                label199:
                localObject = new com.tencent.mm.plugin.f.c.b((com.tencent.mm.storage.ca)localObject, i);
                b.d(b.this).postToWorker((Runnable)localObject);
              }
            }
            label230:
            AppMethodBeat.o(22685);
          }
        });
        AppMethodBeat.o(22686);
      }
    };
    this.pPU = new IListener() {};
    this.cSX = false;
    this.pPV = true;
    this.pPY = false;
    this.pPZ = new IListener()
    {
      private boolean csf()
      {
        AppMethodBeat.i(22692);
        Log.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[] { b.this.bgQ() });
        b.d(b.this, true);
        try
        {
          g.aAk().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22691);
              g.aAh().azQ().set(ar.a.OdA, Long.valueOf(-1L));
              g.aAh().azQ().set(ar.a.Odz, Long.valueOf(0L));
              g.aAh().azQ().gBI();
              b.crW().crX().delete();
              b.d(b.this, false);
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
            Log.printErrStackTrace("MicroMsg.CalcWxService", localException, "%s clean wx file error", new Object[] { b.this.bgQ() });
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
      g.aAh().azQ().set(ar.a.Ody, Integer.valueOf(i));
      paramInt = ((Integer)h.a(i, new int[] { 5, 10, 20, 25, 30 }, 10, 15)).intValue();
      h.CyF.idkeyStat(664L, paramInt, 1L, false);
      AppMethodBeat.o(22717);
      return;
      paramInt -= 5;
      break;
    }
  }
  
  public static b crW()
  {
    try
    {
      AppMethodBeat.i(22705);
      if (pPK == null) {
        pPK = new b();
      }
      b localb = pPK;
      AppMethodBeat.o(22705);
      return localb;
    }
    finally {}
  }
  
  public static void crZ()
  {
    AppMethodBeat.i(231649);
    int i;
    if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_delete_oversize_sns_db", "0", false, true), 0) > 0) {
      i = 1;
    }
    while (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAi();
      long l1 = new o(g.aAh().cachePath + "SnsMicroMsg.db").length();
      long l3 = Util.getLong(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_db_count", Long.toString(50000L), false, true), 50000L);
      long l2 = aj.faO().feV();
      if (l2 > l3)
      {
        h.CyF.dN(150, 101);
        aj.fbi();
        localStringBuilder = new StringBuilder();
        g.aAi();
        l3 = new o(g.aAh().cachePath + "SnsMicroMsg.db").length();
        long l4 = aj.faO().feV();
        h.CyF.n(150L, 102L, l2 - l4);
        h.CyF.a(22134, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) });
        Log.i("MicroMsg.CalcWxService", "cleanSnsDb:%b, snsCount:%s, newSnsCount:%s, snsDbSize:%s, newSnsDbSize:%s", new Object[] { Boolean.TRUE, Long.valueOf(l2), Long.valueOf(l4), Util.getSizeKB(l1), Util.getSizeKB(l3) });
        AppMethodBeat.o(231649);
        return;
        i = 0;
      }
      else
      {
        Log.i("MicroMsg.CalcWxService", "cleanSnsDb:%b, snsCount:%s, snsDbSize:%s", new Object[] { Boolean.FALSE, Long.valueOf(l2), Util.getSizeKB(l1) });
        h.CyF.a(22134, new Object[] { Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(0), Integer.valueOf(0) });
      }
    }
    AppMethodBeat.o(231649);
  }
  
  public static long csa()
  {
    AppMethodBeat.i(22713);
    long l2 = ((Long)g.aAh().azQ().get(ar.a.OdA, Long.valueOf(-1L))).longValue();
    long l1 = l2;
    if (l2 <= -1L)
    {
      l1 = ((l)g.af(l.class)).eiy().aEV("message");
      g.aAh().azQ().set(ar.a.OdA, Long.valueOf(l1));
    }
    AppMethodBeat.o(22713);
    return l1;
  }
  
  public static long csd()
  {
    AppMethodBeat.i(22719);
    long l = ((Long)g.aAh().azQ().get(ar.a.Odz, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(22719);
    return l;
  }
  
  public static int cse()
  {
    AppMethodBeat.i(22720);
    int i = ((Integer)g.aAh().azQ().get(ar.a.Ody, Integer.valueOf(5))).intValue();
    AppMethodBeat.o(22720);
    return i;
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(22710);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22701);
        if (b.f(b.this) != null)
        {
          b.f(b.this).cancel();
          b.f(b.this).isStop = true;
          b.b(b.this, null);
          h.CyF.idkeyStat(664L, 2L, 1L, false);
        }
        if (b.h(b.this) != null) {
          b.h(b.this).isStop = true;
        }
        AppMethodBeat.o(22701);
      }
    });
    AppMethodBeat.o(22710);
  }
  
  public final void BU(long paramLong)
  {
    AppMethodBeat.i(22718);
    Log.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong) });
    g.aAh().azQ().set(ar.a.Odz, Long.valueOf(paramLong));
    AppMethodBeat.o(22718);
  }
  
  public final void an(com.tencent.mm.storage.ca paramca)
  {
    AppMethodBeat.i(22716);
    if (paramca == null)
    {
      AppMethodBeat.o(22716);
      return;
    }
    try
    {
      a locala = (a)this.iLv.get(Integer.valueOf(paramca.getType()));
      if (locala != null) {
        locala.ao(paramca);
      }
      AppMethodBeat.o(22716);
      return;
    }
    catch (Exception paramca)
    {
      Log.printErrStackTrace("MicroMsg.CalcWxService", paramca, "", new Object[0]);
      h.CyF.idkeyStat(664L, 5L, 1L, false);
      AppMethodBeat.o(22716);
    }
  }
  
  public final String bgQ()
  {
    AppMethodBeat.i(22721);
    String str = hashCode();
    AppMethodBeat.o(22721);
    return str;
  }
  
  public final com.tencent.mm.plugin.f.b.b crX()
  {
    AppMethodBeat.i(22706);
    if (this.pPJ == null) {
      this.pPJ = new com.tencent.mm.plugin.f.b.b(this.kvx);
    }
    com.tencent.mm.plugin.f.b.b localb = this.pPJ;
    AppMethodBeat.o(22706);
    return localb;
  }
  
  public final void crY()
  {
    boolean bool = false;
    AppMethodBeat.i(22709);
    final o[] arrayOfo = new o(com.tencent.mm.loader.j.b.aKJ()).a(new q()
    {
      public final boolean accept(o paramAnonymouso)
      {
        AppMethodBeat.i(22698);
        if (paramAnonymouso.isDirectory())
        {
          AppMethodBeat.o(22698);
          return false;
        }
        if ((paramAnonymouso.getName().endsWith(".apk")) || (paramAnonymouso.getName().endsWith(".temp")))
        {
          AppMethodBeat.o(22698);
          return true;
        }
        AppMethodBeat.o(22698);
        return false;
      }
    });
    if ((arrayOfo != null) && (arrayOfo.length > 0))
    {
      String str = bgQ();
      if (this.pPQ != null) {
        bool = true;
      }
      Log.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22699);
          if ((arrayOfo == null) || (arrayOfo.length == 0))
          {
            Log.e("MicroMsg.CalcWxService", "apkList is null or 0");
            AppMethodBeat.o(22699);
            return;
          }
          o[] arrayOfo = arrayOfo;
          int m = arrayOfo.length;
          int j = 0;
          int k = 0;
          Object localObject3 = null;
          Object localObject4 = null;
          if (j < m)
          {
            o localo = arrayOfo[j];
            Object localObject1;
            Object localObject2;
            int i;
            if (localo.getName().endsWith(".temp")) {
              if (Util.milliSecondsToNow(localo.lastModified()) > 86400000L)
              {
                localo.delete();
                localObject1 = localObject4;
                localObject2 = localObject3;
                i = k;
              }
            }
            for (;;)
            {
              j += 1;
              k = i;
              localObject3 = localObject2;
              localObject4 = localObject1;
              break;
              if (localObject3 == null)
              {
                i = k;
                localObject2 = localo;
                localObject1 = localObject4;
              }
              else if (localo.lastModified() > localObject3.lastModified())
              {
                localObject3.delete();
                i = k;
                localObject2 = localo;
                localObject1 = localObject4;
              }
              else
              {
                localo.delete();
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                continue;
                i = k;
                localObject2 = localObject3;
                localObject1 = localObject4;
                if (localo.getName().endsWith(".apk"))
                {
                  localObject1 = MMApplicationContext.getContext().getPackageManager().getPackageArchiveInfo(aa.z(localo.her()), 128);
                  if (localObject1 != null)
                  {
                    if ((((PackageInfo)localObject1).packageName != null) && (!((PackageInfo)localObject1).packageName.equals(MMApplicationContext.getApplicationId())))
                    {
                      localo.delete();
                      i = k;
                      localObject2 = localObject3;
                      localObject1 = localObject4;
                      continue;
                    }
                    localObject1 = ((PackageInfo)localObject1).applicationInfo;
                    if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null))
                    {
                      i = ((ApplicationInfo)localObject1).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
                      Log.d("MicroMsg.CalcWxService", "startCleanAPKFiles:%d, currentVersion;%d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.KyO) });
                      if (i <= com.tencent.mm.protocal.d.KyO)
                      {
                        localo.delete();
                        i = k;
                        localObject2 = localObject3;
                        localObject1 = localObject4;
                        continue;
                      }
                      if (localObject4 == null)
                      {
                        localObject2 = localObject3;
                        localObject1 = localo;
                        continue;
                      }
                      if (i > k)
                      {
                        localObject4.delete();
                        localObject2 = localObject3;
                        localObject1 = localo;
                        continue;
                      }
                      localo.delete();
                      i = k;
                      localObject2 = localObject3;
                      localObject1 = localObject4;
                      continue;
                    }
                  }
                  if (k != 0)
                  {
                    localo.delete();
                    i = k;
                    localObject2 = localObject3;
                    localObject1 = localObject4;
                  }
                  else if (localObject4 == null)
                  {
                    i = k;
                    localObject2 = localObject3;
                    localObject1 = localo;
                  }
                  else if (localo.lastModified() > localObject4.lastModified())
                  {
                    localObject4.delete();
                    i = k;
                    localObject2 = localObject3;
                    localObject1 = localo;
                  }
                  else
                  {
                    localo.delete();
                    i = k;
                    localObject2 = localObject3;
                    localObject1 = localObject4;
                  }
                }
              }
            }
          }
          AppMethodBeat.o(22699);
        }
      });
    }
    AppMethodBeat.o(22709);
  }
  
  public final boolean csb()
  {
    AppMethodBeat.i(22714);
    long l1 = csa();
    long l2 = csd();
    if (l2 >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
      if ((bool) && (((Long)g.aAh().azQ().get(ar.a.OdD, Long.valueOf(0L))).longValue() <= 0L)) {
        g.aAh().azQ().set(ar.a.OdD, Long.valueOf(Util.nowSecond()));
      }
      AppMethodBeat.o(22714);
      return bool;
    }
  }
  
  public final void csc()
  {
    AppMethodBeat.i(22715);
    this.pPO = false;
    this.pPN.clear();
    Log.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    AppMethodBeat.o(22715);
  }
  
  public final void kt(final boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(22708);
    String str = bgQ();
    if (this.pPQ != null) {
      bool = true;
    }
    Log.d("MicroMsg.CalcWxService", "%s manual scan now manualScanTask[%b] uiClick[%b]", new Object[] { str, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22694);
        if (paramBoolean) {
          b.a(b.this, true);
        }
        if (!b.a(b.this))
        {
          AppMethodBeat.o(22694);
          return;
        }
        if (b.b(b.this) == null)
        {
          mj localmj = new mj();
          if (b.this.csb())
          {
            b.a(b.this, false);
            localmj.dRJ.dgZ = true;
            EventCenter.instance.publish(localmj);
            h.CyF.idkeyStat(664L, 9L, 1L, false);
            AppMethodBeat.o(22694);
            return;
          }
          if (paramBoolean) {
            h.CyF.idkeyStat(664L, 7L, 1L, false);
          }
          localmj.dRJ.progress = b.csd();
          localmj.dRJ.total = b.csa();
          localmj.dRJ.dgZ = false;
          EventCenter.instance.publish(localmj);
          b.a(b.this, new com.tencent.mm.plugin.f.c.d("message", b.csd(), b.cse(), b.c(b.this)));
          b.d(b.this).postToWorker(b.b(b.this));
          if (((Long)g.aAh().azQ().get(ar.a.OdC, Long.valueOf(0L))).longValue() <= 0L) {
            g.aAh().azQ().set(ar.a.OdC, Long.valueOf(Util.nowSecond()));
          }
        }
        AppMethodBeat.o(22694);
      }
    });
    AppMethodBeat.o(22708);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(22711);
    Log.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[] { bgQ() });
    if (this.pPL == null)
    {
      Log.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[] { bgQ() });
      this.pPL = new MMHandler("calc-wx");
      this.pPL.setLogging(false);
    }
    paramc = g.aAh().cachePath + "WxFileIndex.db";
    this.kvx = r.a(hashCode(), paramc, kvw, true);
    this.iLv.put(Integer.valueOf(43), new com.tencent.mm.plugin.f.a.e());
    this.iLv.put(Integer.valueOf(62), new com.tencent.mm.plugin.f.a.e());
    this.iLv.put(Integer.valueOf(44), new com.tencent.mm.plugin.f.a.e());
    this.iLv.put(Integer.valueOf(486539313), new com.tencent.mm.plugin.f.a.e());
    this.iLv.put(Integer.valueOf(34), new f());
    this.iLv.put(Integer.valueOf(3), new com.tencent.mm.plugin.f.a.d());
    this.iLv.put(Integer.valueOf(49), new com.tencent.mm.plugin.f.a.c());
    this.iLv.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.f.a.b());
    csa();
    ((l)g.af(l.class)).eiy().a(this.gsV, null);
    EventCenter.instance.add(this.pPU);
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
    for (this.cSX = bool;; this.cSX = false)
    {
      this.pPV = ((PowerManager)paramc.getSystemService("power")).isScreenOn();
      this.pPW = new BroadcastReceiver()
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
            if ((!b.j(b.this)) || (b.k(b.this))) {
              break label273;
            }
            Log.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
            if (b.l(b.this) != null) {
              break label313;
            }
            b.b(b.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(22689);
                b.this.crY();
                b.crZ();
                Log.i("MicroMsg.CalcWxService", "start to calc");
                if (b.this.csb())
                {
                  b localb = b.this;
                  long l = ((Long)g.aAh().azQ().get(ar.a.OdB, Long.valueOf(0L))).longValue();
                  MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
                  Log.i("MicroMsg.CalcWxService", "checkAndReport, midImgSize:%s, hevcSize:%s", new Object[] { Long.valueOf(localMultiProcessMMKV.getLong("CleanCalcMidImg", 0L)), Long.valueOf(localMultiProcessMMKV.getLong("CleanCalcHevcImg", 0L)) });
                  if (Util.milliSecondsToNow(l) >= 259200000L)
                  {
                    if (localb.pPR != null) {
                      localb.pPR.isStop = true;
                    }
                    localb.pPR = new com.tencent.mm.plugin.f.c.c();
                    localb.post(localb.pPR);
                    g.aAh().azQ().set(ar.a.OdB, Long.valueOf(Util.nowMilliSecond()));
                  }
                  AppMethodBeat.o(22689);
                  return;
                }
                h.CyF.idkeyStat(664L, 1L, 1L, false);
                b.i(b.this);
                AppMethodBeat.o(22689);
              }
            });
            bg.aAk().postToWorkerDelayed(b.l(b.this), 300000L);
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
            b.b(b.this, true);
            continue;
            b.b(b.this, false);
            continue;
            b.c(b.this, true);
            continue;
            b.c(b.this, false);
          }
          label273:
          if (b.l(b.this) != null)
          {
            bg.aAk();
            MMHandlerThread.removeRunnable(b.l(b.this));
            b.b(b.this, null);
          }
          b.m(b.this);
          label313:
          AppMethodBeat.o(22690);
        }
      };
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      paramc.registerReceiver(this.pPW, (IntentFilter)localObject);
      EventCenter.instance.add(this.pPZ);
      if (this.pPY) {
        EventCenter.instance.publish(new com.tencent.mm.g.a.ca());
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
    this.pPN.clear();
    this.pPO = false;
    if (this.kvx != null)
    {
      this.kvx.uS(hashCode());
      this.kvx = null;
    }
    ((l)g.af(l.class)).eiy().a(this.gsV);
    EventCenter.instance.removeListener(this.pPU);
    this.iLv.clear();
    if (this.pPW != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(this.pPW);
      this.pPW = null;
    }
    if (this.pPX != null)
    {
      bg.aAk();
      MMHandlerThread.removeRunnable(this.pPX);
      this.pPX = null;
    }
    stopScan();
    if (this.pPL != null)
    {
      Log.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[] { bgQ() });
      this.pPL.quit();
    }
    this.pPL = null;
    EventCenter.instance.removeListener(this.pPZ);
    AppMethodBeat.o(22712);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(22707);
    try
    {
      if (this.pPL != null)
      {
        this.pPL.postToWorker(paramRunnable);
        AppMethodBeat.o(22707);
        return;
      }
      Log.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[] { bgQ() });
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
 * Qualified Name:     com.tencent.mm.plugin.f.b
 * JD-Core Version:    0.7.0.1
 */