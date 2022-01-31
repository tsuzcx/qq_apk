package com.tencent.mm.modelvideo;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;

final class i$3
  implements Runnable
{
  i$3(i parami, f paramf) {}
  
  public final void run()
  {
    long l = this.eGH.bIt;
    synchronized (this.eGG.eGw)
    {
      Iterator localIterator = this.eGG.eGw.iterator();
      while (localIterator.hasNext())
      {
        bi localbi = (bi)localIterator.next();
        if ((localbi != null) && (localbi.field_msgId == l))
        {
          y.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(this.eGG.hashCode()), Long.valueOf(l) });
          localIterator.remove();
        }
      }
    }
    this.eGG.cf(true);
    if (this.eGG.eGE != null) {
      this.eGG.eGE.eGf = null;
    }
    this.eGG.eGE = null;
    i.a(this.eGG);
    this.eGG.Sk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i.3
 * JD-Core Version:    0.7.0.1
 */