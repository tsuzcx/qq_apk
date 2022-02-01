package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.q.a;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "Lcom/tencent/mm/sdk/storage/IStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "mCalculatingDiff", "Ljava/util/concurrent/atomic/AtomicBoolean;", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "serial", "Lcom/tencent/threadpool/serial/Serial;", "serialTag", "", "addCollection", "", "username", "versionType", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "name", "event", "eventId", "obj", "", "getCount", "getCountLimit", "isCollection", "", "lock", "lockCount", "onRegister", "onUnregister", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "removeLoadedListener", "reorder", "reorderList", "reason", "reorderWithCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "restoreNotfityMsgRefuseStatus", "info", "unlock", "Companion", "ReorderCallback", "plugin-appbrand-integration_release"})
public final class f
  implements b, ag, IStorage
{
  public static final f.a nOA;
  private static f nOz;
  private final AtomicBoolean nOy;
  
  static
  {
    AppMethodBeat.i(50264);
    nOA = new f.a((byte)0);
    AppMethodBeat.o(50264);
  }
  
  public f()
  {
    AppMethodBeat.i(50263);
    this.nOy = new AtomicBoolean(false);
    AppMethodBeat.o(50263);
  }
  
  public static void e(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(273333);
    p.k(paramLocalUsageInfo, "info");
    String str = com.tencent.mm.plugin.appbrand.app.m.QG().L(q.a.aeV(paramLocalUsageInfo.appId), "true");
    if (str == null) {
      p.iCn();
    }
    if (!Boolean.parseBoolean(str)) {
      com.tencent.mm.plugin.appbrand.app.m.QG().ho(q.a.aeV(paramLocalUsageInfo.appId));
    }
    AppMethodBeat.o(273333);
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt, ag.a parama)
  {
    AppMethodBeat.i(50256);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(50256);
      return null;
    }
    u localu = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localu != null) {}
    for (parama = localu.b(paramInt, parama);; parama = null)
    {
      parama = (List)parama;
      AppMethodBeat.o(50256);
      return parama;
    }
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt1, ag.a parama, int paramInt2)
  {
    AppMethodBeat.i(50257);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(50257);
      return null;
    }
    u localu = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localu != null) {}
    for (parama = localu.b(paramInt1, parama, paramInt2);; parama = null)
    {
      parama = (List)parama;
      AppMethodBeat.o(50257);
      return parama;
    }
  }
  
  public final boolean a(final List<? extends LocalUsageInfo> paramList, final b paramb)
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
      this.nOy.set(true);
      paramList = (Runnable)new e(this, paramList, paramb);
      if (!MMHandlerThread.isMainThread()) {
        break label71;
      }
      com.tencent.mm.plugin.appbrand.ac.m.clV().postToWorker(paramList);
    }
    for (;;)
    {
      AppMethodBeat.o(50253);
      return true;
      AppMethodBeat.o(50253);
      return false;
      label71:
      paramList.run();
    }
  }
  
  public final void aIF()
  {
    nOz = (f)this;
  }
  
  public final void aIG()
  {
    nOz = null;
  }
  
  public final void add(a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(273338);
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {
      ((u)localObject).add(parama, paramIOnStorageChange);
    }
    localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (localObject != null)
    {
      ((z)localObject).add(parama, paramIOnStorageChange);
      AppMethodBeat.o(273338);
      return;
    }
    AppMethodBeat.o(273338);
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
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {
      ((u)localObject).add(paramIOnStorageChange, paramLooper);
    }
    localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (localObject != null)
    {
      ((z)localObject).add(paramIOnStorageChange, paramLooper);
      AppMethodBeat.o(50261);
      return;
    }
    AppMethodBeat.o(50261);
  }
  
  public final void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(273339);
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {
      ((u)localObject).add(paramString, paramIOnStorageChange);
    }
    localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (localObject != null)
    {
      ((z)localObject).add(paramString, paramIOnStorageChange);
      AppMethodBeat.o(273339);
      return;
    }
    AppMethodBeat.o(273339);
  }
  
  public final void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(273345);
    u localu = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localu != null)
    {
      localu.addLoadedListener(paramIOnStorageLoaded);
      AppMethodBeat.o(273345);
      return;
    }
    AppMethodBeat.o(273345);
  }
  
  public final boolean bA(String paramString, int paramInt)
  {
    AppMethodBeat.i(50252);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50252);
      return false;
    }
    localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (paramString == null) {
      p.iCn();
    }
    boolean bool = ((u)localObject).bE(paramString, paramInt);
    AppMethodBeat.o(50252);
    return bool;
  }
  
  public final int bIW()
  {
    AppMethodBeat.i(50259);
    int i = v.bJC();
    AppMethodBeat.o(50259);
    return i;
  }
  
  public final boolean by(String paramString, int paramInt)
  {
    AppMethodBeat.i(50250);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50250);
      return false;
    }
    localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (paramString == null) {
      p.iCn();
    }
    boolean bool = ((u)localObject).bC(paramString, paramInt);
    AppMethodBeat.o(50250);
    return bool;
  }
  
  public final int bz(String paramString, int paramInt)
  {
    AppMethodBeat.i(50251);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50251);
      return -1;
    }
    localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (paramString == null) {
      p.iCn();
    }
    paramInt = ((u)localObject).bD(paramString, paramInt);
    AppMethodBeat.o(50251);
    return paramInt;
  }
  
  public final void doNotify()
  {
    AppMethodBeat.i(273347);
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {
      ((u)localObject).doNotify();
    }
    localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (localObject != null)
    {
      ((z)localObject).doNotify();
      AppMethodBeat.o(273347);
      return;
    }
    AppMethodBeat.o(273347);
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(273348);
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {
      ((u)localObject).doNotify(paramString);
    }
    localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (localObject != null)
    {
      ((z)localObject).doNotify(paramString);
      AppMethodBeat.o(273348);
      return;
    }
    AppMethodBeat.o(273348);
  }
  
  public final void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(273349);
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {
      ((u)localObject).doNotify(paramString, paramInt, paramObject);
    }
    localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (localObject != null)
    {
      ((z)localObject).doNotify(paramString, paramInt, paramObject);
      AppMethodBeat.o(273349);
      return;
    }
    AppMethodBeat.o(273349);
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(50255);
    Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "reorder reason = ".concat(String.valueOf(paramInt)));
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
  
  public final int getCount()
  {
    AppMethodBeat.i(50258);
    u localu = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localu != null)
    {
      int i = localu.bJz();
      AppMethodBeat.o(50258);
      return i;
    }
    AppMethodBeat.o(50258);
    return 0;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(273340);
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {
      ((u)localObject).lock();
    }
    localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (localObject != null)
    {
      ((z)localObject).lock();
      AppMethodBeat.o(273340);
      return;
    }
    AppMethodBeat.o(273340);
  }
  
  public final int lockCount()
  {
    int j = 0;
    AppMethodBeat.i(273343);
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {}
    for (int i = ((u)localObject).lockCount();; i = 0)
    {
      localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
      if (localObject != null) {
        j = ((z)localObject).lockCount();
      }
      AppMethodBeat.o(273343);
      return i + j;
    }
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(50262);
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {
      ((u)localObject).remove(paramIOnStorageChange);
    }
    localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (localObject != null)
    {
      ((z)localObject).remove(paramIOnStorageChange);
      AppMethodBeat.o(50262);
      return;
    }
    AppMethodBeat.o(50262);
  }
  
  public final void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    AppMethodBeat.i(273346);
    u localu = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localu != null)
    {
      localu.removeLoadedListener(paramIOnStorageLoaded);
      AppMethodBeat.o(273346);
      return;
    }
    AppMethodBeat.o(273346);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(273344);
    Object localObject = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
    if (localObject != null) {
      ((u)localObject).unlock();
    }
    localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (localObject != null)
    {
      ((z)localObject).unlock();
      AppMethodBeat.o(273344);
      return;
    }
    AppMethodBeat.o(273344);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "()V", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"})
  public static class b
    implements c.b
  {
    public void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50243);
      p.k(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50243);
    }
    
    public void bIY() {}
    
    public final void c(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50244);
      p.k(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50244);
    }
    
    public void d(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50245);
      p.k(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50245);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"})
  public static final class c
    extends f.b
  {
    public final void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(278773);
      p.k(paramLocalUsageInfo, "info");
      super.b(paramLocalUsageInfo);
      f.e(paramLocalUsageInfo);
      AppMethodBeat.o(278773);
    }
    
    public final void bIY()
    {
      AppMethodBeat.i(50246);
      ((c)com.tencent.mm.kernel.h.ae(c.class)).a(aa.b.nPY);
      AppMethodBeat.o(50246);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$2", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"})
  public static final class d
    extends f.b
  {
    public final void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(275518);
      p.k(paramLocalUsageInfo, "info");
      super.b(paramLocalUsageInfo);
      f.e(paramLocalUsageInfo);
      AppMethodBeat.o(275518);
    }
    
    public final void bIY()
    {
      AppMethodBeat.i(50247);
      ((c)com.tencent.mm.kernel.h.ae(c.class)).a(aa.b.nPX);
      AppMethodBeat.o(50247);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(f paramf, List paramList, f.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(50248);
      Object localObject2 = f.a(this.nOB);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (List)kotlin.a.v.aaAd;
      }
      localObject2 = new StringBuilder("[collection] reorderWithCallback, before calculateDiff oldList.size=").append(((List)localObject1).size()).append(" reorderList.size= ");
      Object localObject3 = paramList;
      if (localObject3 == null) {
        p.iCn();
      }
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", ((List)localObject3).size() + ' ');
      localObject2 = androidx.recyclerview.widget.h.a((h.a)new ac((List)localObject1, paramList), true);
      localObject3 = new StringBuilder("[collection] reorderWithCallback, after calculateDiff oldList.size=").append(((List)localObject1).size()).append(" reorderList.size= ");
      List localList = paramList;
      if (localList == null) {
        p.iCn();
      }
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", localList.size() + ' ');
      localObject3 = (c)com.tencent.mm.kernel.h.ae(c.class);
      p.j(localObject2, "diff");
      localObject1 = j.p((Iterable)localObject1);
      localList = paramList;
      if (localList == null) {
        p.iCn();
      }
      boolean bool = ((c)localObject3).a((h.b)localObject2, (List)localObject1, j.p((Iterable)localList), (c.b)paramb);
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, changed = ".concat(String.valueOf(bool)));
      if (bool) {
        ((u)com.tencent.mm.plugin.appbrand.app.m.W(u.class)).a(LocalUsageInfo.class, paramList, null);
      }
      f.b(this.nOB).set(false);
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, before run callback");
      localObject1 = paramb;
      if (localObject1 != null)
      {
        ((f.b)localObject1).bIY();
        AppMethodBeat.o(50248);
        return;
      }
      AppMethodBeat.o(50248);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.f
 * JD-Core Version:    0.7.0.1
 */