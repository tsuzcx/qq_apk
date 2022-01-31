package com.tencent.mm.model.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

final class c$3
  implements j.a
{
  c$3(c paramc) {}
  
  public final void a(String paramString, l paraml)
  {
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString)))
    {
      paramString = c.IX().fJ("100205");
      if (paramString.isValid())
      {
        paramString = paramString.ctr();
        int i = bk.getInt((String)paramString.get("main_thread_watch_enable"), 65535);
        int j = bk.getInt((String)paramString.get("main_thread_watch_timeout"), 5000);
        int k = bk.getInt((String)paramString.get("main_thread_watch_log_loop"), 0);
        int m = bk.getInt((String)paramString.get("main_thread_watch_report"), 0);
        ae.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", j).putInt("main_thread_watch_log_loop", k).putInt("main_thread_watch_report", m).commit();
        y.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      }
      c.IZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.c.c.3
 * JD-Core Version:    0.7.0.1
 */