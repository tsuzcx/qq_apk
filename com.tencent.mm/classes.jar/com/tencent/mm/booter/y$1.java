package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.network.x;
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
    Object localObject1 = this.gmP;
    int i = ChannelUtil.channelId;
    String str = q.aoG();
    int j = com.tencent.mm.protocal.d.KyO;
    Object localObject2 = LocaleUtil.getApplicationLanguage();
    int k = ((y)localObject1).context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("last_reportdevice_channel", 0);
    int m = ((y)localObject1).context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("last_reportdevice_clientversion", 0);
    if ((k == 0) && (m == 0)) {}
    for (i = 0;; i = 1) {
      for (str = y.gmO + "?channel=" + ChannelUtil.channelId + "&deviceid=" + str + "&clientversion=" + j + "&platform=" + "0" + "&lang=" + (String)localObject2 + "&installtype=" + i;; str = null)
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
    for (;;)
    {
      try
      {
        label245:
        localObject1 = com.tencent.mm.network.d.a(str, null);
        Log.printErrStackTrace("MicroMsg.StartupReport", localException1, "", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          ((x)localObject1).setConnectTimeout(10000);
          ((x)localObject1).setReadTimeout(10000);
          ((x)localObject1).connect();
          i = ((x)localObject1).getResponseCode();
          if (i == 200)
          {
            localObject2 = this.gmP;
            j = ChannelUtil.channelId;
            k = com.tencent.mm.protocal.d.KyO;
            localObject2 = ((y)localObject2).context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
            ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_channel", j).commit();
            ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_clientversion", k).commit();
          }
          Log.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(i), str });
          if (localObject1 != null) {
            ((x)localObject1).disconnect();
          }
          AppMethodBeat.o(19909);
          return;
        }
        catch (Exception localException2)
        {
          break label413;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label413:
      Log.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.y.1
 * JD-Core Version:    0.7.0.1
 */