package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FollowTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "plugin-finder_release"})
public final class b
  extends f
{
  public b(FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    super(3, paramFinderStreamTabPreloadCore);
    AppMethodBeat.i(249574);
    AppMethodBeat.o(249574);
  }
  
  public final void gc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249573);
    super.gc(paramInt1, paramInt2);
    if (this.dLS == paramInt2)
    {
      final long l = FinderStreamTabPreloadCore.al(this.dLS, true);
      Log.i(this.TAG, "[performChangeEnterTargetTab] interval=".concat(String.valueOf(l)));
      if ((l > 0L) && (l < 9223372036854775807L))
      {
        this.uVb.aut("performChangeEnterTargetTab");
        a(f.c.uVo, null, (kotlin.g.a.b)new a(this, l));
      }
    }
    AppMethodBeat.o(249573);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<f.d, x>
  {
    a(b paramb, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.b
 * JD-Core Version:    0.7.0.1
 */