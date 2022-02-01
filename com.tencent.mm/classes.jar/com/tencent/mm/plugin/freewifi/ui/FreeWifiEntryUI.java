package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class FreeWifiEntryUI
  extends HellActivity
{
  private boolean pFR = true;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25013);
    super.onCreate(paramBundle);
    AppMethodBeat.o(25013);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25015);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25015);
      return;
    }
    ac.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25015);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.pFR = false;
        h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new FreeWifiEntryUI.2(this), new FreeWifiEntryUI.3(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25014);
    super.onResume();
    if (!az.agM()) {
      finish();
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(25014);
      return;
      if (this.pFR)
      {
        boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
        ac.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {}
      }
      else if ((b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) && (!com.tencent.mm.modelgeo.d.aEM()))
      {
        h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new FreeWifiEntryUI.1(this), null);
      }
      Intent localIntent = getIntent();
      int i = getIntent().getIntExtra("free_wifi_source", 1);
      ac.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "has notified, now scene is : %d", new Object[] { Integer.valueOf(i) });
      Object localObject;
      switch (i)
      {
      default: 
        break;
      case 1: 
        if (1 != i.a.cIB().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.cIB().dl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        m.e(localIntent, localIntent.getStringExtra("free_wifi_mid"));
        localIntent.setClass(this, FreeWifiNetCheckUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        super.overridePendingTransition(2130772144, 2130772141);
        break;
      case 3: 
        localIntent.putExtra("free_wifi_auth_type", 2);
        localIntent.setClass(this, FreeWifiMIGNoAuthStateUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
      case 2: 
        localObject = j.cJk().afA(com.tencent.mm.plugin.freewifi.model.d.cJc());
        if (localObject == null)
        {
          ac.e("MicroMsg.FreeWifi.FreeWifiEntryUI", "what the fuck, how could it be???");
        }
        else
        {
          ac.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "banner click, freeWifiInfo.field_action:%d, field_showUrl:%s", new Object[] { Integer.valueOf(((c)localObject).field_action), ((c)localObject).field_showUrl });
          if ((((c)localObject).field_action == 2) && (!bs.isNullOrNil(((c)localObject).field_showUrl)))
          {
            ((o)g.ab(o.class)).b(this, ((c)localObject).field_showUrl, 1064, null);
          }
          else if ((((c)localObject).field_action == 1) && (!bs.isNullOrNil(((c)localObject).field_showUrl)))
          {
            localIntent = new Intent();
            String str = ab.f(getSharedPreferences(ai.eUX(), 0));
            localIntent.putExtra("rawUrl", Uri.parse(((c)localObject).field_showUrl).buildUpon().appendQueryParameter("lang", str).build().toString());
            localIntent.putExtra("show_bottom", false);
            com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
          }
          else
          {
            localIntent.setClass(this, FreeWifiAuthStateUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        break;
      case 5: 
        if (1 != i.a.cIB().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.cIB().dl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        localObject = localIntent.getStringExtra("free_wifi_ap_key");
        if (!m.cX((String)localObject))
        {
          getIntent().putExtra("free_wifi_channel_id", 1);
          if ("_p33beta".equalsIgnoreCase((String)localObject))
          {
            m.ai(localIntent);
            localIntent.putExtra("free_wifi_auth_type", 33);
            localIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 33);
            localIntent.putExtra("free_wifi_ssid", m.afm("MicroMsg.FreeWifi.FreeWifiEntryUI"));
            localIntent.putExtra("free_wifi_url", (String)localObject);
            localIntent.putExtra("free_wifi_ap_key", (String)localObject);
            localIntent.putExtra("free_wifi_source", 5);
            localIntent.putExtra("free_wifi_channel_id", 1);
            localIntent.setClass(this, FreeWifiFrontPageUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            super.overridePendingTransition(2130772144, 2130772141);
          }
          else if (((String)localObject).startsWith("_"))
          {
            localObject = getString(2131759628);
            localIntent = new Intent();
            localIntent.putExtra("free_wifi_error_ui_error_msg", (String)localObject);
            localIntent.setClass(this, FreeWifiErrorUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            super.overridePendingTransition(2130772144, 2130772141);
          }
          else
          {
            int j = localIntent.getIntExtra("free_wifi_threeone_startup_type", 0);
            i = 1;
            if (2 == j) {
              i = 11;
            }
            for (;;)
            {
              localIntent.putExtra("free_wifi_channel_id", i);
              localIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
              m.e(localIntent, localIntent.getStringExtra("free_wifi_schema_ticket"));
              if (j == 4) {
                localIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.aj(localIntent) + "_" + m.al(localIntent) + "_" + m.am(localIntent) + "_" + System.currentTimeMillis());
              }
              localIntent.setClass(this, FreeWifiNetCheckUI.class);
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              super.overridePendingTransition(2130772144, 2130772141);
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
        if (1 != i.a.cIB().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.cIB().dl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        localIntent.setClass(this, FreeWifiNetCheckUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        super.overridePendingTransition(2130772144, 2130772141);
        break;
      case 6: 
        if (1 != i.a.cIB().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.cIB().dl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        localIntent.setClass(this, FreeWifiNetCheckUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI", "doDirect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        super.overridePendingTransition(2130772144, 2130772141);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI
 * JD-Core Version:    0.7.0.1
 */