package com.tencent.mm.plugin.hld.floatview;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "composition", "", "compositionTv", "Landroid/widget/TextView;", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "fillContent", "", "onSelect", "select", "", "IFloatViewListener", "plugin-hld_release"})
public final class e
  extends RecyclerView.v
{
  private final RelativeLayout DtO;
  TextView Dxt;
  String Dxu;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(216016);
    this.DtO = ((RelativeLayout)paramView.findViewById(a.f.root));
    paramView = paramView.findViewById(a.f.float_composition_item_tv);
    p.j(paramView, "itemView.findViewById(R.…loat_composition_item_tv)");
    this.Dxt = ((TextView)paramView);
    AppMethodBeat.o(216016);
  }
  
  public final void sF(boolean paramBoolean)
  {
    AppMethodBeat.i(216015);
    RelativeLayout localRelativeLayout = this.DtO;
    p.j(localRelativeLayout, "rootView");
    if (localRelativeLayout.isSelected() != paramBoolean)
    {
      localRelativeLayout = this.DtO;
      p.j(localRelativeLayout, "rootView");
      localRelativeLayout.setSelected(paramBoolean);
    }
    AppMethodBeat.o(216015);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder$IFloatViewListener;", "", "notifyDataSetChanged", "", "plugin-hld_release"})
  public static abstract interface a
  {
    public abstract void notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.e
 * JD-Core Version:    0.7.0.1
 */