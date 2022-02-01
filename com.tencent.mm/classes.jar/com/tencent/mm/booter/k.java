package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class k
{
  public static void run()
  {
    AppMethodBeat.i(19890);
    int i = com.tencent.mm.k.i.aRC().getInt("EnableForgroundService", 0);
    bh.bCz();
    int j = com.tencent.mm.b.i.jdMethod_do(c.getUin(), 101);
    if ((CrashReportFactory.hasDebuger()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = d.Yxk;
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = CrashReportFactory.hasDebuger();
      }
      if (ChannelUtil.channelId == 1) {
        bool2 = false;
      }
      MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", bool2).commit();
      Log.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(d.Yxk), Integer.valueOf(ChannelUtil.channelId) });
      AppMethodBeat.o(19890);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.k
 * JD-Core Version:    0.7.0.1
 */