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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.h.a;
import com.tencent.mm.plugin.freewifi.model.h.b;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FreeWifiNetCheckUI
  extends MMActivity
{
  private av cXg;
  private int channel;
  private Intent intent;
  private String key;
  private boolean qjw;
  private int scene;
  ImageView tqj;
  private final int tqm;
  private final int tqn;
  private int[] tqp;
  ap tqq;
  private a tqx;
  
  public FreeWifiNetCheckUI()
  {
    AppMethodBeat.i(25102);
    this.qjw = true;
    this.tqm = 1;
    this.tqn = 2;
    this.tqp = new int[] { 2131232429, 2131232430, 2131232431, 2131232432, 2131232433 };
    this.tqq = new ap()
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
          FreeWifiNetCheckUI.this.tqj.setImageResource(FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this)[this.i]);
          this.i += 1;
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(25093);
          return;
          if (paramAnonymousMessage.what == 2) {
            FreeWifiNetCheckUI.this.tqj.setImageResource(FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this)[(FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this).length - 1)]);
          }
        }
      }
    };
    AppMethodBeat.o(25102);
  }
  
  private void cSt()
  {
    AppMethodBeat.i(25106);
    if (bt.isNullOrNil(this.key))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
      finish();
      AppMethodBeat.o(25106);
      return;
    }
    this.tqx = new a(this, this.key, this.channel);
    ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", new Object[] { m.ao(getIntent()), Integer.valueOf(m.ap(this.intent)), this.key, Integer.valueOf(this.channel) });
    this.tqx.connect();
    AppMethodBeat.o(25106);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25103);
    if (this.cXg != null) {
      this.cXg.stopTimer();
    }
    this.tqq.sendEmptyMessage(2);
    super.finish();
    AppMethodBeat.o(25103);
  }
  
  public int getLayoutId()
  {
    return 2131494173;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25104);
    super.onCreate(paramBundle);
    setMMTitle(2131759653);
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
    m.an(this.intent);
    this.key = getIntent().getStringExtra("free_wifi_ap_key");
    this.scene = getIntent().getIntExtra("free_wifi_source", 1);
    ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", new Object[] { m.ao(this.intent), Integer.valueOf(m.ap(this.intent)), this.key, com.tencent.mm.plugin.freewifi.model.d.cRr() });
    this.tqj = ((ImageView)findViewById(2131300246));
    this.cXg = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(25095);
        FreeWifiNetCheckUI.this.tqq.sendEmptyMessage(1);
        AppMethodBeat.o(25095);
        return true;
      }
    }, true);
    this.cXg.az(200L, 200L);
    AppMethodBeat.o(25104);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25107);
    super.onDestroy();
    if (this.tqx != null) {
      this.tqx = null;
    }
    this.cXg.stopTimer();
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
      ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25109);
      return;
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25109);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.qjw = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25100);
            paramAnonymousDialogInterface = FreeWifiNetCheckUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    if (this.qjw)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
      ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        i = 0;
      }
    }
    while (i == 0)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "check permission not passed!");
      AppMethodBeat.o(25105);
      return;
      if (!b.n(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        i = 0;
      }
      else if (!com.tencent.mm.modelgeo.d.aHR())
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25096);
            com.tencent.mm.modelgeo.d.cB(FreeWifiNetCheckUI.this);
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
      ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
      finish();
    }
    label773:
    for (;;)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", new Object[] { m.ao(getIntent()), Integer.valueOf(m.ap(this.intent)), Integer.valueOf(this.channel) });
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
        if ((!((String)localObject1).equals("0")) || (!bt.isNullOrNil(this.key))) {
          break label390;
        }
        ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
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
        cSt();
      }
      else if (((String)localObject1).equals("1"))
      {
        localObject1 = getIntent().getStringExtra("free_wifi_jsapi_param_username");
        if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled()) {
          com.tencent.mm.plugin.freewifi.model.d.cRm();
        }
        h.b.cRw().a(new h.a()
        {
          public final void dQ(List<ScanResult> paramAnonymousList)
          {
            AppMethodBeat.i(25099);
            if ((paramAnonymousList == null) || (paramAnonymousList.size() == 0))
            {
              FreeWifiNetCheckUI.this.finish();
              FreeWifiNetCheckUI.c(FreeWifiNetCheckUI.this);
              AppMethodBeat.o(25099);
              return;
            }
            cxf localcxf = new cxf();
            localcxf.HoQ = new LinkedList();
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              ScanResult localScanResult = (ScanResult)paramAnonymousList.next();
              if (localScanResult != null)
              {
                dw localdw = new dw();
                localdw.mac = localScanResult.BSSID;
                localdw.gfo = localScanResult.level;
                localdw.ssid = localScanResult.SSID;
                localcxf.HoQ.add(localdw);
              }
            }
            paramAnonymousList = com.tencent.mm.plugin.freewifi.k.cQR();
            paramAnonymousList.oZp = m.ao(FreeWifiNetCheckUI.b(FreeWifiNetCheckUI.this));
            paramAnonymousList.tlh = k.b.tlz.tlS;
            paramAnonymousList.tli = k.b.tlz.name;
            paramAnonymousList.channel = 9;
            paramAnonymousList.cQT().cQS();
            new com.tencent.mm.plugin.freewifi.d.k(this.tns, localcxf, 9, m.ao(FreeWifiNetCheckUI.this.getIntent())).c(new f()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(25098);
                paramAnonymous2String = ((com.tencent.mm.plugin.freewifi.d.k)paramAnonymous2n).cRS();
                if (!bt.isNullOrNil(paramAnonymous2String))
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
        ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
        finish();
        continue;
        this.channel = getIntent().getIntExtra("free_wifi_channel_id", 1);
        if (bt.isNullOrNil(this.key))
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
          finish();
        }
        else
        {
          cSt();
          continue;
          getIntent().putExtra("free_wifi_channel_id", 2);
          this.channel = 2;
          if (bt.isNullOrNil(this.key))
          {
            ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
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
                  m.e(getIntent(), (String)localObject1);
                  k.a locala = com.tencent.mm.plugin.freewifi.k.cQR();
                  locala.tle = str;
                  locala.tlf = ((String)localObject3);
                  locala.oZp = ((String)localObject1);
                  locala.tlh = k.b.tlM.tlS;
                  locala.tli = k.b.tlM.name;
                  locala.cQT().cQS();
                  ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", new Object[] { m.ao(getIntent()), Integer.valueOf(m.ap(getIntent())), str, localObject3, localObject1 });
                  new com.tencent.mm.plugin.freewifi.d.h((String)localObject3, bt.getInt(str, 0), (String)localObject1).c(new f()
                  {
                    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
                    {
                      AppMethodBeat.i(25097);
                      if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                      {
                        paramAnonymousn = ((com.tencent.mm.plugin.freewifi.d.h)paramAnonymousn).cRK();
                        if (paramAnonymousn != null)
                        {
                          paramAnonymousString = FreeWifiNetCheckUI.this.getIntent();
                          paramAnonymousString.putExtra("free_wifi_appid", paramAnonymousn.FuU);
                          paramAnonymousString.putExtra("free_wifi_head_img_url", paramAnonymousn.ufR);
                          paramAnonymousString.putExtra("free_wifi_welcome_msg", paramAnonymousn.GrK);
                          paramAnonymousString.putExtra("free_wifi_welcome_sub_title", paramAnonymousn.GrM);
                          paramAnonymousString.putExtra("free_wifi_privacy_url", paramAnonymousn.GrL);
                          paramAnonymousString.putExtra("free_wifi_app_nickname", paramAnonymousn.nEt);
                          paramAnonymousString.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", str);
                          paramAnonymousString.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", this.tqA);
                          paramAnonymousString.setClass(FreeWifiNetCheckUI.this, FreeWifiPcUI.class);
                          FreeWifiNetCheckUI.this.finish();
                          paramAnonymousn = FreeWifiNetCheckUI.this;
                          paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousString);
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, paramAnonymousString.ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI$5", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          paramAnonymousn.startActivity((Intent)paramAnonymousString.mq(0));
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousn, "com/tencent/mm/plugin/freewifi/ui/FreeWifiNetCheckUI$5", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                      }
                      for (;;)
                      {
                        paramAnonymousString = com.tencent.mm.plugin.freewifi.k.cQR();
                        paramAnonymousString.tle = str;
                        paramAnonymousString.tlf = this.jBr;
                        paramAnonymousString.oZp = this.tqA;
                        paramAnonymousString.tlh = k.b.tlN.tlS;
                        paramAnonymousString.tli = k.b.tlN.name;
                        paramAnonymousString.result = paramAnonymousInt2;
                        paramAnonymousString.cQT().cQS();
                        ad.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", new Object[] { m.ao(FreeWifiNetCheckUI.this.getIntent()), Integer.valueOf(m.ap(FreeWifiNetCheckUI.this.getIntent())), Integer.valueOf(paramAnonymousInt2) });
                        AppMethodBeat.o(25097);
                        return;
                        if ((m.gd(paramAnonymousInt1, paramAnonymousInt2)) && (!m.ea(paramAnonymousString))) {
                          FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this, paramAnonymousString + "(" + m.a(m.aq(FreeWifiNetCheckUI.b(FreeWifiNetCheckUI.this)), k.b.tlN, paramAnonymousInt2) + ")", "");
                        } else {
                          FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this, FreeWifiNetCheckUI.this.getString(2131759619), FreeWifiNetCheckUI.this.getString(2131759620));
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
            cSt();
            continue;
            getIntent().putExtra("free_wifi_channel_id", 10);
            this.channel = 10;
            if (bt.isNullOrNil(this.key))
            {
              ad.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
              finish();
            }
            else
            {
              cSt();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI
 * JD-Core Version:    0.7.0.1
 */