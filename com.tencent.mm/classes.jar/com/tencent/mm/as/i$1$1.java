package com.tencent.mm.as;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class i$1$1
  implements Runnable
{
  i$1$1(i.1 param1) {}
  
  public final void run()
  {
    y.i("MicroMsg.ImgService", "on image upload end. queue size : " + i.a(this.eoH.eoG).size());
    i.a(this.eoH.eoG, false);
    if (i.a(this.eoH.eoG).size() > 0)
    {
      l locall = (l)i.a(this.eoH.eoG).poll();
      if (locall != null)
      {
        y.i("MicroMsg.ImgService", "upload image scene hashcode : " + locall.hashCode());
        g.DO().dJT.a(locall, 0);
        i.a(this.eoH.eoG, true);
      }
    }
    else
    {
      return;
    }
    y.w("MicroMsg.ImgService", "poll image scene is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.as.i.1.1
 * JD-Core Version:    0.7.0.1
 */