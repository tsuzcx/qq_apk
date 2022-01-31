package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeOneUI$8$1
  implements f
{
  ProtocolThreeOneUI$8$1(ProtocolThreeOneUI.8 param8) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktk.kti.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktk.kti.getIntent())), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0) || (!(paramm instanceof a))) {
      return;
    }
    paramString = ((a)paramm).aUw();
    if (paramString != null)
    {
      y.i("MicroMsg.FreeWifi.Protocol31UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramString.svu, paramString.hRf, paramString.hPY, Integer.valueOf(paramString.syP), paramString.syQ, paramString.ffk });
      this.ktk.kti.bOL = paramString.svu;
      this.ktk.kti.kpv = paramString.hRf;
      this.ktk.kti.bNZ = paramString.hPY;
      this.ktk.kti.ksJ = paramString.syP;
      this.ktk.kti.ksK = paramString.syQ;
      this.ktk.kti.signature = paramString.ffk;
      this.ktk.kti.ksL = paramString.syR;
      y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktk.kti.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktk.kti.getIntent())), this.ktk.kti.bOL, this.ktk.kti.kpv, this.ktk.kti.bNZ, Integer.valueOf(this.ktk.kti.ksJ), this.ktk.kti.ksK, this.ktk.kti.signature, this.ktk.kti.ksL });
    }
    d.a(this.ktk.kti.ssid, 2, this.ktk.kti.getIntent());
    y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.ktk.kti.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.ktk.kti.getIntent())), Integer.valueOf(2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.8.1
 * JD-Core Version:    0.7.0.1
 */