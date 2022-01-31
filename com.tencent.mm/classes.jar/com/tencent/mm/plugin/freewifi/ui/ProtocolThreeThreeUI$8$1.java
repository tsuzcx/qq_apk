package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeThreeUI$8$1
  implements com.tencent.mm.ah.f
{
  ProtocolThreeThreeUI$8$1(ProtocolThreeThreeUI.8 param8) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktn.ktl.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktn.ktl.getIntent())), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.freewifi.d.f)paramm).aUw();
      if (paramString != null)
      {
        y.i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramString.svu, paramString.hRf, paramString.hPY, Integer.valueOf(paramString.syP), paramString.syQ, paramString.ffk });
        this.ktn.ktl.kpv = paramString.hRf;
        this.ktn.ktl.bNZ = paramString.hPY;
        this.ktn.ktl.ksJ = paramString.syP;
        this.ktn.ktl.ksK = paramString.syQ;
        this.ktn.ktl.signature = paramString.ffk;
        this.ktn.ktl.ksL = paramString.syR;
        y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktn.ktl.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktn.ktl.getIntent())), this.ktn.ktl.appId, this.ktn.ktl.kpv, this.ktn.ktl.bNZ, Integer.valueOf(this.ktn.ktl.ksJ), this.ktn.ktl.ksK, this.ktn.ktl.signature, this.ktn.ktl.ksL });
      }
      d.a(this.ktn.ktl.ssid, 2, this.ktn.ktl.getIntent());
      y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktn.ktl.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktn.ktl.getIntent())), Integer.valueOf(2) });
      return;
    }
    if (paramInt2 == -30032)
    {
      paramString = new Intent();
      paramString.putExtra("free_wifi_error_ui_error_msg", this.ktn.ktl.getString(R.l.free_wifi_errmsg_33_invalid_sign_warnning));
      paramString.setClass(this.ktn.ktl, FreeWifiErrorUI.class);
      this.ktn.ktl.finish();
      this.ktn.ktl.startActivity(paramString);
      return;
    }
    d.a(this.ktn.ktl.ssid, 3, this.ktn.ktl.getIntent());
    y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktn.ktl.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktn.ktl.getIntent())), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.8.1
 * JD-Core Version:    0.7.0.1
 */