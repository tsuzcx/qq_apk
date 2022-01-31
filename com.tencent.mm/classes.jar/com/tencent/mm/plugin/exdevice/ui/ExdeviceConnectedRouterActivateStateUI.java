package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.c.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceConnectedRouterActivateStateUI
  extends MMActivity
{
  private String appId;
  private String bYu;
  private String cqJ;
  private String lCM;
  private final int lMl;
  private ExdeviceConnectedRouterStateView lMm;
  private TextView lMn;
  private TextView lMo;
  private b<a> lMp;
  private String ssid;
  
  public ExdeviceConnectedRouterActivateStateUI()
  {
    AppMethodBeat.i(19921);
    this.lMl = 90000;
    this.lMp = new ExdeviceConnectedRouterActivateStateUI.1(this);
    AppMethodBeat.o(19921);
  }
  
  private void bqK()
  {
    AppMethodBeat.i(19927);
    finish();
    Intent localIntent = new Intent();
    localIntent.putExtra("From_fail_notify", true);
    ab.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
    d.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(19927);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969450;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(19922);
    super.onCreate(paramBundle);
    ab.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
    setMMTitle(2131299398);
    setBackBtn(new ExdeviceConnectedRouterActivateStateUI.2(this));
    this.lMm = ((ExdeviceConnectedRouterStateView)findViewById(2131823765));
    this.lMn = ((TextView)findViewById(2131823766));
    this.lMo = ((TextView)findViewById(2131823767));
    try
    {
      paramBundle = Uri.parse(getIntent().getStringExtra("key_connected_router"));
      this.bYu = paramBundle.getQueryParameter("deviceid");
      this.cqJ = paramBundle.getQueryParameter("devicetype");
      this.lCM = paramBundle.getQueryParameter("clientinfo");
      this.appId = paramBundle.getQueryParameter("appid");
      if ((bo.isNullOrNil(this.bYu)) || (bo.isNullOrNil(this.cqJ)) || (bo.isNullOrNil(this.lCM)) || (bo.isNullOrNil(this.appId)))
      {
        ab.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[] { paramBundle.toString() });
        finish();
      }
      this.ssid = paramBundle.getQueryParameter("ssid");
      ab.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[] { paramBundle.toString(), this.bYu, this.cqJ, this.lCM, this.ssid });
      if (this.ssid == null) {
        this.ssid = "";
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.d("MicroMsg.ConnectedRouterActivateStateUi", paramBundle.toString());
      }
    }
    vc(1);
    aw.Rc().a(new a(this.bYu, this.cqJ, this.lCM, this.appId, this.lMp), 0);
    AppMethodBeat.o(19922);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(19925);
    super.onDestroy();
    AppMethodBeat.o(19925);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(19926);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bqK();
      AppMethodBeat.o(19926);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(19926);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(19923);
    super.onResume();
    AppMethodBeat.o(19923);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void vc(int paramInt)
  {
    AppMethodBeat.i(19924);
    this.lMm.setOnClickListener(null);
    ab.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19924);
      return;
      this.lMm.setImageResource(2131231182);
      this.lMm.setState(3);
      this.lMm.lMs = 2;
      this.lMn.setText(2131299393);
      this.lMo.setText(getString(2131299394, new Object[] { this.ssid }));
      AppMethodBeat.o(19924);
      return;
      this.lMm.setImageResource(2131231182);
      this.lMm.setState(3);
      this.lMm.lMs = 2;
      this.lMn.setText(2131299393);
      this.lMo.setText(getString(2131299395));
      AppMethodBeat.o(19924);
      return;
      this.lMm.setImageResource(2131231182);
      this.lMm.setState(3);
      this.lMm.lMs = 2;
      this.lMn.setText(2131299393);
      this.lMo.setText(getString(2131299397));
      AppMethodBeat.o(19924);
      return;
      this.lMm.setImageResource(2131231184);
      this.lMm.setState(2);
      this.lMn.setText(getString(2131299396, new Object[] { this.ssid }));
      addTextOptionMenu(0, getString(2131299391), new ExdeviceConnectedRouterActivateStateUI.3(this));
      AppMethodBeat.o(19924);
      return;
      this.lMm.setImageResource(2131231183);
      this.lMm.setState(1);
      this.lMn.setText(2131299392);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI
 * JD-Core Version:    0.7.0.1
 */