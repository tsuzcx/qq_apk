package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.mm.ui.component.UIComponentFragment;
import d.l;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "title", "", "tabType", "(II)V", "getTabType", "()I", "getTitle", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public abstract class FinderHomeTabFragment
  extends UIComponentFragment
{
  public final int IoU;
  private HashMap _$_findViewCache;
  public final int title;
  
  public FinderHomeTabFragment(int paramInt1, int paramInt2)
  {
    this.title = paramInt1;
    this.IoU = paramInt2;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public void fVI() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment
 * JD-Core Version:    0.7.0.1
 */