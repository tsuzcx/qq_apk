package com.tencent.mm.plugin.finder.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "fragments", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "getCount", "", "getItem", "position", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends m
{
  private final List<Fragment> fragments;
  
  public c(FragmentManager paramFragmentManager, List<? extends Fragment> paramList)
  {
    super(paramFragmentManager);
    AppMethodBeat.i(345454);
    this.fragments = paramList;
    AppMethodBeat.o(345454);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(345464);
    int i = this.fragments.size();
    AppMethodBeat.o(345464);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(345458);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(345458);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.adapter.c
 * JD-Core Version:    0.7.0.1
 */