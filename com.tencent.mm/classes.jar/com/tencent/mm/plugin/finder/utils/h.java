package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.e;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderLbsLogic;", "", "()V", "TAG", "", "checkLocationBeforeCgi", "", "noPermission", "Lkotlin/Function0;", "cacheInvalid", "cacheValid", "checkLocationPermission", "", "requestLocationPermission", "activity", "Lcom/tencent/mm/ui/MMActivity;", "syncWaitLbs", "plugin-finder_release"})
public final class h
{
  private static final String TAG = "Finder.FinderLbsLogic";
  public static final h rOQ;
  
  static
  {
    AppMethodBeat.i(203608);
    rOQ = new h();
    TAG = "Finder.FinderLbsLogic";
    AppMethodBeat.o(203608);
  }
  
  public static void a(d.g.a.a<y> parama1, d.g.a.a<y> parama2, d.g.a.a<y> parama3)
  {
    AppMethodBeat.i(203604);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    k.g(com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    if (!FinderGlobalLocationVM.cFG())
    {
      parama1.invoke();
      AppMethodBeat.o(203604);
      return;
    }
    long l1 = ce.azH();
    long l2 = FinderGlobalLocationVM.cFI();
    parama1 = b.rCU;
    if (l1 - l2 < b.cAa())
    {
      parama3.invoke();
      AppMethodBeat.o(203604);
      return;
    }
    parama2.invoke();
    AppMethodBeat.o(203604);
  }
  
  public static boolean cCS()
  {
    AppMethodBeat.i(203605);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    k.g(com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    boolean bool = FinderGlobalLocationVM.cFG();
    AppMethodBeat.o(203605);
    return bool;
  }
  
  public static boolean cCT()
  {
    AppMethodBeat.i(203607);
    try
    {
      synchronized (new Object())
      {
        ac.i(TAG, "start syncWaitLbs");
        new a(???).alive();
        Object localObject2 = com.tencent.mm.ui.component.a.IrY;
        localObject2 = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
        k.g(localObject2, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        localObject2 = (FinderGlobalLocationVM)localObject2;
        if (!FinderGlobalLocationVM.cFG()) {
          ac.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
        }
        for (int i = 0; i != 0; i = 1)
        {
          ac.i(TAG, "wait syncWaitLbs");
          localObject2 = b.rCU;
          ???.wait(b.cAb());
          ac.i(TAG, "syncWaitLbs ok");
          AppMethodBeat.o(203607);
          return true;
          ac.i("Finder.GlobalLocationVM", "[requestLocation]...");
          com.tencent.mm.ac.c.b(null, (d.g.a.a)new FinderGlobalLocationVM.b((FinderGlobalLocationVM)localObject2));
        }
        ac.i(TAG, "syncWaitLbs no permission");
        AppMethodBeat.o(203607);
        return false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace(TAG, localThrowable, "syncWaitLbs exception", new Object[0]);
      AppMethodBeat.o(203607);
    }
  }
  
  public static void f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(203606);
    k.h(paramMMActivity, "activity");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    k.g(com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    k.h(paramMMActivity, "activity");
    if ((Build.VERSION.SDK_INT > 23) && (!paramMMActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")))
    {
      com.tencent.mm.ui.base.h.a((Context)paramMMActivity, paramMMActivity.getString(2131761869), paramMMActivity.getString(2131761885), paramMMActivity.getString(2131760598), paramMMActivity.getString(2131755691), false, (DialogInterface.OnClickListener)new FinderGlobalLocationVM.e(paramMMActivity), (DialogInterface.OnClickListener)new FinderGlobalLocationVM.f(paramMMActivity));
      AppMethodBeat.o(203606);
      return;
    }
    FinderGlobalLocationVM.g(paramMMActivity);
    AppMethodBeat.o(203606);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/utils/FinderLbsLogic$syncWaitLbs$1$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLocationRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.sdk.b.c<hg>
  {
    a(Object paramObject) {}
    
    private boolean cCV()
    {
      AppMethodBeat.i(203602);
      dead();
      synchronized (this.rOR)
      {
        Object localObject2 = h.rOQ;
        ac.i(h.cCU(), "notify syncWaitLbs");
        this.rOR.notifyAll();
        localObject2 = y.KTp;
        AppMethodBeat.o(203602);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.h
 * JD-Core Version:    0.7.0.1
 */