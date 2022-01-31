package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class l
  extends b
{
  private af hMF = new af();
  private ag hMG = new ag();
  private l.a hMH;
  
  public l(String paramString, HashMap<Long, h.a> paramHashMap, l.a parama)
  {
    this.hMH = parama;
    this.hMF.hPQ = paramString;
    y.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[] { paramString });
    this.hMF.hRn = new LinkedList();
    this.hMF.hRo = new LinkedList();
    this.hMF.hRp = new LinkedList();
    paramString = paramHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      parama = (h.a)paramHashMap.get((Long)paramString.next());
      this.hMF.hRn.add(Long.valueOf(parama.hJW));
      this.hMF.hRo.add(parama.hJX);
      this.hMF.hRp.add(parama.bIW);
    }
  }
  
  public final a auJ()
  {
    return this.hMG;
  }
  
  public final a auK()
  {
    return this.hMF;
  }
  
  public final int getType()
  {
    return 13;
  }
  
  public final void nF(int paramInt)
  {
    y.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
    j(0, 0, "success");
    this.hMH.C(this.hMG.hRn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.l
 * JD-Core Version:    0.7.0.1
 */