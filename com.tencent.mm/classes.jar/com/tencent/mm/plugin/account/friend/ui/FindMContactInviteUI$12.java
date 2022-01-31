package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class FindMContactInviteUI$12
  implements DialogInterface.OnClickListener
{
  FindMContactInviteUI$12(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (FindMContactInviteUI.j(this.fhx) == 1)
    {
      paramDialogInterface = new StringBuilder();
      g.DN();
      paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_500_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R300_500_QQ") + ",3");
    }
    for (;;)
    {
      g.Dk().a(432, FindMContactInviteUI.a(this.fhx, new FindMContactInviteUI.12.1(this)));
      paramDialogInterface = this.fhx;
      AppCompatActivity localAppCompatActivity = this.fhx.mController.uMN;
      this.fhx.getString(a.h.app_tip);
      FindMContactInviteUI.a(paramDialogInterface, h.b(localAppCompatActivity, this.fhx.getString(a.h.find_mcontact_invite_friend_processing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      }));
      FindMContactInviteUI.b(this.fhx).pL(FindMContactInviteUI.m(this.fhx));
      return;
      paramDialogInterface = new StringBuilder();
      g.DN();
      paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_500_phone,");
      g.DN();
      com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R300_500_phone") + ",3");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.12
 * JD-Core Version:    0.7.0.1
 */