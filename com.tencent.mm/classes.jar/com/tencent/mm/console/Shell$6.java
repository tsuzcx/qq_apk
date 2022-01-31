package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;

final class Shell$6
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(16114);
    ae.gkE = paramIntent.getBooleanExtra("value", false);
    ab.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", new Object[] { Boolean.valueOf(ae.gkE) });
    AppMethodBeat.o(16114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.Shell.6
 * JD-Core Version:    0.7.0.1
 */