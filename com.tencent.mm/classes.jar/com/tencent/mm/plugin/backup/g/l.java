package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
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
  private af rSn;
  private ag rSo;
  private a rSp;
  
  public l(String paramString, HashMap<Long, h.a> paramHashMap, a parama)
  {
    AppMethodBeat.i(21740);
    this.rSn = new af();
    this.rSo = new ag();
    this.rSp = parama;
    this.rSn.rVv = paramString;
    Log.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[] { paramString });
    this.rSn.rWQ = new LinkedList();
    this.rSn.rWR = new LinkedList();
    this.rSn.rWS = new LinkedList();
    paramString = paramHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      parama = (h.a)paramHashMap.get((Long)paramString.next());
      this.rSn.rWQ.add(Long.valueOf(parama.rPF));
      this.rSn.rWR.add(parama.rPG);
      this.rSn.rWS.add(parama.md5);
    }
    AppMethodBeat.o(21740);
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21741);
    Log.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
    r(0, 0, "success");
    this.rSp.F(this.rSo.rWQ);
    AppMethodBeat.o(21741);
  }
  
  public final a ctC()
  {
    return this.rSo;
  }
  
  public final a ctD()
  {
    return this.rSn;
  }
  
  public final int getType()
  {
    return 13;
  }
  
  public static abstract interface a
  {
    public abstract void F(LinkedList<Long> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.l
 * JD-Core Version:    0.7.0.1
 */