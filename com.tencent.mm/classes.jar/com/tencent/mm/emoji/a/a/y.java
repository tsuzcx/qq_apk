package com.tencent.mm.emoji.a.a;

import android.support.v7.widget.RecyclerView.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/PanelDataAdapterListener;", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "groupAdapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "tabAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "onGroupChange", "", "start", "", "count", "onGroupInsert", "onGroupMoved", "from", "to", "onGroupRemove", "onTabChange", "onTabInsert", "onTabRemove", "plugin-emojisdk_release"})
public abstract class y
  implements z
{
  private final RecyclerView.a<?> gly;
  private final RecyclerView.a<?> glz;
  
  public y(RecyclerView.a<?> parama1, RecyclerView.a<?> parama2)
  {
    this.gly = parama1;
    this.glz = parama2;
  }
  
  public final void cE(int paramInt1, int paramInt2)
  {
    this.glz.ar(paramInt1, paramInt2);
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    this.glz.ap(paramInt1, paramInt2);
  }
  
  public final void cG(int paramInt1, int paramInt2)
  {
    this.glz.as(paramInt1, paramInt2);
  }
  
  public final void cx(int paramInt1, int paramInt2)
  {
    this.gly.ar(paramInt1, paramInt2);
  }
  
  public final void cy(int paramInt1, int paramInt2)
  {
    this.gly.ap(paramInt1, paramInt2);
  }
  
  public final void cz(int paramInt1, int paramInt2)
  {
    this.gly.as(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.y
 * JD-Core Version:    0.7.0.1
 */