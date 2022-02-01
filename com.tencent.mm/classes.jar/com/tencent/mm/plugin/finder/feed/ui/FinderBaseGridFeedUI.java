package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "initAfterAttach", "", "initOnCreate", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public abstract class FinderBaseGridFeedUI<V extends b.b, P extends b.a>
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
  
  public abstract P cCB();
  
  public abstract V cDQ();
  
  public abstract void initOnCreate();
  
  public void onBackPressed()
  {
    Object localObject1 = cCB();
    Object localObject2 = ((b.a)localObject1).scu;
    if (localObject2 == null) {
      p.gkB();
    }
    localObject2 = ((b.b)localObject2).cCv();
    if (localObject2 == null) {
      p.gkB();
    }
    if (((FinderLikeDrawer)localObject2).cPI())
    {
      localObject1 = ((b.a)localObject1).scu;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = ((b.b)localObject1).cCv();
      if (localObject1 == null) {
        p.gkB();
      }
      ((FinderLikeDrawer)localObject1).cPH();
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
    cCB().a(cDQ());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cCB().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    cCB();
  }
  
  public void onResume()
  {
    super.onResume();
    cCB();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderBaseGridFeedUI paramFinderBaseGridFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203089);
      this.smj.onBackPressed();
      AppMethodBeat.o(203089);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
 * JD-Core Version:    0.7.0.1
 */