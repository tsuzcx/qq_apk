package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LoginVoiceUI$1
  implements View.OnClickListener
{
  LoginVoiceUI$1(LoginVoiceUI paramLoginVoiceUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11557, new Object[] { Integer.valueOf(2) });
    paramView = new Intent();
    paramView.putExtra("Kusername", this.fnO.fmI);
    paramView.putExtra("kscene_type", 1);
    d.b(this.fnO.mController.uMN, "voiceprint", ".ui.VoiceLoginUI", paramView, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI.1
 * JD-Core Version:    0.7.0.1
 */