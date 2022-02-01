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
  private af mxA;
  private ag mxB;
  private a mxC;
  
  public l(String paramString, HashMap<Long, h.a> paramHashMap, a parama)
  {
    AppMethodBeat.i(21740);
    this.mxA = new af();
    this.mxB = new ag();
    this.mxC = parama;
    this.mxA.mAI = paramString;
    ad.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[] { paramString });
    this.mxA.mCd = new LinkedList();
    this.mxA.mCe = new LinkedList();
    this.mxA.mCf = new LinkedList();
    paramString = paramHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      parama = (h.a)paramHashMap.get((Long)paramString.next());
      this.mxA.mCd.add(Long.valueOf(parama.muT));
      this.mxA.mCe.add(parama.muU);
      this.mxA.mCf.add(parama.md5);
    }
    AppMethodBeat.o(21740);
  }
  
  public final a bxu()
  {
    return this.mxB;
  }
  
  public final a bxv()
  {
    return this.mxA;
  }
  
  public final int getType()
  {
    return 13;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(21741);
    ad.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
    q(0, 0, "success");
    this.mxC.E(this.mxB.mCd);
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