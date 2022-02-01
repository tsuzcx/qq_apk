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
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "onItemDelete", "showEmptyView", "plugin-finder_release"})
public final class aa$b
  extends b.b
{
  private final String TAG;
  
  public aa$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, false);
    AppMethodBeat.i(202506);
    this.TAG = "Finder.FinderSnsPostUIContract.ViewCallback";
    AppMethodBeat.o(202506);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(202503);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).LRV.size();
    if ((paramInt >= 0) && (paramInt < cCB().scw.getSize()))
    {
      am localam = (am)cCB().scw.getDataListJustForAdapter().get(paramInt);
      if (!(localam instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(202503);
        return;
      }
      ae.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)localam).feedObject.getId() + ", pos:" + paramInt);
      if (((BaseFinderFeed)localam).feedObject.isPostFinish())
      {
        parama = m.sWJ;
        m.a.a(this.fNT, (BaseFinderFeed)localam, 5, 4);
        paramView = this.fNT;
        parama = paramView;
        if (!(paramView instanceof FinderNewUIC)) {
          parama = null;
        }
        parama = (FinderNewUIC)parama;
        if (parama != null) {
          parama.som = true;
        }
        parama = n.szV;
        parama = com.tencent.mm.ui.component.a.KEX;
        paramView = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fNT).get(FinderReporterUIC.class)).sessionId;
        parama = paramView;
        if (paramView == null) {
          parama = "";
        }
        n.a(parama, 3, null, false, false, ((BaseFinderFeed)localam).feedObject.getId(), 28);
        AppMethodBeat.o(202503);
        return;
      }
      t.makeText((Context)this.fNT, 2131766983, 0).show();
    }
    AppMethodBeat.o(202503);
  }
  
  public final void bmP()
  {
    AppMethodBeat.i(202500);
    super.bmP();
    final View localView = getEmptyView();
    if (localView != null) {}
    for (localView = localView.findViewById(2131308295); localView != null; localView = null)
    {
      localView.setVisibility(0);
      localView.findViewById(2131308293).setOnClickListener((View.OnClickListener)new a(this, localView));
      localView = this.fNT.findViewById(2131296728);
      p.g(localView, "context.findViewById<Vie….action_bar_middle_title)");
      localView.setVisibility(8);
      AppMethodBeat.o(202500);
      return;
    }
    AppMethodBeat.o(202500);
  }
  
  public final void cCF() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202504);
    p.h(paramc, "reason");
    AppMethodBeat.o(202504);
    return "";
  }
  
  public final void e(e parame)
  {
    AppMethodBeat.i(202502);
    p.h(parame, "holder");
    Object localObject = parame.GD(2131299971);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = parame.GD(2131300017);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = parame.GD(2131296977);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = parame.GD(2131300005);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)parame.GD(2131299988);
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 8))
    {
      parame = parame.GD(2131308306);
      if (parame != null)
      {
        parame.setVisibility(8);
        AppMethodBeat.o(202502);
        return;
      }
      AppMethodBeat.o(202502);
      return;
    }
    localObject = parame.GD(2131308306);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      Context localContext = parame.getContext();
      p.g(localContext, "holder.context");
      ((View)localObject).setBackgroundColor(localContext.getResources().getColor(2131099728));
    }
    parame = (TextView)parame.GD(2131299988);
    if (parame != null)
    {
      parame.setTextColor(-1);
      AppMethodBeat.o(202502);
      return;
    }
    AppMethodBeat.o(202502);
  }
  
  public final RecyclerView.i eP(Context paramContext)
  {
    AppMethodBeat.i(202501);
    p.h(paramContext, "context");
    paramContext = cCD().eP(paramContext);
    AppMethodBeat.o(202501);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202505);
    p.h(paramc, "reason");
    AppMethodBeat.o(202505);
    return "";
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(202499);
    View localView = this.fNT.findViewById(2131299478);
    AppMethodBeat.o(202499);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202498);
    RecyclerView.h localh = cCD().getItemDecoration();
    AppMethodBeat.o(202498);
    return localh;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(aa.b paramb, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202497);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = this.sgE.fNT;
      paramView = (View)localObject;
      if (!(localObject instanceof FinderNewUIC)) {
        paramView = null;
      }
      paramView = (FinderNewUIC)paramView;
      if (paramView != null) {
        paramView.lV(true);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202497);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa.b
 * JD-Core Version:    0.7.0.1
 */