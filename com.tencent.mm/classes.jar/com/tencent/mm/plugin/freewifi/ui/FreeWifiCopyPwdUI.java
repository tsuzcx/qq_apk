package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiCopyPwdUI
  extends MMActivity
{
  public static int wRe = 111;
  private String appId;
  private int channelId;
  private String dFd;
  private MMHandler hAk;
  private Intent intent;
  private String ssid;
  private int wPz;
  private int wRf;
  private int wRg;
  protected TextView wRh;
  protected TextView wRi;
  protected TextView wRj;
  
  public FreeWifiCopyPwdUI()
  {
    AppMethodBeat.i(25001);
    this.wRf = 1;
    this.wRg = 2;
    this.hAk = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(24998);
        paramAnonymousMessage = (FreeWifiCopyPwdUI.b)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.uEf == FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this))
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
    l.S(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    Object localObject = k.dMF();
    ((k.a)localObject).dFd = this.dFd;
    ((k.a)localObject).quX = com.tencent.mm.plugin.freewifi.m.aw(this.intent);
    ((k.a)localObject).wNd = k.b.wNN.wNO;
    ((k.a)localObject).wNe = k.b.wNN.name;
    ((k.a)localObject).channel = com.tencent.mm.plugin.freewifi.m.az(this.intent);
    ((k.a)localObject).wNc = com.tencent.mm.plugin.freewifi.m.ay(this.intent);
    ((k.a)localObject).result = 0;
    ((k.a)localObject).resultMsg = "";
    ((k.a)localObject).dMH().c(this.intent, true).dMG();
    localObject = new Intent();
    g.jRt.h((Intent)localObject, this);
    finish();
    AppMethodBeat.o(25005);
  }
  
  public int getLayoutId()
  {
    return 2131494722;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(25003);
    if ((paramInt1 == wRe) && (com.tencent.mm.plugin.freewifi.m.dML()) && (!Util.isNullOrNil(this.ssid)) && (this.ssid.equals(d.dNf())))
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[] { com.tencent.mm.plugin.freewifi.m.aw(this.intent), Integer.valueOf(com.tencent.mm.plugin.freewifi.m.ax(this.intent)) });
      paramIntent = k.dMF();
      paramIntent.ssid = this.ssid;
      paramIntent.bssid = com.tencent.mm.plugin.freewifi.m.axN("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.dFe = com.tencent.mm.plugin.freewifi.m.axO("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
      paramIntent.dFd = this.dFd;
      paramIntent.wNb = this.appId;
      paramIntent.quX = com.tencent.mm.plugin.freewifi.m.aw(this.intent);
      paramIntent.wNc = com.tencent.mm.plugin.freewifi.m.ay(this.intent);
      paramIntent.wNd = k.b.wNo.wNO;
      paramIntent.wNe = k.b.wNo.name;
      paramIntent.result = 0;
      paramIntent.channel = com.tencent.mm.plugin.freewifi.m.az(this.intent);
      paramIntent.dMH().dMG();
      com.tencent.mm.plugin.freewifi.m.a(this.intent, this.dFd, this.wPz, this.channelId, new m.a()
      {
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(24997);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (!(paramAnonymousq instanceof a))
            {
              AppMethodBeat.o(24997);
              return;
            }
            paramAnonymousString = ((a)paramAnonymousq).dNz();
            if (paramAnonymousString != null)
            {
              Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramAnonymousString.KGX, paramAnonymousString.oUJ, paramAnonymousString.UserName, Integer.valueOf(paramAnonymousString.KMt), paramAnonymousString.KMu, paramAnonymousString.keb, paramAnonymousString.KMv });
              FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, new FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this, FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this), paramAnonymousString));
              AppMethodBeat.o(24997);
              return;
            }
            Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
            paramAnonymousString = FreeWifiCopyPwdUI.this;
            paramAnonymousq = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            localObject = new FreeWifiCopyPwdUI.a();
            ((FreeWifiCopyPwdUI.a)localObject).wRo = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.wNq, 21);
            FreeWifiCopyPwdUI.a(paramAnonymousString, new FreeWifiCopyPwdUI.b(paramAnonymousq, paramAnonymousInt1, localObject));
            AppMethodBeat.o(24997);
            return;
          }
          if ((com.tencent.mm.plugin.freewifi.m.gC(paramAnonymousInt1, paramAnonymousInt2)) && (!com.tencent.mm.plugin.freewifi.m.eP(paramAnonymousString)))
          {
            paramAnonymousq = FreeWifiCopyPwdUI.this;
            localObject = FreeWifiCopyPwdUI.this;
            paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
            FreeWifiCopyPwdUI.a locala = new FreeWifiCopyPwdUI.a();
            locala.text = paramAnonymousString;
            locala.wRo = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.wNq, paramAnonymousInt2);
            FreeWifiCopyPwdUI.a(paramAnonymousq, new FreeWifiCopyPwdUI.b((FreeWifiCopyPwdUI)localObject, paramAnonymousInt1, locala));
            AppMethodBeat.o(24997);
            return;
          }
          paramAnonymousString = FreeWifiCopyPwdUI.this;
          paramAnonymousq = FreeWifiCopyPwdUI.this;
          paramAnonymousInt1 = FreeWifiCopyPwdUI.c(FreeWifiCopyPwdUI.this);
          Object localObject = new FreeWifiCopyPwdUI.a();
          ((FreeWifiCopyPwdUI.a)localObject).wRo = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(FreeWifiCopyPwdUI.this), k.b.wNq, paramAnonymousInt2);
          FreeWifiCopyPwdUI.a(paramAnonymousString, new FreeWifiCopyPwdUI.b(paramAnonymousq, paramAnonymousInt1, localObject));
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
    this.dFd = this.intent.getStringExtra("free_wifi_ap_key");
    this.appId = this.intent.getStringExtra("free_wifi_appid");
    this.channelId = this.intent.getIntExtra("free_wifi_channel_id", 0);
    this.wPz = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    ((TextView)findViewById(2131301753)).setText(this.ssid);
    paramBundle = getIntent().getStringExtra("free_wifi_passowrd");
    ClipboardHelper.setText(getContext(), "wifi password", paramBundle);
    ((Button)findViewById(2131301733)).setOnClickListener(new FreeWifiCopyPwdUI.2(this));
    this.wRh = ((TextView)findViewById(2131301735));
    this.wRi = ((TextView)findViewById(2131301734));
    this.wRj = ((TextView)findViewById(2131301736));
    paramBundle = d.dNe();
    String str = getIntent().getStringExtra("free_wifi_ap_key");
    int i = getIntent().getIntExtra("free_wifi_protocol_type", 0);
    h.CyF.a(12651, new Object[] { Integer.valueOf(6), paramBundle, Integer.valueOf(0), str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
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
    public static a wRm;
    String text;
    private int wRn;
    String wRo;
    
    static
    {
      AppMethodBeat.i(25000);
      wRm = new a();
      AppMethodBeat.o(25000);
    }
  }
  
  public final class b
  {
    Object data;
    int uEf;
    
    public b(int paramInt, Object paramObject)
    {
      this.uEf = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI
 * JD-Core Version:    0.7.0.1
 */