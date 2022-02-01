package com.tencent.mm.plugin.f.c;

import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends b
{
  private long cacheSize;
  private boolean isStop;
  private LinkedList<String> npF;
  private a npG;
  
  public a(LinkedList<String> paramLinkedList, long paramLong, a parama)
  {
    AppMethodBeat.i(191156);
    this.npF = paramLinkedList;
    this.cacheSize = paramLong;
    this.npG = parama;
    ad.d("MicroMsg.CleanCacheTask", "%d clean cache [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.npF.size()) });
    AppMethodBeat.o(191156);
  }
  
  public final String getKey()
  {
    return "ScanMsgTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(191157);
    if (this.isStop)
    {
      AppMethodBeat.o(191157);
      return;
    }
    long l = bt.GC();
    Object localObject = this.npF.iterator();
    while (((Iterator)localObject).hasNext()) {
      i.cO((String)((Iterator)localObject).next(), true);
    }
    l = bt.aS(l);
    ad.d("MicroMsg.CleanCacheTask", "%d clean cache costTime[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("0,0,0,0,0,0,0,0,0,0,0,0,").append(this.cacheSize);
    h.vKh.kvStat(14762, ((StringBuffer)localObject).toString());
    if (this.npG != null) {
      this.npG.bHn();
    }
    AppMethodBeat.o(191157);
  }
  
  public static abstract interface a
  {
    public abstract void bHn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.a
 * JD-Core Version:    0.7.0.1
 */