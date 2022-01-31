package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

final class d$1
  implements Runnable
{
  d$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    int i = d.access$000();
    while (i < this.mff)
    {
      b localb1 = new b(String.format("%s/tempvideo%s.mp4", new Object[] { this.mfg, Integer.valueOf(i) }));
      if (localb1.exists()) {
        localb1.delete();
      }
      b localb2 = new b(j.n(localb1.cLr()) + ".remux");
      if (localb2.exists()) {
        localb2.delete();
      }
      localb1 = new b(localb1.cLs() + ".thumb");
      if (localb1.exists()) {
        localb1.delete();
      }
      i += 1;
    }
    d.access$002(Math.max(this.mff, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.d.1
 * JD-Core Version:    0.7.0.1
 */