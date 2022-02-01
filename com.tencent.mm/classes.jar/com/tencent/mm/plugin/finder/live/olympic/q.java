package com.tencent.mm.plugin.finder.live.olympic;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/RunnerFragmentAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "fragments", "", "Landroidx/fragment/app/Fragment;", "titles", "", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;Ljava/util/List;)V", "getCount", "", "getItem", "position", "getPageTitle", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends m
{
  private final List<String> CPc;
  private final List<Fragment> fragments;
  
  public q(FragmentManager paramFragmentManager, List<? extends Fragment> paramList, List<String> paramList1)
  {
    super(paramFragmentManager);
    AppMethodBeat.i(360419);
    this.fragments = paramList;
    this.CPc = paramList1;
    AppMethodBeat.o(360419);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(360432);
    int i = this.fragments.size();
    AppMethodBeat.o(360432);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(360437);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(360437);
    return localFragment;
  }
  
  public final CharSequence getPageTitle(int paramInt)
  {
    AppMethodBeat.i(360426);
    CharSequence localCharSequence = (CharSequence)this.CPc.get(paramInt);
    AppMethodBeat.o(360426);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.q
 * JD-Core Version:    0.7.0.1
 */