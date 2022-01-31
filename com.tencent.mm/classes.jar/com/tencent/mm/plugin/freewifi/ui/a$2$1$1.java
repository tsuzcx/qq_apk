package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.bl.a;
import com.tencent.mm.sdk.g.a.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$2$1$1
  implements Runnable
{
  a$2$1$1(a.2.1 param1, bl parambl) {}
  
  public final void run()
  {
    AppMethodBeat.i(20923);
    if (bo.isNullOrNil(this.mMN.coU.coZ))
    {
      this.mMO.mML.setVisibility(8);
      AppMethodBeat.o(20923);
      return;
    }
    a.c(this.mMO.mMM.mMK).setText(this.mMN.coU.coZ);
    String str2 = this.mMN.coU.coW;
    if ("0".equalsIgnoreCase(this.mMN.coU.coV)) {}
    String str3;
    String str4;
    String str5;
    String str6;
    for (String str1 = "0";; str1 = "1")
    {
      str3 = this.mMN.coU.coX;
      str4 = this.mMN.coU.ssid;
      str5 = this.mMN.coU.bssid;
      str6 = this.mMN.coU.coY;
      ab.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to show bar. pingEnabled = %s,  pingUrl= %s", new Object[] { str1, str2 });
      if ("1".equals(str1)) {
        break;
      }
      this.mMO.mML.setVisibility(0);
      AppMethodBeat.o(20923);
      return;
    }
    d.ysn.aj(new a.2.1.1.1(this, str2, str4, str5, str6, str3));
    AppMethodBeat.o(20923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.a.2.1.1
 * JD-Core Version:    0.7.0.1
 */