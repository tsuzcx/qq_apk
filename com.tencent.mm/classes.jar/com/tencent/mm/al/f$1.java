package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class f$1
  implements c
{
  f$1(f paramf) {}
  
  public final void a(nr paramnr1, nr paramnr2, nr paramnr3)
  {
    AppMethodBeat.i(78074);
    ab.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + paramnr1.toString() + " getCore().engine:" + f.afP());
    if (f.afP() != null)
    {
      f.afP().a(paramnr1, paramnr2, paramnr3, null, null, null);
      g.RO().ac(new f.1.1(this));
    }
    AppMethodBeat.o(78074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.f.1
 * JD-Core Version:    0.7.0.1
 */