package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FriendTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "plugin-finder_release"})
public final class c
  extends f
{
  public c(FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    super(1, paramFinderStreamTabPreloadCore);
    AppMethodBeat.i(249577);
    AppMethodBeat.o(249577);
  }
  
  public final void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249576);
    super.gc(paramInt1, paramInt2);
    if (this.dLS == paramInt2)
    {
      final long l = FinderStreamTabPreloadCore.al(this.dLS, true);
      Log.i(this.TAG, "[performChangeEnterTargetTab] interval=".concat(String.valueOf(l)));
      if ((l > 0L) && (l < 9223372036854775807L))
      {
        this.uVb.aut("performChangeEnterTargetTab");
        a(f.c.uVo, null, (b)new a(this, l));
      }
    }
    AppMethodBeat.o(249576);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
  static final class a
    extends q
    implements b<f.d, x>
  {
    a(c paramc, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.c
 * JD-Core Version:    0.7.0.1
 */