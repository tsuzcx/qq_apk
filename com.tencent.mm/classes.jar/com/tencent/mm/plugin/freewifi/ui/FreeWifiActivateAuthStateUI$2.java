package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiActivateAuthStateUI$2
  implements g.b
{
  FreeWifiActivateAuthStateUI$2(FreeWifiActivateAuthStateUI paramFreeWifiActivateAuthStateUI) {}
  
  public final void bE(String paramString, int paramInt)
  {
    String str = d.aTV();
    y.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[] { paramString, this.kqB.kpt, str });
    if (!bk.bl(paramString)) {
      new a(this.kqB.kpt, this.kqB.ssid, str, this.kqB.kqK, paramString, "", paramInt, m.B(this.kqB.getIntent())).b(new FreeWifiActivateAuthStateUI.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.2
 * JD-Core Version:    0.7.0.1
 */