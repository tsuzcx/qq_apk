package com.tencent.mm.plugin.finder.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.ui.widget.a.h.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage;", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog$CustomBottomSheetPage;", "callback", "Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Callback;", "(Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Callback;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Data;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Callback;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "rootView", "Landroid/view/View;", "getView", "root", "Landroid/view/ViewGroup;", "onItemClick", "", "position", "", "data", "update", "", "", "Callback", "Companion", "Data", "DataConvert", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends h.b
{
  public static final ac.b GEA;
  private WxRecyclerAdapter<ac.c> ALE;
  private WxRecyclerView AZd;
  final a GEy;
  final ArrayList<ac.c> pUj;
  private View rootView;
  
  static
  {
    AppMethodBeat.i(344736);
    GEA = new ac.b((byte)0);
    AppMethodBeat.o(344736);
  }
  
  public ac(a parama)
  {
    AppMethodBeat.i(344711);
    this.GEy = parama;
    this.pUj = new ArrayList();
    AppMethodBeat.o(344711);
  }
  
  private static final void a(ac paramac, View paramView)
  {
    AppMethodBeat.i(344718);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramac);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramac, "this$0");
    paramac.jHR();
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344718);
  }
  
  private static final void b(ac paramac, View paramView)
  {
    AppMethodBeat.i(344726);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramac);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramac, "this$0");
    paramac.GEy.flC();
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344726);
  }
  
  public final View E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(344752);
    s.u(paramViewGroup, "root");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(p.f.CcJ, paramViewGroup, false);
    View localView = paramViewGroup.findViewById(p.e.single_select_bottom_sheet_rv);
    Object localObject = (WxRecyclerView)localView;
    this.ALE = new WxRecyclerAdapter((g)new e(this), this.pUj);
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.ALE);
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null) {
      localWxRecyclerAdapter.agOe = ((i.c)new f(this));
    }
    ((WxRecyclerView)localObject).getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localObject = ah.aiuX;
    this.AZd = ((WxRecyclerView)localView);
    ((WeImageView)paramViewGroup.findViewById(p.e.finder_live_back_btn)).setOnClickListener(new ac..ExternalSyntheticLambda0(this));
    ((WeImageView)paramViewGroup.findViewById(p.e.BMg)).setOnClickListener(new ac..ExternalSyntheticLambda1(this));
    this.rootView = paramViewGroup;
    s.s(paramViewGroup, "rootView");
    AppMethodBeat.o(344752);
    return paramViewGroup;
  }
  
  public final void hM(List<Integer> paramList)
  {
    AppMethodBeat.i(344763);
    s.u(paramList, "data");
    this.pUj.clear();
    ArrayList localArrayList = this.pUj;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(new ac.c(((Number)((Iterator)localObject).next()).intValue()));
    }
    localArrayList.addAll((Collection)paramList);
    this.pUj.add(new ac.c(0));
    paramList = this.ALE;
    if (paramList != null) {
      paramList.bZE.notifyChanged();
    }
    AppMethodBeat.o(344763);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Callback;", "", "clickHelpButton", "", "selectOther", "selectValue", "value", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void UK(int paramInt);
    
    public abstract void flB();
    
    public abstract void flC();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$DataConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Data;", "isLast", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage;Lkotlin/jvm/functions/Function1;)V", "()Lkotlin/jvm/functions/Function1;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends f<ac.c>
  {
    private final kotlin.g.a.b<Integer, Boolean> GEv;
    
    public d()
    {
      AppMethodBeat.i(344722);
      this.GEv = localObject;
      AppMethodBeat.o(344722);
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(344731);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramj, "holder");
      AppMethodBeat.o(344731);
    }
    
    public final int getLayoutId()
    {
      return p.f.CdT;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$getView$1$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Data;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements g
  {
    e(ac paramac) {}
    
    public final f<ac.c> yF(int paramInt)
    {
      AppMethodBeat.i(344738);
      f localf = (f)new ac.d(this.GEB, (kotlin.g.a.b)new a(this.GEB));
      AppMethodBeat.o(344738);
      return localf;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Integer, Boolean>
    {
      a(ac paramac)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$getView$1$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements i.c<j>
  {
    f(ac paramac) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.ac
 * JD-Core Version:    0.7.0.1
 */