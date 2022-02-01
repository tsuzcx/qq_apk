package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class FreeWifiPcUI
  extends MMActivity
{
  private String appId;
  private String ddJ;
  private Button gAJ;
  private String sre;
  private Button stf;
  private String stk;
  private TextView suc;
  private int sud;
  private p sue = null;
  
  private void goBack()
  {
    AppMethodBeat.i(25127);
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.freewifi.g.iyx.h(localIntent, this);
    finish();
    AppMethodBeat.o(25127);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494175;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25125);
    super.onCreate(paramBundle);
    setMMTitle(2131759653);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25120);
        FreeWifiPcUI.a(FreeWifiPcUI.this);
        AppMethodBeat.o(25120);
        return true;
      }
    });
    this.appId = getIntent().getStringExtra("free_wifi_appid");
    this.sud = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
    this.ddJ = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
    this.sre = getIntent().getStringExtra("free_wifi_app_nickname");
    this.stk = getIntent().getStringExtra("free_wifi_privacy_url");
    this.suc = ((TextView)findViewById(2131300270));
    this.gAJ = ((Button)findViewById(2131300271));
    this.suc.setText("由" + this.sre + "提供");
    this.gAJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(25123);
        FreeWifiPcUI.b(FreeWifiPcUI.this).setClickable(false);
        paramAnonymousView = new au(new au.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(25121);
            FreeWifiPcUI.a(FreeWifiPcUI.this, h.b(FreeWifiPcUI.this.getContext(), FreeWifiPcUI.this.getString(2131757571), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous3DialogInterface) {}
            }));
            AppMethodBeat.o(25121);
            return true;
          }
        }, false);
        paramAnonymousView.au(2000L, 2000L);
        k.a locala = k.cIC();
        locala.soB = String.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.this));
        locala.soC = FreeWifiPcUI.d(FreeWifiPcUI.this);
        locala.ovU = FreeWifiPcUI.c(FreeWifiPcUI.this);
        locala.soE = k.b.spl.spp;
        locala.soF = k.b.spl.name;
        locala.cIE().cID();
        ac.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[] { m.aj(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.ak(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.this)), FreeWifiPcUI.d(FreeWifiPcUI.this), FreeWifiPcUI.c(FreeWifiPcUI.this) });
        new com.tencent.mm.plugin.freewifi.d.l(FreeWifiPcUI.d(FreeWifiPcUI.this), FreeWifiPcUI.e(FreeWifiPcUI.this), FreeWifiPcUI.c(FreeWifiPcUI.this)).c(new com.tencent.mm.ak.g()
        {
          public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
          {
            AppMethodBeat.i(25122);
            paramAnonymousView.stopTimer();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0)) {
              FreeWifiPcUI.this.finish();
            }
            for (;;)
            {
              paramAnonymous2String = k.cIC();
              paramAnonymous2String.soB = String.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.this));
              paramAnonymous2String.soC = FreeWifiPcUI.d(FreeWifiPcUI.this);
              paramAnonymous2String.ovU = FreeWifiPcUI.c(FreeWifiPcUI.this);
              paramAnonymous2String.soE = k.b.spm.spp;
              paramAnonymous2String.soF = k.b.spm.name;
              paramAnonymous2String.result = paramAnonymous2Int2;
              paramAnonymous2String.cIE().cID();
              ac.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", new Object[] { m.aj(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.ak(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.this)), FreeWifiPcUI.d(FreeWifiPcUI.this), FreeWifiPcUI.c(FreeWifiPcUI.this) });
              AppMethodBeat.o(25122);
              return;
              if ((m.fN(paramAnonymous2Int1, paramAnonymous2Int2)) && (!m.cX(paramAnonymous2String))) {
                FreeWifiPcUI.a(FreeWifiPcUI.this, paramAnonymous2String + "(" + m.a(m.al(FreeWifiPcUI.this.getIntent()), k.b.spm, paramAnonymous2Int2) + ")", "");
              } else {
                FreeWifiPcUI.a(FreeWifiPcUI.this, FreeWifiPcUI.this.getString(2131759621), FreeWifiPcUI.this.getString(2131759622));
              }
            }
          }
        });
        AppMethodBeat.o(25123);
      }
    });
    this.stf = ((Button)findViewById(2131300272));
    this.stf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25124);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", FreeWifiPcUI.f(FreeWifiPcUI.this));
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("show_bottom", false);
        d.b(FreeWifiPcUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(25124);
      }
    });
    AppMethodBeat.o(25125);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25126);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(25126);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25126);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI
 * JD-Core Version:    0.7.0.1
 */