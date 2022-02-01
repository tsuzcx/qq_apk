package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineLbsUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderTimelineLbsUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245566);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245566);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245565);
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
    AppMethodBeat.o(245565);
    return localView1;
  }
  
  public final int ddN()
  {
    AppMethodBeat.i(245562);
    c localc = c.vCb;
    if (((Number)c.dst().value()).intValue() == 1)
    {
      AppMethodBeat.o(245562);
      return 3;
    }
    AppMethodBeat.o(245562);
    return 5;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(245561);
    c localc = c.vCb;
    if (((Number)c.dst().value()).intValue() == 1)
    {
      AppMethodBeat.o(245561);
      return 15;
    }
    AppMethodBeat.o(245561);
    return 34;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245560);
    Set localSet = ak.setOf(FinderTimelineLbsUIC.class);
    AppMethodBeat.o(245560);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245559);
    super.onCreate(paramBundle);
    setMMTitle(2131760615);
    paramBundle = g.ah(PluginFinder.class);
    p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().asV("finder_tl_nearby_tab");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    setTitleBarClickListener((Runnable)new b(this), (Runnable)new c(this));
    AppMethodBeat.o(245559);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderTimelineLbsUI paramFinderTimelineLbsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245556);
      this.uda.finish();
      AppMethodBeat.o(245556);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderTimelineLbsUI paramFinderTimelineLbsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(245557);
      FinderTimelineLbsUI.a(this.uda);
      AppMethodBeat.o(245557);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderTimelineLbsUI paramFinderTimelineLbsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(245558);
      FinderTimelineLbsUI.b(this.uda);
      AppMethodBeat.o(245558);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI
 * JD-Core Version:    0.7.0.1
 */