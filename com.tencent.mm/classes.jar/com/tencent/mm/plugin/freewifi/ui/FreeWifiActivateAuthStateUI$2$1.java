package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiActivateAuthStateUI$2$1
  implements f
{
  FreeWifiActivateAuthStateUI$2$1(FreeWifiActivateAuthStateUI.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.kqC.kqB.kqM = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.freewifi.d.a)paramm).aUq();
      y.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", new Object[] { paramString });
      j.aUn().a(this.kqC.kqB.ssid, paramString, this.kqC.kqB.getIntent());
      return;
    }
    if (paramInt2 == -2014)
    {
      d.a(this.kqC.kqB.ssid, -2014, this.kqC.kqB.getIntent());
      return;
    }
    d.a(this.kqC.kqB.ssid, 3, this.kqC.kqB.getIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.2.1
 * JD-Core Version:    0.7.0.1
 */