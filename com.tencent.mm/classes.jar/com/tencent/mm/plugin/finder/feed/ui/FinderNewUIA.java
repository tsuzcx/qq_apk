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
import com.tencent.mm.g.a.hf;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.t.a;
import com.tencent.mm.plugin.finder.feed.t.b;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderNewUIA;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedPresenter;", "()V", "TAG", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "presenter", "scene", "", "unLikeIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "viewCallback", "checkEmptyOnUnLike", "", "getCommentScene", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "initOnCreate", "onBackPressed", "onDestroy", "onResume", "updateTitle", "count", "plugin-finder_release"})
public final class FinderNewUIA
  extends FinderBaseGridFeedUI<t.b, t.a>
{
  private final String TAG = "Finder.FinderLikeFeedGridUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private c<hf> seA;
  private t.a snW;
  private t.b snX;
  public FinderLikedFeedLoader snY;
  private ArrayList<Long> snZ;
  
  public final void ET(int paramInt)
  {
    AppMethodBeat.i(203244);
    if (paramInt > 0)
    {
      localAppCompatActivity = getContext();
      p.g(localAppCompatActivity, "context");
      setMMTitle(localAppCompatActivity.getResources().getString(2131766791, new Object[] { String.valueOf(paramInt) }));
      AppMethodBeat.o(203244);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    p.g(localAppCompatActivity, "context");
    setMMTitle(localAppCompatActivity.getResources().getString(2131766796));
    AppMethodBeat.o(203244);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203247);
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
    AppMethodBeat.o(203247);
    return localView1;
  }
  
  public final int cCL()
  {
    return 35;
  }
  
  public final int cDL()
  {
    return 3;
  }
  
  public final int getLayoutId()
  {
    return 2131496392;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(203239);
    this.snZ = new ArrayList();
    ET(0);
    Object localObject1 = e.slE;
    Object localObject2 = com.tencent.mm.ui.component.a.KEX;
    localObject1 = new FinderLikedFeedLoader(false, (e)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ());
    ((FinderLikedFeedLoader)localObject1).setInitDone((h)new a(this));
    ((FinderLikedFeedLoader)localObject1).sbQ = ((d.g.a.a)new b(this));
    ((FinderLikedFeedLoader)localObject1).skC = ((d.g.a.b)new c(this));
    this.snY = ((FinderLikedFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    localObject2 = this.snY;
    if (localObject2 == null) {
      p.bdF("feedLoader");
    }
    this.snW = new t.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.snX = new t.b((MMActivity)this, this.scene, (byte)0);
    localObject1 = this.snX;
    if (localObject1 == null) {
      p.bdF("viewCallback");
    }
    localObject2 = this.snW;
    if (localObject2 == null) {
      p.bdF("presenter");
    }
    ((t.b)localObject1).a((b.a)localObject2);
    this.seA = ((c)new d(this));
    com.tencent.mm.sdk.b.a.IvT.b(this.seA);
    AppMethodBeat.o(203239);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(203240);
    Intent localIntent = new Intent();
    Object localObject = FinderSelfUI.sRG;
    localObject = FinderSelfUI.cMS();
    FinderLikedFeedLoader localFinderLikedFeedLoader = this.snY;
    if (localFinderLikedFeedLoader == null) {
      p.bdF("feedLoader");
    }
    localIntent.putExtra((String)localObject, localFinderLikedFeedLoader.fVS);
    setResult(-1, localIntent);
    super.onBackPressed();
    AppMethodBeat.o(203240);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203245);
    com.tencent.mm.sdk.b.a.IvT.d(this.seA);
    super.onDestroy();
    AppMethodBeat.o(203245);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203241);
    super.onResume();
    Object localObject1 = this.snZ;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Number)((Iterator)localObject1).next()).longValue();
        Object localObject2 = this.snY;
        if (localObject2 == null) {
          p.bdF("feedLoader");
        }
        ((FinderLikedFeedLoader)localObject2).remove(l, true);
        localObject2 = k.sLb;
        k.a.M(l, 2);
        localObject2 = this.snY;
        if (localObject2 == null) {
          p.bdF("feedLoader");
        }
        if (((FinderLikedFeedLoader)localObject2).getSize() == 0)
        {
          localObject2 = this.snX;
          if (localObject2 == null) {
            p.bdF("viewCallback");
          }
          ((t.b)localObject2).bmP();
        }
      }
    }
    localObject1 = this.snY;
    if (localObject1 == null) {
      p.bdF("feedLoader");
    }
    ET(((FinderLikedFeedLoader)localObject1).fVS);
    AppMethodBeat.o(203241);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderNewUIA paramFinderNewUIA) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(203234);
      Object localObject = FinderNewUIA.a(this.soa).getEmptyView();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        localObject = FinderNewUIA.a(this.soa).scj.getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).setVisibility(0);
        }
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)new hf());
        AppMethodBeat.o(203234);
        return;
      }
      AppMethodBeat.o(203234);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$1$2"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(FinderNewUIA paramFinderNewUIA)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "totalCount", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$1$3"})
  static final class c
    extends q
    implements d.g.a.b<Integer, z>
  {
    c(FinderNewUIA paramFinderNewUIA)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends c<hf>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIA$initOnCreate$2$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderNewUIA.d paramd, hf paramhf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderNewUIA
 * JD-Core Version:    0.7.0.1
 */