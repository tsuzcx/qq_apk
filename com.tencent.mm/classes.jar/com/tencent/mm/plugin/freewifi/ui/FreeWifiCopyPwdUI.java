package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiCopyPwdUI
  extends MMActivity
{
  public static int tpl = 111;
  private String appId;
  private int cSc;
  private String dmM;
  private ap gIf;
  private Intent intent;
  private String ssid;
  private int tnE;
  private int tpm;
  private int tpn;
  protected TextView tpo;
  protected TextView tpp;
  protected TextView tpq;
  
  public FreeWifiCopyPwdUI()
  {
    AppMethodBeat.i(25001);
    this.tpm = 1;
    this.tpn = 2;
    this.gIf = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24998);
        paramAnonymousMessage = (FreeWifiCopyPwdUI.b)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.tpw == FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this))
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
    l.R(d.cRq(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.cQR();
    ((k.a)localObject).dmM = this.dmM;
    ((k.a)localObject).oZp = com.tencent.mm.plugin.freewifi.m.ao(this.intent);
    ((k.a)localObject).tlh = k.b.tlR.tlS;
    ((k.a)localObject).tli = k.b.tlR.name;
    ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
    ((k.a)localObject).tlg = com.tencent.mm.plugin.freewifi.m.aq(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).fKQ = "";
    ((k.a)localObject).cQT().c(this.intent, true).cQS();
    localObject = new Intent();
    com.tencent.mm.plugin.freewifi.g.iRG.h((Intent)localObject, this);
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
    if ((paramInt1 == tpl) && (com.tencent.mm.plugin.freewifi.m.cQX()) && (!bt.isNullOrNil(this.ssid)) && (this.ssid.equals(d.cRr())))
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { com.tencent.mm.plugin.freewifi.m.ao(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ap(this.intent)) });
      paramIntent = k.cQR();
      paramIntent.ssid = this.ssid;
      paramIntent.bssid = com.tencent.mm.plugin.freewifi.m.ajL("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.dmN = com.tencent.mm.plugin.freewifi.m.ajM("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.dmM = this.dmM;
      paramIntent.tlf = this.appId;
      paramIntent.oZp = com.tencent.mm.plugin.freewifi.m.ao(this.intent);
      paramIntent.tlg = com.tencent.mm.plugin.freewifi.m.aq(this.intent);
      paramIntent.tlh = k.b.tls.tlS;
      paramIntent.tli = k.b.tls.name;
      paramIntent.result = 0;
      paramIntent.channel = com.tencent.mm.plugin.freewifi.m.ar(this.intent);
      paramIntent.cQT().cQS();
      com.tencent.mm.plugin.freewifi.m.a(this.intent, this.dmM, this.tnE, this.cSc, new m.a()
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
            paramAnonymousString = ((com.tencent.mm.plugin.freewifi.d.a)paramAnonymousn).cRL();
            if (paramAnonymousString != null)
            {
              ad.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymousString.FuU, paramAnonymousString.nEt, paramAnonymousString.nDo, Integer.valueOf(paramAnonymousString.FAn), paramAnonymousString.FAo, paramAnonymousString.jdf, paramAnonymousString.FAp });
              FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, new FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this, FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this), paramAnonymousString));
              AppMethodBeat.o(24997);
              return;
            }
            ad.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
            paramAnonymousString = FreeWifiCopyPwdUI.this;
            paramAnonymousn = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            localObject = new FreeWifiCopyPwdUI.a();
            ((FreeWifiCopyPwdUI.a)localObject).tpv = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.tlu, 21);
            FreeWifiCopyPwdUI.a(paramAnonymousString, new FreeWifiCopyPwdUI.b(paramAnonymousn, paramAnonymousInt1, localObject));
            AppMethodBeat.o(24997);
            return;
          }
          if ((com.tencent.mm.plugin.freewifi.m.gd(paramAnonymousInt1, paramAnonymousInt2)) && (!com.tencent.mm.plugin.freewifi.m.ea(paramAnonymousString)))
          {
            paramAnonymousn = FreeWifiCopyPwdUI.this;
            localObject = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            FreeWifiCopyPwdUI.a locala = new FreeWifiCopyPwdUI.a();
            locala.text = paramAnonymousString;
            locala.tpv = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.tlu, paramAnonymousInt2);
            FreeWifiCopyPwdUI.a(paramAnonymousn, new FreeWifiCopyPwdUI.b((FreeWifiCopyPwdUI)localObject, paramAnonymousInt1, locala));
            AppMethodBeat.o(24997);
            return;
          }
          paramAnonymousString = FreeWifiCopyPwdUI.this;
          paramAnonymousn = FreeWifiCopyPwdUI.this;
          paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
          Object localObject = new FreeWifiCopyPwdUI.a();
          ((FreeWifiCopyPwdUI.a)localObject).tpv = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.tlu, paramAnonymousInt2);
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
    this.dmM = this.intent.getStringExtra("free_wifi_ap_key");
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.cSc = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.tnE = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ((TextView)findViewById(2131300274)).setText(this.ssid);
    paramBundle = getIntent().getStringExtra("free_wifi_passowrd");
    getContext();
    com.tencent.mm.pluginsdk.i.a.b("wifi password", paramBundle);
    ((Button)findViewById(2131300254)).setOnClickListener(new FreeWifiCopyPwdUI.2(this));
    this.tpo = ((TextView)findViewById(2131300256));
    this.tpp = ((TextView)findViewById(2131300255));
    this.tpq = ((TextView)findViewById(2131300257));
    paramBundle = d.cRq();
    String str = getIntent().getStringExtra("free_wifi_ap_key");
    int i = getIntent().getIntExtra("free_wifi_protocol_type", 0);
    com.tencent.mm.plugin.report.service.g.yhR.f(12651, new Object[] { Integer.valueOf(6), paramBundle, Integer.valueOf(0), str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
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
    public static a tpt;
    String text;
    private int tpu;
    String tpv;
    
    static
    {
      AppMethodBeat.i(25000);
      tpt = new a();
      AppMethodBeat.o(25000);
    }
  }
  
  public final class b
  {
    Object data;
    int tpw;
    
    public b(int paramInt, Object paramObject)
    {
      this.tpw = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI
 * JD-Core Version:    0.7.0.1
 */