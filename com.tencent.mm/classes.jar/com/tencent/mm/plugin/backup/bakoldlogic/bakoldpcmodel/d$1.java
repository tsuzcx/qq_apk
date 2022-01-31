package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.h.c.as;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    d locald = this.hNX;
    locald.hNW = 0;
    locald.hNR = new d.2(locald);
    com.tencent.mm.plugin.backup.g.b.a(5, locald.hNR);
    String str1 = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Dz().get(2, null);
    Iterator localIterator = locald.hNO.iterator();
    String str2;
    ak localak;
    if (localIterator.hasNext())
    {
      str2 = (String)localIterator.next();
      localak = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().FB().abv(str2);
      if (localak == null) {
        break label169;
      }
    }
    label169:
    for (int i = localak.field_unReadCount;; i = 0)
    {
      y.i("MicroMsg.BakPCServer", "backupImp convName:%s, unReadCount:%d", new Object[] { str2, Integer.valueOf(i) });
      if (locald.q(str2, str1, i)) {
        break;
      }
      y.i("MicroMsg.BakPCServer", "backupImp.backupChatMsg canceled");
      return;
      locald.hNS = true;
      y.i("MicroMsg.BakPCServer", "send conplete waiting to send finishCmd");
      locald.avy();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.1
 * JD-Core Version:    0.7.0.1
 */