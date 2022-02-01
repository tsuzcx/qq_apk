package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import com.tencent.mm.ui.component.UIComponentFragment;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "title", "", "tabType", "(II)V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "getTabType", "()I", "getTitle", "onActionbarClick", "", "onActionbarDoubleClick", "onUserVisibleUnFocused", "plugin-finder_release"})
public abstract class FinderHomeTabFragment
  extends UIComponentFragment
{
  public Bundle En;
  private HashMap _$_findViewCache;
  public final int duh;
  public final int title;
  
  public FinderHomeTabFragment(int paramInt1, int paramInt2)
  {
    this.title = paramInt1;
    this.duh = paramInt2;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public final void cKA()
  {
    super.cKA();
    this.En = null;
  }
  
  public void cKz() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment
 * JD-Core Version:    0.7.0.1
 */