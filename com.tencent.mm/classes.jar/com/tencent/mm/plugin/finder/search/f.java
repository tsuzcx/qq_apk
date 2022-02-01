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
import com.tencent.mm.plugin.finder.convert.bc;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;)V", "TAG", "", "loadingView", "Landroid/view/View;", "noResultView", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getActivity", "getItemSpace", "", "getPresenter", "getShowContactListSize", "contactListSize", "feedListSize", "notifyItemChanged", "", "position", "onSearchCallback", "originContactListSize", "originFeedListSize", "onStartSearch", "onTextChange", "query", "MixSearchProfileAdapter", "SpacesItemDecoration", "plugin-finder_release"})
public final class f
  implements e.b
{
  final String TAG;
  MMActivity fLP;
  View gWO;
  RecyclerView gmV;
  RefreshLoadMoreLayout rTF;
  TextView ssK;
  public e.a sts;
  
  public f(MMActivity paramMMActivity, final e.a parama)
  {
    AppMethodBeat.i(166842);
    this.TAG = "Finder.FinderMixSearchViewCallback";
    this.fLP = paramMMActivity;
    this.sts = parama;
    Object localObject = paramMMActivity.findViewById(2131304203);
    p.g(localObject, "context.findViewById(R.id.rl_layout)");
    this.rTF = ((RefreshLoadMoreLayout)localObject);
    localObject = paramMMActivity.findViewById(2131302884);
    p.g(localObject, "context.findViewById(R.id.no_result_tv)");
    this.ssK = ((TextView)localObject);
    localObject = paramMMActivity.findViewById(2131301503);
    p.g(localObject, "context.findViewById(R.id.loading_layout)");
    this.gWO = ((View)localObject);
    this.gmV = this.rTF.getRecyclerView();
    localObject = new FinderStaggeredGridLayoutManager(2);
    this.gmV.setLayoutManager((RecyclerView.i)localObject);
    localObject = new a();
    this.gmV.setAdapter((RecyclerView.a)localObject);
    localObject = this.fLP.getResources();
    if (localObject == null) {
      p.gfZ();
    }
    localObject = new b((int)((Resources)localObject).getDimension(2131165274));
    this.gmV.b((RecyclerView.h)localObject);
    this.rTF.setEnablePullDownHeader(false);
    localObject = this.rTF;
    View localView = com.tencent.mm.ui.z.jO((Context)paramMMActivity).inflate(2131494590, null);
    p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    ((RefreshLoadMoreLayout)localObject).setLoadMoreFooter(localView);
    this.rTF.setActionCallback((RefreshLoadMoreLayout.a)new RefreshLoadMoreLayout.a()
    {
      public final void AM(int paramAnonymousInt)
      {
        AppMethodBeat.i(203465);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
        super.AM(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(203465);
      }
      
      public final void a(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(203467);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
        super.a(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(203467);
      }
      
      public final void b(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(203466);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
        super.b(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(203466);
      }
      
      public final void bYl()
      {
        AppMethodBeat.i(166828);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        h.fUh();
        Object localObject;
        if (parama.cEI())
        {
          localObject = this.stt.rTF.getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131301486);
            if (localObject != null) {
              ((TextView)localObject).setText(2131759244);
            }
          }
          localObject = this.stt.rTF.getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131301486);
            if (localObject != null) {
              ((TextView)localObject).setVisibility(0);
            }
          }
          localObject = this.stt.rTF.getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = ((View)localObject).findViewById(2131308147);
            if (localObject != null) {
              ((View)localObject).setVisibility(8);
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
          AppMethodBeat.o(166828);
          return;
          localObject = this.stt.rTF.getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131301486);
            if (localObject != null) {
              ((TextView)localObject).setText(2131759245);
            }
          }
          localObject = this.stt.rTF.getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(2131301486);
            if (localObject != null) {
              ((TextView)localObject).setVisibility(8);
            }
          }
          localObject = this.stt.rTF.getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = ((View)localObject).findViewById(2131308147);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
          }
        }
      }
    });
    parama = FinderReporterUIC.tcM;
    paramMMActivity = FinderReporterUIC.a.eY((Context)paramMMActivity);
    if (paramMMActivity != null)
    {
      paramMMActivity = FinderReporterUIC.d(paramMMActivity);
      if (paramMMActivity != null)
      {
        paramMMActivity.s(this.gmV);
        AppMethodBeat.o(166842);
        return;
      }
    }
    AppMethodBeat.o(166842);
  }
  
  private static int fN(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 3) && (paramInt2 > 0)) {
      return 4;
    }
    if (paramInt1 > 0) {
      return paramInt1 + 1;
    }
    return 0;
  }
  
  public final void cEJ()
  {
    AppMethodBeat.i(166841);
    this.gmV.setVisibility(8);
    this.ssK.setVisibility(8);
    this.gWO.setVisibility(0);
    RecyclerView localRecyclerView = this.gmV;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback", "onStartSearch", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166841);
  }
  
  public final void cj(int paramInt)
  {
    AppMethodBeat.i(203469);
    RecyclerView.a locala = this.gmV.getAdapter();
    if (locala != null)
    {
      locala.cj(paramInt);
      AppMethodBeat.o(203469);
      return;
    }
    AppMethodBeat.o(203469);
  }
  
  public final void fM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166840);
    int j = this.sts.cEG().size();
    int i = this.sts.cyt().size();
    RecyclerView.a locala;
    if ((j > 0) || (i > 0))
    {
      this.ssK.setVisibility(8);
      this.gWO.setVisibility(8);
      this.gmV.setVisibility(0);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label143;
      }
      locala = this.gmV.getAdapter();
      if (locala != null) {
        locala.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.rTF.afZ(0);
      AppMethodBeat.o(166840);
      return;
      this.ssK.setVisibility(0);
      this.gWO.setVisibility(8);
      this.gmV.setVisibility(8);
      break;
      label143:
      paramInt1 = fN(paramInt1, paramInt2);
      j = fN(j, i);
      locala = this.gmV.getAdapter();
      if (locala != null) {
        locala.ar(paramInt1 + paramInt2, j + i);
      }
    }
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;)V", "VT_CONTACT_HEADER", "", "getVT_CONTACT_HEADER", "()I", "VT_CONTACT_ITEM", "getVT_CONTACT_ITEM", "VT_FEDD_PLAIN_TEXT", "getVT_FEDD_PLAIN_TEXT", "VT_FEED_HEADER", "getVT_FEED_HEADER", "VT_FEED_MEDIA", "getVT_FEED_MEDIA", "bindData", "", "holder", "position", "bindImage", "", "getData", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedPosition", "getItemCount", "getItemViewType", "needShowContactMore", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<RecyclerView.w>
  {
    private final int stv = 1;
    private final int stw = 2;
    private final int stx = 3;
    private final int sty = 4;
    private final int stz = 5;
    
    private final void i(RecyclerView.w paramw, final int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(166837);
      int j = getItemViewType(paramInt);
      Object localObject;
      if (j == this.stv)
      {
        if (paramw == null)
        {
          paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactHeaderHolder");
          AppMethodBeat.o(166837);
          throw paramw;
        }
        paramw = (b)paramw;
        if (this.stt.sts.cEG().size() > 3) {
          if (!((Collection)this.stt.sts.cyt()).isEmpty())
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
          p.h(localObject, "moreClickListener");
          if (paramInt == 0) {
            break label166;
          }
          paramw.stf.setVisibility(0);
          paramw.stg.setVisibility(0);
          paramw.auu.setOnClickListener((View.OnClickListener)localObject);
          AppMethodBeat.o(166837);
          return;
          paramInt = 0;
          break;
        }
        label166:
        paramw.stf.setVisibility(8);
        paramw.stg.setVisibility(8);
        paramw.auu.setOnClickListener(null);
        AppMethodBeat.o(166837);
        return;
      }
      if (j == this.stw)
      {
        localObject = (ard)this.stt.sts.cEG().get(paramInt - 1);
        e.a locala = this.stt.sts;
        String str = ((ard)localObject).contact.username;
        p.g(str, "searchInfo.contact.username");
        locala.ac(str, paramInt, 1);
        if (paramw == null)
        {
          paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
          AppMethodBeat.o(166837);
          throw paramw;
        }
        c.a((c)paramw, (ard)localObject, (View.OnClickListener)new b(this, paramInt));
        AppMethodBeat.o(166837);
        return;
      }
      if (j == this.stw)
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
          paramw.iVT.setVisibility(0);
          AppMethodBeat.o(166837);
          return;
        }
        paramw.iVT.setVisibility(8);
        AppMethodBeat.o(166837);
        return;
      }
      if (j == this.sty)
      {
        localObject = (BaseFinderFeed)this.stt.sts.cyt().get(paramInt - f.a(this.stt) - 1);
        this.stt.sts.L(((BaseFinderFeed)localObject).lP(), paramInt);
        if (paramw == null)
        {
          paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.convert.FinderProfileUIMediaViewHolder");
          AppMethodBeat.o(166837);
          throw paramw;
        }
        ((bc)paramw).a((BaseFinderFeed)localObject, true, true, (d.g.a.a)new c(this, (BaseFinderFeed)localObject));
      }
      AppMethodBeat.o(166837);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(166835);
      p.h(paramViewGroup, "parent");
      MMActivity localMMActivity;
      if (paramInt == this.stv)
      {
        localMMActivity = this.stt.fLP;
        if (localMMActivity == null) {
          p.gfZ();
        }
        paramViewGroup = localMMActivity.getLayoutInflater().inflate(2131494066, paramViewGroup, false);
        p.g(paramViewGroup, "headerLayout");
        paramViewGroup = (RecyclerView.w)new b(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      if (paramInt == this.stw)
      {
        localMMActivity = this.stt.fLP;
        if (localMMActivity == null) {
          p.gfZ();
        }
        paramViewGroup = localMMActivity.getLayoutInflater().inflate(2131494018, paramViewGroup, false);
        p.g(paramViewGroup, "contactLayout");
        paramViewGroup = (RecyclerView.w)new c(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      if (paramInt == this.stx)
      {
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494054, paramViewGroup, false);
        p.g(paramViewGroup, "convertView");
        paramViewGroup = (RecyclerView.w)new d(paramViewGroup);
        AppMethodBeat.o(166835);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494067, paramViewGroup, false);
      p.g(paramViewGroup, "convertView");
      paramViewGroup = (RecyclerView.w)new bc(paramViewGroup);
      AppMethodBeat.o(166835);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(166838);
      p.h(paramw, "holder");
      i(paramw, paramInt);
      AppMethodBeat.o(166838);
    }
    
    public final void a(RecyclerView.w paramw, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(166836);
      p.h(paramw, "holder");
      p.h(paramList, "payloads");
      i(paramw, paramInt);
      AppMethodBeat.o(166836);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166832);
      if (!((Collection)this.stt.sts.cyt()).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        i = f.a(this.stt);
        int j = this.stt.sts.cyt().size();
        AppMethodBeat.o(166832);
        return i + j + 1;
      }
      i = f.a(this.stt);
      AppMethodBeat.o(166832);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(166833);
      if (this.stt.sts == null) {
        p.gfZ();
      }
      int i = f.a(this.stt);
      if (paramInt < i)
      {
        if (paramInt == 0)
        {
          paramInt = this.stv;
          AppMethodBeat.o(166833);
          return paramInt;
        }
        paramInt = this.stw;
        AppMethodBeat.o(166833);
        return paramInt;
      }
      if (paramInt == i)
      {
        paramInt = this.stx;
        AppMethodBeat.o(166833);
        return paramInt;
      }
      paramInt = this.sty;
      AppMethodBeat.o(166833);
      return paramInt;
    }
    
    public final void k(RecyclerView.w paramw)
    {
      AppMethodBeat.i(166834);
      p.h(paramw, "holder");
      super.k(paramw);
      Object localObject = paramw.auu;
      p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if ((paramw.lQ() != this.stv) && (paramw.lQ() != this.stw) && (paramw.lQ() != this.stx)) {
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166829);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.stA.stt.sts.cEH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166829);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(f.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166830);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        p.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(166830);
          throw paramView;
        }
        paramView = (ard)paramView;
        this.stA.stt.sts.a(paramView, paramInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$MixSearchProfileAdapter$bindData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166830);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<d.z>
    {
      c(f.a parama, BaseFinderFeed paramBaseFinderFeed)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "(Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "setFeedDecoration", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public final class b
    extends RecyclerView.h
  {
    private final int stC;
    
    public b()
    {
      int i;
      this.stC = i;
    }
    
    private final void a(Rect paramRect, RecyclerView.w paramw)
    {
      AppMethodBeat.i(203468);
      int i = (int)(this.stC / 2.0F);
      paramRect.top = this.stC;
      paramw = paramw.auu;
      p.g(paramw, "holder.itemView");
      paramw = paramw.getLayoutParams();
      if ((paramw != null) && ((paramw instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if (((StaggeredGridLayoutManager.LayoutParams)paramw).mH() == 0)
        {
          paramRect.left = this.stC;
          paramRect.right = i;
          AppMethodBeat.o(203468);
          return;
        }
        paramRect.left = i;
        paramRect.right = this.stC;
        AppMethodBeat.o(203468);
        return;
      }
      paramRect.left = this.stC;
      paramRect.right = this.stC;
      AppMethodBeat.o(203468);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(166839);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRect);
      localb.bd(paramView);
      localb.bd(paramRecyclerView);
      localb.bd(paramt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", "com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecorationandroid/support/v7/widget/RecyclerView$ItemDecoration", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V", this, localb.ahq());
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      int i = RecyclerView.bw(paramView);
      paramView = paramRecyclerView.bh(paramView);
      paramRecyclerView = f.this.gmV.getAdapter();
      if (paramRecyclerView == null) {
        p.gfZ();
      }
      p.g(paramRecyclerView, "recyclerView.adapter!!");
      if (i != paramRecyclerView.getItemCount() - 1)
      {
        paramRecyclerView = f.this.gmV.getAdapter();
        if (paramRecyclerView == null) {
          p.gfZ();
        }
        p.g(paramRecyclerView, "recyclerView.adapter!!");
        if (i != paramRecyclerView.getItemCount() - 2) {}
      }
      else
      {
        paramRect.bottom = (this.stC * 2);
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
        p.g(paramView, "holder");
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
          p.g(paramView, "holder");
          a(paramRect, paramView);
          if (i <= f.a(f.this) + 2) {
            paramRect.top = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.f
 * JD-Core Version:    0.7.0.1
 */