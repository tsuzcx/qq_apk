package com.tencent.mm.plugin.finder.view.tabcomp;

import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "isDynamic", "", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface IFinderTabProvider
{
  public abstract List<FinderHomeTabFragment> fragments();
  
  public abstract boolean isDynamic();
  
  public abstract n tabContainer();
  
  public abstract m tabViewAction();
  
  public abstract List<g> tabs();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
 * JD-Core Version:    0.7.0.1
 */