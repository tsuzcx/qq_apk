package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.megavideo.ui.c.a;
import com.tencent.mm.plugin.finder.megavideo.ui.c.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "presenter", "unLikeIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnLike", "", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "onDestroy", "onResume", "updateFooterCount", "updateTitle", "count", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLikeMegaVideoFragment
  extends FinderBaseMegaVideoFeedFragment<FinderLikeMegaVideoLoader, c.b, c.a>
{
  public static final a FXQ;
  private HashSet<Long> FXO;
  private c.a FXR;
  private c.b FXS;
  public FinderLikeMegaVideoLoader FXT;
  private IListener<if> qmO;
  
  static
  {
    AppMethodBeat.i(347775);
    FXQ = new a((byte)0);
    AppMethodBeat.o(347775);
  }
  
  public FinderLikeMegaVideoFragment()
  {
    AppMethodBeat.i(347750);
    this.hJx = 103;
    this.FXO = new HashSet();
    AppMethodBeat.o(347750);
  }
  
  private final void fcS()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347757);
    c.b localb = this.FXS;
    Object localObject1 = localb;
    if (localb == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((a.b)localObject1).ATx.getLoadMoreFooter();
    if (localObject1 == null) {}
    for (localObject1 = localObject2;; localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv))
    {
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)getString(e.h.mega_video_like_feed_count_text, new Object[] { Integer.valueOf(fcU().BfD) }));
      }
      AppMethodBeat.o(347757);
      return;
    }
  }
  
  public final void Og(int paramInt)
  {
    AppMethodBeat.i(347809);
    if (paramInt > 0) {
      fcO().setMMTitle(fcO().getResources().getString(e.h.finder_like_feed_title, new Object[] { String.valueOf(paramInt) }));
    }
    for (;;)
    {
      super.Og(paramInt);
      AppMethodBeat.o(347809);
      return;
      fcO().setMMTitle(fcO().getResources().getString(e.h.finder_like_feed_title_zero));
    }
  }
  
  public final FinderLikeMegaVideoLoader fcU()
  {
    AppMethodBeat.i(347781);
    FinderLikeMegaVideoLoader localFinderLikeMegaVideoLoader = this.FXT;
    if (localFinderLikeMegaVideoLoader != null)
    {
      AppMethodBeat.o(347781);
      return localFinderLikeMegaVideoLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(347781);
    return null;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_like_grid_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(347796);
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = new FinderLikeMegaVideoLoader(((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)fcO()).q(as.class)).fou());
    ((FinderLikeMegaVideoLoader)localObject1).setInitDone((j)new b(this));
    ((BaseMegaVideoLoader)localObject1).fetchEndCallback = ((b)new c(this));
    Object localObject2 = ah.aiuX;
    s.u(localObject1, "<set-?>");
    this.FXT = ((FinderLikeMegaVideoLoader)localObject1);
    this.FXR = new c.a((MMActivity)fcO(), fcU());
    localObject1 = (MMActivity)fcO();
    localObject2 = getView();
    s.checkNotNull(localObject2);
    s.s(localObject2, "view!!");
    this.FXS = new c.b((MMActivity)localObject1, (View)localObject2);
    localObject1 = this.FXS;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    for (;;)
    {
      c.a locala = this.FXR;
      localObject2 = locala;
      if (locala == null)
      {
        s.bIx("presenter");
        localObject2 = null;
      }
      ((c.b)localObject1).a((a.a)localObject2);
      this.qmO = ((IListener)new IListener(f.hfK)
      {
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements a<ah>
        {
          a(if paramif, FinderLikeMegaVideoFragment paramFinderLikeMegaVideoFragment)
          {
            super();
          }
        }
      });
      localObject1 = this.qmO;
      if (localObject1 != null) {
        ((IListener)localObject1).alive();
      }
      AppMethodBeat.o(347796);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347813);
    super.onDestroy();
    IListener localIListener = this.qmO;
    if (localIListener != null) {
      localIListener.dead();
    }
    AppMethodBeat.o(347813);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347804);
    super.onResume();
    Iterator localIterator = ((Iterable)this.FXO).iterator();
    while (localIterator.hasNext())
    {
      long l = ((Number)localIterator.next()).longValue();
      l = fcU().pf(l);
      Object localObject = com.tencent.mm.plugin.finder.storage.data.k.FNg;
      k.a.ae(l, 11);
      if (fcU().getSize() == 0)
      {
        c.b localb = this.FXS;
        localObject = localb;
        if (localb == null)
        {
          s.bIx("viewCallback");
          localObject = null;
        }
        ((c.b)localObject).cul();
      }
    }
    this.FXO.clear();
    Og(fcU().lNX);
    fcS();
    AppMethodBeat.o(347804);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(FinderLikeMegaVideoFragment paramFinderLikeMegaVideoFragment) {}
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(347698);
      Object localObject3 = FinderLikeMegaVideoFragment.b(this.FXU);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((c.b)localObject1).getEmptyView();
      if (localObject1 != null)
      {
        localObject3 = this.FXU;
        ((View)localObject1).setVisibility(8);
        localObject1 = FinderLikeMegaVideoFragment.b((FinderLikeMegaVideoFragment)localObject3);
        if (localObject1 != null) {
          break label103;
        }
        s.bIx("viewCallback");
        localObject1 = localObject2;
      }
      label103:
      for (;;)
      {
        localObject1 = ((a.b)localObject1).ATx.getRecyclerView();
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setVisibility(0);
        }
        new if().publish();
        AppMethodBeat.o(347698);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<IResponse<cc>, ah>
  {
    c(FinderLikeMegaVideoFragment paramFinderLikeMegaVideoFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class initOnCreate$2$a
    extends u
    implements a<ah>
  {
    initOnCreate$2$a(if paramif, FinderLikeMegaVideoFragment paramFinderLikeMegaVideoFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLikeMegaVideoFragment
 * JD-Core Version:    0.7.0.1
 */