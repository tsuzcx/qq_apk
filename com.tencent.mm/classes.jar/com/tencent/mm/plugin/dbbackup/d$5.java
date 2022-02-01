package com.tencent.mm.plugin.dbbackup;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

final class d$5
  implements b
{
  int xjo = 0;
  
  d$5(d paramd, u paramu, b paramb, WakerLock paramWakerLock) {}
  
  public final void onResult(int paramInt)
  {
    AppMethodBeat.i(23083);
    int i = paramInt;
    if (this.xjo > 0) {
      Log.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", new Object[] { Integer.valueOf(this.xjo), Integer.valueOf(i) });
    }
    if (i == 0)
    {
      this.xjp.diJ();
      h.OAn.idkeyStat(181L, 29L, 1L, true);
      if (this.xiV != null) {
        this.xiV.onResult(i);
      }
      this.xjq.unLock();
      AppMethodBeat.o(23083);
      return;
    }
    if (i == -2)
    {
      this.xjp.diJ();
      h.OAn.idkeyStat(181L, 3L, 1L, true);
      if (this.xiV != null) {
        this.xiV.onResult(i);
      }
      this.xjq.unLock();
      AppMethodBeat.o(23083);
      return;
    }
    paramInt = this.xjo + 1;
    this.xjo = paramInt;
    switch (paramInt)
    {
    default: 
      this.xjp.diJ();
      h.OAn.idkeyStat(181L, 30L, 1L, true);
      if (this.xiV != null) {
        this.xiV.onResult(i);
      }
      this.xjq.unLock();
      AppMethodBeat.o(23083);
      return;
    case 1: 
      Log.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", new Object[] { Integer.valueOf(this.xjo) });
    case 2: 
      for (paramInt = this.xjh.b(null, this);; paramInt = this.xjh.a(null, this))
      {
        i = paramInt;
        if (paramInt != 0) {
          break;
        }
        AppMethodBeat.o(23083);
        return;
        Log.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", new Object[] { Integer.valueOf(this.xjo) });
      }
    }
    Log.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", new Object[] { Integer.valueOf(this.xjo) });
    d locald = this.xjh;
    bh.bCz();
    Object localObject1 = c.bai();
    if ((localObject1 == null) || (((String)localObject1).isEmpty())) {
      paramInt = -3;
    }
    for (;;)
    {
      break;
      localObject1 = new u((String)localObject1);
      if (!((u)localObject1).jKQ())
      {
        paramInt = -3;
      }
      else
      {
        Object localObject2 = new StringBuilder().append(q.eD(true));
        bh.bCz();
        localObject2 = g.getMessageDigest(c.getUin().getBytes()).substring(0, 7);
        long l1 = ((u)localObject1).length() * 2L;
        long l2 = Util.getDataAvailableSize();
        Log.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        if (l2 < l1)
        {
          paramInt = -2;
        }
        else
        {
          bh.baH().setHighPriority();
          bh.baH().postAtFrontOfQueueToWorker(new d.4(locald, (u)localObject1, (String)localObject2, this));
          paramInt = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.5
 * JD-Core Version:    0.7.0.1
 */