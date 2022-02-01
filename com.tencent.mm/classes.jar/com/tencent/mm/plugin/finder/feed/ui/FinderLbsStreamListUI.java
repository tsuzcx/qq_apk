package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.j;
import com.tencent.mm.plugin.finder.feed.model.j.a;
import com.tencent.mm.plugin.finder.feed.p.a;
import com.tencent.mm.plugin.finder.feed.p.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "initPos", "", "presenter", "saveResult", "", "scene", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "onDestroy", "plugin-finder_release"})
public final class FinderLbsStreamListUI
  extends FinderLoaderFeedUI<j, p.b, p.a>
{
  private final String TAG = "Finder.StreamTimelineUI";
  private HashMap _$_findViewCache;
  private long rhr;
  private int rht;
  private p.a rqj;
  private p.b rqk;
  private j rql;
  private boolean rqm;
  private final int scene = 2;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202430);
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
    AppMethodBeat.o(202430);
    return localView1;
  }
  
  public final int cuI()
  {
    return 16;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(202428);
    long l;
    Object localObject2;
    int i;
    int j;
    if (this.rqm)
    {
      Object localObject1 = this.rqk;
      if (localObject1 == null) {
        k.aVY("viewCallback");
      }
      localObject1 = ((b.b)localObject1).rfT.getRecyclerView().getLayoutManager();
      if ((localObject1 instanceof LinearLayoutManager))
      {
        l = System.currentTimeMillis();
        localObject2 = this.rql;
        if (localObject2 == null) {
          k.aVY("feedLoader");
        }
        localObject2 = ((j)localObject2).getDataListJustForAdapter();
        Object localObject3 = this.rql;
        if (localObject3 == null) {
          k.aVY("feedLoader");
        }
        localObject3 = ((j)localObject3).lastBuffer;
        j.a locala = j.rmZ;
        j.a.a(l, (List)localObject2, (com.tencent.mm.bw.b)localObject3);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("KEY_CACHE_ID", l);
        i = ((LinearLayoutManager)localObject1).jW();
        j = ((LinearLayoutManager)localObject1).jY();
        if ((this.rht < i) || (this.rht > j)) {
          break label246;
        }
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_POSITION", -1);
      }
    }
    for (;;)
    {
      setResult(0, (Intent)localObject2);
      ac.i(this.TAG, "lxl resultCacheId:" + l + ", posStart:" + i + ", posEnd " + j + ", initPos:" + this.rht);
      super.finish();
      AppMethodBeat.o(202428);
      return;
      label246:
      ((Intent)localObject2).putExtra("KEY_CLICK_FEED_POSITION", i);
    }
  }
  
  public final int getLayoutId()
  {
    return 2131496222;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202423);
    Object localObject1 = getIntent().getStringExtra("KEY_UI_TITLE");
    if (localObject1 != null) {}
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      setTitle((CharSequence)localObject1);
      setMMTitle(getTitle());
      this.rhr = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      this.rht = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
      this.rqm = getIntent().getBooleanExtra("KEY_SAVE_RESULT", false);
      this.rqj = new p.a((MMActivity)this, this.rhr, this.rht, this.scene);
      localObject1 = (MMActivity)this;
      Object localObject2 = this.rqj;
      if (localObject2 == null) {
        k.aVY("presenter");
      }
      this.rqk = new p.b((MMActivity)localObject1, (p.a)localObject2, this.scene);
      localObject1 = u.axE();
      k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject2 = com.tencent.mm.ui.component.a.IrY;
      localObject1 = new j((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
      ((j)localObject1).rmE = ((d.g.a.b)new a(this));
      this.rql = ((j)localObject1);
      AppMethodBeat.o(202423);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202427);
    super.onDestroy();
    j.a locala = j.rmZ;
    j.a.ui(this.rhr);
    AppMethodBeat.o(202427);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderLbsStreamListUI paramFinderLbsStreamListUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI
 * JD-Core Version:    0.7.0.1
 */