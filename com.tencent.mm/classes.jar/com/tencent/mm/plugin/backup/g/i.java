package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends b
{
  private com.tencent.mm.plugin.backup.i.i oQc;
  public j oQd;
  
  public i(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21733);
    this.oQc = new com.tencent.mm.plugin.backup.i.i();
    this.oQd = new j();
    Log.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.oQc.oTB = paramLinkedList;
    this.oQc.oTC = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList.next();
      this.oQc.oTC.add(Long.valueOf(paramLong1));
      this.oQc.oTC.add(Long.valueOf(paramLong2));
    }
    AppMethodBeat.o(21733);
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21734);
    if ((this.oQd.oTB == null) || (this.oQd.oTC == null) || (this.oQd.oTB.isEmpty()) || (this.oQd.oTB.size() * 2 != this.oQd.oTC.size()))
    {
      if ((this.oQd.oTB != null) && (this.oQd.oTC != null)) {
        Log.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[] { Integer.valueOf(this.oQd.oTB.size()), Integer.valueOf(this.oQd.oTC.size()) });
      }
      q(4, -1, "BackupRequestSession failed");
      AppMethodBeat.o(21734);
      return;
    }
    Log.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[] { Integer.valueOf(this.oQd.oTB.size()), this.oQd.oTB.toString() });
    Log.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[] { this.oQd.oTC.toString() });
    q(0, 0, "BackupRequestSession success");
    AppMethodBeat.o(21734);
  }
  
  public final a cgq()
  {
    return this.oQd;
  }
  
  public final a cgr()
  {
    return this.oQc;
  }
  
  public final int getType()
  {
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.i
 * JD-Core Version:    0.7.0.1
 */