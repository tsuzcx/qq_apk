package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.e;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LOOP_INTERVAL", "", "SCROLL_TO_NEXT_IMG_WHAT", "TAG", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$ViewHolder;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "currentPosition", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$ITaskData;", "gameAppId", "getGameAppId", "()Ljava/lang/String;", "setGameAppId", "(Ljava/lang/String;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isViewVisible", "", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "pagerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getPagerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "setPagerView", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager;)V", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "init", "", "onDetachedFromWindow", "onPageChange", "position", "isIdle", "isAuto", "reportExpose", "data", "resetHeadAndTail", "resume", "setTaskInfoList", "taskInfo", "", "startLoop", "stop", "FinderLiveQuestActivityTaskData", "GameActivityBannerInfoTaskData", "ITaskData", "ViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveTaskBannerView
  extends FrameLayout
  implements RecyclerHorizontalViewPager.b
{
  private String Eeu;
  public RecyclerHorizontalViewPager EuD;
  private final int EuE;
  private final long EuF;
  private volatile boolean EuG;
  private volatile int EuH;
  private final String TAG;
  private final MMHandler handler;
  public View lBX;
  public Context mContext;
  public RecyclerView.a<d> mlt;
  private LinkedList<c> vEn;
  
  public FinderLiveTaskBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(361201);
    this.EuE = 1;
    this.EuF = 5000L;
    this.TAG = "FinderLiveTaskBannerView";
    this.EuG = true;
    this.handler = new MMHandler(Looper.getMainLooper(), new FinderLiveTaskBannerView..ExternalSyntheticLambda0(this));
    init(paramContext);
    AppMethodBeat.o(361201);
  }
  
  public FinderLiveTaskBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(361208);
    this.EuE = 1;
    this.EuF = 5000L;
    this.TAG = "FinderLiveTaskBannerView";
    this.EuG = true;
    this.handler = new MMHandler(Looper.getMainLooper(), new FinderLiveTaskBannerView..ExternalSyntheticLambda0(this));
    init(paramContext);
    AppMethodBeat.o(361208);
  }
  
  private final void a(c paramc)
  {
    AppMethodBeat.i(361223);
    if (paramc == null)
    {
      AppMethodBeat.o(361223);
      return;
    }
    if ((paramc instanceof FinderLiveTaskBannerView.a))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(22748, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Long.valueOf(cn.bDw()), z.bAW(), "", ((FinderLiveTaskBannerView.a)paramc).EuI.Vyi });
      AppMethodBeat.o(361223);
      return;
    }
    com.tencent.mm.plugin.finder.utils.s locals = com.tencent.mm.plugin.finder.utils.s.GgL;
    com.tencent.mm.plugin.finder.utils.s.H(11, paramc.eBE(), this.Eeu);
    AppMethodBeat.o(361223);
  }
  
  private static final void a(FinderLiveTaskBannerView paramFinderLiveTaskBannerView)
  {
    AppMethodBeat.i(361239);
    kotlin.g.b.s.u(paramFinderLiveTaskBannerView, "this$0");
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = paramFinderLiveTaskBannerView.getPagerView();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerHorizontalViewPager, locala.aYi(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView", "handler$lambda-2$lambda-1$lambda-0", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerHorizontalViewPager.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerHorizontalViewPager, "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView", "handler$lambda-2$lambda-1$lambda-0", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;)V", "Undefined", "scrollToPosition", "(I)V");
    paramFinderLiveTaskBannerView.EuH = 0;
    paramFinderLiveTaskBannerView.startLoop();
    AppMethodBeat.o(361239);
  }
  
  private static final void a(FinderLiveTaskBannerView paramFinderLiveTaskBannerView, Message paramMessage, ah.e parame)
  {
    AppMethodBeat.i(361248);
    kotlin.g.b.s.u(paramFinderLiveTaskBannerView, "this$0");
    kotlin.g.b.s.u(parame, "$interval");
    paramFinderLiveTaskBannerView.handler.sendMessageDelayed(paramMessage, parame.aixc);
    AppMethodBeat.o(361248);
  }
  
  private static final boolean a(FinderLiveTaskBannerView paramFinderLiveTaskBannerView, Message paramMessage)
  {
    AppMethodBeat.i(361244);
    kotlin.g.b.s.u(paramFinderLiveTaskBannerView, "this$0");
    kotlin.g.b.s.u(paramMessage, "it");
    int i;
    if (paramMessage.what == paramFinderLiveTaskBannerView.EuE)
    {
      i = paramMessage.arg1;
      paramFinderLiveTaskBannerView.EuH = i;
      paramMessage = paramFinderLiveTaskBannerView.getPagerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramMessage, locala.aYi(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView", "handler$lambda-2", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;Landroid/os/Message;)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      paramMessage.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView", "handler$lambda-2", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;Landroid/os/Message;)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      paramMessage = paramFinderLiveTaskBannerView.vEn;
      if (paramMessage != null) {
        break label189;
      }
      paramMessage = null;
      paramFinderLiveTaskBannerView.a(paramMessage);
      if (paramFinderLiveTaskBannerView.EuG)
      {
        paramMessage = paramFinderLiveTaskBannerView.vEn;
        if (paramMessage != null)
        {
          if (i != paramMessage.size() - 1) {
            break label201;
          }
          paramFinderLiveTaskBannerView.getPagerView().postDelayed(new FinderLiveTaskBannerView..ExternalSyntheticLambda1(paramFinderLiveTaskBannerView), 200L);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(361244);
      return true;
      label189:
      paramMessage = (c)paramMessage.get(i);
      break;
      label201:
      paramFinderLiveTaskBannerView.startLoop();
    }
  }
  
  private final void init(final Context paramContext)
  {
    AppMethodBeat.i(361217);
    setMContext(paramContext);
    Object localObject = af.mU(paramContext).inflate(p.f.CfS, (ViewGroup)this);
    kotlin.g.b.s.s(localObject, "getInflater(context).inf…r_live_task_layout, this)");
    setRoot((View)localObject);
    localObject = getRoot().findViewById(p.e.BTf);
    kotlin.g.b.s.s(localObject, "root.findViewById(R.id.finder_live_task_list_view)");
    setPagerView((RecyclerHorizontalViewPager)localObject);
    getPagerView().setPageChangeListener((RecyclerHorizontalViewPager.b)this);
    getPagerView().setFrozeTouch(true);
    getPagerView().setHasFixedSize(false);
    localObject = new FinderLinearLayoutManager(paramContext);
    ((FinderLinearLayoutManager)localObject).GGx = 80.0F;
    ((LinearLayoutManager)localObject).bXK = 3;
    ((FinderLinearLayoutManager)localObject).setItemPrefetchEnabled(true);
    ((FinderLinearLayoutManager)localObject).setOrientation(0);
    getPagerView().setLayoutManager((RecyclerView.LayoutManager)localObject);
    setAdapter((RecyclerView.a)new e(this, paramContext));
    getPagerView().setAdapter(getAdapter());
    AppMethodBeat.o(361217);
  }
  
  private final void startLoop()
  {
    int j = 1;
    AppMethodBeat.i(361231);
    if (getVisibility() != 0)
    {
      AppMethodBeat.o(361231);
      return;
    }
    Object localObject1 = this.vEn;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.handler.removeMessages(this.EuE);
      setVisibility(8);
      AppMethodBeat.o(361231);
      return;
    }
    localObject1 = this.vEn;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() == 1)) {}
    for (i = j; i != 0; i = 0)
    {
      this.handler.removeMessages(this.EuE);
      AppMethodBeat.o(361231);
      return;
    }
    this.handler.removeMessages(this.EuE);
    int k = this.EuH + 1;
    localObject1 = this.vEn;
    ah.e locale;
    Object localObject2;
    long l;
    if (localObject1 == null)
    {
      i = 0;
      j = k;
      if (k >= i) {
        j = 0;
      }
      Log.i(this.TAG, kotlin.g.b.s.X("[startLoop] targetPosition:", Integer.valueOf(j)));
      localObject1 = this.handler.obtainMessage(this.EuE, j, 0);
      locale = new ah.e();
      localObject2 = this.vEn;
      if (localObject2 != null) {
        break label282;
      }
      l = 0L;
    }
    for (;;)
    {
      locale.aixc = l;
      if (locale.aixc == 0L) {
        locale.aixc = this.EuF;
      }
      getPagerView().post(new FinderLiveTaskBannerView..ExternalSyntheticLambda2(this, (Message)localObject1, locale));
      AppMethodBeat.o(361231);
      return;
      i = ((LinkedList)localObject1).size();
      break;
      label282:
      localObject2 = (c)((LinkedList)localObject2).get(j);
      if (localObject2 == null) {
        l = 0L;
      } else {
        l = ((c)localObject2).eBF();
      }
    }
  }
  
  public final void aE(int paramInt, boolean paramBoolean) {}
  
  public final RecyclerView.a<d> getAdapter()
  {
    AppMethodBeat.i(361309);
    RecyclerView.a locala = this.mlt;
    if (locala != null)
    {
      AppMethodBeat.o(361309);
      return locala;
    }
    kotlin.g.b.s.bIx("adapter");
    AppMethodBeat.o(361309);
    return null;
  }
  
  public final String getGameAppId()
  {
    return this.Eeu;
  }
  
  public final Context getMContext()
  {
    AppMethodBeat.i(361323);
    Context localContext = this.mContext;
    if (localContext != null)
    {
      AppMethodBeat.o(361323);
      return localContext;
    }
    kotlin.g.b.s.bIx("mContext");
    AppMethodBeat.o(361323);
    return null;
  }
  
  public final RecyclerHorizontalViewPager getPagerView()
  {
    AppMethodBeat.i(361283);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.EuD;
    if (localRecyclerHorizontalViewPager != null)
    {
      AppMethodBeat.o(361283);
      return localRecyclerHorizontalViewPager;
    }
    kotlin.g.b.s.bIx("pagerView");
    AppMethodBeat.o(361283);
    return null;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(361296);
    View localView = this.lBX;
    if (localView != null)
    {
      AppMethodBeat.o(361296);
      return localView;
    }
    kotlin.g.b.s.bIx("root");
    AppMethodBeat.o(361296);
    return null;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(361390);
    super.onDetachedFromWindow();
    this.handler.removeMessages(this.EuE);
    AppMethodBeat.o(361390);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(361380);
    this.EuG = true;
    startLoop();
    AppMethodBeat.o(361380);
  }
  
  public final void setAdapter(RecyclerView.a<d> parama)
  {
    AppMethodBeat.i(361315);
    kotlin.g.b.s.u(parama, "<set-?>");
    this.mlt = parama;
    AppMethodBeat.o(361315);
  }
  
  public final void setGameAppId(String paramString)
  {
    this.Eeu = paramString;
  }
  
  public final void setMContext(Context paramContext)
  {
    AppMethodBeat.i(361329);
    kotlin.g.b.s.u(paramContext, "<set-?>");
    this.mContext = paramContext;
    AppMethodBeat.o(361329);
  }
  
  public final void setPagerView(RecyclerHorizontalViewPager paramRecyclerHorizontalViewPager)
  {
    AppMethodBeat.i(361289);
    kotlin.g.b.s.u(paramRecyclerHorizontalViewPager, "<set-?>");
    this.EuD = paramRecyclerHorizontalViewPager;
    AppMethodBeat.o(361289);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(361303);
    kotlin.g.b.s.u(paramView, "<set-?>");
    this.lBX = paramView;
    AppMethodBeat.o(361303);
  }
  
  public final void setTaskInfoList(List<? extends c> paramList)
  {
    AppMethodBeat.i(361358);
    kotlin.g.b.s.u(paramList, "taskInfo");
    LinkedList localLinkedList = this.vEn;
    if (localLinkedList != null) {
      localLinkedList.clear();
    }
    this.vEn = new LinkedList();
    localLinkedList = this.vEn;
    if (localLinkedList != null) {
      localLinkedList.addAll((Collection)paramList);
    }
    paramList = this.vEn;
    kotlin.g.b.s.checkNotNull(paramList);
    if (paramList.size() > 1)
    {
      paramList = this.vEn;
      if (paramList != null)
      {
        localLinkedList = this.vEn;
        kotlin.g.b.s.checkNotNull(localLinkedList);
        i = localLinkedList.size();
        localLinkedList = this.vEn;
        kotlin.g.b.s.checkNotNull(localLinkedList);
        paramList.add(i, localLinkedList.get(0));
      }
    }
    paramList = this.vEn;
    kotlin.g.b.s.checkNotNull(paramList);
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramList = this.vEn;
        kotlin.g.b.s.checkNotNull(paramList);
        a((c)paramList.get(0));
      }
      getAdapter().bZE.notifyChanged();
      AppMethodBeat.o(361358);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(361370);
    this.EuG = false;
    this.handler.removeMessages(this.EuE);
    AppMethodBeat.o(361370);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$GameActivityBannerInfoTaskData;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$ITaskData;", "data", "Lcom/tencent/mm/protocal/protobuf/GameActivityBannerInfo;", "interval", "", "(Lcom/tencent/mm/protocal/protobuf/GameActivityBannerInfo;J)V", "getData", "()Lcom/tencent/mm/protocal/protobuf/GameActivityBannerInfo;", "getInterval", "()J", "getActivityId", "", "getH5Url", "getIconUrl", "getRemainClickTimes", "", "getSwitchInterval", "getWording", "setRemainClickTimes", "", "value", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements FinderLiveTaskBannerView.c
  {
    private final cba EuJ;
    private final long interval;
    
    public b(cba paramcba, long paramLong)
    {
      AppMethodBeat.i(362003);
      this.EuJ = paramcba;
      this.interval = paramLong;
      AppMethodBeat.o(362003);
    }
    
    public final void Ql(int paramInt) {}
    
    public final int eBD()
    {
      return -1;
    }
    
    public final String eBE()
    {
      return this.EuJ.Vyi;
    }
    
    public final long eBF()
    {
      return this.interval;
    }
    
    public final String getH5Url()
    {
      return this.EuJ.VHT;
    }
    
    public final String getIconUrl()
    {
      return this.EuJ.pic_url;
    }
    
    public final String getWording()
    {
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$ITaskData;", "", "getActivityId", "", "getH5Url", "getIconUrl", "getRemainClickTimes", "", "getSwitchInterval", "", "getWording", "setRemainClickTimes", "", "value", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void Ql(int paramInt);
    
    public abstract int eBD();
    
    public abstract String eBE();
    
    public abstract long eBF();
    
    public abstract String getH5Url();
    
    public abstract String getIconUrl();
    
    public abstract String getWording();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends RecyclerView.v
  {
    public d()
    {
      super();
      AppMethodBeat.i(362011);
      AppMethodBeat.o(362011);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$init$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$ViewHolder;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.a<FinderLiveTaskBannerView.d>
  {
    e(FinderLiveTaskBannerView paramFinderLiveTaskBannerView, Context paramContext) {}
    
    private static final void a(FinderLiveTaskBannerView paramFinderLiveTaskBannerView, Context paramContext, e parame, View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(362042);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderLiveTaskBannerView);
      localb.cH(paramContext);
      localb.cH(parame);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
      kotlin.g.b.s.u(paramFinderLiveTaskBannerView, "this$0");
      kotlin.g.b.s.u(paramContext, "$context");
      kotlin.g.b.s.u(parame, "this$1");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramFinderLiveTaskBannerView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(362042);
        throw paramFinderLiveTaskBannerView;
      }
      int i = ((Integer)paramView).intValue();
      paramView = FinderLiveTaskBannerView.b(paramFinderLiveTaskBannerView);
      if (paramView == null)
      {
        paramView = null;
        if (paramView == null) {
          break label553;
        }
        Log.i(FinderLiveTaskBannerView.c(paramFinderLiveTaskBannerView), " click posttion = " + i + ", reset = " + paramView.eBD() + " ，activityICon:" + paramView.getIconUrl());
        ((f)com.tencent.mm.kernel.h.ax(f.class)).a(paramContext, 4, paramView.getH5Url());
        if (!(paramView instanceof FinderLiveTaskBannerView.a)) {
          break label343;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(22748, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Long.valueOf(cn.bDw()), z.bAW(), "", paramView.eBE() });
        paramContext = paramView.eBE();
        if (paramContext != null) {
          new com.tencent.mm.plugin.finder.live.cgi.c(paramContext).bFJ();
        }
      }
      for (;;)
      {
        if (paramView.eBD() != -1) {
          break label365;
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(362042);
        return;
        paramView = (FinderLiveTaskBannerView.c)paramView.get(i);
        break;
        label343:
        paramContext = com.tencent.mm.plugin.finder.utils.s.GgL;
        com.tencent.mm.plugin.finder.utils.s.H(12, paramView.eBE(), paramFinderLiveTaskBannerView.getGameAppId());
      }
      label365:
      paramView.Ql(k.qu(paramView.eBD() - 1, 0));
      if (paramView.eBD() == 0)
      {
        paramContext = FinderLiveTaskBannerView.b(paramFinderLiveTaskBannerView);
        if (paramContext != null) {
          d.a(paramContext, (kotlin.g.a.b)FinderLiveTaskBannerView.e.a.EuL);
        }
        paramContext = FinderLiveTaskBannerView.b(paramFinderLiveTaskBannerView);
        if (paramContext == null)
        {
          paramContext = null;
          paramView = FinderLiveTaskBannerView.b(paramFinderLiveTaskBannerView);
          if (paramView != null) {
            break label525;
          }
        }
        label525:
        for (paramView = localObject1;; paramView = (FinderLiveTaskBannerView.c)paramView.getLast())
        {
          if (!kotlin.g.b.s.p(paramContext, paramView)) {
            FinderLiveTaskBannerView.d(paramFinderLiveTaskBannerView);
          }
          Log.i(FinderLiveTaskBannerView.c(paramFinderLiveTaskBannerView), "datalist after del");
          paramContext = FinderLiveTaskBannerView.b(paramFinderLiveTaskBannerView);
          if (paramContext == null) {
            break label536;
          }
          paramContext = ((Iterable)paramContext).iterator();
          while (paramContext.hasNext())
          {
            paramView = (FinderLiveTaskBannerView.c)paramContext.next();
            Log.i(FinderLiveTaskBannerView.c(paramFinderLiveTaskBannerView), String.valueOf(paramView.eBE()));
          }
          paramContext = (FinderLiveTaskBannerView.c)paramContext.getFirst();
          break;
        }
        label536:
        Log.i(FinderLiveTaskBannerView.c(paramFinderLiveTaskBannerView), "datalist after del");
        parame.bZE.notifyChanged();
      }
      label553:
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362042);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(362054);
      LinkedList localLinkedList = FinderLiveTaskBannerView.b(this.EuK);
      if (localLinkedList == null)
      {
        AppMethodBeat.o(362054);
        return 0;
      }
      int i = localLinkedList.size();
      AppMethodBeat.o(362054);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveTaskBannerView
 * JD-Core Version:    0.7.0.1
 */