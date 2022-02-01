package com.tencent.mm.plugin.finder.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/util/List;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "lastIndex", "", "lastType", "onPageScrollStateChanged", "", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "Companion", "plugin-finder_release"})
public abstract class FinderFragmentChangeObserver
  implements ViewPager.OnPageChangeListener, h
{
  public static final a Companion = new a((byte)0);
  public static final String TAG = "Finder.FragmentChangeObserver";
  private final MMActivity activity;
  private final List<FinderHomeTabFragment> fragments;
  private int lastIndex;
  private int lastType;
  
  public FinderFragmentChangeObserver(MMActivity paramMMActivity, List<? extends FinderHomeTabFragment> paramList)
  {
    this.activity = paramMMActivity;
    this.fragments = paramList;
    this.lastIndex = -1;
    this.lastType = -1;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < this.fragments.size()))
    {
      localObject1 = ((FinderHomeTabFragment)this.fragments.get(paramInt)).getClass().getName();
      p.g(localObject1, "fragments[position].javaClass.name");
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEs = (String)localObject1;
    }
    if (this.lastIndex != paramInt)
    {
      Iterator localIterator = ((Iterable)this.fragments).iterator();
      int i = 0;
      localObject1 = null;
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.hxH();
        }
        localObject2 = (FinderHomeTabFragment)localObject2;
        if (paramInt == i)
        {
          i = j;
          localObject1 = localObject2;
        }
        else
        {
          if (this.lastIndex == i)
          {
            ((FinderHomeTabFragment)localObject2).onUserVisibleUnFocused();
            a(false, i, (FinderHomeTabFragment)localObject2);
          }
          i = j;
        }
      }
      D(this.lastIndex, paramInt, this.lastType, ((FinderHomeTabFragment)this.fragments.get(paramInt)).dLS);
      if (localObject1 != null)
      {
        ((FinderHomeTabFragment)localObject1).onUserVisibleFocused();
        a(true, paramInt, (FinderHomeTabFragment)localObject1);
      }
    }
    this.lastIndex = paramInt;
    this.lastType = ((FinderHomeTabFragment)this.fragments.get(paramInt)).dLS;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver
 * JD-Core Version:    0.7.0.1
 */