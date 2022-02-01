package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceConnectedRouterActivateStateUI
  extends MMActivity
{
  private String appId;
  private String clientInfo;
  private String hEl;
  private String hEr;
  private String ssid;
  private final int yzJ;
  private ExdeviceConnectedRouterStateView yzK;
  private TextView yzL;
  private TextView yzM;
  private b<a> yzN;
  
  public ExdeviceConnectedRouterActivateStateUI()
  {
    AppMethodBeat.i(23989);
    this.yzJ = 90000;
    this.yzN = new b() {};
    AppMethodBeat.o(23989);
  }
  
  private void dGQ()
  {
    AppMethodBeat.i(23995);
    finish();
    Intent localIntent = new Intent();
    localIntent.putExtra("From_fail_notify", true);
    Log.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
    c.g(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(23995);
  }
  
  protected final void Ll(int paramInt)
  {
    AppMethodBeat.i(23992);
    this.yzK.setOnClickListener(null);
    Log.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23992);
      return;
      this.yzK.setImageResource(R.k.connected_router_state_error);
      this.yzK.setState(3);
      this.yzK.startAngle = 2;
      this.yzL.setText(R.l.gFZ);
      this.yzM.setText(getString(R.l.gGa, new Object[] { this.ssid }));
      AppMethodBeat.o(23992);
      return;
      this.yzK.setImageResource(R.k.connected_router_state_error);
      this.yzK.setState(3);
      this.yzK.startAngle = 2;
      this.yzL.setText(R.l.gFZ);
      this.yzM.setText(getString(R.l.gGb));
      AppMethodBeat.o(23992);
      return;
      this.yzK.setImageResource(R.k.connected_router_state_error);
      this.yzK.setState(3);
      this.yzK.startAngle = 2;
      this.yzL.setText(R.l.gFZ);
      this.yzM.setText(getString(R.l.gGd));
      AppMethodBeat.o(23992);
      return;
      this.yzK.setImageResource(R.k.connected_router_state_succ);
      this.yzK.setState(2);
      this.yzL.setText(getString(R.l.gGc, new Object[] { this.ssid }));
      addTextOptionMenu(0, getString(R.l.gFX), new MenuItem.OnMenuItemClickListener()
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
      this.yzK.setImageResource(R.k.connected_router_state_normal);
      this.yzK.setState(1);
      this.yzL.setText(R.l.gFY);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gjj;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23990);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
    setMMTitle(R.l.gGe);
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
    this.yzK = ((ExdeviceConnectedRouterStateView)findViewById(R.h.fGZ));
    this.yzL = ((TextView)findViewById(R.h.fGY));
    this.yzM = ((TextView)findViewById(R.h.fHa));
    try
    {
      paramBundle = Uri.parse(getIntent().getStringExtra("key_connected_router"));
      this.hEl = paramBundle.getQueryParameter("deviceid");
      this.hEr = paramBundle.getQueryParameter("devicetype");
      this.clientInfo = paramBundle.getQueryParameter("clientinfo");
      this.appId = paramBundle.getQueryParameter("appid");
      if ((Util.isNullOrNil(this.hEl)) || (Util.isNullOrNil(this.hEr)) || (Util.isNullOrNil(this.clientInfo)) || (Util.isNullOrNil(this.appId)))
      {
        Log.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[] { paramBundle.toString() });
        finish();
      }
      this.ssid = paramBundle.getQueryParameter("ssid");
      Log.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[] { paramBundle.toString(), this.hEl, this.hEr, this.clientInfo, this.ssid });
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
    Ll(1);
    bh.aZW().a(new a(this.hEl, this.hEr, this.clientInfo, this.appId, this.yzN), 0);
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
      dGQ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI
 * JD-Core Version:    0.7.0.1
 */