package com.tencent.mm.plugin.finder.activity.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityContentUIC;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/fragment/FinderActivityFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "isFirst", "", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onUserVisibleFocused", "plugin-finder_release"})
public final class FinderActivityFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  private boolean isFirst = true;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(288404);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(288404);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(288399);
    Set localSet = ak.setOf(new Class[] { aj.class, FinderActivityContentUIC.class });
    AppMethodBeat.o(288399);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288401);
    super.onCreate(paramBundle);
    if (this.fEH == 1)
    {
      paramBundle = g.Xox;
      ((aj)g.h((Fragment)this).i(aj.class)).BmU = true;
    }
    AppMethodBeat.o(288401);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(288402);
    super.onResume();
    AppMethodBeat.o(288402);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(288403);
    if (this.isFirst)
    {
      if (this.fEH == 1)
      {
        g localg = g.Xox;
        ((aj)g.h((Fragment)this).i(aj.class)).BmU = false;
      }
      this.isFirst = false;
    }
    super.onUserVisibleFocused();
    AppMethodBeat.o(288403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment
 * JD-Core Version:    0.7.0.1
 */