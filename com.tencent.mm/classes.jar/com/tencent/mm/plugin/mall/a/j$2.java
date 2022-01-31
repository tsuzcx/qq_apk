package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class j$2
  implements bz.a
{
  j$2(j paramj) {}
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(43119);
    parama = aa.a(parama.eyJ.woR);
    ab.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[] { parama });
    j.a(this.oya).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43118);
        c.cUX();
        c.afp(parama);
        AppMethodBeat.o(43118);
      }
    });
    AppMethodBeat.o(43119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j.2
 * JD-Core Version:    0.7.0.1
 */