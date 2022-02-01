package com.google.android.material.appbar;

import android.view.View;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  int bvT;
  private int bvU;
  int bvV;
  int bvW;
  private final View view;
  
  public a(View paramView)
  {
    this.view = paramView;
  }
  
  public final boolean fT(int paramInt)
  {
    AppMethodBeat.i(234810);
    if (this.bvV != paramInt)
    {
      this.bvV = paramInt;
      wg();
      AppMethodBeat.o(234810);
      return true;
    }
    AppMethodBeat.o(234810);
    return false;
  }
  
  public final void wf()
  {
    AppMethodBeat.i(234808);
    this.bvT = this.view.getTop();
    this.bvU = this.view.getLeft();
    wg();
    AppMethodBeat.o(234808);
  }
  
  final void wg()
  {
    AppMethodBeat.i(234809);
    w.s(this.view, this.bvV - (this.view.getTop() - this.bvT));
    w.u(this.view, this.bvW - (this.view.getLeft() - this.bvU));
    AppMethodBeat.o(234809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.appbar.a
 * JD-Core Version:    0.7.0.1
 */