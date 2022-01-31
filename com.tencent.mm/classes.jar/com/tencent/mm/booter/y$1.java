package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

public final class y$1
  implements Runnable
{
  public y$1(y paramy) {}
  
  public final void run()
  {
    long l = ah.UY();
    Process.setThreadPriority(10);
    Object localObject1 = this.div;
    int i = e.bvj;
    String str = q.zg();
    int j = d.spa;
    Object localObject2 = x.cqJ();
    int k = ((y)localObject1).context.getSharedPreferences(ae.cqR(), 0).getInt("last_reportdevice_channel", 0);
    int m = ((y)localObject1).context.getSharedPreferences(ae.cqR(), 0).getInt("last_reportdevice_clientversion", 0);
    if ((k == 0) && (m == 0)) {}
    for (i = 0;; i = 1) {
      for (str = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/reportdevice?channel=" + e.bvj + "&deviceid=" + str + "&clientversion=" + j + "&platform=" + "0" + "&lang=" + (String)localObject2 + "&installtype=" + i;; str = null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str });
        if (!ah.bl(str)) {
          break label224;
        }
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
        label224:
        localObject1 = b.a(str, null);
      }
      catch (Exception localException1)
      {
        try
        {
          ((u)localObject1).setConnectTimeout(10000);
          ((u)localObject1).setReadTimeout(10000);
          ((u)localObject1).connect();
          i = ((u)localObject1).getResponseCode();
          if (i == 200)
          {
            localObject2 = this.div;
            j = e.bvj;
            k = d.spa;
            localObject2 = ((y)localObject2).context.getSharedPreferences(ae.cqR(), 0);
            ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_channel", j).commit();
            ((SharedPreferences)localObject2).edit().putInt("last_reportdevice_clientversion", k).commit();
          }
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", new Object[] { Long.valueOf(ah.co(l)), Integer.valueOf(i), str });
          if (localObject1 == null) {
            break;
          }
          ((u)localObject1).aRG.disconnect();
          return;
        }
        catch (Exception localException2)
        {
          break label389;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label389:
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.StartupReport", localException1, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.y.1
 * JD-Core Version:    0.7.0.1
 */