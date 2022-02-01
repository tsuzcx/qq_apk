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
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiCopyPwdUI
  extends MMActivity
{
  public static int ssJ = 111;
  private String appId;
  private int cGY;
  private String dbq;
  private ao gox;
  private Intent intent;
  private int srd;
  private int ssK;
  private int ssL;
  protected TextView ssM;
  protected TextView ssN;
  protected TextView ssO;
  private String ssid;
  
  public FreeWifiCopyPwdUI()
  {
    AppMethodBeat.i(25001);
    this.ssK = 1;
    this.ssL = 2;
    this.gox = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24998);
        paramAnonymousMessage = (FreeWifiCopyPwdUI.b)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.ssU == FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this))
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
    com.tencent.mm.plugin.freewifi.l.O(d.cJb(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.cIC();
    ((k.a)localObject).dbq = this.dbq;
    ((k.a)localObject).ovU = m.aj(this.intent);
    ((k.a)localObject).soE = k.b.spo.spp;
    ((k.a)localObject).soF = k.b.spo.name;
    ((k.a)localObject).channel = m.am(this.intent);
    ((k.a)localObject).soD = m.al(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).fsq = "";
    ((k.a)localObject).cIE().c(this.intent, true).cID();
    localObject = new Intent();
    g.iyx.h((Intent)localObject, this);
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
    if ((paramInt1 == ssJ) && (m.cII()) && (!bs.isNullOrNil(this.ssid)) && (this.ssid.equals(d.cJc())))
    {
      ac.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { m.aj(this.intent), Integer.valueOf(m.ak(this.intent)) });
      paramIntent = k.cIC();
      paramIntent.ssid = this.ssid;
      paramIntent.bssid = m.afn("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.dbr = m.afo("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.dbq = this.dbq;
      paramIntent.soC = this.appId;
      paramIntent.ovU = m.aj(this.intent);
      paramIntent.soD = m.al(this.intent);
      paramIntent.soE = k.b.soP.spp;
      paramIntent.soF = k.b.soP.name;
      paramIntent.result = 0;
      paramIntent.channel = m.am(this.intent);
      paramIntent.cIE().cID();
      m.a(this.intent, this.dbq, this.srd, this.cGY, new m.a()
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
            paramAnonymousString = ((com.tencent.mm.plugin.freewifi.d.a)paramAnonymousn).cJw();
            if (paramAnonymousString != null)
            {
              ac.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymousString.DPF, paramAnonymousString.ndW, paramAnonymousString.ncR, Integer.valueOf(paramAnonymousString.DUS), paramAnonymousString.DUT, paramAnonymousString.iJW, paramAnonymousString.DUU });
              FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, new FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this, FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this), paramAnonymousString));
              AppMethodBeat.o(24997);
              return;
            }
            ac.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
            paramAnonymousString = FreeWifiCopyPwdUI.this;
            paramAnonymousn = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            localObject = new FreeWifiCopyPwdUI.a();
            ((FreeWifiCopyPwdUI.a)localObject).ssT = m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.soR, 21);
            FreeWifiCopyPwdUI.a(paramAnonymousString, new FreeWifiCopyPwdUI.b(paramAnonymousn, paramAnonymousInt1, localObject));
            AppMethodBeat.o(24997);
            return;
          }
          if ((m.fN(paramAnonymousInt1, paramAnonymousInt2)) && (!m.cX(paramAnonymousString)))
          {
            paramAnonymousn = FreeWifiCopyPwdUI.this;
            localObject = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            FreeWifiCopyPwdUI.a locala = new FreeWifiCopyPwdUI.a();
            locala.text = paramAnonymousString;
            locala.ssT = m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.soR, paramAnonymousInt2);
            FreeWifiCopyPwdUI.a(paramAnonymousn, new FreeWifiCopyPwdUI.b((FreeWifiCopyPwdUI)localObject, paramAnonymousInt1, locala));
            AppMethodBeat.o(24997);
            return;
          }
          paramAnonymousString = FreeWifiCopyPwdUI.this;
          paramAnonymousn = FreeWifiCopyPwdUI.this;
          paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
          Object localObject = new FreeWifiCopyPwdUI.a();
          ((FreeWifiCopyPwdUI.a)localObject).ssT = m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.soR, paramAnonymousInt2);
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
    this.dbq = this.intent.getStringExtra("free_wifi_ap_key");
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.cGY = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.srd = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ((TextView)findViewById(2131300274)).setText(this.ssid);
    paramBundle = getIntent().getStringExtra("free_wifi_passowrd");
    getContext();
    com.tencent.mm.pluginsdk.g.a.b("wifi password", paramBundle);
    ((Button)findViewById(2131300254)).setOnClickListener(new FreeWifiCopyPwdUI.2(this));
    this.ssM = ((TextView)findViewById(2131300256));
    this.ssN = ((TextView)findViewById(2131300255));
    this.ssO = ((TextView)findViewById(2131300257));
    paramBundle = d.cJb();
    String str = getIntent().getStringExtra("free_wifi_ap_key");
    int i = getIntent().getIntExtra("free_wifi_protocol_type", 0);
    h.wUl.f(12651, new Object[] { Integer.valueOf(6), paramBundle, Integer.valueOf(0), str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
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
    public static a ssR;
    private int ssS;
    String ssT;
    String text;
    
    static
    {
      AppMethodBeat.i(25000);
      ssR = new a();
      AppMethodBeat.o(25000);
    }
  }
  
  public final class b
  {
    Object data;
    int ssU;
    
    public b(int paramInt, Object paramObject)
    {
      this.ssU = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI
 * JD-Core Version:    0.7.0.1
 */