package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.a;
import com.tencent.mm.plugin.finder.extension.reddot.e;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationTempUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "getLayoutId", "", "getTitleResId", "onDestroy", "", "plugin-finder_release"})
public final class FinderConversationTempUI
  extends FinderConversationParentUI
{
  private HashMap _$_findViewCache;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204531);
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
    AppMethodBeat.o(204531);
    return localView1;
  }
  
  public final int cMd()
  {
    return 2131766545;
  }
  
  public final int getLayoutId()
  {
    return 2131496390;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204530);
    super.onDestroy();
    Object localObject = g.ad(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().sax.cBh();
    localObject = g.ad(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().sax;
    ((a)localObject).handler.removeMessages(9);
    ((a)localObject).handler.sendEmptyMessage(9);
    AppMethodBeat.o(204530);
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