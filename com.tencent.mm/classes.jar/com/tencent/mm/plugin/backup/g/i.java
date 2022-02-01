package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends b
{
  private com.tencent.mm.plugin.backup.i.i vdp;
  public j vdq;
  
  public i(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21733);
    this.vdp = new com.tencent.mm.plugin.backup.i.i();
    this.vdq = new j();
    Log.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.vdp.vgP = paramLinkedList;
    this.vdp.vgQ = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList.next();
      this.vdp.vgQ.add(Long.valueOf(paramLong1));
      this.vdp.vgQ.add(Long.valueOf(paramLong2));
    }
    AppMethodBeat.o(21733);
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21734);
    if ((this.vdq.vgP == null) || (this.vdq.vgQ == null) || (this.vdq.vgP.isEmpty()) || (this.vdq.vgP.size() * 2 != this.vdq.vgQ.size()))
    {
      if ((this.vdq.vgP != null) && (this.vdq.vgQ != null)) {
        Log.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[] { Integer.valueOf(this.vdq.vgP.size()), Integer.valueOf(this.vdq.vgQ.size()) });
      }
      u(4, -1, "BackupRequestSession failed");
      AppMethodBeat.o(21734);
      return;
    }
    Log.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[] { Integer.valueOf(this.vdq.vgP.size()), this.vdq.vgP.toString() });
    Log.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[] { this.vdq.vgQ.toString() });
    u(0, 0, "BackupRequestSession success");
    AppMethodBeat.o(21734);
  }
  
  public final a cWm()
  {
    return this.vdq;
  }
  
  public final a cWn()
  {
    return this.vdp;
  }
  
  public final int getType()
  {
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.i
 * JD-Core Version:    0.7.0.1
 */