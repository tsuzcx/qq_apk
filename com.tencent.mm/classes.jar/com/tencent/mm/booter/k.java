package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class k
{
  public static void run()
  {
    AppMethodBeat.i(19890);
    int i = g.ZY().getInt("EnableForgroundService", 0);
    az.ayM();
    int j = com.tencent.mm.b.i.cc(c.getUin(), 101);
    if ((b.eUk()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = d.DIf;
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = b.eUk();
      }
      if (com.tencent.mm.sdk.platformtools.i.cGY == 1) {
        bool2 = false;
      }
      ai.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", bool2).commit();
      ac.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(d.DIf), Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cGY) });
      AppMethodBeat.o(19890);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.k
 * JD-Core Version:    0.7.0.1
 */