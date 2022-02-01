package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends b
{
  private com.tencent.mm.plugin.backup.i.i mZn;
  public j mZo;
  
  public i(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21733);
    this.mZn = new com.tencent.mm.plugin.backup.i.i();
    this.mZo = new j();
    ac.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.mZn.ncN = paramLinkedList;
    this.mZn.ncO = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList.next();
      this.mZn.ncO.add(Long.valueOf(paramLong1));
      this.mZn.ncO.add(Long.valueOf(paramLong2));
    }
    AppMethodBeat.o(21733);
  }
  
  public final a bEq()
  {
    return this.mZo;
  }
  
  public final a bEr()
  {
    return this.mZn;
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final void wW(int paramInt)
  {
    AppMethodBeat.i(21734);
    if ((this.mZo.ncN == null) || (this.mZo.ncO == null) || (this.mZo.ncN.isEmpty()) || (this.mZo.ncN.size() * 2 != this.mZo.ncO.size()))
    {
      if ((this.mZo.ncN != null) && (this.mZo.ncO != null)) {
        ac.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[] { Integer.valueOf(this.mZo.ncN.size()), Integer.valueOf(this.mZo.ncO.size()) });
      }
      q(4, -1, "BackupRequestSession failed");
      AppMethodBeat.o(21734);
      return;
    }
    ac.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[] { Integer.valueOf(this.mZo.ncN.size()), this.mZo.ncN.toString() });
    ac.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[] { this.mZo.ncO.toString() });
    q(0, 0, "BackupRequestSession success");
    AppMethodBeat.o(21734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.i
 * JD-Core Version:    0.7.0.1
 */