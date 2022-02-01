package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public abstract class FreeWifiStateUI
  extends MMActivity
  implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b
{
  protected int cSc;
  protected String dmM;
  protected int dnh;
  private int dpw = 1;
  protected String dtE;
  protected String duW;
  protected String hDQ;
  private final com.tencent.mm.aw.a.a.c idd;
  protected String omw;
  protected String signature;
  protected String ssid;
  protected String tnF;
  protected String toV;
  protected FreeWifiNetworkReceiver toW;
  protected boolean toX = false;
  private av toZ = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25130);
      if (!bt.isNullOrNil(FreeWifiStateUI.this.ssid))
      {
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.cSb());
        ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[] { FreeWifiStateUI.this.ssid, Integer.valueOf(FreeWifiStateUI.a(FreeWifiStateUI.this)) });
        FreeWifiStateUI.b(FreeWifiStateUI.this).stopTimer();
        com.tencent.mm.plugin.freewifi.k.a locala = k.cQR();
        locala.ssid = FreeWifiStateUI.this.ssid;
        locala.dmM = FreeWifiStateUI.this.dmM;
        locala.oZp = com.tencent.mm.plugin.freewifi.m.ao(FreeWifiStateUI.this.getIntent());
        locala.tlg = com.tencent.mm.plugin.freewifi.m.aq(FreeWifiStateUI.this.getIntent());
        locala.tlh = k.b.tls.tlS;
        locala.tli = k.b.tls.name;
        locala.result = -16;
        locala.channel = com.tencent.mm.plugin.freewifi.m.ar(FreeWifiStateUI.this.getIntent());
        locala.tlf = FreeWifiStateUI.this.duW;
        locala.tlj = FreeWifiStateUI.this.dtE;
        locala.cQT().cQS();
        if (FreeWifiStateUI.a(FreeWifiStateUI.this) != 2)
        {
          FreeWifiStateUI.this.cSf();
          FreeWifiStateUI.this.cSd();
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 3, FreeWifiStateUI.this.getIntent());
        }
      }
      AppMethodBeat.o(25130);
      return false;
    }
  }, false);
  private ImageView tpD;
  private TextView tpE;
  private TextView tpF;
  private Button tpG;
  private Button tpH;
  protected String tpK;
  protected String tpL;
  protected String tpM;
  private av tpa = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(25131);
      if (com.tencent.mm.plugin.freewifi.model.d.ajQ(FreeWifiStateUI.this.ssid))
      {
        FreeWifiStateUI.this.a(NetworkInfo.State.CONNECTED);
        FreeWifiStateUI.b(FreeWifiStateUI.this).stopTimer();
        AppMethodBeat.o(25131);
        return false;
      }
      AppMethodBeat.o(25131);
      return true;
    }
  }, true);
  private com.tencent.mm.sdk.e.k.a tpb;
  private TextView tpo;
  private p tqG = null;
  protected int tqL;
  protected String tqM;
  protected String tqN;
  
  public FreeWifiStateUI()
  {
    c.a locala = new c.a();
    locala.idp = true;
    locala.idq = true;
    locala.idD = 2131232428;
    locala.hfi = true;
    locala.idK = 0.0F;
    this.idd = locala.aJc();
    this.tpb = new com.tencent.mm.sdk.e.k.a()
    {
      private int tqP = -999999999;
      
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(25132);
        FreeWifiStateUI.a(FreeWifiStateUI.this, FreeWifiStateUI.this.cSb());
        if (this.tqP != FreeWifiStateUI.a(FreeWifiStateUI.this))
        {
          this.tqP = FreeWifiStateUI.a(FreeWifiStateUI.this);
          FreeWifiStateUI.this.CH(FreeWifiStateUI.a(FreeWifiStateUI.this));
        }
        AppMethodBeat.o(25132);
      }
    };
  }
  
  private void cSg()
  {
    this.toW = new FreeWifiNetworkReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.toW, localIntentFilter);
  }
  
  private void goBack()
  {
    l.R(com.tencent.mm.plugin.freewifi.model.d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Intent localIntent = new Intent();
    g.iRG.h(localIntent, this);
    finish();
  }
  
  protected final void CH(int paramInt)
  {
    ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      if (this.tqG != null) {
        this.tqG.dismiss();
      }
      this.tpo.setVisibility(4);
      this.tpG.setText(2131757574);
      if (this.dnh == 3) {
        this.tpF.setText(getString(2131761229, new Object[] { this.ssid }));
      }
      break;
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.duW))
      {
        if (!bt.isNullOrNil(this.tpK)) {
          this.tpE.setText(this.tpK);
        }
        if (!bt.isNullOrNil(this.hDQ)) {
          q.aIJ().a(this.hDQ, this.tpD, this.idd);
        }
      }
      label448:
      for (;;)
      {
        return;
        if (this.tqG != null) {
          this.tqG.dismiss();
        }
        this.toZ.stopTimer();
        this.tpa.stopTimer();
        this.toX = false;
        this.tpo.setVisibility(4);
        this.tpG.setText(2131757574);
        if ((com.tencent.mm.plugin.freewifi.m.ar(getIntent()) == 10) && (!com.tencent.mm.plugin.freewifi.m.ea(ae.gcJ.gbU)) && (!com.tencent.mm.plugin.freewifi.m.ea(ae.bX(getContext())))) {
          this.tpG.setText(String.format(getString(2131759610), new Object[] { ae.bX(getContext()) }));
        }
        if (this.dnh == 3) {
          this.tpF.setText(getString(2131761229, new Object[] { this.ssid }));
        }
        for (;;)
        {
          if (bt.isNullOrNil(this.duW)) {
            break label448;
          }
          if (!bt.isNullOrNil(this.tpK)) {
            this.tpE.setText(this.tpK);
          }
          if (bt.isNullOrNil(this.hDQ)) {
            break;
          }
          q.aIJ().a(this.hDQ, this.tpD, this.idd);
          return;
          if (bt.isNullOrNil(this.tpL)) {
            this.tpF.setText(getString(2131757570));
          } else {
            this.tpF.setText(this.tpL);
          }
        }
      }
      if (this.tqG != null) {
        this.tqG.dismiss();
      }
      this.toZ.stopTimer();
      this.tpa.stopTimer();
      this.tpo.setVisibility(0);
      this.tpG.setText(2131759649);
      return;
      if (this.tqG != null) {
        this.tqG.dismiss();
      }
      this.toZ.stopTimer();
      this.tpa.stopTimer();
      this.tpG.setText(2131757568);
      this.tpG.setClickable(false);
      Object localObject = getIntent();
      ((Intent)localObject).putExtra("free_wifi_appid", this.duW);
      ((Intent)localObject).putExtra("free_wifi_app_nickname", this.tnF);
      ((Intent)localObject).putExtra("free_wifi_app_username", this.dtE);
      ((Intent)localObject).putExtra("free_wifi_signature", this.signature);
      ((Intent)localObject).putExtra("free_wifi_finish_actioncode", this.tqL);
      ((Intent)localObject).putExtra("free_wifi_finish_url", this.tqM);
      if (bt.isNullOrNil(this.tqN)) {
        ((Intent)localObject).setClass(this, FreeWifiSuccUI.class);
      }
      for (;;)
      {
        finish();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        c.report();
        return;
        ((Intent)localObject).putExtra("free_wifi_qinghuai_url", this.tqN);
        ((Intent)localObject).setClass(this, FreeWifiSuccWebViewUI.class);
      }
      this.tpo.setVisibility(4);
      this.tpG.setText(2131757571);
      this.tqG = h.b(getContext(), getString(2131757571), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25138);
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 4, FreeWifiStateUI.this.getIntent());
          AppMethodBeat.o(25138);
        }
      });
      return;
      if (this.tqG != null) {
        this.tqG.dismiss();
      }
      this.toZ.stopTimer();
      this.tpa.stopTimer();
      this.tpo.setVisibility(0);
      this.tpG.setText(2131759649);
      return;
      if (bt.isNullOrNil(this.tpL)) {
        this.tpF.setText(getString(2131757570));
      } else {
        this.tpF.setText(this.tpL);
      }
    }
  }
  
  public final void GJ(int paramInt)
  {
    ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    default: 
      return;
    }
    cSd();
    cSh();
  }
  
  public abstract void a(NetworkInfo.State paramState);
  
  protected abstract void aTT();
  
  protected abstract void cSa();
  
  protected abstract int cSb();
  
  protected final void cSd()
  {
    if (this.toW != null)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
      this.toW.tmW = null;
    }
  }
  
  protected final void cSe()
  {
    if (this.toW == null) {
      cSg();
    }
    this.toW.tmX = this;
  }
  
  protected final void cSf()
  {
    if (this.toW != null)
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
      this.toW.tmX = null;
    }
  }
  
  protected final void cSh()
  {
    if (!com.tencent.mm.plugin.freewifi.model.d.isWifiEnabled())
    {
      this.toZ.az(60000L, 60000L);
      this.tpa.az(1000L, 1000L);
      ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
      j.cRC().cRl().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25136);
          FreeWifiStateUI.d(FreeWifiStateUI.this);
          AppMethodBeat.o(25136);
        }
      });
      return;
    }
    this.dpw = cSb();
    ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", new Object[] { Integer.valueOf(this.dpw) });
    if (this.dpw != 2)
    {
      if (com.tencent.mm.plugin.freewifi.m.aq(getIntent()) == 4) {
        this.toZ.az(30000L, 30000L);
      }
      for (;;)
      {
        this.tpa.az(1000L, 1000L);
        if (!com.tencent.mm.plugin.freewifi.model.d.ajQ(this.ssid)) {
          break label234;
        }
        ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", new Object[] { Boolean.valueOf(this.toX) });
        if (!this.toX) {
          break;
        }
        ad.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
        return;
        this.toZ.az(60000L, 60000L);
      }
      this.toZ.az(60000L, 60000L);
      this.tpa.az(1000L, 1000L);
      aTT();
      this.toX = true;
      return;
      label234:
      j.cRC().cRl().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25137);
          ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[] { FreeWifiStateUI.this.ssid });
          FreeWifiStateUI.this.cSa();
          AppMethodBeat.o(25137);
        }
      });
      return;
    }
    com.tencent.mm.plugin.freewifi.model.d.a(this.ssid, this.dpw, getIntent());
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494170;
  }
  
  public void initView()
  {
    setBackBtn(new FreeWifiStateUI.4(this));
    if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
      findViewById(2131306245).setVisibility(0);
    }
    this.tpD = ((ImageView)findViewById(2131300246));
    this.tpE = ((TextView)findViewById(2131300289));
    this.tpF = ((TextView)findViewById(2131300275));
    this.tpo = ((TextView)findViewById(2131300253));
    this.tpG = ((Button)findViewById(2131298576));
    this.tpG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25134);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        l.Q(com.tencent.mm.plugin.freewifi.model.d.cRq(), FreeWifiStateUI.this.getIntent().getStringExtra("free_wifi_ap_key"), FreeWifiStateUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
        if (FreeWifiStateUI.this.cSb() == 2) {
          FreeWifiStateUI.this.finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25134);
          return;
          com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiStateUI.this.ssid, 1, FreeWifiStateUI.this.getIntent());
          FreeWifiStateUI.this.toX = false;
          FreeWifiStateUI.this.cSh();
        }
      }
    });
    this.tpH = ((Button)findViewById(2131306246));
    this.tpH.setOnClickListener(new FreeWifiStateUI.6(this));
    if (bt.isNullOrNil(this.ssid))
    {
      this.tpF.setText(getString(2131759651));
      this.tpG.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dmM = getIntent().getStringExtra("free_wifi_ap_key");
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.toV = getIntent().getStringExtra("free_wifi_mid");
    this.omw = getIntent().getStringExtra("free_wifi_url");
    this.dnh = getIntent().getIntExtra("free_wifi_source", 1);
    this.cSc = getIntent().getIntExtra("free_wifi_channel_id", 0);
    this.duW = getIntent().getStringExtra("free_wifi_appid");
    this.hDQ = getIntent().getStringExtra("free_wifi_head_img_url");
    this.tpK = getIntent().getStringExtra("free_wifi_welcome_msg");
    this.tpL = getIntent().getStringExtra("free_wifi_welcome_sub_title");
    this.tpM = getIntent().getStringExtra("free_wifi_privacy_url");
    this.tnF = getIntent().getStringExtra("free_wifi_app_nickname");
    switch (this.dnh)
    {
    default: 
      if (bt.isNullOrNil(this.ssid)) {
        ad.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      break;
    case 2: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      for (;;)
      {
        label234:
        initView();
        j.cRz().add(this.tpb);
        l.P(com.tencent.mm.plugin.freewifi.model.d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        return;
        paramBundle = j.cRz().cRZ();
        if (paramBundle != null)
        {
          this.ssid = paramBundle.field_ssid;
          this.toV = paramBundle.field_mid;
          this.omw = paramBundle.field_url;
          ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", new Object[] { this.ssid, this.toV, this.omw });
          break;
        }
        ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
        break;
        if (!bt.isNullOrNil(this.ssid)) {
          break label377;
        }
        ad.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
      }
      label377:
      paramBundle = j.cRz().ajY(this.ssid);
      if (paramBundle == null)
      {
        paramBundle = new com.tencent.mm.plugin.freewifi.g.c();
        paramBundle.field_ssidmd5 = ai.ee(this.ssid);
        paramBundle.field_ssid = this.ssid;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      paramBundle.field_url = this.omw;
      paramBundle.field_mid = this.toV;
      paramBundle.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
      paramBundle.field_connectState = 1;
      if (i != 0)
      {
        j.cRz().insert(paramBundle);
        break;
      }
      j.cRz().update(paramBundle, new String[0]);
      break;
      ad.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", new Object[] { this.ssid, this.toV, Integer.valueOf(this.dnh) });
      break label234;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j.cRz().remove(this.tpb);
    cSd();
    cSf();
    if (this.toW != null) {
      unregisterReceiver(this.toW);
    }
    this.toZ.stopTimer();
    this.tpa.stopTimer();
    j.cRC().release();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
 * JD-Core Version:    0.7.0.1
 */