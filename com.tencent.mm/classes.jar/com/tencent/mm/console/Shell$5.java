package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class Shell$5
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(16113);
    int i = paramIntent.getIntExtra("level", 0);
    ab.w("MicroMsg.Shell", "kiro set Log.level=%d", new Object[] { Integer.valueOf(ab.getLogLevel()) });
    ab.Ne(i);
    AppMethodBeat.o(16113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.Shell.5
 * JD-Core Version:    0.7.0.1
 */