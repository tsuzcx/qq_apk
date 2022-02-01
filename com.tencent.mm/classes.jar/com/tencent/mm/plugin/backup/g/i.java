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
  private com.tencent.mm.plugin.backup.i.i mxm;
  public j mxn;
  
  public i(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21733);
    this.mxm = new com.tencent.mm.plugin.backup.i.i();
    this.mxn = new j();
    ad.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.mxm.mAM = paramLinkedList;
    this.mxm.mAN = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      paramLinkedList.next();
      this.mxm.mAN.add(Long.valueOf(paramLong1));
      this.mxm.mAN.add(Long.valueOf(paramLong2));
    }
    AppMethodBeat.o(21733);
  }
  
  public final a bxu()
  {
    return this.mxn;
  }
  
  public final a bxv()
  {
    return this.mxm;
  }
  
  public final int getType()
  {
    return 11;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(21734);
    if ((this.mxn.mAM == null) || (this.mxn.mAN == null) || (this.mxn.mAM.isEmpty()) || (this.mxn.mAM.size() * 2 != this.mxn.mAN.size()))
    {
      if ((this.mxn.mAM != null) && (this.mxn.mAN != null)) {
        ad.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[] { Integer.valueOf(this.mxn.mAM.size()), Integer.valueOf(this.mxn.mAN.size()) });
      }
      q(4, -1, "BackupRequestSession failed");
      AppMethodBeat.o(21734);
      return;
    }
    ad.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[] { Integer.valueOf(this.mxn.mAM.size()), this.mxn.mAM.toString() });
    ad.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[] { this.mxn.mAN.toString() });
    q(0, 0, "BackupRequestSession success");
    AppMethodBeat.o(21734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.i
 * JD-Core Version:    0.7.0.1
 */