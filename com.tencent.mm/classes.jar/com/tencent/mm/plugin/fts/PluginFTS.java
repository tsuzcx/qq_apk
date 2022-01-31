package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.wcdb.DatabaseErrorHandler;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class PluginFTS
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, n
{
  public static boolean mPY;
  private volatile f mPP;
  private volatile d mPQ;
  private volatile boolean mPR;
  private volatile boolean mPS;
  private boolean mPT;
  private boolean mPU;
  private volatile boolean mPV;
  private Runnable mPW;
  private DatabaseErrorHandler mPX;
  private cc.a mPZ;
  private com.tencent.mm.sdk.b.c mQa;
  private com.tencent.mm.sdk.b.c mQb;
  private com.tencent.mm.ai.f mQc;
  private com.tencent.mm.sdk.b.c mQd;
  private BroadcastReceiver mQe;
  private ConcurrentHashMap<Integer, com.tencent.mm.plugin.fts.a.i> mQf;
  private e mQg;
  private SparseArray<com.tencent.mm.plugin.fts.a.d.d> mQh;
  private com.tencent.mm.plugin.fts.a.d.c mQi;
  private SparseArray<com.tencent.mm.plugin.fts.a.d.a.b> mQj;
  private SparseArray<k> mQk;
  private com.tencent.mm.sdk.b.c mQl;
  
  public PluginFTS()
  {
    AppMethodBeat.i(136600);
    this.mPR = false;
    this.mPS = false;
    this.mPT = false;
    this.mPU = false;
    this.mPW = new PluginFTS.1(this);
    this.mPX = new PluginFTS.3(this);
    this.mPZ = new cc.a()
    {
      public final boolean abs()
      {
        AppMethodBeat.i(136583);
        ab.w("MicroMsg.FTS.PluginFTS", "HERE UninitForUEH is called! stg:%s ", new Object[] { PluginFTS.this.mPQ });
        PluginFTS.mPY = true;
        if (PluginFTS.this.mPQ != null)
        {
          PluginFTS.this.mPQ.rollback();
          PluginFTS.this.mPQ.close();
        }
        AppMethodBeat.o(136583);
        return true;
      }
    };
    this.mQa = new PluginFTS.5(this);
    this.mQb = new PluginFTS.6(this);
    this.mQc = new PluginFTS.7(this);
    this.mQd = new PluginFTS.8(this);
    this.mQe = new PluginFTS.9(this);
    this.mQf = new ConcurrentHashMap();
    this.mQh = new SparseArray();
    this.mQj = new SparseArray();
    this.mQk = new SparseArray();
    this.mQl = new PluginFTS.2(this);
    AppMethodBeat.o(136600);
  }
  
  private void addCheckLanguageTask()
  {
    AppMethodBeat.i(136640);
    ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSTaskDaemon().a(65536, new PluginFTS.10(this));
    AppMethodBeat.o(136640);
  }
  
  private void createIndexStorage()
  {
    int i = 0;
    AppMethodBeat.i(136613);
    ab.i("MicroMsg.FTS.PluginFTS", "Create Index Storage %d", new Object[] { Integer.valueOf(this.mQf.size()) });
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.mQf.values().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add((com.tencent.mm.plugin.fts.a.i)localIterator.next());
    }
    Collections.sort(localLinkedList);
    while (i < localLinkedList.size())
    {
      ((com.tencent.mm.plugin.fts.a.i)localLinkedList.get(i)).create();
      i += 1;
    }
    AppMethodBeat.o(136613);
  }
  
  private void createNativeLogic()
  {
    AppMethodBeat.i(136609);
    ab.i("MicroMsg.FTS.PluginFTS", "Create Native Logic");
    int i = 0;
    for (;;)
    {
      if (i < this.mQk.size())
      {
        int j = this.mQk.keyAt(i);
        k localk = (k)this.mQk.get(j);
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
            ab.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[] { localk.getName(), bo.l(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(136609);
  }
  
  private void destroyItemClickHandler()
  {
    AppMethodBeat.i(136612);
    this.mQj.clear();
    AppMethodBeat.o(136612);
  }
  
  private void destroyNativeLogic()
  {
    AppMethodBeat.i(136610);
    ab.i("MicroMsg.FTS.PluginFTS", "Destroy Native Logic");
    int i = 0;
    for (;;)
    {
      if (i < this.mQk.size())
      {
        int j = this.mQk.keyAt(i);
        k localk = (k)this.mQk.get(j);
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
            ab.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[] { localk.getName(), bo.l(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(136610);
  }
  
  private void destroyNativeUILogic()
  {
    AppMethodBeat.i(136611);
    this.mQh.clear();
    AppMethodBeat.o(136611);
  }
  
  private void destroyStorage()
  {
    AppMethodBeat.i(136614);
    ab.i("MicroMsg.FTS.PluginFTS", "Destroy Index Storage");
    Iterator localIterator = this.mQf.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.i locali = (com.tencent.mm.plugin.fts.a.i)localIterator.next();
      if (locali != null) {
        locali.destroy();
      }
    }
    AppMethodBeat.o(136614);
  }
  
  private void registerSearchLogic()
  {
    AppMethodBeat.i(136607);
    registerNativeLogic(1, new com.tencent.mm.plugin.fts.b.e());
    registerNativeLogic(2, new com.tencent.mm.plugin.fts.b.a());
    registerNativeLogic(3, new com.tencent.mm.plugin.fts.b.c());
    registerNativeLogic(4, new com.tencent.mm.plugin.fts.b.b());
    registerNativeLogic(8, new com.tencent.mm.plugin.fts.b.d());
    registerNativeLogic(10000, new com.tencent.mm.plugin.fts.b.g());
    AppMethodBeat.o(136607);
  }
  
  private void registerStorage()
  {
    AppMethodBeat.i(136608);
    registerIndexStorage(new com.tencent.mm.plugin.fts.c.e());
    registerIndexStorage(new com.tencent.mm.plugin.fts.c.a());
    registerIndexStorage(new com.tencent.mm.plugin.fts.c.b());
    registerIndexStorage(new com.tencent.mm.plugin.fts.c.c());
    registerIndexStorage(new com.tencent.mm.plugin.fts.c.d());
    AppMethodBeat.o(136608);
  }
  
  private void startDaemon()
  {
    AppMethodBeat.i(136616);
    if (!this.mPP.isStart())
    {
      f localf = this.mPP;
      localf.mPG.start();
      ab.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon started with TID: " + localf.mPG.getId());
    }
    AppMethodBeat.o(136616);
  }
  
  private void waitAndStartDaemon()
  {
    AppMethodBeat.i(136615);
    com.tencent.mm.kernel.g.RM();
    boolean bool;
    if (bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(15, null)) != 0)
    {
      bool = true;
      this.mPR = bool;
      if (this.mPR) {
        break label111;
      }
      com.tencent.mm.kernel.g.Rc().a(138, this.mQc);
      ab.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for account initialized");
      label66:
      if (this.mPS) {
        break label122;
      }
      ab.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for all account post reset.");
    }
    for (;;)
    {
      if ((this.mPR) && (this.mPS)) {
        startDaemon();
      }
      AppMethodBeat.o(136615);
      return;
      bool = false;
      break;
      label111:
      ab.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon user is initialized.");
      break label66;
      label122:
      ab.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon all account post reset.");
    }
  }
  
  public void addSOSHistory(String paramString)
  {
    AppMethodBeat.i(136620);
    if ((isFTSContextReady()) && (this.mQk.indexOfKey(8) >= 0)) {
      ((k)this.mQk.get(8)).addSOSHistory(paramString);
    }
    AppMethodBeat.o(136620);
  }
  
  public void cancelSearchTask(com.tencent.mm.plugin.fts.a.a.a parama)
  {
    AppMethodBeat.i(136618);
    if (isFTSContextReady())
    {
      Object localObject = this.mPP;
      if (((f)localObject).mPG != null)
      {
        localObject = ((f)localObject).mPG;
        parama.mCancelled = true;
        ((f.a)localObject).mPI.remove(parama);
        if (((f.a)localObject).mPK == parama) {
          ((f.a)localObject).interrupt();
        }
      }
    }
    AppMethodBeat.o(136618);
  }
  
  public com.tencent.mm.plugin.fts.a.d.e createFTSUIUnit(int paramInt1, Context paramContext, e.b paramb, int paramInt2)
  {
    AppMethodBeat.i(136631);
    com.tencent.mm.plugin.fts.a.d.d locald = (com.tencent.mm.plugin.fts.a.d.d)this.mQh.get(paramInt1);
    if (locald != null)
    {
      paramContext = locald.a(paramContext, paramb, paramInt2);
      AppMethodBeat.o(136631);
      return paramContext;
    }
    AppMethodBeat.o(136631);
    return null;
  }
  
  public LinkedList<com.tencent.mm.plugin.fts.a.d.e> createFTSUIUnitList(HashSet<Integer> paramHashSet, Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(136630);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      int i = ((Integer)paramHashSet.next()).intValue();
      com.tencent.mm.plugin.fts.a.d.d locald = (com.tencent.mm.plugin.fts.a.d.d)this.mQh.get(i);
      if (locald != null) {
        localLinkedList2.add(locald);
      }
    }
    Collections.sort(localLinkedList2);
    paramHashSet = localLinkedList2.iterator();
    while (paramHashSet.hasNext()) {
      localLinkedList1.add(((com.tencent.mm.plugin.fts.a.d.d)paramHashSet.next()).a(paramContext, paramb, paramInt));
    }
    AppMethodBeat.o(136630);
    return localLinkedList1;
  }
  
  public void deleteSOSHistory()
  {
    AppMethodBeat.i(136621);
    if ((isFTSContextReady()) && (this.mQk.indexOfKey(8) >= 0)) {
      ((k)this.mQk.get(8)).deleteSOSHistory();
    }
    AppMethodBeat.o(136621);
  }
  
  public void deleteSOSHistory(String paramString)
  {
    AppMethodBeat.i(136622);
    if ((isFTSContextReady()) && (this.mQk.indexOfKey(8) >= 0)) {
      ((k)this.mQk.get(8)).deleteSOSHistory(paramString);
    }
    AppMethodBeat.o(136622);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(136603);
    if (paramg.SD()) {
      com.tencent.mm.kernel.g.b(ak.class, new com.tencent.mm.plugin.fts.b.f());
    }
    AppMethodBeat.o(136603);
  }
  
  public DatabaseErrorHandler getDatabaseErrorHandler()
  {
    return this.mPX;
  }
  
  public com.tencent.mm.plugin.fts.a.d.c getFTSImageLoader()
  {
    return this.mQi;
  }
  
  public d getFTSIndexDB()
  {
    return this.mPQ;
  }
  
  public com.tencent.mm.plugin.fts.a.i getFTSIndexStorage(int paramInt)
  {
    AppMethodBeat.i(136625);
    com.tencent.mm.plugin.fts.a.i locali = (com.tencent.mm.plugin.fts.a.i)this.mQf.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(136625);
    return locali;
  }
  
  public j getFTSMainDB()
  {
    AppMethodBeat.i(136626);
    if (this.mQg == null) {
      this.mQg = new e();
    }
    e locale = this.mQg;
    AppMethodBeat.o(136626);
    return locale;
  }
  
  public m getFTSTaskDaemon()
  {
    AppMethodBeat.i(136605);
    initFTSTaskDaemon();
    f localf = this.mPP;
    AppMethodBeat.o(136605);
    return localf;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.b getItemClickHandler(int paramInt)
  {
    AppMethodBeat.i(136634);
    com.tencent.mm.plugin.fts.a.d.a.b localb = (com.tencent.mm.plugin.fts.a.d.a.b)this.mQj.get(paramInt);
    AppMethodBeat.o(136634);
    return localb;
  }
  
  public com.tencent.mm.plugin.fts.b.e getTopHitsLogic()
  {
    AppMethodBeat.i(136639);
    com.tencent.mm.plugin.fts.b.e locale = (com.tencent.mm.plugin.fts.b.e)this.mQk.get(1);
    AppMethodBeat.o(136639);
    return locale;
  }
  
  public void initFTSTaskDaemon()
  {
    AppMethodBeat.i(136604);
    f localf;
    if (this.mPP == null)
    {
      this.mPP = new f();
      localf = this.mPP;
      if ((localf.mPG == null) || (!localf.mPG.isAlive())) {
        break label98;
      }
      ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", new Throwable(), "Duplicated daemon initialization detected, working queue maybe dirty!", new Object[0]);
    }
    for (;;)
    {
      localf = this.mPP;
      Runnable localRunnable = this.mPW;
      if (localf.mPG != null) {
        localf.mPG.mPM = localRunnable;
      }
      AppMethodBeat.o(136604);
      return;
      label98:
      localf.mPG = new f.a(localf);
      ab.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon initialized, waiting for starting.");
    }
  }
  
  public boolean isCharging()
  {
    return this.mPT;
  }
  
  public boolean isFTSContextReady()
  {
    AppMethodBeat.i(136637);
    boolean bool = getFTSTaskDaemon().isStart();
    AppMethodBeat.o(136637);
    return bool;
  }
  
  public boolean isFTSIndexReady()
  {
    return this.mPV;
  }
  
  public boolean isInBackground()
  {
    return this.mPU;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(136601);
    paramc = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fts.a.c.mQV);
    if (!paramc.exists()) {
      paramc.mkdirs();
    }
    if (this.mPP != null) {
      this.mPP.quit();
    }
    initFTSTaskDaemon();
    paramc = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    paramc = ah.getContext().registerReceiver(null, paramc);
    boolean bool;
    if (paramc != null)
    {
      int i = paramc.getIntExtra("status", -1);
      if ((i == 2) || (i == 5)) {
        bool = true;
      }
    }
    for (this.mPT = bool;; this.mPT = false)
    {
      paramc = new IntentFilter();
      paramc.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      paramc.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ah.getContext().registerReceiver(this.mQe, paramc);
      com.tencent.mm.kernel.g.RN().a(this.mPZ);
      this.mQb.alive();
      this.mQd.alive();
      this.mQa.alive();
      this.mQl.alive();
      com.tencent.mm.kernel.g.Rc().a(138, this.mQc);
      this.mPP.a(-131072, new PluginFTS.b(this));
      this.mPP.a(-131071, new PluginFTS.a(this, (byte)0));
      this.mQi = new c();
      addCheckLanguageTask();
      AppMethodBeat.o(136601);
      return;
      bool = false;
      break;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(136602);
    destroyNativeLogic();
    destroyNativeUILogic();
    destroyItemClickHandler();
    destroyStorage();
    if (this.mPP != null)
    {
      this.mPP.quit();
      this.mPP = null;
    }
    if (this.mPQ != null)
    {
      this.mPQ.close();
      this.mPQ = null;
    }
    if (this.mQi != null)
    {
      this.mQi.bBN();
      this.mQi = null;
    }
    try
    {
      ah.getContext().unregisterReceiver(this.mQe);
      label91:
      this.mQb.dead();
      this.mQa.dead();
      this.mQl.dead();
      this.mQd.dead();
      com.tencent.mm.kernel.g.Rc().b(138, this.mQc);
      com.tencent.mm.kernel.g.RN().b(this.mPZ);
      this.mPR = false;
      this.mPS = false;
      AppMethodBeat.o(136602);
      return;
    }
    catch (Exception localException)
    {
      break label91;
    }
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(136606);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class));
    AppMethodBeat.o(136606);
  }
  
  public void registerFTSUILogic(com.tencent.mm.plugin.fts.a.d.d paramd)
  {
    AppMethodBeat.i(136628);
    try
    {
      this.mQh.put(paramd.getType(), paramd);
      AppMethodBeat.o(136628);
      return;
    }
    catch (Exception paramd)
    {
      AppMethodBeat.o(136628);
    }
  }
  
  public void registerIndexStorage(com.tencent.mm.plugin.fts.a.i parami)
  {
    AppMethodBeat.i(136623);
    this.mQf.put(Integer.valueOf(parami.getType()), parami);
    AppMethodBeat.o(136623);
  }
  
  public void registerItemClickHandler(int paramInt, com.tencent.mm.plugin.fts.a.d.a.b paramb)
  {
    AppMethodBeat.i(136632);
    this.mQj.put(paramInt, paramb);
    AppMethodBeat.o(136632);
  }
  
  public void registerNativeLogic(int paramInt, k paramk)
  {
    AppMethodBeat.i(136635);
    this.mQk.put(paramInt, paramk);
    AppMethodBeat.o(136635);
  }
  
  public com.tencent.mm.plugin.fts.a.a.a search(int paramInt, com.tencent.mm.plugin.fts.a.a.i parami)
  {
    AppMethodBeat.i(136617);
    if (!isFTSContextReady())
    {
      parami = new b(-2, parami);
      com.tencent.mm.sdk.g.d.post(parami, "FTSExceptionHandler");
      AppMethodBeat.o(136617);
      return parami;
    }
    if (!isFTSIndexReady())
    {
      parami = new b(-4, parami);
      com.tencent.mm.sdk.g.d.post(parami, "FTSExceptionHandler");
      AppMethodBeat.o(136617);
      return parami;
    }
    if (this.mQk.indexOfKey(paramInt) >= 0)
    {
      k localk = (k)this.mQk.get(paramInt);
      if (localk.isCreated())
      {
        parami = localk.a(parami);
        AppMethodBeat.o(136617);
        return parami;
      }
      parami = new b(-2, parami);
      com.tencent.mm.sdk.g.d.post(parami, "FTSExceptionHandler");
      AppMethodBeat.o(136617);
      return parami;
    }
    ab.e("MicroMsg.FTS.PluginFTS", "Not Found Search Logic, LogicArraySize=%d", new Object[] { Integer.valueOf(this.mQk.size()) });
    parami = new b(-2, parami);
    com.tencent.mm.sdk.g.d.post(parami, "FTSExceptionHandler");
    AppMethodBeat.o(136617);
    return parami;
  }
  
  public void setFTSImageLoader(com.tencent.mm.plugin.fts.a.d.c paramc)
  {
    this.mQi = paramc;
  }
  
  public void setFTSIndexReady(boolean paramBoolean)
  {
    AppMethodBeat.i(136638);
    ab.i("MicroMsg.FTS.PluginFTS", "setFTSIndexReady %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mPV = paramBoolean;
    AppMethodBeat.o(136638);
  }
  
  public int stringCompareUtfBinary(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136627);
    int i = FTSJNIUtils.stringCompareUtfBinary(paramString1, paramString2);
    AppMethodBeat.o(136627);
    return i;
  }
  
  public void unregisterFTSUILogic(int paramInt)
  {
    AppMethodBeat.i(136629);
    try
    {
      this.mQh.remove(paramInt);
      AppMethodBeat.o(136629);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(136629);
    }
  }
  
  public void unregisterIndexStorage(int paramInt)
  {
    AppMethodBeat.i(136624);
    com.tencent.mm.plugin.fts.a.i locali;
    if (this.mQf.containsKey(Integer.valueOf(paramInt))) {
      locali = (com.tencent.mm.plugin.fts.a.i)this.mQf.get(Integer.valueOf(paramInt));
    }
    try
    {
      locali.destroy();
      this.mQf.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(136624);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.FTS.PluginFTS", "Destroy Index Storage name=%s \nexception=%s", new Object[] { locali.getName(), bo.l(localException) });
      }
    }
  }
  
  public void unregisterItemClickHandler(int paramInt)
  {
    AppMethodBeat.i(136633);
    this.mQj.remove(paramInt);
    AppMethodBeat.o(136633);
  }
  
  public void unregisterNativeLogic(int paramInt)
  {
    AppMethodBeat.i(136636);
    k localk;
    if (this.mQk.indexOfKey(paramInt) >= 0) {
      localk = (k)this.mQk.get(paramInt);
    }
    try
    {
      localk.destroy();
      this.mQk.remove(paramInt);
      AppMethodBeat.o(136636);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.FTS.PluginFTS", "Destroy Native Logic name=%s \nexception=%s", new Object[] { localk.getName(), bo.l(localException) });
      }
    }
  }
  
  public void updateTopHitsRank(String paramString, l paraml, int paramInt)
  {
    AppMethodBeat.i(136619);
    if ((isFTSContextReady()) && (this.mQk.indexOfKey(1) >= 0)) {
      ((k)this.mQk.get(1)).a(paramString, paraml, paramInt, com.tencent.mm.plugin.fts.a.d.bBU());
    }
    AppMethodBeat.o(136619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS
 * JD-Core Version:    0.7.0.1
 */