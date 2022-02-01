package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FollowTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "plugin-finder_release"})
public final class d
  extends g
{
  public d(c paramc)
  {
    super(3, paramc);
    AppMethodBeat.i(291528);
    AppMethodBeat.o(291528);
  }
  
  public final void gO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(291527);
    super.gO(paramInt1, paramInt2);
    if (this.fEH == paramInt2)
    {
      final long l = c.an(this.fEH, true);
      Log.i(this.TAG, "[performChangeEnterTargetTab] interval=".concat(String.valueOf(l)));
      if ((l > 0L) && (l < 9223372036854775807L))
      {
        this.zLt.aDJ("performChangeEnterTargetTab");
        a(g.c.zLG, null, (b)new a(this, l));
      }
    }
    AppMethodBeat.o(291527);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
  static final class a
    extends q
    implements b<g.d, x>
  {
    a(d paramd, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.d
 * JD-Core Version:    0.7.0.1
 */