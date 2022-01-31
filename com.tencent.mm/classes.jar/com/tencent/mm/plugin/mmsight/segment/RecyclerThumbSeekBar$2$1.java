package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;

final class RecyclerThumbSeekBar$2$1
  implements Runnable
{
  RecyclerThumbSeekBar$2$1(RecyclerThumbSeekBar.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(54977);
    try
    {
      d locald = RecyclerThumbSeekBar.g(this.oLq.oLp).bRA();
      RecyclerThumbSeekBar.c(this.oLq.oLp, locald.getDurationMs());
      RecyclerThumbSeekBar.g(this.oLq.oLp).a(locald);
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
        int i = 0;
      }
      if (RecyclerThumbSeekBar.i(this.oLq.oLp) < 10000) {
        break label203;
      }
      RecyclerThumbSeekBar.d(this.oLq.oLp, RecyclerThumbSeekBar.j(this.oLq.oLp).duration * 1000 / 10);
      for (;;)
      {
        ab.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(this.oLq.oLp)), Integer.valueOf(RecyclerThumbSeekBar.b(this.oLq.oLp)) });
        RecyclerThumbSeekBar.k(this.oLq.oLp);
        AppMethodBeat.o(54977);
        return;
        label203:
        if (RecyclerThumbSeekBar.i(this.oLq.oLp) <= 0) {
          break;
        }
        RecyclerThumbSeekBar.d(this.oLq.oLp, RecyclerThumbSeekBar.i(this.oLq.oLp) / 10);
      }
      ab.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(this.oLq.oLp)) });
      RecyclerThumbSeekBar.h(this.oLq.oLp);
      AppMethodBeat.o(54977);
    }
    if (i == 0)
    {
      RecyclerThumbSeekBar.h(this.oLq.oLp);
      AppMethodBeat.o(54977);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.2.1
 * JD-Core Version:    0.7.0.1
 */