package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.a;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationTempUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "finish", "", "getLayoutId", "", "getTitleResId", "plugin-finder_release"})
public final class FinderConversationTempUI
  extends FinderConversationParentUI
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252216);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252216);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252215);
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
    AppMethodBeat.o(252215);
    return localView1;
  }
  
  public final int dzb()
  {
    return 2131759620;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(252214);
    super.finish();
    Object localObject = g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().tJB.das();
    localObject = g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().tJB;
    ((a)localObject).handler.removeMessages(9);
    ((a)localObject).handler.sendEmptyMessage(9);
    AppMethodBeat.o(252214);
  }
  
  public final int getLayoutId()
  {
    return 2131494231;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationTempUI
 * JD-Core Version:    0.7.0.1
 */