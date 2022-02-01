package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelmulti.u;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

final class Shell$34
  implements Shell.a
{
  public final void v(Intent paramIntent)
  {
    AppMethodBeat.i(20158);
    z.pCm = Util.safeParseInt(paramIntent.getStringExtra("key"));
    z.pCn = Util.safeParseInt(paramIntent.getStringExtra("val"));
    z.pCo = paramIntent.getStringExtra("str");
    Log.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", new Object[] { Integer.valueOf(z.pCm), Integer.valueOf(z.pCn), z.pCo });
    if (10009 == z.pCm)
    {
      int i = z.pCn;
      Shell.aRE();
      AppMethodBeat.o(20158);
      return;
    }
    if ((10014 == z.pCm) && (MMApplicationContext.isMMProcess()))
    {
      u.bKY().a(7L, 1, "");
      AppMethodBeat.o(20158);
      return;
    }
    if (10015 == z.pCm) {
      MMApplicationContext.isPushProcess();
    }
    AppMethodBeat.o(20158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.Shell.34
 * JD-Core Version:    0.7.0.1
 */