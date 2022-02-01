package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;

final class Shell$38
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(20161);
    ac.jOG = paramIntent.getStringExtra("acc");
    ac.jOH = paramIntent.getStringExtra("pass");
    Log.w("MicroMsg.Shell", "dkwt shell [%s %s]", new Object[] { ac.jOG, ac.jOH });
    AppMethodBeat.o(20161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.38
 * JD-Core Version:    0.7.0.1
 */