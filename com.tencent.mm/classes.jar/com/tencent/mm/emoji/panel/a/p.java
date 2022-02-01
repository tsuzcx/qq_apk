package com.tencent.mm.emoji.panel.a;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/GridLayoutManager;)V", "getSpanSize", "", "position", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends GridLayoutManager.b
{
  private final GridLayoutManager mkZ;
  private final RecyclerView.a<?> mlt;
  
  public p(RecyclerView.a<?> parama, GridLayoutManager paramGridLayoutManager)
  {
    AppMethodBeat.i(242374);
    this.mlt = parama;
    this.mkZ = paramGridLayoutManager;
    AppMethodBeat.o(242374);
  }
  
  public final int fJ(int paramInt)
  {
    AppMethodBeat.i(105675);
    switch (this.mlt.getItemViewType(paramInt))
    {
    case 3: 
    case 6: 
    default: 
      AppMethodBeat.o(105675);
      return 1;
    }
    paramInt = this.mkZ.bWl;
    AppMethodBeat.o(105675);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.p
 * JD-Core Version:    0.7.0.1
 */