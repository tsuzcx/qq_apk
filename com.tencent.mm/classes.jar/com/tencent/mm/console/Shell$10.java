package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;

final class Shell$10
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(16118);
    ae.gkO = paramIntent.getStringExtra("acc");
    ae.gkP = paramIntent.getStringExtra("pass");
    ab.w("MicroMsg.Shell", "dkwt shell [%s %s]", new Object[] { ae.gkO, ae.gkP });
    AppMethodBeat.o(16118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.10
 * JD-Core Version:    0.7.0.1
 */