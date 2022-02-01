package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class l
  extends b
{
  private af nFt;
  private ag nFu;
  private a nFv;
  
  public l(String paramString, HashMap<Long, h.a> paramHashMap, a parama)
  {
    AppMethodBeat.i(21740);
    this.nFt = new af();
    this.nFu = new ag();
    this.nFv = parama;
    this.nFt.nIB = paramString;
    ae.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[] { paramString });
    this.nFt.nJW = new LinkedList();
    this.nFt.nJX = new LinkedList();
    this.nFt.nJY = new LinkedList();
    paramString = paramHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      parama = (h.a)paramHashMap.get((Long)paramString.next());
      this.nFt.nJW.add(Long.valueOf(parama.nCM));
      this.nFt.nJX.add(parama.nCN);
      this.nFt.nJY.add(parama.md5);
    }
    AppMethodBeat.o(21740);
  }
  
  public final a bJx()
  {
    return this.nFu;
  }
  
  public final a bJy()
  {
    return this.nFt;
  }
  
  public final int getType()
  {
    return 13;
  }
  
  public final void xG(int paramInt)
  {
    AppMethodBeat.i(21741);
    ae.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
    q(0, 0, "success");
    this.nFv.E(this.nFu.nJW);
    AppMethodBeat.o(21741);
  }
  
  public static abstract interface a
  {
    public abstract void E(LinkedList<Long> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.l
 * JD-Core Version:    0.7.0.1
 */