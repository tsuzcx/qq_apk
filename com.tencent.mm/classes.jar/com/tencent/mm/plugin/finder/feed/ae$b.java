package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.bi;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.b;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.j;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "isHasHeader", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "firstPageExposeData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "hasMore", "progressBar", "Landroid/widget/ProgressBar;", "progressContainer", "Landroid/widget/FrameLayout;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTextView", "Landroid/widget/TextView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "dismissProgress", "", "getActivity", "getFinishLoadMoreReason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "isAnim", "remainSize", "", "getPresenter", "initView", "onSelectActivity", "item", "onUserVisibleFocused", "refreshAll", "isDown", "startIndex", "incrementSize", "isHasMore", "isFirstPage", "reportExpose", "exposeData", "showRetryView", "Companion", "plugin-finder_release"})
public final class ae$b
  implements c<ae.a>
{
  public static final String TAG;
  public static final a tQJ;
  private final MMActivity activity;
  private final View contentView;
  private RecyclerView hak;
  boolean hasMore;
  ProgressBar progressBar;
  WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.l> tFp;
  RefreshLoadMoreLayout tLS;
  TextView tQE;
  FrameLayout tQF;
  public LinkedList<com.tencent.mm.view.recyclerview.k> tQG;
  private final ae.a tQH;
  private final boolean tQI;
  
  static
  {
    AppMethodBeat.i(244147);
    tQJ = new a((byte)0);
    TAG = "Finder.SelectViewCallback." + tQJ.hashCode();
    AppMethodBeat.o(244147);
  }
  
  public ae$b(MMActivity paramMMActivity, View paramView, ae.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(244146);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.tQH = parama;
    this.tQI = paramBoolean;
    AppMethodBeat.o(244146);
  }
  
  public final void af(LinkedList<com.tencent.mm.view.recyclerview.k> paramLinkedList)
  {
    AppMethodBeat.i(244144);
    if (paramLinkedList != null)
    {
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      while (localIterator.hasNext())
      {
        paramLinkedList = (com.tencent.mm.view.recyclerview.k)localIterator.next();
        if ((paramLinkedList.Rrp instanceof com.tencent.mm.plugin.finder.model.l))
        {
          paramLinkedList = paramLinkedList.Rrp;
          if (paramLinkedList == null)
          {
            paramLinkedList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderActivityInfoData");
            AppMethodBeat.o(244144);
            throw paramLinkedList;
          }
          Object localObject = ((com.tencent.mm.plugin.finder.model.l)paramLinkedList).tqo;
          paramLinkedList = ((aqk)localObject).contact;
          label104:
          int i;
          label116:
          long l;
          if (paramLinkedList != null)
          {
            paramLinkedList = paramLinkedList.username;
            if (!p.j(paramLinkedList, z.aUg())) {
              break label182;
            }
            i = 1;
            paramLinkedList = com.tencent.mm.plugin.finder.report.k.vfA;
            l = i;
            paramLinkedList = com.tencent.mm.plugin.finder.report.k.vfA;
            localObject = com.tencent.mm.plugin.finder.report.k.Fg(((aqk)localObject).twd);
            paramLinkedList = FinderReporterUIC.wzC;
            paramLinkedList = FinderReporterUIC.a.fH((Context)this.activity);
            if (paramLinkedList == null) {
              break label187;
            }
          }
          label182:
          label187:
          for (paramLinkedList = paramLinkedList.dIx();; paramLinkedList = null)
          {
            com.tencent.mm.plugin.finder.report.k.a(l, "1", 4L, (String)localObject, paramLinkedList);
            break;
            paramLinkedList = null;
            break label104;
            i = 0;
            break label116;
          }
        }
      }
      AppMethodBeat.o(244144);
      return;
    }
    AppMethodBeat.o(244144);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(244143);
    Object localObject = this.contentView.findViewById(2131307118);
    p.g(localObject, "contentView.findViewById(R.id.rl_layout)");
    this.tLS = ((RefreshLoadMoreLayout)localObject);
    localObject = this.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    int i = (int)localContext.getResources().getDimension(2131166379);
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setLimitTopRequest(i - (int)localContext.getResources().getDimension(2131165281));
    localObject = this.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    i = (int)localContext.getResources().getDimension(2131165310);
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setRefreshTargetY(i - (int)localContext.getResources().getDimension(2131166379));
    localObject = this.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setDamping(1.85F);
    localObject = this.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setEnablePullDownHeader(false);
    ((RefreshLoadMoreLayout)localObject).setActionCallback((RefreshLoadMoreLayout.a)new b((RefreshLoadMoreLayout)localObject, this));
    if (!this.tQI)
    {
      localObject = this.tLS;
      if (localObject == null) {
        p.btv("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setSuperNestedScroll(true);
    }
    localObject = this.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setEnablePullDownHeader(false);
    localObject = this.tLS;
    if (localObject == null) {
      p.btv("rlLayout");
    }
    this.hak = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setHasFixedSize(true);
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setItemViewCacheSize(5);
    this.tFp = new WxRecyclerAdapter((f)new ae.b.c(), this.tQH.kgc, true);
    localObject = this.tFp;
    if (localObject != null) {
      ((WxRecyclerAdapter)localObject).RrA = ((com.tencent.mm.view.recyclerview.l)new d(this));
    }
    if (this.tQI)
    {
      localObject = this.tFp;
      if (localObject != null) {
        g.a((g)localObject, (g.b)new bi());
      }
    }
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.tFp);
    localObject = this.tFp;
    if (localObject != null) {
      ((g)localObject).RqP = ((g.c)new e(this));
    }
    localObject = this.contentView.findViewById(2131309182);
    p.g(localObject, "contentView.findViewById(R.id.tips_loading)");
    this.progressBar = ((ProgressBar)localObject);
    localObject = this.contentView.findViewById(2131309185);
    p.g(localObject, "contentView.findViewById(R.id.tips_retry)");
    this.tQE = ((TextView)localObject);
    localObject = this.contentView.findViewById(2131306216);
    p.g(localObject, "contentView.findViewById…_loading_state_container)");
    this.tQF = ((FrameLayout)localObject);
    localObject = this.tQE;
    if (localObject == null) {
      p.btv("retryTextView");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new f(this));
    AppMethodBeat.o(244143);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$1$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, ae.b paramb) {}
    
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(244137);
      b localb = new b();
      localb.pH(paramInt);
      a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(244137);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244136);
      b localb = new b();
      localb.bm(paramc);
      a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      super.a(paramc);
      if (!ae.b.b(jdField_this)) {
        RefreshLoadMoreLayout.e(ae.b.d(jdField_this));
      }
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244136);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(244135);
      a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      if (ae.b.b(jdField_this)) {
        ae.b.c(jdField_this).na(true);
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(244135);
        return;
        this.tQK.onPreFinishLoadMoreSmooth(ae.b.dcN());
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(244138);
      b localb = new b();
      localb.bm(paramc);
      a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(244138);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.l
  {
    public final void a(RecyclerView paramRecyclerView, j paramj)
    {
      AppMethodBeat.i(244140);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramj, "data");
      if (ae.b.e(this.tQL) == null)
      {
        ae.b.a(this.tQL, paramj.Rrn);
        AppMethodBeat.o(244140);
        return;
      }
      ae.b.b(this.tQL, paramj.Rrn);
      AppMethodBeat.o(244140);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class e
    implements g.c<h>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(ae.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244142);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ae.b.f(this.tQL).setVisibility(0);
      ae.b.g(this.tQL).setVisibility(8);
      ae.b.c(this.tQL).na(false);
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(244142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae.b
 * JD-Core Version:    0.7.0.1
 */