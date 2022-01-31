package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

final class f$5$1
  implements Runnable
{
  f$5$1(f.5 param5) {}
  
  public final void run()
  {
    y.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
    y.cqL();
    a.avr().avs().hOj = 7;
    this.hOA.hOx.hOs = 0;
    Object localObject1;
    Object localObject2;
    if (this.hOA.hOx.hNQ != null)
    {
      this.hOA.hOx.hNQ.atm();
      e.avD();
      new com.tencent.mm.plugin.backup.bakoldlogic.c.b(8).auT();
      y.i("MicroMsg.RecoverPCServer", "recover ok");
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uus, Boolean.valueOf(true));
      localObject1 = a.avr().avt();
      ((c)localObject1).hNM += 1;
      a.avr().avs().hOi = 7;
      this.hOA.hOx.cancel();
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avQ();
      localObject1 = new StringBuffer();
      localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.a)localObject2).hMI.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label344;
      }
      a.a locala = (a.a)((Iterator)localObject2).next();
      String str;
      if ((locala.type == 2) && (locala.obj != null) && ((locala.obj instanceof String)))
      {
        str = (String)locala.obj;
        ((StringBuffer)localObject1).append(locala.type + " : " + str + " ,");
        continue;
        y.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
        break;
      }
      if ((locala.type == 1) && (locala.obj != null) && ((locala.obj instanceof String)))
      {
        str = (String)locala.obj;
        ((StringBuffer)localObject1).append(locala.type + " : " + str + " ,");
      }
    }
    label344:
    y.d("MicroMsg.BakOldRecoverDelayData", "dump delay " + ((StringBuffer)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.5.1
 * JD-Core Version:    0.7.0.1
 */