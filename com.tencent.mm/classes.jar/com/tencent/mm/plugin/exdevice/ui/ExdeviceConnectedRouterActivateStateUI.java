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
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.d.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceConnectedRouterActivateStateUI
  extends MMActivity
{
  private String appId;
  private String cIZ;
  private String dda;
  private final int pGh;
  private ExdeviceConnectedRouterStateView pGi;
  private TextView pGj;
  private TextView pGk;
  private b<a> pGl;
  private String pwJ;
  private String ssid;
  
  public ExdeviceConnectedRouterActivateStateUI()
  {
    AppMethodBeat.i(23989);
    this.pGh = 90000;
    this.pGl = new b() {};
    AppMethodBeat.o(23989);
  }
  
  private void chB()
  {
    AppMethodBeat.i(23995);
    finish();
    Intent localIntent = new Intent();
    localIntent.putExtra("From_fail_notify", true);
    ac.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
    d.e(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(23995);
  }
  
  protected final void BY(int paramInt)
  {
    AppMethodBeat.i(23992);
    this.pGi.setOnClickListener(null);
    ac.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23992);
      return;
      this.pGi.setImageResource(2131689986);
      this.pGi.setState(3);
      this.pGi.pGo = 2;
      this.pGj.setText(2131758521);
      this.pGk.setText(getString(2131758522, new Object[] { this.ssid }));
      AppMethodBeat.o(23992);
      return;
      this.pGi.setImageResource(2131689986);
      this.pGi.setState(3);
      this.pGi.pGo = 2;
      this.pGj.setText(2131758521);
      this.pGk.setText(getString(2131758523));
      AppMethodBeat.o(23992);
      return;
      this.pGi.setImageResource(2131689986);
      this.pGi.setState(3);
      this.pGi.pGo = 2;
      this.pGj.setText(2131758521);
      this.pGk.setText(getString(2131758525));
      AppMethodBeat.o(23992);
      return;
      this.pGi.setImageResource(2131689988);
      this.pGi.setState(2);
      this.pGj.setText(getString(2131758524, new Object[] { this.ssid }));
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
      this.pGi.setImageResource(2131689987);
      this.pGi.setState(1);
      this.pGj.setText(2131758520);
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
    ac.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
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
    this.pGi = ((ExdeviceConnectedRouterStateView)findViewById(2131299547));
    this.pGj = ((TextView)findViewById(2131299546));
    this.pGk = ((TextView)findViewById(2131299548));
    try
    {
      paramBundle = Uri.parse(getIntent().getStringExtra("key_connected_router"));
      this.cIZ = paramBundle.getQueryParameter("deviceid");
      this.dda = paramBundle.getQueryParameter("devicetype");
      this.pwJ = paramBundle.getQueryParameter("clientinfo");
      this.appId = paramBundle.getQueryParameter("appid");
      if ((bs.isNullOrNil(this.cIZ)) || (bs.isNullOrNil(this.dda)) || (bs.isNullOrNil(this.pwJ)) || (bs.isNullOrNil(this.appId)))
      {
        ac.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[] { paramBundle.toString() });
        finish();
      }
      this.ssid = paramBundle.getQueryParameter("ssid");
      ac.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[] { paramBundle.toString(), this.cIZ, this.dda, this.pwJ, this.ssid });
      if (this.ssid == null) {
        this.ssid = "";
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ac.d("MicroMsg.ConnectedRouterActivateStateUi", paramBundle.toString());
      }
    }
    BY(1);
    az.agi().a(new a(this.cIZ, this.dda, this.pwJ, this.appId, this.pGl), 0);
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
      chB();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI
 * JD-Core Version:    0.7.0.1
 */