package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecyclerThumbSeekBar$6
  implements n.a
{
  RecyclerThumbSeekBar$6(RecyclerThumbSeekBar paramRecyclerThumbSeekBar) {}
  
  public final void bRJ()
  {
    AppMethodBeat.i(54982);
    if ((RecyclerThumbSeekBar.p(this.oLp) != null) && (RecyclerThumbSeekBar.m(this.oLp) != null)) {
      RecyclerThumbSeekBar.p(this.oLp).W(this.oLp.bRy(), this.oLp.bRz());
    }
    AppMethodBeat.o(54982);
  }
  
  public final void bRK()
  {
    AppMethodBeat.i(54983);
    if ((RecyclerThumbSeekBar.p(this.oLp) != null) && (RecyclerThumbSeekBar.m(this.oLp) != null)) {
      RecyclerThumbSeekBar.p(this.oLp).X(this.oLp.bRy(), this.oLp.bRz());
    }
    AppMethodBeat.o(54983);
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(54984);
    if ((RecyclerThumbSeekBar.p(this.oLp) != null) && (RecyclerThumbSeekBar.m(this.oLp) != null)) {
      RecyclerThumbSeekBar.p(this.oLp).Y(this.oLp.bRy(), this.oLp.bRz());
    }
    if (paramBoolean)
    {
      RecyclerThumbSeekBar.m(this.oLp).z(true, RecyclerThumbSeekBar.l(this.oLp).getLeftSliderBound());
      AppMethodBeat.o(54984);
      return;
    }
    RecyclerThumbSeekBar.m(this.oLp).z(false, RecyclerThumbSeekBar.l(this.oLp).getWidth() - RecyclerThumbSeekBar.l(this.oLp).getRightSliderBound());
    AppMethodBeat.o(54984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.6
 * JD-Core Version:    0.7.0.1
 */