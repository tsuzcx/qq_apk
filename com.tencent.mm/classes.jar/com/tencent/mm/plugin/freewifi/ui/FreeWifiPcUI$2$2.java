package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiPcUI$2$2
  implements f
{
  FreeWifiPcUI$2$2(FreeWifiPcUI.2 param2, am paramam) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    this.ksI.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.ksG.ksF.finish();
    }
    for (;;)
    {
      paramString = k.aTx();
      paramString.kmP = String.valueOf(FreeWifiPcUI.e(this.ksG.ksF));
      paramString.kmQ = FreeWifiPcUI.d(this.ksG.ksF);
      paramString.iGw = FreeWifiPcUI.c(this.ksG.ksF);
      paramString.kmS = k.b.knA.knD;
      paramString.kmT = k.b.knA.name;
      paramString.result = paramInt2;
      paramString.aTz().aTy();
      y.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ksG.ksF.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ksG.ksF.getIntent())), Integer.valueOf(FreeWifiPcUI.e(this.ksG.ksF)), FreeWifiPcUI.d(this.ksG.ksF), FreeWifiPcUI.c(this.ksG.ksF) });
      return;
      if ((com.tencent.mm.plugin.freewifi.m.cS(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString))) {
        FreeWifiPcUI.a(this.ksG.ksF, paramString + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.D(this.ksG.ksF.getIntent()), k.b.knA, paramInt2) + ")", "");
      } else {
        FreeWifiPcUI.a(this.ksG.ksF, this.ksG.ksF.getString(R.l.free_wifi_errmsg_cannot_set_pc_login_user_info), this.ksG.ksF.getString(R.l.free_wifi_errmsg_cannot_set_pc_login_user_info2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2.2
 * JD-Core Version:    0.7.0.1
 */