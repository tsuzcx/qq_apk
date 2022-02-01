package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;

final class Shell$39
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(20162);
    ac.jPk = paramIntent.getIntExtra("flag", 0);
    Log.w("MicroMsg.Shell", "dkwt shell [%d]", new Object[] { Integer.valueOf(ac.jPk) });
    AppMethodBeat.o(20162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.39
 * JD-Core Version:    0.7.0.1
 */