package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
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
  private af vdD;
  private ag vdE;
  private a vdF;
  
  public l(String paramString, HashMap<Long, h.a> paramHashMap, a parama)
  {
    AppMethodBeat.i(21740);
    this.vdD = new af();
    this.vdE = new ag();
    this.vdF = parama;
    this.vdD.vgL = paramString;
    Log.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[] { paramString });
    this.vdD.vih = new LinkedList();
    this.vdD.vii = new LinkedList();
    this.vdD.vij = new LinkedList();
    paramString = paramHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      parama = (h.a)paramHashMap.get((Long)paramString.next());
      this.vdD.vih.add(Long.valueOf(parama.vaU));
      this.vdD.vii.add(parama.vaV);
      this.vdD.vij.add(parama.md5);
    }
    AppMethodBeat.o(21740);
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21741);
    Log.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
    u(0, 0, "success");
    this.vdF.I(this.vdE.vih);
    AppMethodBeat.o(21741);
  }
  
  public final a cWm()
  {
    return this.vdE;
  }
  
  public final a cWn()
  {
    return this.vdD;
  }
  
  public final int getType()
  {
    return 13;
  }
  
  public static abstract interface a
  {
    public abstract void I(LinkedList<Long> paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.l
 * JD-Core Version:    0.7.0.1
 */