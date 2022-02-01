package com.tencent.mm.plugin.finder.nearby.live.play;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "", "context", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isEnableVoice", "", "tabId", "", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList;ZI)V", "autoPlayRunnable", "Ljava/lang/Runnable;", "autoPlaySelector", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlaySelector;", "getContext", "()Landroid/content/Context;", "curLivePreviewDataSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewData;", "Lkotlin/collections/HashSet;", "curLivePreviewMuteStateDataSet", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewMuteStateData;", "enableNearbyLiveAutoPlay", "getFeedList", "()Ljava/util/ArrayList;", "headsetReceiver", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver;", "()Z", "isHeadStateOn", "isInvokeAutoPlayByTouchEvent", "onTouchEventAdapter", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveItemOnTouchEventAdapter;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getTabId", "()I", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "attach", "", "checkAutoPlay", "pos", "view", "Landroid/view/View;", "checkAutoPlayDelay", "delayMs", "", "checkAutoPlayForTest1OrTest5", "checkAutoPlayInternal", "checkAutoStopInternal", "checkIfStopCurrentView", "clearCurrentViewMuteState", "detach", "disableLiveMuteByPos", "dismissAudioTips", "findSameLineOtherPos", "getFeedByPos", "getOrCreateLiveView", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "livePlayerContainer", "Landroid/widget/FrameLayout;", "getRecordCurrentViewMuteState", "containerHashCode", "getTouchEventAdapter", "isCurPlayPos", "isCurPlayerView", "nearbyLivePreviewView", "isFinishLive", "isInvokeAutoPlayPosVisible", "firstVisiblePos", "lastVisiblePos", "isLeftPos", "isPlayMute", "isRecordMute", "rootView", "isVisibleRectLessThan90Percent", "muteCurrentView", "recordCurrentViewMuteState", "recordViewMuteState", "isMute", "showAudioTips", "stopCurrentView", "Companion", "LivePreviewData", "LivePreviewMuteStateData", "plugin-finder-nearby_release"})
public final class c
{
  public static final a zFp;
  public final Context context;
  final int fXY;
  final ArrayList<bu> feedList;
  final RecyclerView jLl;
  private MMHandler knk;
  private Runnable xVd;
  private final boolean zFg;
  private final d zFh;
  public final HeadsetReceiver zFi;
  boolean zFj;
  public final e zFk;
  HashSet<b> zFl;
  public HashSet<c> zFm;
  boolean zFn;
  final boolean zFo;
  
  static
  {
    AppMethodBeat.i(201218);
    zFp = new a((byte)0);
    AppMethodBeat.o(201218);
  }
  
