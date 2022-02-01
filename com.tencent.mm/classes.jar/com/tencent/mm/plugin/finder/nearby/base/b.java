package com.tencent.mm.plugin.finder.nearby.base;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragments", "", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/util/List;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "lastIndex", "", "lastType", "onPageScrollStateChanged", "", "position", "onPageScrolled", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  implements ViewPager.OnPageChangeListener, a
{
  public static final a EHA = new a((byte)0);
  private final MMActivity activity;
  private final List<AbsNearByFragment> fragments;
  private int lastIndex;
  private int lastType;
  
  public b(MMActivity paramMMActivity, List<? extends AbsNearByFragment> paramList)
  {
    this.activity = paramMMActivity;
    this.fragments = paramList;
    this.lastIndex = -1;
    this.lastType = -1;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Log.i("Finder.FragmentChangeObserver", s.X("onPageScrollStateChanged position:", Integer.valueOf(paramInt)));
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.lastIndex != paramInt)
    {
      Object localObject1 = (Iterable)this.fragments;
      int i = 0;
      Iterator localIterator = ((Iterable)localObject1).iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        localObject2 = (AbsNearByFragment)localObject2;
        if (paramInt == i)
        {
          i = j;
          localObject1 = localObject2;
        }
        else
        {
          if (this.lastIndex == i)
          {
            ((AbsNearByFragment)localObject2).onUserVisibleUnFocused();
            a((AbsNearByFragment)localObject2);
          }
          i = j;
        }
      }
      N(this.lastIndex, paramInt, this.lastType, ((AbsNearByFragment)this.fragments.get(paramInt)).hJx);
      if (localObject1 != null)
      {
        ((AbsNearByFragment)localObject1).onUserVisibleFocused();
        a((AbsNearByFragment)localObject1);
      }
    }
    this.lastIndex = paramInt;
    this.lastType = ((AbsNearByFragment)this.fragments.get(paramInt)).hJx;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.b
 * JD-Core Version:    0.7.0.1
 */