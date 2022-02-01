package com.tencent.mm.plugin.finder.viewmodel.notifytab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderNotifyFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.l;
import com.tencent.mm.plugin.finder.view.tabcomp.m;
import com.tencent.mm.plugin.finder.view.tabcomp.n;
import com.tencent.mm.plugin.finder.view.tabcomp.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderAlignTabProvider;", "()V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e
{
  public c()
  {
    AppMethodBeat.i(337372);
    FinderNotifyFragment localFinderNotifyFragment = new FinderNotifyFragment();
    localFinderNotifyFragment.hJx = 0;
    Object localObject1 = ah.aiuX;
    localObject1 = new FinderNotifyFragment();
    ((FinderHomeTabFragment)localObject1).hJx = 1;
    Object localObject2 = ah.aiuX;
    localObject2 = new FinderNotifyFragment();
    ((FinderHomeTabFragment)localObject2).hJx = 2;
    ah localah = ah.aiuX;
    setFragments((List)p.al(new FinderNotifyFragment[] { localFinderNotifyFragment, localObject1, localObject2 }));
    setTabContainer((n)new b());
    setTabs((List)p.al(new a[] { new a(e.h.finder_notify_tab_like), new a(e.h.finder_notify_tab_comment), new a(e.h.finder_notify_tab_follow) }));
    setTabViewAction((m)new l());
    this.GJf = ((o)new com.tencent.mm.plugin.finder.view.tabcomp.b());
    AppMethodBeat.o(337372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.notifytab.c
 * JD-Core Version:    0.7.0.1
 */