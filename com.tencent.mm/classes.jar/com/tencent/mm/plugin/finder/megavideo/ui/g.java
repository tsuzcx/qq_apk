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
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.finder.model.cc;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "parent", "Landroid/view/View;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;Landroid/view/View;)V", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "recyclerView", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollRecyclerView;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRootView", "getViewActionCallback", "", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "", "onViewPrepared", "refreshWhenEnter", "setOnItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
  implements h.b
{
  public FinderLikeDrawer ATz;
  final AppCompatActivity CCa;
  final h.a EBi;
  private OverScrollRecyclerView EBj;
  private final View nma;
  
  public g(AppCompatActivity paramAppCompatActivity, h.a parama, View paramView)
  {
    AppMethodBeat.i(342067);
    this.CCa = paramAppCompatActivity;
    this.EBi = parama;
    this.nma = paramView;
    AppMethodBeat.o(342067);
  }
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    FinderLikeDrawer.a locala = null;
    AppMethodBeat.i(342078);
    s.u(paramArrayList, "data");
    Object localObject1 = this.nma.findViewById(e.e.long_video_recycler_view);
    s.s(localObject1, "parent.findViewById(R.id.long_video_recycler_view)");
    this.EBj = ((OverScrollRecyclerView)localObject1);
    i locali = new i();
    locali.EBu = ((b)new b(this));
    Object localObject2 = this.EBj;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
    }
    locali.a((RecyclerView)localObject1);
    localObject2 = new WxRecyclerAdapter(this.EBi.dUK(), paramArrayList);
    localObject1 = this.EBj;
    paramArrayList = (ArrayList<cc>)localObject1;
    if (localObject1 == null)
    {
      s.bIx("recyclerView");
      paramArrayList = null;
    }
    paramArrayList.setAdapter((RecyclerView.a)localObject2);
    paramArrayList = this.EBj;
    if (paramArrayList == null)
    {
      s.bIx("recyclerView");
      paramArrayList = null;
      paramArrayList.setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)this.CCa));
      paramArrayList = as.GSQ;
      paramArrayList = as.a.hu((Context)this.CCa);
      if (paramArrayList != null)
      {
        localObject2 = as.b(paramArrayList);
        if (localObject2 != null)
        {
          localObject1 = this.EBj;
          paramArrayList = (ArrayList<cc>)localObject1;
          if (localObject1 == null)
          {
            s.bIx("recyclerView");
            paramArrayList = null;
          }
          ((f)localObject2).o((RecyclerView)paramArrayList);
        }
      }
      d.a(d.bbX(), (b)new c(this));
      paramArrayList = this.EBj;
      if (paramArrayList != null) {
        break label347;
      }
      s.bIx("recyclerView");
      paramArrayList = locala;
    }
    label347:
    for (;;)
    {
      paramArrayList.getOverScrollBehavior().EBB = ((OverScrollVerticalBehavior.b)new a(this));
      paramArrayList = FinderLikeDrawer.GAf;
      paramArrayList = (Context)this.CCa;
      localObject1 = ((MMFragmentActivity)this.CCa).getWindow();
      s.s(localObject1, "getActivity().window");
      locala = FinderLikeDrawer.GAf;
      paramArrayList = FinderLikeDrawer.a.a(paramArrayList, (Window)localObject1, FinderLikeDrawer.fkN());
      s.u(paramArrayList, "<set-?>");
      this.ATz = paramArrayList;
      AppMethodBeat.o(342078);
      return;
      break;
    }
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.CCa;
  }
  
  public boolean ebM()
  {
    return true;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(342086);
    OverScrollRecyclerView localOverScrollRecyclerView = this.EBj;
    Object localObject = localOverScrollRecyclerView;
    if (localOverScrollRecyclerView == null)
    {
      s.bIx("recyclerView");
      localObject = null;
    }
    localObject = (RecyclerView)localObject;
    AppMethodBeat.o(342086);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback$initView$1", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "onPullDown", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements OverScrollVerticalBehavior.b
  {
    a(g paramg) {}
    
    public final void cDL()
    {
      AppMethodBeat.i(342042);
      ((MMFragmentActivity)this.EBk.CCa).onBackPressed();
      AppMethodBeat.o(342042);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Integer, ah>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Void, ah>
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