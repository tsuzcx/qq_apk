package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.d.c;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

final class b$1
  implements f
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(20931);
    Object localObject1 = k.bAc();
    ((k.a)localObject1).coX = this.mMT.coX;
    ((k.a)localObject1).kMp = com.tencent.mm.plugin.freewifi.m.U(this.mMT.intent);
    ((k.a)localObject1).mIF = k.b.mIO.mJq;
    ((k.a)localObject1).mIG = k.b.mIO.name;
    ((k.a)localObject1).mIE = com.tencent.mm.plugin.freewifi.m.W(this.mMT.intent);
    ((k.a)localObject1).cCy = this.mMT.cCy;
    ((k.a)localObject1).result = paramInt2;
    ((k.a)localObject1).eev = paramString;
    localObject1 = ((k.a)localObject1).bAe();
    Object localObject2 = this.mMT.intent;
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((k)localObject1).c((Intent)localObject2, bool).bAd();
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(this.mMT.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(this.mMT.intent)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label2394;
      }
      paramString = this.mMT;
      if ((paramm instanceof a)) {
        break;
      }
      paramString.OM(paramString.activity.getString(2131300151));
      AppMethodBeat.o(20931);
      return;
    }
    localObject1 = (a)paramm;
    paramString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", ((a)localObject1).bAU());
    Object localObject4 = ((a)localObject1).bAV();
    if (localObject4 != null)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.U(paramString.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(paramString.intent)), ((aeg)localObject4).woB, ((aeg)localObject4).jKG, ((aeg)localObject4).jJA, ((aeg)localObject4).nqE, ((aeg)localObject4).wXi, ((aeg)localObject4).wXj, ((aeg)localObject4).wvC, ((aeg)localObject4).wKX, Integer.valueOf(((aeg)localObject4).wkZ) });
      paramString.intent.putExtra("free_wifi_appid", ((aeg)localObject4).woB);
      paramString.intent.putExtra("free_wifi_head_img_url", ((aeg)localObject4).nqE);
      paramString.intent.putExtra("free_wifi_welcome_msg", ((aeg)localObject4).wXi);
      paramString.intent.putExtra("free_wifi_privacy_url", ((aeg)localObject4).wXj);
      paramString.intent.putExtra("free_wifi_app_nickname", ((aeg)localObject4).jKG);
      paramString.intent.putExtra("free_wifi_welcome_sub_title", ((aeg)localObject4).wXk);
    }
    if (paramString.cCy != 2) {
      paramString.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
    }
    Object localObject3 = ((a)localObject1).bAT();
    if (localObject3 == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
      paramString.activity.finish();
      paramm = k.bAc();
      paramm.coX = paramString.coX;
      paramm.kMp = com.tencent.mm.plugin.freewifi.m.U(paramString.intent);
      paramm.mIF = k.b.mIP.mJq;
      paramm.mIG = k.b.mIP.name;
      paramm.mIE = com.tencent.mm.plugin.freewifi.m.W(paramString.intent);
      paramm.cCy = paramString.cCy;
      paramm.result = -1;
      paramm.eev = "qstrInfo is null.";
      paramm.bAe().c(paramString.intent, true).bAd();
      AppMethodBeat.o(20931);
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(((bpx)localObject3).lGx))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
      paramString.activity.finish();
      paramm = k.bAc();
      paramm.coX = paramString.coX;
      paramm.kMp = com.tencent.mm.plugin.freewifi.m.U(paramString.intent);
      paramm.mIF = k.b.mIP.mJq;
      paramm.mIG = k.b.mIP.name;
      paramm.mIE = com.tencent.mm.plugin.freewifi.m.W(paramString.intent);
      paramm.cCy = paramString.cCy;
      paramm.result = -1;
      paramm.eev = "qstrInfo.Ssid is empty.";
      paramm.bAe().c(paramString.intent, true).bAd();
      AppMethodBeat.o(20931);
      return;
    }
    paramString.intent.putExtra("free_wifi_ssid", ((bpx)localObject3).lGx);
    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(paramString.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(paramString.intent)), Integer.valueOf(((bpx)localObject3).xEp), ((bpx)localObject3).lGx, ((bpx)localObject3).wSj });
    paramm = ((a)localObject1).getOpenId();
    localObject1 = ((a)localObject1).Ge();
    paramString.intent.putExtra("free_wifi_openid", paramm);
    paramString.intent.putExtra("free_wifi_tid", (String)localObject1);
    paramString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", ((aeg)localObject4).wvC);
    paramString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", ((aeg)localObject4).wKX);
    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(paramString.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(paramString.intent)), paramm, localObject1 });
    paramString.intent.putExtra("free_wifi_protocol_type", ((bpx)localObject3).xEp);
    if (((bpx)localObject3).xEp == 10)
    {
      if ((bo.isNullOrNil(((bpx)localObject3).lGx)) || (bo.isNullOrNil(((bpx)localObject3).wSj)))
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
        paramString.activity.finish();
        AppMethodBeat.o(20931);
        return;
      }
      paramString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
      paramString.intent.putExtra("free_wifi_auth_type", 2);
      paramString.intent.putExtra("free_wifi_passowrd", ((bpx)localObject3).wSj);
      paramString.intent.setClass(paramString.activity, FreeWifiFrontPageUI.class);
      paramString.activity.startActivity(paramString.intent);
      paramString.activity.finish();
      paramString.activity.overridePendingTransition(2131034266, 2131034263);
      AppMethodBeat.o(20931);
      return;
    }
    if (((bpx)localObject3).xEp == 11)
    {
      if ((bo.isNullOrNil(((bpx)localObject3).lGx)) || (bo.isNullOrNil(((bpx)localObject3).wSj)))
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
        paramString.activity.finish();
        AppMethodBeat.o(20931);
        return;
      }
      paramString.intent.putExtra("free_wifi_auth_type", 2);
      paramString.intent.putExtra("free_wifi_passowrd", ((bpx)localObject3).wSj);
      paramString.intent.setClass(paramString.activity, FreewifiActivateWeChatNoAuthStateUI.class);
      paramString.activity.startActivity(paramString.intent);
      paramString.activity.finish();
      paramString.activity.overridePendingTransition(2131034266, 2131034263);
      AppMethodBeat.o(20931);
      return;
    }
    if (((bpx)localObject3).xEp == 12)
    {
      paramString.intent.putExtra("free_wifi_auth_type", 1);
      paramString.intent.setClass(paramString.activity, FreeWifiActivateAuthStateUI.class);
      paramString.activity.startActivity(paramString.intent);
      paramString.activity.finish();
      paramString.activity.overridePendingTransition(2131034266, 2131034263);
      AppMethodBeat.o(20931);
      return;
    }
    if (((bpx)localObject3).xEp == 31)
    {
      paramString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[] { com.tencent.mm.plugin.freewifi.m.U(paramString.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(paramString.intent)) });
      localObject2 = paramString.intent.getStringExtra("free_wifi_schema_ticket");
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[] { com.tencent.mm.plugin.freewifi.m.U(paramString.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(paramString.intent)), localObject2 });
      if (bo.isNullOrNil((String)localObject2))
      {
        paramString.activity.finish();
        paramm = k.bAc();
        paramm.coX = paramString.coX;
        paramm.kMp = com.tencent.mm.plugin.freewifi.m.U(paramString.intent);
        paramm.mIF = k.b.mIP.mJq;
        paramm.mIG = k.b.mIP.name;
        paramm.cCy = paramString.cCy;
        paramm.mIE = com.tencent.mm.plugin.freewifi.m.W(paramString.intent);
        paramm.result = -1;
        paramm.eev = "31 ticket is empty.";
        paramm.bAe().c(paramString.intent, true).bAd();
        AppMethodBeat.o(20931);
        return;
      }
      String str1 = ((bpx)localObject3).lGx;
      localObject3 = ((aeg)localObject4).wvC;
      localObject4 = ((aeg)localObject4).wKX;
      if (d.bAA() == null)
      {
        ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.U(paramString.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(paramString.intent)) });
        paramString.OM(paramString.activity.getString(2131300151));
        paramm = k.bAc();
        paramm.coX = paramString.coX;
        paramm.kMp = com.tencent.mm.plugin.freewifi.m.U(paramString.intent);
        paramm.mIF = k.b.mIP.mJq;
        paramm.mIG = k.b.mIP.name;
        paramm.cCy = paramString.cCy;
        paramm.mIE = com.tencent.mm.plugin.freewifi.m.W(paramString.intent);
        paramm.result = -1;
        paramm.eev = "wifiInfo is empty.";
        paramm.bAe().c(paramString.intent, true).bAd();
        AppMethodBeat.o(20931);
        return;
      }
      bool = d.OC(str1);
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. is_current_connected_ssid_equals_target_ssid=%b", new Object[] { com.tencent.mm.plugin.freewifi.m.U(paramString.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(paramString.intent)), Boolean.valueOf(bool) });
      str1 = at.gX(ah.getContext());
      String str2 = at.gY(ah.getContext());
      String str3 = com.tencent.mm.plugin.freewifi.m.Oy("MicroMsg.FreeWifi.FreeWifiNetCheckUI");
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.U(paramString.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(paramString.intent)), paramString.coX, str1, str2, str3, localObject2 });
      k.a locala = k.bAc();
      locala.coX = paramString.coX;
      locala.kMp = com.tencent.mm.plugin.freewifi.m.U(paramString.intent);
      locala.mIF = k.b.mIP.mJq;
      locala.mIG = k.b.mIP.name;
      locala.cCy = paramString.cCy;
      locala.mIE = com.tencent.mm.plugin.freewifi.m.W(paramString.intent);
      locala.result = 0;
      locala.eev = "";
      locala.bAe().c(paramString.intent, true).bAd();
      locala = k.bAc();
      locala.ssid = paramString.intent.getStringExtra("free_wifi_ssid");
      locala.coX = paramString.coX;
      locala.mIC = paramString.intent.getStringExtra("free_wifi_appid");
      locala.kMp = com.tencent.mm.plugin.freewifi.m.U(paramString.intent);
      locala.mIE = com.tencent.mm.plugin.freewifi.m.W(paramString.intent);
      locala.mIF = k.b.mIZ.mJq;
      locala.mIG = k.b.mIZ.name;
      locala.cCy = com.tencent.mm.plugin.freewifi.m.X(paramString.intent);
      locala.mIE = com.tencent.mm.plugin.freewifi.m.W(paramString.intent);
      locala.bAe().c(paramString.intent, false).bAd();
      new i(paramString.coX, str1, str2, str3, (String)localObject2, com.tencent.mm.plugin.freewifi.m.U(paramString.intent)).U(paramString.activity).c(new b.2(paramString, paramm, (String)localObject1, (String)localObject3, (String)localObject4));
      AppMethodBeat.o(20931);
      return;
    }
    if (((bpx)localObject3).xEp == 32)
    {
      paramString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[] { com.tencent.mm.plugin.freewifi.m.U(paramString.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.V(paramString.intent)) });
      paramString.intent.setClass(paramString.activity, FreeWifiFrontPageUI.class);
      paramString.activity.startActivity(paramString.intent);
      paramString.activity.finish();
      paramString.activity.overridePendingTransition(2131034266, 2131034263);
      AppMethodBeat.o(20931);
      return;
    }
    if (((bpx)localObject3).xEp == 1)
    {
      paramString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
      paramString.intent.putExtra("free_wifi_auth_type", 1);
      paramString.intent.setClass(paramString.activity, FreeWifiFrontPageUI.class);
      paramString.activity.startActivity(paramString.intent);
      paramString.activity.finish();
      paramString.activity.overridePendingTransition(2131034266, 2131034263);
      AppMethodBeat.o(20931);
      return;
    }
    paramString.activity.finish();
    paramString.OM(paramString.activity.getString(2131300156));
    AppMethodBeat.o(20931);
    return;
    label2394:
    if ((com.tencent.mm.plugin.freewifi.m.eq(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString)))
    {
      this.mMT.OM(paramString + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.W(this.mMT.intent), k.b.mIO, paramInt2) + ")");
      AppMethodBeat.o(20931);
      return;
    }
    if (paramInt2 == -30031)
    {
      this.mMT.OM(this.mMT.activity.getString(2131300155));
      AppMethodBeat.o(20931);
      return;
    }
    this.mMT.OM(this.mMT.activity.getString(2131300151) + "(" + String.format("%02d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.freewifi.m.W(this.mMT.intent)) }) + k.b.mIO.mJq + Math.abs(paramInt2) + ")");
    AppMethodBeat.o(20931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.b.1
 * JD-Core Version:    0.7.0.1
 */