package com.tencent.mm.plugin.hld.symbol;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.plugin.hld.view.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;)V", "data", "", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "symbolKeyTv", "Landroid/widget/TextView;", "fillContent", "", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "onSelect", "select", "", "ISboAndSybKeysViewListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.v
  implements g
{
  private final RelativeLayout Ikt;
  private final a JwN;
  TextView JwS;
  Object cpt;
  
  public c(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(312156);
    this.Ikt = ((RelativeLayout)paramView.findViewById(a.f.root));
    View localView = paramView.findViewById(a.f.symbol_keys_item_tv);
    s.s(localView, "itemView.findViewById(R.id.symbol_keys_item_tv)");
    this.JwS = ((TextView)localView);
    this.JwN = parama;
    this.JwS.setTextSize(0, a.bs(paramView.getContext(), a.d.ime_symbol_keys_item_text_size));
    f.JzR.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(312156);
  }
  
  public final void k(Long paramLong)
  {
    AppMethodBeat.i(312163);
    a locala;
    Object localObject;
    if ((this.JwN != null) && (this.JwS != null))
    {
      locala = this.JwN;
      localObject = this.cpt;
      if (paramLong != null) {
        break label53;
      }
    }
    label53:
    for (long l = 0L;; l = paramLong.longValue())
    {
      locala.v(localObject, l);
      AppMethodBeat.o(312163);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312172);
    k(Long.valueOf(0L));
    AppMethodBeat.o(312172);
  }
  
  public final void wL(boolean paramBoolean)
  {
    AppMethodBeat.i(312177);
    if (this.Ikt.isSelected() != paramBoolean) {
      this.Ikt.setSelected(paramBoolean);
    }
    AppMethodBeat.o(312177);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;", "", "onClick", "", "data", "pressTime", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void v(Object paramObject, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.c
 * JD-Core Version:    0.7.0.1
 */