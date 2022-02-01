package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.component.r;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveLotteryCreateUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "mBackBtnListener", "Landroid/view/MenuItem$OnMenuItemClickListener;", "getForceOrientation", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-live_release"})
public final class FinderLiveLotteryCreateUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  private final MenuItem.OnMenuItemClickListener xPo;
  
  public FinderLiveLotteryCreateUI()
  {
    AppMethodBeat.i(233217);
    this.xPo = ((MenuItem.OnMenuItemClickListener)new a(this));
    AppMethodBeat.o(233217);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233220);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233220);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233219);
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
    AppMethodBeat.o(233219);
    return localView1;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(233214);
    Set localSet = ak.setOf(r.class);
    AppMethodBeat.o(233214);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233212);
    super.onCreate(paramBundle);
    setMMTitle(b.j.finder_live_create_lottery);
    setBackBtn(this.xPo, b.i.icons_filled_close);
    AppMethodBeat.o(233212);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderLiveLotteryCreateUI paramFinderLiveLotteryCreateUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(232511);
      this.xPp.hideVKB();
      this.xPp.finish();
      AppMethodBeat.o(232511);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryCreateUI
 * JD-Core Version:    0.7.0.1
 */