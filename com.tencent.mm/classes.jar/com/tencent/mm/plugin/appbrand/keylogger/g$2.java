package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

final class g$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(186885);
    g.access$100();
    aj.eFE().edit().putLong("MMTempKeyStepLogger-Last-Clean-Time", System.currentTimeMillis()).commit();
    AppMethodBeat.o(186885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.g.2
 * JD-Core Version:    0.7.0.1
 */