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
import com.tencent.mm.plugin.hld.f.j;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.plugin.hld.view.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;)V", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "symbolData", "Lcom/tencent/mm/plugin/hld/utils/WxImeSymbolData;", "symbolKeyTextView", "Landroid/widget/TextView;", "symbolKeyTypeView", "fillContent", "", "symbolStr", "symbolType", "", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "ISymbolGridViewListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.v
  implements g
{
  RelativeLayout Ikt;
  private final a JwV;
  TextView JwY;
  TextView JwZ;
  j Jxa;
  
  public e(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(312128);
    View localView = paramView.findViewById(a.f.root);
    s.s(localView, "itemView.findViewById(R.id.root)");
    this.Ikt = ((RelativeLayout)localView);
    localView = paramView.findViewById(a.f.s5_grid_key_text);
    s.s(localView, "itemView.findViewById(R.id.s5_grid_key_text)");
    this.JwY = ((TextView)localView);
    localView = paramView.findViewById(a.f.s5_grid_key_type);
    s.s(localView, "itemView.findViewById(R.id.s5_grid_key_type)");
    this.JwZ = ((TextView)localView);
    this.JwV = parama;
    this.JwY.setTextSize(0, a.bs(paramView.getContext(), a.d.S5_keys_button_text_size));
    this.JwZ.setTextSize(0, a.bs(paramView.getContext(), a.d.S5_keys_button_text_type_size));
    f.JzR.a((View)this.Ikt, (View.OnClickListener)this);
    AppMethodBeat.o(312128);
  }
  
  public final void k(Long paramLong)
  {
    AppMethodBeat.i(312137);
    a locala = this.JwV;
    Object localObject;
    if (locala != null)
    {
      localObject = this.Jxa;
      if (localObject != null) {
        break label53;
      }
      localObject = "";
      if (paramLong != null) {
        break label75;
      }
    }
    label53:
    label75:
    for (long l = 0L;; l = paramLong.longValue())
    {
      locala.aL((String)localObject, l);
      AppMethodBeat.o(312137);
      return;
      localObject = ((j)localObject).content;
      if (localObject == null)
      {
        localObject = "";
        break;
      }
      break;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312145);
    k(Long.valueOf(0L));
    AppMethodBeat.o(312145);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;", "", "onClick", "", "symbolStr", "", "pressTime", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void aL(String paramString, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.e
 * JD-Core Version:    0.7.0.1
 */