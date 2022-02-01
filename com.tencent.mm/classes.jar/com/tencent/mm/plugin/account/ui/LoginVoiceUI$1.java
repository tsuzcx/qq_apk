package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;

final class LoginVoiceUI$1
  implements View.OnClickListener
{
  LoginVoiceUI$1(LoginVoiceUI paramLoginVoiceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128250);
    h.wUl.f(11557, new Object[] { Integer.valueOf(2) });
    paramView = new Intent();
    paramView.putExtra("Kusername", this.iSR.iRS);
    paramView.putExtra("kscene_type", 1);
    d.b(this.iSR.getContext(), "voiceprint", ".ui.VoiceLoginUI", paramView, 1024);
    AppMethodBeat.o(128250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI.1
 * JD-Core Version:    0.7.0.1
 */