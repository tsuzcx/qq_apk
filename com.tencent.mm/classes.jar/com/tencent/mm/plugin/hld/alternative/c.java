package com.tencent.mm.plugin.hld.alternative;

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
import com.tencent.wxhld.info.Syllable;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/hld/view/ImeOnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;)V", "alternativePyData", "Lcom/tencent/wxhld/info/Syllable;", "mListener", "pinyinKeyTv", "Landroid/widget/TextView;", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "fillContent", "", "onClick", "v", "pressTime", "", "(Landroid/view/View;Ljava/lang/Long;)V", "onSelect", "select", "", "IAlternativePyViewListener", "plugin-hld_release"})
public final class c
  extends RecyclerView.v
  implements h
{
  private final a DtI;
  private final RelativeLayout DtO;
  TextView DtP;
  Syllable DtQ;
  
  public c(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(213990);
    this.DtO = ((RelativeLayout)paramView.findViewById(a.f.root));
    View localView = paramView.findViewById(a.f.pinyin_item_tv);
    p.j(localView, "itemView.findViewById(R.id.pinyin_item_tv)");
    this.DtP = ((TextView)localView);
    this.DtI = parama;
    this.DtP.setTextSize(0, a.aZ(paramView.getContext(), a.d.S5_keys_button_text_size_small));
    parama = g.DIP;
    g.a(paramView, (View.OnClickListener)this);
    AppMethodBeat.o(213990);
  }
  
  public final void j(Long paramLong)
  {
    AppMethodBeat.i(213986);
    a locala;
    Syllable localSyllable;
    if (this.DtI != null)
    {
      locala = this.DtI;
      localSyllable = this.DtQ;
      if (paramLong == null) {
        break label49;
      }
    }
    label49:
    for (long l = paramLong.longValue();; l = 0L)
    {
      locala.a(localSyllable, l);
      AppMethodBeat.o(213986);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213987);
    j(Long.valueOf(0L));
    AppMethodBeat.o(213987);
  }
  
  public final void sF(boolean paramBoolean)
  {
    AppMethodBeat.i(213988);
    RelativeLayout localRelativeLayout = this.DtO;
    p.j(localRelativeLayout, "rootView");
    if (localRelativeLayout.isSelected() != paramBoolean)
    {
      localRelativeLayout = this.DtO;
      p.j(localRelativeLayout, "rootView");
      localRelativeLayout.setSelected(paramBoolean);
    }
    AppMethodBeat.o(213988);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;", "", "onSyllableClick", "", "alternativePyData", "Lcom/tencent/wxhld/info/Syllable;", "pressTime", "", "plugin-hld_release"})
  public static abstract interface a
  {
    public abstract void a(Syllable paramSyllable, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.c
 * JD-Core Version:    0.7.0.1
 */