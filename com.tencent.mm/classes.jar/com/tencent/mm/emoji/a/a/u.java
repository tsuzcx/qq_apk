package com.tencent.mm.emoji.a.a;

import android.support.v7.widget.RecyclerView.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/PanelDataAdapterListener;", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "groupAdapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "tabAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "onGroupChange", "", "start", "", "count", "onGroupInsert", "onGroupMoved", "from", "to", "onGroupRemove", "onTabChange", "onTabInsert", "onTabRemove", "plugin-emojisdk_release"})
public abstract class u
  implements v
{
  private final RecyclerView.a<?> fOj;
  private final RecyclerView.a<?> fOk;
  
  public u(RecyclerView.a<?> parama1, RecyclerView.a<?> parama2)
  {
    this.fOj = parama1;
    this.fOk = parama2;
  }
  
  public final void cE(int paramInt1, int paramInt2)
  {
    this.fOk.aq(paramInt1, paramInt2);
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    this.fOk.ao(paramInt1, paramInt2);
  }
  
  public final void cG(int paramInt1, int paramInt2)
  {
    this.fOk.ar(paramInt1, paramInt2);
  }
  
  public final void cx(int paramInt1, int paramInt2)
  {
    this.fOj.aq(paramInt1, paramInt2);
  }
  
  public final void cy(int paramInt1, int paramInt2)
  {
    this.fOj.ao(paramInt1, paramInt2);
  }
  
  public final void cz(int paramInt1, int paramInt2)
  {
    this.fOj.ar(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.u
 * JD-Core Version:    0.7.0.1
 */