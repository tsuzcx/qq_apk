package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeTwoUI$2$1
  implements f
{
  ProtocolThreeTwoUI$2$1(ProtocolThreeTwoUI.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktp.kto.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktp.kto.getIntent())), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0) || (!(paramm instanceof a))) {
      return;
    }
    paramString = ((a)paramm).aUw();
    if (paramString != null)
    {
      y.i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramString.svu, paramString.hRf, paramString.hPY, Integer.valueOf(paramString.syP), paramString.syQ, paramString.ffk });
      this.ktp.kto.bOL = paramString.svu;
      this.ktp.kto.kpv = paramString.hRf;
      this.ktp.kto.bNZ = paramString.hPY;
      this.ktp.kto.ksJ = paramString.syP;
      this.ktp.kto.ksK = paramString.syQ;
      this.ktp.kto.signature = paramString.ffk;
      this.ktp.kto.ksL = paramString.syR;
      y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktp.kto.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktp.kto.getIntent())), this.ktp.kto.bOL, this.ktp.kto.kpv, this.ktp.kto.bNZ, Integer.valueOf(this.ktp.kto.ksJ), this.ktp.kto.ksK, this.ktp.kto.signature, this.ktp.kto.ksL });
    }
    d.a(this.ktp.kto.ssid, 2, this.ktp.kto.getIntent());
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktp.kto.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktp.kto.getIntent())), Integer.valueOf(2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.2.1
 * JD-Core Version:    0.7.0.1
 */