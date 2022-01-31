package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class i$1$1
  implements Runnable
{
  i$1$1(i.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(78282);
    ab.i("MicroMsg.ImgService", "on image upload end. queue size : " + i.a(this.fFe.fFd).size());
    i.a(this.fFe.fFd, false);
    if (i.a(this.fFe.fFd).size() > 0)
    {
      l locall = (l)i.a(this.fFe.fFd).poll();
      if (locall != null)
      {
        ab.i("MicroMsg.ImgService", "upload image scene hashcode : " + locall.hashCode());
        g.RK().eHt.a(locall, 0);
        i.a(this.fFe.fFd, true);
        AppMethodBeat.o(78282);
        return;
      }
      ab.w("MicroMsg.ImgService", "poll image scene is null");
    }
    AppMethodBeat.o(78282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.at.i.1.1
 * JD-Core Version:    0.7.0.1
 */