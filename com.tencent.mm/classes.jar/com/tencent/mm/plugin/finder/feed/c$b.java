package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.finder.model.cc;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPE_FOOTER", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "()I", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "headerview", "Landroid/view/View;", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "spanCount", "getSpanCount", "setSpanCount", "(I)V", "findViewById", "T", "id", "(I)Landroid/view/View;", "getAdapter", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getRootView", "getTitleStringId", "handleLoadMoreEnd", "", "handleRefreshEnd", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isHandleRefreshEndBySelf", "needScrollData", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "onItemDelete", "onPoiOnRefreshEnd", "onRetryShow", "isVisible", "onTopicOnRefreshEnd", "onViewPrepared", "otherFullSpan", "refreshWhenEnter", "requestLoadMore", "showEmptyView", "showEmptyViewInternal", "emptyView", "showHeaderOnDataEmpty", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c$b
  implements c<c.a>
{
  private final int AJo;
  private WxRecyclerAdapter<?> ALE;
  public FinderLikeDrawer ATA;
  public c.a ATH;
  final int ATI;
  final int ATJ;
  public RecyclerView.LayoutManager ATK;
  public View ATL;
  private final boolean ATw;
  public RefreshLoadMoreLayout ATx;
  private com.tencent.mm.plugin.finder.storage.as AxD;
  final String TAG;
  protected final MMActivity lzt;
  private final int scene;
  private int spanCount;
  
  public c$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.lzt = paramMMActivity;
    this.scene = paramInt1;
    this.AJo = paramInt2;
    this.ATw = paramBoolean;
    this.TAG = "Finder.FinderBaseGridFeedUIContract.ViewCallback";
    this.spanCount = 3;
    paramMMActivity = findViewById(e.e.rl_layout);
    s.checkNotNull(paramMMActivity);
    this.ATx = ((RefreshLoadMoreLayout)paramMMActivity);
    this.ATJ = -1;
    this.AxD = ((com.tencent.mm.plugin.finder.storage.as)new ao());
  }
  
  public abstract void a(RecyclerView.a<?> parama, View paramView, int paramInt);
  
  public final void a(c.a parama)
  {
    s.u(parama, "<set-?>");
    this.ATH = parama;
  }
  
  public void ae(final ArrayList<cc> paramArrayList)
  {
    s.u(paramArrayList, "data");
    RecyclerView localRecyclerView = this.ATx.getRecyclerView();
    Object localObject = fT((Context)this.lzt);
    s.u(localObject, "<set-?>");
    this.ATK = ((RecyclerView.LayoutManager)localObject);
    localObject = FinderLikeDrawer.GAf;
    localObject = (Context)this.lzt;
    Window localWindow = this.lzt.getWindow();
    s.s(localWindow, "context.window");
    FinderLikeDrawer.a locala = FinderLikeDrawer.GAf;
    localObject = FinderLikeDrawer.a.a((Context)localObject, localWindow, FinderLikeDrawer.fkM());
    s.u(localObject, "<set-?>");
    this.ATA = ((FinderLikeDrawer)localObject);
    localObject = this.ATK;
    if (localObject != null)
    {
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
      this.ALE = ((WxRecyclerAdapter)new a(this, paramArrayList, ebL().dUK(), ebG()));
      localObject = this.ALE;
      paramArrayList = (ArrayList<cc>)localObject;
      if (localObject == null)
      {
        s.bIx("adapter");
        paramArrayList = null;
      }
      localRecyclerView.setAdapter((RecyclerView.a)paramArrayList);
      localRecyclerView.a(getItemDecoration());
      paramArrayList = this.ALE;
      if (paramArrayList != null) {
        break label378;
      }
      s.bIx("adapter");
      paramArrayList = null;
    }
    label378:
    for (;;)
    {
      paramArrayList.agOe = ((i.c)new b(this));
      this.ATL = getHeaderView();
      if (this.ATL != null)
      {
        localObject = this.ALE;
        paramArrayList = (ArrayList<cc>)localObject;
        if (localObject == null)
        {
          s.bIx("adapter");
          paramArrayList = null;
        }
        paramArrayList = (com.tencent.mm.view.recyclerview.i)paramArrayList;
        localObject = this.ATL;
        s.checkNotNull(localObject);
        com.tencent.mm.view.recyclerview.i.a(paramArrayList, (View)localObject, this.ATI);
      }
      this.ATx.setActionCallback((RefreshLoadMoreLayout.b)new c(this));
      paramArrayList = k.aeZF;
      paramArrayList = k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
      s.s(paramArrayList, "UICProvider.of(context).…rReporterUIC::class.java)");
      paramArrayList = com.tencent.mm.plugin.finder.viewmodel.component.as.b((com.tencent.mm.plugin.finder.viewmodel.component.as)paramArrayList);
      if (paramArrayList != null) {
        paramArrayList.o(localRecyclerView);
      }
      ebi();
      paramArrayList = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWk().bmg()).intValue() == 1) {
        localRecyclerView.a((RecyclerView.l)new com.tencent.mm.plugin.finder.feed.component.h(this.TAG, this.ATx));
      }
      return;
      s.bIx("finderManager");
      localObject = null;
      break;
    }
  }
  
  public abstract String b(RefreshLoadMoreLayout.d<Object> paramd);
  
  public abstract String c(RefreshLoadMoreLayout.d<Object> paramd);
  
  public void cul()
  {
    Log.i(this.TAG, "showEmptyView");
    View localView = getEmptyView();
    if (localView != null)
    {
      localView.setVisibility(0);
      Object localObject = this.ATx;
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(e.e.empty_tip);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(e.e.progress);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localView = localView.findViewById(e.e.retry_tip);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void d(RefreshLoadMoreLayout.d<Object> paramd)
  {
    s.u(paramd, "reason");
  }
  
  public com.tencent.mm.plugin.finder.storage.as dUN()
  {
    return this.AxD;
  }
  
  public abstract void dUO();
  
  public void e(RefreshLoadMoreLayout.d<Object> paramd)
  {
    s.u(paramd, "reason");
  }
  
  public final FinderLikeDrawer ebF()
  {
    FinderLikeDrawer localFinderLikeDrawer = this.ATA;
    if (localFinderLikeDrawer != null) {
      return localFinderLikeDrawer;
    }
    s.bIx("friendLikeDrawer");
    return null;
  }
  
  public boolean ebG()
  {
    return false;
  }
  
  public final int ebK()
  {
    return this.spanCount;
  }
  
  public final c.a ebL()
  {
    c.a locala = this.ATH;
    if (locala != null) {
      return locala;
    }
    s.bIx("present");
    return null;
  }
  
  public boolean ebM()
  {
    return true;
  }
  
  public boolean ebN()
  {
    return false;
  }
  
  public final void ebO()
  {
    RefreshLoadMoreLayout.d(this.ATx);
  }
  
  public void ebi()
  {
    com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new d(this));
  }
  
  public boolean f(RefreshLoadMoreLayout.d<Object> paramd)
  {
    s.u(paramd, "reason");
    return false;
  }
  
  public abstract RecyclerView.LayoutManager fT(Context paramContext);
  
  protected final <T extends View> T findViewById(int paramInt)
  {
    View localView1 = getRootView();
    if (localView1 == null) {}
    for (localView1 = null;; localView1 = localView1.findViewById(paramInt))
    {
      View localView2 = localView1;
      if (localView1 == null) {
        localView2 = this.lzt.findViewById(paramInt);
      }
      return localView2;
    }
  }
  
  public void g(RefreshLoadMoreLayout.d<Object> paramd)
  {
    s.u(paramd, "reason");
  }
  
  public final WxRecyclerAdapter<?> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter2 = this.ALE;
    WxRecyclerAdapter localWxRecyclerAdapter1 = localWxRecyclerAdapter2;
    if (localWxRecyclerAdapter2 == null)
    {
      s.bIx("adapter");
      localWxRecyclerAdapter1 = null;
    }
    return localWxRecyclerAdapter1;
  }
  
  public final int getCommentScene()
  {
    return this.AJo;
  }
  
  public abstract View getEmptyView();
  
  public abstract View getHeaderView();
  
  public abstract RecyclerView.h getItemDecoration();
  
  public View getRootView()
  {
    return null;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public void h(RefreshLoadMoreLayout.d<Object> paramd)
  {
    s.u(paramd, "reason");
  }
  
  public void pQ(boolean paramBoolean) {}
  
  public boolean t(j paramj)
  {
    s.u(paramj, "holder");
    return false;
  }
  
  public void u(j paramj)
  {
    s.u(paramj, "holder");
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "payloads", "", "", "onViewAttachedToWindow", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends WxRecyclerAdapter<cc>
  {
    a(c.b paramb, ArrayList<cc> paramArrayList, g paramg, boolean paramBoolean)
    {
      super(paramArrayList, paramBoolean);
    }
    
    public final void p(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(363757);
      s.u(paramRecyclerView, "recyclerView");
      Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject = as.a.hu((Context)this.ATM.lzt);
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.b((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject);
        if (localObject != null)
        {
          localObject = ((f)localObject).dYJ();
          if (localObject != null) {
            ((RecyclerView.l)localObject).onScrollStateChanged(paramRecyclerView, 5);
          }
        }
      }
      AppMethodBeat.o(363757);
    }
    
    public final void v(j paramj)
    {
      AppMethodBeat.i(363749);
      s.u(paramj, "holder");
      super.v(paramj);
      ViewGroup.LayoutParams localLayoutParams = paramj.caK.getLayoutParams();
      if ((localLayoutParams != null) && ((localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if ((paramj.caO == this.ATM.ATI) || (paramj.caO == this.ATM.ATJ))
        {
          ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).cbB = true;
          AppMethodBeat.o(363749);
          return;
        }
        if (this.ATM.t(paramj)) {
          ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).cbB = true;
        }
      }
      AppMethodBeat.o(363749);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {
    b(c.b paramb) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "loadMoreType", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RefreshLoadMoreLayout.b
  {
    private boolean ATC = true;
    
    c(c.b paramb) {}
    
    private static final void a(c.b paramb, View paramView1, View paramView2)
    {
      AppMethodBeat.i(363778);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(paramView1);
      localb.cH(paramView2);
      a.c("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramb, "this$0");
      s.u(paramView1, "$this_apply");
      paramView2.setVisibility(8);
      paramb.pQ(false);
      paramView1 = paramView1.findViewById(e.e.progress);
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      com.tencent.threadpool.h.ahAA.bm(new c.b.c..ExternalSyntheticLambda3(paramb));
      a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(363778);
    }
    
    private static final void b(c.b paramb)
    {
      AppMethodBeat.i(363767);
      s.u(paramb, "this$0");
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eQb().bmg()).intValue() == 3)
      {
        locald = com.tencent.mm.plugin.finder.storage.d.FAy;
        com.tencent.mm.plugin.finder.storage.d.eQb().reset();
      }
      paramb.ebL().requestRefresh();
      AppMethodBeat.o(363767);
    }
    
    private static final void c(c.b paramb)
    {
      AppMethodBeat.i(363785);
      s.u(paramb, "this$0");
      paramb.ebL().requestRefresh();
      AppMethodBeat.o(363785);
    }
    
    private static final void d(c.b paramb)
    {
      AppMethodBeat.i(363789);
      s.u(paramb, "this$0");
      paramb.ebL().bXB();
      AppMethodBeat.o(363789);
    }
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(363839);
      super.IH(paramInt);
      if (this.ATM.ebL().ALH.getSize() == 0)
      {
        View localView = this.ATM.getEmptyView();
        if (localView != null)
        {
          Object localObject = this.ATM;
          localView.setVisibility(0);
          localObject = ((c.b)localObject).ATx;
          if (localObject != null) {
            ((RefreshLoadMoreLayout)localObject).setVisibility(8);
          }
          localView = localView.findViewById(e.e.progress);
          if (localView != null) {
            localView.setVisibility(0);
          }
        }
      }
      com.tencent.threadpool.h.ahAA.bm(new c.b.c..ExternalSyntheticLambda2(this.ATM));
      AppMethodBeat.o(363839);
    }
    
    public final void ND(int paramInt)
    {
      if ((this.ATC) && (paramInt > 0)) {
        this.ATC = false;
      }
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363857);
      s.u(paramd, "reason");
      super.a(paramd);
      this.ATM.h(paramd);
      AppMethodBeat.o(363857);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363829);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      if (this.ATM.f(paramd))
      {
        Log.i(this.ATM.TAG, "onRefreshEnd handleBySelf");
        this.ATM.g(paramd);
        AppMethodBeat.o(363829);
        return;
      }
      Object localObject2 = this.ATM.getEmptyView();
      c.b localb;
      Object localObject1;
      int i;
      if (localObject2 != null)
      {
        localb = this.ATM;
        localObject1 = localb.ATx.getRecyclerView().getAdapter();
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          break label178;
        }
        localObject1 = (WxRecyclerAdapter)localObject1;
        if (paramd.agJs == -1) {
          break label329;
        }
        if (localObject1 != null) {
          break label183;
        }
        i = 0;
        label111:
        if ((i > 0) || (localb.ebN())) {
          break label199;
        }
        localObject2 = localb.TAG;
        if (localObject1 != null) {
          break label191;
        }
        i = 0;
        label136:
        Log.i((String)localObject2, s.X("onRefreshEnd showEmptyView for count:", Integer.valueOf(i)));
        localb.cul();
      }
      for (;;)
      {
        this.ATM.e(paramd);
        this.ATM.d(paramd);
        AppMethodBeat.o(363829);
        return;
        label178:
        localObject1 = null;
        break;
        label183:
        i = ((com.tencent.mm.view.recyclerview.i)localObject1).jNl();
        break label111;
        label191:
        i = ((com.tencent.mm.view.recyclerview.i)localObject1).jNl();
        break label136;
        label199:
        String str = localb.TAG;
        if (localObject1 == null) {}
        for (i = 0;; i = ((com.tencent.mm.view.recyclerview.i)localObject1).jNl())
        {
          Log.i(str, s.X("onRefreshEnd show headerView make rlLayout visible :", Integer.valueOf(i)));
          ((View)localObject2).setVisibility(8);
          localObject1 = localb.ATL;
          if (localObject1 != null)
          {
            localObject2 = (TextView)((View)localObject1).findViewById(e.e.title);
            if (localObject2 != null) {
              ((TextView)localObject2).setText((CharSequence)localb.b(paramd));
            }
            localObject1 = (TextView)((View)localObject1).findViewById(e.e.desc);
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)localb.c(paramd));
            }
          }
          localObject1 = localb.ATx;
          if (localObject1 == null) {
            break;
          }
          ((RefreshLoadMoreLayout)localObject1).setVisibility(0);
          break;
        }
        label329:
        Log.i(localb.TAG, "onRefreshEnd retry");
        ((View)localObject2).setVisibility(0);
        localObject1 = localb.ATx;
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setVisibility(8);
        }
        localObject1 = (TextView)((View)localObject2).findViewById(e.e.empty_tip);
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = (TextView)((View)localObject2).findViewById(e.e.retry_tip);
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        localObject1 = ((View)localObject2).findViewById(e.e.progress);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localb.pQ(true);
        localObject1 = ((View)localObject2).findViewById(e.e.retry_tip);
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(new c.b.c..ExternalSyntheticLambda0(localb, (View)localObject2));
        }
      }
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(363849);
      super.qI(paramInt);
      com.tencent.threadpool.h.ahAA.bm(new c.b.c..ExternalSyntheticLambda1(this.ATM));
      AppMethodBeat.o(363849);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Void, ah>
  {
    d(c.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c.b
 * JD-Core Version:    0.7.0.1
 */