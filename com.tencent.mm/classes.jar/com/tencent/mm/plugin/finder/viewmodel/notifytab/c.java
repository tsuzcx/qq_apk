package com.tencent.mm.plugin.finder.viewmodel.notifytab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderNotifyFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "()V", "plugin-finder_release"})
public final class c
  extends FinderTabProvider
{
  public c()
  {
    AppMethodBeat.i(256111);
    FinderNotifyFragment localFinderNotifyFragment1 = new FinderNotifyFragment();
    localFinderNotifyFragment1.dLS = 0;
    FinderNotifyFragment localFinderNotifyFragment2 = new FinderNotifyFragment();
    localFinderNotifyFragment2.dLS = 1;
    FinderNotifyFragment localFinderNotifyFragment3 = new FinderNotifyFragment();
    localFinderNotifyFragment3.dLS = 2;
    setFragments((List)j.ac(new FinderNotifyFragment[] { localFinderNotifyFragment1, localFinderNotifyFragment2, localFinderNotifyFragment3 }));
    setTabContainer((g)new b());
    setTabs((List)j.ac(new a[] { new a(2131760356), new a(2131760354), new a(2131760355) }));
    setTabViewAction((f)new e());
    AppMethodBeat.o(256111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.notifytab.c
 * JD-Core Version:    0.7.0.1
 */