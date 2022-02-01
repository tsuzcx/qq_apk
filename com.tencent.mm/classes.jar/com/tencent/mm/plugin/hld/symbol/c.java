package com.tencent.mm.plugin.hld.symbol;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.view.g;
import com.tencent.mm.plugin.hld.view.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;)V", "data", "", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "symbolKeyTv", "Landroid/widget/TextView;", "fillContent", "", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "onSelect", "select", "", "ISboAndSybKeysViewListener", "plugin-hld_release"})
public final class c
  extends RecyclerView.v
  implements h
{
  private final a DFf;
  TextView DFl;
  private final RelativeLayout DtO;
  Object bnW;
  
  public c(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(213493);
    this.DtO = ((RelativeLayout)paramView.findViewById(a.f.root));
    View localView = paramView.findViewById(a.f.symbol_keys_item_tv);
    p.j(localView, "itemView.findViewById(R.id.symbol_keys_item_tv)");
    this.DFl = ((TextView)localView);
    this.DFf = parama;
    this.DFl.setTextSize(0, a.aZ(paramView.getContext(), a.d.ime_symbol_keys_item_text_size));
    parama = g.DIP;
    g.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(213493);
  }
  
  public final void j(Long paramLong)
  {
    AppMethodBeat.i(213485);
    a locala;
    Object localObject;
    if ((this.DFf != null) && (this.DFl != null))
    {
      locala = this.DFf;
      localObject = this.bnW;
      if (paramLong == null) {
        break label56;
      }
    }
    label56:
    for (long l = paramLong.longValue();; l = 0L)
    {
      locala.m(localObject, l);
      AppMethodBeat.o(213485);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213487);
    j(Long.valueOf(0L));
    AppMethodBeat.o(213487);
  }
  
  public final void sF(boolean paramBoolean)
  {
    AppMethodBeat.i(213490);
    RelativeLayout localRelativeLayout = this.DtO;
    p.j(localRelativeLayout, "rootView");
    if (localRelativeLayout.isSelected() != paramBoolean)
    {
      localRelativeLayout = this.DtO;
      p.j(localRelativeLayout, "rootView");
      localRelativeLayout.setSelected(paramBoolean);
    }
    AppMethodBeat.o(213490);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;", "", "onClick", "", "data", "pressTime", "", "plugin-hld_release"})
  public static abstract interface a
  {
    public abstract void m(Object paramObject, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.c
 * JD-Core Version:    0.7.0.1
 */