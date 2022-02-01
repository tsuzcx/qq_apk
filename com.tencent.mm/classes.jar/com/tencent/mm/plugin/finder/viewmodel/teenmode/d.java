package com.tencent.mm.plugin.finder.viewmodel.teenmode;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.n;
import com.tencent.threadpool.i;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeLimitVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "Lcom/tencent/mm/app/IAppForegroundListener;", "Lcom/tencent/mm/plugin/finder/api/IFinderTeenModeLimitVM;", "()V", "authorAgreeChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AgreeAuthorizationChangeEvent;", "canNotifyLimit", "", "getCanNotifyLimit", "()Z", "setCanNotifyLimit", "(Z)V", "enjoyFinderMs", "", "enjoyLiveMiniStartTime", "enjoyStartTime", "enterRefCount", "", "finderUseTimer", "Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderUseTimer;", "lifeCallback", "com/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeLimitVM$lifeCallback$1", "Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeLimitVM$lifeCallback$1;", "overLimitListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/api/IEnjoyFinderOverLimit;", "Lkotlin/collections/HashSet;", "addEnjoyFinderListener", "", "listener", "checkClearEnjoyFinderTime", "checkEnableCurFew", "checkTeemModeLimit", "currentEnjoyFinderMs", "handleFinderUICreate", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "handleFinderUIStart", "handleFinderUIStop", "init", "isEnableLimit", "isFinderCountPage", "Landroid/app/Activity;", "isInLimitTimeRange", "onAppBackground", "", "onAppForeground", "onEnjoyFinderOverLimit", "isCurFew", "recordEnjoyTime", "recordLiveEnjoyTime", "release", "removeEnjoyFinderListener", "startCheckTeenModeTimer", "startEnjoyFinder", "stopCheckTeenModeTimer", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends n<com.tencent.mm.plugin.findersdk.a.cn>
  implements q, com.tencent.mm.plugin.finder.api.l
{
  public static final d.a GWH;
  private final f GWI;
  HashSet<com.tencent.mm.plugin.finder.api.f> GWJ;
  public boolean GWK;
  private long GWL;
  private long GWM;
  private long GWN;
  private int GWO;
  public final b GWP;
  public final IListener<com.tencent.mm.autogen.a.l> GWQ;
  
  static
  {
    AppMethodBeat.i(337441);
    GWH = new d.a((byte)0);
    AppMethodBeat.o(337441);
  }
  
  public d()
  {
    AppMethodBeat.i(337332);
    this.GWI = new f();
    this.GWJ = new HashSet();
    this.GWK = true;
    this.GWP = new b(this);
    this.GWQ = ((IListener)new FinderTeenModeLimitVM.authorAgreeChangeListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(337332);
  }
  
  private static final void a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(337373);
    s.u(paramd, "this$0");
    paramd = ((Iterable)paramd.GWJ).iterator();
    while (paramd.hasNext()) {
      ((com.tencent.mm.plugin.finder.api.f)paramd.next()).pG(paramBoolean);
    }
    AppMethodBeat.o(337373);
  }
  
  public static boolean fpE()
  {
    AppMethodBeat.i(337344);
    c localc = c.GWG;
    boolean bool1 = c.fpz();
    boolean bool2 = ((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZE();
    Log.i("FinderTeenModeLimitVM", "isEnableLimit switch:" + bool1 + ", teenModeAndViewAll:" + bool2);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(337344);
      return true;
    }
    AppMethodBeat.o(337344);
    return false;
  }
  
  private final void fpF()
  {
    AppMethodBeat.i(337353);
    if (this.GWI.fpI()) {
      Log.i("FinderTeenModeLimitVM", s.X("stopCheckTeenModeTimer enjoyFinderMs", Long.valueOf(this.GWL)));
    }
    AppMethodBeat.o(337353);
  }
  
  private static boolean fpG()
  {
    AppMethodBeat.i(337367);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(com.tencent.mm.model.cn.bDw());
    int k = ((Calendar)localObject).get(11);
    localObject = c.GWG;
    int i = c.fpB();
    localObject = c.GWG;
    int m = c.fpC();
    int j;
    if (m > 0)
    {
      j = m - 1;
      Log.i("FinderTeenModeLimitVM", "isInDayHour22_6 now hour:" + k + ", start:" + i + ", end:" + m + ", realEnd:" + j);
      if (i > k) {
        break label155;
      }
      if (k > 24) {
        break label150;
      }
      i = 1;
      label118:
      if (i == 0)
      {
        if (k < 0) {
          break label165;
        }
        if (k > j) {
          break label160;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label170;
      }
      AppMethodBeat.o(337367);
      return true;
      j = 0;
      break;
      label150:
      i = 0;
      break label118;
      label155:
      i = 0;
      break label118;
      label160:
      i = 0;
      continue;
      label165:
      i = 0;
    }
    label170:
    AppMethodBeat.o(337367);
    return false;
  }
  
  private final void pG(boolean paramBoolean)
  {
    AppMethodBeat.i(337359);
    if (!this.GWK)
    {
      AppMethodBeat.o(337359);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(new d..ExternalSyntheticLambda0(this, paramBoolean));
    AppMethodBeat.o(337359);
  }
  
  public final void dUq()
  {
    AppMethodBeat.i(337469);
    if (!fpE())
    {
      AppMethodBeat.o(337469);
      return;
    }
    Log.i("FinderTeenModeLimitVM", s.X("recordLiveEnjoyTime start enjoyFinderMs:", Long.valueOf(this.GWL)));
    if (this.GWN > 0L)
    {
      this.GWL += com.tencent.mm.model.cn.bDw() - this.GWN;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adeP, Long.valueOf(this.GWL));
      this.GWN = 0L;
    }
    Log.i("FinderTeenModeLimitVM", s.X("recordLiveEnjoyTime end enjoyFinderMs:", Long.valueOf(this.GWL)));
    AppMethodBeat.o(337469);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(337460);
    Log.i("FinderTeenModeLimitVM", "FinderTeenModeLimitVM onAppBackground");
    fpF();
    AppMethodBeat.o(337460);
  }
  
  public final void onAppForeground(String paramString) {}
  
  public final void vs(boolean paramBoolean)
  {
    AppMethodBeat.i(337464);
    this.GWM = com.tencent.mm.model.cn.bDw();
    if (paramBoolean)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adeR, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adeS, Long.valueOf(this.GWM));
    }
    this.GWL = 0L;
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adeP, Long.valueOf(this.GWL));
    AppMethodBeat.o(337464);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeLimitVM$lifeCallback$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Application.ActivityLifecycleCallbacks
  {
    b(d paramd) {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(337321);
      s.u(paramActivity, "activity");
      if ((paramActivity instanceof MMFinderUI)) {
        d.a(this.GWR, (MMFinderUI)paramActivity);
      }
      AppMethodBeat.o(337321);
    }
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(337365);
      s.u(paramActivity, "activity");
      if ((paramActivity instanceof MMFinderUI))
      {
        com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
        if ((com.tencent.mm.plugin.findersdk.e.a.ay(paramActivity)) && (d.fpE()) && (((b)com.tencent.mm.kernel.h.az(b.class)).isVisitorLiving()))
        {
          Log.i("FinderTeenModeLimitVM", "IPluginFinderLive isVisitorLiving");
          d.b(this.GWR, com.tencent.mm.model.cn.bDw());
        }
        if (d.g(this.GWR) <= 0) {
          AppForegroundDelegate.heY.b((q)this.GWR);
        }
      }
      AppMethodBeat.o(337365);
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(337345);
      s.u(paramActivity, "activity");
      AppMethodBeat.o(337345);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(337336);
      s.u(paramActivity, "activity");
      AppMethodBeat.o(337336);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(337358);
      s.u(paramActivity, "activity");
      s.u(paramBundle, "outState");
      AppMethodBeat.o(337358);
    }
    
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(337327);
      s.u(paramActivity, "activity");
      if (d.aQ(paramActivity)) {
        d.e(this.GWR);
      }
      AppMethodBeat.o(337327);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(337352);
      s.u(paramActivity, "activity");
      if (d.aQ(paramActivity)) {
        d.f(this.GWR);
      }
      AppMethodBeat.o(337352);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.teenmode.d
 * JD-Core Version:    0.7.0.1
 */