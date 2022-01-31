package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$2
  implements Runnable
{
  g$2(g paramg, String paramString1, String paramString2, Intent paramIntent) {}
  
  public final void run()
  {
    String str1 = g.Dy(this.koI);
    y.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get redirect location from loginurl : %s, %s", new Object[] { str1, this.koI });
    if (!bk.bl(str1))
    {
      String str2 = g.dh(str1, "res=");
      y.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get connect result from location : %s, %s", new Object[] { str2, str1 });
      if ((!bk.bl(str2)) && ((str2.startsWith("success")) || (str2.startsWith("already"))))
      {
        g.b(this.knT, 2, this.val$intent);
        str1 = this.knT;
        j.aUi().DD(str1);
        return;
      }
    }
    g.b(this.knT, 3, this.val$intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.g.2
 * JD-Core Version:    0.7.0.1
 */