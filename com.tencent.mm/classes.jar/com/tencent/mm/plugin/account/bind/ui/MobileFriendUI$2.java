package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;

final class MobileFriendUI$2
  implements View.OnClickListener
{
  MobileFriendUI$2(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.fes.mController.uMN, BindMContactIntroUI.class);
    paramView.putExtra("key_upload_scene", 6);
    MMWizardActivity.C(this.fes, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.2
 * JD-Core Version:    0.7.0.1
 */