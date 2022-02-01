package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.p.a;
import com.tencent.mm.plugin.finder.feed.p.b;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "presenter", "scene", "", "viewCallback", "getLayoutId", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFriendLikeTimelineUI
  extends FinderLoaderFeedUI<FinderFriendLikeLoader, p.b, p.a>
{
  private final String TAG = "Finder.FinderFavTimelineUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private p.a seF;
  private p.b seG;
  private FinderFriendLikeLoader seH;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202713);
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
    AppMethodBeat.o(202713);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496205;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202708);
    setMMTitle("");
    this.seF = new p.a((MMActivity)this, this.scene);
    Object localObject1 = (MMActivity)this;
    Object localObject2 = this.seF;
    if (localObject2 == null) {
      p.bcb("presenter");
    }
    this.seG = new p.b((MMActivity)localObject1, (p.a)localObject2, this.scene, cAZ());
    localObject1 = u.aAu();
    p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = a.KiD;
    localObject1 = new FinderFriendLikeLoader((String)localObject1, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
    localObject2 = getIntent();
    p.g(localObject2, "intent");
    ((FinderFriendLikeLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderFriendLikeLoader)localObject1).setInitDone((h)new a((FinderFriendLikeLoader)localObject1, this));
    ((FinderFriendLikeLoader)localObject1).fetchEndCallback = ((b)new b(this));
    this.seH = ((FinderFriendLikeLoader)localObject1);
    AppMethodBeat.o(202708);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderFriendLikeLoader paramFinderFriendLikeLoader, FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202706);
      Object localObject = FinderFriendLikeTimelineUI.a(jdField_this).rTF.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          AppMethodBeat.o(202706);
          throw ((Throwable)localObject);
        }
        ((FinderLayoutManager)localObject).ag(this.seD.getInitPos(), 0);
        AppMethodBeat.o(202706);
        return;
      }
      AppMethodBeat.o(202706);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<al>, z>
  {
    b(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI
 * JD-Core Version:    0.7.0.1
 */