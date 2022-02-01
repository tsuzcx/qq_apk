package com.tencent.mm.plugin.f.c;

import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends b
{
  private long cacheSize;
  private boolean isStop;
  private LinkedList<String> oCB;
  private List<Runnable> oCC;
  private a oCD;
  
  public a(LinkedList<String> paramLinkedList, long paramLong, List<Runnable> paramList, a parama)
  {
    AppMethodBeat.i(186430);
    this.oCB = paramLinkedList;
    this.cacheSize = paramLong;
    this.oCD = parama;
    this.oCC = paramList;
    ae.d("MicroMsg.CleanCacheTask", "%d clean cache [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.oCB.size()) });
    AppMethodBeat.o(186430);
  }
  
  public final String getKey()
  {
    return "ScanMsgTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(186431);
    if (this.isStop)
    {
      AppMethodBeat.o(186431);
      return;
    }
    long l = bu.HQ();
    Object localObject = this.oCB.iterator();
    while (((Iterator)localObject).hasNext()) {
      o.dd((String)((Iterator)localObject).next(), true);
    }
    if (this.oCC != null)
    {
      localObject = this.oCC.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    l = bu.aO(l);
    ae.d("MicroMsg.CleanCacheTask", "%d clean cache costTime[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("0,0,0,0,0,0,0,0,0,0,0,0,").append(this.cacheSize);
    g.yxI.kvStat(14762, ((StringBuffer)localObject).toString());
    if (this.oCD != null) {
      this.oCD.bUu();
    }
    AppMethodBeat.o(186431);
  }
  
  public static abstract interface a
  {
    public abstract void bUu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.a
 * JD-Core Version:    0.7.0.1
 */