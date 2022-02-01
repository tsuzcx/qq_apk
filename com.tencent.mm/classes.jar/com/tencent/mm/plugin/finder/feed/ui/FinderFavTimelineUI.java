package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.g.a;
import com.tencent.mm.plugin.finder.feed.g.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "presenter", "scene", "", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "plugin-finder_release"})
public final class FinderFavTimelineUI
  extends FinderLoaderFeedUI<FinderFavFeedLoader, g.b, g.a>
{
  private final String TAG = "Finder.FinderFavTimelineUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private g.a sdT;
  private g.b sdU;
  private FinderFavFeedLoader sdV;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202657);
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
    AppMethodBeat.o(202657);
    return localView1;
  }
  
  public final int cAZ()
  {
    return 21;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(202655);
    Object localObject1 = this.sdU;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
    }
    localObject1 = ((a.b)localObject1).rTF.getRecyclerView().getLayoutManager();
    if ((localObject1 instanceof LinearLayoutManager))
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject2 = this.sdV;
      if (localObject2 == null) {
        d.g.b.p.bcb("feedLoader");
      }
      setResult(-1, com.tencent.mm.plugin.finder.utils.p.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
    }
    super.finish();
    AppMethodBeat.o(202655);
  }
  
  public final int getLayoutId()
  {
    return 2131496184;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202651);
    Object localObject1 = getContext();
    d.g.b.p.g(localObject1, "context");
    setMMTitle(((AppCompatActivity)localObject1).getResources().getString(2131766394));
    this.sdT = new g.a((MMActivity)this, this.scene);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.sdT;
    if (localObject2 == null) {
      d.g.b.p.bcb("presenter");
    }
    this.sdU = new g.b((MMActivity)localObject1, (g.a)localObject2, this.scene);
    localObject1 = u.aAu();
    d.g.b.p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = a.KiD;
    localObject1 = new FinderFavFeedLoader((String)localObject1, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu(), true);
    localObject2 = getIntent();
    d.g.b.p.g(localObject2, "intent");
    ((FinderFavFeedLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderFavFeedLoader)localObject1).setInitDone((h)new a((FinderFavFeedLoader)localObject1, this));
    ((FinderFavFeedLoader)localObject1).fetchEndCallback = ((b)new b(this));
    this.sdV = ((FinderFavFeedLoader)localObject1);
    AppMethodBeat.o(202651);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderFavFeedLoader paramFinderFavFeedLoader, FinderFavTimelineUI paramFinderFavTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202649);
      Object localObject = FinderFavTimelineUI.a(jdField_this).rTF.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          AppMethodBeat.o(202649);
          throw ((Throwable)localObject);
        }
        ((FinderLayoutManager)localObject).ag(this.sdW.getInitPos(), 0);
        AppMethodBeat.o(202649);
        return;
      }
      AppMethodBeat.o(202649);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<al>, z>
  {
    b(FinderFavTimelineUI paramFinderFavTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI
 * JD-Core Version:    0.7.0.1
 */