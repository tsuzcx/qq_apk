package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiAuthStateUI$1$1
  implements f
{
  FreeWifiAuthStateUI$1$1(FreeWifiAuthStateUI.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.kqU.kqT.kqM = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (com.tencent.mm.plugin.freewifi.d.a)paramm;
      paramString = paramm.aUq();
      y.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[] { paramString });
      paramm = paramm.aUw();
      if (paramm != null)
      {
        y.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramm.svu, paramm.hRf, paramm.hPY, Integer.valueOf(paramm.syP), paramm.syQ, paramm.ffk });
        this.kqU.kqT.bOL = paramm.svu;
        this.kqU.kqT.kpv = paramm.hRf;
        this.kqU.kqT.bNZ = paramm.hPY;
        this.kqU.kqT.ksJ = paramm.syP;
        this.kqU.kqT.ksK = paramm.syQ;
        this.kqU.kqT.signature = paramm.ffk;
        this.kqU.kqT.ksL = paramm.syR;
      }
      j.aUn().a(this.kqU.kqT.ssid, paramString, this.kqU.kqT.getIntent());
      return;
    }
    if (paramInt2 == -2014)
    {
      d.a(this.kqU.kqT.ssid, -2014, this.kqU.kqT.getIntent());
      return;
    }
    d.a(this.kqU.kqT.ssid, 3, this.kqU.kqT.getIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI.1.1
 * JD-Core Version:    0.7.0.1
 */