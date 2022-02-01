package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

final class d$1
  implements Runnable
{
  d$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89284);
    int i = d.access$000();
    while (i < this.KTJ)
    {
      u localu1 = new u(String.format("%s/tempvideo%s.mp4", new Object[] { this.KTK, Integer.valueOf(i) }));
      if (localu1.jKS()) {
        localu1.diJ();
      }
      u localu2 = new u(ah.v(localu1.jKT()) + ".remux");
      if (localu2.jKS()) {
        localu2.diJ();
      }
      localu1 = new u(localu1.jKU() + ".thumb");
      if (localu1.jKS()) {
        localu1.diJ();
      }
      i += 1;
    }
    d.access$002(Math.max(this.KTJ, 0));
    AppMethodBeat.o(89284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.d.1
 * JD-Core Version:    0.7.0.1
 */