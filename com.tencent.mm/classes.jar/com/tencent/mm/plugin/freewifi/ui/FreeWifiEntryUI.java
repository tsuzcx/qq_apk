package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.tencent.mm.R.a;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;

@a(3)
public class FreeWifiEntryUI
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onResume()
  {
    int i = 1;
    super.onResume();
    if (!au.DK()) {
      finish();
    }
    for (;;)
    {
      finish();
      return;
      Intent localIntent = getIntent();
      int j = getIntent().getIntExtra("free_wifi_source", 1);
      y.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "has notified, now scene is : %d", new Object[] { Integer.valueOf(j) });
      Object localObject;
      switch (j)
      {
      default: 
        break;
      case 1: 
        if (1 != i.a.aTw().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.aTw().bD("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        m.d(localIntent, localIntent.getStringExtra("free_wifi_mid"));
        localIntent.setClass(this, FreeWifiNetCheckUI.class);
        startActivity(localIntent);
        super.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
        break;
      case 3: 
        localIntent.putExtra("free_wifi_auth_type", 2);
        localIntent.setClass(this, FreeWifiMIGNoAuthStateUI.class);
        startActivity(localIntent);
        break;
      case 2: 
        localObject = j.aUi().DC(com.tencent.mm.plugin.freewifi.model.d.aUa());
        if (localObject == null)
        {
          y.e("MicroMsg.FreeWifi.FreeWifiEntryUI", "what the fuck, how could it be???");
        }
        else
        {
          y.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "banner click, freeWifiInfo.field_action:%d, field_showUrl:%s", new Object[] { Integer.valueOf(((c)localObject).field_action), ((c)localObject).field_showUrl });
          if ((((c)localObject).field_action == 2) && (!bk.bl(((c)localObject).field_showUrl)))
          {
            ((e)g.r(e.class)).b(this, ((c)localObject).field_showUrl, 1064, null);
          }
          else if ((((c)localObject).field_action == 1) && (!bk.bl(((c)localObject).field_showUrl)))
          {
            localIntent = new Intent();
            String str = x.d(getSharedPreferences(ae.cqR(), 0));
            localIntent.putExtra("rawUrl", Uri.parse(((c)localObject).field_showUrl).buildUpon().appendQueryParameter("lang", str).build().toString());
            localIntent.putExtra("show_bottom", false);
            com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
          }
          else
          {
            localIntent.setClass(this, FreeWifiAuthStateUI.class);
            startActivity(localIntent);
          }
        }
        break;
      case 5: 
        if (1 != i.a.aTw().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.aTw().bD("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        localObject = localIntent.getStringExtra("free_wifi_ap_key");
        if (!m.isEmpty((String)localObject))
        {
          getIntent().putExtra("free_wifi_channel_id", 1);
          if ("_p33beta".equalsIgnoreCase((String)localObject))
          {
            m.A(localIntent);
            localIntent.putExtra("free_wifi_auth_type", 33);
            localIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 33);
            localIntent.putExtra("free_wifi_ssid", m.Do("MicroMsg.FreeWifi.FreeWifiEntryUI"));
            localIntent.putExtra("free_wifi_url", (String)localObject);
            localIntent.putExtra("free_wifi_ap_key", (String)localObject);
            localIntent.putExtra("free_wifi_source", 5);
            localIntent.putExtra("free_wifi_channel_id", 1);
            localIntent.setClass(this, FreeWifiFrontPageUI.class);
            startActivity(localIntent);
            super.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
          }
          else if (((String)localObject).startsWith("_"))
          {
            localObject = getString(R.l.free_wifi_errmsg_update_client);
            localIntent = new Intent();
            localIntent.putExtra("free_wifi_error_ui_error_msg", (String)localObject);
            localIntent.setClass(this, FreeWifiErrorUI.class);
            startActivity(localIntent);
            super.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
          }
          else
          {
            j = localIntent.getIntExtra("free_wifi_threeone_startup_type", 0);
            if (2 == j) {
              i = 11;
            }
            for (;;)
            {
              localIntent.putExtra("free_wifi_channel_id", i);
              localIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
              m.d(localIntent, localIntent.getStringExtra("free_wifi_schema_ticket"));
              if (j == 4) {
                localIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.B(localIntent) + "_" + m.D(localIntent) + "_" + m.E(localIntent) + "_" + System.currentTimeMillis());
              }
              localIntent.setClass(this, FreeWifiNetCheckUI.class);
              startActivity(localIntent);
              super.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
              break;
              if (3 == j) {
                i = 12;
              } else if (4 == j) {
                i = 13;
              }
            }
          }
        }
        break;
      case 4: 
        if (1 != i.a.aTw().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.aTw().bD("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        localIntent.setClass(this, FreeWifiNetCheckUI.class);
        startActivity(localIntent);
        super.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
        break;
      case 6: 
        if (1 != i.a.aTw().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.aTw().bD("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        localIntent.setClass(this, FreeWifiNetCheckUI.class);
        startActivity(localIntent);
        super.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI
 * JD-Core Version:    0.7.0.1
 */