package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class FreeWifiEntryUI
  extends Activity
{
  private boolean mMF = true;
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20954);
    super.onCreate(paramBundle);
    AppMethodBeat.o(20954);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(20956);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(20956);
      return;
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20956);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.mMF = false;
        h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new DialogInterface.OnClickListener()new FreeWifiEntryUI.3
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20952);
            FreeWifiEntryUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            FreeWifiEntryUI.this.finish();
            AppMethodBeat.o(20952);
          }
        }, new FreeWifiEntryUI.3(this));
      }
    }
  }
  
  protected void onResume()
  {
    AppMethodBeat.i(20955);
    super.onResume();
    if (!aw.RG()) {
      finish();
    }
    Intent localIntent;
    int i;
    for (;;)
    {
      finish();
      AppMethodBeat.o(20955);
      return;
      if (this.mMF)
      {
        boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
        ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {}
      }
      else if ((b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) && (!com.tencent.mm.modelgeo.d.agR()))
      {
        h.a(this, getString(2131300538), getString(2131297087), getString(2131300996), getString(2131296888), false, new FreeWifiEntryUI.1(this), null);
      }
      localIntent = getIntent();
      i = getIntent().getIntExtra("free_wifi_source", 1);
      ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "has notified, now scene is : %d", new Object[] { Integer.valueOf(i) });
      Object localObject;
      switch (i)
      {
      default: 
        break;
      case 1: 
        if (1 != i.a.bAb().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.bAb().cl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        m.d(localIntent, localIntent.getStringExtra("free_wifi_mid"));
        localIntent.setClass(this, FreeWifiNetCheckUI.class);
        startActivity(localIntent);
        super.overridePendingTransition(2131034266, 2131034263);
        break;
      case 3: 
        localIntent.putExtra("free_wifi_auth_type", 2);
        localIntent.setClass(this, FreeWifiMIGNoAuthStateUI.class);
        startActivity(localIntent);
        break;
      case 2: 
        localObject = j.bAK().OK(com.tencent.mm.plugin.freewifi.model.d.bAC());
        if (localObject == null)
        {
          ab.e("MicroMsg.FreeWifi.FreeWifiEntryUI", "what the fuck, how could it be???");
        }
        else
        {
          ab.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "banner click, freeWifiInfo.field_action:%d, field_showUrl:%s", new Object[] { Integer.valueOf(((c)localObject).field_action), ((c)localObject).field_showUrl });
          if ((((c)localObject).field_action == 2) && (!bo.isNullOrNil(((c)localObject).field_showUrl)))
          {
            ((k)g.E(k.class)).b(this, ((c)localObject).field_showUrl, 1064, null);
          }
          else if ((((c)localObject).field_action == 1) && (!bo.isNullOrNil(((c)localObject).field_showUrl)))
          {
            localIntent = new Intent();
            String str = aa.f(getSharedPreferences(ah.dsP(), 0));
            localIntent.putExtra("rawUrl", Uri.parse(((c)localObject).field_showUrl).buildUpon().appendQueryParameter("lang", str).build().toString());
            localIntent.putExtra("show_bottom", false);
            com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
          }
          else
          {
            localIntent.setClass(this, FreeWifiAuthStateUI.class);
            startActivity(localIntent);
          }
        }
        break;
      case 5: 
        if (1 != i.a.bAb().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
          i.a.bAb().cl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
        }
        localObject = localIntent.getStringExtra("free_wifi_ap_key");
        if (!m.isEmpty((String)localObject))
        {
          getIntent().putExtra("free_wifi_channel_id", 1);
          if ("_p33beta".equalsIgnoreCase((String)localObject))
          {
            m.T(localIntent);
            localIntent.putExtra("free_wifi_auth_type", 33);
            localIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 33);
            localIntent.putExtra("free_wifi_ssid", m.Ow("MicroMsg.FreeWifi.FreeWifiEntryUI"));
            localIntent.putExtra("free_wifi_url", (String)localObject);
            localIntent.putExtra("free_wifi_ap_key", (String)localObject);
            localIntent.putExtra("free_wifi_source", 5);
            localIntent.putExtra("free_wifi_channel_id", 1);
            localIntent.setClass(this, FreeWifiFrontPageUI.class);
            startActivity(localIntent);
            super.overridePendingTransition(2131034266, 2131034263);
          }
          else
          {
            if (!((String)localObject).startsWith("_")) {
              break label751;
            }
            localObject = getString(2131300156);
            localIntent = new Intent();
            localIntent.putExtra("free_wifi_error_ui_error_msg", (String)localObject);
            localIntent.setClass(this, FreeWifiErrorUI.class);
            startActivity(localIntent);
            super.overridePendingTransition(2131034266, 2131034263);
          }
        }
        break;
      }
    }
    label751:
    int j = localIntent.getIntExtra("free_wifi_threeone_startup_type", 0);
    if (2 == j) {
      i = 11;
    }
    for (;;)
    {
      localIntent.putExtra("free_wifi_channel_id", i);
      localIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
      m.d(localIntent, localIntent.getStringExtra("free_wifi_schema_ticket"));
      if (j == 4) {
        localIntent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.U(localIntent) + "_" + m.W(localIntent) + "_" + m.X(localIntent) + "_" + System.currentTimeMillis());
      }
      localIntent.setClass(this, FreeWifiNetCheckUI.class);
      startActivity(localIntent);
      super.overridePendingTransition(2131034266, 2131034263);
      break;
      if (3 == j)
      {
        i = 12;
      }
      else
      {
        if (4 == j)
        {
          i = 13;
          continue;
          if (1 != i.a.bAb().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
            i.a.bAb().cl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
          }
          localIntent.setClass(this, FreeWifiNetCheckUI.class);
          startActivity(localIntent);
          super.overridePendingTransition(2131034266, 2131034263);
          break;
          if (1 != i.a.bAb().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
            i.a.bAb().cl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
          }
          localIntent.setClass(this, FreeWifiNetCheckUI.class);
          startActivity(localIntent);
          super.overridePendingTransition(2131034266, 2131034263);
          break;
        }
        i = 1;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI
 * JD-Core Version:    0.7.0.1
 */