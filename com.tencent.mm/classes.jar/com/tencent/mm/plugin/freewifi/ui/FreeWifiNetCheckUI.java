package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.d.c;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.h.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNetCheckUI
  extends MMActivity
{
  private int bUR;
  private am byQ;
  private Intent intent;
  private String key;
  ImageView ksi;
  private final int ksl = 1;
  private final int ksm = 2;
  private int[] kso = { R.g.free_wifi_loading_1, R.g.free_wifi_loading_2, R.g.free_wifi_loading_3, R.g.free_wifi_loading_4, R.g.free_wifi_loading_5 };
  ah ksp = new FreeWifiNetCheckUI.1(this);
  private b ksw;
  private int scene;
  
  private void aVg()
  {
    if (bk.bl(this.key))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      finish();
      return;
    }
    this.ksw = new b(this, this.key, this.bUR);
    y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", new Object[] { m.B(getIntent()), Integer.valueOf(m.C(this.intent)), this.key, Integer.valueOf(this.bUR) });
    b localb = this.ksw;
    if (bk.bl(localb.bHI))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      localb.activity.finish();
    }
    localb.activity.getIntent().putExtra("free_wifi_url", localb.bHI);
    localb.activity.getIntent().putExtra("free_wifi_ap_key", localb.bHI);
    if (bk.bl(localb.bHI))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
      localb.activity.finish();
      return;
    }
    y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[] { m.B(localb.intent), Integer.valueOf(m.C(localb.intent)), localb.bHI, Integer.valueOf(localb.bUR) });
    k.a locala = k.aTx();
    locala.bHI = localb.bHI;
    locala.iGw = m.B(localb.intent);
    locala.kmS = k.b.kna.knD;
    locala.kmT = k.b.kna.name;
    locala.bUR = localb.bUR;
    locala.kmR = m.D(localb.intent);
    locala.aTz().b(localb.intent, false).aTy();
    new a(localb.bHI, localb.bUR, m.B(localb.intent)).A(localb.activity).b(new b.1(localb));
  }
  
  public void finish()
  {
    if (this.byQ != null) {
      this.byQ.stopTimer();
    }
    this.ksp.sendEmptyMessage(2);
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_net_check;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.free_wifi_title);
    setBackBtn(new FreeWifiNetCheckUI.2(this));
    this.intent = getIntent();
    m.A(this.intent);
    this.key = getIntent().getStringExtra("free_wifi_ap_key");
    this.scene = getIntent().getIntExtra("free_wifi_source", 1);
    y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", new Object[] { m.B(this.intent), Integer.valueOf(m.C(this.intent)), this.key, d.aTX() });
    this.ksi = ((ImageView)findViewById(R.h.free_wifi_app_logo_iv));
    this.byQ = new am(new FreeWifiNetCheckUI.3(this), true);
    this.byQ.S(200L, 200L);
    switch (this.scene)
    {
    case 2: 
    case 3: 
    default: 
      y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
      finish();
    }
    for (;;)
    {
      y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", new Object[] { m.B(getIntent()), Integer.valueOf(m.C(this.intent)), Integer.valueOf(this.bUR) });
      return;
      paramBundle = getIntent().getStringExtra("free_wifi_jsapi_param_type");
      if ("1".equals(paramBundle))
      {
        getIntent().putExtra("free_wifi_channel_id", 9);
        this.bUR = 9;
      }
      for (;;)
      {
        paramBundle = getIntent().getStringExtra("free_wifi_jsapi_param_type");
        if ((!paramBundle.equals("0")) || (!bk.bl(this.key))) {
          break label400;
        }
        y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
        finish();
        break;
        if ("0".equals(paramBundle))
        {
          getIntent().putExtra("free_wifi_channel_id", 8);
          this.bUR = 8;
        }
        else
        {
          getIntent().putExtra("free_wifi_channel_id", 4);
          this.bUR = 4;
        }
      }
      label400:
      if (paramBundle.equals("0"))
      {
        aVg();
      }
      else if (paramBundle.equals("1"))
      {
        paramBundle = getIntent().getStringExtra("free_wifi_jsapi_param_username");
        if (!d.isWifiEnabled()) {
          d.aTU();
        }
        h.b.aUf().a(new FreeWifiNetCheckUI.5(this, paramBundle));
      }
      else
      {
        y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
        finish();
        continue;
        this.bUR = getIntent().getIntExtra("free_wifi_channel_id", 1);
        if (bk.bl(this.key))
        {
          y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
          finish();
        }
        else
        {
          aVg();
          continue;
          getIntent().putExtra("free_wifi_channel_id", 2);
          this.bUR = 2;
          if (bk.bl(this.key))
          {
            y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
          }
          else
          {
            paramBundle = null;
            Object localObject2 = "";
            try
            {
              localObject1 = Uri.parse(this.key);
              paramBundle = (Bundle)localObject1;
              localObject3 = ((Uri)localObject1).getQueryParameter("q");
              localObject2 = localObject3;
              paramBundle = (Bundle)localObject1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Object localObject1;
                Object localObject3;
                finish();
              }
              "_test".equals(localObject2);
              aVg();
            }
            if ("pc".equalsIgnoreCase((String)localObject2))
            {
              localObject1 = paramBundle.getQueryParameter("appid");
              localObject2 = paramBundle.getQueryParameter("shopid");
              paramBundle = paramBundle.getQueryParameter("ticket");
              m.d(getIntent(), paramBundle);
              localObject3 = k.aTx();
              ((k.a)localObject3).kmP = ((String)localObject2);
              ((k.a)localObject3).kmQ = ((String)localObject1);
              ((k.a)localObject3).iGw = paramBundle;
              ((k.a)localObject3).kmS = k.b.knx.knD;
              ((k.a)localObject3).kmT = k.b.knx.name;
              ((k.a)localObject3).aTz().aTy();
              y.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", new Object[] { m.B(getIntent()), Integer.valueOf(m.C(getIntent())), localObject2, localObject1, paramBundle });
              new com.tencent.mm.plugin.freewifi.d.h((String)localObject1, Integer.valueOf((String)localObject2).intValue(), paramBundle).b(new FreeWifiNetCheckUI.4(this, (String)localObject2, paramBundle, (String)localObject1));
            }
            else
            {
              continue;
              getIntent().putExtra("free_wifi_channel_id", 10);
              this.bUR = 10;
              if (bk.bl(this.key))
              {
                y.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
              }
              else
              {
                aVg();
              }
            }
          }
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.ksw != null) {
      this.ksw = null;
    }
    this.byQ.stopTimer();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI
 * JD-Core Version:    0.7.0.1
 */