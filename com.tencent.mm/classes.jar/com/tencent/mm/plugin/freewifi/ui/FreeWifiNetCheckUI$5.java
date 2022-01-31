package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.sdk.platformtools.ab;

final class FreeWifiNetCheckUI$5
  implements f
{
  FreeWifiNetCheckUI$5(FreeWifiNetCheckUI paramFreeWifiNetCheckUI, String paramString1, String paramString2, String paramString3) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(21038);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((h)paramm).bAV();
      if (paramString != null)
      {
        paramm = this.mOl.getIntent();
        paramm.putExtra("free_wifi_appid", paramString.woB);
        paramm.putExtra("free_wifi_head_img_url", paramString.nqE);
        paramm.putExtra("free_wifi_welcome_msg", paramString.wXi);
        paramm.putExtra("free_wifi_welcome_sub_title", paramString.wXk);
        paramm.putExtra("free_wifi_privacy_url", paramString.wXj);
        paramm.putExtra("free_wifi_app_nickname", paramString.jKG);
        paramm.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", this.mOm);
        paramm.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", this.mOn);
        paramm.setClass(this.mOl, FreeWifiPcUI.class);
        this.mOl.finish();
        this.mOl.startActivity(paramm);
      }
    }
    for (;;)
    {
      paramString = k.bAc();
      paramString.mIB = this.mOm;
      paramString.mIC = this.hye;
      paramString.kMp = this.mOn;
      paramString.mIF = k.b.mJl.mJq;
      paramString.mIG = k.b.mJl.name;
      paramString.result = paramInt2;
      paramString.bAe().bAd();
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mOl.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mOl.getIntent())), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(21038);
      return;
      if ((com.tencent.mm.plugin.freewifi.m.eq(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString))) {
        FreeWifiNetCheckUI.a(this.mOl, paramString + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.W(FreeWifiNetCheckUI.b(this.mOl)), k.b.mJl, paramInt2) + ")", "");
      } else {
        FreeWifiNetCheckUI.a(this.mOl, this.mOl.getString(2131300147), this.mOl.getString(2131300148));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.5
 * JD-Core Version:    0.7.0.1
 */