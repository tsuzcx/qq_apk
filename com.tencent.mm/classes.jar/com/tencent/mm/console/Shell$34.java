package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

final class Shell$34
  implements Shell.a
{
  public final void u(Intent paramIntent)
  {
    AppMethodBeat.i(20158);
    ac.mFM = Util.safeParseInt(paramIntent.getStringExtra("key"));
    ac.mFN = Util.safeParseInt(paramIntent.getStringExtra("val"));
    ac.mFO = paramIntent.getStringExtra("str");
    Log.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", new Object[] { Integer.valueOf(ac.mFM), Integer.valueOf(ac.mFN), ac.mFO });
    if (10009 == ac.mFM)
    {
      int i = ac.mFN;
      Shell.axe();
      AppMethodBeat.o(20158);
      return;
    }
    if ((10014 == ac.mFM) && (MMApplicationContext.isMMProcess()))
    {
      p.bnn().a(7L, 1, "");
      AppMethodBeat.o(20158);
      return;
    }
    if (10015 == ac.mFM) {
      MMApplicationContext.isPushProcess();
    }
    AppMethodBeat.o(20158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.Shell.34
 * JD-Core Version:    0.7.0.1
 */