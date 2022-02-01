package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.he;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.f.a;
import com.tencent.mm.plugin.finder.feed.f.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "unFavIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "viewCallback", "checkEmptyOnUnFav", "", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "initOnCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onDestroy", "onResume", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFavFeedUI
  extends FinderBaseGridFeedUI<f.b, f.a>
{
  public static final a sdP;
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader rTS;
  private c<he> rVT;
  private final int scene = 2;
  private f.a sdM;
  private f.b sdN;
  private ArrayList<Long> sdO;
  
  static
  {
    AppMethodBeat.i(202646);
    sdP = new a((byte)0);
    AppMethodBeat.o(202646);
  }
  
  private f.a cCi()
  {
    AppMethodBeat.i(202640);
    f.a locala = this.sdM;
    if (locala == null) {
      d.g.b.p.bcb("presenter");
    }
    AppMethodBeat.o(202640);
    return locala;
  }
  
  public final void EG(int paramInt)
  {
    AppMethodBeat.i(202643);
    if (paramInt > 0)
    {
      localAppCompatActivity = getContext();
      d.g.b.p.g(localAppCompatActivity, "context");
      setMMTitle(localAppCompatActivity.getResources().getString(2131766385, new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(202643);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.p.g(localAppCompatActivity, "context");
    setMMTitle(localAppCompatActivity.getResources().getString(2131766386));
    AppMethodBeat.o(202643);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202648);
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
    AppMethodBeat.o(202648);
    return localView1;
  }
  
  public final int cAZ()
  {
    return 24;
  }
  
  public final int cBZ()
  {
    return 3;
  }
  
  public final BaseFinderFeedLoader cCh()
  {
    AppMethodBeat.i(202636);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader == null) {
      d.g.b.p.bcb("feedLoader");
    }
    AppMethodBeat.o(202636);
    return localBaseFinderFeedLoader;
  }
  
  public final int getLayoutId()
  {
    return 2131496183;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202637);
    this.sdO = new ArrayList();
    EG(0);
    Object localObject1 = u.aAu();
    d.g.b.p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    Object localObject2 = com.tencent.mm.ui.component.a.KiD;
    localObject1 = new FinderFavFeedLoader((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu(), false);
    ((FinderFavFeedLoader)localObject1).setInitDone((h)new b(this));
    ((FinderFavFeedLoader)localObject1).fetchEndCallback = ((d.g.a.b)new c(this));
    this.rTS = ((BaseFinderFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    localObject2 = this.rTS;
    if (localObject2 == null) {
      d.g.b.p.bcb("feedLoader");
    }
    this.sdM = new f.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.sdN = new f.b((MMActivity)this, this.scene, (byte)0);
    localObject1 = this.sdN;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
    }
    localObject2 = this.sdM;
    if (localObject2 == null) {
      d.g.b.p.bcb("presenter");
    }
    ((f.b)localObject1).a((b.a)localObject2);
    this.rVT = ((c)new d(this));
    com.tencent.mm.sdk.b.a.IbL.b(this.rVT);
    AppMethodBeat.o(202637);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(202645);
    if ((paramInt1 == 10001) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        f.a locala = cCi();
        d.g.b.p.h(paramIntent, "data");
        Object localObject = locala.rTQ;
        if (localObject != null)
        {
          localObject = ((b.b)localObject).rTF.getRecyclerView();
          if (localObject != null)
          {
            com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
            com.tencent.mm.plugin.finder.utils.p.a(paramIntent, (RecyclerView)localObject, locala.rTS);
          }
        }
      }
      EG(cCi().rTS.getSize());
    }
    AppMethodBeat.o(202645);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(202638);
    Object localObject1 = new Intent();
    Object localObject2 = FinderSelfUI.sGL;
    localObject2 = FinderSelfUI.cKp();
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader == null) {
      d.g.b.p.bcb("feedLoader");
    }
    if (localBaseFinderFeedLoader == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(202638);
      throw ((Throwable)localObject1);
    }
    ((Intent)localObject1).putExtra((String)localObject2, ((FinderFavFeedLoader)localBaseFinderFeedLoader).fTM);
    setResult(-1, (Intent)localObject1);
    super.onBackPressed();
    AppMethodBeat.o(202638);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202644);
    com.tencent.mm.sdk.b.a.IbL.d(this.rVT);
    super.onDestroy();
    AppMethodBeat.o(202644);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202639);
    super.onResume();
    Object localObject1 = this.sdO;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Number)((Iterator)localObject1).next()).longValue();
        Object localObject2 = this.rTS;
        if (localObject2 == null) {
          d.g.b.p.bcb("feedLoader");
        }
        ((BaseFinderFeedLoader)localObject2).remove(l, true);
        localObject2 = k.sAe;
        k.a.M(l, 10);
        localObject2 = this.rTS;
        if (localObject2 == null) {
          d.g.b.p.bcb("feedLoader");
        }
        if (((BaseFinderFeedLoader)localObject2).getSize() == 0)
        {
          localObject2 = this.sdN;
          if (localObject2 == null) {
            d.g.b.p.bcb("viewCallback");
          }
          ((f.b)localObject2).bmg();
        }
      }
    }
    localObject1 = this.rTS;
    if (localObject1 == null) {
      d.g.b.p.bcb("feedLoader");
    }
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(202639);
      throw ((Throwable)localObject1);
    }
    EG(((FinderFavFeedLoader)localObject1).fTM);
    AppMethodBeat.o(202639);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements h
  {
    b(FinderFavFeedUI paramFinderFavFeedUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202632);
      Object localObject = FinderFavFeedUI.a(this.sdQ);
      if (localObject != null)
      {
        localObject = ((f.b)localObject).getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          localObject = FinderFavFeedUI.a(this.sdQ);
          if (localObject != null)
          {
            localObject = ((b.b)localObject).rTF.getRecyclerView();
            if (localObject != null) {
              ((RecyclerView)localObject).setVisibility(0);
            }
          }
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)new he());
          AppMethodBeat.o(202632);
          return;
        }
      }
      AppMethodBeat.o(202632);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$initOnCreate$1$2"})
  static final class c
    extends q
    implements d.g.a.b<IResponse<al>, z>
  {
    c(FinderFavFeedUI paramFinderFavFeedUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends c<he>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$initOnCreate$2$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderFavFeedUI.d paramd, he paramhe)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI
 * JD-Core Version:    0.7.0.1
 */