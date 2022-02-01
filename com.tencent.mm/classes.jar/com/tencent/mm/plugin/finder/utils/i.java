package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.e;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderLbsLogic;", "", "()V", "TAG", "", "checkLocationBeforeCgi", "", "noPermission", "Lkotlin/Function0;", "cacheInvalid", "cacheValid", "checkLocationPermission", "", "requestLocationPermission", "activity", "Lcom/tencent/mm/ui/MMActivity;", "syncWaitLbs", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.FinderLbsLogic";
  public static final i sLn;
  
  static
  {
    AppMethodBeat.i(204478);
    sLn = new i();
    TAG = "Finder.FinderLbsLogic";
    AppMethodBeat.o(204478);
  }
  
  public static void a(d.g.a.a<z> parama1, d.g.a.a<z> parama2, d.g.a.a<z> parama3)
  {
    AppMethodBeat.i(204474);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    if (!FinderGlobalLocationVM.cOa())
    {
      parama1.invoke();
      AppMethodBeat.o(204474);
      return;
    }
    long l1 = cf.aCK();
    long l2 = FinderGlobalLocationVM.cOc();
    parama1 = b.sxa;
    if (l1 - l2 < b.cGy())
    {
      parama3.invoke();
      AppMethodBeat.o(204474);
      return;
    }
    parama2.invoke();
    AppMethodBeat.o(204474);
  }
  
  public static boolean cLj()
  {
    AppMethodBeat.i(204475);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    boolean bool = FinderGlobalLocationVM.cOa();
    AppMethodBeat.o(204475);
    return bool;
  }
  
  public static boolean cLk()
  {
    AppMethodBeat.i(204477);
    try
    {
      synchronized (new Object())
      {
        ad.i(TAG, "start syncWaitLbs");
        new a(???).alive();
        Object localObject2 = com.tencent.mm.ui.component.a.KiD;
        localObject2 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        p.g(localObject2, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        localObject2 = (FinderGlobalLocationVM)localObject2;
        if (!FinderGlobalLocationVM.cOa()) {
          ad.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
        }
        for (int i = 0; i != 0; i = 1)
        {
          ad.i(TAG, "wait syncWaitLbs");
          localObject2 = b.sxa;
          ???.wait(b.cGz());
          ad.i(TAG, "syncWaitLbs ok");
          AppMethodBeat.o(204477);
          return true;
          ad.i("Finder.GlobalLocationVM", "[requestLocation]...");
          com.tencent.mm.ad.c.b(null, (d.g.a.a)new FinderGlobalLocationVM.b((FinderGlobalLocationVM)localObject2));
        }
        ad.i(TAG, "syncWaitLbs no permission");
        AppMethodBeat.o(204477);
        return false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace(TAG, localThrowable, "syncWaitLbs exception", new Object[0]);
      AppMethodBeat.o(204477);
    }
  }
  
  public static void g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(204476);
    p.h(paramMMActivity, "activity");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    p.h(paramMMActivity, "activity");
    if ((Build.VERSION.SDK_INT > 23) && (!paramMMActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")))
    {
      h.a((Context)paramMMActivity, paramMMActivity.getString(2131761869), paramMMActivity.getString(2131761885), paramMMActivity.getString(2131760598), paramMMActivity.getString(2131755691), false, (DialogInterface.OnClickListener)new FinderGlobalLocationVM.e(paramMMActivity), (DialogInterface.OnClickListener)new FinderGlobalLocationVM.f(paramMMActivity));
      AppMethodBeat.o(204476);
      return;
    }
    FinderGlobalLocationVM.h(paramMMActivity);
    AppMethodBeat.o(204476);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/utils/FinderLbsLogic$syncWaitLbs$1$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLocationRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.sdk.b.c<hl>
  {
    a(Object paramObject) {}
    
    private boolean cLm()
    {
      AppMethodBeat.i(204472);
      dead();
      synchronized (this.sLo)
      {
        Object localObject2 = i.sLn;
        ad.i(i.cLl(), "notify syncWaitLbs");
        this.sLo.notifyAll();
        localObject2 = z.MKo;
        AppMethodBeat.o(204472);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.i
 * JD-Core Version:    0.7.0.1
 */