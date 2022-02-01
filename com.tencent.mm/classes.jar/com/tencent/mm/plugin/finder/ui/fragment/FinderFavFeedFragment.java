package com.tencent.mm.plugin.finder.ui.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.g.a;
import com.tencent.mm.plugin.finder.feed.g.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "presenter", "scene", "", "unFavIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnFav", "", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getViewCallback", "initAfterAttach", "initOnCreate", "onDestroy", "onResume", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFavFeedFragment
  extends FinderBaseGridFeedFragment<g.b, g.a>
{
  public static final a vQv;
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private IListener<hn> tOh;
  public FinderFavFeedLoader tZQ;
  private g.a vQs;
  private g.b vQt;
  private HashSet<Long> vQu;
  
  static
  {
    AppMethodBeat.i(252857);
    vQv = new a((byte)0);
    AppMethodBeat.o(252857);
  }
  
  public FinderFavFeedFragment()
  {
    this.dLS = 100;
  }
  
  public final void IQ(int paramInt)
  {
    AppMethodBeat.i(252855);
    if (paramInt > 0)
    {
      dAq().setMMTitle(dAq().getResources().getString(2131759705, new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(252855);
      return;
    }
    dAq().setMMTitle(dAq().getResources().getString(2131759706));
    AppMethodBeat.o(252855);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252859);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252859);
  }
  
  public final FinderFavFeedLoader dAr()
  {
    AppMethodBeat.i(252849);
    FinderFavFeedLoader localFinderFavFeedLoader = this.tZQ;
    if (localFinderFavFeedLoader == null) {
      p.btv("feedLoader");
    }
    AppMethodBeat.o(252849);
    return localFinderFavFeedLoader;
  }
  
  public final g.a dAs()
  {
    AppMethodBeat.i(252852);
    g.a locala = this.vQs;
    if (locala == null) {
      p.btv("presenter");
    }
    AppMethodBeat.o(252852);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return 2131494250;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(252850);
    this.vQu = new HashSet();
    IQ(0);
    Object localObject1 = z.aUg();
    p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    Object localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = new FinderFavFeedLoader((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)dAq()).get(FinderReporterUIC.class)).dIx(), false);
    ((FinderFavFeedLoader)localObject1).setInitDone((h)new b(this));
    ((FinderFavFeedLoader)localObject1).fetchEndCallback = ((b)new c(this));
    this.tZQ = ((FinderFavFeedLoader)localObject1);
    localObject1 = (MMActivity)dAq();
    dAq().getCommentScene();
    localObject2 = this.tZQ;
    if (localObject2 == null) {
      p.btv("feedLoader");
    }
    this.vQs = new g.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.vQt = ((g.b)new d(this, (MMActivity)dAq(), this.scene, dAq().getCommentScene()));
    localObject1 = this.vQt;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject2 = this.vQs;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    ((g.b)localObject1).a((c.a)localObject2);
    this.tOh = ((IListener)new e(this));
    EventCenter.instance.add(this.tOh);
    AppMethodBeat.o(252850);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252856);
    EventCenter.instance.removeListener(this.tOh);
    super.onDestroy();
    AppMethodBeat.o(252856);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252851);
    super.onResume();
    Object localObject1 = this.vQu;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Number)((Iterator)localObject1).next()).longValue();
        Object localObject2 = this.tZQ;
        if (localObject2 == null) {
          p.btv("feedLoader");
        }
        ((FinderFavFeedLoader)localObject2).remove(l, true);
        localObject2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
        l.a.L(l, 10);
        localObject2 = this.tZQ;
        if (localObject2 == null) {
          p.btv("feedLoader");
        }
        if (((FinderFavFeedLoader)localObject2).getSize() == 0)
        {
          localObject2 = this.vQt;
          if (localObject2 == null) {
            p.btv("viewCallback");
          }
          ((g.b)localObject2).bIo();
        }
      }
    }
    localObject1 = this.tZQ;
    if (localObject1 == null) {
      p.btv("feedLoader");
    }
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(252851);
      throw ((Throwable)localObject1);
    }
    IQ(((FinderFavFeedLoader)localObject1).gAZ);
    AppMethodBeat.o(252851);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements h
  {
    b(FinderFavFeedFragment paramFinderFavFeedFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(252844);
      Object localObject = FinderFavFeedFragment.a(this.vQw);
      if (localObject != null)
      {
        localObject = ((g.b)localObject).getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          localObject = FinderFavFeedFragment.a(this.vQw);
          if (localObject != null)
          {
            localObject = ((c.b)localObject).tLS.getRecyclerView();
            if (localObject != null) {
              ((RecyclerView)localObject).setVisibility(0);
            }
          }
          EventCenter.instance.publish((IEvent)new hn());
          AppMethodBeat.o(252844);
          return;
        }
      }
      AppMethodBeat.o(252844);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$1$2"})
  static final class c
    extends q
    implements b<IResponse<bo>, x>
  {
    c(FinderFavFeedFragment paramFinderFavFeedFragment)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$2", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "getRootView", "Landroid/view/View;", "plugin-finder_release"})
  public static final class d
    extends g.b
  {
    d(MMActivity paramMMActivity, int paramInt1, int paramInt2)
    {
      super(paramInt2, i, (byte)0);
    }
    
    public final View getRootView()
    {
      AppMethodBeat.i(252846);
      View localView = this.vQw.getView();
      AppMethodBeat.o(252846);
      return localView;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<hn>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$3$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderFavFeedFragment.e parame, hn paramhn)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFavFeedFragment
 * JD-Core Version:    0.7.0.1
 */