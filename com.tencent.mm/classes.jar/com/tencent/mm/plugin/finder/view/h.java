package com.tencent.mm.plugin.finder.view;

import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
{
  public abstract void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment);
  
  public abstract void onPageScrollStateChanged(int paramInt);
  
  public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.h
 * JD-Core Version:    0.7.0.1
 */