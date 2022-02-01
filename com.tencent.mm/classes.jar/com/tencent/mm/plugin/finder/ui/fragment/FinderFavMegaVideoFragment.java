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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.megavideo.ui.b.a;
import com.tencent.mm.plugin.finder.megavideo.ui.b.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.d;
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
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "presenter", "unFavIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnFav", "", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "onDestroy", "onResume", "updateFooterCount", "updateTitle", "count", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFavMegaVideoFragment
  extends FinderBaseMegaVideoFeedFragment<FinderFavMegaVideoLoader, b.b, b.a>
{
  public static final a FXH;
  private HashSet<Long> FXE;
  private b.a FXI;
  private b.b FXJ;
  public FinderFavMegaVideoLoader FXK;
  private IListener<if> qmO;
  
  static
  {
    AppMethodBeat.i(347697);
    FXH = new a((byte)0);
    AppMethodBeat.o(347697);
  }
  
  public FinderFavMegaVideoFragment()
  {
    AppMethodBeat.i(347667);
    this.hJx = 101;
    this.FXE = new HashSet();
    AppMethodBeat.o(347667);
  }
  
  private final void fcS()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347674);
    b.b localb = this.FXJ;
    Object localObject1 = localb;
    if (localb == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((a.b)localObject1).ATx.getLoadMoreFooter();
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      if (localObject1 != null)
      {
        localObject2 = d.FAy;
        if (((Number)d.eXJ().bmg()).intValue() != 0) {
          break label115;
        }
      }
    }
    label115:
    for (localObject2 = (CharSequence)getString(e.h.mega_video_fav_feed_count_text, new Object[] { Integer.valueOf(fcR().BfD) });; localObject2 = (CharSequence)getString(e.h.mega_video_fav_feed_count_text2, new Object[] { Integer.valueOf(fcR().BfD) }))
    {
      ((TextView)localObject1).setText((CharSequence)localObject2);
      AppMethodBeat.o(347674);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
      break;
    }
  }
  
  public final void Og(int paramInt)
  {
    AppMethodBeat.i(347739);
    d locald = d.FAy;
    if (((Number)d.eXJ().bmg()).intValue() == 0) {
      if (paramInt > 0) {
        fcO().setMMTitle(fcO().getResources().getString(e.h.finder_fav_feed_title, new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    for (;;)
    {
      super.Og(paramInt);
      AppMethodBeat.o(347739);
      return;
      fcO().setMMTitle(fcO().getResources().getString(e.h.finder_fav_feed_title_zero));
      continue;
      if (paramInt > 0) {
        fcO().setMMTitle(fcO().getResources().getString(e.h.finder_fav_feed_title2, new Object[] { Integer.valueOf(paramInt) }));
      } else {
        fcO().setMMTitle(fcO().getResources().getString(e.h.finder_fav_feed_title_zero2));
      }
    }
  }
  
  public final FinderFavMegaVideoLoader fcR()
  {
    AppMethodBeat.i(347704);
    FinderFavMegaVideoLoader localFinderFavMegaVideoLoader = this.FXK;
    if (localFinderFavMegaVideoLoader != null)
    {
      AppMethodBeat.o(347704);
      return localFinderFavMegaVideoLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(347704);
    return null;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_fav_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(347716);
    Object localObject1 = z.bAW();
    s.s(localObject1, "getMyFinderUsername()");
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = new FinderFavMegaVideoLoader((String)localObject1, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)fcO()).q(as.class)).fou());
    ((FinderFavMegaVideoLoader)localObject1).setInitDone((j)new b(this));
    ((BaseMegaVideoLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new c(this));
    localObject2 = ah.aiuX;
    s.u(localObject1, "<set-?>");
    this.FXK = ((FinderFavMegaVideoLoader)localObject1);
    this.FXI = new b.a((MMActivity)fcO(), fcR());
    localObject1 = (MMActivity)fcO();
    localObject2 = getView();
    s.checkNotNull(localObject2);
    s.s(localObject2, "view!!");
    this.FXJ = new b.b((MMActivity)localObject1, (View)localObject2);
    localObject1 = this.FXJ;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    for (;;)
    {
      b.a locala = this.FXI;
      localObject2 = locala;
      if (locala == null)
      {
        s.bIx("presenter");
        localObject2 = null;
      }
      ((b.b)localObject1).a((a.a)localObject2);
      this.qmO = ((IListener)new IListener(f.hfK)
      {
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements a<ah>
        {
          a(if paramif, FinderFavMegaVideoFragment paramFinderFavMegaVideoFragment)
          {
            super();
          }
        }
      });
      localObject1 = this.qmO;
      if (localObject1 != null) {
        ((IListener)localObject1).alive();
      }
      AppMethodBeat.o(347716);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347731);
    super.onDestroy();
    IListener localIListener = this.qmO;
    if (localIListener != null) {
      localIListener.dead();
    }
    AppMethodBeat.o(347731);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347726);
    super.onResume();
    Iterator localIterator = ((Iterable)this.FXE).iterator();
    while (localIterator.hasNext())
    {
      long l = ((Number)localIterator.next()).longValue();
      l = fcR().pf(l);
      Object localObject = com.tencent.mm.plugin.finder.storage.data.k.FNg;
      k.a.ae(l, 12);
      if (fcR().getSize() == 0)
      {
        b.b localb = this.FXJ;
        localObject = localb;
        if (localb == null)
        {
          s.bIx("viewCallback");
          localObject = null;
        }
        ((b.b)localObject).cul();
      }
    }
    this.FXE.clear();
    Og(fcR().lNX);
    fcS();
    AppMethodBeat.o(347726);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(FinderFavMegaVideoFragment paramFinderFavMegaVideoFragment) {}
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(347651);
      Object localObject3 = FinderFavMegaVideoFragment.b(this.FXL);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).getEmptyView();
      if (localObject1 != null)
      {
        localObject3 = this.FXL;
        ((View)localObject1).setVisibility(8);
        localObject1 = FinderFavMegaVideoFragment.b((FinderFavMegaVideoFragment)localObject3);
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
        AppMethodBeat.o(347651);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    c(FinderFavMegaVideoFragment paramFinderFavMegaVideoFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class initOnCreate$2$a
    extends u
    implements a<ah>
  {
    initOnCreate$2$a(if paramif, FinderFavMegaVideoFragment paramFinderFavMegaVideoFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFavMegaVideoFragment
 * JD-Core Version:    0.7.0.1
 */