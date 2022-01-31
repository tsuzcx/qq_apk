package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.y;

final class FreewifiWeChatNoAuthStateUI$1
  implements f
{
  FreewifiWeChatNoAuthStateUI$1(FreewifiWeChatNoAuthStateUI paramFreewifiWeChatNoAuthStateUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(640, this);
    y.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
      paramString = ((a)paramm).aUw();
      if (paramString != null)
      {
        y.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramString.svu, paramString.hRf, paramString.hPY, Integer.valueOf(paramString.syP), paramString.syQ, paramString.ffk });
        this.ktg.bOL = paramString.svu;
        this.ktg.kpv = paramString.hRf;
        this.ktg.bNZ = paramString.hPY;
        this.ktg.ksJ = paramString.syP;
        this.ktg.ksK = paramString.syQ;
        this.ktg.signature = paramString.ffk;
        this.ktg.ksL = paramString.syR;
      }
      d.a(this.ktg.ssid, 2, this.ktg.getIntent());
      return;
    }
    y.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiWeChatNoAuthStateUI.a(this.ktg)), FreewifiWeChatNoAuthStateUI.b(this.ktg), FreewifiWeChatNoAuthStateUI.c(this.ktg) });
    d.a(this.ktg.ssid, -2014, this.ktg.getIntent());
    d.Dw(FreewifiWeChatNoAuthStateUI.c(this.ktg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiWeChatNoAuthStateUI.1
 * JD-Core Version:    0.7.0.1
 */