package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProvider;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicPlayerManager;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.utils.y.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "musicManager", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "tabType", "", "(Lcom/tencent/mm/ui/MMFragmentActivity;Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;I)V", "FEED_COMMENT_EDU_VALUE", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "hasTryMoreAgainSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isLocked", "", "isResume", "lockKV", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaRect", "Landroid/graphics/Rect;", "mediaViewLocation", "", "getMusicManager", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "preCenterFeedId", "", "preFocusFeedId", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "getTabType", "()I", "canPlayNextFocusFeed", "focusFeedId", "focusVideoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invokeMethodName", "check2Play", "", "mediaIndex", "playPosition", "check2SendShowCommentMsg", "centerFeedId", "check2ShowCommentInput", "feedId", "getNearbyDistance", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isAsync", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isUserVisibleFocused", "lock", "scene", "isLock", "unLockAfterCheck", "onCreate", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onEventHappen", "ev", "onPause", "onRelease", "onResume", "onStart", "onStop", "pauseAllImagePlay", "without", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "pauseAllMedia", "playFocusHolder", "focusHolder", "focusMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "playImage", "playMultiVideoHolder", "playMusicHolder", "playSingleVideoHolder", "postCheck", "source", "prepareHolder", "setup", "Companion", "plugin-finder_release"})
public final class FinderVideoAutoPlayManager
  extends d
  implements UILifecycleObserver
{
  public static final a weJ;
  private boolean aHY;
  private final int dLS;
  final RecyclerView hak;
  private boolean isResume;
  private final MMHandler mainHandler;
  private final MMFragmentActivity uLr;
  private final Rect vXx;
  private final int[] weB;
  private long weC;
  private final int weD;
  private long weE;
  private final HashSet<String> weF;
  private final HashSet<String> weG;
  private final FinderVideoRecycler weH;
  private final FinderImgFeedMusicPlayerManager weI;
  
  static
  {
    AppMethodBeat.i(168029);
    weJ = new a((byte)0);
    AppMethodBeat.o(168029);
  }
  
  public FinderVideoAutoPlayManager(MMFragmentActivity paramMMFragmentActivity, RecyclerView paramRecyclerView, FinderVideoRecycler paramFinderVideoRecycler, FinderImgFeedMusicPlayerManager paramFinderImgFeedMusicPlayerManager, int paramInt)
  {
    AppMethodBeat.i(254266);
    this.uLr = paramMMFragmentActivity;
    this.hak = paramRecyclerView;
    this.weH = paramFinderVideoRecycler;
    this.weI = paramFinderImgFeedMusicPlayerManager;
    this.dLS = paramInt;
    this.weB = new int[2];
    this.mainHandler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new b(this));
    this.weC = -1L;
    paramMMFragmentActivity = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.weD = ((Number)com.tencent.mm.plugin.finder.storage.c.duz().value()).intValue();
    this.weE = -1L;
    this.weF = new HashSet();
    this.vXx = new Rect();
    this.weG = new HashSet();
    AppMethodBeat.o(254266);
  }
  
  private final void Gp(long paramLong)
  {
    AppMethodBeat.i(254260);
    if ((this.weD == 1) && (this.weC != paramLong))
    {
      this.weC = paramLong;
      Log.i("Finder.VideoAutoPlayManager", "send show comment msg,feedId:".concat(String.valueOf(paramLong)));
      this.mainHandler.removeMessages(2);
      Message localMessage = this.mainHandler.obtainMessage(2);
      localMessage.obj = Long.valueOf(paramLong);
      this.mainHandler.sendMessageDelayed(localMessage, 5000L);
    }
    AppMethodBeat.o(254260);
  }
  
  private void Y(RecyclerView.v paramv)
  {
    AppMethodBeat.i(254263);
    if (paramv != null)
    {
      localObject = paramv.aus;
      if (localObject == null) {}
    }
    for (Object localObject = (FinderVideoLayout)((View)localObject).findViewById(2131300776);; localObject = null)
    {
      this.weH.J((kotlin.g.a.b)new d((FinderVideoLayout)localObject));
      localObject = y.vXH;
      localObject = y.X(paramv);
      this.weI.F((kotlin.g.a.b)new e((FinderImgFeedMusicTag)localObject));
      Z(paramv);
      AppMethodBeat.o(254263);
      return;
    }
  }
  
  private final void Z(RecyclerView.v paramv)
  {
    AppMethodBeat.i(254265);
    int j = this.hak.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = this.hak.getChildAt(i);
      localObject1 = this.hak.bu((View)localObject1);
      if ((localObject1 != null) && ((localObject1 instanceof com.tencent.mm.view.recyclerview.h)) && ((p.j(paramv, localObject1) ^ true)))
      {
        Object localObject2 = ((com.tencent.mm.view.recyclerview.h)localObject1).hgv();
        if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getMediaType() == 2)) {
          ((FinderMediaBanner)((com.tencent.mm.view.recyclerview.h)localObject1).Mn(2131304549)).dGZ();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(254265);
  }
  
  private final void a(RecyclerView.v paramv, cjl paramcjl, long paramLong)
  {
    AppMethodBeat.i(254261);
    if (paramv != null)
    {
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramv.aus.findViewById(2131300776);
      if (localFinderVideoLayout != null)
      {
        Log.i("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer " + localFinderVideoLayout.dFJ());
        localFinderVideoLayout.play(paramv.lR());
        this.weE = paramLong;
        AppMethodBeat.o(254261);
        return;
      }
      Log.e("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer is null! mediaId=" + paramcjl.mediaId + "] feedId=" + paramLong);
    }
    AppMethodBeat.o(254261);
  }
  
  private static void b(RecyclerView.v paramv, cjl paramcjl, long paramLong)
  {
    AppMethodBeat.i(254262);
    FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)paramv.aus.findViewById(2131300776);
    if (localFinderVideoLayout != null)
    {
      Log.d("Finder.VideoAutoPlayManager", "prepareToPlay ".concat(String.valueOf(paramLong)));
      paramv.lR();
      localFinderVideoLayout.dFA();
      AppMethodBeat.o(254262);
      return;
    }
    Log.e("Finder.VideoAutoPlayManager", "prepareHolder videoContainer is null! mediaId=" + paramcjl.mediaId + "] feedId=" + paramLong);
    AppMethodBeat.o(254262);
  }
  
  private final void s(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(254259);
    Object localObject1 = paramRecyclerView.getLayoutManager();
    final int i;
    final int j;
    final y.a locala;
    final z.a locala1;
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)localObject1).ks();
      j = ((LinearLayoutManager)localObject1).ku();
      localObject1 = y.vXH;
      locala = y.a(paramRecyclerView, i, j, null, 8);
      Gp(locala.feedId);
      locala1 = new z.a();
      locala1.SYB = false;
      localObject1 = y.vXH;
      localObject1 = locala.tAm;
      localObject2 = locala.feed;
      if ((localObject1 == null) || (localObject2 == null)) {
        break label1229;
      }
      if (((com.tencent.mm.view.recyclerview.h)localObject1).lQ() != ((com.tencent.mm.view.recyclerview.h)localObject1).lR())
      {
        localObject3 = "[check2Play] holder=" + localObject1 + " centerId=" + locala.feedId + " first=" + i + " end=" + j + " adapterPosition=" + ((com.tencent.mm.view.recyclerview.h)localObject1).lR() + " layoutPosition=" + ((com.tencent.mm.view.recyclerview.h)localObject1).lQ() + " isInLayout=" + paramRecyclerView.isInLayout();
        Log.e("Finder.VideoAutoPlayManager", (String)localObject3);
        com.tencent.mm.plugin.report.service.h.CyF.a(20251, new Object[] { Integer.valueOf(1), localObject3 });
        localObject3 = ((com.tencent.mm.view.recyclerview.h)localObject1).hashCode() + '_' + ((com.tencent.mm.view.recyclerview.h)localObject1).lR() + '_' + ((com.tencent.mm.view.recyclerview.h)localObject1).lQ() + '_' + ((com.tencent.mm.view.recyclerview.h)localObject1).lT();
        if (!this.weG.contains(localObject3))
        {
          paramRecyclerView.post((Runnable)new f((String)localObject3, this, locala, i, j, paramRecyclerView, locala1));
          AppMethodBeat.o(254259);
          return;
        }
      }
      localObject3 = a.PRN;
      localObject3 = ((FinderReporterUIC)a.b((AppCompatActivity)this.uLr).get(FinderReporterUIC.class)).MC(this.dLS);
      if (localObject3 != null) {
        ((f)localObject3).f(paramRecyclerView, 6);
      }
      paramRecyclerView = (FinderMediaBanner)((com.tencent.mm.view.recyclerview.h)localObject1).Mn(2131304549);
      if (paramRecyclerView != null) {
        paramRecyclerView.getGlobalVisibleRect(this.vXx);
      }
      if (paramRecyclerView == null) {
        break label1056;
      }
      i = paramRecyclerView.getHeight();
      Log.d("Finder.VideoAutoPlayManager", "check2Play bannerHeight:" + i + " mediaRect:" + this.vXx.height());
      if ((i <= 0) || (this.vXx.height() < i / 2.5F) || ((((FeedData)localObject2).getMediaType() != 4) && (((FeedData)localObject2).getMediaType() != 9))) {
        break label1061;
      }
      paramRecyclerView = (cjl)j.kt((List)((FeedData)localObject2).getMediaList());
      if (paramRecyclerView != null)
      {
        Y((RecyclerView.v)localObject1);
        a((RecyclerView.v)localObject1, paramRecyclerView, ((FeedData)localObject2).getId());
      }
      locala1.SYB = true;
      label558:
      paramRecyclerView = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dxe().value()).intValue() == 1)
      {
        paramRecyclerView = null;
        localObject2 = null;
        localObject1 = (List)locala.vXI;
        i = 0;
        localObject1 = ((List)localObject1).iterator();
        label604:
        if (!((Iterator)localObject1).hasNext()) {
          break label1178;
        }
        if (((y.a)((Iterator)localObject1).next()).feedId != locala.feedId) {
          break label1166;
        }
        j = 1;
        label638:
        if (j == 0) {
          break label1171;
        }
        label642:
        localObject1 = localObject2;
        if (i != -1)
        {
          j = i - 1;
          i += 1;
          if ((j < 0) || (j >= locala.vXI.size())) {
            break label1241;
          }
        }
      }
    }
    label771:
    label801:
    label811:
    label844:
    label1229:
    label1241:
    for (paramRecyclerView = (y.a)locala.vXI.get(j);; paramRecyclerView = null)
    {
      if ((i >= 0) && (i < locala.vXI.size())) {}
      for (localObject1 = (y.a)locala.vXI.get(i);; localObject1 = localObject2)
      {
        localObject3 = new StringBuilder("check2Play preFeed:");
        if (paramRecyclerView != null)
        {
          localObject2 = Long.valueOf(paramRecyclerView.feedId);
          label743:
          localObject3 = ((StringBuilder)localObject3).append(localObject2).append(" nextFeed:");
          if (paramRecyclerView == null) {
            break label1189;
          }
          localObject2 = Long.valueOf(paramRecyclerView.feedId);
          Log.d("Finder.VideoAutoPlayManager", localObject2);
          localObject2 = y.vXH;
          if (paramRecyclerView == null) {
            break label1195;
          }
          localObject2 = paramRecyclerView.tAm;
          if (paramRecyclerView == null) {
            break label1201;
          }
          localObject3 = paramRecyclerView.feed;
          if (paramRecyclerView == null) {
            break label1207;
          }
          paramRecyclerView = paramRecyclerView.feed;
          if (paramRecyclerView == null) {
            break label1207;
          }
          paramRecyclerView = paramRecyclerView.getMediaList();
          if (paramRecyclerView == null) {
            break label1207;
          }
          paramRecyclerView = (cjl)j.kt((List)paramRecyclerView);
          if ((localObject2 != null) && (localObject3 != null) && (paramRecyclerView != null) && (((FeedData)localObject3).getMediaType() == 4)) {
            b((RecyclerView.v)localObject2, paramRecyclerView, ((FeedData)localObject3).getId());
          }
          paramRecyclerView = y.vXH;
          if (localObject1 == null) {
            break label1212;
          }
          paramRecyclerView = ((y.a)localObject1).tAm;
          if (localObject1 == null) {
            break label1217;
          }
          localObject2 = ((y.a)localObject1).feed;
          if (localObject1 == null) {
            break label1223;
          }
          localObject1 = ((y.a)localObject1).feed;
          if (localObject1 == null) {
            break label1223;
          }
          localObject1 = ((FeedData)localObject1).getMediaList();
          if (localObject1 == null) {
            break label1223;
          }
          localObject1 = (cjl)j.kt((List)localObject1);
          if ((paramRecyclerView != null) && (localObject2 != null) && (localObject1 != null) && (((FeedData)localObject2).getMediaType() == 4)) {
            b((RecyclerView.v)paramRecyclerView, (cjl)localObject1, ((FeedData)localObject2).getId());
          }
        }
        for (paramRecyclerView = "ret ok";; paramRecyclerView = null)
        {
          if (paramRecyclerView == null) {
            new StringBuilder("error is null ").append(locala.tAm).append(", ").append(locala.feed);
          }
          if (!locala1.SYB) {
            a(this);
          }
          paramRecyclerView = k.vkd;
          k.a(locala);
          AppMethodBeat.o(254259);
          return;
          i = 0;
          break;
          if ((i > 0) && (((FeedData)localObject2).getMediaType() == 2))
          {
            Y((RecyclerView.v)localObject1);
            if (((FeedData)localObject2).getHasBgmInfo())
            {
              paramRecyclerView = (RecyclerView.v)localObject1;
              if (paramRecyclerView != null)
              {
                localObject2 = y.vXH;
                paramRecyclerView = y.X(paramRecyclerView);
                if (paramRecyclerView == null) {
                  break label1148;
                }
                paramRecyclerView.dlf();
              }
            }
            for (;;)
            {
              if (localObject1 != null) {
                ((FinderMediaBanner)((com.tencent.mm.view.recyclerview.h)localObject1).Mn(2131304549)).setAutoPlay(true);
              }
              locala1.SYB = true;
              break;
              label1148:
              Log.e("Finder.VideoAutoPlayManager", "playMusicHolder musicContainer is null!");
            }
          }
          a(this);
          break label558;
          j = 0;
          break label638;
          i += 1;
          break label604;
          i = -1;
          break label642;
          localObject2 = null;
          break label743;
          localObject2 = null;
          break label771;
          localObject2 = null;
          break label801;
          localObject3 = null;
          break label811;
          paramRecyclerView = null;
          break label844;
          paramRecyclerView = null;
          break label896;
          localObject2 = null;
          break label908;
          localObject1 = null;
          break label950;
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(168015);
    p.h(paramb, "ev");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) {
      this.hak.post((Runnable)new c(this));
    }
    AppMethodBeat.o(168015);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(168021);
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 3) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 8) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5))
      {
        AppMethodBeat.o(168021);
        return true;
      }
      AppMethodBeat.o(168021);
      return false;
    }
    AppMethodBeat.o(168021);
    return false;
  }
  
  public final void awI(String paramString)
  {
    AppMethodBeat.i(254257);
    p.h(paramString, "source");
    Log.i("Finder.VideoAutoPlayManager", "[postCheck] source=".concat(String.valueOf(paramString)));
    this.mainHandler.removeMessages(1);
    this.mainHandler.sendEmptyMessage(1);
    AppMethodBeat.o(254257);
  }
  
  public final boolean cZD()
  {
    return false;
  }
  
  public final void g(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(254255);
    p.h(paramString, "scene");
    Log.i("Finder.VideoAutoPlayManager", "[lock] scene=" + paramString + " isLock=" + paramBoolean1 + " lockSize=" + this.weF.size() + " unLockAfterCheck=" + paramBoolean2);
    if (paramBoolean1)
    {
      this.weF.add(paramString);
      this.aHY = true;
    }
    for (;;)
    {
      this.mainHandler.removeMessages(1);
      if ((!this.aHY) && (paramBoolean2)) {
        this.mainHandler.sendEmptyMessage(1);
      }
      AppMethodBeat.o(254255);
      return;
      this.weF.remove(paramString);
      if (this.weF.size() <= 0) {
        this.aHY = false;
      }
    }
  }
  
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168022);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168022);
  }
  
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168027);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168027);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168025);
    p.h(paramLifecycleOwner, "var1");
    this.mainHandler.removeMessages(1);
    this.mainHandler.removeMessages(2);
    this.isResume = false;
    AppMethodBeat.o(168025);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(168016);
    super.onRelease();
    this.mainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(168016);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168024);
    p.h(paramLifecycleOwner, "var1");
    if ((this.uLr instanceof FinderHomeUI))
    {
      paramLifecycleOwner = a.PRN;
      paramLifecycleOwner = a.b((AppCompatActivity)this.uLr).get(FinderHomeUIC.class);
      p.g(paramLifecycleOwner, "UICProvider.of(activity)…inderHomeUIC::class.java)");
      if ((((FinderHomeUIC)paramLifecycleOwner).dIf() == this.dLS) && (!this.mainHandler.hasMessages(1))) {
        this.mainHandler.sendEmptyMessage(1);
      }
    }
    this.isResume = true;
    AppMethodBeat.o(168024);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168023);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168023);
  }
  
  public final void onStop(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168026);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168026);
  }
  
  public final void setup()
  {
    AppMethodBeat.i(168013);
    Object localObject = this.uLr;
    if (localObject != null) {
      a((MMFragmentActivity)localObject, (UILifecycleObserver)this);
    }
    localObject = a.PRN;
    localObject = ((FinderReporterUIC)a.b((AppCompatActivity)this.uLr).get(FinderReporterUIC.class)).MA(this.dLS);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).a((d)this);
    }
    if (!this.mainHandler.hasMessages(1)) {
      this.mainHandler.sendEmptyMessageDelayed(1, 500L);
    }
    AppMethodBeat.o(168013);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager$Companion;", "", "()V", "BASE_LINE", "", "DELAY_CHECK_TIME", "", "DELAY__SHOW_COMMENT_CHECK_TIME", "TAG", "", "WHAT_CHECK_PLAY", "", "WHAT_CHECK_SHOW_COMMENT_INPUT", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    b(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(168011);
      if (paramMessage.what == 1)
      {
        Log.i("Finder.VideoAutoPlayManager", "data change to check play...");
        FinderVideoAutoPlayManager.a(this.weK, this.weK.hak);
      }
      for (;;)
      {
        AppMethodBeat.o(168011);
        return true;
        if (paramMessage.what == 2)
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(168011);
            throw paramMessage;
          }
          FinderVideoAutoPlayManager.Gq(((Long)paramMessage).longValue());
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager) {}
    
    public final void run()
    {
      AppMethodBeat.i(254250);
      FinderVideoAutoPlayManager.a(this.weK, this.weK.hak);
      AppMethodBeat.o(254250);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<r, Boolean>
  {
    d(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "musicViewInManager", "Landroid/view/View;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<View, Boolean>
  {
    e(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager$playMultiVideoHolder$result$1$1"})
  static final class f
    implements Runnable
  {
    f(String paramString, FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, y.a parama, int paramInt1, int paramInt2, RecyclerView paramRecyclerView, z.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(254253);
      FinderVideoAutoPlayManager.b(jdField_this).add(this.$key);
      FinderVideoAutoPlayManager.a(jdField_this, paramRecyclerView);
      AppMethodBeat.o(254253);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, String paramString, RecyclerView paramRecyclerView) {}
    
    public final void run()
    {
      AppMethodBeat.i(254254);
      FinderVideoAutoPlayManager.b(this.weK).add(this.$key);
      FinderVideoAutoPlayManager.a(this.weK, this.tDJ);
      AppMethodBeat.o(254254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager
 * JD-Core Version:    0.7.0.1
 */