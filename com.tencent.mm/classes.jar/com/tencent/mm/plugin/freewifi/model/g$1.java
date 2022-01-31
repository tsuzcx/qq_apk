package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements Runnable
{
  g$1(g paramg, String paramString, Intent paramIntent, g.b paramb, int paramInt) {}
  
  public final void run()
  {
    int i = this.koH.koF;
    String str3;
    for (;;)
    {
      int j = i - 1;
      if (i <= 0) {
        break label256;
      }
      y.i("MicroMsg.FreeWifi.FreeWifiNetwork", "now retry count = %d", new Object[] { Integer.valueOf(j) });
      g.b(this.knT, 1, this.val$intent);
      str3 = com.tencent.mm.m.g.AB().Ao();
      y.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from cinfig : %s", new Object[] { str3 });
      String str1 = str3;
      if (bk.bl(str3))
      {
        y.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from config failed, use the default url : %s", new Object[] { "http://10.1.0.6/redirect" });
        str1 = "http://10.1.0.6/redirect";
      }
      str3 = g.Dy(str1);
      y.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url : %s, %s", new Object[] { str1, str3 });
      if (!bk.bl(str3)) {
        break;
      }
      y.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url failed : %s, %s", new Object[] { str1, str3 });
      try
      {
        Thread.sleep(500L);
        i = j;
      }
      catch (Exception localException)
      {
        i = j;
      }
    }
    String str2 = g.dh(str3, "auth=");
    y.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauthmessage from location : %s, %s", new Object[] { str2, str3 });
    if (bk.bl(str2))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauth message from location failed : %s", new Object[] { str3 });
      g.b(this.knT, 3, this.val$intent);
    }
    if (this.koG != null) {
      this.koG.bE(str2, this.knJ);
    }
    return;
    label256:
    if (this.koG != null) {
      this.koG.bE(null, this.knJ);
    }
    g.b(this.knT, 3, this.val$intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.g.1
 * JD-Core Version:    0.7.0.1
 */