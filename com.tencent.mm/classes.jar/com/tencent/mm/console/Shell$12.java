package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class Shell$12
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(20153);
    int i = paramIntent.getIntExtra("level", 0);
    Log.w("MicroMsg.Shell", "kiro set Log.level=%d", new Object[] { Integer.valueOf(Log.getLogLevel()) });
    Log.setLevel(i, false);
    AppMethodBeat.o(20153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.12
 * JD-Core Version:    0.7.0.1
 */