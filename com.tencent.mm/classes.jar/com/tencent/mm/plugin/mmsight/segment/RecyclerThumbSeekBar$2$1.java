package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.y;

final class RecyclerThumbSeekBar$2$1
  implements Runnable
{
  RecyclerThumbSeekBar$2$1(RecyclerThumbSeekBar.2 param2) {}
  
  public final void run()
  {
    try
    {
      d locald = RecyclerThumbSeekBar.g(this.mmj.mmi).bjN();
      RecyclerThumbSeekBar.c(this.mmj.mmi, locald.getDurationMs());
      RecyclerThumbSeekBar.g(this.mmj.mmi).a(locald);
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("RecyclerThumbSeekBar", localException, "Try to init fetcher error : %s", new Object[] { localException.getMessage() });
        int i = 0;
      }
      if (RecyclerThumbSeekBar.i(this.mmj.mmi) < 10000) {
        break label188;
      }
      RecyclerThumbSeekBar.d(this.mmj.mmi, RecyclerThumbSeekBar.j(this.mmj.mmi).duration * 1000 / 10);
      for (;;)
      {
        y.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(this.mmj.mmi)), Integer.valueOf(RecyclerThumbSeekBar.b(this.mmj.mmi)) });
        RecyclerThumbSeekBar.k(this.mmj.mmi);
        return;
        label188:
        if (RecyclerThumbSeekBar.i(this.mmj.mmi) <= 0) {
          break;
        }
        RecyclerThumbSeekBar.d(this.mmj.mmi, RecyclerThumbSeekBar.i(this.mmj.mmi) / 10);
      }
      y.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.i(this.mmj.mmi)) });
      RecyclerThumbSeekBar.h(this.mmj.mmi);
    }
    if (i == 0)
    {
      RecyclerThumbSeekBar.h(this.mmj.mmi);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.2.1
 * JD-Core Version:    0.7.0.1
 */