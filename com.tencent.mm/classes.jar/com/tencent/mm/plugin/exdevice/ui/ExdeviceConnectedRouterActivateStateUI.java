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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
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
  private String fzB;
  private String fzF;
  private String ssid;
  private String vdv;
  private final int vnh;
  private ExdeviceConnectedRouterStateView vni;
  private TextView vnj;
  private TextView vnk;
  private b<a> vnl;
  
  public ExdeviceConnectedRouterActivateStateUI()
  {
    AppMethodBeat.i(23989);
    this.vnh = 90000;
    this.vnl = new b() {};
    AppMethodBeat.o(23989);
  }
  
  private void dav()
  {
    AppMethodBeat.i(23995);
    finish();
    Intent localIntent = new Intent();
    localIntent.putExtra("From_fail_notify", true);
    Log.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
    c.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(23995);
  }
  
  protected final void Km(int paramInt)
  {
    AppMethodBeat.i(23992);
    this.vni.setOnClickListener(null);
    Log.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23992);
      return;
      this.vni.setImageResource(R.k.connected_router_state_error);
      this.vni.setState(3);
      this.vni.startAngle = 2;
      this.vnj.setText(R.l.eDl);
      this.vnk.setText(getString(R.l.eDm, new Object[] { this.ssid }));
      AppMethodBeat.o(23992);
      return;
      this.vni.setImageResource(R.k.connected_router_state_error);
      this.vni.setState(3);
      this.vni.startAngle = 2;
      this.vnj.setText(R.l.eDl);
      this.vnk.setText(getString(R.l.eDn));
      AppMethodBeat.o(23992);
      return;
      this.vni.setImageResource(R.k.connected_router_state_error);
      this.vni.setState(3);
      this.vni.startAngle = 2;
      this.vnj.setText(R.l.eDl);
      this.vnk.setText(getString(R.l.eDp));
      AppMethodBeat.o(23992);
      return;
      this.vni.setImageResource(R.k.connected_router_state_succ);
      this.vni.setState(2);
      this.vnj.setText(getString(R.l.eDo, new Object[] { this.ssid }));
      addTextOptionMenu(0, getString(R.l.eDj), new MenuItem.OnMenuItemClickListener()
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
      this.vni.setImageResource(R.k.connected_router_state_normal);
      this.vni.setState(1);
      this.vnj.setText(R.l.eDk);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.egq;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23990);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
    setMMTitle(R.l.eDq);
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
    this.vni = ((ExdeviceConnectedRouterStateView)findViewById(R.h.dFT));
    this.vnj = ((TextView)findViewById(R.h.dFS));
    this.vnk = ((TextView)findViewById(R.h.dFU));
    try
    {
      paramBundle = Uri.parse(getIntent().getStringExtra("key_connected_router"));
      this.fzB = paramBundle.getQueryParameter("deviceid");
      this.fzF = paramBundle.getQueryParameter("devicetype");
      this.vdv = paramBundle.getQueryParameter("clientinfo");
      this.appId = paramBundle.getQueryParameter("appid");
      if ((Util.isNullOrNil(this.fzB)) || (Util.isNullOrNil(this.fzF)) || (Util.isNullOrNil(this.vdv)) || (Util.isNullOrNil(this.appId)))
      {
        Log.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[] { paramBundle.toString() });
        finish();
      }
      this.ssid = paramBundle.getQueryParameter("ssid");
      Log.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[] { paramBundle.toString(), this.fzB, this.fzF, this.vdv, this.ssid });
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
    Km(1);
    bh.aGY().a(new a(this.fzB, this.fzF, this.vdv, this.appId, this.vnl), 0);
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
      dav();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI
 * JD-Core Version:    0.7.0.1
 */