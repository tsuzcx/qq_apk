package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(17180);
    int i = 0;
    if ((this.jAa != null) && (i < this.jAa.size()))
    {
      Long localLong = (Long)this.jAa.get(i);
      h.a locala = (h.a)this.jAb.jzZ.jzV.jzQ.get(localLong);
      String str3 = this.jAb.jzZ.jzV.TAG;
      int j = this.jAa.size();
      String str1;
      if (locala == null)
      {
        str1 = "null";
        label93:
        if (locala != null) {
          break label220;
        }
      }
      label220:
      for (String str2 = "null";; str2 = locala.jDy.path)
      {
        ab.i(str3, "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localLong, str1, str2 });
        if (locala != null)
        {
          this.jAb.jzZ.jzV.jzO.add(locala.jDy.cBO);
          this.jAb.jzZ.jzV.m(locala.jDy.cBO, locala.jDy.path, true);
        }
        i += 1;
        break;
        str1 = locala.jDy.cBO;
        break label93;
      }
    }
    this.jAb.jzZ.jzV.jzK.offer(this.jAb.jzZ.jzV.jzU);
    AppMethodBeat.o(17180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.3.1.1
 * JD-Core Version:    0.7.0.1
 */