package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.n.a;
import com.tencent.mm.plugin.finder.feed.o.a;
import com.tencent.mm.plugin.finder.feed.o.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "()V", "TAG", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "onDestroy", "updateTitle", "count", "plugin-finder_release"})
public final class FinderFavFeedUI
  extends FinderBaseGridFeedUI<o.b, o.a>
{
  private o.a KRu;
  private o.b KRv;
  private final String TAG = "Finder.FinderFavFeedUI";
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader qvo;
  private final int scene = 2;
  private c<gy> xpb;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198404);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(198404);
    return localView1;
  }
  
  public final void ahl(int paramInt)
  {
    AppMethodBeat.i(198401);
    if (paramInt > 0)
    {
      localAppCompatActivity = getContext();
      k.g(localAppCompatActivity, "context");
      setMMTitle(localAppCompatActivity.getResources().getString(2131766234, new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(198401);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    k.g(localAppCompatActivity, "context");
    setMMTitle(localAppCompatActivity.getResources().getString(2131766236));
    AppMethodBeat.o(198401);
  }
  
  public final int fTB()
  {
    return 3;
  }
  
  public final BaseFinderFeedLoader fTF()
  {
    AppMethodBeat.i(198397);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
    if (localBaseFinderFeedLoader == null) {
      k.aPZ("feedLoader");
    }
    AppMethodBeat.o(198397);
    return localBaseFinderFeedLoader;
  }
  
  public final int getCommentScene()
  {
    return 24;
  }
  
  public final int getLayoutId()
  {
    return 2131496182;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198398);
    ahl(0);
    Object localObject1 = (MMActivity)this;
    Object localObject2 = u.aqO();
    k.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    localObject2 = new com.tencent.mm.plugin.finder.feed.model.a((String)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
    ((com.tencent.mm.plugin.finder.feed.model.a)localObject2).KPL = ((b)new a(this));
    this.qvo = ((BaseFinderFeedLoader)localObject2);
    localObject2 = this.qvo;
    if (localObject2 == null) {
      k.aPZ("feedLoader");
    }
    this.KRu = new o.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.KRv = new o.b((MMActivity)this, this.scene, (byte)0);
    localObject1 = this.KRv;
    if (localObject1 == null) {
      k.aPZ("viewCallback");
    }
    localObject2 = this.KRu;
    if (localObject2 == null) {
      k.aPZ("presenter");
    }
    ((o.b)localObject1).a((n.a)localObject2);
    this.xpb = ((c)new b(this));
    com.tencent.mm.sdk.b.a.ESL.b(this.xpb);
    AppMethodBeat.o(198398);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198402);
    com.tencent.mm.sdk.b.a.ESL.d(this.xpb);
    super.onDestroy();
    AppMethodBeat.o(198402);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$getLoader$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderFavFeedUI paramFinderFavFeedUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$initOnCreate$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends c<gy>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$initOnCreate$1$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(FinderFavFeedUI.b paramb, gy paramgy)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI
 * JD-Core Version:    0.7.0.1
 */