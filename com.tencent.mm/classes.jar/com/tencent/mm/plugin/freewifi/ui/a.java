package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.d.c;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  Activity activity;
  int channel;
  String dbq;
  Intent intent;
  
  public a(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(24992);
    if (bs.isNullOrNil(paramString))
    {
      paramActivity = new IllegalArgumentException("acitvity or apKey cannot be null.");
      AppMethodBeat.o(24992);
      throw paramActivity;
    }
    this.activity = paramActivity;
    this.intent = paramActivity.getIntent();
    this.dbq = paramString;
    this.channel = paramInt;
    AppMethodBeat.o(24992);
  }
  
  final void afC(String paramString)
  {
    AppMethodBeat.i(24994);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg", paramString);
    ((Intent)localObject).setClass(this.activity, FreeWifiErrorUI.class);
    this.activity.finish();
    paramString = this.activity;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24994);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24993);
    if (bs.isNullOrNil(this.dbq))
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      this.activity.finish();
    }
    this.activity.getIntent().putExtra("free_wifi_url", this.dbq);
    this.activity.getIntent().putExtra("free_wifi_ap_key", this.dbq);
    if (bs.isNullOrNil(this.dbq))
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
      this.activity.finish();
      AppMethodBeat.o(24993);
      return;
    }
    ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[] { m.aj(this.intent), Integer.valueOf(m.ak(this.intent)), this.dbq, Integer.valueOf(this.channel) });
    k.a locala = k.cIC();
    locala.dbq = this.dbq;
    locala.ovU = m.aj(this.intent);
    locala.soE = k.b.soM.spp;
    locala.soF = k.b.soM.name;
    locala.channel = this.channel;
    locala.soD = m.al(this.intent);
    locala.cIE().c(this.intent, false).cID();
    new com.tencent.mm.plugin.freewifi.d.a(this.dbq, this.channel, m.aj(this.intent)).aq(this.activity).c(new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24990);
        Object localObject1 = k.cIC();
        ((k.a)localObject1).dbq = a.this.dbq;
        ((k.a)localObject1).ovU = m.aj(a.this.intent);
        ((k.a)localObject1).soE = k.b.soN.spp;
        ((k.a)localObject1).soF = k.b.soN.name;
        ((k.a)localObject1).soD = m.al(a.this.intent);
        ((k.a)localObject1).channel = a.this.channel;
        ((k.a)localObject1).result = paramAnonymousInt2;
        ((k.a)localObject1).fsq = paramAnonymousString;
        localObject1 = ((k.a)localObject1).cIE();
        Object localObject2 = a.this.intent;
        if (paramAnonymousInt2 != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((k)localObject1).c((Intent)localObject2, bool).cID();
          ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.aj(a.this.intent), Integer.valueOf(m.ak(a.this.intent)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label2794;
          }
          paramAnonymousString = a.this;
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.freewifi.d.a)) {
            break;
          }
          paramAnonymousString.afC(paramAnonymousString.activity.getString(2131759623));
          AppMethodBeat.o(24990);
          return;
        }
        localObject1 = (com.tencent.mm.plugin.freewifi.d.a)paramAnonymousn;
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cJu());
        Object localObject4 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cJv();
        if (localObject4 != null)
        {
          ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[] { m.aj(paramAnonymousString.intent), Integer.valueOf(m.ak(paramAnonymousString.intent)), ((apy)localObject4).DPF, ((apy)localObject4).ndW, ((apy)localObject4).ncR, ((apy)localObject4).tia, ((apy)localObject4).EIT, ((apy)localObject4).EIU, ((apy)localObject4).DYh, ((apy)localObject4).EpV, Integer.valueOf(((apy)localObject4).DLE) });
          paramAnonymousString.intent.putExtra("free_wifi_appid", ((apy)localObject4).DPF);
          paramAnonymousString.intent.putExtra("free_wifi_head_img_url", ((apy)localObject4).tia);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_msg", ((apy)localObject4).EIT);
          paramAnonymousString.intent.putExtra("free_wifi_privacy_url", ((apy)localObject4).EIU);
          paramAnonymousString.intent.putExtra("free_wifi_app_nickname", ((apy)localObject4).ndW);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_sub_title", ((apy)localObject4).EIV);
        }
        if (paramAnonymousString.channel != 2) {
          paramAnonymousString.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
        }
        Object localObject3 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cJt();
        if (localObject3 == null)
        {
          ac.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
          paramAnonymousString.activity.finish();
          paramAnonymousn = k.cIC();
          paramAnonymousn.dbq = paramAnonymousString.dbq;
          paramAnonymousn.ovU = m.aj(paramAnonymousString.intent);
          paramAnonymousn.soE = k.b.soO.spp;
          paramAnonymousn.soF = k.b.soO.name;
          paramAnonymousn.soD = m.al(paramAnonymousString.intent);
          paramAnonymousn.channel = paramAnonymousString.channel;
          paramAnonymousn.result = -1;
          paramAnonymousn.fsq = "qstrInfo is null.";
          paramAnonymousn.cIE().c(paramAnonymousString.intent, true).cID();
          AppMethodBeat.o(24990);
          return;
        }
        if (m.cX(((cjv)localObject3).pAt))
        {
          ac.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
          paramAnonymousString.activity.finish();
          paramAnonymousn = k.cIC();
          paramAnonymousn.dbq = paramAnonymousString.dbq;
          paramAnonymousn.ovU = m.aj(paramAnonymousString.intent);
          paramAnonymousn.soE = k.b.soO.spp;
          paramAnonymousn.soF = k.b.soO.name;
          paramAnonymousn.soD = m.al(paramAnonymousString.intent);
          paramAnonymousn.channel = paramAnonymousString.channel;
          paramAnonymousn.result = -1;
          paramAnonymousn.fsq = "qstrInfo.Ssid is empty.";
          paramAnonymousn.cIE().c(paramAnonymousString.intent, true).cID();
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.intent.putExtra("free_wifi_ssid", ((cjv)localObject3).pAt);
        ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[] { m.aj(paramAnonymousString.intent), Integer.valueOf(m.ak(paramAnonymousString.intent)), Integer.valueOf(((cjv)localObject3).Fye), ((cjv)localObject3).pAt, ((cjv)localObject3).EyJ });
        paramAnonymousn = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).getOpenId();
        localObject1 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).RT();
        paramAnonymousString.intent.putExtra("free_wifi_openid", paramAnonymousn);
        paramAnonymousString.intent.putExtra("free_wifi_tid", (String)localObject1);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", ((apy)localObject4).DYh);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", ((apy)localObject4).EpV);
        ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[] { m.aj(paramAnonymousString.intent), Integer.valueOf(m.ak(paramAnonymousString.intent)), paramAnonymousn, localObject1 });
        paramAnonymousString.intent.putExtra("free_wifi_protocol_type", ((cjv)localObject3).Fye);
        if (((cjv)localObject3).Fye == 10)
        {
          if ((bs.isNullOrNil(((cjv)localObject3).pAt)) || (bs.isNullOrNil(((cjv)localObject3).EyJ)))
          {
            ac.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((cjv)localObject3).EyJ);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cjv)localObject3).Fye == 11)
        {
          if ((bs.isNullOrNil(((cjv)localObject3).pAt)) || (bs.isNullOrNil(((cjv)localObject3).EyJ)))
          {
            ac.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((cjv)localObject3).EyJ);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreewifiActivateWeChatNoAuthStateUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cjv)localObject3).Fye == 12)
        {
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiActivateAuthStateUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cjv)localObject3).Fye == 31)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
          ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[] { m.aj(paramAnonymousString.intent), Integer.valueOf(m.ak(paramAnonymousString.intent)) });
          localObject2 = paramAnonymousString.intent.getStringExtra("free_wifi_schema_ticket");
          ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[] { m.aj(paramAnonymousString.intent), Integer.valueOf(m.ak(paramAnonymousString.intent)), localObject2 });
          if (bs.isNullOrNil((String)localObject2))
          {
            paramAnonymousString.activity.finish();
            paramAnonymousn = k.cIC();
            paramAnonymousn.dbq = paramAnonymousString.dbq;
            paramAnonymousn.ovU = m.aj(paramAnonymousString.intent);
            paramAnonymousn.soE = k.b.soO.spp;
            paramAnonymousn.soF = k.b.soO.name;
            paramAnonymousn.channel = paramAnonymousString.channel;
            paramAnonymousn.soD = m.al(paramAnonymousString.intent);
            paramAnonymousn.result = -1;
            paramAnonymousn.fsq = "31 ticket is empty.";
            paramAnonymousn.cIE().c(paramAnonymousString.intent, true).cID();
            AppMethodBeat.o(24990);
            return;
          }
          String str1 = ((cjv)localObject3).pAt;
          localObject3 = ((apy)localObject4).DYh;
          localObject4 = ((apy)localObject4).EpV;
          if (d.cJa() == null)
          {
            ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[] { m.aj(paramAnonymousString.intent), Integer.valueOf(m.ak(paramAnonymousString.intent)) });
            paramAnonymousString.afC(paramAnonymousString.activity.getString(2131759623));
            paramAnonymousn = k.cIC();
            paramAnonymousn.dbq = paramAnonymousString.dbq;
            paramAnonymousn.ovU = m.aj(paramAnonymousString.intent);
            paramAnonymousn.soE = k.b.soO.spp;
            paramAnonymousn.soF = k.b.soO.name;
            paramAnonymousn.channel = paramAnonymousString.channel;
            paramAnonymousn.soD = m.al(paramAnonymousString.intent);
            paramAnonymousn.result = -1;
            paramAnonymousn.fsq = "wifiInfo is empty.";
            paramAnonymousn.cIE().c(paramAnonymousString.intent, true).cID();
            AppMethodBeat.o(24990);
            return;
          }
          bool = d.afs(str1);
          ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. is_current_connected_ssid_equals_target_ssid=%b", new Object[] { m.aj(paramAnonymousString.intent), Integer.valueOf(m.ak(paramAnonymousString.intent)), Boolean.valueOf(bool) });
          str1 = ax.iL(ai.getContext());
          String str2 = ax.iM(ai.getContext());
          String str3 = m.afo("MicroMsg.FreeWifi.FreeWifiNetCheckUI");
          ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[] { m.aj(paramAnonymousString.intent), Integer.valueOf(m.ak(paramAnonymousString.intent)), paramAnonymousString.dbq, str1, str2, str3, localObject2 });
          k.a locala = k.cIC();
          locala.dbq = paramAnonymousString.dbq;
          locala.ovU = m.aj(paramAnonymousString.intent);
          locala.soE = k.b.soO.spp;
          locala.soF = k.b.soO.name;
          locala.channel = paramAnonymousString.channel;
          locala.soD = m.al(paramAnonymousString.intent);
          locala.result = 0;
          locala.fsq = "";
          locala.cIE().c(paramAnonymousString.intent, true).cID();
          locala = k.cIC();
          locala.ssid = paramAnonymousString.intent.getStringExtra("free_wifi_ssid");
          locala.dbq = paramAnonymousString.dbq;
          locala.soC = paramAnonymousString.intent.getStringExtra("free_wifi_appid");
          locala.ovU = m.aj(paramAnonymousString.intent);
          locala.soD = m.al(paramAnonymousString.intent);
          locala.soE = k.b.soY.spp;
          locala.soF = k.b.soY.name;
          locala.channel = m.am(paramAnonymousString.intent);
          locala.soD = m.al(paramAnonymousString.intent);
          locala.cIE().c(paramAnonymousString.intent, false).cID();
          new i(paramAnonymousString.dbq, str1, str2, str3, (String)localObject2, m.aj(paramAnonymousString.intent)).aq(paramAnonymousString.activity).c(new a.2(paramAnonymousString, paramAnonymousn, (String)localObject1, (String)localObject3, (String)localObject4));
          AppMethodBeat.o(24990);
          return;
        }
        if (((cjv)localObject3).Fye == 32)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
          ac.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[] { m.aj(paramAnonymousString.intent), Integer.valueOf(m.ak(paramAnonymousString.intent)) });
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cjv)localObject3).Fye == 1)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.activity.finish();
        paramAnonymousString.afC(paramAnonymousString.activity.getString(2131759628));
        AppMethodBeat.o(24990);
        return;
        label2794:
        if ((m.fN(paramAnonymousInt1, paramAnonymousInt2)) && (!m.cX(paramAnonymousString)))
        {
          a.this.afC(paramAnonymousString + "(" + m.a(m.al(a.this.intent), k.b.soN, paramAnonymousInt2) + ")");
          AppMethodBeat.o(24990);
          return;
        }
        if (paramAnonymousInt2 == -30031)
        {
          a.this.afC(a.this.activity.getString(2131759627));
          AppMethodBeat.o(24990);
          return;
        }
        a.this.afC(a.this.activity.getString(2131759623) + "(" + String.format("%02d", new Object[] { Integer.valueOf(m.al(a.this.intent)) }) + k.b.soN.spp + Math.abs(paramAnonymousInt2) + ")");
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