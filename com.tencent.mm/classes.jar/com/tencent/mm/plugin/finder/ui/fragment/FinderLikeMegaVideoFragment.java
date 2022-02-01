package com.tencent.mm.plugin.finder.ui.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.megavideo.ui.c.a;
import com.tencent.mm.plugin.finder.megavideo.ui.c.b;
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
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "presenter", "unLikeIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnLike", "", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "onDestroy", "onResume", "updateFooterCount", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderLikeMegaVideoFragment
  extends FinderBaseMegaVideoFeedFragment<FinderLikeMegaVideoLoader, c.b, c.a>
{
  public static final a vQN;
  private HashMap _$_findViewCache;
  private IListener<hn> tOh;
  private HashSet<Long> vQH;
  private c.a vQK;
  private c.b vQL;
  public FinderLikeMegaVideoLoader vQM;
  
  static
  {
    AppMethodBeat.i(252923);
    vQN = new a((byte)0);
    AppMethodBeat.o(252923);
  }
  
  public FinderLikeMegaVideoFragment()
  {
    AppMethodBeat.i(252922);
    this.dLS = 103;
    this.vQH = new HashSet();
    AppMethodBeat.o(252922);
  }
  
  private final void dAu()
  {
    AppMethodBeat.i(252918);
    Object localObject = this.vQL;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    localObject = ((a.b)localObject).tLS.getLoadMoreFooter();
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131303685);
      if (localObject != null)
      {
        FinderLikeMegaVideoLoader localFinderLikeMegaVideoLoader = this.vQM;
        if (localFinderLikeMegaVideoLoader == null) {
          p.btv("feedLoader");
        }
        ((TextView)localObject).setText((CharSequence)getString(2131763018, new Object[] { Integer.valueOf(localFinderLikeMegaVideoLoader.tUU) }));
        AppMethodBeat.o(252918);
        return;
      }
    }
    AppMethodBeat.o(252918);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252926);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252926);
  }
  
  public final FinderLikeMegaVideoLoader dAw()
  {
    AppMethodBeat.i(252915);
    FinderLikeMegaVideoLoader localFinderLikeMegaVideoLoader = this.vQM;
    if (localFinderLikeMegaVideoLoader == null) {
      p.btv("feedLoader");
    }
    AppMethodBeat.o(252915);
    return localFinderLikeMegaVideoLoader;
  }
  
  public final int getLayoutId()
  {
    return 2131494357;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(252916);
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = new FinderLikeMegaVideoLoader(((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)dAq()).get(FinderReporterUIC.class)).dIx());
    ((FinderLikeMegaVideoLoader)localObject1).setInitDone((h)new b(this));
    ((BaseMegaVideoLoader)localObject1).fetchEndCallback = ((b)new c(this));
    this.vQM = ((FinderLikeMegaVideoLoader)localObject1);
    localObject1 = (MMActivity)dAq();
    Object localObject2 = this.vQM;
    if (localObject2 == null) {
      p.btv("feedLoader");
    }
    this.vQK = new c.a((MMActivity)localObject1, (FinderLikeMegaVideoLoader)localObject2);
    localObject1 = (MMActivity)dAq();
    localObject2 = getView();
    if (localObject2 == null) {
      p.hyc();
    }
    p.g(localObject2, "view!!");
    this.vQL = new c.b((MMActivity)localObject1, (View)localObject2);
    localObject1 = this.vQL;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject2 = this.vQK;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    ((c.b)localObject1).a((a.a)localObject2);
    this.tOh = ((IListener)new d(this));
    localObject1 = this.tOh;
    if (localObject1 != null)
    {
      ((IListener)localObject1).alive();
      AppMethodBeat.o(252916);
      return;
    }
    AppMethodBeat.o(252916);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252919);
    super.onDestroy();
    IListener localIListener = this.tOh;
    if (localIListener != null)
    {
      localIListener.dead();
      AppMethodBeat.o(252919);
      return;
    }
    AppMethodBeat.o(252919);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252917);
    super.onResume();
    Object localObject1 = ((Iterable)this.vQH).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      long l = ((Number)((Iterator)localObject1).next()).longValue();
      Object localObject2 = this.vQM;
      if (localObject2 == null) {
        p.btv("feedLoader");
      }
      l = ((FinderLikeMegaVideoLoader)localObject2).ER(l);
      localObject2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
      l.a.M(l, 11);
      localObject2 = this.vQM;
      if (localObject2 == null) {
        p.btv("feedLoader");
      }
      if (((FinderLikeMegaVideoLoader)localObject2).getSize() == 0)
      {
        localObject2 = this.vQL;
        if (localObject2 == null) {
          p.btv("viewCallback");
        }
        ((c.b)localObject2).bIo();
      }
    }
    this.vQH.clear();
    localObject1 = this.vQM;
    if (localObject1 == null) {
      p.btv("feedLoader");
    }
    int i = ((FinderLikeMegaVideoLoader)localObject1).gAZ;
    if (i > 0) {
      dAq().setMMTitle(dAq().getResources().getString(2131759840, new Object[] { String.valueOf(i) }));
    }
    for (;;)
    {
      dAu();
      AppMethodBeat.o(252917);
      return;
      dAq().setMMTitle(dAq().getResources().getString(2131759841));
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements h
  {
    b(FinderLikeMegaVideoFragment paramFinderLikeMegaVideoFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(252911);
      Object localObject = FinderLikeMegaVideoFragment.a(this.vQO);
      if (localObject != null)
      {
        localObject = ((c.b)localObject).getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          localObject = FinderLikeMegaVideoFragment.a(this.vQO);
          if (localObject != null)
          {
            localObject = ((a.b)localObject).tLS.getRecyclerView();
            if (localObject != null) {
              ((RecyclerView)localObject).setVisibility(0);
            }
          }
          EventCenter.instance.publish((IEvent)new hn());
          AppMethodBeat.o(252911);
          return;
        }
      }
      AppMethodBeat.o(252911);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$1$2"})
  static final class c
    extends q
    implements b<IResponse<bo>, x>
  {
    c(FinderLikeMegaVideoFragment paramFinderLikeMegaVideoFragment)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hn>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$2$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderLikeMegaVideoFragment.d paramd, hn paramhn)
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