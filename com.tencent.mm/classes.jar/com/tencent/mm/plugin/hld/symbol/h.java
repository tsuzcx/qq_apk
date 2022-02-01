package com.tencent.mm.plugin.hld.symbol;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;)V", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "symbolKeyTv", "Landroid/widget/TextView;", "symbolType", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "fillContent", "", "onClick", "v", "onSelect", "select", "", "ISymbolTypesViewListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends RecyclerView.v
  implements View.OnClickListener
{
  private final RelativeLayout Ikt;
  TextView JwS;
  private final a Jxf;
  f Jxi;
  
  public h(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(312131);
    this.Ikt = ((RelativeLayout)paramView.findViewById(a.f.root));
    View localView = paramView.findViewById(a.f.symbol_keys_item_tv);
    s.s(localView, "itemView.findViewById(R.id.symbol_keys_item_tv)");
    this.JwS = ((TextView)localView);
    this.Jxf = parama;
    this.JwS.setTextSize(0, com.tencent.mm.cd.a.bs(paramView.getContext(), a.d.S5_keys_button_text_size_small));
    com.tencent.mm.plugin.hld.view.f.JzR.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(312131);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312140);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    a locala;
    if (this.Jxf != null)
    {
      locala = this.Jxf;
      paramView = this.Jxi;
      if (paramView != null) {
        break label96;
      }
    }
    label96:
    for (paramView = null;; paramView = paramView.typeName)
    {
      localObject = paramView;
      if (paramView == null)
      {
        paramView = com.tencent.mm.plugin.hld.f.b.Jyf;
        localObject = com.tencent.mm.plugin.hld.f.b.fNN();
      }
      locala.onClick((String)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312140);
      return;
    }
  }
  
  public final void wL(boolean paramBoolean)
  {
    AppMethodBeat.i(312148);
    if (this.Ikt.isSelected() != paramBoolean) {
      this.Ikt.setSelected(paramBoolean);
    }
    AppMethodBeat.o(312148);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;", "", "onClick", "", "typeName", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onClick(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.h
 * JD-Core Version:    0.7.0.1
 */