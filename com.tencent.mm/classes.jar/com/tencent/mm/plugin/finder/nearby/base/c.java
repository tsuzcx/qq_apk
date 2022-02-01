package com.tencent.mm.plugin.finder.nearby.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/base/FragmentPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "fragments", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "getCount", "", "getItem", "position", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends m
{
  private final List<Fragment> fragments;
  
  public c(FragmentManager paramFragmentManager, List<? extends Fragment> paramList)
  {
    super(paramFragmentManager);
    AppMethodBeat.i(339679);
    this.fragments = paramList;
    AppMethodBeat.o(339679);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(339686);
    int i = this.fragments.size();
    AppMethodBeat.o(339686);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(339681);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(339681);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.c
 * JD-Core Version:    0.7.0.1
 */