package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class Shell$7
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(16115);
    ae.gkK = paramIntent.getIntExtra("key", 0);
    ae.gkL = paramIntent.getIntExtra("val", 0);
    ae.gkM = paramIntent.getStringExtra("str");
    ab.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", new Object[] { Integer.valueOf(ae.gkK), Integer.valueOf(ae.gkL), ae.gkM });
    if (10009 == ae.gkK)
    {
      int i = ae.gkL;
      Shell.Ns();
      AppMethodBeat.o(16115);
      return;
    }
    if ((10014 == ae.gkK) && (ah.brt()))
    {
      n.aio().a(7L, 1, "");
      AppMethodBeat.o(16115);
      return;
    }
    if (10015 == ae.gkK) {
      ah.dsU();
    }
    AppMethodBeat.o(16115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.Shell.7
 * JD-Core Version:    0.7.0.1
 */