package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.a.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "()V", "TAG", "", "cacheId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "Lkotlin/Lazy;", "feedLoader", "fromScene", "", "getFromScene", "()I", "fromScene$delegate", "isSelfFlag", "", "()Z", "isSelfFlag$delegate", "presenter", "requestAtScene", "title", "getTitle", "()Ljava/lang/String;", "title$delegate", "username", "kotlin.jvm.PlatformType", "getUsername", "username$delegate", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderAtTimelineUI
  extends FinderLoaderFeedUI<FinderAtFeedLoader, a.c, a.b>
{
  private static ConcurrentHashMap<Long, FinderItem> tZo;
  public static final a tZp;
  private final String TAG;
  private HashMap _$_findViewCache;
  private final int tLA;
  private final f tYU;
  private a.b tZg;
  private a.c tZh;
  private FinderAtFeedLoader tZi;
  private long tZj;
  private final f tZk;
  private final f tZl;
  private final f tZm;
  private final f tZn;
  
  static
  {
    AppMethodBeat.i(245111);
    tZp = new a((byte)0);
    tZo = new ConcurrentHashMap();
    AppMethodBeat.o(245111);
  }
  
  public FinderAtTimelineUI()
  {
    AppMethodBeat.i(245110);
    this.TAG = "Finder.FinderAtTimelineUI";
    this.tZk = g.ah((a)new i(this));
    this.tYU = g.ah((a)new b(this));
    this.tZl = g.ah((a)new g(this));
    this.tZm = g.ah((a)new h(this));
    this.tZn = g.ah((a)new c(this));
    this.tLA = 2;
    AppMethodBeat.o(245110);
  }
  
  private final bbn getContextObj()
  {
    AppMethodBeat.i(245100);
    bbn localbbn = (bbn)this.tYU.getValue();
    AppMethodBeat.o(245100);
    return localbbn;
  }
  
  private final int getFromScene()
  {
    AppMethodBeat.i(245103);
    int i = ((Number)this.tZn.getValue()).intValue();
    AppMethodBeat.o(245103);
    return i;
  }
  
  private final String getTitle()
  {
    AppMethodBeat.i(245102);
    String str = (String)this.tZm.getValue();
    AppMethodBeat.o(245102);
    return str;
  }
  
  private final String getUsername()
  {
    AppMethodBeat.i(245099);
    String str = (String)this.tZk.getValue();
    AppMethodBeat.o(245099);
    return str;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(245101);
    boolean bool = ((Boolean)this.tZl.getValue()).booleanValue();
    AppMethodBeat.o(245101);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245115);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245115);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245114);
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
    AppMethodBeat.o(245114);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(245109);
    if (getFromScene() == 1)
    {
      if (isSelfFlag())
      {
        AppMethodBeat.o(245109);
        return 62;
      }
      AppMethodBeat.o(245109);
      return 63;
    }
    AppMethodBeat.o(245109);
    return 13;
  }
  
  public final int getLayoutId()
  {
    return 2131494200;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245104);
    int i;
    label34:
    Object localObject1;
    label136:
    Object localObject2;
    int j;
    if (((CharSequence)getTitle()).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label426;
      }
      setMMTitle(2131759542);
      this.tZj = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      Log.i(this.TAG, "[initOnCreate] cacheId:" + this.tZj + " username=" + getUsername() + " fromScene=" + getFromScene());
      tZo.clear();
      if (getFromScene() == 1)
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
        if (!p.j(getUsername(), z.aUg())) {
          break label437;
        }
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(21206, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      }
      localObject1 = (MMActivity)this;
      bool = isSelfFlag();
      localObject2 = getUsername();
      p.g(localObject2, "username");
      this.tZg = new a.b((MMActivity)localObject1, bool, (String)localObject2, this.tLA, getFromScene(), getContextObj());
      localObject1 = (MMActivity)this;
      localObject2 = this.tZg;
      if (localObject2 == null) {
        p.btv("presenter");
      }
      i = this.tLA;
      j = getCommentScene();
      if (getFromScene() == 1) {
        break label442;
      }
    }
    label426:
    label437:
    label442:
    for (boolean bool = true;; bool = false)
    {
      this.tZh = new a.c((MMActivity)localObject1, (a.b)localObject2, i, j, bool);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131303713);
      p.g(localObject1, "loading_state_container");
      ((FrameLayout)localObject1).setVisibility(0);
      localObject1 = e.tYz;
      localObject2 = getUsername();
      p.g(localObject2, "username");
      localObject1 = new FinderAtFeedLoader((e)localObject1, (String)localObject2, getContextObj());
      localObject2 = getIntent();
      p.g(localObject2, "intent");
      ((FinderAtFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderAtFeedLoader)localObject1).tTS = ((a)new d(this));
      ((FinderAtFeedLoader)localObject1).tVa = ((b)new e(this));
      ((FinderAtFeedLoader)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new f((FinderAtFeedLoader)localObject1, this));
      this.tZi = ((FinderAtFeedLoader)localObject1);
      AppMethodBeat.o(245104);
      return;
      i = 0;
      break;
      setMMTitle(getTitle());
      break label34;
      i = 0;
      break label136;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245105);
    super.onDestroy();
    tZo.clear();
    AppMethodBeat.o(245105);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$Companion;", "", "()V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class b
    extends q
    implements a<bbn>
  {
    b(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Integer>
  {
    c(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$1"})
  static final class d
    extends q
    implements a<x>
  {
    d(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$2"})
  static final class e
    extends q
    implements b<IResponse<bo>, x>
  {
    e(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    f(FinderAtFeedLoader paramFinderAtFeedLoader, FinderAtTimelineUI paramFinderAtTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245095);
      RecyclerView.LayoutManager localLayoutManager = FinderAtTimelineUI.a(jdField_this).tLS.getRecyclerView().getLayoutManager();
      Object localObject = localLayoutManager;
      if (!(localLayoutManager instanceof FinderLinearLayoutManager)) {
        localObject = null;
      }
      localObject = (FinderLinearLayoutManager)localObject;
      if (localObject != null) {
        ((FinderLinearLayoutManager)localObject).ah(this.tZr.getInitPos(), 0);
      }
      if (paramInt > 0)
      {
        localObject = (FrameLayout)jdField_this._$_findCachedViewById(2131303713);
        p.g(localObject, "loading_state_container");
        ((FrameLayout)localObject).setVisibility(8);
        AppMethodBeat.o(245095);
        return;
      }
      localObject = (FrameLayout)jdField_this._$_findCachedViewById(2131303713);
      p.g(localObject, "loading_state_container");
      ((FrameLayout)localObject).setVisibility(0);
      localObject = (ProgressBar)jdField_this._$_findCachedViewById(2131309182);
      p.g(localObject, "tips_loading");
      ((ProgressBar)localObject).setVisibility(0);
      AppMethodBeat.o(245095);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<Boolean>
  {
    g(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<String>
  {
    h(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements a<String>
  {
    i(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI
 * JD-Core Version:    0.7.0.1
 */