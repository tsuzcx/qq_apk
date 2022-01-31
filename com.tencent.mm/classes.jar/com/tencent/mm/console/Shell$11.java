package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;

final class Shell$11
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(16119);
    ae.glq = paramIntent.getIntExtra("flag", 0);
    ab.w("MicroMsg.Shell", "dkwt shell [%d]", new Object[] { Integer.valueOf(ae.glq) });
    AppMethodBeat.o(16119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.11
 * JD-Core Version:    0.7.0.1
 */