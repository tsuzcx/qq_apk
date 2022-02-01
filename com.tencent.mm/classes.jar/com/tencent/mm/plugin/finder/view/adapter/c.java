package com.tencent.mm.plugin.finder.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "fragments", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "getCount", "", "getItem", "position", "plugin-finder_release"})
public final class c
  extends g
{
  private final List<Fragment> fragments;
  
  public c(e parame, List<? extends Fragment> paramList)
  {
    super(parame);
    AppMethodBeat.i(285700);
    this.fragments = paramList;
    AppMethodBeat.o(285700);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(285699);
    int i = this.fragments.size();
    AppMethodBeat.o(285699);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(285698);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(285698);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.c
 * JD-Core Version:    0.7.0.1
 */