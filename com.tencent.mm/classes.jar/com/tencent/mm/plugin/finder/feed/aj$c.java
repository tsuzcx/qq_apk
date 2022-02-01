package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.cgi.dq;
import com.tencent.mm.plugin.finder.convert.bv;
import com.tencent.mm.plugin.finder.convert.bw;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiManageUI;
import com.tencent.mm.plugin.finder.model.bq;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.RefreshLoadMoreLayout.d<Ljava.lang.Object;>;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManagePresent;", "activity", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiManageUI;", "presenter", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiManageUI;Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManagePresent;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "findViewById", "T", "Landroid/view/View;", "id", "", "(I)Landroid/view/View;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getEmptyView", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "handleItemDelete", "", "finderPoiData", "Lcom/tencent/mm/plugin/finder/model/FinderPoiData;", "handleNetError", "initView", "onRetryShow", "isVisible", "", "onViewPrepared", "refreshList", "loadMore", "startIndex", "increaseCount", "showEmptyView", "showPopupMenu", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "anchor", "startLoadingByInit", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj$c
  implements c<aj.b>
{
  public WxRecyclerAdapter<?> ALE;
  public RefreshLoadMoreLayout ATx;
  public final FinderPoiManageUI AXG;
  public final aj.b AXH;
  public com.tencent.mm.ui.widget.b.a vEV;
  
  public aj$c(FinderPoiManageUI paramFinderPoiManageUI, aj.b paramb)
  {
    AppMethodBeat.i(363550);
    this.AXG = paramFinderPoiManageUI;
    this.AXH = paramb;
    AppMethodBeat.o(363550);
  }
  
  private static final void a(c paramc, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(363559);
    kotlin.g.b.s.u(paramc, "this$0");
    paramContextMenu.add(0, 10002, 0, (CharSequence)paramc.AXG.getString(e.h.finder_poi_delete));
    AppMethodBeat.o(363559);
  }
  
  private static final void a(c paramc, bq parambq, RecyclerView.a parama, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(363574);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(parambq, "$finderPoiData");
    kotlin.g.b.s.u(parama, "$adapter");
    Object localObject;
    if (paramMenuItem.getItemId() == 10002)
    {
      paramMenuItem = parambq.EDw.id;
      localObject = (CharSequence)paramMenuItem;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label272;
      }
      paramInt2 = 1;
      if (paramInt2 == 0)
      {
        localObject = paramc.AXH;
        kotlin.g.b.s.u(paramMenuItem, "poiId");
        paramMenuItem = new dq(((aj.b)localObject).username, paramMenuItem);
        com.tencent.mm.kernel.h.aZW().a((p)paramMenuItem, 0);
      }
      paramMenuItem = parambq.EDw.ZEH;
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.abEh;
        if (paramMenuItem != null)
        {
          localObject = paramMenuItem.abjy;
          if (localObject != null)
          {
            paramMenuItem = new JSONObject();
            paramMenuItem.put("poi_name", ((eee)localObject).IGU);
            localObject = z.FrZ;
            paramMenuItem = paramMenuItem.toString();
            kotlin.g.b.s.s(paramMenuItem, "kvJson.toString()");
            localObject = n.bV(paramMenuItem, ",", ";");
            paramMenuItem = as.GSQ;
            paramMenuItem = as.a.hu((Context)paramc.AXG);
            if (paramMenuItem != null) {
              break label278;
            }
          }
        }
      }
    }
    label272:
    label278:
    for (paramMenuItem = null;; paramMenuItem = paramMenuItem.fou())
    {
      z.b(1, "profile_poiMngmt_del", (String)localObject, paramMenuItem);
      if (paramc.AXH.pUj.remove(parambq)) {
        parama.fX(paramInt1);
      }
      AppMethodBeat.o(363574);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  private static final void k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(363583);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramView1, "$root");
    paramView1 = paramView1.findViewById(e.e.retry_tip);
    if (paramView1 != null) {
      paramView1.callOnClick();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(363583);
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.AXG;
  }
  
  final View getEmptyView()
  {
    AppMethodBeat.i(363636);
    View localView = this.AXG.findViewById(e.e.empty_view);
    AppMethodBeat.o(363636);
    return localView;
  }
  
  public final void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    RefreshLoadMoreLayout.d locald = null;
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = null;
    AppMethodBeat.i(363629);
    WxRecyclerAdapter localWxRecyclerAdapter;
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      localWxRecyclerAdapter = this.ALE;
      localObject = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject = null;
      }
      ((WxRecyclerAdapter)localObject).bA(paramInt1, paramInt2);
      if (!paramBoolean) {
        break label170;
      }
      locald = new RefreshLoadMoreLayout.d(0);
      locald.agJu = this.AXH.hasMore;
      locald.agJv = paramInt2;
      if (locald.agJv > 0) {
        locald.pzq = false;
      }
      localObject = this.ATx;
      if (localObject != null) {
        break label167;
      }
      kotlin.g.b.s.bIx("rlLayout");
      localObject = localRefreshLoadMoreLayout;
    }
    label167:
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject).onPreFinishLoadMoreSmooth(locald);
      AppMethodBeat.o(363629);
      return;
      localWxRecyclerAdapter = this.ALE;
      localObject = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject = null;
      }
      ((RecyclerView.a)localObject).bZE.notifyChanged();
      break;
    }
    label170:
    localRefreshLoadMoreLayout = this.ATx;
    Object localObject = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject = null;
    }
    ((RefreshLoadMoreLayout)localObject).aFV(0);
    if (!this.AXH.hasMore)
    {
      localObject = this.ATx;
      if (localObject != null) {
        break label243;
      }
      kotlin.g.b.s.bIx("rlLayout");
      localObject = locald;
    }
    label243:
    for (;;)
    {
      RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject);
      AppMethodBeat.o(363629);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(362567);
      switch (paramInt)
      {
      default: 
        localObject = av.GiL;
        av.eY("Finder.FinderPoiManageUIContract", paramInt);
        localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(362567);
        return localObject;
      case 1: 
        localObject = (f)new bw();
        AppMethodBeat.o(362567);
        return localObject;
      }
      Object localObject = (f)new bv();
      AppMethodBeat.o(362567);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i.d<j>
  {
    public c(aj.c paramc) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RefreshLoadMoreLayout.b
  {
    public d(aj.c paramc) {}
    
    private static final void a(aj.c paramc, View paramView1, View paramView2)
    {
      AppMethodBeat.i(362523);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramc);
      localb.cH(paramView1);
      localb.cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramc, "this$0");
      kotlin.g.b.s.u(paramView1, "$this_apply");
      paramView2.setVisibility(8);
      aj.c.a(paramc, false);
      paramView1 = paramView1.findViewById(e.e.progress);
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      com.tencent.threadpool.h.ahAA.bm(new aj.c.d..ExternalSyntheticLambda1(paramc));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362523);
    }
    
    private static final void b(aj.c paramc)
    {
      AppMethodBeat.i(362512);
      kotlin.g.b.s.u(paramc, "this$0");
      if (paramc.AXH.AXE)
      {
        paramc.AXH.dUL();
        AppMethodBeat.o(362512);
        return;
      }
      paramc.AXH.AyB = null;
      paramc.AXH.L(false, 2);
      AppMethodBeat.o(362512);
    }
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(362545);
      super.IH(paramInt);
      this.AXI.AXH.AyB = null;
      this.AXI.AXH.L(false, 2);
      AppMethodBeat.o(362545);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(362565);
      kotlin.g.b.s.u(paramd, "reason");
      super.a(paramd);
      if (!this.AXI.AXH.hasMore)
      {
        RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.AXI.ATx;
        paramd = localRefreshLoadMoreLayout;
        if (localRefreshLoadMoreLayout == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          paramd = null;
        }
        RefreshLoadMoreLayout.e(paramd);
      }
      AppMethodBeat.o(362565);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      Object localObject2 = null;
      AppMethodBeat.i(362553);
      kotlin.g.b.s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      View localView = this.AXI.getEmptyView();
      aj.c localc;
      Object localObject1;
      int i;
      if (localView != null)
      {
        localc = this.AXI;
        Object localObject3 = localc.ATx;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject1 = null;
        }
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView().getAdapter();
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          break label231;
        }
        localObject1 = (WxRecyclerAdapter)localObject1;
        if (paramd.agJs == -1) {
          break label278;
        }
        if (localObject1 != null) {
          break label236;
        }
        i = 0;
        label95:
        if (i > 0) {
          break label244;
        }
        localObject3 = localc.getEmptyView();
        if (localObject3 != null)
        {
          ((View)localObject3).setVisibility(0);
          localObject1 = localc.ATx;
          paramd = (RefreshLoadMoreLayout.d<Object>)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            paramd = null;
          }
          paramd.setVisibility(8);
          paramd = (TextView)((View)localObject3).findViewById(e.e.empty_tip);
          if (paramd != null) {
            paramd.setVisibility(0);
          }
          paramd = ((View)localObject3).findViewById(e.e.progress);
          if (paramd != null) {
            paramd.setVisibility(8);
          }
          paramd = ((View)localObject3).findViewById(e.e.retry_tip);
          if (paramd != null) {
            paramd.setVisibility(8);
          }
        }
      }
      label201:
      paramd = this.AXI.ATx;
      if (paramd == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramd = localObject2;
      }
      for (;;)
      {
        RefreshLoadMoreLayout.c(paramd);
        AppMethodBeat.o(362553);
        return;
        label231:
        localObject1 = null;
        break;
        label236:
        i = ((com.tencent.mm.view.recyclerview.i)localObject1).jNl();
        break label95;
        label244:
        localView.setVisibility(8);
        localObject1 = localc.ATx;
        paramd = (RefreshLoadMoreLayout.d<Object>)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          paramd = null;
        }
        paramd.setVisibility(0);
        break label201;
        label278:
        localView.setVisibility(0);
        localObject1 = localc.ATx;
        paramd = (RefreshLoadMoreLayout.d<Object>)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          paramd = null;
        }
        paramd.setVisibility(8);
        paramd = (TextView)localView.findViewById(e.e.empty_tip);
        if (paramd != null) {
          paramd.setVisibility(8);
        }
        paramd = (TextView)localView.findViewById(e.e.retry_tip);
        if (paramd != null) {
          paramd.setVisibility(0);
        }
        paramd = localView.findViewById(e.e.progress);
        if (paramd != null) {
          paramd.setVisibility(8);
        }
        aj.c.a(localc, true);
        paramd = localView.findViewById(e.e.retry_tip);
        if (paramd == null) {
          break label201;
        }
        paramd.setOnClickListener(new aj.c.d..ExternalSyntheticLambda0(localc, localView));
        break label201;
      }
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(362560);
      super.qI(paramInt);
      this.AXI.AXH.L(true, 2);
      AppMethodBeat.o(362560);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements kotlin.g.a.b<Void, ah>
  {
    public e(aj.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aj.c
 * JD-Core Version:    0.7.0.1
 */