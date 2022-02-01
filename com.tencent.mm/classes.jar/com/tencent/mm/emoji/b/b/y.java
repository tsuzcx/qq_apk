package com.tencent.mm.emoji.b.b;

import android.support.v7.widget.RecyclerView.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/PanelDataAdapterListener;", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "groupAdapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "tabAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "onGroupChange", "", "start", "", "count", "onGroupInsert", "onGroupMoved", "from", "to", "onGroupRemove", "onTabChange", "onTabInsert", "onTabRemove", "plugin-emojisdk_release"})
public abstract class y
  implements z
{
  private final RecyclerView.a<?> gYO;
  private final RecyclerView.a<?> gYP;
  
  public y(RecyclerView.a<?> parama1, RecyclerView.a<?> parama2)
  {
    this.gYO = parama1;
    this.gYP = parama2;
  }
  
  public final void cA(int paramInt1, int paramInt2)
  {
    this.gYO.as(paramInt1, paramInt2);
  }
  
  public final void cB(int paramInt1, int paramInt2)
  {
    this.gYO.aq(paramInt1, paramInt2);
  }
  
  public final void cC(int paramInt1, int paramInt2)
  {
    this.gYO.at(paramInt1, paramInt2);
  }
  
  public final void cH(int paramInt1, int paramInt2)
  {
    this.gYP.as(paramInt1, paramInt2);
  }
  
  public final void cI(int paramInt1, int paramInt2)
  {
    this.gYP.aq(paramInt1, paramInt2);
  }
  
  public final void cJ(int paramInt1, int paramInt2)
  {
    this.gYP.at(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.y
 * JD-Core Version:    0.7.0.1
 */