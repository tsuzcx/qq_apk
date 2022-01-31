package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class a$c$1
  implements Runnable
{
  a$c$1(a.c paramc) {}
  
  public final void run()
  {
    this.bvX.bvV = ((this.bvX.bvV + 1) % 2147483647);
    if (this.bvX.bvV % a.access$200() == 0)
    {
      SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("system_config_prefs", 4);
      int i = localSharedPreferences.getInt("main_thread_watch_enable", 65535);
      int j = localSharedPreferences.getInt("main_thread_watch_timeout", 0);
      int k = localSharedPreferences.getInt("main_thread_watch_log_loop", 0);
      int m = localSharedPreferences.getInt("main_thread_watch_report", 0);
      y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ticker tname[%s], tick[%d] enable[%d], timeout[%d], loop[%d], report[%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(this.bvX.bvV), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      if (!a.o(a.access$300(), i)) {
        break label250;
      }
      if ((j > 0) && (j != a.su()))
      {
        y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset timeout[%d, %d] by new setting", new Object[] { Integer.valueOf(a.su()), Integer.valueOf(j) });
        a.en(j);
      }
      if ((k > 0) && (k != a.access$200()))
      {
        y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset loop[%d, %d] by new setting", new Object[] { Integer.valueOf(a.access$200()), Integer.valueOf(k) });
        a.eo(k);
      }
    }
    return;
    label250:
    h.nFQ.a(510L, 12L, 1L, true);
    if (a.sv() != null) {
      a.sv().interrupt();
    }
    y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr disable by new setting and interrupt watch");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.a.c.1
 * JD-Core Version:    0.7.0.1
 */