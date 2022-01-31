package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements f
{
  b$2(b paramb, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(20932);
    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mMT.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mMT.intent)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject = k.bAc();
      ((k.a)localObject).coX = this.mMT.coX;
      ((k.a)localObject).kMp = com.tencent.mm.plugin.freewifi.m.U(this.mMT.intent);
      ((k.a)localObject).mIF = k.b.mJa.mJq;
      ((k.a)localObject).mIG = k.b.mJa.name;
      ((k.a)localObject).cCy = this.mMT.cCy;
      ((k.a)localObject).result = paramInt2;
      ((k.a)localObject).eev = paramString;
      ((k.a)localObject).bAe().c(this.mMT.intent, false).bAd();
      paramm = (i)paramm;
      paramString = paramm.bBa();
      if (com.tencent.mm.plugin.freewifi.m.isEmpty(paramString))
      {
        ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mMT.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mMT.intent)) });
        this.mMT.OM(this.mMT.activity.getString(2131300151));
        paramString = k.bAc();
        paramString.coX = this.mMT.coX;
        paramString.kMp = com.tencent.mm.plugin.freewifi.m.U(this.mMT.intent);
        paramString.mIF = k.b.mJb.mJq;
        paramString.mIG = k.b.mJb.name;
        paramString.cCy = this.mMT.cCy;
        paramString.mIE = com.tencent.mm.plugin.freewifi.m.W(this.mMT.intent);
        paramString.result = -1;
        paramString.eev = "31 auth url is empty.";
        paramString.bAe().c(this.mMT.intent, true).bAd();
        AppMethodBeat.o(20932);
        return;
      }
      paramm = com.tencent.mm.plugin.freewifi.m.Ov(paramm.bBb());
      localObject = com.tencent.mm.plugin.freewifi.m.Ov(this.mMU);
      String str = com.tencent.mm.plugin.freewifi.m.Ov(this.mMV);
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      if (paramString.indexOf("?") != -1) {
        localStringBuilder.append("&extend=").append(paramm);
      }
      for (;;)
      {
        localStringBuilder.append("&openId=").append((String)localObject).append("&tid=").append(str).append("&timestamp=").append(com.tencent.mm.plugin.freewifi.m.Ov(this.mMW)).append("&sign=").append(com.tencent.mm.plugin.freewifi.m.Ov(this.mMX));
        ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mMT.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mMT.intent)), localStringBuilder.toString() });
        this.mMT.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", localStringBuilder.toString());
        this.mMT.intent.setClass(this.mMT.activity, FreeWifiFrontPageUI.class);
        this.mMT.activity.startActivity(this.mMT.intent);
        this.mMT.activity.finish();
        this.mMT.activity.overridePendingTransition(2131034266, 2131034263);
        paramString = k.bAc();
        paramString.coX = this.mMT.coX;
        paramString.kMp = com.tencent.mm.plugin.freewifi.m.U(this.mMT.intent);
        paramString.mIF = k.b.mJb.mJq;
        paramString.mIG = k.b.mJb.name;
        paramString.cCy = this.mMT.cCy;
        paramString.mIE = com.tencent.mm.plugin.freewifi.m.W(this.mMT.intent);
        paramString.result = 0;
        paramString.eev = "";
        paramString.bAe().c(this.mMT.intent, true).bAd();
        AppMethodBeat.o(20932);
        return;
        localStringBuilder.append("?extend=").append(paramm);
      }
    }
    paramm = k.bAc();
    paramm.coX = this.mMT.coX;
    paramm.kMp = com.tencent.mm.plugin.freewifi.m.U(this.mMT.intent);
    paramm.mIF = k.b.mJa.mJq;
    paramm.mIG = k.b.mJa.name;
    paramm.cCy = this.mMT.cCy;
    paramm.mIE = com.tencent.mm.plugin.freewifi.m.W(this.mMT.intent);
    paramm.result = paramInt2;
    paramm.eev = paramString;
    paramm.bAe().c(this.mMT.intent, true).bAd();
    if ((com.tencent.mm.plugin.freewifi.m.eq(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString)))
    {
      this.mMT.OM(paramString + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.W(this.mMT.intent), k.b.mJa, paramInt2) + ")");
      AppMethodBeat.o(20932);
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(paramString))
    {
      this.mMT.OM(this.mMT.activity.getString(2131300151));
      AppMethodBeat.o(20932);
      return;
    }
    this.mMT.OM(paramString);
    AppMethodBeat.o(20932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.b.2
 * JD-Core Version:    0.7.0.1
 */