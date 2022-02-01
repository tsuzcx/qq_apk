package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FollowTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "plugin-finder_release"})
public final class b
  extends f
{
  public b(FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    super(3, paramFinderStreamTabPreloadCore);
    AppMethodBeat.i(203562);
    AppMethodBeat.o(203562);
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203561);
    super.fI(paramInt1, paramInt2);
    if (this.dvm == paramInt2)
    {
      final long l = FinderStreamTabPreloadCore.ag(this.dvm, true);
      ae.i(this.TAG, "[performChangeEnterTargetTab] interval=".concat(String.valueOf(l)));
      if ((l > 0L) && (l < 9223372036854775807L))
      {
        this.suO.aiE("performChangeEnterTargetTab");
        a(f.c.svc, (d.g.a.b)new a(this, l));
      }
    }
    AppMethodBeat.o(203561);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<f.d, z>
  {
    a(b paramb, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.b
 * JD-Core Version:    0.7.0.1
 */