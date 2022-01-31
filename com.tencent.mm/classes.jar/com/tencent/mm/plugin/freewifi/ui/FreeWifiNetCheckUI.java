package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNetCheckUI
  extends MMActivity
{
  private int cCy;
  private ap caS;
  private Intent intent;
  private String key;
  private boolean mMF;
  ImageView mNW;
  private final int mNZ;
  private final int mOa;
  private int[] mOc;
  ak mOd;
  private b mOk;
  private int scene;
  
  public FreeWifiNetCheckUI()
  {
    AppMethodBeat.i(21043);
    this.mMF = true;
    this.mNZ = 1;
    this.mOa = 2;
    this.mOc = new int[] { 2130838890, 2130838891, 2130838892, 2130838893, 2130838894 };
    this.mOd = new FreeWifiNetCheckUI.1(this);
    AppMethodBeat.o(21043);
  }
  
  private void bBF()
  {
    AppMethodBeat.i(21047);
    if (bo.isNullOrNil(this.key))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      finish();
      AppMethodBeat.o(21047);
      return;
    }
    this.mOk = new b(this, this.key, this.cCy);
    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(this.intent)), this.key, Integer.valueOf(this.cCy) });
    this.mOk.connect();
    AppMethodBeat.o(21047);
  }
  
  public void finish()
  {
    AppMethodBeat.i(21044);
    if (this.caS != null) {
      this.caS.stopTimer();
    }
    this.mOd.sendEmptyMessage(2);
    super.finish();
    AppMethodBeat.o(21044);
  }
  
  public int getLayoutId()
  {
    return 2130969631;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21045);
    super.onCreate(paramBundle);
    setMMTitle(2131300181);
    setBackBtn(new FreeWifiNetCheckUI.2(this));
    this.intent = getIntent();
    m.T(this.intent);
    this.key = getIntent().getStringExtra("free_wifi_ap_key");
    this.scene = getIntent().getIntExtra("free_wifi_source", 1);
    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", new Object[] { m.U(this.intent), Integer.valueOf(m.V(this.intent)), this.key, com.tencent.mm.plugin.freewifi.model.d.bAC() });
    this.mNW = ((ImageView)findViewById(2131824254));
    this.caS = new ap(new FreeWifiNetCheckUI.3(this), true);
    this.caS.ag(200L, 200L);
    AppMethodBeat.o(21045);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21048);
    super.onDestroy();
    if (this.mOk != null) {
      this.mOk = null;
    }
    this.caS.stopTimer();
    AppMethodBeat.o(21048);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21049);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      finish();
      AppMethodBeat.o(21049);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21049);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(21050);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(21050);
      return;
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21050);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.mMF = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new FreeWifiNetCheckUI.7(this), new FreeWifiNetCheckUI.8(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21046);
    super.onResume();
    int i;
    if (this.mMF)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = 0;
      }
    }
    while (i == 0)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "check permission not passed!");
      AppMethodBeat.o(21046);
      return;
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        i = 0;
      }
      else if (!com.tencent.mm.modelgeo.d.agR())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131300538), getString(2131297087), getString(2131300996), getString(2131296888), false, new FreeWifiNetCheckUI.4(this), null);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    switch (this.scene)
    {
    case 2: 
    case 3: 
    default: 
      ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
      finish();
    }
    for (;;)
    {
      ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(this.intent)), Integer.valueOf(this.cCy) });
      AppMethodBeat.o(21046);
      return;
      Object localObject1 = getIntent().getStringExtra("free_wifi_jsapi_param_type");
      if ("1".equals(localObject1))
      {
        getIntent().putExtra("free_wifi_channel_id", 9);
        this.cCy = 9;
      }
      for (;;)
      {
        localObject1 = getIntent().getStringExtra("free_wifi_jsapi_param_type");
        if ((!((String)localObject1).equals("0")) || (!bo.isNullOrNil(this.key))) {
          break label390;
        }
        ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
        finish();
        break;
        if ("0".equals(localObject1))
        {
          getIntent().putExtra("free_wifi_channel_id", 8);
          this.cCy = 8;
        }
        else
        {
          getIntent().putExtra("free_wifi_channel_id", 4);
          this.cCy = 4;
        }
      }
      label390:
      if (((String)localObject1).equals("0"))
      {
        bBF();
      }
      else if (((String)localObject1).equals("1"))
      {
        localObject1 = getIntent().getStringExtra("free_wifi_jsapi_param_username");
        if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled()) {
          com.tencent.mm.plugin.freewifi.model.d.bAx();
        }
        h.b.bAH().a(new FreeWifiNetCheckUI.6(this, (String)localObject1));
      }
      else
      {
        ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
        finish();
        continue;
        this.cCy = getIntent().getIntExtra("free_wifi_channel_id", 1);
        if (bo.isNullOrNil(this.key))
        {
          ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
          finish();
        }
        else
        {
          bBF();
          continue;
          getIntent().putExtra("free_wifi_channel_id", 2);
          this.cCy = 2;
          if (bo.isNullOrNil(this.key))
          {
            ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
          }
          else
          {
            Object localObject3 = "";
            for (;;)
            {
              try
              {
                localObject1 = Uri.parse(this.key);
              }
              catch (Exception localException1)
              {
                try
                {
                  String str = ((Uri)localObject1).getQueryParameter("q");
                  localObject3 = str;
                  if (!"pc".equalsIgnoreCase((String)localObject3)) {
                    break label782;
                  }
                  localObject3 = ((Uri)localObject1).getQueryParameter("appid");
                  str = ((Uri)localObject1).getQueryParameter("shopid");
                  localObject1 = ((Uri)localObject1).getQueryParameter("ticket");
                  m.d(getIntent(), (String)localObject1);
                  k.a locala = k.bAc();
                  locala.mIB = str;
                  locala.mIC = ((String)localObject3);
                  locala.kMp = ((String)localObject1);
                  locala.mIF = k.b.mJk.mJq;
                  locala.mIG = k.b.mJk.name;
                  locala.bAe().bAd();
                  ab.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", new Object[] { m.U(getIntent()), Integer.valueOf(m.V(getIntent())), str, localObject3, localObject1 });
                  new com.tencent.mm.plugin.freewifi.d.h((String)localObject3, Integer.valueOf(str).intValue(), (String)localObject1).c(new FreeWifiNetCheckUI.5(this, str, (String)localObject1, (String)localObject3));
                }
                catch (Exception localException2)
                {
                  Object localObject2;
                  break label775;
                }
                localException1 = localException1;
                localObject2 = null;
              }
              label775:
              finish();
            }
            label782:
            "_test".equals(localObject3);
            bBF();
            continue;
            getIntent().putExtra("free_wifi_channel_id", 10);
            this.cCy = 10;
            if (bo.isNullOrNil(this.key))
            {
              ab.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
              finish();
            }
            else
            {
              bBF();
            }
          }
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI
 * JD-Core Version:    0.7.0.1
 */