package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.x;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineLbsLiveFriendsUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getReportType", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderTimelineLbsLiveFriendsUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245555);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245555);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245554);
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
    AppMethodBeat.o(245554);
    return localView1;
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return (Set)x.SXt;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245553);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    setTitleBarClickListener((Runnable)new b(this), (Runnable)new c(this));
    AppMethodBeat.o(245553);
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
    a(FinderTimelineLbsLiveFriendsUI paramFinderTimelineLbsLiveFriendsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245550);
      this.ucZ.finish();
      AppMethodBeat.o(245550);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderTimelineLbsLiveFriendsUI paramFinderTimelineLbsLiveFriendsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(245551);
      FinderTimelineLbsLiveFriendsUI.der();
      AppMethodBeat.o(245551);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderTimelineLbsLiveFriendsUI paramFinderTimelineLbsLiveFriendsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(245552);
      FinderTimelineLbsLiveFriendsUI.des();
      AppMethodBeat.o(245552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsLiveFriendsUI
 * JD-Core Version:    0.7.0.1
 */