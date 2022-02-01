package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
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
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;

public class FreeWifiPcUI
  extends MMActivity
{
  private String appId;
  private String dHx;
  private Button hPX;
  private String wPA;
  private String wRE;
  private Button wRz;
  private TextView wSw;
  private int wSx;
  private q wSy = null;
  
  private void goBack()
  {
    AppMethodBeat.i(25127);
    Intent localIntent = new Intent();
    g.jRt.h(localIntent, this);
    finish();
    AppMethodBeat.o(25127);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494729;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25125);
    super.onCreate(paramBundle);
    setMMTitle(2131760974);
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
    this.wSx = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
    this.dHx = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
    this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
    this.wRE = getIntent().getStringExtra("free_wifi_privacy_url");
    this.wSw = ((TextView)findViewById(2131301749));
    this.hPX = ((Button)findViewById(2131301750));
    this.wSw.setText("由" + this.wPA + "提供");
    this.hPX.setOnClickListener(new FreeWifiPcUI.2(this));
    this.wRz = ((Button)findViewById(2131301751));
    this.wRz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25124);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", FreeWifiPcUI.f(FreeWifiPcUI.this));
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("show_bottom", false);
        c.b(FreeWifiPcUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI
 * JD-Core Version:    0.7.0.1
 */