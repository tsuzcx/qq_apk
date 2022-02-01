package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;

final class f$5$1
  implements Runnable
{
  f$5$1(f.5 param5) {}
  
  public final void run()
  {
    AppMethodBeat.i(21923);
    ad.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
    ad.fku();
    a.bJi().bJj().nBB = 7;
    this.nBS.nBP.nBK = 0;
    Object localObject1;
    Object localObject2;
    if (this.nBS.nBP.nBi != null)
    {
      this.nBS.nBP.nBi.bGW();
      e.bJu();
      new com.tencent.mm.plugin.backup.bakoldlogic.c.b(8).bIJ();
      ad.i("MicroMsg.RecoverPCServer", "recover ok");
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Ixi, Boolean.TRUE);
      localObject1 = a.bJi().bJk();
      ((c)localObject1).nBe += 1;
      a.bJi().bJj().nBA = 7;
      this.nBS.nBP.cancel();
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJH();
      localObject1 = new StringBuffer();
      localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.a)localObject2).nAb.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label349;
      }
      a.a locala = (a.a)((Iterator)localObject2).next();
      String str;
      if ((locala.type == 2) && (locala.obj != null) && ((locala.obj instanceof String)))
      {
        str = (String)locala.obj;
        ((StringBuffer)localObject1).append(locala.type + " : " + str + " ,");
        continue;
        ad.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
        break;
      }
      if ((locala.type == 1) && (locala.obj != null) && ((locala.obj instanceof String)))
      {
        str = (String)locala.obj;
        ((StringBuffer)localObject1).append(locala.type + " : " + str + " ,");
      }
    }
    label349:
    ad.d("MicroMsg.BakOldRecoverDelayData", "dump delay " + ((StringBuffer)localObject1).toString());
    AppMethodBeat.o(21923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.5.1
 * JD-Core Version:    0.7.0.1
 */