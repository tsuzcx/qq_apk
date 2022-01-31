package com.tencent.mm.console.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.List;

final class a$4
  implements a.a
{
  a$4(a parama, String paramString, int paramInt, int[] paramArrayOfInt, b paramb) {}
  
  public final void execute()
  {
    AppMethodBeat.i(16157);
    ab.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, begin single transaction, username:%s", new Object[] { this.efI });
    long l1 = System.currentTimeMillis();
    int i = 0;
    if (i < this.eux)
    {
      int j = a.jd(this.euy.length);
      int k = this.euy[j];
      c localc = null;
      bi localbi;
      label102:
      long l2;
      switch (k)
      {
      default: 
        localbi = a.H(this.efI, i);
        l2 = ((j)g.E(j.class)).bPQ().Z(localbi);
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
        if (!this.eus.euA.isEmpty())
        {
          localbi = a.a(this.efI, (c)this.eus.euA.get(a.jd(this.eus.euA.size())));
          break label102;
          j = i;
          if (!this.eus.euB.isEmpty())
          {
            localc = (c)this.eus.euB.get(a.jd(this.eus.euB.size()));
            localbi = a.b(this.efI, localc);
            break label102;
            j = i;
            if (!this.eus.euC.isEmpty())
            {
              localbi = a.c(this.efI, (c)this.eus.euC.get(a.jd(this.eus.euC.size())));
              break label102;
              j = 0;
              continue;
              j = i;
              if (k == 43)
              {
                o.alE().b(a.a(this.efI, (int)l2, localbi, localc));
                j = i;
              }
            }
          }
        }
      }
    }
    ab.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, end single transaction, username:%s, cost:%s", new Object[] { this.efI, Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(16157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.a.b.a.4
 * JD-Core Version:    0.7.0.1
 */