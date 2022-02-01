package com.tencent.mm.plugin.finder.nearby.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/base/FragmentPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "fragments", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "getCount", "", "getItem", "position", "plugin-finder-nearby_release"})
public final class c
  extends g
{
  private final List<Fragment> fragments;
  
  public c(e parame, List<? extends Fragment> paramList)
  {
    super(parame);
    AppMethodBeat.i(203372);
    this.fragments = paramList;
    AppMethodBeat.o(203372);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(203370);
    int i = this.fragments.size();
    AppMethodBeat.o(203370);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(203368);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(203368);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.c
 * JD-Core Version:    0.7.0.1
 */