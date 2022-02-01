package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends b
{
  private com.tencent.mm.plugin.backup.i.i nFf;
  public j nFg;
  
  public i(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21733);
    this.nFf = new com.tencent.mm.plugin.backup.i.i();
    this.nFg = new j();
    ae.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.nFf.nIF = paramLinkedList;
    this.nFf.nIG = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList.next();
      this.nFf.nIG.add(Long.valueOf(paramLong1));
      this.nFf.nIG.add(Long.valueOf(paramLong2));
    }
    AppMethodBeat.o(21733);
  }
  
  public final a bJx()
  {
    return this.nFg;
  }
  
  public final a bJy()
  {
    return this.nFf;
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final void xG(int paramInt)
  {
    AppMethodBeat.i(21734);
    if ((this.nFg.nIF == null) || (this.nFg.nIG == null) || (this.nFg.nIF.isEmpty()) || (this.nFg.nIF.size() * 2 != this.nFg.nIG.size()))
    {
      if ((this.nFg.nIF != null) && (this.nFg.nIG != null)) {
        ae.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[] { Integer.valueOf(this.nFg.nIF.size()), Integer.valueOf(this.nFg.nIG.size()) });
      }
      q(4, -1, "BackupRequestSession failed");
      AppMethodBeat.o(21734);
      return;
    }
    ae.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[] { Integer.valueOf(this.nFg.nIF.size()), this.nFg.nIF.toString() });
    ae.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[] { this.nFg.nIG.toString() });
    q(0, 0, "BackupRequestSession success");
    AppMethodBeat.o(21734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.i
 * JD-Core Version:    0.7.0.1
 */