package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;

final class i$3$1
  implements com.tencent.mm.ai.f
{
  i$3$1(i.3 param3) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(20839);
    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mLB.mLz.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mLB.mLz.intent)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject = k.bAc();
    ((k.a)localObject).ssid = this.mLB.mLz.ssid;
    ((k.a)localObject).bssid = com.tencent.mm.plugin.freewifi.m.Ox("MicroMsg.FreeWifi.Protocol33");
    ((k.a)localObject).coY = com.tencent.mm.plugin.freewifi.m.Oy("MicroMsg.FreeWifi.Protocol33");
    ((k.a)localObject).coX = this.mLB.mLz.coX;
    ((k.a)localObject).kMp = com.tencent.mm.plugin.freewifi.m.U(this.mLB.mLz.intent);
    ((k.a)localObject).mIE = com.tencent.mm.plugin.freewifi.m.W(this.mLB.mLz.intent);
    ((k.a)localObject).mIF = k.b.mIU.mJq;
    ((k.a)localObject).mIG = k.b.mIU.name;
    ((k.a)localObject).cCy = com.tencent.mm.plugin.freewifi.m.X(this.mLB.mLz.intent);
    ((k.a)localObject).result = paramInt2;
    ((k.a)localObject).eev = paramString;
    ((k.a)localObject).bAe().bAd();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.freewifi.d.f)paramm).bAW();
      if (paramString != null)
      {
        ab.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramString.woB, paramString.jKG, paramString.jJA, Integer.valueOf(paramString.wsQ), paramString.wsR, paramString.gwS, paramString.wsS });
        paramm = this.mLB.mLz.mLf;
        localObject = FreeWifiFrontPageUI.d.mNK;
        FreeWifiFrontPageUI.b localb = new FreeWifiFrontPageUI.b();
        localb.mNG = paramString;
        paramm.a((FreeWifiFrontPageUI.d)localObject, localb);
        AppMethodBeat.o(20839);
        return;
      }
      paramString = this.mLB.mLz.mLf;
      paramm = FreeWifiFrontPageUI.d.mNJ;
      localObject = new FreeWifiFrontPageUI.a();
      ((FreeWifiFrontPageUI.a)localObject).mNi = com.tencent.mm.plugin.freewifi.m.a(this.mLB.mLz.mLg, k.b.mIU, 20);
      paramString.a(paramm, localObject);
      AppMethodBeat.o(20839);
      return;
    }
    if (paramInt2 == -30032)
    {
      paramString = new Intent();
      paramString.putExtra("free_wifi_error_ui_error_msg", this.mLB.mLz.mLf.getString(2131300146));
      paramString.setClass(this.mLB.mLz.mLf, FreeWifiErrorUI.class);
      this.mLB.mLz.mLf.finish();
      this.mLB.mLz.mLf.startActivity(paramString);
      AppMethodBeat.o(20839);
      return;
    }
    paramString = this.mLB.mLz.mLf;
    paramm = FreeWifiFrontPageUI.d.mNJ;
    localObject = new FreeWifiFrontPageUI.a();
    ((FreeWifiFrontPageUI.a)localObject).mNh = 2131300141;
    ((FreeWifiFrontPageUI.a)localObject).mNi = com.tencent.mm.plugin.freewifi.m.a(this.mLB.mLz.mLg, k.b.mIU, paramInt2);
    paramString.a(paramm, localObject);
    AppMethodBeat.o(20839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.i.3.1
 * JD-Core Version:    0.7.0.1
 */