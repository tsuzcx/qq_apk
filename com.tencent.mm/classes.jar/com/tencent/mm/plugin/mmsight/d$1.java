package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

final class d$1
  implements Runnable
{
  d$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89284);
    int i = d.access$000();
    while (i < this.vYu)
    {
      k localk1 = new k(String.format("%s/tempvideo%s.mp4", new Object[] { this.vYv, Integer.valueOf(i) }));
      if (localk1.exists()) {
        localk1.delete();
      }
      k localk2 = new k(w.B(localk1.fTh()) + ".remux");
      if (localk2.exists()) {
        localk2.delete();
      }
      localk1 = new k(localk1.fTi() + ".thumb");
      if (localk1.exists()) {
        localk1.delete();
      }
      i += 1;
    }
    d.access$002(Math.max(this.vYu, 0));
    AppMethodBeat.o(89284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.d.1
 * JD-Core Version:    0.7.0.1
 */