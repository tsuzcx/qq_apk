package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;

final class Shell$23
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(20157);
    ac.jOw = paramIntent.getBooleanExtra("value", false);
    Log.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", new Object[] { Boolean.valueOf(ac.jOw) });
    AppMethodBeat.o(20157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.23
 * JD-Core Version:    0.7.0.1
 */