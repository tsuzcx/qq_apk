package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "tabType", "", "(I)V", "title", "(II)V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "getTabType", "()I", "setTabType", "getTitle", "setTitle", "onActionbarClick", "", "onActionbarDoubleClick", "onBackPressed", "", "onUserVisibleUnFocused", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderHomeTabFragment
  extends MMFinderFragment
{
  public Bundle EHy;
  public int hJx;
  public int title;
  
  public FinderHomeTabFragment()
  {
    this.title = -1;
    this.hJx = -1;
  }
  
  public FinderHomeTabFragment(int paramInt)
  {
    this.title = -1;
    this.hJx = paramInt;
  }
  
  public FinderHomeTabFragment(int paramInt1, int paramInt2)
  {
    this.title = paramInt1;
    this.hJx = paramInt2;
  }
  
  public void eEr() {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public final void onUserVisibleUnFocused()
  {
    super.onUserVisibleUnFocused();
    this.EHy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment
 * JD-Core Version:    0.7.0.1
 */