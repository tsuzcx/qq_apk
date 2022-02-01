package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class l
  extends b
{
  private af oQq;
  private ag oQr;
  private a oQs;
  
  public l(String paramString, HashMap<Long, h.a> paramHashMap, a parama)
  {
    AppMethodBeat.i(21740);
    this.oQq = new af();
    this.oQr = new ag();
    this.oQs = parama;
    this.oQq.oTx = paramString;
    Log.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[] { paramString });
    this.oQq.oUR = new LinkedList();
    this.oQq.oUS = new LinkedList();
    this.oQq.oUT = new LinkedList();
    paramString = paramHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      parama = (h.a)paramHashMap.get((Long)paramString.next());
      this.oQq.oUR.add(Long.valueOf(parama.oNJ));
      this.oQq.oUS.add(parama.oNK);
      this.oQq.oUT.add(parama.md5);
    }
    AppMethodBeat.o(21740);
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21741);
    Log.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
    q(0, 0, "success");
    this.oQs.E(this.oQr.oUR);
    AppMethodBeat.o(21741);
  }
  
  public final a cgq()
  {
    return this.oQr;
  }
  
  public final a cgr()
  {
    return this.oQq;
  }
  
  public final int getType()
  {
    return 13;
  }
  
  public static abstract interface a
  {
    public abstract void E(LinkedList<Long> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.l
 * JD-Core Version:    0.7.0.1
 */