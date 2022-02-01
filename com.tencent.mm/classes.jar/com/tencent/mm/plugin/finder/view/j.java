package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "finderBottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "getFinderBottomSheet", "()Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "finderBottomSheet$delegate", "Lkotlin/Lazy;", "firstDivider", "Landroid/view/View;", "firstMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "getFirstMenu", "()Lcom/tencent/mm/ui/base/MMMenu;", "firstMenu$delegate", "firstRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "firstRecyclerViewAdapter", "Lcom/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet$RecycleViewAdapter;", "onCreateFirstMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "onCreateSecondMenuListener", "onCreateZeroMenuListener", "rootView", "secondDivider", "secondMenu", "getSecondMenu", "secondMenu$delegate", "secondRecyclerView", "secondRecyclerViewAdapter", "showAlwaysDark", "", "zeroDivider", "zeroMenu", "getZeroMenu", "zeroMenu$delegate", "zeroRecyclerView", "zeroRecyclerViewAdapter", "initRecyclerView", "", "recyclerView", "adapter", "setCancelTvColor", "color", "", "setFirstMenuSelectedListener", "onMenuSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "setOnCreateFirstMenuListener", "listener", "setOnCreateSecondMenuListener", "setOnCreateZeroMenuListener", "setOnDismissListener", "onDismissListener", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet$OnDismissListener;", "setSecondMenuSelectedListener", "setShowAlwaysDark", "_showAlwaysDark", "setZeroMenuSelectedListener", "tryHide", "tryShow", "Companion", "RecycleViewAdapter", "ViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final float GAA;
  public static final j.a GAi;
  private final kotlin.j GAj;
  private final kotlin.j GAk;
  private final kotlin.j GAl;
  private final kotlin.j GAm;
  private final RecyclerView GAn;
  private final RecyclerView GAo;
  private final RecyclerView GAp;
  private final b GAq;
  private final b GAr;
  private final b GAs;
  private final View GAt;
  private final View GAu;
  private final View GAv;
  private boolean GAw;
  public u.g GAx;
  public u.g GAy;
  public u.g GAz;
  private final Context context;
  private final View rootView;
  
  static
  {
    AppMethodBeat.i(344383);
    GAi = new j.a((byte)0);
    GAA = MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_2A);
    AppMethodBeat.o(344383);
  }
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(344293);
    this.context = paramContext;
    this.GAj = k.cm((kotlin.g.a.a)new d(this));
    this.GAk = k.cm((kotlin.g.a.a)new h(this));
    this.GAl = k.cm((kotlin.g.a.a)new e(this));
    this.GAm = k.cm((kotlin.g.a.a)new g(this));
    paramContext = View.inflate(this.context, p.f.CcR, null);
    kotlin.g.b.s.s(paramContext, "inflate(context, R.layou…_sheet_custom_view, null)");
    this.rootView = paramContext;
    paramContext = this.rootView.findViewById(p.e.BFm);
    kotlin.g.b.s.s(paramContext, "rootView.findViewById(R.…t_zero_menu_recyclerview)");
    this.GAn = ((RecyclerView)paramContext);
    paramContext = this.rootView.findViewById(p.e.BFi);
    kotlin.g.b.s.s(paramContext, "rootView.findViewById(R.…_first_menu_recyclerview)");
    this.GAo = ((RecyclerView)paramContext);
    paramContext = this.rootView.findViewById(p.e.BFk);
    kotlin.g.b.s.s(paramContext, "rootView.findViewById(R.…second_menu_recyclerview)");
    this.GAp = ((RecyclerView)paramContext);
    paramContext = this.rootView.findViewById(p.e.BFl);
    kotlin.g.b.s.s(paramContext, "rootView.findViewById(R.…tom_sheet_zero_menu_line)");
    this.GAt = paramContext;
    paramContext = this.rootView.findViewById(p.e.BFh);
    kotlin.g.b.s.s(paramContext, "rootView.findViewById(R.…om_sheet_first_menu_line)");
    this.GAu = paramContext;
    paramContext = this.rootView.findViewById(p.e.BFj);
    kotlin.g.b.s.s(paramContext, "rootView.findViewById(R.…m_sheet_second_menu_line)");
    this.GAv = paramContext;
    this.GAq = new b();
    this.GAr = new b();
    this.GAs = new b();
    a(this.GAn, this.GAq);
    a(this.GAo, this.GAr);
    a(this.GAp, this.GAs);
    AppMethodBeat.o(344293);
  }
  
  private final void a(RecyclerView paramRecyclerView, b paramb)
  {
    AppMethodBeat.i(344344);
    paramRecyclerView.setFocusable(false);
    paramRecyclerView.setAdapter((RecyclerView.a)paramb);
    paramRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(5));
    paramRecyclerView.a((RecyclerView.h)new f());
    AppMethodBeat.o(344344);
  }
  
  private final com.tencent.mm.ui.base.s fkP()
  {
    AppMethodBeat.i(344305);
    com.tencent.mm.ui.base.s locals = (com.tencent.mm.ui.base.s)this.GAk.getValue();
    AppMethodBeat.o(344305);
    return locals;
  }
  
  private final com.tencent.mm.ui.base.s fkQ()
  {
    AppMethodBeat.i(344317);
    com.tencent.mm.ui.base.s locals = (com.tencent.mm.ui.base.s)this.GAl.getValue();
    AppMethodBeat.o(344317);
    return locals;
  }
  
  private final com.tencent.mm.ui.base.s fkR()
  {
    AppMethodBeat.i(344327);
    com.tencent.mm.ui.base.s locals = (com.tencent.mm.ui.base.s)this.GAm.getValue();
    AppMethodBeat.o(344327);
    return locals;
  }
  
  public final void UE(int paramInt)
  {
    AppMethodBeat.i(344407);
    fkO().UE(paramInt);
    AppMethodBeat.o(344407);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(344454);
    fkO().GwT = paramb;
    AppMethodBeat.o(344454);
  }
  
  public final void a(u.i parami)
  {
    this.GAq.GAC = parami;
  }
  
  public final void b(u.i parami)
  {
    this.GAr.GAC = parami;
  }
  
  public final void c(u.i parami)
  {
    this.GAs.GAC = parami;
  }
  
  public final void dDn()
  {
    AppMethodBeat.i(344471);
    u.g localg = this.GAx;
    if (localg != null) {
      localg.onCreateMMMenu(fkP());
    }
    this.GAq.GAB = fkP();
    this.GAq.bZE.notifyChanged();
    localg = this.GAy;
    if (localg != null) {
      localg.onCreateMMMenu(fkQ());
    }
    this.GAr.GAB = fkQ();
    this.GAr.bZE.notifyChanged();
    localg = this.GAz;
    if (localg != null) {
      localg.onCreateMMMenu(fkR());
    }
    this.GAs.GAB = fkR();
    this.GAs.bZE.notifyChanged();
    fkO().dDn();
    AppMethodBeat.o(344471);
  }
  
  public final d fkO()
  {
    AppMethodBeat.i(344391);
    d locald = (d)this.GAj.getValue();
    AppMethodBeat.o(344391);
    return locald;
  }
  
  public final void fkS()
  {
    AppMethodBeat.i(344399);
    this.GAw = true;
    fkO().fki();
    this.GAt.setBackgroundColor(this.context.getResources().getColor(p.b.BW_100_Alpha_0_0_5));
    this.GAu.setBackgroundColor(this.context.getResources().getColor(p.b.BW_100_Alpha_0_0_5));
    this.GAv.setBackgroundColor(this.context.getResources().getColor(p.b.BW_100_Alpha_0_0_5));
    AppMethodBeat.o(344399);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet$RecycleViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet;)V", "mmMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "onMenuSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClickListener", "listener", "setMenu", "menu", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends RecyclerView.a<j.c>
  {
    com.tencent.mm.ui.base.s GAB;
    u.i GAC;
    
    public b()
    {
      AppMethodBeat.i(344807);
      AppMethodBeat.o(344807);
    }
    
    private static final void a(b paramb, t paramt, int paramInt, View paramView)
    {
      AppMethodBeat.i(344822);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramb);
      localb.cH(paramt);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet$RecycleViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramb, "this$0");
      kotlin.g.b.s.u(paramt, "$menuItem");
      paramb = paramb.GAC;
      if (paramb != null) {
        paramb.onMMMenuItemSelected((MenuItem)paramt, paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet$RecycleViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344822);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(344845);
      com.tencent.mm.ui.base.s locals = this.GAB;
      if (locals == null)
      {
        AppMethodBeat.o(344845);
        return 0;
      }
      int i = locals.size();
      AppMethodBeat.o(344845);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "iconBg", "Landroid/widget/ImageView;", "getIconBg", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    extends RecyclerView.v
  {
    final WeImageView EoD;
    final ImageView GAE;
    final TextView mll;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(344796);
      this.mll = ((TextView)paramView.findViewById(p.e.title));
      this.EoD = ((WeImageView)paramView.findViewById(p.e.icon));
      this.GAE = ((ImageView)paramView.findViewById(p.e.icon_bg));
      AppMethodBeat.o(344796);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<d>
  {
    d(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/base/MMMenu;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<com.tencent.mm.ui.base.s>
  {
    e(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet$initRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(344970);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      if (RecyclerView.bA(paramView) < 5)
      {
        paramRect.top = 0;
        AppMethodBeat.o(344970);
        return;
      }
      paramRect.top = ((int)j.fkT());
      AppMethodBeat.o(344970);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/base/MMMenu;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<com.tencent.mm.ui.base.s>
  {
    g(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/base/MMMenu;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<com.tencent.mm.ui.base.s>
  {
    h(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.j
 * JD-Core Version:    0.7.0.1
 */