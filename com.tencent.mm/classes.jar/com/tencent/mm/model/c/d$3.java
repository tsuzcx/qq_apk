package com.tencent.mm.model.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.c;
import java.util.Map;

final class d$3
  implements MStorage.IOnStorageChange
{
  d$3(d paramd) {}
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(153126);
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString)))
    {
      paramString = d.aXu().Fu("100205");
      if (paramString.isValid())
      {
        paramString = paramString.gzz();
        int i = Util.getInt((String)paramString.get("main_thread_watch_enable"), 65535);
        int j = Util.getInt((String)paramString.get("main_thread_watch_timeout"), 5000);
        int k = Util.getInt((String)paramString.get("main_thread_watch_log_loop"), 0);
        int m = Util.getInt((String)paramString.get("main_thread_watch_report"), 0);
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aps()).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", j).putInt("main_thread_watch_log_loop", k).putInt("main_thread_watch_report", m).commit();
        Log.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      }
      d.aXw();
    }
    AppMethodBeat.o(153126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.d.3
 * JD-Core Version:    0.7.0.1
 */