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
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.r.a;
import com.tencent.mm.plugin.finder.feed.r.b;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "()V", "TAG", "", "feedLoader", "presenter", "saveResult", "", "scene", "", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "plugin-finder_release"})
public final class FinderLbsStreamListUI
  extends FinderLoaderFeedUI<FinderLbsStreamFeedLoader, r.b, r.a>
{
  private final String TAG = "Finder.StreamTimelineUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private r.a seX;
  private r.b seY;
  private FinderLbsStreamFeedLoader seZ;
  private boolean sfa;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202756);
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
    AppMethodBeat.o(202756);
    return localView1;
  }
  
  public final int cAZ()
  {
    return 16;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(202754);
    if (this.sfa)
    {
      Object localObject1 = this.seY;
      if (localObject1 == null) {
        d.g.b.p.bcb("viewCallback");
      }
      localObject1 = ((a.b)localObject1).rTF.getRecyclerView().getLayoutManager();
      if ((localObject1 instanceof LinearLayoutManager))
      {
        Object localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject2 = this.seZ;
        if (localObject2 == null) {
          d.g.b.p.bcb("feedLoader");
        }
        setResult(-1, com.tencent.mm.plugin.finder.utils.p.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
      }
    }
    super.finish();
    AppMethodBeat.o(202754);
  }
  
  public final int getLayoutId()
  {
    return 2131496222;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202750);
    Object localObject1 = getIntent().getStringExtra("KEY_UI_TITLE");
    if (localObject1 != null) {}
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      setTitle((CharSequence)localObject1);
      setMMTitle(getTitle());
      this.sfa = getIntent().getBooleanExtra("KEY_SAVE_RESULT", false);
      this.seX = new r.a((MMActivity)this, this.scene);
      localObject1 = (MMActivity)this;
      Object localObject2 = this.seX;
      if (localObject2 == null) {
        d.g.b.p.bcb("presenter");
      }
      this.seY = new r.b((MMActivity)localObject1, (r.a)localObject2, this.scene);
      localObject1 = u.aAu();
      d.g.b.p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject2 = com.tencent.mm.ui.component.a.KiD;
      localObject1 = new FinderLbsStreamFeedLoader((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
      localObject2 = getIntent();
      d.g.b.p.g(localObject2, "intent");
      ((FinderLbsStreamFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderLbsStreamFeedLoader)localObject1).setInitDone((h)new a((FinderLbsStreamFeedLoader)localObject1, this));
      ((FinderLbsStreamFeedLoader)localObject1).fetchEndCallback = ((b)new b(this));
      this.seZ = ((FinderLbsStreamFeedLoader)localObject1);
      AppMethodBeat.o(202750);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderLbsStreamFeedLoader paramFinderLbsStreamFeedLoader, FinderLbsStreamListUI paramFinderLbsStreamListUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202747);
      Object localObject = FinderLbsStreamListUI.a(jdField_this).rTF.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          AppMethodBeat.o(202747);
          throw ((Throwable)localObject);
        }
        ((FinderLayoutManager)localObject).ag(this.sfb.getInitPos(), 0);
        AppMethodBeat.o(202747);
        return;
      }
      AppMethodBeat.o(202747);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<al>, z>
  {
    b(FinderLbsStreamListUI paramFinderLbsStreamListUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI
 * JD-Core Version:    0.7.0.1
 */