package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ao;
import com.tencent.mm.plugin.finder.report.x;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "onPause", "", "plugin-finder_release"})
public final class FinderStreamCardTxtConvert$lifecycleObserver$1
  implements k
{
  @t(jl=h.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(286220);
    Object localObject1 = this.xpI.amk;
    if (localObject1 != null)
    {
      Object localObject2 = cp.c(this.xpI);
      if (localObject2 != null) {}
      for (int i = ((View)localObject2).getHeight();; i = 0)
      {
        if ((i > 0) && (cp.a(this.xpI, (View)localObject1)))
        {
          localObject2 = ((View)localObject1).getTag();
          localObject1 = localObject2;
          if (!(localObject2 instanceof ao)) {
            localObject1 = null;
          }
          localObject1 = (ao)localObject1;
          if ((localObject1 != null) && (this.xpI.xpE))
          {
            localObject2 = x.zYS;
            x.a(((ao)localObject1).xBM, ((ao)localObject1).xBN, ((ao)localObject1).position, ((ao)localObject1).xBO, "", cp.b(this.xpI));
          }
          this.xpI.xpE = true;
        }
        AppMethodBeat.o(286220);
        return;
      }
    }
    AppMethodBeat.o(286220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderStreamCardTxtConvert.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */