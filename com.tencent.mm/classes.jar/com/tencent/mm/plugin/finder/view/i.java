package com.tencent.mm.plugin.finder.view;

import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
public abstract interface i
{
  public abstract void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment);
  
  public abstract void onPageScrollStateChanged(int paramInt);
  
  public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.i
 * JD-Core Version:    0.7.0.1
 */