package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class l
  extends b
{
  private af jGh;
  private ag jGi;
  private l.a jGj;
  
  public l(String paramString, HashMap<Long, h.a> paramHashMap, l.a parama)
  {
    AppMethodBeat.i(17681);
    this.jGh = new af();
    this.jGi = new ag();
    this.jGj = parama;
    this.jGh.jJs = paramString;
    ab.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[] { paramString });
    this.jGh.jKO = new LinkedList();
    this.jGh.jKP = new LinkedList();
    this.jGh.jKQ = new LinkedList();
    paramString = paramHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      parama = (h.a)paramHashMap.get((Long)paramString.next());
      this.jGh.jKO.add(Long.valueOf(parama.jDz));
      this.jGh.jKP.add(parama.jDA);
      this.jGh.jKQ.add(parama.cqq);
    }
    AppMethodBeat.o(17681);
  }
  
  public final a aUl()
  {
    return this.jGi;
  }
  
  public final a aUm()
  {
    return this.jGh;
  }
  
  public final int getType()
  {
    return 13;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(17682);
    ab.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
    n(0, 0, "success");
    this.jGj.D(this.jGi.jKO);
    AppMethodBeat.o(17682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.l
 * JD-Core Version:    0.7.0.1
 */