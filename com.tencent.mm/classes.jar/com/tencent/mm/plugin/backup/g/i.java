package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends b
{
  private com.tencent.mm.plugin.backup.i.i nzK;
  public j nzL;
  
  public i(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21733);
    this.nzK = new com.tencent.mm.plugin.backup.i.i();
    this.nzL = new j();
    ad.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.nzK.nDk = paramLinkedList;
    this.nzK.nDl = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList.next();
      this.nzK.nDl.add(Long.valueOf(paramLong1));
      this.nzK.nDl.add(Long.valueOf(paramLong2));
    }
    AppMethodBeat.o(21733);
  }
  
  public final a bIA()
  {
    return this.nzK;
  }
  
  public final a bIz()
  {
    return this.nzL;
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final void xC(int paramInt)
  {
    AppMethodBeat.i(21734);
    if ((this.nzL.nDk == null) || (this.nzL.nDl == null) || (this.nzL.nDk.isEmpty()) || (this.nzL.nDk.size() * 2 != this.nzL.nDl.size()))
    {
      if ((this.nzL.nDk != null) && (this.nzL.nDl != null)) {
        ad.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[] { Integer.valueOf(this.nzL.nDk.size()), Integer.valueOf(this.nzL.nDl.size()) });
      }
      q(4, -1, "BackupRequestSession failed");
      AppMethodBeat.o(21734);
      return;
    }
    ad.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[] { Integer.valueOf(this.nzL.nDk.size()), this.nzL.nDk.toString() });
    ad.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[] { this.nzL.nDl.toString() });
    q(0, 0, "BackupRequestSession success");
    AppMethodBeat.o(21734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.i
 * JD-Core Version:    0.7.0.1
 */