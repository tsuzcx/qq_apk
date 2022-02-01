package com.tencent.mm.plugin.exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.protocal.protobuf.cwg;

public final class a
  implements b
{
  public final void a(final b.a parama)
  {
    AppMethodBeat.i(169753);
    c.a locala = new c.a();
    locala.otE = new cwf();
    locala.otF = new cwg();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
    locala.funcId = 1926;
    locala.otG = 0;
    locala.respCmdId = 0;
    z.a(locala.bEF(), new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
      {
        boolean bool2 = true;
        AppMethodBeat.i(169752);
        if (paramAnonymousp.getType() != 1926)
        {
          AppMethodBeat.o(169752);
          return 0;
        }
        boolean bool1;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (cwg)c.c.b(paramAnonymousc.otC);
          if ((paramAnonymousString != null) && (paramAnonymousString.aaBA)) {
            bool1 = true;
          }
        }
        for (;;)
        {
          if (parama != null) {
            parama.D(bool2, bool1);
          }
          AppMethodBeat.o(169752);
          return 0;
          bool1 = false;
          continue;
          bool1 = false;
          bool2 = false;
        }
      }
    }, true);
    AppMethodBeat.o(169753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.a.a
 * JD-Core Version:    0.7.0.1
 */