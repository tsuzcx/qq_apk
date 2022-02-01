package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.convert.ci;
import com.tencent.mm.plugin.finder.convert.ck;
import com.tencent.mm.plugin.finder.convert.cl;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.b;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.k;
import com.tencent.mm.view.recyclerview.m;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "isHasHeader", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "firstPageExposeData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "hasMore", "progressBar", "Landroid/widget/ProgressBar;", "progressContainer", "Landroid/widget/FrameLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "retryTextView", "Landroid/widget/TextView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "dismissProgress", "", "getActivity", "getFinishLoadMoreReason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "isAnim", "remainSize", "", "getPresenter", "initView", "onSelectActivity", "item", "onUserVisibleFocused", "refreshAll", "isDown", "startIndex", "incrementSize", "isHasMore", "isFirstPage", "reportExpose", "exposeData", "showRetryView", "Companion", "plugin-finder_release"})
public final class ak$b
  implements c<ak.a>
{
  public static final String TAG;
  public static final a xBz;
  private final MMActivity activity;
  private final View contentView;
  boolean hasMore;
  private RecyclerView jLl;
  ProgressBar progressBar;
  TextView xBu;
  FrameLayout xBv;
  public LinkedList<com.tencent.mm.view.recyclerview.l> xBw;
  private final ak.a xBx;
  private final boolean xBy;
  WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.l> xnR;
  RefreshLoadMoreLayout xvJ;
  
  static
  {
    AppMethodBeat.i(291762);
    xBz = new a((byte)0);
    TAG = "Finder.SelectViewCallback." + xBz.hashCode();
    AppMethodBeat.o(291762);
  }
  
  public ak$b(MMActivity paramMMActivity, View paramView, ak.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(291761);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.xBx = parama;
    this.xBy = paramBoolean;
    AppMethodBeat.o(291761);
  }
  
  public final void ad(LinkedList<com.tencent.mm.view.recyclerview.l> paramLinkedList)
  {
    AppMethodBeat.i(291759);
    if (paramLinkedList != null)
    {
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      while (localIterator.hasNext())
      {
        paramLinkedList = (com.tencent.mm.view.recyclerview.l)localIterator.next();
        if ((paramLinkedList.YSP instanceof com.tencent.mm.plugin.finder.model.l))
        {
          paramLinkedList = paramLinkedList.YSP;
          if (paramLinkedList == null)
          {
            paramLinkedList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.FinderActivityInfoData");
            AppMethodBeat.o(291759);
            throw paramLinkedList;
          }
          Object localObject = ((com.tencent.mm.plugin.finder.model.l)paramLinkedList).wWV;
          paramLinkedList = ((asg)localObject).contact;
          label104:
          int i;
          label116:
          long l;
          if (paramLinkedList != null)
          {
            paramLinkedList = paramLinkedList.username;
            if (!p.h(paramLinkedList, z.bdh())) {
              break label182;
            }
            i = 1;
            paramLinkedList = n.zWF;
            l = i;
            paramLinkedList = n.zWF;
            localObject = n.Mp(((asg)localObject).xdR);
            paramLinkedList = aj.Bnu;
            paramLinkedList = aj.a.fZ((Context)this.activity);
            if (paramLinkedList == null) {
              break label187;
            }
          }
          label182:
          label187:
          for (paramLinkedList = paramLinkedList.ekY();; paramLinkedList = null)
          {
            n.a(l, "1", 4L, (String)localObject, paramLinkedList);
            break;
            paramLinkedList = null;
            break label104;
            i = 0;
            break label116;
          }
        }
      }
      AppMethodBeat.o(291759);
      return;
    }
    AppMethodBeat.o(291759);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(291758);
    Object localObject = this.contentView.findViewById(b.f.rl_layout);
    p.j(localObject, "contentView.findViewById(R.id.rl_layout)");
    this.xvJ = ((RefreshLoadMoreLayout)localObject);
    localObject = this.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    int i = (int)localContext.getResources().getDimension(b.d.finder_timeline_refresh_height);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setLimitTopRequest(i - (int)localContext.getResources().getDimension(b.d.Edge_12A));
    localObject = this.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    i = (int)localContext.getResources().getDimension(b.d.Edge_7A);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject).setRefreshTargetY(i - (int)localContext.getResources().getDimension(b.d.finder_timeline_refresh_height));
    localObject = this.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setDamping(1.85F);
    localObject = this.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setEnablePullDownHeader(false);
    ((RefreshLoadMoreLayout)localObject).setActionCallback((RefreshLoadMoreLayout.a)new b((RefreshLoadMoreLayout)localObject, this));
    if (!this.xBy)
    {
      localObject = this.xvJ;
      if (localObject == null) {
        p.bGy("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setSuperNestedScroll(true);
    }
    localObject = this.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject).setEnablePullDownHeader(false);
    localObject = this.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    this.jLl = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setHasFixedSize(true);
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setItemViewCacheSize(5);
    this.xnR = new WxRecyclerAdapter((f)new c(), this.xBx.mXB, true);
    localObject = this.xnR;
    if (localObject != null) {
      ((WxRecyclerAdapter)localObject).YTa = ((m)new d(this));
    }
    if (this.xBy)
    {
      localObject = this.xnR;
      if (localObject != null) {
        h.a((h)localObject, (h.b)new bn(b.j.finder_activity_search_hint_content));
      }
    }
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.xnR);
    localObject = this.xnR;
    if (localObject != null) {
      ((h)localObject).YSn = ((h.c)new e(this));
    }
    localObject = this.contentView.findViewById(b.f.tips_loading);
    p.j(localObject, "contentView.findViewById(R.id.tips_loading)");
    this.progressBar = ((ProgressBar)localObject);
    localObject = this.contentView.findViewById(b.f.tips_retry);
    p.j(localObject, "contentView.findViewById(R.id.tips_retry)");
    this.xBu = ((TextView)localObject);
    localObject = this.contentView.findViewById(b.f.profile_loading_state_container);
    p.j(localObject, "contentView.findViewById…_loading_state_container)");
    this.xBv = ((FrameLayout)localObject);
    localObject = this.xBu;
    if (localObject == null) {
      p.bGy("retryTextView");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new f(this));
    AppMethodBeat.o(291758);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$1$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    b(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, ak.b paramb) {}
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(282367);
      b localb = new b();
      localb.sg(paramInt);
      a.c("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(282367);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(282366);
      b localb = new b();
      localb.bn(paramc);
      a.c("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      super.a(paramc);
      if (!ak.b.b(jdField_this)) {
        RefreshLoadMoreLayout.e(ak.b.d(jdField_this));
      }
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(282366);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(282365);
      a.b("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      if (ak.b.b(jdField_this)) {
        ak.b.c(jdField_this).ou(true);
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(282365);
        return;
        this.xBA.onPreFinishLoadMoreSmooth(ak.b.dtm());
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(282368);
      b localb = new b();
      localb.bn(paramc);
      a.c("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(282368);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class c
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(258475);
      e locale;
      if (paramInt == bn.class.getName().hashCode())
      {
        locale = (e)new ci();
        AppMethodBeat.o(258475);
        return locale;
      }
      if (paramInt == bo.class.getName().hashCode())
      {
        locale = (e)new cl();
        AppMethodBeat.o(258475);
        return locale;
      }
      if (paramInt == com.tencent.mm.plugin.finder.model.l.class.getName().hashCode())
      {
        locale = (e)new ck();
        AppMethodBeat.o(258475);
        return locale;
      }
      p.iCn();
      AppMethodBeat.o(258475);
      return null;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
  public static final class d
    implements m
  {
    public final void a(RecyclerView paramRecyclerView, k paramk)
    {
      AppMethodBeat.i(287028);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramk, "data");
      if (ak.b.e(this.xBB) == null)
      {
        ak.b.a(this.xBB, paramk.YSN);
        AppMethodBeat.o(287028);
        return;
      }
      ak.b.b(this.xBB, paramk.YSN);
      AppMethodBeat.o(287028);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class e
    implements h.c<i>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(ak.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(276990);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ak.b.f(this.xBB).setVisibility(0);
      ak.b.g(this.xBB).setVisibility(8);
      ak.b.c(this.xBB).ou(false);
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(276990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ak.b
 * JD-Core Version:    0.7.0.1
 */