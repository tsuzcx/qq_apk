package com.tencent.mm.emoji.c.b;

import androidx.recyclerview.widget.RecyclerView.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/PanelDataAdapterListener;", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "groupAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "tabAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "onGroupChange", "", "start", "", "count", "onGroupInsert", "onGroupMoved", "from", "to", "onGroupRemove", "onTabChange", "onTabInsert", "onTabRemove", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class aa
  implements ab
{
  private final RecyclerView.a<?> mjg;
  private final RecyclerView.a<?> mjh;
  
  public aa(RecyclerView.a<?> parama1, RecyclerView.a<?> parama2)
  {
    this.mjg = parama1;
    this.mjh = parama2;
  }
  
  public final void dH(int paramInt1, int paramInt2)
  {
    this.mjg.bA(paramInt1, paramInt2);
  }
  
  public final void dI(int paramInt1, int paramInt2)
  {
    this.mjg.by(paramInt1, paramInt2);
  }
  
  public final void dJ(int paramInt1, int paramInt2)
  {
    this.mjg.bB(paramInt1, paramInt2);
  }
  
  public final void dO(int paramInt1, int paramInt2)
  {
    this.mjh.bA(paramInt1, paramInt2);
  }
  
  public final void dP(int paramInt1, int paramInt2)
  {
    this.mjh.by(paramInt1, paramInt2);
  }
  
  public final void dQ(int paramInt1, int paramInt2)
  {
    this.mjh.bB(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.aa
 * JD-Core Version:    0.7.0.1
 */