package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiCopyPwdUI
  extends MMActivity
{
  public static int tAc = 111;
  private String appId;
  private int cSM;
  private String dnO;
  private aq gKO;
  private Intent intent;
  private String ssid;
  private int tAd;
  private int tAe;
  protected TextView tAf;
  protected TextView tAg;
  protected TextView tAh;
  private int tyw;
  
  public FreeWifiCopyPwdUI()
  {
    AppMethodBeat.i(25001);
    this.tAd = 1;
    this.tAe = 2;
    this.gKO = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24998);
        paramAnonymousMessage = (FreeWifiCopyPwdUI.b)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.tAn == FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this))
        {
          FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, paramAnonymousMessage.data);
          AppMethodBeat.o(24998);
          return;
        }
        FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this, paramAnonymousMessage.data);
        AppMethodBeat.o(24998);
      }
    };
    AppMethodBeat.o(25001);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(25005);
    l.R(d.cTV(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.cTw();
    ((k.a)localObject).dnO = this.dnO;
    ((k.a)localObject).pfT = com.tencent.mm.plugin.freewifi.m.ap(this.intent);
    ((k.a)localObject).tvZ = k.b.twJ.twK;
    ((k.a)localObject).twa = k.b.twJ.name;
    ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.as(this.intent);
    ((k.a)localObject).tvY = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).fMT = "";
    ((k.a)localObject).cTy().c(this.intent, true).cTx();
    localObject = new Intent();
    com.tencent.mm.plugin.freewifi.g.iUz.h((Intent)localObject, this);
    finish();
    AppMethodBeat.o(25005);
  }
  
  public int getLayoutId()
  {
    return 2131494168;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25003);
    if ((paramInt1 == tAc) && (com.tencent.mm.plugin.freewifi.m.cTC()) && (!bu.isNullOrNil(this.ssid)) && (this.ssid.equals(d.cTW())))
    {
      ae.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ap(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.aq(this.intent)) });
      paramIntent = k.cTw();
      paramIntent.ssid = this.ssid;
      paramIntent.bssid = com.tencent.mm.plugin.freewifi.m.akJ("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.dnP = com.tencent.mm.plugin.freewifi.m.akK("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.dnO = this.dnO;
      paramIntent.tvX = this.appId;
      paramIntent.pfT = com.tencent.mm.plugin.freewifi.m.ap(this.intent);
      paramIntent.tvY = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
      paramIntent.tvZ = k.b.twk.twK;
      paramIntent.twa = k.b.twk.name;
      paramIntent.result = 0;
      paramIntent.channel = com.tencent.mm.plugin.freewifi.m.as(this.intent);
      paramIntent.cTy().cTx();
      com.tencent.mm.plugin.freewifi.m.a(this.intent, this.dnO, this.tyw, this.cSM, new m.a()
      {
        public final void g(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(24997);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (!(paramAnonymousn instanceof com.tencent.mm.plugin.freewifi.d.a))
            {
              AppMethodBeat.o(24997);
              return;
            }
            paramAnonymousString = ((com.tencent.mm.plugin.freewifi.d.a)paramAnonymousn).cUq();
            if (paramAnonymousString != null)
            {
              ae.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymousString.FNs, paramAnonymousString.nJO, paramAnonymousString.nIJ, Integer.valueOf(paramAnonymousString.FSK), paramAnonymousString.FSL, paramAnonymousString.jfY, paramAnonymousString.FSM });
              FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, new FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this, FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this), paramAnonymousString));
              AppMethodBeat.o(24997);
              return;
            }
            ae.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
            paramAnonymousString = FreeWifiCopyPwdUI.this;
            paramAnonymousn = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            localObject = new FreeWifiCopyPwdUI.a();
            ((FreeWifiCopyPwdUI.a)localObject).tAm = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.twm, 21);
            FreeWifiCopyPwdUI.a(paramAnonymousString, new FreeWifiCopyPwdUI.b(paramAnonymousn, paramAnonymousInt1, localObject));
            AppMethodBeat.o(24997);
            return;
          }
          if ((com.tencent.mm.plugin.freewifi.m.gd(paramAnonymousInt1, paramAnonymousInt2)) && (!com.tencent.mm.plugin.freewifi.m.ef(paramAnonymousString)))
          {
            paramAnonymousn = FreeWifiCopyPwdUI.this;
            localObject = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            FreeWifiCopyPwdUI.a locala = new FreeWifiCopyPwdUI.a();
            locala.text = paramAnonymousString;
            locala.tAm = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.twm, paramAnonymousInt2);
            FreeWifiCopyPwdUI.a(paramAnonymousn, new FreeWifiCopyPwdUI.b((FreeWifiCopyPwdUI)localObject, paramAnonymousInt1, locala));
            AppMethodBeat.o(24997);
            return;
          }
          paramAnonymousString = FreeWifiCopyPwdUI.this;
          paramAnonymousn = FreeWifiCopyPwdUI.this;
          paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
          Object localObject = new FreeWifiCopyPwdUI.a();
          ((FreeWifiCopyPwdUI.a)localObject).tAm = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.twm, paramAnonymousInt2);
          FreeWifiCopyPwdUI.a(paramAnonymousString, new FreeWifiCopyPwdUI.b(paramAnonymousn, paramAnonymousInt1, localObject));
          AppMethodBeat.o(24997);
        }
      }, "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
    }
    AppMethodBeat.o(25003);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25002);
    super.onCreate(paramBundle);
    setBackBtn(new FreeWifiCopyPwdUI.1(this));
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.dnO = this.intent.getStringExtra("free_wifi_ap_key");
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.cSM = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.tyw = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ((TextView)findViewById(2131300274)).setText(this.ssid);
    paramBundle = getIntent().getStringExtra("free_wifi_passowrd");
    getContext();
    com.tencent.mm.pluginsdk.i.a.b("wifi password", paramBundle);
    ((Button)findViewById(2131300254)).setOnClickListener(new FreeWifiCopyPwdUI.2(this));
    this.tAf = ((TextView)findViewById(2131300256));
    this.tAg = ((TextView)findViewById(2131300255));
    this.tAh = ((TextView)findViewById(2131300257));
    paramBundle = d.cTV();
    String str = getIntent().getStringExtra("free_wifi_ap_key");
    int i = getIntent().getIntExtra("free_wifi_protocol_type", 0);
    com.tencent.mm.plugin.report.service.g.yxI.f(12651, new Object[] { Integer.valueOf(6), paramBundle, Integer.valueOf(0), str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
    AppMethodBeat.o(25002);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25004);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(25004);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25004);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    public static a tAk;
    private int tAl;
    String tAm;
    String text;
    
    static
    {
      AppMethodBeat.i(25000);
      tAk = new a();
      AppMethodBeat.o(25000);
    }
  }
  
  public final class b
  {
    Object data;
    int tAn;
    
    public b(int paramInt, Object paramObject)
    {
      this.tAn = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI
 * JD-Core Version:    0.7.0.1
 */