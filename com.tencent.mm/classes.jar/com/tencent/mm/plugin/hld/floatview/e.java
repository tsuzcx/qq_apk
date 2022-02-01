package com.tencent.mm.plugin.hld.floatview;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "composition", "", "compositionTv", "Landroid/widget/TextView;", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "fillContent", "", "onSelect", "select", "", "IFloatViewListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.v
{
  private final RelativeLayout Ikt;
  TextView Jqy;
  String Jqz;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(312781);
    this.Ikt = ((RelativeLayout)paramView.findViewById(a.f.root));
    paramView = paramView.findViewById(a.f.float_composition_item_tv);
    s.s(paramView, "itemView.findViewById(R.…loat_composition_item_tv)");
    this.Jqy = ((TextView)paramView);
    AppMethodBeat.o(312781);
  }
  
  public final void wL(boolean paramBoolean)
  {
    AppMethodBeat.i(312793);
    if (this.Ikt.isSelected() != paramBoolean) {
      this.Ikt.setSelected(paramBoolean);
    }
    AppMethodBeat.o(312793);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder$IFloatViewListener;", "", "notifyDataSetChanged", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.e
 * JD-Core Version:    0.7.0.1
 */