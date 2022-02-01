package com.tencent.mm.plugin.finder.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedLiveRecommendView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "INTERVAL", "", "INTERVAL_WHEN_ONE_TIPS", "TAG", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedLiveRecommendView$ViewHolder;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "callBack", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "curVisiblePosition", "defaultReportMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "entryBg", "Landroid/view/View;", "getEntryBg", "()Landroid/view/View;", "setEntryBg", "(Landroid/view/View;)V", "entryTextView", "Landroid/widget/TextView;", "getEntryTextView", "()Landroid/widget/TextView;", "setEntryTextView", "(Landroid/widget/TextView;)V", "handlerForEmptyTips", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandlerForEmptyTips", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handlerForEmptyTips$delegate", "Lkotlin/Lazy;", "hasFinishAnim", "", "hasPauseAnim", "hasStartAnim", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "recommendTips", "Ljava/util/LinkedList;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "root", "getRoot", "setRoot", "statusIcon", "getStatusIcon", "setStatusIcon", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "visibleHolderTop", "changeItemAlpha", "", "clearAll", "init", "onDrawListenerRemoved", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "pauseRecommendTipsAnim", "report23057", "hasBtnChangeColor", "index", "textValue", "report23059", "scrollToNext", "startAnim", "startRecommendTipsAnim", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "update", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveStatus", "ViewHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedLiveRecommendView
  extends FrameLayout
{
  public WxRecyclerView AZd;
  private final j Bwl;
  private MTimerHandler.CallBack DdQ;
  public View GyY;
  public TextView GyZ;
  public View Gza;
  public LinkedList<String> Gzb;
  private long Gzc;
  public int Gzd;
  private int Gze;
  public volatile boolean Gzf;
  public boolean Gzg;
  public boolean Gzh;
  public final HashMap<String, String> Gzi;
  private final j Gzj;
  private final long INTERVAL;
  public final String TAG;
  public View lBX;
  public Context mContext;
  public RecyclerView.a<a> mlt;
  
  public FinderFeedLiveRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345645);
    this.TAG = "FinderFeedLiveRecommendView";
    this.INTERVAL = 3000L;
    this.Gzc = 10000L;
    this.Gzd = 3;
    this.Gzi = new HashMap();
    this.DdQ = new FinderFeedLiveRecommendView..ExternalSyntheticLambda0(this);
    this.Bwl = k.cm((kotlin.g.a.a)new d(this));
    this.Gzj = k.cm((kotlin.g.a.a)new b(this));
    init(paramContext);
    AppMethodBeat.o(345645);
  }
  
  public FinderFeedLiveRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345652);
    this.TAG = "FinderFeedLiveRecommendView";
    this.INTERVAL = 3000L;
    this.Gzc = 10000L;
    this.Gzd = 3;
    this.Gzi = new HashMap();
    this.DdQ = new FinderFeedLiveRecommendView..ExternalSyntheticLambda0(this);
    this.Bwl = k.cm((kotlin.g.a.a)new d(this));
    this.Gzj = k.cm((kotlin.g.a.a)new b(this));
    init(paramContext);
    AppMethodBeat.o(345652);
  }
  
  private static final void a(FinderFeedLiveRecommendView paramFinderFeedLiveRecommendView)
  {
    AppMethodBeat.i(345683);
    s.u(paramFinderFeedLiveRecommendView, "this$0");
    paramFinderFeedLiveRecommendView.fky();
    AppMethodBeat.o(345683);
  }
  
  private static final boolean b(FinderFeedLiveRecommendView paramFinderFeedLiveRecommendView)
  {
    AppMethodBeat.i(345690);
    s.u(paramFinderFeedLiveRecommendView, "this$0");
    LinkedList localLinkedList = paramFinderFeedLiveRecommendView.Gzb;
    if (localLinkedList == null) {}
    for (int i = 0;; i = localLinkedList.size())
    {
      Log.i(paramFinderFeedLiveRecommendView.TAG, "curVisiblePosition:" + paramFinderFeedLiveRecommendView.Gzd + ", size:" + i);
      if (paramFinderFeedLiveRecommendView.Gzd != i - 1) {
        break;
      }
      paramFinderFeedLiveRecommendView.getTimeHandler().stopTimer();
      long l2 = paramFinderFeedLiveRecommendView.Gzc - (i - 3) * paramFinderFeedLiveRecommendView.INTERVAL;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = paramFinderFeedLiveRecommendView.Gzc;
      }
      paramFinderFeedLiveRecommendView.getHandlerForEmptyTips().postDelayed(new FinderFeedLiveRecommendView..ExternalSyntheticLambda1(paramFinderFeedLiveRecommendView), l1);
      paramFinderFeedLiveRecommendView.getHandlerForEmptyTips().sendEmptyMessageDelayed(1, l1);
      AppMethodBeat.o(345690);
      return false;
    }
    int j = paramFinderFeedLiveRecommendView.Gzd;
    localLinkedList = paramFinderFeedLiveRecommendView.Gzb;
    if (localLinkedList == null)
    {
      i = 0;
      if (j < i) {
        paramFinderFeedLiveRecommendView.fky();
      }
      paramFinderFeedLiveRecommendView.Gzd += 1;
      j = paramFinderFeedLiveRecommendView.Gzd;
      paramFinderFeedLiveRecommendView = paramFinderFeedLiveRecommendView.Gzb;
      if (paramFinderFeedLiveRecommendView != null) {
        break label224;
      }
    }
    label224:
    for (i = 0;; i = paramFinderFeedLiveRecommendView.size())
    {
      if (j >= i) {
        break label232;
      }
      AppMethodBeat.o(345690);
      return true;
      i = localLinkedList.size();
      break;
    }
    label232:
    AppMethodBeat.o(345690);
    return false;
  }
  
  private static final void c(FinderFeedLiveRecommendView paramFinderFeedLiveRecommendView)
  {
    int i = 0;
    AppMethodBeat.i(345694);
    s.u(paramFinderFeedLiveRecommendView, "this$0");
    Object localObject = paramFinderFeedLiveRecommendView.getRecyclerView().fU(1);
    if (localObject == null) {}
    for (;;)
    {
      paramFinderFeedLiveRecommendView.Gze = i;
      paramFinderFeedLiveRecommendView.cKI();
      paramFinderFeedLiveRecommendView.Gzf = true;
      Log.i(paramFinderFeedLiveRecommendView.TAG, "[startRecommendTipsAnim] nomal start");
      AppMethodBeat.o(345694);
      return;
      localObject = ((RecyclerView.v)localObject).caK;
      if (localObject != null) {
        i = ((View)localObject).getTop();
      }
    }
  }
  
  private final void c(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(345680);
    Log.i(this.TAG, "report23057");
    HashMap localHashMap = new HashMap();
    localHashMap.putAll((Map)this.Gzi);
    Map localMap = (Map)localHashMap;
    Object localObject;
    if (paramBoolean)
    {
      localObject = "1";
      localMap.put("button_colour", localObject);
      if (!paramBoolean)
      {
        localObject = this.Gzb;
        if (localObject == null) {
          break label187;
        }
        if (((Collection)localObject).isEmpty()) {
          break label181;
        }
        i = 1;
        label97:
        if (i != 1) {
          break label187;
        }
      }
    }
    label181:
    label187:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((Map)localHashMap).put("text_index", String.valueOf(paramInt));
        ((Map)localHashMap).put("text_value", paramString);
      }
      ((ce)h.ax(ce.class)).a(q.t.Dws, (Map)localHashMap);
      AppMethodBeat.o(345680);
      return;
      localObject = "0";
      break;
      i = 0;
      break label97;
    }
  }
  
  private final void cKI()
  {
    AppMethodBeat.i(345671);
    LinkedList localLinkedList = this.Gzb;
    if (localLinkedList == null) {}
    for (int i = 0; i > 4; i = localLinkedList.size())
    {
      getTimeHandler().startTimer(this.INTERVAL);
      this.Gzh = false;
      AppMethodBeat.o(345671);
      return;
    }
    localLinkedList = this.Gzb;
    if (localLinkedList == null) {}
    for (i = 0; i == 4; i = localLinkedList.size())
    {
      getHandlerForEmptyTips().sendEmptyMessageDelayed(1, this.Gzc);
      this.Gzh = false;
      AppMethodBeat.o(345671);
      return;
    }
    localLinkedList = this.Gzb;
    if (localLinkedList == null) {}
    for (i = 0; i == 3; i = localLinkedList.size())
    {
      getHandlerForEmptyTips().sendEmptyMessageDelayed(1, this.Gzc);
      this.Gzh = false;
      AppMethodBeat.o(345671);
      return;
    }
    Log.i(this.TAG, "[startAnim] not start");
    AppMethodBeat.o(345671);
  }
  
  private final void fky()
  {
    AppMethodBeat.i(345635);
    Object localObject1 = getRecyclerView();
    Object localObject2 = c.a(this.Gzd, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/view/FinderFeedLiveRecommendView", "scrollToNext", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/view/FinderFeedLiveRecommendView", "scrollToNext", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    int i = this.Gzd;
    int j = this.Gzd;
    localObject2 = getRecyclerView().fU(i - 2);
    localObject1 = getRecyclerView().fU(j - 1);
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ObjectAnimator.ofFloat(((RecyclerView.v)localObject2).caK, "alpha", new float[] { 1.0F, 0.0F }).setDuration(800L);
      s.s(localObject2, "ofFloat(outing.itemView,…,1f,0f).setDuration(800L)");
      localObject1 = ObjectAnimator.ofFloat(((RecyclerView.v)localObject1).caK, "alpha", new float[] { 0.0F, 1.0F }).setDuration(800L);
      s.s(localObject1, "ofFloat(entering.itemVie…,0f,1f).setDuration(800L)");
      ((ObjectAnimator)localObject2).start();
      ((ObjectAnimator)localObject1).start();
    }
    localObject1 = this.Gzb;
    if (localObject1 != null)
    {
      localObject1 = (String)((LinkedList)localObject1).get(this.Gzd - 3);
      if (localObject1 != null) {
        c(false, this.Gzd - 2, (String)localObject1);
      }
    }
    AppMethodBeat.o(345635);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(345661);
    Log.i(this.TAG, "[init]");
    setMContext(paramContext);
    Object localObject = d.FAy;
    this.Gzc = (((Number)d.eYn().bmg()).longValue() * 1000L);
    localObject = af.mU(paramContext).inflate(e.f.finder_feed_live_recommend_banner_layout, (ViewGroup)this);
    s.s(localObject, "getInflater(context)\n   …mend_banner_layout, this)");
    setRoot((View)localObject);
    localObject = getRoot().findViewById(e.e.finder_live_recommend_banner);
    s.s(localObject, "root.findViewById(R.id.f…er_live_recommend_banner)");
    setRecyclerView((WxRecyclerView)localObject);
    localObject = getRoot().findViewById(e.e.living_status_icon);
    s.s(localObject, "root.findViewById(R.id.living_status_icon)");
    setStatusIcon((View)localObject);
    localObject = getRoot().findViewById(e.e.finder_live_entry_txt);
    s.s(localObject, "root.findViewById(R.id.finder_live_entry_txt)");
    setEntryTextView((TextView)localObject);
    com.tencent.mm.ui.aw.a((Paint)getEntryTextView().getPaint(), 0.8F);
    localObject = getRoot().findViewById(e.e.finder_feed_live_entry_bg);
    s.s(localObject, "root.findViewById(R.id.finder_feed_live_entry_bg)");
    setEntryBg((View)localObject);
    localObject = new FinderLinearLayoutManager(paramContext);
    ((FinderLinearLayoutManager)localObject).GGx = 1000.0F;
    getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)localObject);
    setAdapter((RecyclerView.a)new c(paramContext, this));
    getRecyclerView().setAdapter(getAdapter());
    AppMethodBeat.o(345661);
  }
  
  public final void a(bip parambip, int paramInt)
  {
    AppMethodBeat.i(345888);
    if (((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isUnPurchasedChargeLive(parambip))
    {
      Object localObject = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage();
      long l;
      if (parambip == null)
      {
        l = 0L;
        paramInt = ((com.tencent.d.a.a.a.d.b)localObject).ov(l);
        localObject = com.tencent.d.a.a.a.a.a.ahiX;
        int i = ((Number)com.tencent.d.a.a.a.a.a.jUn().bmg()).intValue();
        localObject = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("update live is charge live:");
        if (parambip != null) {
          break label192;
        }
        parambip = null;
        label97:
        Log.i((String)localObject, parambip + ",totalFreeTimeToWatch:" + i + ",usedTime:" + paramInt);
        getStatusIcon().setVisibility(0);
        if (paramInt < 0) {
          break label208;
        }
        if (paramInt >= i) {
          break label203;
        }
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label213;
        }
        getEntryTextView().setText((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_live_entry_wording1));
        AppMethodBeat.o(345888);
        return;
        l = parambip.liveId;
        break;
        label192:
        parambip = Long.valueOf(parambip.liveId);
        break label97;
        label203:
        paramInt = 0;
        continue;
        label208:
        paramInt = 0;
      }
      label213:
      getEntryTextView().setText((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_live_entry_wording2));
      AppMethodBeat.o(345888);
      return;
    }
    if (paramInt == 1)
    {
      getStatusIcon().setVisibility(0);
      getEntryTextView().setText((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_live_entry_wording));
      AppMethodBeat.o(345888);
      return;
    }
    getEntryTextView().setText((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_live_end));
    getStatusIcon().setVisibility(8);
    getTimeHandler().stopTimer();
    getHandlerForEmptyTips().removeCallbacksAndMessages(null);
    getRecyclerView().setVisibility(4);
    AppMethodBeat.o(345888);
  }
  
  public final void c(x paramx)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(345916);
        s.u(paramx, "item");
        localObject1 = (Collection)this.Gzb;
        if (localObject1 == null) {
          break label619;
        }
        if (((Collection)localObject1).isEmpty())
        {
          break label619;
          if ((i == 0) && (this.Gzf) && (!this.Gzg) && (this.Gzh))
          {
            cKI();
            Log.i(this.TAG, "[startRecommendTipsAnim] resume anim");
            AppMethodBeat.o(345916);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        if ((this.Gzf) || (this.Gzg))
        {
          Log.i(this.TAG, "[startRecommendTipsAnim] hasStartAnim or hasFinishAnim,return");
          AppMethodBeat.o(345916);
          continue;
        }
        this.Gzb = new LinkedList();
      }
      finally {}
      Object localObject2 = this.Gzi;
      Map localMap = (Map)localObject2;
      Object localObject1 = paramx.feedObject.getFinderObject().liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        label179:
        localMap.put("liveid", String.valueOf(localObject1));
        ((Map)localObject2).put("feedid", String.valueOf(paramx.feedObject.getFinderObject().id));
        localObject2 = (Map)localObject2;
        localObject1 = paramx.feedObject.getFinderObject().liveInfo;
        if (localObject1 != null) {
          break label483;
        }
        localObject1 = null;
        label249:
        ((Map)localObject2).put("text_total", String.valueOf(localObject1));
        localObject1 = d.FAy;
        if (((Number)d.eYj().bmg()).intValue() != -1) {
          break label537;
        }
        localObject1 = paramx.feedObject.getFinderObject().liveInfo;
        if (localObject1 != null) {
          break label514;
        }
        i = j;
        label305:
        Log.i(this.TAG, s.X("[startRecommendTipsAnim] using svr data,size = ", Integer.valueOf(i)));
        if (i > 0)
        {
          paramx = paramx.feedObject.getFinderObject().liveInfo;
          if (paramx != null)
          {
            paramx = paramx.ZSk;
            if (paramx != null)
            {
              localObject1 = this.Gzb;
              if (localObject1 != null) {
                ((LinkedList)localObject1).addAll((Collection)p.c((Iterable)paramx, 3));
              }
            }
          }
        }
      }
      label483:
      int k;
      label514:
      label537:
      do
      {
        paramx = this.Gzb;
        if (paramx != null) {
          paramx.add(0, " ");
        }
        paramx = this.Gzb;
        if (paramx != null) {
          paramx.addLast(" ");
        }
        paramx = this.Gzb;
        if (paramx != null) {
          paramx.addLast(" ");
        }
        getRecyclerView().setVisibility(0);
        getAdapter().bZE.notifyChanged();
        getRecyclerView().post(new FinderFeedLiveRecommendView..ExternalSyntheticLambda2(this));
        AppMethodBeat.o(345916);
        break;
        localObject1 = Long.valueOf(((bip)localObject1).liveId);
        break label179;
        localObject1 = ((bip)localObject1).ZSk;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label249;
        }
        localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        break label249;
        localObject1 = ((bip)localObject1).ZSk;
        i = j;
        if (localObject1 == null) {
          break label305;
        }
        i = ((LinkedList)localObject1).size();
        break label305;
        paramx = d.FAy;
        k = ((Number)d.eYj().bmg()).intValue();
        Log.i(this.TAG, s.X("[startRecommendTipsAnim] using fake data,size = ", Integer.valueOf(k)));
      } while (k <= 0);
      for (int i = 0;; i = j)
      {
        j = i + 1;
        paramx = this.Gzb;
        if (paramx != null) {
          paramx.add(s.X("test_", Integer.valueOf(i)));
        }
        if (j >= k) {
          break;
        }
      }
      label619:
      i = 1;
    }
  }
  
  public final void fkz()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(345896);
        if (this.Gzf)
        {
          if (!getTimeHandler().stopped())
          {
            getTimeHandler().stopTimer();
            this.Gzh = true;
            Log.i(this.TAG, "[pauseRecommendTipsAnim] success 1");
            Log.i(this.TAG, "[pauseRecommendTipsAnim] success ");
            AppMethodBeat.o(345896);
            return;
          }
          if (!getHandlerForEmptyTips().hasMessages(1)) {
            continue;
          }
          getHandlerForEmptyTips().removeCallbacksAndMessages(null);
          Log.i(this.TAG, "[pauseRecommendTipsAnim] success 2");
          continue;
        }
        Log.i(this.TAG, "[pauseRecommendTipsAnim] timeHandler stopped or not Started ,return");
      }
      finally {}
      AppMethodBeat.o(345896);
    }
  }
  
  public final RecyclerView.a<a> getAdapter()
  {
    AppMethodBeat.i(345851);
    RecyclerView.a locala = this.mlt;
    if (locala != null)
    {
      AppMethodBeat.o(345851);
      return locala;
    }
    s.bIx("adapter");
    AppMethodBeat.o(345851);
    return null;
  }
  
  public final View getEntryBg()
  {
    AppMethodBeat.i(345830);
    View localView = this.Gza;
    if (localView != null)
    {
      AppMethodBeat.o(345830);
      return localView;
    }
    s.bIx("entryBg");
    AppMethodBeat.o(345830);
    return null;
  }
  
  public final TextView getEntryTextView()
  {
    AppMethodBeat.i(345812);
    TextView localTextView = this.GyZ;
    if (localTextView != null)
    {
      AppMethodBeat.o(345812);
      return localTextView;
    }
    s.bIx("entryTextView");
    AppMethodBeat.o(345812);
    return null;
  }
  
  public final MMHandler getHandlerForEmptyTips()
  {
    AppMethodBeat.i(345872);
    MMHandler localMMHandler = (MMHandler)this.Gzj.getValue();
    AppMethodBeat.o(345872);
    return localMMHandler;
  }
  
  public final Context getMContext()
  {
    AppMethodBeat.i(345735);
    Context localContext = this.mContext;
    if (localContext != null)
    {
      AppMethodBeat.o(345735);
      return localContext;
    }
    s.bIx("mContext");
    AppMethodBeat.o(345735);
    return null;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(345770);
    WxRecyclerView localWxRecyclerView = this.AZd;
    if (localWxRecyclerView != null)
    {
      AppMethodBeat.o(345770);
      return localWxRecyclerView;
    }
    s.bIx("recyclerView");
    AppMethodBeat.o(345770);
    return null;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(345752);
    View localView = this.lBX;
    if (localView != null)
    {
      AppMethodBeat.o(345752);
      return localView;
    }
    s.bIx("root");
    AppMethodBeat.o(345752);
    return null;
  }
  
  public final View getStatusIcon()
  {
    AppMethodBeat.i(345788);
    View localView = this.GyY;
    if (localView != null)
    {
      AppMethodBeat.o(345788);
      return localView;
    }
    s.bIx("statusIcon");
    AppMethodBeat.o(345788);
    return null;
  }
  
  public final MTimerHandler getTimeHandler()
  {
    AppMethodBeat.i(345866);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.Bwl.getValue();
    AppMethodBeat.o(345866);
    return localMTimerHandler;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void setAdapter(RecyclerView.a<a> parama)
  {
    AppMethodBeat.i(345856);
    s.u(parama, "<set-?>");
    this.mlt = parama;
    AppMethodBeat.o(345856);
  }
  
  public final void setEntryBg(View paramView)
  {
    AppMethodBeat.i(345841);
    s.u(paramView, "<set-?>");
    this.Gza = paramView;
    AppMethodBeat.o(345841);
  }
  
  public final void setEntryTextView(TextView paramTextView)
  {
    AppMethodBeat.i(345822);
    s.u(paramTextView, "<set-?>");
    this.GyZ = paramTextView;
    AppMethodBeat.o(345822);
  }
  
  public final void setMContext(Context paramContext)
  {
    AppMethodBeat.i(345744);
    s.u(paramContext, "<set-?>");
    this.mContext = paramContext;
    AppMethodBeat.o(345744);
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    AppMethodBeat.i(345781);
    s.u(paramWxRecyclerView, "<set-?>");
    this.AZd = paramWxRecyclerView;
    AppMethodBeat.o(345781);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(345760);
    s.u(paramView, "<set-?>");
    this.lBX = paramView;
    AppMethodBeat.o(345760);
  }
  
  public final void setStatusIcon(View paramView)
  {
    AppMethodBeat.i(345802);
    s.u(paramView, "<set-?>");
    this.GyY = paramView;
    AppMethodBeat.o(345802);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedLiveRecommendView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/view/FinderFeedLiveRecommendView;Landroid/view/View;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      AppMethodBeat.i(345124);
      AppMethodBeat.o(345124);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    b(FinderFeedLiveRecommendView paramFinderFeedLiveRecommendView)
    {
      super();
    }
    
    private static final boolean a(FinderFeedLiveRecommendView paramFinderFeedLiveRecommendView, Message paramMessage)
    {
      AppMethodBeat.i(345083);
      s.u(paramFinderFeedLiveRecommendView, "this$0");
      s.u(paramMessage, "it");
      FinderFeedLiveRecommendView.f(paramFinderFeedLiveRecommendView);
      AppMethodBeat.o(345083);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderFeedLiveRecommendView$init$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedLiveRecommendView$ViewHolder;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedLiveRecommendView;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.a<FinderFeedLiveRecommendView.a>
  {
    c(Context paramContext, FinderFeedLiveRecommendView paramFinderFeedLiveRecommendView) {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(345068);
      LinkedList localLinkedList = FinderFeedLiveRecommendView.d(jdField_this);
      if (localLinkedList == null)
      {
        AppMethodBeat.o(345068);
        return 0;
      }
      int i = localLinkedList.size();
      AppMethodBeat.o(345068);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MTimerHandler>
  {
    d(FinderFeedLiveRecommendView paramFinderFeedLiveRecommendView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedLiveRecommendView
 * JD-Core Version:    0.7.0.1
 */