package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends b
{
  private com.tencent.mm.plugin.backup.i.i hMr = new com.tencent.mm.plugin.backup.i.i();
  public j hMs = new j();
  
  public i(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    y.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.hMr.hPU = paramLinkedList;
    this.hMr.hPV = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList.next();
      this.hMr.hPV.add(Long.valueOf(paramLong1));
      this.hMr.hPV.add(Long.valueOf(paramLong2));
    }
  }
  
  public final a auJ()
  {
    return this.hMs;
  }
  
  public final a auK()
  {
    return this.hMr;
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final void nF(int paramInt)
  {
    if ((this.hMs.hPU == null) || (this.hMs.hPV == null) || (this.hMs.hPU.isEmpty()) || (this.hMs.hPU.size() * 2 != this.hMs.hPV.size()))
    {
      if ((this.hMs.hPU != null) && (this.hMs.hPV != null)) {
        y.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[] { Integer.valueOf(this.hMs.hPU.size()), Integer.valueOf(this.hMs.hPV.size()) });
      }
      j(4, -1, "BackupRequestSession failed");
      return;
    }
    y.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[] { Integer.valueOf(this.hMs.hPU.size()), this.hMs.hPU.toString() });
    y.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[] { this.hMs.hPV.toString() });
    j(0, 0, "BackupRequestSession success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.i
 * JD-Core Version:    0.7.0.1
 */