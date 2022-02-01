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
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class FreeWifiPcUI
  extends MMActivity
{
  private String appId;
  private String dgo;
  private Button hJh;
  private String ril;
  private Button rkm;
  private String rkr;
  private TextView rlj;
  private int rlk;
  private p rll = null;
  
  private void goBack()
  {
    AppMethodBeat.i(25127);
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.freewifi.g.hYt.h(localIntent, this);
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
    this.rlk = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
    this.dgo = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
    this.ril = getIntent().getStringExtra("free_wifi_app_nickname");
    this.rkr = getIntent().getStringExtra("free_wifi_privacy_url");
    this.rlj = ((TextView)findViewById(2131300270));
    this.hJh = ((Button)findViewById(2131300271));
    this.rlj.setText("由" + this.ril + "提供");
    this.hJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(25123);
        FreeWifiPcUI.b(FreeWifiPcUI.this).setClickable(false);
        paramAnonymousView = new av(new av.a()
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
        paramAnonymousView.av(2000L, 2000L);
        k.a locala = k.cvq();
        locala.rfJ = String.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.this));
        locala.rfK = FreeWifiPcUI.d(FreeWifiPcUI.this);
        locala.nSA = FreeWifiPcUI.c(FreeWifiPcUI.this);
        locala.rfM = k.b.rgt.rgx;
        locala.rfN = k.b.rgt.name;
        locala.cvs().cvr();
        ad.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[] { m.ai(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.aj(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.this)), FreeWifiPcUI.d(FreeWifiPcUI.this), FreeWifiPcUI.c(FreeWifiPcUI.this) });
        new com.tencent.mm.plugin.freewifi.d.l(FreeWifiPcUI.d(FreeWifiPcUI.this), FreeWifiPcUI.e(FreeWifiPcUI.this), FreeWifiPcUI.c(FreeWifiPcUI.this)).c(new com.tencent.mm.al.g()
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
              paramAnonymous2String = k.cvq();
              paramAnonymous2String.rfJ = String.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.this));
              paramAnonymous2String.rfK = FreeWifiPcUI.d(FreeWifiPcUI.this);
              paramAnonymous2String.nSA = FreeWifiPcUI.c(FreeWifiPcUI.this);
              paramAnonymous2String.rfM = k.b.rgu.rgx;
              paramAnonymous2String.rfN = k.b.rgu.name;
              paramAnonymous2String.result = paramAnonymous2Int2;
              paramAnonymous2String.cvs().cvr();
              ad.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", new Object[] { m.ai(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.aj(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.e(FreeWifiPcUI.this)), FreeWifiPcUI.d(FreeWifiPcUI.this), FreeWifiPcUI.c(FreeWifiPcUI.this) });
              AppMethodBeat.o(25122);
              return;
              if ((m.fG(paramAnonymous2Int1, paramAnonymous2Int2)) && (!m.dq(paramAnonymous2String))) {
                FreeWifiPcUI.a(FreeWifiPcUI.this, paramAnonymous2String + "(" + m.a(m.ak(FreeWifiPcUI.this.getIntent()), k.b.rgu, paramAnonymous2Int2) + ")", "");
              } else {
                FreeWifiPcUI.a(FreeWifiPcUI.this, FreeWifiPcUI.this.getString(2131759621), FreeWifiPcUI.this.getString(2131759622));
              }
            }
          }
        });
        AppMethodBeat.o(25123);
      }
    });
    this.rkm = ((Button)findViewById(2131300272));
    this.rkm.setOnClickListener(new View.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI
 * JD-Core Version:    0.7.0.1
 */