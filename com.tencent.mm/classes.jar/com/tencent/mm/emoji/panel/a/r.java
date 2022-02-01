package com.tencent.mm.emoji.panel.a;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/GridLayoutManager;)V", "getSpanSize", "", "position", "plugin-emojisdk_release"})
public final class r
  extends GridLayoutManager.b
{
  private final GridLayoutManager jLZ;
  private final RecyclerView.a<?> jMq;
  
  public r(RecyclerView.a<?> parama, GridLayoutManager paramGridLayoutManager)
  {
    AppMethodBeat.i(227884);
    this.jMq = parama;
    this.jLZ = paramGridLayoutManager;
    AppMethodBeat.o(227884);
  }
  
  public final int cx(int paramInt)
  {
    AppMethodBeat.i(105675);
    switch (this.jMq.getItemViewType(paramInt))
    {
    case 3: 
    case 6: 
    default: 
      AppMethodBeat.o(105675);
      return 1;
    }
    paramInt = this.jLZ.ku();
    AppMethodBeat.o(105675);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.r
 * JD-Core Version:    0.7.0.1
 */