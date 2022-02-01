package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class l
  extends b
{
  private a nAa;
  private af nzY;
  private ag nzZ;
  
  public l(String paramString, HashMap<Long, h.a> paramHashMap, a parama)
  {
    AppMethodBeat.i(21740);
    this.nzY = new af();
    this.nzZ = new ag();
    this.nAa = parama;
    this.nzY.nDg = paramString;
    ad.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[] { paramString });
    this.nzY.nEB = new LinkedList();
    this.nzY.nEC = new LinkedList();
    this.nzY.nED = new LinkedList();
    paramString = paramHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      parama = (h.a)paramHashMap.get((Long)paramString.next());
      this.nzY.nEB.add(Long.valueOf(parama.nxr));
      this.nzY.nEC.add(parama.nxs);
      this.nzY.nED.add(parama.md5);
    }
    AppMethodBeat.o(21740);
  }
  
  public final a bIA()
  {
    return this.nzY;
  }
  
  public final a bIz()
  {
    return this.nzZ;
  }
  
  public final int getType()
  {
    return 13;
  }
  
  public final void xC(int paramInt)
  {
    AppMethodBeat.i(21741);
    ad.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
    q(0, 0, "success");
    this.nAa.E(this.nzZ.nEB);
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