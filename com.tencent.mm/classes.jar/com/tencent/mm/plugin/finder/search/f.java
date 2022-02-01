package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.aq;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.k;
import d.v;
import d.y;
import java.util.Collection;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;)V", "TAG", "", "loadingView", "Landroid/view/View;", "noResultView", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getItemSpace", "", "getPresenter", "getShowContactListSize", "contactListSize", "feedListSize", "onSearchCallback", "", "originContactListSize", "originFeedListSize", "onStartSearch", "onTextChange", "query", "MixSearchProfileAdapter", "SpacesItemDecoration", "plugin-finder_release"})
public final class f
  implements e.b
{
  final String TAG;
  RecyclerView fTr;
  View gDe;
  MMActivity iMV;
  TextView rAz;
  public e.a rBc;
  RefreshLoadMoreLayout rfT;
  
  public f(MMActivity paramMMActivity, final e.a parama)
  {
    AppMethodBeat.i(166842);
    this.TAG = "Finder.FinderMixSearchViewCallback";
    this.iMV = paramMMActivity;
    this.rBc = parama;
    Object localObject = paramMMActivity.findViewById(2131304203);
    k.g(localObject, "context.findViewById(R.id.rl_layout)");
    this.rfT = ((RefreshLoadMoreLayout)localObject);
    localObject = paramMMActivity.findViewById(2131302884);
    k.g(localObject, "context.findViewById(R.id.no_result_tv)");
    this.rAz = ((TextView)localObject);
    localObject = paramMMActivity.findViewById(2131301503);
    k.g(localObject, "context.findViewById(R.id.loading_layout)");
    this.gDe = ((View)localObject);
    this.fTr = this.rfT.getRecyclerView();
    localObject = new FinderStaggeredGridLayoutManager(2);
    this.fTr.setLayoutManager((RecyclerView.i)localObject);
    localObject = new a();
    this.fTr.setAdapter((RecyclerView.a)localObject);
    localObject = this.iMV.getResources();
    if (localObject == null) {
      k.fOy();
    }
    localObject = new b((int)((Resources)localObject).getDimension(2131165274));
    this.fTr.b((RecyclerView.h)localObject);
    this.rfT.setEnablePullDownHeader(false);
    localObject = this.rfT;
    View localView = z.jD((Context)paramMMActivity).inflate(2131494590, null);
    k.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    ((RefreshLoadMoreLayout)localObject).setLoadMoreFooter(localView);
    this.rfT.setActionCallback((RefreshLoadMoreLayout.a)new RefreshLoadMoreLayout.a()
    {
      public final void Ad(int paramAnonymousInt)
      {
        AppMethodBeat.i(202892);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
        super.Ad(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(202892);
      }
      
      public final void a(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(202894);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
        super.a(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(202894);
      }
      
      public final void b(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(202893);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
        super.b(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(202893);
      }
      
      public final void bTG()
      {
        AppMethodBeat.i(166828);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        h.fCP();
        Object localObject;
        if (parama.cxL())
        {
          localObject = this.rBd.rfT.getLoadMoreFooter();
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
          localObject = this.rBd.rfT.getLoadMoreFooter();
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
    parama = FinderReporterUIC.seQ;
    paramMMActivity = FinderReporterUIC.a.eV((Context)paramMMActivity);
    if (paramMMActivity != null)
    {
      paramMMActivity = FinderReporterUIC.d(paramMMActivity);
      if (paramMMActivity != null)
      {
        paramMMActivity.s(this.fTr);
        AppMethodBeat.o(166842);
        return;
      }
    }
    AppMethodBeat.o(166842);
  }
  
  private static int fA(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 3) && (paramInt2 > 0)) {
      return 4;
    }
    if (paramInt1 > 0) {
      return paramInt1 + 1;
    }
    return 0;
  }
  
  public final void cxM()
  {
    AppMethodBeat.i(166841);
    this.fTr.setVisibility(8);
    this.rAz.setVisibility(8);
    this.gDe.setVisibility(0);
    RecyclerView localRecyclerView = this.fTr;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166841);
  }
  
  public final void fz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166840);
    int j = this.rBc.cxJ().size();
    int i = this.rBc.csC().size();
    RecyclerView.a locala;
    if ((j > 0) || (i > 0))
    {
      this.rAz.setVisibility(8);
      this.gDe.setVisibility(8);
      this.fTr.setVisibility(0);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label143;
      }
      locala = this.fTr.getAdapter();
      if (locala != null) {
        locala.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.rfT.adz(0);
      AppMethodBeat.o(166840);
      return;
      this.rAz.setVisibility(0);
      this.gDe.setVisibility(8);
      this.fTr.setVisibility(8);
      break;
      label143:
      paramInt1 = fA(paramInt1, paramInt2);
      j = fA(j, i);
      locala = this.fTr.getAdapter();
      if (locala != null) {
        locala.aq(paramInt1 + paramInt2, j + i);
      }
    }
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;)V", "VT_CONTACT_HEADER", "", "getVT_CONTACT_HEADER", "()I", "VT_CONTACT_ITEM", "getVT_CONTACT_ITEM", "VT_FEDD_PLAIN_TEXT", "getVT_FEDD_PLAIN_TEXT", "VT_FEED_HEADER", "getVT_FEED_HEADER", "VT_FEED_MEDIA", "getVT_FEED_MEDIA", "bindData", "", "holder", "position", "bindImage", "", "getData", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedPosition", "getItemCount", "getItemViewType", "needShowContactMore", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<RecyclerView.w>
  {
    private final int rBf = 1;
    private final int rBg = 2;
    private final int rBh = 3;
    private final int rBi = 4;
    private final int rBj = 5;
    
    private final void i(RecyclerView.w paramw, final int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(166837);
      int j = getItemViewType(paramInt);
      Object localObject;
      if (j == this.rBf)
      {
        if (paramw == null)
        {
          paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactHeaderHolder");
          AppMethodBeat.o(166837);
          throw paramw;
        }
        paramw = (b)paramw;
        if (this.rBd.rBc.cxJ().size() > 3) {
          if (!((Collection)this.rBd.rBc.csC()).isEmpty())
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
          paramw.rAS.setVisibility(0);
          paramw.rAT.setVisibility(0);
          paramw.asD.setOnClickListener((View.OnClickListener)localObject);
          AppMethodBeat.o(166837);
          return;
          paramInt = 0;
          break;
        }
        label166:
        paramw.rAS.setVisibility(8);
        paramw.rAT.setVisibility(8);
        paramw.asD.setOnClickListener(null);
        AppMethodBeat.o(166837);
        return;
      }
      if (j == this.rBg)
      {
        localObject = (anr)this.rBd.rBc.cxJ().get(paramInt - 1);
        e.a locala = this.rBd.rBc;
        String str = ((anr)localObject).contact.username;
        k.g(str, "searchInfo.contact.username");
        locala.Z(str, paramInt, 1);
        if (paramw == null)
        {
          paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
          AppMethodBeat.o(166837);
          throw paramw;
        }
        c.a((c)paramw, (anr)localObject, (View.OnClickListener)new b(this, paramInt));
        AppMethodBeat.o(166837);
        return;
      }
      if (j == this.rBg)
      {
        if (paramw == null)
        {
          paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchFeedHeaderHolder");
          AppMethodBeat.o(166837);
          throw paramw;
        }
        paramw = (d)paramw;
        if (paramInt != 0) {}
        for (paramInt = i; paramInt != 0; paramInt = 0)
        {
          paramw.iCJ.setVisibility(0);
          AppMethodBeat.o(166837);
          return;
        }
        paramw.iCJ.setVisibility(8);
        AppMethodBeat.o(166837);
        return;
      }
      if (j == this.rBi)
      {
        localObject = (BaseFinderFeed)this.rBd.rBc.csC().get(paramInt - f.a(this.rBd) - 1);
        this.rBd.rBc.J(((BaseFinderFeed)localObject).lx(), paramInt);
        if (paramw == null)
        {
          paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.convert.FinderProfileUIMediaViewHolder");
          AppMethodBeat.o(166837);
          throw paramw;
        }
        ((aq)paramw).a((BaseFinderFeed)localObject, true, true, (d.g.a.a)new c(this, (BaseFinderFeed)localObject));
      }
      AppMethodBeat.o(166837);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(166835);
      k.h(paramViewGroup, "parent");
      MMActivity localMMActivity;
      if (paramInt == this.rBf)
      {
        localMMActivity = this.rBd.iMV;
        if (localMMActivity == null) {
          k.fOy();
        }
        paramViewGroup = localMMActivity.getLayoutInflater().inflate(2131494066, paramViewGroup, false);
        k.g(paramViewGroup, "headerLayout");
        paramViewGroup = (RecyclerView.w)new b(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      if (paramInt == this.rBg)
      {
        localMMActivity = this.rBd.iMV;
        if (localMMActivity == null) {
          k.fOy();
        }
        paramViewGroup = localMMActivity.getLayoutInflater().inflate(2131494018, paramViewGroup, false);
        k.g(paramViewGroup, "contactLayout");
        paramViewGroup = (RecyclerView.w)new c(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      if (paramInt == this.rBh)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494054, paramViewGroup, false);
        k.g(paramViewGroup, "convertView");
        paramViewGroup = (RecyclerView.w)new d(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494067, paramViewGroup, false);
      k.g(paramViewGroup, "convertView");
      paramViewGroup = (RecyclerView.w)new aq(paramViewGroup);
      AppMethodBeat.o(166835);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(166838);
      k.h(paramw, "holder");
      i(paramw, paramInt);
      AppMethodBeat.o(166838);
    }
    
    public final void a(RecyclerView.w paramw, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(166836);
      k.h(paramw, "holder");
      k.h(paramList, "payloads");
      i(paramw, paramInt);
      AppMethodBeat.o(166836);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166832);
      if (!((Collection)this.rBd.rBc.csC()).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        i = f.a(this.rBd);
        int j = this.rBd.rBc.csC().size();
        AppMethodBeat.o(166832);
        return i + j + 1;
      }
      i = f.a(this.rBd);
      AppMethodBeat.o(166832);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(166833);
      if (this.rBd.rBc == null) {
        k.fOy();
      }
      int i = f.a(this.rBd);
      if (paramInt < i)
      {
        if (paramInt == 0)
        {
          paramInt = this.rBf;
          AppMethodBeat.o(166833);
          return paramInt;
        }
        paramInt = this.rBg;
        AppMethodBeat.o(166833);
        return paramInt;
      }
      if (paramInt == i)
      {
        paramInt = this.rBh;
        AppMethodBeat.o(166833);
        return paramInt;
      }
      paramInt = this.rBi;
      AppMethodBeat.o(166833);
      return paramInt;
    }
    
    public final void k(RecyclerView.w paramw)
    {
      AppMethodBeat.i(166834);
      k.h(paramw, "holder");
      super.k(paramw);
      Object localObject = paramw.asD;
      k.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((paramw.ly() != this.rBf) && (paramw.ly() != this.rBg) && (paramw.ly() != this.rBh)) {
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
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166829);
        this.rBk.rBd.rBc.cxK();
        AppMethodBeat.o(166829);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(f.a parama, int paramInt) {}
      
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
        paramView = (anr)paramView;
        this.rBk.rBd.rBc.a(paramView, paramInt);
        AppMethodBeat.o(166830);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(f.a parama, BaseFinderFeed paramBaseFinderFeed)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "setFeedDecoration", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public final class b
    extends RecyclerView.h
  {
    private final int rie;
    
    public b()
    {
      int i;
      this.rie = i;
    }
    
    private final void a(Rect paramRect, RecyclerView.w paramw)
    {
      AppMethodBeat.i(202895);
      int i = (int)(this.rie / 2.0F);
      paramRect.top = this.rie;
      paramw = paramw.asD;
      k.g(paramw, "holder.itemView");
      paramw = paramw.getLayoutParams();
      if ((paramw != null) && ((paramw instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if (((StaggeredGridLayoutManager.LayoutParams)paramw).mp() == 0)
        {
          paramRect.left = this.rie;
          paramRect.right = i;
          AppMethodBeat.o(202895);
          return;
        }
        paramRect.left = i;
        paramRect.right = this.rie;
        AppMethodBeat.o(202895);
        return;
      }
      paramRect.left = this.rie;
      paramRect.right = this.rie;
      AppMethodBeat.o(202895);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(166839);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRect);
      localb.bb(paramView);
      localb.bb(paramRecyclerView);
      localb.bb(paramt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroid/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V", this, localb.aeE());
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(paramt, "state");
      int i = RecyclerView.bw(paramView);
      paramView = paramRecyclerView.bh(paramView);
      paramRecyclerView = f.this.fTr.getAdapter();
      if (paramRecyclerView == null) {
        k.fOy();
      }
      k.g(paramRecyclerView, "recyclerView.adapter!!");
      if (i != paramRecyclerView.getItemCount() - 1)
      {
        paramRecyclerView = f.this.fTr.getAdapter();
        if (paramRecyclerView == null) {
          k.fOy();
        }
        k.g(paramRecyclerView, "recyclerView.adapter!!");
        if (i != paramRecyclerView.getItemCount() - 2) {}
      }
      else
      {
        paramRect.bottom = (this.rie * 2);
        if (f.a(f.this) != 0) {
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
        if (i <= f.a(f.this))
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
          if (i <= f.a(f.this) + 2) {
            paramRect.top = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.f
 * JD-Core Version:    0.7.0.1
 */