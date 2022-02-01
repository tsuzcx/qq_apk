package com.tencent.mm.plugin.misc.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.network.s;

final class a$1
  implements Runnable
{
  a$1(a parama, q paramq, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(127605);
    int k = this.ftz.getType();
    int j = 0;
    Object localObject = this.ftz.getReqResp();
    int i;
    if ((k == 1616) || (k == 1518) || (k == 385)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 1) {
        a.as(this.val$errType, this.val$errCode, k);
      }
      AppMethodBeat.o(127605);
      return;
      i = j;
      if (localObject != null)
      {
        localObject = ((s)localObject).getUri();
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((String)localObject).startsWith("/cgi-bin/mmpay-bin/")) {
            i = 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.a.1
 * JD-Core Version:    0.7.0.1
 */