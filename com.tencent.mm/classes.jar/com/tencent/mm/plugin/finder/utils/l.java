package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.e;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderLbsLogic;", "", "()V", "TAG", "", "checkLocationBeforeCgi", "", "noPermission", "Lkotlin/Function0;", "cacheInvalid", "cacheValid", "checkLocationPermission", "", "requestLocationPermission", "activity", "Lcom/tencent/mm/ui/MMActivity;", "syncWaitLbs", "plugin-finder_release"})
public final class l
{
  private static final String TAG = "Finder.FinderLbsLogic";
  public static final l vVE;
  
  static
  {
    AppMethodBeat.i(253401);
    vVE = new l();
    TAG = "Finder.FinderLbsLogic";
    AppMethodBeat.o(253401);
  }
  
  public static void a(kotlin.g.a.a<x> parama1, kotlin.g.a.a<x> parama2, kotlin.g.a.a<x> parama3)
  {
    AppMethodBeat.i(253397);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    if (!FinderGlobalLocationVM.dHO())
    {
      if (parama1 != null)
      {
        parama1.invoke();
        AppMethodBeat.o(253397);
        return;
      }
      AppMethodBeat.o(253397);
      return;
    }
    long l1 = cl.aWy();
    long l2 = FinderGlobalLocationVM.dHQ();
    parama1 = c.vCb;
    if (l1 - l2 < c.dse())
    {
      parama3.invoke();
      AppMethodBeat.o(253397);
      return;
    }
    parama2.invoke();
    AppMethodBeat.o(253397);
  }
  
  public static boolean dBJ()
  {
    AppMethodBeat.i(253398);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    boolean bool = FinderGlobalLocationVM.dHO();
    AppMethodBeat.o(253398);
    return bool;
  }
  
  public static boolean dBK()
  {
    AppMethodBeat.i(253400);
    try
    {
      synchronized (new Object())
      {
        Log.i(TAG, "start syncWaitLbs");
        new a(???).alive();
        Object localObject2 = com.tencent.mm.ui.component.a.PRN;
        localObject2 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        p.g(localObject2, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        localObject2 = (FinderGlobalLocationVM)localObject2;
        if (!FinderGlobalLocationVM.dHO()) {
          Log.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
        }
        for (int i = 0; i != 0; i = 1)
        {
          Log.i(TAG, "wait syncWaitLbs");
          localObject2 = c.vCb;
          ???.wait(c.dsf());
          Log.i(TAG, "syncWaitLbs ok");
          AppMethodBeat.o(253400);
          return true;
          Log.i("Finder.GlobalLocationVM", "[forceRequestLocation]...");
          d.c("Finder.GlobalLocationVM#RequestLocation", (kotlin.g.a.a)new FinderGlobalLocationVM.b((FinderGlobalLocationVM)localObject2));
        }
        Log.i(TAG, "syncWaitLbs no permission");
        AppMethodBeat.o(253400);
        return false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace(TAG, localThrowable, "syncWaitLbs exception", new Object[0]);
      AppMethodBeat.o(253400);
    }
  }
  
  public static void g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(253399);
    p.h(paramMMActivity, "activity");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    p.h(paramMMActivity, "activity");
    if ((Build.VERSION.SDK_INT > 23) && (!paramMMActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")))
    {
      h.a((Context)paramMMActivity, paramMMActivity.getString(2131763874), paramMMActivity.getString(2131763890), paramMMActivity.getString(2131762043), paramMMActivity.getString(2131755761), false, (DialogInterface.OnClickListener)new FinderGlobalLocationVM.e(paramMMActivity), (DialogInterface.OnClickListener)new FinderGlobalLocationVM.f(paramMMActivity));
      AppMethodBeat.o(253399);
      return;
    }
    FinderGlobalLocationVM.h(paramMMActivity);
    AppMethodBeat.o(253399);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderLbsLogic$syncWaitLbs$1$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLocationRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hy>
  {
    a(Object paramObject) {}
    
    private boolean dBM()
    {
      AppMethodBeat.i(253395);
      dead();
      synchronized (this.vVF)
      {
        Object localObject2 = l.vVE;
        Log.i(l.dBL(), "notify syncWaitLbs");
        this.vVF.notifyAll();
        localObject2 = x.SXb;
        AppMethodBeat.o(253395);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.l
 * JD-Core Version:    0.7.0.1
 */