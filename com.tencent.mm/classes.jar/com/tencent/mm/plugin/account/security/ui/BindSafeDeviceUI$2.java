package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.ui.MMWizardActivity;

final class BindSafeDeviceUI$2
  implements View.OnClickListener
{
  BindSafeDeviceUI$2(BindSafeDeviceUI paramBindSafeDeviceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69859);
    paramView = new Intent();
    paramView.putExtra("bind_scene", 1);
    paramView.setClass(this.gBq, BindMContactUI.class);
    MMWizardActivity.J(this.gBq, paramView);
    AppMethodBeat.o(69859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI.2
 * JD-Core Version:    0.7.0.1
 */