package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.h.a.bj;
import com.tencent.mm.h.a.bj.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$2$1$1
  implements Runnable
{
  a$2$1$1(a.2.1 param1, bj parambj) {}
  
  public final void run()
  {
    if (bk.bl(this.kra.bHF.bHK))
    {
      this.krb.kqY.setVisibility(8);
      return;
    }
    ((TextView)a.c(this.krb.kqZ.kqX).findViewById(R.h.free_wifi_banner_tv)).setText(this.kra.bHF.bHK);
    String str2 = this.kra.bHF.bHH;
    if ("0".equalsIgnoreCase(this.kra.bHF.bHG)) {}
    String str3;
    String str4;
    String str5;
    String str6;
    for (String str1 = "0";; str1 = "1")
    {
      str3 = this.kra.bHF.bHI;
      str4 = this.kra.bHF.ssid;
      str5 = this.kra.bHF.bssid;
      str6 = this.kra.bHF.bHJ;
      y.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to show bar. pingEnabled = %s,  pingUrl= %s", new Object[] { str1, str2 });
      if ("1".equals(str1)) {
        break;
      }
      this.krb.kqY.setVisibility(0);
      return;
    }
    au.DS().O(new a.2.1.1.1(this, str2, str4, str5, str6, str3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.a.2.1.1
 * JD-Core Version:    0.7.0.1
 */