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
import com.tencent.mm.plugin.hld.f.j;
import com.tencent.mm.plugin.hld.view.g;
import com.tencent.mm.plugin.hld.view.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;)V", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "symbolData", "Lcom/tencent/mm/plugin/hld/utils/WxImeSymbolData;", "symbolKeyTextView", "Landroid/widget/TextView;", "symbolKeyTypeView", "fillContent", "", "symbolStr", "symbolType", "", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "ISymbolGridViewListener", "plugin-hld_release"})
public final class e
  extends RecyclerView.v
  implements h
{
  private final a DFm;
  TextView DFr;
  TextView DFs;
  j DFt;
  RelativeLayout DtO;
  
  public e(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(209232);
    View localView = paramView.findViewById(a.f.root);
    p.j(localView, "itemView.findViewById(R.id.root)");
    this.DtO = ((RelativeLayout)localView);
    localView = paramView.findViewById(a.f.s5_grid_key_text);
    p.j(localView, "itemView.findViewById(R.id.s5_grid_key_text)");
    this.DFr = ((TextView)localView);
    localView = paramView.findViewById(a.f.s5_grid_key_type);
    p.j(localView, "itemView.findViewById(R.id.s5_grid_key_type)");
    this.DFs = ((TextView)localView);
    this.DFm = parama;
    this.DFr.setTextSize(0, a.aZ(paramView.getContext(), a.d.S5_keys_button_text_size));
    this.DFs.setTextSize(0, a.aZ(paramView.getContext(), a.d.S5_keys_button_text_type_size));
    paramView = g.DIP;
    g.a((View)this.DtO, (View.OnClickListener)this);
    AppMethodBeat.o(209232);
  }
  
  public final void j(Long paramLong)
  {
    AppMethodBeat.i(209229);
    a locala = this.DFm;
    Object localObject;
    if (locala != null)
    {
      localObject = this.DFt;
      if (localObject != null)
      {
        localObject = ((j)localObject).content;
        if (localObject != null) {
          break label79;
        }
      }
      localObject = "";
    }
    label79:
    for (;;)
    {
      if (paramLong != null) {}
      for (long l = paramLong.longValue();; l = 0L)
      {
        locala.aB((String)localObject, l);
        AppMethodBeat.o(209229);
        return;
      }
      AppMethodBeat.o(209229);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209231);
    j(Long.valueOf(0L));
    AppMethodBeat.o(209231);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;", "", "onClick", "", "symbolStr", "", "pressTime", "", "plugin-hld_release"})
  public static abstract interface a
  {
    public abstract void aB(String paramString, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.e
 * JD-Core Version:    0.7.0.1
 */