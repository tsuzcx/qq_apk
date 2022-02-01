package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.j.a;
import com.tencent.mm.plugin.finder.feed.j.b;
import com.tencent.mm.plugin.finder.feed.model.e;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "mPresenter", "mViewCallback", "scene", "", "tabType", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFeedRelTimelineUI
  extends FinderLoaderFeedUI<e, j.b, j.a>
{
  private final String TAG = "Finder.FinderFeedRelTimelineUI";
  private HashMap _$_findViewCache;
  private long dig;
  private int diw;
  private j.a rpn;
  private j.b rpo;
  private e rpp;
  private final int scene = 2;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202331);
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
    AppMethodBeat.o(202331);
    return localView1;
  }
  
  public final int cuI()
  {
    return 20;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496193;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202326);
    this.dig = getIntent().getLongExtra("FEED_ID", 0L);
    this.diw = getIntent().getIntExtra("TAB_TYPE", 0);
    setMMTitle("");
    this.rpn = new j.a((MMActivity)this, this.dig, this.scene);
    Object localObject = (MMActivity)this;
    j.a locala = this.rpn;
    if (locala == null) {
      k.aVY("mPresenter");
    }
    this.rpo = new j.b((MMActivity)localObject, locala, this.scene);
    long l = this.dig;
    int i = this.diw;
    localObject = a.IrY;
    localObject = new e(l, i, null, 0, ((FinderReporterUIC)a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb(), 12);
    ((e)localObject).rmE = ((b)new a(this));
    this.rpp = ((e)localObject);
    AppMethodBeat.o(202326);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI$initOnCreate$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderFeedRelTimelineUI paramFinderFeedRelTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI
 * JD-Core Version:    0.7.0.1
 */