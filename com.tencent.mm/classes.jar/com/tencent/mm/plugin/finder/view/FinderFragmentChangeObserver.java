package com.tencent.mm.plugin.finder.view;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/util/List;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "lastIndex", "", "lastType", "onPageScrollStateChanged", "", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      localObject1 = this.fragments.get(paramInt).getClass().getName();
      s.s(localObject1, "fragments[position].javaClass.name");
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGs = (String)localObject1;
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
          p.kkW();
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
      N(this.lastIndex, paramInt, this.lastType, ((FinderHomeTabFragment)this.fragments.get(paramInt)).hJx);
      if (localObject1 != null)
      {
        ((FinderHomeTabFragment)localObject1).onUserVisibleFocused();
        a(true, paramInt, (FinderHomeTabFragment)localObject1);
      }
    }
    this.lastIndex = paramInt;
    this.lastType = ((FinderHomeTabFragment)this.fragments.get(paramInt)).hJx;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver
 * JD-Core Version:    0.7.0.1
 */