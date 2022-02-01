package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceConnectedRouterActivateStateUI
  extends MMActivity
{
  private String appId;
  private String dGL;
  private String dGP;
  private TextView rHA;
  private TextView rHB;
  private b<a> rHC;
  private final int rHy;
  private ExdeviceConnectedRouterStateView rHz;
  private String rxP;
  private String ssid;
  
  public ExdeviceConnectedRouterActivateStateUI()
  {
    AppMethodBeat.i(23989);
    this.rHy = 90000;
    this.rHC = new b() {};
    AppMethodBeat.o(23989);
  }
  
  private void cLI()
  {
    AppMethodBeat.i(23995);
    finish();
    Intent localIntent = new Intent();
    localIntent.putExtra("From_fail_notify", true);
    Log.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
    c.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(23995);
  }
  
  protected final void GE(int paramInt)
  {
    AppMethodBeat.i(23992);
    this.rHz.setOnClickListener(null);
    Log.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23992);
      return;
      this.rHz.setImageResource(2131690015);
      this.rHz.setState(3);
      this.rHz.rHF = 2;
      this.rHA.setText(2131758820);
      this.rHB.setText(getString(2131758821, new Object[] { this.ssid }));
      AppMethodBeat.o(23992);
      return;
      this.rHz.setImageResource(2131690015);
      this.rHz.setState(3);
      this.rHz.rHF = 2;
      this.rHA.setText(2131758820);
      this.rHB.setText(getString(2131758822));
      AppMethodBeat.o(23992);
      return;
      this.rHz.setImageResource(2131690015);
      this.rHz.setState(3);
      this.rHz.rHF = 2;
      this.rHA.setText(2131758820);
      this.rHB.setText(getString(2131758824));
      AppMethodBeat.o(23992);
      return;
      this.rHz.setImageResource(2131690017);
      this.rHz.setState(2);
      this.rHA.setText(getString(2131758823, new Object[] { this.ssid }));
      addTextOptionMenu(0, getString(2131758818), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(23988);
          ExdeviceConnectedRouterActivateStateUI.a(ExdeviceConnectedRouterActivateStateUI.this);
          AppMethodBeat.o(23988);
          return true;
        }
      });
      AppMethodBeat.o(23992);
      return;
      this.rHz.setImageResource(2131690016);
      this.rHz.setState(1);
      this.rHA.setText(2131758819);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494018;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23990);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
    setMMTitle(2131758825);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(23987);
        ExdeviceConnectedRouterActivateStateUI.a(ExdeviceConnectedRouterActivateStateUI.this);
        AppMethodBeat.o(23987);
        return true;
      }
    });
    this.rHz = ((ExdeviceConnectedRouterStateView)findViewById(2131300195));
    this.rHA = ((TextView)findViewById(2131300194));
    this.rHB = ((TextView)findViewById(2131300196));
    try
    {
      paramBundle = Uri.parse(getIntent().getStringExtra("key_connected_router"));
      this.dGL = paramBundle.getQueryParameter("deviceid");
      this.dGP = paramBundle.getQueryParameter("devicetype");
      this.rxP = paramBundle.getQueryParameter("clientinfo");
      this.appId = paramBundle.getQueryParameter("appid");
      if ((Util.isNullOrNil(this.dGL)) || (Util.isNullOrNil(this.dGP)) || (Util.isNullOrNil(this.rxP)) || (Util.isNullOrNil(this.appId)))
      {
        Log.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[] { paramBundle.toString() });
        finish();
      }
      this.ssid = paramBundle.getQueryParameter("ssid");
      Log.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[] { paramBundle.toString(), this.dGL, this.dGP, this.rxP, this.ssid });
      if (this.ssid == null) {
        this.ssid = "";
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.d("MicroMsg.ConnectedRouterActivateStateUi", paramBundle.toString());
      }
    }
    GE(1);
    bg.azz().a(new a(this.dGL, this.dGP, this.rxP, this.appId, this.rHC), 0);
    AppMethodBeat.o(23990);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23993);
    super.onDestroy();
    AppMethodBeat.o(23993);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(23994);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      cLI();
      AppMethodBeat.o(23994);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(23994);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23991);
    super.onResume();
    AppMethodBeat.o(23991);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI
 * JD-Core Version:    0.7.0.1
 */