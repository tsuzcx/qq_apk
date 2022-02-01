package com.tencent.mm.plugin.finder;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.l;
import kotlin.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/FinderLocationUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "plugin-finder_release"})
public final class FinderLocationUI
  extends MMActivity
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(241827);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(241827);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(241826);
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
    AppMethodBeat.o(241826);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(178065);
    Throwable localThrowable = (Throwable)new n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(178065);
    throw localThrowable;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.FinderLocationUI
 * JD-Core Version:    0.7.0.1
 */