package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.a.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "()V", "TAG", "", "cacheId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "Lkotlin/Lazy;", "dismissTipRunnable", "Ljava/lang/Runnable;", "feedLoader", "fromScene", "", "getFromScene", "()I", "fromScene$delegate", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isSelfFlag", "", "()Z", "isSelfFlag$delegate", "lastPos", "getLastPos", "setLastPos", "(I)V", "lastVisiblePos", "presenter", "requestAtScene", "title", "getTitle", "()Ljava/lang/String;", "title$delegate", "updateAtFeedListener", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$updateAtFeedListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$updateAtFeedListener$1;", "username", "kotlin.jvm.PlatformType", "getUsername", "username$delegate", "viewCallback", "dismissAtFeedTip", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "feedId", "(Landroidx/recyclerview/widget/LinearLayoutManager;Ljava/lang/Long;)V", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initItemExpose", "initManageAtFeed", "initOnCreate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "removeMessage", "reportItemExpose", "reportMention", "id", "eventCode", "Companion", "plugin-finder_release"})
public final class FinderAtTimelineUI
  extends FinderLoaderFeedUI<FinderAtFeedLoader, a.c, a.b>
{
  private static ConcurrentHashMap<Long, FinderItem> xLE;
  public static final a xLF;
  private final String TAG;
  private HashMap _$_findViewCache;
  private int fYT;
  private final MMHandler handler;
  private int wKJ;
  private long xKc;
  private final f xLA;
  private final f xLB;
  private final Runnable xLC;
  private final n xLD;
  private final f xLj;
  private a.b xLw;
  private a.c xLx;
  private FinderAtFeedLoader xLy;
  private final f xLz;
  private final f xjx;
  private final int xvg;
  
  static
  {
    AppMethodBeat.i(290617);
    xLF = new a((byte)0);
    xLE = new ConcurrentHashMap();
    AppMethodBeat.o(290617);
  }
  
  public FinderAtTimelineUI()
  {
    AppMethodBeat.i(290616);
    this.TAG = "Finder.FinderAtTimelineUI";
    this.fYT = -1;
    this.xLz = kotlin.g.ar((kotlin.g.a.a)new o(this));
    this.xLj = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.xjx = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.xLA = kotlin.g.ar((kotlin.g.a.a)new m(this));
    this.xLB = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.xvg = 2;
    this.xLC = ((Runnable)new c(this));
    this.xLD = new n(this);
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new e(this));
    this.wKJ = -1;
    AppMethodBeat.o(290616);
  }
  
  private final void a(LinearLayoutManager paramLinearLayoutManager, Long paramLong)
  {
    AppMethodBeat.i(290614);
    if (paramLinearLayoutManager != null) {}
    for (int i = paramLinearLayoutManager.kK();; i = -1)
    {
      Log.i(this.TAG, "idle state pos:".concat(String.valueOf(i)));
      paramLinearLayoutManager = Message.obtain();
      paramLinearLayoutManager.what = 1001;
      paramLinearLayoutManager.obj = paramLong;
      this.handler.removeMessages(1000);
      this.handler.sendMessageDelayed(paramLinearLayoutManager, 3000L);
      AppMethodBeat.o(290614);
      return;
    }
  }
  
  private final bid getContextObj()
  {
    AppMethodBeat.i(290602);
    bid localbid = (bid)this.xLj.getValue();
    AppMethodBeat.o(290602);
    return localbid;
  }
  
  private final int getFromScene()
  {
    AppMethodBeat.i(290606);
    int i = ((Number)this.xLB.getValue()).intValue();
    AppMethodBeat.o(290606);
    return i;
  }
  
  private final String getTitle()
  {
    AppMethodBeat.i(290605);
    String str = (String)this.xLA.getValue();
    AppMethodBeat.o(290605);
    return str;
  }
  
  private final String getUsername()
  {
    AppMethodBeat.i(290601);
    String str = (String)this.xLz.getValue();
    AppMethodBeat.o(290601);
    return str;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(290604);
    boolean bool = ((Boolean)this.xjx.getValue()).booleanValue();
    AppMethodBeat.o(290604);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(290624);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(290624);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(290623);
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
    AppMethodBeat.o(290623);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(290613);
    if (getFromScene() == 1)
    {
      if (isSelfFlag())
      {
        AppMethodBeat.o(290613);
        return 62;
      }
      AppMethodBeat.o(290613);
      return 63;
    }
    AppMethodBeat.o(290613);
    return 13;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_at_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(290607);
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
        break label486;
      }
      setMMTitle(b.j.finder_at_timeline_title);
      this.xKc = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      Log.i(this.TAG, "[initOnCreate] cacheId:" + this.xKc + " username=" + getUsername() + " fromScene=" + getFromScene());
      xLE.clear();
      if (getFromScene() == 1)
      {
        localObject1 = h.IzE;
        if (!p.h(getUsername(), z.bdh())) {
          break label497;
        }
        i = 1;
        ((h)localObject1).a(21206, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      }
      localObject1 = (MMActivity)this;
      bool = isSelfFlag();
      localObject2 = getUsername();
      p.j(localObject2, "username");
      this.xLw = new a.b((MMActivity)localObject1, bool, (String)localObject2, this.xvg, getFromScene(), getContextObj());
      localObject1 = (MMActivity)this;
      localObject2 = this.xLw;
      if (localObject2 == null) {
        p.bGy("presenter");
      }
      i = this.xvg;
      j = getCommentScene();
      if (getFromScene() == 1) {
        break label502;
      }
    }
    label486:
    label497:
    label502:
    for (boolean bool = true;; bool = false)
    {
      this.xLx = new a.c((MMActivity)localObject1, (a.b)localObject2, i, j, bool);
      localObject1 = (FrameLayout)_$_findCachedViewById(b.f.loading_state_container);
      p.j(localObject1, "loading_state_container");
      ((FrameLayout)localObject1).setVisibility(0);
      localObject1 = com.tencent.mm.plugin.finder.feed.model.internal.g.xKG;
      localObject2 = getUsername();
      p.j(localObject2, "username");
      localObject1 = new FinderAtFeedLoader((com.tencent.mm.plugin.finder.feed.model.internal.g)localObject1, (String)localObject2, getContextObj());
      localObject2 = getIntent();
      p.j(localObject2, "intent");
      ((FinderAtFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderAtFeedLoader)localObject1).fromScene = getIntent().getIntExtra("key_from_page", com.tencent.mm.plugin.finder.feed.model.internal.g.xKu.value);
      ((FinderAtFeedLoader)localObject1).xEI = ((kotlin.g.a.a)new h(this));
      ((FinderAtFeedLoader)localObject1).xGJ = ((kotlin.g.a.b)new i(this));
      ((FinderAtFeedLoader)localObject1).setInitDone((j)new j((FinderAtFeedLoader)localObject1, this));
      this.xLy = ((FinderAtFeedLoader)localObject1);
      localObject1 = this.xLx;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      ((b.b)localObject1).xvJ.getRecyclerView().a((RecyclerView.l)new g(this));
      AppMethodBeat.o(290607);
      return;
      i = 0;
      break;
      setMMTitle(getTitle());
      break label34;
      i = 0;
      break label136;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(290608);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("force_show_ad_tip", false))
    {
      paramBundle = this.xLx;
      if (paramBundle == null) {
        p.bGy("viewCallback");
      }
      paramBundle.xvJ.getRecyclerView().a((RecyclerView.l)new f(this));
    }
    paramBundle = this.xLx;
    if (paramBundle == null) {
      p.bGy("viewCallback");
    }
    paramBundle.xvJ.getRecyclerView().post((Runnable)new l(this));
    AppMethodBeat.o(290608);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(290609);
    super.onDestroy();
    xLE.clear();
    this.handler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(290609);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$Companion;", "", "()V", "DELAY_TIME", "", "DISMISS_AT_FEED_TIP", "", "SHOW_AT_FEED_TIP", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<bid>
  {
    b(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderAtTimelineUI paramFinderAtTimelineUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(290598);
      RecyclerView.LayoutManager localLayoutManager2 = FinderAtTimelineUI.a(this.xLG).xvJ.getRecyclerView().getLayoutManager();
      FinderAtTimelineUI localFinderAtTimelineUI = this.xLG;
      RecyclerView.LayoutManager localLayoutManager1 = localLayoutManager2;
      if (!(localLayoutManager2 instanceof FinderLinearLayoutManager)) {
        localLayoutManager1 = null;
      }
      FinderAtTimelineUI.a(localFinderAtTimelineUI, (LinearLayoutManager)localLayoutManager1);
      AppMethodBeat.o(290598);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    d(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "message", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class e
    implements MMHandler.Callback
  {
    e(FinderAtTimelineUI paramFinderAtTimelineUI) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      int i = -1;
      AppMethodBeat.i(285568);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(285568);
        return true;
        Object localObject = FinderAtTimelineUI.a(this.xLG).xvJ.getRecyclerView().getLayoutManager();
        paramMessage = (Message)localObject;
        if (!(localObject instanceof FinderLinearLayoutManager)) {
          paramMessage = null;
        }
        paramMessage = (FinderLinearLayoutManager)paramMessage;
        if (paramMessage != null) {}
        for (i = paramMessage.kK();; i = -1)
        {
          FinderAtTimelineUI.b(this.xLG).am(i, true);
          break;
        }
        RecyclerView.LayoutManager localLayoutManager = FinderAtTimelineUI.a(this.xLG).xvJ.getRecyclerView().getLayoutManager();
        localObject = localLayoutManager;
        if (!(localLayoutManager instanceof FinderLinearLayoutManager)) {
          localObject = null;
        }
        localObject = (FinderLinearLayoutManager)localObject;
        if (localObject != null) {
          i = ((FinderLinearLayoutManager)localObject).kK();
        }
        localObject = paramMessage.obj;
        if (localObject != null)
        {
          paramMessage = FinderAtTimelineUI.b(this.xLG).getDataListJustForAdapter();
          int j;
          if ((i >= 0) && (i < paramMessage.size()))
          {
            j = 1;
            if (j == 0) {
              break label234;
            }
            label195:
            if (paramMessage == null) {
              break label239;
            }
          }
          label234:
          label239:
          for (paramMessage = (bu)paramMessage.get(i);; paramMessage = null)
          {
            if (paramMessage != null) {
              break label244;
            }
            paramMessage = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
            AppMethodBeat.o(285568);
            throw paramMessage;
            j = 0;
            break;
            paramMessage = null;
            break label195;
          }
          label244:
          if (p.h(localObject, Long.valueOf(((BaseFinderFeed)paramMessage).feedObject.getId())))
          {
            Log.i(FinderAtTimelineUI.d(this.xLG), "DISMISS_AT_FEED_TIP feedId:" + localObject + " pos:" + i);
            FinderAtTimelineUI.b(this.xLG).am(i, false);
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(291815);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        FinderAtTimelineUI.c(this.xLG);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(291815);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(291816);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(291816);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class g
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(227394);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        FinderAtTimelineUI localFinderAtTimelineUI = this.xLG;
        localObject = FinderAtTimelineUI.a(this.xLG).xvJ.getRecyclerView().getLayoutManager();
        paramRecyclerView = (RecyclerView)localObject;
        if (!(localObject instanceof FinderLinearLayoutManager)) {
          paramRecyclerView = null;
        }
        FinderAtTimelineUI.b(localFinderAtTimelineUI, (LinearLayoutManager)paramRecyclerView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(227394);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(227399);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(227399);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$1"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$2"})
  static final class i
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    i(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class j
    implements j
  {
    j(FinderAtFeedLoader paramFinderAtFeedLoader, FinderAtTimelineUI paramFinderAtTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(286138);
      RecyclerView.LayoutManager localLayoutManager = FinderAtTimelineUI.a(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      Object localObject = localLayoutManager;
      if (!(localLayoutManager instanceof FinderLinearLayoutManager)) {
        localObject = null;
      }
      localObject = (FinderLinearLayoutManager)localObject;
      if (localObject != null) {
        ((FinderLinearLayoutManager)localObject).au(this.xLH.getInitPos(), 0);
      }
      if (paramInt > 0)
      {
        localObject = (FrameLayout)jdField_this._$_findCachedViewById(b.f.loading_state_container);
        p.j(localObject, "loading_state_container");
        ((FrameLayout)localObject).setVisibility(8);
        AppMethodBeat.o(286138);
        return;
      }
      localObject = (FrameLayout)jdField_this._$_findCachedViewById(b.f.loading_state_container);
      p.j(localObject, "loading_state_container");
      ((FrameLayout)localObject).setVisibility(0);
      localObject = (ProgressBar)jdField_this._$_findCachedViewById(b.f.tips_loading);
      p.j(localObject, "tips_loading");
      ((ProgressBar)localObject).setVisibility(0);
      AppMethodBeat.o(286138);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    k(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderAtTimelineUI paramFinderAtTimelineUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(264819);
      FinderAtTimelineUI.c(this.xLG);
      AppMethodBeat.o(264819);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<String>
  {
    m(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$updateAtFeedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderAtFeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class n
    extends IListener<hz>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<String>
  {
    o(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI
 * JD-Core Version:    0.7.0.1
 */