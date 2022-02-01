package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.freewifi.d.c;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  Activity activity;
  int channel;
  String dmM;
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
    this.dmM = paramString;
    this.channel = paramInt;
    AppMethodBeat.o(24992);
  }
  
  final void aka(String paramString)
  {
    AppMethodBeat.i(24994);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg", paramString);
    ((Intent)localObject).setClass(this.activity, FreeWifiErrorUI.class);
    this.activity.finish();
    paramString = this.activity;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24994);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24993);
    if (bt.isNullOrNil(this.dmM))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      this.activity.finish();
    }
    this.activity.getIntent().putExtra("free_wifi_url", this.dmM);
    this.activity.getIntent().putExtra("free_wifi_ap_key", this.dmM);
    if (bt.isNullOrNil(this.dmM))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
      this.activity.finish();
      AppMethodBeat.o(24993);
      return;
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[] { m.ao(this.intent), Integer.valueOf(m.ap(this.intent)), this.dmM, Integer.valueOf(this.channel) });
    k.a locala = k.cQR();
    locala.dmM = this.dmM;
    locala.oZp = m.ao(this.intent);
    locala.tlh = k.b.tlp.tlS;
    locala.tli = k.b.tlp.name;
    locala.channel = this.channel;
    locala.tlg = m.aq(this.intent);
    locala.cQT().c(this.intent, false).cQS();
    new com.tencent.mm.plugin.freewifi.d.a(this.dmM, this.channel, m.ao(this.intent)).aq(this.activity).c(new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(24990);
        Object localObject1 = k.cQR();
        ((k.a)localObject1).dmM = a.this.dmM;
        ((k.a)localObject1).oZp = m.ao(a.this.intent);
        ((k.a)localObject1).tlh = k.b.tlq.tlS;
        ((k.a)localObject1).tli = k.b.tlq.name;
        ((k.a)localObject1).tlg = m.aq(a.this.intent);
        ((k.a)localObject1).channel = a.this.channel;
        ((k.a)localObject1).result = paramAnonymousInt2;
        ((k.a)localObject1).fKQ = paramAnonymousString;
        localObject1 = ((k.a)localObject1).cQT();
        Object localObject2 = a.this.intent;
        if (paramAnonymousInt2 != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((k)localObject1).c((Intent)localObject2, bool).cQS();
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.ao(a.this.intent), Integer.valueOf(m.ap(a.this.intent)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label2794;
          }
          paramAnonymousString = a.this;
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.freewifi.d.a)) {
            break;
          }
          paramAnonymousString.aka(paramAnonymousString.activity.getString(2131759623));
          AppMethodBeat.o(24990);
          return;
        }
        localObject1 = (com.tencent.mm.plugin.freewifi.d.a)paramAnonymousn;
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cRJ());
        Object localObject4 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cRK();
        if (localObject4 != null)
        {
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[] { m.ao(paramAnonymousString.intent), Integer.valueOf(m.ap(paramAnonymousString.intent)), ((ats)localObject4).FuU, ((ats)localObject4).nEt, ((ats)localObject4).nDo, ((ats)localObject4).ufR, ((ats)localObject4).GrK, ((ats)localObject4).GrL, ((ats)localObject4).FDD, ((ats)localObject4).FXg, Integer.valueOf(((ats)localObject4).FqJ) });
          paramAnonymousString.intent.putExtra("free_wifi_appid", ((ats)localObject4).FuU);
          paramAnonymousString.intent.putExtra("free_wifi_head_img_url", ((ats)localObject4).ufR);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_msg", ((ats)localObject4).GrK);
          paramAnonymousString.intent.putExtra("free_wifi_privacy_url", ((ats)localObject4).GrL);
          paramAnonymousString.intent.putExtra("free_wifi_app_nickname", ((ats)localObject4).nEt);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_sub_title", ((ats)localObject4).GrM);
        }
        if (paramAnonymousString.channel != 2) {
          paramAnonymousString.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
        }
        Object localObject3 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).cRI();
        if (localObject3 == null)
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
          paramAnonymousString.activity.finish();
          paramAnonymousn = k.cQR();
          paramAnonymousn.dmM = paramAnonymousString.dmM;
          paramAnonymousn.oZp = m.ao(paramAnonymousString.intent);
          paramAnonymousn.tlh = k.b.tlr.tlS;
          paramAnonymousn.tli = k.b.tlr.name;
          paramAnonymousn.tlg = m.aq(paramAnonymousString.intent);
          paramAnonymousn.channel = paramAnonymousString.channel;
          paramAnonymousn.result = -1;
          paramAnonymousn.fKQ = "qstrInfo is null.";
          paramAnonymousn.cQT().c(paramAnonymousString.intent, true).cQS();
          AppMethodBeat.o(24990);
          return;
        }
        if (m.ea(((cov)localObject3).qdY))
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
          paramAnonymousString.activity.finish();
          paramAnonymousn = k.cQR();
          paramAnonymousn.dmM = paramAnonymousString.dmM;
          paramAnonymousn.oZp = m.ao(paramAnonymousString.intent);
          paramAnonymousn.tlh = k.b.tlr.tlS;
          paramAnonymousn.tli = k.b.tlr.name;
          paramAnonymousn.tlg = m.aq(paramAnonymousString.intent);
          paramAnonymousn.channel = paramAnonymousString.channel;
          paramAnonymousn.result = -1;
          paramAnonymousn.fKQ = "qstrInfo.Ssid is empty.";
          paramAnonymousn.cQT().c(paramAnonymousString.intent, true).cQS();
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.intent.putExtra("free_wifi_ssid", ((cov)localObject3).qdY);
        ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[] { m.ao(paramAnonymousString.intent), Integer.valueOf(m.ap(paramAnonymousString.intent)), Integer.valueOf(((cov)localObject3).Hij), ((cov)localObject3).qdY, ((cov)localObject3).Ggv });
        paramAnonymousn = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).getOpenId();
        localObject1 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).Ua();
        paramAnonymousString.intent.putExtra("free_wifi_openid", paramAnonymousn);
        paramAnonymousString.intent.putExtra("free_wifi_tid", (String)localObject1);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", ((ats)localObject4).FDD);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", ((ats)localObject4).FXg);
        ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[] { m.ao(paramAnonymousString.intent), Integer.valueOf(m.ap(paramAnonymousString.intent)), paramAnonymousn, localObject1 });
        paramAnonymousString.intent.putExtra("free_wifi_protocol_type", ((cov)localObject3).Hij);
        if (((cov)localObject3).Hij == 10)
        {
          if ((bt.isNullOrNil(((cov)localObject3).qdY)) || (bt.isNullOrNil(((cov)localObject3).Ggv)))
          {
            ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((cov)localObject3).Ggv);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cov)localObject3).Hij == 11)
        {
          if ((bt.isNullOrNil(((cov)localObject3).qdY)) || (bt.isNullOrNil(((cov)localObject3).Ggv)))
          {
            ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((cov)localObject3).Ggv);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreewifiActivateWeChatNoAuthStateUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cov)localObject3).Hij == 12)
        {
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiActivateAuthStateUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cov)localObject3).Hij == 31)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[] { m.ao(paramAnonymousString.intent), Integer.valueOf(m.ap(paramAnonymousString.intent)) });
          localObject2 = paramAnonymousString.intent.getStringExtra("free_wifi_schema_ticket");
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[] { m.ao(paramAnonymousString.intent), Integer.valueOf(m.ap(paramAnonymousString.intent)), localObject2 });
          if (bt.isNullOrNil((String)localObject2))
          {
            paramAnonymousString.activity.finish();
            paramAnonymousn = k.cQR();
            paramAnonymousn.dmM = paramAnonymousString.dmM;
            paramAnonymousn.oZp = m.ao(paramAnonymousString.intent);
            paramAnonymousn.tlh = k.b.tlr.tlS;
            paramAnonymousn.tli = k.b.tlr.name;
            paramAnonymousn.channel = paramAnonymousString.channel;
            paramAnonymousn.tlg = m.aq(paramAnonymousString.intent);
            paramAnonymousn.result = -1;
            paramAnonymousn.fKQ = "31 ticket is empty.";
            paramAnonymousn.cQT().c(paramAnonymousString.intent, true).cQS();
            AppMethodBeat.o(24990);
            return;
          }
          String str1 = ((cov)localObject3).qdY;
          localObject3 = ((ats)localObject4).FDD;
          localObject4 = ((ats)localObject4).FXg;
          if (d.cRp() == null)
          {
            ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[] { m.ao(paramAnonymousString.intent), Integer.valueOf(m.ap(paramAnonymousString.intent)) });
            paramAnonymousString.aka(paramAnonymousString.activity.getString(2131759623));
            paramAnonymousn = k.cQR();
            paramAnonymousn.dmM = paramAnonymousString.dmM;
            paramAnonymousn.oZp = m.ao(paramAnonymousString.intent);
            paramAnonymousn.tlh = k.b.tlr.tlS;
            paramAnonymousn.tli = k.b.tlr.name;
            paramAnonymousn.channel = paramAnonymousString.channel;
            paramAnonymousn.tlg = m.aq(paramAnonymousString.intent);
            paramAnonymousn.result = -1;
            paramAnonymousn.fKQ = "wifiInfo is empty.";
            paramAnonymousn.cQT().c(paramAnonymousString.intent, true).cQS();
            AppMethodBeat.o(24990);
            return;
          }
          bool = d.ajQ(str1);
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. is_current_connected_ssid_equals_target_ssid=%b", new Object[] { m.ao(paramAnonymousString.intent), Integer.valueOf(m.ap(paramAnonymousString.intent)), Boolean.valueOf(bool) });
          str1 = ay.iV(aj.getContext());
          String str2 = ay.iW(aj.getContext());
          String str3 = m.ajM("MicroMsg.FreeWifi.FreeWifiNetCheckUI");
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[] { m.ao(paramAnonymousString.intent), Integer.valueOf(m.ap(paramAnonymousString.intent)), paramAnonymousString.dmM, str1, str2, str3, localObject2 });
          k.a locala = k.cQR();
          locala.dmM = paramAnonymousString.dmM;
          locala.oZp = m.ao(paramAnonymousString.intent);
          locala.tlh = k.b.tlr.tlS;
          locala.tli = k.b.tlr.name;
          locala.channel = paramAnonymousString.channel;
          locala.tlg = m.aq(paramAnonymousString.intent);
          locala.result = 0;
          locala.fKQ = "";
          locala.cQT().c(paramAnonymousString.intent, true).cQS();
          locala = k.cQR();
          locala.ssid = paramAnonymousString.intent.getStringExtra("free_wifi_ssid");
          locala.dmM = paramAnonymousString.dmM;
          locala.tlf = paramAnonymousString.intent.getStringExtra("free_wifi_appid");
          locala.oZp = m.ao(paramAnonymousString.intent);
          locala.tlg = m.aq(paramAnonymousString.intent);
          locala.tlh = k.b.tlB.tlS;
          locala.tli = k.b.tlB.name;
          locala.channel = m.ar(paramAnonymousString.intent);
          locala.tlg = m.aq(paramAnonymousString.intent);
          locala.cQT().c(paramAnonymousString.intent, false).cQS();
          new i(paramAnonymousString.dmM, str1, str2, str3, (String)localObject2, m.ao(paramAnonymousString.intent)).aq(paramAnonymousString.activity).c(new a.2(paramAnonymousString, paramAnonymousn, (String)localObject1, (String)localObject3, (String)localObject4));
          AppMethodBeat.o(24990);
          return;
        }
        if (((cov)localObject3).Hij == 32)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
          ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[] { m.ao(paramAnonymousString.intent), Integer.valueOf(m.ap(paramAnonymousString.intent)) });
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        if (((cov)localObject3).Hij == 1)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousn = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.activity.finish();
        paramAnonymousString.aka(paramAnonymousString.activity.getString(2131759628));
        AppMethodBeat.o(24990);
        return;
        label2794:
        if ((m.gd(paramAnonymousInt1, paramAnonymousInt2)) && (!m.ea(paramAnonymousString)))
        {
          a.this.aka(paramAnonymousString + "(" + m.a(m.aq(a.this.intent), k.b.tlq, paramAnonymousInt2) + ")");
          AppMethodBeat.o(24990);
          return;
        }
        if (paramAnonymousInt2 == -30031)
        {
          a.this.aka(a.this.activity.getString(2131759627));
          AppMethodBeat.o(24990);
          return;
        }
        a.this.aka(a.this.activity.getString(2131759623) + "(" + String.format("%02d", new Object[] { Integer.valueOf(m.aq(a.this.intent)) }) + k.b.tlq.tlS + Math.abs(paramAnonymousInt2) + ")");
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