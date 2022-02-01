package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/widget/GridLayoutManager;)V", "getSpanSize", "", "position", "plugin-emojisdk_release"})
public final class p
  extends GridLayoutManager.b
{
  private final GridLayoutManager fTZ;
  private final RecyclerView.a<?> fUp;
  
  public p(RecyclerView.a<?> parama, GridLayoutManager paramGridLayoutManager)
  {
    AppMethodBeat.i(105676);
    this.fUp = parama;
    this.fTZ = paramGridLayoutManager;
    AppMethodBeat.o(105676);
  }
  
  public final int bW(int paramInt)
  {
    AppMethodBeat.i(105675);
    switch (this.fUp.getItemViewType(paramInt))
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      paramInt = this.fTZ.jJ();
      AppMethodBeat.o(105675);
      return paramInt;
    }
    AppMethodBeat.o(105675);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.p
 * JD-Core Version:    0.7.0.1
 */