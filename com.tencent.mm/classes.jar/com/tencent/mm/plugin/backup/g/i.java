package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends b
{
  private com.tencent.mm.plugin.backup.i.i jFT;
  public j jFU;
  
  public i(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(17674);
    this.jFT = new com.tencent.mm.plugin.backup.i.i();
    this.jFU = new j();
    ab.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.jFT.jJw = paramLinkedList;
    this.jFT.jJx = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList.next();
      this.jFT.jJx.add(Long.valueOf(paramLong1));
      this.jFT.jJx.add(Long.valueOf(paramLong2));
    }
    AppMethodBeat.o(17674);
  }
  
  public final a aUl()
  {
    return this.jFU;
  }
  
  public final a aUm()
  {
    return this.jFT;
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(17675);
    if ((this.jFU.jJw == null) || (this.jFU.jJx == null) || (this.jFU.jJw.isEmpty()) || (this.jFU.jJw.size() * 2 != this.jFU.jJx.size()))
    {
      if ((this.jFU.jJw != null) && (this.jFU.jJx != null)) {
        ab.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[] { Integer.valueOf(this.jFU.jJw.size()), Integer.valueOf(this.jFU.jJx.size()) });
      }
      n(4, -1, "BackupRequestSession failed");
      AppMethodBeat.o(17675);
      return;
    }
    ab.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[] { Integer.valueOf(this.jFU.jJw.size()), this.jFU.jJw.toString() });
    ab.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[] { this.jFU.jJx.toString() });
    n(0, 0, "BackupRequestSession success");
    AppMethodBeat.o(17675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.i
 * JD-Core Version:    0.7.0.1
 */