package com.google.android.material.appbar;

import android.view.View;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  int doW;
  private int doX;
  int doY;
  int doZ;
  private final View view;
  
  public a(View paramView)
  {
    this.view = paramView;
  }
  
  public final void VE()
  {
    AppMethodBeat.i(210031);
    this.doW = this.view.getTop();
    this.doX = this.view.getLeft();
    VF();
    AppMethodBeat.o(210031);
  }
  
  final void VF()
  {
    AppMethodBeat.i(210039);
    z.s(this.view, this.doY - (this.view.getTop() - this.doW));
    z.u(this.view, this.doZ - (this.view.getLeft() - this.doX));
    AppMethodBeat.o(210039);
  }
  
  public final boolean ji(int paramInt)
  {
    AppMethodBeat.i(210047);
    if (this.doY != paramInt)
    {
      this.doY = paramInt;
      VF();
      AppMethodBeat.o(210047);
      return true;
    }
    AppMethodBeat.o(210047);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.appbar.a
 * JD-Core Version:    0.7.0.1
 */