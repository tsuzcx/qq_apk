package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.DynamicConfigStorage;

public final class m
{
  public static void run()
  {
    AppMethodBeat.i(19897);
    int i = com.tencent.mm.k.i.aRC().getInt("EnableFlockMultiProcSPProb", 0);
    bh.bCz();
    int j = com.tencent.mm.b.i.jdMethod_do(c.getUin(), 101);
    if ((CrashReportFactory.hasDebuger()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool = true;; bool = false)
    {
      MultiProcSharedPreferences.DynamicConfigStorage.setValue(MultiProcSharedPreferences.DynamicConfigStorage.PREF_KEY_IS_ENABLE_MULTIPROC_SP, bool);
      Log.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(19897);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.m
 * JD-Core Version:    0.7.0.1
 */