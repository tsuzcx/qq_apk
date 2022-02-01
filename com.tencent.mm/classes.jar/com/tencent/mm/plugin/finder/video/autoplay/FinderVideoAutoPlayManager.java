package com.tencent.mm.plugin.finder.video.autoplay;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView.b;
import com.tencent.mm.plugin.finder.loader.v;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.l;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.bi;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.j;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$OnFeedChangeCallback;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "musicManager", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "tabType", "", "(Lcom/tencent/mm/ui/MMFragmentActivity;Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;I)V", "FEED_COMMENT_EDU_VALUE", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "feedSelectorAdapter", "Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter;", "hasTryMoreAgainSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isLocked", "", "isResume", "lockKV", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMusicManager", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "preCenterFeedId", "", "readyPlayForwardTrace", "Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getTabType", "()I", "check2Play", "", "forceCheckSame", "check2PlayInternalV2", "check2SendShowCommentMsg", "centerFeedId", "check2ShowCommentInput", "feedId", "getFTPPTag", "selectedFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "handleOnFeedUnSelected", "source", "", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "feed", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "isAsync", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isUserVisibleFocused", "lock", "scene", "isLock", "unLockAfterCheck", "onCreate", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onEventHappen", "ev", "onFeedSelected", "onFeedUnSelected", "onNextFeedPrepare", "onPageScrollStateChanged", "state", "onPause", "onRelease", "onResume", "onStart", "onStop", "pauseAllImagePlay", "without", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pauseAllMedia", "playFocusHolder", "focusHolder", "focusMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "playImage", "playMusicHolder", "playSelectedFeed", "postCheck", "preloadNextFeed", "nextFeed", "prepareNextHolder", "prepareHolder", "setup", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoAutoPlayManager
  extends com.tencent.mm.plugin.finder.event.base.d
  implements com.tencent.mm.plugin.finder.life.b, a.b
{
  public static final a GrR;
  private final MMFragmentActivity EzS;
  private final bi GpW;
  private final com.tencent.mm.plugin.finder.music.b GpX;
  private final a GrS;
  private com.tencent.mm.plugin.findersdk.f.c GrT;
  private long GrU;
  private final int GrV;
  private final HashSet<String> GrW;
  private boolean GrX;
  private final HashSet<String> GrY;
  private final int hJx;
  private boolean isResume;
  private final MMHandler mainHandler;
  private final RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(335524);
    GrR = new a((byte)0);
    AppMethodBeat.o(335524);
  }
  
  public FinderVideoAutoPlayManager(MMFragmentActivity paramMMFragmentActivity, RecyclerView paramRecyclerView, bi parambi, com.tencent.mm.plugin.finder.music.b paramb, int paramInt)
  {
    AppMethodBeat.i(335418);
    this.EzS = paramMMFragmentActivity;
    this.mkw = paramRecyclerView;
    this.GpW = parambi;
    this.GpX = paramb;
    this.hJx = paramInt;
    this.GrS = new a();
    this.GrT = new com.tencent.mm.plugin.findersdk.f.c("ReadyPlayForward");
    this.mainHandler = new MMHandler(Looper.getMainLooper(), new FinderVideoAutoPlayManager..ExternalSyntheticLambda0(this));
    this.GrU = -1L;
    paramMMFragmentActivity = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.GrV = ((Number)com.tencent.mm.plugin.finder.storage.d.eUj().bmg()).intValue();
    paramMMFragmentActivity = this.GrS;
    paramRecyclerView = this.mkw;
    paramInt = this.hJx;
    s.u(paramRecyclerView, "recyclerView");
    Log.i("FinderFeedSelectorAdapter", s.X("bindRecyclerView recyclerView:", paramRecyclerView));
    paramMMFragmentActivity.mkw = paramRecyclerView;
    paramMMFragmentActivity.hJx = paramInt;
    if ((paramRecyclerView instanceof FinderRecyclerView))
    {
      parambi = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWu().bmg()).intValue() == 1) {
        ((FinderRecyclerView)paramRecyclerView).setPageChangeListener((FinderRecyclerView.b)new a.d(paramMMFragmentActivity));
      }
    }
    paramRecyclerView.a((RecyclerView.i)new a.e(paramRecyclerView, paramMMFragmentActivity));
    paramRecyclerView = paramMMFragmentActivity.mkw;
    if (paramRecyclerView != null) {
      paramRecyclerView.a((RecyclerView.l)new a.c(paramRecyclerView, paramMMFragmentActivity));
    }
    paramMMFragmentActivity = this.GrS;
    paramRecyclerView = (a.b)this;
    s.u(paramRecyclerView, "onFeedChangeCallback");
    paramMMFragmentActivity.GrK = paramRecyclerView;
    this.GrW = new HashSet();
    this.GrY = new HashSet();
    AppMethodBeat.o(335418);
  }
  
  private void U(RecyclerView.v paramv)
  {
    AppMethodBeat.i(335463);
    Log.i("Finder.VideoAutoPlayManager", s.X("pauseAllMedia without:", paramv));
    Object localObject;
    if (paramv == null) {
      localObject = null;
    }
    for (;;)
    {
      this.GpW.aw((kotlin.g.a.b)new b((FinderVideoLayout)localObject));
      localObject = av.GiL;
      localObject = av.T(paramv);
      this.GpX.as((kotlin.g.a.b)new c((FinderImgFeedMusicTag)localObject));
      V(paramv);
      AppMethodBeat.o(335463);
      return;
      localObject = paramv.caK;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (FinderVideoLayout)((View)localObject).findViewById(e.e.finder_banner_video_layout);
      }
    }
  }
  
  private final void V(RecyclerView.v paramv)
  {
    AppMethodBeat.i(335471);
    int k = this.mkw.getChildCount();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject1 = this.mkw.getChildAt(i);
      localObject1 = this.mkw.by((View)localObject1);
      if ((localObject1 != null) && ((localObject1 instanceof j)) && (!s.p(paramv, localObject1)))
      {
        Object localObject2 = ((j)localObject1).CSA;
        if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getMediaType() == 2)) {
          ((FinderMediaBanner)((j)localObject1).UH(e.e.media_banner)).flb();
        }
      }
      if (j >= k)
      {
        AppMethodBeat.o(335471);
        return;
      }
      i = j;
    }
  }
  
  private final void a(RecyclerView.v paramv, dji paramdji, long paramLong, com.tencent.mm.plugin.findersdk.f.a parama)
  {
    AppMethodBeat.i(335456);
    Object localObject1;
    FinderVideoLayout localFinderVideoLayout;
    if (paramv != null)
    {
      localObject1 = (FrameLayout)paramv.caK.findViewById(e.e.finder_share_stream_cover);
      if ((localObject1 != null) && (((FrameLayout)localObject1).getVisibility() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer shareShadowView is visible, return}");
        AppMethodBeat.o(335456);
        return;
      }
      localFinderVideoLayout = (FinderVideoLayout)paramv.caK.findViewById(e.e.finder_banner_video_layout);
      if (localFinderVideoLayout != null) {
        break label137;
      }
      paramv = null;
      if (paramv == null) {
        Log.e("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer is null! mediaId=" + paramdji.mediaId + "] feedId=" + paramLong);
      }
    }
    AppMethodBeat.o(335456);
    return;
    label137:
    Object localObject2 = localFinderVideoLayout.GqA;
    label154:
    boolean bool1;
    label202:
    boolean bool2;
    if (localObject2 == null)
    {
      localObject1 = "[FinderVideoLayout#loginfo] playInfo is null";
      Log.i("Finder.VideoAutoPlayManager", s.X("playFocusHolder videoContainer ", localObject1));
      if (parama != null) {
        parama.aDn("playFocusHolder");
      }
      localFinderVideoLayout.setSelectedToPlay(true);
      localObject1 = localFinderVideoLayout.getVideoView();
      if (localObject1 != null) {
        break label442;
      }
      bool1 = false;
      bool2 = localFinderVideoLayout.Gqz;
      if (!bool1) {
        break label454;
      }
      if (parama != null) {
        parama.gG("hitPause");
      }
    }
    for (;;)
    {
      localFinderVideoLayout.a(paramv.KJ(), parama);
      if (!this.isResume) {
        this.GpW.aw((kotlin.g.a.b)FinderVideoAutoPlayManager.d.Gsb);
      }
      paramv = ah.aiuX;
      break;
      localObject1 = ((FinderVideoLayout.b)localObject2).EEv;
      ((FinderVideoLayout.b)localObject2).feed.getExpectId();
      localObject2 = ((FinderVideoLayout.b)localObject2).mediaList;
      localObject2 = "[FinderVideoLayout#loginfo] layout=[" + localFinderVideoLayout.getWidth() + ':' + localFinderVideoLayout.getHeight() + "] videoView=[" + localFinderVideoLayout.getWidth() + ':' + localFinderVideoLayout.getHeight() + "] video=[" + ((v)localObject1).ExE.width + ':' + ((v)localObject1).ExE.height + "] " + localFinderVideoLayout.fjx() + " media=" + localObject1 + " mediaList=" + ((LinkedList)localObject2).size();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label154;
      }
      localObject1 = "[FinderVideoLayout#loginfo] playInfo is null";
      break label154;
      label442:
      bool1 = ((t)localObject1).isPlaying();
      break label202;
      label454:
      if ((bool2) && (parama != null)) {
        parama.gG("hitPreRender");
      }
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.event.base.b paramb, FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager)
  {
    AppMethodBeat.i(335495);
    s.u(paramb, "$ev");
    s.u(paramFinderVideoAutoPlayManager, "this$0");
    if (((com.tencent.mm.plugin.finder.event.base.h)paramb).AOu != 5) {}
    for (boolean bool = true;; bool = false)
    {
      paramFinderVideoAutoPlayManager.uI(bool);
      AppMethodBeat.o(335495);
      return;
    }
  }
  
  private static final void a(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, FeedData paramFeedData, j paramj, com.tencent.mm.plugin.findersdk.f.a parama)
  {
    AppMethodBeat.i(335506);
    dji localdji = (dji)p.oL((List)paramFeedData.getMediaList());
    if (localdji == null) {}
    for (paramFinderVideoAutoPlayManager = null;; paramFinderVideoAutoPlayManager = ah.aiuX)
    {
      if (paramFinderVideoAutoPlayManager == null) {
        Log.w("Finder.VideoAutoPlayManager", "playFocusHolder mediaList first feed null.");
      }
      AppMethodBeat.o(335506);
      return;
      paramFinderVideoAutoPlayManager.U((RecyclerView.v)paramj);
      paramFinderVideoAutoPlayManager.a((RecyclerView.v)paramj, localdji, paramFeedData.getId(), parama);
      Log.i("Finder.VideoAutoPlayManager", "playFocusHolder mediaList first feed.");
    }
  }
  
  private static final void a(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, String paramString)
  {
    AppMethodBeat.i(335517);
    s.u(paramFinderVideoAutoPlayManager, "this$0");
    s.u(paramString, "$key");
    paramFinderVideoAutoPlayManager.GrY.add(paramString);
    paramFinderVideoAutoPlayManager.uI(true);
    AppMethodBeat.o(335517);
  }
  
  private static final boolean a(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, Message paramMessage)
  {
    AppMethodBeat.i(335485);
    s.u(paramFinderVideoAutoPlayManager, "this$0");
    s.u(paramMessage, "it");
    if (paramMessage.what == 1)
    {
      Log.i("Finder.VideoAutoPlayManager", "data change to check play...");
      paramFinderVideoAutoPlayManager.uI(false);
    }
    for (;;)
    {
      AppMethodBeat.o(335485);
      return true;
      if (paramMessage.what == 2)
      {
        paramFinderVideoAutoPlayManager = paramMessage.obj;
        if (paramFinderVideoAutoPlayManager == null)
        {
          paramFinderVideoAutoPlayManager = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(335485);
          throw paramFinderVideoAutoPlayManager;
        }
        long l = ((Long)paramFinderVideoAutoPlayManager).longValue();
        paramFinderVideoAutoPlayManager = av.GiL;
        if (l == av.ffU())
        {
          paramFinderVideoAutoPlayManager = av.GiL;
          paramFinderVideoAutoPlayManager = av.GiL;
          av.a(av.ffU(), true, 3);
        }
        else
        {
          Log.i("Finder.VideoAutoPlayManager", "feedId:" + l + " no eqauls current center feed");
        }
      }
    }
  }
  
  private final void uI(boolean paramBoolean)
  {
    AppMethodBeat.i(335435);
    this.mainHandler.removeMessages(1);
    long l = cn.bDw();
    a.a(this.GrS, null, paramBoolean, "checkSelected", 1);
    Log.d("Finder.VideoAutoPlayManager", s.X("check2Play cost:", Long.valueOf(cn.bDw() - l)));
    AppMethodBeat.o(335435);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(335655);
    s.u(paramb, "ev");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      Log.i("Finder.VideoAutoPlayManager", "onEventHappen event state:" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOu + " event feed:" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv);
      this.mkw.post(new FinderVideoAutoPlayManager..ExternalSyntheticLambda1(paramb, this));
    }
    AppMethodBeat.o(335655);
  }
  
  public final void a(List<? extends com.tencent.mm.view.recyclerview.a> paramList, com.tencent.mm.plugin.finder.utils.d paramd, j paramj, int paramInt)
  {
    AppMethodBeat.i(335566);
    s.u(paramList, "source");
    s.u(paramd, "feed");
    s.u(paramj, "holder");
    Log.i("Finder.VideoAutoPlayManager", s.X("onFeedUnSelected position:", Integer.valueOf(paramInt)));
    paramList = (FinderVideoLayout)paramj.caK.findViewById(e.e.finder_banner_video_layout);
    if (paramList != null) {
      paramList.setSelectedToPlay(false);
    }
    AppMethodBeat.o(335566);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(335674);
    s.u(paramc, "dispatcher");
    s.u(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 3) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 11))
      {
        AppMethodBeat.o(335674);
        return true;
      }
      AppMethodBeat.o(335674);
      return false;
    }
    AppMethodBeat.o(335674);
    return false;
  }
  
  public final void aCs(String paramString)
  {
    AppMethodBeat.i(335646);
    s.u(paramString, "source");
    Log.i("Finder.VideoAutoPlayManager", s.X("[postCheck] source=", paramString));
    this.mainHandler.removeMessages(1);
    this.mainHandler.sendEmptyMessage(1);
    AppMethodBeat.o(335646);
  }
  
  public final void b(List<? extends com.tencent.mm.view.recyclerview.a> paramList, com.tencent.mm.plugin.finder.utils.d paramd, j paramj, int paramInt)
  {
    AppMethodBeat.i(335593);
    s.u(paramList, "source");
    s.u(paramd, "feed");
    s.u(paramj, "holder");
    Log.i("Finder.VideoAutoPlayManager", s.X("onFeedSelected position:", Integer.valueOf(paramInt)));
    this.GrT.gF("onFeedSelected");
    if (!this.isResume)
    {
      Log.w("Finder.VideoAutoPlayManager", s.X("[playSelectedFeed] activity is not resume, tabType=", Integer.valueOf(this.hJx)));
      AppMethodBeat.o(335593);
      return;
    }
    if (this.GrX)
    {
      Log.w("Finder.VideoAutoPlayManager", "[playSelectedFeed] isLocked=" + this.GrX + " lockKV=" + this.GrW + " tabType=" + this.hJx);
      AppMethodBeat.o(335593);
      return;
    }
    if ((this.EzS instanceof FinderHomeUI))
    {
      paramList = k.aeZF;
      paramList = k.d((AppCompatActivity)this.EzS).q(FinderHomeUIC.class);
      s.s(paramList, "UICProvider.of(activity)…inderHomeUIC::class.java)");
      if (((FinderHomeUIC)paramList).fnX() == this.hJx) {}
    }
    for (paramInt = 0; paramInt == 0; paramInt = 1)
    {
      Log.w("Finder.VideoAutoPlayManager", s.X("[playSelectedFeed] isUserVisibleFocused=false tabType=", Integer.valueOf(this.hJx)));
      AppMethodBeat.o(335593);
      return;
    }
    Log.i("Finder.VideoAutoPlayManager", s.X("playSelectedFeed feed:", paramd));
    long l = paramd.feedId;
    if ((this.GrV == 1) && (this.GrU != l))
    {
      this.GrU = l;
      Log.i("Finder.VideoAutoPlayManager", s.X("send show comment msg,feedId:", Long.valueOf(l)));
      this.mainHandler.removeMessages(2);
      paramList = this.mainHandler.obtainMessage(2);
      paramList.obj = Long.valueOf(l);
      this.mainHandler.sendMessageDelayed(paramList, 5000L);
    }
    paramj = new StringBuilder().append(paramd.GfU).append('.');
    paramList = paramd.feed;
    if (paramList == null) {}
    for (paramList = null;; paramList = paramList.getDescription())
    {
      paramList = new com.tencent.mm.plugin.findersdk.f.a(s.X("FVPT-", o.aBv(paramList) + '.' + o.aBv(paramd.mediaId)));
      paramList.gF("onSelected");
      if (paramd.AIz != null) {
        break;
      }
      Log.w("Finder.VideoAutoPlayManager", "playSelectedFeed return for holder:null");
      AppMethodBeat.o(335593);
      return;
    }
    paramj = paramd.AIz;
    s.checkNotNull(paramj);
    if (paramd.feed == null)
    {
      Log.w("Finder.VideoAutoPlayManager", "playSelectedFeed return for feed:null");
      AppMethodBeat.o(335593);
      return;
    }
    Object localObject = paramd.feed;
    s.checkNotNull(localObject);
    if (paramj.KI() != paramj.KJ())
    {
      String str = "playSelectedFeed holder=" + paramj + " centerId=" + paramd.feedId + " adapterPosition=" + paramj.KJ() + " layoutPosition=" + paramj.KI() + " isInLayout=" + this.mkw.isInLayout();
      Log.e("Finder.VideoAutoPlayManager", str);
      com.tencent.mm.plugin.report.service.h.OAn.b(20251, new Object[] { Integer.valueOf(1), str });
      str = paramj.hashCode() + '_' + paramj.KJ() + '_' + paramj.KI() + '_' + paramj.caN;
      if (!this.GrY.contains(str))
      {
        this.mkw.post(new FinderVideoAutoPlayManager..ExternalSyntheticLambda2(this, str));
        AppMethodBeat.o(335593);
        return;
      }
    }
    Log.w("Finder.VideoAutoPlayManager", s.X("playSelectedFeed mediaType:", Integer.valueOf(((FeedData)localObject).getMediaType())));
    if (((FeedData)localObject).getMediaType() == 4) {
      a(this, (FeedData)localObject, paramj, paramList);
    }
    for (;;)
    {
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).a(paramd);
      AppMethodBeat.o(335593);
      return;
      if (((FeedData)localObject).getMediaType() == 9)
      {
        a(this, (FeedData)localObject, paramj, paramList);
      }
      else
      {
        if (((FeedData)localObject).getMediaType() == 2)
        {
          U((RecyclerView.v)paramj);
          if ((((FeedData)localObject).getHasBgmInfo()) && (paramj != null))
          {
            paramList = av.GiL;
            paramList = av.T((RecyclerView.v)paramj);
            localObject = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
            if (localObject != null) {
              break label944;
            }
            bool = false;
            label846:
            if (!bool)
            {
              if (paramList != null) {
                break label954;
              }
              paramList = null;
              label857:
              if (paramList == null) {
                Log.e("Finder.VideoAutoPlayManager", "playMusicHolder musicContainer is null!");
              }
            }
          }
          if (paramj != null)
          {
            paramList = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
            if (paramList != null) {
              break label965;
            }
          }
          label944:
          label954:
          label965:
          for (boolean bool = false;; bool = paramList.Gnn)
          {
            Log.i("Finder.VideoAutoPlayManager", s.X("[playImage] isInSeekMode: ", Boolean.valueOf(bool)));
            if (!bool) {
              ((FinderMediaBanner)paramj.UH(e.e.media_banner)).setAutoPlay(true);
            }
            Log.i("Finder.VideoAutoPlayManager", s.X("playSelectedFeed hit playImage feed:", paramd));
            break;
            bool = ((FinderFullSeekBarLayout)localObject).Gnn;
            break label846;
            paramList.eDU();
            paramList = ah.aiuX;
            break label857;
          }
        }
        Log.i("Finder.VideoAutoPlayManager", s.X("playSelectedFeed hit pauseAllMedia feed:", paramd));
        U(null);
      }
    }
  }
  
  public final void c(List<? extends com.tencent.mm.view.recyclerview.a> paramList, com.tencent.mm.plugin.finder.utils.d paramd, j paramj, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(335608);
    s.u(paramList, "source");
    s.u(paramd, "feed");
    s.u(paramj, "holder");
    Log.i("Finder.VideoAutoPlayManager", s.X("onNextFeedPrepare position:", Integer.valueOf(paramInt)));
    paramList = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVX().bmg()).intValue() == 0)
    {
      Log.w("Finder.VideoAutoPlayManager", "preloadNextFeed return for disable");
      AppMethodBeat.o(335608);
      return;
    }
    label111:
    FeedData localFeedData;
    label118:
    label124:
    long l;
    if (paramd == null)
    {
      paramList = null;
      Log.i("Finder.VideoAutoPlayManager", s.X("preloadNextFeed nextFeed:", paramList));
      paramList = av.GiL;
      if (paramd != null) {
        break label242;
      }
      paramj = null;
      if (paramd != null) {
        break label250;
      }
      localFeedData = null;
      if (paramd != null) {
        break label259;
      }
      paramList = null;
      paramd = aw.Gjk;
      if ((paramj != null) && (localFeedData != null) && (paramList != null) && (localFeedData.getMediaType() == 4))
      {
        paramd = (RecyclerView.v)paramj;
        l = localFeedData.getId();
        paramj = (FinderVideoLayout)paramd.caK.findViewById(e.e.finder_banner_video_layout);
        if (paramj != null) {
          break label301;
        }
      }
    }
    for (paramd = localObject;; paramd = ah.aiuX)
    {
      if (paramd == null) {
        Log.e("Finder.VideoAutoPlayManager", "prepareNextHolder videoContainer is null! mediaId=" + paramList.mediaId + "] feedId=" + l);
      }
      AppMethodBeat.o(335608);
      return;
      paramList = Long.valueOf(paramd.feedId);
      break;
      label242:
      paramj = paramd.AIz;
      break label111;
      label250:
      localFeedData = paramd.feed;
      break label118;
      label259:
      paramList = paramd.feed;
      if (paramList == null)
      {
        paramList = null;
        break label124;
      }
      paramList = paramList.getMediaList();
      if (paramList == null)
      {
        paramList = null;
        break label124;
      }
      paramList = (dji)p.oL((List)paramList);
      break label124;
      label301:
      Log.i("Finder.VideoAutoPlayManager", s.X("prepareNextHolder ", Long.valueOf(l)));
      paramInt = paramd.KJ();
      paramd = paramj.GqA;
      if (paramd != null)
      {
        paramd.feed.setPosition(paramInt);
        paramj.getVideoCore().fjp().a((ViewGroup)paramj, (x)paramd.EEv, (kotlin.g.a.b)new FinderVideoLayout.l(paramj, paramd));
      }
    }
  }
  
  public final boolean dXA()
  {
    return false;
  }
  
  public final void i(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(335637);
    s.u(paramString, "scene");
    Log.i("Finder.VideoAutoPlayManager", "[lock] scene=" + paramString + " isLock=" + paramBoolean1 + " lockSize=" + this.GrW.size() + " unLockAfterCheck=" + paramBoolean2);
    if (paramBoolean1)
    {
      this.GrW.add(paramString);
      this.GrX = true;
    }
    for (;;)
    {
      this.mainHandler.removeMessages(1);
      if ((!this.GrX) && (paramBoolean2)) {
        this.mainHandler.sendEmptyMessage(1);
      }
      AppMethodBeat.o(335637);
      return;
      this.GrW.remove(paramString);
      if (this.GrW.size() <= 0) {
        this.GrX = false;
      }
    }
  }
  
  public final void k(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(335616);
    s.u(paramRecyclerView, "recyclerView");
    Log.i("Finder.VideoAutoPlayManager", s.X("onPageScrollStateChanged state:", Integer.valueOf(paramInt)));
    if (paramInt == 0) {
      this.GrT.gG("onViewIdle");
    }
    AppMethodBeat.o(335616);
  }
  
  public final void onCreate(q paramq)
  {
    AppMethodBeat.i(335680);
    s.u(paramq, "var1");
    AppMethodBeat.o(335680);
  }
  
  public final void onDestroy(q paramq)
  {
    AppMethodBeat.i(335716);
    s.u(paramq, "var1");
    AppMethodBeat.o(335716);
  }
  
  public final void onPause(q paramq)
  {
    AppMethodBeat.i(335700);
    s.u(paramq, "var1");
    this.mainHandler.removeMessages(1);
    this.mainHandler.removeMessages(2);
    this.isResume = false;
    AppMethodBeat.o(335700);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(335663);
    super.onRelease();
    this.mainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(335663);
  }
  
  public final void onResume(q paramq)
  {
    AppMethodBeat.i(335695);
    s.u(paramq, "var1");
    if ((this.EzS instanceof FinderHomeUI))
    {
      paramq = k.aeZF;
      paramq = k.d((AppCompatActivity)this.EzS).q(FinderHomeUIC.class);
      s.s(paramq, "UICProvider.of(activity)…inderHomeUIC::class.java)");
      if ((((FinderHomeUIC)paramq).fnX() == this.hJx) && (!this.mainHandler.hasMessages(1))) {
        this.mainHandler.sendEmptyMessage(1);
      }
    }
    this.isResume = true;
    AppMethodBeat.o(335695);
  }
  
  public final void onStart(q paramq)
  {
    AppMethodBeat.i(335687);
    s.u(paramq, "var1");
    AppMethodBeat.o(335687);
  }
  
  public final void onStop(q paramq)
  {
    AppMethodBeat.i(335706);
    s.u(paramq, "var1");
    AppMethodBeat.o(335706);
  }
  
  public final void setup()
  {
    AppMethodBeat.i(335624);
    Object localObject = this.EzS;
    if (localObject != null) {
      a((MMFragmentActivity)localObject, (com.tencent.mm.plugin.finder.life.b)this);
    }
    localObject = k.aeZF;
    localObject = ((as)k.d((AppCompatActivity)this.EzS).q(as.class)).Vm(this.hJx);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).a((com.tencent.mm.plugin.finder.event.base.d)this);
    }
    if (!this.mainHandler.hasMessages(1)) {
      this.mainHandler.sendEmptyMessageDelayed(1, 500L);
    }
    AppMethodBeat.o(335624);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager$Companion;", "", "()V", "DELAY_CHECK_TIME", "", "DELAY__SHOW_COMMENT_CHECK_TIME", "TAG", "", "WHAT_CHECK_PLAY", "", "WHAT_CHECK_SHOW_COMMENT_INPUT", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<t, Boolean>
  {
    b(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "musicViewInManager", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<View, Boolean>
  {
    c(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager
 * JD-Core Version:    0.7.0.1
 */