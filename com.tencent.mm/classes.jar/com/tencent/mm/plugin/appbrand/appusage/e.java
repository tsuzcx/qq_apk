package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.s.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import com.tencent.threadpool.j.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "Lcom/tencent/mm/sdk/storage/IStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "mCalculatingDiff", "Ljava/util/concurrent/atomic/AtomicBoolean;", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "serial", "Lcom/tencent/threadpool/serial/Serial;", "serialTag", "", "addCollection", "", "username", "versionType", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "name", "event", "eventId", "obj", "", "getCount", "getCountLimit", "isCollection", "", "isCollectionForAppId", "appId", "localusageListInfo", "localList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "lock", "lockCount", "onRegister", "onUnregister", "query", "", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "remove", "removeCollection", "removeLoadedListener", "reorder", "reorderList", "reason", "reorderWithCallback", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "restoreNotfityMsgRefuseStatus", "info", "unlock", "Companion", "ReorderCallback", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements b, af, IStorage
{
  public static final e.a qOs;
  private static e qOu;
  private final AtomicBoolean qOt;
  
  static
  {
    AppMethodBeat.i(50264);
    qOs = new e.a((byte)0);
    AppMethodBeat.o(50264);
  }
  
  public e()
  {
    AppMethodBeat.i(50263);
    this.qOt = new AtomicBoolean(false);
    AppMethodBeat.o(50263);
  }
  
  private static final void a(e parame, List paramList, b paramb)
  {
    AppMethodBeat.i(319341);
    s.u(parame, "this$0");
    Object localObject2 = parame.a(2147483647, af.a.qPX);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)kotlin.a.ab.aivy;
    }
    localObject2 = new StringBuilder("[collection] reorderWithCallback, before calculateDiff oldList.size=").append(((List)localObject1).size()).append(" reorderList.size= ");
    s.checkNotNull(paramList);
    Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", paramList.size() + ' ');
    Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "jacob beforeDiff " + cS((List)localObject1) + " new  list " + cS(paramList));
    if (((List)localObject1).size() == paramList.size())
    {
      localObject2 = g.a((g.a)new ab((List)localObject1, paramList), true);
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, after calculateDiff oldList.size=" + ((List)localObject1).size() + " reorderList.size= " + paramList.size() + ' ');
      c localc = (c)h.ax(c.class);
      s.s(localObject2, "diff");
      boolean bool = localc.a((g.b)localObject2, p.p((Iterable)localObject1), p.p((Iterable)paramList), (c.b)paramb);
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", s.X("[collection] reorderWithCallback, changed = ", Boolean.valueOf(bool)));
      if (bool) {
        ((t)n.ag(t.class)).a(LocalUsageInfo.class, paramList, null);
      }
      parame.qOt.set(false);
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, before run callback");
      if (paramb != null) {
        paramb.ciC();
      }
    }
    AppMethodBeat.o(319341);
  }
  
  private static String cS(List<? extends LocalUsageInfo> paramList)
  {
    AppMethodBeat.i(319338);
    s.u(paramList, "localList");
    if (!BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(319338);
      return "";
    }
    Iterator localIterator = paramList.iterator();
    paramList = "";
    if (localIterator.hasNext())
    {
      Object localObject = (LocalUsageInfo)localIterator.next();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((LocalUsageInfo)localObject).nickname)
      {
        paramList = s.X(paramList, localObject);
        break;
      }
    }
    AppMethodBeat.o(319338);
    return paramList;
  }
  
  public static void e(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(319339);
    s.u(paramLocalUsageInfo, "info");
    String str = n.aqS().O(s.a.Xx(paramLocalUsageInfo.appId), "true");
    s.checkNotNull(str);
    if (!Boolean.parseBoolean(str)) {
      n.aqS().iP(s.a.Xx(paramLocalUsageInfo.appId));
    }
    AppMethodBeat.o(319339);
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt, af.a parama)
  {
    AppMethodBeat.i(50256);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(50256);
      return null;
    }
    t localt = (t)n.ag(t.class);
    if (localt == null) {}
    for (parama = null;; parama = localt.b(paramInt, parama))
    {
      parama = (List)parama;
      AppMethodBeat.o(50256);
      return parama;
    }
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt1, af.a parama, int paramInt2)
  {
    AppMethodBeat.i(50257);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(50257);
      return null;
    }
    t localt = (t)n.ag(t.class);
    if (localt == null) {}
    for (parama = null;; parama = localt.b(paramInt1, parama, paramInt2))
    {
      parama = (List)parama;
      AppMethodBeat.o(50257);
      return parama;
    }
  }
  
  public final boolean a(List<? extends LocalUsageInfo> paramList, b paramb)
  {
    AppMethodBeat.i(50253);
    if (paramList == null)
    {
      if (WeChatEnvironment.hasDebugger()) {
        Assert.assertTrue("reorderList is NULL", false);
      }
    }
    else
    {
      this.qOt.set(true);
      paramList = new e..ExternalSyntheticLambda0(this, paramList, paramb);
      if (!MMHandlerThread.isMainThread()) {
        break label72;
      }
      o.cNm().postToWorker(paramList);
    }
    for (;;)
    {
      AppMethodBeat.o(50253);
      return true;
      AppMethodBeat.o(50253);
      return false;
      label72:
      paramList.run();
    }
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(50260);
    add(paramIOnStorageChange, Looper.getMainLooper());
    AppMethodBeat.o(50260);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    AppMethodBeat.i(50261);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).add(paramIOnStorageChange, paramLooper);
    }
    localObject = n.cfc();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.config.af)localObject).add(paramIOnStorageChange, paramLooper);
    }
    AppMethodBeat.o(50261);
  }
  
  public final void add(a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(319368);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).add(parama, paramIOnStorageChange);
    }
    localObject = n.cfc();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.config.af)localObject).add(parama, paramIOnStorageChange);
    }
    AppMethodBeat.o(319368);
  }
  
  public final void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(319370);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).add(paramString, paramIOnStorageChange);
    }
    localObject = n.cfc();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.config.af)localObject).add(paramString, paramIOnStorageChange);
    }
    AppMethodBeat.o(319370);
  }
  
  public final void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(319384);
    t localt = (t)n.ag(t.class);
    if (localt != null) {
      localt.addLoadedListener(paramIOnStorageLoaded);
    }
    AppMethodBeat.o(319384);
  }
  
  public final boolean bP(String paramString, int paramInt)
  {
    AppMethodBeat.i(50250);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50250);
      return false;
    }
    localObject = (t)n.ag(t.class);
    s.checkNotNull(paramString);
    boolean bool = ((t)localObject).bU(paramString, paramInt);
    AppMethodBeat.o(50250);
    return bool;
  }
  
  public final boolean bQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(319350);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(319350);
      return false;
    }
    boolean bool = bP(ad.XL(paramString), paramInt);
    AppMethodBeat.o(319350);
    return bool;
  }
  
  public final int bR(String paramString, int paramInt)
  {
    AppMethodBeat.i(50251);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50251);
      return -1;
    }
    localObject = (t)n.ag(t.class);
    s.checkNotNull(paramString);
    paramInt = ((t)localObject).bW(paramString, paramInt);
    AppMethodBeat.o(50251);
    return paramInt;
  }
  
  public final boolean bS(String paramString, int paramInt)
  {
    AppMethodBeat.i(50252);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50252);
      return false;
    }
    localObject = (t)n.ag(t.class);
    s.checkNotNull(paramString);
    boolean bool = ((t)localObject).o(paramString, paramInt, true);
    AppMethodBeat.o(50252);
    return bool;
  }
  
  public final void bbB()
  {
    qOu = this;
  }
  
  public final void bbC()
  {
    qOu = null;
  }
  
  public final int ciA()
  {
    AppMethodBeat.i(50259);
    int i = u.cjh();
    AppMethodBeat.o(50259);
    return i;
  }
  
  public final void doNotify()
  {
    AppMethodBeat.i(319388);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).doNotify();
    }
    localObject = n.cfc();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.config.af)localObject).doNotify();
    }
    AppMethodBeat.o(319388);
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(319389);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).doNotify(paramString);
    }
    localObject = n.cfc();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.config.af)localObject).doNotify(paramString);
    }
    AppMethodBeat.o(319389);
  }
  
  public final void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(319393);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).doNotify(paramString, paramInt, paramObject);
    }
    localObject = n.cfc();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.config.af)localObject).doNotify(paramString, paramInt, paramObject);
    }
    AppMethodBeat.o(319393);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(50258);
    t localt = (t)n.ag(t.class);
    if (localt == null)
    {
      AppMethodBeat.o(50258);
      return 0;
    }
    int i = localt.cjd();
    AppMethodBeat.o(50258);
    return i;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(319374);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).lock();
    }
    localObject = n.cfc();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.config.af)localObject).lock();
    }
    AppMethodBeat.o(319374);
  }
  
  public final int lockCount()
  {
    int j = 0;
    AppMethodBeat.i(319377);
    Object localObject = (t)n.ag(t.class);
    int i;
    if (localObject == null)
    {
      i = 0;
      localObject = n.cfc();
      if (localObject != null) {
        break label49;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(319377);
      return i + j;
      i = ((t)localObject).lockCount();
      break;
      label49:
      j = ((com.tencent.mm.plugin.appbrand.config.af)localObject).lockCount();
    }
  }
  
  public final boolean p(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(50255);
    Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", s.X("reorder reason = ", Integer.valueOf(paramInt)));
    b localb;
    switch (paramInt)
    {
    default: 
      localb = null;
    }
    for (;;)
    {
      boolean bool = a(paramList, localb);
      AppMethodBeat.o(50255);
      return bool;
      localb = (b)new c(this);
      continue;
      localb = (b)new d(this);
    }
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(50262);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).remove(paramIOnStorageChange);
    }
    localObject = n.cfc();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.config.af)localObject).remove(paramIOnStorageChange);
    }
    AppMethodBeat.o(50262);
  }
  
  public final void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(319386);
    t localt = (t)n.ag(t.class);
    if (localt != null) {
      localt.removeLoadedListener(paramIOnStorageLoaded);
    }
    AppMethodBeat.o(319386);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(319382);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).unlock();
    }
    localObject = n.cfc();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.config.af)localObject).unlock();
    }
    AppMethodBeat.o(319382);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "()V", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class b
    implements c.b
  {
    public void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50243);
      s.u(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50243);
    }
    
    public final void c(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50244);
      s.u(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50244);
    }
    
    public void ciC() {}
    
    public void d(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50245);
      s.u(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50245);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends e.b
  {
    c(e parame) {}
    
    public final void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(319333);
      s.u(paramLocalUsageInfo, "info");
      super.b(paramLocalUsageInfo);
      e.e(paramLocalUsageInfo);
      AppMethodBeat.o(319333);
    }
    
    public final void ciC()
    {
      AppMethodBeat.i(50246);
      ((c)h.ax(c.class)).a(z.b.qPQ);
      AppMethodBeat.o(50246);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$2", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends e.b
  {
    d(e parame) {}
    
    public final void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(319330);
      s.u(paramLocalUsageInfo, "info");
      super.b(paramLocalUsageInfo);
      e.e(paramLocalUsageInfo);
      AppMethodBeat.o(319330);
    }
    
    public final void ciC()
    {
      AppMethodBeat.i(50247);
      ((c)h.ax(c.class)).a(z.b.qPP);
      AppMethodBeat.o(50247);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.e
 * JD-Core Version:    0.7.0.1
 */