package com.tencent.mm.plugin.finder.ui.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.megavideo.ui.b.a;
import com.tencent.mm.plugin.finder.megavideo.ui.b.b;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "presenter", "unFavIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnFav", "", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "onDestroy", "onResume", "updateFooterCount", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFavMegaVideoFragment
  extends FinderBaseMegaVideoFeedFragment<FinderFavMegaVideoLoader, b.b, b.a>
{
  public static final a vQC;
  private HashMap _$_findViewCache;
  private IListener<hn> tOh;
  private b.b vQA;
  public FinderFavMegaVideoLoader vQB;
  private HashSet<Long> vQu;
  private b.a vQz;
  
  static
  {
    AppMethodBeat.i(252873);
    vQC = new a((byte)0);
    AppMethodBeat.o(252873);
  }
  
  public FinderFavMegaVideoFragment()
  {
    AppMethodBeat.i(252872);
    this.dLS = 101;
    this.vQu = new HashSet();
    AppMethodBeat.o(252872);
  }
  
  private final void dAu()
  {
    AppMethodBeat.i(252871);
    Object localObject = this.vQA;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    localObject = ((a.b)localObject).tLS.getLoadMoreFooter();
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131303685);
      if (localObject != null)
      {
        FinderFavMegaVideoLoader localFinderFavMegaVideoLoader = this.vQB;
        if (localFinderFavMegaVideoLoader == null) {
          p.btv("feedLoader");
        }
        ((TextView)localObject).setText((CharSequence)getString(2131763013, new Object[] { Integer.valueOf(localFinderFavMegaVideoLoader.tUU) }));
        AppMethodBeat.o(252871);
        return;
      }
    }
    AppMethodBeat.o(252871);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252876);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252876);
  }
  
  public final FinderFavMegaVideoLoader dAt()
  {
    AppMethodBeat.i(252865);
    FinderFavMegaVideoLoader localFinderFavMegaVideoLoader = this.vQB;
    if (localFinderFavMegaVideoLoader == null) {
      p.btv("feedLoader");
    }
    AppMethodBeat.o(252865);
    return localFinderFavMegaVideoLoader;
  }
  
  public final int getLayoutId()
  {
    return 2131494250;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(252866);
    Object localObject1 = z.aUg();
    p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    Object localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = new FinderFavMegaVideoLoader((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)dAq()).get(FinderReporterUIC.class)).dIx());
    ((FinderFavMegaVideoLoader)localObject1).setInitDone((h)new b(this));
    ((BaseMegaVideoLoader)localObject1).fetchEndCallback = ((b)new c(this));
    this.vQB = ((FinderFavMegaVideoLoader)localObject1);
    localObject1 = (MMActivity)dAq();
    localObject2 = this.vQB;
    if (localObject2 == null) {
      p.btv("feedLoader");
    }
    this.vQz = new b.a((MMActivity)localObject1, (FinderFavMegaVideoLoader)localObject2);
    localObject1 = (MMActivity)dAq();
    localObject2 = getView();
    if (localObject2 == null) {
      p.hyc();
    }
    p.g(localObject2, "view!!");
    this.vQA = new b.b((MMActivity)localObject1, (View)localObject2);
    localObject1 = this.vQA;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject2 = this.vQz;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    ((b.b)localObject1).a((a.a)localObject2);
    this.tOh = ((IListener)new d(this));
    localObject1 = this.tOh;
    if (localObject1 != null)
    {
      ((IListener)localObject1).alive();
      AppMethodBeat.o(252866);
      return;
    }
    AppMethodBeat.o(252866);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252868);
    super.onDestroy();
    IListener localIListener = this.tOh;
    if (localIListener != null)
    {
      localIListener.dead();
      AppMethodBeat.o(252868);
      return;
    }
    AppMethodBeat.o(252868);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252867);
    super.onResume();
    Object localObject1 = ((Iterable)this.vQu).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      long l = ((Number)((Iterator)localObject1).next()).longValue();
      Object localObject2 = this.vQB;
      if (localObject2 == null) {
        p.btv("feedLoader");
      }
      l = ((FinderFavMegaVideoLoader)localObject2).ER(l);
      localObject2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
      l.a.M(l, 12);
      localObject2 = this.vQB;
      if (localObject2 == null) {
        p.btv("feedLoader");
      }
      if (((FinderFavMegaVideoLoader)localObject2).getSize() == 0)
      {
        localObject2 = this.vQA;
        if (localObject2 == null) {
          p.btv("viewCallback");
        }
        ((b.b)localObject2).bIo();
      }
    }
    this.vQu.clear();
    localObject1 = this.vQB;
    if (localObject1 == null) {
      p.btv("feedLoader");
    }
    int i = ((FinderFavMegaVideoLoader)localObject1).gAZ;
    if (i > 0) {
      dAq().setMMTitle(dAq().getResources().getString(2131759705, new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      dAu();
      AppMethodBeat.o(252867);
      return;
      dAq().setMMTitle(dAq().getResources().getString(2131759706));
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements h
  {
    b(FinderFavMegaVideoFragment paramFinderFavMegaVideoFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(252861);
      Object localObject = FinderFavMegaVideoFragment.a(this.vQD);
      if (localObject != null)
      {
        localObject = ((b.b)localObject).getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          localObject = FinderFavMegaVideoFragment.a(this.vQD);
          if (localObject != null)
          {
            localObject = ((a.b)localObject).tLS.getRecyclerView();
            if (localObject != null) {
              ((RecyclerView)localObject).setVisibility(0);
            }
          }
          EventCenter.instance.publish((IEvent)new hn());
          AppMethodBeat.o(252861);
          return;
        }
      }
      AppMethodBeat.o(252861);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$1$2"})
  static final class c
    extends q
    implements b<IResponse<bo>, x>
  {
    c(FinderFavMegaVideoFragment paramFinderFavMegaVideoFragment)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hn>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$2$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderFavMegaVideoFragment.d paramd, hn paramhn)
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