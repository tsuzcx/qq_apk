package com.tencent.mm.plugin.finder.service;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.l;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderExternalMultiTaskService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderExternalMultiTaskService;", "()V", "checkMoveBackFinderTask", "", "checkReenterFinderFromLauncherUI", "", "activity", "Landroid/app/Activity;", "onLauncherUIPause", "onLauncherUIStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements ad
{
  public final boolean E(Activity paramActivity)
  {
    AppMethodBeat.i(330051);
    s.u(paramActivity, "activity");
    l locall = (l)h.ax(l.class);
    if (locall == null)
    {
      AppMethodBeat.o(330051);
      return false;
    }
    boolean bool = locall.E(paramActivity);
    AppMethodBeat.o(330051);
    return bool;
  }
  
  public final void bUT()
  {
    AppMethodBeat.i(330060);
    l locall = (l)h.ax(l.class);
    if (locall != null) {
      locall.bUT();
    }
    AppMethodBeat.o(330060);
  }
  
  public final void bUU()
  {
    AppMethodBeat.i(330067);
    l locall = (l)h.ax(l.class);
    if (locall != null) {
      locall.bUU();
    }
    AppMethodBeat.o(330067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.d
 * JD-Core Version:    0.7.0.1
 */