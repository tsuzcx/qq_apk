package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;

@Deprecated
public class LoginSelectorUI
  extends MMActivity
  implements View.OnClickListener
{
  private TextView gEN;
  private View gEO;
  
  public int getLayoutId()
  {
    return 2130970654;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125010);
    Button localButton1 = (Button)findViewById(2131827535);
    Button localButton2 = (Button)findViewById(2131827534);
    this.gEN = ((TextView)findViewById(2131827537));
    this.gEO = findViewById(2131827536);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    this.gEN.setText(aa.gQ(getContext()));
    this.gEO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125007);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("not_auth_setting", true);
        com.tencent.mm.plugin.account.a.a.gmO.o(paramAnonymousView, LoginSelectorUI.this.getContext());
        AppMethodBeat.o(125007);
      }
    });
    if (com.tencent.mm.sdk.platformtools.g.ymN)
    {
      com.tencent.mm.plugin.account.a.a.gmP.o(this);
      AppMethodBeat.o(125010);
      return;
    }
    com.tencent.mm.plugin.account.a.a.gmP.bh(this);
    AppMethodBeat.o(125010);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(125012);
    if (2131827535 == paramView.getId())
    {
      paramView = new Intent(this, MobileInputUI.class);
      paramView.putExtra("mobile_input_purpose", 1);
      startActivity(paramView);
      AppMethodBeat.o(125012);
      return;
    }
    if (2131827534 == paramView.getId())
    {
      if (d.whK)
      {
        paramView = getString(2131298884, new Object[] { "0x" + Integer.toHexString(d.whH), aa.dsG() });
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramView);
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("needRedirect", false);
        localIntent.putExtra("neverGetA8Key", true);
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
        com.tencent.mm.plugin.account.a.a.gmO.i(localIntent, this);
        AppMethodBeat.o(125012);
        return;
      }
      startActivity(new Intent(this, RegByMobileRegAIOUI.class));
    }
    AppMethodBeat.o(125012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125008);
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.kernel.a.QY();
    initView();
    AppMethodBeat.o(125008);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125011);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Intent localIntent = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
      localIntent.addFlags(67108864);
      localIntent.putExtra("can_finish", true);
      startActivity(localIntent);
      finish();
      b.ig(this);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125011);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125009);
    super.onResume();
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.kernel.a.QY();
    AppMethodBeat.o(125009);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSelectorUI
 * JD-Core Version:    0.7.0.1
 */