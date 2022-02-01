package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.k;
import d.v;
import java.util.Collection;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;)V", "TAG", "", "loadingView", "Landroid/view/View;", "noResultView", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getItemSpace", "", "getPresenter", "getShowContactListSize", "contactListSize", "feedListSize", "onSearchCallback", "", "originContactListSize", "originFeedListSize", "onStartSearch", "onTextChange", "query", "MixSearchProfileAdapter", "SpacesItemDecoration", "plugin-finder_release"})
public final class g
  implements f.b
{
  final String TAG;
  RecyclerView fPw;
  MMActivity imP;
  View lZo;
  TextView qHD;
  f.a qIb;
  RefreshLoadMoreLayout quj;
  
  public g(MMActivity paramMMActivity, final f.a parama)
  {
    AppMethodBeat.i(166842);
    this.TAG = "Finder.FinderMixSearchViewCallback";
    this.imP = paramMMActivity;
    this.qIb = parama;
    Object localObject = paramMMActivity.findViewById(2131304203);
    k.g(localObject, "context.findViewById(R.id.rl_layout)");
    this.quj = ((RefreshLoadMoreLayout)localObject);
    localObject = paramMMActivity.findViewById(2131302884);
    k.g(localObject, "context.findViewById(R.id.no_result_tv)");
    this.qHD = ((TextView)localObject);
    localObject = paramMMActivity.findViewById(2131301503);
    k.g(localObject, "context.findViewById(R.id.loading_layout)");
    this.lZo = ((View)localObject);
    this.fPw = this.quj.getRecyclerView();
    localObject = new FinderStaggeredGridLayoutManager(2);
    this.fPw.setLayoutManager((RecyclerView.i)localObject);
    localObject = new a();
    this.fPw.setAdapter((RecyclerView.a)localObject);
    localObject = this.imP.getResources();
    if (localObject == null) {
      k.fvU();
    }
    localObject = new b((int)((Resources)localObject).getDimension(2131165274));
    this.fPw.b((RecyclerView.h)localObject);
    this.quj.setEnablePullDownHeader(false);
    localObject = this.quj;
    View localView = com.tencent.mm.ui.y.js((Context)paramMMActivity).inflate(2131494590, null);
    k.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    ((RefreshLoadMoreLayout)localObject).setLoadMoreFooter(localView);
    this.quj.setActionCallback((RefreshLoadMoreLayout.a)new RefreshLoadMoreLayout.a()
    {
      public final void a(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(198941);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
        super.a(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(198941);
      }
      
      public final void agP(int paramAnonymousInt)
      {
        AppMethodBeat.i(198939);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
        super.agP(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(198939);
      }
      
      public final void b(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(198940);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
        super.b(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(198940);
      }
      
      public final void bMu()
      {
        AppMethodBeat.i(166828);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        h.fmz();
        Object localObject;
        if (parama.coo())
        {
          localObject = this.qIc.quj.getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131301486);
            if (localObject != null) {
              ((TextView)localObject).setText(2131759244);
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
          AppMethodBeat.o(166828);
          return;
          localObject = this.qIc.quj.getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131301486);
            if (localObject != null) {
              ((TextView)localObject).setText(2131759245);
            }
          }
        }
      }
    });
    parama = FinderReporterUIC.Ljl;
    paramMMActivity = FinderReporterUIC.a.lB((Context)paramMMActivity);
    if (paramMMActivity != null)
    {
      paramMMActivity = FinderReporterUIC.d(paramMMActivity);
      if (paramMMActivity != null)
      {
        paramMMActivity.v(this.fPw);
        AppMethodBeat.o(166842);
        return;
      }
    }
    AppMethodBeat.o(166842);
  }
  
  private static int fw(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 3) && (paramInt2 > 0)) {
      return 4;
    }
    if (paramInt1 > 0) {
      return paramInt1 + 1;
    }
    return 0;
  }
  
  public final void cop()
  {
    AppMethodBeat.i(166841);
    this.fPw.setVisibility(8);
    this.qHD.setVisibility(8);
    this.lZo.setVisibility(0);
    RecyclerView localRecyclerView = this.fPw;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166841);
  }
  
  public final void fv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166840);
    int j = this.qIb.com().size();
    int i = this.qIb.ckL().size();
    RecyclerView.a locala;
    if ((j > 0) || (i > 0))
    {
      this.qHD.setVisibility(8);
      this.lZo.setVisibility(8);
      this.fPw.setVisibility(0);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label143;
      }
      locala = this.fPw.getAdapter();
      if (locala != null) {
        locala.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.quj.abh(0);
      AppMethodBeat.o(166840);
      return;
      this.qHD.setVisibility(0);
      this.lZo.setVisibility(8);
      this.fPw.setVisibility(8);
      break;
      label143:
      paramInt1 = fw(paramInt1, paramInt2);
      j = fw(j, i);
      locala = this.fPw.getAdapter();
      if (locala != null) {
        locala.aq(paramInt1 + paramInt2, j + i);
      }
    }
  }
  
  public final MMActivity getActivity()
  {
    return this.imP;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;)V", "VT_CONTACT_HEADER", "", "getVT_CONTACT_HEADER", "()I", "VT_CONTACT_ITEM", "getVT_CONTACT_ITEM", "VT_FEDD_PLAIN_TEXT", "getVT_FEDD_PLAIN_TEXT", "VT_FEED_HEADER", "getVT_FEED_HEADER", "VT_FEED_MEDIA", "getVT_FEED_MEDIA", "bindData", "", "holder", "position", "bindImage", "", "getItemCount", "getItemViewType", "needShowContactMore", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<RecyclerView.v>
  {
    private final int qIe = 1;
    private final int qIf = 2;
    private final int qIg = 3;
    private final int qIh = 4;
    private final int qIi = 5;
    
    private final void i(RecyclerView.v paramv, final int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(166837);
      int j = getItemViewType(paramInt);
      Object localObject;
      if (j == this.qIe)
      {
        if (paramv == null)
        {
          paramv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactHeaderHolder");
          AppMethodBeat.o(166837);
          throw paramv;
        }
        paramv = (b)paramv;
        if (this.qIc.qIb.com().size() > 3) {
          if (!((Collection)this.qIc.qIb.ckL()).isEmpty())
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label161;
            }
          }
        }
        label161:
        for (paramInt = 1;; paramInt = 0)
        {
          localObject = (View.OnClickListener)new a(this);
          k.h(localObject, "moreClickListener");
          if (paramInt == 0) {
            break label166;
          }
          paramv.qHQ.setVisibility(0);
          paramv.qHR.setVisibility(0);
          paramv.arI.setOnClickListener((View.OnClickListener)localObject);
          AppMethodBeat.o(166837);
          return;
          paramInt = 0;
          break;
        }
        label166:
        paramv.qHQ.setVisibility(8);
        paramv.qHR.setVisibility(8);
        paramv.arI.setOnClickListener(null);
        AppMethodBeat.o(166837);
        return;
      }
      if (j == this.qIf)
      {
        localObject = (aky)this.qIc.qIb.com().get(paramInt - 1);
        f.a locala = this.qIc.qIb;
        String str = ((aky)localObject).contact.username;
        k.g(str, "searchInfo.contact.username");
        locala.ab(str, paramInt, 1);
        if (paramv == null)
        {
          paramv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
          AppMethodBeat.o(166837);
          throw paramv;
        }
        c.a((c)paramv, (aky)localObject, (View.OnClickListener)new b(this, paramInt));
        AppMethodBeat.o(166837);
        return;
      }
      if (j == this.qIf)
      {
        if (paramv == null)
        {
          paramv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchFeedHeaderHolder");
          AppMethodBeat.o(166837);
          throw paramv;
        }
        paramv = (d)paramv;
        if (paramInt != 0) {}
        for (paramInt = i; paramInt != 0; paramInt = 0)
        {
          paramv.icB.setVisibility(0);
          AppMethodBeat.o(166837);
          return;
        }
        paramv.icB.setVisibility(8);
        AppMethodBeat.o(166837);
        return;
      }
      if (j == this.qIh)
      {
        localObject = (BaseFinderFeed)this.qIc.qIb.ckL().get(paramInt - g.a(this.qIc) - 1);
        this.qIc.qIb.G(((BaseFinderFeed)localObject).bMs(), paramInt);
        if (paramv == null)
        {
          paramv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.convert.FinderProfileUIMediaViewHolder");
          AppMethodBeat.o(166837);
          throw paramv;
        }
        ((com.tencent.mm.plugin.finder.convert.y)paramv).a((BaseFinderFeed)localObject, true, true, (d.g.a.a)new c(this, (BaseFinderFeed)localObject));
      }
      AppMethodBeat.o(166837);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(166835);
      k.h(paramViewGroup, "parent");
      MMActivity localMMActivity;
      if (paramInt == this.qIe)
      {
        localMMActivity = this.qIc.imP;
        if (localMMActivity == null) {
          k.fvU();
        }
        paramViewGroup = localMMActivity.getLayoutInflater().inflate(2131494066, paramViewGroup, false);
        k.g(paramViewGroup, "headerLayout");
        paramViewGroup = (RecyclerView.v)new b(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      if (paramInt == this.qIf)
      {
        localMMActivity = this.qIc.imP;
        if (localMMActivity == null) {
          k.fvU();
        }
        paramViewGroup = localMMActivity.getLayoutInflater().inflate(2131494018, paramViewGroup, false);
        k.g(paramViewGroup, "contactLayout");
        paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      if (paramInt == this.qIg)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494054, paramViewGroup, false);
        k.g(paramViewGroup, "convertView");
        paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494067, paramViewGroup, false);
      k.g(paramViewGroup, "convertView");
      paramViewGroup = (RecyclerView.v)new com.tencent.mm.plugin.finder.convert.y(paramViewGroup);
      AppMethodBeat.o(166835);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(166838);
      k.h(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(166838);
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(166836);
      k.h(paramv, "holder");
      k.h(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(166836);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166832);
      if (!((Collection)this.qIc.qIb.ckL()).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        i = g.a(this.qIc);
        int j = this.qIc.qIb.ckL().size();
        AppMethodBeat.o(166832);
        return i + j + 1;
      }
      i = g.a(this.qIc);
      AppMethodBeat.o(166832);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(166833);
      if (this.qIc.qIb == null) {
        k.fvU();
      }
      int i = g.a(this.qIc);
      if (paramInt < i)
      {
        if (paramInt == 0)
        {
          paramInt = this.qIe;
          AppMethodBeat.o(166833);
          return paramInt;
        }
        paramInt = this.qIf;
        AppMethodBeat.o(166833);
        return paramInt;
      }
      if (paramInt == i)
      {
        paramInt = this.qIg;
        AppMethodBeat.o(166833);
        return paramInt;
      }
      paramInt = this.qIh;
      AppMethodBeat.o(166833);
      return paramInt;
    }
    
    public final void k(RecyclerView.v paramv)
    {
      AppMethodBeat.i(166834);
      k.h(paramv, "holder");
      super.k(paramv);
      Object localObject = paramv.arI;
      k.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((paramv.lp() != this.qIe) && (paramv.lp() != this.qIf) && (paramv.lp() != this.qIg)) {
          break label98;
        }
      }
      label98:
      for (boolean bool = true;; bool = false)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(bool);
        AppMethodBeat.o(166834);
        return;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(g.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166829);
        this.qIj.qIc.qIb.con();
        AppMethodBeat.o(166829);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(g.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166830);
        k.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(166830);
          throw paramView;
        }
        paramView = (aky)paramView;
        this.qIj.qIc.qIb.a(paramView, paramInt);
        AppMethodBeat.o(166830);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      c(g.a parama, BaseFinderFeed paramBaseFinderFeed)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "setFeedDecoration", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public final class b
    extends RecyclerView.h
  {
    private final int qwE;
    
    public b()
    {
      int i;
      this.qwE = i;
    }
    
    private final void a(Rect paramRect, RecyclerView.v paramv)
    {
      AppMethodBeat.i(198942);
      int i = (int)(this.qwE / 2.0F);
      paramRect.top = this.qwE;
      paramv = paramv.arI;
      k.g(paramv, "holder.itemView");
      paramv = paramv.getLayoutParams();
      if ((paramv != null) && ((paramv instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if (((StaggeredGridLayoutManager.LayoutParams)paramv).mg() == 0)
        {
          paramRect.left = this.qwE;
          paramRect.right = i;
          AppMethodBeat.o(198942);
          return;
        }
        paramRect.left = i;
        paramRect.right = this.qwE;
        AppMethodBeat.o(198942);
        return;
      }
      paramRect.left = this.qwE;
      paramRect.right = this.qwE;
      AppMethodBeat.o(198942);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(166839);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRect);
      localb.be(paramView);
      localb.be(paramRecyclerView);
      localb.be(params);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroid/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V", this, localb.ado());
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(params, "state");
      int i = RecyclerView.bw(paramView);
      paramView = paramRecyclerView.bh(paramView);
      paramRecyclerView = g.this.fPw.getAdapter();
      if (paramRecyclerView == null) {
        k.fvU();
      }
      k.g(paramRecyclerView, "recyclerView.adapter!!");
      if (i != paramRecyclerView.getItemCount() - 1)
      {
        paramRecyclerView = g.this.fPw.getAdapter();
        if (paramRecyclerView == null) {
          k.fvU();
        }
        k.g(paramRecyclerView, "recyclerView.adapter!!");
        if (i != paramRecyclerView.getItemCount() - 2) {}
      }
      else
      {
        paramRect.bottom = (this.qwE * 2);
        if (g.a(g.this) != 0) {
          break label249;
        }
        if (i != 0) {
          break label234;
        }
        paramRect.right = 0;
        paramRect.top = 0;
        paramRect.left = 0;
        paramRect.bottom = 0;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroid/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V");
        AppMethodBeat.o(166839);
        return;
        paramRect.bottom = 0;
        break;
        label234:
        k.g(paramView, "holder");
        a(paramRect, paramView);
        continue;
        label249:
        if (i <= g.a(g.this))
        {
          paramRect.right = 0;
          paramRect.top = 0;
          paramRect.left = 0;
          paramRect.bottom = 0;
        }
        else
        {
          k.g(paramView, "holder");
          a(paramRect, paramView);
          if (i <= g.a(g.this) + 2) {
            paramRect.top = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.g
 * JD-Core Version:    0.7.0.1
 */