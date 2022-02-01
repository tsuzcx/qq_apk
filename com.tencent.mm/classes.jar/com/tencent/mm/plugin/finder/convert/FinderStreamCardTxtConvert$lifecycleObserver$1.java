package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ah;
import com.tencent.mm.plugin.finder.report.t;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1", "Landroid/arch/lifecycle/LifecycleObserver;", "onPause", "", "plugin-finder_release"})
public final class FinderStreamCardTxtConvert$lifecycleObserver$1
  implements LifecycleObserver
{
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(243336);
    Object localObject1 = this.tGW.aus;
    if (localObject1 != null)
    {
      Object localObject2 = ci.c(this.tGW);
      if (localObject2 != null) {}
      for (int i = ((View)localObject2).getHeight();; i = 0)
      {
        if ((i > 0) && (ci.a(this.tGW, (View)localObject1)))
        {
          localObject2 = ((View)localObject1).getTag();
          localObject1 = localObject2;
          if (!(localObject2 instanceof ah)) {
            localObject1 = null;
          }
          localObject1 = (ah)localObject1;
          if ((localObject1 != null) && (this.tGW.tGS))
          {
            localObject2 = t.vhJ;
            t.a(((ah)localObject1).tQV, ((ah)localObject1).tQW, ((ah)localObject1).position, ((ah)localObject1).tQX, "", ci.b(this.tGW));
          }
          this.tGW.tGS = true;
        }
        AppMethodBeat.o(243336);
        return;
      }
    }
    AppMethodBeat.o(243336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderStreamCardTxtConvert.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */