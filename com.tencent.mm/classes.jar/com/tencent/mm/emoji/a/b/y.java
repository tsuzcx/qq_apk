package com.tencent.mm.emoji.a.b;

import android.support.v7.widget.RecyclerView.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/PanelDataAdapterListener;", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "groupAdapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "tabAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "onGroupChange", "", "start", "", "count", "onGroupInsert", "onGroupMoved", "from", "to", "onGroupRemove", "onTabChange", "onTabInsert", "onTabRemove", "plugin-emojisdk_release"})
public abstract class y
  implements z
{
  private final RecyclerView.a<?> gnT;
  private final RecyclerView.a<?> gnU;
  
  public y(RecyclerView.a<?> parama1, RecyclerView.a<?> parama2)
  {
    this.gnT = parama1;
    this.gnU = parama2;
  }
  
  public final void cE(int paramInt1, int paramInt2)
  {
    this.gnU.ar(paramInt1, paramInt2);
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    this.gnU.ap(paramInt1, paramInt2);
  }
  
  public final void cG(int paramInt1, int paramInt2)
  {
    this.gnU.as(paramInt1, paramInt2);
  }
  
  public final void cx(int paramInt1, int paramInt2)
  {
    this.gnT.ar(paramInt1, paramInt2);
  }
  
  public final void cy(int paramInt1, int paramInt2)
  {
    this.gnT.ap(paramInt1, paramInt2);
  }
  
  public final void cz(int paramInt1, int paramInt2)
  {
    this.gnT.as(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.y
 * JD-Core Version:    0.7.0.1
 */