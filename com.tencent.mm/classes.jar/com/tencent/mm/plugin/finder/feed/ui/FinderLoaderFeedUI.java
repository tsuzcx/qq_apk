package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.u.a;
import com.tencent.mm.plugin.finder.feed.u.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getModel", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "initOnCreate", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "plugin-finder_release"})
public abstract class FinderLoaderFeedUI<M extends BaseFinderFeedLoader, V extends u.b, P extends u.a>
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
  
  public abstract P cDJ();
  
  public abstract V cDK();
  
  public abstract M getModel();
  
  public abstract void initOnCreate();
  
  public void onBackPressed()
  {
    cDJ().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initOnCreate();
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = cDJ();
    u.b localb = cDK();
    paramBundle.a(getModel(), localb);
    setTitleBarClickListener((Runnable)new b(localb), (Runnable)FinderLoaderFeedUI.c.snV);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cDJ().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    cDJ().onUIPause();
  }
  
  public void onResume()
  {
    super.onResume();
    cDJ().onUIResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = getModel();
    Intent localIntent = getIntent();
    p.g(localIntent, "intent");
    BaseFinderFeedLoader.saveCache$default(paramBundle, localIntent, getModel().getInitPos(), null, 4, null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderLoaderFeedUI paramFinderLoaderFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166128);
      this.snT.onBackPressed();
      AppMethodBeat.o(166128);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "run"})
  static final class b
    implements Runnable
  {
    b(u.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(166129);
      RecyclerView localRecyclerView = this.snU.scj.getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(166129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
 * JD-Core Version:    0.7.0.1
 */