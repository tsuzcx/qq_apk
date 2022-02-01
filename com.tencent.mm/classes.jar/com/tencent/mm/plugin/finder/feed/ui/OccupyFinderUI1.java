package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorAllLotteryHistoryUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveSingleLotteryHistoryUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI1;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI1
  extends MMFinderUI
{
  public static final a udI;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(245614);
    udI = new a((byte)0);
    AppMethodBeat.o(245614);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245616);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245616);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245615);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(245615);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245613);
    if (getIntent().getBooleanExtra("KEY_IS_FROM_SETTING", false))
    {
      localSet = ak.setOf(FinderLiveAnchorAllLotteryHistoryUIC.class);
      AppMethodBeat.o(245613);
      return localSet;
    }
    Set localSet = ak.setOf(FinderLiveSingleLotteryHistoryUIC.class);
    AppMethodBeat.o(245613);
    return localSet;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI1$Companion;", "", "()V", "KEY_IS_FROM_SETTING", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI1
 * JD-Core Version:    0.7.0.1
 */