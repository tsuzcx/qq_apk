package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$initViewPager$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTabUIC$d
  extends FinderFragmentChangeObserver
{
  FinderTabUIC$d(FinderTabUIC paramFinderTabUIC, AppCompatActivity paramAppCompatActivity, List<? extends FinderHomeTabFragment> paramList)
  {
    super((MMActivity)paramAppCompatActivity, paramList);
    AppMethodBeat.i(337715);
    AppMethodBeat.o(337715);
  }
  
  public final void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(337735);
    Log.i("Finder.FragmentChangeObserver", "to :" + paramInt2 + " lastIndex:" + this.GVq.lastIndex);
    this.GVq.lastIndex = paramInt2;
    FinderTabUIC.a(this.GVq, paramInt2);
    Iterator localIterator = ((Iterable)this.GVq.GRB).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).N(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(337735);
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(337726);
    s.u(paramFinderHomeTabFragment, "fragment");
    Iterator localIterator = ((Iterable)this.GVq.GRB).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
    }
    AppMethodBeat.o(337726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC.d
 * JD-Core Version:    0.7.0.1
 */