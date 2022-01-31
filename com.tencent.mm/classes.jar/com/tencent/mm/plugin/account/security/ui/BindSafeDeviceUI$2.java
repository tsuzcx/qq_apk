package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.ui.MMWizardActivity;

final class BindSafeDeviceUI$2
  implements View.OnClickListener
{
  BindSafeDeviceUI$2(BindSafeDeviceUI paramBindSafeDeviceUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("is_bind_for_safe_device", true);
    paramView.setClass(this.fjZ, BindMContactUI.class);
    MMWizardActivity.C(this.fjZ, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI.2
 * JD-Core Version:    0.7.0.1
 */