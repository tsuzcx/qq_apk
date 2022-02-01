package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader.b;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.y.a;
import com.tencent.mm.plugin.finder.feed.y.b;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedPresenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "presenter", "scene", "", "unLikeIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnLike", "", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getViewCallback", "initAfterAttach", "initOnCreate", "onDestroy", "onResume", "updateTitle", "count", "plugin-finder_release"})
public final class FinderLikeFeedGridFragment
  extends FinderBaseGridFeedFragment<y.b, y.a>
{
  private y.a Ayr;
  private y.b Ays;
  private HashSet<Long> Ayt;
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private IListener<hu> xyI;
  public FinderLikedFeedLoader zNr;
  
  public FinderLikeFeedGridFragment()
  {
    this.fEH = 102;
  }
  
  public final void MI(int paramInt)
  {
    AppMethodBeat.i(221215);
    if (paramInt > 0)
    {
      ebI().setMMTitle(ebI().getResources().getString(b.j.finder_like_feed_title, new Object[] { String.valueOf(paramInt) }));
      AppMethodBeat.o(221215);
      return;
    }
    ebI().setMMTitle(ebI().getResources().getString(b.j.finder_like_feed_title_zero));
    AppMethodBeat.o(221215);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(221225);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(221225);
  }
  
  public final FinderLikedFeedLoader ebN()
  {
    AppMethodBeat.i(221185);
    FinderLikedFeedLoader localFinderLikedFeedLoader = this.zNr;
    if (localFinderLikedFeedLoader == null) {
      p.bGy("feedLoader");
    }
    AppMethodBeat.o(221185);
    return localFinderLikedFeedLoader;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_like_grid_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(221200);
    this.Ayt = new HashSet();
    MI(0);
    Object localObject1 = com.tencent.mm.plugin.finder.feed.model.internal.g.xKw;
    Object localObject2 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = new FinderLikedFeedLoader(false, (com.tencent.mm.plugin.finder.feed.model.internal.g)localObject1, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)ebI()).i(aj.class)).ekY());
    ((FinderLikedFeedLoader)localObject1).setInitDone((j)new a(this));
    ((FinderLikedFeedLoader)localObject1).xEI = ((a)new b(this));
    ((FinderLikedFeedLoader)localObject1).xHK = ((b)new c((FinderLikedFeedLoader)localObject1, this));
    this.zNr = ((FinderLikedFeedLoader)localObject1);
    localObject1 = (MMActivity)ebI();
    ebI().getCommentScene();
    localObject2 = this.zNr;
    if (localObject2 == null) {
      p.bGy("feedLoader");
    }
    this.Ayr = new y.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.Ays = new y.b((MMActivity)ebI(), this.scene, ebI().getCommentScene(), (byte)0);
    localObject1 = this.Ays;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject2 = this.Ayr;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    ((y.b)localObject1).a((c.a)localObject2);
    this.xyI = ((IListener)new d(this));
    EventCenter.instance.add(this.xyI);
    AppMethodBeat.o(221200);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(221219);
    EventCenter.instance.removeListener(this.xyI);
    super.onDestroy();
    AppMethodBeat.o(221219);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(221210);
    super.onResume();
    Object localObject1 = this.Ayt;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Number)((Iterator)localObject1).next()).longValue();
        Object localObject2 = this.zNr;
        if (localObject2 == null) {
          p.bGy("feedLoader");
        }
        ((FinderLikedFeedLoader)localObject2).remove(l, true);
        localObject2 = k.Anu;
        k.a.R(l, 2);
        localObject2 = this.zNr;
        if (localObject2 == null) {
          p.bGy("feedLoader");
        }
        if (((FinderLikedFeedLoader)localObject2).getSize() == 0)
        {
          localObject2 = this.Ays;
          if (localObject2 == null) {
            p.bGy("viewCallback");
          }
          ((y.b)localObject2).bTY();
        }
      }
    }
    localObject1 = this.zNr;
    if (localObject1 == null) {
      p.bGy("feedLoader");
    }
    MI(((FinderLikedFeedLoader)localObject1).jlf);
    AppMethodBeat.o(221210);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a(FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(289928);
      Object localObject = FinderLikeFeedGridFragment.a(this.Ayu).getEmptyView();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        localObject = FinderLikeFeedGridFragment.a(this.Ayu).xvJ.getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).setVisibility(0);
        }
        EventCenter.instance.publish((IEvent)new hu());
        AppMethodBeat.o(289928);
        return;
      }
      AppMethodBeat.o(289928);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$2"})
  static final class b
    extends q
    implements a<x>
  {
    b(FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$3"})
  static final class c
    extends q
    implements b<FinderLikedFeedLoader.b, x>
  {
    c(FinderLikedFeedLoader paramFinderLikedFeedLoader, FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hu>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$2$callback$1$1"})
    static final class a
      extends q
      implements a<x>
    {
      a(FinderLikeFeedGridFragment.d paramd, hu paramhu)
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