package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class y$1
  implements Runnable
{
  public y$1(y paramy) {}
  
  public final void run()
  {
    AppMethodBeat.i(19909);
    long l = Util.nowMilliSecond();
    Process.setThreadPriority(10);
    Object localObject1 = this.lsU;
    int i = ChannelUtil.channelId;
    String str = q.aPg();
    int j = com.tencent.mm.protocal.d.Yxh;
    Object localObject2 = LocaleUtil.getApplicationLanguage();
    int k = ((y)localObject1).context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("last_reportdevice_channel", 0);
    int m = ((y)localObject1).context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("last_reportdevice_clientversion", 0);
    if ((k == 0) && (m == 0)) {}
    for (i = 0;; i = 1) {
      for (str = y.lsT + "?channel=" + ChannelUtil.channelId + "&deviceid=" + str + "&clientversion=" + j + "&platform=" + "0" + "&lang=" + (String)localObject2 + "&installtype=" + i;; str = null)
      {
        Log.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str });
        if (!Util.isNullOrNil(str)) {
          break label245;
        }
        AppMethodBeat.o(19909);
        return;
        if ((k != i) || (m != j)) {
          break;
        }
      }
    }
    try
    {
      label245:
      localObject1 = com.tencent.mm.network.d.a(str, null);
      if (localObject1 != null) {}
    }
    catch (Exception localException1)
    {
      localObject1 = null;
    }
    try
    {
      Log.e("MicroMsg.StartupReport", "tryReport ERR: genHttpConnection is null url[%s]", new Object[] { str });
      AppMethodBeat.o(19909);
      return;
    }
    catch (Exception localException2)
    {
      break label441;
    }
    ((com.tencent.mm.network.y)localObject1).xx(10000);
    ((com.tencent.mm.network.y)localObject1).xy(10000);
    ((com.tencent.mm.network.y)localObject1).connect();
    i = ((com.tencent.mm.network.y)localObject1).getResponseCode();
    if (i == 200)
    {
      localObject2 = this.lsU;
      j = ChannelUtil.channelId;
      k = com.tencent.mm.protocal.d.Yxh;
      localObject2 = ((y)localObject2).context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_channel", j).commit();
      ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_clientversion", k).commit();
    }
    Log.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(i), str });
    for (;;)
    {
      if (localObject1 != null) {
        ((com.tencent.mm.network.y)localObject1).disconnect();
      }
      AppMethodBeat.o(19909);
      return;
      label441:
      Log.printErrStackTrace("MicroMsg.StartupReport", localException1, "", new Object[0]);
      Log.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.y.1
 * JD-Core Version:    0.7.0.1
 */