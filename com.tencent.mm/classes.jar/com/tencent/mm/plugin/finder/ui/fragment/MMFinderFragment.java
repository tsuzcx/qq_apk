package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ae.d;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "enablePullDown", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "plugin-finder-base_release"})
public abstract class MMFinderFragment
  extends UIComponentFragment
{
  private HashMap _$_findViewCache;
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    p.k(paramLayoutInflater, "inflater");
    setRootView(super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
    return getRootView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    p.k(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    d.a(0L, (a)new a(this));
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(MMFinderFragment paramMMFinderFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment
 * JD-Core Version:    0.7.0.1
 */