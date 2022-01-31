package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class i$2
  implements Runnable
{
  i$2(i parami, l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(78284);
    ab.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[] { Boolean.valueOf(i.b(this.fFd)), Integer.valueOf(this.fFf.hashCode()) });
    if (i.b(this.fFd))
    {
      i.a(this.fFd).offer(this.fFf);
      AppMethodBeat.o(78284);
      return;
    }
    g.RK().eHt.a(this.fFf, 0);
    i.a(this.fFd, true);
    AppMethodBeat.o(78284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.at.i.2
 * JD-Core Version:    0.7.0.1
 */