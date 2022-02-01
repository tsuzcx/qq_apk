package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.he;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.t.a;
import com.tencent.mm.plugin.finder.feed.t.b;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderNewUIA;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedPresenter;", "()V", "TAG", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "presenter", "scene", "", "unLikeIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "viewCallback", "checkEmptyOnUnLike", "", "getCommentScene", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "initOnCreate", "onBackPressed", "onDestroy", "onResume", "updateTitle", "count", "plugin-finder_release"})
public final class FinderNewUIA
  extends FinderBaseGridFeedUI<t.b, t.a>
{
  private final String TAG = "Finder.FinderLikeFeedGridUI";
  private HashMap _$_findViewCache;
  private c<he> rVT;
  private final int scene = 2;
  private t.a sfh;
  private t.b sfi;
  public FinderLikedFeedLoader sfj;
  private ArrayList<Long> sfk;
  
  public final void EG(int paramInt)
  {
    AppMethodBeat.i(202767);
    if (paramInt > 0)
    {
      localAppCompatActivity = getContext();
      p.g(localAppCompatActivity, "context");
      setMMTitle(localAppCompatActivity.getResources().getString(2131766791, new Object[] { String.valueOf(paramInt) }));
      AppMethodBeat.o(202767);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    p.g(localAppCompatActivity, "context");
    setMMTitle(localAppCompatActivity.getResources().getString(2131766796));
    AppMethodBeat.o(202767);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202770);
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
    AppMethodBeat.o(202770);
    return localView1;
  }
  
  public final int cAZ()
  {
    return 35;
  }
  
  public final int cBZ()
  {
    return 3;
  }
  
  public final int getLayoutId()
  {
    return 2131496392;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202762);
    this.sfk = new ArrayList();
    EG(0);
    Object localObject1 = e.scN;
    Object localObject2 = com.tencent.mm.ui.component.a.KiD;
    localObject1 = new FinderLikedFeedLoader(false, (e)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
    ((FinderLikedFeedLoader)localObject1).setInitDone((h)new a(this));
    ((FinderLikedFeedLoader)localObject1).rTm = ((d.g.a.a)new b(this));
    ((FinderLikedFeedLoader)localObject1).sbL = ((d.g.a.b)new c(this));
    this.sfj = ((FinderLikedFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    localObject2 = this.sfj;
    if (localObject2 == null) {
      p.bcb("feedLoader");
    }
    this.sfh = new t.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.sfi = new t.b((MMActivity)this, this.scene, (byte)0);
    localObject1 = this.sfi;
    if (localObject1 == null) {
      p.bcb("viewCallback");
    }
    localObject2 = this.sfh;
    if (localObject2 == null) {
      p.bcb("presenter");
    }
    ((t.b)localObject1).a((b.a)localObject2);
    this.rVT = ((c)new d(this));
    com.tencent.mm.sdk.b.a.IbL.b(this.rVT);
    AppMethodBeat.o(202762);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(202763);
    Intent localIntent = new Intent();
    Object localObject = FinderSelfUI.sGL;
    localObject = FinderSelfUI.cKp();
    FinderLikedFeedLoader localFinderLikedFeedLoader = this.sfj;
    if (localFinderLikedFeedLoader == null) {
      p.bcb("feedLoader");
    }
    localIntent.putExtra((String)localObject, localFinderLikedFeedLoader.fTM);
    setResult(-1, localIntent);
    super.onBackPressed();
    AppMethodBeat.o(202763);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202768);
    com.tencent.mm.sdk.b.a.IbL.d(this.rVT);
    super.onDestroy();
    AppMethodBeat.o(202768);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202764);
    super.onResume();
    Object localObject1 = this.sfk;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Number)((Iterator)localObject1).next()).longValue();
        Object localObject2 = this.sfj;
        if (localObject2 == null) {
          p.bcb("feedLoader");
        }
        ((FinderLikedFeedLoader)localObject2).remove(l, true);
        localObject2 = k.sAe;
        k.a.M(l, 2);
        localObject2 = this.sfj;
        if (localObject2 == null) {
          p.bcb("feedLoader");
        }
        if (((FinderLikedFeedLoader)localObject2).getSize() == 0)
        {
          localObject2 = this.sfi;
          if (localObject2 == null) {
            p.bcb("viewCallback");
          }
          ((t.b)localObject2).bmg();
        }
      }
    }
    localObject1 = this.sfj;
    if (localObject1 == null) {
      p.bcb("feedLoader");
    }
    EG(((FinderLikedFeedLoader)localObject1).fTM);
    AppMethodBeat.o(202764);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderNewUIA paramFinderNewUIA) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202757);
      Object localObject = FinderNewUIA.a(this.sfl).getEmptyView();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        localObject = FinderNewUIA.a(this.sfl).rTF.getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).setVisibility(0);
        }
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)new he());
        AppMethodBeat.o(202757);
        return;
      }
      AppMethodBeat.o(202757);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$1$2"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(FinderNewUIA paramFinderNewUIA)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "totalCount", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$1$3"})
  static final class c
    extends q
    implements d.g.a.b<Integer, z>
  {
    c(FinderNewUIA paramFinderNewUIA)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends c<he>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$2$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderNewUIA.d paramd, he paramhe)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderNewUIA
 * JD-Core Version:    0.7.0.1
 */