  public c(Context paramContext, RecyclerView paramRecyclerView, ArrayList<bu> paramArrayList, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(201217);
    this.context = paramContext;
    this.jLl = paramRecyclerView;
    this.feedList = paramArrayList;
    this.zFo = paramBoolean;
    this.fXY = paramInt;
    paramContext = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ily().aSr()).intValue() == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.zFg = paramBoolean;
      this.zFh = new d(this.feedList);
      this.zFi = new HeadsetReceiver();
      this.zFk = new e((kotlin.g.a.b)new c.i(this), (kotlin.g.a.b)new j(this));
      this.zFl = new HashSet();
      this.zFm = new HashSet();
      this.knk = new MMHandler(Looper.getMainLooper());
      this.jLl.a((RecyclerView.l)new c.1(this));
      Log.i("NearbyLiveAutoPlayManager", "init isEnableVoice:" + this.zFo + ' ');
      AppMethodBeat.o(201217);
      return;
    }
  }
  
  private final void Oo(int paramInt)
  {
    AppMethodBeat.i(201197);
    Object localObject1 = this.jLl.getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(201197);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((FinderStaggeredGridLayoutManager)localObject1).findViewByPosition(paramInt);
    if (localObject1 != null)
    {
      Oq(paramInt);
      Object localObject2 = new Rect();
      ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
      int i = ((Rect)localObject2).height();
      int j = ((View)localObject1).getHeight();
      if (i * 1.0F / j < 0.9F)
      {
        i = 1;
        if (i != 0)
        {
          localObject2 = (NearbyLivePreviewView)((View)localObject1).findViewWithTag("nearby-live-preview-view-tag");
          if (localObject2 == null) {
            break label192;
          }
        }
      }
      label192:
      for (boolean bool = a((NearbyLivePreviewView)localObject2);; bool = false)
      {
        if (bool)
        {
          dLP();
          Log.i("NearbyLiveAutoPlayManager", "checkAutoStopInternal stop pos:" + paramInt + " view:" + localObject1);
        }
        AppMethodBeat.o(201197);
        return;
        i = 0;
        break;
      }
    }
    AppMethodBeat.o(201197);
  }
  
  private final bu Or(int paramInt)
  {
    AppMethodBeat.i(201215);
    if (this.feedList == null)
    {
      Log.w("NearbyLiveAutoPlayManager", "getFeedByPos return for feedList:" + this.feedList);
      AppMethodBeat.o(201215);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.feedList.size()))
    {
      Log.w("NearbyLiveAutoPlayManager", "getFeedByPos return for invalid pos:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(201215);
      return null;
    }
    bu localbu = (bu)this.feedList.get(paramInt);
    AppMethodBeat.o(201215);
    return localbu;
  }
  
  private final boolean a(NearbyLivePreviewView paramNearbyLivePreviewView)
  {
    AppMethodBeat.i(201212);
    Iterator localIterator = ((Iterable)this.zFl).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.h(((b)localObject).zFr, paramNearbyLivePreviewView));
    for (paramNearbyLivePreviewView = localObject; paramNearbyLivePreviewView != null; paramNearbyLivePreviewView = null)
    {
      AppMethodBeat.o(201212);
      return true;
    }
    AppMethodBeat.o(201212);
    return false;
  }
  
  private final void dLO()
  {
    AppMethodBeat.i(201191);
    if (this.xVd != null)
    {
      this.knk.removeCallbacks(this.xVd);
      this.xVd = null;
    }
    this.xVd = ((Runnable)new f(this));
    this.knk.postDelayed(this.xVd, 500L);
    AppMethodBeat.o(201191);
  }
  
  private final void dLQ()
  {
    AppMethodBeat.i(201209);
    if (this.zFl.size() >= d.dLR()) {
      dLP();
    }
    AppMethodBeat.o(201209);
  }
  
  private static NearbyLivePreviewView g(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(201214);
    Object localObject = (NearbyLivePreviewView)paramFrameLayout.findViewWithTag("nearby-live-preview-view-tag");
    if (localObject != null)
    {
      Log.i("NearbyLiveAutoPlayManager", "getOrCreateLiveView get view:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(201214);
      return localObject;
    }
    localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = ((f)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(f.class)).dLT();
    ((NearbyLivePreviewView)localObject).setTag("nearby-live-preview-view-tag");
    paramFrameLayout.addView((View)localObject);
    Log.i("NearbyLiveAutoPlayManager", "getOrCreateLiveView create view:".concat(String.valueOf(localObject)));
    AppMethodBeat.o(201214);
    return localObject;
  }
  
  public final boolean Op(int paramInt)
  {
    AppMethodBeat.i(201205);
    Iterator localIterator = ((Iterable)this.zFl).iterator();
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
      AppMethodBeat.o(201205);
      return true;
      i = 0;
      break label51;
      label70:
      break;
      localObject = null;
    }
    label77:
    AppMethodBeat.o(201205);
    return false;
  }
  
  final void Oq(int paramInt)
  {
    AppMethodBeat.i(201208);
    Object localObject = this.jLl.getLayoutManager();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(201208);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderStaggeredGridLayoutManager)localObject).findViewByPosition(paramInt);
    if (localObject != null)
    {
      new g((View)localObject, Os(paramInt)).dLX();
      AppMethodBeat.o(201208);
      return;
    }
    AppMethodBeat.o(201208);
  }
  
  final boolean Os(int paramInt)
  {
    AppMethodBeat.i(201216);
    if (paramInt >= 0)
    {
      int j = 0;
      int i;
      for (k = paramInt;; k = i)
      {
        i = k;
        if (!(Or(j) instanceof w))
        {
          Log.i("NearbyLiveAutoPlayManager", "isLeftPos pos:" + paramInt + " ignore pos:" + j);
          i = k - 1;
        }
        k = i;
        if (j == paramInt) {
          break;
        }
        j += 1;
      }
    }
    int k = paramInt;
    if (k % 2 == 0)
    {
      AppMethodBeat.o(201216);
      return true;
    }
    AppMethodBeat.o(201216);
    return false;
  }
  
  public final void dLN()
  {
    AppMethodBeat.i(201190);
    if (!this.zFg)
    {
      Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay return for enableNearbyLiveAutoPlay:" + this.zFg);
      AppMethodBeat.o(201190);
      return;
    }
    dLO();
    AppMethodBeat.o(201190);
  }
  
  public final void dLP()
  {
    AppMethodBeat.i(201207);
    Log.i("NearbyLiveAutoPlayManager", "stopCurrentView set:" + this.zFl.size());
    if (this.xVd != null)
    {
      this.knk.removeCallbacks(this.xVd);
      this.xVd = null;
    }
    Iterator localIterator = ((Iterable)this.zFl).iterator();
    while (localIterator.hasNext()) {
      com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new k((b)localIterator.next()));
    }
    this.zFl.clear();
    AppMethodBeat.o(201207);
  }
  
  final void g(final int paramInt, final View paramView)
  {
    AppMethodBeat.i(201204);
    if (!this.zFg)
    {
      Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay return for enableNearbyLiveAutoPlay:" + this.zFg);
      AppMethodBeat.o(201204);
      return;
    }
    final bu localbu = Or(paramInt);
    if (localbu == null)
    {
      Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay return for feed:".concat(String.valueOf(localbu)));
      AppMethodBeat.o(201204);
      return;
    }
    Object localObject1 = (FrameLayout)paramView.findViewById(b.f.live_player_container);
    if (localObject1 == null)
    {
      Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay return for view:".concat(String.valueOf(paramView)));
      AppMethodBeat.o(201204);
      return;
    }
    localObject1 = g((FrameLayout)localObject1);
    if ((localbu instanceof w))
    {
      Object localObject2 = ((w)localbu).feedObject.getFeedObject().liveInfo;
      if ((localObject2 == null) || (((bac)localObject2).liveStatus != 1))
      {
        localObject1 = new StringBuilder("checkAutoPlay return for liveStatus:");
        paramView = ((w)localbu).feedObject.getFeedObject().liveInfo;
        if (paramView != null) {}
        for (paramView = Integer.valueOf(paramView.liveStatus);; paramView = null)
        {
          Log.w("NearbyLiveAutoPlayManager", paramView);
          AppMethodBeat.o(201204);
          return;
        }
      }
      localObject2 = ((w)localbu).feedObject.getFeedObject().liveInfo;
      if (localObject2 != null)
      {
        localObject2 = ((bac)localObject2).kih;
        if (localObject2 != null)
        {
          if (a((NearbyLivePreviewView)localObject1))
          {
            Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay return for same feed:" + localbu + " same view:" + localObject1 + " set:" + this.zFl.size());
            AppMethodBeat.o(201204);
            return;
          }
          dLQ();
          this.zFl.add(new b(paramInt, (NearbyLivePreviewView)localObject1, (w)localbu));
          Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay pos:" + paramInt + " feed:" + localbu + " view:" + localObject1);
          com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new e((String)localObject2, this, (NearbyLivePreviewView)localObject1, localbu, paramInt, paramView));
          paramView = com.tencent.mm.plugin.finder.nearby.report.a.zIZ;
          com.tencent.mm.plugin.finder.nearby.report.a.a((w)localbu, paramInt);
          Log.i("NearbyLiveAutoPlayManager", "checkAutoPlay view:".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(201204);
          return;
        }
      }
      AppMethodBeat.o(201204);
      return;
    }
    Log.w("NearbyLiveAutoPlayManager", "checkAutoPlay return for feed:".concat(String.valueOf(localbu)));
    AppMethodBeat.o(201204);
  }
  
  public final void lT()
  {
    AppMethodBeat.i(201187);
    this.zFi.a(this.context, (HeadsetReceiver.b)new d(this));
    AppMethodBeat.o(201187);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$Companion;", "", "()V", "NEARBY_LIVE_PREVIEW_VIEW_TAG", "", "NOTIFY_BUFFERING_START_DELAY_MS", "", "TAG", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewData;", "", "pos", "", "view", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "(ILcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "getPos", "()I", "getView", "()Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-nearby_release"})
  public static final class b
  {
    final int pos;
    private final w zFe;
    final NearbyLivePreviewView zFr;
    
    public b(int paramInt, NearbyLivePreviewView paramNearbyLivePreviewView, w paramw)
    {
      AppMethodBeat.i(202060);
      this.pos = paramInt;
      this.zFr = paramNearbyLivePreviewView;
      this.zFe = paramw;
      AppMethodBeat.o(202060);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(202067);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.pos != paramObject.pos) || (!p.h(this.zFr, paramObject.zFr)) || (!p.h(this.zFe, paramObject.zFe))) {}
        }
      }
      else
      {
        AppMethodBeat.o(202067);
        return true;
      }
      AppMethodBeat.o(202067);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(202065);
      int k = this.pos;
      Object localObject = this.zFr;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.zFe;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(202065);
        return (i + k * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202063);
      String str = "LivePreviewData(pos=" + this.pos + ", view=" + this.zFr + ", feed=" + this.zFe + ")";
      AppMethodBeat.o(202063);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewMuteStateData;", "", "pos", "", "containerHashCode", "isMute", "", "(IIZ)V", "getContainerHashCode", "()I", "()Z", "getPos", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-nearby_release"})
  public static final class c
  {
    final boolean iYs;
    final int pos;
    final int zFs;
    
    public c(int paramInt1, int paramInt2)
    {
      this.pos = paramInt1;
      this.zFs = paramInt2;
      this.iYs = false;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.pos != paramObject.pos) || (this.zFs != paramObject.zFs) || (this.iYs != paramObject.iYs)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202343);
      String str = "LivePreviewMuteStateData(pos=" + this.pos + ", containerHashCode=" + this.zFs + ", isMute=" + this.iYs + ")";
      AppMethodBeat.o(202343);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$attach$1", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChange", "", "on", "", "plugin-finder-nearby_release"})
  public static final class d
    implements HeadsetReceiver.b
  {
    public final void pR(boolean paramBoolean)
    {
      AppMethodBeat.i(200197);
      Log.i("NearbyLiveAutoPlayManager", "onHeadsetStateChange on:".concat(String.valueOf(paramBoolean)));
      c.a(this.zFq, paramBoolean);
      if (!c.a(this.zFq))
      {
        Object localObject = this.zFq;
        Log.i("NearbyLiveAutoPlayManager", "muteCurrentView set:" + ((c)localObject).zFl.size());
        localObject = ((Iterable)((c)localObject).zFl).iterator();
        while (((Iterator)localObject).hasNext()) {
          com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new c.h((c.b)((Iterator)localObject).next()));
        }
      }
      AppMethodBeat.o(200197);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$checkAutoPlay$2$1"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(String paramString, c paramc, NearbyLivePreviewView paramNearbyLivePreviewView, bu parambu, int paramInt, View paramView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(202038);
      c.b(this.zFq);
      AppMethodBeat.o(202038);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(c.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pos", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    j(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(c.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.c
 * JD-Core Version:    0.7.0.1
 */