package com.tencent.mm.plugin.finder.video.autoplay;

import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView.b;
import com.tencent.mm.plugin.finder.live.n;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.utils.aj.a;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.o;
import com.tencent.mm.plugin.finder.video.s;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.au;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter$OnFeedChangeCallback;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "musicManager", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "liveListPlayManager", "Lcom/tencent/mm/plugin/finder/live/IFinderLiveListAutoPlayManager;", "tabType", "", "(Lcom/tencent/mm/ui/MMFragmentActivity;Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;Lcom/tencent/mm/plugin/finder/live/IFinderLiveListAutoPlayManager;I)V", "FEED_COMMENT_EDU_VALUE", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "feedSelectorAdapter", "Lcom/tencent/mm/plugin/finder/video/autoplay/FinderFeedSelectorAdapter;", "hasTryMoreAgainSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isLocked", "", "isResume", "lockKV", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaRect", "Landroid/graphics/Rect;", "getMusicManager", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "preCenterFeedId", "", "readyPlayForwardTrace", "Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getTabType", "()I", "check2Play", "", "forceCheckSame", "check2PlayInternalV1", "check2PlayInternalV2", "check2SendShowCommentMsg", "centerFeedId", "check2ShowCommentInput", "feedId", "isAsync", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isUserVisibleFocused", "isValidBannerHeight", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "lock", "scene", "isLock", "unLockAfterCheck", "onCareFeedVisibility", "feeds", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibilityFeed;", "onCreate", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onEventHappen", "ev", "onFeedSelected", "source", "", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "feed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "position", "onFeedUnSelected", "onNextFeedPrepare", "onPageScrollStateChanged", "state", "onPause", "onRelease", "onResume", "onStart", "onStop", "pauseAllImagePlay", "without", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pauseAllMedia", "playFocusHolder", "focusHolder", "focusMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "playImage", "playMusicHolder", "playSelectedFeed", "selectedFeed", "postCheck", "preloadNextFeed", "nextFeed", "prepareHolder", "setup", "Companion", "plugin-finder_release"})
public final class FinderVideoAutoPlayManager
  extends com.tencent.mm.plugin.finder.event.base.d
  implements com.tencent.mm.plugin.finder.life.b, a.b
{
  public static final a APH;
  private final Rect AFR;
  private final au ANw;
  private final com.tencent.mm.plugin.finder.music.b ANx;
  private final n ANy;
  private com.tencent.mm.plugin.findersdk.f.c APA;
  private long APB;
  private final int APC;
  private final HashSet<String> APD;
  private boolean APF;
  private final HashSet<String> APG;
  private final a APz;
  private final int fEH;
  private boolean isResume;
  final RecyclerView jLl;
  private final MMHandler mainHandler;
  private final MMFragmentActivity zwS;
  
  static
  {
    AppMethodBeat.i(291484);
    APH = new a((byte)0);
    AppMethodBeat.o(291484);
  }
  
  public FinderVideoAutoPlayManager(MMFragmentActivity paramMMFragmentActivity, RecyclerView paramRecyclerView, au paramau, com.tencent.mm.plugin.finder.music.b paramb, n paramn, int paramInt)
  {
    AppMethodBeat.i(291483);
    this.zwS = paramMMFragmentActivity;
    this.jLl = paramRecyclerView;
    this.ANw = paramau;
    this.ANx = paramb;
    this.ANy = paramn;
    this.fEH = paramInt;
    this.APz = new a();
    this.APA = new com.tencent.mm.plugin.findersdk.f.c("ReadyPlayForward");
    this.mainHandler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new b(this));
    this.APB = -1L;
    paramMMFragmentActivity = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.APC = ((Number)com.tencent.mm.plugin.finder.storage.d.dVH().aSr()).intValue();
    paramMMFragmentActivity = this.APz;
    paramRecyclerView = this.jLl;
    p.k(paramRecyclerView, "recyclerView");
    Log.i("FinderFeedSelectorAdapter", "bindRecyclerView recyclerView:".concat(String.valueOf(paramRecyclerView)));
    paramMMFragmentActivity.jLl = paramRecyclerView;
    if ((paramRecyclerView instanceof FinderRecyclerView))
    {
      paramau = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dXC().aSr()).intValue() == 1) {
        ((FinderRecyclerView)paramRecyclerView).setPageChangeListener((FinderRecyclerView.b)new a.c(paramMMFragmentActivity));
      }
    }
    paramRecyclerView.a((RecyclerView.i)new a.d(paramMMFragmentActivity, paramRecyclerView));
    paramMMFragmentActivity = this.APz;
    paramRecyclerView = (a.b)this;
    p.k(paramRecyclerView, "onFeedChangeCallback");
    paramMMFragmentActivity.APr = paramRecyclerView;
    this.APD = new HashSet();
    this.AFR = new Rect();
    this.APG = new HashSet();
    AppMethodBeat.o(291483);
  }
  
  private void Z(RecyclerView.v paramv)
  {
    AppMethodBeat.i(291474);
    Log.i("Finder.VideoAutoPlayManager", "pauseAllMedia without:".concat(String.valueOf(paramv)));
    if (paramv != null)
    {
      localObject = paramv.amk;
      if (localObject == null) {}
    }
    for (Object localObject = (FinderVideoLayout)((View)localObject).findViewById(b.f.finder_banner_video_layout);; localObject = null)
    {
      this.ANw.Q((kotlin.g.a.b)new d((FinderVideoLayout)localObject));
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject = com.tencent.mm.plugin.finder.utils.aj.Y(paramv);
      this.ANx.M((kotlin.g.a.b)new e((FinderImgFeedMusicTag)localObject));
      aa(paramv);
      this.ANy.MY(this.fEH);
      AppMethodBeat.o(291474);
      return;
    }
  }
  
  private final void aa(RecyclerView.v paramv)
  {
    AppMethodBeat.i(291475);
    int j = this.jLl.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = this.jLl.getChildAt(i);
      localObject1 = this.jLl.bf((View)localObject1);
      if ((localObject1 != null) && ((localObject1 instanceof i)) && ((p.h(paramv, localObject1) ^ true)))
      {
        Object localObject2 = ((i)localObject1).ihX();
        if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getMediaType() == 2)) {
          ((FinderMediaBanner)((i)localObject1).RD(b.f.media_banner)).eiY();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(291475);
  }
  
  private final void rh(boolean paramBoolean)
  {
    AppMethodBeat.i(291472);
    this.mainHandler.removeMessages(1);
    long l = cm.bfE();
    a.a(this.APz, null, paramBoolean, "checkSelected", 1);
    Log.d("Finder.VideoAutoPlayManager", "check2Play cost:".concat(String.valueOf(cm.bfE() - l)));
    AppMethodBeat.o(291472);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(291470);
    p.k(paramb, "ev");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      Log.i("Finder.VideoAutoPlayManager", "onEventHappen event state:" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrk + " event feed:" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrl);
      this.jLl.post((Runnable)new c(this, paramb));
    }
    AppMethodBeat.o(291470);
  }
  
  public final void a(List<? extends com.tencent.mm.view.recyclerview.a> paramList, com.tencent.mm.plugin.finder.utils.b paramb, i parami)
  {
    AppMethodBeat.i(291461);
    p.k(paramList, "source");
    p.k(paramb, "feed");
    p.k(parami, "holder");
    AppMethodBeat.o(291461);
  }
  
  public final void a(List<? extends com.tencent.mm.view.recyclerview.a> paramList, com.tencent.mm.plugin.finder.utils.b paramb, i parami, int paramInt)
  {
    AppMethodBeat.i(291462);
    p.k(paramList, "source");
    p.k(paramb, "feed");
    p.k(parami, "holder");
    Log.i("Finder.VideoAutoPlayManager", "onFeedSelected position:".concat(String.valueOf(paramInt)));
    this.APA.fo("onFeedSelected");
    if (!this.isResume)
    {
      Log.w("Finder.VideoAutoPlayManager", "[playSelectedFeed] activity is not resume, tabType=" + this.fEH);
      AppMethodBeat.o(291462);
      return;
    }
    if (this.APF)
    {
      Log.w("Finder.VideoAutoPlayManager", "[playSelectedFeed] isLocked=" + this.APF + " lockKV=" + this.APD + " tabType=" + this.fEH);
      AppMethodBeat.o(291462);
      return;
    }
    if ((this.zwS instanceof FinderHomeUI))
    {
      paramList = g.Xox;
      paramList = g.b((AppCompatActivity)this.zwS).i(FinderHomeUIC.class);
      p.j(paramList, "UICProvider.of(activity)…inderHomeUIC::class.java)");
      if (((FinderHomeUIC)paramList).ekL() == this.fEH) {}
    }
    for (paramInt = 0; paramInt == 0; paramInt = 1)
    {
      Log.w("Finder.VideoAutoPlayManager", "[playSelectedFeed] isUserVisibleFocused=false tabType=" + this.fEH);
      AppMethodBeat.o(291462);
      return;
    }
    Log.i("Finder.VideoAutoPlayManager", "playSelectedFeed feed:".concat(String.valueOf(paramb)));
    long l = paramb.feedId;
    if ((this.APC == 1) && (this.APB != l))
    {
      this.APB = l;
      Log.i("Finder.VideoAutoPlayManager", "send show comment msg,feedId:".concat(String.valueOf(l)));
      this.mainHandler.removeMessages(2);
      paramList = this.mainHandler.obtainMessage(2);
      paramList.obj = Long.valueOf(l);
      this.mainHandler.sendMessageDelayed(paramList, 5000L);
    }
    Object localObject1 = new com.tencent.mm.plugin.findersdk.f.a("FVPT-" + paramb.mediaId);
    ((com.tencent.mm.plugin.findersdk.f.a)localObject1).fo("onSelected");
    if (paramb.xhX == null)
    {
      Log.w("Finder.VideoAutoPlayManager", "playSelectedFeed return for holder:null");
      AppMethodBeat.o(291462);
      return;
    }
    paramList = paramb.xhX;
    if (paramList == null) {
      p.iCn();
    }
    if (paramb.feed == null)
    {
      Log.w("Finder.VideoAutoPlayManager", "playSelectedFeed return for feed:null");
      AppMethodBeat.o(291462);
      return;
    }
    parami = paramb.feed;
    if (parami == null) {
      p.iCn();
    }
    if (paramList.mc() != paramList.md())
    {
      localObject2 = "playSelectedFeed holder=" + paramList + " centerId=" + paramb.feedId + " adapterPosition=" + paramList.md() + " layoutPosition=" + paramList.mc() + " isInLayout=" + this.jLl.isInLayout();
      Log.e("Finder.VideoAutoPlayManager", (String)localObject2);
      com.tencent.mm.plugin.report.service.h.IzE.a(20251, new Object[] { Integer.valueOf(1), localObject2 });
      localObject2 = paramList.hashCode() + '_' + paramList.md() + '_' + paramList.mc() + '_' + paramList.mf();
      if (!this.APG.contains(localObject2))
      {
        this.jLl.post((Runnable)new g(this, (String)localObject2));
        AppMethodBeat.o(291462);
        return;
      }
    }
    Object localObject2 = g.Xox;
    localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this.zwS).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).RW(this.fEH);
    if (localObject2 != null) {
      ((f)localObject2).e(this.jLl, 6);
    }
    Log.w("Finder.VideoAutoPlayManager", "playSelectedFeed mediaType:" + parami.getMediaType());
    Object localObject3;
    if ((parami.getMediaType() == 4) || (parami.getMediaType() == 9))
    {
      localObject3 = (csg)j.lp((List)parami.getMediaList());
      if (localObject3 != null)
      {
        Z((RecyclerView.v)paramList);
        localObject2 = (RecyclerView.v)paramList;
        l = parami.getId();
        if (localObject2 != null)
        {
          FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)((RecyclerView.v)localObject2).amk.findViewById(b.f.finder_banner_video_layout);
          if (localFinderVideoLayout == null) {
            break label1109;
          }
          localObject3 = new StringBuilder("playFocusHolder videoContainer ");
          parami = localFinderVideoLayout.ANY;
          if (parami != null)
          {
            paramList = parami.zBB;
            parami.feed.getExpectId();
            parami = parami.mediaList;
            parami = "[FinderVideoLayout#loginfo] layout=[" + localFinderVideoLayout.getWidth() + ':' + localFinderVideoLayout.getHeight() + "] videoView=[" + localFinderVideoLayout.getWidth() + ':' + localFinderVideoLayout.getHeight() + "] video=[" + paramList.ztO.width + ':' + paramList.ztO.height + "] " + localFinderVideoLayout.eht() + ' ' + "media=" + paramList + ' ' + "mediaList=" + parami.size();
            paramList = parami;
            if (parami != null) {}
          }
          else
          {
            paramList = "[FinderVideoLayout#loginfo] playInfo is null";
          }
          Log.i("Finder.VideoAutoPlayManager", paramList);
          ((com.tencent.mm.plugin.findersdk.f.a)localObject1).aGV("playFocusHolder");
          localFinderVideoLayout.a(((RecyclerView.v)localObject2).md(), (com.tencent.mm.plugin.findersdk.f.a)localObject1);
          if (!this.isResume) {
            this.ANw.Q((kotlin.g.a.b)FinderVideoAutoPlayManager.f.APM);
          }
        }
        Log.i("Finder.VideoAutoPlayManager", "playFocusHolder mediaList first feed.");
      }
    }
    for (;;)
    {
      paramList = k.yBj;
      k.a(paramb);
      AppMethodBeat.o(291462);
      return;
      label1109:
      Log.e("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer is null! mediaId=" + ((csg)localObject3).mediaId + "] feedId=" + l);
      break;
      Log.w("Finder.VideoAutoPlayManager", "playFocusHolder mediaList first feed null.");
      continue;
      if (parami.getMediaType() == 2)
      {
        Z((RecyclerView.v)paramList);
        if ((parami.getHasBgmInfo()) && (paramList != null))
        {
          parami = com.tencent.mm.plugin.finder.utils.aj.AGc;
          parami = com.tencent.mm.plugin.finder.utils.aj.Y((RecyclerView.v)paramList);
          localObject1 = (FinderFullSeekBarLayout)paramList.RD(b.f.full_seek_bar_layout);
          if (localObject1 == null) {
            break label1318;
          }
          bool = ((FinderFullSeekBarLayout)localObject1).AKv;
          label1225:
          if (!bool)
          {
            if (parami == null) {
              break label1324;
            }
            parami.dLf();
          }
        }
        label1238:
        if (paramList != null)
        {
          parami = (FinderFullSeekBarLayout)paramList.RD(b.f.full_seek_bar_layout);
          if (parami == null) {
            break label1336;
          }
        }
        label1318:
        label1324:
        label1336:
        for (boolean bool = parami.AKv;; bool = false)
        {
          Log.i("Finder.VideoAutoPlayManager", "[playImage] isInSeekMode: ".concat(String.valueOf(bool)));
          if (!bool) {
            ((FinderMediaBanner)paramList.RD(b.f.media_banner)).setAutoPlay(true);
          }
          Log.i("Finder.VideoAutoPlayManager", "playSelectedFeed hit playImage feed:".concat(String.valueOf(paramb)));
          break;
          bool = false;
          break label1225;
          Log.e("Finder.VideoAutoPlayManager", "playMusicHolder musicContainer is null!");
          break label1238;
        }
      }
      Log.i("Finder.VideoAutoPlayManager", "playSelectedFeed hit pauseAllMedia feed:".concat(String.valueOf(paramb)));
      Z(null);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(291476);
    p.k(paramc, "dispatcher");
    p.k(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 3) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 11))
      {
        AppMethodBeat.o(291476);
        return true;
      }
      AppMethodBeat.o(291476);
      return false;
    }
    AppMethodBeat.o(291476);
    return false;
  }
  
  public final void aGl(String paramString)
  {
    AppMethodBeat.i(291469);
    p.k(paramString, "source");
    Log.i("Finder.VideoAutoPlayManager", "[postCheck] source=".concat(String.valueOf(paramString)));
    this.mainHandler.removeMessages(1);
    this.mainHandler.sendEmptyMessage(1);
    AppMethodBeat.o(291469);
  }
  
  public final void b(aj.a parama)
  {
    AppMethodBeat.i(291465);
    p.k(parama, "feeds");
    Log.i("Finder.VideoAutoPlayManager", "onFeedVisibility feeds:".concat(String.valueOf(parama)));
    Iterator localIterator = ((Iterable)parama.AGd).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (aj.a)localIterator.next();
      parama = ((aj.a)localObject).xrd;
      if ((parama != null) && (parama.bAQ() == 2003))
      {
        parama = ((aj.a)localObject).xhX;
        if (parama != null) {}
        for (parama = (WxRecyclerView)parama.RD(b.f.live_onlive_list_rv);; parama = null)
        {
          localObject = ((aj.a)localObject).xrd;
          if ((parama == null) || (localObject == null)) {
            break;
          }
          this.ANy.a(this.fEH, parama, (bu)localObject);
          break;
        }
      }
    }
    AppMethodBeat.o(291465);
  }
  
  public final void b(List<? extends com.tencent.mm.view.recyclerview.a> paramList, com.tencent.mm.plugin.finder.utils.b paramb, i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(291463);
    p.k(paramList, "source");
    p.k(paramb, "feed");
    p.k(parami, "holder");
    paramList = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXi().aSr()).intValue() == 0)
    {
      Log.w("Finder.VideoAutoPlayManager", "preloadNextFeed return for disable");
      AppMethodBeat.o(291463);
      return;
    }
    parami = new StringBuilder("preloadNextFeed nextFeed:");
    if (paramb != null)
    {
      paramList = Long.valueOf(paramb.feedId);
      Log.i("Finder.VideoAutoPlayManager", paramList.longValue());
      paramList = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (paramb == null) {
        break label313;
      }
      paramList = paramb.xhX;
      label118:
      if (paramb == null) {
        break label318;
      }
    }
    Object localObject1;
    long l;
    label313:
    label318:
    for (parami = paramb.feed;; parami = null)
    {
      localObject1 = localObject2;
      if (paramb != null)
      {
        paramb = paramb.feed;
        localObject1 = localObject2;
        if (paramb != null)
        {
          paramb = paramb.getMediaList();
          localObject1 = localObject2;
          if (paramb != null) {
            localObject1 = (csg)j.lp((List)paramb);
          }
        }
      }
      if ((paramList == null) || (parami == null) || (localObject1 == null) || (parami.getMediaType() != 4)) {
        break label368;
      }
      paramb = (RecyclerView.v)paramList;
      l = parami.getId();
      paramList = (FinderVideoLayout)paramb.amk.findViewById(b.f.finder_banner_video_layout);
      if (paramList == null) {
        break label330;
      }
      Log.d("Finder.VideoAutoPlayManager", "prepareToPlay ".concat(String.valueOf(l)));
      paramb.md();
      paramb = paramList.ANY;
      if (paramb == null) {
        break label323;
      }
      parami = paramList.xkW;
      if (parami == null) {
        p.bGy("videoCore");
      }
      parami.ehl().a((ViewGroup)paramList, (ac)paramb.zBB, (kotlin.g.a.b)new FinderVideoLayout.o(paramb, paramList));
      AppMethodBeat.o(291463);
      return;
      paramList = null;
      break;
      paramList = null;
      break label118;
    }
    label323:
    AppMethodBeat.o(291463);
    return;
    label330:
    Log.e("Finder.VideoAutoPlayManager", "prepareHolder videoContainer is null! mediaId=" + ((csg)localObject1).mediaId + "] feedId=" + l);
    label368:
    AppMethodBeat.o(291463);
  }
  
  public final boolean dpw()
  {
    return false;
  }
  
  public final void g(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(291467);
    p.k(paramString, "scene");
    Log.i("Finder.VideoAutoPlayManager", "[lock] scene=" + paramString + " isLock=" + paramBoolean1 + " lockSize=" + this.APD.size() + " unLockAfterCheck=" + paramBoolean2);
    if (paramBoolean1)
    {
      this.APD.add(paramString);
      this.APF = true;
    }
    for (;;)
    {
      this.mainHandler.removeMessages(1);
      if ((!this.APF) && (paramBoolean2)) {
        this.mainHandler.sendEmptyMessage(1);
      }
      AppMethodBeat.o(291467);
      return;
      this.APD.remove(paramString);
      if (this.APD.size() <= 0) {
        this.APF = false;
      }
    }
  }
  
  public final void i(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(291464);
    p.k(paramRecyclerView, "recyclerView");
    Log.i("Finder.VideoAutoPlayManager", "onPageScrollStateChanged state:".concat(String.valueOf(paramInt)));
    if (paramInt == 0) {
      this.APA.fp("onViewIdle");
    }
    AppMethodBeat.o(291464);
  }
  
  public final void onCreate(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(291477);
    p.k(paraml, "var1");
    AppMethodBeat.o(291477);
  }
  
  public final void onDestroy(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(291482);
    p.k(paraml, "var1");
    AppMethodBeat.o(291482);
  }
  
  public final void onPause(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(291480);
    p.k(paraml, "var1");
    this.mainHandler.removeMessages(1);
    this.mainHandler.removeMessages(2);
    this.isResume = false;
    AppMethodBeat.o(291480);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(291471);
    super.onRelease();
    this.mainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(291471);
  }
  
  public final void onResume(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(291479);
    p.k(paraml, "var1");
    if ((this.zwS instanceof FinderHomeUI))
    {
      paraml = g.Xox;
      paraml = g.b((AppCompatActivity)this.zwS).i(FinderHomeUIC.class);
      p.j(paraml, "UICProvider.of(activity)…inderHomeUIC::class.java)");
      if ((((FinderHomeUIC)paraml).ekL() == this.fEH) && (!this.mainHandler.hasMessages(1))) {
        this.mainHandler.sendEmptyMessage(1);
      }
    }
    this.isResume = true;
    AppMethodBeat.o(291479);
  }
  
  public final void onStart(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(291478);
    p.k(paraml, "var1");
    AppMethodBeat.o(291478);
  }
  
  public final void onStop(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(291481);
    p.k(paraml, "var1");
    AppMethodBeat.o(291481);
  }
  
  public final void setup()
  {
    AppMethodBeat.i(291466);
    Object localObject = this.zwS;
    if (localObject != null) {
      a((MMFragmentActivity)localObject, (com.tencent.mm.plugin.finder.life.b)this);
    }
    localObject = g.Xox;
    localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this.zwS).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).RU(this.fEH);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).a((com.tencent.mm.plugin.finder.event.base.d)this);
    }
    if (!this.mainHandler.hasMessages(1)) {
      this.mainHandler.sendEmptyMessageDelayed(1, 500L);
    }
    AppMethodBeat.o(291466);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/autoplay/FinderVideoAutoPlayManager$Companion;", "", "()V", "DELAY_CHECK_TIME", "", "DELAY__SHOW_COMMENT_CHECK_TIME", "TAG", "", "WHAT_CHECK_PLAY", "", "WHAT_CHECK_SHOW_COMMENT_INPUT", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    b(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(287155);
      if (paramMessage.what == 1)
      {
        Log.i("Finder.VideoAutoPlayManager", "data change to check play...");
        FinderVideoAutoPlayManager.a(this.APJ, false);
      }
      for (;;)
      {
        AppMethodBeat.o(287155);
        return true;
        if (paramMessage.what == 2)
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(287155);
            throw paramMessage;
          }
          FinderVideoAutoPlayManager.Nr(((Long)paramMessage).longValue());
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, com.tencent.mm.plugin.finder.event.base.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(266185);
      if (((com.tencent.mm.plugin.finder.event.base.h)paramb).xrk != 5) {}
      for (boolean bool = true;; bool = false)
      {
        FinderVideoAutoPlayManager.a(this.APJ, bool);
        AppMethodBeat.o(266185);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<s, Boolean>
  {
    d(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "musicViewInManager", "Landroid/view/View;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<View, Boolean>
  {
    e(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderVideoAutoPlayManager paramFinderVideoAutoPlayManager, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(230691);
      FinderVideoAutoPlayManager.b(this.APJ).add(this.$key);
      FinderVideoAutoPlayManager.a(this.APJ);
      AppMethodBeat.o(230691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager
 * JD-Core Version:    0.7.0.1
 */