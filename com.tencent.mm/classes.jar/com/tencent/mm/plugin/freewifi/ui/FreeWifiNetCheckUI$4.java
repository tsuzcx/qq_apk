package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiNetCheckUI$4
  implements f
{
  FreeWifiNetCheckUI$4(FreeWifiNetCheckUI paramFreeWifiNetCheckUI, String paramString1, String paramString2, String paramString3) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((h)paramm).aUt();
      if (paramString != null)
      {
        paramm = this.ksx.getIntent();
        paramm.putExtra("free_wifi_appid", paramString.svu);
        paramm.putExtra("free_wifi_head_img_url", paramString.kSF);
        paramm.putExtra("free_wifi_welcome_msg", paramString.sYN);
        paramm.putExtra("free_wifi_welcome_sub_title", paramString.sYP);
        paramm.putExtra("free_wifi_privacy_url", paramString.sYO);
        paramm.putExtra("free_wifi_app_nickname", paramString.hRf);
        paramm.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", this.ksy);
        paramm.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", this.ksz);
        paramm.setClass(this.ksx, FreeWifiPcUI.class);
        this.ksx.finish();
        this.ksx.startActivity(paramm);
      }
    }
    for (;;)
    {
      paramString = k.aTx();
      paramString.kmP = this.ksy;
      paramString.kmQ = this.gge;
      paramString.iGw = this.ksz;
      paramString.kmS = k.b.kny.knD;
      paramString.kmT = k.b.kny.name;
      paramString.result = paramInt2;
      paramString.aTz().aTy();
      y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ksx.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ksx.getIntent())), Integer.valueOf(paramInt2) });
      return;
      if ((com.tencent.mm.plugin.freewifi.m.cS(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString))) {
        FreeWifiNetCheckUI.a(this.ksx, paramString + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.D(FreeWifiNetCheckUI.b(this.ksx)), k.b.kny, paramInt2) + ")", "");
      } else {
        FreeWifiNetCheckUI.a(this.ksx, this.ksx.getString(R.l.free_wifi_errmsg_cannot_get_pc_front_page), this.ksx.getString(R.l.free_wifi_errmsg_cannot_get_pc_front_page2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.4
 * JD-Core Version:    0.7.0.1
 */