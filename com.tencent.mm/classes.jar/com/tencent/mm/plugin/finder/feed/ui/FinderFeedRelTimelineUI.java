package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.l.a;
import com.tencent.mm.plugin.finder.feed.l.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "mPresenter", "mViewCallback", "scene", "", "tabType", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFeedRelTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, l.b, l.a>
{
  private final String TAG = "Finder.FinderFeedRelTimelineUI";
  private HashMap _$_findViewCache;
  private int dLS;
  private long feedId;
  private final int scene = 2;
  private l.a tZU;
  private l.b tZV;
  private FinderFeedRelTimelineLoader tZW;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245169);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245169);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245168);
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
    AppMethodBeat.o(245168);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 20;
  }
  
  public final int getLayoutId()
  {
    return 2131494298;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245163);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    this.dLS = getIntent().getIntExtra("TAB_TYPE", 0);
    setMMTitle("");
    this.tZU = new l.a((MMActivity)this, this.feedId, this.scene);
    Object localObject = (MMActivity)this;
    l.a locala = this.tZU;
    if (locala == null) {
      p.btv("mPresenter");
    }
    this.tZV = new l.b((MMActivity)localObject, locala, this.scene);
    long l = this.feedId;
    int i = this.dLS;
    localObject = a.PRN;
    localObject = new FinderFeedRelTimelineLoader(l, "", i, null, 0, false, null, null, null, 0, ((FinderReporterUIC)a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx(), 4088);
    ((FinderFeedRelTimelineLoader)localObject).fetchEndCallback = ((b)new a(this));
    this.tZW = ((FinderFeedRelTimelineLoader)localObject);
    AppMethodBeat.o(245163);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI$initOnCreate$1$1"})
  static final class a
    extends q
    implements b<IResponse<bo>, x>
  {
    a(FinderFeedRelTimelineUI paramFinderFeedRelTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI
 * JD-Core Version:    0.7.0.1
 */