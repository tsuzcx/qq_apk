package com.tencent.mm.emoji.a.a;

import android.support.v7.widget.RecyclerView.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/PanelDataAdapterListener;", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "groupAdapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "tabAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "onGroupChange", "", "start", "", "count", "onGroupInsert", "onGroupMoved", "from", "to", "onGroupRemove", "onTabChange", "onTabInsert", "onTabRemove", "plugin-emojisdk_release"})
public abstract class u
  implements v
{
  private final RecyclerView.a<?> fRU;
  private final RecyclerView.a<?> fRV;
  
  public u(RecyclerView.a<?> parama1, RecyclerView.a<?> parama2)
  {
    this.fRU = parama1;
    this.fRV = parama2;
  }
  
  public final void cC(int paramInt1, int paramInt2)
  {
    this.fRV.aq(paramInt1, paramInt2);
  }
  
  public final void cD(int paramInt1, int paramInt2)
  {
    this.fRV.ao(paramInt1, paramInt2);
  }
  
  public final void cE(int paramInt1, int paramInt2)
  {
    this.fRV.ar(paramInt1, paramInt2);
  }
  
  public final void cv(int paramInt1, int paramInt2)
  {
    this.fRU.aq(paramInt1, paramInt2);
  }
  
  public final void cw(int paramInt1, int paramInt2)
  {
    this.fRU.ao(paramInt1, paramInt2);
  }
  
  public final void cx(int paramInt1, int paramInt2)
  {
    this.fRU.ar(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.u
 * JD-Core Version:    0.7.0.1
 */