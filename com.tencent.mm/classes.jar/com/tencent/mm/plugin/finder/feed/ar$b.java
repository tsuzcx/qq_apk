package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.convert.cj;
import com.tencent.mm.plugin.finder.convert.cl;
import com.tencent.mm.plugin.finder.convert.cm;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.bv;
import com.tencent.mm.plugin.finder.model.l;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.b;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.mm.view.recyclerview.m;
import com.tencent.mm.view.recyclerview.n;
import com.tencent.mm.view.recyclerview.o;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "isHasHeader", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "firstPageExposeData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "hasMore", "progressBar", "Landroid/widget/ProgressBar;", "progressContainer", "Landroid/widget/FrameLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "retryTextView", "Landroid/widget/TextView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "dismissProgress", "", "getActivity", "getFinishLoadMoreReason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "isAnim", "remainSize", "", "getPresenter", "initView", "onSelectActivity", "item", "onUserVisibleFocused", "refreshAll", "isDown", "startIndex", "incrementSize", "isHasMore", "isFirstPage", "reportExpose", "exposeData", "showRetryView", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar$b
  implements c<ar.a>
{
  public static final a AYL;
  public static final String TAG;
  WxRecyclerAdapter<l> ALE;
  RefreshLoadMoreLayout ATx;
  private final ar.a AYM;
  private final boolean AYN;
  TextView AYO;
  FrameLayout AYP;
  public LinkedList<n> AYQ;
  private final MMActivity activity;
  private final View contentView;
  boolean hasMore;
  private RecyclerView mkw;
  ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(363354);
    AYL = new a((byte)0);
    TAG = s.X("Finder.SelectViewCallback.", Integer.valueOf(AYL.hashCode()));
    AppMethodBeat.o(363354);
  }
  
  public ar$b(MMActivity paramMMActivity, View paramView, ar.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(363281);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.AYM = parama;
    this.AYN = paramBoolean;
    AppMethodBeat.o(363281);
  }
  
  private static final void a(b paramb, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(363306);
    Object localObject2 = new Object();
    b localb = new b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramb, "this$0");
    localObject2 = paramb.progressBar;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("progressBar");
      paramView = null;
    }
    paramView.setVisibility(0);
    paramView = paramb.AYO;
    if (paramView == null)
    {
      s.bIx("retryTextView");
      paramView = localObject1;
    }
    for (;;)
    {
      paramView.setVisibility(8);
      paramb.AYM.pX(false);
      a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(363306);
      return;
    }
  }
  
  public final void ah(LinkedList<n> paramLinkedList)
  {
    AppMethodBeat.i(363383);
    if (paramLinkedList != null)
    {
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      while (localIterator.hasNext())
      {
        paramLinkedList = (n)localIterator.next();
        if ((paramLinkedList.agOG instanceof l))
        {
          Object localObject = ((l)paramLinkedList.agOG).AtP;
          paramLinkedList = ((awt)localObject).contact;
          label76:
          int i;
          label88:
          long l;
          if (paramLinkedList == null)
          {
            paramLinkedList = null;
            if (!s.p(paramLinkedList, com.tencent.mm.model.z.bAW())) {
              break label154;
            }
            i = 1;
            paramLinkedList = com.tencent.mm.plugin.finder.report.z.FrZ;
            l = i;
            paramLinkedList = com.tencent.mm.plugin.finder.report.z.FrZ;
            localObject = com.tencent.mm.plugin.finder.report.z.pL(((awt)localObject).ocD);
            paramLinkedList = as.GSQ;
            paramLinkedList = as.a.hu((Context)this.activity);
            if (paramLinkedList != null) {
              break label159;
            }
          }
          label154:
          label159:
          for (paramLinkedList = null;; paramLinkedList = paramLinkedList.fou())
          {
            com.tencent.mm.plugin.finder.report.z.a(l, "1", 4L, (String)localObject, paramLinkedList);
            break;
            paramLinkedList = paramLinkedList.username;
            break label76;
            i = 0;
            break label88;
          }
        }
      }
    }
    AppMethodBeat.o(363383);
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(363369);
    Object localObject1 = this.contentView.findViewById(e.e.rl_layout);
    s.s(localObject1, "contentView.findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)localObject1);
    Object localObject3 = this.ATx;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
    }
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest((int)MMApplicationContext.getContext().getResources().getDimension(e.c.finder_timeline_refresh_height) - (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_12A));
    localObject3 = this.ATx;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
    }
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY((int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_7A) - (int)MMApplicationContext.getContext().getResources().getDimension(e.c.finder_timeline_refresh_height));
    localObject3 = this.ATx;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.ATx;
    if (localObject1 == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
      ((RefreshLoadMoreLayout)localObject1).setEnablePullDownHeader(false);
      ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.b)new b(this, (RefreshLoadMoreLayout)localObject1));
      if (!this.AYN)
      {
        localObject3 = this.ATx;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("rlLayout");
          localObject1 = null;
        }
        ((RefreshLoadMoreLayout)localObject1).setSuperNestedScroll(true);
      }
      localObject3 = this.ATx;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("rlLayout");
        localObject1 = null;
      }
      ((RefreshLoadMoreLayout)localObject1).setEnablePullDownHeader(false);
      localObject3 = this.ATx;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("rlLayout");
        localObject1 = null;
      }
      this.mkw = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label616;
      }
      s.bIx("recyclerView");
      localObject1 = null;
      label297:
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      localObject3 = this.mkw;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
      }
      ((RecyclerView)localObject1).setHasFixedSize(true);
      localObject3 = this.mkw;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
      }
      ((RecyclerView)localObject1).setItemViewCacheSize(5);
      this.ALE = new WxRecyclerAdapter((g)new c(), this.AYM.pUj, true);
      localObject1 = this.ALE;
      if (localObject1 != null) {
        ((WxRecyclerAdapter)localObject1).agOS = ((o)new d(this));
      }
      if (this.AYN)
      {
        localObject1 = this.ALE;
        if (localObject1 != null) {
          i.a((i)localObject1, (i.b)new bu(e.h.finder_activity_search_hint_content));
        }
      }
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label619;
      }
      s.bIx("recyclerView");
      localObject1 = null;
      label465:
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.ALE);
      localObject1 = this.ALE;
      if (localObject1 != null) {
        ((i)localObject1).agOe = ((i.c)new e(this));
      }
      localObject1 = this.contentView.findViewById(e.e.tips_loading);
      s.s(localObject1, "contentView.findViewById(R.id.tips_loading)");
      this.progressBar = ((ProgressBar)localObject1);
      localObject1 = this.contentView.findViewById(e.e.tips_retry);
      s.s(localObject1, "contentView.findViewById(R.id.tips_retry)");
      this.AYO = ((TextView)localObject1);
      localObject1 = this.contentView.findViewById(e.e.profile_loading_state_container);
      s.s(localObject1, "contentView.findViewById…_loading_state_container)");
      this.AYP = ((FrameLayout)localObject1);
      localObject1 = this.AYO;
      if (localObject1 != null) {
        break label622;
      }
      s.bIx("retryTextView");
      localObject1 = localObject2;
    }
    label616:
    label619:
    label622:
    for (;;)
    {
      ((TextView)localObject1).setOnClickListener(new ar.b..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(363369);
      return;
      break;
      break label297;
      break label465;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$1$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RefreshLoadMoreLayout.b
  {
    b(ar.b paramb, RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363314);
      s.u(paramd, "reason");
      super.a(paramd);
      if (!ar.b.d(this.AYR))
      {
        RefreshLoadMoreLayout localRefreshLoadMoreLayout = ar.b.e(this.AYR);
        paramd = localRefreshLoadMoreLayout;
        if (localRefreshLoadMoreLayout == null)
        {
          s.bIx("rlLayout");
          paramd = null;
        }
        RefreshLoadMoreLayout.e(paramd);
      }
      AppMethodBeat.o(363314);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(363309);
      if (ar.b.d(this.AYR))
      {
        ar.b.c(this.AYR).pX(true);
        AppMethodBeat.o(363309);
        return;
      }
      this.AYS.onPreFinishLoadMoreSmooth(ar.b.ecy());
      AppMethodBeat.o(363309);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(363341);
      if (paramInt == bu.class.getName().hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new cj();
        AppMethodBeat.o(363341);
        return localObject;
      }
      if (paramInt == bv.class.getName().hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new cm();
        AppMethodBeat.o(363341);
        return localObject;
      }
      if (paramInt == l.class.getName().hashCode())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new cl();
        AppMethodBeat.o(363341);
        return localObject;
      }
      s.checkNotNull(null);
      Object localObject = new kotlin.f();
      AppMethodBeat.o(363341);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements o
  {
    d(ar.b paramb) {}
    
    public final void a(RecyclerView paramRecyclerView, m paramm)
    {
      AppMethodBeat.i(363342);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramm, "data");
      if (ar.b.b(this.AYR) == null)
      {
        ar.b.a(this.AYR, paramm.agOE);
        AppMethodBeat.o(363342);
        return;
      }
      ar.b.b(this.AYR, paramm.agOE);
      AppMethodBeat.o(363342);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements i.c<j>
  {
    e(ar.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ar.b
 * JD-Core Version:    0.7.0.1
 */