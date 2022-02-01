package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FollowTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "plugin-finder_release"})
public final class b
  extends f
{
  public b(FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    super(3, paramFinderStreamTabPreloadCore);
    AppMethodBeat.i(221496);
    AppMethodBeat.o(221496);
  }
  
  public final void ex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221495);
    super.ex(paramInt1, paramInt2);
    if (this.duh == paramInt2)
    {
      long l = FinderStreamTabPreloadCore.bu(this.duh, true);
      ad.i(this.TAG, "[performChangeEnterTargetTab] interval=".concat(String.valueOf(l)));
      if ((l > 0L) && (l < 9223372036854775807L))
      {
        this.INs.axH("performChangeEnterTargetTab");
        if (b(f.c.ING)) {
          this.INs.a(this.INw, l, "performChangeEnterTargetTab");
        }
      }
    }
    AppMethodBeat.o(221495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.b
 * JD-Core Version:    0.7.0.1
 */