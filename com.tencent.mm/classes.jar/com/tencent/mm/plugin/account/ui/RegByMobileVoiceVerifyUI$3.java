package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.ui.base.h;

final class RegByMobileVoiceVerifyUI$3
  implements View.OnClickListener
{
  RegByMobileVoiceVerifyUI$3(RegByMobileVoiceVerifyUI paramRegByMobileVoiceVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    if ((RegByMobileVoiceVerifyUI.b(this.frt) == 0) || (RegByMobileVoiceVerifyUI.b(this.frt) == 2) || (RegByMobileVoiceVerifyUI.b(this.frt) == 3))
    {
      RegByMobileVoiceVerifyUI.a(this.frt, new a(RegByMobileVoiceVerifyUI.c(this.frt), RegByMobileVoiceVerifyUI.d(this.frt), "", 1, RegByMobileVoiceVerifyUI.a(this.frt)));
      g.Dk().a(RegByMobileVoiceVerifyUI.e(this.frt), 0);
      h.a(this.frt, q.j.bind_mcontact_voice_verify_select_tips, q.j.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          RegByMobileVoiceVerifyUI.3.this.frt.finish();
        }
      });
    }
    while ((RegByMobileVoiceVerifyUI.b(this.frt) != 4) && (RegByMobileVoiceVerifyUI.b(this.frt) != 1)) {
      return;
    }
    RegByMobileVoiceVerifyUI.a(this.frt, new x(RegByMobileVoiceVerifyUI.c(this.frt), 1, "", 1, RegByMobileVoiceVerifyUI.a(this.frt)));
    g.Dk().a(RegByMobileVoiceVerifyUI.f(this.frt), 0);
    h.a(this.frt, q.j.bind_mcontact_voice_verify_select_tips, q.j.app_tip, new RegByMobileVoiceVerifyUI.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI.3
 * JD-Core Version:    0.7.0.1
 */