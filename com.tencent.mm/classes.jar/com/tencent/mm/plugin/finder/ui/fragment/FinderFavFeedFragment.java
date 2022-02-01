package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.g.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "presenter", "scene", "", "unFavIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnFav", "", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getViewCallback", "initAfterAttach", "initOnCreate", "onDestroy", "onResume", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFavFeedFragment
  extends FinderBaseGridFeedFragment<g.b, com.tencent.mm.plugin.finder.feed.g.a>
{
  public static final a Ayh;
  private com.tencent.mm.plugin.finder.feed.g.a Aye;
  private g.b Ayf;
  private HashSet<Long> Ayg;
  private HashMap _$_findViewCache;
  private final int scene = 2;
  public FinderFavFeedLoader xMf;
  private IListener<hu> xyI;
  
  static
  {
    AppMethodBeat.i(285291);
    Ayh = new a((byte)0);
    AppMethodBeat.o(285291);
  }
  
  public FinderFavFeedFragment()
  {
    this.fEH = 100;
  }
  
  public final void MI(int paramInt)
  {
    AppMethodBeat.i(285289);
    if (paramInt > 0)
    {
      ebI().setMMTitle(ebI().getResources().getString(b.j.finder_fav_feed_title, new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(285289);
      return;
    }
    ebI().setMMTitle(ebI().getResources().getString(b.j.finder_fav_feed_title_zero));
    AppMethodBeat.o(285289);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(285293);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(285293);
  }
  
  public final FinderFavFeedLoader ebJ()
  {
    AppMethodBeat.i(285282);
    FinderFavFeedLoader localFinderFavFeedLoader = this.xMf;
    if (localFinderFavFeedLoader == null) {
      p.bGy("feedLoader");
    }
    AppMethodBeat.o(285282);
    return localFinderFavFeedLoader;
  }
  
  public final com.tencent.mm.plugin.finder.feed.g.a ebK()
  {
    AppMethodBeat.i(285285);
    com.tencent.mm.plugin.finder.feed.g.a locala = this.Aye;
    if (locala == null) {
      p.bGy("presenter");
    }
    AppMethodBeat.o(285285);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_fav_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(285283);
    this.Ayg = new HashSet();
    MI(0);
    Object localObject1 = z.bdh();
    p.j(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    Object localObject2 = g.Xox;
    localObject1 = new FinderFavFeedLoader((String)localObject1, ((aj)g.b((AppCompatActivity)ebI()).i(aj.class)).ekY(), false);
    ((FinderFavFeedLoader)localObject1).setInitDone((j)new b((FinderFavFeedLoader)localObject1, this));
    ((FinderFavFeedLoader)localObject1).fetchEndCallback = ((b)new c(this));
    this.xMf = ((FinderFavFeedLoader)localObject1);
    localObject1 = (MMActivity)ebI();
    ebI().getCommentScene();
    localObject2 = this.xMf;
    if (localObject2 == null) {
      p.bGy("feedLoader");
    }
    this.Aye = new com.tencent.mm.plugin.finder.feed.g.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.Ayf = ((g.b)new d(this, (MMActivity)ebI(), this.scene, ebI().getCommentScene()));
    localObject1 = this.Ayf;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject2 = this.Aye;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    ((g.b)localObject1).a((c.a)localObject2);
    this.xyI = ((IListener)new e(this));
    EventCenter.instance.add(this.xyI);
    AppMethodBeat.o(285283);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(285290);
    EventCenter.instance.removeListener(this.xyI);
    super.onDestroy();
    AppMethodBeat.o(285290);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(285284);
    super.onResume();
    Object localObject1 = this.Ayg;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Number)((Iterator)localObject1).next()).longValue();
        Object localObject2 = this.xMf;
        if (localObject2 == null) {
          p.bGy("feedLoader");
        }
        ((FinderFavFeedLoader)localObject2).remove(l, true);
        localObject2 = k.Anu;
        k.a.R(l, 10);
        localObject2 = this.xMf;
        if (localObject2 == null) {
          p.bGy("feedLoader");
        }
        if (((FinderFavFeedLoader)localObject2).getSize() == 0)
        {
          localObject2 = this.Ayf;
          if (localObject2 == null) {
            p.bGy("viewCallback");
          }
          ((g.b)localObject2).bTY();
        }
      }
    }
    localObject1 = this.xMf;
    if (localObject1 == null) {
      p.bGy("feedLoader");
    }
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(285284);
      throw ((Throwable)localObject1);
    }
    MI(((FinderFavFeedLoader)localObject1).jlf);
    AppMethodBeat.o(285284);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b(FinderFavFeedLoader paramFinderFavFeedLoader, FinderFavFeedFragment paramFinderFavFeedFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(278512);
      try
      {
        Object localObject = FinderFavFeedFragment.a(jdField_this);
        if (localObject != null)
        {
          localObject = ((g.b)localObject).getEmptyView();
          if (localObject != null)
          {
            ((View)localObject).setVisibility(8);
            localObject = FinderFavFeedFragment.a(jdField_this);
            if (localObject != null)
            {
              localObject = ((c.b)localObject).xvJ.getRecyclerView();
              if (localObject != null) {
                ((RecyclerView)localObject).setVisibility(0);
              }
            }
            EventCenter.instance.publish((IEvent)new hu());
            AppMethodBeat.o(278512);
            return;
          }
        }
        AppMethodBeat.o(278512);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Log.printErrStackTrace(this.xMh.getTAG(), (Throwable)localIllegalStateException, "view illegal stat", new Object[0]);
        AppMethodBeat.o(278512);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$1$2"})
  static final class c
    extends q
    implements b<IResponse<bu>, x>
  {
    c(FinderFavFeedFragment paramFinderFavFeedFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$2", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "getRootView", "Landroid/view/View;", "plugin-finder_release"})
  public static final class d
    extends g.b
  {
    d(MMActivity paramMMActivity, int paramInt1, int paramInt2)
    {
      super(paramInt2, i, (byte)0);
    }
    
    public final View getRootView()
    {
      AppMethodBeat.i(267725);
      View localView = this.Ayi.getView();
      AppMethodBeat.o(267725);
      return localView;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<hu>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$3$callback$1$1"})
    static final class a
      extends q
      implements a<x>
    {
      a(FinderFavFeedFragment.e parame, hu paramhu)
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