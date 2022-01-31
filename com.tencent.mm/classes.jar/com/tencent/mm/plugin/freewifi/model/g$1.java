package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class g$1
  implements Runnable
{
  g$1(g paramg, String paramString, Intent paramIntent, g.b paramb, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(20724);
    int i = this.mKu.mKs;
    String str3;
    for (;;)
    {
      int j = i - 1;
      if (i <= 0) {
        break label268;
      }
      ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "now retry count = %d", new Object[] { Integer.valueOf(j) });
      g.b(this.mJG, 1, this.val$intent);
      str3 = com.tencent.mm.m.g.Nr().Ne();
      ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from cinfig : %s", new Object[] { str3 });
      String str1 = str3;
      if (bo.isNullOrNil(str3))
      {
        ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from config failed, use the default url : %s", new Object[] { "http://10.1.0.6/redirect" });
        str1 = "http://10.1.0.6/redirect";
      }
      str3 = g.OG(str1);
      ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url : %s, %s", new Object[] { str1, str3 });
      if (!bo.isNullOrNil(str3)) {
        break;
      }
      ab.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url failed : %s, %s", new Object[] { str1, str3 });
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
    String str2 = g.ev(str3, "auth=");
    ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauthmessage from location : %s, %s", new Object[] { str2, str3 });
    if (bo.isNullOrNil(str2))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauth message from location failed : %s", new Object[] { str3 });
      g.b(this.mJG, 3, this.val$intent);
    }
    if (this.mKt != null) {
      this.mKt.cm(str2, this.mJw);
    }
    AppMethodBeat.o(20724);
    return;
    label268:
    if (this.mKt != null) {
      this.mKt.cm(null, this.mJw);
    }
    g.b(this.mJG, 3, this.val$intent);
    AppMethodBeat.o(20724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.g.1
 * JD-Core Version:    0.7.0.1
 */