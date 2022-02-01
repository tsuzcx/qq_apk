package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;

final class d$1
  implements Runnable
{
  d$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89284);
    int i = d.access$000();
    while (i < this.EXX)
    {
      q localq1 = new q(String.format("%s/tempvideo%s.mp4", new Object[] { this.EXY, Integer.valueOf(i) }));
      if (localq1.ifE()) {
        localq1.cFq();
      }
      q localq2 = new q(localq1.bOF() + ".remux");
      if (localq2.ifE()) {
        localq2.cFq();
      }
      localq1 = new q(localq1.ifG() + ".thumb");
      if (localq1.ifE()) {
        localq1.cFq();
      }
      i += 1;
    }
    d.access$002(Math.max(this.EXX, 0));
    AppMethodBeat.o(89284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.d.1
 * JD-Core Version:    0.7.0.1
 */