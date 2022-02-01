package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "onItemDelete", "showEmptyView", "plugin-finder_release"})
public final class aa$b
  extends b.b
{
  private final String TAG;
  
  public aa$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, false);
    AppMethodBeat.i(202042);
    this.TAG = "Finder.FinderSnsPostUIContract.ViewCallback";
    AppMethodBeat.o(202042);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(202039);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).Lvi.size();
    if ((paramInt >= 0) && (paramInt < cAP().rTS.getSize()))
    {
      al localal = (al)cAP().rTS.getDataListJustForAdapter().get(paramInt);
      if (!(localal instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(202039);
        return;
      }
      ad.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)localal).feedObject.getId() + ", pos:" + paramInt);
      if (((BaseFinderFeed)localal).feedObject.isPostFinish())
      {
        parama = com.tencent.mm.plugin.finder.utils.m.sLy;
        m.a.a(this.fLP, (BaseFinderFeed)localal, 5, 4);
        paramView = this.fLP;
        parama = paramView;
        if (!(paramView instanceof FinderNewUIC)) {
          parama = null;
        }
        parama = (FinderNewUIC)parama;
        if (parama != null) {
          parama.sft = true;
        }
        parama = com.tencent.mm.plugin.finder.report.m.spK;
        parama = com.tencent.mm.ui.component.a.KiD;
        paramView = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fLP).get(FinderReporterUIC.class)).sessionId;
        parama = paramView;
        if (paramView == null) {
          parama = "";
        }
        com.tencent.mm.plugin.finder.report.m.a(parama, 3, null, false, false, ((BaseFinderFeed)localal).feedObject.getId(), 28);
        AppMethodBeat.o(202039);
        return;
      }
      t.makeText((Context)this.fLP, 2131766983, 0).show();
    }
    AppMethodBeat.o(202039);
  }
  
  public final void bmg()
  {
    AppMethodBeat.i(202036);
    super.bmg();
    final View localView = getEmptyView();
    if (localView != null) {}
    for (localView = localView.findViewById(2131308295); localView != null; localView = null)
    {
      localView.setVisibility(0);
      localView.findViewById(2131308293).setOnClickListener((View.OnClickListener)new a(this, localView));
      localView = this.fLP.findViewById(2131296728);
      p.g(localView, "context.findViewById<Vie….action_bar_middle_title)");
      localView.setVisibility(8);
      AppMethodBeat.o(202036);
      return;
    }
    AppMethodBeat.o(202036);
  }
  
  public final void cAT() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202040);
    p.h(paramc, "reason");
    AppMethodBeat.o(202040);
    return "";
  }
  
  public final void e(e parame)
  {
    AppMethodBeat.i(202038);
    p.h(parame, "holder");
    Object localObject = parame.Gd(2131299971);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = parame.Gd(2131300017);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = parame.Gd(2131296977);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = parame.Gd(2131300005);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)parame.Gd(2131299988);
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 8))
    {
      parame = parame.Gd(2131308306);
      if (parame != null)
      {
        parame.setVisibility(8);
        AppMethodBeat.o(202038);
        return;
      }
      AppMethodBeat.o(202038);
      return;
    }
    localObject = parame.Gd(2131308306);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      Context localContext = parame.getContext();
      p.g(localContext, "holder.context");
      ((View)localObject).setBackgroundColor(localContext.getResources().getColor(2131099728));
    }
    parame = (TextView)parame.Gd(2131299988);
    if (parame != null)
    {
      parame.setTextColor(-1);
      AppMethodBeat.o(202038);
      return;
    }
    AppMethodBeat.o(202038);
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(202037);
    p.h(paramContext, "context");
    paramContext = cAR().eL(paramContext);
    AppMethodBeat.o(202037);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202041);
    p.h(paramc, "reason");
    AppMethodBeat.o(202041);
    return "";
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(202035);
    View localView = this.fLP.findViewById(2131299478);
    AppMethodBeat.o(202035);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202034);
    RecyclerView.h localh = cAR().getItemDecoration();
    AppMethodBeat.o(202034);
    return localh;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(aa.b paramb, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202033);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      localObject = this.rXT.fLP;
      paramView = (View)localObject;
      if (!(localObject instanceof FinderNewUIC)) {
        paramView = null;
      }
      paramView = (FinderNewUIC)paramView;
      if (paramView != null) {
        paramView.lV(true);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202033);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa.b
 * JD-Core Version:    0.7.0.1
 */