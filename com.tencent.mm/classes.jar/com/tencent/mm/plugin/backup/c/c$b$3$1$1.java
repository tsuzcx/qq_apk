package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

final class c$b$3$1$1
  implements Runnable
{
  c$b$3$1$1(c.b.3.1 param1, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    int i = 0;
    if ((this.hGE != null) && (i < this.hGE.size()))
    {
      Long localLong = (Long)this.hGE.get(i);
      h.a locala = (h.a)this.hGF.hGD.hGz.hGu.get(localLong);
      String str3 = this.hGF.hGD.hGz.TAG;
      int j = this.hGE.size();
      String str1;
      if (locala == null)
      {
        str1 = "null";
        label87:
        if (locala != null) {
          break label214;
        }
      }
      label214:
      for (String str2 = "null";; str2 = locala.hJV.path)
      {
        y.i(str3, "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localLong, str1, str2 });
        if (locala != null)
        {
          this.hGF.hGD.hGz.hGs.add(locala.hJV.bUi);
          this.hGF.hGD.hGz.k(locala.hJV.bUi, locala.hJV.path, true);
        }
        i += 1;
        break;
        str1 = locala.hJV.bUi;
        break label87;
      }
    }
    this.hGF.hGD.hGz.hGo.offer(this.hGF.hGD.hGz.hGy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.3.1.1
 * JD-Core Version:    0.7.0.1
 */