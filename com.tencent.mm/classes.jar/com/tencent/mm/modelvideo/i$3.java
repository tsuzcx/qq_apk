package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;

final class i$3
  implements Runnable
{
  i$3(i parami, f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(50717);
    long l = this.fWx.cpO;
    synchronized (this.fWw.fWm)
    {
      Iterator localIterator = this.fWw.fWm.iterator();
      while (localIterator.hasNext())
      {
        bi localbi = (bi)localIterator.next();
        if ((localbi != null) && (localbi.field_msgId == l))
        {
          ab.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(this.fWw.hashCode()), Long.valueOf(l) });
          localIterator.remove();
        }
      }
    }
    this.fWw.di(true);
    if (this.fWw.fWu != null) {
      this.fWw.fWu.fVW = null;
    }
    this.fWw.fWu = null;
    i.a(this.fWw);
    this.fWw.alw();
    AppMethodBeat.o(50717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i.3
 * JD-Core Version:    0.7.0.1
 */