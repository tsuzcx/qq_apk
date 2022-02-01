package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.a;
import com.tencent.mm.plugin.finder.extension.reddot.e;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationTempUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "getLayoutId", "", "getTitleResId", "onDestroy", "", "plugin-finder_release"})
public final class FinderConversationTempUI
  extends FinderConversationParentUI
{
  private HashMap _$_findViewCache;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203935);
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
    AppMethodBeat.o(203935);
    return localView1;
  }
  
  public final int cJA()
  {
    return 2131766545;
  }
  
  public final int getLayoutId()
  {
    return 2131496390;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203934);
    super.onDestroy();
    Object localObject = g.ad(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().rRV.czD();
    localObject = g.ad(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().rRV;
    ((a)localObject).handler.removeMessages(9);
    ((a)localObject).handler.sendEmptyMessage(9);
    AppMethodBeat.o(203934);
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