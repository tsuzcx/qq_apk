package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.h.a;
import com.tencent.mm.plugin.freewifi.model.h.b;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FreeWifiNetCheckUI
  extends MMActivity
{
  private int channel;
  private Intent intent;
  private String key;
  private boolean rHi;
  private int scene;
  private MTimerHandler timer;
  ImageView wSb;
  private final int wSe;
  private final int wSf;
  private int[] wSh;
  MMHandler wSi;
  private a wSp;
  
  public FreeWifiNetCheckUI()
  {
    AppMethodBeat.i(25102);
    this.rHi = true;
    this.wSe = 1;
    this.wSf = 2;
    this.wSh = new int[] { 2131232810, 2131232811, 2131232812, 2131232813, 2131232814 };
    this.wSi = new MMHandler()
    {
      int i = 0;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25093);
        if (paramAnonymousMessage.what == 1)
        {
          if (this.i >= FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this).length) {
            this.i = 0;
          }
          FreeWifiNetCheckUI.this.wSb.setImageResource(FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this)[this.i]);
          this.i += 1;
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(25093);
          return;
          if (paramAnonymousMessage.what == 2) {
            FreeWifiNetCheckUI.this.wSb.setImageResource(FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this)[(FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this).length - 1)]);
          }
        }
      }
    };
    AppMethodBeat.o(25102);
  }
  
  private void dOh()
  {
    AppMethodBeat.i(25106);
    if (Util.isNullOrNil(this.key))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      finish();
      AppMethodBeat.o(25106);
      return;
    }
    this.wSp = new a(this, this.key, this.channel);
    Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", new Object[] { m.aw(getIntent()), Integer.valueOf(m.ax(this.intent)), this.key, Integer.valueOf(this.channel) });
    this.wSp.connect();
    AppMethodBeat.o(25106);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25103);
    if (this.timer != null) {
      this.timer.stopTimer();
    }
    this.wSi.sendEmptyMessage(2);
    super.finish();
    AppMethodBeat.o(25103);
  }
  
  public int getLayoutId()
  {
    return 2131494727;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25104);
    super.onCreate(paramBundle);
    setMMTitle(2131760974);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25094);
        FreeWifiNetCheckUI.this.finish();
        AppMethodBeat.o(25094);
        return true;
      }
    });
    this.intent = getIntent();
    m.av(this.intent);
    this.key = getIntent().getStringExtra("free_wifi_ap_key");
    this.scene = getIntent().getIntExtra("free_wifi_source", 1);
    Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", new Object[] { m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.key, com.tencent.mm.plugin.freewifi.model.d.dNf() });
    this.wSb = ((ImageView)findViewById(2131301725));
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25095);
        FreeWifiNetCheckUI.this.wSi.sendEmptyMessage(1);
        AppMethodBeat.o(25095);
        return true;
      }
    }, true);
    this.timer.startTimer(200L);
    AppMethodBeat.o(25104);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25107);
    super.onDestroy();
    if (this.wSp != null) {
      this.wSp = null;
    }
    this.timer.stopTimer();
    AppMethodBeat.o(25107);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25108);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      finish();
      AppMethodBeat.o(25108);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25108);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25109);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25109);
      return;
    }
    Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25109);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.rHi = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25100);
            paramAnonymousDialogInterface = FreeWifiNetCheckUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            FreeWifiNetCheckUI.this.finish();
            AppMethodBeat.o(25100);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25101);
            FreeWifiNetCheckUI.this.finish();
            AppMethodBeat.o(25101);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25105);
    super.onResume();
    int i;
    if (this.rHi)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_FINE_LOCATION", 77, null, null);
      Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = 0;
      }
    }
    while (i == 0)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "check permission not passed!");
      AppMethodBeat.o(25105);
      return;
      if (!b.n(this, "android.permission.ACCESS_FINE_LOCATION"))
      {
        i = 0;
      }
      else if (!com.tencent.mm.modelgeo.d.bcc())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131761461), getString(2131755998), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25096);
            com.tencent.mm.modelgeo.d.cZ(FreeWifiNetCheckUI.this);
            AppMethodBeat.o(25096);
          }
        }, null);
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
      Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
      finish();
    }
    label773:
    for (;;)
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", new Object[] { m.aw(getIntent()), Integer.valueOf(m.ax(this.intent)), Integer.valueOf(this.channel) });
      AppMethodBeat.o(25105);
      return;
      Object localObject1 = getIntent().getStringExtra("free_wifi_jsapi_param_type");
      if ("1".equals(localObject1))
      {
        getIntent().putExtra("free_wifi_channel_id", 9);
        this.channel = 9;
      }
      for (;;)
      {
        localObject1 = getIntent().getStringExtra("free_wifi_jsapi_param_type");
        if ((!((String)localObject1).equals("0")) || (!Util.isNullOrNil(this.key))) {
          break label390;
        }
        Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
        finish();
        break;
        if ("0".equals(localObject1))
        {
          getIntent().putExtra("free_wifi_channel_id", 8);
          this.channel = 8;
        }
        else
        {
          getIntent().putExtra("free_wifi_channel_id", 4);
          this.channel = 4;
        }
      }
      label390:
      if (((String)localObject1).equals("0"))
      {
        dOh();
      }
      else if (((String)localObject1).equals("1"))
      {
        localObject1 = getIntent().getStringExtra("free_wifi_jsapi_param_username");
        if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled()) {
          com.tencent.mm.plugin.freewifi.model.d.dNa();
        }
        h.b.dNk().a(new h.a()
        {
          public final void eM(List<ScanResult> paramAnonymousList)
          {
            AppMethodBeat.i(25099);
            if ((paramAnonymousList == null) || (paramAnonymousList.size() == 0))
            {
              FreeWifiNetCheckUI.this.finish();
              FreeWifiNetCheckUI.c(FreeWifiNetCheckUI.this);
              AppMethodBeat.o(25099);
              return;
            }
            dqu localdqu = new dqu();
            localdqu.MTD = new LinkedList();
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              ScanResult localScanResult = (ScanResult)paramAnonymousList.next();
              if (localScanResult != null)
              {
                ei localei = new ei();
                localei.mac = localScanResult.BSSID;
                localei.gNm = localScanResult.level;
                localei.ssid = localScanResult.SSID;
                localdqu.MTD.add(localei);
              }
            }
            paramAnonymousList = com.tencent.mm.plugin.freewifi.k.dMF();
            paramAnonymousList.quX = m.aw(FreeWifiNetCheckUI.b(FreeWifiNetCheckUI.this));
            paramAnonymousList.wNd = k.b.wNv.wNO;
            paramAnonymousList.wNe = k.b.wNv.name;
            paramAnonymousList.channel = 9;
            paramAnonymousList.dMH().dMG();
            new com.tencent.mm.plugin.freewifi.d.k(this.wPn, localdqu, 9, m.aw(FreeWifiNetCheckUI.this.getIntent())).c(new i()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
              {
                AppMethodBeat.i(25098);
                paramAnonymous2String = ((com.tencent.mm.plugin.freewifi.d.k)paramAnonymous2q).dNG();
                if (!Util.isNullOrNil(paramAnonymous2String))
                {
                  FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this, paramAnonymous2String);
                  FreeWifiNetCheckUI.this.getIntent().putExtra("free_wifi_ap_key", paramAnonymous2String);
                  FreeWifiNetCheckUI.d(FreeWifiNetCheckUI.this);
                  FreeWifiNetCheckUI.e(FreeWifiNetCheckUI.this);
                  AppMethodBeat.o(25098);
                  return;
                }
                FreeWifiNetCheckUI.this.finish();
                FreeWifiNetCheckUI.c(FreeWifiNetCheckUI.this);
                AppMethodBeat.o(25098);
              }
            });
            AppMethodBeat.o(25099);
          }
        });
      }
      else
      {
        Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
        finish();
        continue;
        this.channel = getIntent().getIntExtra("free_wifi_channel_id", 1);
        if (Util.isNullOrNil(this.key))
        {
          Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
          finish();
        }
        else
        {
          dOh();
          continue;
          getIntent().putExtra("free_wifi_channel_id", 2);
          this.channel = 2;
          if (Util.isNullOrNil(this.key))
          {
            Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
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
                  final String str = ((Uri)localObject1).getQueryParameter("q");
                  localObject3 = str;
                  if (!"pc".equalsIgnoreCase((String)localObject3)) {
                    break label780;
                  }
                  localObject3 = ((Uri)localObject1).getQueryParameter("appid");
                  str = ((Uri)localObject1).getQueryParameter("shopid");
                  localObject1 = ((Uri)localObject1).getQueryParameter("ticket");
                  m.f(getIntent(), (String)localObject1);
                  k.a locala = com.tencent.mm.plugin.freewifi.k.dMF();
                  locala.wNa = str;
                  locala.wNb = ((String)localObject3);
                  locala.quX = ((String)localObject1);
                  locala.wNd = k.b.wNI.wNO;
                  locala.wNe = k.b.wNI.name;
                  locala.dMH().dMG();
                  Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", new Object[] { m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), str, localObject3, localObject1 });
                  new com.tencent.mm.plugin.freewifi.d.h((String)localObject3, Util.getInt(str, 0), (String)localObject1).c(new i()
                  {
                    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
                    {
                      AppMethodBeat.i(25097);
                      if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                      {
                        paramAnonymousq = ((com.tencent.mm.plugin.freewifi.d.h)paramAnonymousq).dNy();
                        if (paramAnonymousq != null)
                        {
                          paramAnonymousString = FreeWifiNetCheckUI.this.getIntent();
                          paramAnonymousString.putExtra("free_wifi_appid", paramAnonymousq.KGX);
                          paramAnonymousString.putExtra("free_wifi_head_img_url", paramAnonymousq.xJE);
                          paramAnonymousString.putExtra("free_wifi_welcome_msg", paramAnonymousq.LPm);
                          paramAnonymousString.putExtra("free_wifi_welcome_sub_title", paramAnonymousq.LPo);
                          paramAnonymousString.putExtra("free_wifi_privacy_url", paramAnonymousq.LPn);
                          paramAnonymousString.putExtra("free_wifi_app_nickname", paramAnonymousq.oUJ);
                          paramAnonymousString.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", str);
                          paramAnonymousString.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", this.wSs);
                          paramAnonymousString.setClass(FreeWifiNetCheckUI.this, FreeWifiPcUI.class);
                          FreeWifiNetCheckUI.this.finish();
                          paramAnonymousq = FreeWifiNetCheckUI.this;
                          paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousString);
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, paramAnonymousString.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI$5", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          paramAnonymousq.startActivity((Intent)paramAnonymousString.pG(0));
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousq, "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI$5", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                      }
                      for (;;)
                      {
                        paramAnonymousString = com.tencent.mm.plugin.freewifi.k.dMF();
                        paramAnonymousString.wNa = str;
                        paramAnonymousString.wNb = this.kFU;
                        paramAnonymousString.quX = this.wSs;
                        paramAnonymousString.wNd = k.b.wNJ.wNO;
                        paramAnonymousString.wNe = k.b.wNJ.name;
                        paramAnonymousString.result = paramAnonymousInt2;
                        paramAnonymousString.dMH().dMG();
                        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", new Object[] { m.aw(FreeWifiNetCheckUI.this.getIntent()), Integer.valueOf(m.ax(FreeWifiNetCheckUI.this.getIntent())), Integer.valueOf(paramAnonymousInt2) });
                        AppMethodBeat.o(25097);
                        return;
                        if ((m.gC(paramAnonymousInt1, paramAnonymousInt2)) && (!m.eP(paramAnonymousString))) {
                          FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this, paramAnonymousString + "(" + m.a(m.ay(FreeWifiNetCheckUI.b(FreeWifiNetCheckUI.this)), k.b.wNJ, paramAnonymousInt2) + ")", "");
                        } else {
                          FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this, FreeWifiNetCheckUI.this.getString(2131760940), FreeWifiNetCheckUI.this.getString(2131760941));
                        }
                      }
                    }
                  });
                }
                catch (Exception localException2)
                {
                  Object localObject2;
                  break label773;
                }
                localException1 = localException1;
                localObject2 = null;
              }
              finish();
            }
            label780:
            "_test".equals(localObject3);
            dOh();
            continue;
            getIntent().putExtra("free_wifi_channel_id", 10);
            this.channel = 10;
            if (Util.isNullOrNil(this.key))
            {
              Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
              finish();
            }
            else
            {
              dOh();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI
 * JD-Core Version:    0.7.0.1
 */