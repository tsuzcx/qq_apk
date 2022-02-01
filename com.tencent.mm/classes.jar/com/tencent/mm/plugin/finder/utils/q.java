package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.il;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.viewmodel.a.b;
import com.tencent.mm.plugin.finder.viewmodel.a.e;
import com.tencent.mm.plugin.finder.viewmodel.a.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderLbsLogic;", "", "()V", "TAG", "", "checkLocationBeforeCgi", "", "noPermission", "Lkotlin/Function0;", "cacheInvalid", "cacheValid", "checkLocationPermission", "", "requestLocationPermission", "activity", "Lcom/tencent/mm/ui/MMActivity;", "syncWaitLbs", "plugin-finder_release"})
public final class q
{
  public static final q ADH;
  private static final String TAG = "Finder.FinderLbsLogic";
  
  static
  {
    AppMethodBeat.i(291048);
    ADH = new q();
    TAG = "Finder.FinderLbsLogic";
    AppMethodBeat.o(291048);
  }
  
  public static void a(kotlin.g.a.a<x> parama1, kotlin.g.a.a<x> parama2, kotlin.g.a.a<x> parama3)
  {
    AppMethodBeat.i(291043);
    g localg = g.Xox;
    p.j(g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    if (!com.tencent.mm.plugin.finder.viewmodel.a.ejZ())
    {
      if (parama1 != null)
      {
        parama1.invoke();
        AppMethodBeat.o(291043);
        return;
      }
      AppMethodBeat.o(291043);
      return;
    }
    long l1 = cm.bfC();
    long l2 = com.tencent.mm.plugin.finder.viewmodel.a.eka();
    parama1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (l1 - l2 < com.tencent.mm.plugin.finder.storage.d.dTt())
    {
      parama3.invoke();
      AppMethodBeat.o(291043);
      return;
    }
    parama2.invoke();
    AppMethodBeat.o(291043);
  }
  
  public static boolean edb()
  {
    AppMethodBeat.i(291044);
    g localg = g.Xox;
    p.j(g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    boolean bool = com.tencent.mm.plugin.finder.viewmodel.a.ejZ();
    AppMethodBeat.o(291044);
    return bool;
  }
  
  public static boolean edc()
  {
    AppMethodBeat.i(291047);
    try
    {
      synchronized (new Object())
      {
        Log.i(TAG, "start syncWaitLbs");
        new a(???).alive();
        Object localObject2 = g.Xox;
        localObject2 = g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class);
        p.j(localObject2, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        localObject2 = (com.tencent.mm.plugin.finder.viewmodel.a)localObject2;
        if (!com.tencent.mm.plugin.finder.viewmodel.a.ejZ()) {
          Log.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
        }
        for (int i = 0; i != 0; i = 1)
        {
          Log.i(TAG, "wait syncWaitLbs");
          localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
          ???.wait(com.tencent.mm.plugin.finder.storage.d.dTu());
          Log.i(TAG, "syncWaitLbs ok");
          AppMethodBeat.o(291047);
          return true;
          Log.i("Finder.GlobalLocationVM", "[forceRequestLocation]...");
          com.tencent.mm.ae.d.c("Finder.GlobalLocationVM#RequestLocation", (kotlin.g.a.a)new a.b((com.tencent.mm.plugin.finder.viewmodel.a)localObject2));
        }
        Log.i(TAG, "syncWaitLbs no permission");
        AppMethodBeat.o(291047);
        return false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace(TAG, localThrowable, "syncWaitLbs exception", new Object[0]);
      AppMethodBeat.o(291047);
    }
  }
  
  public static void h(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(291046);
    p.k(paramMMActivity, "activity");
    g localg = g.Xox;
    p.j(g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    p.k(paramMMActivity, "activity");
    if ((Build.VERSION.SDK_INT > 23) && (!paramMMActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")))
    {
      h.a((Context)paramMMActivity, paramMMActivity.getString(b.j.permission_location_request_again_msg), paramMMActivity.getString(b.j.permission_tips_title), paramMMActivity.getString(b.j.jump_to_settings), paramMMActivity.getString(b.j.app_cancel), false, (DialogInterface.OnClickListener)new a.e(paramMMActivity), (DialogInterface.OnClickListener)new a.f(paramMMActivity));
      AppMethodBeat.o(291046);
      return;
    }
    com.tencent.mm.plugin.finder.viewmodel.a.i(paramMMActivity);
    AppMethodBeat.o(291046);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderLbsLogic$syncWaitLbs$1$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLocationRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<il>
  {
    a(Object paramObject) {}
    
    private boolean ede()
    {
      AppMethodBeat.i(270215);
      dead();
      synchronized (this.ADI)
      {
        Object localObject2 = q.ADH;
        Log.i(q.edd(), "notify syncWaitLbs");
        this.ADI.notifyAll();
        localObject2 = x.aazN;
        AppMethodBeat.o(270215);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.q
 * JD-Core Version:    0.7.0.1
 */