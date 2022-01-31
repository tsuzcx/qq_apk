package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeThreeUI$8$1
  implements com.tencent.mm.ai.f
{
  ProtocolThreeThreeUI$8$1(ProtocolThreeThreeUI.8 param8) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(21157);
    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mPb.mOZ.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mPb.mOZ.getIntent())), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.freewifi.d.f)paramm).bAW();
      if (paramString != null)
      {
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramString.woB, paramString.jKG, paramString.jJA, Integer.valueOf(paramString.wsQ), paramString.wsR, paramString.gwS });
        this.mPb.mOZ.mLh = paramString.jKG;
        this.mPb.mOZ.cvr = paramString.jJA;
        this.mPb.mOZ.mOy = paramString.wsQ;
        this.mPb.mOZ.mOz = paramString.wsR;
        this.mPb.mOZ.signature = paramString.gwS;
        this.mPb.mOZ.mOA = paramString.wsS;
        ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mPb.mOZ.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mPb.mOZ.getIntent())), this.mPb.mOZ.appId, this.mPb.mOZ.mLh, this.mPb.mOZ.cvr, Integer.valueOf(this.mPb.mOZ.mOy), this.mPb.mOZ.mOz, this.mPb.mOZ.signature, this.mPb.mOZ.mOA });
      }
      d.a(this.mPb.mOZ.ssid, 2, this.mPb.mOZ.getIntent());
      ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mPb.mOZ.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mPb.mOZ.getIntent())), Integer.valueOf(2) });
      AppMethodBeat.o(21157);
      return;
    }
    if (paramInt2 == -30032)
    {
      paramString = new Intent();
      paramString.putExtra("free_wifi_error_ui_error_msg", this.mPb.mOZ.getString(2131300146));
      paramString.setClass(this.mPb.mOZ, FreeWifiErrorUI.class);
      this.mPb.mOZ.finish();
      this.mPb.mOZ.startActivity(paramString);
      AppMethodBeat.o(21157);
      return;
    }
    d.a(this.mPb.mOZ.ssid, 3, this.mPb.mOZ.getIntent());
    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mPb.mOZ.getIntent()), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mPb.mOZ.getIntent())), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(21157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.8.1
 * JD-Core Version:    0.7.0.1
 */