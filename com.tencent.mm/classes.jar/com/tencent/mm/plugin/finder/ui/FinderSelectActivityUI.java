package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.ak.a;
import com.tencent.mm.plugin.finder.feed.ak.b;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectActivityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "selectPresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "getLayoutId", "", "initContentView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderSelectActivityUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  private ak.b xBc;
  private final ak.a zQw;
  
  public FinderSelectActivityUI()
  {
    AppMethodBeat.i(290723);
    this.zQw = new ak.a();
    AppMethodBeat.o(290723);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(290725);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(290725);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(290724);
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
    AppMethodBeat.o(290724);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_select_activity_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(290721);
    super.onCreate(paramBundle);
    setMMTitle(getResources().getString(b.j.finder_activity_select_title));
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = (MMActivity)this;
    Object localObject = getContentView();
    p.j(localObject, "contentView");
    this.xBc = new ak.b(paramBundle, (View)localObject, this.zQw, true);
    paramBundle = this.zQw;
    localObject = this.xBc;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    paramBundle.a((ak.b)localObject);
    paramBundle = this.xBc;
    if (paramBundle == null) {
      p.bGy("viewCallback");
    }
    paramBundle.initView();
    AppMethodBeat.o(290721);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(290722);
    super.onDestroy();
    this.zQw.onDetach();
    AppMethodBeat.o(290722);
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
    a(FinderSelectActivityUI paramFinderSelectActivityUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(287126);
      if (!this.AtX.isFinishing()) {
        this.AtX.finish();
      }
      AppMethodBeat.o(287126);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectActivityUI
 * JD-Core Version:    0.7.0.1
 */