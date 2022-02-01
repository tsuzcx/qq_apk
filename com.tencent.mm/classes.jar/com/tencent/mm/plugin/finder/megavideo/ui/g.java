package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "parent", "Landroid/view/View;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;Landroid/view/View;)V", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "recyclerView", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollRecyclerView;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRootView", "getViewActionCallback", "", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "", "onViewPrepared", "refreshWhenEnter", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public class g
  implements h.b
{
  private final View kJC;
  public FinderLikeDrawer xvL;
  private final AppCompatActivity ycV;
  private OverScrollRecyclerView zyq;
  final h.a zyr;
  
  public g(AppCompatActivity paramAppCompatActivity, h.a parama, View paramView)
  {
    AppMethodBeat.i(220595);
    this.ycV = paramAppCompatActivity;
    this.zyr = parama;
    this.kJC = paramView;
    AppMethodBeat.o(220595);
  }
  
  public final void ab(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(220588);
    p.k(paramArrayList, "data");
    Object localObject1 = this.kJC.findViewById(b.f.long_video_recycler_view);
    p.j(localObject1, "parent.findViewById(R.id.long_video_recycler_view)");
    this.zyq = ((OverScrollRecyclerView)localObject1);
    localObject1 = new i();
    ((i)localObject1).zyB = ((b)new a(this));
    Object localObject2 = this.zyq;
    if (localObject2 == null) {
      p.bGy("recyclerView");
    }
    ((i)localObject1).a((RecyclerView)localObject2);
    paramArrayList = new WxRecyclerAdapter(this.zyr.dsu(), paramArrayList);
    localObject1 = this.zyq;
    if (localObject1 == null) {
      p.bGy("recyclerView");
    }
    ((OverScrollRecyclerView)localObject1).setAdapter((RecyclerView.a)paramArrayList);
    paramArrayList = this.zyq;
    if (paramArrayList == null) {
      p.bGy("recyclerView");
    }
    paramArrayList.setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)this.ycV));
    paramArrayList = aj.Bnu;
    paramArrayList = aj.a.fZ((Context)this.ycV);
    if (paramArrayList != null)
    {
      paramArrayList = aj.d(paramArrayList);
      if (paramArrayList != null)
      {
        localObject1 = this.zyq;
        if (localObject1 == null) {
          p.bGy("recyclerView");
        }
        paramArrayList.k((RecyclerView)localObject1);
      }
    }
    d.a(d.aJa(), (b)new c(this));
    paramArrayList = this.zyq;
    if (paramArrayList == null) {
      p.bGy("recyclerView");
    }
    paramArrayList.getOverScrollBehavior().zyI = ((OverScrollVerticalBehavior.b)new b(this));
    paramArrayList = FinderLikeDrawer.AYs;
    paramArrayList = (Context)this.ycV;
    localObject1 = dsB().getWindow();
    p.j(localObject1, "getActivity().window");
    localObject2 = FinderLikeDrawer.AYs;
    this.xvL = FinderLikeDrawer.a.a(paramArrayList, (Window)localObject1, FinderLikeDrawer.eiP());
    AppMethodBeat.o(220588);
  }
  
  public final MMFragmentActivity dsB()
  {
    AppMethodBeat.i(220593);
    Object localObject = this.ycV;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(220593);
      throw ((Throwable)localObject);
    }
    localObject = (MMFragmentActivity)localObject;
    AppMethodBeat.o(220593);
    return localObject;
  }
  
  public boolean dsJ()
  {
    return true;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(220590);
    Object localObject = this.zyq;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    localObject = (RecyclerView)localObject;
    AppMethodBeat.o(220590);
    return localObject;
  }
  
  public final View getRootView()
  {
    return this.kJC;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pos", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback$initView$snapHelper$1$1"})
  static final class a
    extends q
    implements b<Integer, x>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback$initView$1", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "onPullDown", "", "plugin-finder_release"})
  public static final class b
    implements OverScrollVerticalBehavior.b
  {
    public final void cdo()
    {
      AppMethodBeat.i(291694);
      this.zys.dsB().onBackPressed();
      AppMethodBeat.o(291694);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class c
    extends q
    implements b<Void, x>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.g
 * JD-Core Version:    0.7.0.1
 */