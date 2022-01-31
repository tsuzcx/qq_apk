package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import com.tencent.mm.R.a;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.d.c;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.bhn;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements f
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    Object localObject1 = k.aTx();
    ((k.a)localObject1).bHI = this.krg.bHI;
    ((k.a)localObject1).iGw = com.tencent.mm.plugin.freewifi.m.B(this.krg.intent);
    ((k.a)localObject1).kmS = k.b.knb.knD;
    ((k.a)localObject1).kmT = k.b.knb.name;
    ((k.a)localObject1).kmR = com.tencent.mm.plugin.freewifi.m.D(this.krg.intent);
    ((k.a)localObject1).bUR = this.krg.bUR;
    ((k.a)localObject1).result = paramInt2;
    ((k.a)localObject1).dmU = paramString;
    localObject1 = ((k.a)localObject1).aTz();
    Object localObject2 = this.krg.intent;
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((k)localObject1).b((Intent)localObject2, bool).aTy();
      y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(this.krg.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(this.krg.intent)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label2434;
      }
      localObject1 = this.krg;
      if ((paramm instanceof a)) {
        break;
      }
      ((b)localObject1).DE(((b)localObject1).activity.getString(R.l.free_wifi_errmsg_retry));
      return;
    }
    Object localObject3 = (a)paramm;
    ((b)localObject1).intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", ((a)localObject3).aUs());
    paramString = ((a)localObject3).aUt();
    if (paramString != null)
    {
      y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[] { com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(((b)localObject1).intent)), paramString.svu, paramString.hRf, paramString.hPY, paramString.kSF, paramString.sYN, paramString.sYO, paramString.sBi, paramString.sNh, Integer.valueOf(paramString.ssu) });
      ((b)localObject1).intent.putExtra("free_wifi_appid", paramString.svu);
      ((b)localObject1).intent.putExtra("free_wifi_head_img_url", paramString.kSF);
      ((b)localObject1).intent.putExtra("free_wifi_welcome_msg", paramString.sYN);
      ((b)localObject1).intent.putExtra("free_wifi_privacy_url", paramString.sYO);
      ((b)localObject1).intent.putExtra("free_wifi_app_nickname", paramString.hRf);
      ((b)localObject1).intent.putExtra("free_wifi_welcome_sub_title", paramString.sYP);
    }
    if (((b)localObject1).bUR != 2) {
      ((b)localObject1).activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
    }
    paramm = ((a)localObject3).aUr();
    if (paramm == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
      ((b)localObject1).activity.finish();
      paramString = k.aTx();
      paramString.bHI = ((b)localObject1).bHI;
      paramString.iGw = com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent);
      paramString.kmS = k.b.knc.knD;
      paramString.kmT = k.b.knc.name;
      paramString.kmR = com.tencent.mm.plugin.freewifi.m.D(((b)localObject1).intent);
      paramString.bUR = ((b)localObject1).bUR;
      paramString.result = -1;
      paramString.dmU = "qstrInfo is null.";
      paramString.aTz().b(((b)localObject1).intent, true).aTy();
      return;
    }
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(paramm.jwY))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
      ((b)localObject1).activity.finish();
      paramString = k.aTx();
      paramString.bHI = ((b)localObject1).bHI;
      paramString.iGw = com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent);
      paramString.kmS = k.b.knc.knD;
      paramString.kmT = k.b.knc.name;
      paramString.kmR = com.tencent.mm.plugin.freewifi.m.D(((b)localObject1).intent);
      paramString.bUR = ((b)localObject1).bUR;
      paramString.result = -1;
      paramString.dmU = "qstrInfo.Ssid is empty.";
      paramString.aTz().b(((b)localObject1).intent, true).aTy();
      return;
    }
    ((b)localObject1).intent.putExtra("free_wifi_ssid", paramm.jwY);
    y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(((b)localObject1).intent)), Integer.valueOf(paramm.tCm), paramm.jwY, paramm.sUm });
    localObject2 = ((a)localObject3).aUu();
    localObject3 = ((a)localObject3).aUv();
    ((b)localObject1).intent.putExtra("free_wifi_openid", (String)localObject2);
    ((b)localObject1).intent.putExtra("free_wifi_tid", (String)localObject3);
    ((b)localObject1).intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", paramString.sBi);
    ((b)localObject1).intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", paramString.sNh);
    y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(((b)localObject1).intent)), localObject2, localObject3 });
    ((b)localObject1).intent.putExtra("free_wifi_protocol_type", paramm.tCm);
    if (paramm.tCm == 10)
    {
      if ((bk.bl(paramm.jwY)) || (bk.bl(paramm.sUm)))
      {
        y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
        ((b)localObject1).activity.finish();
        return;
      }
      ((b)localObject1).intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
      ((b)localObject1).intent.putExtra("free_wifi_auth_type", 2);
      ((b)localObject1).intent.putExtra("free_wifi_passowrd", paramm.sUm);
      ((b)localObject1).intent.setClass(((b)localObject1).activity, FreeWifiFrontPageUI.class);
      ((b)localObject1).activity.startActivity(((b)localObject1).intent);
      ((b)localObject1).activity.finish();
      ((b)localObject1).activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      return;
    }
    if (paramm.tCm == 11)
    {
      if ((bk.bl(paramm.jwY)) || (bk.bl(paramm.sUm)))
      {
        y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
        ((b)localObject1).activity.finish();
        return;
      }
      ((b)localObject1).intent.putExtra("free_wifi_auth_type", 2);
      ((b)localObject1).intent.putExtra("free_wifi_passowrd", paramm.sUm);
      ((b)localObject1).intent.setClass(((b)localObject1).activity, FreewifiActivateWeChatNoAuthStateUI.class);
      ((b)localObject1).activity.startActivity(((b)localObject1).intent);
      ((b)localObject1).activity.finish();
      ((b)localObject1).activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      return;
    }
    if (paramm.tCm == 12)
    {
      ((b)localObject1).intent.putExtra("free_wifi_auth_type", 1);
      ((b)localObject1).intent.setClass(((b)localObject1).activity, FreeWifiActivateAuthStateUI.class);
      ((b)localObject1).activity.startActivity(((b)localObject1).intent);
      ((b)localObject1).activity.finish();
      ((b)localObject1).activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      return;
    }
    if (paramm.tCm == 31)
    {
      ((b)localObject1).intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
      y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(((b)localObject1).intent)) });
      String str1 = ((b)localObject1).intent.getStringExtra("free_wifi_schema_ticket");
      y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(((b)localObject1).intent)), str1 });
      if (bk.bl(str1))
      {
        ((b)localObject1).activity.finish();
        paramString = k.aTx();
        paramString.bHI = ((b)localObject1).bHI;
        paramString.iGw = com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent);
        paramString.kmS = k.b.knc.knD;
        paramString.kmT = k.b.knc.name;
        paramString.bUR = ((b)localObject1).bUR;
        paramString.kmR = com.tencent.mm.plugin.freewifi.m.D(((b)localObject1).intent);
        paramString.result = -1;
        paramString.dmU = "31 ticket is empty.";
        paramString.aTz().b(((b)localObject1).intent, true).aTy();
        return;
      }
      String str4 = paramm.jwY;
      String str2 = paramString.sBi;
      String str3 = paramString.sNh;
      paramm = d.aTY();
      if (paramm == null)
      {
        y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[] { com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(((b)localObject1).intent)) });
        ((b)localObject1).DE(((b)localObject1).activity.getString(R.l.free_wifi_errmsg_retry));
        paramString = k.aTx();
        paramString.bHI = ((b)localObject1).bHI;
        paramString.iGw = com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent);
        paramString.kmS = k.b.knc.knD;
        paramString.kmT = k.b.knc.name;
        paramString.bUR = ((b)localObject1).bUR;
        paramString.kmR = com.tencent.mm.plugin.freewifi.m.D(((b)localObject1).intent);
        paramString.result = -1;
        paramString.dmU = "wifiInfo is empty.";
        paramString.aTz().b(((b)localObject1).intent, true).aTy();
        return;
      }
      bool = d.Du(str4);
      str4 = com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent);
      paramInt1 = com.tencent.mm.plugin.freewifi.m.C(((b)localObject1).intent);
      if (paramm == null) {}
      for (paramString = "null";; paramString = paramm.toString())
      {
        y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. wifiInfo=%s, is_current_connected_ssid_equals_target_ssid=%b", new Object[] { str4, Integer.valueOf(paramInt1), paramString, Boolean.valueOf(bool) });
        str4 = com.tencent.mm.plugin.freewifi.m.Dm(paramm.getSSID());
        String str5 = paramm.getBSSID();
        paramm = paramm.getMacAddress();
        paramString = paramm;
        if (Build.VERSION.SDK_INT > 22) {
          if (paramm != null)
          {
            paramString = paramm;
            if (!paramm.equals("02:00:00:00:00:00")) {}
          }
          else
          {
            paramString = com.tencent.mm.plugin.freewifi.m.aTC();
          }
        }
        y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[] { com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(((b)localObject1).intent)), ((b)localObject1).bHI, str4, str5, paramString, str1 });
        paramm = k.aTx();
        paramm.bHI = ((b)localObject1).bHI;
        paramm.iGw = com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent);
        paramm.kmS = k.b.knc.knD;
        paramm.kmT = k.b.knc.name;
        paramm.bUR = ((b)localObject1).bUR;
        paramm.kmR = com.tencent.mm.plugin.freewifi.m.D(((b)localObject1).intent);
        paramm.result = 0;
        paramm.dmU = "";
        paramm.aTz().b(((b)localObject1).intent, true).aTy();
        paramm = k.aTx();
        paramm.ssid = ((b)localObject1).intent.getStringExtra("free_wifi_ssid");
        paramm.bHI = ((b)localObject1).bHI;
        paramm.kmQ = ((b)localObject1).intent.getStringExtra("free_wifi_appid");
        paramm.iGw = com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent);
        paramm.kmR = com.tencent.mm.plugin.freewifi.m.D(((b)localObject1).intent);
        paramm.kmS = k.b.knm.knD;
        paramm.kmT = k.b.knm.name;
        paramm.bUR = com.tencent.mm.plugin.freewifi.m.E(((b)localObject1).intent);
        paramm.kmR = com.tencent.mm.plugin.freewifi.m.D(((b)localObject1).intent);
        paramm.aTz().b(((b)localObject1).intent, false).aTy();
        new i(((b)localObject1).bHI, str4, str5, paramString, str1, com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent)).A(((b)localObject1).activity).b(new b.2((b)localObject1, (String)localObject2, (String)localObject3, str2, str3));
        return;
      }
    }
    if (paramm.tCm == 32)
    {
      ((b)localObject1).intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
      y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[] { com.tencent.mm.plugin.freewifi.m.B(((b)localObject1).intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.C(((b)localObject1).intent)) });
      ((b)localObject1).intent.setClass(((b)localObject1).activity, FreeWifiFrontPageUI.class);
      ((b)localObject1).activity.startActivity(((b)localObject1).intent);
      ((b)localObject1).activity.finish();
      ((b)localObject1).activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      return;
    }
    if (paramm.tCm == 1)
    {
      ((b)localObject1).intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
      ((b)localObject1).intent.putExtra("free_wifi_auth_type", 1);
      ((b)localObject1).intent.setClass(((b)localObject1).activity, FreeWifiFrontPageUI.class);
      ((b)localObject1).activity.startActivity(((b)localObject1).intent);
      ((b)localObject1).activity.finish();
      ((b)localObject1).activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      return;
    }
    ((b)localObject1).activity.finish();
    ((b)localObject1).DE(((b)localObject1).activity.getString(R.l.free_wifi_errmsg_update_client));
    return;
    label2434:
    if ((com.tencent.mm.plugin.freewifi.m.cS(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString)))
    {
      this.krg.DE(paramString + "(" + com.tencent.mm.plugin.freewifi.m.a(com.tencent.mm.plugin.freewifi.m.D(this.krg.intent), k.b.knb, paramInt2) + ")");
      return;
    }
    if (paramInt2 == -30031)
    {
      this.krg.DE(this.krg.activity.getString(R.l.free_wifi_errmsg_ssid_not_match_3));
      return;
    }
    this.krg.DE(this.krg.activity.getString(R.l.free_wifi_errmsg_retry) + "(" + String.format("%02d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.freewifi.m.D(this.krg.intent)) }) + k.b.knb.knD + Math.abs(paramInt2) + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.b.1
 * JD-Core Version:    0.7.0.1
 */