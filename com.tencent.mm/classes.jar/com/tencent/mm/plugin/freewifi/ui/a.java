package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.d.c;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  Activity activity;
  int channel;
  String dFd;
  Intent intent;
  
  public a(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(24992);
    if (Util.isNullOrNil(paramString))
    {
      paramActivity = new IllegalArgumentException("acitvity or apKey cannot be null.");
      AppMethodBeat.o(24992);
      throw paramActivity;
    }
    this.activity = paramActivity;
    this.intent = paramActivity.getIntent();
    this.dFd = paramString;
    this.channel = paramInt;
    AppMethodBeat.o(24992);
  }
  
  final void ayc(String paramString)
  {
    AppMethodBeat.i(24994);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg", paramString);
    ((Intent)localObject).setClass(this.activity, FreeWifiErrorUI.class);
    this.activity.finish();
    paramString = this.activity;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24994);
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24993);
    if (Util.isNullOrNil(this.dFd))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      this.activity.finish();
    }
    this.activity.getIntent().putExtra("free_wifi_url", this.dFd);
    this.activity.getIntent().putExtra("free_wifi_ap_key", this.dFd);
    if (Util.isNullOrNil(this.dFd))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
      this.activity.finish();
      AppMethodBeat.o(24993);
      return;
    }
    Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.dFd, Integer.valueOf(this.channel) });
    k.a locala = k.dMF();
    locala.dFd = this.dFd;
    locala.quX = m.aw(this.intent);
    locala.wNd = k.b.wNl.wNO;
    locala.wNe = k.b.wNl.name;
    locala.channel = this.channel;
    locala.wNc = m.ay(this.intent);
    locala.dMH().c(this.intent, false).dMG();
    new com.tencent.mm.plugin.freewifi.d.a(this.dFd, this.channel, m.aw(this.intent)).ap(this.activity).c(new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(24990);
        Object localObject1 = k.dMF();
        ((k.a)localObject1).dFd = a.this.dFd;
        ((k.a)localObject1).quX = m.aw(a.this.intent);
        ((k.a)localObject1).wNd = k.b.wNm.wNO;
        ((k.a)localObject1).wNe = k.b.wNm.name;
        ((k.a)localObject1).wNc = m.ay(a.this.intent);
        ((k.a)localObject1).channel = a.this.channel;
        ((k.a)localObject1).result = paramAnonymousInt2;
        ((k.a)localObject1).resultMsg = paramAnonymousString;
        localObject1 = ((k.a)localObject1).dMH();
        Object localObject2 = a.this.intent;
        if (paramAnonymousInt2 != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((k)localObject1).c((Intent)localObject2, bool).dMG();
          Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { m.aw(a.this.intent), Integer.valueOf(m.ax(a.this.intent)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            break label2794;
          }
          paramAnonymousString = a.this;
          if ((paramAnonymousq instanceof com.tencent.mm.plugin.freewifi.d.a)) {
            break;
          }
          paramAnonymousString.ayc(paramAnonymousString.activity.getString(2131760944));
          AppMethodBeat.o(24990);
          return;
        }
        localObject1 = (com.tencent.mm.plugin.freewifi.d.a)paramAnonymousq;
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", ((com.tencent.mm.plugin.freewifi.d.a)localObject1).dNx());
        Object localObject4 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).dNy();
        if (localObject4 != null)
        {
          Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[] { m.aw(paramAnonymousString.intent), Integer.valueOf(m.ax(paramAnonymousString.intent)), ((bfr)localObject4).KGX, ((bfr)localObject4).oUJ, ((bfr)localObject4).UserName, ((bfr)localObject4).xJE, ((bfr)localObject4).LPm, ((bfr)localObject4).LPn, ((bfr)localObject4).KPJ, ((bfr)localObject4).Lkr, Integer.valueOf(((bfr)localObject4).KCz) });
          paramAnonymousString.intent.putExtra("free_wifi_appid", ((bfr)localObject4).KGX);
          paramAnonymousString.intent.putExtra("free_wifi_head_img_url", ((bfr)localObject4).xJE);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_msg", ((bfr)localObject4).LPm);
          paramAnonymousString.intent.putExtra("free_wifi_privacy_url", ((bfr)localObject4).LPn);
          paramAnonymousString.intent.putExtra("free_wifi_app_nickname", ((bfr)localObject4).oUJ);
          paramAnonymousString.intent.putExtra("free_wifi_welcome_sub_title", ((bfr)localObject4).LPo);
        }
        if (paramAnonymousString.channel != 2) {
          paramAnonymousString.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
        }
        Object localObject3 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).dNw();
        if (localObject3 == null)
        {
          Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
          paramAnonymousString.activity.finish();
          paramAnonymousq = k.dMF();
          paramAnonymousq.dFd = paramAnonymousString.dFd;
          paramAnonymousq.quX = m.aw(paramAnonymousString.intent);
          paramAnonymousq.wNd = k.b.wNn.wNO;
          paramAnonymousq.wNe = k.b.wNn.name;
          paramAnonymousq.wNc = m.ay(paramAnonymousString.intent);
          paramAnonymousq.channel = paramAnonymousString.channel;
          paramAnonymousq.result = -1;
          paramAnonymousq.resultMsg = "qstrInfo is null.";
          paramAnonymousq.dMH().c(paramAnonymousString.intent, true).dMG();
          AppMethodBeat.o(24990);
          return;
        }
        if (m.eP(((dho)localObject3).rBy))
        {
          Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
          paramAnonymousString.activity.finish();
          paramAnonymousq = k.dMF();
          paramAnonymousq.dFd = paramAnonymousString.dFd;
          paramAnonymousq.quX = m.aw(paramAnonymousString.intent);
          paramAnonymousq.wNd = k.b.wNn.wNO;
          paramAnonymousq.wNe = k.b.wNn.name;
          paramAnonymousq.wNc = m.ay(paramAnonymousString.intent);
          paramAnonymousq.channel = paramAnonymousString.channel;
          paramAnonymousq.result = -1;
          paramAnonymousq.resultMsg = "qstrInfo.Ssid is empty.";
          paramAnonymousq.dMH().c(paramAnonymousString.intent, true).dMG();
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.intent.putExtra("free_wifi_ssid", ((dho)localObject3).rBy);
        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[] { m.aw(paramAnonymousString.intent), Integer.valueOf(m.ax(paramAnonymousString.intent)), Integer.valueOf(((dho)localObject3).MMx), ((dho)localObject3).rBy, ((dho)localObject3).LuS });
        paramAnonymousq = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).getOpenId();
        localObject1 = ((com.tencent.mm.plugin.freewifi.d.a)localObject1).ahV();
        paramAnonymousString.intent.putExtra("free_wifi_openid", paramAnonymousq);
        paramAnonymousString.intent.putExtra("free_wifi_tid", (String)localObject1);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", ((bfr)localObject4).KPJ);
        paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", ((bfr)localObject4).Lkr);
        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[] { m.aw(paramAnonymousString.intent), Integer.valueOf(m.ax(paramAnonymousString.intent)), paramAnonymousq, localObject1 });
        paramAnonymousString.intent.putExtra("free_wifi_protocol_type", ((dho)localObject3).MMx);
        if (((dho)localObject3).MMx == 10)
        {
          if ((Util.isNullOrNil(((dho)localObject3).rBy)) || (Util.isNullOrNil(((dho)localObject3).LuS)))
          {
            Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((dho)localObject3).LuS);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousq = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousq.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772169, 2130772166);
          AppMethodBeat.o(24990);
          return;
        }
        if (((dho)localObject3).MMx == 11)
        {
          if ((Util.isNullOrNil(((dho)localObject3).rBy)) || (Util.isNullOrNil(((dho)localObject3).LuS)))
          {
            Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
            paramAnonymousString.activity.finish();
            AppMethodBeat.o(24990);
            return;
          }
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 2);
          paramAnonymousString.intent.putExtra("free_wifi_passowrd", ((dho)localObject3).LuS);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreewifiActivateWeChatNoAuthStateUI.class);
          paramAnonymousq = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousq.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772169, 2130772166);
          AppMethodBeat.o(24990);
          return;
        }
        if (((dho)localObject3).MMx == 12)
        {
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiActivateAuthStateUI.class);
          paramAnonymousq = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousq.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772169, 2130772166);
          AppMethodBeat.o(24990);
          return;
        }
        if (((dho)localObject3).MMx == 31)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
          Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[] { m.aw(paramAnonymousString.intent), Integer.valueOf(m.ax(paramAnonymousString.intent)) });
          localObject2 = paramAnonymousString.intent.getStringExtra("free_wifi_schema_ticket");
          Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[] { m.aw(paramAnonymousString.intent), Integer.valueOf(m.ax(paramAnonymousString.intent)), localObject2 });
          if (Util.isNullOrNil((String)localObject2))
          {
            paramAnonymousString.activity.finish();
            paramAnonymousq = k.dMF();
            paramAnonymousq.dFd = paramAnonymousString.dFd;
            paramAnonymousq.quX = m.aw(paramAnonymousString.intent);
            paramAnonymousq.wNd = k.b.wNn.wNO;
            paramAnonymousq.wNe = k.b.wNn.name;
            paramAnonymousq.channel = paramAnonymousString.channel;
            paramAnonymousq.wNc = m.ay(paramAnonymousString.intent);
            paramAnonymousq.result = -1;
            paramAnonymousq.resultMsg = "31 ticket is empty.";
            paramAnonymousq.dMH().c(paramAnonymousString.intent, true).dMG();
            AppMethodBeat.o(24990);
            return;
          }
          String str1 = ((dho)localObject3).rBy;
          localObject3 = ((bfr)localObject4).KPJ;
          localObject4 = ((bfr)localObject4).Lkr;
          if (d.dNd() == null)
          {
            Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[] { m.aw(paramAnonymousString.intent), Integer.valueOf(m.ax(paramAnonymousString.intent)) });
            paramAnonymousString.ayc(paramAnonymousString.activity.getString(2131760944));
            paramAnonymousq = k.dMF();
            paramAnonymousq.dFd = paramAnonymousString.dFd;
            paramAnonymousq.quX = m.aw(paramAnonymousString.intent);
            paramAnonymousq.wNd = k.b.wNn.wNO;
            paramAnonymousq.wNe = k.b.wNn.name;
            paramAnonymousq.channel = paramAnonymousString.channel;
            paramAnonymousq.wNc = m.ay(paramAnonymousString.intent);
            paramAnonymousq.result = -1;
            paramAnonymousq.resultMsg = "wifiInfo is empty.";
            paramAnonymousq.dMH().c(paramAnonymousString.intent, true).dMG();
            AppMethodBeat.o(24990);
            return;
          }
          bool = d.axS(str1);
          Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. is_current_connected_ssid_equals_target_ssid=%b", new Object[] { m.aw(paramAnonymousString.intent), Integer.valueOf(m.ax(paramAnonymousString.intent)), Boolean.valueOf(bool) });
          str1 = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
          String str2 = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
          String str3 = m.axO("MicroMsg.FreeWifi.FreeWifiNetCheckUI");
          Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[] { m.aw(paramAnonymousString.intent), Integer.valueOf(m.ax(paramAnonymousString.intent)), paramAnonymousString.dFd, str1, str2, str3, localObject2 });
          k.a locala = k.dMF();
          locala.dFd = paramAnonymousString.dFd;
          locala.quX = m.aw(paramAnonymousString.intent);
          locala.wNd = k.b.wNn.wNO;
          locala.wNe = k.b.wNn.name;
          locala.channel = paramAnonymousString.channel;
          locala.wNc = m.ay(paramAnonymousString.intent);
          locala.result = 0;
          locala.resultMsg = "";
          locala.dMH().c(paramAnonymousString.intent, true).dMG();
          locala = k.dMF();
          locala.ssid = paramAnonymousString.intent.getStringExtra("free_wifi_ssid");
          locala.dFd = paramAnonymousString.dFd;
          locala.wNb = paramAnonymousString.intent.getStringExtra("free_wifi_appid");
          locala.quX = m.aw(paramAnonymousString.intent);
          locala.wNc = m.ay(paramAnonymousString.intent);
          locala.wNd = k.b.wNx.wNO;
          locala.wNe = k.b.wNx.name;
          locala.channel = m.az(paramAnonymousString.intent);
          locala.wNc = m.ay(paramAnonymousString.intent);
          locala.dMH().c(paramAnonymousString.intent, false).dMG();
          new com.tencent.mm.plugin.freewifi.d.i(paramAnonymousString.dFd, str1, str2, str3, (String)localObject2, m.aw(paramAnonymousString.intent)).ap(paramAnonymousString.activity).c(new a.2(paramAnonymousString, paramAnonymousq, (String)localObject1, (String)localObject3, (String)localObject4));
          AppMethodBeat.o(24990);
          return;
        }
        if (((dho)localObject3).MMx == 32)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
          Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[] { m.aw(paramAnonymousString.intent), Integer.valueOf(m.ax(paramAnonymousString.intent)) });
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousq = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousq.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772169, 2130772166);
          AppMethodBeat.o(24990);
          return;
        }
        if (((dho)localObject3).MMx == 1)
        {
          paramAnonymousString.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
          paramAnonymousString.intent.putExtra("free_wifi_auth_type", 1);
          paramAnonymousString.intent.setClass(paramAnonymousString.activity, FreeWifiFrontPageUI.class);
          paramAnonymousq = paramAnonymousString.activity;
          localObject1 = paramAnonymousString.intent;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousq.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString.activity.finish();
          paramAnonymousString.activity.overridePendingTransition(2130772169, 2130772166);
          AppMethodBeat.o(24990);
          return;
        }
        paramAnonymousString.activity.finish();
        paramAnonymousString.ayc(paramAnonymousString.activity.getString(2131760949));
        AppMethodBeat.o(24990);
        return;
        label2794:
        if ((m.gC(paramAnonymousInt1, paramAnonymousInt2)) && (!m.eP(paramAnonymousString)))
        {
          a.this.ayc(paramAnonymousString + "(" + m.a(m.ay(a.this.intent), k.b.wNm, paramAnonymousInt2) + ")");
          AppMethodBeat.o(24990);
          return;
        }
        if (paramAnonymousInt2 == -30031)
        {
          a.this.ayc(a.this.activity.getString(2131760948));
          AppMethodBeat.o(24990);
          return;
        }
        a.this.ayc(a.this.activity.getString(2131760944) + "(" + String.format("%02d", new Object[] { Integer.valueOf(m.ay(a.this.intent)) }) + k.b.wNm.wNO + Math.abs(paramAnonymousInt2) + ")");
        AppMethodBeat.o(24990);
      }
    });
    AppMethodBeat.o(24993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.a
 * JD-Core Version:    0.7.0.1
 */