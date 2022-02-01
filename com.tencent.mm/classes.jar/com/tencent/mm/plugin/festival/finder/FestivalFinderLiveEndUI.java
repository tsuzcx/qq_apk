package com.tencent.mm.plugin.festival.finder;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import kotlin.l;

@a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveEndUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "plugin-appbrand-integration_release"})
public final class FestivalFinderLiveEndUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(229774);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(229774);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(229773);
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
    AppMethodBeat.o(229773);
    return localView1;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.finder.FestivalFinderLiveEndUI
 * JD-Core Version:    0.7.0.1
 */