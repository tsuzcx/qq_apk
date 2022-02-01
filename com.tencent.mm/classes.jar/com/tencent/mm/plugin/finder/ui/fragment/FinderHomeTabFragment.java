package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import java.util.HashMap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "tabType", "", "(I)V", "title", "(II)V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "getTabType", "()I", "setTabType", "getTitle", "setTitle", "onActionbarClick", "", "onActionbarDoubleClick", "onBackPressed", "", "onUserVisibleUnFocused", "plugin-finder_release"})
public abstract class FinderHomeTabFragment
  extends MMFinderFragment
{
  private HashMap _$_findViewCache;
  public int fEH;
  public int title;
  public Bundle zDr;
  
  public FinderHomeTabFragment()
  {
    this.title = -1;
    this.fEH = -1;
  }
  
  public FinderHomeTabFragment(int paramInt)
  {
    this.title = -1;
    this.fEH = paramInt;
  }
  
  public FinderHomeTabFragment(int paramInt1, int paramInt2)
  {
    this.title = paramInt1;
    this.fEH = paramInt2;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public void dLu() {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public final void onUserVisibleUnFocused()
  {
    super.onUserVisibleUnFocused();
    this.zDr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment
 * JD-Core Version:    0.7.0.1
 */