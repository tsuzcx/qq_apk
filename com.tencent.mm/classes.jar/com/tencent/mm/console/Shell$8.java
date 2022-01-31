package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;

final class Shell$8
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(16116);
    ae.gkJ = paramIntent.getIntExtra("value", 0);
    ab.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", new Object[] { Integer.toBinaryString(ae.gkJ) });
    AppMethodBeat.o(16116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.Shell.8
 * JD-Core Version:    0.7.0.1
 */