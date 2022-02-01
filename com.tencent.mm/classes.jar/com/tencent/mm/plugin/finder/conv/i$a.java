package com.tencent.mm.plugin.finder.conv;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$5$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$a
  implements Application.ActivityLifecycleCallbacks
{
  i$a(i parami) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(336088);
    s.u(paramActivity, "activity");
    if ((paramActivity instanceof MMFinderUI))
    {
      paramActivity = this.AGi;
      i.a(paramActivity, i.e(paramActivity) + 1);
    }
    AppMethodBeat.o(336088);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(336128);
    s.u(paramActivity, "activity");
    if ((paramActivity instanceof MMFinderUI))
    {
      paramActivity = this.AGi;
      i.a(paramActivity, i.e(paramActivity) - 1);
    }
    i.a(this.AGi, i.f.AGq);
    AppMethodBeat.o(336128);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(336111);
    s.u(paramActivity, "activity");
    i.a(this.AGi, ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).isPayScene(paramActivity));
    AppMethodBeat.o(336111);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(336107);
    s.u(paramActivity, "activity");
    i.a(this.AGi, ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).isPayScene(paramActivity));
    if ((paramActivity instanceof MMFinderUI)) {
      d.B((kotlin.g.a.a)new a(this.AGi));
    }
    AppMethodBeat.o(336107);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(336121);
    s.u(paramActivity, "activity");
    s.u(paramBundle, "outState");
    AppMethodBeat.o(336121);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(336101);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(336101);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(336115);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(336115);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.i.a
 * JD-Core Version:    0.7.0.1
 */