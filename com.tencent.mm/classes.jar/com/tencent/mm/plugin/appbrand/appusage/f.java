package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.q.a;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "mCalculatingDiff", "Ljava/util/concurrent/atomic/AtomicBoolean;", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "onRegister", "onUnregister", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "reorder", "reorderList", "reason", "reorderWithCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "restoreNotfityMsgRefuseStatus", "info", "Companion", "ReorderCallback", "plugin-appbrand-integration_release"})
public final class f
  extends MStorage
  implements b, ag
{
  private static f kUm;
  public static final a kUn;
  private final AtomicBoolean kUl;
  
  static
  {
    AppMethodBeat.i(50264);
    kUn = new a((byte)0);
    AppMethodBeat.o(50264);
  }
  
  public f()
  {
    AppMethodBeat.i(50263);
    this.kUl = new AtomicBoolean(false);
    AppMethodBeat.o(50263);
  }
  
  public static void e(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(228126);
    kotlin.g.b.p.h(paramLocalUsageInfo, "info");
    String str = n.NL().get(q.a.Xj(paramLocalUsageInfo.appId), "true");
    if (str == null) {
      kotlin.g.b.p.hyc();
    }
    if (!Boolean.parseBoolean(str)) {
      n.NL().gC(q.a.Xj(paramLocalUsageInfo.appId));
    }
    AppMethodBeat.o(228126);
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt, ag.a parama)
  {
    AppMethodBeat.i(50256);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(50256);
      return null;
    }
    parama = (List)((u)n.W(u.class)).b(paramInt, parama);
    AppMethodBeat.o(50256);
    return parama;
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt1, ag.a parama, int paramInt2)
  {
    AppMethodBeat.i(50257);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(50257);
      return null;
    }
    parama = (List)((u)n.W(u.class)).b(paramInt1, parama, paramInt2);
    AppMethodBeat.o(50257);
    return parama;
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
      this.kUl.set(true);
      paramList = (Runnable)new e(this, paramList, paramb);
      if (!MMHandlerThread.isMainThread()) {
        break label71;
      }
      m.bZn().postToWorker(paramList);
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
  
  public final void aBc()
  {
    kUm = (f)this;
  }
  
  public final void aBd()
  {
    kUm = null;
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
    ((u)n.W(u.class)).add(paramIOnStorageChange, paramLooper);
    n.buC().add(paramIOnStorageChange, paramLooper);
    AppMethodBeat.o(50261);
  }
  
  public final boolean bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(50250);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50250);
      return false;
    }
    localObject = (u)n.W(u.class);
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    boolean bool = ((u)localObject).bj(paramString, paramInt);
    AppMethodBeat.o(50250);
    return bool;
  }
  
  public final int bg(String paramString, int paramInt)
  {
    AppMethodBeat.i(50251);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50251);
      return -1;
    }
    localObject = (u)n.W(u.class);
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    paramInt = ((u)localObject).bk(paramString, paramInt);
    AppMethodBeat.o(50251);
    return paramInt;
  }
  
  public final boolean bh(String paramString, int paramInt)
  {
    AppMethodBeat.i(50252);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50252);
      return false;
    }
    localObject = (u)n.W(u.class);
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    boolean bool = ((u)localObject).bl(paramString, paramInt);
    AppMethodBeat.o(50252);
    return bool;
  }
  
  public final void bxG()
  {
    AppMethodBeat.i(50249);
    if (this.kUl.get())
    {
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, skip fetch when calculating diff");
      AppMethodBeat.o(50249);
      return;
    }
    Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, fetch");
    j.bxQ().a(Util.nowMilliSecond(), true, null, 6, 0);
    h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPD, com.tencent.mm.plugin.appbrand.service.z.nMB);
    h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPE, com.tencent.mm.plugin.appbrand.service.z.nMB);
    AppMethodBeat.o(50249);
  }
  
  public final int bxH()
  {
    AppMethodBeat.i(50259);
    int i = v.byo();
    AppMethodBeat.o(50259);
    return i;
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
    Object localObject = n.W(u.class);
    kotlin.g.b.p.g(localObject, "SubCoreAppBrand.getStora…arAppStorage::class.java)");
    int i = ((u)localObject).byk();
    AppMethodBeat.o(50258);
    return i;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(50262);
    ((u)n.W(u.class)).remove(paramIOnStorageChange);
    n.buC().remove(paramIOnStorageChange);
    AppMethodBeat.o(50262);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$Companion;", "", "()V", "STORAGE", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "getSTORAGE", "()Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "setSTORAGE", "(Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;)V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "()V", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"})
  public static class b
    implements c.b
  {
    public void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50243);
      kotlin.g.b.p.h(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50243);
    }
    
    public void bxJ() {}
    
    public final void c(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50244);
      kotlin.g.b.p.h(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50244);
    }
    
    public void d(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50245);
      kotlin.g.b.p.h(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50245);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"})
  public static final class c
    extends f.b
  {
    public final void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(228124);
      kotlin.g.b.p.h(paramLocalUsageInfo, "info");
      super.b(paramLocalUsageInfo);
      f.e(paramLocalUsageInfo);
      AppMethodBeat.o(228124);
    }
    
    public final void bxJ()
    {
      AppMethodBeat.i(50246);
      ((c)com.tencent.mm.kernel.g.af(c.class)).a(aa.b.kVL);
      AppMethodBeat.o(50246);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$2", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"})
  public static final class d
    extends f.b
  {
    public final void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(228125);
      kotlin.g.b.p.h(paramLocalUsageInfo, "info");
      super.b(paramLocalUsageInfo);
      f.e(paramLocalUsageInfo);
      AppMethodBeat.o(228125);
    }
    
    public final void bxJ()
    {
      AppMethodBeat.i(50247);
      ((c)com.tencent.mm.kernel.g.af(c.class)).a(aa.b.kVK);
      AppMethodBeat.o(50247);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(f paramf, List paramList, f.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(50248);
      Object localObject2 = f.a(this.kUo);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (List)kotlin.a.v.SXr;
      }
      localObject2 = new StringBuilder("[collection] reorderWithCallback, before calculateDiff oldList.size=").append(((List)localObject1).size()).append(" reorderList.size= ");
      Object localObject3 = paramList;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", ((List)localObject3).size() + ' ');
      localObject2 = android.support.v7.h.c.a((c.a)new ac((List)localObject1, paramList), true);
      localObject3 = new StringBuilder("[collection] reorderWithCallback, after calculateDiff oldList.size=").append(((List)localObject1).size()).append(" reorderList.size= ");
      List localList = paramList;
      if (localList == null) {
        kotlin.g.b.p.hyc();
      }
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", localList.size() + ' ');
      localObject3 = (c)com.tencent.mm.kernel.g.af(c.class);
      kotlin.g.b.p.g(localObject2, "diff");
      localObject1 = kotlin.a.j.p((Iterable)localObject1);
      localList = paramList;
      if (localList == null) {
        kotlin.g.b.p.hyc();
      }
      boolean bool = ((c)localObject3).a((android.support.v7.h.c.b)localObject2, (List)localObject1, kotlin.a.j.p((Iterable)localList), (c.b)paramb);
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, changed = ".concat(String.valueOf(bool)));
      if (bool) {
        ((u)n.W(u.class)).a(LocalUsageInfo.class, paramList, null);
      }
      f.b(this.kUo).set(false);
      Log.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, before run callback");
      localObject1 = paramb;
      if (localObject1 != null)
      {
        ((f.b)localObject1).bxJ();
        AppMethodBeat.o(50248);
        return;
      }
      AppMethodBeat.o(50248);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.f
 * JD-Core Version:    0.7.0.1
 */