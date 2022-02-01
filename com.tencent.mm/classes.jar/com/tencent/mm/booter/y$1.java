package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.network.b;
import com.tencent.mm.network.v;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;

public final class y$1
  implements Runnable
{
  public y$1(y paramy) {}
  
  public final void run()
  {
    AppMethodBeat.i(19909);
    long l = bs.eWj();
    Process.setThreadPriority(10);
    Object localObject1 = this.fnr;
    int i = i.cGY;
    String str = q.XX();
    int j = d.DIc;
    Object localObject2 = ab.eUO();
    int k = ((y)localObject1).context.getSharedPreferences(ai.eUX(), 0).getInt("last_reportdevice_channel", 0);
    int m = ((y)localObject1).context.getSharedPreferences(ai.eUX(), 0).getInt("last_reportdevice_clientversion", 0);
    if ((k == 0) && (m == 0)) {}
    for (i = 0;; i = 1) {
      for (str = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/reportdevice?channel=" + i.cGY + "&deviceid=" + str + "&clientversion=" + j + "&platform=" + "0" + "&lang=" + (String)localObject2 + "&installtype=" + i;; str = null)
      {
        ac.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str });
        if (!bs.isNullOrNil(str)) {
          break label236;
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
        label236:
        localObject1 = b.a(str, null);
        ac.printErrStackTrace("MicroMsg.StartupReport", localException1, "", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          ((v)localObject1).setConnectTimeout(10000);
          ((v)localObject1).setReadTimeout(10000);
          ((v)localObject1).connect();
          i = ((v)localObject1).getResponseCode();
          if (i == 200)
          {
            localObject2 = this.fnr;
            j = i.cGY;
            k = d.DIc;
            localObject2 = ((y)localObject2).context.getSharedPreferences(ai.eUX(), 0);
            ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_channel", j).commit();
            ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_clientversion", k).commit();
          }
          ac.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", new Object[] { Long.valueOf(bs.Ap(l)), Integer.valueOf(i), str });
          if (localObject1 != null) {
            ((v)localObject1).disconnect();
          }
          AppMethodBeat.o(19909);
          return;
        }
        catch (Exception localException2)
        {
          break label404;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label404:
      ac.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.y.1
 * JD-Core Version:    0.7.0.1
 */