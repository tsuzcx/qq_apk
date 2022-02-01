package com.tencent.mm.plugin.finder.live.view.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "isAssistant", "", "(Landroid/view/View;Z)V", "addBtn", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getAddBtn", "()Landroid/widget/LinearLayout;", "callback", "Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderViewCallback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderViewCallback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderViewCallback;)V", "container", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "()Z", "manageBtn", "getManageBtn", "moreBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getMoreBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "type", "Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderType;", "getType", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderType;", "setType", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderType;)V", "isAnchorOrAssistant", "update", "", "", "topMargin", "hasProductData", "hasAdData", "ShoppingHeaderType", "ShoppingHeaderViewCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.v
{
  private final boolean DUe;
  public b DUf;
  private final WeImageView DUg;
  private final LinearLayout DUh;
  private final LinearLayout DUi;
  private final ConstraintLayout DUj;
  public a DUk;
  private final TextView mll;
  
  public b(View paramView, boolean paramBoolean)
  {
    super(paramView);
    AppMethodBeat.i(359142);
    this.DUe = paramBoolean;
    this.mll = ((TextView)paramView.findViewById(p.e.title));
    this.DUg = ((WeImageView)paramView.findViewById(p.e.more_btn));
    this.DUh = ((LinearLayout)paramView.findViewById(p.e.add_btn));
    this.DUi = ((LinearLayout)paramView.findViewById(p.e.manage_btn));
    this.DUj = ((ConstraintLayout)paramView.findViewById(p.e.container));
    this.DUk = a.DUm;
    AppMethodBeat.o(359142);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(359160);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.DUf;
    if (paramb != null) {
      paramb.esl();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359160);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(359165);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (paramb.DUk == a.DUl)
    {
      paramb = paramb.DUf;
      if (paramb != null) {
        paramb.esl();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359165);
  }
  
  private static final void c(b paramb, View paramView)
  {
    AppMethodBeat.i(359173);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.DUf;
    if (paramb != null) {
      paramb.esn();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359173);
  }
  
  private static final void d(b paramb, View paramView)
  {
    AppMethodBeat.i(359181);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.DUf;
    if (paramb != null) {
      paramb.esm();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359181);
  }
  
  private final boolean eqc()
  {
    AppMethodBeat.i(359148);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (this.DUe))
    {
      AppMethodBeat.o(359148);
      return true;
    }
    AppMethodBeat.o(359148);
    return false;
  }
  
  public final void a(String paramString, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 8;
    AppMethodBeat.i(359219);
    s.u(paramString, "title");
    s.u(parama, "type");
    this.mll.setText((CharSequence)paramString);
    this.DUk = parama;
    paramString = this.DUg;
    label52:
    label120:
    Context localContext;
    if (parama == a.DUl)
    {
      i = 0;
      paramString.setVisibility(i);
      this.DUg.setOnClickListener(new b..ExternalSyntheticLambda3(this));
      this.caK.setOnClickListener(new b..ExternalSyntheticLambda2(this));
      paramString = this.DUh;
      if ((parama != a.DUm) || (!eqc()) || ((!paramBoolean2) && (!paramBoolean3))) {
        break label285;
      }
      i = 0;
      paramString.setVisibility(i);
      this.DUh.setOnClickListener(new b..ExternalSyntheticLambda1(this));
      paramString = this.DUi;
      i = j;
      if (parama == a.DUm)
      {
        i = j;
        if (eqc())
        {
          i = j;
          if (paramBoolean2) {
            i = 0;
          }
        }
      }
      paramString.setVisibility(i);
      this.DUi.setOnClickListener(new b..ExternalSyntheticLambda0(this));
      paramString = this.mll;
      localContext = this.caK.getContext();
      if (parama == a.DUn) {
        break label292;
      }
    }
    label285:
    label292:
    for (int i = p.b.UN_BW_0_Alpha_0_9;; i = p.b.UN_BW_0_Alpha_0_3)
    {
      paramString.setTextColor(com.tencent.mm.cd.a.w(localContext, i));
      switch (c.$EnumSwitchMapping$0[parama.ordinal()])
      {
      default: 
        AppMethodBeat.o(359219);
        return;
        i = 8;
        break label52;
        i = 8;
        break label120;
      }
    }
    paramString = this.DUj.getLayoutParams();
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(359219);
      throw paramString;
    }
    ((RecyclerView.LayoutParams)paramString).setMargins(0, 0, 0, com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.Edge_A));
    AppMethodBeat.o(359219);
    return;
    paramString = this.DUj.getLayoutParams();
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(359219);
      throw paramString;
    }
    paramString = (RecyclerView.LayoutParams)paramString;
    if (paramBoolean1) {}
    for (i = com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.Bzi);; i = 0)
    {
      paramString.setMargins(0, i, 0, com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.finder_0_75_A));
      AppMethodBeat.o(359219);
      return;
    }
    paramString = this.DUj.getLayoutParams();
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(359219);
      throw paramString;
    }
    paramString = (RecyclerView.LayoutParams)paramString;
    j = com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.finder_2_25_A);
    if (paramBoolean1) {}
    for (i = com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.Bzi);; i = com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.finder_0_25_A))
    {
      paramString.setMargins(j, i, 0, com.tencent.mm.cd.a.bs(this.caK.getContext(), p.c.finder_0_75_A));
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderType;", "", "(Ljava/lang/String;I)V", "Coupon", "Goods", "Detail", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(359159);
      DUl = new a("Coupon", 0);
      DUm = new a("Goods", 1);
      DUn = new a("Detail", 2);
      DUo = new a[] { DUl, DUm, DUn };
      AppMethodBeat.o(359159);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderViewCallback;", "", "onClickAdd", "", "onClickManage", "onClickMore", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void esl();
    
    public abstract void esm();
    
    public abstract void esn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.holder.b
 * JD-Core Version:    0.7.0.1
 */