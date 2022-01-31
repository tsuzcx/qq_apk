package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.c.e;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class f$5
  implements Runnable
{
  f$5(f paramf, int paramInt) {}
  
  public final void run()
  {
    e.reset();
    e.atN();
    c localc = new c();
    localc.begin();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.hOx.hOq.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (t)localIterator.next();
      localObject = a.avo() + "backupItem/" + a.xq(((t)localObject).ID) + ((t)localObject).ID;
      try
      {
        int j = this.hOx.a((String)localObject, localHashMap, localc, localHashSet);
        if (j < 0)
        {
          localc.end();
          y.w("MicroMsg.RecoverPCServer", "Thread has been canceled");
          return;
        }
        i = j + i;
      }
      catch (Exception localException1)
      {
        try
        {
          this.hOx.cq(i, this.hOz);
          y.i("MicroMsg.RecoverPCServer", "recover has done: %d", new Object[] { Integer.valueOf(i) });
        }
        catch (Exception localException2)
        {
          b localb;
          break label184;
        }
        localException1 = localException1;
      }
      label184:
      y.e("MicroMsg.RecoverPCServer", "Thread.run err:" + localException1.toString());
      y.printErrStackTrace("MicroMsg.RecoverPCServer", localException1, "", new Object[0]);
      y.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + localException1.toString());
    }
    d.k(localHashMap);
    localc.end();
    this.hOx.cq(100, 100);
    y.i("MicroMsg.RecoverPCServer", "build temDB finish!");
    y.cqL();
    localb = b.avO();
    localb.a(new b.2(localb, new f.5.1(this)), 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.5
 * JD-Core Version:    0.7.0.1
 */