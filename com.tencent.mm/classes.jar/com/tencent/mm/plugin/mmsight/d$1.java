package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

final class d$1
  implements Runnable
{
  d$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89284);
    int i = d.access$000();
    while (i < this.zsw)
    {
      o localo1 = new o(String.format("%s/tempvideo%s.mp4", new Object[] { this.zsx, Integer.valueOf(i) }));
      if (localo1.exists()) {
        localo1.delete();
      }
      o localo2 = new o(aa.z(localo1.her()) + ".remux");
      if (localo2.exists()) {
        localo2.delete();
      }
      localo1 = new o(localo1.hes() + ".thumb");
      if (localo1.exists()) {
        localo1.delete();
      }
      i += 1;
    }
    d.access$002(Math.max(this.zsw, 0));
    AppMethodBeat.o(89284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.d.1
 * JD-Core Version:    0.7.0.1
 */