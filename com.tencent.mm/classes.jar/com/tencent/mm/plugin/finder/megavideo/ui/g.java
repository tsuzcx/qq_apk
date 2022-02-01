package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "context", "Landroid/support/v7/app/AppCompatActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "parent", "Landroid/view/View;", "(Landroid/support/v7/app/AppCompatActivity;Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;Landroid/view/View;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRootView", "getViewActionCallback", "", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "", "onViewPrepared", "refreshWhenEnter", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public class g
  implements h.b
{
  private final View hVd;
  private final AppCompatActivity uMk;
  final h.a uMy;
  private WxRecyclerView ufR;
  
  public g(AppCompatActivity paramAppCompatActivity, h.a parama, View paramView)
  {
    AppMethodBeat.i(248598);
    this.uMk = paramAppCompatActivity;
    this.uMy = parama;
    this.hVd = paramView;
    AppMethodBeat.o(248598);
  }
  
  public final void ab(ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(248595);
    p.h(paramArrayList, "data");
    Object localObject = this.hVd.findViewById(2131303834);
    p.g(localObject, "parent.findViewById(R.id.long_video_recycler_view)");
    this.ufR = ((WxRecyclerView)localObject);
    localObject = new i();
    ((i)localObject).uMB = ((b)new a(this));
    WxRecyclerView localWxRecyclerView = this.ufR;
    if (localWxRecyclerView == null) {
      p.btv("recyclerView");
    }
    ((i)localObject).f((RecyclerView)localWxRecyclerView);
    paramArrayList = new WxRecyclerAdapter(this.uMy.dce(), paramArrayList);
    localObject = this.ufR;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)paramArrayList);
    paramArrayList = this.ufR;
    if (paramArrayList == null) {
      p.btv("recyclerView");
    }
    paramArrayList.setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)this.uMk));
    paramArrayList = FinderReporterUIC.wzC;
    paramArrayList = FinderReporterUIC.a.fH((Context)this.uMk);
    if (paramArrayList != null)
    {
      paramArrayList = FinderReporterUIC.d(paramArrayList);
      if (paramArrayList != null)
      {
        localObject = this.ufR;
        if (localObject == null) {
          p.btv("recyclerView");
        }
        paramArrayList.m((RecyclerView)localObject);
      }
    }
    d.a(d.aBx(), (b)new b(this));
    AppMethodBeat.o(248595);
  }
  
  public final MMFragmentActivity dcl()
  {
    AppMethodBeat.i(248597);
    Object localObject = this.uMk;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(248597);
      throw ((Throwable)localObject);
    }
    localObject = (MMFragmentActivity)localObject;
    AppMethodBeat.o(248597);
    return localObject;
  }
  
  public boolean dct()
  {
    return true;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(248596);
    Object localObject = this.ufR;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    localObject = (RecyclerView)localObject;
    AppMethodBeat.o(248596);
    return localObject;
  }
  
  public final View getRootView()
  {
    return this.hVd;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pos", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback$initView$snapHelper$1$1"})
  static final class a
    extends q
    implements b<Integer, x>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class b
    extends q
    implements b<Void, x>
  {
    b(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.g
 * JD-Core Version:    0.7.0.1
 */