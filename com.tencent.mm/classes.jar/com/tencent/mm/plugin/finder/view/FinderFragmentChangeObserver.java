package com.tencent.mm.plugin.finder.view;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import d.a.j;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/util/List;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "lastIndex", "", "lastType", "onPageScrollStateChanged", "", "position", "onPageScrolled", "p0", "p1", "", "p2", "onPageSelected", "Companion", "plugin-finder_release"})
public abstract class FinderFragmentChangeObserver
  implements ViewPager.OnPageChangeListener, g
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
  
  public void onPageSelected(final int paramInt)
  {
    ad.i("Finder.FragmentChangeObserver", "onPageSelected=" + paramInt + " lastIndex=" + this.lastIndex);
    if (this.lastIndex != paramInt)
    {
      ((FinderViewPager)((FragmentActivity)this.activity).findViewById(2131307918)).post((Runnable)new b(this, paramInt));
      X(this.lastIndex, paramInt, this.lastType, ((FinderHomeTabFragment)this.fragments.get(paramInt)).IoU);
    }
    this.lastIndex = paramInt;
    this.lastType = ((FinderHomeTabFragment)this.fragments.get(paramInt)).IoU;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderFragmentChangeObserver paramFinderFragmentChangeObserver, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(200106);
      Iterator localIterator1 = ((Iterable)FinderFragmentChangeObserver.a(this.Lfa)).iterator();
      int i = 0;
      Object localObject1 = null;
      while (localIterator1.hasNext())
      {
        Object localObject2 = localIterator1.next();
        int j = i + 1;
        if (i < 0) {
          j.fvx();
        }
        localObject2 = (FinderHomeTabFragment)localObject2;
        if (paramInt == i)
        {
          i = j;
          localObject1 = localObject2;
        }
        else
        {
          if (((UIComponentFragment)localObject2).LDc != 2)
          {
            ad.i("MicroMsg.UIComponentFragment", "[onViewUnFocused] " + localObject2.getClass().getSimpleName() + '@' + ((UIComponentFragment)localObject2).hashCode());
            Iterator localIterator2 = ((Iterable)((UIComponentFragment)localObject2).uiComponents).iterator();
            while (localIterator2.hasNext()) {
              ((UIComponent)localIterator2.next()).fXn();
            }
            ((UIComponentFragment)localObject2).LDc = 2;
          }
          this.Lfa.a(false, i, (FinderHomeTabFragment)localObject2);
          i = j;
        }
      }
      if (localObject1 != null)
      {
        localObject1.fTo();
        this.Lfa.a(true, paramInt, localObject1);
        AppMethodBeat.o(200106);
        return;
      }
      AppMethodBeat.o(200106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver
 * JD-Core Version:    0.7.0.1
 */