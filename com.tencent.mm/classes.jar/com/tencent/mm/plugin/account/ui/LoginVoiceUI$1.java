package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;

final class LoginVoiceUI$1
  implements View.OnClickListener
{
  LoginVoiceUI$1(LoginVoiceUI paramLoginVoiceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125073);
    h.qsU.e(11557, new Object[] { Integer.valueOf(2) });
    paramView = new Intent();
    paramView.putExtra("Kusername", this.gFi.gEc);
    paramView.putExtra("kscene_type", 1);
    d.b(this.gFi.getContext(), "voiceprint", ".ui.VoiceLoginUI", paramView, 1024);
    AppMethodBeat.o(125073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI.1
 * JD-Core Version:    0.7.0.1
 */