package com.tencent.mm.plugin.finder.viewmodel.notifytab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.ui.fragment.FinderNotifyFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "()V", "plugin-finder_release"})
public final class c
  extends FinderTabProvider
{
  public c()
  {
    AppMethodBeat.i(269816);
    FinderNotifyFragment localFinderNotifyFragment1 = new FinderNotifyFragment();
    localFinderNotifyFragment1.fEH = 0;
    FinderNotifyFragment localFinderNotifyFragment2 = new FinderNotifyFragment();
    localFinderNotifyFragment2.fEH = 1;
    FinderNotifyFragment localFinderNotifyFragment3 = new FinderNotifyFragment();
    localFinderNotifyFragment3.fEH = 2;
    setFragments((List)j.ag(new FinderNotifyFragment[] { localFinderNotifyFragment1, localFinderNotifyFragment2, localFinderNotifyFragment3 }));
    setTabContainer((g)new b());
    setTabs((List)j.ag(new a[] { new a(b.j.finder_notify_tab_like), new a(b.j.finder_notify_tab_comment), new a(b.j.finder_notify_tab_follow) }));
    setTabViewAction((f)new e());
    AppMethodBeat.o(269816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.notifytab.c
 * JD-Core Version:    0.7.0.1
 */