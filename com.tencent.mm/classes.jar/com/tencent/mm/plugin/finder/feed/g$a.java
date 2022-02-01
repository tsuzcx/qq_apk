package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.f;
import d.g.a.b;
import d.g.b.u;
import d.g.b.w;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "username", "", "(Lcom/tencent/mm/ui/MMActivity;Ljava/lang/String;)V", "TAG", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter$feedProgressListener$1;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getUsername", "()Ljava/lang/String;", "viewCallback", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "loadMoreData", "onAttach", "callback", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
public final class g$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<FinderProfileUIContract.ProfileViewCallback>
{
  private final f KNR;
  final String TAG;
  final MMActivity activity;
  boolean hasMore;
  private final a qwb;
  final String username;
  private FinderProfileUIContract.ProfileViewCallback viewCallback;
  
  static
  {
    AppMethodBeat.i(197871);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "feedLoader", "getFeedLoader()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;")) };
    AppMethodBeat.o(197871);
  }
  
  public g$a(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(197873);
    this.activity = paramMMActivity;
    this.username = paramString;
    this.TAG = "Finder.FinderProfileSelfContract.ProfilePresenter";
    this.KNR = d.g.E((d.g.a.a)new g.a.e(this));
    this.hasMore = true;
    this.qwb = new a(this);
    AppMethodBeat.o(197873);
  }
  
  public final void a(FinderProfileUIContract.ProfileViewCallback paramProfileViewCallback)
  {
    AppMethodBeat.i(165802);
    d.g.b.k.h(paramProfileViewCallback, "callback");
    this.viewCallback = paramProfileViewCallback;
    com.tencent.mm.sdk.b.a.ESL.b((com.tencent.mm.sdk.b.c)this.qwb);
    fTm().setFetchEndCallback((d.g.a.a)new c(this));
    fTm().setOnFetchCallback((b)new d(this));
    AppMethodBeat.o(165802);
  }
  
  public final void cmd()
  {
    AppMethodBeat.i(165805);
    if (this.hasMore)
    {
      fTm().requestLoadMore();
      AppMethodBeat.o(165805);
      return;
    }
    ad.i(this.TAG, "doSceneNextPage: no more, return");
    AppMethodBeat.o(165805);
  }
  
  public final FinderProfileFeedLoader fTm()
  {
    AppMethodBeat.i(197872);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.KNR.getValue();
    AppMethodBeat.o(197872);
    return localFinderProfileFeedLoader;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165804);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.qwb);
    this.viewCallback = null;
    AppMethodBeat.o(165804);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.sdk.b.c<gx>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter$loadMoreData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(165799);
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
      AppMethodBeat.o(165799);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(g.a.b paramb)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(g.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/ProfileResponse;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<q, y>
  {
    d(g.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.a
 * JD-Core Version:    0.7.0.1
 */