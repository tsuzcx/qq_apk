package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeOneUI$8$1
  implements f
{
  ProtocolThreeOneUI$8$1(ProtocolThreeOneUI.8 param8) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(21131);
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mOY.mOW.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mOY.mOW.getIntent())), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof a))
      {
        AppMethodBeat.o(21131);
        return;
      }
      paramString = ((a)paramm).bAW();
      if (paramString != null)
      {
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramString.woB, paramString.jKG, paramString.jJA, Integer.valueOf(paramString.wsQ), paramString.wsR, paramString.gwS });
        this.mOY.mOW.cwc = paramString.woB;
        this.mOY.mOW.mLh = paramString.jKG;
        this.mOY.mOW.cvr = paramString.jJA;
        this.mOY.mOW.mOy = paramString.wsQ;
        this.mOY.mOW.mOz = paramString.wsR;
        this.mOY.mOW.signature = paramString.gwS;
        this.mOY.mOW.mOA = paramString.wsS;
        ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mOY.mOW.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mOY.mOW.getIntent())), this.mOY.mOW.cwc, this.mOY.mOW.mLh, this.mOY.mOW.cvr, Integer.valueOf(this.mOY.mOW.mOy), this.mOY.mOW.mOz, this.mOY.mOW.signature, this.mOY.mOW.mOA });
      }
      d.a(this.mOY.mOW.ssid, 2, this.mOY.mOW.getIntent());
      ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mOY.mOW.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mOY.mOW.getIntent())), Integer.valueOf(2) });
    }
    AppMethodBeat.o(21131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.8.1
 * JD-Core Version:    0.7.0.1
 */