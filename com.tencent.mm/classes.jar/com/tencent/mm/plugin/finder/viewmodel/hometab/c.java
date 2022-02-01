package com.tencent.mm.plugin.finder.viewmodel.hometab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/hometab/FinderHomeTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "()V", "plugin-finder_release"})
public final class c
  extends FinderTabProvider
{
  public c()
  {
    AppMethodBeat.i(256105);
    setFragments((List)j.ac(new FinderHomeTabFragment[] { (FinderHomeTabFragment)new FinderFollowTabFragment(), (FinderHomeTabFragment)new FinderFriendTabFragment(), (FinderHomeTabFragment)new FinderMachineTabFragment() }));
    setTabContainer((g)new b());
    setTabs((List)j.ac(new a[] { new a(2131760613, 3), new a(2131760614, 1), new a(2131760616, 4) }));
    setTabViewAction((f)new d());
    AppMethodBeat.o(256105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.hometab.c
 * JD-Core Version:    0.7.0.1
 */