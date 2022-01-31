package com.tencent.mm.plugin.mmsight.segment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecyclerThumbSeekBar$c
  extends RecyclerView.a<RecyclerThumbSeekBar.e>
{
  RecyclerThumbSeekBar.d oLu;
  int oLv;
  int oLw;
  private View oLx;
  private View oLy;
  
  private RecyclerThumbSeekBar$c(RecyclerThumbSeekBar paramRecyclerThumbSeekBar)
  {
    AppMethodBeat.i(54988);
    this.oLu = new RecyclerThumbSeekBar.d(this.oLp);
    this.oLv = RecyclerThumbSeekBar.f(this.oLp);
    this.oLw = RecyclerThumbSeekBar.f(this.oLp);
    AppMethodBeat.o(54988);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(54991);
    if (RecyclerThumbSeekBar.i(this.oLp) <= 0)
    {
      AppMethodBeat.o(54991);
      return 0;
    }
    int i = Math.max(0, (int)Math.floor(RecyclerThumbSeekBar.i(this.oLp) / RecyclerThumbSeekBar.b(this.oLp)));
    AppMethodBeat.o(54991);
    return i + 2;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(54989);
    if (paramInt == 0)
    {
      AppMethodBeat.o(54989);
      return 1;
    }
    if (paramInt == getItemCount() - 1)
    {
      AppMethodBeat.o(54989);
      return 2;
    }
    AppMethodBeat.o(54989);
    return 0;
  }
  
  public final void z(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(54990);
    if (paramBoolean)
    {
      if (this.oLx != null) {
        this.oLx.setMinimumWidth(paramInt);
      }
      if (((LinearLayoutManager)RecyclerThumbSeekBar.n(this.oLp).getLayoutManager()).it() == 0) {
        RecyclerThumbSeekBar.n(this.oLp).scrollBy(paramInt - this.oLv, 0);
      }
      this.oLv = paramInt;
      AppMethodBeat.o(54990);
      return;
    }
    this.oLw = paramInt;
    if (this.oLy != null) {
      this.oLy.setMinimumWidth(this.oLw);
    }
    AppMethodBeat.o(54990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.c
 * JD-Core Version:    0.7.0.1
 */