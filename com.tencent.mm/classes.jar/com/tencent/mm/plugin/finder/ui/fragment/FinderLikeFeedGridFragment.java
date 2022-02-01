package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader.b;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.z.a;
import com.tencent.mm.plugin.finder.feed.z.b;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedPresenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "presenter", "scene", "", "unLikeIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnLike", "", "getCommentScene", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getViewCallback", "initAfterAttach", "initOnCreate", "onDestroy", "onResume", "updateTitle", "count", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLikeFeedGridFragment
  extends FinderBaseGridFeedFragment<z.b, z.a>
{
  public FinderLikedFeedLoader EXX;
  private z.a FXM;
  private z.b FXN;
  private HashSet<Long> FXO;
  private IListener<if> qmO;
  private final int scene = 2;
  
  public FinderLikeFeedGridFragment()
  {
    this.hJx = 102;
  }
  
  public final void Og(int paramInt)
  {
    AppMethodBeat.i(347699);
    if (paramInt > 0) {
      getActivity().setMMTitle(getActivity().getResources().getString(e.h.finder_like_feed_title, new Object[] { String.valueOf(paramInt) }));
    }
    for (;;)
    {
      super.Og(paramInt);
      AppMethodBeat.o(347699);
      return;
      getActivity().setMMTitle(getActivity().getResources().getString(e.h.finder_like_feed_title_zero));
    }
  }
  
  public final FinderLikedFeedLoader fcT()
  {
    AppMethodBeat.i(347668);
    FinderLikedFeedLoader localFinderLikedFeedLoader = this.EXX;
    if (localFinderLikedFeedLoader != null)
    {
      AppMethodBeat.o(347668);
      return localFinderLikedFeedLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(347668);
    return null;
  }
  
  public final int getCommentScene()
  {
    return 35;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_like_grid_list_layout;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(347685);
    this.FXO = new HashSet();
    Og(0);
    Object localObject1 = g.Bkl;
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = new FinderLikedFeedLoader(false, (g)localObject1, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)getActivity()).q(as.class)).fou());
    ((FinderLikedFeedLoader)localObject1).setInitDone((j)new a(this));
    ((FinderLikedFeedLoader)localObject1).BbB = ((a)new b(this));
    ((FinderLikedFeedLoader)localObject1).BgZ = ((b)new c(this, (FinderLikedFeedLoader)localObject1));
    localObject2 = ah.aiuX;
    s.u(localObject1, "<set-?>");
    this.EXX = ((FinderLikedFeedLoader)localObject1);
    localObject2 = getActivity();
    localObject1 = getActivity();
    int i;
    if ((localObject1 instanceof MMFinderUI))
    {
      localObject1 = (MMFinderUI)localObject1;
      if (localObject1 != null) {
        break label313;
      }
      i = 0;
      label152:
      this.FXM = new z.a((MMActivity)localObject2, i, (BaseFinderFeedLoader)fcT());
      localObject2 = getActivity();
      int j = this.scene;
      localObject1 = getActivity();
      if (!(localObject1 instanceof MMFinderUI)) {
        break label321;
      }
      localObject1 = (MMFinderUI)localObject1;
      label201:
      if (localObject1 != null) {
        break label326;
      }
      i = 0;
      label207:
      this.FXN = new z.b((MMActivity)localObject2, j, i, (byte)0);
      localObject1 = this.FXN;
      if (localObject1 != null) {
        break label334;
      }
      s.bIx("viewCallback");
      localObject1 = null;
    }
    label313:
    label321:
    label326:
    label334:
    for (;;)
    {
      z.a locala = this.FXM;
      localObject2 = locala;
      if (locala == null)
      {
        s.bIx("presenter");
        localObject2 = null;
      }
      ((z.b)localObject1).a((c.a)localObject2);
      this.qmO = ((IListener)new IListener(f.hfK)
      {
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements a<ah>
        {
          a(if paramif, FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment)
          {
            super();
          }
        }
      });
      localObject1 = this.qmO;
      if (localObject1 != null) {
        ((IListener)localObject1).alive();
      }
      AppMethodBeat.o(347685);
      return;
      localObject1 = null;
      break;
      i = ((MMFinderUI)localObject1).getCommentScene();
      break label152;
      localObject1 = null;
      break label201;
      i = ((MMFinderUI)localObject1).getCommentScene();
      break label207;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347707);
    IListener localIListener = this.qmO;
    if (localIListener != null) {
      localIListener.dead();
    }
    super.onDestroy();
    AppMethodBeat.o(347707);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347693);
    super.onResume();
    Object localObject = this.FXO;
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      while (localIterator.hasNext())
      {
        long l = ((Number)localIterator.next()).longValue();
        fcT().remove(l, true);
        localObject = com.tencent.mm.plugin.finder.storage.data.k.FNg;
        k.a.ad(l, 2);
        if (fcT().getSize() == 0)
        {
          z.b localb = this.FXN;
          localObject = localb;
          if (localb == null)
          {
            s.bIx("viewCallback");
            localObject = null;
          }
          ((z.b)localObject).cul();
        }
      }
    }
    Og(fcT().lNX);
    AppMethodBeat.o(347693);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements j
  {
    a(FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment) {}
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(347649);
      Object localObject3 = FinderLikeFeedGridFragment.b(this.FXP);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((z.b)localObject1).getEmptyView();
      if (localObject1 != null)
      {
        localObject3 = this.FXP;
        ((View)localObject1).setVisibility(8);
        localObject1 = FinderLikeFeedGridFragment.b((FinderLikeFeedGridFragment)localObject3);
        if (localObject1 != null) {
          break label103;
        }
        s.bIx("viewCallback");
        localObject1 = localObject2;
      }
      label103:
      for (;;)
      {
        localObject1 = ((c.b)localObject1).ATx.getRecyclerView();
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setVisibility(0);
        }
        new if().publish();
        AppMethodBeat.o(347649);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<FinderLikedFeedLoader.b, ah>
  {
    c(FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment, FinderLikedFeedLoader paramFinderLikedFeedLoader)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class initOnCreate$2$a
    extends u
    implements a<ah>
  {
    initOnCreate$2$a(if paramif, FinderLikeFeedGridFragment paramFinderLikeFeedGridFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLikeFeedGridFragment
 * JD-Core Version:    0.7.0.1
 */