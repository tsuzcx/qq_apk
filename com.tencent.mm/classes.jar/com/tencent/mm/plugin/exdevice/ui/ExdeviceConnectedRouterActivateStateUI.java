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
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.d.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceConnectedRouterActivateStateUI
  extends MMActivity
{
  private String appId;
  private String cUi;
  private String dow;
  private String qao;
  private final int qjM;
  private ExdeviceConnectedRouterStateView qjN;
  private TextView qjO;
  private TextView qjP;
  private b<a> qjQ;
  private String ssid;
  
  public ExdeviceConnectedRouterActivateStateUI()
  {
    AppMethodBeat.i(23989);
    this.qjM = 90000;
    this.qjQ = new b() {};
    AppMethodBeat.o(23989);
  }
  
  private void cmf()
  {
    AppMethodBeat.i(23995);
    finish();
    Intent localIntent = new Intent();
    localIntent.putExtra("From_fail_notify", true);
    ad.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
    d.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(23995);
  }
  
  protected final void CH(int paramInt)
  {
    AppMethodBeat.i(23992);
    this.qjN.setOnClickListener(null);
    ad.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23992);
      return;
      this.qjN.setImageResource(2131689986);
      this.qjN.setState(3);
      this.qjN.qjT = 2;
      this.qjO.setText(2131758521);
      this.qjP.setText(getString(2131758522, new Object[] { this.ssid }));
      AppMethodBeat.o(23992);
      return;
      this.qjN.setImageResource(2131689986);
      this.qjN.setState(3);
      this.qjN.qjT = 2;
      this.qjO.setText(2131758521);
      this.qjP.setText(getString(2131758523));
      AppMethodBeat.o(23992);
      return;
      this.qjN.setImageResource(2131689986);
      this.qjN.setState(3);
      this.qjN.qjT = 2;
      this.qjO.setText(2131758521);
      this.qjP.setText(getString(2131758525));
      AppMethodBeat.o(23992);
      return;
      this.qjN.setImageResource(2131689988);
      this.qjN.setState(2);
      this.qjO.setText(getString(2131758524, new Object[] { this.ssid }));
      addTextOptionMenu(0, getString(2131758519), new MenuItem.OnMenuItemClickListener()
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
      this.qjN.setImageResource(2131689987);
      this.qjN.setState(1);
      this.qjO.setText(2131758520);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493862;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23990);
    super.onCreate(paramBundle);
    ad.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
    setMMTitle(2131758526);
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
    this.qjN = ((ExdeviceConnectedRouterStateView)findViewById(2131299547));
    this.qjO = ((TextView)findViewById(2131299546));
    this.qjP = ((TextView)findViewById(2131299548));
    try
    {
      paramBundle = Uri.parse(getIntent().getStringExtra("key_connected_router"));
      this.cUi = paramBundle.getQueryParameter("deviceid");
      this.dow = paramBundle.getQueryParameter("devicetype");
      this.qao = paramBundle.getQueryParameter("clientinfo");
      this.appId = paramBundle.getQueryParameter("appid");
      if ((bt.isNullOrNil(this.cUi)) || (bt.isNullOrNil(this.dow)) || (bt.isNullOrNil(this.qao)) || (bt.isNullOrNil(this.appId)))
      {
        ad.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[] { paramBundle.toString() });
        finish();
      }
      this.ssid = paramBundle.getQueryParameter("ssid");
      ad.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[] { paramBundle.toString(), this.cUi, this.dow, this.qao, this.ssid });
      if (this.ssid == null) {
        this.ssid = "";
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ad.d("MicroMsg.ConnectedRouterActivateStateUi", paramBundle.toString());
      }
    }
    CH(1);
    ba.aiU().a(new a(this.cUi, this.dow, this.qao, this.appId, this.qjQ), 0);
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
      cmf();
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