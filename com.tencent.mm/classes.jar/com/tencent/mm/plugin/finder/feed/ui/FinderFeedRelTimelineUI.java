package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.m.a;
import com.tencent.mm.plugin.finder.feed.m.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "mPresenter", "mViewCallback", "scene", "", "tabType", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFeedRelTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, m.b, m.a>
{
  private final String TAG = "Finder.FinderFeedRelTimelineUI";
  private HashMap _$_findViewCache;
  private int fEH;
  private long feedId;
  private final int scene = 2;
  private m.a xMj;
  private m.b xMk;
  private FinderFeedRelTimelineLoader xMl;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(290320);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(290320);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(290319);
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
    AppMethodBeat.o(290319);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 20;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_feed_rel_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(290314);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    this.fEH = getIntent().getIntExtra("TAB_TYPE", 0);
    setMMTitle("");
    this.xMj = new m.a((MMActivity)this, this.feedId, this.scene);
    Object localObject = (MMActivity)this;
    m.a locala = this.xMj;
    if (locala == null) {
      p.bGy("mPresenter");
    }
    this.xMk = new m.b((MMActivity)localObject, locala, this.scene);
    long l = this.feedId;
    int i = this.fEH;
    localObject = g.Xox;
    localObject = new FinderFeedRelTimelineLoader(l, "", i, null, 0, false, null, null, null, 0, ((aj)g.b((AppCompatActivity)this).i(aj.class)).ekY(), 0.0F, 0.0F, 28664);
    ((FinderFeedRelTimelineLoader)localObject).fetchEndCallback = ((b)new a(this));
    this.xMl = ((FinderFeedRelTimelineLoader)localObject);
    AppMethodBeat.o(290314);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI$initOnCreate$1$1"})
  static final class a
    extends q
    implements b<IResponse<bu>, x>
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