package com.tencent.mm.plugin.exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.cgd;

public final class a
  implements b
{
  public final void a(final b.a parama)
  {
    AppMethodBeat.i(169753);
    d.a locala = new d.a();
    locala.lBU = new cgc();
    locala.lBV = new cgd();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
    locala.funcId = 1926;
    locala.lBW = 0;
    locala.respCmdId = 0;
    aa.a(locala.bgN(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        boolean bool2 = true;
        AppMethodBeat.i(169752);
        if (paramAnonymousq.getType() != 1926)
        {
          AppMethodBeat.o(169752);
          return 0;
        }
        boolean bool1;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (cgd)d.c.b(paramAnonymousd.lBS);
          if ((paramAnonymousString != null) && (paramAnonymousString.Tnu)) {
            bool1 = true;
          }
        }
        for (;;)
        {
          if (parama != null) {
            parama.z(bool2, bool1);
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