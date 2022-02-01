package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.freewifi.d.c;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  Activity activity;
  int channel;
  String ddU;
  Intent intent;
  
  public a(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(24992);
    if (bt.isNullOrNil(paramString))
    {
      paramActivity = new IllegalArgumentException("acitvity or apKey cannot be null.");
      AppMethodBeat.o(24992);
      throw paramActivity;
    }
    this.activity = paramActivity;
    this.intent = paramActivity.getIntent();
    this.ddU = paramString;
    this.channel = paramInt;
    AppMethodBeat.o(24992);
  }
  
  final void aaK(String paramString)
  {
    AppMethodBeat.i(24994);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg", paramString);
    ((Intent)localObject).setClass(this.activity, FreeWifiErrorUI.class);
    this.activity.finish();
    paramString = this.activity;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24994);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24993);
    if (bt.isNullOrNil(this.ddU))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      this.activity.finish();
    }
    this.activity.getIntent().putExtra("free_wifi_url", this.ddU);
    this.activity.getIntent().putExtra("free_wifi_ap_key", this.ddU);
    if (bt.isNullOrNil(this.ddU))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
      this.activity.finish();
      AppMethodBeat.o(24993);
      return;
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[] { m.ai(this.intent), Integer.valueOf(m.aj(this.intent)), this.ddU, Integer.valueOf(this.channel) });
    k.a locala = k.cvq();
    locala.ddU = this.ddU;
    locala.nSA = m.ai(this.intent);
    locala.rfM = k.b.rfU.rgx;
    locala.rfN = k.b.rfU.name;
    locala.channel = this.channel;
    locala.rfL = m.ak(this.intent);
    locala.cvs().c(this.intent, false).cvr();
    new com.tencent.mm.plugin.freewifi.d.a(this.ddU, this.channel, m.ai(this.intent)).am(this.activity).c(new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24990);
        Object localObject1 = k.cvq();
        ((k.a)localObject1).ddU = a.this.ddU;
        ((k.a)localObject1).nSA = m.ai(a.this.intent);
        ((k.a)localObject1).rfM = k.b.rfV.rgx;
        ((k.a)localObject1).rfN = k.b.rfV.name;
        ((k.a)localObject1).rfL = m.ak(a.this.intent);
        ((k.a)localObject1).channel = a.this.channel;
        ((k.a)localObject1).result = paramAnonymousInt2;
        ((k.a)localObject1).foR = paramAnonymousString;
        localObject1 = ((k.a)localObject1).cvs();
        Object localObject2 = a.this.intent;
        if (paramAnonymousInt2 != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((k)localObject1).c((Intent)localObject2, bool).cvr();
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.ai(a.this.intent), Integer.valueOf(m.aj(a.this.intent)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label2794;
          }
          paramAnonymousString = a.this;
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.freewifi.d.a)) {
            break;
          }
          paramAnonymousString.aaK(paramAnonymousString.activity.getString(2131759623));
          AppMethodBeat.o(24990);
          return;
        }
        localObject1 = (com.tencent.mm.plugin.freewifi.d.a)paramAnonymousn;
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cwi());
        Object localObject4 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cwj();
        if (localObject4 != null)
        {
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[] { m.ai(paramAnonymousString.intent), Integer.valueOf(m.aj(paramAnonymousString.intent)), ((amu)localObject4).Cxj, ((amu)localObject4).mBV, ((amu)localObject4).mAQ, ((amu)localObject4).sah, ((amu)localObject4).DnT, ((amu)localObject4).DnU, ((amu)localObject4).CFH, ((amu)localObject4).CXm, Integer.valueOf(((amu)localObject4).Ctn) });
          paramAnonymousString.intent.putExtra("free_wifi_appid", ((amu)localObject4).Cxj);
          paramAnonymousString.intent.putExtra("free_wifi_head_img_url", ((amu)localObject4).sah);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_msg", ((amu)localObject4).DnT);
          paramAnonymousString.intent.putExtra("free_wifi_privacy_url", ((amu)localObject4).DnU);
          paramAnonymousString.intent.putExtra("free_wifi_app_nickname", ((amu)localObject4).mBV);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_sub_title", ((amu)localObject4).DnV);
        }
        if (paramAnonymousString.channel != 2) {
          paramAnonymousString.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
        }
        Object localObject3 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cwh();
        if (localObject3 == null)
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
          paramAnonymousString.activity.finish();
          paramAnonymousn = k.cvq();
          paramAnonymousn.ddU = paramAnonymousString.ddU;
          paramAnonymousn.nSA = m.ai(paramAnonymousString.intent);
          paramAnonymousn.rfM = k.b.rfW.rgx;
          paramAnonymousn.rfN = k.b.rfW.name;
          paramAnonymousn.rfL = m.ak(paramAnonymousString.intent);
          paramAnonymousn.channel = paramAnonymousString.channel;
          paramAnonymousn.result = -1;
          paramAnonymousn.foR = "qstrInfo is null.";
          paramAnonymousn.cvs().c(paramAnonymousString.intent, true).cvr();
          AppMethodBeat.o(24990);
          return;
        }
        if (m.dq(((ces)localObject3).oXi))
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
          paramAnonymousString.activity.finish();
          paramAnonymousn = k.cvq();
          paramAnonymousn.ddU = paramAnonymousString.ddU;
          paramAnonymousn.nSA = m.ai(paramAnonymousString.intent);
          paramAnonymousn.rfM = k.b.rfW.rgx;
          paramAnonymousn.rfN = k.b.rfW.name;
          paramAnonymousn.rfL = m.ak(paramAnonymousString.intent);
          paramAnonymousn.channel = paramAnonymousString.channel;
          paramAnonymousn.result = -1;
          paramAnonymousn.foR = "qstrInfo.Ssid is empty.";
          paramAnonymousn.cvs().c(paramAnonymousString.intent, true).cvr();
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.intent.putExtra("free_wifi_ssid", ((ces)localObject3).oXi);
        ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[] { m.ai(paramAnonymousString.intent), Integer.valueOf(m.aj(paramAnonymousString.intent)), Integer.valueOf(((ces)localObject3).Ebj), ((ces)localObject3).oXi, ((ces)localObject3).DfD });
        paramAnonymousn = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).getOpenId();
        localObject1 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).Rr();
        paramAnonymousString.intent.putExtra("free_wifi_openid", paramAnonymousn);
        paramAnonymousString.intent.putExtra("free_wifi_tid", (String)localObject1);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", ((amu)localObject4).CFH);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", ((amu)localObject4).CXm);
        ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[] { m.ai(paramAnonymousString.intent), Integer.valueOf(m.aj(paramAnonymousString.intent)), paramAnonymousn, localObject1 });
        paramAnonymousString.intent.putExtra("free_wifi_protocol_type", ((ces)localObject3).Ebj);
        if (((ces)localObject3).Ebj == 10)
        {
          if ((bt.isNullOrNil(((ces)localObject3).oXi)) || (bt.isNullOrNil(((ces)localObject3).DfD)))
          {
            ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((ces)localObject3).DfD);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((ces)localObject3).Ebj == 11)
        {
          if ((bt.isNullOrNil(((ces)localObject3).oXi)) || (bt.isNullOrNil(((ces)localObject3).DfD)))
          {
            ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((ces)localObject3).DfD);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreewifiActivateWeChatNoAuthStateUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((ces)localObject3).Ebj == 12)
        {
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiActivateAuthStateUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((ces)localObject3).Ebj == 31)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[] { m.ai(paramAnonymousString.intent), Integer.valueOf(m.aj(paramAnonymousString.intent)) });
          localObject2 = paramAnonymousString.intent.getStringExtra("free_wifi_schema_ticket");
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[] { m.ai(paramAnonymousString.intent), Integer.valueOf(m.aj(paramAnonymousString.intent)), localObject2 });
          if (bt.isNullOrNil((String)localObject2))
          {
            paramAnonymousString.activity.finish();
            paramAnonymousn = k.cvq();
            paramAnonymousn.ddU = paramAnonymousString.ddU;
            paramAnonymousn.nSA = m.ai(paramAnonymousString.intent);
            paramAnonymousn.rfM = k.b.rfW.rgx;
            paramAnonymousn.rfN = k.b.rfW.name;
            paramAnonymousn.channel = paramAnonymousString.channel;
            paramAnonymousn.rfL = m.ak(paramAnonymousString.intent);
            paramAnonymousn.result = -1;
            paramAnonymousn.foR = "31 ticket is empty.";
            paramAnonymousn.cvs().c(paramAnonymousString.intent, true).cvr();
            AppMethodBeat.o(24990);
            return;
          }
          String str1 = ((ces)localObject3).oXi;
          localObject3 = ((amu)localObject4).CFH;
          localObject4 = ((amu)localObject4).CXm;
          if (d.cvO() == null)
          {
            ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[] { m.ai(paramAnonymousString.intent), Integer.valueOf(m.aj(paramAnonymousString.intent)) });
            paramAnonymousString.aaK(paramAnonymousString.activity.getString(2131759623));
            paramAnonymousn = k.cvq();
            paramAnonymousn.ddU = paramAnonymousString.ddU;
            paramAnonymousn.nSA = m.ai(paramAnonymousString.intent);
            paramAnonymousn.rfM = k.b.rfW.rgx;
            paramAnonymousn.rfN = k.b.rfW.name;
            paramAnonymousn.channel = paramAnonymousString.channel;
            paramAnonymousn.rfL = m.ak(paramAnonymousString.intent);
            paramAnonymousn.result = -1;
            paramAnonymousn.foR = "wifiInfo is empty.";
            paramAnonymousn.cvs().c(paramAnonymousString.intent, true).cvr();
            AppMethodBeat.o(24990);
            return;
          }
          bool = d.aaA(str1);
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. is_current_connected_ssid_equals_target_ssid=%b", new Object[] { m.ai(paramAnonymousString.intent), Integer.valueOf(m.aj(paramAnonymousString.intent)), Boolean.valueOf(bool) });
          str1 = ay.iA(aj.getContext());
          String str2 = ay.iB(aj.getContext());
          String str3 = m.aaw("MicroMsg.FreeWifi.FreeWifiNetCheckUI");
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[] { m.ai(paramAnonymousString.intent), Integer.valueOf(m.aj(paramAnonymousString.intent)), paramAnonymousString.ddU, str1, str2, str3, localObject2 });
          k.a locala = k.cvq();
          locala.ddU = paramAnonymousString.ddU;
          locala.nSA = m.ai(paramAnonymousString.intent);
          locala.rfM = k.b.rfW.rgx;
          locala.rfN = k.b.rfW.name;
          locala.channel = paramAnonymousString.channel;
          locala.rfL = m.ak(paramAnonymousString.intent);
          locala.result = 0;
          locala.foR = "";
          locala.cvs().c(paramAnonymousString.intent, true).cvr();
          locala = k.cvq();
          locala.ssid = paramAnonymousString.intent.getStringExtra("free_wifi_ssid");
          locala.ddU = paramAnonymousString.ddU;
          locala.rfK = paramAnonymousString.intent.getStringExtra("free_wifi_appid");
          locala.nSA = m.ai(paramAnonymousString.intent);
          locala.rfL = m.ak(paramAnonymousString.intent);
          locala.rfM = k.b.rgg.rgx;
          locala.rfN = k.b.rgg.name;
          locala.channel = m.al(paramAnonymousString.intent);
          locala.rfL = m.ak(paramAnonymousString.intent);
          locala.cvs().c(paramAnonymousString.intent, false).cvr();
          new i(paramAnonymousString.ddU, str1, str2, str3, (String)localObject2, m.ai(paramAnonymousString.intent)).am(paramAnonymousString.activity).c(new a.2(paramAnonymousString, paramAnonymousn, (String)localObject1, (String)localObject3, (String)localObject4));
          AppMethodBeat.o(24990);
          return;
        }
        if (((ces)localObject3).Ebj == 32)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[] { m.ai(paramAnonymousString.intent), Integer.valueOf(m.aj(paramAnonymousString.intent)) });
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((ces)localObject3).Ebj == 1)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.activity.finish();
        paramAnonymousString.aaK(paramAnonymousString.activity.getString(2131759628));
        AppMethodBeat.o(24990);
        return;
        label2794:
        if ((m.fG(paramAnonymousInt1, paramAnonymousInt2)) && (!m.dq(paramAnonymousString)))
        {
          a.this.aaK(paramAnonymousString + "(" + m.a(m.ak(a.this.intent), k.b.rfV, paramAnonymousInt2) + ")");
          AppMethodBeat.o(24990);
          return;
        }
        if (paramAnonymousInt2 == -30031)
        {
          a.this.aaK(a.this.activity.getString(2131759627));
          AppMethodBeat.o(24990);
          return;
        }
        a.this.aaK(a.this.activity.getString(2131759623) + "(" + String.format("%02d", new Object[] { Integer.valueOf(m.ak(a.this.intent)) }) + k.b.rfV.rgx + Math.abs(paramAnonymousInt2) + ")");
        AppMethodBeat.o(24990);
      }
    });
    AppMethodBeat.o(24993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.a
 * JD-Core Version:    0.7.0.1
 */