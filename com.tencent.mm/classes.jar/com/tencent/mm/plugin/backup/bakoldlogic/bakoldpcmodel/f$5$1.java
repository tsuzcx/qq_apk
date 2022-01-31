package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(17866);
    ab.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
    ab.dsI();
    a.aUU().aUV().jHL = 7;
    this.jIc.jHZ.jHU = 0;
    Object localObject1;
    Object localObject2;
    if (this.jIc.jHZ.jHs != null)
    {
      this.jIc.jHZ.jHs.aSK();
      e.aVg();
      new com.tencent.mm.plugin.backup.bakoldlogic.c.b(8).aUv();
      ab.i("MicroMsg.RecoverPCServer", "recover ok");
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEv, Boolean.TRUE);
      localObject1 = a.aUU().aUW();
      ((c)localObject1).jHo += 1;
      a.aUU().aUV().jHK = 7;
      this.jIc.jHZ.cancel();
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVt();
      localObject1 = new StringBuffer();
      localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.a)localObject2).jGk.iterator();
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
        ab.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
        break;
      }
      if ((locala.type == 1) && (locala.obj != null) && ((locala.obj instanceof String)))
      {
        str = (String)locala.obj;
        ((StringBuffer)localObject1).append(locala.type + " : " + str + " ,");
      }
    }
    label349:
    ab.d("MicroMsg.BakOldRecoverDelayData", "dump delay " + ((StringBuffer)localObject1).toString());
    AppMethodBeat.o(17866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.5.1
 * JD-Core Version:    0.7.0.1
 */