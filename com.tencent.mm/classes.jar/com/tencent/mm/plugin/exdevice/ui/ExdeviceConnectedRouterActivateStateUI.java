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
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.d.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceConnectedRouterActivateStateUI
  extends MMActivity
{
  private String appId;
  private String cLR;
  private String dfF;
  private String oTy;
  private final int pcW;
  private ExdeviceConnectedRouterStateView pcX;
  private TextView pcY;
  private TextView pcZ;
  private b<a> pda;
  private String ssid;
  
  public ExdeviceConnectedRouterActivateStateUI()
  {
    AppMethodBeat.i(23989);
    this.pcW = 90000;
    this.pda = new b() {};
    AppMethodBeat.o(23989);
  }
  
  private void cas()
  {
    AppMethodBeat.i(23995);
    finish();
    Intent localIntent = new Intent();
    localIntent.putExtra("From_fail_notify", true);
    ad.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
    d.e(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    AppMethodBeat.o(23995);
  }
  
  protected final void Bg(int paramInt)
  {
    AppMethodBeat.i(23992);
    this.pcX.setOnClickListener(null);
    ad.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23992);
      return;
      this.pcX.setImageResource(2131689986);
      this.pcX.setState(3);
      this.pcX.pdd = 2;
      this.pcY.setText(2131758521);
      this.pcZ.setText(getString(2131758522, new Object[] { this.ssid }));
      AppMethodBeat.o(23992);
      return;
      this.pcX.setImageResource(2131689986);
      this.pcX.setState(3);
      this.pcX.pdd = 2;
      this.pcY.setText(2131758521);
      this.pcZ.setText(getString(2131758523));
      AppMethodBeat.o(23992);
      return;
      this.pcX.setImageResource(2131689986);
      this.pcX.setState(3);
      this.pcX.pdd = 2;
      this.pcY.setText(2131758521);
      this.pcZ.setText(getString(2131758525));
      AppMethodBeat.o(23992);
      return;
      this.pcX.setImageResource(2131689988);
      this.pcX.setState(2);
      this.pcY.setText(getString(2131758524, new Object[] { this.ssid }));
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
      this.pcX.setImageResource(2131689987);
      this.pcX.setState(1);
      this.pcY.setText(2131758520);
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
    this.pcX = ((ExdeviceConnectedRouterStateView)findViewById(2131299547));
    this.pcY = ((TextView)findViewById(2131299546));
    this.pcZ = ((TextView)findViewById(2131299548));
    try
    {
      paramBundle = Uri.parse(getIntent().getStringExtra("key_connected_router"));
      this.cLR = paramBundle.getQueryParameter("deviceid");
      this.dfF = paramBundle.getQueryParameter("devicetype");
      this.oTy = paramBundle.getQueryParameter("clientinfo");
      this.appId = paramBundle.getQueryParameter("appid");
      if ((bt.isNullOrNil(this.cLR)) || (bt.isNullOrNil(this.dfF)) || (bt.isNullOrNil(this.oTy)) || (bt.isNullOrNil(this.appId)))
      {
        ad.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[] { paramBundle.toString() });
        finish();
      }
      this.ssid = paramBundle.getQueryParameter("ssid");
      ad.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[] { paramBundle.toString(), this.cLR, this.dfF, this.oTy, this.ssid });
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
    Bg(1);
    az.aeS().a(new a(this.cLR, this.dfF, this.oTy, this.appId, this.pda), 0);
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
      cas();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI
 * JD-Core Version:    0.7.0.1
 */