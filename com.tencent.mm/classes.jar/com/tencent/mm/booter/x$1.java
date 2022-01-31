package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.network.b;
import com.tencent.mm.network.v;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.g;

public final class x$1
  implements Runnable
{
  public x$1(x paramx) {}
  
  public final void run()
  {
    AppMethodBeat.i(15873);
    long l = com.tencent.mm.platformtools.ah.aoy();
    Process.setThreadPriority(10);
    Object localObject1 = this.dZO;
    int i = g.bWu;
    String str = q.LK();
    int j = d.whH;
    Object localObject2 = aa.dsG();
    int k = ((x)localObject1).context.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).getInt("last_reportdevice_channel", 0);
    int m = ((x)localObject1).context.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).getInt("last_reportdevice_clientversion", 0);
    if ((k == 0) && (m == 0)) {}
    for (i = 0;; i = 1) {
      for (str = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/reportdevice?channel=" + g.bWu + "&deviceid=" + str + "&clientversion=" + j + "&platform=" + "0" + "&lang=" + (String)localObject2 + "&installtype=" + i;; str = null)
      {
        ab.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str });
        if (!com.tencent.mm.platformtools.ah.isNullOrNil(str)) {
          break label236;
        }
        AppMethodBeat.o(15873);
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
        ab.printErrStackTrace("MicroMsg.StartupReport", localException1, "", new Object[0]);
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
            localObject2 = this.dZO;
            j = g.bWu;
            k = d.whH;
            localObject2 = ((x)localObject2).context.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0);
            ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_channel", j).commit();
            ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_clientversion", k).commit();
          }
          ab.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", new Object[] { Long.valueOf(com.tencent.mm.platformtools.ah.hl(l)), Integer.valueOf(i), str });
          if (localObject1 != null) {
            ((v)localObject1).disconnect();
          }
          AppMethodBeat.o(15873);
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
      ab.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.x.1
 * JD-Core Version:    0.7.0.1
 */