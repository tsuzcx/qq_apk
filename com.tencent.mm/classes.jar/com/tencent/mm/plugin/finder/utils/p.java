package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.e;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderLbsLogic;", "", "()V", "TAG", "", "checkLocationBeforeCgi", "", "noPermission", "Lkotlin/Function0;", "cacheInvalid", "cacheValid", "checkLocationPermission", "", "requestLocationPermission", "activity", "Lcom/tencent/mm/ui/MMActivity;", "syncWaitLbs", "plugin-finder_release"})
public final class p
{
  public static final p LaH;
  private static final String TAG = "Finder.FinderLbsLogic";
  
  static
  {
    AppMethodBeat.i(199632);
    LaH = new p();
    TAG = "Finder.FinderLbsLogic";
    AppMethodBeat.o(199632);
  }
  
  public static void a(d.g.a.a<y> parama1, d.g.a.a<y> parama2, d.g.a.a<y> parama3)
  {
    AppMethodBeat.i(199628);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    k.g(com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    if (!FinderGlobalLocationVM.fXe())
    {
      parama1.invoke();
      AppMethodBeat.o(199628);
      return;
    }
    long l1 = ce.asQ();
    long l2 = FinderGlobalLocationVM.fXg();
    parama1 = b.qJA;
    if (l1 - l2 < b.fUD())
    {
      parama3.invoke();
      AppMethodBeat.o(199628);
      return;
    }
    parama2.invoke();
    AppMethodBeat.o(199628);
  }
  
  public static boolean fVQ()
  {
    AppMethodBeat.i(199629);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    k.g(com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    boolean bool = FinderGlobalLocationVM.fXe();
    AppMethodBeat.o(199629);
    return bool;
  }
  
  public static boolean fVR()
  {
    AppMethodBeat.i(199631);
    try
    {
      synchronized (new Object())
      {
        ad.i(TAG, "start syncWaitLbs");
        new a(???).alive();
        Object localObject2 = com.tencent.mm.ui.component.a.LCX;
        localObject2 = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
        k.g(localObject2, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        localObject2 = (FinderGlobalLocationVM)localObject2;
        if (!FinderGlobalLocationVM.fXe()) {
          ad.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
        }
        for (int i = 0; i != 0; i = 1)
        {
          ad.i(TAG, "wait syncWaitLbs");
          localObject2 = b.qJA;
          ???.wait(b.fUE());
          ad.i(TAG, "syncWaitLbs ok");
          AppMethodBeat.o(199631);
          return true;
          ad.i("Finder.GlobalLocationVM", "[requestLocation]...");
          com.tencent.mm.ad.c.b(null, (d.g.a.a)new FinderGlobalLocationVM.b((FinderGlobalLocationVM)localObject2));
        }
        ad.i(TAG, "syncWaitLbs no permission");
        AppMethodBeat.o(199631);
        return false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace(TAG, localThrowable, "syncWaitLbs exception", new Object[0]);
      AppMethodBeat.o(199631);
    }
  }
  
  public static void g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(199630);
    k.h(paramMMActivity, "activity");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    k.g(com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    k.h(paramMMActivity, "activity");
    if ((Build.VERSION.SDK_INT > 23) && (!paramMMActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")))
    {
      h.a((Context)paramMMActivity, paramMMActivity.getString(2131761869), paramMMActivity.getString(2131761885), paramMMActivity.getString(2131760598), paramMMActivity.getString(2131755691), false, (DialogInterface.OnClickListener)new FinderGlobalLocationVM.e(paramMMActivity), (DialogInterface.OnClickListener)new FinderGlobalLocationVM.f(paramMMActivity));
      AppMethodBeat.o(199630);
      return;
    }
    FinderGlobalLocationVM.r(paramMMActivity);
    AppMethodBeat.o(199630);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/utils/FinderLbsLogic$syncWaitLbs$1$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLocationRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.sdk.b.c<ym>
  {
    a(Object paramObject) {}
    
    private boolean fVT()
    {
      AppMethodBeat.i(199626);
      dead();
      synchronized (this.LaI)
      {
        Object localObject2 = p.LaH;
        ad.i(p.fVS(), "notify syncWaitLbs");
        this.LaI.notifyAll();
        localObject2 = y.JfV;
        AppMethodBeat.o(199626);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p
 * JD-Core Version:    0.7.0.1
 */