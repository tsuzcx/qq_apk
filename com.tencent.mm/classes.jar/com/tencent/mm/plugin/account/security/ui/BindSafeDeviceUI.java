package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.security.a.a;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI
  extends MMWizardActivity
{
  public int getLayoutId()
  {
    return a.b.security_account_normal;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125543);
    setMMTitle(a.d.safe_device_account_protect);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125540);
        BindSafeDeviceUI.this.finish();
        AppMethodBeat.o(125540);
        return true;
      }
    });
    ((ImageView)findViewById(a.a.security_account_state_icon)).setImageResource(a.c.accounts_saftphone_icon);
    ((TextView)findViewById(a.a.security_account_tips)).setText(a.d.safe_device_bind__hit);
    ((TextView)findViewById(a.a.tip_title)).setText(a.d.safe_device_bind_mobile);
    findViewById(a.a.tip_title).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125541);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/account/security/ui/BindSafeDeviceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("bind_scene", 1);
        paramAnonymousView.setClass(BindSafeDeviceUI.this, BindMContactUI.class);
        MMWizardActivity.aH(BindSafeDeviceUI.this, paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/account/security/ui/BindSafeDeviceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125541);
      }
    });
    AppMethodBeat.o(125543);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125542);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(125542);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI
 * JD-Core Version:    0.7.0.1
 */