package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class k
{
  public static void run()
  {
    AppMethodBeat.i(15853);
    int i = com.tencent.mm.m.g.Nq().getInt("EnableForgroundService", 0);
    aw.aaz();
    int j = i.bQ(c.getUin(), 101);
    if ((b.dsf()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = d.whK;
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = b.dsf();
      }
      if (com.tencent.mm.sdk.platformtools.g.bWu == 1) {
        bool2 = false;
      }
      ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", bool2).commit();
      ab.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(d.whK), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.bWu) });
      AppMethodBeat.o(15853);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.k
 * JD-Core Version:    0.7.0.1
 */