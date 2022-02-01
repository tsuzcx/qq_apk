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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.d.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceConnectedRouterActivateStateUI
  extends MMActivity
{
  private String appId;
  private String cVh;
  private String dpB;
  private String qgT;
  private final int qqr;
  private ExdeviceConnectedRouterStateView qqs;
  private TextView qqt;
  private TextView qqu;
  private b<a> qqv;
  private String ssid;
  
  public ExdeviceConnectedRouterActivateStateUI()
  {
    AppMethodBeat.i(23989);
    this.qqr = 90000;
    this.qqv = new b() {};
    AppMethodBeat.o(23989);
  }
  
  private void cnv()
  {
    AppMethodBeat.i(23995);
    finish();
    Intent localIntent = new Intent();
    localIntent.putExtra("From_fail_notify", true);
    ae.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
    d.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(23995);
  }
  
  protected final void CT(int paramInt)
  {
    AppMethodBeat.i(23992);
    this.qqs.setOnClickListener(null);
    ae.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23992);
      return;
      this.qqs.setImageResource(2131689986);
      this.qqs.setState(3);
      this.qqs.qqy = 2;
      this.qqt.setText(2131758521);
      this.qqu.setText(getString(2131758522, new Object[] { this.ssid }));
      AppMethodBeat.o(23992);
      return;
      this.qqs.setImageResource(2131689986);
      this.qqs.setState(3);
      this.qqs.qqy = 2;
      this.qqt.setText(2131758521);
      this.qqu.setText(getString(2131758523));
      AppMethodBeat.o(23992);
      return;
      this.qqs.setImageResource(2131689986);
      this.qqs.setState(3);
      this.qqs.qqy = 2;
      this.qqt.setText(2131758521);
      this.qqu.setText(getString(2131758525));
      AppMethodBeat.o(23992);
      return;
      this.qqs.setImageResource(2131689988);
      this.qqs.setState(2);
      this.qqt.setText(getString(2131758524, new Object[] { this.ssid }));
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
      this.qqs.setImageResource(2131689987);
      this.qqs.setState(1);
      this.qqt.setText(2131758520);
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
    ae.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
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
    this.qqs = ((ExdeviceConnectedRouterStateView)findViewById(2131299547));
    this.qqt = ((TextView)findViewById(2131299546));
    this.qqu = ((TextView)findViewById(2131299548));
    try
    {
      paramBundle = Uri.parse(getIntent().getStringExtra("key_connected_router"));
      this.cVh = paramBundle.getQueryParameter("deviceid");
      this.dpB = paramBundle.getQueryParameter("devicetype");
      this.qgT = paramBundle.getQueryParameter("clientinfo");
      this.appId = paramBundle.getQueryParameter("appid");
      if ((bu.isNullOrNil(this.cVh)) || (bu.isNullOrNil(this.dpB)) || (bu.isNullOrNil(this.qgT)) || (bu.isNullOrNil(this.appId)))
      {
        ae.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[] { paramBundle.toString() });
        finish();
      }
      this.ssid = paramBundle.getQueryParameter("ssid");
      ae.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[] { paramBundle.toString(), this.cVh, this.dpB, this.qgT, this.ssid });
      if (this.ssid == null) {
        this.ssid = "";
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ae.d("MicroMsg.ConnectedRouterActivateStateUi", paramBundle.toString());
      }
    }
    CT(1);
    bc.ajj().a(new a(this.cVh, this.dpB, this.qgT, this.appId, this.qqv), 0);
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
      cnv();
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