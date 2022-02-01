package com.tencent.mm.plugin.f.c;

import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends b
{
  private long cacheSize;
  private boolean isStop;
  private LinkedList<String> nSF;
  private a nSG;
  
  public a(LinkedList<String> paramLinkedList, long paramLong, a parama)
  {
    AppMethodBeat.i(195962);
    this.nSF = paramLinkedList;
    this.cacheSize = paramLong;
    this.nSG = parama;
    ac.d("MicroMsg.CleanCacheTask", "%d clean cache [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.nSF.size()) });
    AppMethodBeat.o(195962);
  }
  
  public final String getKey()
  {
    return "ScanMsgTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(195963);
    if (this.isStop)
    {
      AppMethodBeat.o(195963);
      return;
    }
    long l = bs.Gn();
    Object localObject = this.nSF.iterator();
    while (((Iterator)localObject).hasNext()) {
      i.cU((String)((Iterator)localObject).next(), true);
    }
    l = bs.aO(l);
    ac.d("MicroMsg.CleanCacheTask", "%d clean cache costTime[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("0,0,0,0,0,0,0,0,0,0,0,0,").append(this.cacheSize);
    h.wUl.kvStat(14762, ((StringBuffer)localObject).toString());
    if (this.nSG != null) {
      this.nSG.bOA();
    }
    AppMethodBeat.o(195963);
  }
  
  public static abstract interface a
  {
    public abstract void bOA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.a
 * JD-Core Version:    0.7.0.1
 */