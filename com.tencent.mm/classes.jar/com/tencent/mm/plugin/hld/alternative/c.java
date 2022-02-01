package com.tencent.mm.plugin.hld.alternative;

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
import com.tencent.wxhld.info.Syllable;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;)V", "alternativePyData", "Lcom/tencent/wxhld/info/Syllable;", "mListener", "pinyinKeyTv", "Landroid/widget/TextView;", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "fillContent", "", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "onSelect", "select", "", "IAlternativePyViewListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.v
  implements g
{
  private final RelativeLayout Ikt;
  private final a Jnl;
  TextView Jnp;
  Syllable Jnq;
  
  public c(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(311685);
    this.Ikt = ((RelativeLayout)paramView.findViewById(a.f.root));
    View localView = paramView.findViewById(a.f.pinyin_item_tv);
    s.s(localView, "itemView.findViewById(R.id.pinyin_item_tv)");
    this.Jnp = ((TextView)localView);
    this.Jnl = parama;
    this.Jnp.setTextSize(0, a.bs(paramView.getContext(), a.d.S5_keys_button_text_size_small));
    f.JzR.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(311685);
  }
  
  public final void k(Long paramLong)
  {
    AppMethodBeat.i(311707);
    a locala;
    Syllable localSyllable;
    if (this.Jnl != null)
    {
      locala = this.Jnl;
      localSyllable = this.Jnq;
      if (paramLong != null) {
        break label46;
      }
    }
    label46:
    for (long l = 0L;; l = paramLong.longValue())
    {
      locala.a(localSyllable, l);
      AppMethodBeat.o(311707);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(311722);
    k(Long.valueOf(0L));
    AppMethodBeat.o(311722);
  }
  
  public final void wL(boolean paramBoolean)
  {
    AppMethodBeat.i(311740);
    if (this.Ikt.isSelected() != paramBoolean) {
      this.Ikt.setSelected(paramBoolean);
    }
    AppMethodBeat.o(311740);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;", "", "onSyllableClick", "", "alternativePyData", "Lcom/tencent/wxhld/info/Syllable;", "pressTime", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(Syllable paramSyllable, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.c
 * JD-Core Version:    0.7.0.1
 */