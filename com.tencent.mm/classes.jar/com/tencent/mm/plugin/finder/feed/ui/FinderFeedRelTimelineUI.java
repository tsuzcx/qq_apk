package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.feed.k.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "mPresenter", "mViewCallback", "scene", "", "tabType", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFeedRelTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, k.b, k.a>
{
  private final String TAG = "Finder.FinderFeedRelTimelineUI";
  private HashMap _$_findViewCache;
  private long dtq;
  private int duh;
  private final int scene = 2;
  private k.a sdY;
  private k.b sdZ;
  private FinderFeedRelTimelineLoader sea;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202664);
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
    AppMethodBeat.o(202664);
    return localView1;
  }
  
  public final int cAZ()
  {
    return 20;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496193;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202659);
    this.dtq = getIntent().getLongExtra("FEED_ID", 0L);
    this.duh = getIntent().getIntExtra("TAB_TYPE", 0);
    setMMTitle("");
    this.sdY = new k.a((MMActivity)this, this.dtq, this.scene);
    Object localObject = (MMActivity)this;
    k.a locala = this.sdY;
    if (locala == null) {
      p.bcb("mPresenter");
    }
    this.sdZ = new k.b((MMActivity)localObject, locala, this.scene);
    long l = this.dtq;
    int i = this.duh;
    localObject = a.KiD;
    localObject = new FinderFeedRelTimelineLoader(l, "", i, null, 0, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu(), 24);
    ((FinderFeedRelTimelineLoader)localObject).fetchEndCallback = ((b)new a(this));
    this.sea = ((FinderFeedRelTimelineLoader)localObject);
    AppMethodBeat.o(202659);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI$initOnCreate$1$1"})
  static final class a
    extends q
    implements b<IResponse<al>, z>
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