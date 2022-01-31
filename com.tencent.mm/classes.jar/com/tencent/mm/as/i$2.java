package com.tencent.mm.as;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class i$2
  implements Runnable
{
  i$2(i parami, l paraml) {}
  
  public final void run()
  {
    y.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[] { Boolean.valueOf(i.b(this.eoG)), Integer.valueOf(this.eoI.hashCode()) });
    if (i.b(this.eoG))
    {
      i.a(this.eoG).offer(this.eoI);
      return;
    }
    g.DO().dJT.a(this.eoI, 0);
    i.a(this.eoG, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.as.i.2
 * JD-Core Version:    0.7.0.1
 */