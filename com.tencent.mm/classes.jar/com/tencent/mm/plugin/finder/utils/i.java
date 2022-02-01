package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.e;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderLbsLogic;", "", "()V", "TAG", "", "checkLocationBeforeCgi", "", "noPermission", "Lkotlin/Function0;", "cacheInvalid", "cacheValid", "checkLocationPermission", "", "requestLocationPermission", "activity", "Lcom/tencent/mm/ui/MMActivity;", "syncWaitLbs", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.FinderLbsLogic";
  public static final i sWy;
  
  static
  {
    AppMethodBeat.i(205096);
    sWy = new i();
    TAG = "Finder.FinderLbsLogic";
    AppMethodBeat.o(205096);
  }
  
  public static void a(d.g.a.a<z> parama1, d.g.a.a<z> parama2, d.g.a.a<z> parama3)
  {
    AppMethodBeat.i(205092);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    if (!FinderGlobalLocationVM.cQK())
    {
      parama1.invoke();
      AppMethodBeat.o(205092);
      return;
    }
    long l1 = ch.aDa();
    long l2 = FinderGlobalLocationVM.cQM();
    parama1 = b.sHP;
    if (l1 - l2 < b.cIv())
    {
      parama3.invoke();
      AppMethodBeat.o(205092);
      return;
    }
    parama2.invoke();
    AppMethodBeat.o(205092);
  }
  
  public static boolean cNN()
  {
    AppMethodBeat.i(205093);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    boolean bool = FinderGlobalLocationVM.cQK();
    AppMethodBeat.o(205093);
    return bool;
  }
  
  public static boolean cNO()
  {
    AppMethodBeat.i(205095);
    try
    {
      synchronized (new Object())
      {
        ae.i(TAG, "start syncWaitLbs");
        new a(???).alive();
        Object localObject2 = com.tencent.mm.ui.component.a.KEX;
        localObject2 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        p.g(localObject2, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        localObject2 = (FinderGlobalLocationVM)localObject2;
        if (!FinderGlobalLocationVM.cQK()) {
          ae.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
        }
        for (int i = 0; i != 0; i = 1)
        {
          ae.i(TAG, "wait syncWaitLbs");
          localObject2 = b.sHP;
          ???.wait(b.cIw());
          ae.i(TAG, "syncWaitLbs ok");
          AppMethodBeat.o(205095);
          return true;
          ae.i("Finder.GlobalLocationVM", "[requestLocation]...");
          com.tencent.mm.ac.c.b(null, (d.g.a.a)new FinderGlobalLocationVM.b((FinderGlobalLocationVM)localObject2));
        }
        ae.i(TAG, "syncWaitLbs no permission");
        AppMethodBeat.o(205095);
        return false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace(TAG, localThrowable, "syncWaitLbs exception", new Object[0]);
      AppMethodBeat.o(205095);
    }
  }
  
  public static void g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(205094);
    p.h(paramMMActivity, "activity");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    p.g(com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class), "UICProvider.of(PluginFin…alLocationVM::class.java)");
    p.h(paramMMActivity, "activity");
    if ((Build.VERSION.SDK_INT > 23) && (!paramMMActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")))
    {
      h.a((Context)paramMMActivity, paramMMActivity.getString(2131761869), paramMMActivity.getString(2131761885), paramMMActivity.getString(2131760598), paramMMActivity.getString(2131755691), false, (DialogInterface.OnClickListener)new FinderGlobalLocationVM.e(paramMMActivity), (DialogInterface.OnClickListener)new FinderGlobalLocationVM.f(paramMMActivity));
      AppMethodBeat.o(205094);
      return;
    }
    FinderGlobalLocationVM.h(paramMMActivity);
    AppMethodBeat.o(205094);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/utils/FinderLbsLogic$syncWaitLbs$1$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLocationRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.sdk.b.c<hm>
  {
    a(Object paramObject) {}
    
    private boolean cNQ()
    {
      AppMethodBeat.i(205090);
      dead();
      synchronized (this.sWz)
      {
        Object localObject2 = i.sWy;
        ae.i(i.cNP(), "notify syncWaitLbs");
        this.sWz.notifyAll();
        localObject2 = z.Nhr;
        AppMethodBeat.o(205090);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.i
 * JD-Core Version:    0.7.0.1
 */