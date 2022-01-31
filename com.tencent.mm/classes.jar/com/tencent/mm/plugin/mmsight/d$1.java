package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

final class d$1
  implements Runnable
{
  d$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(76399);
    int i = d.access$000();
    while (i < this.oFE)
    {
      b localb1 = new b(String.format("%s/tempvideo%s.mp4", new Object[] { this.oFF, Integer.valueOf(i) }));
      if (localb1.exists()) {
        localb1.delete();
      }
      b localb2 = new b(j.p(localb1.dQJ()) + ".remux");
      if (localb2.exists()) {
        localb2.delete();
      }
      localb1 = new b(localb1.dQK() + ".thumb");
      if (localb1.exists()) {
        localb1.delete();
      }
      i += 1;
    }
    d.access$002(Math.max(this.oFE, 0));
    AppMethodBeat.o(76399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.d.1
 * JD-Core Version:    0.7.0.1
 */