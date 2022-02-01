package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/widget/GridLayoutManager;)V", "getSpanSize", "", "position", "plugin-emojisdk_release"})
public final class p
  extends GridLayoutManager.b
{
  private final GridLayoutManager haU;
  private final RecyclerView.a<?> hbg;
  
  public p(RecyclerView.a<?> parama, GridLayoutManager paramGridLayoutManager)
  {
    AppMethodBeat.i(105676);
    this.hbg = parama;
    this.haU = paramGridLayoutManager;
    AppMethodBeat.o(105676);
  }
  
  public final int bX(int paramInt)
  {
    AppMethodBeat.i(105675);
    switch (this.hbg.getItemViewType(paramInt))
    {
    case 3: 
    case 6: 
    default: 
      AppMethodBeat.o(105675);
      return 1;
    }
    paramInt = this.haU.ki();
    AppMethodBeat.o(105675);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.p
 * JD-Core Version:    0.7.0.1
 */