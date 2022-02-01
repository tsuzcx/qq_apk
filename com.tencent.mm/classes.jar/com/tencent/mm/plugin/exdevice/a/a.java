package com.tencent.mm.plugin.exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.bly;

public final class a
  implements b
{
  public final void a(final b.a parama)
  {
    AppMethodBeat.i(169753);
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.hQF = new blx();
    locala.hQG = new bly();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
    locala.funcId = 1926;
    locala.hQH = 0;
    locala.respCmdId = 0;
    x.a(locala.aDS(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        boolean bool2 = true;
        AppMethodBeat.i(169752);
        if (paramAnonymousn.getType() != 1926)
        {
          AppMethodBeat.o(169752);
          return 0;
        }
        boolean bool1;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (bly)paramAnonymousb.hQE.hQJ;
          if ((paramAnonymousString != null) && (paramAnonymousString.GZb)) {
            bool1 = true;
          }
        }
        for (;;)
        {
          if (parama != null) {
            parama.w(bool2, bool1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.a.a
 * JD-Core Version:    0.7.0.1
 */