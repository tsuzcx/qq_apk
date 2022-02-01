package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderMultiTaskUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI;", "()V", "Companion", "plugin-finder_release"})
public final class FinderMultiTaskUI
  extends FinderFloatBallDetailUI
{
  public static final a xQL;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(235552);
    xQL = new a((byte)0);
    AppMethodBeat.o(235552);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(235557);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(235557);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(235555);
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
    AppMethodBeat.o(235555);
    return localView1;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderMultiTaskUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderMultiTaskUI
 * JD-Core Version:    0.7.0.1
 */