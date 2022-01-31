package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class FreewifiActivateWeChatNoAuthStateUI$1
  implements f
{
  FreewifiActivateWeChatNoAuthStateUI$1(FreewifiActivateWeChatNoAuthStateUI paramFreewifiActivateWeChatNoAuthStateUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(640, this);
    y.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
      d.a(this.ktf.ssid, 2, this.ktf.getIntent());
      return;
    }
    y.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[] { Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.a(this.ktf)), FreewifiActivateWeChatNoAuthStateUI.b(this.ktf), FreewifiActivateWeChatNoAuthStateUI.c(this.ktf) });
    this.ktf.qv(-2014);
    d.Dw(FreewifiActivateWeChatNoAuthStateUI.c(this.ktf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreewifiActivateWeChatNoAuthStateUI.1
 * JD-Core Version:    0.7.0.1
 */