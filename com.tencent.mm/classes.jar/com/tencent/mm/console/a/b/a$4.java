package com.tencent.mm.console.a.b;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.List;

final class a$4
  implements a.a
{
  a$4(a parama, String paramString, int paramInt, int[] paramArrayOfInt, b paramb) {}
  
  public final void execute()
  {
    y.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, begin single transaction, username:%s", new Object[] { this.dol });
    long l1 = System.currentTimeMillis();
    int i = 0;
    if (i < this.dAW)
    {
      int j = a.gQ(this.dAX.length);
      int k = this.dAX[j];
      c localc = null;
      bi localbi;
      label98:
      long l2;
      switch (k)
      {
      default: 
        localbi = a.C(this.dol, i);
        l2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(localbi);
        if (l2 <= 0L) {
          if (i > 0) {
            j = i - 1;
          }
        }
        break;
      }
      for (;;)
      {
        i = j + 1;
        break;
        j = i;
        if (!this.dAR.dAZ.isEmpty())
        {
          localbi = a.a(this.dol, (c)this.dAR.dAZ.get(a.gQ(this.dAR.dAZ.size())));
          break label98;
          j = i;
          if (!this.dAR.dBa.isEmpty())
          {
            localc = (c)this.dAR.dBa.get(a.gQ(this.dAR.dBa.size()));
            localbi = a.b(this.dol, localc);
            break label98;
            j = i;
            if (!this.dAR.dBb.isEmpty())
            {
              localbi = a.c(this.dol, (c)this.dAR.dBb.get(a.gQ(this.dAR.dBb.size())));
              break label98;
              j = 0;
              continue;
              j = i;
              if (k == 43)
              {
                o.Sr().b(a.a(this.dol, (int)l2, localbi, localc));
                j = i;
              }
            }
          }
        }
      }
    }
    y.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, end single transaction, username:%s, cost:%s", new Object[] { this.dol, Long.valueOf(System.currentTimeMillis() - l1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.a.b.a.4
 * JD-Core Version:    0.7.0.1
 */