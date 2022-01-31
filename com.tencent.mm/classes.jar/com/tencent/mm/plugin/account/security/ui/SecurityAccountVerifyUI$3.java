package com.tencent.mm.plugin.account.security.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.h;

final class SecurityAccountVerifyUI$3
  implements View.OnClickListener
{
  SecurityAccountVerifyUI$3(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69918);
    ab.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
    SecurityAccountVerifyUI.b(this.gCb).setVisibility(8);
    SecurityAccountVerifyUI.a(this.gCb).setTag(Integer.valueOf(60));
    SecurityAccountVerifyUI.c(this.gCb).stopTimer();
    SecurityAccountVerifyUI.c(this.gCb).ag(1000L, 1000L);
    paramView = new a(SecurityAccountVerifyUI.d(this.gCb), 10, "", "", SecurityAccountVerifyUI.e(this.gCb));
    g.Rc().a(paramView, 0);
    SecurityAccountVerifyUI localSecurityAccountVerifyUI = this.gCb;
    AppCompatActivity localAppCompatActivity = this.gCb.getContext();
    this.gCb.getString(2131297087);
    SecurityAccountVerifyUI.a(localSecurityAccountVerifyUI, h.b(localAppCompatActivity, this.gCb.getString(2131302860), true, new SecurityAccountVerifyUI.3.1(this, paramView)));
    AppMethodBeat.o(69918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.3
 * JD-Core Version:    0.7.0.1
 */