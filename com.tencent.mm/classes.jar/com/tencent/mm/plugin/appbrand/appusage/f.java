package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.config.p.a;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.preload.d.a;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "mCalculatingDiff", "Ljava/util/concurrent/atomic/AtomicBoolean;", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "onRegister", "onUnregister", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "refreshOnPullDownOpenAnimationEnd", "remove", "removeCollection", "reorder", "reorderList", "reason", "reorderWithCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "restoreNotfityMsgRefuseStatus", "info", "Companion", "ReorderCallback", "plugin-appbrand-integration_release"})
public final class f
  extends k
  implements b, ah
{
  private static f jOk;
  public static final a jOl;
  private final AtomicBoolean jOj;
  
  static
  {
    AppMethodBeat.i(50264);
    jOl = new a((byte)0);
    AppMethodBeat.o(50264);
  }
  
  public f()
  {
    AppMethodBeat.i(50263);
    this.jOj = new AtomicBoolean(false);
    AppMethodBeat.o(50263);
  }
  
  public static void e(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(188992);
    p.h(paramLocalUsageInfo, "info");
    String str = com.tencent.mm.plugin.appbrand.app.j.Ej().get(p.a.Ns(paramLocalUsageInfo.appId), "true");
    if (str == null) {
      p.gfZ();
    }
    if (!Boolean.parseBoolean(str)) {
      com.tencent.mm.plugin.appbrand.app.j.Ej().CA(p.a.Ns(paramLocalUsageInfo.appId));
    }
    AppMethodBeat.o(188992);
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt, ah.a parama)
  {
    AppMethodBeat.i(50256);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(50256);
      return null;
    }
    parama = (List)((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).b(paramInt, parama);
    AppMethodBeat.o(50256);
    return parama;
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt1, ah.a parama, int paramInt2)
  {
    AppMethodBeat.i(50257);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(50257);
      return null;
    }
    parama = (List)((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).b(paramInt1, parama, paramInt2);
    AppMethodBeat.o(50257);
    return parama;
  }
  
  public final boolean a(final List<? extends LocalUsageInfo> paramList, final b paramb)
  {
    AppMethodBeat.i(50253);
    if (paramList == null)
    {
      if (bu.flY()) {
        Assert.assertTrue("reorderList is NULL", false);
      }
    }
    else
    {
      this.jOj.set(true);
      paramList = (Runnable)new e(this, paramList, paramb);
      if (!aq.isMainThread()) {
        break label71;
      }
      m.bBp().postToWorker(paramList);
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
  
  public final boolean aX(String paramString, int paramInt)
  {
    AppMethodBeat.i(50250);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50250);
      return false;
    }
    localObject = (u)com.tencent.mm.plugin.appbrand.app.j.T(u.class);
    if (paramString == null) {
      p.gfZ();
    }
    boolean bool = ((u)localObject).bb(paramString, paramInt);
    AppMethodBeat.o(50250);
    return bool;
  }
  
  public final int aY(String paramString, int paramInt)
  {
    AppMethodBeat.i(50251);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50251);
      return -1;
    }
    localObject = (u)com.tencent.mm.plugin.appbrand.app.j.T(u.class);
    if (paramString == null) {
      p.gfZ();
    }
    paramInt = ((u)localObject).bc(paramString, paramInt);
    AppMethodBeat.o(50251);
    return paramInt;
  }
  
  public final boolean aZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(50252);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50252);
      return false;
    }
    localObject = (u)com.tencent.mm.plugin.appbrand.app.j.T(u.class);
    if (paramString == null) {
      p.gfZ();
    }
    boolean bool = ((u)localObject).bd(paramString, paramInt);
    AppMethodBeat.o(50252);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(50260);
    add(parama, Looper.getMainLooper());
    AppMethodBeat.o(50260);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(50261);
    ((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).add(parama, paramLooper);
    com.tencent.mm.plugin.appbrand.app.j.aYP().add(parama, paramLooper);
    AppMethodBeat.o(50261);
  }
  
  public final void akx()
  {
    jOk = (f)this;
  }
  
  public final void aky()
  {
    jOk = null;
  }
  
  public final void bbN()
  {
    AppMethodBeat.i(50249);
    if (this.jOj.get())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, skip fetch when calculating diff");
      AppMethodBeat.o(50249);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, fetch");
    j.bbX().a(bt.flT(), true, null, 6, 0);
    com.tencent.mm.plugin.appbrand.task.f.a(e.myg, d.a.mzc);
    com.tencent.mm.plugin.appbrand.task.f.a(e.myh, d.a.mzc);
    AppMethodBeat.o(50249);
  }
  
  public final int bbO()
  {
    AppMethodBeat.i(50259);
    int i = v.bcu();
    AppMethodBeat.o(50259);
    return i;
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(50255);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "reorder reason = ".concat(String.valueOf(paramInt)));
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
    Object localObject = com.tencent.mm.plugin.appbrand.app.j.T(u.class);
    p.g(localObject, "SubCoreAppBrand.getStora…arAppStorage::class.java)");
    int i = ((u)localObject).bcq();
    AppMethodBeat.o(50258);
    return i;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(50262);
    ((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).remove(parama);
    com.tencent.mm.plugin.appbrand.app.j.aYP().remove(parama);
    AppMethodBeat.o(50262);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$Companion;", "", "()V", "STORAGE", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "getSTORAGE", "()Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "setSTORAGE", "(Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;)V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "()V", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"})
  public static class b
    implements c.b
  {
    public void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50243);
      p.h(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50243);
    }
    
    public void bbQ() {}
    
    public final void c(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50244);
      p.h(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50244);
    }
    
    public void d(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(50245);
      p.h(paramLocalUsageInfo, "info");
      AppMethodBeat.o(50245);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"})
  public static final class c
    extends f.b
  {
    public final void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(188990);
      p.h(paramLocalUsageInfo, "info");
      super.b(paramLocalUsageInfo);
      f.e(paramLocalUsageInfo);
      AppMethodBeat.o(188990);
    }
    
    public final void bbQ()
    {
      AppMethodBeat.i(50246);
      ((c)g.ab(c.class)).a(ab.b.jPL);
      AppMethodBeat.o(50246);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$2", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onReorderEnd", "plugin-appbrand-integration_release"})
  public static final class d
    extends f.b
  {
    public final void b(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(188991);
      p.h(paramLocalUsageInfo, "info");
      super.b(paramLocalUsageInfo);
      f.e(paramLocalUsageInfo);
      AppMethodBeat.o(188991);
    }
    
    public final void bbQ()
    {
      AppMethodBeat.i(50247);
      ((c)g.ab(c.class)).a(ab.b.jPK);
      AppMethodBeat.o(50247);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(f paramf, List paramList, f.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(50248);
      Object localObject2 = f.a(this.jOm);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (List)d.a.v.MKE;
      }
      localObject2 = new StringBuilder("[collection] reorderWithCallback, before calculateDiff oldList.size=").append(((List)localObject1).size()).append(" reorderList.size= ");
      Object localObject3 = paramList;
      if (localObject3 == null) {
        p.gfZ();
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandCollectionStorageExport[collection]", ((List)localObject3).size() + ' ');
      localObject2 = android.support.v7.h.c.a((c.a)new ad((List)localObject1, paramList), true);
      localObject3 = new StringBuilder("[collection] reorderWithCallback, after calculateDiff oldList.size=").append(((List)localObject1).size()).append(" reorderList.size= ");
      List localList = paramList;
      if (localList == null) {
        p.gfZ();
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandCollectionStorageExport[collection]", localList.size() + ' ');
      localObject3 = (c)g.ab(c.class);
      p.g(localObject2, "diff");
      localObject1 = d.a.j.l((Iterable)localObject1);
      localList = paramList;
      if (localList == null) {
        p.gfZ();
      }
      boolean bool = ((c)localObject3).a((android.support.v7.h.c.b)localObject2, (List)localObject1, d.a.j.l((Iterable)localList), (c.b)paramb);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, changed = ".concat(String.valueOf(bool)));
      if (bool) {
        ((u)com.tencent.mm.plugin.appbrand.app.j.T(u.class)).a(LocalUsageInfo.class, paramList, null);
      }
      f.b(this.jOm).set(false);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, before run callback");
      localObject1 = paramb;
      if (localObject1 != null)
      {
        ((f.b)localObject1).bbQ();
        AppMethodBeat.o(50248);
        return;
      }
      AppMethodBeat.o(50248);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.f
 * JD-Core Version:    0.7.0.1
 */