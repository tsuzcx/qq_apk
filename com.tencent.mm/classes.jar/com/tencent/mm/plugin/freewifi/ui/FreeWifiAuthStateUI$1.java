package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiAuthStateUI$1
  implements g.b
{
  FreeWifiAuthStateUI$1(FreeWifiAuthStateUI paramFreeWifiAuthStateUI) {}
  
  public final void bE(String paramString, int paramInt)
  {
    String str = d.aTV();
    y.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramString, this.kqT.kpt, str });
    if (!bk.bl(paramString)) {
      new a(this.kqT.kpt, this.kqT.ssid, str, this.kqT.kqK, paramString, "", paramInt, m.B(this.kqT.getIntent())).b(new FreeWifiAuthStateUI.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI.1
 * JD-Core Version:    0.7.0.1
 */