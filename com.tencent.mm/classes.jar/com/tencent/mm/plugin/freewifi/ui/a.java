package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.d.c;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  Activity activity;
  int channel;
  String dnO;
  Intent intent;
  
  public a(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(24992);
    if (bu.isNullOrNil(paramString))
    {
      paramActivity = new IllegalArgumentException("acitvity or apKey cannot be null.");
      AppMethodBeat.o(24992);
      throw paramActivity;
    }
    this.activity = paramActivity;
    this.intent = paramActivity.getIntent();
    this.dnO = paramString;
    this.channel = paramInt;
    AppMethodBeat.o(24992);
  }
  
  final void akY(String paramString)
  {
    AppMethodBeat.i(24994);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg", paramString);
    ((Intent)localObject).setClass(this.activity, FreeWifiErrorUI.class);
    this.activity.finish();
    paramString = this.activity;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24994);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24993);
    if (bu.isNullOrNil(this.dnO))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      this.activity.finish();
    }
    this.activity.getIntent().putExtra("free_wifi_url", this.dnO);
    this.activity.getIntent().putExtra("free_wifi_ap_key", this.dnO);
    if (bu.isNullOrNil(this.dnO))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
      this.activity.finish();
      AppMethodBeat.o(24993);
      return;
    }
    ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[] { m.ap(this.intent), Integer.valueOf(m.aq(this.intent)), this.dnO, Integer.valueOf(this.channel) });
    k.a locala = k.cTw();
    locala.dnO = this.dnO;
    locala.pfT = m.ap(this.intent);
    locala.tvZ = k.b.twh.twK;
    locala.twa = k.b.twh.name;
    locala.channel = this.channel;
    locala.tvY = m.ar(this.intent);
    locala.cTy().c(this.intent, false).cTx();
    new com.tencent.mm.plugin.freewifi.d.a(this.dnO, this.channel, m.ap(this.intent)).ar(this.activity).c(new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24990);
        Object localObject1 = k.cTw();
        ((k.a)localObject1).dnO = a.this.dnO;
        ((k.a)localObject1).pfT = m.ap(a.this.intent);
        ((k.a)localObject1).tvZ = k.b.twi.twK;
        ((k.a)localObject1).twa = k.b.twi.name;
        ((k.a)localObject1).tvY = m.ar(a.this.intent);
        ((k.a)localObject1).channel = a.this.channel;
        ((k.a)localObject1).result = paramAnonymousInt2;
        ((k.a)localObject1).fMT = paramAnonymousString;
        localObject1 = ((k.a)localObject1).cTy();
        Object localObject2 = a.this.intent;
        if (paramAnonymousInt2 != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((k)localObject1).c((Intent)localObject2, bool).cTx();
          ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.ap(a.this.intent), Integer.valueOf(m.aq(a.this.intent)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label2794;
          }
          paramAnonymousString = a.this;
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.freewifi.d.a)) {
            break;
          }
          paramAnonymousString.akY(paramAnonymousString.activity.getString(2131759623));
          AppMethodBeat.o(24990);
          return;
        }
        localObject1 = (com.tencent.mm.plugin.freewifi.d.a)paramAnonymousn;
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cUo());
        Object localObject4 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cUp();
        if (localObject4 != null)
        {
          ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[] { m.ap(paramAnonymousString.intent), Integer.valueOf(m.aq(paramAnonymousString.intent)), ((aui)localObject4).FNs, ((aui)localObject4).nJO, ((aui)localObject4).nIJ, ((aui)localObject4).urn, ((aui)localObject4).GLi, ((aui)localObject4).GLj, ((aui)localObject4).FVY, ((aui)localObject4).GpF, Integer.valueOf(((aui)localObject4).FJh) });
          paramAnonymousString.intent.putExtra("free_wifi_appid", ((aui)localObject4).FNs);
          paramAnonymousString.intent.putExtra("free_wifi_head_img_url", ((aui)localObject4).urn);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_msg", ((aui)localObject4).GLi);
          paramAnonymousString.intent.putExtra("free_wifi_privacy_url", ((aui)localObject4).GLj);
          paramAnonymousString.intent.putExtra("free_wifi_app_nickname", ((aui)localObject4).nJO);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_sub_title", ((aui)localObject4).GLk);
        }
        if (paramAnonymousString.channel != 2) {
          paramAnonymousString.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
        }
        Object localObject3 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cUn();
        if (localObject3 == null)
        {
          ae.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
          paramAnonymousString.activity.finish();
          paramAnonymousn = k.cTw();
          paramAnonymousn.dnO = paramAnonymousString.dnO;
          paramAnonymousn.pfT = m.ap(paramAnonymousString.intent);
          paramAnonymousn.tvZ = k.b.twj.twK;
          paramAnonymousn.twa = k.b.twj.name;
          paramAnonymousn.tvY = m.ar(paramAnonymousString.intent);
          paramAnonymousn.channel = paramAnonymousString.channel;
          paramAnonymousn.result = -1;
          paramAnonymousn.fMT = "qstrInfo is null.";
          paramAnonymousn.cTy().c(paramAnonymousString.intent, true).cTx();
          AppMethodBeat.o(24990);
          return;
        }
        if (m.ef(((cpp)localObject3).qkD))
        {
          ae.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
          paramAnonymousString.activity.finish();
          paramAnonymousn = k.cTw();
          paramAnonymousn.dnO = paramAnonymousString.dnO;
          paramAnonymousn.pfT = m.ap(paramAnonymousString.intent);
          paramAnonymousn.tvZ = k.b.twj.twK;
          paramAnonymousn.twa = k.b.twj.name;
          paramAnonymousn.tvY = m.ar(paramAnonymousString.intent);
          paramAnonymousn.channel = paramAnonymousString.channel;
          paramAnonymousn.result = -1;
          paramAnonymousn.fMT = "qstrInfo.Ssid is empty.";
          paramAnonymousn.cTy().c(paramAnonymousString.intent, true).cTx();
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.intent.putExtra("free_wifi_ssid", ((cpp)localObject3).qkD);
        ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[] { m.ap(paramAnonymousString.intent), Integer.valueOf(m.aq(paramAnonymousString.intent)), Integer.valueOf(((cpp)localObject3).HBJ), ((cpp)localObject3).qkD, ((cpp)localObject3).Gze });
        paramAnonymousn = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).getOpenId();
        localObject1 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).Ug();
        paramAnonymousString.intent.putExtra("free_wifi_openid", paramAnonymousn);
        paramAnonymousString.intent.putExtra("free_wifi_tid", (String)localObject1);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", ((aui)localObject4).FVY);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", ((aui)localObject4).GpF);
        ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[] { m.ap(paramAnonymousString.intent), Integer.valueOf(m.aq(paramAnonymousString.intent)), paramAnonymousn, localObject1 });
        paramAnonymousString.intent.putExtra("free_wifi_protocol_type", ((cpp)localObject3).HBJ);
        if (((cpp)localObject3).HBJ == 10)
        {
          if ((bu.isNullOrNil(((cpp)localObject3).qkD)) || (bu.isNullOrNil(((cpp)localObject3).Gze)))
          {
            ae.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((cpp)localObject3).Gze);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cpp)localObject3).HBJ == 11)
        {
          if ((bu.isNullOrNil(((cpp)localObject3).qkD)) || (bu.isNullOrNil(((cpp)localObject3).Gze)))
          {
            ae.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((cpp)localObject3).Gze);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreewifiActivateWeChatNoAuthStateUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cpp)localObject3).HBJ == 12)
        {
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiActivateAuthStateUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cpp)localObject3).HBJ == 31)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
          ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[] { m.ap(paramAnonymousString.intent), Integer.valueOf(m.aq(paramAnonymousString.intent)) });
          localObject2 = paramAnonymousString.intent.getStringExtra("free_wifi_schema_ticket");
          ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[] { m.ap(paramAnonymousString.intent), Integer.valueOf(m.aq(paramAnonymousString.intent)), localObject2 });
          if (bu.isNullOrNil((String)localObject2))
          {
            paramAnonymousString.activity.finish();
            paramAnonymousn = k.cTw();
            paramAnonymousn.dnO = paramAnonymousString.dnO;
            paramAnonymousn.pfT = m.ap(paramAnonymousString.intent);
            paramAnonymousn.tvZ = k.b.twj.twK;
            paramAnonymousn.twa = k.b.twj.name;
            paramAnonymousn.channel = paramAnonymousString.channel;
            paramAnonymousn.tvY = m.ar(paramAnonymousString.intent);
            paramAnonymousn.result = -1;
            paramAnonymousn.fMT = "31 ticket is empty.";
            paramAnonymousn.cTy().c(paramAnonymousString.intent, true).cTx();
            AppMethodBeat.o(24990);
            return;
          }
          String str1 = ((cpp)localObject3).qkD;
          localObject3 = ((aui)localObject4).FVY;
          localObject4 = ((aui)localObject4).GpF;
          if (d.cTU() == null)
          {
            ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[] { m.ap(paramAnonymousString.intent), Integer.valueOf(m.aq(paramAnonymousString.intent)) });
            paramAnonymousString.akY(paramAnonymousString.activity.getString(2131759623));
            paramAnonymousn = k.cTw();
            paramAnonymousn.dnO = paramAnonymousString.dnO;
            paramAnonymousn.pfT = m.ap(paramAnonymousString.intent);
            paramAnonymousn.tvZ = k.b.twj.twK;
            paramAnonymousn.twa = k.b.twj.name;
            paramAnonymousn.channel = paramAnonymousString.channel;
            paramAnonymousn.tvY = m.ar(paramAnonymousString.intent);
            paramAnonymousn.result = -1;
            paramAnonymousn.fMT = "wifiInfo is empty.";
            paramAnonymousn.cTy().c(paramAnonymousString.intent, true).cTx();
            AppMethodBeat.o(24990);
            return;
          }
          bool = d.akO(str1);
          ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. is_current_connected_ssid_equals_target_ssid=%b", new Object[] { m.ap(paramAnonymousString.intent), Integer.valueOf(m.aq(paramAnonymousString.intent)), Boolean.valueOf(bool) });
          str1 = az.ja(ak.getContext());
          String str2 = az.jb(ak.getContext());
          String str3 = m.akK("MicroMsg.FreeWifi.FreeWifiNetCheckUI");
          ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[] { m.ap(paramAnonymousString.intent), Integer.valueOf(m.aq(paramAnonymousString.intent)), paramAnonymousString.dnO, str1, str2, str3, localObject2 });
          k.a locala = k.cTw();
          locala.dnO = paramAnonymousString.dnO;
          locala.pfT = m.ap(paramAnonymousString.intent);
          locala.tvZ = k.b.twj.twK;
          locala.twa = k.b.twj.name;
          locala.channel = paramAnonymousString.channel;
          locala.tvY = m.ar(paramAnonymousString.intent);
          locala.result = 0;
          locala.fMT = "";
          locala.cTy().c(paramAnonymousString.intent, true).cTx();
          locala = k.cTw();
          locala.ssid = paramAnonymousString.intent.getStringExtra("free_wifi_ssid");
          locala.dnO = paramAnonymousString.dnO;
          locala.tvX = paramAnonymousString.intent.getStringExtra("free_wifi_appid");
          locala.pfT = m.ap(paramAnonymousString.intent);
          locala.tvY = m.ar(paramAnonymousString.intent);
          locala.tvZ = k.b.twt.twK;
          locala.twa = k.b.twt.name;
          locala.channel = m.as(paramAnonymousString.intent);
          locala.tvY = m.ar(paramAnonymousString.intent);
          locala.cTy().c(paramAnonymousString.intent, false).cTx();
          new i(paramAnonymousString.dnO, str1, str2, str3, (String)localObject2, m.ap(paramAnonymousString.intent)).ar(paramAnonymousString.activity).c(new a.2(paramAnonymousString, paramAnonymousn, (String)localObject1, (String)localObject3, (String)localObject4));
          AppMethodBeat.o(24990);
          return;
        }
        if (((cpp)localObject3).HBJ == 32)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
          ae.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[] { m.ap(paramAnonymousString.intent), Integer.valueOf(m.aq(paramAnonymousString.intent)) });
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cpp)localObject3).HBJ == 1)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.activity.finish();
        paramAnonymousString.akY(paramAnonymousString.activity.getString(2131759628));
        AppMethodBeat.o(24990);
        return;
        label2794:
        if ((m.gd(paramAnonymousInt1, paramAnonymousInt2)) && (!m.ef(paramAnonymousString)))
        {
          a.this.akY(paramAnonymousString + "(" + m.a(m.ar(a.this.intent), k.b.twi, paramAnonymousInt2) + ")");
          AppMethodBeat.o(24990);
          return;
        }
        if (paramAnonymousInt2 == -30031)
        {
          a.this.akY(a.this.activity.getString(2131759627));
          AppMethodBeat.o(24990);
          return;
        }
        a.this.akY(a.this.activity.getString(2131759623) + "(" + String.format("%02d", new Object[] { Integer.valueOf(m.ar(a.this.intent)) }) + k.b.twi.twK + Math.abs(paramAnonymousInt2) + ")");
        AppMethodBeat.o(24990);
      }
    });
    AppMethodBeat.o(24993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.a
 * JD-Core Version:    0.7.0.1
 */