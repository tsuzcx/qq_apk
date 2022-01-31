package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeTwoUI$2$1
  implements f
{
  ProtocolThreeTwoUI$2$1(ProtocolThreeTwoUI.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(21173);
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mPd.mPc.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mPd.mPc.getIntent())), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof a))
      {
        AppMethodBeat.o(21173);
        return;
      }
      paramString = ((a)paramm).bAW();
      if (paramString != null)
      {
        ab.i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramString.woB, paramString.jKG, paramString.jJA, Integer.valueOf(paramString.wsQ), paramString.wsR, paramString.gwS });
        this.mPd.mPc.cwc = paramString.woB;
        this.mPd.mPc.mLh = paramString.jKG;
        this.mPd.mPc.cvr = paramString.jJA;
        this.mPd.mPc.mOy = paramString.wsQ;
        this.mPd.mPc.mOz = paramString.wsR;
        this.mPd.mPc.signature = paramString.gwS;
        this.mPd.mPc.mOA = paramString.wsS;
        ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mPd.mPc.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mPd.mPc.getIntent())), this.mPd.mPc.cwc, this.mPd.mPc.mLh, this.mPd.mPc.cvr, Integer.valueOf(this.mPd.mPc.mOy), this.mPd.mPc.mOz, this.mPd.mPc.signature, this.mPd.mPc.mOA });
      }
      d.a(this.mPd.mPc.ssid, 2, this.mPd.mPc.getIntent());
      ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mPd.mPc.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mPd.mPc.getIntent())), Integer.valueOf(2) });
    }
    AppMethodBeat.o(21173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.2.1
 * JD-Core Version:    0.7.0.1
 */