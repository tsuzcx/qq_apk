package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.aa.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LOOP_INTERVAL", "", "SCROLL_TO_NEXT_IMG_WHAT", "TAG", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$ViewHolder;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "currentPosition", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivity;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isViewVisible", "", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "pagerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getPagerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "setPagerView", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager;)V", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "init", "", "onDetachedFromWindow", "onPageChange", "position", "isIdle", "isAuto", "resetHeadAndTail", "resume", "setTaskInfoList", "taskInfo", "", "startLoop", "stop", "ViewHolder", "plugin-finder_release"})
public final class FinderLiveTaskBannerView
  extends FrameLayout
  implements RecyclerHorizontalViewPager.b
{
  private final String TAG;
  private final MMHandler handler;
  public RecyclerView.a<FinderLiveTaskBannerView.a> jMq;
  public View jac;
  public Context mContext;
  private LinkedList<bbt> syG;
  public volatile boolean zrA;
  private volatile int zrB;
  public RecyclerHorizontalViewPager zrx;
  private final int zry;
  private final long zrz;
  
  public FinderLiveTaskBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(274803);
    this.zry = 1;
    this.zrz = 5000L;
    this.TAG = "FinderLiveTaskBannerView";
    this.zrA = true;
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new b(this));
    init(paramContext);
    AppMethodBeat.o(274803);
  }
  
  public FinderLiveTaskBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(274804);
    this.zry = 1;
    this.zrz = 5000L;
    this.TAG = "FinderLiveTaskBannerView";
    this.zrA = true;
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new b(this));
    init(paramContext);
    AppMethodBeat.o(274804);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(274796);
    this.mContext = paramContext;
    Object localObject = ad.kS(paramContext).inflate(b.g.finder_live_task_layout, (ViewGroup)this);
    p.j(localObject, "MMLayoutInflater.getInfl…r_live_task_layout, this)");
    this.jac = ((View)localObject);
    localObject = this.jac;
    if (localObject == null) {
      p.bGy("root");
    }
    localObject = ((View)localObject).findViewById(b.f.finder_live_task_list_view);
    p.j(localObject, "root.findViewById(R.id.finder_live_task_list_view)");
    this.zrx = ((RecyclerHorizontalViewPager)localObject);
    localObject = this.zrx;
    if (localObject == null) {
      p.bGy("pagerView");
    }
    ((RecyclerHorizontalViewPager)localObject).setPageChangeListener((RecyclerHorizontalViewPager.b)this);
    localObject = this.zrx;
    if (localObject == null) {
      p.bGy("pagerView");
    }
    ((RecyclerHorizontalViewPager)localObject).setFrozeTouch(true);
    localObject = this.zrx;
    if (localObject == null) {
      p.bGy("pagerView");
    }
    ((RecyclerHorizontalViewPager)localObject).setHasFixedSize(false);
    localObject = new FinderLinearLayoutManager(paramContext);
    ((FinderLinearLayoutManager)localObject).BdV = 80.0F;
    ((FinderLinearLayoutManager)localObject).cC(3);
    ((FinderLinearLayoutManager)localObject).setItemPrefetchEnabled(true);
    ((FinderLinearLayoutManager)localObject).setOrientation(0);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.zrx;
    if (localRecyclerHorizontalViewPager == null) {
      p.bGy("pagerView");
    }
    localRecyclerHorizontalViewPager.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jMq = ((RecyclerView.a)new FinderLiveTaskBannerView.c(this, paramContext));
    paramContext = this.zrx;
    if (paramContext == null) {
      p.bGy("pagerView");
    }
    localObject = this.jMq;
    if (localObject == null) {
      p.bGy("adapter");
    }
    paramContext.setAdapter((RecyclerView.a)localObject);
    AppMethodBeat.o(274796);
  }
  
  public final void al(int paramInt, boolean paramBoolean) {}
  
  public final RecyclerView.a<FinderLiveTaskBannerView.a> getAdapter()
  {
    AppMethodBeat.i(274791);
    RecyclerView.a locala = this.jMq;
    if (locala == null) {
      p.bGy("adapter");
    }
    AppMethodBeat.o(274791);
    return locala;
  }
  
  public final Context getMContext()
  {
    AppMethodBeat.i(274793);
    Context localContext = this.mContext;
    if (localContext == null) {
      p.bGy("mContext");
    }
    AppMethodBeat.o(274793);
    return localContext;
  }
  
  public final RecyclerHorizontalViewPager getPagerView()
  {
    AppMethodBeat.i(274786);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.zrx;
    if (localRecyclerHorizontalViewPager == null) {
      p.bGy("pagerView");
    }
    AppMethodBeat.o(274786);
    return localRecyclerHorizontalViewPager;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(274789);
    View localView = this.jac;
    if (localView == null) {
      p.bGy("root");
    }
    AppMethodBeat.o(274789);
    return localView;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(274802);
    super.onDetachedFromWindow();
    this.handler.removeMessages(this.zry);
    AppMethodBeat.o(274802);
  }
  
  public final void setAdapter(RecyclerView.a<FinderLiveTaskBannerView.a> parama)
  {
    AppMethodBeat.i(274792);
    p.k(parama, "<set-?>");
    this.jMq = parama;
    AppMethodBeat.o(274792);
  }
  
  public final void setMContext(Context paramContext)
  {
    AppMethodBeat.i(274794);
    p.k(paramContext, "<set-?>");
    this.mContext = paramContext;
    AppMethodBeat.o(274794);
  }
  
  public final void setPagerView(RecyclerHorizontalViewPager paramRecyclerHorizontalViewPager)
  {
    AppMethodBeat.i(274787);
    p.k(paramRecyclerHorizontalViewPager, "<set-?>");
    this.zrx = paramRecyclerHorizontalViewPager;
    AppMethodBeat.o(274787);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(274790);
    p.k(paramView, "<set-?>");
    this.jac = paramView;
    AppMethodBeat.o(274790);
  }
  
  public final void setTaskInfoList(List<? extends bbt> paramList)
  {
    AppMethodBeat.i(274798);
    p.k(paramList, "taskInfo");
    LinkedList localLinkedList = this.syG;
    if (localLinkedList != null) {
      localLinkedList.clear();
    }
    this.syG = new LinkedList();
    localLinkedList = this.syG;
    if (localLinkedList != null) {
      localLinkedList.addAll((Collection)paramList);
    }
    paramList = this.syG;
    if (paramList == null) {
      p.iCn();
    }
    if (paramList.size() > 1)
    {
      paramList = this.syG;
      if (paramList != null)
      {
        localLinkedList = this.syG;
        if (localLinkedList == null) {
          p.iCn();
        }
        int i = localLinkedList.size();
        localLinkedList = this.syG;
        if (localLinkedList == null) {
          p.iCn();
        }
        paramList.add(i, localLinkedList.get(0));
      }
    }
    paramList = this.jMq;
    if (paramList == null) {
      p.bGy("adapter");
    }
    paramList.notifyDataSetChanged();
    AppMethodBeat.o(274798);
  }
  
  public final void startLoop()
  {
    AppMethodBeat.i(274800);
    if (getVisibility() != 0)
    {
      AppMethodBeat.o(274800);
      return;
    }
    Object localObject1 = this.syG;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() == 0))
    {
      this.handler.removeMessages(this.zry);
      setVisibility(8);
      AppMethodBeat.o(274800);
      return;
    }
    localObject1 = this.syG;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() == 1))
    {
      this.handler.removeMessages(this.zry);
      AppMethodBeat.o(274800);
      return;
    }
    this.handler.removeMessages(this.zry);
    int k = this.zrB + 1;
    localObject1 = this.syG;
    int i;
    final aa.e locale;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((LinkedList)localObject1).size();
      int j = k;
      if (k >= i) {
        j = 0;
      }
      Log.i(this.TAG, "[startLoop] targetPosition:".concat(String.valueOf(j)));
      localObject1 = this.handler.obtainMessage(this.zry, j, 0);
      locale = new aa.e();
      localObject2 = this.syG;
      if (localObject2 == null) {
        break label310;
      }
      localObject2 = (bbt)((LinkedList)localObject2).get(j);
      if (localObject2 == null) {
        break label310;
      }
    }
    label310:
    for (long l = ((bbt)localObject2).SNA;; l = 0L)
    {
      locale.aaBB = l;
      if (locale.aaBB == 0L) {
        locale.aaBB = this.zrz;
      }
      locale.aaBB *= 1000L;
      localObject2 = this.zrx;
      if (localObject2 == null) {
        p.bGy("pagerView");
      }
      ((RecyclerHorizontalViewPager)localObject2).post((Runnable)new d(this, (Message)localObject1, locale));
      AppMethodBeat.o(274800);
      return;
      i = 0;
      break;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(274801);
    this.zrA = false;
    this.handler.removeMessages(this.zry);
    AppMethodBeat.o(274801);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    b(FinderLiveTaskBannerView paramFinderLiveTaskBannerView) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(287605);
      if (paramMessage.what == FinderLiveTaskBannerView.e(this.zrC))
      {
        final int i = paramMessage.arg1;
        FinderLiveTaskBannerView.a(this.zrC, i);
        paramMessage = this.zrC.getPagerView();
        Object localObject = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$handler$1", "handleMessage", "(Landroid/os/Message;)Z", "Undefined", "smoothScrollToPosition", "(I)V");
        paramMessage.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$handler$1", "handleMessage", "(Landroid/os/Message;)Z", "Undefined", "smoothScrollToPosition", "(I)V");
        localObject = h.IzE;
        long l = cm.bfE();
        String str = z.bdh();
        paramMessage = FinderLiveTaskBannerView.a(this.zrC);
        if (paramMessage == null) {
          break label263;
        }
        paramMessage = (bbt)paramMessage.get(i);
        if (paramMessage == null) {
          break label263;
        }
        paramMessage = paramMessage.OIw;
        ((h)localObject).a(22748, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Long.valueOf(l), str, "", paramMessage });
        if (FinderLiveTaskBannerView.f(this.zrC))
        {
          paramMessage = FinderLiveTaskBannerView.a(this.zrC);
          if (paramMessage != null)
          {
            if (i != paramMessage.size() - 1) {
              break label268;
            }
            this.zrC.getPagerView().postDelayed((Runnable)new a(this, i), 200L);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(287605);
        return true;
        label263:
        paramMessage = null;
        break;
        label268:
        FinderLiveTaskBannerView.g(this.zrC);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$handler$1$1$1"})
    static final class a
      implements Runnable
    {
      a(FinderLiveTaskBannerView.b paramb, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(286866);
        RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.zrD.zrC.getPagerView();
        com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerHorizontalViewPager, locala.aFh(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$handler$1$$special$$inlined$let$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerHorizontalViewPager.scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerHorizontalViewPager, "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$handler$1$$special$$inlined$let$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        FinderLiveTaskBannerView.a(this.zrD.zrC, 0);
        FinderLiveTaskBannerView.g(this.zrD.zrC);
        AppMethodBeat.o(286866);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderLiveTaskBannerView paramFinderLiveTaskBannerView, Message paramMessage, aa.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(262898);
      FinderLiveTaskBannerView.d(this.zrC).sendMessageDelayed(this.zrH, locale.aaBB);
      AppMethodBeat.o(262898);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveTaskBannerView
 * JD-Core Version:    0.7.0.1
 */