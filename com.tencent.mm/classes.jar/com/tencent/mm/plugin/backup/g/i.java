package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends b
{
  private com.tencent.mm.plugin.backup.i.i rRZ;
  public j rSa;
  
  public i(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21733);
    this.rRZ = new com.tencent.mm.plugin.backup.i.i();
    this.rSa = new j();
    Log.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.rRZ.rVz = paramLinkedList;
    this.rRZ.rVA = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList.next();
      this.rRZ.rVA.add(Long.valueOf(paramLong1));
      this.rRZ.rVA.add(Long.valueOf(paramLong2));
    }
    AppMethodBeat.o(21733);
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21734);
    if ((this.rSa.rVz == null) || (this.rSa.rVA == null) || (this.rSa.rVz.isEmpty()) || (this.rSa.rVz.size() * 2 != this.rSa.rVA.size()))
    {
      if ((this.rSa.rVz != null) && (this.rSa.rVA != null)) {
        Log.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[] { Integer.valueOf(this.rSa.rVz.size()), Integer.valueOf(this.rSa.rVA.size()) });
      }
      r(4, -1, "BackupRequestSession failed");
      AppMethodBeat.o(21734);
      return;
    }
    Log.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[] { Integer.valueOf(this.rSa.rVz.size()), this.rSa.rVz.toString() });
    Log.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[] { this.rSa.rVA.toString() });
    r(0, 0, "BackupRequestSession success");
    AppMethodBeat.o(21734);
  }
  
  public final a ctC()
  {
    return this.rSa;
  }
  
  public final a ctD()
  {
    return this.rRZ;
  }
  
  public final int getType()
  {
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.i
 * JD-Core Version:    0.7.0.1
 */