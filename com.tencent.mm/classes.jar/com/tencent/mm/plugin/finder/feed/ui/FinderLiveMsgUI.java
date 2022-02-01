package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.FinderLiveLotteryCreateUIC;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "mBackBtnListener", "Landroid/view/MenuItem$OnMenuItemClickListener;", "getForceOrientation", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderLiveMsgUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  private final MenuItem.OnMenuItemClickListener ubB;
  
  public FinderLiveMsgUI()
  {
    AppMethodBeat.i(245391);
    this.ubB = ((MenuItem.OnMenuItemClickListener)new a(this));
    AppMethodBeat.o(245391);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245393);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245393);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245392);
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
    AppMethodBeat.o(245392);
    return localView1;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245390);
    Set localSet = ak.setOf(FinderLiveLotteryCreateUIC.class);
    AppMethodBeat.o(245390);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245389);
    super.onCreate(paramBundle);
    setMMTitle(2131759912);
    setBackBtn(this.ubB, 2131690514);
    AppMethodBeat.o(245389);
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
    a(FinderLiveMsgUI paramFinderLiveMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245388);
      this.ubC.hideVKB();
      this.ubC.finish();
      AppMethodBeat.o(245388);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveMsgUI
 * JD-Core Version:    0.7.0.1
 */