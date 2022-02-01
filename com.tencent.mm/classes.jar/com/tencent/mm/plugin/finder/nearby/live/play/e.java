package com.tencent.mm.plugin.finder.nearby.live.play;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.live.model.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "", "context", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isEnableVoice", "", "tabId", "", "isRedDotShowAnimationIgnoreTagIdCheck", "isRedDotShowAnimationLeftOnly", "isIgnoreRedDotShowAnimation", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList;ZIZZZ)V", "autoPlayRunnable", "Ljava/lang/Runnable;", "autoPlaySelector", "Lcom/tencent/mm/plugin/finder/nearby/live/play/selector/ILiveAutoPlaySelector;", "getContext", "()Landroid/content/Context;", "curLivePreviewDataSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewData;", "Lkotlin/collections/HashSet;", "curLivePreviewMuteStateDataSet", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewMuteStateData;", "enableNearbyLiveAutoPlay", "getEnableNearbyLiveAutoPlay", "()Z", "enableRedDotFeedAnimation", "enterTabTipExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getFeedList", "()Ljava/util/ArrayList;", "finderSquareLiveViewLayoutEvent", "com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$finderSquareLiveViewLayoutEvent$1", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$finderSquareLiveViewLayoutEvent$1;", "headsetReceiver", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver;", "value", "isEnableAutoPlay", "setEnableAutoPlay", "(Z)V", "isHeadStateOn", "isInvokeAutoPlayByTouchEvent", "isSwitchLiveAutoPlay", "liveCardPreviewAnimationHelper", "Lcom/tencent/mm/plugin/finder/nearby/guide/FinderLiveCardPreViewAnimationHelper;", "onTouchEventAdapter", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveItemOnTouchEventAdapter;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getTabId", "()I", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "voipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "attach", "", "checkAutoPlay", "pos", "view", "Landroid/view/View;", "checkAutoPlayDelay", "delayMs", "", "checkAutoPlayForTest1OrTest5", "checkAutoPlayInternal", "checkAutoStopInternal", "checkIfShowAnimation", "livePlayerView", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "checkIfStopCurrentView", "clearCurrentViewMuteState", "detach", "disableLiveMuteByPos", "dismissAudioTips", "findSameLineOtherPos", "getFeedByPos", "getIndexFromFeedId", "feedId", "getOrCreateLiveView", "livePlayerContainer", "Landroid/widget/FrameLayout;", "getRecordCurrentViewMuteState", "containerHashCode", "getSwitchPlayPosition", "", "startIndex", "layoutManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "getTouchEventAdapter", "isCurPlayPos", "isCurPlayerView", "nearbyLivePreviewView", "isEnableVoiceOpen", "isFinishLive", "isInvokeAutoPlayPosVisible", "firstVisiblePos", "lastVisiblePos", "isLeftPos", "isPlayMute", "isRecordMute", "rootView", "isSingleOneLine", "muteCurrentView", "parseLiveFeedInfo", "", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "recordCurrentViewMuteState", "recordViewMuteState", "isMute", "showAudioTips", "stopCurrentView", "stopLiveViewInternal", "previewData", "Companion", "LivePreviewData", "LivePreviewMuteStateData", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a EKw;
  private final IListener<acn> BtB;
  private Runnable EHY;
  private boolean EJS;
  HashSet<b> EJT;
  private com.tencent.mm.plugin.finder.nearby.live.play.selector.a EKA;
  private final HeadsetReceiver EKB;
  private final com.tencent.mm.plugin.finder.nearby.guide.a EKC;
  boolean EKD;
  public final f EKE;
  public HashSet<e.c> EKF;
  private boolean EKG;
  private btx EKH;
  private final NearbyLiveAutoPlayManager.finderSquareLiveViewLayoutEvent.1 EKI;
  public boolean EKJ;
  private final boolean EKx;
  private final boolean EKy;
  public boolean EKz;
  private final boolean akhu;
  private final boolean akhv;
  private final boolean akhw;
  private final Context context;
  final ArrayList<cc> feedList;
  final int idY;
  private MMHandler mRi;
  public final RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(341166);
    EKw = new a((byte)0);
    AppMethodBeat.o(341166);
  }
  
  public e(Context paramContext, RecyclerView paramRecyclerView, ArrayList<cc> paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(370449);
    this.context = paramContext;
    this.mkw = paramRecyclerView;
    this.feedList = paramArrayList;
    this.EKx = paramBoolean1;
    this.idY = paramInt;
    this.akhu = paramBoolean2;
    this.akhv = paramBoolean3;
    this.akhw = paramBoolean4;
    paramContext = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jRZ().bmg()).intValue() == 1)
    {
      paramBoolean1 = true;
      this.EJS = paramBoolean1;
      paramContext = com.tencent.d.a.a.a.a.a.ahiX;
      paramBoolean1 = bool;
      if (((Number)com.tencent.d.a.a.a.a.a.jSa().bmg()).intValue() == 1) {
        paramBoolean1 = true;
      }
      this.EKy = paramBoolean1;
      this.EKA = ((com.tencent.mm.plugin.finder.nearby.live.play.selector.a)new com.tencent.mm.plugin.finder.nearby.live.play.selector.b(this.feedList));
      this.EKB = new HeadsetReceiver();
      this.EKC = new com.tencent.mm.plugin.finder.nearby.guide.a(this.context, this.mkw);
      this.EKE = new f(this.mkw, this.EKx, (kotlin.g.a.b)new h(this), (kotlin.g.a.b)new i(this));
      this.EJT = new HashSet();
      this.EKF = new HashSet();
      this.mRi = new MMHandler(Looper.getMainLooper());
      this.mkw.setOnTouchListener(new e..ExternalSyntheticLambda0(this));
      this.mkw.a((RecyclerView.l)new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(341012);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          s.u(paramAnonymousRecyclerView, "recyclerView");
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          Log.i("NearbyLiveAutoPlayManager", s.X("onScrollStateChanged newState:", Integer.valueOf(paramAnonymousInt)));
          localObject = e.e(this.EKK);
          s.u(paramAnonymousRecyclerView, "recyclerView");
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            if (paramAnonymousInt == 0) {
              this.EKK.eES();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(341012);
            return;
            if ((!((f)localObject).EKW) && (((f)localObject).EKU)) {
              ((f)localObject).EKR.invoke(Integer.valueOf(((f)localObject).EKS));
            }
            if ((!((f)localObject).EKX) || (((f)localObject).EKY == null) || (!((f)localObject).EKx)) {}
            for (;;)
            {
              ((f)localObject).EKW = false;
              break;
              d.B((kotlin.g.a.a)new f.d((f)localObject));
            }
            ((f)localObject).EKW = true;
            continue;
            ((f)localObject).EKX = true;
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(341022);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          s.u(paramAnonymousRecyclerView, "recyclerView");
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          e.f(this.EKK);
          localObject = e.e(this.EKK);
          s.u(paramAnonymousRecyclerView, "recyclerView");
          if (((f)localObject).EKU) {
            Log.i("NearbyLiveItemOnTouchEventAdapter", "handleOnScrolled return for isInvokeAutoPlayCallback");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(341022);
            return;
            if (((f)localObject).EKS < 0)
            {
              Log.i("NearbyLiveItemOnTouchEventAdapter", s.X("handleOnScrolled return for onTouchPos:", Integer.valueOf(((f)localObject).EKS)));
            }
            else
            {
              if (((f)localObject).EKT == 0) {
                ((f)localObject).EKT = paramAnonymousInt2;
              }
              if (Math.abs(paramAnonymousInt2 - ((f)localObject).EKT) > 1)
              {
                Log.i("NearbyLiveItemOnTouchEventAdapter", "handleOnScrolled hit auto play pos:" + ((f)localObject).EKS + " (" + ((f)localObject).EKT + ", " + paramAnonymousInt2 + ')');
                ((f)localObject).EKQ.invoke(Integer.valueOf(((f)localObject).EKS));
                ((f)localObject).EKU = true;
              }
              else
              {
                Log.i("NearbyLiveItemOnTouchEventAdapter", "handleOnScrolled auto play pos:" + ((f)localObject).EKS + " (" + ((f)localObject).EKT + ", " + paramAnonymousInt2 + " move:" + Math.abs(paramAnonymousInt2 - ((f)localObject).EKT) + " threshold:1");
              }
            }
          }
        }
      });
      this.EKH = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avs("NearbyLiveTab");
      paramContext = this.EKH;
      if (paramContext != null) {
        break label424;
      }
    }
    label424:
    for (paramContext = null;; paramContext = "enterLiveAction:" + paramContext.object_id + " targetTabId:" + paramContext.aabK + " tabId:" + paramContext.aabK)
    {
      paramRecyclerView = paramContext;
      if (paramContext == null) {
        paramRecyclerView = "NULL";
      }
      Log.i("NearbyLiveAutoPlayManager", "init isEnableVoice:" + this.EKx + " tabTips:" + paramRecyclerView);
      this.BtB = ((IListener)new NearbyLiveAutoPlayManager.voipCallEvent.1(this, com.tencent.mm.app.f.hfK));
      this.EKI = new NearbyLiveAutoPlayManager.finderSquareLiveViewLayoutEvent.1(this, com.tencent.mm.app.f.hfK);
      this.EKJ = true;
      AppMethodBeat.o(370449);
      return;
      paramBoolean1 = false;
      break;
    }
  }
  
  private final void QD(int paramInt)
  {
    AppMethodBeat.i(340990);
    Object localObject1 = this.mkw.getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(340990);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = (FinderStaggeredGridLayoutManager)localObject1;
    localObject1 = ((FinderStaggeredGridLayoutManager)localObject2).findViewByPosition(paramInt);
    if (localObject1 != null)
    {
      QJ(paramInt);
      com.tencent.mm.plugin.finder.nearby.live.base.a locala = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
      if (com.tencent.mm.plugin.finder.nearby.live.base.a.l(((StaggeredGridLayoutManager)localObject2).mOrientation, (View)localObject1))
      {
        localObject2 = (NearbyLivePreviewView)((View)localObject1).findViewWithTag("nearby-live-preview-view-tag");
        if (localObject2 == null) {
          break label149;
        }
      }
    }
    label149:
    for (boolean bool = a((NearbyLivePreviewView)localObject2);; bool = false)
    {
      if (bool)
      {
        QI(paramInt);
        Log.i("NearbyLiveAutoPlayManager", "checkAutoStopInternal stop pos:" + paramInt + " view:" + localObject1);
      }
      AppMethodBeat.o(340990);
      return;
    }
  }
  
  private final cc QF(int paramInt)
  {
    AppMethodBeat.i(341049);
    if (this.feedList == null)
    {
      Log.w("NearbyLiveAutoPlayManager", s.X("getFeedByPos return for feedList:", this.feedList));
      AppMethodBeat.o(341049);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.feedList.size()))
    {
      Log.w("NearbyLiveAutoPlayManager", s.X("getFeedByPos return for invalid pos:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(341049);
      return null;
    }
    cc localcc = (cc)this.feedList.get(paramInt);
    AppMethodBeat.o(341049);
    return localcc;
  }
  
  private final void QI(int paramInt)
  {
    AppMethodBeat.i(340996);
    if (this.EHY != null)
    {
      this.mRi.removeCallbacks(this.EHY);
      this.EHY = null;
    }
    Object localObject2 = (Iterable)this.EJT;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label110:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((b)localObject3).pos == paramInt) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label110;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      a((b)((Iterator)localObject1).next());
    }
    this.EJT.removeIf(new e..ExternalSyntheticLambda2(paramInt));
    AppMethodBeat.o(340996);
  }
  
  private static String a(int paramInt, x paramx)
  {
    AppMethodBeat.i(341015);
    paramx = paramInt + '-' + o.aBv(paramx.feedObject.getNickName());
    AppMethodBeat.o(341015);
    return paramx;
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(341007);
    Log.i("NearbyLiveAutoPlayManager", s.X("stopLiveViewInternal ", a(paramb.pos, paramb.EJX)));
    paramb.EKL.stop();
    paramb.EKL.release();
    Object localObject = paramb.EKL.getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        View localView = ((ViewGroup)localObject).findViewWithTag("nearby-live-fluent-preview-view-tag");
        if (localView != null) {
          ((ViewGroup)localObject).removeView(localView);
        }
        ((ViewGroup)localObject).removeView((View)paramb.EKL);
      }
      localObject = k.aeZF;
      ((g)k.cn(PluginFinder.class).q(g.class)).b(paramb.EKL);
      AppMethodBeat.o(341007);
      return;
    }
  }
  
  private static final boolean a(int paramInt, b paramb)
  {
    AppMethodBeat.i(341066);
    s.u(paramb, "it");
    if (paramb.pos == paramInt)
    {
      AppMethodBeat.o(341066);
      return true;
    }
    AppMethodBeat.o(341066);
    return false;
  }
  
  private final boolean a(NearbyLivePreviewView paramNearbyLivePreviewView)
  {
    AppMethodBeat.i(341026);
    Iterator localIterator = ((Iterable)this.EJT).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((b)localObject).EKL, paramNearbyLivePreviewView));
    for (paramNearbyLivePreviewView = localObject; paramNearbyLivePreviewView != null; paramNearbyLivePreviewView = null)
    {
      AppMethodBeat.o(341026);
      return true;
    }
    AppMethodBeat.o(341026);
    return false;
  }
  
  private static final boolean a(e parame, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(341058);
    s.u(parame, "this$0");
    parame = parame.EKE;
    s.s(paramMotionEvent, "p1");
    s.u(paramMotionEvent, "event");
    if ((paramMotionEvent.getAction() == 0) && (parame.EKW))
    {
      parame.EKX = true;
      parame.EKY = paramMotionEvent;
    }
    AppMethodBeat.o(341058);
    return false;
  }
  
  private static final void b(e parame)
  {
    AppMethodBeat.i(341060);
    s.u(parame, "this$0");
    parame.eFd();
    AppMethodBeat.o(341060);
  }
  
  private final void eEU()
  {
    AppMethodBeat.i(340975);
    if (this.EHY != null)
    {
      this.mRi.removeCallbacks(this.EHY);
      this.EHY = null;
    }
    this.EHY = new e..ExternalSyntheticLambda1(this);
    this.mRi.postDelayed(this.EHY, 500L);
    AppMethodBeat.o(340975);
  }
  
  private final boolean eFb()
  {
    AppMethodBeat.i(340955);
    if (v.CGh.ekY())
    {
      eET();
      AppMethodBeat.o(340955);
      return false;
    }
    boolean bool = this.EJS;
    AppMethodBeat.o(340955);
    return bool;
  }
  
  private final void eFd()
  {
    AppMethodBeat.i(340984);
    Object localObject = this.mkw.getLayoutManager();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(340984);
      throw ((Throwable)localObject);
    }
    FinderStaggeredGridLayoutManager localFinderStaggeredGridLayoutManager = (FinderStaggeredGridLayoutManager)localObject;
    localObject = this.mkw.getAdapter();
    if (localObject == null) {}
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int[] arrayOfInt3;
    for (int i = 0;; i = ((RecyclerView.a)localObject).getItemCount())
    {
      arrayOfInt1 = new int[2];
      arrayOfInt2 = new int[2];
      localFinderStaggeredGridLayoutManager.n(arrayOfInt1);
      localFinderStaggeredGridLayoutManager.o(arrayOfInt2);
      arrayOfInt3 = this.EKA.a((StaggeredGridLayoutManager)localFinderStaggeredGridLayoutManager, arrayOfInt1, arrayOfInt2);
      if ((!this.EKD) || (!hV(arrayOfInt1[0], arrayOfInt2[1]))) {
        break;
      }
      this.EKD = false;
      Log.i("NearbyLiveAutoPlayManager", "checkAutoPlayInternal return for hit test3 & before invoke by touch event");
      AppMethodBeat.o(340984);
      return;
    }
    int k = arrayOfInt3.length;
    int j = 0;
    if (j < k)
    {
      int m = arrayOfInt3[j];
      View localView = localFinderStaggeredGridLayoutManager.findViewByPosition(m);
      if (localView == null) {}
      for (localObject = null;; localObject = ah.aiuX)
      {
        if (localObject == null) {
          Log.w("NearbyLiveAutoPlayManager", "checkAutoPlayInternal invalid pos:" + m + " view:" + localView);
        }
        j += 1;
        break;
        m(m, localView);
      }
    }
    d.a(0L, (kotlin.g.a.a)new f(this));
    Log.i("NearbyLiveAutoPlayManager", "checkAutoPlayInternal visible[" + arrayOfInt1[0] + ", " + arrayOfInt2[1] + "] itemCount:" + i);
    AppMethodBeat.o(340984);
  }
  
  private final void eFe()
  {
    AppMethodBeat.i(341018);
    Object localObject = this.mkw.getLayoutManager();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(341018);
      throw ((Throwable)localObject);
    }
    localObject = (FinderStaggeredGridLayoutManager)localObject;
    localObject = ((Iterable)this.EKA.a((StaggeredGridLayoutManager)localObject, new HashSet((Collection)this.EJT))).iterator();
    while (((Iterator)localObject).hasNext()) {
      QI(((b)((Iterator)localObject).next()).pos);
    }
    AppMethodBeat.o(341018);
  }
  
  private static NearbyLivePreviewView g(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(341039);
    Object localObject = (NearbyLivePreviewView)paramFrameLayout.findViewWithTag("nearby-live-preview-view-tag");
    if (localObject != null)
    {
      Log.i("NearbyLiveAutoPlayManager", s.X("getOrCreateLiveView get view:", localObject));
      AppMethodBeat.o(341039);
      return localObject;
    }
    localObject = k.aeZF;
    localObject = ((g)k.cn(PluginFinder.class).q(g.class)).eFh();
    ((NearbyLivePreviewView)localObject).setTag("nearby-live-preview-view-tag");
    paramFrameLayout.addView((View)localObject);
    Log.i("NearbyLiveAutoPlayManager", s.X("getOrCreateLiveView create view:", localObject));
    AppMethodBeat.o(341039);
    return localObject;
  }
  
  private final boolean hV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(341032);
    if (paramInt1 <= paramInt2) {}
    for (;;)
    {
      if (QH(paramInt1))
      {
        AppMethodBeat.o(341032);
        return true;
      }
      if (paramInt1 == paramInt2)
      {
        AppMethodBeat.o(341032);
        return false;
      }
      paramInt1 += 1;
    }
  }
  
  final boolean QE(int paramInt)
  {
    AppMethodBeat.i(341283);
    int m;
    int j;
    int k;
    int i2;
    int i1;
    label50:
    int n;
    int i;
    if (paramInt > 0)
    {
      m = 0;
      j = 0;
      k = paramInt;
      i2 = m + 1;
      if (((m - j) % 2 == 0) && (!(QF(m + 1) instanceof x)))
      {
        i1 = 1;
        if (((QF(m) instanceof x)) && (!(QF(m) instanceof c)))
        {
          n = j;
          i = k;
          if (i1 == 0) {}
        }
        else
        {
          i = k - 1;
          n = j + 1;
        }
        if (i2 < paramInt) {
          break label129;
        }
      }
    }
    for (;;)
    {
      if (i % 2 == 0)
      {
        AppMethodBeat.o(341283);
        return true;
        i1 = 0;
        break label50;
      }
      AppMethodBeat.o(341283);
      return false;
      label129:
      m = i2;
      j = n;
      k = i;
      break;
      i = paramInt;
    }
  }
  
  public final void QG(int paramInt)
  {
    AppMethodBeat.i(341235);
    if (!QH(paramInt))
    {
      Log.w("NearbyLiveAutoPlayManager", s.X("disableLiveMuteByPos return for pos:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(341235);
      return;
    }
    Log.i("NearbyLiveAutoPlayManager", s.X("disableLiveMuteByPos pos:", Integer.valueOf(paramInt)));
    Iterator localIterator = ((Iterable)this.EJT).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.pos == paramInt) {
        localb.EKL.setMute(false);
      } else {
        localb.EKL.setMute(true);
      }
    }
    AppMethodBeat.o(341235);
  }
  
  public final boolean QH(int paramInt)
  {
    AppMethodBeat.i(341263);
    Iterator localIterator = ((Iterable)this.EJT).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((b)localObject).pos == paramInt)
      {
        i = 1;
        label51:
        if (i == 0) {
          break label70;
        }
      }
    }
    for (;;)
    {
      if (localObject == null) {
        break label77;
      }
      AppMethodBeat.o(341263);
      return true;
      i = 0;
      break label51;
      label70:
      break;
      localObject = null;
    }
    label77:
    AppMethodBeat.o(341263);
    return false;
  }
  
  final void QJ(int paramInt)
  {
    AppMethodBeat.i(341278);
    Object localObject = this.mkw.getLayoutManager();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(341278);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderStaggeredGridLayoutManager)localObject).findViewByPosition(paramInt);
    if (localObject != null) {
      new h((View)localObject, QE(paramInt)).eFn();
    }
    AppMethodBeat.o(341278);
  }
  
  public final void a(com.tencent.mm.plugin.finder.nearby.live.play.selector.a parama)
  {
    AppMethodBeat.i(341199);
    if (parama != null) {
      this.EKA = parama;
    }
    this.BtB.alive();
    this.EKI.alive();
    this.EKB.a(this.context, (HeadsetReceiver.b)new d(this));
    AppMethodBeat.o(341199);
  }
  
  final boolean aNC(int paramInt)
  {
    AppMethodBeat.i(370461);
    if ((QF(paramInt) instanceof c))
    {
      AppMethodBeat.o(370461);
      return true;
    }
    if (!(QF(paramInt + 1) instanceof x)) {}
    for (int i = 1; (QE(paramInt)) && (i != 0); i = 0)
    {
      AppMethodBeat.o(370461);
      return true;
    }
    AppMethodBeat.o(370461);
    return false;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(341210);
    this.BtB.dead();
    this.EKI.dead();
    eET();
    this.EKF.clear();
    this.EKB.hy(this.context);
    AppMethodBeat.o(341210);
  }
  
  public final void eES()
  {
    AppMethodBeat.i(341219);
    if (!eFb())
    {
      Log.w("NearbyLiveAutoPlayManager", s.X("checkAutoPlay return for enableNearbyLiveAutoPlay:", Boolean.valueOf(eFb())));
      AppMethodBeat.o(341219);
      return;
    }
    this.EKz = false;
    com.tencent.mm.plugin.finder.live.fluent.g localg = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
    if (com.tencent.mm.plugin.finder.live.fluent.g.ejt())
    {
      eEU();
      AppMethodBeat.o(341219);
      return;
    }
    eFd();
    AppMethodBeat.o(341219);
  }
  
  public final void eET()
  {
    AppMethodBeat.i(341270);
    Log.i("NearbyLiveAutoPlayManager", s.X("stopCurrentView set:", Integer.valueOf(this.EJT.size())));
    if (this.EHY != null)
    {
      this.mRi.removeCallbacks(this.EHY);
      this.EHY = null;
    }
    Iterator localIterator = ((Iterable)this.EJT).iterator();
    while (localIterator.hasNext()) {
      d.a(0L, (kotlin.g.a.a)new j(this, (b)localIterator.next()));
    }
    this.EJT.clear();
    AppMethodBeat.o(341270);
  }
  
  final boolean eFc()
  {
    return (this.EKx) && (!this.EKG);
  }
  
  public final void m(int paramInt, View paramView)
  {
    AppMethodBeat.i(341254);
    if (!com.tencent.mm.plugin.expansions.e.isInstalled())
    {
      Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay return for expansions not yet installed");
      AppMethodBeat.o(341254);
      return;
    }
    if (!this.EKJ)
    {
      Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay return for isEnableCheckAutoPlay is disable");
      AppMethodBeat.o(341254);
      return;
    }
    if (!eFb())
    {
      Log.w("NearbyLiveAutoPlayManager", s.X("checkAutoPlay return for enableNearbyLiveAutoPlay:", Boolean.valueOf(eFb())));
      AppMethodBeat.o(341254);
      return;
    }
    cc localcc = QF(paramInt);
    if (localcc == null)
    {
      Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay pos:" + paramInt + "  return for feed:" + localcc);
      AppMethodBeat.o(341254);
      return;
    }
    Object localObject1 = (FrameLayout)paramView.findViewById(com.tencent.mm.plugin.finder.e.e.live_player_container);
    if (localObject1 == null)
    {
      Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay pos:" + paramInt + " return for view:" + paramView);
      AppMethodBeat.o(341254);
      return;
    }
    localObject1 = g((FrameLayout)localObject1);
    if ((localcc instanceof x))
    {
      Object localObject2 = ((x)localcc).feedObject.getFeedObject().liveInfo;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((bip)localObject2).ZSn;
        if (localObject2 != null)
        {
          localObject3 = com.tencent.d.a.a.a.b.b.ahnU;
          if (com.tencent.d.a.a.a.b.b.a((bgr)localObject2) != true) {}
        }
      }
      for (int i = 1; i != 0; i = 0)
      {
        Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay return is olympic");
        AppMethodBeat.o(341254);
        return;
      }
      localObject2 = ((x)localcc).feedObject.getFeedObject().liveInfo;
      if ((localObject2 != null) && (((bip)localObject2).liveStatus == 1))
      {
        i = 1;
        if (i != 0) {
          break label400;
        }
        localObject1 = new StringBuilder("checkAutoPlay pos:").append(paramInt).append(" return for liveStatus:");
        paramView = ((x)localcc).feedObject.getFeedObject().liveInfo;
        if (paramView != null) {
          break label389;
        }
      }
      label389:
      for (paramView = null;; paramView = Integer.valueOf(paramView.liveStatus))
      {
        Log.w("NearbyLiveAutoPlayManager", paramView);
        AppMethodBeat.o(341254);
        return;
        i = 0;
        break;
      }
      label400:
      if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(((x)localcc).feedObject.getFeedObject().liveInfo))
      {
        Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay pos:" + paramInt + " return for charge live!");
        AppMethodBeat.o(341254);
        return;
      }
      localObject2 = ((x)localcc).feedObject.getFeedObject().liveInfo;
      if (localObject2 != null)
      {
        localObject2 = ((bip)localObject2).mIE;
        if (localObject2 != null)
        {
          if (a((NearbyLivePreviewView)localObject1))
          {
            Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay pos:" + paramInt + " return for same feed:" + localcc + " same view:" + localObject1 + " set:" + this.EJT.size());
            AppMethodBeat.o(341254);
            return;
          }
          localObject3 = ((x)localcc).feedObject.getFeedObject().liveInfo;
          if ((localObject3 != null) && (((bip)localObject3).ZSl == 1)) {}
          for (i = 1; i != 0; i = 0)
          {
            Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay pos:" + paramInt + " return for vr live");
            AppMethodBeat.o(341254);
            return;
          }
          eFe();
          this.EJT.add(new b(paramInt, (NearbyLivePreviewView)localObject1, (x)localcc));
          Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay pos:" + paramInt + " feed:" + localcc + " view:" + localObject1);
          d.a(0L, (kotlin.g.a.a)new e.e((String)localObject2, localcc, this, paramInt, (NearbyLivePreviewView)localObject1, paramView));
          paramView = com.tencent.mm.plugin.finder.nearby.report.a.EQq;
          com.tencent.mm.plugin.finder.nearby.report.a.a((x)localcc, paramInt);
          AppMethodBeat.o(341254);
        }
      }
    }
    else
    {
      Log.w("NearbyLiveAutoPlayManager", s.X("checkAutoPlay return for feed:", localcc));
    }
    AppMethodBeat.o(341254);
  }
  
  public final void sP(boolean paramBoolean)
  {
    AppMethodBeat.i(341244);
    this.EKJ = paramBoolean;
    if (paramBoolean)
    {
      eES();
      AppMethodBeat.o(341244);
      return;
    }
    this.EKF.clear();
    eET();
    AppMethodBeat.o(341244);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$Companion;", "", "()V", "NEARBY_LIVE_PREVIEW_VIEW_TAG", "", "NOTIFY_BUFFERING_START_DELAY_MS", "", "TAG", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewData;", "", "pos", "", "view", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "(ILcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "getPos", "()I", "getView", "()Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final x EJX;
    final NearbyLivePreviewView EKL;
    public final int pos;
    
    public b(int paramInt, NearbyLivePreviewView paramNearbyLivePreviewView, x paramx)
    {
      AppMethodBeat.i(340937);
      this.pos = paramInt;
      this.EKL = paramNearbyLivePreviewView;
      this.EJX = paramx;
      AppMethodBeat.o(340937);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(340957);
      if (this == paramObject)
      {
        AppMethodBeat.o(340957);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(340957);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.pos != paramObject.pos)
      {
        AppMethodBeat.o(340957);
        return false;
      }
      if (!s.p(this.EKL, paramObject.EKL))
      {
        AppMethodBeat.o(340957);
        return false;
      }
      if (!s.p(this.EJX, paramObject.EJX))
      {
        AppMethodBeat.o(340957);
        return false;
      }
      AppMethodBeat.o(340957);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(340951);
      int i = this.pos;
      int j = this.EKL.hashCode();
      int k = this.EJX.hashCode();
      AppMethodBeat.o(340951);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(340944);
      String str = "LivePreviewData(pos=" + this.pos + ", view=" + this.EKL + ", feed=" + this.EJX + ')';
      AppMethodBeat.o(340944);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$attach$1", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChange", "", "on", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements HeadsetReceiver.b
  {
    d(e parame) {}
    
    public final void sO(boolean paramBoolean)
    {
      AppMethodBeat.i(340954);
      Log.i("NearbyLiveAutoPlayManager", s.X("onHeadsetStateChange on:", Boolean.valueOf(paramBoolean)));
      e.a(this.EKK, paramBoolean);
      if (!e.c(this.EKK))
      {
        Object localObject = this.EKK;
        Log.i("NearbyLiveAutoPlayManager", s.X("muteCurrentView set:", Integer.valueOf(((e)localObject).EJT.size())));
        localObject = ((Iterable)((e)localObject).EJT).iterator();
        while (((Iterator)localObject).hasNext()) {
          d.a(0L, (kotlin.g.a.a)new e.g((e.b)((Iterator)localObject).next()));
        }
      }
      AppMethodBeat.o(340954);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(e.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    h(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(e parame, e.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.e
 * JD-Core Version:    0.7.0.1
 */