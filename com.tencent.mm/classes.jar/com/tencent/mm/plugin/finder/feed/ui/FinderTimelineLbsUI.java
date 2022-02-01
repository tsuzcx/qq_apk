package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineLbsUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderTimelineLbsUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202886);
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
    AppMethodBeat.o(202886);
    return localView1;
  }
  
  public final int cAZ()
  {
    AppMethodBeat.i(202883);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGO().value()).intValue() == 1)
    {
      AppMethodBeat.o(202883);
      return 15;
    }
    AppMethodBeat.o(202883);
    return 34;
  }
  
  public final int cBZ()
  {
    return 3;
  }
  
  public final Set<Class<? extends UIComponent>> cCu()
  {
    AppMethodBeat.i(202882);
    Set localSet = ak.setOf(FinderTimelineLbsUIC.class);
    AppMethodBeat.o(202882);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202881);
    super.onCreate(paramBundle);
    setMMTitle(2131766502);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    setTitleBarClickListener((Runnable)new b(this), (Runnable)new c(this));
    AppMethodBeat.o(202881);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderTimelineLbsUI paramFinderTimelineLbsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202878);
      this.shw.finish();
      AppMethodBeat.o(202878);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderTimelineLbsUI paramFinderTimelineLbsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(202879);
      FinderTimelineLbsUI.a(this.shw);
      AppMethodBeat.o(202879);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderTimelineLbsUI paramFinderTimelineLbsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(202880);
      FinderTimelineLbsUI.b(this.shw);
      AppMethodBeat.o(202880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI
 * JD-Core Version:    0.7.0.1
 */