package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.megavideo.ui.b.a;
import com.tencent.mm.plugin.finder.megavideo.ui.b.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "presenter", "unFavIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnFav", "", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "onDestroy", "onResume", "updateFooterCount", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFavMegaVideoFragment
  extends FinderBaseMegaVideoFeedFragment<FinderFavMegaVideoLoader, b.b, b.a>
{
  public static final a Ayo;
  private HashSet<Long> Ayg;
  private b.a Ayl;
  private b.b Aym;
  public FinderFavMegaVideoLoader Ayn;
  private HashMap _$_findViewCache;
  private IListener<hu> xyI;
  
  static
  {
    AppMethodBeat.i(290251);
    Ayo = new a((byte)0);
    AppMethodBeat.o(290251);
  }
  
  public FinderFavMegaVideoFragment()
  {
    AppMethodBeat.i(290250);
    this.fEH = 101;
    this.Ayg = new HashSet();
    AppMethodBeat.o(290250);
  }
  
  private final void ebM()
  {
    AppMethodBeat.i(290249);
    Object localObject = this.Aym;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    localObject = ((a.b)localObject).xvJ.getLoadMoreFooter();
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
      if (localObject != null)
      {
        int i = b.j.mega_video_fav_feed_count_text;
        FinderFavMegaVideoLoader localFinderFavMegaVideoLoader = this.Ayn;
        if (localFinderFavMegaVideoLoader == null) {
          p.bGy("feedLoader");
        }
        ((TextView)localObject).setText((CharSequence)getString(i, new Object[] { Integer.valueOf(localFinderFavMegaVideoLoader.xGy) }));
        AppMethodBeat.o(290249);
        return;
      }
    }
    AppMethodBeat.o(290249);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(290254);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(290254);
  }
  
  public final FinderFavMegaVideoLoader ebL()
  {
    AppMethodBeat.i(290242);
    FinderFavMegaVideoLoader localFinderFavMegaVideoLoader = this.Ayn;
    if (localFinderFavMegaVideoLoader == null) {
      p.bGy("feedLoader");
    }
    AppMethodBeat.o(290242);
    return localFinderFavMegaVideoLoader;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_fav_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(290243);
    Object localObject1 = z.bdh();
    p.j(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    Object localObject2 = g.Xox;
    localObject1 = new FinderFavMegaVideoLoader((String)localObject1, ((aj)g.b((AppCompatActivity)ebI()).i(aj.class)).ekY());
    ((FinderFavMegaVideoLoader)localObject1).setInitDone((j)new b(this));
    ((BaseMegaVideoLoader)localObject1).fetchEndCallback = ((b)new c(this));
    this.Ayn = ((FinderFavMegaVideoLoader)localObject1);
    localObject1 = (MMActivity)ebI();
    localObject2 = this.Ayn;
    if (localObject2 == null) {
      p.bGy("feedLoader");
    }
    this.Ayl = new b.a((MMActivity)localObject1, (FinderFavMegaVideoLoader)localObject2);
    localObject1 = (MMActivity)ebI();
    localObject2 = getView();
    if (localObject2 == null) {
      p.iCn();
    }
    p.j(localObject2, "view!!");
    this.Aym = new b.b((MMActivity)localObject1, (View)localObject2);
    localObject1 = this.Aym;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject2 = this.Ayl;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    ((b.b)localObject1).a((a.a)localObject2);
    this.xyI = ((IListener)new d(this));
    localObject1 = this.xyI;
    if (localObject1 != null)
    {
      ((IListener)localObject1).alive();
      AppMethodBeat.o(290243);
      return;
    }
    AppMethodBeat.o(290243);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(290246);
    super.onDestroy();
    IListener localIListener = this.xyI;
    if (localIListener != null)
    {
      localIListener.dead();
      AppMethodBeat.o(290246);
      return;
    }
    AppMethodBeat.o(290246);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(290244);
    super.onResume();
    Object localObject1 = ((Iterable)this.Ayg).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      long l = ((Number)((Iterator)localObject1).next()).longValue();
      Object localObject2 = this.Ayn;
      if (localObject2 == null) {
        p.bGy("feedLoader");
      }
      l = ((FinderFavMegaVideoLoader)localObject2).LY(l);
      localObject2 = k.Anu;
      k.a.S(l, 12);
      localObject2 = this.Ayn;
      if (localObject2 == null) {
        p.bGy("feedLoader");
      }
      if (((FinderFavMegaVideoLoader)localObject2).getSize() == 0)
      {
        localObject2 = this.Aym;
        if (localObject2 == null) {
          p.bGy("viewCallback");
        }
        ((b.b)localObject2).bTY();
      }
    }
    this.Ayg.clear();
    localObject1 = this.Ayn;
    if (localObject1 == null) {
      p.bGy("feedLoader");
    }
    int i = ((FinderFavMegaVideoLoader)localObject1).jlf;
    if (i > 0) {
      ebI().setMMTitle(ebI().getResources().getString(b.j.finder_fav_feed_title, new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      ebM();
      AppMethodBeat.o(290244);
      return;
      ebI().setMMTitle(ebI().getResources().getString(b.j.finder_fav_feed_title_zero));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b(FinderFavMegaVideoFragment paramFinderFavMegaVideoFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(289047);
      Object localObject = FinderFavMegaVideoFragment.a(this.Ayp);
      if (localObject != null)
      {
        localObject = ((b.b)localObject).getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          localObject = FinderFavMegaVideoFragment.a(this.Ayp);
          if (localObject != null)
          {
            localObject = ((a.b)localObject).xvJ.getRecyclerView();
            if (localObject != null) {
              ((RecyclerView)localObject).setVisibility(0);
            }
          }
          EventCenter.instance.publish((IEvent)new hu());
          AppMethodBeat.o(289047);
          return;
        }
      }
      AppMethodBeat.o(289047);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$1$2"})
  static final class c
    extends q
    implements b<IResponse<bu>, x>
  {
    c(FinderFavMegaVideoFragment paramFinderFavMegaVideoFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hu>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$2$callback$1$1"})
    static final class a
      extends q
      implements a<x>
    {
      a(FinderFavMegaVideoFragment.d paramd, hu paramhu)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFavMegaVideoFragment
 * JD-Core Version:    0.7.0.1
 */