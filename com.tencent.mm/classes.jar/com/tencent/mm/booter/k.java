package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class k
{
  public static void run()
  {
    AppMethodBeat.i(19890);
    int i = g.acL().getInt("EnableForgroundService", 0);
    bc.aCg();
    int j = i.cf(c.getUin(), 101);
    if ((b.fnF()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = d.FFK;
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = b.fnF();
      }
      if (com.tencent.mm.sdk.platformtools.k.cSM == 1) {
        bool2 = false;
      }
      ak.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", bool2).commit();
      ae.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(d.FFK), Integer.valueOf(com.tencent.mm.sdk.platformtools.k.cSM) });
      AppMethodBeat.o(19890);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.k
 * JD-Core Version:    0.7.0.1
 */