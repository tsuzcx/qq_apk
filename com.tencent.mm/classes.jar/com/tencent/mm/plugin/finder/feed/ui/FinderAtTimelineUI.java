package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ik;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.a.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "()V", "TAG", "", "cacheId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "Lkotlin/Lazy;", "dismissTipRunnable", "Ljava/lang/Runnable;", "feedLoader", "fromScene", "", "getFromScene", "()I", "fromScene$delegate", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isSelfFlag", "", "()Z", "isSelfFlag$delegate", "lastPos", "getLastPos", "setLastPos", "(I)V", "lastVisiblePos", "presenter", "requestAtScene", "title", "getTitle", "()Ljava/lang/String;", "title$delegate", "updateAtFeedListener", "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$updateAtFeedListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$updateAtFeedListener$1;", "username", "kotlin.jvm.PlatformType", "getUsername", "username$delegate", "viewCallback", "dismissAtFeedTip", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "feedId", "(Landroidx/recyclerview/widget/LinearLayoutManager;Ljava/lang/Long;)V", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initItemExpose", "initManageAtFeed", "initOnCreate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "removeMessage", "reportItemExpose", "reportMention", "id", "eventCode", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAtTimelineUI
  extends FinderLoaderFeedUI<FinderAtFeedLoader, a.c, a.b>
{
  public static final a BlG;
  private static ConcurrentHashMap<Long, FinderItem> BlP;
  private final kotlin.j AIq;
  private final int ASQ;
  private int Ahg;
  private long BjP;
  private a.b BlH;
  private a.c BlI;
  private FinderAtFeedLoader BlJ;
  private final kotlin.j BlK;
  private final kotlin.j BlL;
  private final kotlin.j BlM;
  private final Runnable BlN;
  private final updateAtFeedListener.1 BlO;
  private final kotlin.j Bld;
  private final String TAG;
  private final MMHandler handler;
  private int ieV;
  
  static
  {
    AppMethodBeat.i(364378);
    BlG = new a((byte)0);
    BlP = new ConcurrentHashMap();
    AppMethodBeat.o(364378);
  }
  
  public FinderAtTimelineUI()
  {
    AppMethodBeat.i(364241);
    this.TAG = "Finder.FinderAtTimelineUI";
    this.ieV = -1;
    this.BlK = k.cm((kotlin.g.a.a)new k(this));
    this.Bld = k.cm((kotlin.g.a.a)new b(this));
    this.AIq = k.cm((kotlin.g.a.a)new i(this));
    this.BlL = k.cm((kotlin.g.a.a)new j(this));
    this.BlM = k.cm((kotlin.g.a.a)new c(this));
    this.ASQ = 2;
    this.BlN = new FinderAtTimelineUI..ExternalSyntheticLambda1(this);
    this.BlO = new IListener(f.hfK) {};
    this.handler = new MMHandler(Looper.getMainLooper(), new FinderAtTimelineUI..ExternalSyntheticLambda0(this));
    this.Ahg = -1;
    AppMethodBeat.o(364241);
  }
  
  private final void a(LinearLayoutManager paramLinearLayoutManager, Long paramLong)
  {
    AppMethodBeat.i(364288);
    if (paramLinearLayoutManager == null) {}
    for (int i = -1;; i = paramLinearLayoutManager.Jv())
    {
      Log.i(this.TAG, s.X("idle state pos:", Integer.valueOf(i)));
      paramLinearLayoutManager = Message.obtain();
      paramLinearLayoutManager.what = 1001;
      paramLinearLayoutManager.obj = paramLong;
      this.handler.removeMessages(1000);
      this.handler.sendMessageDelayed(paramLinearLayoutManager, 3000L);
      AppMethodBeat.o(364288);
      return;
    }
  }
  
  private static final void a(FinderAtTimelineUI paramFinderAtTimelineUI)
  {
    AppMethodBeat.i(364311);
    s.u(paramFinderAtTimelineUI, "this$0");
    a.c localc = paramFinderAtTimelineUI.BlI;
    Object localObject = localc;
    if (localc == null)
    {
      s.bIx("viewCallback");
      localObject = null;
    }
    localObject = ((b.b)localObject).ATx.getRecyclerView().getLayoutManager();
    if ((localObject instanceof FinderLinearLayoutManager)) {}
    for (localObject = (FinderLinearLayoutManager)localObject;; localObject = null)
    {
      paramFinderAtTimelineUI.a((LinearLayoutManager)localObject, null);
      AppMethodBeat.o(364311);
      return;
    }
  }
  
  private static final boolean a(FinderAtTimelineUI paramFinderAtTimelineUI, Message paramMessage)
  {
    int i = -1;
    a.c localc = null;
    Object localObject1 = null;
    AppMethodBeat.i(364322);
    s.u(paramFinderAtTimelineUI, "this$0");
    s.u(paramMessage, "message");
    switch (paramMessage.what)
    {
    }
    label109:
    label115:
    Object localObject2;
    label147:
    label155:
    label215:
    do
    {
      do
      {
        AppMethodBeat.o(364322);
        return true;
        localc = paramFinderAtTimelineUI.BlI;
        paramMessage = localc;
        if (localc == null)
        {
          s.bIx("viewCallback");
          paramMessage = null;
        }
        paramMessage = paramMessage.ATx.getRecyclerView().getLayoutManager();
        if ((paramMessage instanceof FinderLinearLayoutManager))
        {
          paramMessage = (FinderLinearLayoutManager)paramMessage;
          if (paramMessage != null) {
            break label147;
          }
          i = -1;
          paramFinderAtTimelineUI = paramFinderAtTimelineUI.BlJ;
          if (paramFinderAtTimelineUI != null) {
            break label155;
          }
          s.bIx("feedLoader");
          paramFinderAtTimelineUI = (FinderAtTimelineUI)localObject1;
        }
        for (;;)
        {
          paramFinderAtTimelineUI.aF(i, true);
          break;
          paramMessage = null;
          break label109;
          i = paramMessage.Jv();
          break label115;
        }
        localObject2 = paramFinderAtTimelineUI.BlI;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
        if (!(localObject1 instanceof FinderLinearLayoutManager)) {
          break;
        }
        localObject1 = (FinderLinearLayoutManager)localObject1;
        if (localObject1 != null) {
          break label306;
        }
        localObject2 = paramMessage.obj;
      } while (localObject2 == null);
      localObject1 = paramFinderAtTimelineUI.BlJ;
      paramMessage = (Message)localObject1;
      if (localObject1 == null)
      {
        s.bIx("feedLoader");
        paramMessage = null;
      }
      paramMessage = paramMessage.getDataListJustForAdapter();
      int j;
      if ((i >= 0) && (i < paramMessage.size()))
      {
        j = 1;
        if (j == 0) {
          break label320;
        }
        if (paramMessage != null) {
          break label325;
        }
      }
      for (paramMessage = null;; paramMessage = (cc)paramMessage.get(i))
      {
        if (paramMessage != null) {
          break label337;
        }
        paramFinderAtTimelineUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        AppMethodBeat.o(364322);
        throw paramFinderAtTimelineUI;
        localObject1 = null;
        break;
        i = ((FinderLinearLayoutManager)localObject1).Jv();
        break label215;
        j = 0;
        break label267;
        paramMessage = null;
        break label271;
      }
    } while (!s.p(localObject2, Long.valueOf(((BaseFinderFeed)paramMessage).feedObject.getId())));
    label267:
    label271:
    label306:
    label320:
    label325:
    label337:
    Log.i(paramFinderAtTimelineUI.TAG, "DISMISS_AT_FEED_TIP feedId:" + localObject2 + " pos:" + i);
    paramFinderAtTimelineUI = paramFinderAtTimelineUI.BlJ;
    if (paramFinderAtTimelineUI == null)
    {
      s.bIx("feedLoader");
      paramFinderAtTimelineUI = localc;
    }
    for (;;)
    {
      paramFinderAtTimelineUI.aF(i, false);
      break;
    }
  }
  
  private static final void b(FinderAtTimelineUI paramFinderAtTimelineUI)
  {
    AppMethodBeat.i(364328);
    s.u(paramFinderAtTimelineUI, "this$0");
    paramFinderAtTimelineUI.eez();
    AppMethodBeat.o(364328);
  }
  
  private final void eez()
  {
    Object localObject2 = null;
    AppMethodBeat.i(364303);
    Object localObject3 = this.BlI;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
    int i;
    label60:
    int j;
    if ((localObject1 instanceof LinearLayoutManager))
    {
      localObject1 = (LinearLayoutManager)localObject1;
      if (localObject1 != null) {
        break label249;
      }
      i = -1;
      if (this.ieV != i)
      {
        localObject3 = this.BlJ;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("feedLoader");
          localObject1 = null;
        }
        localObject1 = ((FinderAtFeedLoader)localObject1).getDataListJustForAdapter();
        if ((((DataBuffer)localObject1).size() <= i) || (i < 0)) {
          break label257;
        }
        j = 1;
        label109:
        if (j == 0) {
          break label262;
        }
        label113:
        if (localObject1 != null) {
          break label267;
        }
        localObject1 = null;
        label119:
        if (!(localObject1 instanceof BaseFinderFeed)) {
          break label279;
        }
        localObject1 = (BaseFinderFeed)localObject1;
        label131:
        if (localObject1 != null)
        {
          localObject1 = ((BaseFinderFeed)localObject1).feedObject;
          if ((localObject1 != null) && (((FinderItem)localObject1).getMentionListSelected() == 3))
          {
            localObject3 = com.tencent.mm.plugin.finder.report.z.FrZ;
            localObject1 = com.tencent.mm.plugin.finder.report.z.pL(((FinderItem)localObject1).getId());
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("feedid", localObject1);
            localObject3 = ((JSONObject)localObject3).toString();
            s.s(localObject3, "JSONObject().apply {\n   … id)\n        }.toString()");
            localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
            localObject1 = as.GSQ;
            localObject1 = as.a.hu((Context)this);
            if (localObject1 != null) {
              break label284;
            }
          }
        }
      }
    }
    label257:
    label262:
    label267:
    label279:
    label284:
    for (localObject1 = localObject2;; localObject1 = ((as)localObject1).fou())
    {
      com.tencent.mm.plugin.finder.report.z.a(0, "if_show_mentionedfeed", (String)localObject3, (bui)localObject1);
      this.ieV = i;
      AppMethodBeat.o(364303);
      return;
      localObject1 = null;
      break;
      label249:
      i = ((LinearLayoutManager)localObject1).Jv();
      break label60;
      j = 0;
      break label109;
      localObject1 = null;
      break label113;
      localObject1 = (cc)((DataBuffer)localObject1).get(i);
      break label119;
      localObject1 = null;
      break label131;
    }
  }
  
  private final bui getContextObj()
  {
    AppMethodBeat.i(364255);
    bui localbui = (bui)this.Bld.getValue();
    AppMethodBeat.o(364255);
    return localbui;
  }
  
  private final int getFromScene()
  {
    AppMethodBeat.i(364275);
    int i = ((Number)this.BlM.getValue()).intValue();
    AppMethodBeat.o(364275);
    return i;
  }
  
  private final String getTitle()
  {
    AppMethodBeat.i(364268);
    String str = (String)this.BlL.getValue();
    AppMethodBeat.o(364268);
    return str;
  }
  
  private final String getUsername()
  {
    AppMethodBeat.i(364247);
    String str = (String)this.BlK.getValue();
    AppMethodBeat.o(364247);
    return str;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(364262);
    boolean bool = ((Boolean)this.AIq.getValue()).booleanValue();
    AppMethodBeat.o(364262);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(364445);
    if (getFromScene() == 1)
    {
      if (isSelfFlag())
      {
        AppMethodBeat.o(364445);
        return 62;
      }
      AppMethodBeat.o(364445);
      return 63;
    }
    AppMethodBeat.o(364445);
    return 13;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_at_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    Object localObject2 = null;
    AppMethodBeat.i(364420);
    Object localObject1 = getTitle();
    s.s(localObject1, "title");
    int i;
    label49:
    boolean bool;
    if (((CharSequence)localObject1).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label506;
      }
      setMMTitle(e.h.finder_at_timeline_title);
      this.BjP = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      Log.i(this.TAG, "[initOnCreate] cacheId:" + this.BjP + " username=" + getUsername() + " fromScene=" + getFromScene());
      BlP.clear();
      if (getFromScene() == 1)
      {
        localObject1 = h.OAn;
        if (!s.p(getUsername(), com.tencent.mm.model.z.bAW())) {
          break label517;
        }
        i = 1;
        label151:
        ((h)localObject1).b(21206, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      }
      localObject1 = (MMActivity)this;
      bool = isSelfFlag();
      Object localObject3 = getUsername();
      s.s(localObject3, "username");
      this.BlH = new a.b((MMActivity)localObject1, bool, (String)localObject3, this.ASQ, getFromScene(), getContextObj());
      MMActivity localMMActivity = (MMActivity)this;
      localObject3 = this.BlH;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      i = this.ASQ;
      int j = getCommentScene();
      if (getFromScene() == 1) {
        break label522;
      }
      bool = true;
      label280:
      this.BlI = new a.c(localMMActivity, (a.b)localObject1, i, j, bool);
      ((FrameLayout)findViewById(e.e.loading_state_container)).setVisibility(0);
      localObject1 = g.Bkv;
      localObject3 = getUsername();
      s.s(localObject3, "username");
      localObject1 = new FinderAtFeedLoader((g)localObject1, (String)localObject3, getContextObj());
      localObject3 = getIntent();
      s.s(localObject3, "intent");
      ((FinderAtFeedLoader)localObject1).initFromCache((Intent)localObject3);
      ((FinderAtFeedLoader)localObject1).fromScene = getIntent().getIntExtra("key_from_page", g.Bkj.value);
      ((FinderAtFeedLoader)localObject1).BbB = ((kotlin.g.a.a)new f(this));
      ((FinderAtFeedLoader)localObject1).BfX = ((kotlin.g.a.b)new g(this));
      ((FinderAtFeedLoader)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new h(this, (FinderAtFeedLoader)localObject1));
      localObject3 = ah.aiuX;
      this.BlJ = ((FinderAtFeedLoader)localObject1);
      localObject1 = this.BlI;
      if (localObject1 != null) {
        break label527;
      }
      s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    label517:
    label522:
    label527:
    for (;;)
    {
      ((b.b)localObject1).ATx.getRecyclerView().a((RecyclerView.l)new e(this));
      AppMethodBeat.o(364420);
      return;
      i = 0;
      break;
      label506:
      setMMTitle(getTitle());
      break label49;
      i = 0;
      break label151;
      bool = false;
      break label280;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(364424);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("force_show_ad_tip", false))
    {
      a.c localc = this.BlI;
      paramBundle = localc;
      if (localc == null)
      {
        s.bIx("viewCallback");
        paramBundle = null;
      }
      paramBundle.ATx.getRecyclerView().a((RecyclerView.l)new d(this));
    }
    paramBundle = this.BlI;
    if (paramBundle == null)
    {
      s.bIx("viewCallback");
      paramBundle = localObject;
    }
    for (;;)
    {
      paramBundle.ATx.getRecyclerView().post(new FinderAtTimelineUI..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(364424);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364428);
    super.onDestroy();
    BlP.clear();
    this.handler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(364428);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$Companion;", "", "()V", "DELAY_TIME", "", "DISMISS_AT_FEED_TIP", "", "SHOW_AT_FEED_TIP", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<bui>
  {
    b(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    c(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(FinderAtTimelineUI paramFinderAtTimelineUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(365457);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        FinderAtTimelineUI.d(this.BlQ);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(365457);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(365465);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initItemExpose$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(365465);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    e(FinderAtTimelineUI paramFinderAtTimelineUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(365412);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      FinderAtTimelineUI localFinderAtTimelineUI;
      if (paramInt == 0)
      {
        localFinderAtTimelineUI = this.BlQ;
        localObject = FinderAtTimelineUI.c(this.BlQ);
        paramRecyclerView = (RecyclerView)localObject;
        if (localObject == null)
        {
          s.bIx("viewCallback");
          paramRecyclerView = null;
        }
        paramRecyclerView = paramRecyclerView.ATx.getRecyclerView().getLayoutManager();
        if (!(paramRecyclerView instanceof FinderLinearLayoutManager)) {
          break label132;
        }
      }
      label132:
      for (paramRecyclerView = (FinderLinearLayoutManager)paramRecyclerView;; paramRecyclerView = null)
      {
        FinderAtTimelineUI.a(localFinderAtTimelineUI, (LinearLayoutManager)paramRecyclerView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(365412);
        return;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(365418);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initManageAtFeed$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(365418);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    g(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderAtTimelineUI$initOnCreate$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    h(FinderAtTimelineUI paramFinderAtTimelineUI, FinderAtFeedLoader paramFinderAtFeedLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(365436);
      a.c localc = FinderAtTimelineUI.c(this.BlQ);
      Object localObject = localc;
      if (localc == null)
      {
        s.bIx("viewCallback");
        localObject = null;
      }
      localObject = ((b.b)localObject).ATx.getRecyclerView().getLayoutManager();
      if ((localObject instanceof FinderLinearLayoutManager)) {}
      for (localObject = (FinderLinearLayoutManager)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((FinderLinearLayoutManager)localObject).bo(this.BlR.getInitPos(), 0);
        }
        if (paramInt <= 0) {
          break;
        }
        ((FrameLayout)this.BlQ.findViewById(e.e.loading_state_container)).setVisibility(8);
        AppMethodBeat.o(365436);
        return;
      }
      ((FrameLayout)this.BlQ.findViewById(e.e.loading_state_container)).setVisibility(0);
      ((ProgressBar)this.BlQ.findViewById(e.e.tips_loading)).setVisibility(0);
      AppMethodBeat.o(365436);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    i(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<String>
  {
    j(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<String>
  {
    k(FinderAtTimelineUI paramFinderAtTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI
 * JD-Core Version:    0.7.0.1
 */