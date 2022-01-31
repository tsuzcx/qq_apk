package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;

final class RecyclerThumbSeekBar$2
  implements Runnable
{
  RecyclerThumbSeekBar$2(RecyclerThumbSeekBar paramRecyclerThumbSeekBar) {}
  
  public final void run()
  {
    AppMethodBeat.i(54978);
    if ((this.oLp.getHeight() == 0) || (this.oLp.getWidth() == 0))
    {
      this.oLp.post(RecyclerThumbSeekBar.e(this.oLp));
      AppMethodBeat.o(54978);
      return;
    }
    RecyclerThumbSeekBar.a(this.oLp, this.oLp.getHeight());
    RecyclerThumbSeekBar.b(this.oLp, (this.oLp.getWidth() - RecyclerThumbSeekBar.f(this.oLp) * 2) / 12);
    d.post(new RecyclerThumbSeekBar.2.1(this), "check duration of ");
    AppMethodBeat.o(54978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.2
 * JD-Core Version:    0.7.0.1
 */