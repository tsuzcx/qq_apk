package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.e.a;
import com.tencent.mm.plugin.finder.feed.e.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.l;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getModel", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "initOnCreate", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public abstract class FinderLoaderFeedUI<M extends BaseFinderFeedLoader, V extends e.b, P extends e.a>
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
  
  public abstract P cmE();
  
  public abstract V cmF();
  
  public abstract M getModel();
  
  public abstract void initOnCreate();
  
  public void onBackPressed()
  {
    cmE().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initOnCreate();
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderLoaderFeedUI.a(this));
    paramBundle = cmE();
    e.b localb = cmF();
    paramBundle.a(getModel(), localb);
    setTitleBarClickListener((Runnable)new b(localb), (Runnable)FinderLoaderFeedUI.c.qzE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cmE().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    cmE().onUIPause();
  }
  
  public void onResume()
  {
    super.onResume();
    cmE().onUIResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "run"})
  static final class b
    implements Runnable
  {
    b(e.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(166129);
      RecyclerView localRecyclerView = this.qzD.quj.getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(166129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
 * JD-Core Version:    0.7.0.1
 */