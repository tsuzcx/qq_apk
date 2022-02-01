package com.tencent.mm.model.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.c;
import java.util.Map;

final class d$3
  implements k.a
{
  d$3(d paramd) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(153126);
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString)))
    {
      paramString = d.aDs().wz("100205");
      if (paramString.isValid())
      {
        paramString = paramString.foF();
        int i = bt.getInt((String)paramString.get("main_thread_watch_enable"), 65535);
        int j = bt.getInt((String)paramString.get("main_thread_watch_timeout"), 5000);
        int k = bt.getInt((String)paramString.get("main_thread_watch_log_loop"), 0);
        int m = bt.getInt((String)paramString.get("main_thread_watch_report"), 0);
        aj.getContext().getSharedPreferences("system_config_prefs", g.abm()).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", j).putInt("main_thread_watch_log_loop", k).putInt("main_thread_watch_report", m).commit();
        ad.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      }
      d.aDu();
    }
    AppMethodBeat.o(153126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.d.3
 * JD-Core Version:    0.7.0.1
 */