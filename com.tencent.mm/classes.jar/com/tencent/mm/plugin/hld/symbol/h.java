package com.tencent.mm.plugin.hld.symbol;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.view.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;)V", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "symbolKeyTv", "Landroid/widget/TextView;", "symbolType", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "fillContent", "", "onClick", "v", "onSelect", "select", "", "ISymbolTypesViewListener", "plugin-hld_release"})
public final class h
  extends RecyclerView.v
  implements View.OnClickListener
{
  f DFB;
  TextView DFl;
  private final a DFw;
  private final RelativeLayout DtO;
  
  public h(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(210863);
    this.DtO = ((RelativeLayout)paramView.findViewById(a.f.root));
    View localView = paramView.findViewById(a.f.symbol_keys_item_tv);
    p.j(localView, "itemView.findViewById(R.id.symbol_keys_item_tv)");
    this.DFl = ((TextView)localView);
    this.DFw = parama;
    this.DFl.setTextSize(0, com.tencent.mm.ci.a.aZ(paramView.getContext(), a.d.S5_keys_button_text_size_small));
    parama = g.DIP;
    g.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(210863);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(210861);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (this.DFw != null)
    {
      a locala = this.DFw;
      paramView = this.DFB;
      if (paramView != null)
      {
        localObject = paramView.typeName;
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.hld.f.b.DGL;
        paramView = com.tencent.mm.plugin.hld.f.b.eFU();
      }
      locala.azH(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(210861);
  }
  
  public final void sF(boolean paramBoolean)
  {
    AppMethodBeat.i(210862);
    RelativeLayout localRelativeLayout = this.DtO;
    p.j(localRelativeLayout, "rootView");
    if (localRelativeLayout.isSelected() != paramBoolean)
    {
      localRelativeLayout = this.DtO;
      p.j(localRelativeLayout, "rootView");
      localRelativeLayout.setSelected(paramBoolean);
    }
    AppMethodBeat.o(210862);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;", "", "onClick", "", "typeName", "", "plugin-hld_release"})
  public static abstract interface a
  {
    public abstract void azH(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.h
 * JD-Core Version:    0.7.0.1
 */