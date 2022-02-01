package com.tencent.mm.plugin.finder.view.tabcomp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.sample.FinderSampleTabUI.FinderSampleTabFragment;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "()V", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getFragments", "()Ljava/util/List;", "setFragments", "(Ljava/util/List;)V", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "getTabContainer", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "setTabContainer", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;)V", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "getTabViewAction", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "setTabViewAction", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;)V", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "getTabs", "setTabs", "plugin-finder_release"})
public class FinderTabProvider
  implements IFinderTabProvider
{
  private List<? extends FinderHomeTabFragment> fragments;
  private g tabContainer;
  private f tabViewAction;
  private List<? extends a> tabs;
  
  public FinderTabProvider()
  {
    AppMethodBeat.i(240900);
    Object localObject1 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject1).title = 101;
    localObject1 = (FinderHomeTabFragment)localObject1;
    Object localObject2 = new FinderSampleTabUI.FinderSampleTabFragment();
    ((FinderHomeTabFragment)localObject2).title = 102;
    localObject2 = (FinderHomeTabFragment)localObject2;
    FinderSampleTabUI.FinderSampleTabFragment localFinderSampleTabFragment = new FinderSampleTabUI.FinderSampleTabFragment();
    localFinderSampleTabFragment.title = 103;
    this.fragments = ((List)j.ag(new FinderHomeTabFragment[] { localObject1, localObject2, (FinderHomeTabFragment)localFinderSampleTabFragment }));
    this.tabContainer = ((g)new d());
    this.tabs = ((List)j.ag(new c[] { new c("喜欢"), new c("点赞"), new c("提到") }));
    this.tabViewAction = ((f)new e());
    AppMethodBeat.o(240900);
  }
  
  public List<FinderHomeTabFragment> fragments()
  {
    return this.fragments;
  }
  
  public final List<FinderHomeTabFragment> getFragments()
  {
    return this.fragments;
  }
  
  public final g getTabContainer()
  {
    return this.tabContainer;
  }
  
  public final f getTabViewAction()
  {
    return this.tabViewAction;
  }
  
  public final List<a> getTabs()
  {
    return this.tabs;
  }
  
  public boolean isDynamic()
  {
    return false;
  }
  
  public final void setFragments(List<? extends FinderHomeTabFragment> paramList)
  {
    AppMethodBeat.i(240877);
    p.k(paramList, "<set-?>");
    this.fragments = paramList;
    AppMethodBeat.o(240877);
  }
  
  public final void setTabContainer(g paramg)
  {
    AppMethodBeat.i(240880);
    p.k(paramg, "<set-?>");
    this.tabContainer = paramg;
    AppMethodBeat.o(240880);
  }
  
  public final void setTabViewAction(f paramf)
  {
    AppMethodBeat.i(240887);
    p.k(paramf, "<set-?>");
    this.tabViewAction = paramf;
    AppMethodBeat.o(240887);
  }
  
  public final void setTabs(List<? extends a> paramList)
  {
    AppMethodBeat.i(240884);
    p.k(paramList, "<set-?>");
    this.tabs = paramList;
    AppMethodBeat.o(240884);
  }
  
  public g tabContainer()
  {
    return this.tabContainer;
  }
  
  public f tabViewAction()
  {
    return this.tabViewAction;
  }
  
  public List<a> tabs()
  {
    return this.tabs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider
 * JD-Core Version:    0.7.0.1
 */