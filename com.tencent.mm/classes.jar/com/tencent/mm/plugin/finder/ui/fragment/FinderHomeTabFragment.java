package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "tabType", "", "(I)V", "title", "(II)V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "getTabType", "()I", "setTabType", "getTitle", "setTitle", "onActionbarClick", "", "onActionbarDoubleClick", "onBackPressed", "", "onUserVisibleUnFocused", "plugin-finder_release"})
public abstract class FinderHomeTabFragment
  extends UIComponentFragment
{
  public Bundle Ew;
  private HashMap _$_findViewCache;
  public int dLS;
  public int title;
  
  public FinderHomeTabFragment()
  {
    this.title = -1;
    this.dLS = -1;
  }
  
  public FinderHomeTabFragment(byte paramByte)
  {
    this.title = -1;
    this.dLS = 106;
  }
  
  public FinderHomeTabFragment(int paramInt1, int paramInt2)
  {
    this.title = paramInt1;
    this.dLS = paramInt2;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public void dlm() {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public final void onUserVisibleUnFocused()
  {
    super.onUserVisibleUnFocused();
    this.Ew = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment
 * JD-Core Version:    0.7.0.1
 */