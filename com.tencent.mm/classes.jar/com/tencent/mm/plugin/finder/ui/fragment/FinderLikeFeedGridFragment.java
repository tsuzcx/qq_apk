package com.tencent.mm.plugin.finder.ui.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader.b;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.u.a;
import com.tencent.mm.plugin.finder.feed.u.b;
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
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedPresenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "presenter", "scene", "", "unLikeIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnLike", "", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getViewCallback", "initAfterAttach", "initOnCreate", "onDestroy", "onResume", "updateTitle", "count", "plugin-finder_release"})
public final class FinderLikeFeedGridFragment
  extends FinderBaseGridFeedFragment<u.b, u.a>
{
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private IListener<hn> tOh;
  public FinderLikedFeedLoader uXc;
  private u.a vQF;
  private u.b vQG;
  private HashSet<Long> vQH;
  
  public FinderLikeFeedGridFragment()
  {
    this.dLS = 102;
  }
  
  public final void IQ(int paramInt)
  {
    AppMethodBeat.i(252906);
    if (paramInt > 0)
    {
      dAq().setMMTitle(dAq().getResources().getString(2131759840, new Object[] { String.valueOf(paramInt) }));
      AppMethodBeat.o(252906);
      return;
    }
    dAq().setMMTitle(dAq().getResources().getString(2131759841));
    AppMethodBeat.o(252906);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252909);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252909);
  }
  
  public final FinderLikedFeedLoader dAv()
  {
    AppMethodBeat.i(252901);
    FinderLikedFeedLoader localFinderLikedFeedLoader = this.uXc;
    if (localFinderLikedFeedLoader == null) {
      p.btv("feedLoader");
    }
    AppMethodBeat.o(252901);
    return localFinderLikedFeedLoader;
  }
  
  public final int getLayoutId()
  {
    return 2131494357;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(252902);
    this.vQH = new HashSet();
    IQ(0);
    Object localObject1 = e.tYs;
    Object localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = new FinderLikedFeedLoader(false, (e)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)dAq()).get(FinderReporterUIC.class)).dIx());
    ((FinderLikedFeedLoader)localObject1).setInitDone((h)new a(this));
    ((FinderLikedFeedLoader)localObject1).tTS = ((kotlin.g.a.a)new b(this));
    ((FinderLikedFeedLoader)localObject1).tVS = ((b)new c((FinderLikedFeedLoader)localObject1, this));
    this.uXc = ((FinderLikedFeedLoader)localObject1);
    localObject1 = (MMActivity)dAq();
    dAq().getCommentScene();
    localObject2 = this.uXc;
    if (localObject2 == null) {
      p.btv("feedLoader");
    }
    this.vQF = new u.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.vQG = new u.b((MMActivity)dAq(), this.scene, dAq().getCommentScene(), (byte)0);
    localObject1 = this.vQG;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject2 = this.vQF;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    ((u.b)localObject1).a((c.a)localObject2);
    this.tOh = ((IListener)new d(this));
    EventCenter.instance.add(this.tOh);
    AppMethodBeat.o(252902);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252907);
    EventCenter.instance.removeListener(this.tOh);
    super.onDestroy();
    AppMethodBeat.o(252907);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252903);
    super.onResume();
    Object localObject1 = this.vQH;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Number)((Iterator)localObject1).next()).longValue();
        Object localObject2 = this.uXc;
        if (localObject2 == null) {
          p.btv("feedLoader");
        }
        ((FinderLikedFeedLoader)localObject2).remove(l, true);
        localObject2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
        l.a.L(l, 2);
        localObject2 = this.uXc;
        if (localObject2 == null) {
          p.btv("feedLoader");
        }
        if (((FinderLikedFeedLoader)localObject2).getSize() == 0)
        {
          localObject2 = this.vQG;
          if (localObject2 == null) {
            p.btv("viewCallback");
          }
          ((u.b)localObject2).bIo();
        }
      }
    }
    localObject1 = this.uXc;
    if (localObject1 == null) {
      p.btv("feedLoader");
    }
    IQ(((FinderLikedFeedLoader)localObject1).gAZ);
    AppMethodBeat.o(252903);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(252896);
      Object localObject = FinderLikeFeedGridFragment.a(this.vQI).getEmptyView();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        localObject = FinderLikeFeedGridFragment.a(this.vQI).tLS.getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).setVisibility(0);
        }
        EventCenter.instance.publish((IEvent)new hn());
        AppMethodBeat.o(252896);
        return;
      }
      AppMethodBeat.o(252896);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$2"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$3"})
  static final class c
    extends q
    implements b<FinderLikedFeedLoader.b, x>
  {
    c(FinderLikedFeedLoader paramFinderLikedFeedLoader, FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hn>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$2$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderLikeFeedGridFragment.d paramd, hn paramhn)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLikeFeedGridFragment
 * JD-Core Version:    0.7.0.1
 */