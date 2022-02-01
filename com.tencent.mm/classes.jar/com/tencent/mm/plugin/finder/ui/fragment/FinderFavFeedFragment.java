package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.g.a;
import com.tencent.mm.plugin.finder.feed.g.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "presenter", "reachBottom", "", "scene", "", "unFavIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnFav", "", "getCommentScene", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getViewCallback", "initAfterAttach", "initOnCreate", "onDestroy", "onResume", "updateTitle", "count", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFavFeedFragment
  extends FinderBaseGridFeedFragment<g.b, g.a>
{
  public static final a FXB;
  public FinderFavFeedLoader Bmp;
  private g.a FXC;
  private g.b FXD;
  private HashSet<Long> FXE;
  private boolean FXF;
  private IListener<if> qmO;
  private final int scene = 2;
  
  static
  {
    AppMethodBeat.i(347758);
    FXB = new a((byte)0);
    AppMethodBeat.o(347758);
  }
  
  public FinderFavFeedFragment()
  {
    this.hJx = 100;
  }
  
  public final void Og(int paramInt)
  {
    AppMethodBeat.i(347800);
    d locald = d.FAy;
    if (((Number)d.eXJ().bmg()).intValue() == 0) {
      if (paramInt > 0) {
        getActivity().setMMTitle(getActivity().getResources().getString(e.h.finder_fav_feed_title, new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    for (;;)
    {
      super.Og(paramInt);
      AppMethodBeat.o(347800);
      return;
      getActivity().setMMTitle(getActivity().getResources().getString(e.h.finder_fav_feed_title_zero));
      continue;
      if (paramInt > 0) {
        getActivity().setMMTitle(getActivity().getResources().getString(e.h.finder_fav_feed_title2, new Object[] { Integer.valueOf(paramInt) }));
      } else {
        getActivity().setMMTitle(getActivity().getResources().getString(e.h.finder_fav_feed_title_zero2));
      }
    }
  }
  
  public final FinderFavFeedLoader fcP()
  {
    AppMethodBeat.i(347763);
    FinderFavFeedLoader localFinderFavFeedLoader = this.Bmp;
    if (localFinderFavFeedLoader != null)
    {
      AppMethodBeat.o(347763);
      return localFinderFavFeedLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(347763);
    return null;
  }
  
  public final g.a fcQ()
  {
    AppMethodBeat.i(347791);
    g.a locala = this.FXC;
    if (locala == null)
    {
      s.bIx("presenter");
      AppMethodBeat.o(347791);
      return null;
    }
    AppMethodBeat.o(347791);
    return locala;
  }
  
  public final int getCommentScene()
  {
    return 24;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_fav_list_layout;
  }
  
  public final void initOnCreate()
  {
    int j = 0;
    AppMethodBeat.i(347780);
    this.FXE = new HashSet();
    Og(0);
    Object localObject1 = z.bAW();
    s.s(localObject1, "getMyFinderUsername()");
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = new FinderFavFeedLoader((String)localObject1, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)getActivity()).q(as.class)).fou(), false);
    ((FinderFavFeedLoader)localObject1).setInitDone((j)new b(this, (FinderFavFeedLoader)localObject1));
    ((FinderFavFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new c(this));
    localObject2 = ah.aiuX;
    s.u(localObject1, "<set-?>");
    this.Bmp = ((FinderFavFeedLoader)localObject1);
    localObject2 = getActivity();
    localObject1 = getActivity();
    int i;
    if ((localObject1 instanceof MMFinderUI))
    {
      localObject1 = (MMFinderUI)localObject1;
      if (localObject1 != null) {
        break label338;
      }
      i = 0;
      label161:
      this.FXC = new g.a((MMActivity)localObject2, i, (BaseFinderFeedLoader)fcP());
      localObject2 = getActivity();
      int k = this.scene;
      localObject1 = getActivity();
      if (!(localObject1 instanceof MMFinderUI)) {
        break label347;
      }
      localObject1 = (MMFinderUI)localObject1;
      label214:
      if (localObject1 != null) {
        break label353;
      }
      i = j;
      label221:
      this.FXD = ((g.b)new d(this, (MMActivity)localObject2, k, i));
      localObject1 = this.FXD;
      if (localObject1 != null) {
        break label362;
      }
      s.bIx("viewCallback");
      localObject1 = null;
    }
    label338:
    label347:
    label353:
    label362:
    for (;;)
    {
      g.a locala = this.FXC;
      localObject2 = locala;
      if (locala == null)
      {
        s.bIx("presenter");
        localObject2 = null;
      }
      ((g.b)localObject1).a((c.a)localObject2);
      this.qmO = ((IListener)new IListener(f.hfK)
      {
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements a<ah>
        {
          a(if paramif, FinderFavFeedFragment paramFinderFavFeedFragment)
          {
            super();
          }
        }
      });
      localObject1 = this.qmO;
      if (localObject1 != null) {
        ((IListener)localObject1).alive();
      }
      AppMethodBeat.o(347780);
      return;
      localObject1 = null;
      break;
      i = ((MMFinderUI)localObject1).getCommentScene();
      break label161;
      localObject1 = null;
      break label214;
      i = ((MMFinderUI)localObject1).getCommentScene();
      break label221;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347805);
    IListener localIListener = this.qmO;
    if (localIListener != null) {
      localIListener.dead();
    }
    super.onDestroy();
    AppMethodBeat.o(347805);
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347786);
    super.onResume();
    Object localObject1 = this.FXE;
    g.b localb;
    if (localObject1 != null)
    {
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        long l = ((Number)localIterator.next()).longValue();
        fcP().remove(l, true);
        localObject1 = com.tencent.mm.plugin.finder.storage.data.k.FNg;
        k.a.ad(l, 10);
        if (fcP().getSize() == 0)
        {
          localb = this.FXD;
          localObject1 = localb;
          if (localb == null)
          {
            s.bIx("viewCallback");
            localObject1 = null;
          }
          ((g.b)localObject1).cul();
          localb = this.FXD;
          localObject1 = localb;
          if (localb == null)
          {
            s.bIx("viewCallback");
            localObject1 = null;
          }
          localObject1 = ((c.b)localObject1).ATx.getLoadMoreFooter();
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(4);
          }
        }
      }
    }
    localObject1 = this.FXE;
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (i > 0)
      {
        localb = this.FXD;
        localObject1 = localb;
        if (localb == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        ((g.b)localObject1).eca();
      }
      Og(fcP().lNX);
      if (this.FXF)
      {
        localObject1 = this.FXD;
        if (localObject1 != null) {
          break label270;
        }
        s.bIx("viewCallback");
        localObject1 = localObject2;
      }
    }
    label270:
    for (;;)
    {
      ((g.b)localObject1).eca();
      AppMethodBeat.o(347786);
      return;
      i = ((HashSet)localObject1).size();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(FinderFavFeedFragment paramFinderFavFeedFragment, FinderFavFeedLoader paramFinderFavFeedLoader) {}
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(347711);
      try
      {
        Object localObject3 = FinderFavFeedFragment.b(this.FXG);
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((g.b)localObject1).getEmptyView();
        if (localObject1 != null)
        {
          localObject3 = this.FXG;
          ((View)localObject1).setVisibility(8);
          localObject1 = FinderFavFeedFragment.b((FinderFavFeedFragment)localObject3);
          if (localObject1 == null)
          {
            s.bIx("viewCallback");
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject1 = ((c.b)localObject1).ATx.getRecyclerView();
            if (localObject1 != null) {
              ((RecyclerView)localObject1).setVisibility(0);
            }
            new if().publish();
            AppMethodBeat.o(347711);
            return;
          }
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Log.printErrStackTrace(this.Bms.getTAG(), (Throwable)localIllegalStateException, "view illegal stat", new Object[0]);
        AppMethodBeat.o(347711);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    c(FinderFavFeedFragment paramFinderFavFeedFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$2", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "getRootView", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends g.b
  {
    d(FinderFavFeedFragment paramFinderFavFeedFragment, MMActivity paramMMActivity, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2, (byte)0);
    }
    
    public final View getRootView()
    {
      AppMethodBeat.i(347705);
      View localView = this.FXG.getView();
      AppMethodBeat.o(347705);
      return localView;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class initOnCreate$3$a
    extends u
    implements a<ah>
  {
    initOnCreate$3$a(if paramif, FinderFavFeedFragment paramFinderFavFeedFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderFavFeedFragment
 * JD-Core Version:    0.7.0.1
 */