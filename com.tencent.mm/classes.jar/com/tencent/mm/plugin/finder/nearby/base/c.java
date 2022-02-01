package com.tencent.mm.plugin.finder.nearby.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/base/FragmentPagerAdapter;", "Landroid/support/v4/app/FragmentPagerAdapter;", "fm", "Landroid/support/v4/app/FragmentManager;", "fragments", "", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/FragmentManager;Ljava/util/List;)V", "getCount", "", "getItem", "position", "plugin-finder_release"})
public final class c
  extends i
{
  private final List<Fragment> fragments;
  
  public c(g paramg, List<? extends Fragment> paramList)
  {
    super(paramg);
    AppMethodBeat.i(249013);
    this.fragments = paramList;
    AppMethodBeat.o(249013);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(249012);
    int i = this.fragments.size();
    AppMethodBeat.o(249012);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(249011);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(249011);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.c
 * JD-Core Version:    0.7.0.1
 */