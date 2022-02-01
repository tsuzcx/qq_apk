package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;

final class Shell$1
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(20140);
    int i = paramIntent.getIntExtra("type", 2147483647);
    int j = paramIntent.getIntExtra("error", 0);
    if ((i == 2147483647) || (j == 0))
    {
      AppMethodBeat.o(20140);
      return;
    }
    Log.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    ac.dF(i, j);
    AppMethodBeat.o(20140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.1
 * JD-Core Version:    0.7.0.1
 */