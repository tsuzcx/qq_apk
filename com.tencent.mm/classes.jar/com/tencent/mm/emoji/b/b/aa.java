package com.tencent.mm.emoji.b.b;

import androidx.recyclerview.widget.RecyclerView.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/PanelDataAdapterListener;", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "groupAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "tabAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "onGroupChange", "", "start", "", "count", "onGroupInsert", "onGroupMoved", "from", "to", "onGroupRemove", "onTabChange", "onTabInsert", "onTabRemove", "plugin-emojisdk_release"})
public abstract class aa
  implements ab
{
  private final RecyclerView.a<?> jJO;
  private final RecyclerView.a<?> jJP;
  
  public aa(RecyclerView.a<?> parama1, RecyclerView.a<?> parama2)
  {
    this.jJO = parama1;
    this.jJP = parama2;
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    this.jJO.aG(paramInt1, paramInt2);
  }
  
  public final void cV(int paramInt1, int paramInt2)
  {
    this.jJO.aE(paramInt1, paramInt2);
  }
  
  public final void cW(int paramInt1, int paramInt2)
  {
    this.jJO.aH(paramInt1, paramInt2);
  }
  
  public final void db(int paramInt1, int paramInt2)
  {
    this.jJP.aG(paramInt1, paramInt2);
  }
  
  public final void dc(int paramInt1, int paramInt2)
  {
    this.jJP.aE(paramInt1, paramInt2);
  }
  
  public final void dd(int paramInt1, int paramInt2)
  {
    this.jJP.aH(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.aa
 * JD-Core Version:    0.7.0.1
 */