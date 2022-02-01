package com.tencent.mm.plugin.finder.trim;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.bi;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/trim/FinderLifecycleDelegate;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "BG_TAG", "", "CHECK_DELAY_TIME_MILLIS", "", "FG_TAG", "TAG", "bgTask", "Lkotlin/Function0;", "", "isFinderForeground", "", "mCallbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/trim/FinderLifecycleCallback;", "Lkotlin/collections/ArrayList;", "mResumedFinderUI", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "releaseUnFocusViewRunnable", "Ljava/lang/Runnable;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addFinderLifecycleCallback", "callback", "onActivityCreated", "p0", "Landroid/app/Activity;", "p1", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "releaseUnFocusView", "removeFinderLifecycleCallback", "setup", "dispatchBackground", "name", "dispatchForeground", "isFinder", "toKey", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements Application.ActivityLifecycleCallbacks
{
  public static final b FNT;
  private static Runnable FNU;
  private static final HashSet<String> FNV;
  private static volatile boolean FNW;
  private static kotlin.g.a.a<ah> FNX;
  private static final ArrayList<a> mCallbackList;
  private static MMHandler mRi;
  
  static
  {
    AppMethodBeat.i(330668);
    FNT = new b();
    mRi = new MMHandler(Looper.getMainLooper());
    mCallbackList = new ArrayList();
    FNV = new HashSet();
    AppMethodBeat.o(330668);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(330619);
    s.u(parama, "callback");
    mCallbackList.add(parama);
    AppMethodBeat.o(330619);
  }
  
  private static String aI(Activity paramActivity)
  {
    AppMethodBeat.i(330613);
    paramActivity = paramActivity.getClass().getName() + '_' + paramActivity.hashCode();
    AppMethodBeat.o(330613);
    return paramActivity;
  }
  
  private static final void fav()
  {
    AppMethodBeat.i(330625);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1808, 2);
    k localk = k.aeZF;
    ((bi)k.cn(cn.class).cq(bi.class)).fpu();
    FNU = null;
    AppMethodBeat.o(330625);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(330676);
    s.u(paramActivity, "p0");
    AppMethodBeat.o(330676);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(330712);
    s.u(paramActivity, "p0");
    AppMethodBeat.o(330712);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(330697);
    s.u(paramActivity, "p0");
    AppMethodBeat.o(330697);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(330690);
    s.u(paramActivity, "p0");
    Log.d("MicroMsg.FinderLifecycleCallback", s.X("onActivityResumed: ", aI(paramActivity)));
    String str = paramActivity.getClass().getSimpleName();
    if ((paramActivity instanceof MMFinderUI)) {}
    for (;;)
    {
      if (paramActivity != null)
      {
        FNV.add(aI(paramActivity));
        if (!FNW)
        {
          FNW = true;
          com.tencent.threadpool.h.ahAA.bFQ("FINDER-BG");
          FNX = null;
          d.a("FINDER-FG", false, (kotlin.g.a.a)new a(str));
        }
      }
      AppMethodBeat.o(330690);
      return;
      paramActivity = null;
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(330707);
    s.u(paramActivity, "p0");
    s.u(paramBundle, "p1");
    AppMethodBeat.o(330707);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(330683);
    s.u(paramActivity, "p0");
    AppMethodBeat.o(330683);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(330702);
    s.u(paramActivity, "p0");
    Log.d("MicroMsg.FinderLifecycleCallback", s.X("onActivityStopped: ", aI(paramActivity)));
    FNV.remove(aI(paramActivity));
    paramActivity = paramActivity.getClass().getSimpleName();
    if ((FNW) && (FNV.isEmpty()))
    {
      FNW = false;
      paramActivity = (kotlin.g.a.a)new b(paramActivity);
      FNX = paramActivity;
      d.a("FINDER-BG", false, paramActivity, 600L);
    }
    AppMethodBeat.o(330702);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/trim/FinderLifecycleDelegate$setup$1", "Lcom/tencent/mm/plugin/finder/trim/FinderLifecycleCallback;", "onFinderBackground", "", "name", "", "onFinderForeground", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a
  {
    public final void aAT(String paramString)
    {
      AppMethodBeat.i(330584);
      s.u(paramString, "name");
      Log.i("MicroMsg.FinderLifecycleCallback", s.X("onFinderForeground: ", paramString));
      if (b.faw() != null) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1808, 1);
      }
      b.fax().removeCallbacks(b.faw());
      AppMethodBeat.o(330584);
    }
    
    public final void aAU(String paramString)
    {
      AppMethodBeat.i(330591);
      s.u(paramString, "name");
      Log.i("MicroMsg.FinderLifecycleCallback", s.X("onFinderBackground: ", paramString));
      paramString = b.FNT;
      b.fay();
      AppMethodBeat.o(330591);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.trim.b
 * JD-Core Version:    0.7.0.1
 */