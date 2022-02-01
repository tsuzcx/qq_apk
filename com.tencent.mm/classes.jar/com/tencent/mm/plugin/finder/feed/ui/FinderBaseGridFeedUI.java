package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "initAfterAttach", "", "initOnCreate", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public abstract class FinderBaseGridFeedUI<V extends c.b, P extends c.a>
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
  
  public abstract P cuC();
  
  public abstract V cvO();
  
  public abstract void initOnCreate();
  
  public void onBackPressed()
  {
    Object localObject1 = cuC();
    Object localObject2 = ((c.a)localObject1).rgf;
    if (localObject2 == null) {
      k.fOy();
    }
    localObject2 = ((c.b)localObject2).cuE();
    if (localObject2 == null) {
      k.fOy();
    }
    if (((FinderLikeDrawer)localObject2).cEG())
    {
      localObject1 = ((c.a)localObject1).rgf;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = ((c.b)localObject1).cuE();
      if (localObject1 == null) {
        k.fOy();
      }
      ((FinderLikeDrawer)localObject1).cEF();
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        finish();
      }
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initOnCreate();
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    cuC().a(cvO());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cuC().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    cuC();
  }
  
  public void onResume()
  {
    super.onResume();
    cuC();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderBaseGridFeedUI paramFinderBaseGridFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202288);
      this.roJ.onBackPressed();
      AppMethodBeat.o(202288);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
 * JD-Core Version:    0.7.0.1
 */