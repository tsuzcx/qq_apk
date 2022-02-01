package com.tencent.mm.plugin.finder.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.UIComponentFragment.b;
import d.a.j;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/util/List;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "lastIndex", "", "lastType", "onPageScrollStateChanged", "", "position", "onPageScrolled", "p0", "p1", "", "p2", "onPageSelected", "Companion", "plugin-finder_release"})
public abstract class FinderFragmentChangeObserver
  implements ViewPager.OnPageChangeListener, f
{
  public static final FinderFragmentChangeObserver.a Companion = new FinderFragmentChangeObserver.a((byte)0);
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
    ac.i("Finder.FragmentChangeObserver", "onPageSelected=" + paramInt + " lastIndex=" + this.lastIndex);
    Object localObject1;
    Object localObject2;
    if (this.lastIndex != paramInt)
    {
      Iterator localIterator = ((Iterable)this.fragments).iterator();
      int i = 0;
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.fOc();
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
            ((FinderHomeTabFragment)localObject2).cFW();
            a(false, i, (FinderHomeTabFragment)localObject2);
          }
          i = j;
        }
      }
      D(this.lastIndex, paramInt, this.lastType, ((FinderHomeTabFragment)this.fragments.get(paramInt)).diw);
      if (localObject1 != null) {
        if (localObject1.Isd != 1)
        {
          localObject2 = (Runnable)new UIComponentFragment.b(localObject1);
          if (localObject1.isResumed()) {
            break label260;
          }
          ac.w("MicroMsg.UIComponentFragment", "[onUserVisibleFocused] wait to fragment resume.");
          localObject1.Isf.add(localObject2);
        }
      }
    }
    for (;;)
    {
      localObject1.Isd = 1;
      a(true, paramInt, localObject1);
      this.lastIndex = paramInt;
      this.lastType = ((FinderHomeTabFragment)this.fragments.get(paramInt)).diw;
      return;
      label260:
      ((Runnable)localObject2).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver
 * JD-Core Version:    0.7.0.1
 */