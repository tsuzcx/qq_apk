package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "onItemDelete", "showEmptyView", "plugin-finder_release"})
public final class af$b
  extends c.b
{
  private final String TAG;
  
  public af$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, false);
    AppMethodBeat.i(244169);
    this.TAG = "Finder.FinderSnsPostUIContract.ViewCallback";
    AppMethodBeat.o(244169);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(244166);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((g)parama).RqM.size();
    if ((paramInt >= 0) && (paramInt < dcq().tFM.getSize()))
    {
      bo localbo = (bo)dcq().tFM.getDataListJustForAdapter().get(paramInt);
      if (!(localbo instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(244166);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)localbo).feedObject.getId() + ", pos:" + paramInt);
      if (((BaseFinderFeed)localbo).feedObject.isPostFinish())
      {
        parama = s.vWt;
        s.a.a((AppCompatActivity)this.gte, (BaseFinderFeed)localbo, 5, 0, 20);
        paramView = this.gte;
        parama = paramView;
        if (!(paramView instanceof FinderSnsGridFeedUI)) {
          parama = null;
        }
        parama = (FinderSnsGridFeedUI)parama;
        if (parama != null) {
          parama.ucW = true;
        }
        parama = q.vgE;
        parama = com.tencent.mm.ui.component.a.PRN;
        paramView = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).sessionId;
        parama = paramView;
        if (paramView == null) {
          parama = "";
        }
        q.a(parama, 3, null, false, false, ((BaseFinderFeed)localbo).feedObject.getId(), 28);
        AppMethodBeat.o(244166);
        return;
      }
      u.makeText((Context)this.gte, 2131759766, 0).show();
    }
    AppMethodBeat.o(244166);
  }
  
  public final String b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244167);
    p.h(paramc, "reason");
    AppMethodBeat.o(244167);
    return "";
  }
  
  public final void bIo()
  {
    AppMethodBeat.i(244163);
    super.bIo();
    final View localView = getEmptyView();
    if (localView != null) {}
    for (localView = localView.findViewById(2131300093); localView != null; localView = null)
    {
      localView.setVisibility(0);
      localView.findViewById(2131300082).setOnClickListener((View.OnClickListener)new a(this, localView));
      localView = this.gte.findViewById(2131296368);
      p.g(localView, "context.findViewById<Vie….action_bar_middle_title)");
      localView.setVisibility(8);
      AppMethodBeat.o(244163);
      return;
    }
    AppMethodBeat.o(244163);
  }
  
  public final String c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244168);
    p.h(paramc, "reason");
    AppMethodBeat.o(244168);
    return "";
  }
  
  public final void dcv() {}
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(244164);
    p.h(paramContext, "context");
    paramContext = dcs().eS(paramContext);
    AppMethodBeat.o(244164);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(244162);
    View localView = this.gte.findViewById(2131300111);
    AppMethodBeat.o(244162);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(244161);
    RecyclerView.h localh = dcs().getItemDecoration();
    AppMethodBeat.o(244161);
    return localh;
  }
  
  public final void m(h paramh)
  {
    AppMethodBeat.i(244165);
    p.h(paramh, "holder");
    Object localObject = paramh.Mn(2131300773);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramh.Mn(2131301380);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramh.Mn(2131297096);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramh.Mn(2131300858);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)paramh.Mn(2131300801);
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 8))
    {
      paramh = paramh.Mn(2131301356);
      if (paramh != null)
      {
        paramh.setVisibility(8);
        AppMethodBeat.o(244165);
        return;
      }
      AppMethodBeat.o(244165);
      return;
    }
    localObject = paramh.Mn(2131301356);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      Context localContext = paramh.getContext();
      p.g(localContext, "holder.context");
      ((View)localObject).setBackgroundColor(localContext.getResources().getColor(2131099742));
    }
    paramh = (TextView)paramh.Mn(2131300801);
    if (paramh != null)
    {
      paramh.setTextColor(-1);
      AppMethodBeat.o(244165);
      return;
    }
    AppMethodBeat.o(244165);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(af.b paramb, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244160);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = this.tQN.gte;
      paramView = (View)localObject;
      if (!(localObject instanceof FinderSnsGridFeedUI)) {
        paramView = null;
      }
      paramView = (FinderSnsGridFeedUI)paramView;
      if (paramView != null) {
        paramView.nd(true);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(244160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.af.b
 * JD-Core Version:    0.7.0.1
 */