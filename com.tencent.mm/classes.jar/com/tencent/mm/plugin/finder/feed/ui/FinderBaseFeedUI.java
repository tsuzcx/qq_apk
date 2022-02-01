package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.d;
import d.l;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "initAfterAttach", "", "initOnCreate", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public abstract class FinderBaseFeedUI<V extends b.b, P extends b.a>
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public View _$_findCachedViewById(int paramInt)
  {
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
    return localView1;
  }
  
  public void cvL() {}
  
  public abstract P cvM();
  
  public abstract V cvN();
  
  public abstract void initOnCreate();
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    cvM().cuv().d(paramInt1, paramIntent);
  }
  
  public void onBackPressed()
  {
    cvM().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initOnCreate();
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    cvM().a(cvN());
    cvL();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cvM().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    cvM().onUIPause();
  }
  
  public void onResume()
  {
    super.onResume();
    cvM().onUIResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderBaseFeedUI paramFinderBaseFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166127);
      this.roI.onBackPressed();
      AppMethodBeat.o(166127);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
 * JD-Core Version:    0.7.0.1
 */