package com.tencent.mm.plugin.misc.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.q;

final class a$1
  implements Runnable
{
  a$1(a parama, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    int j = 1;
    AppMethodBeat.i(50504);
    int k = this.ckS.getType();
    Object localObject = this.ckS.getReqResp();
    int i = j;
    if (k != 1616)
    {
      i = j;
      if (k != 1518)
      {
        if (k != 385) {
          break label70;
        }
        i = j;
      }
    }
    for (;;)
    {
      a.z(i, this.val$errType, this.val$errCode, k);
      AppMethodBeat.o(50504);
      return;
      label70:
      if (localObject != null)
      {
        localObject = ((q)localObject).getUri();
        if (localObject != null)
        {
          i = j;
          if (((String)localObject).startsWith("/cgi-bin/mmpay-bin/")) {
            continue;
          }
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.a.1
 * JD-Core Version:    0.7.0.1
 */