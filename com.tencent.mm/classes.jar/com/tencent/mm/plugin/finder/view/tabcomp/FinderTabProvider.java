package com.tencent.mm.plugin.finder.view.tabcomp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.sample.FinderSampleTabUI.FinderSampleTabFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "()V", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/List;", "setFragments", "(Ljava/util/List;)V", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "getTabContainer", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "setTabContainer", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;)V", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "getTabViewAction", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "setTabViewAction", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;)V", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "getTabs", "setTabs", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderTabProvider
  implements IFinderTabProvider
{
  public List<? extends FinderHomeTabFragment> fragments;
  private n tabContainer;
  private m tabViewAction;
  private List<? extends g> tabs;
  
  public FinderTabProvider()
  {
    AppMethodBeat.i(345595);
    Object localObject1 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject1).title = 101;
    Object localObject2 = ah.aiuX;
    localObject1 = (FinderHomeTabFragment)localObject1;
    localObject2 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject2).title = 102;
    Object localObject3 = ah.aiuX;
    localObject2 = (FinderHomeTabFragment)localObject2;
    localObject3 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject3).title = 103;
    ah localah = ah.aiuX;
    this.fragments = ((List)p.al(new FinderHomeTabFragment[] { localObject1, localObject2, (FinderHomeTabFragment)localObject3 }));
    this.tabContainer = ((n)new j());
    this.tabs = ((List)p.al(new i[] { new i("喜欢"), new i("点赞"), new i("提到") }));
    this.tabViewAction = ((m)new l());
    AppMethodBeat.o(345595);
  }
  
  public List<FinderHomeTabFragment> fragments()
  {
    return this.fragments;
  }
  
  public final List<FinderHomeTabFragment> getFragments()
  {
    return this.fragments;
  }
  
  public final n getTabContainer()
  {
    return this.tabContainer;
  }
  
  public final m getTabViewAction()
  {
    return this.tabViewAction;
  }
  
  public final List<g> getTabs()
  {
    return this.tabs;
  }
  
  public boolean isDynamic()
  {
    AppMethodBeat.i(345670);
    s.u(this, "this");
    AppMethodBeat.o(345670);
    return false;
  }
  
  public final void setFragments(List<? extends FinderHomeTabFragment> paramList)
  {
    AppMethodBeat.i(345606);
    s.u(paramList, "<set-?>");
    this.fragments = paramList;
    AppMethodBeat.o(345606);
  }
  
  public final void setTabContainer(n paramn)
  {
    AppMethodBeat.i(345620);
    s.u(paramn, "<set-?>");
    this.tabContainer = paramn;
    AppMethodBeat.o(345620);
  }
  
  public final void setTabViewAction(m paramm)
  {
    AppMethodBeat.i(345643);
    s.u(paramm, "<set-?>");
    this.tabViewAction = paramm;
    AppMethodBeat.o(345643);
  }
  
  public final void setTabs(List<? extends g> paramList)
  {
    AppMethodBeat.i(345630);
    s.u(paramList, "<set-?>");
    this.tabs = paramList;
    AppMethodBeat.o(345630);
  }
  
  public n tabContainer()
  {
    return this.tabContainer;
  }
  
  public m tabViewAction()
  {
    return this.tabViewAction;
  }
  
  public List<g> tabs()
  {
    return this.tabs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider
 * JD-Core Version:    0.7.0.1
 */