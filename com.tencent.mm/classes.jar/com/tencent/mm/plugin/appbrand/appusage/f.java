package com.tencent.mm.plugin.appbrand.appusage;

import a.l;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "mCalculatingDiff", "Ljava/util/concurrent/atomic/AtomicBoolean;", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "onRegister", "onUnregister", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "remove", "removeCollection", "reorder", "reorderList", "reason", "reorderWithCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Companion", "ReorderCallback", "plugin-appbrand-integration_release"})
public final class f
  extends k
  implements b, af
{
  private static f haV;
  public static final f.a haW;
  private final AtomicBoolean haU;
  
  static
  {
    AppMethodBeat.i(134529);
    haW = new f.a((byte)0);
    AppMethodBeat.o(134529);
  }
  
  public f()
  {
    AppMethodBeat.i(134528);
    this.haU = new AtomicBoolean(false);
    AppMethodBeat.o(134528);
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt, af.a parama)
  {
    AppMethodBeat.i(134522);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(134522);
      return null;
    }
    parama = (List)((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).b(paramInt, parama);
    AppMethodBeat.o(134522);
    return parama;
  }
  
  public final boolean a(List<? extends LocalUsageInfo> paramList, f.b paramb)
  {
    AppMethodBeat.i(134519);
    if (paramList == null)
    {
      if (bp.dud()) {
        Assert.assertTrue("reorderList is NULL", false);
      }
    }
    else
    {
      this.haU.set(true);
      paramList = (Runnable)new f.e(this, paramList, paramb);
      if (!al.isMainThread()) {
        break label71;
      }
      m.aNS().ac(paramList);
    }
    for (;;)
    {
      AppMethodBeat.o(134519);
      return true;
      AppMethodBeat.o(134519);
      return false;
      label71:
      paramList.run();
    }
  }
  
  public final boolean aC(String paramString, int paramInt)
  {
    AppMethodBeat.i(134516);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(134516);
      return false;
    }
    localObject = (s)com.tencent.mm.plugin.appbrand.app.g.w(s.class);
    if (paramString == null) {
      a.f.b.j.ebi();
    }
    boolean bool = ((s)localObject).aG(paramString, paramInt);
    AppMethodBeat.o(134516);
    return bool;
  }
  
  public final int aD(String paramString, int paramInt)
  {
    AppMethodBeat.i(134517);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(134517);
      return -1;
    }
    localObject = (s)com.tencent.mm.plugin.appbrand.app.g.w(s.class);
    if (paramString == null) {
      a.f.b.j.ebi();
    }
    paramInt = ((s)localObject).aH(paramString, paramInt);
    AppMethodBeat.o(134517);
    return paramInt;
  }
  
  public final boolean aE(String paramString, int paramInt)
  {
    AppMethodBeat.i(134518);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(134518);
      return false;
    }
    localObject = (s)com.tencent.mm.plugin.appbrand.app.g.w(s.class);
    if (paramString == null) {
      a.f.b.j.ebi();
    }
    boolean bool = ((s)localObject).aI(paramString, paramInt);
    AppMethodBeat.o(134518);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(134525);
    add(parama, Looper.getMainLooper());
    AppMethodBeat.o(134525);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(134526);
    ((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).add(parama, paramLooper);
    com.tencent.mm.plugin.appbrand.app.g.auF().add(parama, paramLooper);
    AppMethodBeat.o(134526);
  }
  
  public final void awQ()
  {
    AppMethodBeat.i(134515);
    if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED)
    {
      if (this.haU.get())
      {
        ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, skip fetch when calculating diff");
        AppMethodBeat.o(134515);
        return;
      }
      ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, fetch");
      j.axa().a(bo.aoy(), true, null, 6, 0);
    }
    h.b(com.tencent.mm.plugin.appbrand.task.g.iKS);
    h.b(com.tencent.mm.plugin.appbrand.task.g.iKT);
    AppMethodBeat.o(134515);
  }
  
  public final int awR()
  {
    AppMethodBeat.i(134524);
    int i = t.axA();
    AppMethodBeat.o(134524);
    return i;
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    AppMethodBeat.i(134521);
    ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "reorder reason = ".concat(String.valueOf(paramInt)));
    f.b localb;
    switch (paramInt)
    {
    default: 
      localb = null;
    }
    for (;;)
    {
      boolean bool = a(paramList, localb);
      AppMethodBeat.o(134521);
      return bool;
      localb = (f.b)new f.c();
      continue;
      localb = (f.b)new d();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(134523);
    Object localObject = com.tencent.mm.plugin.appbrand.app.g.w(s.class);
    a.f.b.j.p(localObject, "SubCoreAppBrand.getStora…arAppStorage::class.java)");
    int i = ((s)localObject).axx();
    AppMethodBeat.o(134523);
    return i;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(134527);
    ((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).remove(parama);
    com.tencent.mm.plugin.appbrand.app.g.auF().remove(parama);
    AppMethodBeat.o(134527);
  }
  
  public final void xM()
  {
    haV = (f)this;
  }
  
  public final void xN()
  {
    haV = null;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$2", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onReorderEnd", "", "plugin-appbrand-integration_release"})
  public static final class d
    extends f.b
  {
    public final void awT()
    {
      AppMethodBeat.i(134513);
      ((c)com.tencent.mm.kernel.g.E(c.class)).a(z.b.hcz);
      AppMethodBeat.o(134513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.f
 * JD-Core Version:    0.7.0.1
 */