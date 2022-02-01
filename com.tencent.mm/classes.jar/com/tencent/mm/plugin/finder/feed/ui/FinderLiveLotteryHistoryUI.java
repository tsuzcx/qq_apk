package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.component.a;
import com.tencent.mm.plugin.finder.live.viewmodel.component.e;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveLotteryHistoryUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-finder-live_release"})
public final class FinderLiveLotteryHistoryUI
  extends MMFinderUI
{
  public static final a xPq;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(233601);
    xPq = new a((byte)0);
    AppMethodBeat.o(233601);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233604);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233604);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233602);
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
    AppMethodBeat.o(233602);
    return localView1;
  }
  
  public final String dvl()
  {
    return "FinderLiveLotteryHistoryUI";
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(233597);
    if (getIntent().getBooleanExtra("KEY_IS_FROM_SETTING", false))
    {
      localSet = ak.setOf(a.class);
      AppMethodBeat.o(233597);
      return localSet;
    }
    Set localSet = ak.setOf(e.class);
    AppMethodBeat.o(233597);
    return localSet;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveLotteryHistoryUI$Companion;", "", "()V", "KEY_IS_FROM_SETTING", "", "plugin-finder-live_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryHistoryUI
 * JD-Core Version:    0.7.0.1
 */