package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.s;

@Deprecated
public class LoginSelectorUI
  extends MMActivity
  implements View.OnClickListener
{
  private TextView fnu;
  private View fnv;
  
  protected final int getLayoutId()
  {
    return q.g.select_login_reg;
  }
  
  protected final void initView()
  {
    Button localButton1 = (Button)findViewById(q.f.select_login_btn);
    Button localButton2 = (Button)findViewById(q.f.select_register_btn);
    this.fnu = ((TextView)findViewById(q.f.select_country));
    this.fnv = findViewById(q.f.select_country_ly);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    this.fnu.setText(x.g(this.mController.uMN, q.b.language_setting, q.j.app_lang_sys));
    this.fnv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("not_auth_setting", true);
        com.tencent.mm.plugin.account.a.a.eUR.p(paramAnonymousView, LoginSelectorUI.this.mController.uMN);
      }
    });
    if (e.uem)
    {
      com.tencent.mm.plugin.account.a.a.eUS.n(this);
      return;
    }
    com.tencent.mm.plugin.account.a.a.eUS.aJ(this);
  }
  
  public void onClick(View paramView)
  {
    if (q.f.select_login_btn == paramView.getId())
    {
      paramView = new Intent(this, MobileInputUI.class);
      paramView.putExtra("mobile_input_purpose", 1);
      startActivity(paramView);
    }
    while (q.f.select_register_btn != paramView.getId()) {
      return;
    }
    if (d.spd)
    {
      paramView = getString(q.j.create_forbiden_uri, new Object[] { "0x" + Integer.toHexString(d.spa), x.cqJ() });
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("needRedirect", false);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
      localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
      com.tencent.mm.plugin.account.a.a.eUR.j(localIntent, this);
      return;
    }
    paramView = new Intent(this, RegByMobileRegAIOUI.class);
    paramView.putExtra("login_type", 0);
    startActivity(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    g.DN();
    com.tencent.mm.kernel.a.Dg();
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Intent localIntent = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
      localIntent.addFlags(67108864);
      localIntent.putExtra("can_finish", true);
      startActivity(localIntent);
      finish();
      b.gK(this);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    g.DN();
    com.tencent.mm.kernel.a.Dg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSelectorUI
 * JD-Core Version:    0.7.0.1
 */