package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiCopyPwdUI
  extends MMActivity
{
  public static int rjQ = 111;
  private String appId;
  private int cJR;
  private String ddU;
  private ap gAC;
  private Intent intent;
  private int rik;
  private int rjR;
  private int rjS;
  protected TextView rjT;
  protected TextView rjU;
  protected TextView rjV;
  private String ssid;
  
  public FreeWifiCopyPwdUI()
  {
    AppMethodBeat.i(25001);
    this.rjR = 1;
    this.rjS = 2;
    this.gAC = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24998);
        paramAnonymousMessage = (FreeWifiCopyPwdUI.b)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.rkb == FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this))
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
    com.tencent.mm.plugin.freewifi.l.N(d.cvP(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.cvq();
    ((k.a)localObject).ddU = this.ddU;
    ((k.a)localObject).nSA = m.ai(this.intent);
    ((k.a)localObject).rfM = k.b.rgw.rgx;
    ((k.a)localObject).rfN = k.b.rgw.name;
    ((k.a)localObject).channel = m.al(this.intent);
    ((k.a)localObject).rfL = m.ak(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).foR = "";
    ((k.a)localObject).cvs().c(this.intent, true).cvr();
    localObject = new Intent();
    g.hYt.h((Intent)localObject, this);
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
    if ((paramInt1 == rjQ) && (m.cvw()) && (!bt.isNullOrNil(this.ssid)) && (this.ssid.equals(d.cvQ())))
    {
      ad.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { m.ai(this.intent), Integer.valueOf(m.aj(this.intent)) });
      paramIntent = k.cvq();
      paramIntent.ssid = this.ssid;
      paramIntent.bssid = m.aav("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.ddV = m.aaw("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.ddU = this.ddU;
      paramIntent.rfK = this.appId;
      paramIntent.nSA = m.ai(this.intent);
      paramIntent.rfL = m.ak(this.intent);
      paramIntent.rfM = k.b.rfX.rgx;
      paramIntent.rfN = k.b.rfX.name;
      paramIntent.result = 0;
      paramIntent.channel = m.al(this.intent);
      paramIntent.cvs().cvr();
      m.a(this.intent, this.ddU, this.rik, this.cJR, new m.a()
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
            paramAnonymousString = ((com.tencent.mm.plugin.freewifi.d.a)paramAnonymousn).cwk();
            if (paramAnonymousString != null)
            {
              ad.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymousString.Cxj, paramAnonymousString.mBV, paramAnonymousString.mAQ, Integer.valueOf(paramAnonymousString.CCv), paramAnonymousString.CCw, paramAnonymousString.ijP, paramAnonymousString.CCx });
              FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, new FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this, FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this), paramAnonymousString));
              AppMethodBeat.o(24997);
              return;
            }
            ad.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
            paramAnonymousString = FreeWifiCopyPwdUI.this;
            paramAnonymousn = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            localObject = new FreeWifiCopyPwdUI.a();
            ((FreeWifiCopyPwdUI.a)localObject).rka = m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.rfZ, 21);
            FreeWifiCopyPwdUI.a(paramAnonymousString, new FreeWifiCopyPwdUI.b(paramAnonymousn, paramAnonymousInt1, localObject));
            AppMethodBeat.o(24997);
            return;
          }
          if ((m.fG(paramAnonymousInt1, paramAnonymousInt2)) && (!m.dq(paramAnonymousString)))
          {
            paramAnonymousn = FreeWifiCopyPwdUI.this;
            localObject = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            FreeWifiCopyPwdUI.a locala = new FreeWifiCopyPwdUI.a();
            locala.text = paramAnonymousString;
            locala.rka = m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.rfZ, paramAnonymousInt2);
            FreeWifiCopyPwdUI.a(paramAnonymousn, new FreeWifiCopyPwdUI.b((FreeWifiCopyPwdUI)localObject, paramAnonymousInt1, locala));
            AppMethodBeat.o(24997);
            return;
          }
          paramAnonymousString = FreeWifiCopyPwdUI.this;
          paramAnonymousn = FreeWifiCopyPwdUI.this;
          paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
          Object localObject = new FreeWifiCopyPwdUI.a();
          ((FreeWifiCopyPwdUI.a)localObject).rka = m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.rfZ, paramAnonymousInt2);
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(24995);
        FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this);
        AppMethodBeat.o(24995);
        return true;
      }
    });
    this.intent = getIntent();
    this.ssid = getIntent().getStringExtra("free_wifi_ssid");
    this.ddU = this.intent.getStringExtra("free_wifi_ap_key");
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.cJR = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.rik = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ((TextView)findViewById(2131300274)).setText(this.ssid);
    paramBundle = getIntent().getStringExtra("free_wifi_passowrd");
    getContext();
    com.tencent.mm.pluginsdk.g.a.b("wifi password", paramBundle);
    ((Button)findViewById(2131300254)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24996);
        paramAnonymousView = new Intent("android.settings.WIFI_SETTINGS");
        FreeWifiCopyPwdUI.this.startActivityForResult(paramAnonymousView, FreeWifiCopyPwdUI.rjQ);
        AppMethodBeat.o(24996);
      }
    });
    this.rjT = ((TextView)findViewById(2131300256));
    this.rjU = ((TextView)findViewById(2131300255));
    this.rjV = ((TextView)findViewById(2131300257));
    paramBundle = d.cvP();
    String str = getIntent().getStringExtra("free_wifi_ap_key");
    int i = getIntent().getIntExtra("free_wifi_protocol_type", 0);
    h.vKh.f(12651, new Object[] { Integer.valueOf(6), paramBundle, Integer.valueOf(0), str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
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
    public static a rjY;
    private int rjZ;
    String rka;
    String text;
    
    static
    {
      AppMethodBeat.i(25000);
      rjY = new a();
      AppMethodBeat.o(25000);
    }
  }
  
  public final class b
  {
    Object data;
    int rkb;
    
    public b(int paramInt, Object paramObject)
    {
      this.rkb = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI
 * JD-Core Version:    0.7.0.1
 */