package com.tencent.mm.plugin.mmsight.segment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;

final class RecyclerThumbSeekBar$c
  extends RecyclerView.a<RecyclerThumbSeekBar.e>
{
  RecyclerThumbSeekBar.d mmm = new RecyclerThumbSeekBar.d(this.mmi);
  int mmn = RecyclerThumbSeekBar.f(this.mmi);
  int mmo = RecyclerThumbSeekBar.f(this.mmi);
  private View mmp;
  private View mmq;
  
  private RecyclerThumbSeekBar$c(RecyclerThumbSeekBar paramRecyclerThumbSeekBar) {}
  
  public final int getItemCount()
  {
    if (RecyclerThumbSeekBar.i(this.mmi) <= 0) {
      return 0;
    }
    return Math.max(0, (int)Math.floor(RecyclerThumbSeekBar.i(this.mmi) / RecyclerThumbSeekBar.b(this.mmi))) + 2;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == getItemCount() - 1) {
      return 2;
    }
    return 0;
  }
  
  public final void q(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.mmp != null) {
        this.mmp.setMinimumWidth(paramInt);
      }
      if (((LinearLayoutManager)RecyclerThumbSeekBar.n(this.mmi).getLayoutManager()).gY() == 0) {
        RecyclerThumbSeekBar.n(this.mmi).scrollBy(paramInt - this.mmn, 0);
      }
      this.mmn = paramInt;
    }
    do
    {
      return;
      this.mmo = paramInt;
    } while (this.mmq == null);
    this.mmq.setMinimumWidth(this.mmo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.c
 * JD-Core Version:    0.7.0.1
 */