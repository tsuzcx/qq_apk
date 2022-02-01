package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;

final class Shell$37
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(20160);
    ac.jOF = paramIntent.getStringExtra("errmsg");
    Log.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", new Object[] { ac.jOF });
    AppMethodBeat.o(20160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.37
 * JD-Core Version:    0.7.0.1
 */