package com.tencent.mm.plugin.account.security.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.account.security.a.a;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI
  extends MMWizardActivity
{
  protected final int getLayoutId()
  {
    return a.b.security_account_normal;
  }
  
  protected final void initView()
  {
    setMMTitle(a.d.safe_device_account_protect);
    setBackBtn(new BindSafeDeviceUI.1(this));
    ((ImageView)findViewById(a.a.security_account_state_icon)).setImageResource(a.c.accounts_saftphone_icon);
    ((TextView)findViewById(a.a.security_account_tips)).setText(a.d.safe_device_bind__hit);
    ((TextView)findViewById(a.a.tip_title)).setText(a.d.safe_device_bind_mobile);
    findViewById(a.a.tip_title).setOnClickListener(new BindSafeDeviceUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI
 * JD-Core Version:    0.7.0.1
 */