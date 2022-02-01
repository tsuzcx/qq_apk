package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.megavideo.ui.c.a;
import com.tencent.mm.plugin.finder.megavideo.ui.c.b;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "presenter", "unLikeIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnLike", "", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "onDestroy", "onResume", "updateFooterCount", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderLikeMegaVideoFragment
  extends FinderBaseMegaVideoFeedFragment<FinderLikeMegaVideoLoader, c.b, c.a>
{
  public static final a Ayz;
  private HashSet<Long> Ayt;
  private c.a Ayw;
  private c.b Ayx;
  public FinderLikeMegaVideoLoader Ayy;
  private HashMap _$_findViewCache;
  private IListener<hu> xyI;
  
  static
  {
    AppMethodBeat.i(272946);
    Ayz = new a((byte)0);
    AppMethodBeat.o(272946);
  }
  
  public FinderLikeMegaVideoFragment()
  {
    AppMethodBeat.i(272945);
    this.fEH = 103;
    this.Ayt = new HashSet();
    AppMethodBeat.o(272945);
  }
  
  private final void ebM()
  {
    AppMethodBeat.i(272940);
    Object localObject = this.Ayx;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    localObject = ((a.b)localObject).xvJ.getLoadMoreFooter();
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
      if (localObject != null)
      {
        int i = b.j.mega_video_like_feed_count_text;
        FinderLikeMegaVideoLoader localFinderLikeMegaVideoLoader = this.Ayy;
        if (localFinderLikeMegaVideoLoader == null) {
          p.bGy("feedLoader");
        }
        ((TextView)localObject).setText((CharSequence)getString(i, new Object[] { Integer.valueOf(localFinderLikeMegaVideoLoader.xGy) }));
        AppMethodBeat.o(272940);
        return;
      }
    }
    AppMethodBeat.o(272940);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(272950);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(272950);
  }
  
  public final FinderLikeMegaVideoLoader ebO()
  {
    AppMethodBeat.i(272934);
    FinderLikeMegaVideoLoader localFinderLikeMegaVideoLoader = this.Ayy;
    if (localFinderLikeMegaVideoLoader == null) {
      p.bGy("feedLoader");
    }
    AppMethodBeat.o(272934);
    return localFinderLikeMegaVideoLoader;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_like_grid_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(272937);
    Object localObject1 = g.Xox;
    localObject1 = new FinderLikeMegaVideoLoader(((aj)g.b((AppCompatActivity)ebI()).i(aj.class)).ekY());
    ((FinderLikeMegaVideoLoader)localObject1).setInitDone((j)new b(this));
    ((BaseMegaVideoLoader)localObject1).fetchEndCallback = ((b)new c(this));
    this.Ayy = ((FinderLikeMegaVideoLoader)localObject1);
    localObject1 = (MMActivity)ebI();
    Object localObject2 = this.Ayy;
    if (localObject2 == null) {
      p.bGy("feedLoader");
    }
    this.Ayw = new c.a((MMActivity)localObject1, (FinderLikeMegaVideoLoader)localObject2);
    localObject1 = (MMActivity)ebI();
    localObject2 = getView();
    if (localObject2 == null) {
      p.iCn();
    }
    p.j(localObject2, "view!!");
    this.Ayx = new c.b((MMActivity)localObject1, (View)localObject2);
    localObject1 = this.Ayx;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject2 = this.Ayw;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    ((c.b)localObject1).a((a.a)localObject2);
    this.xyI = ((IListener)new d(this));
    localObject1 = this.xyI;
    if (localObject1 != null)
    {
      ((IListener)localObject1).alive();
      AppMethodBeat.o(272937);
      return;
    }
    AppMethodBeat.o(272937);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(272941);
    super.onDestroy();
    IListener localIListener = this.xyI;
    if (localIListener != null)
    {
      localIListener.dead();
      AppMethodBeat.o(272941);
      return;
    }
    AppMethodBeat.o(272941);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(272938);
    super.onResume();
    Object localObject1 = ((Iterable)this.Ayt).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      long l = ((Number)((Iterator)localObject1).next()).longValue();
      Object localObject2 = this.Ayy;
      if (localObject2 == null) {
        p.bGy("feedLoader");
      }
      l = ((FinderLikeMegaVideoLoader)localObject2).LY(l);
      localObject2 = k.Anu;
      k.a.S(l, 11);
      localObject2 = this.Ayy;
      if (localObject2 == null) {
        p.bGy("feedLoader");
      }
      if (((FinderLikeMegaVideoLoader)localObject2).getSize() == 0)
      {
        localObject2 = this.Ayx;
        if (localObject2 == null) {
          p.bGy("viewCallback");
        }
        ((c.b)localObject2).bTY();
      }
    }
    this.Ayt.clear();
    localObject1 = this.Ayy;
    if (localObject1 == null) {
      p.bGy("feedLoader");
    }
    int i = ((FinderLikeMegaVideoLoader)localObject1).jlf;
    if (i > 0) {
      ebI().setMMTitle(ebI().getResources().getString(b.j.finder_like_feed_title, new Object[] { String.valueOf(i) }));
    }
    for (;;)
    {
      ebM();
      AppMethodBeat.o(272938);
      return;
      ebI().setMMTitle(ebI().getResources().getString(b.j.finder_like_feed_title_zero));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b(FinderLikeMegaVideoFragment paramFinderLikeMegaVideoFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(286736);
      Object localObject = FinderLikeMegaVideoFragment.a(this.AyA);
      if (localObject != null)
      {
        localObject = ((c.b)localObject).getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          localObject = FinderLikeMegaVideoFragment.a(this.AyA);
          if (localObject != null)
          {
            localObject = ((a.b)localObject).xvJ.getRecyclerView();
            if (localObject != null) {
              ((RecyclerView)localObject).setVisibility(0);
            }
          }
          EventCenter.instance.publish((IEvent)new hu());
          AppMethodBeat.o(286736);
          return;
        }
      }
      AppMethodBeat.o(286736);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$1$2"})
  static final class c
    extends q
    implements b<IResponse<bu>, x>
  {
    c(FinderLikeMegaVideoFragment paramFinderLikeMegaVideoFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hu>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$2$callback$1$1"})
    static final class a
      extends q
      implements a<x>
    {
      a(FinderLikeMegaVideoFragment.d paramd, hu paramhu)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLikeMegaVideoFragment
 * JD-Core Version:    0.7.0.1
 */