package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.c.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceConnectedRouterActivateStateUI
  extends MMActivity
{
  private String appId;
  private String bJp;
  private String bwK;
  private final int jCO = 90000;
  private ExdeviceConnectedRouterStateView jCP;
  private TextView jCQ;
  private TextView jCR;
  private b<a> jCS = new ExdeviceConnectedRouterActivateStateUI.1(this);
  private String jtn;
  private String ssid;
  
  private void aMw()
  {
    finish();
    Intent localIntent = new Intent();
    localIntent.putExtra("From_fail_notify", true);
    y.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
    d.e(this, "com.tencent.mm.ui.LauncherUI", localIntent);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_connected_router_state;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
    setMMTitle(R.l.exdevice_connected_router_title);
    setBackBtn(new ExdeviceConnectedRouterActivateStateUI.2(this));
    this.jCP = ((ExdeviceConnectedRouterStateView)findViewById(R.h.exdevice_connected_router_connect_state));
    this.jCQ = ((TextView)findViewById(R.h.exdevice_connected_router_connect_info));
    this.jCR = ((TextView)findViewById(R.h.exdevice_connected_router_connect_tips));
    try
    {
      paramBundle = Uri.parse(getIntent().getStringExtra("key_connected_router"));
      this.bwK = paramBundle.getQueryParameter("deviceid");
      this.bJp = paramBundle.getQueryParameter("devicetype");
      this.jtn = paramBundle.getQueryParameter("clientinfo");
      this.appId = paramBundle.getQueryParameter("appid");
      if ((bk.bl(this.bwK)) || (bk.bl(this.bJp)) || (bk.bl(this.jtn)) || (bk.bl(this.appId)))
      {
        y.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[] { paramBundle.toString() });
        finish();
      }
      this.ssid = paramBundle.getQueryParameter("ssid");
      y.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[] { paramBundle.toString(), this.bwK, this.bJp, this.jtn, this.ssid });
      if (this.ssid == null) {
        this.ssid = "";
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        y.d("MicroMsg.ConnectedRouterActivateStateUi", paramBundle.toString());
      }
    }
    qv(1);
    au.Dk().a(new a(this.bwK, this.bJp, this.jtn, this.appId, this.jCS), 0);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aMw();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected final void qv(int paramInt)
  {
    this.jCP.setOnClickListener(null);
    y.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      this.jCP.setImageResource(R.k.connected_router_state_error);
      this.jCP.setState(3);
      this.jCP.startAngle = 2;
      this.jCQ.setText(R.l.exdevice_connected_router_error);
      this.jCR.setText(getString(R.l.exdevice_connected_router_error_tips, new Object[] { this.ssid }));
      return;
    case 4: 
      this.jCP.setImageResource(R.k.connected_router_state_error);
      this.jCP.setState(3);
      this.jCP.startAngle = 2;
      this.jCQ.setText(R.l.exdevice_connected_router_error);
      this.jCR.setText(getString(R.l.exdevice_connected_router_network_error));
      return;
    case 5: 
      this.jCP.setImageResource(R.k.connected_router_state_error);
      this.jCP.setState(3);
      this.jCP.startAngle = 2;
      this.jCQ.setText(R.l.exdevice_connected_router_error);
      this.jCR.setText(getString(R.l.exdevice_connected_router_system_error));
      return;
    case 2: 
      this.jCP.setImageResource(R.k.connected_router_state_succ);
      this.jCP.setState(2);
      this.jCQ.setText(getString(R.l.exdevice_connected_router_success, new Object[] { this.ssid }));
      addTextOptionMenu(0, getString(R.l.exdevice_connected_router_complete), new ExdeviceConnectedRouterActivateStateUI.3(this));
      return;
    }
    this.jCP.setImageResource(R.k.connected_router_state_normal);
    this.jCP.setState(1);
    this.jCQ.setText(R.l.exdevice_connected_router_connecting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI
 * JD-Core Version:    0.7.0.1
 */