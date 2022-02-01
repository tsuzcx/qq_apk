package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineLbsUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderTimelineLbsUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202505);
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
    AppMethodBeat.o(202505);
    return localView1;
  }
  
  public final int cuI()
  {
    AppMethodBeat.i(202502);
    b localb = b.rCU;
    if (b.czW())
    {
      AppMethodBeat.o(202502);
      return 15;
    }
    AppMethodBeat.o(202502);
    return 34;
  }
  
  public final int cvJ()
  {
    return 3;
  }
  
  public final Set<Class<? extends UIComponent>> cwg()
  {
    AppMethodBeat.i(202501);
    Set localSet = ak.setOf(FinderTimelineLbsUIC.class);
    AppMethodBeat.o(202501);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202500);
    super.onCreate(paramBundle);
    setMMTitle(2131766502);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    setTitleBarClickListener((Runnable)new b(this), (Runnable)new c(this));
    AppMethodBeat.o(202500);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderTimelineLbsUI paramFinderTimelineLbsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202497);
      this.rso.finish();
      AppMethodBeat.o(202497);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderTimelineLbsUI paramFinderTimelineLbsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(202498);
      FinderTimelineLbsUI.a(this.rso);
      AppMethodBeat.o(202498);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderTimelineLbsUI paramFinderTimelineLbsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(202499);
      FinderTimelineLbsUI.b(this.rso);
      AppMethodBeat.o(202499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI
 * JD-Core Version:    0.7.0.1
 */