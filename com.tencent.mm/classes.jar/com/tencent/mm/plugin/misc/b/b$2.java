package com.tencent.mm.plugin.misc.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  extends n.a
{
  b$2(b paramb) {}
  
  public final void onNetworkChange(int paramInt)
  {
    paramInt = 1;
    AppMethodBeat.i(50513);
    for (;;)
    {
      try
      {
        if (!b.bQn())
        {
          b.a(this.oEx, 0);
          AppMethodBeat.o(50513);
          return;
        }
        String str1 = q.LE();
        ab.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", new Object[] { str1 });
        if (!str1.equals(b.access$300()))
        {
          ab.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", new Object[] { b.access$300(), str1 });
          b.Qd(str1);
          if (paramInt == 0) {
            break label178;
          }
          b.b(this.oEx);
          b.c(this.oEx);
          this.oEx.yX(2);
          AppMethodBeat.o(50513);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.SimcardService", localException, "", new Object[0]);
        AppMethodBeat.o(50513);
        return;
      }
      String str2 = b.bQo();
      if (!str2.equals(b.access$500()))
      {
        ab.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", new Object[] { b.access$500(), str2 });
        b.TR(str2);
        continue;
        label178:
        b.a(this.oEx, b.d(this.oEx));
        AppMethodBeat.o(50513);
      }
      else
      {
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b.2
 * JD-Core Version:    0.7.0.1
 */