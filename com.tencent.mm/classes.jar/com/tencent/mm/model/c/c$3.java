package com.tencent.mm.model.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.util.Map;

final class c$3
  implements k.a
{
  c$3(c paramc) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(118178);
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString)))
    {
      paramString = c.abU().me("100205");
      if (paramString.isValid())
      {
        paramString = paramString.dvN();
        int i = bo.getInt((String)paramString.get("main_thread_watch_enable"), 65535);
        int j = bo.getInt((String)paramString.get("main_thread_watch_timeout"), 5000);
        int k = bo.getInt((String)paramString.get("main_thread_watch_log_loop"), 0);
        int m = bo.getInt((String)paramString.get("main_thread_watch_report"), 0);
        ah.getContext().getSharedPreferences("system_config_prefs", h.Mp()).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", j).putInt("main_thread_watch_log_loop", k).putInt("main_thread_watch_report", m).commit();
        ab.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      }
      c.abW();
    }
    AppMethodBeat.o(118178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.c.3
 * JD-Core Version:    0.7.0.1
 */