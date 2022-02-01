package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.e.a;
import com.tencent.mm.plugin.finder.feed.e.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "()V", "TAG", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "unFavIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "viewCallback", "checkEmptyOnUnFav", "", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "initOnCreate", "onDestroy", "onResume", "updateTitle", "count", "plugin-finder_release"})
public final class FinderFavFeedUI
  extends FinderBaseGridFeedUI<e.b, e.a>
{
  private final String TAG = "Finder.FinderFavFeedUI";
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader rgh;
  private c<ha> rhM;
  private e.a rpd;
  private e.b rpe;
  private ArrayList<Long> rpf;
  private final int scene = 2;
  
  public final void DM(int paramInt)
  {
    AppMethodBeat.i(202314);
    if (paramInt > 0)
    {
      localAppCompatActivity = getContext();
      k.g(localAppCompatActivity, "context");
      setMMTitle(localAppCompatActivity.getResources().getString(2131766385, new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(202314);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    k.g(localAppCompatActivity, "context");
    setMMTitle(localAppCompatActivity.getResources().getString(2131766386));
    AppMethodBeat.o(202314);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202317);
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
    AppMethodBeat.o(202317);
    return localView1;
  }
  
  public final int cuI()
  {
    return 24;
  }
  
  public final int cvJ()
  {
    return 3;
  }
  
  public final BaseFinderFeedLoader cvR()
  {
    AppMethodBeat.i(202309);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader == null) {
      k.aVY("feedLoader");
    }
    AppMethodBeat.o(202309);
    return localBaseFinderFeedLoader;
  }
  
  public final int getLayoutId()
  {
    return 2131496183;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202310);
    this.rpf = new ArrayList();
    DM(0);
    Object localObject1 = (MMActivity)this;
    Object localObject2 = u.axE();
    k.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    localObject2 = new d((String)localObject2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
    ((d)localObject2).rmE = ((d.g.a.b)new a(this));
    this.rgh = ((BaseFinderFeedLoader)localObject2);
    localObject2 = this.rgh;
    if (localObject2 == null) {
      k.aVY("feedLoader");
    }
    this.rpd = new e.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.rpe = new e.b((MMActivity)this, this.scene, (byte)0);
    localObject1 = this.rpe;
    if (localObject1 == null) {
      k.aVY("viewCallback");
    }
    localObject2 = this.rpd;
    if (localObject2 == null) {
      k.aVY("presenter");
    }
    ((e.b)localObject1).a((c.a)localObject2);
    this.rhM = ((c)new b(this));
    com.tencent.mm.sdk.b.a.GpY.b(this.rhM);
    AppMethodBeat.o(202310);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202315);
    com.tencent.mm.sdk.b.a.GpY.d(this.rhM);
    super.onDestroy();
    AppMethodBeat.o(202315);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202311);
    super.onResume();
    Object localObject1 = this.rpf;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Number)((Iterator)localObject1).next()).longValue();
        Object localObject2 = this.rgh;
        if (localObject2 == null) {
          k.aVY("feedLoader");
        }
        ((BaseFinderFeedLoader)localObject2).remove(l, true);
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        b.a.vf(l);
        localObject2 = this.rgh;
        if (localObject2 == null) {
          k.aVY("feedLoader");
        }
        if (((BaseFinderFeedLoader)localObject2).getSize() == 0)
        {
          localObject2 = this.rpe;
          if (localObject2 == null) {
            k.aVY("viewCallback");
          }
          View localView = ((c.b)localObject2).getEmptyView();
          if (localView != null) {
            ((c.b)localObject2).dX(localView);
          }
        }
      }
    }
    localObject1 = this.rgh;
    if (localObject1 == null) {
      k.aVY("feedLoader");
    }
    DM(((BaseFinderFeedLoader)localObject1).getSize());
    AppMethodBeat.o(202311);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$getLoader$1$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderFavFeedUI paramFinderFavFeedUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$initOnCreate$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends c<ha>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$initOnCreate$1$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(FinderFavFeedUI.b paramb, ha paramha)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI
 * JD-Core Version:    0.7.0.1
 */