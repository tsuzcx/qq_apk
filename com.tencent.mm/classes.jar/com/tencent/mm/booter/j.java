package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.a.h;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  public static void run()
  {
    int i = g.AA().getInt("EnableForgroundService", 0);
    au.Hx();
    int j = h.aT(c.CK(), 101);
    if ((b.cqk()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = d.spd;
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = b.cqk();
      }
      if (com.tencent.mm.sdk.platformtools.e.bvj == 1) {
        bool2 = false;
      }
      ae.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", bool2).commit();
      y.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(d.spd), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bvj) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.j
 * JD-Core Version:    0.7.0.1
 */