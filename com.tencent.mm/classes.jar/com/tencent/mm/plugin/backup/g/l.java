package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class l
  extends b
{
  private af mZB;
  private ag mZC;
  private a mZD;
  
  public l(String paramString, HashMap<Long, h.a> paramHashMap, a parama)
  {
    AppMethodBeat.i(21740);
    this.mZB = new af();
    this.mZC = new ag();
    this.mZD = parama;
    this.mZB.ncJ = paramString;
    ac.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[] { paramString });
    this.mZB.nee = new LinkedList();
    this.mZB.nef = new LinkedList();
    this.mZB.neg = new LinkedList();
    paramString = paramHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      parama = (h.a)paramHashMap.get((Long)paramString.next());
      this.mZB.nee.add(Long.valueOf(parama.mWU));
      this.mZB.nef.add(parama.mWV);
      this.mZB.neg.add(parama.md5);
    }
    AppMethodBeat.o(21740);
  }
  
  public final a bEq()
  {
    return this.mZC;
  }
  
  public final a bEr()
  {
    return this.mZB;
  }
  
  public final int getType()
  {
    return 13;
  }
  
  public final void wW(int paramInt)
  {
    AppMethodBeat.i(21741);
    ac.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
    q(0, 0, "success");
    this.mZD.E(this.mZC.nee);
    AppMethodBeat.o(21741);
  }
  
  public static abstract interface a
  {
    public abstract void E(LinkedList<Long> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.l
 * JD-Core Version:    0.7.0.1
 */