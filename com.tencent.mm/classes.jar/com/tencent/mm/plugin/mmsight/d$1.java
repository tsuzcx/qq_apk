package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

final class d$1
  implements Runnable
{
  d$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89284);
    int i = d.access$000();
    while (i < this.tAN)
    {
      e locale1 = new e(String.format("%s/tempvideo%s.mp4", new Object[] { this.tAO, Integer.valueOf(i) }));
      if (locale1.exists()) {
        locale1.delete();
      }
      e locale2 = new e(q.B(locale1.fhU()) + ".remux");
      if (locale2.exists()) {
        locale2.delete();
      }
      locale1 = new e(locale1.fhV() + ".thumb");
      if (locale1.exists()) {
        locale1.delete();
      }
      i += 1;
    }
    d.access$002(Math.max(this.tAN, 0));
    AppMethodBeat.o(89284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.d.1
 * JD-Core Version:    0.7.0.1
 */