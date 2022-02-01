package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ae.a;
import com.tencent.mm.plugin.finder.feed.ae.b;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectActivityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "selectPresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "getLayoutId", "", "initContentView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderSelectActivityUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  private ae.b tQm;
  private final ae.a vaq;
  
  public FinderSelectActivityUI()
  {
    AppMethodBeat.i(252607);
    this.vaq = new ae.a();
    AppMethodBeat.o(252607);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252609);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252609);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252608);
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
    AppMethodBeat.o(252608);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494613;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252605);
    super.onCreate(paramBundle);
    setMMTitle(getResources().getString(2131759521));
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = (MMActivity)this;
    Object localObject = getContentView();
    p.g(localObject, "contentView");
    this.tQm = new ae.b(paramBundle, (View)localObject, this.vaq, true);
    paramBundle = this.vaq;
    localObject = this.tQm;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    paramBundle.a((ae.b)localObject);
    paramBundle = this.tQm;
    if (paramBundle == null) {
      p.btv("viewCallback");
    }
    paramBundle.initView();
    AppMethodBeat.o(252605);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252606);
    super.onDestroy();
    this.vaq.onDetach();
    AppMethodBeat.o(252606);
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
    a(FinderSelectActivityUI paramFinderSelectActivityUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252604);
      if (!this.vNf.isFinishing()) {
        this.vNf.finish();
      }
      AppMethodBeat.o(252604);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectActivityUI
 * JD-Core Version:    0.7.0.1
 */