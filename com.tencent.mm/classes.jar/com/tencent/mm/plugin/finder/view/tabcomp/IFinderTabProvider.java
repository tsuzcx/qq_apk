package com.tencent.mm.plugin.finder.view.tabcomp;

import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "isDynamic", "", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "plugin-finder_release"})
public abstract interface IFinderTabProvider
{
  public abstract List<FinderHomeTabFragment> fragments();
  
  public abstract boolean isDynamic();
  
  public abstract g tabContainer();
  
  public abstract f tabViewAction();
  
  public abstract List<a> tabs();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
 * JD-Core Version:    0.7.0.1
 */