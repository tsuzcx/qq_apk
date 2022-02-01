package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.SparseArray;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abr;
import com.tencent.mm.autogen.a.cb;
import com.tencent.mm.autogen.a.dc;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.co;
import com.tencent.mm.model.co.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class PluginFTS
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, n
{
  public static boolean Hqz;
  private co.a HqA;
  private IListener HqB;
  private com.tencent.mm.am.h HqC;
  private IListener HqD;
  private BroadcastReceiver HqE;
  private ConcurrentHashMap<Integer, com.tencent.mm.plugin.fts.a.i> HqF;
  private e HqG;
  private SparseArray<com.tencent.mm.plugin.fts.a.d.d> HqH;
  private com.tencent.mm.plugin.fts.a.d.c HqI;
  private SparseArray<com.tencent.mm.plugin.fts.a.d.a.b> HqJ;
  private SparseArray<k> HqK;
  private IListener HqL;
  private volatile g Hqr;
  private volatile d Hqs;
  private volatile boolean Hqt;
  private volatile boolean Hqu;
  private boolean Hqv;
  private boolean Hqw;
  private Runnable Hqx;
  private DatabaseErrorHandler Hqy;
  private IListener wPn;
  
  public PluginFTS()
  {
    AppMethodBeat.i(52580);
    this.Hqt = false;
    this.Hqu = false;
    this.Hqv = false;
    this.Hqw = false;
    this.Hqx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(52563);
        if (PluginFTS.this.Hqs != null) {
          PluginFTS.this.Hqs.fxj();
        }
        AppMethodBeat.o(52563);
      }
    };
    this.Hqy = new DatabaseErrorHandler()
    {
      public final void onCorruption(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        AppMethodBeat.i(52565);
        com.tencent.mm.plugin.fts.a.e.Wf(18);
        com.tencent.mm.kernel.h.baF();
        int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSY, Integer.valueOf(5))).intValue();
        Log.e("MicroMsg.FTS.PluginFTS", "DB onCorrupt dbCorruptRebuildTimes: %d", new Object[] { Integer.valueOf(i) });
        if (i > 0)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acSY, Integer.valueOf(i - 1));
          try
          {
            PluginFTS.access$200(PluginFTS.this);
            PluginFTS.access$300(PluginFTS.this);
            if (PluginFTS.this.Hqs != null)
            {
              PluginFTS.this.Hqs.close();
              PluginFTS.access$102(PluginFTS.this, null);
            }
            d.fxk();
            paramAnonymousSQLiteDatabase = PluginFTS.this.Hqr;
            if (paramAnonymousSQLiteDatabase.Hqi != null) {
              paramAnonymousSQLiteDatabase.Hqi.Hqk.clear();
            }
            PluginFTS.this.Hqr.a(-131072, new PluginFTS.b(PluginFTS.this));
            PluginFTS.this.Hqr.a(-131071, new PluginFTS.a(PluginFTS.this, (byte)0));
          }
          catch (Exception paramAnonymousSQLiteDatabase)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.FTS.PluginFTS", paramAnonymousSQLiteDatabase, "onCorruption handle error", new Object[0]);
            }
          }
          paramAnonymousSQLiteDatabase = new f("Throw FTSStopTaskException From FTSDatabaseErrorHandler");
          AppMethodBeat.o(52565);
          throw paramAnonymousSQLiteDatabase;
        }
        com.tencent.mm.plugin.fts.a.e.Wf(23);
        AppMethodBeat.o(52565);
      }
    };
    this.HqA = new co.a()
    {
      public final boolean bDy()
      {
        AppMethodBeat.i(52566);
        Log.w("MicroMsg.FTS.PluginFTS", "HERE UninitForUEH is called! stg:%s ", new Object[] { PluginFTS.this.Hqs });
        PluginFTS.Hqz = true;
        if (PluginFTS.this.Hqs != null)
        {
          PluginFTS.this.Hqs.fxj();
          PluginFTS.this.Hqs.close();
        }
        AppMethodBeat.o(52566);
        return true;
      }
    };
    this.wPn = new IListener(com.tencent.mm.app.f.hfK) {};
    this.HqB = new IListener(com.tencent.mm.app.f.hfK) {};
    this.HqC = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(52569);
        com.tencent.mm.kernel.h.baF();
        if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(15, null)) != 0)
        {
          com.tencent.mm.kernel.h.aZW().b(138, PluginFTS.this.HqC);
          PluginFTS.access$1502(PluginFTS.this, true);
          Log.i("MicroMsg.FTS.PluginFTS", "*** User has finished initializing.");
          PluginFTS.access$1200(PluginFTS.this);
        }
        AppMethodBeat.o(52569);
      }
    };
    this.HqD = new IListener(com.tencent.mm.app.f.hfK) {};
    this.HqE = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(52573);
        if ((paramAnonymousIntent == null) || (paramAnonymousIntent.getAction() == null))
        {
          AppMethodBeat.o(52573);
          return;
        }
        Log.i("MicroMsg.FTS.PluginFTS", "*** Charging notified: " + paramAnonymousIntent.getAction());
        if (paramAnonymousIntent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED"))
        {
          PluginFTS.access$1602(PluginFTS.this, true);
          AppMethodBeat.o(52573);
          return;
        }
        if (paramAnonymousIntent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
          PluginFTS.access$1602(PluginFTS.this, false);
        }
        AppMethodBeat.o(52573);
      }
    };
    this.HqF = new ConcurrentHashMap();
    this.HqH = new SparseArray();
    this.HqJ = new SparseArray();
    this.HqK = new SparseArray();
    this.HqL = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(52580);
  }
  
  private void addCheckLanguageTask()
  {
    AppMethodBeat.i(52621);
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSTaskDaemon().a(65536, new com.tencent.mm.plugin.fts.a.a.c()
    {
      String HqP;
      boolean cao;
      
      public final boolean aXz()
      {
        AppMethodBeat.i(52575);
        if ((int)((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().aF(-3L, 0L) != this.HqP.hashCode()) {}
        for (boolean bool = true;; bool = false)
        {
          this.cao = bool;
          if (this.cao) {
            new abr().publish();
          }
          AppMethodBeat.o(52575);
          return true;
        }
      }
      
      public final String coz()
      {
        AppMethodBeat.i(52576);
        String str = String.format("{changed: %b}", new Object[] { Boolean.valueOf(this.cao) });
        AppMethodBeat.o(52576);
        return str;
      }
      
      public final String getName()
      {
        return "CheckLanguageUpdate";
      }
    });
    AppMethodBeat.o(52621);
  }
  
  private void createIndexStorage()
  {
    int i = 0;
    AppMethodBeat.i(52593);
    Log.i("MicroMsg.FTS.PluginFTS", "Create Index Storage %d", new Object[] { Integer.valueOf(this.HqF.size()) });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.HqF.values().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add((com.tencent.mm.plugin.fts.a.i)localIterator.next());
    }
    Collections.sort(localLinkedList);
    while (i < localLinkedList.size())
    {
      ((com.tencent.mm.plugin.fts.a.i)localLinkedList.get(i)).create();
      i += 1;
    }
    AppMethodBeat.o(52593);
  }
  
  private void createNativeLogic()
  {
    AppMethodBeat.i(52589);
    Log.i("MicroMsg.FTS.PluginFTS", "Create Native Logic");
    int i = 0;
    for (;;)
    {
      if (i < this.HqK.size())
      {
        int j = this.HqK.keyAt(i);
        k localk = (k)this.HqK.get(j);
        if (localk != null) {}
        try
        {
          localk.create();
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[] { localk.getName(), Util.stackTraceToString(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(52589);
  }
  
  private void destroyItemClickHandler()
  {
    AppMethodBeat.i(52592);
    this.HqJ.clear();
    AppMethodBeat.o(52592);
  }
  
  private void destroyNativeLogic()
  {
    AppMethodBeat.i(52590);
    Log.i("MicroMsg.FTS.PluginFTS", "Destroy Native Logic");
    int i = 0;
    for (;;)
    {
      if (i < this.HqK.size())
      {
        int j = this.HqK.keyAt(i);
        k localk = (k)this.HqK.get(j);
        if (localk != null) {}
        try
        {
          localk.destroy();
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[] { localk.getName(), Util.stackTraceToString(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(52590);
  }
  
  private void destroyNativeUILogic()
  {
    AppMethodBeat.i(52591);
    this.HqH.clear();
    AppMethodBeat.o(52591);
  }
  
  private void destroyStorage()
  {
    AppMethodBeat.i(52594);
    Log.i("MicroMsg.FTS.PluginFTS", "Destroy Index Storage");
    Iterator localIterator = this.HqF.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.i locali = (com.tencent.mm.plugin.fts.a.i)localIterator.next();
      if (locali != null) {
        locali.destroy();
      }
    }
    AppMethodBeat.o(52594);
  }
  
  private void registerSearchLogic()
  {
    AppMethodBeat.i(52587);
    registerNativeLogic(1, new com.tencent.mm.plugin.fts.logic.g());
    registerNativeLogic(2, new com.tencent.mm.plugin.fts.logic.b());
    registerNativeLogic(3, new com.tencent.mm.plugin.fts.logic.d());
    registerNativeLogic(4, new com.tencent.mm.plugin.fts.logic.c());
    registerNativeLogic(8, new com.tencent.mm.plugin.fts.logic.e());
    registerNativeLogic(11, new com.tencent.mm.plugin.fts.logic.a());
    registerNativeLogic(12, new com.tencent.mm.plugin.fts.logic.f());
    registerNativeLogic(10000, new com.tencent.mm.plugin.fts.logic.i());
    AppMethodBeat.o(52587);
  }
  
  private void registerStorage()
  {
    AppMethodBeat.i(52588);
    registerIndexStorage(new com.tencent.mm.plugin.fts.b.g());
    registerIndexStorage(new com.tencent.mm.plugin.fts.b.b());
    registerIndexStorage(new com.tencent.mm.plugin.fts.b.c());
    registerIndexStorage(new com.tencent.mm.plugin.fts.b.d());
    registerIndexStorage(new com.tencent.mm.plugin.fts.b.e());
    registerIndexStorage(new com.tencent.mm.plugin.fts.b.a());
    registerIndexStorage(new com.tencent.mm.plugin.fts.b.f());
    AppMethodBeat.o(52588);
  }
  
  private void startDaemon()
  {
    AppMethodBeat.i(52596);
    if (!this.Hqr.isStart())
    {
      g localg = this.Hqr;
      localg.Hqi.start();
      Log.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon started with TID: " + localg.Hqi.getId());
    }
    AppMethodBeat.o(52596);
  }
  
  private void waitAndStartDaemon()
  {
    AppMethodBeat.i(52595);
    com.tencent.mm.kernel.h.baF();
    boolean bool;
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(15, null)) != 0)
    {
      bool = true;
      this.Hqt = bool;
      if (this.Hqt) {
        break label111;
      }
      com.tencent.mm.kernel.h.aZW().a(138, this.HqC);
      Log.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for account initialized");
      label66:
      if (this.Hqu) {
        break label122;
      }
      Log.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for all account post reset.");
    }
    for (;;)
    {
      if ((this.Hqt) && (this.Hqu)) {
        startDaemon();
      }
      AppMethodBeat.o(52595);
      return;
      bool = false;
      break;
      label111:
      Log.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon user is initialized.");
      break label66;
      label122:
      Log.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon all account post reset.");
    }
  }
  
  public void addSOSHistory(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52600);
    if ((isFTSContextReady()) && (this.HqK.indexOfKey(8) >= 0)) {
      ((k)this.HqK.get(8)).addSOSHistory(paramString1, paramString2);
    }
    AppMethodBeat.o(52600);
  }
  
  public void cancelSearchTask(com.tencent.mm.plugin.fts.a.a.c paramc)
  {
    AppMethodBeat.i(52598);
    if (isFTSContextReady()) {
      this.Hqr.a(paramc);
    }
    AppMethodBeat.o(52598);
  }
  
  public com.tencent.mm.plugin.fts.a.d.e createFTSUIUnit(int paramInt1, Context paramContext, e.b paramb, int paramInt2)
  {
    AppMethodBeat.i(52611);
    com.tencent.mm.plugin.fts.a.d.d locald = (com.tencent.mm.plugin.fts.a.d.d)this.HqH.get(paramInt1);
    if (locald != null)
    {
      paramContext = locald.a(paramContext, paramb, paramInt2);
      AppMethodBeat.o(52611);
      return paramContext;
    }
    AppMethodBeat.o(52611);
    return null;
  }
  
  public LinkedList<com.tencent.mm.plugin.fts.a.d.e> createFTSUIUnitList(HashSet<Integer> paramHashSet, Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(52610);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      int i = ((Integer)paramHashSet.next()).intValue();
      com.tencent.mm.plugin.fts.a.d.d locald = (com.tencent.mm.plugin.fts.a.d.d)this.HqH.get(i);
      if (locald != null) {
        localLinkedList2.add(locald);
      }
    }
    Collections.sort(localLinkedList2);
    paramHashSet = localLinkedList2.iterator();
    while (paramHashSet.hasNext()) {
      localLinkedList1.add(((com.tencent.mm.plugin.fts.a.d.d)paramHashSet.next()).a(paramContext, paramb, paramInt));
    }
    AppMethodBeat.o(52610);
    return localLinkedList1;
  }
  
  public void deleteSOSHistory()
  {
    AppMethodBeat.i(52601);
    if ((isFTSContextReady()) && (this.HqK.indexOfKey(8) >= 0)) {
      ((k)this.HqK.get(8)).deleteSOSHistory();
    }
    AppMethodBeat.o(52601);
  }
  
  public void deleteSOSHistory(String paramString)
  {
    AppMethodBeat.i(52602);
    if ((isFTSContextReady()) && (this.HqK.indexOfKey(8) >= 0)) {
      ((k)this.HqK.get(8)).deleteSOSHistory(paramString);
    }
    AppMethodBeat.o(52602);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(52583);
    if (paramg.bbA()) {
      com.tencent.mm.kernel.h.b(aw.class, new com.tencent.mm.plugin.fts.logic.h());
    }
    AppMethodBeat.o(52583);
  }
  
  public DatabaseErrorHandler getDatabaseErrorHandler()
  {
    return this.Hqy;
  }
  
  public com.tencent.mm.plugin.fts.a.d.c getFTSImageLoader()
  {
    return this.HqI;
  }
  
  public d getFTSIndexDB()
  {
    return this.Hqs;
  }
  
  public com.tencent.mm.plugin.fts.a.i getFTSIndexStorage(int paramInt)
  {
    AppMethodBeat.i(52605);
    com.tencent.mm.plugin.fts.a.i locali = (com.tencent.mm.plugin.fts.a.i)this.HqF.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(52605);
    return locali;
  }
  
  public j getFTSMainDB()
  {
    AppMethodBeat.i(52606);
    if (this.HqG == null) {
      this.HqG = new e();
    }
    e locale = this.HqG;
    AppMethodBeat.o(52606);
    return locale;
  }
  
  public m getFTSTaskDaemon()
  {
    AppMethodBeat.i(52585);
    initFTSTaskDaemon();
    g localg = this.Hqr;
    AppMethodBeat.o(52585);
    return localg;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.b getItemClickHandler(int paramInt)
  {
    AppMethodBeat.i(52614);
    com.tencent.mm.plugin.fts.a.d.a.b localb = (com.tencent.mm.plugin.fts.a.d.a.b)this.HqJ.get(paramInt);
    AppMethodBeat.o(52614);
    return localb;
  }
  
  public com.tencent.mm.plugin.fts.logic.i getSearchTestLogic()
  {
    AppMethodBeat.i(52620);
    com.tencent.mm.plugin.fts.logic.i locali = (com.tencent.mm.plugin.fts.logic.i)this.HqK.get(10000);
    AppMethodBeat.o(52620);
    return locali;
  }
  
  public com.tencent.mm.plugin.fts.logic.g getTopHitsLogic()
  {
    AppMethodBeat.i(52619);
    com.tencent.mm.plugin.fts.logic.g localg = (com.tencent.mm.plugin.fts.logic.g)this.HqK.get(1);
    AppMethodBeat.o(52619);
    return localg;
  }
  
  public void initFTSTaskDaemon()
  {
    AppMethodBeat.i(52584);
    g localg;
    if (this.Hqr == null)
    {
      this.Hqr = new g();
      localg = this.Hqr;
      if ((localg.Hqi == null) || (!localg.Hqi.isAlive())) {
        break label98;
      }
      Log.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", new Throwable(), "Duplicated daemon initialization detected, working queue maybe dirty!", new Object[0]);
    }
    for (;;)
    {
      localg = this.Hqr;
      Runnable localRunnable = this.Hqx;
      if (localg.Hqi != null) {
        localg.Hqi.Hqo = localRunnable;
      }
      AppMethodBeat.o(52584);
      return;
      label98:
      localg.Hqi = new g.a(localg);
      Log.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon initialized, waiting for starting.");
    }
  }
  
  public boolean isCharging()
  {
    return this.Hqv;
  }
  
  public boolean isFTSContextReady()
  {
    AppMethodBeat.i(52617);
    boolean bool = getFTSTaskDaemon().isStart();
    AppMethodBeat.o(52617);
    return bool;
  }
  
  public boolean isInBackground()
  {
    return this.Hqw;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(52581);
    Object localObject = new u(com.tencent.mm.plugin.fts.a.c.Hrx);
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    if (this.Hqr != null) {
      this.Hqr.quit();
    }
    initFTSTaskDaemon();
    localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    localObject = MMApplicationContext.getContext().registerReceiver(null, (IntentFilter)localObject);
    boolean bool;
    if (localObject != null)
    {
      int i = ((Intent)localObject).getIntExtra("status", -1);
      if ((i == 2) || (i == 5)) {
        bool = true;
      }
    }
    for (this.Hqv = bool;; this.Hqv = false)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      MMApplicationContext.getContext().registerReceiver(this.HqE, (IntentFilter)localObject);
      com.tencent.mm.kernel.h.baG().a(this.HqA);
      this.HqB.alive();
      this.HqD.alive();
      this.wPn.alive();
      this.HqL.alive();
      com.tencent.mm.kernel.h.aZW().a(138, this.HqC);
      this.Hqr.a(-131072, new b());
      this.Hqr.a(-131071, new a((byte)0));
      this.HqI = new c();
      addCheckLanguageTask();
      if (!paramc.mDg) {
        break label326;
      }
      Log.i("MicroMsg.FTS.PluginFTS", "upgrade reset rebuild times to 3");
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSY, Integer.valueOf(5));
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSZ, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(52581);
      return;
      bool = false;
      break;
    }
    label326:
    com.tencent.mm.kernel.h.baF();
    long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.acSZ, 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      Log.i("MicroMsg.FTS.PluginFTS", "one day reset rebuild times to 3");
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSY, Integer.valueOf(5));
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSZ, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(52581);
      return;
    }
    Log.i("MicroMsg.FTS.PluginFTS", "no need reset rebuild times to 3 %s preVersion %s", new Object[] { Long.valueOf(l), Integer.valueOf(paramc.mDh) });
    AppMethodBeat.o(52581);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(52582);
    destroyNativeLogic();
    destroyNativeUILogic();
    destroyItemClickHandler();
    destroyStorage();
    if (this.Hqr != null)
    {
      this.Hqr.quit();
      this.Hqr = null;
    }
    if (this.Hqs != null)
    {
      this.Hqs.close();
      this.Hqs = null;
    }
    if (this.HqI != null)
    {
      this.HqI.fxi();
      this.HqI = null;
    }
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(this.HqE);
      label91:
      this.HqB.dead();
      this.wPn.dead();
      this.HqL.dead();
      this.HqD.dead();
      com.tencent.mm.kernel.h.aZW().b(138, this.HqC);
      com.tencent.mm.kernel.h.baG().b(this.HqA);
      this.Hqt = false;
      this.Hqu = false;
      AppMethodBeat.o(52582);
      return;
    }
    catch (Exception localException)
    {
      break label91;
    }
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(52586);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).db(com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class));
    AppMethodBeat.o(52586);
  }
  
  public void registerFTSUILogic(com.tencent.mm.plugin.fts.a.d.d paramd)
  {
    AppMethodBeat.i(52608);
    try
    {
      this.HqH.put(paramd.getType(), paramd);
      AppMethodBeat.o(52608);
      return;
    }
    catch (Exception paramd)
    {
      AppMethodBeat.o(52608);
    }
  }
  
  public void registerIndexStorage(com.tencent.mm.plugin.fts.a.i parami)
  {
    AppMethodBeat.i(52603);
    this.HqF.put(Integer.valueOf(parami.getType()), parami);
    AppMethodBeat.o(52603);
  }
  
  public void registerItemClickHandler(int paramInt, com.tencent.mm.plugin.fts.a.d.a.b paramb)
  {
    AppMethodBeat.i(52612);
    this.HqJ.put(paramInt, paramb);
    AppMethodBeat.o(52612);
  }
  
  public void registerNativeLogic(int paramInt, k paramk)
  {
    AppMethodBeat.i(52615);
    this.HqK.put(paramInt, paramk);
    AppMethodBeat.o(52615);
  }
  
  public com.tencent.mm.plugin.fts.a.a.c search(int paramInt, l paraml)
  {
    AppMethodBeat.i(52597);
    if (!isFTSContextReady())
    {
      paraml = new b(paraml);
      ThreadPool.post(paraml, "FTSExceptionHandler");
      AppMethodBeat.o(52597);
      return paraml;
    }
    if (this.HqK.indexOfKey(paramInt) >= 0)
    {
      k localk = (k)this.HqK.get(paramInt);
      if (localk.isCreated())
      {
        paraml = localk.a(paraml);
        AppMethodBeat.o(52597);
        return paraml;
      }
      paraml = new b(paraml);
      ThreadPool.post(paraml, "FTSExceptionHandler");
      AppMethodBeat.o(52597);
      return paraml;
    }
    Log.e("MicroMsg.FTS.PluginFTS", "Not Found Search Logic, LogicArraySize=%d", new Object[] { Integer.valueOf(this.HqK.size()) });
    paraml = new b(paraml);
    ThreadPool.post(paraml, "FTSExceptionHandler");
    AppMethodBeat.o(52597);
    return paraml;
  }
  
  public void setFTSImageLoader(com.tencent.mm.plugin.fts.a.d.c paramc)
  {
    this.HqI = paramc;
  }
  
  public int stringCompareUtfBinary(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52607);
    int i = FTSJNIUtils.stringCompareUtfBinary(paramString1, paramString2);
    AppMethodBeat.o(52607);
    return i;
  }
  
  public void unregisterFTSUILogic(int paramInt)
  {
    AppMethodBeat.i(52609);
    try
    {
      this.HqH.remove(paramInt);
      AppMethodBeat.o(52609);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(52609);
    }
  }
  
  public void unregisterIndexStorage(int paramInt)
  {
    AppMethodBeat.i(52604);
    com.tencent.mm.plugin.fts.a.i locali;
    if (this.HqF.containsKey(Integer.valueOf(paramInt))) {
      locali = (com.tencent.mm.plugin.fts.a.i)this.HqF.get(Integer.valueOf(paramInt));
    }
    try
    {
      locali.destroy();
      this.HqF.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(52604);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.FTS.PluginFTS", "Destroy Index Storage name=%s \nexception=%s", new Object[] { locali.getName(), Util.stackTraceToString(localException) });
      }
    }
  }
  
  public void unregisterItemClickHandler(int paramInt)
  {
    AppMethodBeat.i(52613);
    this.HqJ.remove(paramInt);
    AppMethodBeat.o(52613);
  }
  
  public void unregisterNativeLogic(int paramInt)
  {
    AppMethodBeat.i(52616);
    k localk;
    if (this.HqK.indexOfKey(paramInt) >= 0) {
      localk = (k)this.HqK.get(paramInt);
    }
    try
    {
      localk.destroy();
      this.HqK.remove(paramInt);
      AppMethodBeat.o(52616);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.FTS.PluginFTS", "Destroy Native Logic name=%s \nexception=%s", new Object[] { localk.getName(), Util.stackTraceToString(localException) });
      }
    }
  }
  
  public void updateTopHitsRank(String paramString, o paramo, int paramInt)
  {
    AppMethodBeat.i(52599);
    if ((isFTSContextReady()) && (this.HqK.indexOfKey(1) >= 0)) {
      ((k)this.HqK.get(1)).a(paramString, paramo, paramInt, com.tencent.mm.plugin.fts.a.d.fxs());
    }
    AppMethodBeat.o(52599);
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private a() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52577);
      aEp("start");
      try
      {
        String[] arrayOfString1 = new String(y.bi("assets:///fts/fts_t2s.txt", 0, -1)).split("\n");
        int j = arrayOfString1.length;
        int i = 0;
        String[] arrayOfString3;
        while (i < j)
        {
          arrayOfString3 = arrayOfString1[i].split(",");
          com.tencent.mm.plugin.fts.a.g.pBs.put(arrayOfString3[0], arrayOfString3[1]);
          i += 1;
        }
        try
        {
          arrayOfString2 = new String(y.bi("assets:///fts/fts_py.txt", 0, -1)).split("\n");
          i = 0;
          if (i >= arrayOfString2.length) {
            break label272;
          }
          arrayOfString5 = arrayOfString2[i].split(",");
          arrayOfString3 = arrayOfString5[0];
          arrayOfString4 = new String[arrayOfString5.length - 1];
          j = 0;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            com.tencent.mm.plugin.fts.a.e.Wf(27);
            Log.printErrStackTrace("MicroMsg.FTS.PluginFTS", localException2, localException2.getMessage(), new Object[0]);
            aEp("py");
            com.tencent.mm.plugin.fts.a.e.HrL.HrP = (d.fxl().length() / 1048576L);
            com.tencent.mm.plugin.fts.a.e.HrL.HrQ = PluginFTS.this.Hqs.aF(-301L, 0L);
            com.tencent.mm.plugin.fts.a.e.HrL.HrR = PluginFTS.this.Hqs.aF(-302L, 0L);
            com.tencent.mm.plugin.fts.a.e.HrL.HrT = PluginFTS.this.Hqs.aF(-303L, 0L);
            com.tencent.mm.plugin.fts.a.e.HrL.HrS = PluginFTS.this.Hqs.aF(-304L, 0L);
            long l1 = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().aF(-300L, 0L);
            long l2 = System.currentTimeMillis();
            if (!com.tencent.mm.plugin.fts.a.d.isSameDay(l1, l2))
            {
              com.tencent.mm.plugin.fts.a.e.fxt();
              ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().aG(-300L, l2);
            }
            for (;;)
            {
              aEp("reportData");
              String str = com.tencent.mm.kernel.h.baE().bal();
              Log.i("MicroMsg.FTS.PluginFTS", "ftsDBSize: %s mainEnDBPath:%s", new Object[] { Util.getSizeMB(y.bEl(com.tencent.mm.kernel.h.baE().cachePath + "FTS5IndexMicroMsg_encrypt.db")), Util.getSizeMB(y.bEl(str)) });
              AppMethodBeat.o(52577);
              return true;
              Log.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
            }
            j += 1;
          }
        }
      }
      catch (Exception localException1)
      {
        com.tencent.mm.plugin.fts.a.e.Wf(26);
        Log.printErrStackTrace("MicroMsg.FTS.PluginFTS", localException1, localException1.getMessage(), new Object[0]);
        aEp("t2s");
      }
      for (;;)
      {
        String[] arrayOfString2;
        String[] arrayOfString5;
        String[] arrayOfString4;
        if (j < arrayOfString4.length)
        {
          if (j + 1 >= arrayOfString5.length) {
            break;
          }
          arrayOfString4[j] = arrayOfString5[(j + 1)];
          break;
        }
        if (arrayOfString4.length > 0)
        {
          int k = arrayOfString4.length;
          j = 0;
          while (j < k)
          {
            arrayOfString5 = arrayOfString4[j];
            com.tencent.mm.plugin.fts.a.g.Hsn.aEs(arrayOfString5);
            j += 1;
          }
          com.tencent.mm.plugin.fts.a.g.Hso.put(arrayOfString3, arrayOfString4);
        }
        i += 1;
      }
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52578);
      String str = String.format("{T2S: %d PY: %d}", new Object[] { Integer.valueOf(com.tencent.mm.plugin.fts.a.g.pBs.size()), Integer.valueOf(com.tencent.mm.plugin.fts.a.g.Hso.size()) });
      AppMethodBeat.o(52578);
      return str;
    }
    
    public final String getName()
    {
      return "InitResourceTask";
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    b() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52579);
      com.tencent.mm.kernel.h.baF();
      if (2 != ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSX, Integer.valueOf(0))).intValue())
      {
        d.fxk();
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acSX, Integer.valueOf(2));
      }
      com.tencent.mm.kernel.h.baF();
      Object localObject1 = new u(com.tencent.mm.kernel.h.baE().cachePath, "IndexMicroMsg.db");
      if (((u)localObject1).jKS()) {
        ((u)localObject1).diJ();
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.baF();
        localObject1 = new u(com.tencent.mm.kernel.h.baE().cachePath, "FTS5IndexMicroMsg.db");
        if (((u)localObject1).jKS())
        {
          ((u)localObject1).diJ();
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjX, 0) == 1)
          {
            com.tencent.mm.kernel.h.baF();
            localObject1 = new u(com.tencent.mm.kernel.h.baE().cachePath, "FTS5IndexMicroMsg_encrypt.db");
            com.tencent.mm.kernel.h.baF();
            u localu = new u(com.tencent.mm.kernel.h.baE().bal());
            Object localObject2 = new StringBuilder();
            com.tencent.mm.kernel.h.baF();
            localObject2 = new u(com.tencent.mm.kernel.h.baE().cachePath + "enFavorite.db");
            Log.i("MicroMsg.FTS.PluginFTS", "ftsEncryptDB:%s mainEncryptDB:%s favEncryptDB:%s", new Object[] { Util.getSizeMB(((u)localObject1).length()), Util.getSizeMB(localu.length()), Util.getSizeMB(((u)localObject2).length()) });
            if (((u)localObject1).length() > 1610612736.0D)
            {
              long l1 = ((u)localObject1).length();
              long l2 = localu.length();
              if (l1 > (((u)localObject2).length() + l2) * 2L)
              {
                ((u)localObject1).diJ();
                Log.i("MicroMsg.FTS.PluginFTS", "try to delete old db and rebuild");
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(729L, 14L, 1L, false);
              }
            }
          }
        }
        try
        {
          localObject1 = PluginFTS.this;
          com.tencent.mm.kernel.h.baF();
          PluginFTS.access$102((PluginFTS)localObject1, new d(com.tencent.mm.kernel.h.baE().cachePath));
          PluginFTS.access$500(PluginFTS.this);
          PluginFTS.access$600(PluginFTS.this);
          PluginFTS.access$700(PluginFTS.this);
          PluginFTS.access$800(PluginFTS.this);
          AppMethodBeat.o(52579);
          return true;
          Log.i("MicroMsg.FTS.PluginFTS", "not exist fts3DBFile %s", new Object[] { ah.v(((u)localObject1).jKT()) });
          continue;
          Log.i("MicroMsg.FTS.PluginFTS", "not exist fts5DBUnEncrypt %s", new Object[] { ah.v(((u)localObject1).jKT()) });
        }
        catch (f localf)
        {
          AppMethodBeat.o(52579);
          throw localf;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (PluginFTS.Hqz)
            {
              AppMethodBeat.o(52579);
              return true;
            }
            Log.printErrStackTrace("MicroMsg.FTS.PluginFTS", localException, "Index database corruption detected", new Object[0]);
            PluginFTS.this.Hqy.onCorruption(null);
          }
        }
      }
    }
    
    public final String getName()
    {
      return "InitSearchTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS
 * JD-Core Version:    0.7.0.1
 */