package com.tencent.mm.plugin.finder.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "Landroid/support/v4/app/FragmentPagerAdapter;", "fm", "Landroid/support/v4/app/FragmentManager;", "fragments", "", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/FragmentManager;Ljava/util/List;)V", "getCount", "", "getItem", "position", "plugin-finder_release"})
public final class a
  extends i
{
  private final List<Fragment> fragments;
  
  public a(g paramg, List<? extends Fragment> paramList)
  {
    super(paramg);
    AppMethodBeat.i(205310);
    this.fragments = paramList;
    AppMethodBeat.o(205310);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(205309);
    int i = this.fragments.size();
    AppMethodBeat.o(205309);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(205308);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(205308);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.a
 * JD-Core Version:    0.7.0.1
 */